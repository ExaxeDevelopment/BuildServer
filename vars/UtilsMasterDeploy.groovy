import hudson.Util;

def appRootPath = "C:\\Uploads\\BuildApp\\Exaxe.SolutionManager.BuildApp.exe";

def failureMessage = "";
def failureMessageSuffix = " was not successful!";
def duration = "";

def configFile = "#";
def projectsOperations = "#";

try{
	
    node{
		// INPUT PARAMS
		configFile = SelectedConfigFile;
		projectsOperations = ProjectsOperations;

		echo projectsOperations;

		def actionStringClass = new actionString();

		//// Retrieve all possible deployment steps
		def masterDeploymentStepsClass = new masterDeploymentSteps();
		def masterDeploySteps = masterDeploymentStepsClass.getMasterUtilsDeploymentSteps();

		//// Each array is going to be triggered in parallel
		for (ArrayList<Map<String,String>> deploySteps : masterDeploySteps) {
			def parallelDeployJobs = [:]

			//// Get the actions for the Operation/Project 
			for(Map<String,String> deployStep : deploySteps){
                def _deployStep = deployStep;
                def operation = deployStep.get("Operation");
                def project = deployStep.get("Project");
                
                parallelDeployJobs[_deployStep] = {
					stage("${operation} - ${project}"){
						//// Add action to be executed in parallel
						def actionString = actionStringClass.createActionString(appRootPath, configFile, project, operation);
						echo actionString;
						def result = bat(returnStatus: true, script: "${actionString}");
						if(result != 0){
							failureMessage = "${_deployStep} ${failureMessageSuffix}";
							echo failureMessage;
							error(failureMessage);
						}
					}
				}
            }

			// Schedule actions in parallel
			parallel parallelDeployJobs;
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
            body: "The deployment failed \r\nError: ${err} \r\nURL: ${env.BUILD_URL}"
        }
    }	
}