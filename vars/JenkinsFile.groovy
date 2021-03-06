@Library('ExaxeScripts') _

def appRootPath = "C:\\Uploads\\BuildApp\\Exaxe.SolutionManager.BuildApp.exe";
def configFile = "config/build/server/testBuild/Build01.json";
def projectName = "BackendTestBuild01";
def tfsUsername = "";
def tfsPassword = "";
def operation = "";
def undoOperation = "";
def failureMessage = "";
def failureMessageSuffix = " was not successful!";

node{
    withCredentials([[$class: "UsernamePasswordMultiBinding", credentialsId: "166ca05f-1074-4a9c-9529-2ab17ba62480", usernameVariable: "USERNAME", passwordVariable: "PASSWORD"]]) {
        tfsUsername = "${env.USERNAME}"
        tfsPassword = "${env.PASSWORD}"
    }
    
    def action = "#";
    action = actionInput;   //// Input parameter
    
    def buildStepsClass = new demoBuildSteps();
    def buildSteps = buildStepsClass.createBuildSteps("${action}")

    def actionStringClass = new actionString();
    
    for (String buildStep : buildSteps) {
        stage("${buildStep}"){
            def actionString = actionStringClass.createActionString("${appRootPath}", "${configFile}", "${projectName}", buildStep, "${tfsUsername}", "${tfsPassword}")
            echo "${actionString}"
            
            def result = bat(returnStatus: true, script: "${actionString}");
            if(result != 0){
                failureMessage = "${buildStep} ${failureMessageSuffix}";
                echo failureMessage;
                error(failureMessage);
            }
        }
    }
}