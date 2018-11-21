class deployClientWebApi implements Serializable {
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
		//Exaxe.Client - GetCodeLatestVersion
		Map<String,String> clientWebApiGetCodeMap  = new HashMap<String,String>();
		clientWebApiGetCodeMap.put("Project", "Exaxe.Client"); 
		clientWebApiGetCodeMap.put("Operation", "GetCodeLatestVersion"); 
		deploySteps.add(clientWebApiGetCodeMap);

		//Exaxe.Client - RestoreNuGetPackages
		Map<String,String> clientWebApiRestoreNugetMap  = new HashMap<String,String>();
		clientWebApiRestoreNugetMap.put("Project", "Exaxe.Client"); 
		clientWebApiRestoreNugetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(clientWebApiRestoreNugetMap);
		
		//Hansard.Portals.Broker - PublishWebSite
		Map<String,String> clientWebApiPublishMap  = new HashMap<String,String>();
		clientWebApiPublishMap.put("Project", "Exaxe.Client"); 
		clientWebApiPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(clientWebApiPublishMap);

		//Release Content
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseContent"); 
		releaseContentMap.put("Operation", "ReleaseContent"); 
		deploySteps.add(releaseContentMap);
		
		//Return All of the defined steps (Broker)
		deploySteps
    }
}
