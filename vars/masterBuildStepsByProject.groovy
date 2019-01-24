class masterBuildStepsByProject implements Serializable {
	//// Returns the build steps based on the 'masterBuildType'
	//// The 'firstProject' indicates from where in the list the build will start
    def getMasterBuildStepsByProject(masterBuildType, firstProject) { 

		List<String> buildSteps = new ArrayList<String>();

        switch (masterBuildType) {
			case "MasterBuildBaseDev001":
                buildSteps = getMasterBuildBaseDev001();
                break
            case "MasterBuildAdminPlusDev001":
                buildSteps = getMasterBuildAdminPlusDev001();
                break
            case "MasterBuildAdminPlusDev002":
                buildSteps = getMasterBuildAdminPlusDev002();
                break
            case "MasterBuildAdminPlusRelease":
                buildSteps = getMasterBuildAdminPlusRelease();
                break
			case "MasterBuildAdminPlusReleaseV2":
                buildSteps = getMasterBuildAdminPlusReleaseV2();
                break
			case "MasterBuildAdvicePlusDev001":
                buildSteps = getMasterBuildAdvicePlusDev001();
                break
			case "MasterBuildAdvicePlusDev002":
                buildSteps = getMasterBuildAdvicePlusDev002();
                break
			case "MasterBuildAdvicePlusRelease":
                buildSteps = getMasterBuildAdvicePlusRelease();
                break
			case "MasterBuildPolicyEBIDev001":
                buildSteps = getMasterBuildPolicyEBIDev001();
                break
			case "MasterBuildChannelPlusDev001":
                buildSteps = getMasterBuildChannelPlusDev001();
                break
			case "MasterBuildChannelPlusDev002":
                buildSteps = getMasterBuildChannelPlusDev002();
                break
			case "MasterBuildHansardPortalsDev001":
                buildSteps = getMasterBuildHansardPortalsDev001();
                break
			case "MasterBuildHansardPortalsDev002":
                buildSteps = getMasterBuildHansardPortalsDev002();
                break
			case "MasterBuildProductDevelopmentDev001":
                buildSteps = getMasterBuildProductDevelopmentDev001();
                break
			case "MasterDeployDev002Hansard":
                buildSteps = getMasterDeployDev002Hansard();
                break
			case "MasterDeployDev002HansardSingle":
                buildSteps = getMasterDeployDev002HansardSingle();
                break	
			case "MasterDeployDev001HansardSingle":
                buildSteps = getMasterDeployDev001HansardSingle();
                break	
			case "MasterDeployDev001Hansard":
                buildSteps = getMasterDeployDev001Hansard();
                break	
			case "MasterDeployDev001HansardExaxe":
                buildSteps = getMasterDeployDev001HansardExaxe();
                break	
			case "MasterDeployDev001HansardTest":
                buildSteps = getMasterDeployDev001HansardTest();
                break	
			case "MasterDeployDev001HansardStaging":
                buildSteps = getMasterDeployDev001HansardStaging();
                break	
			case "MasterDeployDev001HansardProduction":
                buildSteps = getMasterDeployDev001HansardProduction();
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

	//// Returns the build steps to be executed in parallel and in sequence, based on the 'masterBuildType'
	def getMasterBuildParallelStepsByProject(masterBuildType) { 

		List<String> masterBuildParallelAdminPlusIntermediate = new ArrayList<String>();
		masterBuildParallelAdminPlusIntermediate.add("Build-Exaxe.Client-Dev-Intermediate"); 
		masterBuildParallelAdminPlusIntermediate.add("Build-Exaxe.AdminPlus-Dev-Intermediate"); 
		masterBuildParallelAdminPlusIntermediate.add("Build-Exaxe.Apex-Dev-Intermediate"); 
		masterBuildParallelAdminPlusIntermediate.add("Build-Exaxe.Aggregate-Dev-Intermediate"); 
		masterBuildParallelAdminPlusIntermediate.add("Build-Exaxe.Apex.Activities-Dev-Intermediate"); 

        List<String> masterBuildSequenceAdminPlusIntermediate = new ArrayList<String>();
		masterBuildSequenceAdminPlusIntermediate.add("Build-Exaxe.Apex.Server-Dev002"); 
		masterBuildSequenceAdminPlusIntermediate.add("Build-AdminPlusUI-Dev002"); 

		List<List<String>> buildSteps = new ArrayList<ArrayList<String>>();
        switch (masterBuildType) {
            case "MasterBuildAdminPlusDevIntermediate":
				buildSteps.add(masterBuildParallelAdminPlusIntermediate);
				buildSteps.add(masterBuildSequenceAdminPlusIntermediate);
                break
            default:
                break
		}

		buildSteps
	}

	//// Returns the build items for "COMMON/BASE" solutions @ DEV001 (UAT/INTEGRATION)
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
		buildItems.add("Build-SystemConfigurationUI-Dev001");
		buildItems.add("Build-Exaxe.Calculations-Dev001");

		return buildItems;
	}

	//// Returns the build + deploy items for "ADMIN PLUS" solutions @ DEV001 (UAT/INTEGRATION)
	private List<String> getMasterBuildAdminPlusDev001(){

        List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-Exaxe.Client-Dev001"); 
		buildItems.add("Build-Exaxe.AdminPlus-Dev001"); 
		buildItems.add("Build-Exaxe.Apex-Dev001");
		buildItems.add("Build-Exaxe.Aggregate-Dev001"); 
		buildItems.add("Build-Exaxe.Apex.Activities-Dev001"); 
		buildItems.add("Build-Exaxe.Apex.Server-Dev001"); 
		buildItems.add("Build-AdminPlusUI-Dev001"); 

		//// NOTE: Commented deployments can be re-added if the customer/environment must be included.

		//// ONE FAMILY DEPLOYMENT SECTION
		// buildItems.add("Deploy-AdminPlus-Dev001-OneFamily"); 
		// buildItems.add("Deploy-AdminPlus-Dev001-OneFamily-Exaxe"); 
		// buildItems.add("Deploy-AdminPlus-Dev001-OneFamily-Test"); 
		// buildItems.add("Deploy-AdminPlus-Dev001-OneFamily-Staging"); 
		// buildItems.add("Deploy-AdminPlus-Dev001-OneFamily-Production"); 

		//// POLICE MUTUAL DEPLOYMENT SECTION
		// buildItems.add("Deploy-AdminPlus-Dev001-PoliceMutual"); 

		//// SALES DEMO DEPLOYMENT SECTION
		// buildItems.add("Deploy-AdminPlus-Dev001-SalesDemo"); 

		return buildItems;
	}

	//// Returns the build + deploy items for "ADMIN PLUS" solutions @ DEV002 (DEVELOPMENT)
	private List<String> getMasterBuildAdminPlusDev002(){

        List<String> buildItems = new ArrayList<String>();
		buildItems.add("Build-Exaxe.Client-Dev002"); 
		buildItems.add("Build-Exaxe.AdminPlus-Dev002"); 
		buildItems.add("Build-Exaxe.Apex-Dev002"); 
		buildItems.add("Build-Exaxe.Aggregate-Dev002"); 
		buildItems.add("Build-Exaxe.Apex.Activities-Dev002"); 
		buildItems.add("Build-Exaxe.Apex.Server-Dev002"); 
		buildItems.add("Build-AdminPlusUI-Dev002"); 

		//// Commented deployments can be re-added if the customer/environment must be included.

		//// FORESTERS SECTION
		buildItems.add("Deploy-AdminPlus-Dev002-Foresters"); 

		//// ONE FAMILY SECTION
		buildItems.add("Deploy-AdminPlus-Dev002-OneFamily"); 

		//// POLICE MUTUAL SECTION
		// buildItems.add("Deploy-AdminPlus-Dev002-PoliceMutual"); 

		//// SALES DEMO SECTION
		buildItems.add("Deploy-AdminPlus-Dev002-SalesDemo"); 

		return buildItems;
	}

	//// Returns the build + deploy items for "ADMIN PLUS" solutions @ LATEST PRODUCTION RELEASE
	private List<String> getMasterBuildAdminPlusRelease(){
		List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-Exaxe.Types-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Libraries-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Rest-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Web-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Common-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.External-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Agent-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.App-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Configuration-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Rules-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Comment-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Document-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.SystemConfiguration-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Users-AdminPlus-Release");
		buildItems.add("Build-Exaxe.Accounting-AdminPlus-Release");
		buildItems.add("Build-Exaxe.Auth-AdminPlus-Release");
		buildItems.add("Build-Exaxe.UIElements-AdminPlus-Release");
		buildItems.add("Build-SystemConfigurationUI-AdminPlus-Release");
		buildItems.add("Build-Exaxe.Calculations-AdminPlus-Release");
		buildItems.add("Build-Exaxe.Client-AdminPlus-Release");
		buildItems.add("Build-Exaxe.AdminPlus-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Apex-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Aggregate-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Apex.Activities-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Apex.Server-AdminPlus-Release"); 
		buildItems.add("Build-AdminPlusUI-AdminPlus-Release"); 
	
		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-AdminPlus-Release-OneFamily"); 
		buildItems.add("Deploy-AdminPlus-Release-OneFamily-Exaxe"); 
		buildItems.add("Deploy-AdminPlus-Release-OneFamily-Test"); 
		buildItems.add("Deploy-AdminPlus-Release-OneFamily-Staging"); 
		buildItems.add("Deploy-AdminPlus-Release-OneFamily-Production"); 
		buildItems.add("Deploy-AdminPlus-Release-PoliceMutual");
	
		return buildItems;		
	}

	//// Returns the build + deploy items for "ADMIN PLUS" solutions @ LATEST PRODUCTION RELEASE
	private List<String> getMasterBuildAdminPlusReleaseV2(){
		List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-Exaxe.Types-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Libraries-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Rest-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Web-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Common-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.External-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Agent-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.App-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Configuration-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Rules-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Comment-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Document-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.SystemConfiguration-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Users-AdminPlus-Release");
		buildItems.add("Build-Exaxe.Accounting-AdminPlus-Release");
		buildItems.add("Build-Exaxe.Auth-AdminPlus-Release");
		buildItems.add("Build-Exaxe.UIElements-AdminPlus-Release");
		buildItems.add("Build-SystemConfigurationUI-AdminPlus-Release");
		buildItems.add("Build-Exaxe.Calculations-AdminPlus-Release");
		buildItems.add("Build-Exaxe.Client-AdminPlus-Release");
		buildItems.add("Build-Exaxe.AdminPlus-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Apex-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Aggregate-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Apex.Activities-AdminPlus-Release"); 
		buildItems.add("Build-Exaxe.Apex.Server-AdminPlus-Release"); 
		buildItems.add("Build-AdminPlusUI-AdminPlus-Release"); 
	
		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-AdminPlus-Release-OneFamily-V2"); 
		buildItems.add("Deploy-AdminPlus-Release-OneFamily-Exaxe-V2"); 
		buildItems.add("Deploy-AdminPlus-Release-OneFamily-Test-V2"); 
		buildItems.add("Deploy-AdminPlus-Release-OneFamily-Staging-V2"); 
		buildItems.add("Deploy-AdminPlus-Release-OneFamily-Production-V2"); 
	
		return buildItems;		
	}

	//// Returns the build + deploy items for "ADVICE PLUS" solutions @ DEV001 (UAT/INTEGRATION build)
	private List<String> getMasterBuildAdvicePlusDev001(){
		List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-Exaxe.FactFind-Dev001");
		buildItems.add("Build-Exaxe.Quote.Rules-Dev001");
		buildItems.add("Build-Exaxe.Quote-Dev001");
		buildItems.add("Build-Exaxe.ExistingBusiness-Dev001");
		buildItems.add("Build-PointOfSaleUI-Dev001");
	
		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-AdvicePlus-Dev001");	
	
		return buildItems;
	}

	//// Returns the build + deploy items for "ADVICE PLUS" solutions @ DEV002 (DEVELOPMENT build)
	private List<String> getMasterBuildAdvicePlusDev002(){
		List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-Exaxe.Client-Dev003");
		buildItems.add("Build-Exaxe.FactFind-Dev002");
		buildItems.add("Build-Exaxe.Quote.Rules-Dev002");
		buildItems.add("Build-Exaxe.Quote-Dev002");
		buildItems.add("Build-Exaxe.ExistingBusiness-Dev002");
		buildItems.add("Build-PointOfSaleUI-Dev002");

		//// Commented deployments can be re-added if the customer/environment must be included.

		buildItems.add("Deploy-AdvicePlus-Dev002-ACORN");
	
		return buildItems;
	}
 
	//// Returns the build + deploy items for "ADVICE PLUS" solutions @ LATEST PRODUCTION RELEASE
	private List<String> getMasterBuildAdvicePlusRelease(){
		List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-Exaxe.Types-AdvicePlus-Release"); 
		buildItems.add("Build-Exaxe.Libraries-AdvicePlus-Release"); 
		buildItems.add("Build-Exaxe.Rest-AdvicePlus-Release"); 
		buildItems.add("Build-Exaxe.Web-AdvicePlus-Release"); 
		buildItems.add("Build-Exaxe.Agent-AdvicePlus-Release"); 
		buildItems.add("Build-Exaxe.App-AdvicePlus-Release"); 
		buildItems.add("Build-Exaxe.Common-AdvicePlus-Release"); 
		buildItems.add("Build-Exaxe.Configuration-AdvicePlus-Release"); 
		buildItems.add("Build-Exaxe.Rules-AdvicePlus-Release"); 
		buildItems.add("Build-Exaxe.Comment-AdvicePlus-Release"); 
		buildItems.add("Build-Exaxe.SystemConfiguration-AdvicePlus-Release"); 
		buildItems.add("Build-Exaxe.Users-AdvicePlus-Release");
		buildItems.add("Build-Exaxe.UIElements-AdvicePlus-Release");
		buildItems.add("Build-SystemConfigurationUI-AdvicePlus-Release");
		buildItems.add("Build-Exaxe.Calculations-AdvicePlus-Release");
		buildItems.add("Build-Exaxe.Client-AdvicePlus-Release");
		buildItems.add("Build-Exaxe.FactFind-AdvicePlus-Release");
		buildItems.add("Build-Exaxe.Quote.Rules-AdvicePlus-Release");
		buildItems.add("Build-Exaxe.Quote-AdvicePlus-Release");
		buildItems.add("Build-Exaxe.ExistingBusiness-AdvicePlus-Release");
		buildItems.add("Build-PointOfSaleUI-AdvicePlus-Release");
	
		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-AdvicePlus-Release-ACORN");
	
		return buildItems;		
	}
 
	//// Returns the build + deploy items for "POLICY EBI (Aviva)" solutions @ DEV001 (UAT/INTEGRATION build)
	private List<String> getMasterBuildPolicyEBIDev001(){
		List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-Exaxe.PolicyEBI-Dev001"); 
		buildItems.add("Build-ExistingBusinessUI-Dev001"); 
		buildItems.add("Deploy-PolicyEBI-Dev001-Aviva"); 
		buildItems.add("Deploy-PolicyEBI-Dev001-Aviva-Test"); 
	
		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-PolicyEBI-Dev001-Aviva-Production"); 
	
		return buildItems;
	}

	//// Returns the build items for "HANSARD PORTALS" solutions @ DEV001 (UAT/INTEGRATION build)
	private List<String> getMasterBuildHansardPortalsDev001(){
		List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-Hansard.Portals-Dev001"); 
		
		return buildItems;		
	}


	//// Returns the build items for "HANSARD PORTALS" solutions @ DEV002 (DEVELOPMENT build)
	private List<String> getMasterBuildHansardPortalsDev002(){
		List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-Hansard.Portals-Dev002"); 
		
		return buildItems;		
	}

	//// Returns the build items for "CHANNEL PLUS" solutions @ Dev001 (UAT/INTEGRATION build)
	private List<String> getMasterBuildChannelPlusDev001(){
		List<String> buildItems = new ArrayList<String>();
		buildItems.add("Build-Exaxe.ChannelPlus-Dev001"); 
		buildItems.add("Build-ChannelPlusUI-Dev001"); 	

		return buildItems;		
	}

	//// Returns the build items for "CHANNEL PLUS" solutions @ Dev002 (DEVELOPMENT build)
	private List<String> getMasterBuildChannelPlusDev002(){
		List<String> buildItems = new ArrayList<String>();
		buildItems.add("Build-Exaxe.ChannelPlus-Dev002"); 
		buildItems.add("Build-ChannelPlusUI-Dev002"); 	

		return buildItems;		
	}


	//// Returns the deployment items for "HANSARD" solutions @ DEV002 (DEVELOPMENT build)
	private List<String> getMasterDeployDev002Hansard(){
		List<String> buildItems = new ArrayList<String>()
		
		buildItems.add("Deploy-WebApi-Dev002-Hansard"); 
		buildItems.add("Deploy-AdminPlus-Dev002-Hansard"); 
		buildItems.add("Deploy-SystemConfiguration-Dev001-Hansard"); 
		buildItems.add("Deploy-ChannelPlus-Dev002-Hansard"); 
		buildItems.add("Deploy-Portals.Broker-Dev002-Hansard"); 
		buildItems.add("Deploy-Portals.Client-Dev002-Hansard"); 

		return buildItems;		
	}

	//// Returns the deployment items for "HANSARD - Single" solutions @ DEV002 (DEVELOPMENT build)
	private List<String> getMasterDeployDev002HansardSingle(){
		List<String> buildItems = new ArrayList<String>()
		
		buildItems.add("Deploy-WebApi-Dev002-Hansard-Single"); 
		buildItems.add("Deploy-AdminPlus-Dev002-Hansard-Single"); 
		buildItems.add("Deploy-SystemConfiguration-Dev001-Hansard-Single"); 
		buildItems.add("Deploy-ChannelPlus-Dev002-Hansard-Single"); 
		buildItems.add("Deploy-Portals.Broker-Dev002-Hansard-Single"); 
		buildItems.add("Deploy-Portals.Client-Dev002-Hansard-Single"); 

		return buildItems;		
	}
	
	//// Returns the build items for "Product Development Application" solutions @ Dev001 
	private List<String> getMasterBuildProductDevelopmentDev001(){
		List<String> buildItems = new ArrayList<String>();
		buildItems.add("Build-Exaxe.ProductDevelopment-Dev001"); 
		buildItems.add("Build-Exaxe.ProductDevelopment.UI-Dev001"); 
		buildItems.add("Deploy-ProductDevelopment-Dev001-SalesDemo"); 		

		return buildItems;		
	}

	//// Returns the deployment items for "HANSARD - Single" solutions @ DEV001 
	private List<String> getMasterDeployDev001HansardSingle(){
		List<String> buildItems = new ArrayList<String>()
		
		buildItems.add("Deploy-WebApi-Dev001-Hansard-Single"); 
		buildItems.add("Deploy-AdminPlus-Dev001-Hansard-Single"); 
		buildItems.add("Deploy-SystemConfiguration-Dev001-Hansard-Single"); 
		buildItems.add("Deploy-ChannelPlus-Dev001-Hansard-Single"); 
		buildItems.add("Deploy-Portals.Broker-Dev001-Hansard-Single"); 
		buildItems.add("Deploy-Portals.Client-Dev001-Hansard-Single"); 

		return buildItems;		
	}

	//// Returns the deployment items for "HANSARD (EXAXE) - Single" solutions @ DEV001 
	private List<String> getMasterDeployDev001Hansard(){
		List<String> buildItems = new ArrayList<String>()
		
		buildItems.add("Deploy-WebApi-Dev001-Hansard"); 
		buildItems.add("Deploy-AdminPlus-Dev001-Hansard"); 
		buildItems.add("Deploy-SystemConfiguration-Dev001-Hansard"); 
		buildItems.add("Deploy-ChannelPlus-Dev001-Hansard"); 
		buildItems.add("Deploy-Portals.Broker-Dev001-Hansard"); 
		buildItems.add("Deploy-Portals.Client-Dev001-Hansard"); 

		return buildItems;		
	}


	//// Returns the deployment items for "HANSARD (EXAXE) - Multi" solutions @ DEV001 
	private List<String> getMasterDeployDev001HansardExaxe(){
		List<String> buildItems = new ArrayList<String>()
		
		buildItems.add("Deploy-WebApi-Dev001-Hansard-Exaxe"); 
		buildItems.add("Deploy-AdminPlus-Dev001-Hansard-Exaxe"); 
		buildItems.add("Deploy-SystemConfiguration-Dev001-Hansard-Exaxe"); 
		buildItems.add("Deploy-ChannelPlus-Dev001-Hansard-Exaxe"); 
		buildItems.add("Deploy-Portals.Broker-Dev001-Hansard-Exaxe"); 
		buildItems.add("Deploy-Portals.Client-Dev001-Hansard-Exaxe"); 

		return buildItems;		
	}
	//// Returns the deployment items for "HANSARD (TEST) - Multi" solutions @ DEV001 
	private List<String> getMasterDeployDev001HansardTest(){
		List<String> buildItems = new ArrayList<String>()
		
		buildItems.add("Deploy-WebApi-Dev001-Hansard-Test"); 
		buildItems.add("Deploy-AdminPlus-Dev001-Hansard-Test"); 
		buildItems.add("Deploy-SystemConfiguration-Dev001-Hansard-Test"); 
		buildItems.add("Deploy-ChannelPlus-Dev001-Hansard-Test"); 
		buildItems.add("Deploy-Portals.Broker-Dev001-Hansard-Test"); 
		buildItems.add("Deploy-Portals.Client-Dev001-Hansard-Test"); 

		return buildItems;		
	}

	//// Returns the deployment items for "HANSARD (STAGING) - Multi" solutions @ DEV001 
	private List<String> getMasterDeployDev001HansardStaging(){
		List<String> buildItems = new ArrayList<String>()
		
		buildItems.add("Deploy-WebApi-Dev001-Hansard-Staging"); 
		buildItems.add("Deploy-AdminPlus-Dev001-Hansard-Staging"); 
		buildItems.add("Deploy-SystemConfiguration-Dev001-Hansard-Staging"); 
		buildItems.add("Deploy-ChannelPlus-Dev001-Hansard-Staging"); 
		buildItems.add("Deploy-Portals.Broker-Dev001-Hansard-Staging"); 
		buildItems.add("Deploy-Portals.Client-Dev001-Hansard-Staging"); 

		return buildItems;		
	}

	//// Returns the deployment items for "HANSARD (PRODUCTION) - Multi" solutions @ DEV001 
	private List<String> getMasterDeployDev001HansardProduction(){
		List<String> buildItems = new ArrayList<String>()
		
		buildItems.add("Deploy-WebApi-Dev001-Hansard-Production"); 
		buildItems.add("Deploy-AdminPlus-Dev001-Hansard-Production"); 
		buildItems.add("Deploy-SystemConfiguration-Dev001-Hansard-Production"); 
		buildItems.add("Deploy-ChannelPlus-Dev001-Hansard-Production"); 
		buildItems.add("Deploy-Portals.Broker-Dev001-Hansard-Production"); 
		buildItems.add("Deploy-Portals.Client-Dev001-Hansard-Production"); 

		return buildItems;		
	}

}