class actionString implements Serializable {
  
  def stagesWithoutProject = ["GetAllCodeLatestVersion", "Initialisation", "ReleaseContent", "ReleaseEscrowFiles"] 

  def createActionString(appRootPath, configFile, projectName, operation) {
    private String actionString;
    
    if (stagesWithoutProject.contains(operation)) {
      actionString = appRootPath + " " + configFile + " " + "'N/A'" + " " + operation;
    }
    else {
      actionString = appRootPath + " " + configFile + " " + projectName + " " + operation;
    }
    
     return actionString;        
  }
}