import hudson.Util;

def undoChanges = false;
def appRootPath = "C:\\Uploads\\BuildApp\\Exaxe.SolutionManager.BuildApp.exe";
def configFile = "config/build/server/base/Build-SystemConfigurationUI-Dev001.json";
def projectName = "SystemConfigurationUI";
def tfsUsername = "";
def tfsPassword = "";
def operation = "";
def undoOperation = "";
def failureMessage = "";
def failureMessageSuffix = " was not successful!";

def duration = "";

try{

    node{

        withCredentials([[$class: "UsernamePasswordMultiBinding", credentialsId: "166ca05f-1074-4a9c-9529-2ab17ba62480", usernameVariable: "USERNAME", passwordVariable: "PASSWORD"]]) {
            tfsUsername = "${env.USERNAME}"
            tfsPassword = "${env.PASSWORD}"
        }
        
        undoChanges = true;	//// From here, it will need to undo the changes if any error/exception is raised

        operation = "GetCodeLatestVersion";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation} ${tfsUsername} ${tfsPassword}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }
	
        operation = "CheckOutFiles";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation} ${tfsUsername} ${tfsPassword}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

        operation = "UpdateAssemblyVersion";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

        operation = "RestoreNuGetPackages";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

        operation = "UpdateNuGetPackages";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }
        
        operation = "BuildSolution";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }
 
        operation = "PerformUnitTests";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

        operation = "CheckInFiles";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation} ${tfsUsername} ${tfsPassword}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

        undoChanges = false;	//// No need to worry about changes
		
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