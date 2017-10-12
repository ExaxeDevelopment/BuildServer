import hudson.Util;

def endRow = "\r\n";
def selectedJiraRelease = "";
def selectedJiraProjectKey = "";

node{

    stage("Success Notification"){
        
		// INPUT PARAMS
		selectedJiraRelease = SelectedJiraRelease;
		selectedJiraProjectKey = SelectedJiraProjectKey; 

		def jiraStatuses = "";
		switch (selectedJiraProjectKey) {
			case "OF":
                jiraStatuses = "status in ('Dev Complete', 'Tester Assigned')";
                break
			default:
				jiraStatuses = "status = Resolved";
				break
		}

		def jql = "project = " + selectedJiraProjectKey + " AND " + jiraStatuses;
		def issues = jiraJqlSearch jql: jql, site: 'exaxejira', failOnError: true;
		
		def body = "${env.BUILD_URL}" + "\r\n\r\n" + "JIRA RELEASE NOTES" + "\r\n\r\n";
		def jiraUrl = "https://exaxejira.atlassian.net/browse/"

		for(def issue in issues.data.issues){
			def tempJiraSummary = "";   
			tempJiraSummary = "Summary: ";
			tempJiraSummary = tempJiraSummary + issue.key + ": " + issue.fields.summary + endRow;

			tempJiraSummary = tempJiraSummary + "Status: ";
			tempJiraSummary = tempJiraSummary +  issue.fields.status.name + endRow;			

			tempJiraSummary = tempJiraSummary + "Created By: ";
			tempJiraSummary = tempJiraSummary + issue.fields.creator.displayName + endRow;

			tempJiraSummary = tempJiraSummary + "Assigned To: ";
			tempJiraSummary = tempJiraSummary + issue.fields.assignee.displayName + endRow;

			tempJiraSummary = tempJiraSummary + "Create Date: ";
			tempJiraSummary = tempJiraSummary + issue.fields.created + endRow + endRow;
			
			tempJiraSummary = tempJiraSummary + "Last Update Date: ";
			tempJiraSummary = tempJiraSummary + issue.fields.updated + endRow;

			tempJiraSummary = tempJiraSummary + "Link: ";
			tempJiraSummary = tempJiraSummary + jiraUrl + issue.key + endRow + endRow;

			body = body + tempJiraSummary;
		}

        mail to: "filip.ludma@exaxe.com", 
        subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
		body: body; 
    }
}

