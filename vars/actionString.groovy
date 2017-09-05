class actionString implements Serializable {
  
  def stagesWithSixParams = ["GetCodeLatestVersion", "CheckOutFiles", "UpdateAssemblyVersion", "CheckInFiles"]
  def stagesWithCustomParams = ["GetAllCodeLatestVersion"] 
  def stagesWithFourCustomParans = ["Initialisation", "ReleaseContent"]

  def createActionString(appRootPath, configFile, projectName, operation, userName, userPassword) {
    private String actionString;
    
    if(stagesWithSixParams.contains(operation)){
      actionString = appRootPath + " " + configFile + " " + projectName + " " + operation + " " + userName + " " + userPassword;      
    }
    else if (stagesWithCustomParams.contains(operation)) {
      actionString = appRootPath + " " + configFile + " " + "'N/A'" + " " + operation + " " + userName + " " + userPassword;
    }
	else if (stagesWithFourCustomParans.contains(operation)) {
      actionString = appRootPath + " " + configFile + " " + "'N/A'" + " " + operation;
    }
    else {
      // action string with four params      
      actionString = appRootPath + " " + configFile + " " + projectName + " " + operation;
    }
    
     return actionString;        
  }
}