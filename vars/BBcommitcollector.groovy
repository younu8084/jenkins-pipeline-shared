import groovy.json.*
import groovy.json.JsonOutput

def call(jsondata){
def jsonString = jsondata
def jsonObj = readJSON text: jsonString
String a=jsonObj.scm.projects.project.repositories.repository.repo_name
String repoName=a.replaceAll("\\[", "").replaceAll("\\]","");
String b=jsonObj.scm.projects.project.project_key 
String Key=b.replaceAll("\\[", "").replaceAll("\\]","");
int ecount = jsonObj.config.emails.email.size()
println("No of users "+ ecount)
println(Key)
println(repoName)
// Date date = new Date() 
 withCredentials([usernamePassword(credentialsId: 'bitbucket_cred', passwordVariable: 'pass', usernameVariable: 'userId')]) {
  sh "curl -X GET  -H -d  -u $userId:$pass http://18.224.68.30:7990/rest/api/1.0/projects/'${Key}'/repos/'${repoName}'/commits -o output.json"
 } 

def jsonSlurper = new JsonSlurper()
def resultJson = jsonSlurper.parse(new File("/var/lib/jenkins/workspace/${JOB_NAME}/output.json"))
def total = resultJson.size
echo "Total no.of commits in $repoName $total"
//File file = new File(output.json)
//file.write(total)
//def commiter=1
List<String> JSON = new ArrayList<String>();
List<String> JCOPY = new ArrayList<String>();

for(i=0;i<ecount;i++)
{	 
  for(j=0;j<total;j++)
  {
 if(jsonObj.config.emails.email[i]==resultJson.values.author[j].emailAddress)
	     {
	JSON.add(resultJson.values[j])
	//println(JSON) 
      
		     
    }
	
      
  
      }
	 
	
	 count=JSON.size()
	 //  println(USER)
          	
     String res = String.join(",", JSON);
        println(JSON);
	   JCOPY.add(["Email":jsonObj.config.emails.email[i],"Individual_commit":JsonOutput.toJson(JSON),"Commit_count":count])
	 //JCOPY[i]=JsonOutput.toJson(JSON)
	 
	
	
	 JSON.clear()
	 

	  
}

def jsonBuilder = new groovy.json.JsonBuilder()

jsonBuilder.bitbucket(
  "Total_commits": resultJson.values,
 "Commit_count": resultJson.size(),
 "Individual_commits":JCOPY
)



File file = new File("/var/lib/jenkins/workspace/${JOB_NAME}/commits1.json")
file.write(jsonBuilder.toPrettyString())	


}


