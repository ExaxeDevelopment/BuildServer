class deployWebApi implements Serializable {
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

		//Exaxe.Common - BuildDatabase
		Map<String,String> commonDbMap  = new HashMap<String,String>();
		commonDbMap.put("Project", "Exaxe.Common"); 
		commonDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(commonDbMap);

		//Exaxe.Configuration-Configuration - BuildDatabase
		Map<String,String> configurationDbMap  = new HashMap<String,String>();
		configurationDbMap.put("Project", "Exaxe.Configuration"); 
		configurationDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(configurationDbMap);

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
		clientDbMap.put("Project", "Exaxe.Client"); 
		clientDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(clientDbMap);

		//Exaxe.AdminPlus - BuildDatabase
		Map<String,String> adminPlusDbMap = new HashMap<String,String>();
		adminPlusDbMap.put("Project", "Exaxe.AdminPlus"); 
		adminPlusDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(adminPlusDbMap);

		//Exaxe.Apex  - BuildDatabase
		Map<String,String> apexDbMap = new HashMap<String,String>();
		apexDbMap.put("Project", "Exaxe.Apex "); 
		apexDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(apexDbMap);

		//Exaxe.FactFind - BuildDatabase
		Map<String,String> factFindDbMap  = new HashMap<String,String>();
		factFindDbMap.put("Project", "Exaxe.FactFind"); 
		factFindDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(factFindDbMap);

		//Exaxe.Quote - BuildDatabase
		Map<String,String> quoteDbMap  = new HashMap<String,String>();
		quoteDbMap.put("Project", "Exaxe.Quote"); 
		quoteDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(quoteDbMap);

		//Exaxe.ChannelPlus - BuildDatabase
		Map<String,String> channelPlusDbMap  = new HashMap<String,String>();
		channelPlusDbMap.put("Project", "Exaxe.ChannelPlus"); 
		channelPlusDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(channelPlusDbMap);

		//Exaxe.Auth - BuildDatabase
		Map<String,String> authDbMap  = new HashMap<String,String>();
		authDbMap.put("Project", "Exaxe.Auth"); 
		authDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(authDbMap);

		/// WEB Apis

		//Exaxe.External - RestoreNuGetPackages
		Map<String,String> externalWebApiRestoreMap  = new HashMap<String,String>();
		externalWebApiRestoreMap.put("Project", "Exaxe.External"); 
		externalWebApiRestoreMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(externalWebApiRestoreMap);

		//Exaxe.External - PublishWebService
		Map<String,String> externalWebApiPublishMap  = new HashMap<String,String>();
		externalWebApiPublishMap.put("Project", "Exaxe.External"); 
		externalWebApiPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(externalWebApiPublishMap);

		//Exaxe.Document - RestoreNuGetPackages
		Map<String,String> documentWebApiRestoreMap  = new HashMap<String,String>();
		documentWebApiRestoreMap.put("Project", "Exaxe.Document"); 
		documentWebApiRestoreMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(documentWebApiRestoreMap);

		//Exaxe.Document - PublishWebService
		Map<String,String> documenthWebApiPublishMap  = new HashMap<String,String>();
		documenthWebApiPublishMap.put("Project", "Exaxe.Document"); 
		documenthWebApiPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(documenthWebApiPublishMap);

	    //Exaxe.Configuration - RestoreNuGetPackages
		Map<String,String> configurationRestoreNuGetMap  = new HashMap<String,String>();
		configurationRestoreNuGetMap.put("Project", "Exaxe.Configuration"); 
		configurationRestoreNuGetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(configurationRestoreNuGetMap);

		//Exaxe.Configuration - PublishWebService
		Map<String,String> configurationWsPublishMap = new HashMap<String,String>();
		configurationWsPublishMap.put("Project", "Exaxe.Configuration"); 
		configurationWsPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(configurationWsPublishMap);

		//Exaxe.SystemConfiguration - RestoreNuGetPackages
		Map<String,String> sysConfigurationWebApiRestoreMap  = new HashMap<String,String>();
		sysConfigurationWebApiRestoreMap.put("Project", "Exaxe.SystemConfiguration"); 
		sysConfigurationWebApiRestoreMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(sysConfigurationWebApiRestoreMap);

		//Exaxe.SystemConfiguration - PublishWebService
		Map<String,String> sysConfigurationWebApiPublishMap  = new HashMap<String,String>();
		sysConfigurationWebApiPublishMap.put("Project", "Exaxe.SystemConfiguration"); 
		sysConfigurationWebApiPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(sysConfigurationWebApiPublishMap);

		//Exaxe.Users - RestoreNuGetPackages
		Map<String,String> usersWebApiRestoreMap  = new HashMap<String,String>();
		usersWebApiRestoreMap.put("Project", "Exaxe.Users"); 
		usersWebApiRestoreMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(usersWebApiRestoreMap);

		//Exaxe.Users - PublishWebService
		Map<String,String> usersWebApiPublishMap  = new HashMap<String,String>();
		usersWebApiPublishMap.put("Project", "Exaxe.Users"); 
		usersWebApiPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(usersWebApiPublishMap);

		//Exaxe.Client  - RestoreNuGetPackages
		Map<String,String> clientWsRestoreMap = new HashMap<String,String>();
		clientWsRestoreMap.put("Project", "Exaxe.Client"); 
		clientWsRestoreMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(clientWsRestoreMap);

		//Exaxe.Client  - PublishWebService
		Map<String,String> clientWsPublishMap = new HashMap<String,String>();
		clientWsPublishMap.put("Project", "Exaxe.Client"); 
		clientWsPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(clientWsPublishMap);

		//Exaxe.AdminPlus  - RestoreNuGetPackages
		Map<String,String> policyWsRestoreMap = new HashMap<String,String>();
		policyWsRestoreMap.put("Project", "Exaxe.AdminPlus"); 
		policyWsRestoreMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(policyWsRestoreMap);

		//Exaxe.AdminPlus  - PublishWebService
		Map<String,String> policyWsPublishMap = new HashMap<String,String>();
		policyWsPublishMap.put("Project", "Exaxe.AdminPlus"); 
		policyWsPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(policyWsPublishMap);

		//Exaxe.Apex  - RestoreNuGetPackages
		Map<String,String> apexWsRestoreMap = new HashMap<String,String>();
		apexWsRestoreMap.put("Project", "Exaxe.Apex"); 
		apexWsRestoreMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(apexWsRestoreMap);

		//Exaxe.Apex  - PublishWebService
		Map<String,String> apexWsPublishMap = new HashMap<String,String>();
		apexWsPublishMap.put("Project", "Exaxe.Apex"); 
		apexWsPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(apexWsPublishMap);

		//Exaxe.Aggregate  - RestoreNuGetPackages
		Map<String,String> aggregateWsRestoreMap = new HashMap<String,String>();
		aggregateWsRestoreMap.put("Project", "Exaxe.Aggregate"); 
		aggregateWsRestoreMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(aggregateWsRestoreMap);

		//Exaxe.Aggregate  - PublishWebService
		Map<String,String> aggregateWsPublishMap = new HashMap<String,String>();
		aggregateWsPublishMap.put("Project", "Exaxe.Aggregate"); 
		aggregateWsPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(aggregateWsPublishMap);

		//Exaxe.Quote - RestoreNuGetPackages
		Map<String,String> quoteWebApiRestoreMap  = new HashMap<String,String>();
		quoteWebApiRestoreMap.put("Project", "Exaxe.Quote"); 
		quoteWebApiRestoreMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(quoteWebApiRestoreMap);

		//Exaxe.Quote - PublishWebService
		Map<String,String> quotehWebApiPublishMap  = new HashMap<String,String>();
		quotehWebApiPublishMap.put("Project", "Exaxe.Quote"); 
		quotehWebApiPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(quotehWebApiPublishMap);

		//Exaxe.ChannelPlus - RestoreNuGetPackages
		Map<String,String> channelPlusWebApiRestoreMap  = new HashMap<String,String>();
		channelPlusWebApiRestoreMap.put("Project", "Exaxe.ChannelPlus"); 
		channelPlusWebApiRestoreMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(channelPlusWebApiRestoreMap);

		//Exaxe.ChannelPlus - PublishWebService
		Map<String,String> channelPlusWebApiPublishMap  = new HashMap<String,String>();
		channelPlusWebApiPublishMap.put("Project", "Exaxe.ChannelPlus"); 
		channelPlusWebApiPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(channelPlusWebApiPublishMap);

		//Exaxe.Auth - RestoreNuGetPackages
		Map<String,String> authWebApiRestoreMap  = new HashMap<String,String>();
		authWebApiRestoreMap.put("Project", "Exaxe.Auth"); 
		authWebApiRestoreMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(authWebApiRestoreMap);

		//Exaxe.Auth - PublishWebService
		Map<String,String> authhWebApiPublishMap  = new HashMap<String,String>();
		authhWebApiPublishMap.put("Project", "Exaxe.Auth"); 
		authhWebApiPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(authhWebApiPublishMap);

		//Exaxe.Apex.Workflow  - RestoreNuGetPackages
		Map<String,String> apexWorkflowRestoreMap = new HashMap<String,String>();
		apexWorkflowRestoreMap.put("Project", "Exaxe.Apex.Workflow"); 
		apexWorkflowRestoreMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(apexWorkflowRestoreMap);

		//Exaxe.Apex.Workflow  - PublishWebService
		Map<String,String> apexWorkflowPublishMap = new HashMap<String,String>();
		apexWorkflowPublishMap.put("Project", "Exaxe.Apex.Workflow"); 
		apexWorkflowPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(apexWorkflowPublishMap);

		//Exaxe.Apex.Server  - RestoreNuGetPackages
		Map<String,String> apexServerRestoreMap = new HashMap<String,String>();
		apexServerRestoreMap.put("Project", "Exaxe.Apex.Server"); 
		apexServerRestoreMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(apexServerRestoreMap);

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