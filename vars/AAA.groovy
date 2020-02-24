import groovy.json.*

@NonCPS
create(){
  def jsonSlurper = new JsonSlurper()
  def resultJson = jsonSlurper.parse(new File("/var/lib/jenkins/workspace/${JOB_NAME}/output.json"))
def total = resultJson.size
  echo "$total"
  echo "resultJson.author[0].name[0]"
 for(i=0;i<=total;i++)
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
