import groovy.json.JsonSlurper 

@NonCPS
createRepo(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def repoName = resultJson.bitbucketname
//def projUrl = resultJson.bitbucketurl
//def projUrl = resultJson.url
httpRequest authentication: 'bitbucket_cred', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'POST', requestBody: """
{
    "name": "${repoName}",
    "scmId": "git",
    "forkable": true
}""", responseHandle: 'NONE', url:"http://18.224.68.30:7990//rest/api/1.0/projects/BIT/repos"
  
  }


def call(){
def request = libraryResource 'data.json'
createRepo(request)




}
