import groovy.json.JsonSlurper 

@NonCPS
listRepo(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def repoName = resultJson.name
def projUrl = resultJson.url
//def projUrl = resultJson.url
   response=$(curl -X GET "${projUrl}")
echo $response
}
def call(){
def request = libraryResource 'datacollector.json'
listRepo(request)
}
