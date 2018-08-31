class masterBuildStepsByProject implements Serializable {
	//// Returns the build steps based on the 'masterBuildType'
	//// The 'firstProject' indicates from where in the list the build will start
    def getMasterBuildStepsByProject(masterBuildType, firstProject) { 

		List<String> masterBuildBaseDev001 = new ArrayList<String>()
		masterBuildBaseDev001.add("Build-Exaxe.Types-Dev001"); 
		masterBuildBaseDev001.add("Build-Exaxe.Libraries-Dev001"); 
		masterBuildBaseDev001.add("Build-Exaxe.Rest-Dev001"); 
		masterBuildBaseDev001.add("Build-Exaxe.Web-Dev001"); 
		masterBuildBaseDev001.add("Build-Exaxe.Common-Dev001"); 
		masterBuildBaseDev001.add("Build-Exaxe.External-Dev001"); 
		masterBuildBaseDev001.add("Build-Exaxe.Agent-Dev001"); 
		masterBuildBaseDev001.add("Build-Exaxe.App-Dev001"); 
		masterBuildBaseDev001.add("Build-Exaxe.Configuration-Dev001"); 
		masterBuildBaseDev001.add("Build-Exaxe.Rules-Dev001"); 
		masterBuildBaseDev001.add("Build-Exaxe.Comment-Dev001"); 
		masterBuildBaseDev001.add("Build-Exaxe.Document-Dev001"); 
		masterBuildBaseDev001.add("Build-Exaxe.SystemConfiguration-Dev001"); 
		masterBuildBaseDev001.add("Build-Exaxe.Users-Dev001");
		masterBuildBaseDev001.add("Build-Exaxe.Accounting-Dev001");
		masterBuildBaseDev001.add("Build-Exaxe.Auth-Dev001"); 
		masterBuildBaseDev001.add("Build-Exaxe.UIElements-Dev001");
		masterBuildBaseDev001.add("Build-SystemConfigurationUI-Dev001");
		masterBuildBaseDev001.add("Build-Exaxe.Calculations-Dev001");

        List<String> masterBuildAdminPlusDev001 = new ArrayList<String>()
		masterBuildAdminPlusDev001.add("Build-Exaxe.Client-Dev001"); 
		masterBuildAdminPlusDev001.add("Build-Exaxe.AdminPlus-Dev001"); 
		masterBuildAdminPlusDev001.add("Build-Exaxe.Apex-Dev001");
		masterBuildAdminPlusDev001.add("Build-Exaxe.Aggregate-Dev001"); 
		masterBuildAdminPlusDev001.add("Build-Exaxe.Apex.Activities-Dev001"); 
		masterBuildAdminPlusDev001.add("Build-Exaxe.Apex.Server-Dev001"); 
		masterBuildAdminPlusDev001.add("Build-AdminPlusUI-Dev001"); 
		masterBuildAdminPlusDev001.add("Deploy-AdminPlus-Dev001-OneFamily"); 
		masterBuildAdminPlusDev001.add("Deploy-AdminPlus-Dev001-OneFamily-Exaxe"); 
		masterBuildAdminPlusDev001.add("Deploy-AdminPlus-Dev001-OneFamily-Test"); 
		masterBuildAdminPlusDev001.add("Deploy-AdminPlus-Dev001-OneFamily-Staging"); 
		masterBuildAdminPlusDev001.add("Deploy-AdminPlus-Dev001-OneFamily-Production"); 

        List<String> masterBuildAdminPlusDev002 = new ArrayList<String>();
		masterBuildAdminPlusDev002.add("Build-Exaxe.Client-Dev002"); 
		masterBuildAdminPlusDev002.add("Build-Exaxe.AdminPlus-Dev002"); 
		masterBuildAdminPlusDev002.add("Build-Exaxe.Apex-Dev002"); 
		masterBuildAdminPlusDev002.add("Build-Exaxe.Aggregate-Dev002"); 
		masterBuildAdminPlusDev002.add("Build-Exaxe.Apex.Activities-Dev002"); 
		masterBuildAdminPlusDev002.add("Build-Exaxe.Apex.Server-Dev002"); 
		masterBuildAdminPlusDev002.add("Build-AdminPlusUI-Dev002"); 
		masterBuildAdminPlusDev002.add("Deploy-AdminPlus-Dev002-Hansard"); 
		masterBuildAdminPlusDev002.add("Deploy-AdminPlus-Dev002-Hansard-Single"); 
		masterBuildAdminPlusDev002.add("Deploy-AdminPlus-Dev002-SalesDemo"); 
		masterBuildAdminPlusDev002.add("Deploy-AdminPlus-Dev002-OneFamily"); 

        List<String> masterBuildAdminPlusDev004 = new ArrayList<String>();
		masterBuildAdminPlusDev004.add("Build-Exaxe.Client-Dev004"); 
		masterBuildAdminPlusDev004.add("Build-Exaxe.AdminPlus-Dev004"); 
		masterBuildAdminPlusDev004.add("Build-Exaxe.Apex-Dev004"); 
		masterBuildAdminPlusDev004.add("Build-Exaxe.Aggregate-Dev004"); 
		masterBuildAdminPlusDev004.add("Build-Exaxe.Apex.Activities-Dev004"); 
		masterBuildAdminPlusDev004.add("Build-Exaxe.Apex.Server-Dev004"); 
		masterBuildAdminPlusDev004.add("Build-AdminPlusUI-Dev004"); 
		
		List<String> masterBuildAdvicePlusDev002 = new ArrayList<String>()
        masterBuildAdvicePlusDev002.add("Build-Exaxe.Client-Dev003");
        masterBuildAdvicePlusDev002.add("Build-Exaxe.FactFind-Dev002");
        masterBuildAdvicePlusDev002.add("Build-Exaxe.Quote.Rules-Dev002");
        masterBuildAdvicePlusDev002.add("Build-Exaxe.Quote-Dev002");
        masterBuildAdvicePlusDev002.add("Build-Exaxe.ExistingBusiness-Dev002");
        masterBuildAdvicePlusDev002.add("Build-PointOfSaleUI-Dev002");
        masterBuildAdvicePlusDev002.add("Deploy-AdvicePlus-Dev002-ACORN");

		List<String> masterBuildAdvicePlusDev001 = new ArrayList<String>()
        masterBuildAdvicePlusDev001.add("Build-Exaxe.FactFind-Dev001");
        masterBuildAdvicePlusDev001.add("Build-Exaxe.Quote.Rules-Dev001");
        masterBuildAdvicePlusDev001.add("Build-Exaxe.Quote-Dev001");
        masterBuildAdvicePlusDev001.add("Build-Exaxe.ExistingBusiness-Dev001");
        masterBuildAdvicePlusDev001.add("Build-PointOfSaleUI-Dev001");
        masterBuildAdvicePlusDev001.add("Deploy-AdvicePlus-Dev001");

		List<String> masterBuildPolicyEBIDev001 = new ArrayList<String>()
		masterBuildPolicyEBIDev001.add("Build-Exaxe.PolicyEBI-Dev001"); 
		masterBuildPolicyEBIDev001.add("Build-ExistingBusinessUI-Dev001"); 
		masterBuildPolicyEBIDev001.add("Deploy-PolicyEBI-Dev001-Aviva"); 
		masterBuildPolicyEBIDev001.add("Deploy-PolicyEBI-Dev001-Aviva-Test"); 
		masterBuildPolicyEBIDev001.add("Deploy-PolicyEBI-Dev001-Aviva-Production"); 

		List<String> masterBuildAdvicePlusRelease = new ArrayList<String>()
		masterBuildAdvicePlusRelease.add("Build-Exaxe.Types-AdvicePlus-Release"); 
		masterBuildAdvicePlusRelease.add("Build-Exaxe.Libraries-AdvicePlus-Release"); 
		masterBuildAdvicePlusRelease.add("Build-Exaxe.Agent-AdvicePlus-Release"); 
		masterBuildAdvicePlusRelease.add("Build-Exaxe.App-AdvicePlus-Release"); 
		masterBuildAdvicePlusRelease.add("Build-Exaxe.Common-AdvicePlus-Release"); 
		masterBuildAdvicePlusRelease.add("Build-Exaxe.Configuration-AdvicePlus-Release"); 
		masterBuildAdvicePlusRelease.add("Build-Exaxe.Rules-AdvicePlus-Release"); 
		masterBuildAdvicePlusRelease.add("Build-Exaxe.Comment-AdvicePlus-Release"); 
		masterBuildAdvicePlusRelease.add("Build-Exaxe.SystemConfiguration-AdvicePlus-Release"); 
		masterBuildAdvicePlusRelease.add("Build-Exaxe.Users-AdvicePlus-Release");
		masterBuildAdvicePlusRelease.add("Build-Exaxe.UIElements-AdvicePlus-Release");
		masterBuildAdvicePlusRelease.add("Build-SystemConfigurationUI-AdvicePlus-Release");
		masterBuildAdvicePlusRelease.add("Build-Exaxe.Calculations-AdvicePlus-Release");
        masterBuildAdvicePlusRelease.add("Build-Exaxe.Client-AdvicePlus-Release");
        masterBuildAdvicePlusRelease.add("Build-Exaxe.FactFind-AdvicePlus-Release");
        masterBuildAdvicePlusRelease.add("Build-Exaxe.Quote.Rules-AdvicePlus-Release");
        masterBuildAdvicePlusRelease.add("Build-Exaxe.Quote-AdvicePlus-Release");
		masterBuildAdvicePlusRelease.add("Build-Exaxe.ExistingBusiness-AdvicePlus-Release");
        masterBuildAdvicePlusRelease.add("Build-PointOfSaleUI-AdvicePlus-Release");
        masterBuildAdvicePlusRelease.add("Deploy-AdvicePlus-Release-ACORN");

		List<String> masterBuildAdminPlusRelease = new ArrayList<String>()
		masterBuildAdminPlusRelease.add("Build-Exaxe.Types-AdminPlus-Release"); 
		masterBuildAdminPlusRelease.add("Build-Exaxe.Libraries-AdminPlus-Release"); 
		masterBuildAdminPlusRelease.add("Build-Exaxe.Rest-AdminPlus-Release"); 
		masterBuildAdminPlusRelease.add("Build-Exaxe.Web-AdminPlus-Release"); 
		masterBuildAdminPlusRelease.add("Build-Exaxe.Common-AdminPlus-Release"); 
		masterBuildAdminPlusRelease.add("Build-Exaxe.External-AdminPlus-Release"); 
		masterBuildAdminPlusRelease.add("Build-Exaxe.Agent-AdminPlus-Release"); 
		masterBuildAdminPlusRelease.add("Build-Exaxe.App-AdminPlus-Release"); 
		masterBuildAdminPlusRelease.add("Build-Exaxe.Configuration-AdminPlus-Release"); 
		masterBuildAdminPlusRelease.add("Build-Exaxe.Rules-AdminPlus-Release"); 
		masterBuildAdminPlusRelease.add("Build-Exaxe.Comment-AdminPlus-Release"); 
		masterBuildAdminPlusRelease.add("Build-Exaxe.Document-AdminPlus-Release"); 
		masterBuildAdminPlusRelease.add("Build-Exaxe.SystemConfiguration-AdminPlus-Release"); 
		masterBuildAdminPlusRelease.add("Build-Exaxe.Users-AdminPlus-Release");
		masterBuildAdminPlusRelease.add("Build-Exaxe.Accounting-AdminPlus-Release");
		masterBuildAdminPlusRelease.add("Build-Exaxe.Auth-AdminPlus-Release");
		masterBuildAdminPlusRelease.add("Build-Exaxe.UIElements-AdminPlus-Release");
		masterBuildAdminPlusRelease.add("Build-SystemConfigurationUI-AdminPlus-Release");
		masterBuildAdminPlusRelease.add("Build-Exaxe.Calculations-AdminPlus-Release");
        masterBuildAdminPlusRelease.add("Build-Exaxe.Client-AdminPlus-Release");
		masterBuildAdminPlusRelease.add("Build-Exaxe.AdminPlus-AdminPlus-Release"); 
		masterBuildAdminPlusRelease.add("Build-Exaxe.Apex-AdminPlus-Release"); 
		masterBuildAdminPlusRelease.add("Build-Exaxe.Aggregate-AdminPlus-Release"); 
		masterBuildAdminPlusRelease.add("Build-Exaxe.Apex.Activities-AdminPlus-Release"); 
		masterBuildAdminPlusRelease.add("Build-Exaxe.Apex.Server-AdminPlus-Release"); 
		masterBuildAdminPlusRelease.add("Build-AdminPlusUI-AdminPlus-Release"); 
		masterBuildAdminPlusRelease.add("Deploy-AdminPlus-Release-OneFamily"); 
		masterBuildAdminPlusRelease.add("Deploy-AdminPlus-Release-OneFamily-Exaxe"); 
		masterBuildAdminPlusRelease.add("Deploy-AdminPlus-Release-OneFamily-Test"); 
		masterBuildAdminPlusRelease.add("Deploy-AdminPlus-Release-OneFamily-Staging"); 
		masterBuildAdminPlusRelease.add("Deploy-AdminPlus-Release-OneFamily-Production"); 

        List<String> masterBuildChannelPlusDev001 = new ArrayList<String>();
		masterBuildChannelPlusDev001.add("Build-Exaxe.ChannelPlus-Dev001"); 
		masterBuildChannelPlusDev001.add("Build-ChannelPlusUI-Dev001"); 
		
		List<String> buildSteps = new ArrayList<String>();
        switch (masterBuildType) {
			case "MasterBuildBaseDev001":
                buildSteps = masterBuildBaseDev001;
                break
            case "MasterBuildAdminPlusDev001":
                buildSteps = masterBuildAdminPlusDev001;
                break
            case "MasterBuildAdminPlusDev002":
                buildSteps = masterBuildAdminPlusDev002;
                break
            case "MasterBuildAdminPlusDev004":
                buildSteps = masterBuildAdminPlusDev004;
                break
            case "MasterBuildAdminPlusRelease":
                buildSteps = masterBuildAdminPlusRelease;
                break
			case "MasterBuilderAdvicePlusDev001":
                buildSteps = masterBuildAdvicePlusDev001;
                break
			case "MasterBuilderAdvicePlusDev002":
                buildSteps = masterBuildAdvicePlusDev002;
                break
			case "MasterBuilderAdvicePlusRelease":
                buildSteps = masterBuildAdvicePlusRelease;
                break
			case "MasterBuildPolicyEBIDev001":
                buildSteps = masterBuildPolicyEBIDev001;
                break
			case "MasterBuildChannelPlusDev001":
                buildSteps = masterBuildChannelPlusDev001;
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
}