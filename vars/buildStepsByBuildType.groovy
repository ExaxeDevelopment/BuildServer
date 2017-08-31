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
		fullBuild.add("BuildSolution");
		fullBuild.add("PerformUnitTests"); 
		fullBuild.add("CheckInFiles"); 
		fullBuild.add("PublishNuGetPackages"); 
		fullBuild.add("CheckNuGetFeed"); 
		fullBuild.add("DistributeSQLScripts");

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
		fullBuildWithoutGetAllCodeLatestVersionStage.add("DistributeSQLScripts");
		
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
		
		List<String> buildUI = new ArrayList<String>()
		buildUI.add("GetCodeLatestVersion"); 
		buildUI.add("CheckOutFiles"); 
		buildUI.add("UpdateAssemblyVersion"); 
		buildUI.add("RestoreNuGetPackages"); 
		buildUI.add("UpdateNuGetPackages"); 
		buildUI.add("BuildSolution"); 
		buildUI.add("PerformUnitTests"); 
		buildUI.add("CheckInFiles");

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
			case "BuildUI":
                buildSteps = buildUI;
                break
			case "BuildDBSyncService":
                buildSteps = buildDBSyncService;
                break
            default:
                buildSteps.add("BuildTypeNotDefined");
                break
        }   

        buildSteps
    }
}