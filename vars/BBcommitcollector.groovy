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

  sh "curl -X GET  -H -d  -u  rig:rigaDapt@devOps http://18.224.68.30:7990/rest/api/1.0/projects/EDN/repos/demo12/users/rig/commits?since='${date}'&until='${date}' -o output.json"
 
}
