class masterDeploymentSteps implements Serializable {

	def getMasterUtilsDeploymentSteps() { 
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

		// DeployInstallApp - Exaxe.SolutionManager-Console
		List lifePlusMigrationUISteps = new ArrayList<Map<String,String>>();
		Map<String,String> lifePlusMigrationUIMap  = new HashMap<String,String>();
		lifePlusMigrationUIMap.put("Project", "LifePlus.Migration-UI"); 
		lifePlusMigrationUIMap.put("Operation", "DeployInstallApp"); 
		lifePlusMigrationUISteps.add(lifePlusMigrationUIMap);
		deploySteps.add(lifePlusMigrationUISteps);

		//Release Content
		List releaseContentSteps = new ArrayList<Map<String,String>>();
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseContent"); 
		releaseContentMap.put("Operation", "ReleaseContent"); 
		releaseContentSteps.add(releaseContentMap);
		deploySteps.add(releaseContentSteps);

		deploySteps;
	}

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

		// DeployInstallApp - Exaxe.SolutionManager-Console
		List solutionManagerConsoleSteps = new ArrayList<Map<String,String>>();
		Map<String,String> solutionManagerConsoleMap  = new HashMap<String,String>();
		solutionManagerConsoleMap.put("Project", "Exaxe.SolutionManager-Console"); 
		solutionManagerConsoleMap.put("Operation", "DeployInstallApp"); 
		solutionManagerConsoleSteps.add(solutionManagerConsoleMap);
		deploySteps.add(solutionManagerConsoleSteps);

		// DeployInstallApp - Exaxe.SolutionManager-UI
		List solutionManagerUISteps = new ArrayList<Map<String,String>>();
		Map<String,String> solutionManagerUIMap  = new HashMap<String,String>();
		solutionManagerUIMap.put("Project", "Exaxe.SolutionManager-UI"); 
		solutionManagerUIMap.put("Operation", "DeployInstallApp"); 
		solutionManagerUISteps.add(solutionManagerUIMap);
		deploySteps.add(solutionManagerUISteps);

		//// ******************** DATABASES - START ********************
		//// First list with DB projects that will be triggered in parallel 
		List dbProjects01 = new ArrayList<String>();
		dbProjects01.add("Exaxe.Agent-DB");
		dbProjects01.add("Exaxe.App-DB");
		dbProjects01.add("Exaxe.Product.DatabaseModel");
		dbProjects01.add("Exaxe.Common-DB");
		dbProjects01.add("Exaxe.Configuration-DB");
		dbProjects01.add("Exaxe.Configuration-Question-DB");
		dbProjects01.add("Exaxe.Configuration-Reference-DB");
		dbProjects01.add("Exaxe.Comment-DB");
		dbProjects01.add("Exaxe.Document-DB");
		dbProjects01.add("Exaxe.SystemConfiguration-DB");
		dbProjects01.add("Exaxe.Accounting-DB");
		dbProjects01.add("Exaxe.Client-DB");
		deploySteps.add(getDatabaseSteps(dbProjects01));

		//// Second list with DB projects that will be triggered in parallel 
		////List dbProjects02 = new ArrayList<String>();
		////deploySteps.add(getDatabaseSteps(dbProjects02));

		//// Third list with DB projects that will be triggered in parallel 
		List dbProjects03 = new ArrayList<String>();
		dbProjects03.add("Exaxe.AdminPlus-DB");
		dbProjects03.add("Exaxe.Apex-DB");
		dbProjects03.add("Exaxe.FactFind-DB");
		dbProjects03.add("Exaxe.Quote-DB");
		dbProjects03.add("Exaxe.ExistingBusiness-DB");
		dbProjects03.add("Exaxe.ChannelPlus-DB");
		dbProjects03.add("Exaxe.Auth-DB");
		dbProjects03.add("Exaxe.PolicyEBI-DB"); 
		deploySteps.add(getDatabaseSteps(dbProjects03));

		//// Fourth list with DB projects that will be triggered in parallel 
		////List dbProjects04 = new ArrayList<String>();
		////deploySteps.add(getDatabaseSteps(dbProjects04));
		//// ********************* DATABASES - END *********************

		//// ********************* WCF SERVICES - START *********************
		//// First list with WCF projects that will be triggered in parallel 
		List wcfProjects01 = new ArrayList<String>();
		wcfProjects01.add("Exaxe.Configuration-WCF");
		wcfProjects01.add("Exaxe.Client-WCF");
		wcfProjects01.add("Exaxe.AdminPlus-WCF");
		wcfProjects01.add("Exaxe.Apex-WCF");
		wcfProjects01.add("Exaxe.Aggregate-WCF");
		wcfProjects01.add("Exaxe.FactFind-WCF");
		wcfProjects01.add("Exaxe.Apex.Server-WCF");
		wcfProjects01.add("Exaxe.PolicyEBI-WCF");
		deploySteps.add(getWcfServiceSteps(wcfProjects01));

		//// Second list with WCF projects that will be triggered in parallel 
		////List wcfProjects02 = new ArrayList<String>();
		////deploySteps.add(getWcfServiceSteps(wcfProjects02));

		//// Third list with WCF projects that will be triggered in parallel 
		////List wcfProjects03 = new ArrayList<String>();
		////deploySteps.add(getWcfServiceSteps(wcfProjects03));
		//// ********************** WCF SERVICES - END **********************

		//// ********************* WEB API - START *********************
		//// First list with Web API projects that will be triggered in parallel 
		List apiProjects01 = new ArrayList<String>();
		apiProjects01.add("Exaxe.External-WebAPI");
		apiProjects01.add("Exaxe.Configuration-WebAPI");
		apiProjects01.add("Exaxe.SystemConfiguration-WebAPI");
		apiProjects01.add("Exaxe.Client-WebAPI");
		apiProjects01.add("Exaxe.AdminPlus-WebAPI");
		apiProjects01.add("Exaxe.Users-WebAPI");
		apiProjects01.add("Exaxe.Quote-WebAPI");
		apiProjects01.add("Exaxe.ChannelPlus-WebAPI");
		apiProjects01.add("Exaxe.Auth-WebAPI");		
		deploySteps.add(getWebApiSteps(apiProjects01));

		//// Second list with Web API projects that will be triggered in parallel 
		////List apiProjects02 = new ArrayList<String>();
		////deploySteps.add(getWebApiSteps(apiProjects02));

		//// Third list with Web API projects that will be triggered in parallel 
		////List apiProjects03 = new ArrayList<String>();
		////deploySteps.add(getWebApiSteps(apiProjects03));

		//// Fourth list with Web API projects that will be triggered in parallel 
		////List apiProjects04 = new ArrayList<String>();
		////deploySteps.add(getWebApiSteps(apiProjects04));

		//// Fifth list with Web API projects that will be triggered in parallel 
		List apiProjects05 = new ArrayList<String>();
		apiProjects05.add("Exaxe.Apex-WebAPI");
		apiProjects05.add("Exaxe.Apex.Workflow-WebAPI");
		apiProjects05.add("Exaxe.Document-WebAPI");
		apiProjects05.add("Exaxe.Aggregate-WebAPI");
		deploySteps.add(getWebApiSteps(apiProjects05));

		//// Sixth list with Web API projects that will be triggered in parallel 
		////List apiProjects06 = new ArrayList<String>();
		////deploySteps.add(getWebApiSteps(apiProjects06));
		//// ********************** WEB API - END **********************

		//// ********************* WEB SITE - START *********************
		//// First list with Web Site projects that will be triggered in parallel 
		List siteProjects01 = new ArrayList<String>();
		siteProjects01.add("AdminPlusUI-WebSite");
		siteProjects01.add("PointOfSaleUI-WebSite");
		siteProjects01.add("ChannelPlusUI-WebSite");
		siteProjects01.add("SystemConfigurationUI-WebSite");
		siteProjects01.add("ProductDevelopmentApplication-WebSite");
		siteProjects01.add("ExistingBusinessUI-WebSite");		
		deploySteps.add(getWebSiteSteps(siteProjects01));

		//// Second list with Web Site projects that will be triggered in parallel 
		////List siteProjects02 = new ArrayList<String>();

		////deploySteps.add(getWebSiteSteps(siteProjects02));

		//// Third list with Web Site projects that will be triggered in parallel 
		List siteProjects03 = new ArrayList<String>();
		siteProjects03.add("Hansard.Portals.Broker-WebSite");
		siteProjects03.add("Exaxe.Portals.Broker-WebSite");
		siteProjects03.add("Hansard.Portals.Client-WebSite");
		siteProjects03.add("Exaxe.Portals.Client-WebSite");
		deploySteps.add(getWebSiteSteps(siteProjects03));

		//// Fourth list with Web Site projects that will be triggered in parallel 
		////List siteProjects04 = new ArrayList<String>();
		////deploySteps.add(getWebSiteSteps(siteProjects04));

		//// Fifth list with Web Site projects that will be triggered in parallel 
		List siteProjects05 = new ArrayList<String>();
		siteProjects05.add("Exaxe.Portals.Court-WebSite");
		deploySteps.add(getWebSiteSteps(siteProjects05));

		//// ********************** WEB SITE - END **********************

		//Release Content
		List releaseContentSteps = new ArrayList<Map<String,String>>();
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseContent"); 
		releaseContentMap.put("Operation", "ReleaseContent"); 
		releaseContentSteps.add(releaseContentMap);
		deploySteps.add(releaseContentSteps);

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