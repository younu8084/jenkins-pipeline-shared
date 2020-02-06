def call(json){
def jsonString = json
def jsonObj = readJSON text: jsonString

String b=jsonObj.scm.projects.project.project_key 
String Key=b.replaceAll("\\[", "").replaceAll("\\]","");
println(Key)
sh 'curl -X GET -i -H  -d  -u rig:rigaDapt@devOps "http://18.224.68.30:7990/rest/api/1.0/projects/EDN/repos" '
sh "curl -X GET -i -H  -d  -u rig:rigaDapt@devOps http://18.224.68.30:7990/rest/api/1.0/projects/'${Key}'"
sh 'curl -X GET -i -H  -d  -u rig:rigaDapt@devOps "http://18.224.68.30:7990/rest/api/1.0/projects/EDN/repos/Rig/branches" '
sh "curl -X GET -i -H  -d  -u rig:rigaDapt@devOps  http://18.224.68.30:7990/rest/api/1.0/projects/'${Key}'/repos/Rig/tags " 
 sh 'curl -X GET -i -H  -d  -u rig:rigaDapt@devOps "http://18.224.68.30:7990/rest/api/1.0/users/rig/repos/Rig/commits" '

}
