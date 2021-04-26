class escrowRelease implements Serializable {
    def getEscrowSteps() { 
		
		List deploySteps = new ArrayList<Map<String,String>>();

		//Initialisation
		Map<String,String> initialisationMap  = new HashMap<String,String>();
		initialisationMap.put("Project", "Initialisation"); 
		initialisationMap.put("Operation", "Initialisation"); 
		deploySteps.add(initialisationMap);

		//Delete Workspace Mappings
		Map<String,String> securityMapDWM  = new HashMap<String,String>();
		securityMapDWM.put("Project", "Exaxe.Security"); 
		securityMapDWM.put("Operation", "DeleteWorkspaceMappings"); 
		deploySteps.add(securityMapDWM);

		//GetAllCodeLatestVersion
		Map<String,String> getAllCodeMap  = new HashMap<String,String>();
		getAllCodeMap.put("Project", "GetAllCodeLatestVersion"); 
		getAllCodeMap.put("Operation", "GetAllCodeLatestVersion"); 
		deploySteps.add(getAllCodeMap);

		// Exaxe.Types Get Latest Code
		// Exaxe.Types GetEscrow
		Map<String,String> typesMap2  = new HashMap<String,String>();
		typesMap2.put("Project", "Exaxe.Types"); 
		typesMap2.put("Operation", "EscrowFiles"); 
		deploySteps.add(typesMap2);

		// Exaxe.Security Get Latest Code
		Map<String,String> securityMap  = new HashMap<String,String>();
		securityMap.put("Project", "Exaxe.Security"); 
		securityMap.put("Operation", "GetCodeLatestVersion"); 
		deploySteps.add(securityMap);

		// Exaxe.Security GetEscrow
		Map<String,String> securityMap2  = new HashMap<String,String>();
		securityMap2.put("Project", "Exaxe.Security"); 
		securityMap2.put("Operation", "EscrowFiles"); 
		deploySteps.add(securityMap2);

		//Release Content
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseEscrowFiles"); 
		releaseContentMap.put("Operation", "ReleaseEscrowFiles"); 
		deploySteps.add(releaseContentMap);
		
		//Return All of the defined steps
		deploySteps
    }
}