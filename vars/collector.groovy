import groovy.json.JsonSlurper 

@NonCPS
createRepo(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def projUrl = resultJson.bitbucketurl
//def projUrl = resultJson.url
httpRequest authentication: 'bitbucket', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'GET', requestBody: """
{
}""", responseHandle: 'NONE', url: "${projUrl}"
}
def call(){
def request = libraryResource 'data.json'
createRepo(request)
}
