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

		// Exaxe.Types Get Latest Code
		// Exaxe.Types GetEscrow
		Map<String,String> typesMap  = new HashMap<String,String>();
		typesMap.put("Project", "Exaxe.Types"); 
		typesMap.put("Operation", "EscrowFiles"); 
		deploySteps.add(typesMap);

		// Exaxe.Security GetEscrow
		Map<String,String> securityMap  = new HashMap<String,String>();
		securityMap.put("Project", "Exaxe.Security"); 
		securityMap.put("Operation", "EscrowFiles"); 
		deploySteps.add(securityMap);

		Map<String,String> librariesMap  = new HashMap<String,String>();
		librariesMap.put("Project", "Exaxe.Libraries"); 
		librariesMap.put("Operation", "EscrowFiles"); 
		deploySteps.add(librariesMap);

		//Release Content
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseEscrowFiles"); 
		releaseContentMap.put("Operation", "ReleaseEscrowFiles"); 
		deploySteps.add(releaseContentMap);
		
		//Return All of the defined steps
		deploySteps
    }
}