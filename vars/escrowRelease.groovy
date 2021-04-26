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
		deploySteps.add(getStep("Exaxe.Rest"));
		deploySteps.add(getStep("Exaxe.Web"));
		deploySteps.add(getStep("Exaxe.Common"));
		deploySteps.add(getStep("Exaxe.External"));
		deploySteps.add(getStep("Exaxe.Agent"));
		deploySteps.add(getStep("Exaxe.App"));
		deploySteps.add(getStep("Exaxe.Configuration"));
		deploySteps.add(getStep("Exaxe.Rules"));
		deploySteps.add(getStep("Exaxe.Comment"));
		deploySteps.add(getStep("Exaxe.Document"));
		deploySteps.add(getStep("Exaxe.SystemConfiguration"));
		deploySteps.add(getStep("Exaxe.Users"));
		deploySteps.add(getStep("Exaxe.Accounting"));
		deploySteps.add(getStep("Exaxe.Auth"));
		deploySteps.add(getStep("Exaxe.UIElements"));
		deploySteps.add(getStep("Exaxe.Calculations"));
		deploySteps.add(getStep("Exaxe.CalculationManagers"));
		deploySteps.add(getStep("Exaxe.ChannelPlus"));
		deploySteps.add(getStep("Exaxe.Client"));
		deploySteps.add(getStep("Exaxe.AdminPlus"));
		deploySteps.add(getStep("Exaxe.Apex"));
		deploySteps.add(getStep("Exaxe.Aggregate"));
		deploySteps.add(getStep("Exaxe.Client-ADVP"));
		deploySteps.add(getStep("Exaxe.FactFind"));
		deploySteps.add(getStep("Exaxe.Quote.Rules"));
		deploySteps.add(getStep("Exaxe.Quote"));
		deploySteps.add(getStep("Exaxe.ExistingBusiness"));
		deploySteps.add(getStep("Exaxe.WebApi"));
		deploySteps.add(getStep("Exaxe.Apex.Workflow"));
		deploySteps.add(getStep("Exaxe.Apex.Activities"));
		deploySteps.add(getStep("Exaxe.Apex.Server"));
		deploySteps.add(getStep("PointOfSaleUI"));
		deploySteps.add(getStep("AdminPlusUI"));
		deploySteps.add(getStep("ChannelPlusUI"));
		deploySteps.add(getStep("SystemConfigurationUI"));

		//Release Content
		Map<String,String> releaseContentMap  = new HashMap<String,String>();
		releaseContentMap.put("Project", "ReleaseEscrowFiles"); 
		releaseContentMap.put("Operation", "ReleaseEscrowFiles"); 
		deploySteps.add(releaseContentMap);
		
		//Return All of the defined steps
		deploySteps
    }

	private Map<String,String> getStep(val){
		Map<String,String> map  = new HashMap<String,String>();
		map.put("Project", val); 
		map.put("Operation", "EscrowFiles"); 
		
		return map;
	}
}