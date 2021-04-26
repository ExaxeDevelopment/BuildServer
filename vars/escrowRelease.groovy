class escrowRelease implements Serializable {
    def getEscrowSteps() { 
		
		List deploySteps = new ArrayList<Map<String,String>>();

		//Initialisation
		Map<String,String> initialisationMap  = new HashMap<String,String>();
		initialisationMap.put("Project", "Initialisation"); 
		initialisationMap.put("Operation", "Initialisation"); 
		deploySteps.add(initialisationMap);

		//GetAllCodeLatestVersion
		Map<String,String> getAllCodeMap  = new HashMap<String,String>();
		getAllCodeMap.put("Project", "GetAllCodeLatestVersion"); 
		getAllCodeMap.put("Operation", "GetAllCodeLatestVersion"); 
		deploySteps.add(getAllCodeMap);

		deploySteps.add(getStep("Exaxe.Types"));
		deploySteps.add(getStep("Exaxe.Security"));
		deploySteps.add(getStep("Exaxe.Libraries"));

		//Release Content
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseEscrowFiles"); 
		releaseContentMap.put("Operation", "ReleaseEscrowFiles"); 
		deploySteps.add(releaseContentMap);
		
		//Return All of the defined steps
		deploySteps
    }

	def getStep(val){
		Map<String,String> map  = new HashMap<String,String>();
		map.put("Project", val); 
		map.put("Operation", "EscrowFiles"); 
		
		map
	}
}