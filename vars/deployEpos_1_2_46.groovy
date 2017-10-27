class deployEpos_1_2_46 implements Serializable {
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
		
		//Exaxe.Configuration-Configuration - BuildSolution
		Map<String,String> configurationDbMap  = new HashMap<String,String>();
		configurationDbMap.put("Project", "Exaxe.Configuration-Configuration"); 
		configurationDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(configurationDbMap);

		//Exaxe.Configuration-Question - BuildDatabase
		Map<String,String> configurationQuestionDbMap = new HashMap<String,String>();
		configurationQuestionDbMap.put("Project", "Exaxe.Configuration-Question"); 
		configurationQuestionDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(configurationQuestionDbMap);

		//Exaxe.Configuration-Reference - BuildDatabase
		Map<String,String> configurationReferenceDbMap = new HashMap<String,String>();
		configurationReferenceDbMap.put("Project", "Exaxe.Configuration-Reference"); 
		configurationReferenceDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(configurationReferenceDbMap);

		//Exaxe.FactFind - BuildDatabase
		Map<String,String> factFindDbMap = new HashMap<String,String>();
		factFindDbMap.put("Project", "Exaxe.FactFind"); 
		factFindDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(factFindDbMap);

		//Exaxe.Quote  - BuildDatabase
		Map<String,String> quoteDbMap = new HashMap<String,String>();
		quoteDbMap.put("Project", "Exaxe.Quote "); 
		quoteDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(quoteDbMap);

		/// WEB SERVICES
		//Exaxe.FactFind  - PublishWebService
		Map<String,String> factFindWsPublishMap = new HashMap<String,String>();
		factFindWsPublishMap.put("Project", "Exaxe.FactFind "); 
		factFindWsPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(factFindWsPublishMap);

		//PointOfSaleUI- GetCodeLatestVersion
		Map<String,String> pointSalesUIWsGetCodeMap  = new HashMap<String,String>();
		pointSalesUIWsGetCodeMap.put("Project", "PointOfSaleUI"); 
		pointSalesUIWsGetCodeMap.put("Operation", "GetCodeLatestVersion"); 
		deploySteps.add(pointSalesUIWsGetCodeMap);

		//PointOfSaleUI - RestoreNuGetPackages
		Map<String,String> pointSalesUIWsRestoreNuGetMap  = new HashMap<String,String>();
		pointSalesUIWsRestoreNuGetMap.put("Project", "PointOfSaleUI"); 
		pointSalesUIWsRestoreNuGetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(pointSalesUIWsRestoreNuGetMap);

		//PointOfSaleUI - PublishWebSite
		Map<String,String> pointSalesUIWsPublishMap  = new HashMap<String,String>();
		pointSalesUIWsPublishMap.put("Project", "PointOfSaleUI"); 
		pointSalesUIWsPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(pointSalesUIWsPublishMap);

		//Release Content
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseContent"); 
		releaseContentMap.put("Operation", "ReleaseContent"); 
		deploySteps.add(releaseContentMap);

		//Return All of the defined steps
		deploySteps
	}
}


