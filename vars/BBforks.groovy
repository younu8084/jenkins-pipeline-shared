def call(jsondata){
def jsonString = jsondata
def jsonObj = readJSON text: jsonString
String a=jsonObj.scm.projects.project.repositories.repository.repo_name
String repoName=a.replaceAll("\\[", "").replaceAll("\\]","");
String b=jsonObj.scm.projects.project.project_key 
String Key=b.replaceAll("\\[", "").replaceAll("\\]","");
println(Key)
 withCredentials([usernamePassword(credentialsId: 'bitbucket_cred', passwordVariable: 'pass', usernameVariable: 'userId')]) {
def response =  sh "curl -w '%{http_code}' -s -i -X GET  -H -d  -u  $userId:$pass http://18.224.68.30:7990/rest/api/1.0/projects/${Key}/repos/${repoName}/forks -o test.txt"
 }
//def response =new File('/var/lib/jenkins/workspace/' + JOB_NAME + '/test.txt').text
 
  echo " ============ $response"
 if(response == "200")
{
 echo " Forks are listed successfully "
}
else
{
 error("Error while listing")
}
}
