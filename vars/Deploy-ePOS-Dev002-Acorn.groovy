import hudson.Util;

def appRootPath = "C:\\Uploads\\BuildApp\\Exaxe.SolutionManager.BuildApp.exe";
def configFile = "config/deploy/server/epos/Deploy-ePOS-Dev002-Acorn.json";

def projectInstallApp = "Exaxe.SolutionManager";

def projectExaxeAgent = "Exaxe.Agent";
def projectExaxeApp = "Exaxe.App";
def projectExaxeProduct = "Exaxe.Product.DatabaseModel";
def projectExaxeCommon = "Exaxe.Common";
def projectExaxeConfiguration = "Exaxe.Configuration-Configuration";
def projectExaxeConfigurationQuestion = "Exaxe.Configuration-Question";
def projectExaxeSystemConfiguration = "Exaxe.SystemConfiguration";

def projectExaxeClient = "Exaxe.Client";
def projectExaxeFactFind = "Exaxe.FactFind";
def projectExaxeQuote = "Exaxe.Quote";
def projectExaxeExistingBusiness = "Exaxe.ExistingBusiness";

def projectPointOfSalesUI = "PointOfSaleUI";
def projectSystemConfigurationUI = "SystemConfigurationUI";

def tfsUsername = "";
def tfsPassword = "";

def operation = "";
def failureMessage = "";
def failureMessageSuffix = " was not successful!";

def duration = "";

try{
    node{

        withCredentials([[$class: "UsernamePasswordMultiBinding", credentialsId: "166ca05f-1074-4a9c-9529-2ab17ba62480", usernameVariable: "USERNAME", passwordVariable: "PASSWORD"]]) {
            tfsUsername = "${env.USERNAME}"
            tfsPassword = "${env.PASSWORD}"
        }

        ////////////////////////
        //// INITIALISATION ////
        ////////////////////////

        operation = "Initialisation";
        stage(operation){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} 'N/A' ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

        if(canGetAllCodeFromTFS == "true"){ // This is a parameter on the pipeline
            operation = "GetAllCodeLatestVersion";
            stage(operation){
                def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} 'N/A' ${operation} ${tfsUsername} ${tfsPassword}");
                if(result != 0){
                    failureMessage = "${operation} ${failureMessageSuffix}";
                    echo failureMessage;
                    error(failureMessage);
                }
            }
        }

        ////////////////////
        //// INSTAL APP ////
        ////////////////////

        operation = "GetCodeLatestVersion";
        stage("${projectInstallApp} - ${operation}"){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectInstallApp} ${operation} ${tfsUsername} ${tfsPassword}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

        operation = "RestoreNuGetPackages";
        stage("${projectInstallApp} - ${operation}"){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectInstallApp} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

        operation = "BuildSolution";
        stage("${projectInstallApp} - ${operation}"){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectInstallApp} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

        operation = "PublishInstallApp";
        stage("${projectInstallApp} - ${operation}"){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectInstallApp} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

        ///////////////////
        //// DATABASES ////
        ///////////////////

        operation = "BuildDatabase";

        stage("${projectExaxeAgent} - ${operation}"){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectExaxeAgent} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }
		
        stage("${projectExaxeApp} - ${operation}"){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectExaxeApp} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }
        
        stage("${projectExaxeProduct} - ${operation}"){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectExaxeProduct} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }
        
        stage("${projectExaxeCommon} - ${operation}"){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectExaxeCommon} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }
        
        stage("${projectExaxeConfiguration} - ${operation}"){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectExaxeConfiguration} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

        stage("${projectExaxeConfigurationQuestion} - ${operation}"){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectExaxeConfigurationQuestion} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }
        
        stage("${projectExaxeSystemConfiguration} - ${operation}"){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectExaxeSystemConfiguration} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }
            
        stage("${projectExaxeClient} - ${operation}"){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectExaxeClient} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }
        
        stage("${projectExaxeFactFind} - ${operation}"){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectExaxeFactFind} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

        stage("${projectExaxeQuote} - ${operation}"){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectExaxeQuote} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }


        stage("${projectExaxeExistingBusiness} - ${operation}"){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectExaxeExistingBusiness} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }
        
        //////////////////////
        //// WEB SERVICES ////
        //////////////////////

        operation = "PublishWebService"; 

        stage("${projectExaxeFactFind} - ${operation}"){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectExaxeFactFind} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

        ///////////////////
        //// WEB SITES ////
        ///////////////////

        operation = "GetCodeLatestVersion"; // To force getting all the files for the web sites. Occasionally, the publish fails with files missing from the project. 

        stage("${projectSystemConfigurationUI} - ${operation}"){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectSystemConfigurationUI} ${operation} ${tfsUsername} ${tfsPassword}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

        stage("${projectPointOfSalesUI} - ${operation}"){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectPointOfSalesUI} ${operation} ${tfsUsername} ${tfsPassword}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

        operation = "PublishWebSite"; 

        stage("${projectPointOfSalesUI} - ${operation}"){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectPointOfSalesUI} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

        stage("${projectSystemConfigurationUI} - ${operation}"){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} ${projectSystemConfigurationUI} ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }

        /////////////////////////
        //// CONTENT RELEASE ////
        /////////////////////////

        operation = "ReleaseContent";
        stage('Release Content'){
            def result = bat(returnStatus: true, script: "${appRootPath} ${configFile} 'N/A' ${operation}");
            if(result != 0){
                failureMessage = "${operation} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
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
    echo "Deploymet Failed...";
	
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