import groovy.json.JsonSlurper 

@NonCPS
createRepo(String data, String URL){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def repoName = '"'+resultJson.repositoryName+'"'
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
}""", responseHandle: 'NONE', url: "${URL}"
}


def call(String request,String BITBUCKETURL){

 createRepo(request,BITBUCKETURL)
}
