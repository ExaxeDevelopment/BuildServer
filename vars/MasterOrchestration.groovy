import hudson.Util;

def failureMessage = "";
def failureMessageSuffix = " was not successful!";
def duration = "";


try{
	
    node{

	} // END NODE
}
catch(err){
    echo "Build Failed...";
	
    currentBuild.result = "FAILURE";
	
    node{
        stage("Error Notification"){
            mail to: "${DEV_TEAM_EMAIL}", 
            subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
            body: "The deployment failed \r\nError: ${err} \r\nURL: ${env.BUILD_URL}"
        }
    }	
}