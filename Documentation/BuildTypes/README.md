# Build Types

| Stages	| FullBuild	| FullBuildWithoutGetAllCodeLatestVersionStage	| BuildDBSyncService	| BuildWithoutDB	| BuildUI| 
|:----:|:----:|:----:|:----:|:----:|:----:| 
| Stage 1	| GetAllCodeLatestVersion	| GetAllCodeLatestVersion	| GetAllCodeLatestVersion	| GetCodeLatestVersion	| GetCodeLatestVersion | 
| Stage 2	| GetCodeLatestVersion	| ClearDatabases	| GetCodeLatestVersion	| CheckOutFiles	| CheckOutFiles | 
| Stage 3	| ClearDatabases	| InstallAllDatabases	| CheckOutFiles	| UpdateAssemblyVersion	| UpdateAssemblyVersion | 
| Stage 4	| InstallAllDatabases	| CheckOutFiles	| RestoreNuGetPackages	| RestoreNuGetPackages	| RestoreNuGetPackages | 
| Stage 5	| CheckOutFiles	| UpdateAssemblyVersion	| BuildSolution	| UpdateNuGetPackages	| UpdateNuGetPackages | 
| Stage 6	| UpdateAssemblyVersion	| RestoreNuGetPackages	| PerformUnitTests	| BuildSolution	| BuildSolution | 
| Stage 7	| RestoreNuGetPackages	| UpdateNuGetPackages	| Provision	| PerformUnitTests	| PerformUnitTests | 
| Stage 8	| UpdateNuGetPackages	| BuildSolution	| Synchronize	| CheckInFiles	| CheckInFiles | 
| Stage 9	| BuildSolution	| PerformUnitTests	| InstallAllDatabases	| PublishNuGetPackages	|  | 
| Stage 10	| PerformUnitTests	| CheckInFiles	| Reprovision	| CheckNuGetFeed	|  | 
| Stage 11	| CheckInFiles	| PublishNuGetPackages	| Synchronize	| 	|  | 
| Stage 12	| PublishNuGetPackages	| CheckNuGetFeed	| 	| 	|  | 
| Stage 13	| CheckNuGetFeed	| DistributeSQLScripts	| 	| 	|  | 
| Stage 14	| DistributeSQLScripts	| 	| 	| 	|  | 


