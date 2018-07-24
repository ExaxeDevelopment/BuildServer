class deployChannelPlus implements Serializable {
    def getDeploySteps() { 

		List deploySteps = new ArrayList<Map<String,String>>();

		//Initialisation
		Map<String,String> initialisationMap  = new HashMap<String,String>();
		initialisationMap.put("Project", "Initialisation"); 
		initialisationMap.put("Operation", "Initialisation"); 
		deploySteps.add(initialisationMap);

		//GetAllCodeLatestVersion
		Map<String,String> getAllCodeMap  = new HashMap<String,String>();
		getAllCodeMap.put("Project", "GetAllCodeLatestVersion"); 
		getAllCodeMap.put("Operation", "GetAllCodeLatestVersion"); 
		deploySteps.add(getAllCodeMap);

		//Exaxe.SolutionManager - GetCodeLatestVersion
		Map<String,String> solutionManagerGetCodeMap  = new HashMap<String,String>();
		solutionManagerGetCodeMap.put("Project", "Exaxe.SolutionManager-Update"); 
		solutionManagerGetCodeMap.put("Operation", "GetCodeLatestVersion"); 
		deploySteps.add(solutionManagerGetCodeMap);

		//Exaxe.SolutionManager - RestoreNuGetPackages
		Map<String,String> solutionManagerRestoreNuGetMap  = new HashMap<String,String>();
		solutionManagerRestoreNuGetMap.put("Project", "Exaxe.SolutionManager-Update"); 
		solutionManagerRestoreNuGetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(solutionManagerRestoreNuGetMap);

		//Exaxe.SolutionManager - BuildSolution
		Map<String,String> solutionManagerBuildMap  = new HashMap<String,String>();
		solutionManagerBuildMap.put("Project", "Exaxe.SolutionManager-Update"); 
		solutionManagerBuildMap.put("Operation", "BuildSolution"); 
		deploySteps.add(solutionManagerBuildMap);

		//Exaxe.SolutionManager - PublishInstallApp (UPDATE)
		Map<String,String> solutionManagerPublishUpdateMap  = new HashMap<String,String>();
		solutionManagerPublishUpdateMap.put("Project", "Exaxe.SolutionManager-Update"); 
		solutionManagerPublishUpdateMap.put("Operation", "PublishInstallApp"); 
		deploySteps.add(solutionManagerPublishUpdateMap);

		//Exaxe.SolutionManager - PublishInstallApp (CREATE)
		Map<String,String> solutionManagerPublishCreateMap  = new HashMap<String,String>();
		solutionManagerPublishCreateMap.put("Project", "Exaxe.SolutionManager-Create"); 
		solutionManagerPublishCreateMap.put("Operation", "PublishInstallApp"); 
		deploySteps.add(solutionManagerPublishCreateMap);

		//Exaxe.Product.DatabaseModel - BuildDatabase
		Map<String,String> productDbMap  = new HashMap<String,String>();
		productDbMap.put("Project", "Exaxe.Product.DatabaseModel"); 
		productDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(productDbMap);

		//Exaxe.Common - BuildDatabase
		Map<String,String> commonDbMap  = new HashMap<String,String>();
		commonDbMap.put("Project", "Exaxe.Common"); 
		commonDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(commonDbMap);

		//Exaxe.Configuration-Configuration - BuildDatabase
		Map<String,String> configurationDbMap  = new HashMap<String,String>();
		configurationDbMap.put("Project", "Exaxe.Configuration-Configuration"); 
		configurationDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(configurationDbMap);

		//Exaxe.SystemConfiguration - BuildDatabase
		Map<String,String> systemConfigurationDbMap = new HashMap<String,String>();
		systemConfigurationDbMap.put("Project", "Exaxe.SystemConfiguration"); 
		systemConfigurationDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(systemConfigurationDbMap);

		//Exaxe.ChannelPlus  - BuildDatabase
		Map<String,String> clientDbMap = new HashMap<String,String>();
		clientDbMap.put("Project", "Exaxe.ChannelPlus "); 
		clientDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(clientDbMap);

		/// WEB SITES
		//Exaxe.SystemConfigurationUI - GetCodeLatestVersion
		Map<String,String> systemConfigurationWsGetCodeMap  = new HashMap<String,String>();
		systemConfigurationWsGetCodeMap.put("Project", "SystemConfigurationUI"); 
		systemConfigurationWsGetCodeMap.put("Operation", "GetCodeLatestVersion"); 
		deploySteps.add(systemConfigurationWsGetCodeMap);

		//Exaxe.SystemConfigurationUI - RestoreNuGetPackages
		Map<String,String> systemConfigurationWsRestoreNuGetMap  = new HashMap<String,String>();
		systemConfigurationWsRestoreNuGetMap.put("Project", "SystemConfigurationUI"); 
		systemConfigurationWsRestoreNuGetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(systemConfigurationWsRestoreNuGetMap);

		//Exaxe.SystemConfigurationUI - PublishWebSite
		Map<String,String> systemConfigurationWsPublishMap  = new HashMap<String,String>();
		systemConfigurationWsPublishMap.put("Project", "SystemConfigurationUI"); 
		systemConfigurationWsPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(systemConfigurationWsPublishMap);

		//ChannelPlusUI- GetCodeLatestVersion
		Map<String,String> channelPlusUIWsGetCodeMap  = new HashMap<String,String>();
		channelPlusUIWsGetCodeMap.put("Project", "ChannelPlusUI"); 
		channelPlusUIWsGetCodeMap.put("Operation", "GetCodeLatestVersion"); 
		deploySteps.add(channelPlusUIWsGetCodeMap);

		//ChannelPlusUI - RestoreNuGetPackages
		Map<String,String> channelPlusUIWsRestoreNuGetMap  = new HashMap<String,String>();
		channelPlusUIWsRestoreNuGetMap.put("Project", "ChannelPlusUI"); 
		channelPlusUIWsRestoreNuGetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(channelPlusUIWsRestoreNuGetMap);

		//ChannelPlusUI - PublishWebSite
		Map<String,String> channelPlusUIWsPublishMap  = new HashMap<String,String>();
		channelPlusUIWsPublishMap.put("Project", "ChannelPlusUI"); 
		channelPlusUIWsPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(channelPlusUIWsPublishMap);

		//Release Content
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseContent"); 
		releaseContentMap.put("Operation", "ReleaseContent"); 
		deploySteps.add(releaseContentMap);

		//Return All of the defined steps
		deploySteps
	}
}


