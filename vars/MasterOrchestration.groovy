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

				case "Integration":
					allSteps = getIntegrationSteps(buildFromStage, buildToStage);
					break
			}

			allSteps.each{stage, innerSteps ->
				def parallelBuildJobs = [:] 
				echo "************** ${stage} ******************"

				innerSteps.each{key, value ->
					echo "Server:${value} / Pipeline:${key}" 
					parallelBuildJobs[key] = getRemoteJobRequest(value, key, REMOTE_TOKEN)
				}
				
				parallel parallelBuildJobs;
			} 
			
			currentBuild.result = "SUCCESS";
		
			duration = "Build duration: ${Util.getTimeSpanString(System.currentTimeMillis() - currentBuild.startTimeInMillis)}";
		
			try{
				stage("Success Notification"){
					echo duration;
				
					mail to: "${DEV_TEAM_EMAIL}", 
					subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
					body: "${env.BUILD_URL} \r\n ${duration}" 
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
def getRemoteJobRequest(serverName, job, token){
	
	def remoteRequest = {
		try{
			stage("${job}"){
				echo "Trigering job: ${job}"
				def handle = triggerRemoteJob(remoteJenkinsName: serverName, job: job, token: token, connectionRetryLimit: 1, blockBuildUntilComplete: true);
				def status = handle.getBuildStatus();
				echo "Remote status from ${job}: ${status.toString()}";
				def result = handle.getBuildResult();
				echo "Remote result from ${job}: ${result.toString()}";
			}
		}
		catch(err){
			echo "Build ${job} failed...";			
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
	map06.put("Deploy-Dev002-Foresters-Exaxe-Single", FFS_DEPLOY_SERVER)
	map06.put("Deploy-Dev002-OneFamily-Exaxe-Single", OF_DEPLOY_SERVER)
	map06.put("Deploy-Dev002-PoliceMutual-Single", PM_DEPLOY_SERVER)
	map06.put("Deploy-AdminPlus-Dev002-SalesDemo", DEMO_DEPLOY_SERVER)
	map06.put("Deploy-AdvicePlus-Dev002-ACORN", ACN_DEPLOY_SERVER)
	map06.put("Deploy-Dev001-Aviva-Exaxe-Single", AVIVA_DEPLOY_SERVER)
	steps.put("Deployments", map06);

	Map<String,String> map07 = new HashMap<String,String>();
	map07.put("Build-QualityGates-exop-base-bld01", BASE_BUILD_SERVER)
	map07.put("Build-QualityGates-exop-ap-bld01", ADMIN_PLUS_BUILD_SERVER)
	map07.put("Build-QualityGates-exop-advp-bld01", ADVICE_PLUS_BUILD_SERVER)
	map07.put("Build-QualityGates-exop-dp-bld01", DISTRIBUTION_PLUS_BUILD_SERVER)
	map07.put("Build-QualityGates-exop-apex-bld01", APEX_BUILD_SERVER)
	map07.put("Build-QualityGates-exop-api-bld01", API_BUILD_SERVER)
	steps.put("QualityGates", map07);
	
	Map<String,String> map08 = new HashMap<String,String>();
	map08.put("Build-ShrinkDbLogsScript-exop-base-bld01", BASE_BUILD_SERVER)
	map08.put("Build-ShrinkDbLogsScript-exop-ap-bld01", ADMIN_PLUS_BUILD_SERVER)
	map08.put("Build-ShrinkDbLogsScript-exop-advp-bld01", ADVICE_PLUS_BUILD_SERVER)
	map08.put("Build-ShrinkDbLogsScript-exop-dp-bld01", DISTRIBUTION_PLUS_BUILD_SERVER)
	map08.put("Build-ShrinkDbLogsScript-exop-apex-bld01", APEX_BUILD_SERVER)
	map08.put("Build-ShrinkDbLogsScript-exop-api-bld01", API_BUILD_SERVER)
	steps.put("ShrinkDbLogsScript", map08);

	Map<String,String> map09 = new HashMap<String,String>();
	map09.put("Build-DeletePackages-exop-base-bld01", BASE_BUILD_SERVER)
	map09.put("Build-DeletePackages-exop-ap-bld01", ADMIN_PLUS_BUILD_SERVER)
	map09.put("Build-DeletePackages-exop-advp-bld01", ADVICE_PLUS_BUILD_SERVER)
	map09.put("Build-DeletePackages-exop-dp-bld01", DISTRIBUTION_PLUS_BUILD_SERVER)
	map09.put("Build-DeletePackages-exop-apex-bld01", APEX_BUILD_SERVER)
	map09.put("Build-DeletePackages-exop-api-bld01", API_BUILD_SERVER)
	steps.put("DeletePackages", map09);

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
	map06.put("Deploy-Dev001-Foresters-Exaxe-Single", FFS_DEPLOY_SERVER)
	steps.put("Deployments / Exaxe Single", map06);

	// 2. SINGLE SERVER --> CUSTOMER
	Map<String,String> map07 = new HashMap<String,String>();
	map07.put("Deploy-Dev001-Hansard-Single", HD_DEPLOY_SERVER)
	map07.put("Deploy-Dev001-Foresters-Single", FFS_DEPLOY_SERVER)
	steps.put("Deployments / Customer Single", map07);

	// 3. MULTI SERVER --> EXAXE
	Map<String,String> map08 = new HashMap<String,String>();
	map08.put("Deploy-Dev001-Hansard-Exaxe-Multi", HD_DEPLOY_SERVER)
	steps.put("Deployments / Exaxe Multi", map08);

	// 4. MULTI SERVER --> CUSTOMER
	Map<String,String> map09 = new HashMap<String,String>();
	map09.put("Deploy-Dev001-Hansard-Multi", HD_DEPLOY_SERVER)
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