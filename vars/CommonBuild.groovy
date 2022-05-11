import hudson.Util;

def undoChanges = false;
def appRootPath = "C:\\Uploads\\BuildApp\\Exaxe.SolutionManager.BuildApp.exe";

def operation = "";
def undoOperation = "";
def failureMessage = "";
def failureMessageSuffix = " was not successful!";
def duration = "";

def buildTypeAction = "#";
def configFile = "#";
def projectName = "#";

def css = "<style>body{font-size: 60px}.good{background-color:#7FD400}.bad{background-color:#F15D22}.banner{width: 100%; min-height: 20px}</style>";

def embeddedImage = "<img src='data:image/png;base64,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' />";

try{

    node{
        
        undoChanges = true;	//// From here, it will need to undo the changes if any error/exception is raised
		
		// INPUT PARAMS
		buildTypeAction = BuildType; 
		configFile = SelectedConfigFile;
		projectName = SelectedProjectName;
	
		// PREPARE CLASS OBJECTS
		def buildStepsClass = new buildStepsByBuildType();
		def actionStringClass = new actionString();
		
		// EXECUTE
		echo "Getting build steps..."
		def buildSteps = buildStepsClass.createBuildStepsByBuildType("${buildTypeAction}")
    
		echo "Sarting to execute the steps..."
		for (String buildStep : buildSteps) {
			operation = buildStep;

			if(buildStep == "PublishNuGetPackages" || buildStep == "UpdateQualityGates" || buildStep == "DataScriptsReconciliation" || buildStep == "ShrinkDatabaseLogs" || buildStep == "CheckExtendedProperties"){
				undoChanges = false;	//// No need to worry about changes
			}

			def timeOut = getTimeout(buildStep);
			
			stage("${buildStep}"){
				def actionString = actionStringClass.createActionString("${appRootPath}", "${configFile}", "${projectName}", buildStep)

				timeout(time: timeOut, unit: 'MINUTES'){
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
                body: "<html><body>${css}<div class='good banner'>&nbsp;</div><a href='${env.BUILD_URL}'>${JOB_NAME} ${currentBuild.displayName} / ${currentBuild.result}</a><br/> ${duration} <br/> Build Type: ${buildTypeAction}<div>${embeddedImage}</div></body></html>",
				mimeType: 'text/html'
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
                def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${undoOperation}");
                if(result != 0){
                    failureMessage = "${undoOperation} ${failureMessageSuffix}";
                    echo failureMessage;
                }
            }
		}
    }
	
	if(operation == "CanContinueBuild"){
		//// This operation checks if the build can continue, based on changes in the solution or new packages. 
		currentBuild.result = "SUCCESS";
	}
	else{
		currentBuild.result = "FAILURE";
	
		node{
			stage("Error Notification"){
				mail to: "${DEV_TEAM_EMAIL}", 
				subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
				body: "<html><body>${css}<div class='bad banner'>&nbsp;</div>The build failed on stage: ${operation} <br/>Error: ${err} <br/><a href='${env.BUILD_URL}'>${JOB_NAME} ${currentBuild.displayName} / ${currentBuild.result}</a><div>${embeddedImage}</div></body></html>",
				mimeType: 'text/html'      
			}
		}
	}

}

//// Gets the time-out for the build step
def getTimeout(buildStep){

	def timeOut = 300;

	if(buildStep == "CheckNuGetFeed"){
		timeOut = 5;
	}

	timeOut;
}
