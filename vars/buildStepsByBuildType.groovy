class buildStepsByBuildType implements Serializable {
    def createBuildStepsByBuildType(val) { 

        List<String> forceFullBuild = new ArrayList<String>()
		forceFullBuild.add("GetAllCodeLatestVersion"); 
		forceFullBuild.add("CheckOutFiles"); 
		forceFullBuild.add("UpdateAssemblyVersion"); 
		forceFullBuild.add("RestoreNuGetPackages"); 
		forceFullBuild.add("UpdateNuGetPackages"); 
		forceFullBuild.add("ForceContinueBuild");
		forceFullBuild.add("BuildSolution");
		forceFullBuild.add("ClearDatabases"); 
		forceFullBuild.add("InstallAllDatabases"); 
		forceFullBuild.add("PublishWebService");
		forceFullBuild.add("CheckWorkflowsAsync");
		forceFullBuild.add("CheckWebServicesAsync");
		forceFullBuild.add("PerformUnitTests"); 
		forceFullBuild.add("CheckInFiles"); 
		forceFullBuild.add("PublishNuGetPackages"); 
		forceFullBuild.add("CheckNuGetFeed");
		forceFullBuild.add("PublishNuGetPackagesAzureDevOps");			

        List<String> fullBuild = new ArrayList<String>()
		fullBuild.add("GetAllCodeLatestVersion"); 
		fullBuild.add("CheckOutFiles"); 
		fullBuild.add("UpdateAssemblyVersion"); 
		fullBuild.add("RestoreNuGetPackages"); 
		fullBuild.add("UpdateNuGetPackages"); 
		fullBuild.add("CanContinueBuild");
		fullBuild.add("BuildSolution");
		fullBuild.add("ClearDatabases"); 
		fullBuild.add("InstallAllDatabases"); 
		fullBuild.add("PublishWebService");
		fullBuild.add("CheckWorkflowsAsync");
		fullBuild.add("CheckWebServicesAsync");
		fullBuild.add("PerformUnitTests"); 
		fullBuild.add("CheckInFiles"); 
		fullBuild.add("PublishNuGetPackages"); 
		fullBuild.add("CheckNuGetFeed");
		fullBuild.add("PublishNuGetPackagesAzureDevOps");			

        List<String> increaseVersionResetMinorVersion = new ArrayList<String>()
		increaseVersionResetMinorVersion.add("GetAllCodeLatestVersion"); 
		increaseVersionResetMinorVersion.add("CheckOutFiles"); 
		increaseVersionResetMinorVersion.add("ResetAssemblyVersion"); 
		increaseVersionResetMinorVersion.add("CheckInFiles"); 

        List<String> fullBuildRevision = new ArrayList<String>()
		fullBuildRevision.add("GetAllCodeLatestVersion");
		fullBuildRevision.add("CheckOutFiles"); 
		fullBuildRevision.add("UpdateAssemblyVersionRevision"); 
		fullBuildRevision.add("RestoreNuGetPackages"); 
		fullBuildRevision.add("UpdateNuGetPackages"); 
		fullBuildRevision.add("CanContinueBuild");
		fullBuildRevision.add("BuildSolution");
		fullBuildRevision.add("ClearDatabases"); 
		fullBuildRevision.add("InstallAllDatabases"); 
		fullBuildRevision.add("PublishWebService");
		fullBuildRevision.add("CheckWorkflowsAsync");
		fullBuildRevision.add("CheckWebServicesAsync");
		fullBuildRevision.add("PerformUnitTests"); 
		fullBuildRevision.add("CheckInFiles"); 
		fullBuildRevision.add("PublishNuGetPackages"); 
		fullBuildRevision.add("CheckNuGetFeed"); 
		fullBuildRevision.add("PublishNuGetPackagesAzureDevOps");			

        List<String> fullBuildCore = new ArrayList<String>()
		fullBuildCore.add("GetAllCodeLatestVersion");
		fullBuildCore.add("RestoreNuGetPackages"); 
		fullBuildCore.add("CanContinueBuild");
		fullBuildCore.add("BuildSolution");
		fullBuildCore.add("ClearDatabases"); 
		fullBuildCore.add("InstallAllDatabases"); 
		fullBuildCore.add("PublishWebService");
		fullBuildCore.add("CheckWorkflowsAsync");
		fullBuildCore.add("CheckWebServicesAsync");
		fullBuildCore.add("PerformUnitTests"); 
		fullBuildCore.add("PublishNuGetPackages"); 
		fullBuildCore.add("CheckNuGetFeed"); 
		fullBuildCore.add("PublishNuGetPackagesAzureDevOps");			


		List<String> intermediateBuild = new ArrayList<String>()
		intermediateBuild.add("GetCodeLatestVersion"); 
		intermediateBuild.add("CheckOutFiles"); 
		intermediateBuild.add("UpdateAssemblyVersion"); 
		intermediateBuild.add("RestoreNuGetPackages"); 
		intermediateBuild.add("UpdateNuGetPackages"); 
		intermediateBuild.add("CanContinueBuild");
		intermediateBuild.add("BuildSolution"); 
		intermediateBuild.add("CheckInFiles"); 
		intermediateBuild.add("PublishNuGetPackages"); 
		intermediateBuild.add("CheckNuGetFeed");
		
		List<String> buildDBSyncService = new ArrayList<String>()
		buildDBSyncService.add("GetAllCodeLatestVersion"); 
		buildDBSyncService.add("GetCodeLatestVersion"); 
		buildDBSyncService.add("CheckOutFiles"); 
		buildDBSyncService.add("RestoreNuGetPackages");
		buildDBSyncService.add("CanContinueBuild");
		buildDBSyncService.add("BuildSolution"); 
		buildDBSyncService.add("PerformUnitTests"); 
		buildDBSyncService.add("Provision"); 
		buildDBSyncService.add("Synchronize"); 
		buildDBSyncService.add("InstallAllDatabases"); 
		buildDBSyncService.add("Reprovision"); 
		buildDBSyncService.add("Synchronize");
	
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

		List<String> buildShrinkDatabaseLogs = new ArrayList<String>()
		buildShrinkDatabaseLogs.add("ShrinkDatabaseLogs");

		List<String> buildDeletePackages = new ArrayList<String>()
		buildDeletePackages.add("DeletePackages");

		List<String> buildClearNuGetCachePackages = new ArrayList<String>()
		buildClearNuGetCachePackages.add("ClearNuGetCachePackages");

		List<String> buildUpdateQualityGates = new ArrayList<String>()
		buildUpdateQualityGates.add("UpdateQualityGates"); 

		List<String> buildSteps = new ArrayList<String>();
        switch (val) {
            case "FullBuild":
                buildSteps = fullBuild;
                break
            case "ForceFullBuild":
                buildSteps = forceFullBuild;
                break
            case "FullBuildRevision":
                buildSteps = fullBuildRevision;
                break
			case "IncreaseVersionResetMinorVersion":
				buildSteps = "increaseVersionResetMinorVersion";
				break
            case "FullBuildCore":
                buildSteps = fullBuildCore;
                break
            case "IntermediateBuild":
                buildSteps = intermediateBuild;
                break
			case "UpdatePackagesWithoutBuild":
                buildSteps = updatePackagesWithoutBuild;
                break
			case "UpdatePackagesWithBuild":
                buildSteps = updatePackagesWithBuild;
                break
			case "BuildDBSyncService":
                buildSteps = buildDBSyncService;
                break
			case "FullDatabaseReconciliation":
                buildSteps = fullDatabaseReconciliation;
                break
			case "UpdateQualityGates":
                buildSteps = buildUpdateQualityGates;
                break
			case "ShrinkDatabaseLogs":
                buildSteps = buildShrinkDatabaseLogs;
                break
			case "DeletePackages":
                buildSteps = buildDeletePackages;
                break
			case "ClearNuGetCachePackages":
                buildSteps = buildClearNuGetCachePackages;
                break
            default:
                buildSteps.add("BuildTypeNotDefined");
                break
        }   

        buildSteps
    }
}