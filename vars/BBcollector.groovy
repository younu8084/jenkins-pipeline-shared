def call(json){
def jsonString = json
def jsonObj = readJSON text: jsonString

String b=jsonObj.scm.projects.project.project_key 
String Key=b.replaceAll("\\[", "").replaceAll("\\]","");
println(key)
sh 'curl -X GET -i -H  -d  -u rig:rigaDapt@devOps "http://18.224.68.30:7990/rest/api/1.0/projects/EDN/repos" '
sh "curl -X GET -i -H  -d  -u rig:rigaDapt@devOps http://18.224.68.30:7990/rest/api/1.0/projects/'${Key}'"
sh 'curl -X GET -i -H  -d  -u rig:rigaDapt@devOps "http://18.224.68.30:7990/rest/api/1.0/projects/EDN/repos/newrepo/branches" '
sh "curl -X GET -i -H  -d  -u rig:rigaDapt@devOps http://18.224.68.30:7990/rest/api/1.0/projects/'${Key}'/repos/newrepo/tags " 
 sh 'curl -X GET -i -H  -d  -u rig:rigaDapt@devOps "http://18.224.68.30:7990/rest/api/1.0/users/rig/repos/newrepo/commits" '
}
