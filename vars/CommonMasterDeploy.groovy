import hudson.Util;

def jobBuild = "";

def duration = "";

try{
	
    node{
		def masterDeploymentStepsClass = new masterDeploymentSteps();

		//// Retrieve all possible deployment steps
		def masterDeploySteps = masterDeploymentStepsClass.getMasterDeploymentSteps();

		//// Each array is going to be triggered in parallel
		for (ArrayList<Map<String,String>> deploySteps : masterDeploySteps) {
			def parallelDeployJobs = [:]

			//// Get the actions for the Operation/Project 
			for(Map<String,String> deployStep : deploySteps){
                def _deployStep = deployStep;
                def operation = deployStep.get("Operation");
                def project = deployStep.get("Project");
                
                parallelDeployJobs[_deployStep]  = {
					stage("${_deployStep}"){
						//// Setup action
						echo operation
						echo project
					}
				}
            }

			// Schedule Actions in parallel
			parallel parallelDeployJobs;
		}

		currentBuild.result = "SUCCESS";
		duration = "Build duration: ${Util.getTimeSpanString(System.currentTimeMillis() - currentBuild.startTimeInMillis)}";

		try{
			stage("Success Notification"){
                echo duration;
				
                /*mail to: "${DEV_TEAM_EMAIL}", 
                subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
                body: "${env.BUILD_URL} \r\n ${duration}"*/
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
            /*mail to: "${DEV_TEAM_EMAIL}", 
            subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
            body: "The build failed on stage: ${jobBuild} \r\nError: ${err} \r\nURL: ${env.BUILD_URL}"*/ 
        }
    }	
}