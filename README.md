# BuildServer
Repository for groovy scripts

## Build Types 

| BuildType                                       | You should use this type when: | Stages |
|-------------------------------------------------|--------------------------------|--------|
| FullBuild                                       |                                |[here](Documentation/BuildTypes/README.md)|
| FullBuildWithoutGetAllCodeLatestVersionStage    |                                |[here](Documentation/BuildTypes/README.md)|
| BuildDBSyncService                              |                                |[here](Documentation/BuildTypes/README.md)|
| BuildWithoutDB                                  |                                |[here](Documentation/BuildTypes/README.md)|
| BuildUI                                         |                                |[here](Documentation/BuildTypes/README.md)|


## Action String Types 
| Type | Params | Usage |
|:------:|--------------------------------|--------------------------------|
| 1 | ${appRootPath} ${configFile} 'N/A' ${operation} ${tfsUsername} ${tfsPassword}| GetAllCodeLatestVersion |
| 2 | ${appRootPath} ${configFile} ${projectName} ${operation} ${tfsUsername} ${tfsPassword}")| GetCodeLatestVersion, __CheckOutFiles__, UpdateAssemblyVersion, __CheckInFiles__ |
| 3 | ${appRootPath} ${configFile} ${projectName} ${operation}"| Everything else|


