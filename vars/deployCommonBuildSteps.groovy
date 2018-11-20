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
			case "DeployPolicyEBI":
                def deployPolicyEbiClass = new deployPolicyEbi();
				commonDeploySteps = deployPolicyEbiClass.getDeploySteps();
                break
			case "DeployChannelPlus":
                def deployChannelPlusClass = new deployChannelPlus();
				commonDeploySteps = deployChannelPlusClass.getDeploySteps();
                break
			case "DeployChannelPlusUI":
                def deployChannelPlusUIClass = new deployChannelPlusUI();
				commonDeploySteps = deployChannelPlusUIClass.getDeploySteps();
                break
			case "DeployPortalsBroker":
                def deployHansardPortalsBrokerClass = new deployHansardPortalsBroker();
				commonDeploySteps = deployHansardPortalsBrokerClass.getDeploySteps();
                break
			case "DeployPortalsClient":
                def deployHansardsPortalClientClass = new deployHansardPortalsClient();
				commonDeploySteps = deployHansardsPortalClientClass.getDeploySteps();
                break
			case "DeployAdminPlusWebApi":
                def deployAdminPlusWebApiClass = new deployAdminPlusWebApi();
				commonDeploySteps = deployAdminPlusWebApiClass.getDeploySteps();
                break
			case "DeployAuthWebApi":
                def deployAuthWebApiClass = new deployAuthWebApi();
				commonDeploySteps = deployAuthWebApiClass.getDeploySteps();
                break
			case "DeployChannelPlusWebApi":
                def deployChannelPlusWebApiClass = new deployChannelPlusWebApi();
				commonDeploySteps = deployChannelPlusWebApiClass.getDeploySteps();
                break
            default:             
                break
        }  

		//Return All of the defined steps
		commonDeploySteps
    }
}