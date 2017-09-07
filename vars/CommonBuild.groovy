import hudson.Util;

def undoChanges = false;
def appRootPath = "C:\\Uploads\\BuildApp\\Exaxe.SolutionManager.BuildApp.exe";
def tfsUsername = "";
def tfsPassword = "";
def operation = "";
def undoOperation = "";
def failureMessage = "";
def failureMessageSuffix = " was not successful!";
def duration = "";

def buildTypeAction = "#";
def configFile = "#";
def projectName = "#";

try{

    node{
        withCredentials([[$class: "UsernamePasswordMultiBinding", credentialsId: "166ca05f-1074-4a9c-9529-2ab17ba62480", usernameVariable: "USERNAME", passwordVariable: "PASSWORD"]]) {
            tfsUsername = "${env.USERNAME}"
            tfsPassword = "${env.PASSWORD}"
        }
        
        undoChanges = true;	//// From here, it will need to undo the changes if any error/exception is raised
		
		// INPUT PARAMS
		buildTypeAction = BuildType; 
		configFile = SelectedConfigFile;
		projectName = SelectedProjectName;
	
		// PREPARE CLASS OBJECTS
		def buildStepsClass = new buildStepsByBuildType();
		def actionStringClass = new actionString();
		
		// EXECUTE
		def buildSteps = buildStepsClass.createBuildStepsByBuildType("${buildTypeAction}")
    
		for (String buildStep : buildSteps) {
			if(buildStep == "PublishNuGetPackages"){
				undoChanges = false;	//// No need to worry about changes
			}
			
			stage("${buildStep}"){
				def actionString = actionStringClass.createActionString("${appRootPath}", "${configFile}", "${projectName}", buildStep, "${tfsUsername}", "${tfsPassword}")
				
				if(buildStep == "CheckNuGetFeed"){
					timeout(time: 5, unit: 'MINUTES'){
						def result = bat(returnStatus: true, script: "${actionString}");
						if(result != 0){
							failureMessage = "${operation} ${failureMessageSuffix}";
							echo failureMessage;
							error(failureMessage);
						}
					}
				} else {
					def result = bat(returnStatus: true, script: "${actionString}");
					if(result != 0){
						failureMessage = "${operation} ${failureMessageSuffix}";
						echo failureMessage;
						error(failureMessage);
					}
				}
			}

			if(buildStep == buildSteps.last()){
				undoChanges = false;
			}
		}		
           
        currentBuild.result = "SUCCESS";
		
        duration = "Build duration: ${Util.getTimeSpanString(System.currentTimeMillis() - currentBuild.startTimeInMillis)}";
		
        try{
            stage("Success Notification"){
                echo duration;
				
                mail to: "${DEV_TEAM_EMAIL}", 
                subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
                body: "${env.BUILD_URL} \r\n ${duration} \r\n Build Type: ${buildTypeAction}" 
            }
        }
        catch(err){
            echo "Notification stage failed, but build was successful.";
            echo "Error: ${err}"
        }

    } //// end node
}
catch(err){
    echo "Build Failed...";
	
    if(undoChanges){
        echo "Undoing Changes...";
		
        node{
            undoOperation = "UndoCheckOutFiles"
            stage(undoOperation){
                def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${undoOperation} ${tfsUsername} ${tfsPassword}");
                if(result != 0){
                    failureMessage = "${undoOperation} ${failureMessageSuffix}";
                    echo failureMessage;
                }
            }
        }
    }
	
    currentBuild.result = "FAILURE";
	
    node{
        stage("Error Notification"){
            mail to: "${DEV_TEAM_EMAIL}", 
            subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
            body: "The build failed on stage: ${operation} \r\nError: ${err} \r\nURL: ${env.BUILD_URL}"      
        }
    }	
}
