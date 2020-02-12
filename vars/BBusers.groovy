def call(jsondata){
def jsonString = jsondata
def jsonObj = readJSON text: jsonString

String b=jsonObj.scm.projects.project.project_key 
String Key=b.replaceAll("\\[", "").replaceAll("\\]","");
println(Key)
 withCredentials([usernamePassword(credentialsId: 'bitbucket_cred', passwordVariable: 'pass', usernameVariable: 'userId')]) {
  sh "curl -s GET http://18.224.68.30:7990/rest/api/1.0/projects/'${Key}'/permissions/users --user $userId:$pass  -o output.json"


 
 }
}
