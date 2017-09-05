class deployCommonBuildSteps implements Serializable {
    def getDeployCommonBuildSteps(val) { 
		
		List commonDeploySteps = new ArrayList<Map<String,String>>();

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
		deployMap6.put("Project", "Exaxe.SolutionManager"); 
		deployMap6.put("Operation", "PublishInstallApp"); 
		commonDeploySteps.add(deployMap6);

		//Exaxe.Agent - BuildDatabase
		Map<String,String> deployMap7  = new HashMap<String,String>();
		deployMap7.put("Project", "Exaxe.Agent"); 
		deployMap7.put("Operation", "BuildDatabase"); 
		commonDeploySteps.add(deployMap7);

		//Exaxe.App - BuildDatabase
		Map<String,String> deployMap8  = new HashMap<String,String>();
		deployMap8.put("Project", "Exaxe.App"); 
		deployMap8.put("Operation", "BuildDatabase"); 
		commonDeploySteps.add(deployMap8);

		//Exaxe.Product.DatabaseModel - BuildDatabase
		Map<String,String> deployMap9  = new HashMap<String,String>();
		deployMap9.put("Project", "Exaxe.Product.DatabaseModel"); 
		deployMap9.put("Operation", "BuildDatabase"); 
		commonDeploySteps.add(deployMap9);

		//Exaxe.Common - BuildSolution
		Map<String,String> deployMap10  = new HashMap<String,String>();
		deployMap10.put("Project", "Exaxe.Common"); 
		deployMap10.put("Operation", "BuildDatabase"); 
		commonDeploySteps.add(deployMap10);

		//Exaxe.Configuration-Configuration - BuildSolution
		Map<String,String> deployMap11  = new HashMap<String,String>();
		deployMap11.put("Project", "Exaxe.Configuration-Configuration"); 
		deployMap11.put("Operation", "BuildDatabase"); 
		commonDeploySteps.add(deployMap11);

		switch (val) {
            case "DeployEposDev002ACORN":
                def eposDev002Class = new deployEposDev002ACORN();
				List eposDev002Steps = eposDev002Class.getDeploySteps();
				commonDeploySteps = commonDeploySteps + eposDev002Steps;
                break
			case "DeployEposPilotACORN":
                def eposPilotClass = new deployEposPilotACORN();
				List eposPilotSteps = eposPilotClass.getDeploySteps();
				commonDeploySteps = commonDeploySteps + eposPilotSteps;
                break
            default:             
                break
        }  

		//Release Content
		Map<String,String> deployMap12  = new HashMap<String,String>();
		deployMap12.put("Project", "Release Content"); 
		deployMap12.put("Operation", "Release Content"); 
		commonDeploySteps.add(deployMap12);

		//Return All of the defined steps
		commonDeploySteps
    }
}