class getMasterEscrowStepsByProject implements Serializable {
	//// Returns the build steps based on the 'masterBuildType'
	//// The 'firstProject' indicates from where in the list the build will start
    def getMasterEscrowStepsByProject(masterBuildType, firstProject) { 

		List<String> buildSteps = new ArrayList<String>();

        switch (masterBuildType) {
			case "EscrowVACN21_03":
                buildSteps = getEscrowSteps("VACN21_03");
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

	def getMasterBuildParallelStepsByProject(masterBuildType) { 

		List<List<String>> buildSteps = new ArrayList<ArrayList<String>>();

		buildSteps
	}

	private List<String> getMasterBuildReleaseVXX_X(String version)
	{
		List<String> buildItems = new ArrayList<String>()

		buildItems.add("Build-Exaxe.Types-Release-V"+version); 
		buildItems.add("Build-Exaxe.Security-Release-V"+version); 
		buildItems.add("Build-Exaxe.Libraries-Release-V"+version); 
		buildItems.add("Build-Exaxe.Rest-Release-V"+version); 
		buildItems.add("Build-Exaxe.Web-Release-V"+version); 
		buildItems.add("Build-Exaxe.Common-Release-V"+version); 
		buildItems.add("Build-Exaxe.External-Release-V"+version); 
		buildItems.add("Build-Exaxe.Agent-Release-V"+version); 
		buildItems.add("Build-Exaxe.App-Release-V"+version); 
		buildItems.add("Build-Exaxe.Configuration-Release-V"+version); 
		buildItems.add("Build-Exaxe.Rules-Release-V"+version); 
		buildItems.add("Build-Exaxe.Comment-Release-V"+version); 
		buildItems.add("Build-Exaxe.Document-Release-V"+version); 
		buildItems.add("Build-Exaxe.SystemConfiguration-Release-V"+version); 
		buildItems.add("Build-Exaxe.Users-Release-V"+version);
		buildItems.add("Build-Exaxe.Accounting-Release-V"+version);
		buildItems.add("Build-Exaxe.Auth-Release-V"+version);
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
		buildItems.add("Build-Exaxe.WebApi-Release-V"+version); 
		buildItems.add("Build-Exaxe.Apex.Workflow-Release-V"+version); 
		buildItems.add("Build-Exaxe.Apex.Activities-Release-V"+version); 
		buildItems.add("Build-Exaxe.Apex.Server-Release-V"+version); 
		buildItems.add("Build-SystemConfigurationUI-Release-V"+version);
		buildItems.add("Build-PointOfSaleUI-Release-V"+version); 
		buildItems.add("Build-AdminPlusUI-Release-V"+version); 
		buildItems.add("Build-ChannelPlusUI-Release-V"+version); 	
		
		return buildItems;		
	}
}