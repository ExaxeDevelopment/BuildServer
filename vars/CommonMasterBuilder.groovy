import hudson.Util;

def jobBuild = "";

def duration = "";

try{
	
    node{
		// INPUT PARAMS
		def masterBuildName = SelectedMasterBuild; 
		def buildFrom = BuildFromProject; 

		def masterBuildStepsClass = new masterBuildSteps();

		//// #####################################
		//// ######## PARALLEL PROCESSING ########
		//// #####################################
		def parallelBuildSteps = masterBuildStepsClass.getMasterBuildParallelSteps(masterBuildName);

		if(parallelBuildSteps != null && parallelBuildSteps.size() > 0){
			def parallelBuildJobs = [:] 
			for (String buildStep : parallelBuildSteps) {
				def _buildStep = buildStep; // This is necessary to prevent modified closure, when it's executing in parallel
				jobBuild += "${_buildStep}, "; //// So it can be included in the failure notification

				parallelBuildJobs[_buildStep]  = {
					stage("${_buildStep}"){
						echo "Building: ${_buildStep}";
						build _buildStep
					}
				}
			}

			// SCHEDULE BUILDS IN PARALLEL
			parallel parallelBuildJobs;
		}
		else{
			echo "No PARALLEL Steps!"
		}

		//// #######################################
		//// ######## SEQUENTIAL PROCESSING ########
		//// #######################################
		def buildSteps = masterBuildStepsClass.getMasterBuildSteps(masterBuildName, buildFrom);
    
		if(buildSteps != null && buildSteps.size() > 0){
			for (String buildStep : buildSteps) {
				jobBuild = buildStep; //// So it can be included in the failure notification

				stage("${buildStep}")
				{
					echo "Building: ${buildStep}";
					build buildStep;
				}
			}
		}
		else{
			echo "No SEQUENTIAL Steps!"
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