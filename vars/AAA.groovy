import groovy.json.*

@NonCPS
create(){
  def jsonSlurper = new JsonSlurper()
  def resultJson = jsonSlurper.parse(new File("/var/lib/jenkins/workspace/${JOB_NAME}/output.json"))
def total = resultJson.size
  echo "$total"
def value=resultJson.values.author[0].name
  echo "$value"
def timer=resultJson.values.committerTimestamp[0]
  echo "$timer"
  LocalDate date = Instant.ofEpochMilli(Long.parseLong(timer))
            .atOffset(ZoneOffset.UTC)
            .toLocalDate();
  
  echo "$date"
  
  def count=0
  //Date date = new Date() 
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
