import groovy.json.JsonSlurper 

@NonCPS
createRepo(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)

def projkey = resultJson.bitbucketkey
//def projUrl = resultJson.url
httpRequest authentication: 'bitbucket', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'GET', requestBody: """
{
}""", responseHandle: 'NONE', url: "http://18.224.68.30:7990//rest/api/1.0/projects/${projkey}/repos"

}
def call(){
def request = libraryResource 'data.json'
createRepo(request)
