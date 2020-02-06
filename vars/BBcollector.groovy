def call(JSON){
def jsonString = JSON
def jsonObj = readJSON text: jsonString

String a=jsonObj.ci.id.deploymentProjectId
String id=a.replaceAll("\\[", "").replaceAll("\\]","");
 String b=jsonObj.ci.list.key
String key=b.replaceAll("\\[", "").replaceAll("\\]","");
println(id)
sh 'curl -X GET -i -H  -d  -u rig:rigaDapt@devOps "http://18.220.143.53:8085/rest/api/latest/plan.json" '
sh 'curl -X GET -i -H  -d  -u rig:rigaDapt@devOps "http://18.220.143.53:8085/rest/api/latest/project.json" '
sh "curl -X GET -i -H  -d  -u rig:rigaDapt@devOps http://18.220.143.53:8085/rest/api/latest/deploy/project/'${id}' "  
sh "curl -X GET -i -H  -d  -u rig:rigaDapt@devOps http://18.220.143.53:8085/rest/api/latest/deploy/project/'${id}'/versions " 
 sh "curl -X GET -i -H  -d  -u rig:rigaDapt@devOps http://18.220.143.53:8085/rest/api/latest/project/'${key}'.json " 
}
