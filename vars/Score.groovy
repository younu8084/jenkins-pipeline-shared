import groovy.json.*

def call(bitbucket){
/*def jsonString = jsondata
def jsonObj = readJSON text: jsonString
int ecount = jsonObj.config.emails.email.size()*/
def jsonString = bitbucket
def jsonObj = readJSON text: jsonString
println(jsonObj)
}
