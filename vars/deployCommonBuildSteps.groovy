class deployCommonBuildSteps implements Serializable {
    def getDeployCommonBuildSteps() { 
		
		List commonDeploySteps = new List();

		//Initialisation
		Map<String,String> deployMap1  = new HashMap<String,String>();
		deployMap1.put("Project", "Initialisation"); 
		deployMap1.put("Operation", "Initialisation"); 
		commonDeploySteps.add(deployMap1);

		//GetAllCodeLatestVersion
		Map<String,String> deployMap2  = new HashMap<String,String>();
		deployMap2.put("Project", "GetAllCodeLatestVersion"); 
		deployMap2.put("Operation", "GetAllCodeLatestVersion"); 
		commonDeploySteps.add(deployMap2);

		//Exaxe.SolutionManager - GetCodeLatestVersion
		Map<String,String> deployMap3  = new HashMap<String,String>();
		deployMap3.put("Project", "Exaxe.SolutionManager"); 
		deployMap3.put("Operation", "GetCodeLatestVersion"); 
		commonDeploySteps.add(deployMap3);

		//Exaxe.SolutionManager - RestoreNuGetPackages
		Map<String,String> deployMap4  = new HashMap<String,String>();
		deployMap4.put("Project", "Exaxe.SolutionManager"); 
		deployMap4.put("Operation", "RestoreNuGetPackages"); 
		commonDeploySteps.add(deployMap4);

		//Exaxe.SolutionManager - BuildSolution
		Map<String,String> deployMap5  = new HashMap<String,String>();
		deployMap5.put("Project", "Exaxe.SolutionManager"); 
		deployMap5.put("Operation", "BuildSolution"); 
		commonDeploySteps.add(deployMap5);

		//Exaxe.SolutionManager - PublishInstallApp
		Map<String,String> deployMap6  = new HashMap<String,String>();
		deployMap5.put("Project", "Exaxe.SolutionManager"); 
		deployMap5.put("Operation", "PublishInstallApp"); 
		commonDeploySteps.add(deployMap6);

		//Exaxe.Agent - BuildDatabase
		Map<String,String> deployMap7  = new HashMap<String,String>();
		deployMap5.put("Project", "Exaxe.Agent"); 
		deployMap5.put("Operation", "BuildDatabase"); 
		commonDeploySteps.add(deployMap7);

		//Exaxe.App - BuildDatabase
		Map<String,String> deployMap8  = new HashMap<String,String>();
		deployMap5.put("Project", "Exaxe.App"); 
		deployMap5.put("Operation", "BuildDatabase"); 
		commonDeploySteps.add(deployMap8);

		//Exaxe.Product.DatabaseModel - BuildDatabase
		Map<String,String> deployMap9  = new HashMap<String,String>();
		deployMap5.put("Project", "Exaxe.Product.DatabaseModel"); 
		deployMap5.put("Operation", "BuildDatabase"); 
		commonDeploySteps.add(deployMap9);

		//Exaxe.Common - BuildSolution
		Map<String,String> deployMap10  = new HashMap<String,String>();
		deployMap5.put("Project", "Exaxe.Common"); 
		deployMap5.put("Operation", "BuildSolution"); 
		commonDeploySteps.add(deployMap10);

		//Exaxe.Configuration-Configuration - BuildSolution
		Map<String,String> deployMap11  = new HashMap<String,String>();
		deployMap5.put("Project", "Exaxe.Configuration-Configuration"); 
		deployMap5.put("Operation", "BuildSolution"); 
		commonDeploySteps.add(deployMap11);

		//Return All of the defined steps
		commonDeploySteps
    }
}