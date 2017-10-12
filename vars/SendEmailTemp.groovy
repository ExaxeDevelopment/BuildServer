import hudson.Util;

def selectedJiraRelease = "";
def selectedJiraProjectKey = "";

node{

    stage("Success Notification"){
        
		// INPUT PARAMS
		selectedJiraRelease = SelectedJiraRelease;
		selectedJiraProjectKey = SelectedJiraProjectKey; 

		// JIRAT TICKETS
		def devJiraTickets;
		def resolvedJiraTickets;

		wrap([$class: 'hudson.plugins.jira.JiraCreateReleaseNotes', jiraProjectKey: selectedJiraProjectKey,
        jiraRelease: selectedJiraRelease, jiraEnvironmentVariable: 'notes', jiraFilter: 'status in (Open, Review, "To Do")']) 
		{
			println "=============================================="
			println "GET JIRA TICKETS IN DEV"
			devJiraTickets =  env.notes
			println "=============================================="
		}
    
        wrap([$class: 'hudson.plugins.jira.JiraCreateReleaseNotes', jiraProjectKey: selectedJiraProjectKey,
        jiraRelease: selectedJiraRelease, jiraEnvironmentVariable: 'notes', jiraFilter: 'status in (Resolved")']) 
		{
	    
			println "=============================================="
			println "GET RESOLVED JIRA TICKETS TO TEST"
			resolvedJiraTickets = env.notes
			println "=============================================="
	    }

		def temp  = "${env.BUILD_URL}" + "\r\n";

        mail to: "filip.ludma@exaxe.com", 
        subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
		body: temp + "RELEASE VERSION: " + selectedJiraRelease+ "\r\nJIRA TICKETS IN DEV\r\n" + devJiraTickets  + "\r\n\r\n" + "RESOLVED JIRA TICKETS TO TEST\r\n" + resolvedJiraTickets; 
    }
}

