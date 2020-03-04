import groovy.json.*

def call(jsondata,bitbucket){
def jsonString = jsondata
def jsonObj = readJSON text: jsonString
int ecount = jsonObj.config.emails.email.size()
def jsonStringa = bitbucket
def jsonObja = readJSON text: jsonStringa
println(jsonObja)
}
