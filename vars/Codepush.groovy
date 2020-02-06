 
import jenkins.model.*
import hudson.model.*
import groovy.json.JsonSlurper 
jenkins = Jenkins.instance
import hudson.plugin.git.extension.impl.*
  
  @NonCPS
  codePush(String data){
    def jsonSlurper = new JsonSlurper() 
    def resultJson = jsonSlurper.parseText(data)
   
    def gitUrl= resultJson.url
    
    echo gitUrl
  
  
  def link1 = "rm -rf ./* && git clone https://github.com/kavi1997/TestProject.git && git clone http://bitbucket_cred@18.224.68.30:7990/scm/EDN/Rig.git && cp -r ./TestProject/* ./app && pwd && cd app && pwd && git init && git add --all && git status && git commit -m 'commit' && git remote add origin http://rig:rigaDapt%40devOps@18.224.68.30:7990/scm/EDN/Rig.git && git push -u origin master"
   
  
   sh(link1)
   
    
  }

         
 def call(){
 def request = libraryResource 'data.json'   
 codePush(request)
 }               
