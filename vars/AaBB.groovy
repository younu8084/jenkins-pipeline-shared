import groovy.json.*

def call(jsondata){
def jsonString = jsondata
def jsonObj = readJSON text: jsonString

 sh""" 
 curl -X GET  -H -d  -u rig:rigaDapt@devOps "http://18.224.68.30:7990/rest/api/1.0/projects/EDN/repos/rig/commits -o output.json"  
    """
	
//def total = resultJson.size
  //echo "$total"
//def value=resultJson.values.author[0].name
 // echo "$value"
	def jsonSlurper = new JsonSlurper()
def resultJson = jsonSlurper.parse(new File("/var/lib/jenkins/workspace/${JOB_NAME}/output.json"))

 def time=resultJson.values[0].committerTimestamp
   def name=resultJson.values.committer[0].name
    def email=resultJson.values.committer[0].emailAddress
		//dateArr=$dateArr$data_date,
   Date date = new Date(time) 

//echo $dateArr > dateData
echo "{\"commitDate\":$date,\"contributorsName\":"$name",\"contributorsEmail\":"$email"}," >> bitAllDataDb.json

	//def count=0
  //
/* for(i=0;i<total;i++)
 {
   //if(resultJson.values.committerTimestamp[i]==1582522990000)
   if (resultJson.values.committerTimestamp[i]==date)
   {
    count ++
   }
 }
  echo "$count"*/
 }

