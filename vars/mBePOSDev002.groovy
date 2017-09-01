class mBePOSDev002 implements Serializable {
    def getMasterBuildSteps(val) { 
        
		List<String> masterBuildSteps = new ArrayList<String>();

		List<String> allSteps = new ArrayList<String>();
        list.add("Build-Exaxe.Client-Dev003");
        list.add("Build-Exaxe.FactFind-Dev002");
        list.add("Build-Exaxe.Quote.Rules-Dev001");
        list.add("Build-Exaxe.Quote-Dev002");
        list.add("Build-Exaxe.ExistingBusiness-Dev001");
        list.add("Build-PointOfSaleUI-Dev001");
        list.add("Deploy-ePOS-Dev002-ACORN");
		
		def indexOfStartStep = allSteps.findIndexOf { name -> name == val };
        
		masterBuildSteps = 
			allSteps.subList(Math.max(allSteps.size() - indexOfStartStep, 0), allSteps.size());
		
		// Return Selected MasterBuildSteps
		masterBuildSteps
    }
}