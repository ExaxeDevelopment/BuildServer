class masterBuildSteps implements Serializable {
	//// Returns the build steps based on the 'masterBuildType'
	//// The 'firstProject' indicates from where in the list the build will start
    def getMasterBuildSteps(masterBuildType, firstProject) { 

		List<String> buildSteps = new ArrayList<String>();

        switch (masterBuildType) {
			case "MasterBuildBaseDev001":
                buildSteps = getMasterBuildBaseDev001();
                break

			case "MasterBuildPolicyEBIDev001":
                buildSteps = getMasterBuildPolicyEBIDev001();
				break

            case "MasterBuildAdminPlusDev001":
                buildSteps = getMasterBuildAdminPlusDev001();
                break

            case "MasterBuildAdminPlusDev002":
                buildSteps = getMasterBuildAdminPlusDev002();
                break

			case "MasterBuildAdvicePlusDev001":
                buildSteps = getMasterBuildAdvicePlusDev001();
                break

			case "MasterBuildAdvicePlusDev002":
                buildSteps = getMasterBuildAdvicePlusDev002();
                break

			case "MasterBuildChannelPlusDev001":
                buildSteps = getMasterBuildChannelPlusDev001();
                break

			case "MasterBuildChannelPlusDev002":
                buildSteps = getMasterBuildChannelPlusDev002();
                break

			case "MasterBuildApexDev001":
                buildSteps = getMasterBuildApexDev001();
                break
				
			case "MasterBuildApexDev002":
                buildSteps = getMasterBuildApexDev002();
                break

			case "MasterBuildWebServicesDev001":
                buildSteps = getMasterBuildWebServicesDev001();
                break
				
			case "MasterBuildWebServicesDev002":
                buildSteps = getMasterBuildWebServicesDev002();
                break

			case "IntermediateMasterBuildAdminPlusDev002":
                buildSteps = getSequentialMasterBuildAdminPlusDev002();
                break

			case "IntermediateMasterBuildAdvicePlusDev002":
                buildSteps = getSequentialMasterBuildAdvicePlusDev002();
                break
			case "MasterBuildUtils":
                buildSteps = getMasterBuildUtils();
                break

            default:
                break
        }   

		int indexOfStartStep = buildSteps.indexOf(firstProject);
        
		if(indexOfStartStep == -1){
			indexOfStartStep = 0;
		}

		// Return Selected MasterBuildSteps
		def steps = buildSteps.subList(Math.max(indexOfStartStep, 0), buildSteps.size()).collect();
		
		steps
    } 

	//// Returns the parallel build steps based on the 'masterBuildType'
    def getMasterBuildParallelSteps(masterBuildType) { 

		List<String> buildSteps = new ArrayList<String>();

        switch (masterBuildType) {
			case "IntermediateMasterBuildAdminPlusDev002":
                buildSteps = getParallelMasterBuildAdminPlusDev002();
                break

			case "IntermediateMasterBuildAdvicePlusDev002":
                buildSteps = getParallelMasterBuildAdvicePlusDev002();
                break

			case "IntermediateMasterBuildChannelPlusDev002":
                buildSteps = getParallelMasterBuildChannelPlusDev002();
                break

			case "IntermediateMasterBuildApexDev002":
                buildSteps = getParallelMasterBuildAPEXDev002();
                break

			case "IntermediateMasterBuildWebServiceDev002":
                buildSteps = getParallelMasterBuildWebServiceDev002();
                break

            default:
                break
        }   

		buildSteps
    } 

	//// Returns the build items for "COMMON/BASE" solutions @ DEV001 (DEVELOPMENT + UAT/INTEGRATION)
	private List<String> getMasterBuildBaseDev001(){
		List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-Exaxe.Types-Dev001"); 
		buildItems.add("Build-Exaxe.Security-Dev001"); 
		buildItems.add("Build-Exaxe.Libraries-Dev001"); 
		buildItems.add("Build-Exaxe.Rest-Dev001"); 
		buildItems.add("Build-Exaxe.Web-Dev001"); 
		buildItems.add("Build-Exaxe.Auth-Dev001"); 
		buildItems.add("Build-Exaxe.Common-Dev001"); 
		buildItems.add("Build-Exaxe.External-Dev001");	
		buildItems.add("Build-Exaxe.Agent-Dev001"); 
		buildItems.add("Build-Exaxe.App-Dev001"); 
		buildItems.add("Build-Exaxe.Configuration-Dev001"); 
		buildItems.add("Build-Exaxe.Rules-Dev001"); 
		buildItems.add("Build-Exaxe.Comment-Dev001"); 
		buildItems.add("Build-Exaxe.SystemConfiguration-Dev001"); 
		buildItems.add("Build-Exaxe.Users-Dev001");
		buildItems.add("Build-Exaxe.Document-Dev001"); 
		buildItems.add("Build-Exaxe.Configuration.WCF-Dev001"); 
		buildItems.add("Build-Exaxe.Accounting-Dev001");
		buildItems.add("Build-Exaxe.Calculations-Dev001");
		buildItems.add("Build-Exaxe.CalculationManagers-Dev001");
		buildItems.add("Build-Exaxe.UIElements-Dev001");

		return buildItems;
	}
 
	//// Returns the build items for "POLICY EBI (Aviva)" solutions @ DEV001 (DEVELOPMENT + UAT/INTEGRATION)
	private List<String> getMasterBuildPolicyEBIDev001(){
		List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-Exaxe.PolicyEBI-Dev001"); 
		buildItems.add("Build-ExistingBusinessUI-Dev001"); 
	
		return buildItems;
	}

	//// Returns the build items for "ADMIN PLUS" solutions @ DEV001 (UAT/INTEGRATION)
	private List<String> getMasterBuildAdminPlusDev001(){

        List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-Exaxe.Client-Dev001"); 
		buildItems.add("Build-Exaxe.AdminPlus-Dev001"); 
		buildItems.add("Build-Exaxe.Apex-Dev001");
		buildItems.add("Build-Exaxe.Aggregate-Dev001"); 

		return buildItems;
	}

	//// Returns the build items for "ADMIN PLUS" solutions @ DEV002 (DEVELOPMENT)
	private List<String> getMasterBuildAdminPlusDev002(){

        List<String> buildItems = new ArrayList<String>();
		buildItems.add("Build-Exaxe.Client-Dev002"); 
		buildItems.add("Build-Exaxe.AdminPlus-Dev002"); 
		buildItems.add("Build-Exaxe.Apex-Dev002"); 
		buildItems.add("Build-Exaxe.Aggregate-Dev002"); 

		return buildItems;
	}

	//// Returns the build items for "ADVICE PLUS" solutions @ DEV001 (UAT/INTEGRATION)
	private List<String> getMasterBuildAdvicePlusDev001(){
		List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-Exaxe.Client-Dev003");
		buildItems.add("Build-Exaxe.FactFind-Dev001");
		buildItems.add("Build-Exaxe.Quote.Rules-Dev001");
		buildItems.add("Build-Exaxe.Quote-Dev001");
		buildItems.add("Build-Exaxe.ExistingBusiness-Dev001");
	
		return buildItems;
	}

	//// Returns the build items for "ADVICE PLUS" solutions @ DEV002 (DEVELOPMENT)
	private List<String> getMasterBuildAdvicePlusDev002(){
		List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-Exaxe.Client-Dev003");
		buildItems.add("Build-Exaxe.FactFind-Dev002");
		buildItems.add("Build-Exaxe.Quote.Rules-Dev002");
		buildItems.add("Build-Exaxe.Quote-Dev002");
		buildItems.add("Build-Exaxe.ExistingBusiness-Dev002");
	
		return buildItems;
	}

	//// Returns the build items for "CHANNEL PLUS" solutions @ Dev001 (UAT/INTEGRATION)
	private List<String> getMasterBuildChannelPlusDev001(){
		List<String> buildItems = new ArrayList<String>();
		buildItems.add("Build-Exaxe.ChannelPlus-Dev001"); 	

		return buildItems;		
	}

	//// Returns the build items for "CHANNEL PLUS" solutions @ Dev002 (DEVELOPMENT)
	private List<String> getMasterBuildChannelPlusDev002(){
		List<String> buildItems = new ArrayList<String>();
		buildItems.add("Build-Exaxe.ChannelPlus-Dev002"); 	

		return buildItems;		
	}
 
	//// Returns the build items for "APEX SERVER/WORKFLOWS" solutions @ Dev001 (UAT/INTEGRATION)
	private List<String> getMasterBuildApexDev001(){
		List<String> buildItems = new ArrayList<String>();
		buildItems.add("Build-Exaxe.Apex.Activities-Dev001"); 
		buildItems.add("Build-Exaxe.Apex.Server-Dev001"); 

		return buildItems;		
	}

	//// Returns the build items for "APEX SERVER/WORKFLOWS" solutions @ Dev002 (DEVELOPMENT)
	private List<String> getMasterBuildApexDev002(){
		List<String> buildItems = new ArrayList<String>();
		buildItems.add("Build-Exaxe.Apex.Activities-Dev002"); 
		buildItems.add("Build-Exaxe.Apex.Server-Dev002"); 

		return buildItems;		
	}

	//// Returns the build items for "Web Services" solutions @ Dev001 (UAT/INTEGRATION)
	private List<String> getMasterBuildWebServicesDev001(){
		List<String> buildItems = new ArrayList<String>();
		buildItems.add("Build-Exaxe.WebApi-Dev001"); 
		buildItems.add("Build-Exaxe.WCF-Dev001"); 

		return buildItems;		
	}

	//// Returns the build items for "Web Services" solutions @ Dev002 (DEVELOPMENT)
	private List<String> getMasterBuildWebServicesDev002(){
		List<String> buildItems = new ArrayList<String>();
		buildItems.add("Build-Exaxe.WebApi-Dev002"); 
		buildItems.add("Build-Exaxe.WCF-Dev002"); 

		return buildItems;		
	}


	///*************************************************************************************
	///********************* STEPS FOR THE INTERMEDIATE BUILDS - BEGIN *********************
	///*************************************************************************************

	//// Returns the parallel builds for ADMIN PLUS solutions @ DEV002 (DEVELOPMENT)
	private List<String> getParallelMasterBuildAdminPlusDev002(){
		List<String> buildItems = new ArrayList<String>()
		buildItems.add("Intermediate-Build-Exaxe.Client-Dev002"); 

		return buildItems;
	} 

	//// Returns the parallel builds for ADVICE PLUS solutions @ DEV002 (DEVELOPMENT)
	private List<String> getParallelMasterBuildAdvicePlusDev002(){
		List<String> buildItems = new ArrayList<String>()
		buildItems.add("Intermediate-Build-Exaxe.FactFind-Dev002");
		buildItems.add("Intermediate-Build-Exaxe.Quote.Rules-Dev002");

		return buildItems;
	} 

	//// Returns the parallel builds for CHANNEL PLUS solutions @ DEV002 (DEVELOPMENT)
	private List<String> getParallelMasterBuildChannelPlusDev002(){
		List<String> buildItems = new ArrayList<String>()
		buildItems.add("Intermediate-Build-Exaxe.ChannelPlus-Dev002"); 

		return buildItems;
	} 

	//// Returns the parallel builds for APEX SERVER/WORKFLOW solutions @ DEV002 (DEVELOPMENT)
	private List<String> getParallelMasterBuildAPEXDev002(){
		List<String> buildItems = new ArrayList<String>();
		buildItems.add("Intermediate-Build-Exaxe.Apex.Workflow-Dev002"); 
		buildItems.add("Intermediate-Build-Exaxe.Apex.Activities-Dev002"); 

		return buildItems;
	} 

	//// Returns the sequential builds for ADMIN PLUS solutions @ DEV002 (DEVELOPMENT)
	private List<String> getSequentialMasterBuildAdminPlusDev002(){
		List<String> buildItems = new ArrayList<String>();
		buildItems.add("Intermediate-Build-Exaxe.AdminPlus-Dev002"); 
		buildItems.add("Intermediate-Build-Exaxe.Apex-Dev002"); 
		buildItems.add("Intermediate-Build-Exaxe.Aggregate-Dev002"); 

		return buildItems;
	} 

	//// Returns the sequential builds for ADVICE PLUS solutions @ DEV002 (DEVELOPMENT)
	private List<String> getSequentialMasterBuildAdvicePlusDev002(){
		List<String> buildItems = new ArrayList<String>();
		buildItems.add("Intermediate-Build-Exaxe.Quote-Dev002");
		buildItems.add("Intermediate-Build-Exaxe.ExistingBusiness-Dev002");

		return buildItems;
	}
	
	//// Returns the parallel builds for WEB SERVICE solutions @ DEV002 (DEVELOPMENT)
	private List<String> getParallelMasterBuildWebServiceDev002(){
		List<String> buildItems = new ArrayList<String>();
		buildItems.add("Build-Exaxe.Apex.Server-Dev002"); 
		buildItems.add("Intermediate-Build-Exaxe.WebApi-Dev002"); 

		return buildItems;
	} 

	///***********************************************************************************
	///********************* STEPS FOR THE INTERMEDIATE BUILDS - END *********************
	///***********************************************************************************

	///******************************************************************************
	///********************* STEPS FOR THE UTILS BUILDS - START *********************
	///******************************************************************************
	private List<String> getMasterBuildUtils(){
		List<String> buildItems = new ArrayList<String>();
		buildItems.add("Build-Build-AppMonitor-Main"); 
		buildItems.add("Build-LifePlus.Migration-Main"); 
		buildItems.add("Build-Build-Escrow-Main"); 
		buildItems.add("Build-Exaxe.ProductDevelopment-Dev001");
		buildItems.add("Build-Exaxe.ProductDevelopment.UI-Dev001")	

		return buildItems;
	}

	///******************************************************************************
	///********************* STEPS FOR THE UTILS BUILDS - END *********************
	///******************************************************************************
}