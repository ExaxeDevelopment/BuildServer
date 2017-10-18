class jiraReleaseNotificationEmail implements Serializable {
    def createJiraReleaseNotes(buildUrl, selectedJiraProjectKey, issues) {
		def body = "$" + buildUrl + "\r\n\r\n" + "JIRA RELEASE NOTES" + "\r\n\r\n";
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
			tempJiraSummary = tempJiraSummary + issue.fields.created + endRow;
			
			tempJiraSummary = tempJiraSummary + "Last Update Date: ";
			tempJiraSummary = tempJiraSummary + issue.fields.updated + endRow;

			tempJiraSummary = tempJiraSummary + "Link: ";
			tempJiraSummary = tempJiraSummary + jiraUrl + issue.key + endRow + endRow;

			body = body + tempJiraSummary;
		}

		body;
	}
}