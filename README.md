# BuildServer
Repository for groovy scripts

## Build Types 

| BuildType                                       | You should use this type when: | Stages |
|:-----------------------------------------------|--------------------------------|--------|
| FullBuild                                       |                                |[here](Documentation/BuildTypes/README.md)|
| FullBuildWithoutGetAllCodeLatestVersionStage    |                                |[here](Documentation/BuildTypes/README.md)|
| BuildWithoutDB                                  |                                |[here](Documentation/BuildTypes/README.md)|
| BuildWithoutDBAndUnitTests                      |                                |[here](Documentation/BuildTypes/README.md)|
| BuildWithoutPublishNugGet                       |                                |[here](Documentation/BuildTypes/README.md)|
| BuildApexServer                                 |                                |[here](Documentation/BuildTypes/README.md)|
| BuildUI                                         |                                |[here](Documentation/BuildTypes/README.md)|
| BuildDBSyncService                              |                                |[here](Documentation/BuildTypes/README.md)|
| UpdatePackagesWithoutBuild                      |                                |[here](Documentation/BuildTypes/README.md)|
| UpdatePackagesWithBuild                         |                                |[here](Documentation/BuildTypes/README.md)|


## Action String Types 
| Type | Params | Usage |
|:------:|--------------------------------|--------------------------------|
| 1 | ${appRootPath} ${configFile} 'N/A' ${operation} ${Username} ${Password}| GetAllCodeLatestVersion |
| 2 | ${appRootPath} ${configFile} ${projectName} ${operation} ${Username} ${Password}")| GetCodeLatestVersion, __CheckOutFiles__, UpdateAssemblyVersion, __CheckInFiles__ |
| 3 | ${appRootPath} ${configFile} ${projectName} ${operation}"| Everything else|


