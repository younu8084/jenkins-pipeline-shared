import groovy.json.JsonSlurper 
def call(){
sh 'curl -X -GET --user rig:rigaDapt@devOps  "http://18.224.68.30:7990/rest/api/1.0/projects/BIT/repos"'

}
