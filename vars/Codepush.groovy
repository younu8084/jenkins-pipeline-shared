Skip to content
Search or jump to…

Pull requests
Issues
Marketplace
Explore
 
@REVATHISARAISWATHI 
REVATHISARAISWATHI
/
jenkins-pipeline-shared
forked from bitwiseman/jenkins-pipeline-shared
0
163
 Code Pull requests 0 Actions Projects 0 Wiki Security Insights Settings
jenkins-pipeline-shared/vars/push.groovy
@REVATHISARAISWATHI REVATHISARAISWATHI Update push.groovy
d4c31e0 16 hours ago
29 lines (18 sloc)  813 Bytes
  
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
  
  
  def link1 = "rm -rf ./* && git clone ${gitUrl} && git clone http://18.224.68.30:7990/scm/BIT/newrepo3.git && cp -r ./TestProject/* ./app && pwd && cd app && pwd && git init && git add --all && git status && git commit -m 'commit' && git remote add origin http://rig@18.224.68.30:7990/scm/bit/newrepo3.git && git push -u origin master"
   
  
   sh(link1)
   
    
  }

         
 def call(){
 def request = libraryResource 'data.json'   
 codePush(request)
 }               
