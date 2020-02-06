def call(message,jsondata)
{
  
def jsonString = jsondata
def jsonObj = readJSON text: jsonString
println(jsonObj.scm)

String a=jsonObj.scm.projects.project.repositories.repository.name
String projectName=a.replaceAll("\\[", "").replaceAll("\\]","");
  
 
 println(message)
  Date date = new Date() 
  sh " echo '${date}' NEXUS '${projectName}' ${message} >>log.txt"
}
