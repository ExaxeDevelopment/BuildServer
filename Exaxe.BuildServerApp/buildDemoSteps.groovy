class demoBuildSteps implements Serializable {
    def createBuildSteps(val) { 
        List<String> list = new ArrayList<String>();
        switch (val) {
            case "Update":
                list.add("Stage2");
                break
            case "Deploy":
                list.add("Stage3");
                break
            default:
                list.add("GetAllCodeLatestVersion");
                list.add("GetCodeLatestVersion");
                list.add("ClearDatabases");
                list.add("InstallAllDatabases");
                list.add("CheckOutFiles");
                list.add("UpdateAssemblyVersion");
                list.add("RestoreNuGetPackages");
                list.add("UpdateNuGetPackages");
                list.add("BuildSolution");
                list.add("PublishWebService");
                list.add("CheckWorkflowsAsync");
                list.add("PerformUnitTests");
                list.add("CheckInFiles");
                list.add("PublishNuGetPackages");
                list.add("CheckNuGetFeed");
                break
        }   
        list
    }
}