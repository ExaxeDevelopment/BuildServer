class deployChannelPlusWebApi implements Serializable {
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
		//Exaxe.ChannelPlus - GetCodeLatestVersion
		Map<String,String> channelPlusWebApiGetCodeMap  = new HashMap<String,String>();
		channelPlusWebApiGetCodeMap.put("Project", "Exaxe.ChannelPlus"); 
		channelPlusWebApiGetCodeMap.put("Operation", "GetCodeLatestVersion"); 
		deploySteps.add(channelPlusWebApiGetCodeMap);

		//Exaxe.ChannelPlus - RestoreNuGetPackages
		Map<String,String> channelPlusWebApiRestoreNugetMap  = new HashMap<String,String>();
		channelPlusWebApiRestoreNugetMap.put("Project", "Exaxe.ChannelPlus"); 
		channelPlusWebApiRestoreNugetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(channelPlusWebApiRestoreNugetMap);
		
		//Exaxe.ChannelPlus - PublishWebSite
		Map<String,String> channelPlusWebApiPublishMap  = new HashMap<String,String>();
		channelPlusWebApiPublishMap.put("Project", "Exaxe.ChannelPlus"); 
		channelPlusWebApiPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(channelPlusWebApiPublishMap);

		//Release Content
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseContent"); 
		releaseContentMap.put("Operation", "ReleaseContent"); 
		deploySteps.add(releaseContentMap);
		
		//Return All of the defined steps (Broker)
		deploySteps
    }
}
