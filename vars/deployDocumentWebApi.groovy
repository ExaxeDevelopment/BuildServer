class deployDocumentWebApi implements Serializable {
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
		//Exaxe.Document - GetCodeLatestVersion
		Map<String,String> documentWebApiGetCodeMap  = new HashMap<String,String>();
		documentWebApiGetCodeMap.put("Project", "Exaxe.Document"); 
		documentWebApiGetCodeMap.put("Operation", "GetCodeLatestVersion"); 
		deploySteps.add(documentWebApiGetCodeMap);

		//Exaxe.Document - RestoreNuGetPackages
		Map<String,String> documentWebApiRestoreNugetMap  = new HashMap<String,String>();
		documentWebApiRestoreNugetMap.put("Project", "Exaxe.Document"); 
		documentWebApiRestoreNugetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(documentWebApiRestoreNugetMap);
		
		//Exaxe.Document - PublishWebSite
		Map<String,String> documentWebApiPublishMap  = new HashMap<String,String>();
		documentWebApiPublishMap.put("Project", "Exaxe.Document"); 
		documentWebApiPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(documentWebApiPublishMap);

		//Release Content
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseContent"); 
		releaseContentMap.put("Operation", "ReleaseContent"); 
		deploySteps.add(releaseContentMap);
		
		//Return All of the defined steps (Broker)
		deploySteps
    }
}
