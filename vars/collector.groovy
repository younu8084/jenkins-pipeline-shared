import groovy.json.JsonSlurper 

@NonCPS
createRepo(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
//def projUrl = resultJson.url
httpRequest authentication: 'bitbucket', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'GET', requestBody: """
{
    "scmId": "git",
    "forkable": true
}""", responseHandle: 'NONE', url: "${projUrl}"
}
def call(){
def request = libraryResource 'datacollector.json'
collector(request)
}
