class deployCommonBuildSteps implements Serializable {
    def getDeployCommonBuildSteps() { 

        List<String> deployCommonSteps = new ArrayList<String>();
		deployCommonSteps.add("Initialisation"); 
		deployCommonSteps.add("GetAllCodeLatestVersion");
		deployCommonSteps.add("Exaxe.SolutionManager - GetCodeLatestVersion"); 
		deployCommonSteps.add("Exaxe.SolutionManager - RestoreNuGetPackages"); 
		deployCommonSteps.add("Exaxe.SolutionManager - BuildSolution"); 
		deployCommonSteps.add("Exaxe.SolutionManager - PublishInstallApp"); 
		deployCommonSteps.add("Exaxe.Agent - BuildDatabase"); 
		deployCommonSteps.add("Exaxe.App - BuildDatabase"); 
		deployCommonSteps.add("Exaxe.Product.DatabaseModel - BuildDatabase");
		deployCommonSteps.add("Exaxe.Common - BuildDatabase"); 
		deployCommonSteps.add("Exaxe.Configuration-Configuration - BuildDatabase"); 
		deployCommonSteps.add("Exaxe.SystemConfiguration - BuildDatabase"); 
		deployCommonSteps.add("Exaxe.Accounting - BuildDatabase"); 
		deployCommonSteps.add("Exaxe.Client - BuildDatabase");
		deployCommonSteps.add("Release Content");
		deployCommonSteps.add("Success Notification");

        deployCommonSteps
    }
}