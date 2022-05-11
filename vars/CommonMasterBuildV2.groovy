import hudson.Util;

def jobBuild = "";

def duration = "";

def css = "<style>body{font-size: 60px}img{width: 50%;height:auto}.good-text{color:#7FD400}.bad-text{color:#F15D22}.good{background-color:#7FD400}.bad{background-color:#F15D22}.banner{width: 100%; min-height: 20px}</style>";

try{
	
    node{
		// INPUT PARAMS
		def masterBuildName = SelectedMasterBuild; 
		def buildFrom = BuildFromProject; 

		def masterBuildStepsClass = new masterBuildSteps();

		def buildSteps = masterBuildStepsClass.getMasterBuildSteps(masterBuildName, buildFrom);
    
		for (String buildStep : buildSteps) {
			jobBuild = buildStep; //// So it can be included in the failure notification

			echo "Building: ${buildStep}";

			stage("${buildStep}")
			{
				build buildStep;
			}
		}

		currentBuild.result = "SUCCESS";
		duration = "Build duration: ${Util.getTimeSpanString(System.currentTimeMillis() - currentBuild.startTimeInMillis)}";

		try{
			stage("Success Notification"){
                echo duration;
				
                mail to: "${DEV_TEAM_EMAIL}", 
                subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
                body: "<html><body>${css}<div class='good banner'>&nbsp;</div><a href='${env.BUILD_URL}'>${JOB_NAME} ${currentBuild.displayName} / ${currentBuild.result}</a><br/> ${duration}<br/><div>${embeddedImage}</div></body></html>",
				mimeType: "text/html"
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
            body: "<html><body>${css}<div class='bad banner'>&nbsp;</div>The build failed on stage: ${operation} <br/>Error: ${err} <br/><a href='${env.BUILD_URL}'>${JOB_NAME} ${currentBuild.displayName} / ${currentBuild.result}</a><br/><div>${embeddedImage}</div></body></html>",
			mimeType: 'text/html'      
        }
    }
}