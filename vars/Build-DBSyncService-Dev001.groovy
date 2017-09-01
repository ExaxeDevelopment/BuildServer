import hudson.Util;

def undoChanges = false;
def appRootPath = "C:\\Uploads\\BuildApp\\Exaxe.SolutionManager.BuildApp.exe";
def configFile = "config/build/server/syncservice/Build-DatabaseSyncService.json";
def sqlConfigFile = "config/build/DatabaseScriptsConfiguration.json";
def projectName = "DatabaseSyncService";
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
        
        undoChanges = true; //// From here, it will need to undo the changes if any error/exception is raised

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

/*
        operation = "ClearDatabases";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }             
        */
        
        operation = "CheckOutFiles";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation} ${tfsUsername} ${tfsPassword}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

/*
        operation = "UpdateAssemblyVersion";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }
*/
        operation = "RestoreNuGetPackages";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

/*
        operation = "UpdateNuGetPackages";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }
        */
        
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

        // First time only. If already be provisioned - no effect
        operation = "Provision";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

        // First time only. If already done - no effect, syncs 0 rows
        operation = "Synchronize";
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

        operation = "Reprovision";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

        operation = "Synchronize";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }
        
        /*
        // Skip this. Only for testing
        operation = "DeprovisionStore";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

        operation = "Provision";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

        operation = "Synchronize";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }
        */

        /*
        operation = "CheckInFiles";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectName} ${operation} ${tfsUsername} ${tfsPassword}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }
        */
        
        try{
            currentBuild.result = "SUCCESS";

            duration = "Build duration: ${Util.getTimeSpanString(System.currentTimeMillis() - currentBuild.startTimeInMillis)}";

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