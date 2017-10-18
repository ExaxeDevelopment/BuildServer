import hudson.Util;
import org.thoughtslive.jenkins.plugins.jira.api.Component;
import org.thoughtslive.jenkins.plugins.jira.api.Version;
import org.thoughtslive.jenkins.plugins.jira.Site;

def endRow = "\r\n";
def selectedJiraRelease = "";
def selectedJiraProjectKey = "";

node{

    stage("Success Notification"){
		def body = "${env.BUILD_URL}"; 

		envVars = env.getEnvironment()
		if(envVars.containsKey("SelectedJiraProjectKey")){
			// INPUT PARAMS
			selectedJiraProjectKey = SelectedJiraProjectKey; 

			// PREPARE CLASS OBJECT
			def jiraReleaseNotificationEmailClass = new jiraReleaseNotificationEmail();
	    
	    	// START EXECUTION
			body = jiraReleaseNotificationEmailClass.createJiraReleaseNotes(selectedJiraProjectKey)
		}

        mail to: "filip.ludma@exaxe.com", 
        subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
		body: body; 
    }
}

