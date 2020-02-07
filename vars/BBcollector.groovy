def call(json){
def jsonString = json
def jsonObj = readJSON text: jsonString

String b=jsonObj.scm.projects.project.project_key 
String Key=b.replaceAll("\\[", "").replaceAll("\\]","");
println(Key)
 withCredentials([usernamePassword(credentialsId: 'bitbucket_cred', passwordVariable: 'pass', usernameVariable: 'userId')]) {
sh "curl GET -i -H -d  -u  $userId:$pass http://18.224.68.30:7990/rest/api/1.0/projects/'${Key}'"
sh "curl GET -i -H -d  -u  $userId:$pass http://18.224.68.30:7990/rest/api/1.0/projects/'${Key}'/repos/Rig" 
sh "curl GET -i -H -d  -u  $userId:$pass http://18.224.68.30:7990/rest/api/1.0/projects/'${Key}'/repos/Rig/branches" 
sh 'curl GET -i -H -d  -u  $userId:$pass "http://18.224.68.30:7990/rest/api/1.0/admin/groups"'
sh "curl GET -i -H -d  -u  $userId:$pass http://18.224.68.30:7990/rest/api/1.0/projects/'${Key}'/repos/rig/commits" 
 }
}
