class deployAggregateWebApi implements Serializable {
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
		//Exaxe.Aggregate - GetCodeLatestVersion
		Map<String,String> aggregateWebApiGetCodeMap  = new HashMap<String,String>();
		aggregateWebApiGetCodeMap.put("Project", "Exaxe.Aggregate"); 
		aggregateWebApiGetCodeMap.put("Operation", "GetCodeLatestVersion"); 
		deploySteps.add(aggregateWebApiGetCodeMap);

		//Exaxe.Aggregate - RestoreNuGetPackages
		Map<String,String> aggregateWebApiRestoreNugetMap  = new HashMap<String,String>();
		aggregateWebApiRestoreNugetMap.put("Project", "Exaxe.Aggregate"); 
		aggregateWebApiRestoreNugetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(aggregateWebApiRestoreNugetMap);
		
		//Exaxe.Aggregate - PublishWebSite
		Map<String,String> aggregateWebApiPublishMap  = new HashMap<String,String>();
		aggregateWebApiPublishMap.put("Project", "Exaxe.Aggregate"); 
		aggregateWebApiPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(aggregateWebApiPublishMap);

		//Release Content
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseContent"); 
		releaseContentMap.put("Operation", "ReleaseContent"); 
		deploySteps.add(releaseContentMap);
		
		//Return All of the defined steps (Broker)
		deploySteps
    }
}
