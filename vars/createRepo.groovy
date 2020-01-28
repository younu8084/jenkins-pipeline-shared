import groovy.json.JsonSlurper 

@NonCPS
createRepo(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def repoName = '"'+resultJson.name+'"'
//def projUrl = resultJson.url
  
 httpRequest authentication: 'bitbucket', 
    customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json'], 
                    [maskValue: false, name: 'Accept', value: 'application/json']], 
    httpMode: 'POST', requestBody: """{
    
    "name": ${repoName},
    
}""", responseHandle: 'NONE', url: 'https://api.bitbucket.org/2.0/repositories/Megalai/Proj'
}
def call(){
def request = libraryResource 'data.json'
 createRepo(request)
}
