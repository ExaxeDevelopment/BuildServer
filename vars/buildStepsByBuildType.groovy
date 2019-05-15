class buildStepsByBuildType implements Serializable {
    def createBuildStepsByBuildType(val) { 

        List<String> fullBuild = new ArrayList<String>()
		fullBuild.add("GetAllCodeLatestVersion"); 
		fullBuild.add("GetCodeLatestVersion");
		fullBuild.add("ClearDatabases"); 
		fullBuild.add("InstallAllDatabases"); 
		fullBuild.add("CheckOutFiles"); 
		fullBuild.add("UpdateAssemblyVersion"); 
		fullBuild.add("RestoreNuGetPackages"); 
		fullBuild.add("UpdateNuGetPackages"); 
		fullBuild.add("BuildSolution");
		fullBuild.add("PerformUnitTests"); 
		fullBuild.add("CheckInFiles"); 
		fullBuild.add("PublishNuGetPackages"); 
		fullBuild.add("CheckNuGetFeed");

        List<String> fullBuildRevision = new ArrayList<String>()
		fullBuildRevision.add("GetAllCodeLatestVersion"); 
		fullBuildRevision.add("GetCodeLatestVersion");
		fullBuildRevision.add("ClearDatabases"); 
		fullBuildRevision.add("InstallAllDatabases"); 
		fullBuildRevision.add("CheckOutFiles"); 
		fullBuildRevision.add("UpdateAssemblyVersionRevision"); 
		fullBuildRevision.add("RestoreNuGetPackages"); 
		fullBuildRevision.add("UpdateNuGetPackages"); 
		fullBuildRevision.add("BuildSolution");
		fullBuildRevision.add("PerformUnitTests"); 
		fullBuildRevision.add("CheckInFiles"); 
		fullBuildRevision.add("PublishNuGetPackages"); 
		fullBuildRevision.add("CheckNuGetFeed"); 

		List<String> fullBuildWithWebService = new ArrayList<String>()
		fullBuildWithWebService.add("GetAllCodeLatestVersion"); 
		fullBuildWithWebService.add("GetCodeLatestVersion");
		fullBuildWithWebService.add("ClearDatabases"); 
		fullBuildWithWebService.add("InstallAllDatabases"); 
		fullBuildWithWebService.add("CheckOutFiles"); 
		fullBuildWithWebService.add("UpdateAssemblyVersion"); 
		fullBuildWithWebService.add("RestoreNuGetPackages"); 
		fullBuildWithWebService.add("UpdateNuGetPackages"); 
		fullBuildWithWebService.add("BuildSolution");
		fullBuildWithWebService.add("PublishWebService");
		fullBuildWithWebService.add("PerformUnitTests"); 
		fullBuildWithWebService.add("CheckInFiles"); 
		fullBuildWithWebService.add("PublishNuGetPackages"); 
		fullBuildWithWebService.add("CheckNuGetFeed");

		List<String> fullBuildWithWebServiceRevision = new ArrayList<String>()
		fullBuildWithWebServiceRevision.add("GetAllCodeLatestVersion"); 
		fullBuildWithWebServiceRevision.add("GetCodeLatestVersion");
		fullBuildWithWebServiceRevision.add("ClearDatabases"); 
		fullBuildWithWebServiceRevision.add("InstallAllDatabases"); 
		fullBuildWithWebServiceRevision.add("CheckOutFiles"); 
		fullBuildWithWebServiceRevision.add("UpdateAssemblyVersionRevision"); 
		fullBuildWithWebServiceRevision.add("RestoreNuGetPackages"); 
		fullBuildWithWebServiceRevision.add("UpdateNuGetPackages"); 
		fullBuildWithWebServiceRevision.add("BuildSolution");
		fullBuildWithWebServiceRevision.add("PublishWebService");
		fullBuildWithWebServiceRevision.add("PerformUnitTests"); 
		fullBuildWithWebServiceRevision.add("CheckInFiles"); 
		fullBuildWithWebServiceRevision.add("PublishNuGetPackages"); 
		fullBuildWithWebServiceRevision.add("CheckNuGetFeed");

        List<String> fullBuildWithoutGetAllCodeLatestVersionStage = new ArrayList<String>();
		fullBuildWithoutGetAllCodeLatestVersionStage.add("GetAllCodeLatestVersion"); 
		fullBuildWithoutGetAllCodeLatestVersionStage.add("ClearDatabases"); 
		fullBuildWithoutGetAllCodeLatestVersionStage.add("InstallAllDatabases"); 
		fullBuildWithoutGetAllCodeLatestVersionStage.add("CheckOutFiles"); 
		fullBuildWithoutGetAllCodeLatestVersionStage.add("UpdateAssemblyVersion"); 
		fullBuildWithoutGetAllCodeLatestVersionStage.add("RestoreNuGetPackages"); 
		fullBuildWithoutGetAllCodeLatestVersionStage.add("UpdateNuGetPackages"); 
		fullBuildWithoutGetAllCodeLatestVersionStage.add("BuildSolution"); 
		fullBuildWithoutGetAllCodeLatestVersionStage.add("PerformUnitTests"); 
		fullBuildWithoutGetAllCodeLatestVersionStage.add("CheckInFiles"); 
		fullBuildWithoutGetAllCodeLatestVersionStage.add("PublishNuGetPackages"); 
		fullBuildWithoutGetAllCodeLatestVersionStage.add("CheckNuGetFeed"); 
		
		List<String> buildWithoutDB = new ArrayList<String>()
		buildWithoutDB.add("GetCodeLatestVersion"); 
		buildWithoutDB.add("CheckOutFiles"); 
		buildWithoutDB.add("UpdateAssemblyVersion"); 
		buildWithoutDB.add("RestoreNuGetPackages"); 
		buildWithoutDB.add("UpdateNuGetPackages"); 
		buildWithoutDB.add("BuildSolution"); 
		buildWithoutDB.add("PerformUnitTests"); 
		buildWithoutDB.add("CheckInFiles"); 
		buildWithoutDB.add("PublishNuGetPackages"); 
		buildWithoutDB.add("CheckNuGetFeed");

		List<String> buildWithoutDBRevision = new ArrayList<String>()
		buildWithoutDBRevision.add("GetCodeLatestVersion"); 
		buildWithoutDBRevision.add("CheckOutFiles"); 
		buildWithoutDBRevision.add("UpdateAssemblyVersionRevision"); 
		buildWithoutDBRevision.add("RestoreNuGetPackages"); 
		buildWithoutDBRevision.add("UpdateNuGetPackages"); 
		buildWithoutDBRevision.add("BuildSolution"); 
		buildWithoutDBRevision.add("PerformUnitTests"); 
		buildWithoutDBRevision.add("CheckInFiles"); 
		buildWithoutDBRevision.add("PublishNuGetPackages"); 
		buildWithoutDBRevision.add("CheckNuGetFeed");

		List<String> buildWithoutDBAndUnitTests = new ArrayList<String>()
		buildWithoutDBAndUnitTests.add("GetCodeLatestVersion"); 
		buildWithoutDBAndUnitTests.add("CheckOutFiles"); 
		buildWithoutDBAndUnitTests.add("UpdateAssemblyVersion"); 
		buildWithoutDBAndUnitTests.add("RestoreNuGetPackages"); 
		buildWithoutDBAndUnitTests.add("UpdateNuGetPackages"); 
		buildWithoutDBAndUnitTests.add("BuildSolution"); 
		buildWithoutDBAndUnitTests.add("CheckInFiles"); 
		buildWithoutDBAndUnitTests.add("PublishNuGetPackages"); 
		buildWithoutDBAndUnitTests.add("CheckNuGetFeed");
		
		List<String> buildUI = new ArrayList<String>()
		buildUI.add("GetCodeLatestVersion"); 
		buildUI.add("CheckOutFiles"); 
		buildUI.add("UpdateAssemblyVersion"); 
		buildUI.add("RestoreNuGetPackages"); 
		buildUI.add("UpdateNuGetPackages"); 
		buildUI.add("BuildSolution"); 
		buildUI.add("PerformUnitTests"); 
		buildUI.add("CheckInFiles");
		buildUI.add("PublishNuGetPackagesAzureDevOps");

		List<String> buildUIRevision = new ArrayList<String>()
		buildUIRevision.add("GetCodeLatestVersion"); 
		buildUIRevision.add("CheckOutFiles"); 
		buildUIRevision.add("UpdateAssemblyVersionRevision"); 
		buildUIRevision.add("RestoreNuGetPackages"); 
		buildUIRevision.add("UpdateNuGetPackages"); 
		buildUIRevision.add("BuildSolution"); 
		buildUIRevision.add("PerformUnitTests"); 
		buildUIRevision.add("CheckInFiles");

		List<String> buildDBSyncService = new ArrayList<String>()
		buildDBSyncService.add("GetAllCodeLatestVersion"); 
		buildDBSyncService.add("GetCodeLatestVersion"); 
		buildDBSyncService.add("CheckOutFiles"); 
		buildDBSyncService.add("RestoreNuGetPackages");
		buildDBSyncService.add("BuildSolution"); 
		buildDBSyncService.add("PerformUnitTests"); 
		buildDBSyncService.add("Provision"); 
		buildDBSyncService.add("Synchronize"); 
		buildDBSyncService.add("InstallAllDatabases"); 
		buildDBSyncService.add("Reprovision"); 
		buildDBSyncService.add("Synchronize");

        List<String> buildWithoutPublishNugGet = new ArrayList<String>()
		buildWithoutPublishNugGet.add("GetAllCodeLatestVersion"); 
		buildWithoutPublishNugGet.add("ClearDatabases"); 
		buildWithoutPublishNugGet.add("InstallAllDatabases"); 
		buildWithoutPublishNugGet.add("CheckOutFiles"); 
		buildWithoutPublishNugGet.add("UpdateAssemblyVersion"); 
		buildWithoutPublishNugGet.add("RestoreNuGetPackages"); 
		buildWithoutPublishNugGet.add("UpdateNuGetPackages"); 
		buildWithoutPublishNugGet.add("BuildSolution");
		buildWithoutPublishNugGet.add("PerformUnitTests"); 
		buildWithoutPublishNugGet.add("CheckInFiles"); 
		
        List<String> buildApexServer = new ArrayList<String>()
		buildApexServer.add("GetAllCodeLatestVersion"); 
		buildApexServer.add("GetCodeLatestVersion");
		buildApexServer.add("ClearDatabases"); 
		buildApexServer.add("InstallAllDatabases"); 
		buildApexServer.add("CheckOutFiles"); 
		buildApexServer.add("UpdateAssemblyVersion"); 
		buildApexServer.add("RestoreNuGetPackages"); 
		buildApexServer.add("UpdateNuGetPackages"); 
		buildApexServer.add("BuildSolution");
		buildApexServer.add("PublishWebService");
		buildApexServer.add("CheckWorkflowsAsync");
		buildApexServer.add("PerformUnitTests"); 
		buildApexServer.add("CheckInFiles"); 

        List<String> buildApexServerRevision = new ArrayList<String>()
		buildApexServerRevision.add("GetAllCodeLatestVersion"); 
		buildApexServerRevision.add("GetCodeLatestVersion");
		buildApexServerRevision.add("ClearDatabases"); 
		buildApexServerRevision.add("InstallAllDatabases"); 
		buildApexServerRevision.add("CheckOutFiles"); 
		buildApexServerRevision.add("UpdateAssemblyVersionRevision"); 
		buildApexServerRevision.add("RestoreNuGetPackages"); 
		buildApexServerRevision.add("UpdateNuGetPackages"); 
		buildApexServerRevision.add("BuildSolution");
		buildApexServerRevision.add("PublishWebService");
		buildApexServerRevision.add("CheckWorkflowsAsync");
		buildApexServerRevision.add("PerformUnitTests"); 
		buildApexServerRevision.add("CheckInFiles"); 

		List<String> updatePackagesWithoutBuild = new ArrayList<String>()
		updatePackagesWithoutBuild.add("GetCodeLatestVersion"); 
		updatePackagesWithoutBuild.add("CheckOutFiles"); 
		updatePackagesWithoutBuild.add("RestoreNuGetPackages"); 
		updatePackagesWithoutBuild.add("UpdateNuGetPackages");
		updatePackagesWithoutBuild.add("CheckInFiles"); 
		updatePackagesWithoutBuild.add("PublishNuGetPackagesAzureDevOps"); 

		List<String> updatePackagesWithBuild = new ArrayList<String>()
		updatePackagesWithBuild.add("GetCodeLatestVersion"); 
		updatePackagesWithBuild.add("CheckOutFiles"); 
		updatePackagesWithBuild.add("RestoreNuGetPackages"); 
		updatePackagesWithBuild.add("UpdateNuGetPackages");
		updatePackagesWithBuild.add("BuildSolution");
		updatePackagesWithBuild.add("CheckInFiles"); 
		updatePackagesWithBuild.add("PublishNuGetPackagesAzureDevOps"); 

		List<String> fullDatabaseReconciliation = new ArrayList<String>()
		fullDatabaseReconciliation.add("GetAllCodeLatestVersion"); 
		fullDatabaseReconciliation.add("ClearDatabases"); 
		fullDatabaseReconciliation.add("InstallAllDatabases"); 
		fullDatabaseReconciliation.add("CheckExtendedProperties");
		fullDatabaseReconciliation.add("DataScriptsReconciliation"); 

		List<String> buildDataScriptsReconciliation = new ArrayList<String>()
		buildDataScriptsReconciliation.add("DataScriptsReconciliation"); 

		List<String> buildShrinkDatabaseLogs = new ArrayList<String>()
		buildShrinkDatabaseLogs.add("ShrinkDatabaseLogs");

		List<String> buildDeletePackages = new ArrayList<String>()
		buildDeletePackages.add("DeletePackages");

		List<String> buildCheckExtendedProperties = new ArrayList<String>()
		buildCheckExtendedProperties.add("CheckExtendedProperties");

		List<String> buildUpdateQualityGates = new ArrayList<String>()
		buildUpdateQualityGates.add("UpdateQualityGates"); 

		List<String> buildSteps = new ArrayList<String>();
        switch (val) {
            case "FullBuild":
                buildSteps = fullBuild;
                break
            case "FullBuildWithoutGetAllCodeLatestVersionStage":
                buildSteps = fullBuildWithoutGetAllCodeLatestVersionStage;
                break
			case "BuildWithoutDB":
                buildSteps = buildWithoutDB;
                break
			case "BuildWithoutDBAndUnitTests":
                buildSteps = buildWithoutDBAndUnitTests;
                break
			case "BuildWithoutPublishNugGet":
                buildSteps = buildWithoutPublishNugGet;
                break
			case "BuildApexServer":
                buildSteps = buildApexServer;
                break
			case "BuildUI":
                buildSteps = buildUI;
                break
			case "BuildDBSyncService":
                buildSteps = buildDBSyncService;
                break
			case "UpdatePackagesWithoutBuild":
                buildSteps = updatePackagesWithoutBuild;
                break
			case "UpdatePackagesWithBuild":
                buildSteps = updatePackagesWithBuild;
                break
            case "FullBuildRevision":
                buildSteps = fullBuildRevision;
                break
			case "BuildWithoutDBRevision":
                buildSteps = buildWithoutDBRevision;
                break
			case "BuildApexServerRevision":
                buildSteps = buildApexServerRevision;
                break
			case "BuildUIRevision":
                buildSteps = buildUIRevision;
                break
			case "DataScriptsReconciliation":
                buildSteps = buildDataScriptsReconciliation;
                break
			case "FullDatabaseReconciliation":
                buildSteps = fullDatabaseReconciliation;
                break
			case "UpdateQualityGates":
                buildSteps = buildUpdateQualityGates;
                break
			case "FullBuildWithWebService":
                buildSteps = fullBuildWithWebService;
                break
			case "FullBuildWithWebServiceRevision":
                buildSteps = fullBuildWithWebServiceRevision;
                break
			case "ShrinkDatabaseLogs":
                buildSteps = buildShrinkDatabaseLogs;
                break
			case "DeletePackages":
                buildSteps = buildDeletePackages;
                break
			case "CheckExtendedProperties":
                buildSteps = buildCheckExtendedProperties;
                break
            default:
                buildSteps.add("BuildTypeNotDefined");
                break
        }   

        buildSteps
    }
}