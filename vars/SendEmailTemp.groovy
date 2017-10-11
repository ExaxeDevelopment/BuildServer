import hudson.Util;

node{

    stage("Success Notification"){
        
		// EXECUTE
		def issueKeys = List<String> issueKeys = jiraSearch(jql: "project = EPOS AND status in (Resolved)")	

		def temp  = "${env.BUILD_URL} \r\n ${duration} \r\n";
		def jiraUrl = "https://exaxejira.atlassian.net/browse/"
		if(issueKeys != null){
			for(String key : issueKeys){
				temp = temp + jiraUrl + key + "\r\n";
			}
		}

        mail to: "filip.ludma@exaxe.com", 
        subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
		body: temp 
    }
}

