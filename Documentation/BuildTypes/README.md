# Build Types

| Build Name| Build Type | Stages |
|-|-|-|
|__Full_Build__| 1 | GetAllCodeLatestVersion |	ClearDatabases	InstallAllDatabases	CheckOutFiles	UpdateAssemblyVersion	RestoreNuGetPackages	UpdateNuGetPackages	BuildSolution	PerformUnitTests	CheckInFiles	PublishNuGetPackages	CheckNuGetFeed	DistributeSQLScripts	Success Notification |
|__BoldKey__| Value2 |
