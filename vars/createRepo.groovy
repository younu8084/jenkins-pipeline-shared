import groovy.json.JsonSlurper 

@NonCPS
createRepo(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def repoName = '"'+resultJson.name+'"'
//def projUrl = resultJson.url
 sh 'curl -X POST -v --user Megalai:admin123 -H "ContentType: application/json; charset=UTF-8" "https://api.bitbucket.org/2.0/repositories/Megalai/${repoName}" '
}
def call(){
def request = libraryResource 'data.json'
 createRepo(request)
}
