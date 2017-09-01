# Build Types

| Stage | Build Name | Build Type |
|-|-|-|
||__Full_Build__| 1 |
|1|	GetAllCodeLatestVersion|
|2|	GetCodeLatestVersion|
|3|	ClearDatabases|
|4|	InstallAllDatabases|
|5|	CheckOutFiles|
|6|	UpdateAssemblyVersion|
|7|	RestoreNuGetPackages|
|8|	UpdateNuGetPackages|
|9|	BuildSolution|
|10|	PerformUnitTests|
|11|	CheckInFiles|
|12|	PublishNuGetPackages|
|13|	CheckNuGetFeed|
|14|	DistributeSQLScripts|

