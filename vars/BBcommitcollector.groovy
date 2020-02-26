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
//def commiter=1
List<String> JSON = new ArrayList<String>();

for(i=0;i<ecount;i++)
 {
  for(j=0;j<total;j++)
  {
   if(jsonObj.config.emails.email[i]==resultJson.values.author[j].emailAddress)
   {
	//JSON.add(JsonOutput.toJson(resultJson.values[j]))
	 def y = resultJson.values[j]
    
    }
	  
      }

//def result = JSON.groupBy({ customer -> customer.country })	 
	 
//def Array = JSON;
//def Property = "resultJson.values.author[i].emailAddress";
//def commitsbyuser = JSON.groupBy(JSON, Property);
//println(commitsbyuser)
	 
//def n=JsonOutput.toJson(JSON.groupBy{it.resultJson.values.author[j].emailAddress}.collect{['resultJson.values.author[j].emailAddress':it.key]})
//println(n)
  }
 

println(y)	
println(y.size())

//def Array= jsonSlurper.parse(new File("/var/lib/jenkins/workspace/${JOB_NAME}/output.json"))	
//def Array = jsonSlurper.parse(JSON)
/*def Property = "Array.values.author[1].emailAddress";
def commitsbyuser = Array.groupBy(Array, Property);
println(commitsbyuser)*/
	 
 }


