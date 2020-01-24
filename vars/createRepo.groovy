import groovy.json.JsonSlurper 

@NonCPS
createRepo(String data, String URL){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def repoName = '"'+resultJson.name+'"'
def projUrl = resultJson.url
  
  println repoName
  println """
{
    "name": ${repoName},
    "scmId": "git",
    "forkable": true
}"""
  
  httpRequest authentication: 'bitbucket', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'POST', requestBody: """
{
    "name": ${repoName},
    "scmId": "git",
    "forkable": true
}""", responseHandle: 'NONE', url:'https://api.bitbucket.org/2.0/repositories/Megalai/Proj'
}


def call(){
def request = libraryResource 'data.json'
 createRepo(request)
}
