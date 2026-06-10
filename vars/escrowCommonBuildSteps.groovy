class escrowCommonBuildSteps implements Serializable {
    def getEscrowCommonBuildSteps(val) { 
		
		List commonDeploySteps = new ArrayList<Map<String,String>>();

		switch (val) {
            case "escrowRelease":
                def escrowReleaseClass = new escrowRelease();
				commonDeploySteps = escrowReleaseClass.getEscrowSteps();
                break
            case "escrowReleaseV2":
                def escrowReleaseV2Class = new escrowReleaseV2();
				commonDeploySteps = escrowReleaseV2Class.getEscrowSteps();
                break
            default:             
                break
        }  

		//Return All of the defined steps
		commonDeploySteps
    }
}