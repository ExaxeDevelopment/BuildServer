import hudson.Util;

def jobBuild = "";

def duration = "";

try{
	
    node{
		// INPUT PARAMS
		def masterBuildName = "#";
		masterBuildName = SelectedMasterBuild; 
		def action = "#";
		action = BuildFromProject; 

		def masterBuildStepsClass = new masterBuildStepsByProject();

		List<String> parallelBuildSteps = new ArrayList<String>();
		List<String> sequentialBuildSteps = new ArrayList<String>();

		//// First try to get using the parallel. It may also contain the sequential.
		def allBuildSteps = masterBuildStepsClass.getMasterBuildParallelStepsByProject(masterBuildName, action);

		if(allBuildSteps.size() > 0){
			echo "We have parallel jobs to execute!";
			parallelBuildSteps = allBuildSteps[0];
			sequentialBuildSteps = allBuildSteps[1];
		}
		else{
			// GET SEQUENTIAL MASTER BUILD STEPS
			echo "No parallel jobs to execute!";
			echo "Get the sequential jobs to execute!";
			sequentialBuildSteps = masterBuildStepsClass.getMasterBuildStepsByProject(masterBuildName, action);
		}

		//// #####################################
		//// ######## PARALLEL PROCESSING ########
		//// #####################################
		if(parallelBuildSteps.size() > 0){
			def parallelBuildJobs = [:] 
			for (String buildStep : parallelBuildSteps) {
				def _buildStep = buildStep; // This is necessary to prevent modified closure, when it's executing in parallel
				jobBuild += "${_buildStep}, "; //// So it can be included in the failure notification

				parallelBuildJobs[_buildStep]  = {
					stage("${_buildStep}"){
						build _buildStep
					}
				}
			}

			// SCHEDULE BUILDS IN PARALLEL
			parallel parallelBuildJobs;
		}
    
		//// #######################################
		//// ######## SEQUENTIAL PROCESSING ########
		//// #######################################
		// STEPS EXECUTION: SEQUENTIAL
		for (String buildStep : sequentialBuildSteps) {
			jobBuild = buildStep; //// So it can be included in the failure notification

			stage("${buildStep}")
			{
				build buildStep;
			}
		}

		currentBuild.result = "SUCCESS";
		duration = "Build duration: ${Util.getTimeSpanString(System.currentTimeMillis() - currentBuild.startTimeInMillis)}";

		try{
			stage("Success Notification"){
                echo duration;
				
                mail to: "${DEV_TEAM_EMAIL}", 
                subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
                body: "${env.BUILD_URL} \r\n ${duration}" 
            }
        }
        catch(err){
            echo "Notification stage failed, but build was successful.";
            echo "Error: ${err}"
        }

	} // END NODE
}
catch(err){
    echo "Build Failed...";
	
    currentBuild.result = "FAILURE";
	
    node{
        stage("Error Notification"){
            mail to: "${DEV_TEAM_EMAIL}", 
            subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
            body: "The build failed on stage: ${jobBuild} \r\nError: ${err} \r\nURL: ${env.BUILD_URL}"      
        }
    }	
}