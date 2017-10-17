class deployEpos implements Serializable {
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

		//Exaxe.SolutionManager - PublishInstallApp (UPDATE-OFFLINE)
		Map<String,String> solutionManagerPublishUpdateOfflineMap  = new HashMap<String,String>();
		solutionManagerPublishUpdateOfflineMap.put("Project", "Exaxe.SolutionManager-UpdateOffline"); 
		solutionManagerPublishUpdateOfflineMap.put("Operation", "PublishInstallApp"); 
		deploySteps.add(solutionManagerPublishUpdateOfflineMap);

		//Exaxe.Agent - BuildDatabase
		Map<String,String> agentDbMap  = new HashMap<String,String>();
		agentDbMap.put("Project", "Exaxe.Agent"); 
		agentDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(agentDbMap);

		//Exaxe.App - BuildDatabase
		Map<String,String> appDbMap  = new HashMap<String,String>();
		appDbMap.put("Project", "Exaxe.App"); 
		appDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(appDbMap);

		//Exaxe.Product.DatabaseModel - BuildDatabase
		Map<String,String> productDbMap  = new HashMap<String,String>();
		productDbMap.put("Project", "Exaxe.Product.DatabaseModel"); 
		productDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(productDbMap);

		//Exaxe.Common - BuildSolution
		Map<String,String> commonDbMap  = new HashMap<String,String>();
		commonDbMap.put("Project", "Exaxe.Common"); 
		commonDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(commonDbMap);

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

		//Exaxe.SystemConfiguration - BuildDatabase
		Map<String,String> systemConfigurationDbMap = new HashMap<String,String>();
		systemConfigurationDbMap.put("Project", "Exaxe.SystemConfiguration"); 
		systemConfigurationDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(systemConfigurationDbMap);

		//Exaxe.Client  - BuildDatabase
		Map<String,String> clientDbMap = new HashMap<String,String>();
		clientDbMap.put("Project", "Exaxe.Client "); 
		clientDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(clientDbMap);

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

		//Exaxe.ExistingBusiness - BuildDatabase
		Map<String,String> existingBusinessDbMap = new HashMap<String,String>();
		existingBusinessDbMap.put("Project", "Exaxe.ExistingBusiness"); 
		existingBusinessDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(existingBusinessDbMap);

		/// WEB SERVICES
		//Exaxe.FactFind  - PublishWebService
		Map<String,String> factFindWsPublishMap = new HashMap<String,String>();
		factFindWsPublishMap.put("Project", "Exaxe.FactFind "); 
		factFindWsPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(factFindWsPublishMap);

		/// WEB SITES
		//Exaxe.SystemConfigurationUI - GetCodeLatestVersion
		Map<String,String> systemConfigurationWsGetCodeMap  = new HashMap<String,String>();
		systemConfigurationWsGetCodeMap.put("Project", "SystemConfigurationUI"); 
		systemConfigurationWsGetCodeMap.put("Operation", "GetCodeLatestVersion"); 
		deploySteps.add(systemConfigurationWsGetCodeMap);

		//Exaxe.SystemConfigurationUI - RestoreNuGetPackages
		Map<String,String> systemConfigurationWsRestoreNuGetMap  = new HashMap<String,String>();
		systemConfigurationWsRestoreNuGetMap.put("Project", "SystemConfigurationUI"); 
		systemConfigurationWsRestoreNuGetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(systemConfigurationWsRestoreNuGetMap);

		//Exaxe.SystemConfigurationUI - PublishWebSite
		Map<String,String> systemConfigurationWsPublishMap  = new HashMap<String,String>();
		systemConfigurationWsPublishMap.put("Project", "SystemConfigurationUI"); 
		systemConfigurationWsPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(systemConfigurationWsPublishMap);

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


