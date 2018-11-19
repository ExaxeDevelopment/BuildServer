class deployHansardsPortalsBroker implements Serializable {
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
		Map<String,String> hansardPortalBrokerGetCodeMap  = new HashMap<String,String>();
		hansardPortalBrokerGetCodeMap.put("Project", "Hansard.Portals"); 
		hansardPortalBrokerGetCodeMap.put("Operation", "GetCodeLatestVersion"); 
		deploySteps.add(hansardPortalBrokerGetCodeMap);

		//Hansard.Portals - RestoreNuGetPackages
		Map<String,String> hansardPortalBrokerRestoreNugetMap  = new HashMap<String,String>();
		hansardPortalBrokerRestoreNugetMap.put("Project", "Hansard.Portals"); 
		hansardPortalBrokerRestoreNugetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(hansardPortalBrokerRestoreNugetMap);
		
		//Hansard.Portals.Broker - PublishWebSite
		Map<String,String> hansardPortalBrokerPublishMap  = new HashMap<String,String>();
		hansardPortalBrokerPublishMap.put("Project", "Hansard.Portals.Broker"); 
		hansardPortalBrokerPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(hansardPortalBrokerPublishMap);

		//Release Content
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseContent"); 
		releaseContentMap.put("Operation", "ReleaseContent"); 
		deploySteps.add(releaseContentMap);
		
		//Return All of the defined steps (Broker)
		deploySteps
    }
}