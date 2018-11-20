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
		Map<String,String> authWebApiGetCodeMap  = new HashMap<String,String>();
		authWebApiGetCodeMap.put("Project", "Exaxe.ChannelPlus"); 
		authWebApiGetCodeMap.put("Operation", "GetCodeLatestVersion"); 
		deploySteps.add(authWebApiGetCodeMap);

		//Exaxe.ChannelPlus - RestoreNuGetPackages
		Map<String,String> authWebApiRestoreNugetMap  = new HashMap<String,String>();
		authWebApiRestoreNugetMap.put("Project", "Exaxe.ChannelPlus"); 
		authWebApiRestoreNugetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(authWebApiRestoreNugetMap);
		
		//Hansard.Portals.Broker - PublishWebSite
		Map<String,String> authWebApiPublishMap  = new HashMap<String,String>();
		authWebApiPublishMap.put("Project", "Exaxe.ChannelPlus"); 
		authWebApiPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(authWebApiPublishMap);

		//Release Content
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseContent"); 
		releaseContentMap.put("Operation", "ReleaseContent"); 
		deploySteps.add(releaseContentMap);
		
		//Return All of the defined steps (Broker)
		deploySteps
    }
}
