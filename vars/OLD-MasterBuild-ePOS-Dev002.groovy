import hudson.Util;

def jobBuild = "";

def duration = "";

try{
	
    node{
        jobBuild = "Build-Exaxe.Client-Dev003";
        stage(jobBuild){    
            build jobBuild;
        }
		
        jobBuild = "Build-Exaxe.FactFind-Dev002";
        stage(jobBuild){    
            build jobBuild;
        }
		
        jobBuild = "Build-Exaxe.Quote.Rules-Dev001";
        stage(jobBuild){    
            build jobBuild;
        }
		
        jobBuild = "Build-Exaxe.Quote-Dev002";
        stage(jobBuild){    
            build jobBuild;
        }
		
        jobBuild = "Build-Exaxe.ExistingBusiness-Dev001";
        stage(jobBuild){    
            build jobBuild;
        } 

        jobBuild = "Build-PointOfSaleUI-Dev001";
        stage(jobBuild){    
            build jobBuild;
        } 

        jobBuild = "Deploy-ePOS-Dev002-ACORN";
        stage(jobBuild){    
            build jobBuild;
        }

        currentBuild.result = "SUCCESS";
		
        duration = "Build duration: ${Util.getTimeSpanString(System.currentTimeMillis() - currentBuild.startTimeInMillis)}";
		
        try{
            stage("Success Notification"){
                echo duration;
				
                mail to: "${DEV_TEAM_EMAIL}", 
                subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
                body: "${env.BUILD_URL} \r\n ${duration}" 
            }
        }
        catch(err){
            echo "Notification stage failed, but build was successful.";
            echo "Error: ${err}"
        }
		
    } //// end node
}
catch(err){
    echo "Build Failed...";
	
    currentBuild.result = "FAILURE";	
	
    node{
        stage("Error Notification"){
            mail to: "${DEV_TEAM_EMAIL}", 
            subject: " ${JOB_NAME} (Build ${currentBuild.displayName} / ${currentBuild.result})", 
            body: "The build failed on stage: ${jobBuild} \r\nError: ${err} \r\nURL: ${env.BUILD_URL}"      
        }
    }
	
}