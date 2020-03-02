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
List<String> JCOPY = new ArrayList<String>();
//Map<String, List<String>> map = new HashMap<String, List<String>>();
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
	 //def count=JSON.size()
	
	 //println(jsonObj.config.emails.email[i])
	 JCOPY[i]=(JsonOutput.toJson(JSON))
	// map.put(jsonObj.config.emails.email[i],JCOPY[i])
	 JSON.clear()
	 

	  
}

for(i=0;i<JCOPY.size();i++)

	{
		println(JCOPY[i])
	}
	/*def jsonBuilder = new groovy.json.JsonBuilder()
 jsonBuilder.bitbucket(
  "totalcommit" : resultJson,
  "commit_cnt" : resultJson.size()
  )
 println(jsonBuilder)*/

	def jsonBuilder = new groovy.json.JsonBuilder()
	 jsonBuilder.bitbucket(
 "totalcommit" : resultJson,
  "commit_cnt" : resultJson.size(),
   "user1" :JCOPY,
    "user2" :JCOPY
		 )
	
//def user1 = new user1(email:'rituparna.ghosh@wipro.com')
//def user3 = new user3(email:'MO20090733@wipro.com')
		 
def indivudalcommits = [user1,user2]
jsonBuilder(Indivudal:indivudalcommits)
		  
//println("Using list of objects")
//println(jsonBuilder.toPrettyString())
println(jsonBuilder)
}
