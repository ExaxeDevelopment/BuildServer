class deployChannelPlusUI implements Serializable {
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

		/// WEB SITES
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


