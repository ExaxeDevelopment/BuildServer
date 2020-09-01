class deployCommonBuildSteps implements Serializable {
    def getDeployCommonBuildSteps(val) { 
		
		List commonDeploySteps = new ArrayList<Map<String,String>>();

		switch (val) {
            case "DeployAdvicePlus":
                def deployAdvicePlusClass = new deployAdvicePlus();
				commonDeploySteps = deployAdvicePlusClass.getDeploySteps();
                break
            case "DeployAdvicePlusRelease":
                def deployAdvicePlusReleaseClass = new deployAdvicePlusRelease();
				commonDeploySteps = deployAdvicePlusReleaseClass.getDeploySteps();
                break
			case "DeployAdminPlus":
                def deployAdminPlusClass = new deployAdminPlus();
				commonDeploySteps = deployAdminPlusClass.getDeploySteps();
                break
			case "DeployAdminPlusV2":
                def deployAdminPlusV2Class = new deployAdminPlusV2();
				commonDeploySteps = deployAdminPlusV2Class.getDeploySteps();
                break
			case "DeployAdminPlusV3":
                def deployAdminPlusPMClass = new deployAdminPlusPM();
				commonDeploySteps = deployAdminPlusPMClass.getDeploySteps();
                break
			case "DeployRelease_Hansard":
                def deployRelease_HansardClass = new deployRelease_Hansard();
				commonDeploySteps = deployRelease_HansardClass.getDeploySteps();
                break			
            case "DeployPolicyEBI":
                def deployPolicyEbiClass = new deployPolicyEbi();
				commonDeploySteps = deployPolicyEbiClass.getDeploySteps();
                break
			case "DeployChannelPlus":
                def deployChannelPlusClass = new deployChannelPlus();
				commonDeploySteps = deployChannelPlusClass.getDeploySteps();
                break
			case "DeployHansardPortals":
                def deployHansardPortalsClass = new deployHansardPortals();
				commonDeploySteps = deployHansardPortalsClass.getDeploySteps();
                break
			case "DeployWebApi":
                def deployWebApiClass = new deployWebApi();
				commonDeploySteps = deployWebApiClass.getDeploySteps();
                break
			case "DeploySystemConfiguration":
                def deploySystemConfigurationClass = new deploySystemConfiguration();
				commonDeploySteps = deploySystemConfigurationClass.getDeploySteps();
                break
			case "DeployProductDevelopment":
                def deployProductDevelopmentClass = new deployProductDevelopment();
				commonDeploySteps = deployProductDevelopmentClass.getDeploySteps();
                break
            default:             
                break
        }  

		//Return All of the defined steps
		commonDeploySteps
    }
}