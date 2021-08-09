import hudson.Util;

def appRootPath = "C:\\Uploads\\BuildApp\\Exaxe.SolutionManager.BuildApp.exe";

def operation = "";
def failureMessage = "";
def failureMessageSuffix = " was not successful!";

def configFile = "#";
def deployConfigurationAction = "#";

def duration = "";

def endRow = "\r\n";
def selectedJiraProjectKey = "";

try{
    node{

		// INPUT PARAMS
		configFile = SelectedConfigFile;
		deployConfigurationAction = SelectedDeployConfiguration; 
		
		// PREPARE CLASS OBJECTS
		def actionStringClass = new actionString();
	    def deployStepsClass = new deployCommonBuildSteps();
	    
	    // START EXECUTION
        def deployCommonSteps = deployStepsClass.getDeployCommonBuildSteps(deployConfigurationAction)

		def buildStagesList = []

		for(Map<String,String>step : deployCommonSteps){
			operation = step.get("Operation");

			if(step.get("Project") == step.get("Operation")){
				stage(step.get("Operation")){
					def actionString = actionStringClass.createActionString("${appRootPath}", "${configFile}", step.get("Project"), step.get("Operation"))

					def result = bat(returnStatus: true, script: "${actionString}");
					if(result != 0){
						failureMessage = "${operation} ${failureMessageSuffix}";
						echo failureMessage;
						error(failureMessage);
					}
				}
			} 

			if((step.get("Project") != step.get("Operation")) && (operation == "PublishWebSite" || operation == "DeployWebApi" || operation == "PublishWebService")){
				def buildParallelMap = [:]	
				def n = "${step.get("Project")} - RestoreNuGetPackages"
				buildParallelMap.put(n, prepareRestorePackagesStage(step))
				echo "adding ${step}"
				buildStagesList.add(buildParallelMap)
			}
		}		

		parallel buildStagesList

		deployCommonSteps = deployStepsClass.getDeployCommonBuildSteps(deployConfigurationAction)

		for(Map<String,String>step : deployCommonSteps){
			operation = step.get("Operation");

			if(step.get("Project") == step.get("Operation")){

			} 
			else{
				def stageName = "${step.get("Project")} - ${step.get("Operation")}"

				stage("${stageName}"){
					def actionString = actionStringClass.createActionString("${appRootPath}", "${configFile}", step.get("Project"), step.get("Operation"))
				
					def result = bat(returnStatus: true, script: "${actionString}");
					if(result != 0){
						failureMessage = "${operation} ${failureMessageSuffix}";
						echo failureMessage;
						error(failureMessage);
					}
				}
			}
		}	
		
        currentBuild.result = "SUCCESS";

        duration = "Build duration: ${Util.getTimeSpanString(System.currentTimeMillis() - currentBuild.startTimeInMillis)}";
        
        try{
            stage("Success Notification"){
                echo duration;
                
				def body = "${env.BUILD_URL} \r\n ${duration}" 

				envVars = env.getEnvironment()
				if(envVars.containsKey("SelectedJiraProjectKey")){
					
					// INPUT PARAM
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
		
					body = "${env.BUILD_URL} \r\n ${duration}" + "\r\n\r\n" + "JIRA RELEASE NOTES" + "\r\n\r\n";
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
				}

                mail to: "${DEV_TEAM_EMAIL},${QA_TEAM_EMAIL},${BA_TEAM_EMAIL},${PM_TEAM_EMAIL}", 
                subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
                body: body;
            }
        }
        catch(err){
            echo "Notification stage failed, but build was successful.";
            echo "Error: ${err}"
        }
        
    } //// end node 
}
catch(err){
    echo "Deployment Failed...";
    
    currentBuild.result = "FAILURE";
    
    node{
        stage("Error Notification"){
            echo duration;

            mail to: "${DEV_TEAM_EMAIL}", 
            subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
            body: "The build failed on stage: ${operation} \r\nError: ${err} \r\nURL: ${env.BUILD_URL}"      
        }
    }    
}

def prepareRestorePackagesStage(Map<String,String>step){
	def stageName = "${step.get("Project")} - RestoreNuGetPackages"
	return {
		stage("${stageName}"){
			def actionString = actionStringClass.createActionString("${appRootPath}", "${configFile}", step.get("Project"), "RestoreNuGetPackages")
				
			def result = bat(returnStatus: true, script: "${actionString}");
			if(result != 0){
				failureMessage = "${operation} ${failureMessageSuffix}";
				echo failureMessage;
				error(failureMessage);
			}
		}
	}
}