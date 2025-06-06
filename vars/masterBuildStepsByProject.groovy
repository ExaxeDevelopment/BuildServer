class masterBuildStepsByProject implements Serializable {
	//// Returns the build steps based on the 'masterBuildType'
	//// The 'firstProject' indicates from where in the list the build will start
    def getMasterBuildStepsByProject(masterBuildType, firstProject) { 

		List<String> buildSteps = new ArrayList<String>();

        switch (masterBuildType) {
			case "MasterBuildBaseDev001":
                buildSteps = getMasterBuildBaseDev001();
                break
            case "MasterBuildSystemConfigurationDev001":
                buildSteps = getMasterBuildSystemConfigurationDev001();
                break
            case "MasterBuildSystemConfigurationDev002":
                buildSteps = getMasterBuildSystemConfigurationDev002();
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
			case "MasterBuildAdminPlusReleaseV3":
                buildSteps = getMasterBuildAdminPlusReleaseV3();
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
			case "MasterBuildExaxePortalsDev001":
                buildSteps = getMasterBuildExaxePortalsDev001();
                break
			case "MasterBuildExaxePortalsDev002":
                buildSteps = getMasterBuildExaxePortalsDev002();
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
			case "MasterBuildApexServerWorkflowDev001":
                buildSteps = getMasterBuildApexServerWorkflowDev001();
                break	
			case "MasterBuildApexServerWorkflowDev002":
                buildSteps = getMasterBuildApexServerWorkflowDev002();
                break	
			case "MasterBuildReleaseV20_6":
                buildSteps = getMasterBuildReleaseV20_6();
                break	
			case "MasterBuildReleaseV20_8":
                buildSteps = getMasterBuildReleaseV20_8();
                break	
			case "MasterBuildReleaseV20_10":
                buildSteps = getMasterBuildReleaseV20_10();
                break	
			case "MasterBuildReleaseV23_2":
                buildSteps = getMasterBuildReleaseV23_2();
                break	
			case "MasterBuildReleaseV20_10_prod":
                buildSteps = getMasterBuildReleaseV20_10_prod();
                break	
			case "MasterBuildReleaseV21_04":
                buildSteps = getMasterBuildReleaseV21_04();
                break	
			case "MasterBuildReleaseV21_5":
                buildSteps = getMasterBuildReleaseV21_5();
                break	
			case "MasterBuildReleaseV21_6":
                buildSteps = getMasterBuildReleaseV21_6();
                break	
			case "MasterBuildReleaseV21_6h":
                buildSteps = getMasterBuildReleaseV21_6h();
                break	
			case "MasterBuildReleaseVSP_ACN21_03":
                buildSteps = getMasterBuildReleaseVSP_ACN21_03();
                break	
			case "MasterBuildReleaseVACN21_03":
                buildSteps = getMasterBuildReleaseVACN21_03();
                break	
			case "MasterBuildReleaseVA21_03_1":
                buildSteps = getMasterBuildReleaseVA21_03_1();
                break	
			case "MasterBuildReleaseVSCV21_03":
                buildSteps = getMasterBuildReleaseVSCV21_03();
                break	
			case "MasterBuildReleaseV22_6":
                buildSteps = getMasterBuildReleaseV22_6();
                break	
			case "MasterBuildReleaseV22_10":
                buildSteps = getMasterBuildReleaseV22_10();
                break	
			case "MasterBuildReleaseV22_10h":
                buildSteps = getMasterBuildReleaseV22_10h();
                break	
			case "MasterBuildReleaseV23_9":
                buildSteps = getMasterBuildReleaseV23_9();
                break	
			case "MasterBuildReleaseVp23_9":
                buildSteps = getMasterBuildReleaseVp23_9();
                break	
			case "MasterBuildReleaseV23_11":
                buildSteps = getMasterBuildReleaseV23_11();
                break	
			case "MasterBuildReleaseV24_1":
                buildSteps = getMasterBuildReleaseV24_1();
                break	
			case "MasterBuildReleaseVh24_1":
                buildSteps = getMasterBuildReleaseVh24_1();
                break	
			case "MasterBuildReleaseV24_2":
                buildSteps = getMasterBuildReleaseV24_2();
                break	
			case "MasterBuildReleaseV24_3":
                buildSteps = getMasterBuildReleaseV24_3();
                break	
			case "MasterBuildReleaseVh24_3":
                buildSteps = getMasterBuildReleaseVh24_3();
                break	
			case "MasterBuildReleaseV24_5":
                buildSteps = getMasterBuildReleaseV24_5();
                break	
			case "MasterBuildReleaseV24_7":
                buildSteps = getMasterBuildReleaseV24_7();
                break	
			case "MasterBuildReleaseV24_9":
                buildSteps = getMasterBuildReleaseV24_9();
                break	
			case "MasterBuildReleaseV24_11":
                buildSteps = getMasterBuildReleaseV24_11();
                break	
			case "MasterBuildReleaseV25_3":
                buildSteps = getMasterBuildReleaseV25_3();
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

	//// Returns the build for "SYSTEM CONFIGURATION UI" @ DEV001 (UAT/INTEGRATION)
	private List<String> getMasterBuildSystemConfigurationDev001(){

        List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-SystemConfigurationUI-Dev001");
		return buildItems;
	}

	//// Returns the build for "SYSTEM CONFIGURATION UI" @ DEV002 (DEVELOPMENT)
	private List<String> getMasterBuildSystemConfigurationDev002(){

        List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-SystemConfigurationUI-Dev002");
		return buildItems;
	}

	//// Returns the build items for "ADMIN PLUS" solutions @ DEV001 (UAT/INTEGRATION)
	private List<String> getMasterBuildAdminPlusDev001(){

        List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-Exaxe.Client-Dev001"); 
		buildItems.add("Build-Exaxe.AdminPlus-Dev001"); 
		buildItems.add("Build-Exaxe.Apex-Dev001");
		buildItems.add("Build-Exaxe.Aggregate-Dev001"); 
		buildItems.add("Build-Exaxe.Apex.Activities-Dev001"); 
		buildItems.add("Build-Exaxe.Apex.Server-Dev001"); 
		buildItems.add("Build-AdminPlusUI-Dev001"); 
		return buildItems;
	}

	//// Returns the build items for "ADMIN PLUS" solutions @ DEV002 (DEVELOPMENT)
	private List<String> getMasterBuildAdminPlusDev002(){

        List<String> buildItems = new ArrayList<String>();
		buildItems.add("Build-Exaxe.Client-Dev002"); 
		buildItems.add("Build-Exaxe.AdminPlus-Dev002"); 
		buildItems.add("Build-Exaxe.Apex-Dev002"); 
		buildItems.add("Build-Exaxe.Aggregate-Dev002"); 
		buildItems.add("Build-Exaxe.Apex.Activities-Dev002"); 
		buildItems.add("Build-Exaxe.Apex.Server-Dev002"); 
		buildItems.add("Build-AdminPlusUI-Dev002"); 

		//// TODO: Remove ONE FAMILY deployment from build.
		//// ONE FAMILY SECTION
		buildItems.add("Deploy-AdminPlus-Dev002-OneFamily"); 

		//// TODO: Remove SALES DEMO deployment from build.
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
		buildItems.add("Build-Exaxe.Types-AdminPlus-Release-V2"); 
		buildItems.add("Build-Exaxe.Libraries-AdminPlus-Release-V2"); 
		buildItems.add("Build-Exaxe.Rest-AdminPlus-Release-V2"); 
		buildItems.add("Build-Exaxe.Web-AdminPlus-Release-V2"); 
		buildItems.add("Build-Exaxe.Common-AdminPlus-Release-V2"); 
		buildItems.add("Build-Exaxe.External-AdminPlus-Release-V2"); 
		buildItems.add("Build-Exaxe.Agent-AdminPlus-Release-V2"); 
		buildItems.add("Build-Exaxe.App-AdminPlus-Release-V2"); 
		buildItems.add("Build-Exaxe.Configuration-AdminPlus-Release-V2"); 
		buildItems.add("Build-Exaxe.Rules-AdminPlus-Release-V2"); 
		buildItems.add("Build-Exaxe.Comment-AdminPlus-Release-V2"); 
		buildItems.add("Build-Exaxe.Document-AdminPlus-Release-V2"); 
		buildItems.add("Build-Exaxe.SystemConfiguration-AdminPlus-Release-V2"); 
		buildItems.add("Build-Exaxe.Users-AdminPlus-Release-V2");
		buildItems.add("Build-Exaxe.Accounting-AdminPlus-Release-V2");
		buildItems.add("Build-Exaxe.Auth-AdminPlus-Release-V2");
		buildItems.add("Build-Exaxe.UIElements-AdminPlus-Release-V2");
		buildItems.add("Build-SystemConfigurationUI-AdminPlus-Release-V2");
		buildItems.add("Build-Exaxe.Calculations-AdminPlus-Release-V2");
		buildItems.add("Build-Exaxe.Client-AdminPlus-Release-V2");
		buildItems.add("Build-Exaxe.AdminPlus-AdminPlus-Release-V2"); 
		buildItems.add("Build-Exaxe.Apex-AdminPlus-Release-V2"); 
		buildItems.add("Build-Exaxe.Aggregate-AdminPlus-Release-V2"); 
		buildItems.add("Build-Exaxe.Apex.Activities-AdminPlus-Release-V2"); 
		buildItems.add("Build-Exaxe.Apex.Server-AdminPlus-Release-V2"); 
		buildItems.add("Build-AdminPlusUI-AdminPlus-Release-V2"); 
	
		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-AdminPlus-Release-OneFamily-V2"); 
		buildItems.add("Deploy-AdminPlus-Release-OneFamily-Exaxe-V2"); 
		buildItems.add("Deploy-AdminPlus-Release-OneFamily-Test-V2"); 
		buildItems.add("Deploy-AdminPlus-Release-OneFamily-Staging-V2"); 
		buildItems.add("Deploy-AdminPlus-Release-OneFamily-Production-V2"); 
	
		return buildItems;		
	}

	//// Returns the build + deploy items for "ADMIN PLUS" solutions @ LATEST PRODUCTION RELEASE
	private List<String> getMasterBuildAdminPlusReleaseV3(){
		List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-Exaxe.Types-AdminPlus-Release-V3"); 
		buildItems.add("Build-Exaxe.Libraries-AdminPlus-Release-V3"); 
		buildItems.add("Build-Exaxe.Rest-AdminPlus-Release-V3"); 
		buildItems.add("Build-Exaxe.Web-AdminPlus-Release-V3"); 
		buildItems.add("Build-Exaxe.Common-AdminPlus-Release-V3"); 
		buildItems.add("Build-Exaxe.External-AdminPlus-Release-V3"); 
		buildItems.add("Build-Exaxe.Agent-AdminPlus-Release-V3"); 
		buildItems.add("Build-Exaxe.App-AdminPlus-Release-V3"); 
		buildItems.add("Build-Exaxe.Configuration-AdminPlus-Release-V3"); 
		buildItems.add("Build-Exaxe.Rules-AdminPlus-Release-V3"); 
		buildItems.add("Build-Exaxe.Comment-AdminPlus-Release-V3"); 
		buildItems.add("Build-Exaxe.Document-AdminPlus-Release-V3"); 
		buildItems.add("Build-Exaxe.SystemConfiguration-AdminPlus-Release-V3"); 
		buildItems.add("Build-Exaxe.Users-AdminPlus-Release-V3");
		buildItems.add("Build-Exaxe.Accounting-AdminPlus-Release-V3");
		buildItems.add("Build-Exaxe.Auth-AdminPlus-Release-V3");
		buildItems.add("Build-Exaxe.UIElements-AdminPlus-Release-V3");
		buildItems.add("Build-SystemConfigurationUI-AdminPlus-Release-V3");
		buildItems.add("Build-Exaxe.Calculations-AdminPlus-Release-V3");
		buildItems.add("Build-Exaxe.Client-AdminPlus-Release-V3");
		buildItems.add("Build-Exaxe.AdminPlus-AdminPlus-Release-V3"); 
		buildItems.add("Build-Exaxe.Apex-AdminPlus-Release-V3"); 
		buildItems.add("Build-Exaxe.Aggregate-AdminPlus-Release-V3"); 
		buildItems.add("Build-Exaxe.Apex.Activities-AdminPlus-Release-V3"); 
		buildItems.add("Build-Exaxe.Apex.Server-AdminPlus-Release-V3"); 
		buildItems.add("Build-AdminPlusUI-AdminPlus-Release-V3"); 
	
		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-AdminPlus-Release-PoliceMutual-V3");
	
		return buildItems;		
	}

	//// Returns the build + deploy items for "ADMIN PLUS" solutions @ LATEST PRODUCTION RELEASE
	private List<String> getMasterBuildReleaseV20_6(){
		List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-Exaxe.Types-Release-V20.6"); 
		buildItems.add("Build-Exaxe.Libraries-Release-V20.6"); 
		buildItems.add("Build-Exaxe.Rest-Release-V20.6"); 
		buildItems.add("Build-Exaxe.Web-Release-V20.6"); 
		buildItems.add("Build-Exaxe.Common-Release-V20.6"); 
		buildItems.add("Build-Exaxe.External-Release-V20.6"); 
		buildItems.add("Build-Exaxe.Agent-Release-V20.6"); 
		buildItems.add("Build-Exaxe.App-Release-V20.6"); 
		buildItems.add("Build-Exaxe.Configuration-Release-V20.6"); 
		buildItems.add("Build-Exaxe.Rules-Release-V20.6"); 
		buildItems.add("Build-Exaxe.Comment-Release-V20.6"); 
		buildItems.add("Build-Exaxe.Document-Release-V20.6"); 
		buildItems.add("Build-Exaxe.SystemConfiguration-Release-V20.6"); 
		buildItems.add("Build-Exaxe.Users-Release-V20.6");
		buildItems.add("Build-Exaxe.Accounting-Release-V20.6");
		buildItems.add("Build-Exaxe.Auth-Release-V20.6");
		buildItems.add("Build-Exaxe.UIElements-Release-V20.6");
		buildItems.add("Build-SystemConfigurationUI-Release-V20.6");
		buildItems.add("Build-Exaxe.Calculations-Release-V20.6");
		buildItems.add("Build-Exaxe.CalculationManagers-Release-V20.6");
		buildItems.add("Build-Exaxe.Client-Release-V20.6");
		buildItems.add("Build-Exaxe.AdminPlus-Release-V20.6"); 
		buildItems.add("Build-Exaxe.Apex-Release-V20.6"); 
		buildItems.add("Build-Exaxe.Aggregate-Release-V20.6"); 
		buildItems.add("Build-Exaxe.Apex.Activities-Release-V20.6"); 
		buildItems.add("Build-Exaxe.Apex.Server-Release-V20.6"); 
		buildItems.add("Build-AdminPlusUI-Release-V20.6"); 
	
		//// Commented deployments can be re-added if the customer/environment must be included.
	
		//// buildItems.add("Deploy-AdminPlus-Release-OneFamily-V20.6");
	
		return buildItems;		
	}

	//// Returns the build + deploy items for "ADMIN PLUS" solutions @ LATEST PRODUCTION RELEASE
	private List<String> getMasterBuildReleaseV20_8(){
		List<String> buildItems = getMasterBuildReleaseVXX_X("20.8");
	
		buildItems.add("Build-Hansard.Portals-Release-V20.8"); 	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Hansard-Exaxe-Multi-V20.8");
		buildItems.add("Deploy-Release-Hansard-Exaxe-Single-V20.8");
		buildItems.add("Deploy-Release-Hansard-Multi-V20.8");
		buildItems.add("Deploy-Release-Hansard-Single-V20.8");
	
		return buildItems;		
	}

	//// Returns the build + deploy items for "ADMIN PLUS" solutions @ LATEST PRODUCTION RELEASE
	private List<String> getMasterBuildReleaseV20_10(){
		List<String> buildItems = getMasterBuildReleaseVXX_X("20.10");
	
		buildItems.add("Build-Hansard.Portals-Release-V20.10"); 	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Hansard-Exaxe-Single-V20.10");
		buildItems.add("Deploy-Release-Hansard-Exaxe-Multi-V20.10");
		buildItems.add("Deploy-Release-Hansard-Multi-V20.10");
		buildItems.add("Deploy-Release-Hansard-Single-V20.10");
	
		return buildItems;		
	}

	//// Returns the build + deploy items for "ADMIN PLUS" solutions @ LATEST PRODUCTION RELEASE
	private List<String> getMasterBuildReleaseV23_2(){
		List<String> buildItems = getMasterBuildV2ReleaseVXX_X("23.2");
	
		buildItems.add("Build-Hansard.Portals-Release-V23.2"); 	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Hansard-Exaxe-Single-V23.2");
		buildItems.add("Deploy-Release-Hansard-Exaxe-Multi-V23.2");
		buildItems.add("Deploy-Release-Hansard-Multi-V23.2");
		buildItems.add("Deploy-Release-Hansard-Single-V23.2");
	
		return buildItems;		
	}

	//// Returns the build + deploy items for "ADMIN PLUS" solutions @ LATEST PRODUCTION RELEASE
	private List<String> getMasterBuildReleaseV20_10_prod(){
		List<String> buildItems = getMasterBuildReleaseVXX_X("20.10_prod");
	
		buildItems.add("Build-Hansard.Portals-Release-V20.10_prod"); 	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Hansard-Exaxe-Single-V20.10_prod");
		buildItems.add("Deploy-Release-Hansard-Exaxe-Multi-V20.10_prod");
		buildItems.add("Deploy-Release-Hansard-Multi-V20.10_prod");
		buildItems.add("Deploy-Release-Hansard-Single-V20.10_prod");
	
		return buildItems;		
	}

	//// Returns the build + deploy items for "ADMIN PLUS" solutions @ LATEST PRODUCTION RELEASE
	private List<String> getMasterBuildReleaseV21_04(){
		List<String> buildItems = getMasterBuildReleaseVXX_X("21.04");
	
		buildItems.add("Build-Hansard.Portals-Release-V21.04"); 	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Hansard-Exaxe-Single-V21.04");
		buildItems.add("Deploy-Release-Hansard-Exaxe-Multi-V21.04");
		buildItems.add("Deploy-Release-Hansard-Multi-V21.04");
		buildItems.add("Deploy-Release-Hansard-Single-V21.04");
		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
		
		return buildItems;		
	}

	//// Returns the build + deploy items for "ADMIN PLUS" solutions @ LATEST PRODUCTION RELEASE
	private List<String> getMasterBuildReleaseV21_5(){
		List<String> buildItems = getMasterBuildReleaseVXX_X("21.5");
	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-PoliceMutual-Exaxe-Single-V21.5");
		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
		
		return buildItems;		
	}

	//// Returns the build + deploy items for "ADMIN PLUS" solutions @ LATEST PRODUCTION RELEASE
	private List<String> getMasterBuildReleaseV21_6(){
		List<String> buildItems = getMasterBuildV2ReleaseVXX_X("21.6");
	

		buildItems.add("Build-Hansard.Portals-Release-V21.6"); 	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Hansard-Exaxe-Single-V21.6");
		buildItems.add("Deploy-Release-Hansard-Exaxe-Multi-V21.6");
		buildItems.add("Deploy-Release-Hansard-Multi-V21.6");
		buildItems.add("Deploy-Release-Hansard-Single-V21.6");
		buildItems.add("Deploy-Release-OneFamily-Exaxe-Single-V21.6");
		buildItems.add("Deploy-Release-PoliceMutual-Exaxe-Single-V21.6");
		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
		
		return buildItems;		
	}

	//// Returns the build + deploy items for "ADMIN PLUS" solutions @ LATEST PRODUCTION RELEASE
	private List<String> getMasterBuildReleaseV22_6(){
		List<String> buildItems = getMasterBuildV2ReleaseVXX_X("22.6");
	

		buildItems.add("Build-Hansard.Portals-Release-V22.6"); 	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Hansard-Exaxe-Single-V22.6");
		buildItems.add("Deploy-Release-Hansard-Exaxe-Multi-V22.6");
		buildItems.add("Deploy-Release-Hansard-Multi-V22.6");
		buildItems.add("Deploy-Release-Hansard-Single-V22.6");

		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
		
		return buildItems;		
	}

	//// Returns the build + deploy items for "ADMIN PLUS" solutions @ LATEST PRODUCTION RELEASE
	private List<String> getMasterBuildReleaseV22_10(){
		List<String> buildItems = getMasterBuildV2ReleaseVXX_X("22.10");
	

		buildItems.add("Build-Hansard.Portals-Release-V22.10"); 	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Hansard-Exaxe-Single-V22.10");
		buildItems.add("Deploy-Release-Hansard-Exaxe-Multi-V22.10");
		buildItems.add("Deploy-Release-Hansard-Multi-V22.10");
		buildItems.add("Deploy-Release-Hansard-Single-V22.10");

		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
		
		return buildItems;		
	}


	//// Returns the build + deploy items for "ADMIN PLUS" solutions @ LATEST PRODUCTION RELEASE
	private List<String> getMasterBuildReleaseV21_6h(){
		List<String> buildItems = getMasterBuildV2ReleaseVXX_X("21.6h");
	

		buildItems.add("Build-Hansard.Portals-Release-V21.6h"); 	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Hansard-Exaxe-Single-V21.6h");
		buildItems.add("Deploy-Release-Hansard-Exaxe-Multi-V21.6h");
		buildItems.add("Deploy-Release-Hansard-Multi-V21.6h");
		buildItems.add("Deploy-Release-Hansard-Single-V21.6h");
		buildItems.add("Deploy-Release-OneFamily-Exaxe-Single-V21.6h");
		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
		
		return buildItems;		
	}

	//// Returns the build + deploy items for "ADMIN PLUS" solutions @ LATEST PRODUCTION RELEASE
	private List<String> getMasterBuildReleaseV22_10h(){
		List<String> buildItems = getMasterBuildV2ReleaseVXX_X("22.10h");
	

		buildItems.add("Build-Hansard.Portals-Release-V22.10h"); 	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Hansard-Exaxe-Single-V22.10h");
		buildItems.add("Deploy-Release-Hansard-Exaxe-Multi-V22.10h");
		buildItems.add("Deploy-Release-Hansard-Multi-V22.10h");
		buildItems.add("Deploy-Release-Hansard-Single-V22.10h");
		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
		
		return buildItems;		
	}

	private List<String> getMasterBuildReleaseV23_9(){
		List<String> buildItems = getMasterBuildV2ReleaseVXX_X("23.9");
	

		buildItems.add("Build-Hansard.Portals-Release-V23.9"); 	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Hansard-Exaxe-Single-V23.9");
		buildItems.add("Deploy-Release-Hansard-Exaxe-Multi-V23.9");
		buildItems.add("Deploy-Release-Hansard-Multi-V23.9");
		buildItems.add("Deploy-Release-Hansard-Single-V23.9");
		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
		
		return buildItems;		
	}
	
	private List<String> getMasterBuildReleaseV23_11(){
		List<String> buildItems = getMasterBuildV2ReleaseVXX_X("23.11");
	

		buildItems.add("Build-Hansard.Portals-Release-V23.11"); 	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Hansard-Exaxe-Single-V23.11");
		buildItems.add("Deploy-Release-Hansard-Exaxe-Multi-V23.11");
		buildItems.add("Deploy-Release-Hansard-Multi-V23.11");
		buildItems.add("Deploy-Release-Hansard-Single-V23.11");
		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
		
		return buildItems;		
	}	
	
	private List<String> getMasterBuildReleaseV24_1(){
		List<String> buildItems = getMasterBuildV2ReleaseVXX_X("24.1");
	

		buildItems.add("Build-Hansard.Portals-Release-V24.1"); 	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Hansard-Exaxe-Single-V24.1");
		buildItems.add("Deploy-Release-Hansard-Exaxe-Multi-V24.1");
		buildItems.add("Deploy-Release-Hansard-Multi-V24.1");
		buildItems.add("Deploy-Release-Hansard-Single-V24.1");
		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
		
		return buildItems;		
	}	
	
	private List<String> getMasterBuildReleaseV24_2(){
		List<String> buildItems = getMasterBuildV2ReleaseVXX_X("24.2");
	

		buildItems.add("Build-Hansard.Portals-Release-V24.2"); 	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Hansard-Exaxe-Single-V24.2");
		buildItems.add("Deploy-Release-Hansard-Exaxe-Multi-V24.2");
		buildItems.add("Deploy-Release-Hansard-Multi-V24.2");
		buildItems.add("Deploy-Release-Hansard-Single-V24.2");
		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
		
		return buildItems;		
	}	
	
	private List<String> getMasterBuildReleaseV24_3(){
		List<String> buildItems = getMasterBuildV2ReleaseVXX_X("24.3");
	

		buildItems.add("Build-Hansard.Portals-Release-V24.3"); 	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Hansard-Exaxe-Single-V24.3");
		buildItems.add("Deploy-Release-Hansard-Exaxe-Multi-V24.3");
		buildItems.add("Deploy-Release-Hansard-Multi-V24.3");
		buildItems.add("Deploy-Release-Hansard-Single-V24.3");
		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
		
		return buildItems;		
	}	
	
	private List<String> getMasterBuildReleaseV24_5(){
		List<String> buildItems = getMasterBuildV2ReleaseVXX_X("24.5");
	

		buildItems.add("Build-Hansard.Portals-Release-V24.5"); 	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Hansard-Exaxe-Single-V24.5");
		buildItems.add("Deploy-Release-Hansard-Exaxe-Multi-V24.5");
		buildItems.add("Deploy-Release-Hansard-Multi-V24.5");
		buildItems.add("Deploy-Release-Hansard-Single-V24.5");
		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
		
		return buildItems;		
	}	

	private List<String> getMasterBuildReleaseV24_7(){
		List<String> buildItems = getMasterBuildV2ReleaseVXX_X("24.7");
	

		buildItems.add("Build-Hansard.Portals-Release-V24.7"); 	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Hansard-Exaxe-Single-V24.7");
		buildItems.add("Deploy-Release-Hansard-Exaxe-Multi-V24.7");
		buildItems.add("Deploy-Release-Hansard-Multi-V24.7");
		buildItems.add("Deploy-Release-Hansard-Single-V24.7");
		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
		
		return buildItems;		
	}	
	
	private List<String> getMasterBuildReleaseV24_9(){
		List<String> buildItems = getMasterBuildV2ReleaseVXX_X("24.9");
	

		buildItems.add("Build-Hansard.Portals-Release-V24.9"); 	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Hansard-Exaxe-Single-V24.9");
		buildItems.add("Deploy-Release-Hansard-Exaxe-Multi-V24.9");
		buildItems.add("Deploy-Release-Hansard-Multi-V24.9");
		buildItems.add("Deploy-Release-Hansard-Single-V24.9");
		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
		
		return buildItems;		
	}	
	
	private List<String> getMasterBuildReleaseV24_11(){
		List<String> buildItems = getMasterBuildV2ReleaseVXX_X("24.11");
	

		buildItems.add("Build-Hansard.Portals-Release-V24.11"); 	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Hansard-Exaxe-Single-V24.11");
		buildItems.add("Deploy-Release-Hansard-Exaxe-Multi-V24.11");
		buildItems.add("Deploy-Release-Hansard-Multi-V24.11");
		buildItems.add("Deploy-Release-Hansard-Single-V24.11");
		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
		
		return buildItems;		
	}	
	
	private List<String> getMasterBuildReleaseV25_3(){
		List<String> buildItems = getMasterBuildV2ReleaseVXX_X("25.3");
	

		buildItems.add("Build-Hansard.Portals-Release-V25.3"); 	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Hansard-Exaxe-Single-V25.3");
		buildItems.add("Deploy-Release-Hansard-Exaxe-Multi-V25.3");
		buildItems.add("Deploy-Release-Hansard-Multi-V25.3");
		buildItems.add("Deploy-Release-Hansard-Single-V25.3");
		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
		
		return buildItems;		
	}	
	
	private List<String> getMasterBuildReleaseVh24_3(){
		List<String> buildItems = getMasterBuildV2ReleaseVXX_X("h24.3");
	

		buildItems.add("Build-Hansard.Portals-Release-Vh24.3"); 	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Hansard-Exaxe-Single-Vh24.3");
		buildItems.add("Deploy-Release-Hansard-Exaxe-Multi-Vh24.3");
		buildItems.add("Deploy-Release-Hansard-Multi-Vh24.3");
		buildItems.add("Deploy-Release-Hansard-Single-Vh24.3");
		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
		
		return buildItems;		
	}	
	
	private List<String> getMasterBuildReleaseVh24_1(){
		List<String> buildItems = getMasterBuildV2ReleaseVXX_X("h24.1");
	

		buildItems.add("Build-Hansard.Portals-Release-Vh24.1"); 	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Hansard-Exaxe-Single-Vh24.1");
		buildItems.add("Deploy-Release-Hansard-Exaxe-Multi-Vh24.1");
		buildItems.add("Deploy-Release-Hansard-Multi-Vh24.1");
		buildItems.add("Deploy-Release-Hansard-Single-Vh24.1");
		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
		
		return buildItems;		
	}	
	

	private List<String> getMasterBuildReleaseVp23_9(){
		List<String> buildItems = getMasterBuildV2ReleaseVXX_X("p23.9");
	

		buildItems.add("Build-Hansard.Portals-Release-V23.9"); 	

		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Hansard-Exaxe-Single-Vp23.9");
		buildItems.add("Deploy-Release-Hansard-Exaxe-Multi-Vp23.9");
		buildItems.add("Deploy-Release-Hansard-Multi-Vp23.9");
		buildItems.add("Deploy-Release-Hansard-Single-Vp23.9")p;
		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
		
		return buildItems;		
	}
	
	//// Returns the build + deploy items for "ADMIN PLUS" solutions @ LATEST PRODUCTION RELEASE
	private List<String> getMasterBuildReleaseVACN21_03(){
		List<String> buildItems = getMasterBuildReleaseVXX_X("ACN21.03");
	
		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Acorn-Exaxe-Multi-VACN21.03");
		buildItems.add("Deploy-Release-Acorn-Multi-VACN21.03");
		buildItems.add("Deploy-Release-Acorn-Exaxe-Single-VACN21.03");
		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
	
		return buildItems;		
	}

	//// Returns the build + deploy items for "ADMIN PLUS" solutions @ LATEST PRODUCTION RELEASE
	private List<String> getMasterBuildReleaseVA21_03_1(){
		List<String> buildItems = getMasterBuildReleaseVXX_X("A21.03.1");
	
		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Acorn-Exaxe-Multi-VA21.03.1");
		buildItems.add("Deploy-Release-Acorn-Multi-VA21.03.1");
		buildItems.add("Deploy-Release-Acorn-Exaxe-Single-VA21.03.1");
		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
	
		return buildItems;		
	}

	//// Returns the build + deploy items for "ADMIN PLUS" solutions @ LATEST PRODUCTION RELEASE
	private List<String> getMasterBuildReleaseVSP_ACN21_03(){
		List<String> buildItems = getMasterBuildReleaseVXX_X("SPRING_ACN21.03");
	
		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Acorn-Exaxe-Multi-VSPRING_ACN21.03");
		buildItems.add("Deploy-Release-Acorn-Multi-VSPRING_ACN21.03");
		buildItems.add("Deploy-Release-Acorn-Exaxe-Single-VSPRING_ACN21.03");
		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
	
		return buildItems;		
	}

	//// Returns the build + deploy items for "ADMIN PLUS" solutions @ LATEST PRODUCTION RELEASE
	private List<String> getMasterBuildReleaseVSCV21_03(){
		List<String> buildItems = getMasterBuildReleaseVXX_X("SCV21.03");
	
		//// Commented deployments can be re-added if the customer/environment must be included.
	
		buildItems.add("Deploy-Release-Acorn-Exaxe-Multi-VSCV21.03");
		buildItems.add("Deploy-Release-Acorn-Multi-VSCV21.03");
		buildItems.add("Deploy-Release-Acorn-Exaxe-Single-VSCV21.03");
		buildItems.add("DeletePackages");
		buildItems.add("ClearNuGetCachePackages");
	
		return buildItems;		
	}

	private List<String> getMasterBuildReleaseVXX_X(String version)
	{
		List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-Exaxe.Types-Release-V"+version); 
		buildItems.add("Build-Exaxe.Security-Release-V"+version); 
		buildItems.add("Build-Exaxe.Libraries-Release-V"+version); 
		buildItems.add("Build-Exaxe.Rest-Release-V"+version); 
		buildItems.add("Build-Exaxe.Web-Release-V"+version); 
		buildItems.add("Build-Exaxe.Auth-Release-V"+version);
		buildItems.add("Build-Exaxe.Common-Release-V"+version); 
		buildItems.add("Build-Exaxe.External-Release-V"+version); 
		buildItems.add("Build-Exaxe.Agent-Release-V"+version); 
		buildItems.add("Build-Exaxe.App-Release-V"+version); 
		buildItems.add("Build-Exaxe.Configuration-Release-V"+version); 
		buildItems.add("Build-Exaxe.Rules-Release-V"+version); 
		buildItems.add("Build-Exaxe.Comment-Release-V"+version); 
		buildItems.add("Build-Exaxe.SystemConfiguration-Release-V"+version); 
		buildItems.add("Build-Exaxe.Users-Release-V"+version);
		buildItems.add("Build-Exaxe.Document-Release-V"+version); 
		buildItems.add("Build-Exaxe.Accounting-Release-V"+version);
		buildItems.add("Build-Exaxe.Calculations-Release-V"+version);
		buildItems.add("Build-Exaxe.CalculationManagers-Release-V"+version);
		buildItems.add("Build-Exaxe.UIElements-Release-V"+version);
		buildItems.add("Build-Exaxe.ChannelPlus-Release-V"+version); 
		buildItems.add("Build-Exaxe.Client-Release-V"+version);
		buildItems.add("Build-Exaxe.AdminPlus-Release-V"+version); 
		buildItems.add("Build-Exaxe.Apex-Release-V"+version); 
		buildItems.add("Build-Exaxe.Aggregate-Release-V"+version); 
		buildItems.add("Build-Exaxe.Client-Release-VADVP"+version);
		buildItems.add("Build-Exaxe.FactFind-Release-V"+version);
		buildItems.add("Build-Exaxe.Quote.Rules-Release-V"+version);
		buildItems.add("Build-Exaxe.Quote-Release-V"+version);
		buildItems.add("Build-Exaxe.ExistingBusiness-Release-V"+version);
		buildItems.add("Build-Exaxe.Apex.Workflow-Release-V"+version); 
		buildItems.add("Build-Exaxe.Apex.Activities-Release-V"+version); 
		buildItems.add("Build-Exaxe.Apex.Server-Release-V"+version); 
		buildItems.add("Build-Exaxe.WebApi-Release-V"+version); 
		buildItems.add("Build-SystemConfigurationUI-Release-V"+version);
		buildItems.add("Build-PointOfSaleUI-Release-V"+version); 
		buildItems.add("Build-AdminPlusUI-Release-V"+version); 
		buildItems.add("Build-ChannelPlusUI-Release-V"+version); 	
		
		return buildItems;		
	}

	private List<String> getMasterBuildV2ReleaseVXX_X(String version)
	{
		List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-Exaxe.Types-Release-V"+version); 
		buildItems.add("Build-Exaxe.Security-Release-V"+version); 
		buildItems.add("Build-Exaxe.Libraries-Release-V"+version); 
		buildItems.add("Build-Exaxe.Rest-Release-V"+version); 
		buildItems.add("Build-Exaxe.Web-Release-V"+version); 
		buildItems.add("Build-Exaxe.Common-Release-V"+version); 
		buildItems.add("Build-Exaxe.Auth-Release-V"+version);
		buildItems.add("Build-Exaxe.External-Release-V"+version); 
		buildItems.add("Build-Exaxe.Agent-Release-V"+version); 
		buildItems.add("Build-Exaxe.App-Release-V"+version); 
		buildItems.add("Build-Exaxe.Configuration-Release-V"+version); 
		buildItems.add("Build-Exaxe.Rules-Release-V"+version); 
		buildItems.add("Build-Exaxe.Comment-Release-V"+version); 
		buildItems.add("Build-Exaxe.SystemConfiguration-Release-V"+version); 
		buildItems.add("Build-Exaxe.Users-Release-V"+version);
		buildItems.add("Build-Exaxe.Document-Release-V"+version); 
		buildItems.add("Build-Exaxe.Configuration.WCF-Release-V"+version); 
		buildItems.add("Build-Exaxe.Accounting-Release-V"+version);
		buildItems.add("Build-Exaxe.UIElements-Release-V"+version);
		buildItems.add("Build-Exaxe.Calculations-Release-V"+version);
		buildItems.add("Build-Exaxe.CalculationManagers-Release-V"+version);
		buildItems.add("Build-Exaxe.ChannelPlus-Release-V"+version); 
		buildItems.add("Build-Exaxe.Client-Release-V"+version);
		buildItems.add("Build-Exaxe.AdminPlus-Release-V"+version); 
		buildItems.add("Build-Exaxe.Apex-Release-V"+version); 
		buildItems.add("Build-Exaxe.Aggregate-Release-V"+version); 
		buildItems.add("Build-Exaxe.Client-Release-VADVP"+version);
		buildItems.add("Build-Exaxe.FactFind-Release-V"+version);
		buildItems.add("Build-Exaxe.Quote.Rules-Release-V"+version);
		buildItems.add("Build-Exaxe.Quote-Release-V"+version);
		buildItems.add("Build-Exaxe.ExistingBusiness-Release-V"+version);
		buildItems.add("Build-Exaxe.Apex.Workflow-Release-V"+version); 
		buildItems.add("Build-Exaxe.Apex.Activities-Release-V"+version); 
		buildItems.add("Build-Exaxe.Apex.Server-Release-V"+version); 
		buildItems.add("Build-Exaxe.WCF-Release-V"+version); 
		buildItems.add("Build-Exaxe.WebApi-Release-V"+version); 
		buildItems.add("Build-SystemConfigurationUI-Release-V"+version);
		buildItems.add("Build-PointOfSaleUI-Release-V"+version); 
		buildItems.add("Build-AdminPlusUI-Release-V"+version); 
		buildItems.add("Build-ChannelPlusUI-Release-V"+version); 	
		
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
	
	//// Returns the build items for "EXAXE PORTALS" solutions @ DEV001 (UAT/INTEGRATION build)
	private List<String> getMasterBuildExaxePortalsDev001(){
		List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-Exaxe.Portals-Dev001"); 
		
		return buildItems;		
	}

	//// Returns the build items for "EXAXE PORTALS" solutions @ DEV002 (DEVELOPMENT build)
	private List<String> getMasterBuildExaxePortalsDev002(){
		List<String> buildItems = new ArrayList<String>()
		buildItems.add("Build-Exaxe.Portals-Dev002"); 
		
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
		buildItems.add("Deploy-SystemConfiguration-Dev002-Hansard"); 
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
		buildItems.add("Deploy-SystemConfiguration-Dev002-Hansard-Single"); 
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



	//// Returns the build items for "APEX SERVER/WORKFLOWS" solutions @ Dev001 (UAT/INTEGRATION build)
	private List<String> getMasterBuildApexServerWorkflowDev001(){
		List<String> buildItems = new ArrayList<String>();
		buildItems.add("Build-Exaxe.Apex.Workflow-Dev001"); 

		return buildItems;		
	}

	//// Returns the build items for "APEX SERVER/WORKFLOWS" solutions @ Dev002 (DEVELOPMENT build)
	private List<String> getMasterBuildApexServerWorkflowDev002(){
		List<String> buildItems = new ArrayList<String>();
		buildItems.add("Build-Exaxe.Apex.Workflow-Dev002"); 

		return buildItems;		
	}

}