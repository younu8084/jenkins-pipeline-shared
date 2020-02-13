
import groovy.json.*

@NonCPS
create(){
def jsonSlurper = new JsonSlurper()
 def resultJson = jsonSlurper.parse(new File("/var/lib/jenkins/workspace/${JOB_NAME}/output.json"))
 def total = resultJson.component.measures[0].value
pushToInflux(total);
}
def pushToInflux(value)
{
 sh """curl -i -w '%{http_code}' -XPOST 'http://ec2-13-58-47-71.us-east-2.compute.amazonaws.com:8086/write?db=Collector' --data-binary 'sonar vulnerabilities=${value}' >test.txt"""

 def response =new File('/var/lib/jenkins/workspace/' + JOB_NAME+ '/test.txt').text
def value = resultJson.component.measures[0].value
 echo " ============ $response"

if(response == "204" || response == "200")
{
 echo " Data pushed into influxDB "
}
else
{
 error("Error while pushing")
}
}
def call()
{
 create()
}
