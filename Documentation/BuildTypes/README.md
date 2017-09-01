# Build Types

| Build Name| Build Type | Stage 1 | Stage 2 | Stage 3 | Stage 4 | Stage 5 | Stage 6 | Stage 7 | Stage 8 | Stage 9 | Stage 10 | Stage 11 | Stage 12 | Stage 13 | Stage 14 | Stage 15 |
|-|-|-|
|__Full_Build__| 1 | GetAllCodeLatestVersion | ClearDatabases | InstallAllDatabases | CheckOutFiles | UpdateAssemblyVersion | RestoreNuGetPackages | UpdateNuGetPackages | BuildSolution | PerformUnitTests | CheckInFiles | PublishNuGetPackages |	CheckNuGetFeed | DistributeSQLScripts | Success Notification |
|__BoldKey__| Value2 |
