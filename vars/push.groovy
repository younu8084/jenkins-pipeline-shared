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
  
  
  def link1 = "rm -rf ./* && git clone ${gitUrl} && git clone http://rig:${rig_password}@${BB_URL}/scm/DEM/app.git && cp -r ./JenkinsWar/* ./app && pwd && cd app && pwd && git init && git add --all && git status && git commit -m 'commit' && git push -u origin master"
   
   echo "************** Aman Repo ************"
   
   sh(link1)
   
    
  }

         
 def call(){
 def request = libraryResource 'data.json'   
 codePush(request)
 }               
