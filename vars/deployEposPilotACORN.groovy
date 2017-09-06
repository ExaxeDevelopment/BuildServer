class deployEposPilotACORN implements Serializable {
    def getDeploySteps() { 
		
		List deploySteps = new ArrayList<Map<String,String>>();

		//Exaxe.Configuration-Question - BuildDatabase
		Map<String,String> eposPilotDeployMap1 = new HashMap<String,String>();
		eposPilotDeployMap1.put("Project", "Exaxe.Configuration-Question"); 
		eposPilotDeployMap1.put("Operation", "BuildDatabase"); 
		deploySteps.add(eposPilotDeployMap1);

		//Exaxe.SystemConfiguration - BuildDatabase
		Map<String,String> eposPilotDeployMap2 = new HashMap<String,String>();
		eposPilotDeployMap2.put("Project", "Exaxe.SystemConfiguration"); 
		eposPilotDeployMap2.put("Operation", "BuildDatabase"); 
		deploySteps.add(eposPilotDeployMap2);

		//Exaxe.Client  - BuildDatabase
		Map<String,String> eposPilotDeployMap3 = new HashMap<String,String>();
		eposPilotDeployMap3.put("Project", "Exaxe.Client "); 
		eposPilotDeployMap3.put("Operation", "BuildDatabase"); 
		deploySteps.add(eposPilotDeployMap3);

		//Exaxe.FactFind - BuildDatabase
		Map<String,String> eposPilotDeployMap4 = new HashMap<String,String>();
		eposPilotDeployMap4.put("Project", "Exaxe.FactFind"); 
		eposPilotDeployMap4.put("Operation", "BuildDatabase"); 
		deploySteps.add(eposPilotDeployMap4);

		//Exaxe.Quote  - BuildDatabase
		Map<String,String> eposPilotDeployMap5 = new HashMap<String,String>();
		eposPilotDeployMap5.put("Project", "Exaxe.Quote "); 
		eposPilotDeployMap5.put("Operation", "BuildDatabase"); 
		deploySteps.add(eposPilotDeployMap5);

		//Exaxe.ExistingBusiness - BuildDatabase
		Map<String,String> eposPilotDeployMap6 = new HashMap<String,String>();
		eposPilotDeployMap6.put("Project", "Exaxe.ExistingBusiness"); 
		eposPilotDeployMap6.put("Operation", "BuildDatabase"); 
		deploySteps.add(eposPilotDeployMap6);

		//Exaxe.FactFind  - PublishWebService
		Map<String,String> eposPilotDeployMap7 = new HashMap<String,String>();
		eposPilotDeployMap7.put("Project", "Exaxe.FactFind "); 
		eposPilotDeployMap7.put("Operation", "PublishWebService"); 
		deploySteps.add(eposPilotDeployMap7);

		//Exaxe.SystemConfigurationUI - GetCodeLatestVersion
		Map<String,String> eposPilotDeployMap8  = new HashMap<String,String>();
		eposPilotDeployMap8.put("Project", "SystemConfigurationUI"); 
		eposPilotDeployMap8.put("Operation", "GetCodeLatestVersion"); 
		deploySteps.add(eposPilotDeployMap8);

		//Exaxe.SystemConfigurationUI - RestoreNuGetPackages
		Map<String,String> eposPilotDeployMap9  = new HashMap<String,String>();
		eposPilotDeployMap9.put("Project", "SystemConfigurationUI"); 
		eposPilotDeployMap9.put("Operation", "RestoreNuGetPackages"); 
		deploySteps.add(eposPilotDeployMap9);

		//Exaxe.SystemConfigurationUI - PublishWebSite
		Map<String,String> eposPilotDeployMap10  = new HashMap<String,String>();
		eposPilotDeployMap10.put("Project", "SystemConfigurationUI"); 
		eposPilotDeployMap10.put("Operation", "PublishWebSite"); 
		deploySteps.add(eposPilotDeployMap10);

		//PointOfSaleUI- GetCodeLatestVersion
		Map<String,String> eposPilotDeployMap11  = new HashMap<String,String>();
		eposPilotDeployMap11.put("Project", "PointOfSaleUI"); 
		eposPilotDeployMap11.put("Operation", "GetCodeLatestVersion"); 
		deploySteps.add(eposPilotDeployMap11);

		//PointOfSaleUI - PublishWebSite
		Map<String,String> eposPilotDeployMap12  = new HashMap<String,String>();
		eposPilotDeployMap12.put("Project", "PointOfSaleUI"); 
		eposPilotDeployMap12.put("Operation", "PublishWebSite"); 
		deploySteps.add(eposPilotDeployMap12);

		//Return All of the defined steps
		deploySteps
    }
}