class deployAdminPlusV2 implements Serializable {
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
		//Exaxe.Configuration - RestoreNuGetPackages
		Map<String,String> configurationWsRestoreNuGetMap  = new HashMap<String,String>();
		configurationWsRestoreNuGetMap.put("Project", "Exaxe.Configuration-Configuration"); 
		configurationWsRestoreNuGetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(configurationWsRestoreNuGetMap);

		//Exaxe.Configuration - BuildSolution
		Map<String,String> configurationWsBuildMap  = new HashMap<String,String>();
		configurationWsBuildMap.put("Project", "Exaxe.Configuration-Configuration"); 
		configurationWsBuildMap.put("Operation", "BuildSolution"); 
		deploySteps.add(configurationWsBuildMap);

		//Exaxe.Configuration  - PublishWebService
		Map<String,String> configurationWsPublishMap = new HashMap<String,String>();
		configurationWsPublishMap.put("Project", "Exaxe.Configuration-Configuration"); 
		configurationWsPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(configurationWsPublishMap);

		//Exaxe.Client - RestoreNuGetPackages
		Map<String,String> clientWsRestoreNuGetMap  = new HashMap<String,String>();
		clientWsRestoreNuGetMap.put("Project", "Exaxe.Client"); 
		clientWsRestoreNuGetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(clientWsRestoreNuGetMap);

		//Exaxe.Client - BuildSolution
		Map<String,String> clientWsBuildMap  = new HashMap<String,String>();
		clientWsBuildMap.put("Project", "Exaxe.Client"); 
		clientWsBuildMap.put("Operation", "BuildSolution"); 
		deploySteps.add(clientWsBuildMap);

		//Exaxe.Client  - PublishWebService
		Map<String,String> clientWsPublishMap = new HashMap<String,String>();
		clientWsPublishMap.put("Project", "Exaxe.Client"); 
		clientWsPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(clientWsPublishMap);

		//Exaxe.AdminPlus - RestoreNuGetPackages
		Map<String,String> policyWsRestoreNuGetMap  = new HashMap<String,String>();
		policyWsRestoreNuGetMap.put("Project", "Exaxe.AdminPlus"); 
		policyWsRestoreNuGetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(policyWsRestoreNuGetMap);

		//Exaxe.AdminPlus - BuildSolution
		Map<String,String> policyWsBuildMap  = new HashMap<String,String>();
		policyWsBuildMap.put("Project", "Exaxe.AdminPlus"); 
		policyWsBuildMap.put("Operation", "BuildSolution"); 
		deploySteps.add(policyWsBuildMap);

		//Exaxe.AdminPlus  - PublishWebService
		Map<String,String> policyWsPublishMap = new HashMap<String,String>();
		policyWsPublishMap.put("Project", "Exaxe.AdminPlus"); 
		policyWsPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(policyWsPublishMap);

		//Exaxe.Apex - RestoreNuGetPackages
		Map<String,String> apexWsRestoreNuGetMap  = new HashMap<String,String>();
		apexWsRestoreNuGetMap.put("Project", "Exaxe.Apex"); 
		apexWsRestoreNuGetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(apexWsRestoreNuGetMap);

		//Exaxe.Apex - BuildSolution
		Map<String,String> apexWsBuildMap  = new HashMap<String,String>();
		apexWsBuildMap.put("Project", "Exaxe.Apex"); 
		apexWsBuildMap.put("Operation", "BuildSolution"); 
		deploySteps.add(apexWsBuildMap);

		//Exaxe.Apex  - PublishWebService
		Map<String,String> apexWsPublishMap = new HashMap<String,String>();
		apexWsPublishMap.put("Project", "Exaxe.Apex"); 
		apexWsPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(apexWsPublishMap);

		//Exaxe.Aggregate - RestoreNuGetPackages
		Map<String,String> aggregateWsRestoreNuGetMap  = new HashMap<String,String>();
		aggregateWsRestoreNuGetMap.put("Project", "Exaxe.Aggregate"); 
		aggregateWsRestoreNuGetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(aggregateWsRestoreNuGetMap);

		//Exaxe.Aggregate - BuildSolution
		Map<String,String> aggregateWsBuildMap  = new HashMap<String,String>();
		aggregateWsBuildMap.put("Project", "Exaxe.Aggregate"); 
		aggregateWsBuildMap.put("Operation", "BuildSolution"); 
		deploySteps.add(aggregateWsBuildMap);

		//Exaxe.Aggregate  - PublishWebService
		Map<String,String> aggregateWsPublishMap = new HashMap<String,String>();
		aggregateWsPublishMap.put("Project", "Exaxe.Aggregate"); 
		aggregateWsPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(aggregateWsPublishMap);

		//Exaxe.Apex.Server - RestoreNuGetPackages
		Map<String,String> apexServerWsRestoreNuGetMap  = new HashMap<String,String>();
		apexServerWsRestoreNuGetMap.put("Project", "Exaxe.Apex.Server"); 
		apexServerWsRestoreNuGetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(apexServerWsRestoreNuGetMap);

		//Exaxe.Apex.Server - BuildSolution
		Map<String,String> apexServerWsBuildMap  = new HashMap<String,String>();
		apexServerWsBuildMap.put("Project", "Exaxe.Apex.Server"); 
		apexServerWsBuildMap.put("Operation", "BuildSolution"); 
		deploySteps.add(apexServerWsBuildMap);

		//Exaxe.Apex.Server  - PublishWebService
		Map<String,String> apexServerWsPublishMap = new HashMap<String,String>();
		apexServerWsPublishMap.put("Project", "Exaxe.Apex.Server"); 
		apexServerWsPublishMap.put("Operation", "PublishWebService"); 
		deploySteps.add(apexServerWsPublishMap);

		/// WEB SITES
		//AdminPlusUI - RestoreNuGetPackages
		Map<String,String> adminPlusUIRestoreNuGetMap  = new HashMap<String,String>();
		adminPlusUIRestoreNuGetMap.put("Project", "AdminPlusUI"); 
		adminPlusUIRestoreNuGetMap.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(adminPlusUIRestoreNuGetMap);

		//AdminPlusUI - BuildSolution
		Map<String,String> adminPlusUIBuildMap  = new HashMap<String,String>();
		adminPlusUIBuildMap.put("Project", "AdminPlusUI"); 
		adminPlusUIBuildMap.put("Operation", "BuildSolution"); 
		deploySteps.add(systemConfigUIBuildMap);

		//AdminPlusUI - PublishWebSite
		Map<String,String> adminPlusUIPublishMap  = new HashMap<String,String>();
		adminPlusUIPublishMap.put("Project", "AdminPlusUI"); 
		adminPlusUIPublishMap.put("Operation", "PublishWebSite"); 
		deploySteps.add(adminPlusUIPublishMap);

		//Release Content
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseContent"); 
		releaseContentMap.put("Operation", "ReleaseContent"); 
		deploySteps.add(releaseContentMap);
		
		//Return All of the defined steps
		deploySteps
    }
}