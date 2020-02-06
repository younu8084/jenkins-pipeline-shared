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
  
  
  def link1 = "git config --global user.name "rig" && rm -rf ./* && git clone ${gitUrl} && git clone http://{rig}:{rigaDapt@devOps}@18.224.68.30:7990/scm/BIT/newrepo3.git && cp -r ./TestProject/* ./app && pwd && cd app && pwd && git init && git add --all && git status && git commit -m 'commit' && git remote add origin http://18.224.68.30:7990/scm/bit/newrepo3.git && git push -u origin master"
   
  
   sh(link1)
   
    
  }

         
 def call(){
 def request = libraryResource 'data.json'   
 codePush(request)
 }               
