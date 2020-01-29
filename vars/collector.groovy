import groovy.json.JsonSlurper 

@NonCPS
listRepo(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def projUrl = resultJson.url
//def projUrl = resultJson.url
response=$(curl -G {projUrl})
echo $response
}
def call(){
def request = libraryResource 'datacollector.json'
listRepo(request)
}
