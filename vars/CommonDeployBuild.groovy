import hudson.Util;

def appRootPath = "C:\\Uploads\\BuildApp\\Exaxe.SolutionManager.BuildApp.exe";

def operation = "";
def failureMessage = "";
def failureMessageSuffix = " was not successful!";

def configFile = "#";
def deployConfigurationAction = "#";

def duration = "";

def endRow = "<br/>";
def selectedJiraProjectKey = "";

def css = "<style>body{font-size: 60px}img{width: 50%;height:auto}.good-text{color:#7FD400}.bad-text{color:#F15D22}.good{background-color:#7FD400}.bad{background-color:#F15D22}.banner{width: 100%; min-height: 20px}</style>";

def actionStringClass;

try{
    node{

		// INPUT PARAMS
		configFile = SelectedConfigFile;
		deployConfigurationAction = SelectedDeployConfiguration; 
		
		// PREPARE CLASS OBJECTS
		actionStringClass = new actionString();
	    def deployStepsClass = new deployCommonBuildSteps();
	    
	    // START EXECUTION
        def deployCommonSteps = deployStepsClass.getDeployCommonBuildSteps(deployConfigurationAction)

		def restoreParallelMap = [:]	
		def databaseParallelMap = [:]	
		def webSiteParallelMap = [:]	
		def webServiceParallelMap = [:]	
		def webApiParallelMap = [:]	
		for(Map<String,String>step : deployCommonSteps){
			operation = step.get("Operation");
			
			if(step.get("Project") == step.get("Operation") && operation != "ReleaseContent"){
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

			if(step.get("Project") != step.get("Operation")){
				if(operation == "PublishWebSite" || operation == "DeployWebApi" || operation == "PublishWebService"){
					def n = "${step.get("Project")} RestoreNuGetPackages"
					restoreParallelMap.put(n, prepareRestorePackagesStage(step, configFile, appRootPath))
					echo "adding ${step}"
				}
				if(operation == "BuildDatabase"){
					def n = "${step.get("Project")} BuildDatabase"
					databaseParallelMap.put(n, prepareStage(step, configFile, appRootPath))
					echo "adding ${step}"
				}
				if(operation == "PublishWebSite"){
					def n = "${step.get("Project")} PublishWebSite"
					webSiteParallelMap.put(n, prepareStage(step, configFile, appRootPath))
					echo "adding ${step}"
				}
				if(operation == "PublishWebService"){
					def n = "${step.get("Project")} PublishWebService"
					webServiceParallelMap.put(n, prepareStage(step, configFile, appRootPath))
					echo "adding ${step}"
				}
				if(operation == "DeployWebApi"){
					def n = "${step.get("Project")} DeployWebApi"
					webApiParallelMap.put(n, prepareStage(step, configFile, appRootPath))
					echo "adding ${step}"
				}
			}
		}		
		 
		parallel(restoreParallelMap)
		parallel(databaseParallelMap)
		//parallel(webSiteParallelMap)
		//parallel(webServiceParallelMap)
		//parallel(webApiParallelMap)

		for(Map<String,String>step : deployCommonSteps){
			operation = step.get("Operation");

			if(step.get("Project") != step.get("Operation") && operation != "BuildDatabase"){
				echo "runnig ${step}"
			
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
			else if(operation == "ReleaseContent"){
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
		}	
		
        currentBuild.result = "SUCCESS";

        duration = "Build duration: ${Util.getTimeSpanString(System.currentTimeMillis() - currentBuild.startTimeInMillis)}";
        
        try{
            stage("Success Notification"){
                echo duration;
                
				def body = "${env.BUILD_URL} ${endRow} ${duration}" 

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
		
					body = "<html><body>${css}${env.BUILD_URL} ${endRow} ${duration} ${endRow} JIRA RELEASE NOTES${endRow}";
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

				body = body + "</body></html>";

                mail to: "${DEV_TEAM_EMAIL},${QA_TEAM_EMAIL},${BA_TEAM_EMAIL},${PM_TEAM_EMAIL}", 
                subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
                body: body,
				mimeType: "text/html";
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
            body: "<html><body>${css}<div class='bad banner'>&nbsp;</div>The build failed on stage: ${operation} <br/>Error: ${err} <br/><a href='${env.BUILD_URL}'>${JOB_NAME} ${currentBuild.displayName} / ${currentBuild.result}</a></body></html>",
			mimeType: 'text/html'            
        }
    }    
}

def prepareRestorePackagesStage(Map<String,String>step, String configFile, String appRootPath){
	
	def operation = step.get("Operation");
	def project = step.get("Project");
	def stageName = "${project} - RestoreNuGetPackages";

	return {
		stage("${stageName}"){
			
			def actionStringClass = new actionString();
			def actionString = actionStringClass.createActionString("${appRootPath}", "${configFile}", "${project}", "RestoreNuGetPackages")

			
			def result = bat(returnStatus: true, script: "${actionString}");
			if(result != 0){
				failureMessage = "RestoreNuGetPackages ${failureMessageSuffix}";
				echo failureMessage;
				error(failureMessage);
			}
		}
	}
}

def prepareStage(Map<String,String>step, String configFile, String appRootPath){
	
	def operation = step.get("Operation");
	def project = step.get("Project");
	def stageName = "${project} - ${operation}";

	return {
		stage("${stageName}"){
			
			def actionStringClass = new actionString();
			def actionString = actionStringClass.createActionString("${appRootPath}", "${configFile}", "${project}", "${operation}")

			
			def result = bat(returnStatus: true, script: "${actionString}");
			if(result != 0){
				failureMessage = "RestoreNuGetPackages ${failureMessageSuffix}";
				echo failureMessage;
				error(failureMessage);
			}
		}
	}
}