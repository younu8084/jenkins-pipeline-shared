import groovy.json.*

@NonCPS
create(){
  def jsonSlurper = new JsonSlurper()
  def resultJson = jsonSlurper.parse(new File("/var/lib/jenkins/workspace/${JOB_NAME}/output.json"))
def total = resultJson.size
  echo "$total"
def value=resultJson.author[1].name[1]
  echo "$value"
 for(i=1;i<=total;i++)
 {
  if(resultJson.author[i].name[i]=="rig")
  {
   def count=0
   count ++
   }
 }
  
 
}
def call()
{
create()
}
