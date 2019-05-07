import hudson.Util;

def duration = "";

try{
	
	node {
		stage("Orchestration - Development"){

			// GLOBAL PROPERTIES
			def remoteToken = REMOTE_TOKEN	
			def baseBuildServer = BASE_BUILD_SERVER
			def adminPlusBuildServer = ADMIN_PLUS_BUILD_SERVER
			def advicePlusBuildServer = ADVICE_PLUS_BUILD_SERVER
			def distribuitionPlusBuildServer = DISTRIBUTION_PLUS_BUILD_SERVER
			def apexBuildServer = APEX_BUILD_SERVER
			def apiBuildServer = API_BUILD_SERVER

			//// BASE/COMMON
			def parallelBuildJobs = [:] 

			def baseBuildStage = "MasterBuild-Base-Dev001";
			parallelBuildJobs [baseBuildStage] = getRemoteJobRequest(baseBuildServer, baseBuildStage, remoteToken)
		
			parallel parallelBuildJobs;

			parallelBuildJobs = [:] 	

			//// ADMIN PLUS 		
			def adminPlusBuildStage = "MasterBuild-AdminPlus-Dev002";
			parallelBuildJobs [adminPlusBuildStage] = getRemoteJobRequest(adminPlusBuildServer, adminPlusBuildStage, remoteToken)
	
			//// ADVICE PLUS 		
			def advicePlusBuildStage = "MasterBuild-AdvicePlus-Dev002";
			parallelBuildJobs [advicePlusBuildStage] = getRemoteJobRequest(advicePlusBuildServer, advicePlusBuildStage, remoteToken)
		
			//// DISTRIBUTION PLUS 		
			def distributionPlusBuildStage = "MasterBuild-ChannelPlus-Dev002";
			parallelBuildJobs [distributionPlusBuildStage] = getRemoteJobRequest(distribuitionPlusBuildServer, distributionPlusBuildStage, remoteToken)
		
			//// POLICY EBI (AVIVA) 		
			def policyEbiBuildStage = "MasterBuild-PolicyEBI-Dev001";
			parallelBuildJobs [policyEbiBuildStage] = getRemoteJobRequest(baseBuildServer, policyEbiBuildStage, remoteToken)		
		
			parallel parallelBuildJobs;
				
			parallelBuildJobs = [:] 	

			//// APEX 
			def apexBuildStage = "MasterBuild-Apex-Dev002";
			parallelBuildJobs [apexBuildStage] = getRemoteJobRequest(apexBuildServer, apexBuildStage, remoteToken)		
		
			parallel parallelBuildJobs;
		
			parallelBuildJobs = [:] 	

			//// WEB SERVICES 
			def apiBuildStage = "Build-Exaxe.WebApi-Dev002";
			parallelBuildJobs [apiBuildStage] = getRemoteJobRequest(apiBuildServer, apiBuildStage, remoteToken)		

			def wcfBuildStage = "Build-Exaxe.WcfService-Dev002";
			parallelBuildJobs [wcfBuildStage] = getRemoteJobRequest(apiBuildServer, wcfBuildStage, remoteToken)		
		
			parallel parallelBuildJobs;
		
			parallelBuildJobs = [:] 	

			//// WEB SITES 			
			def pdaSiteBuildStage = "Build-Exaxe.ProductDevelopment.UI-Dev001";
			parallelBuildJobs [pdaSiteBuildStage] = getRemoteJobRequest(baseBuildServer, pdaSiteBuildStage, remoteToken)		

			def sysConfigurationSiteBuildStage = "Build-SystemConfigurationUI-Dev002";
			parallelBuildJobs [sysConfigurationSiteBuildStage] = getRemoteJobRequest(baseBuildServer, sysConfigurationSiteBuildStage, remoteToken)		

			def adminPlusSiteBuildStage = "Build-AdminPlusUI-Dev002";
			parallelBuildJobs [adminPlusSiteBuildStage] = getRemoteJobRequest(adminPlusBuildServer, adminPlusSiteBuildStage, remoteToken)		

			def advicePlusSiteBuildStage = "Build-PointOfSaleUI-Dev002";
			parallelBuildJobs [advicePlusSiteBuildStage] = getRemoteJobRequest(advicePlusBuildServer, advicePlusSiteBuildStage, remoteToken)		
		
			def distributionPlusSiteBuildStage = "Build-ChannelPlusUI-Dev002";
			parallelBuildJobs [distributionPlusSiteBuildStage] = getRemoteJobRequest(distribuitionPlusBuildServer, distributionPlusSiteBuildStage, remoteToken)

			def exaxePortalsBuildStage = "Build-Exaxe.Portals-Dev002";
			parallelBuildJobs [exaxePortalsBuildStage] = getRemoteJobRequest(apexBuildServer, exaxePortalsBuildStage, remoteToken)
	
			def hansardPortalsBuildStage = "Build-Hansard.Portals-Dev002";
			parallelBuildJobs [hansardPortalsBuildStage] = getRemoteJobRequest(apexBuildServer, hansardPortalsBuildStage, remoteToken)
			
			parallel parallelBuildJobs;		

			parallelBuildJobs = [:] 	

			//// DEPLOYMENTS 	
			
			currentBuild.result = "SUCCESS";
		
			duration = "Build duration: ${Util.getTimeSpanString(System.currentTimeMillis() - currentBuild.startTimeInMillis)}";
		
			try{
				stage("Success Notification"){
					echo duration;
				
					mail to: "${ricardo.bicho@majesco.com}", 
					subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
					body: "${env.BUILD_URL} \r\n ${duration} \r\n Build Type: ${buildTypeAction}" 
				}
			}
			catch(err){
				echo "Notification stage failed, but build was successful.";
				echo "Error: ${err}"
			}
		}
	} // END NODE

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
}
catch(err){
    echo "Build Failed...";
	
    currentBuild.result = "FAILURE";
	
    node{
        stage("Error Notification"){
            mail to: "${ricardo.bicho@majesco.com}", 
            subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
            body: "The deployment failed \r\nError: ${err} \r\nURL: ${env.BUILD_URL}"
        }
    }	
}