class deployConfigurationWebApi implements Serializable {
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
		//Exaxe.Configuration - GetCodeLatestVersion
		Map<String,String> configurationWebApiGetCodeMap  = new HashMap<String,String>();
		configurationWebApiGetCodeMap.put("Project", "Exaxe.Configuration"); 
		configurationWebApiGetCodeMap.put("Operation", "GetCodeLatestVersion"); 
		deploySteps.add(configurationWebApiGetCodeMap);

		//Exaxe.Configuration - RestoreNuGetPackages
		Map<String,String> configurationWebApiRestoreNugetMap  = new HashMap<String,String>();
		configurationWebApiRestoreNugetMap.put("Project", "Exaxe.Configuration"); 
		configurationWebApiRestoreNugetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(configurationWebApiRestoreNugetMap);
		
		//Exaxe.Configuration - PublishWebSite
		Map<String,String> configurationWebApiPublishMap  = new HashMap<String,String>();
		configurationWebApiPublishMap.put("Project", "Exaxe.Configuration"); 
		configurationWebApiPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(configurationWebApiPublishMap);

		//Release Content
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseContent"); 
		releaseContentMap.put("Operation", "ReleaseContent"); 
		deploySteps.add(releaseContentMap);
		
		//Return All of the defined steps (Broker)
		deploySteps
    }
}
