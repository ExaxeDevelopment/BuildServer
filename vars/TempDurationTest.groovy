import hudson.Util;

node{
	// Test 
    def deployStepsClass = new deployCommonBuildSteps();
    def deployCommonSteps = deployStepsClass.getDeployCommonBuildSteps("DeployEposPilotACORN")
    
    for(Map<String,String>step : deployCommonSteps){
        if(step.get("Project") == step.get("Operation")){
            stage(step.get("Operation")){
            
            }
        } 
        else{
            def stageName = "${step.get("Project")} - ${step.get("Operation")}"
            stage("${stageName}"){
            
            }
        }
    }
    
    duration = "Build duration: ${Util.getTimeSpanString(System.currentTimeMillis() - currentBuild.startTimeInMillis)}";
    echo duration.toString();
}