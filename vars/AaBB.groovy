
import groovy.json.*
import java.util.*
import java.util.Date.*
@NonCPS
create(){
  def jsonSlurper = new JsonSlurper()
  def resultJson = jsonSlurper.parse(new File("/var/lib/jenkins/workspace/${JOB_NAME}/ouput.json"))
 // def String="timestamp"
def total = resultJson.size
  echo "$total"
def value=resultJson.values.author[0].name
  echo "$value"
 // Date date = new Date() 
 // echo "$date"
  def Timestamp = resultJson.values.committerTimestamp[0]
  Date date= new Date(Timestamp);  
  echo "$date"
  def count=0
  //
 for(i=0;i<total;i++)
 {
   //if(resultJson.values.committerTimestamp[i]==1582522990000)
   if (resultJson.values.committerTimestamp[i]==date)
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

