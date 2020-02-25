import groovy.json.*

def call(jsondata){
def jsonString = jsondata
def jsonObj = readJSON text: jsonString
	
	withCredentials([usernamePassword(credentialsId: 'bitbucket_cred', passwordVariable: 'pass', usernameVariable: 'userId')]) {
  sh "curl -X GET  -H -d  -u $userId:$pass http://18.224.68.30:7990/rest/api/1.0/projects/EDN/repos/rig/commits -o output.json"
 } 

 // def String="timestamp"
def total = resultJson.size
  echo "$total"
def value=resultJson.values.author[0].name
  echo "$value"
 // Date date = new Date() 
 //echo "$date"
 def time=resultJson.values[0].committerTimestamp
   //data_date=$(date -d @`expr $time / 1000` +%Y-%m-%d)
    //data_date=\"$data_date\"
   def name=resultJson.values.committer[0].name
		email=resultJson.values.committer[0].emailAddress
		//dateArr=$dateArr$data_date,
   Date date = new Date(time*1000L) 
   SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z")
   jdf.setTimeZone(TimeZone.getTimeZone("GMT-4"))
   String data_date = jdf.format(date)
   
		//echo $dateArr > dateData
		echo "{\"commitDate\":$data_date,\"contributorsName\":"$name",\"contributorsEmail\":"$email"}," >> bitAllDataDb.json

  def count=0
  //
 for(i=0;i<total;i++)
 {
   //if(resultJson.values.committerTimestamp[i]==1582522990000)
   if (resultJson.values.committerTimestamp[i]==convdataTime)
   {
    count ++
   }
 }
  echo "$count"
 }

