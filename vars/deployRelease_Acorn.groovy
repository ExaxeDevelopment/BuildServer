class deployRelease_Acorn implements Serializable {
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

		//Exaxe.SolutionManager - Deploy
		Map<String,String> solutionManagerGetCodeMap  = new HashMap<String,String>();
		solutionManagerGetCodeMap.put("Project", "Exaxe.SolutionManager-UI"); 
		solutionManagerGetCodeMap.put("Operation", "DeployInstallApp"); 
		deploySteps.add(solutionManagerGetCodeMap);

		//Exaxe.FactFind - BuildDatabase
		Map<String,String> agentDbMap  = new HashMap<String,String>();
		agentDbMap.put("Project", "Exaxe.Agent"); 
		agentDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(agentDbMap);

		//Exaxe.Quote - BuildDatabase
		Map<String,String> quoteFFDbMap  = new HashMap<String,String>();
		quoteFFDbMap.put("Project", "Exaxe.Quote-FactFind"); 
		quoteFFDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(quoteFFDbMap);

		//Exaxe.Quote - BuildDatabase
		Map<String,String> quoteDbMap  = new HashMap<String,String>();
		quoteDbMap.put("Project", "Exaxe.Quote"); 
		quoteDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(quoteDbMap);

		//Exaxe.Auth - BuildDatabase
		Map<String,String> authDbMap  = new HashMap<String,String>();
		authDbMap.put("Project", "Exaxe.Auth"); 
		authDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(authDbMap);

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

		//Exaxe.Common - BuildDatabase
		Map<String,String> commonDbMap  = new HashMap<String,String>();
		commonDbMap.put("Project", "Exaxe.Common"); 
		commonDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(commonDbMap);

		//Exaxe.Configuration-Configuration - BuildDatabase
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

		//Exaxe.Comment - BuildDatabase
		Map<String,String> commentDbMap  = new HashMap<String,String>();
		commentDbMap.put("Project", "Exaxe.Comment"); 
		commentDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(commentDbMap);

		//Exaxe.Document - BuildDatabase
		Map<String,String> documentDbMap  = new HashMap<String,String>();
		documentDbMap.put("Project", "Exaxe.Document"); 
		documentDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(documentDbMap);

		//Exaxe.SystemConfiguration - BuildDatabase
		Map<String,String> systemConfigurationDbMap = new HashMap<String,String>();
		systemConfigurationDbMap.put("Project", "Exaxe.SystemConfiguration"); 
		systemConfigurationDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(systemConfigurationDbMap);

		//Exaxe.Accounting  - BuildDatabase
		Map<String,String> accountingDbMap = new HashMap<String,String>();
		accountingDbMap.put("Project", "Exaxe.Accounting "); 
		accountingDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(accountingDbMap);

		//Exaxe.Client  - BuildDatabase
		Map<String,String> clientDbMap = new HashMap<String,String>();
		clientDbMap.put("Project", "Exaxe.Client "); 
		clientDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(clientDbMap);

		//Exaxe.Apex  - BuildDatabase
		Map<String,String> apexDbMap = new HashMap<String,String>();
		apexDbMap.put("Project", "Exaxe.Apex "); 
		apexDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(apexDbMap);

		//Exaxe.FactFind - BuildDatabase
		Map<String,String> factFindDbMap = new HashMap<String,String>();
		factFindDbMap.put("Project", "Exaxe.FactFind"); 
		factFindDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(factFindDbMap);

		//Exaxe.ExistingBusiness - BuildDatabase
		Map<String,String> existingBusinessDbMap = new HashMap<String,String>();
		existingBusinessDbMap.put("Project", "Exaxe.ExistingBusiness"); 
		existingBusinessDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(existingBusinessDbMap);

		/// WEB SITES

		//SystemConfigurationUI - PublishWebSite
		Map<String,String> systemConfigUIPublishMap  = new HashMap<String,String>();
		systemConfigUIPublishMap.put("Project", "SystemConfigurationUI"); 
		systemConfigUIPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(systemConfigUIPublishMap);

		//PointOfSaleUI - PublishWebSite
		Map<String,String> pointSalesUIWsPublishMap  = new HashMap<String,String>();
		pointSalesUIWsPublishMap.put("Project", "PointOfSaleUI"); 
		pointSalesUIWsPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(pointSalesUIWsPublishMap);

		/// WEB SERVICES

		//Exaxe.FactFind  - PublishWebService
		Map<String,String> factFindWsPublishMap = new HashMap<String,String>();
		factFindWsPublishMap.put("Project", "Exaxe.FactFind "); 
		factFindWsPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(factFindWsPublishMap);

		//Exaxe.Auth - PublishWebService
		Map<String,String> authWebApiPublishMap  = new HashMap<String,String>();
		authWebApiPublishMap.put("Project", "Exaxe.Auth-WebAPI"); 
		authWebApiPublishMap.put("Operation", "DeployWebApi"); 
		deploySteps.add(authWebApiPublishMap);

		//Exaxe.Apex.Workflow  - PublishWebService
		Map<String,String> apexWorkflowPublishMap = new HashMap<String,String>();
		apexWorkflowPublishMap.put("Project", "Exaxe.Apex.Workflow-WebAPI"); 
		apexWorkflowPublishMap.put("Operation", "DeployWebApi"); 
		deploySteps.add(apexWorkflowPublishMap);

		//Exaxe.Apex.Server  - PublishWebService
		Map<String,String> apexServerPublishMap = new HashMap<String,String>();
		apexServerPublishMap.put("Project", "Exaxe.Apex.Server"); 
		apexServerPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(apexServerPublishMap);

		//Release Content
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseContent"); 
		releaseContentMap.put("Operation", "ReleaseContent"); 
		deploySteps.add(releaseContentMap);
		
		//Return All of the defined steps
		deploySteps
    }
}