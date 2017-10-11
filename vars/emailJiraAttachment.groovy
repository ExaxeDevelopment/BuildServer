class emailJiraAttachment implements Serializable {
    def getJiraIssueKey() { 

        List<String> issueKeys = jiraSearch(jql: "project = EPOS AND status in (Resolved)")	
        issueKeys
    }
}