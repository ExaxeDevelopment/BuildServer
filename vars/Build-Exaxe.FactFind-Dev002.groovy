import hudson.Util;

def undoChanges = false;
def appRootPath = "C:\\Uploads\\BuildApp\\Exaxe.SolutionManager.BuildApp.exe";
def configFile = "config/build/server/epos/Build-Exaxe.FactFind-Dev002.json";
def sqlConfigFile = "config/build/DatabaseScriptsConfiguration.json";
def projectName = "Exaxe.FactFind";
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

        operation = "GetAllCodeLatestVersion"; //// Because we need all DB scripts
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} 'N/A' ${operation} ${tfsUsername} ${tfsPassword}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

        operation = "GetCodeLatestVersion";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation} ${tfsUsername} ${tfsPassword}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

        operation = "ClearDatabases";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }		

        operation = "InstallAllDatabases";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation}");
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
        operation = "PublishNuGetPackages";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }
        
        operation = "CheckNuGetFeed";
        stage(operation){
            timeout(time: 5, unit: 'MINUTES'){
                def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation}");
                if(result != 0){
                    failureMessage = "${operation} ${failureMessageSuffix}";
                    echo failureMessage;
                    error(failureMessage);
                }
            }
        }
		
        currentBuild.result = "SUCCESS";

        duration = "Build duration: ${Util.getTimeSpanString(System.currentTimeMillis() - currentBuild.startTimeInMillis)}";
		
		try{
            operation = "DistributeSQLScripts";
            stage(operation){
                def result = bat(returnStatus: true, script: "${appRootPath} ${sqlConfigFile} ${projectName} ${operation}");
                if(result != 0){
                    failureMessage = "${operation} ${failureMessageSuffix}";
                    echo failureMessage;
                    error(failureMessage);
                }
            }
        }
        catch(err){
            echo "Operation: ${operation}, failed.";
            echo "Error: ${err}"
        }
		
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