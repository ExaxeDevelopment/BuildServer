class deployCommonBuildSteps implements Serializable {
    def getDeployCommonBuildSteps() { 

		def emptyMap = [:];
		Map<String,String> deployMap1  = new HashMap<String,String>();
		deployMap1.put("Project", "Initialisation"); 
		deployMap1.put("Operation", "Initialisation"); 
		Map<String,String> deployMap2  = new HashMap<String,String>();
		deployMap2.put("Project", "GetAllCodeLatestVersion"); 
		deployMap2.put("Operation", "GetAllCodeLatestVersion"); 
		Map<String,String> deployMap3  = new HashMap<String,String>();
		deployMap3.put("Project", "Exaxe.SolutionManager"); 
		deployMap3.put("Operation", "GetCodeLatestVersion"); 
		Map<String,String> deployMap4  = new HashMap<String,String>();
		deployMap4.put("Project", "Exaxe.SolutionManager"); 
		deployMap4.put("Operation", "RestoreNuGetPackages"); 
		Map<String,String> deployMap5  = new HashMap<String,String>();
		deployMap5.put("Project", "Exaxe.SolutionManager"); 
		deployMap5.put("Operation", "BuildSolution"); 

		List l1 = ["Initialisation", "Initialisation"]
		List l2 = ["GetAllCodeLatestVersion", "GetAllCodeLatestVersion"]
		List l3 = ["Exaxe.SolutionManager", "GetCodeLatestVersion"]
		List l4 = ["Exaxe.SolutionManager", "RestoreNuGetPackages"]
		List l5 = ["Exaxe.SolutionManager", "BuildSolution"]

		List deploySteps = [deployMap1, deployMap2, deployMap3, deployMap4, deployMap5]

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

        deploySteps
    }
}