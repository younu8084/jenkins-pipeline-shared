def call(jsondata){
def jsonString = jsondata
//println(jsonString)
def jsonObj = readJSON text: jsonString
println(jsonObj.scm)

String a=jsonObj.scm.projects.project.repositories[0].repository[0].repo_name
String repoName=a.replaceAll("\\[", "").replaceAll("\\]","");
String b=jsonObj.scm.projects.project.project_key 
String projectKey=b.replaceAll("\\[", "").replaceAll("\\]","");
String c=jsonObj.scm.projects.project.repositories.repository.branches.startPoint 
String sPoint=c.replaceAll("\\[", "").replaceAll("\\]","");
String d=jsonObj.scm.projects.project.repositories.repository.branches[0].branch[0].name[2] 
String branchname=d.replaceAll("\\[", "").replaceAll("\\]","");
    println(branchname)
    println(sPoint)
httpRequest authentication: 'bitbucket_cred', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'DELETE', requestBody: """
{
    "name": "${branchname}",
    "startPoint": "${sPoint}"   
}""", responseHandle: 'NONE', url:"http://18.224.68.30:7990/rest/branch-utils/1.0/projects/${projectKey}/repos/${repoName}/branches"
  
  }
