import groovy.json.*
import java.lang.Long
import java.lang.Math

@NonCPS
create(){
  def jsonSlurper = new JsonSlurper()
  def resultJson = jsonSlurper.parse(new File("/var/lib/jenkins/workspace/${JOB_NAME}/output.json"))
def total = resultJson.size
  echo "$total"
def value=resultJson.values.author[0].name
  echo "$value"
 String timer=resultJson.values.committerTimestamp[0]
  echo "$timer"
  
 Long date= System.currentTimeMillis() 
  echo "$date"
  
  Long sub=Math.subtractExact(date,timer)
  echo "$sub"
  def count=0
  //
 for(i=0;i<total;i++)
 {
   //if(resultJson.values.committerTimestamp[i]==1582522990000)
   if (resultJson.values.committerTimestamp[i]==date)
   {
    count ++
   echo "$count"
   }
 }
  
 
}
def call()
{
create()
}
