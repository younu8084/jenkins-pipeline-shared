import groovy.json.*

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
 echo "Total no.of commits in ${repoName} $total"

List<String> JSON = new ArrayList<String>();
List<String> JSON1 = new ArrayList<String>();
/*for(i=0;i<ecount;i++)
 {
 for(j=0;j<total;j++)
	 {
   if(jsonObj.config.emails.email[i]==resultJson.values.author[j].emailAddress)
   {
	   JSON.add(JsonOutput.toJson(resultJson.values[j]))
    }
}

 }*/

for(i=0;i<ecount;i++)
 {	 
 for(j=0;j<total;j++)
	 {
   if(jsonObj.config.emails.email[i]==resultJson.values.author[j].emailAddress)
	  for(i=0;i<ecount;i++)
            if(JSON[i]==JSON1[j+1])
	     {
                JSON.add(JsonOutput.toJson(resultJson.values[j]))
		continue;
	      }
		else
		{
			 JSON1.add(JsonOutput.toJson(resultJson.values[j]))
		}
 }
 }
		
String 
	
println(JSON)
	
println(JSON1)
}
