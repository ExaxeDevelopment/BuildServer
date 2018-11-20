class deployAuthWebApi implements Serializable {
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
		//Exaxe.Auth - GetCodeLatestVersion
		Map<String,String> AuthWebApiGetCodeMap  = new HashMap<String,String>();
		AuthWebApiGetCodeMap.put("Project", "Exaxe.Auth"); 
		AuthWebApiGetCodeMap.put("Operation", "GetCodeLatestVersion"); 
		deploySteps.add(AuthWebApiGetCodeMap);

		//Exaxe.Auth - RestoreNuGetPackages
		Map<String,String> AuthWebApiRestoreNugetMap  = new HashMap<String,String>();
		AuthWebApiRestoreNugetMap.put("Project", "Exaxe.Auth"); 
		AuthWebApiRestoreNugetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(AuthWebApiRestoreNugetMap);
		
		//Hansard.Portals.Broker - PublishWebSite
		Map<String,String> AuthWebApiPublishMap  = new HashMap<String,String>();
		AuthWebApiPublishMap.put("Project", "Exaxe.Auth"); 
		AuthWebApiPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(AuthWebApiPublishMap);

		//Release Content
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseContent"); 
		releaseContentMap.put("Operation", "ReleaseContent"); 
		deploySteps.add(releaseContentMap);
		
		//Return All of the defined steps (Broker)
		deploySteps
    }
}
