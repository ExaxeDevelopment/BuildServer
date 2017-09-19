import hudson.Util;

node{
    withCredentials([[$class: "UsernamePasswordMultiBinding", credentialsId: "166ca05f-1074-4a9c-9529-2ab17ba62480", usernameVariable: "USERNAME", passwordVariable: "PASSWORD"]]) {
        tfsUsername = "${env.USERNAME}"
        tfsPassword = "${env.PASSWORD}"
    }

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