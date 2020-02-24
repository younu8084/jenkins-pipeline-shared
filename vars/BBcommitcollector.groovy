import groovy.json.*

def call(jsondata){
def jsonString = jsondata
def jsonObj = readJSON text: jsonString
String a=jsonObj.scm.projects.project.repositories.repository.repo_name
String repoName=a.replaceAll("\\[", "").replaceAll("\\]","");
String b=jsonObj.scm.projects.project.project_key 
String Key=b.replaceAll("\\[", "").replaceAll("\\]","");
println(Key)
println(repoName)
 Date date = new Date() 
 withCredentials([usernamePassword(credentialsId: 'bitbucket_cred', passwordVariable: 'pass', usernameVariable: 'userId')]) {
  sh "curl -X GET  -H -d  -u  $userId:$pass http://18.224.68.30:7990/rest/api/1.0/projects/'${Key}'/repos/'${repoName}'/commits -o output.json"
  

 
 }
 create()
}
@NonCPS
def create()
{
  def jsonSlurper = new JsonSlurper()
  def resultJson = jsonSlurper.parse(new File("/var/lib/jenkins/workspace/${JOB_NAME}/output.json"))
 def value = resultJson.values
 println(value)
 for(i=0;i<=value;i++)
 {
  if(resultJson.author.name=="rig")
  {
   def count=0
   count ++
   }
 }
  
 
}
