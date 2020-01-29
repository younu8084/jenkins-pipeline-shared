import groovy.json.JsonSlurper 

@NonCPS
collector(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def projUrl = resultJson.url
httpRequest authentication: 'bitbucket', contentType: 'APPLICATION_JSON', name: 'Content-Type', value: 'application/json', httpMode: 'GET', requestBody: """
{
}""", responseHandle: 'NONE', url: "${projUrl}"
}
def call(){
def response = libraryResource 'datacollector.json'
collector(response)
}
