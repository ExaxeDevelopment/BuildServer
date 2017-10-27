class deployCommonBuildSteps implements Serializable {
    def getDeployCommonBuildSteps(val) { 
		
		List commonDeploySteps = new ArrayList<Map<String,String>>();

		switch (val) {
            case "DeployEpos":
                def deployEposClass = new deployEpos();
				commonDeploySteps = deployEposClass.getDeploySteps();
                break
			case "DeployAdminPlus":
                def deployAdminPlusClass = new deployAdminPlus();
				commonDeploySteps = deployAdminPlusClass.getDeploySteps();
                break
			case "DeployAdminPlusPM":
                def deployAdminPlusPMClass = new deployAdminPlusPM();
				commonDeploySteps = deployAdminPlusPMClass.getDeploySteps();
                break
			case "DeployEpos_1_2_46":
                def deployEpos_1_2_46Class = new deployEpos_1_2_46();
				commonDeploySteps = deployEpos_1_2_46Class.getDeploySteps();
                break
            default:             
                break
        }  

		//Return All of the defined steps
		commonDeploySteps
    }
}