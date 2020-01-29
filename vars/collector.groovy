import groovy.json.JsonSlurper 

@NonCPS
listRepo(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def repoName = resultJson.name
def projUrl = resultJson.url
//def projUrl = resultJson.url
    sh 'curl -v -G '${projUrl}''
}
def call(){
def request = libraryResource 'datacollector.json'
listRepo(request)
}
