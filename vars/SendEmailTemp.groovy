import hudson.Util;

def selectedJiraRelease = "";
def selectedJiraProjectKey = "";

node{

    stage("Success Notification"){
		
		url = env.BUILD_URL;

		if(!env.BUILD_URL.contains(".azure.com:8080")){
			url = env.BUILD_URL.replace(":8080", ".northeurope.cloudapp.azure.com:8080");
		}

		def body = "${url}"; 

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
			body = jiraReleaseNotificationEmailClass.createJiraReleaseNotes("${env.BUILD_URL}", selectedJiraProjectKey, issues)
		}

        mail to: "filip.ludma@exaxe.com", 
        subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
		body: body; 
    }
}

