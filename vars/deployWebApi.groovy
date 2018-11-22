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

		//Exaxe.Quote - BuildDatabase
		Map<String,String> quoteDbMap  = new HashMap<String,String>();
		quoteDbMap.put("Project", "Exaxe.Quote"); 
		quoteDbMap.put("Operation", "BuildDatabase"); 
		deploySteps.add(quoteDbMap);

		/// WEB Apis
	    //Exaxe.Configuration - RestoreNuGetPackages
		Map<String,String> configurationRestoreNuGetMap  = new HashMap<String,String>();
		configurationRestoreNuGetMap.put("Project", "Exaxe.Configuration"); 
		configurationRestoreNuGetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(configurationRestoreNuGetMap);

		 //Exaxe.Configuration - Build
		Map<String,String> configurationBuildMap  = new HashMap<String,String>();
		configurationBuildMap.put("Project", "Exaxe.Configuration"); 
		configurationBuildMap.put("Operation", "BuildSolution"); 
		deploySteps.add(configurationBuildMap);

		//Exaxe.Configuration - PublishWebService
		Map<String,String> configurationWsPublishMap = new HashMap<String,String>();
		configurationWsPublishMap.put("Project", "Exaxe.Configuration"); 
		configurationWsPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(configurationWsPublishMap);

		//Exaxe.Client  - RestoreNuGetPackages
		Map<String,String> clientWsRestoreMap = new HashMap<String,String>();
		clientWsRestoreMap.put("Project", "Exaxe.Client"); 
		clientWsRestoreMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(clientWsRestoreMap);

		//Exaxe.Client  - Build
		Map<String,String> clientWsBuildMap = new HashMap<String,String>();
		clientWsBuildMap.put("Project", "Exaxe.Client"); 
		clientWsBuildMap.put("Operation", "BuildSolution"); 
		deploySteps.add(clientWsBuildMap);

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

		//Exaxe.AdminPlus  - BuildSolution
		Map<String,String> policyWsBuildMap = new HashMap<String,String>();
		policyWsBuildMap.put("Project", "Exaxe.AdminPlus"); 
		policyWsBuildMap.put("Operation", "BuildSolution"); 
		deploySteps.add(policyWsBuildMap);

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

		//Exaxe.Apex  - BuildSolution
		Map<String,String> apexWsBuildMap = new HashMap<String,String>();
		apexWsBuildMap.put("Project", "Exaxe.Apex"); 
		apexWsBuildMap.put("Operation", "BuildSolution"); 
		deploySteps.add(apexWsBuildMap);

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

		//Exaxe.Aggregate  - BuildSolution
		Map<String,String> aggregateWsBuildMap = new HashMap<String,String>();
		aggregateWsBuildMap.put("Project", "Exaxe.Aggregate"); 
		aggregateWsBuildMap.put("Operation", "BuildSolution"); 
		deploySteps.add(aggregateWsBuildMap);

		//Exaxe.Aggregate  - PublishWebService
		Map<String,String> aggregateWsPublishMap = new HashMap<String,String>();
		aggregateWsPublishMap.put("Project", "Exaxe.Aggregate"); 
		aggregateWsPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(aggregateWsPublishMap);

		//Exaxe.ChannelPlus - RestoreNuGetPackages
		Map<String,String> channelPlusWebApiRestoreMap  = new HashMap<String,String>();
		channelPlusWebApiRestoreMap.put("Project", "Exaxe.ChannelPlus"); 
		channelPlusWebApiRestoreMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(channelPlusWebApiRestoreMap);

		//Exaxe.ChannelPlus - BuildSolution
		Map<String,String> channelPlusWebApiBuildMap  = new HashMap<String,String>();
		channelPlusWebApiBuildMap.put("Project", "Exaxe.ChannelPlus"); 
		channelPlusWebApiBuildMap.put("Operation", "BuildSolution"); 
		deploySteps.add(channelPlusWebApiBuildMap);

		//Exaxe.ChannelPlus - PublishWebSite
		Map<String,String> channelPlusWebApiPublishMap  = new HashMap<String,String>();
		channelPlusWebApiPublishMap.put("Project", "Exaxe.ChannelPlus"); 
		channelPlusWebApiPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(channelPlusWebApiPublishMap);

		//Exaxe.Auth - RestoreNuGetPackages
		Map<String,String> authWebApiRestoreMap  = new HashMap<String,String>();
		authWebApiRestoreMap.put("Project", "Exaxe.Auth"); 
		authWebApiRestoreMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(authWebApiRestoreMap);

		//Exaxe.Auth - BuildSolution
		Map<String,String> authWebApiBuildMap  = new HashMap<String,String>();
		authWebApiBuildMap.put("Project", "Exaxe.Auth"); 
		authWebApiBuildMap.put("Operation", "BuildSolution"); 
		deploySteps.add(authWebApiBuildMap);

		//Exaxe.Auth - PublishWebSite
		Map<String,String> authhWebApiPublishMap  = new HashMap<String,String>();
		authhWebApiPublishMap.put("Project", "Exaxe.Auth"); 
		authhWebApiPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(authhWebApiPublishMap);

		//Exaxe.Users - RestoreNuGetPackages
		Map<String,String> usersWebApiRestoreMap  = new HashMap<String,String>();
		usersWebApiRestoreMap.put("Project", "Exaxe.Users"); 
		usersWebApiRestoreMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(usersWebApiRestoreMap);

		//Exaxe.Users - BuildSolution
		Map<String,String> usersWebApiBuildMap  = new HashMap<String,String>();
		usersWebApiBuildMap.put("Project", "Exaxe.Users"); 
		usersWebApiBuildMap.put("Operation", "BuildSolution"); 
		deploySteps.add(usersWebApiBuildMap);

		//Exaxe.Users - PublishWebSite
		Map<String,String> usershWebApiPublishMap  = new HashMap<String,String>();
		usershWebApiPublishMap.put("Project", "Exaxe.Users"); 
		usershWebApiPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(usershWebApiPublishMap);
	
		//Exaxe.Document - RestoreNuGetPackages
		Map<String,String> documentWebApiRestoreMap  = new HashMap<String,String>();
		documentWebApiRestoreMap.put("Project", "Exaxe.Document"); 
		documentWebApiRestoreMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(documentWebApiRestoreMap);

		//Exaxe.Document - BuildSolution
		Map<String,String> documentWebApiBuildMap  = new HashMap<String,String>();
		documentWebApiBuildMap.put("Project", "Exaxe.Document"); 
		documentWebApiBuildMap.put("Operation", "BuildSolution"); 
		deploySteps.add(documentWebApiBuildMap);

		//Exaxe.Document - PublishWebSite
		Map<String,String> documenthWebApiPublishMap  = new HashMap<String,String>();
		documenthWebApiPublishMap.put("Project", "Exaxe.Document"); 
		documenthWebApiPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(documenthWebApiPublishMap);

		//Exaxe.Quote - RestoreNuGetPackages
		Map<String,String> quoteWebApiRestoreMap  = new HashMap<String,String>();
		quoteWebApiRestoreMap.put("Project", "Exaxe.Quote"); 
		quoteWebApiRestoreMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(quoteWebApiRestoreMap);

		//Exaxe.Quote - BuildSolution
		Map<String,String> quoteWebApiBuildMap  = new HashMap<String,String>();
		quoteWebApiBuildMap.put("Project", "Exaxe.Quote"); 
		quoteWebApiBuildMap.put("Operation", "BuildSolution"); 
		deploySteps.add(quoteWebApiBuildMap);

		//Exaxe.Quote - PublishWebSite
		Map<String,String> quotehWebApiPublishMap  = new HashMap<String,String>();
		quotehWebApiPublishMap.put("Project", "Exaxe.Quote"); 
		quotehWebApiPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(quotehWebApiPublishMap);

		//Release Content
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseContent"); 
		releaseContentMap.put("Operation", "ReleaseContent"); 
		deploySteps.add(releaseContentMap);
		
		//Return All of the defined steps
		deploySteps
    }
}