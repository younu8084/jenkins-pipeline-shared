import groovy.json.JsonSlurper 

@NonCPS
collector(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def projUrl = resultJson.url
sh 'curl -v -G https://api.bitbucket.org/2.0/repositories/Megalai'
}
def call(){
def response = libraryResource 'datacollector.json'
collector(response)
}
