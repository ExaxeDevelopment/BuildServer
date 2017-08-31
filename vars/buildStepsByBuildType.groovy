class buildStepsByBuildType implements Serializable {
    def createBuildStepsByBuildType(val) { 

        List<String> fullBuild = 
		new ArrayList<String>{{add("GetAllCodeLatestVersion"), add("ClearDatabases"), add("InstallAllDatabases"), add("CheckOutFiles"), add("UpdateAssemblyVersion"), add("RestoreNuGetPackages"), add("UpdateNuGetPackages"), add("BuildSolution"), add("PerformUnitTests"), add("CheckInFiles"), add("PublishNuGetPackages"), add("CheckNuGetFeed"), add("DistributeSQLScripts")}};

        List<String> fullBuildWithoutGetAllCodeLatestVersionStage = 
		new ArrayList<String>{{ add("GetAllCodeLatestVersion"), add("ClearDatabases"), add("InstallAllDatabases"), add("CheckOutFiles"), add("UpdateAssemblyVersion"), add("RestoreNuGetPackages"), add("UpdateNuGetPackages"), add("BuildSolution"), add("PerformUnitTests"), add("CheckInFiles"), add("PublishNuGetPackages"), add("CheckNuGetFeed"), add("DistributeSQLScripts")}};
		
		List<String> buildWithoutDB = 
		new ArrayList<String>{{add("GetCodeLatestVersion"), add("CheckOutFiles"), add("UpdateAssemblyVersion"), add("RestoreNuGetPackages"), add("UpdateNuGetPackages"), add("BuildSolution"), add("PerformUnitTests"), add("CheckInFiles"), add("PublishNuGetPackages"), add("CheckNuGetFeed")}};
		
		List<String> buildUI = 
		new ArrayList<String>{{add("GetCodeLatestVersion"), add("CheckOutFiles"), add("UpdateAssemblyVersion"), add("RestoreNuGetPackages"), add("UpdateNuGetPackages"), add("BuildSolution"), add("PerformUnitTests"), add("CheckInFiles")}};

		List<String> buildDBSyncService =
		new ArrayList<String>{{add("GetAllCodeLatestVersion"), add("GetCodeLatestVersion"), add("CheckOutFiles"), add("RestoreNuGetPackages") ,add("BuildSolution"), add("PerformUnitTests"), add("Provision"), add("Synchronize"), add("InstallAllDatabases"), add("Reprovision"), add("Synchronize")}}
		
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