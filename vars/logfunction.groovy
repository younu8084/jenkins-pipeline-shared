import groovy.json.JsonSlurper 
@NonCPS
def call(message)
{
 println(message)
 def request = libraryResource 'data.json'
 def jsonSlurper = new JsonSlurper() 
 def resultJson = jsonSlurper.parseText(request)
 def projectName = resultJson.name
  Date date = new Date() 
  sh " echo '${date}' Bitbucket repository with the reponame '${projectName}' ${message} >>log.txt"
}
