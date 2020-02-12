def call(jsondata){
def jsonString = jsondata
//println(jsonString)
def jsonObj = readJSON text: jsonString
println(jsonObj.scm)
println(jsonObj.scm.projects.project.repositories.repository.branches[0].branch[0].size())

/*String a=jsonObj.scm.projects.project.repositories.repository.repo_name
String repoName=a.replaceAll("\\[", "").replaceAll("\\]","");
String b=jsonObj.scm.projects.project.project_key 
String projectKey=b.replaceAll("\\[", "").replaceAll("\\]","");
String c=jsonObj.scm.projects.project.repositories.repository.branches.startPoint
String sPoint=c.replaceAll("\\[", "").replaceAll("\\]","");

for(i=0;i<3;i++)
    {
String d=jsonObj.scm.projects.project.repositories.repository.branches[0].branch[0].name[i] 
String branchname=d.replaceAll("\\[", "").replaceAll("\\]","");
    println(branchname)
    println(sPoint)
httpRequest authentication: 'bitbucket_cred', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'POST', requestBody: """
{
    "name": "${branchname}",
    "startPoint": "${sPoint}"   
}""", responseHandle: 'NONE', url:"http://18.224.68.30:7990/rest/api/1.0/projects/EDN/repos/newrepo3/branches"
    }*/
  }
