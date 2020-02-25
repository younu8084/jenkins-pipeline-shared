import groovy.json.*

def call(jsondata){
def jsonString = jsondata
def jsonObj = readJSON text: jsonString
String a=jsonObj.scm.projects.project.repositories.repository.repo_name
String repoName=a.replaceAll("\\[", "").replaceAll("\\]","");
String b=jsonObj.scm.projects.project.project_key 
String Key=b.replaceAll("\\[", "").replaceAll("\\]","");
int ecount = jsonObj.config.emails.email.size()
println("No of users "+ ecount)
println(Key)
println(repoName)
 Date date = new Date() 
 withCredentials([usernamePassword(credentialsId: 'bitbucket_cred', passwordVariable: 'pass', usernameVariable: 'userId')]) {
  sh "curl -X GET  -H -d  -u $userId:$pass http://18.224.68.30:7990/rest/api/1.0/projects/'${Key}'/repos/'${repoName}'/commits -o output.json"
 } 
def jsonSlurper = new JsonSlurper()
def resultJson = jsonSlurper.parse(new File("/var/lib/jenkins/workspace/${JOB_NAME}/output.json"))
def total = resultJson.size
 echo "Total no.of commits in ${repoName} $total"
 jq -c '.[]' output.json | while read i; do

		time=`echo $i | jq '.committerTimestamp'`

		data_date=$(date -d @`expr $time / 1000` +%Y-%m-%d)

		data_date=\"$data_date\"

		name=`echo $i | jq '.committer.name'`

		email=`echo $i | jq '.committer.emailAddress'`

		dateArr=$dateArr$data_date,
		echo $dateArr > dateData

		echo "{\"commitDate\":$data_date,\"contributorsName\":"$name",\"contributorsEmail\":"$email"}," >> bitAllDataDb.json
 }


