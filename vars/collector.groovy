import groovy.json.JsonSlurper 

@NonCPS
listRepo(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def repoName = resultJson.name
def projUrl = resultJson.url
//def projUrl = resultJson.url
   httpRequest authentication: 'bitbucket', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'GET', requestBody: """
{
}""", responseHandle: 'NONE', url: "${projUrl}"
response=$(curl -G &{projUrl})
echo $response
}
def call(){
def request = libraryResource 'datacollector.json'
listRepo(request)
}
