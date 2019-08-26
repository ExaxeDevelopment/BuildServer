class buildStepsByBuildType implements Serializable {
    def createBuildStepsByBuildType(val) { 

        List<String> fullBuild = new ArrayList<String>()
		fullBuild.add("GetAllCodeLatestVersion"); 
		fullBuild.add("ClearDatabases"); 
		fullBuild.add("InstallAllDatabases"); 
		fullBuild.add("CheckOutFiles"); 
		fullBuild.add("UpdateAssemblyVersion"); 
		fullBuild.add("RestoreNuGetPackages"); 
		fullBuild.add("UpdateNuGetPackages"); 
		fullBuild.add("CanContinueBuild");
		fullBuild.add("BuildSolution");
		fullBuild.add("PublishWebService");
		fullBuild.add("CheckWorkflowsAsync");
		fullBuild.add("PerformUnitTests"); 
		fullBuild.add("CheckInFiles"); 
		fullBuild.add("PublishNuGetPackages"); 
		fullBuild.add("CheckNuGetFeed");
		fullBuild.add("PublishNuGetPackagesAzureDevOps");			

        List<String> fullBuildRevision = new ArrayList<String>()
		fullBuildRevision.add("GetAllCodeLatestVersion");
		fullBuildRevision.add("ClearDatabases"); 
		fullBuildRevision.add("InstallAllDatabases"); 
		fullBuildRevision.add("CheckOutFiles"); 
		fullBuildRevision.add("UpdateAssemblyVersionRevision"); 
		fullBuildRevision.add("RestoreNuGetPackages"); 
		fullBuildRevision.add("UpdateNuGetPackages"); 
		fullBuildRevision.add("CanContinueBuild");
		fullBuildRevision.add("BuildSolution");
		fullBuildRevision.add("PublishWebService");
		fullBuildRevision.add("CheckWorkflowsAsync");
		fullBuildRevision.add("PerformUnitTests"); 
		fullBuildRevision.add("CheckInFiles"); 
		fullBuildRevision.add("PublishNuGetPackages"); 
		fullBuildRevision.add("CheckNuGetFeed"); 
		fullBuildRevision.add("PublishNuGetPackagesAzureDevOps");			

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

		List<String> buildUpdateQualityGates = new ArrayList<String>()
		buildUpdateQualityGates.add("UpdateQualityGates"); 

		List<String> buildSteps = new ArrayList<String>();
        switch (val) {
            case "FullBuild":
                buildSteps = fullBuild;
                break
            case "FullBuildRevision":
                buildSteps = fullBuildRevision;
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
            default:
                buildSteps.add("BuildTypeNotDefined");
                break
        }   

        buildSteps
    }
}