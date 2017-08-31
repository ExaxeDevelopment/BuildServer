class buildStepsByBuildType implements Serializable {
    def createBuildStepsByBuildType(val) { 

        List<String> fullBuild = 
		new ArrayList<String>["GetAllCodeLatestVersion","ClearDatabases","InstallAllDatabases","CheckOutFiles","UpdateAssemblyVersion","RestoreNuGetPackages","UpdateNuGetPackages","BuildSolution","PerformUnitTests","CheckInFiles","PublishNuGetPackages","CheckNuGetFeed","DistributeSQLScripts"];

        List<String> fullBuildWithoutGetAllCodeLatestVersionStage = 
		new ArrayList<String>["GetAllCodeLatestVersion","ClearDatabases","InstallAllDatabases","CheckOutFiles","UpdateAssemblyVersion","RestoreNuGetPackages","UpdateNuGetPackages","BuildSolution","PerformUnitTests","CheckInFiles","PublishNuGetPackages","CheckNuGetFeed","DistributeSQLScripts"];
		
		List<String> buildWithoutDB = 
		new ArrayList<String>["GetCodeLatestVersion","CheckOutFiles","UpdateAssemblyVersion","RestoreNuGetPackages","UpdateNuGetPackages","BuildSolution","PerformUnitTests","CheckInFiles","PublishNuGetPackages","CheckNuGetFeed"];
		
		List<String> buildUI = 
		new ArrayList<String>["GetCodeLatestVersion","CheckOutFiles","UpdateAssemblyVersion","RestoreNuGetPackages","UpdateNuGetPackages","BuildSolution","PerformUnitTests","CheckInFiles"];

		List<String> buildDBSyncService =
		new ArrayList<String>["GetAllCodeLatestVersion","GetCodeLatestVersion","CheckOutFiles","RestoreNuGetPackages","BuildSolution","PerformUnitTests","Provision","Synchronize","InstallAllDatabases","Reprovision","Synchronize"]
		
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