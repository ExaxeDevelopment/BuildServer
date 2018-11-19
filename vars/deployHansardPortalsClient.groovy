class deployHansardPortalsClient implements Serializable {
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
		//Hansard.Portals - GetCodeLatestVersion
		Map<String,String> hansardPortalGetCodeMap  = new HashMap<String,String>();
		hansardPortalGetCodeMap.put("Project", "Hansard.Portals"); 
		hansardPortalGetCodeMap.put("Operation", "GetCodeLatestVersion"); 
		deploySteps.add(hansardPortalGetCodeMap);

		//Hansard.Portals - RestoreNuGetPackages
		Map<String,String> hansardPortalRestoreNugetMap  = new HashMap<String,String>();
		hansardPortalRestoreNugetMap.put("Project", "Hansard.Portals"); 
		hansardPortalRestoreNugetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(hansardPortalRestoreNugetMap);
		
		//Hansard.Portals.Client - PublishWebSite
		Map<String,String> hansardPortalClientPublishMap  = new HashMap<String,String>();
		hansardPortalClientPublishMap.put("Project", "Hansard.Portals"); 
		hansardPortalClientPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(hansardPortalClientPublishMap);

		//Release Content
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseContent"); 
		releaseContentMap.put("Operation", "ReleaseContent"); 
		deploySteps.add(releaseContentMap);
		
		//Return All of the defined steps
		deploySteps
    }
}








