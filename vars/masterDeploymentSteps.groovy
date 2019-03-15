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

		//// ******************** DATABASES - START ********************
		//// First list with DB projects that will be triggered in parallel 
		List dbProjects01 = new ArrayList<String>();
		dbProjects01.add("Exaxe.Agent");
		dbProjects01.add("Exaxe.App");
		dbProjects01.add("Exaxe.Product.DatabaseModel");
		dbProjects01.add("Exaxe.Common");
		dbProjects01.add("Exaxe.Configuration");
		deploySteps.add(getDatabaseSteps(dbProjects01));

		//// Second list with DB projects that will be triggered in parallel 
		List dbProjects02 = new ArrayList<String>();
		dbProjects02.add("Exaxe.Comment");
		dbProjects02.add("Exaxe.Document");
		dbProjects02.add("Exaxe.SystemConfiguration");
		dbProjects02.add("Exaxe.Accounting");
		dbProjects02.add("Exaxe.Client");
		deploySteps.add(getDatabaseSteps(dbProjects02));

		//// Third list with DB projects that will be triggered in parallel 
		List dbProjects03 = new ArrayList<String>();
		dbProjects03.add("Exaxe.AdminPlus");
		dbProjects03.add("Exaxe.Apex");
		dbProjects03.add("Exaxe.FactFind");
		dbProjects03.add("Exaxe.Quote");
		deploySteps.add(getDatabaseSteps(dbProjects03));

		//// Fourth list with DB projects that will be triggered in parallel 
		List dbProjects04 = new ArrayList<String>();
		dbProjects04.add("Exaxe.ExistingBusiness");
		dbProjects04.add("Exaxe.ChannelPlus");
		dbProjects04.add("Exaxe.Auth");
		dbProjects04.add("Exaxe.PolicyEBI"); 
		deploySteps.add(getDatabaseSteps(dbProjects04));
		//// ********************* DATABASES - END *********************

		//// ********************* WCF SERVICES - START *********************
		//// First list with WCF projects that will be triggered in parallel 
		List wcfProjects01 = new ArrayList<String>();
		wcfProjects01.add("Exaxe.Configuration");
		wcfProjects01.add("Exaxe.Client");
		wcfProjects01.add("Exaxe.AdminPlus");
		deploySteps.add(getWcfServiceSteps(wcfProjects01));

		//// Second list with WCF projects that will be triggered in parallel 
		List wcfProjects02 = new ArrayList<String>();
		wcfProjects02.add("Exaxe.Apex");
		wcfProjects02.add("Exaxe.Aggregate");
		wcfProjects02.add("Exaxe.FactFind");
		deploySteps.add(getWcfServiceSteps(wcfProjects02));

		//// Third list with WCF projects that will be triggered in parallel 
		List wcfProjects03 = new ArrayList<String>();
		wcfProjects03.add("Exaxe.Apex.Server");
		wcfProjects03.add("Exaxe.PolicyEBI");
		deploySteps.add(getWcfServiceSteps(wcfProjects03));
		//// ********************** WCF SERVICES - END **********************

		//// ********************* WEB API - START *********************
		//// First list with Web API projects that will be triggered in parallel 
		List apiProjects01 = new ArrayList<String>();
		apiProjects01.add("Exaxe.External");
		apiProjects01.add("Exaxe.Configuration");
		apiProjects01.add("Exaxe.Document");
		deploySteps.add(getWebApiSteps(apiProjects01));

		//// Second list with Web API projects that will be triggered in parallel 
		List apiProjects02 = new ArrayList<String>();
		apiProjects02.add("Exaxe.SystemConfiguration");
		apiProjects02.add("Exaxe.Users");
		apiProjects02.add("Exaxe.Client");
		deploySteps.add(getWebApiSteps(apiProjects02));

		//// Third list with Web API projects that will be triggered in parallel 
		List apiProjects03 = new ArrayList<String>();
		apiProjects03.add("Exaxe.AdminPlus");
		apiProjects03.add("Exaxe.Apex");
		apiProjects03.add("Exaxe.Aggregate");
		deploySteps.add(getWebApiSteps(apiProjects03));

		//// Fourth list with Web API projects that will be triggered in parallel 
		List apiProjects04 = new ArrayList<String>();
		apiProjects04.add("Exaxe.Quote");
		apiProjects04.add("Exaxe.ChannelPlus");
		apiProjects04.add("Exaxe.Auth");
		deploySteps.add(getWebApiSteps(apiProjects04));

		//// Fifth list with Web API projects that will be triggered in parallel 
		List apiProjects05 = new ArrayList<String>();
		apiProjects05.add("Exaxe.Apex.Workflow");
		deploySteps.add(getWebApiSteps(apiProjects05));
		//// ********************** WEB API - END **********************

		//// ********************* WEB SITE - START *********************
		//// First list with Web Site projects that will be triggered in parallel 
		List siteProjects01 = new ArrayList<String>();
		siteProjects01.add("AdminPlusUI");
		siteProjects01.add("PointOfSaleUI");
		siteProjects01.add("ChannelPlusUI");
		deploySteps.add(getWebSiteSteps(siteProjects01));

		//// Second list with Web Site projects that will be triggered in parallel 
		List siteProjects02 = new ArrayList<String>();
		siteProjects02.add("SystemConfigurationUI");
		siteProjects02.add("ProductDevelopmentApplication");
		siteProjects02.add("ExistingBusinessUI");
		deploySteps.add(getWebSiteSteps(siteProjects02));

		//// Third list with Web Site projects that will be triggered in parallel 
		List siteProjects03 = new ArrayList<String>();
		siteProjects03.add("Hansard.Portals.Broker");
		siteProjects03.add("Hansard.Portals.Client");
		deploySteps.add(getWebSiteSteps(siteProjects03));

		//// Fourth list with Web Site projects that will be triggered in parallel 
		List siteProjects04 = new ArrayList<String>();
		siteProjects04.add("Exaxe.Portals.Broker");
		siteProjects04.add("Exaxe.Portals.Client");
		deploySteps.add(getWebSiteSteps(siteProjects04));

		//// ********************** WEB SITE - END **********************

		deploySteps;
	}

	//// Get the steps for the passed in projects and operation 
	def getSteps(List<String> projects, String operation){	
		List steps = new ArrayList<Map<String,String>>();

		for(String project : projects){
			Map<String,String> map = new HashMap<String,String>();
			map.put("Project", project); 
			map.put("Operation", operation); 
			steps.add(map);			
		}

		steps;
	}

	//// Get the database steps for the passed in projects 
	def getDatabaseSteps(List<String> projects){	
		List steps = getSteps(projects, "DeployDatabase");

		steps;
	}

	//// Get the WCF Service steps for the passed in projects 
	def getWcfServiceSteps(List<String> projects){	
		List steps = getSteps(projects, "DeployWcfService");

		steps;
	}

	//// Get the Web API steps for the passed in projects 
	def getWebApiSteps(List<String> projects){	
		List steps = getSteps(projects, "DeployWebApi");

		steps;		
	}

	//// Get the Web Site steps for the passed in projects 
	def getWebSiteSteps(List<String> projects){	
		List steps = getSteps(projects, "DeployWebSite");

		steps;
	}

}