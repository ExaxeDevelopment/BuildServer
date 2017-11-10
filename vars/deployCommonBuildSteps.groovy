class deployCommonBuildSteps implements Serializable {
    def getDeployCommonBuildSteps(val) { 
		
		List commonDeploySteps = new ArrayList<Map<String,String>>();

		switch (val) {
            case "DeployAdvicePlus":
                def deployAdvicePlusClass = new deployAdvicePlus();
				commonDeploySteps = deployAdvicePlusClass.getDeploySteps();
                break
			case "DeployAdminPlus":
                def deployAdminPlusClass = new deployAdminPlus();
				commonDeploySteps = deployAdminPlusClass.getDeploySteps();
                break
			case "DeployAdminPlusPM":
                def deployAdminPlusPMClass = new deployAdminPlusPM();
				commonDeploySteps = deployAdminPlusPMClass.getDeploySteps();
                break
            default:             
                break
        }  

		//Return All of the defined steps
		commonDeploySteps
    }
}