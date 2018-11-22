class deployHansardPortals implements Serializable {
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

		/// WEB SITES
		//Hansard.Portals - RestoreNuGetPackages
		Map<String,String> hansardPortalRestoreNugetMap  = new HashMap<String,String>();
		hansardPortalRestoreNugetMap.put("Project", "Hansard.Portals"); 
		hansardPortalRestoreNugetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(hansardPortalRestoreNugetMap);
		
		//Hansard.Portals - PublishWebSite
		Map<String,String> hansardPortalPublishMap  = new HashMap<String,String>();
		hansardPortalPublishMap.put("Project", "Hansard.Portals"); 
		hansardPortalPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(hansardPortalPublishMap);

		//Release Content
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseContent"); 
		releaseContentMap.put("Operation", "ReleaseContent"); 
		deploySteps.add(releaseContentMap);
		
		//Return All of the defined steps
		deploySteps
    }
}
