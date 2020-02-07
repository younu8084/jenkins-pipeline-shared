def call(message,JSON)
{
  
def jsonString = JSON
def jsonObj = readJSON text: jsonString
println(jsonObj.scm)

String b=jsonObj.scm.projects.project.project_key 
String Key=b.replaceAll("\\[", "").replaceAll("\\]","");

 println(message)
  Date date = new Date() 
 
      sh " echo '${date}' Bitbucket  ${message}  >>log.txt"
}
