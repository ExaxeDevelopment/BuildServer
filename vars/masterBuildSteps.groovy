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

            default:
                buildSteps.add("MasterBuildNotDefined");
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

	//// Returns the build items for "COMMON/BASE" solutions @ DEV001 (DEVELOPMENT + UAT/INTEGRATION)
	private List<String> getMasterBuildBaseDev001(){
		List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-Exaxe.Types-Dev001"); 
		buildItems.add("Build-Exaxe.Security-Dev001"); 
		buildItems.add("Build-Exaxe.Libraries-Dev001"); 
		buildItems.add("Build-Exaxe.Rest-Dev001"); 
		buildItems.add("Build-Exaxe.Web-Dev001"); 
		buildItems.add("Build-Exaxe.Common-Dev001"); 
		buildItems.add("Build-Exaxe.External-Dev001"); 
		buildItems.add("Build-Exaxe.Agent-Dev001"); 
		buildItems.add("Build-Exaxe.App-Dev001"); 
		buildItems.add("Build-Exaxe.Configuration-Dev001"); 
		buildItems.add("Build-Exaxe.Rules-Dev001"); 
		buildItems.add("Build-Exaxe.Comment-Dev001"); 
		buildItems.add("Build-Exaxe.Document-Dev001"); 
		buildItems.add("Build-Exaxe.SystemConfiguration-Dev001"); 
		buildItems.add("Build-Exaxe.Users-Dev001");
		buildItems.add("Build-Exaxe.Accounting-Dev001");
		buildItems.add("Build-Exaxe.Auth-Dev001"); 
		buildItems.add("Build-Exaxe.UIElements-Dev001");
		buildItems.add("Build-Exaxe.Calculations-Dev001");
		buildItems.add("Build-Exaxe.CalculationManagers-Dev001");
		buildItems.add("Build-Exaxe.ProductDevelopment-Dev001");

		return buildItems;
	}
 
	//// Returns the build + deploy items for "POLICY EBI (Aviva)" solutions @ DEV001 (DEVELOPMENT + UAT/INTEGRATION)
	private List<String> getMasterBuildPolicyEBIDev001(){
		List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-Exaxe.PolicyEBI-Dev001"); 
		buildItems.add("Build-ExistingBusinessUI-Dev001"); 
		buildItems.add("Deploy-Dev001-Aviva-Exaxe"); 
		buildItems.add("Deploy-Dev001-Aviva"); 
	
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
		buildItems.add("Build-Exaxe.Apex.Workflow-Dev001"); 
		buildItems.add("Build-Exaxe.Apex.Activities-Dev001"); 
		buildItems.add("Build-Exaxe.Apex.Server-Dev001"); 

		return buildItems;		
	}

	//// Returns the build items for "APEX SERVER/WORKFLOWS" solutions @ Dev002 (DEVELOPMENT)
	private List<String> getMasterBuildApexDev002(){
		List<String> buildItems = new ArrayList<String>();
		buildItems.add("Build-Exaxe.Apex.Workflow-Dev002"); 
		buildItems.add("Build-Exaxe.Apex.Activities-Dev002"); 
		buildItems.add("Build-Exaxe.Apex.Server-Dev002"); 

		return buildItems;		
	}

}