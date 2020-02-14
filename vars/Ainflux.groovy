
import groovy.json.*

@NonCPS
def create(){
  def jsonSlurper = new JsonSlurper()
  //def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/ouput.json"),"UTF-8"))
  
  def resultJson = jsonSlurper.parse(new File("/var/lib/jenkins/workspace/${JOB_NAME}/ouput.json"))
  
  def value = resultJson.component.measures[0].value
  echo "=============================Total $value"
  pushToInflux(value);
  

 }


def pushToInflux(value) {
  
  sh """
    curl -w '%{http_code}' -s -i  -X POST \
      'http://ec2-13-58-47-71.us-east-2.compute.amazonaws.com:8086/write?db=Collector' \
      --data 'sonar vulnerabilities=${value}' > test2.txt
  """
 def response =new File('/var/lib/jenkins/workspace/' + JOB_NAME + '/test2.txt').txt
  echo "======================== $response" 
  
  if (response == "204" || response == "200") {
      echo "DATA PUSHED TO INFLUX DB"
     } else {
     
       error("ERROR PUSHING DATA TO INFLUX")
     }
}


def call()
{
 create()
}
