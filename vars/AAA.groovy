import groovy.json.*

@NonCPS
create(){
  def jsonSlurper = new JsonSlurper()
  def resultJson = jsonSlurper.parse(new File("/var/lib/jenkins/workspace/${JOB_NAME}/output.json"))
 def value = resultJson.values.size
 println(value)
 for(i=0;i<=value;i++)
 {
  if(resultJson.author.name=="rig")
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
