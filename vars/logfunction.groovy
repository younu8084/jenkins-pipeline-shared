import groovy.json.JsonSlurper 
@NonCPS
def call(message)
{
 println(message)
 def request = libraryResource 'data.json'
 def jsonSlurper = new JsonSlurper() 
 def resultJson = jsonSlurper.parseText(request)
 def repoName = resultJson.bitbucketname
  Date date = new Date() 
  sh " echo '${date}' '${repoName}' repository ${message} in Bitbucket>>log.txt"
 if(${message}=="Listed")
  sh " echo '${date}' '${repoName}' repository is ${message} in Bitbucket>>log.txt"
}
