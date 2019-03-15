class masterDeploymentSteps implements Serializable {

	//// Returns all the available steps for deployment within the Exaxe solutions
	//// The information will be grouped in multiple collections that will contain the Operation and associated Project (if required)
	//// The operations inside each collection can be triggered in parallel
	def getMasterDeploymentSteps() { 
		List deploySteps = new ArrayList<ArrayList<Map<String,String>>>();

		// Initialisation
		List initialisationSteps = new ArrayList<Map<String,String>>();
		Map<String,String> initialisationMap  = new HashMap<String,String>();
		initialisationMap.put("Project", ""); 
		initialisationMap.put("Operation", "Initialisation"); 
		initialisationSteps.add(initialisationMap);
		deploySteps.add(initialisationSteps);

		// GetAllCodeLatestVersion
		List getCodeLatestVersionSteps = new ArrayList<Map<String,String>>();
		Map<String,String> getCodeLatestVersionMap  = new HashMap<String,String>();
		getCodeLatestVersionMap.put("Project", ""); 
		getCodeLatestVersionMap.put("Operation", "GetAllCodeLatestVersion"); 
		getCodeLatestVersionSteps.add(getCodeLatestVersionMap);
		deploySteps.add(getCodeLatestVersionSteps);

		// DeployInstallApp - Exaxe.SolutionManager
		List solutionManagerSteps = new ArrayList<Map<String,String>>();
		Map<String,String> solutionManagerMap  = new HashMap<String,String>();
		solutionManagerMap.put("Project", "Exaxe.SolutionManager"); 
		solutionManagerMap.put("Operation", "DeployInstallApp"); 
		solutionManagerSteps.add(solutionManagerMap);
		deploySteps.add(solutionManagerSteps);

		//// ********** First list with DB steps that will be triggered in parallel ********
		List projects01 = new ArrayList<String>();
		projects01.add("Exaxe.Agent");
		projects01.add("Exaxe.App");
		projects01.add("Exaxe.Product.DatabaseModel");
		projects01.add("Exaxe.Common");
		projects01.add("Exaxe.Configuration");
		deploySteps.add(getDatabaseSteps(projects01));

		//// ********** Second list with DB steps that will be triggered in parallel ********
		List projects02 = new ArrayList<String>();
		projects02.add("Exaxe.Comment");
		projects02.add("Exaxe.Document");
		projects02.add("Exaxe.SystemConfiguration");
		projects02.add("Exaxe.Accounting");
		projects02.add("Exaxe.Client");
		deploySteps.add(getDatabaseSteps(projects02));


		//// ********** Third list with DB steps that will be triggered in parallel ********
		List projects03 = new ArrayList<String>();
		projects03.add("Exaxe.AdminPlus");
		projects03.add("Exaxe.Apex");
		projects03.add("Exaxe.FactFind");
		projects03.add("Exaxe.Quote");
		deploySteps.add(getDatabaseSteps(projects03));

		//// ********** Fourth list with DB steps that will be triggered in parallel ********
		List projects04 = new ArrayList<String>();
		projects04.add("Exaxe.ExistingBusiness");
		projects04.add("Exaxe.ChannelPlus");
		projects04.add("Exaxe.Auth");
		projects04.add("Exaxe.PolicyEBI"); 
		deploySteps.add(getDatabaseSteps(projects04));

		deploySteps;
	}

	//// Get the database steps for the passed in projects 
	def getDatabaseSteps(List<String> projects){	
		List dbSteps = new ArrayList<Map<String,String>>();

		for(String project : projects){
			Map<String,String> dbMap  = new HashMap<String,String>();
			dbMap.put("Project", project); 
			dbMap.put("Operation", "DeployDatabase"); 
			dbSteps.add(dbMap);			
		}

		dbSteps;
	}

}