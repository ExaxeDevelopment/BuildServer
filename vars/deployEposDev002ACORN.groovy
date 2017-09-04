class deployEposDev002ACORN implements Serializable {
    def getDeploySteps() { 
		
		List deploySteps = new ArrayList<Map<String,String>>();

		//Exaxe.Configuration-Question - BuildDatabase
		Map<String,String> eposDev002DeployMap1 = new HashMap<String,String>();
		eposDev002DeployMap1.put("Project", "Exaxe.Configuration-Question"); 
		eposDev002DeployMap1.put("Operation", "BuildDatabase"); 
		deploySteps.add(eposDev002DeployMap1);

		//Exaxe.SystemConfiguration - BuildDatabase
		Map<String,String> eposDev002DeployMap2 = new HashMap<String,String>();
		eposDev002DeployMap2.put("Project", "Exaxe.SystemConfiguration"); 
		eposDev002DeployMap2.put("Operation", "BuildDatabase"); 
		deploySteps.add(eposDev002DeployMap2);

		//Exaxe.Client  - BuildDatabase
		Map<String,String> eposDev002DeployMap3 = new HashMap<String,String>();
		eposDev002DeployMap3.put("Project", "Exaxe.Client "); 
		eposDev002DeployMap3.put("Operation", "BuildDatabase"); 
		deploySteps.add(eposDev002DeployMap3);

		//Exaxe.FactFind - BuildDatabase
		Map<String,String> eposDev002DeployMap4 = new HashMap<String,String>();
		eposDev002DeployMap4.put("Project", "Exaxe.FactFind"); 
		eposDev002DeployMap4.put("Operation", "BuildDatabase"); 
		deploySteps.add(eposDev002DeployMap4);

		//Exaxe.Quote  - BuildDatabase
		Map<String,String> eposDev002DeployMap5 = new HashMap<String,String>();
		eposDev002DeployMap5.put("Project", "Exaxe.Quote "); 
		eposDev002DeployMap5.put("Operation", "BuildDatabase"); 
		deploySteps.add(eposDev002DeployMap5);

		//Exaxe.ExistingBusiness - BuildDatabase
		Map<String,String> eposDev002DeployMap6 = new HashMap<String,String>();
		eposDev002DeployMap6.put("Project", "Exaxe.ExistingBusiness"); 
		eposDev002DeployMap6.put("Operation", "BuildDatabase"); 
		deploySteps.add(eposDev002DeployMap6);

		//Exaxe.FactFind  - PublishWebService
		Map<String,String> eposDev002DeployMap7 = new HashMap<String,String>();
		eposDev002DeployMap7.put("Project", "Exaxe.FactFind "); 
		eposDev002DeployMap7.put("Operation", "PublishWebService"); 
		deploySteps.add(eposDev002DeployMap7);

		//Exaxe.SystemConfigurationUI - PublishWebSite
		Map<String,String> eposDev002DeployMap8  = new HashMap<String,String>();
		eposDev002DeployMap8.put("Project", "SystemConfigurationUI"); 
		eposDev002DeployMap8.put("Operation", "PublishWebSite"); 
		deploySteps.add(eposDev002DeployMap8);

		//Return All of the defined steps
		deploySteps
    }
}