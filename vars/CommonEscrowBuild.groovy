import hudson.Util;

def appRootPath = "C:\\Uploads\\BuildApp\\Exaxe.SolutionManager.BuildApp.exe";

def operation = "";
def failureMessage = "";
def failureMessageSuffix = " was not successful!";

def configFile = "#";
def deployConfigurationAction = "#";

def duration = "";

def endRow = "\r\n";
def selectedJiraProjectKey = "";

try{
    node{

		// INPUT PARAMS
		configFile = SelectedConfigFile;
		deployConfigurationAction = SelectedDeployConfiguration; 
		
		// PREPARE CLASS OBJECTS
		def actionStringClass = new actionString();
	    def deployStepsClass = new escrowCommonBuildSteps();
	    
	    // START EXECUTION
        def deployCommonSteps = deployStepsClass.getEscrowCommonBuildSteps(deployConfigurationAction)
		
		for(Map<String,String>step : deployCommonSteps){
			operation = step.get("Operation");

			if(step.get("Project") == step.get("Operation")){
				stage(step.get("Operation")){
					def actionString = actionStringClass.createActionString("${appRootPath}", "${configFile}", step.get("Project"), step.get("Operation"))

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
					def actionString = actionStringClass.createActionString("${appRootPath}", "${configFile}", step.get("Project"), step.get("Operation"))
				
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
        
        
    } //// end node 
}
catch(err){
    echo "Escrow Creation Failed...";
    
    currentBuild.result = "FAILURE";
    
}