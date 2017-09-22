# Build Types                       

[Home](../../README.md)

| Stages	| FullBuild	| FullBuildWithoutGetAllCodeLatestVersionStage	| BuildDBSyncService	| BuildWithoutDB	| BuildUI| 
|:----:|:----:|:----:|:----:|:----:|:----:| 
|  1	| GetAllCodeLatestVersion	| GetAllCodeLatestVersion	| GetAllCodeLatestVersion	| GetCodeLatestVersion	| GetCodeLatestVersion | 
|  2	| GetCodeLatestVersion	| ClearDatabases	| GetCodeLatestVersion	| CheckOutFiles	| CheckOutFiles | 
|  3	| ClearDatabases	| InstallAllDatabases	| CheckOutFiles	| UpdateAssemblyVersion	| UpdateAssemblyVersion | 
|  4	| InstallAllDatabases	| CheckOutFiles	| RestoreNuGetPackages	| RestoreNuGetPackages	| RestoreNuGetPackages | 
|  5	| CheckOutFiles	| UpdateAssemblyVersion	| BuildSolution	| UpdateNuGetPackages	| UpdateNuGetPackages | 
|  6	| UpdateAssemblyVersion	| RestoreNuGetPackages	| PerformUnitTests	| BuildSolution	| BuildSolution | 
|  7	| RestoreNuGetPackages	| UpdateNuGetPackages	| Provision	| PerformUnitTests	| PerformUnitTests | 
|  8	| UpdateNuGetPackages	| BuildSolution	| Synchronize	| CheckInFiles	| CheckInFiles | 
|  9	| BuildSolution	| PerformUnitTests	| InstallAllDatabases	| PublishNuGetPackages	|  | 
|  10	| PerformUnitTests	| CheckInFiles	| Reprovision	| CheckNuGetFeed	|  | 
|  11	| CheckInFiles	| PublishNuGetPackages	| Synchronize	| 	|  | 
|  12	| PublishNuGetPackages	| CheckNuGetFeed	| 	| 	|  | 
|  13	| CheckNuGetFeed	| DistributeSQLScripts	| 	| 	|  | 
|  14	| DistributeSQLScripts	| 	| 	| 	|  | 

# Stages Descriptions

| No	| Stage	| Description	|
|:----:|:----:|:----:|
|  1	| GetAllCodeLatestVersion	| 	|
|  2	| GetCodeLatestVersion	| 	|
|  3	| ClearDatabases	| 	|
|  4	| InstallAllDatabases	| 	|
|  5	| CheckOutFiles	| 	|
|  6	| UpdateAssemblyVersion	| 	|
|  7	| RestoreNuGetPackages	| 	|
|  8	| UpdateNuGetPackages	| 	| 
|  9	| BuildSolution	| 	|
|  10	| PerformUnitTests	| 	|
|  11	| CheckInFiles	| 	| 
|  12	| PublishNuGetPackages	| 	|
|  13	| CheckNuGetFeed	| 	|
|  14	| DistributeSQLScripts	| 	|
