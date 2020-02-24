
import groovy.json.*
import java.util.*
import java.sql.Timestamp.*   
import java.util.Date.*
@NonCPS
create(){
  def jsonSlurper = new JsonSlurper()
  def resultJson = jsonSlurper.parse(new File("/var/lib/jenkins/workspace/${JOB_NAME}/output.json"))
 // def String="timestamp"
def total = resultJson.size
  echo "$total"
def value=resultJson.values.author[0].name
  echo "$value"
 // Date date = new Date() 
 // echo "$date"
 def Timestamp =new Timestamp(System.currentTimeMillis());  
  Date date=new Date(Timestamp.getTime());  
  echo "$date"
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

