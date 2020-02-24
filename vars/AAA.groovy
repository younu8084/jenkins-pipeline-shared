import groovy.json.*
import java.lang.Long
import java.lang.Math

@NonCPS
create(){
  def jsonSlurper = new JsonSlurper()
  def resultJson = jsonSlurper.parse(new File("/var/lib/jenkins/workspace/${JOB_NAME}/output.json"))
def total = resultJson.size
  echo "$total"
//def value=resultJson.values.author[0].name
  //echo "$value"

  
  
 Long date= System.currentTimeMillis() 
 // echo "$date"
  
  
  def count=0
  //
 
 for(i=0;i<total;i++)
 {
    Long timer=resultJson.values.committerTimestamp[i]
   //echo "$timer"
   Long sub=Math.subtractExact(date,timer)
  echo "$sub"
   //if(resultJson.values.committerTimestamp[i]==1582522990000)
   if (resultJson.values.author[i].name=="rig" && sub<86400000)
   {
    count ++
   
   }
 }
 echo "$count" 
 
}
def call()
{
create()
}
