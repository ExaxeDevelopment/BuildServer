import hudson.Util;

def appRootPath = "C:\\Uploads\\BuildApp\\Exaxe.SolutionManager.BuildApp.exe";

def tfsUsername = "";
def tfsPassword = "";

def operation = "";
def failureMessage = "";
def failureMessageSuffix = " was not successful!";

def configFile = "#";
def deployConfigurationAction = "#";

def duration = "";

try{
    node{

        withCredentials([[$class: "UsernamePasswordMultiBinding", credentialsId: "166ca05f-1074-4a9c-9529-2ab17ba62480", usernameVariable: "USERNAME", passwordVariable: "PASSWORD"]]) {
            tfsUsername = "${env.USERNAME}"
            tfsPassword = "${env.PASSWORD}"
        }

		// INPUT PARAMS
		configFile = SelectedConfigFile;
		deployConfigurationAction = SelectedDeployConfiguration; 
		
		// PREPARE CLASS OBJECTS
		def actionStringClass = new actionString();
	    def deployStepsClass = new deployCommonBuildSteps();
	    
	    // START EXECUTION
        def deployCommonSteps = deployStepsClass.getDeployCommonBuildSteps(deployConfigurationAction)
		
		for(Map<String,String>step : deployCommonSteps){
			if(step.get("Project") == step.get("Operation")){
				stage(step.get("Operation")){
					def actionString = actionStringClass.createActionString("${appRootPath}", "${configFile}", step.get("Project"), step.get("Operation"), "${tfsUsername}", "${tfsPassword}")

					def result = bat(returnStatus: true, script: "${actionString}");
					if(result != 0){
						failureMessage = "${operation} ${failureMessageSuffix}";
						echo failureMessage;
						error(failureMessage);
					}
				}
			} 
			else{
				def stageName = "${step.get("Project")} - ${step.get("Operation")}"
				stage("${stageName}"){
					def actionString = actionStringClass.createActionString("${appRootPath}", "${configFile}", step.get("Project"), step.get("Operation"), "${tfsUsername}", "${tfsPassword}")
				
					def result = bat(returnStatus: true, script: "${actionString}");
					if(result != 0){
						failureMessage = "${operation} ${failureMessageSuffix}";
						echo failureMessage;
						error(failureMessage);
					}
				}
			}
		}	
		
        currentBuild.result = "SUCCESS";

        duration = "Build duration: ${Util.getTimeSpanString(System.currentTimeMillis() - currentBuild.startTimeInMillis)}";
        
        try{
            stage("Success Notification"){
                echo duration;
                
                mail to: "${DEV_TEAM_EMAIL},${QA_TEAM_EMAIL},${BA_TEAM_EMAIL},${PM_TEAM_EMAIL}", 
                subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
                body: "${env.BUILD_URL} \r\n ${duration}" 
            }
        }
        catch(err){
            echo "Notification stage failed, but build was successful.";
            echo "Error: ${err}"
        }
        
    } //// end node 
}
catch(err){
    echo "Deployment Failed...";
    
    currentBuild.result = "FAILURE";
    
    node{
        stage("Error Notification"){
            echo duration;

            mail to: "${DEV_TEAM_EMAIL}", 
            subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
            body: "The build failed on stage: ${operation} \r\nError: ${err} \r\nURL: ${env.BUILD_URL}"      
        }
    }    
}