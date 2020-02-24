
import groovy.json.*
import java.util.*
import java.sql.Timestamp.* 
import java.util.Date.*
@NonCPS
create(){
  def jsonSlurper = new JsonSlurper()
  def resultJson = jsonSlurper.parse(new File("/var/lib/jenkins/workspace/${JOB_NAME}/output12.json"))
 // def String="timestamp"
def total = resultJson.size
  echo "$total"
def value=resultJson.values.author[0].name
  echo "$value"
 // Date date = new Date() 
 // echo "$date"
 // Timestamp ts=new Timestamp(System.currentTimeMillis());  
  //Date date=ts;  
//  def Timestamp = resultJson.values.committerTimestamp[0]
 // Date date= new Date(Timestamp);  
  function convert(){

 // Unixtimestamp
 var unixtimestamp = document.getElementById('committerTimestamp').value;

 // Months array
 var months_arr = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];

 // Convert timestamp to milliseconds
 var date = new Date(unixtimestamp*1000);

 // Year
 var year = date.getFullYear();

 // Month
 var month = months_arr[date.getMonth()];

 // Day
 var day = date.getDate();

 // Hours
 var hours = date.getHours();

 // Minutes
 var minutes = "0" + date.getMinutes();

 // Seconds
 var seconds = "0" + date.getSeconds();

 // Display date time in MM-dd-yyyy h:m:s format
 var convdataTime = month+'-'+day+'-'+year+' '+hours + ':' + minutes.substr(-2) + ':' + seconds.substr(-2);
 
 document.getElementById('datetime').innerHTML = convdataTime;
 
}
  
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
  function convert()
}

