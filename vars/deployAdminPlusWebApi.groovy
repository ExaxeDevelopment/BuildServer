class deployAdminPlusWebApi implements Serializable {
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
		//Exaxe.AdminPlus - GetCodeLatestVersion
		Map<String,String> adminPlusWebApiGetCodeMap  = new HashMap<String,String>();
		adminPlusWebApiGetCodeMap.put("Project", "Exaxe.AdminPlus"); 
		adminPlusWebApiGetCodeMap.put("Operation", "GetCodeLatestVersion"); 
		deploySteps.add(adminPlusWebApiGetCodeMap);

		//Exaxe.AdminPlus - RestoreNuGetPackages
		Map<String,String> adminPlusWebApiRestoreNugetMap  = new HashMap<String,String>();
		adminPlusWebApiRestoreNugetMap.put("Project", "Exaxe.AdminPlus"); 
		adminPlusWebApiRestoreNugetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(adminPlusWebApiRestoreNugetMap);
		
		//Hansard.Portals.Broker - PublishWebSite
		Map<String,String> adminPlusWebApiPublishMap  = new HashMap<String,String>();
		adminPlusWebApiPublishMap.put("Project", "Exaxe.AdminPlus"); 
		adminPlusWebApiPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(adminPlusWebApiPublishMap);

		//Release Content
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseContent"); 
		releaseContentMap.put("Operation", "ReleaseContent"); 
		deploySteps.add(releaseContentMap);
		
		//Return All of the defined steps (Broker)
		deploySteps
    }
}
