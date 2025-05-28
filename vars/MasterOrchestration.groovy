import hudson.Util;

def duration = "";
def buildFromStage = "#";
def buildToStage = "#";
def orchestrationType = "#"
def css = "<style>body{font-size: 3em}img{width: 50%;height:auto}.good-text{color:#7FD400}.bad-text{color:#F15D22}.good{background-color:#7FD400}.bad{background-color:#F15D22}.banner{width: 100%; min-height: 20px;padding: 5px;}</style>";

def embeddedImage = "<img src='data:image/png;base64,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' />";

def class1 = "good-text";
def class2 = "good-text";
def class3 = "good-text";
def class4= "good-text";
def class5 = "good-text";
def class6 = "good-text";
def class7 = "good-text";
def class8 = "good-text";

def dev001Banner = "good"
def dev002Banner = "good"

try{
	
	node {
		stage("Orchestration - ${OrchestrationType}"){
			
			// Input parameters
			buildFromStage = FromStage
			buildToStage = ToStage
			orchestrationType = OrchestrationType
	
			echo "From: ${buildFromStage}"
			echo "To: ${buildToStage}"
			echo "Orchestration: ${orchestrationType}"

			Map<String,Map<String,String>> allSteps = null

			switch (orchestrationType) {
				case "Development":
					allSteps = getDevelopmentSteps(buildFromStage, buildToStage);
					break

				case "DatabaseReconciliation":
					allSteps = getDatabaseReconciliationSteps(buildFromStage, buildToStage);

					break
				case "IntermediateDevelopment":
					allSteps = getIntermediateDevelopmentSteps(buildFromStage, buildToStage);
					break

				case "Integration":
					allSteps = getIntegrationSteps(buildFromStage, buildToStage);
					break

				case "Utils":
					allSteps = getUtilsSteps(buildFromStage, buildToStage);
					break
				
				case "SuperBuild":
					allSteps = getSuperBuildSteps(buildFromStage, buildToStage);
					break
				case "HansardDeployments":
					allSteps = getHansardDeployments(buildFromStage, buildToStage);
					break
				case "StopAllBuilds":
					allSteps = getStopAllBuilds(buildFromStage, buildToStage);
					break
			}

			//// Set the default status to 'false' (FAILURE)
			Map<String,Boolean> mapStatuses = new LinkedHashMap<String,Boolean>();
			allSteps.each{stage, innerSteps ->
				innerSteps.each{job, serverName ->				
					mapStatuses.put(job, false);
				}
			}

			allSteps.each{stage, innerSteps ->
				def parallelBuildJobs = [:] 
				echo "************** ${stage} ******************"

				innerSteps.each{job, serverName ->
					echo "Server:${serverName} / Pipeline:${job}" 
					parallelBuildJobs[job] = getRemoteJobRequest(serverName, job, REMOTE_TOKEN, mapStatuses, css, embeddedImage)
				}
				
				parallel parallelBuildJobs;
			} 			

			List productsStability = getProductsStability(mapStatuses);
			
			def stableMessage = "";
			def mailTo = "${DEV_TEAM_EMAIL}";
			
			if(productsStability.size() > 5){
				////Prepares message indicating the products stability
				stableMessage = """
				****************************************************<br/>
				<br/>
				<p>DEV001</p>
<br/>
				ADMIN PLUS STABLE? ${productsStability.get(0)}<br/>
				ADVICE PLUS STABLE? ${productsStability.get(1)}<br/>
				DISTRIBUTION PLUS STABLE? ${productsStability.get(2)}<br/>
				PORTALS STABLE? ${productsStability.get(3)}<br/>
				****************************************************<br/>
<br/>
				<p>DEV002</p>
<br/>
				ADMIN PLUS STABLE? ${productsStability.get(4)}<br/>
				ADVICE PLUS STABLE? ${productsStability.get(5)}<br/>
				DISTRIBUTION PLUS STABLE? ${productsStability.get(6)}<br/>
				PORTALS STABLE? ${productsStability.get(7)}<br/>
				****************************************************<br/>
				"""
				
				mailTo += ",${QA_TEAM_EMAIL},${BA_TEAM_EMAIL}"
			}
 			else if(productsStability.size() > 0){
				 if(!productsStability.get(0)){
					 class1 = "bad-text";
				 }
				 if(!productsStability.get(1)){
					 class2 = "bad-text";
				 }
				 if(!productsStability.get(2)){
					 class3 = "bad-text";
				 }
				 if(!productsStability.get(3)){
					 class4 = "bad-text";
				 }

				////Prepares message indicating the products stability
				stableMessage = """
				<div class=""${dev001Banner} banner"">&nbsp;</div>
				ADMIN PLUS STABLE? <span class='${class1}'>${productsStability.get(0)}</span><br/>
				<br/>ADVICE PLUS STABLE? <span class='${class2}'>${productsStability.get(1)}</span><br/>
				DISTRIBUTION PLUS STABLE? <span class='${class3}'>${productsStability.get(2)}</span><br/>
				PORTALS STABLE? <span class='${class4}'>${productsStability.get(3)}</span><br/>
				<div class='${dev001Banner} banner'>&nbsp;</div>
				"""
				
				mailTo += ",${QA_TEAM_EMAIL},${BA_TEAM_EMAIL}"
			}
 			
			echo stableMessage

			currentBuild.result = "SUCCESS";
		
			duration = "Build duration: ${Util.getTimeSpanString(System.currentTimeMillis() - currentBuild.startTimeInMillis)}";
		
			url = env.BUILD_URL;

			if(!env.BUILD_URL.contains(".azure.com:8080")){
				url = env.BUILD_URL.replace(":8080", ".northeurope.cloudapp.azure.com:8080");
			}

			try{
				stage("Success Notification"){
					echo duration;
				
					mail to: "${mailTo}", 
					subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
					body: "<html><body>${css}<div class='good banner'>&nbsp;&nbsp;${embeddedImage}</div><a href='${url}'>${JOB_NAME} ${currentBuild.displayName} / ${currentBuild.result}</a><br/> ${duration} <br/> ${stableMessage}</body></html>",
					mimeType: "text/html"
				}
			}
			catch(err){
				echo "Notification stage failed, but build was successful.";
				echo "Error: ${err}"
			}
		} // END STAGE
	} // END NODE
}
catch(err){
    echo "Build Failed...";
	
    currentBuild.result = "FAILURE";
	url = env.BUILD_URL;

	if(!env.BUILD_URL.contains(".azure.com:8080")){
		url = env.BUILD_URL.replace(":8080", ".northeurope.cloudapp.azure.com:8080");
	}

	
    node{
        stage("Error Notification"){
            mail to: "${DEV_TEAM_EMAIL}", 
            subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
			body: "<html><body>${css}<div class='bad banner'>&nbsp;&nbsp;${embeddedImage}</div><a href='${url}'>${JOB_NAME} ${currentBuild.displayName} / ${currentBuild.result}</a><br/> The deployment failed <br/> ${err}</body></html>",
			mimeType: "text/html"
        }
    }	
}

/// Method that returns a remote request job ready to be executed.
def getRemoteJobRequest(serverName, job, token, mapStatuses, css, embeddedImage){
	
	def remoteRequest = {
		try{
			stage("${job}"){
				echo "Trigering job: ${job}"
				def handle = triggerRemoteJob(remoteJenkinsName: serverName, job: job, token: token, pollInterval: 30, blockBuildUntilComplete: true);
				def status = handle.getBuildStatus();
				echo "Remote status from ${job}: ${status.toString()}";
				def result = handle.getBuildResult();
				echo "Remote result from ${job}: ${result.toString()}";

				if(result.toString() == "SUCCESS" && mapStatuses.containsKey(job)){
					mapStatuses.put(job, true);
				}
			}
		}
		catch(err){
			echo "Build ${job} failed... ${err}";

			url = env.BUILD_URL;

			if(!env.BUILD_URL.contains(".azure.com:8080")){
				url = env.BUILD_URL.replace(":8080", ".northeurope.cloudapp.azure.com:8080");
			}

			mail to: "${DEV_TEAM_EMAIL}",
            subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / FAILURE)", 
			body: "<html><body>${css}<div class='bad banner'>&nbsp;&nbsp;${embeddedImage}</div><a href='${url}'>${JOB_NAME} ${currentBuild.displayName} / ${currentBuild.result}</a><br/> The remote build (${job} @ ${serverName}) failed<br/> ${err}</body></html>",
			mimeType: "text/html"
		}
	}
			
	remoteRequest
}

/// Method that returns the development steps for Build, Deploy, Analysis, etc.
def getDevelopmentSteps(buildFromStage, buildToStage){
	Map<String,Map<String,String>> steps = new LinkedHashMap<String,Map<String,String>>();

	Map<String,String> map01 = new HashMap<String,String>();
	map01.put("MasterBuild-Base-Dev001", BASE_BUILD_SERVER)
	steps.put("Base/Common", map01);

	////Temporary stage to allow integration to be kicked off automatically
	////Map<String,String> mapIntegration = new HashMap<String,String>();
	////mapIntegration.put("MasterBuild-Orchestration-Integration", BASE_BUILD_SERVER)
	////steps.put("Integration", mapIntegration);  
		 
	Map<String,String> map02 = new HashMap<String,String>();
	map02.put("MasterBuild-ChannelPlus-Dev002", DISTRIBUTION_PLUS_BUILD_SERVER)
	steps.put("Channel Plus", map02);

	Map<String,String> map02a = new HashMap<String,String>();
	map02a.put("MasterBuild-AdminPlus-Dev002", ADMIN_PLUS_BUILD_SERVER)
	map02a.put("MasterBuild-AdvicePlus-Dev002", ADVICE_PLUS_BUILD_SERVER)
	map02a.put("MasterBuild-PolicyEBI-Dev001", BASE_BUILD_SERVER)
	steps.put("Backend Services", map02a);
	  
	Map<String,String> map03 = new HashMap<String,String>();
	map03.put("MasterBuild-ApexWorkflow-Dev002", APEX_BUILD_SERVER)	
	map03.put("Build-Exaxe.ExcelCalculationManagers-Dev002", BASE_BUILD_SERVER)
	steps.put("APEX Workflow", map03);
	 
	Map<String,String> map04 = new HashMap<String,String>();
	map04.put("MasterBuild-Apex-Dev002", APEX_BUILD_SERVER)	
	map04.put("MasterBuild-WebServices-Dev002", API_BUILD_SERVER)	
	steps.put("APEX/Web Services", map04);

	Map<String,String> map05 = new HashMap<String,String>();
	map05.put("Build-SystemConfigurationUI-Dev002", BASE_BUILD_SERVER)	
	map05.put("Build-AdminPlusUI-Dev002", ADMIN_PLUS_BUILD_SERVER)
	map05.put("Build-PointOfSaleUI-Dev002", ADVICE_PLUS_BUILD_SERVER)	
	map05.put("Build-ChannelPlusUI-Dev002", DISTRIBUTION_PLUS_BUILD_SERVER)
	map05.put("Build-Hansard.Portals-Dev002", API_BUILD_SERVER)	
	steps.put("Web Sites", map05);

	Map<String,String> map06 = new HashMap<String,String>();
	map06.put("Deploy-Dev002-Hansard-Exaxe-Single", HD_DEPLOY_SERVER)
	map06.put("Deploy-Dev002-PoliceMutual-Single", PM_DEPLOY_SERVER)
	map06.put("Deploy-Dev002-Acorn-Exaxe-Single", ACN_DEPLOY_SERVER)
	map06.put("Deploy-Dev002-Hansard-Exaxe-Multi", DISTRIBUTION_PLUS_BUILD_SERVER)
	map06.put("Build-QualityGates-exop-ap-bld01", ADMIN_PLUS_BUILD_SERVER)
	steps.put("Deployments", map06);

	Map<String,String> map07 = new HashMap<String,String>();
	map07.put("Deploy-Dev001-Aviva-Exaxe-Single", AVIVA_DEPLOY_SERVER)
	map07.put("Build-QualityGates-exop-base-bld01", BASE_BUILD_SERVER)
	map07.put("Build-QualityGates-exop-advp-bld01", ADVICE_PLUS_BUILD_SERVER)
	map07.put("Build-QualityGates-exop-dp-bld01", DISTRIBUTION_PLUS_BUILD_SERVER)
	map07.put("Build-QualityGates-exop-apex-bld01", APEX_BUILD_SERVER)
	map07.put("Build-QualityGates-exop-api-bld01", API_BUILD_SERVER)
	steps.put("QualityGates", map07);

	Map<String,String> map08 = new HashMap<String,String>();
	map08.put("Build-DeletePackages-exop-base-bld01", BASE_BUILD_SERVER)
	map08.put("Build-DeletePackages-exop-ap-bld01", ADMIN_PLUS_BUILD_SERVER)
	map08.put("Build-DeletePackages-exop-advp-bld01", ADVICE_PLUS_BUILD_SERVER)
	map08.put("Build-DeletePackages-exop-dp-bld01", DISTRIBUTION_PLUS_BUILD_SERVER)
	map08.put("Build-DeletePackages-exop-apex-bld01", APEX_BUILD_SERVER)
	map08.put("Build-DeletePackages-exop-api-bld01", API_BUILD_SERVER)
	map08.put("DeletePackages-exop-hd-deploy1", HD_DEPLOY_SERVER)
	map08.put("DeletePackages-exop-pm-deploy1", PM_DEPLOY_SERVER)
	map08.put("DeletePackages-exop-bd-deploy1", DEMO_DEPLOY_SERVER)
	map08.put("DeletePackages-exop-al-deploy1", ACN_DEPLOY_SERVER)
	steps.put("DeletePackages", map08);
	
	Map<String,String> map09 = new HashMap<String,String>();
	map09.put("Build-ShrinkDbLogsScript-exop-base-bld01", BASE_BUILD_SERVER)
	map09.put("Build-ShrinkDbLogsScript-exop-ap-bld01", ADMIN_PLUS_BUILD_SERVER)
	map09.put("Build-ShrinkDbLogsScript-exop-advp-bld01", ADVICE_PLUS_BUILD_SERVER)
	map09.put("Build-ShrinkDbLogsScript-exop-dp-bld01", DISTRIBUTION_PLUS_BUILD_SERVER)
	map09.put("Build-ShrinkDbLogsScript-exop-apex-bld01", APEX_BUILD_SERVER)
	map09.put("Build-ShrinkDbLogsScript-exop-api-bld01", API_BUILD_SERVER)
	steps.put("ShrinkDbLogsScript", map09);

	//// filter the steps/stages
	Map<String,Map<String,String>> finalSteps = getFilteredSteps(steps, buildFromStage, buildToStage);

	finalSteps;	
}

def getStopAllBuilds(buildFromStage, buildToStage){
	Map<String,Map<String,String>> steps = new LinkedHashMap<String,Map<String,String>>();

	Map<String,String> map02 = new HashMap<String,String>();
	map02.put("Stop-All-Jobs-exop-base-bld01", BASE_BUILD_SERVER)
	map02.put("Stop-All-Jobs-exop-ap-bld01", ADMIN_PLUS_BUILD_SERVER)
	map02.put("Stop-All-Jobs-exop-advp-bld01", ADVICE_PLUS_BUILD_SERVER)
	map02.put("Stop-All-Jobs-exop-dp-bld01", DISTRIBUTION_PLUS_BUILD_SERVER)
	map02.put("Stop-All-Jobs-exop-apex-bld01", APEX_BUILD_SERVER)
	map02.put("Stop-All-Jobs-exop-api-bld01", API_BUILD_SERVER)
	map02.put("Stop-All-Jobs-exop-hd-deploy1", HD_DEPLOY_SERVER)
	map02.put("Stop-All-Jobs-exop-of-deploy1", OF_DEPLOY_SERVER)
	map02.put("Stop-All-Jobs-exop-fs-deploy1", FS_DEPLOY_SERVER)
	map02.put("Stop-All-Jobs-exop-pm-deploy1", PM_DEPLOY_SERVER)
	map02.put("Stop-All-Jobs-exop-al-deploy1", ACN_DEPLOY_SERVER)
	map02.put("Stop-All-Jobs-exop-bd-deploy1", DEMO_DEPLOY_SERVER)
	steps.put("Stop All Builds", map02);

	//// filter the steps/stages
	Map<String,Map<String,String>> finalSteps = getFilteredSteps(steps, buildFromStage, buildToStage);

	finalSteps;	
}

/// Method that returns the development steps for the Intermediate Build
def getIntermediateDevelopmentSteps(buildFromStage, buildToStage){
	Map<String,Map<String,String>> steps = new LinkedHashMap<String,Map<String,String>>();

	Map<String,String> map02 = new HashMap<String,String>();
	map02.put("Intermediate-MasterBuild-AdminPlus-Dev002", ADMIN_PLUS_BUILD_SERVER)
	map02.put("Intermediate-MasterBuild-AdvicePlus-Dev002", ADVICE_PLUS_BUILD_SERVER)
	map02.put("Intermediate-MasterBuild-ChannelPlus-Dev002", DISTRIBUTION_PLUS_BUILD_SERVER)
	steps.put("Backend Services", map02);
	  
	Map<String,String> map03 = new HashMap<String,String>();
	map03.put("Intermediate-MasterBuild-Apex-Dev002", APEX_BUILD_SERVER)	
	steps.put("APEX", map03);
	 
	Map<String,String> map04 = new HashMap<String,String>();
	map04.put("Intermediate-MasterBuild-WebServices-Dev002", API_BUILD_SERVER)	
	steps.put("Web Services", map04);

	Map<String,String> map05 = new HashMap<String,String>();
	map05.put("Build-SystemConfigurationUI-Dev002", BASE_BUILD_SERVER)	
	map05.put("Build-AdminPlusUI-Dev002", ADMIN_PLUS_BUILD_SERVER)
	map05.put("Build-PointOfSaleUI-Dev002", ADVICE_PLUS_BUILD_SERVER)	
	map05.put("Build-ChannelPlusUI-Dev002", DISTRIBUTION_PLUS_BUILD_SERVER)
	////map05.put("Build-Exaxe.Portals-Dev002", API_BUILD_SERVER)
	map05.put("Build-Hansard.Portals-Dev002", API_BUILD_SERVER)	
	steps.put("Web Sites", map05);

	Map<String,String> map06 = new HashMap<String,String>();
	map06.put("Build-DatabaseReconciliation-All", APEX_BUILD_SERVER)
	steps.put("Database Reconciliation", map06);

	//// filter the steps/stages
	Map<String,Map<String,String>> finalSteps = getFilteredSteps(steps, buildFromStage, buildToStage);

	finalSteps;	
}

/// Method that returns the development steps for the Intermediate Build
def getDatabaseReconciliationSteps(buildFromStage, buildToStage){
	Map<String,Map<String,String>> steps = new LinkedHashMap<String,Map<String,String>>();

	Map<String,String> map02 = new HashMap<String,String>();
	Map<String,String> map06 = new HashMap<String,String>();
	map06.put("Build-DatabaseReconciliation-All", APEX_BUILD_SERVER)
	steps.put("Database Reconciliation", map06);

	//// filter the steps/stages
	Map<String,Map<String,String>> finalSteps = getFilteredSteps(steps, buildFromStage, buildToStage);

	finalSteps;	
}

/// Method that returns the integartion steps for Build and Deploy
def getIntegrationSteps(buildFromStage, buildToStage){
	Map<String,Map<String,String>> steps = new LinkedHashMap<String,Map<String,String>>();

	Map<String,String> map01 = new HashMap<String,String>();
	map01.put("MasterBuild-Base-Dev001", BASE_BUILD_SERVER)
	steps.put("Base/Common", map01);

	Map<String,String> map02 = new HashMap<String,String>();
	map02.put("MasterBuild-ChannelPlus-Dev001", DISTRIBUTION_PLUS_BUILD_SERVER)
	steps.put("Channel Plus", map02);

	Map<String,String> map02a = new HashMap<String,String>();
	map02a.put("MasterBuild-AdminPlus-Dev001", ADMIN_PLUS_BUILD_SERVER)
	map02a.put("MasterBuild-AdvicePlus-Dev001", ADVICE_PLUS_BUILD_SERVER)
	map02a.put("MasterBuild-PolicyEBI-Dev001", BASE_BUILD_SERVER)
	steps.put("Backend Services", map02a);
	steps.put("Backend Services", map02a);
	  
	Map<String,String> map03 = new HashMap<String,String>();
	map03.put("MasterBuild-ApexWorkflow-Dev001", APEX_BUILD_I_SERVER)	
	map03.put("Build-Exaxe.ExcelCalculationManagers-Dev001", BASE_BUILD_SERVER)
	steps.put("APEX Workflow", map03);
	 
	Map<String,String> map04 = new HashMap<String,String>();
	map04.put("MasterBuild-Apex-Dev001", APEX_BUILD_I_SERVER)	
	map04.put("MasterBuild-WebServices-Dev001", API_BUILD_I_SERVER)	
	steps.put("APEX/Web Services", map04);

	Map<String,String> map05 = new HashMap<String,String>();
	map05.put("Build-SystemConfigurationUI-Dev001", BASE_BUILD_SERVER)	
	map05.put("Build-AdminPlusUI-Dev001", ADMIN_PLUS_BUILD_SERVER)
	map05.put("Build-PointOfSaleUI-Dev001", ADVICE_PLUS_BUILD_SERVER)	
	map05.put("Build-ChannelPlusUI-Dev001", DISTRIBUTION_PLUS_BUILD_SERVER)
	//// map05.put("Build-Exaxe.Portals-Dev001", API_BUILD_SERVER)
	map05.put("Build-Hansard.Portals-Dev001", API_BUILD_I_SERVER)	

	steps.put("Web Sites", map05);

	// 3. MULTI SERVER --> EXAXE
	Map<String,String> map08 = new HashMap<String,String>();
	map08.put("Deploy-Dev001-Hansard-Exaxe-Multi", HD_DEPLOY_SERVER)
	map08.put("Deploy-Dev001-Acorn-Exaxe-Multi", ACN_DEPLOY_SERVER)
	steps.put("Deployments / Multi", map08);

	Map<String,String> map09 = new HashMap<String,String>();
	map09.put("Deploy-Dev001-Acorn-Exaxe-Single", ACN_DEPLOY_SERVER)
	map09.put("Deploy-Dev001-PoliceMutual-Single", PM_DEPLOY_SERVER)	
	map09.put("Deploy-Dev001-Hansard-Exaxe-Single", HD_DEPLOY_SERVER)
	steps.put("Deployments / Single", map09);

	Map<String,String> map10 = new HashMap<String,String>();
	map10.put("Deploy-Dev001-Hansard-Multi", HD_DEPLOY_SERVER)
	map10.put("Deploy-Dev001-Hansard-Single", ADMIN_PLUS_BUILD_SERVER)
	steps.put("Deployments / External", map10);

 
	//// filter the steps/stages
	Map<String,Map<String,String>> finalSteps = getFilteredSteps(steps, buildFromStage, buildToStage);
	
	finalSteps;	
}

def getUtilsSteps(buildFromStage, buildToStage){
	Map<String,Map<String,String>> steps = new LinkedHashMap<String,Map<String,String>>();

	Map<String,String> map01 = new HashMap<String,String>();
	map01.put("Build-LifePlus.Migration-Main", BASE_BUILD_SERVER); 
	steps.put("Migration", map01);
	
	Map<String,String> map02 = new HashMap<String,String>();
	map02.put("Build-AppMonitor-Main", BASE_BUILD_SERVER); 
	steps.put("AppMonitor", map02);
	 
	Map<String,String> map02a = new HashMap<String,String>();
	map02a.put("Build-Escrow-Main", BASE_BUILD_SERVER); 
	steps.put("Escrow", map02a);
	 
	Map<String,String> map03 = new HashMap<String,String>();
	map03.put("Build-Exaxe.ProductDevelopment-Dev001", BASE_BUILD_SERVER); 
	steps.put("PDA3 Back", map03);

	Map<String,String> map04 = new HashMap<String,String>();
	map04.put("Build-Exaxe.ProductDevelopment.UI-Dev001", BASE_BUILD_SERVER); 
	steps.put("PDA3 UI", map04);

	Map<String,String> map05 = new HashMap<String,String>();
	map05.put("Build-SolutionManager-Main", BASE_BUILD_SERVER); 
	steps.put("SolutionManager", map05);

	Map<String,String> map06 = new HashMap<String,String>();
	map06.put("Build-NuGetCleaner-Main", BASE_BUILD_SERVER); 
	steps.put("NuGetCleaner", map06);
	
	Map<String,String> map07 = new HashMap<String,String>();
	map07.put("Deploy-Majesco-Migration", BASE_BUILD_SERVER); 
	steps.put("Deploy LifePlus.Migration", map07);
	 
	Map<String,String> map08 = new HashMap<String,String>();
	map08.put("Deploy Build App", BASE_BUILD_SERVER); 
	steps.put("Deploy BuildApp", map08);	

	Map<String,String> map09 = new HashMap<String,String>();
	map09.put("Deploy NuGetCleaner", BASE_BUILD_SERVER); 
	steps.put("Deploy NuGetCleaner", map09);	


	//// filter the steps/stages
	Map<String,Map<String,String>> finalSteps = getFilteredSteps(steps, buildFromStage, buildToStage);
	
	finalSteps;	
}


//// Method that returns the steps filtered by from/to stages
def getFilteredSteps(steps, buildFromStage, buildToStage){

	Map<String,Map<String,String>> finalSteps = new LinkedHashMap<String,Map<String,String>>();
	
	boolean foundFrom = false;
	boolean foundTo = false;
	
	steps.each{ key, value ->
		if(key != buildFromStage && !foundFrom){
			return;
		}

		if(key == buildFromStage){
			foundFrom = true;
		}	

		if(key != buildToStage && foundTo){
			return;
		}
		
		if(key == buildToStage){
			foundTo = true;
		}		

		finalSteps.put(key, value)			
	}

	finalSteps;	
}

//// Method that returns the key builds for Admin Plus
//// To be used to check whether the deployment might be affected
def getAdminPlusKeyBuilds()	{
	List keyBuilds = new ArrayList<String>();
	keyBuilds.add("MasterBuild-AdminPlus");
	keyBuilds.add("MasterBuild-ChannelPlus");
	keyBuilds.add("Build-Exaxe.Apex.Workflow");
	keyBuilds.add("MasterBuild-Apex");
	keyBuilds.add("Build-AdminPlusUI");
	
	keyBuilds;
}

//// Method that returns the key builds for Advice Plus
//// To be used to check whether the deployment might be affected
def getAdvicePlusKeyBuilds(){
	List keyBuilds = new ArrayList<String>();
	keyBuilds.add("MasterBuild-AdvicePlus");
	keyBuilds.add("Build-Exaxe.Apex.Workflow");
	keyBuilds.add("Build-PointOfSaleUI");
	
	keyBuilds;
}

//// Method that returns the key builds for Distribution Plus
//// To be used to check whether the deployment might be affected
def getDistributionPlusKeyBuilds(){
	List keyBuilds = new ArrayList<String>();
	keyBuilds.add("MasterBuild-ChannelPlus");
	keyBuilds.add("Build-ChannelPlusUI");
	keyBuilds.add("MasterBuild-WebServices");
	keyBuilds.add("Build-Exaxe.Apex.Workflow");
	keyBuilds.add("MasterBuild-Apex");
	
	keyBuilds;
}

//// Method that returns the key builds for Portals
//// To be used to check whether the deployment might be affected
def getPortalsKeyBuilds(){
	List keyBuilds = new ArrayList<String>();
	keyBuilds.add("MasterBuild-AdminPlus");
	keyBuilds.add("MasterBuild-AdvicePlus");
	keyBuilds.add("MasterBuild-ChannelPlus");
	keyBuilds.add("MasterBuild-Apex");
	keyBuilds.add("Build-Exaxe.Apex.Workflow");
	keyBuilds.add("MasterBuild-WebServices");
	keyBuilds.add("Build-Hansard.Portals");
	
	keyBuilds;
}

//// Method that returns the stability of the products:
//// 0 -> Admin Plus
//// 1 -> Advice Plus
//// 2 -> Distribution Plus
//// 3 -> Portals
def getProductsStability(mapStatuses){	
	//// Set default values for
	List productsStability = new ArrayList<Boolean>();
	
	//// Check if we have deployments	
	Boolean hasDeployments = false;

	Boolean includesDev001 = false;
	Boolean includesDev002 = false;


	echo "GETTING PRODUCTS STABILITY..." 

	mapStatuses.each{key, value ->
		echo "KEY:${key} / VALUE:${value}" 
		if(key.startsWith("Deploy")){
			hasDeployments = true;
		}
		if(key.contains("AdminPlus-Dev001")){
			includesDev001 = true;
		}
		if(key.contains("AdminPlus-Dev002")){
			includesDev002 = true;
		}
	}
	
	if(!hasDeployments){
		echo "NO DEPLOYMENTS." 
		return productsStability
	}

	//// Admin Plus
	productsStability.add(true);

	//// Advice Plus
	productsStability.add(true);

	//// Distribution Plus
	productsStability.add(true);

	//// Portals
	productsStability.add(true);

	if(includesDev001 && includesDev002){
		//// Admin Plus Dev002
		productsStability.add(true);

		//// Advice Plus Dev002
		productsStability.add(true);

		//// Distribution Plus Dev002
		productsStability.add(true);

		//// Portals Dev002
		productsStability.add(true);

	}

	
	//// Get the key builds for the different products
	List adminPlusKeyBuilds = getAdminPlusKeyBuilds();
	List advicePlusKeyBuilds = getAdvicePlusKeyBuilds();
	List distributionPlusKeyBuilds = getDistributionPlusKeyBuilds();
	List portalsKeyBuilds = getPortalsKeyBuilds();
	
	echo "Considering: ";
	mapStatuses.each{key, value -> echo "(${key}/${value})."};

	//// Check for failures 
	mapStatuses.each{key, value ->
		if(value == false){
			int offset =0;
			adminPlusKeyBuilds.each{ str -> 
				if(key.startsWith(str)){
					if(includesDev001 && includesDev002 && (key.contains("Dev002"))){
						offset = 4;
					}
					echo "ADMIN PLUS NOT STABLE (${key}/${str}).";
					productsStability.set(0+offset, false);
				}
			};
			
			advicePlusKeyBuilds.each{ str -> 
				if(key.startsWith(str)){
					if(includesDev001 && includesDev002 && (key.contains("Dev002"))){
						offset = 4;
					}
					echo "ADVICE PLUS NOT STABLE (${key}/${str}).";
					productsStability.set(1+offset, false);
				}
			};
			
			distributionPlusKeyBuilds.each{ str -> 
				echo "DISTRIBUTION PLUS NOT STABLE (${key}/${str}).";
				if(key.startsWith(str)){
					if(includesDev001 && includesDev002 && (key.contains("Dev002"))){
						offset = 4;
					}

					productsStability.set(2+offset, false);
				}
			};
			
			portalsKeyBuilds.each{ str -> 
				echo "PORTALS NOT STABLE (${key}/${str}).";
				if(key.startsWith(str)){
					if(includesDev001 && includesDev002 && (key.contains("Dev002"))){
						offset = 4;
					}

					productsStability.set(3+offset, false);
				}
			};
		}
	}	

	echo "Results: ${productsStability}";

	productsStability
}

def getHansardDeployments(buildFromStage, buildToStage){
	Map<String,Map<String,String>> steps = new LinkedHashMap<String,Map<String,String>>();

	Map<String,String> map01 = new HashMap<String,String>();
	map01.put("Deploy-Dev001-Hansard-Exaxe-Single", ADMIN_PLUS_BUILD_SERVER)
	map01.put("Deploy-Dev001-Hansard-Exaxe-Multi", DISTRIBUTION_PLUS_BUILD_SERVER)
	map01.put("Deploy-Dev001-Hansard-Single", HD_DEPLOY_SERVER)
	map01.put("Deploy-Dev001-Hansard-Multi", ADVICE_PLUS_BUILD_SERVER)

	steps.put("Dev001", map01);
		
	Map<String,String> map02 = new HashMap<String,String>();
	map02.put("Deploy-Dev002-Hansard-Exaxe-Single", HD_DEPLOY_SERVER)
	map02.put("Deploy-Dev002-Hansard-Exaxe-Multi", DISTRIBUTION_PLUS_BUILD_SERVER)


	steps.put("Dev002", map02);
		
	//// filter the steps/stages
	Map<String,Map<String,String>> finalSteps = getFilteredSteps(steps, buildFromStage, buildToStage);

	finalSteps;	
}

/// Method that returns the development steps for Build, Deploy, Analysis, etc.
def getSuperBuildSteps(buildFromStage, buildToStage){
	Map<String,Map<String,String>> steps = new LinkedHashMap<String,Map<String,String>>();

	Map<String,String> map01 = new HashMap<String,String>();
	map01.put("MasterBuild-Base-Dev001", BASE_BUILD_SERVER)
	steps.put("Base/Common", map01);

	Map<String,String> map02a = new HashMap<String,String>();
	map02a.put("MasterBuild-ChannelPlus-Dev001", DISTRIBUTION_PLUS_BUILD_SERVER)
	steps.put("Stage 2a", map02a);

	Map<String,String> map02 = new HashMap<String,String>();
	map02.put("MasterBuild-AdminPlus-Dev001", ADMIN_PLUS_BUILD_SERVER)
	map02.put("MasterBuild-ChannelPlus-Dev002", DISTRIBUTION_PLUS_BUILD_SERVER)
	map02.put("MasterBuild-AdvicePlus-Dev001", ADVICE_PLUS_BUILD_SERVER)
	map02.put("MasterBuild-PolicyEBI-Dev001", BASE_BUILD_SERVER)
	steps.put("Stage 2b", map02);

	Map<String,String> map03 = new HashMap<String,String>();
	map03.put("MasterBuild-AdminPlus-Dev002", ADMIN_PLUS_BUILD_SERVER)
	map03.put("MasterBuild-AdvicePlus-Dev002", ADVICE_PLUS_BUILD_SERVER)
	steps.put("Stage 3", map03);

	Map<String,String> map04 = new HashMap<String,String>();
	map04.put("MasterBuild-ApexWorkflow-Dev001", APEX_BUILD_I_SERVER)	
	map04.put("MasterBuild-ApexWorkflow-Dev002", APEX_BUILD_SERVER)	
	map03.put("Build-Exaxe.ExcelCalculationManagers-Dev001", BASE_BUILD_SERVER)
	steps.put("Stage 4", map04);

	Map<String,String> map05 = new HashMap<String,String>();
	map03.put("Build-Exaxe.ExcelCalculationManagers-Dev002", BASE_BUILD_SERVER)
	map05.put("MasterBuild-Apex-Dev001", APEX_BUILD_I_SERVER)	
	map05.put("MasterBuild-WebServices-Dev001", API_BUILD_I_SERVER)	
	map05.put("MasterBuild-Apex-Dev002", APEX_BUILD_SERVER)	
	map05.put("MasterBuild-WebServices-Dev002", API_BUILD_SERVER)	
	steps.put("Stage 5", map05);

	Map<String,String> map06 = new HashMap<String,String>();
	map06.put("Build-SystemConfigurationUI-Dev001", BASE_BUILD_SERVER)	
	map06.put("Build-AdminPlusUI-Dev001", ADMIN_PLUS_BUILD_SERVER)
	map06.put("Build-PointOfSaleUI-Dev001", ADVICE_PLUS_BUILD_SERVER)	
	map06.put("Build-ChannelPlusUI-Dev001", DISTRIBUTION_PLUS_BUILD_SERVER)
	map06.put("Build-Hansard.Portals-Dev001", API_BUILD_SERVER)	
	steps.put("Stage 6", map06);

	Map<String,String> map08 = new HashMap<String,String>();
	map08.put("Build-SystemConfigurationUI-Dev002", BASE_BUILD_SERVER)	
	map08.put("Build-AdminPlusUI-Dev002", ADMIN_PLUS_BUILD_SERVER)
	map08.put("Build-PointOfSaleUI-Dev002", ADVICE_PLUS_BUILD_SERVER)	
	map08.put("Build-ChannelPlusUI-Dev002", DISTRIBUTION_PLUS_BUILD_SERVER)
	map08.put("Build-Hansard.Portals-Dev002", API_BUILD_SERVER)	
	steps.put("Stage 7", map08);

	Map<String,String> map10 = new HashMap<String,String>();
	map10.put("Deploy-Dev002-Hansard-Exaxe-Single", HD_DEPLOY_SERVER)
	map10.put("Deploy-Dev002-Hansard-Exaxe-Multi", DISTRIBUTION_PLUS_BUILD_SERVER)
	map10.put("Deploy-Dev001-Hansard-Exaxe-Single", ADMIN_PLUS_BUILD_SERVER)
	map10.put("Deploy-Dev001-Hansard-Exaxe-Multi", ADVICE_PLUS_BUILD_SERVER)
	map10.put("Deploy-Dev002-PoliceMutual-Single", PM_DEPLOY_SERVER)
	map10.put("Deploy-Dev002-Acorn-Exaxe-Single", ACN_DEPLOY_SERVER)

	steps.put("Deployments part 1", map10);

	Map<String,String> map13 = new HashMap<String,String>();
	map13.put("Deploy-Dev001-Aviva-Exaxe-Single", AVIVA_DEPLOY_SERVER)
	map13.put("Deploy-Dev001-Acorn-Exaxe-Single", ACN_DEPLOY_SERVER)
	map13.put("Deploy-Dev001-PoliceMutual-Single", PM_DEPLOY_SERVER)
	map13.put("Deploy-Dev001-Hansard-Single", HD_DEPLOY_SERVER)
	map13.put("Deploy-Dev001-Hansard-Multi", ADVICE_PLUS_BUILD_SERVER)
	map13.put("Build-QualityGates-exop-ap-bld01", ADMIN_PLUS_BUILD_SERVER)
	steps.put("Deployments part 2", map13);

	// 3. MULTI SERVER --> EXAXE
	Map<String,String> map14 = new HashMap<String,String>();
	map14.put("Deploy-Dev001-Acorn-Exaxe-Multi", ACN_DEPLOY_SERVER)
	map14.put("Build-QualityGates-exop-base-bld01", BASE_BUILD_SERVER)
	map14.put("Build-QualityGates-exop-advp-bld01", ADVICE_PLUS_BUILD_SERVER)
	map14.put("Build-QualityGates-exop-dp-bld01", DISTRIBUTION_PLUS_BUILD_SERVER)
	map14.put("Build-QualityGates-exop-apex-bld01", APEX_BUILD_SERVER)
	map14.put("Build-QualityGates-exop-api-bld01", API_BUILD_SERVER)
	steps.put("Deployments part 3", map14);

	Map<String,String> map21 = new HashMap<String,String>();
	map21.put("Build-DeletePackages-exop-base-bld01", BASE_BUILD_SERVER)
	map21.put("Build-DeletePackages-exop-ap-bld01", ADMIN_PLUS_BUILD_SERVER)
	map21.put("Build-DeletePackages-exop-advp-bld01", ADVICE_PLUS_BUILD_SERVER)
	map21.put("Build-DeletePackages-exop-dp-bld01", DISTRIBUTION_PLUS_BUILD_SERVER)
	map21.put("Build-DeletePackages-exop-apex-bld01", APEX_BUILD_SERVER)
	map21.put("Build-DeletePackages-exop-api-bld01", API_BUILD_SERVER)
	map21.put("Build-DeletePackages-exop-apex-bld-i", APEX_BUILD_I_SERVER)
	map21.put("Build-DeletePackages-exop-api-bld-i", API_BUILD_I_SERVER)
	map21.put("DeletePackages-exop-hd-deploy1", HD_DEPLOY_SERVER)
	map21.put("DeletePackages-exop-pm-deploy1", PM_DEPLOY_SERVER)
	map21.put("DeletePackages-exop-bd-deploy1", DEMO_DEPLOY_SERVER)
	map21.put("DeletePackages-exop-al-deploy1", ACN_DEPLOY_SERVER)
	steps.put("DeletePackages", map21);
	
	Map<String,String> map22 = new HashMap<String,String>();
	map22.put("Build-ShrinkDbLogsScript-exop-base-bld01", BASE_BUILD_SERVER)
	map22.put("Build-ShrinkDbLogsScript-exop-ap-bld01", ADMIN_PLUS_BUILD_SERVER)
	map22.put("Build-ShrinkDbLogsScript-exop-advp-bld01", ADVICE_PLUS_BUILD_SERVER)
	map22.put("Build-ShrinkDbLogsScript-exop-dp-bld01", DISTRIBUTION_PLUS_BUILD_SERVER)
	map22.put("Build-ShrinkDbLogsScript-exop-apex-bld01", APEX_BUILD_SERVER)
	map22.put("Build-ShrinkDbLogsScript-exop-api-bld01", API_BUILD_SERVER)
	map22.put("Build-ShrinkDbLogsScript-exop-apex-bld-i", APEX_BUILD_I_SERVER)
	map22.put("Build-ShrinkDbLogsScript-exop-api-bld-i", API_BUILD_I_SERVER)
	steps.put("ShrinkDbLogsScript", map22);

	//// filter the steps/stages
	Map<String,Map<String,String>> finalSteps = getFilteredSteps(steps, buildFromStage, buildToStage);

	finalSteps;	
}