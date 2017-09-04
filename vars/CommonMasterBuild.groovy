import hudson.Util;

def jobBuild = "";

def duration = "";

try{
	
    node{
		// INPUT PARAMS
		def masterBuildName = "#";
		masterBuildName = SelectedMasterBuild; 
		def action = "#";
		action = BuildFromProject; 
    
		// GET MASTER BUILD STEPS
		def masterBuildStepsClass = new masterBuildStepsByProject();
		def buildSteps = masterBuildStepsClass.getMasterBuildStepsByProject(masterBuildName, action);

		// STEPS EXECUTION
		for (String buildStep : buildSteps) {
			stage("${buildStep}")
			{
				build jobBuild;
			}
		}

		currentBuild.result = "SUCCESS";
		//duration = "Build duration: ${Util.getTimeSpanString(System.currentTimeMillis() - currentBuild.startTimeInMillis)}";

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

	} // END NODE
}
catch(err){
    echo "Build Failed...";
	
    currentBuild.result = "FAILURE";
	
    node{
        stage("Error Notification"){
            mail to: "${DEV_TEAM_EMAIL}", 
            subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
            body: "The build failed on stage: ${jobBuild} \r\nError: ${err} \r\nURL: ${env.BUILD_URL}"      
        }
    }	
}