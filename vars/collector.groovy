import groovy.json.JsonSlurper 

@NonCPS
listRepo(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def repoName = resultJson.name
def projUrl = resultJson.url
//def projUrl = resultJson.url
 sh'response=$(curl -G "https://api.bitbucket.org/2.0/repositories/Megalai/$repoName")
echo $response'
}
def call(){
def request = libraryResource 'datacollector.json'
listRepo(request)
}
