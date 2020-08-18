import hudson.Util;

def duration = "";
def buildFromStage = "#";
def buildToStage = "#";
def orchestrationType = "#"

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

				case "IntermediateDevelopment":
					allSteps = getIntermediateDevelopmentSteps(buildFromStage, buildToStage);
					break

				case "Integration":
					allSteps = getIntegrationSteps(buildFromStage, buildToStage);
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
					parallelBuildJobs[job] = getRemoteJobRequest(serverName, job, REMOTE_TOKEN, mapStatuses)
				}
				
				parallel parallelBuildJobs;
			} 			

			List productsStability = getProductsStability(mapStatuses);
			
			def stableMessage = "";
			def mailTo = "${DEV_TEAM_EMAIL}";
			
			if(productsStability.size() > 0){
				////Prepares message indicating the products stability
				stableMessage = """
				****************************************************
				ADMIN PLUS STABLE? ${productsStability.get(0)}
				ADVICE PLUS STABLE? ${productsStability.get(1)}
				DISTRIBUTION PLUS STABLE? ${productsStability.get(2)}
				PORTALS STABLE? ${productsStability.get(3)}
				****************************************************
				"""
				
				mailTo += ",${QA_TEAM_EMAIL}"
			}
 			
			echo stableMessage

			currentBuild.result = "SUCCESS";
		
			duration = "Build duration: ${Util.getTimeSpanString(System.currentTimeMillis() - currentBuild.startTimeInMillis)}";
		
			try{
				stage("Success Notification"){
					echo duration;
				
					mail to: "${mailTo}", 
					subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
					body: "${env.BUILD_URL} \r\n ${duration} \r\n ${stableMessage}"  
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
	
    node{
        stage("Error Notification"){
            mail to: "${DEV_TEAM_EMAIL}", 
            subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
            body: "The deployment failed \r\nError: ${err} \r\nURL: ${env.BUILD_URL}"
        }
    }	
}

/// Method that returns a remote request job ready to be executed.
def getRemoteJobRequest(serverName, job, token, mapStatuses){
	
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

			mail to: "${DEV_TEAM_EMAIL}",
            subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / FAILURE)", 
            body: "The remote build (${job} @ ${serverName}) failed \r\nError: ${err} \r\nURL: ${env.BUILD_URL}"
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

	//// Temporary stage to allow integration to be kicked off automatically
	/*Map<String,String> mapIntegration = new HashMap<String,String>();
	mapIntegration.put("MasterBuild-Orchestration-Integration", BASE_BUILD_SERVER)
	steps.put("Integration", mapIntegration); */
		 
	Map<String,String> map02 = new HashMap<String,String>();
	map02.put("MasterBuild-AdminPlus-Dev002", ADMIN_PLUS_BUILD_SERVER)
	map02.put("MasterBuild-AdvicePlus-Dev002", ADVICE_PLUS_BUILD_SERVER)
	map02.put("MasterBuild-ChannelPlus-Dev002", DISTRIBUTION_PLUS_BUILD_SERVER)
	map02.put("MasterBuild-PolicyEBI-Dev001", BASE_BUILD_SERVER)
	steps.put("Backend Services", map02);
	  
	Map<String,String> map03 = new HashMap<String,String>();
	map03.put("MasterBuild-Apex-Dev002", APEX_BUILD_SERVER)	
	steps.put("APEX", map03);
	 
	Map<String,String> map04 = new HashMap<String,String>();
	map04.put("MasterBuild-WebServices-Dev002", API_BUILD_SERVER)	
	steps.put("Web Services", map04);

	Map<String,String> map05 = new HashMap<String,String>();
	map05.put("Build-Exaxe.ProductDevelopment.UI-Dev001", BASE_BUILD_SERVER)	
	map05.put("Build-SystemConfigurationUI-Dev002", BASE_BUILD_SERVER)	
	map05.put("Build-AdminPlusUI-Dev002", ADMIN_PLUS_BUILD_SERVER)
	map05.put("Build-PointOfSaleUI-Dev002", ADVICE_PLUS_BUILD_SERVER)	
	map05.put("Build-ChannelPlusUI-Dev002", DISTRIBUTION_PLUS_BUILD_SERVER)
	map05.put("Build-Exaxe.Portals-Dev002", API_BUILD_SERVER)
	map05.put("Build-Hansard.Portals-Dev002", API_BUILD_SERVER)	
	steps.put("Web Sites", map05);

	Map<String,String> map06 = new HashMap<String,String>();
	map06.put("Deploy-Dev002-Hansard-Exaxe-Single", HD_DEPLOY_SERVER)
	map06.put("Deploy-Dev002-OneFamily-Exaxe-Single", OF_DEPLOY_SERVER)
	map06.put("Deploy-Dev002-PoliceMutual-Single", PM_DEPLOY_SERVER)
	map06.put("Deploy-Dev002-SalesDemo-AdvicePlus-Single", DEMO_DEPLOY_SERVER)
	map06.put("Deploy-Dev002-Acorn-Exaxe-Single", ACN_DEPLOY_SERVER)
	steps.put("Deployments", map06);

	Map<String,String> map06a = new HashMap<String,String>();
	map06a.put("Deploy-Dev001-Aviva-Exaxe-Single", AVIVA_DEPLOY_SERVER)
	steps.put("Deployments-a", map06a);

	Map<String,String> map07 = new HashMap<String,String>();
	map07.put("Build-QualityGates-exop-base-bld01", BASE_BUILD_SERVER)
	map07.put("Build-QualityGates-exop-ap-bld01", ADMIN_PLUS_BUILD_SERVER)
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
	map05.put("Build-Exaxe.Portals-Dev002", API_BUILD_SERVER)
	map05.put("Build-Hansard.Portals-Dev002", API_BUILD_SERVER)	
	steps.put("Web Sites", map05);

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
	map02.put("MasterBuild-AdminPlus-Dev001", ADMIN_PLUS_BUILD_SERVER)
	map02.put("MasterBuild-AdvicePlus-Dev001", ADVICE_PLUS_BUILD_SERVER)
	map02.put("MasterBuild-ChannelPlus-Dev001", DISTRIBUTION_PLUS_BUILD_SERVER)
	steps.put("Backend Services", map02);
	  
	Map<String,String> map03 = new HashMap<String,String>();
	map03.put("MasterBuild-Apex-Dev001", APEX_BUILD_SERVER)	
	steps.put("APEX", map03);
	 
	Map<String,String> map04 = new HashMap<String,String>();
	map04.put("MasterBuild-WebServices-Dev001", API_BUILD_SERVER)	
	steps.put("Web Services", map04);

	Map<String,String> map05 = new HashMap<String,String>();
	map05.put("Build-SystemConfigurationUI-Dev001", BASE_BUILD_SERVER)	
	map05.put("Build-AdminPlusUI-Dev001", ADMIN_PLUS_BUILD_SERVER)
	map05.put("Build-PointOfSaleUI-Dev001", ADVICE_PLUS_BUILD_SERVER)	
	map05.put("Build-ChannelPlusUI-Dev001", DISTRIBUTION_PLUS_BUILD_SERVER)
	map05.put("Build-Exaxe.Portals-Dev001", API_BUILD_SERVER)
	map05.put("Build-Hansard.Portals-Dev001", API_BUILD_SERVER)	
	steps.put("Web Sites", map05);

	//// ***** ADD/REMOVE the customers and respective stages if/when required
	// 1. SINGLE SERVER --> EXAXE
	Map<String,String> map06 = new HashMap<String,String>();
	map06.put("Deploy-Dev001-Hansard-Exaxe-Single", HD_DEPLOY_SERVER)
	map06.put("Deploy-Dev001-OneFamily-Exaxe-Single", OF_DEPLOY_SERVER)
	steps.put("Deployments / Exaxe Single", map06);

	// 2. SINGLE SERVER --> CUSTOMER
	Map<String,String> map07 = new HashMap<String,String>();
	//map07.put("Deploy-Dev001-Hansard-Single", HD_DEPLOY_SERVER)
	//map07.put("Deploy-Dev001-OneFamily-Single", OF_DEPLOY_SERVER)
	steps.put("Deployments / Customer Single", map07);

	// 3. MULTI SERVER --> EXAXE
	Map<String,String> map08 = new HashMap<String,String>();
	map08.put("Deploy-Dev001-Hansard-Exaxe-Multi", HD_DEPLOY_SERVER)
	map08.put("Deploy-Dev001-OneFamily-Exaxe-Multi", OF_DEPLOY_SERVER)
	steps.put("Deployments / Exaxe Multi", map08);

	// 4. MULTI SERVER --> CUSTOMER
	Map<String,String> map09 = new HashMap<String,String>();
	//map09.put("Deploy-Dev001-Hansard-Multi", HD_DEPLOY_SERVER)
	//map09.put("Deploy-Dev001-OneFamily-Multi", OF_DEPLOY_SERVER)
	steps.put("Deployments / Customer Multi", map09);
 
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
	keyBuilds.add("MasterBuild-Apex");
	keyBuilds.add("Build-AdminPlusUI");
	
	keyBuilds;
}

//// Method that returns the key builds for Advice Plus
//// To be used to check whether the deployment might be affected
def getAdvicePlusKeyBuilds(){
	List keyBuilds = new ArrayList<String>();
	keyBuilds.add("MasterBuild-AdvicePlus");
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
	keyBuilds.add("MasterBuild-WebServices");
	keyBuilds.add("Build-Exaxe.Portals");
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

	echo "GETTING PRODUCTS STABILITY..." 

	mapStatuses.each{key, value ->
		echo "KEY:${key} / VALUE:${value}" 
		if(key.startsWith("Deploy")){
			hasDeployments = true;
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
	
	//// Get the key builds for the different products
	List adminPlusKeyBuilds = getAdminPlusKeyBuilds();
	List advicePlusKeyBuilds = getAdvicePlusKeyBuilds();
	List distributionPlusKeyBuilds = getDistributionPlusKeyBuilds();
	List portalsKeyBuilds = getPortalsKeyBuilds();
	
	//// Check for failures 
	mapStatuses.each{key, value ->
		if(value == false){
			adminPlusKeyBuilds.each{ str -> 
				if(key.startsWith(str)){
					echo "ADMIN PLUS NOT STABLE (${key}/${str})."
					productsStability.set(0, false);
				}
			};
			
			advicePlusKeyBuilds.each{ str -> 
				if(key.startsWith(str)){
					echo "ADVICE PLUS NOT STABLE (${key}/${str})."
					productsStability.set(1, false);
				}
			};
			
			distributionPlusKeyBuilds.each{ str -> 
				echo "DISTRIBUTION PLUS NOT STABLE (${key}/${str})."
				if(key.startsWith(str)){
					productsStability.set(2, false);
				}
			};
			
			portalsKeyBuilds.each{ str -> 
				echo "PORTALS NOT STABLE (${key}/${str})."
				if(key.startsWith(str)){
					productsStability.set(3, false);
				}
			};
		}
	}	
	
	productsStability
}
