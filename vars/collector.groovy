import groovy.json.JsonSlurper 

@NonCPS
collector(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def projUrl = resultJson.url
  sh 'curl -v -G '${projUrl}''
}
def call(){
def response = libraryResource 'datacollector.json'
collector(response)
}
