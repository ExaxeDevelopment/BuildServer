class deployQuoteWebApi implements Serializable {
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
		//Exaxe.Quote - GetCodeLatestVersion
		Map<String,String> quoteWebApiGetCodeMap  = new HashMap<String,String>();
		quoteWebApiGetCodeMap.put("Project", "Exaxe.Quote"); 
		quoteWebApiGetCodeMap.put("Operation", "GetCodeLatestVersion"); 
		deploySteps.add(quoteWebApiGetCodeMap);

		//Exaxe.Quote - RestoreNuGetPackages
		Map<String,String> quoteWebApiRestoreNugetMap  = new HashMap<String,String>();
		quoteWebApiRestoreNugetMap.put("Project", "Exaxe.Quote"); 
		quoteWebApiRestoreNugetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(quoteWebApiRestoreNugetMap);
		
		//Exaxe.Quote - PublishWebSite
		Map<String,String> quoteWebApiPublishMap  = new HashMap<String,String>();
		quoteWebApiPublishMap.put("Project", "Exaxe.Quote"); 
		quoteWebApiPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(quoteWebApiPublishMap);

		//Release Content
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseContent"); 
		releaseContentMap.put("Operation", "ReleaseContent"); 
		deploySteps.add(releaseContentMap);
		
		//Return All of the defined steps (Broker)
		deploySteps
    }
}
