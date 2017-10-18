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

			def jiraStatuses = "";
			switch (selectedJiraProjectKey) {
				case "OF":
					jiraStatuses = "status in ('Dev Complete', 'Test In Progress')";
					selectedJiraProjectKey = "'OF'";
					break
				default:
					jiraStatuses = "status = Resolved";
					break
			}

			def jql = "project = " + selectedJiraProjectKey + " AND " + jiraStatuses;
			def issues = jiraJqlSearch jql: jql, site: 'exaxejira', failOnError: true;

			// PREPARE CLASS OBJECT
			def jiraReleaseNotificationEmailClass = new jiraReleaseNotificationEmail();
	    
	    	// START EXECUTION
			body = jiraReleaseNotificationEmailClass.createJiraReleaseNotes(selectedJiraProjectKey, issues)
		}

        mail to: "filip.ludma@exaxe.com", 
        subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
		body: body; 
    }
}

