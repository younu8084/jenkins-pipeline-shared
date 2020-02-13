import groovy.json.*

@NonCPS
def jsonSlurper = new JsonSlurper()
def call(){
def pushToInflux(totalIssues)
{
 sh """curl -i -w '%{http_code}' -XPOST 'http://3.16.33.107:9000/api/measures/component?metricKeys=vulnerabilities&component=comrades.bmi%3ABMI'  --header 'Authorization: Basic YWRtaW46YWRtaW4= ' >test.txt"""

 def response =new File('/var/lib/jenkins/workspace/sonarnew/test.txt').text


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
}
