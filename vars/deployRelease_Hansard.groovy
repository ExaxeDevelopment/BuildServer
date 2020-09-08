class deployRelease_Hansard implements Serializable {
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

		//Exaxe.Agent - BuildDatabase
		Map<String,String> quoteDbMap  = new HashMap<String,String>();
		quoteDbMap.put("Project", "Exaxe.Quote"); 
		quoteDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(quoteDbMap);

		Map<String,String> quoteFFDbMap  = new HashMap<String,String>();
		quoteFFDbMap.put("Project", "Exaxe.Quote-FactFind"); 
		quoteFFDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(quoteFFDbMap);

		//Exaxe.Agent - BuildDatabase
		Map<String,String> authDbMap  = new HashMap<String,String>();
		authDbMap.put("Project", "Exaxe.Auth"); 
		authDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(authDbMap);

		//Exaxe.ChannelPlus - BuildDatabase
		Map<String,String> channelPlusDbMap  = new HashMap<String,String>();
		channelPlusDbMap.put("Project", "Exaxe.ChannelPlus"); 
		channelPlusDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(channelPlusDbMap);

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

		/// WEB SERVICES

		//Exaxe.Aggregate  - PublishWebService
		Map<String,String> aggregateWsPublishMap = new HashMap<String,String>();
		aggregateWsPublishMap.put("Project", "Exaxe.Aggregate"); 
		aggregateWsPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(aggregateWsPublishMap);

		Map<String,String> aggregateWebAPIPublishMap = new HashMap<String,String>();
		aggregateWebAPIPublishMap.put("Project", "Exaxe.Aggregate-WebAPI"); 
		aggregateWebAPIPublishMap.put("Operation", "DeployWebApi"); 
		deploySteps.add(aggregateWebAPIPublishMap);

		Map<String,String> apexWebAPIPublishMap = new HashMap<String,String>();
		apexWebAPIPublishMap.put("Project", "Exaxe.Apex-WebAPI"); 
		apexWebAPIPublishMap.put("Operation", "DeployWebApi"); 
		deploySteps.add(apexWebAPIPublishMap);

		Map<String,String> clientWebAPIPublishMap = new HashMap<String,String>();
		clientWebAPIPublishMap.put("Project", "Exaxe.Client-WebAPI"); 
		clientWebAPIPublishMap.put("Operation", "DeployWebApi"); 
		deploySteps.add(clientWebAPIPublishMap);

		Map<String,String> configurationWebAPIPublishMap = new HashMap<String,String>();
		configurationWebAPIPublishMap.put("Project", "Exaxe.Configuration-WebAPI"); 
		configurationWebAPIPublishMap.put("Operation", "DeployWebApi"); 
		deploySteps.add(configurationWebAPIPublishMap);

		Map<String,String> policyWebAPIPublishMap = new HashMap<String,String>();
		policyWebAPIPublishMap.put("Project", "Exaxe.AdminPlus-WebAPI"); 
		policyWebAPIPublishMap.put("Operation", "DeployWebApi"); 
		deploySteps.add(policyWebAPIPublishMap);

		//Exaxe.External - PublishWebService
		Map<String,String> externalWebApiPublishMap  = new HashMap<String,String>();
		externalWebApiPublishMap.put("Project", "Exaxe.External-WebAPI"); 
		externalWebApiPublishMap.put("Operation", "DeployWebApi"); 
		deploySteps.add(externalWebApiPublishMap);

		//Exaxe.Document - PublishWebService
		Map<String,String> documenthWebApiPublishMap  = new HashMap<String,String>();
		documenthWebApiPublishMap.put("Project", "Exaxe.Document-WebAPI"); 
		documenthWebApiPublishMap.put("Operation", "DeployWebApi"); 
		deploySteps.add(documenthWebApiPublishMap);

		//Exaxe.Configuration - PublishWebService
		Map<String,String> configurationWsPublishMap = new HashMap<String,String>();
		configurationWsPublishMap.put("Project", "Exaxe.Configuration"); 
		configurationWsPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(configurationWsPublishMap);

		//Exaxe.SystemConfiguration - PublishWebService
		Map<String,String> sysConfigurationWebApiPublishMap  = new HashMap<String,String>();
		sysConfigurationWebApiPublishMap.put("Project", "Exaxe.SystemConfiguration-WebAPI"); 
		sysConfigurationWebApiPublishMap.put("Operation", "DeployWebApi"); 
		deploySteps.add(sysConfigurationWebApiPublishMap);

		//Exaxe.Users - PublishWebService
		Map<String,String> usersWebApiPublishMap  = new HashMap<String,String>();
		usersWebApiPublishMap.put("Project", "Exaxe.Users-WebAPI"); 
		usersWebApiPublishMap.put("Operation", "DeployWebApi"); 
		deploySteps.add(usersWebApiPublishMap);

		//Exaxe.Client  - PublishWebService
		Map<String,String> clientWsPublishMap = new HashMap<String,String>();
		clientWsPublishMap.put("Project", "Exaxe.Client"); 
		clientWsPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(clientWsPublishMap);

		//Exaxe.AdminPlus  - PublishWebService
		Map<String,String> policyWsPublishMap = new HashMap<String,String>();
		policyWsPublishMap.put("Project", "Exaxe.AdminPlus"); 
		policyWsPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(policyWsPublishMap);

		//Exaxe.Apex  - PublishWebService
		Map<String,String> apexWsPublishMap = new HashMap<String,String>();
		apexWsPublishMap.put("Project", "Exaxe.Apex"); 
		apexWsPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(apexWsPublishMap);

		Map<String,String> apexWebApiPublishMap = new HashMap<String,String>();
		apexWebApiPublishMap.put("Project", "Exaxe.Apex-WebAPI"); 
		apexWebApiPublishMap.put("Operation", "DeployWebApi"); 
		deploySteps.add(apexWebApiPublishMap);

		//Exaxe.Aggregate  - PublishWebService
		//Exaxe.Quote - PublishWebService
		Map<String,String> quotehWebApiPublishMap  = new HashMap<String,String>();
		quotehWebApiPublishMap.put("Project", "Exaxe.Quote-WebAPI"); 
		quotehWebApiPublishMap.put("Operation", "DeployWebApi"); 
		deploySteps.add(quotehWebApiPublishMap);

		//Exaxe.ChannelPlus - PublishWebService
		Map<String,String> channelPlusWebApiPublishMap  = new HashMap<String,String>();
		channelPlusWebApiPublishMap.put("Project", "Exaxe.ChannelPlus-WebAPI"); 
		channelPlusWebApiPublishMap.put("Operation", "DeployWebApi"); 
		deploySteps.add(channelPlusWebApiPublishMap);

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

		/// WEB SITES
		//SystemConfigurationUI - PublishWebSite
		Map<String,String> systemConfigUIPublishMap  = new HashMap<String,String>();
		systemConfigUIPublishMap.put("Project", "SystemConfigurationUI"); 
		systemConfigUIPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(systemConfigUIPublishMap);

		//AdminPlusUI - PublishWebSite
		Map<String,String> adminPlusUIPublishMap  = new HashMap<String,String>();
		adminPlusUIPublishMap.put("Project", "AdminPlusUI"); 
		adminPlusUIPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(adminPlusUIPublishMap);

		//channelPlusUI - PublishWebSite
		Map<String,String> channelPlusUIPublishMap  = new HashMap<String,String>();
		channelPlusUIPublishMap.put("Project", "ChannelPlusUI"); 
		channelPlusUIPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(channelPlusUIPublishMap);

		//Hansard.Portals.Client - PublishWebSite
		Map<String,String> hansardPortalClientPublishMap  = new HashMap<String,String>();
		hansardPortalClientPublishMap.put("Project", "Hansard.Portals.Broker-WebSite"); 
		hansardPortalClientPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(hansardPortalClientPublishMap);

		//Hansard.Portals - PublishWebSite
		Map<String,String> hansardPortalBrokerPublishMap  = new HashMap<String,String>();
		hansardPortalBrokerPublishMap.put("Project", "Hansard.Portals.Client-WebSite"); 
		hansardPortalBrokerPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(hansardPortalBrokerPublishMap);

		//Release Content
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseContent"); 
		releaseContentMap.put("Operation", "ReleaseContent"); 
		deploySteps.add(releaseContentMap);
		
		//Return All of the defined steps
		deploySteps
    }
}