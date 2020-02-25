//#!/bin/sh

import groovy.json.*

@NonCPS
def create(){
  def jsonSlurper = new JsonSlurper()
  //def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/ouput.json"),"UTF-8"))
  
  def resultJson = jsonSlurper.parse(new File("/var/lib/jenkins/workspace/${JOB_NAME}/ouput.json"))
  
def BITBUCKET_USER="rig" 
def BITBUCKET_PASS="rigaDapt@devOps"
def bitbucket_url="http://18.224.68.30:7990"
  def bitbucket_project_name="EDN250"
  def bitbucket_repo_name="rig"
defiterate_flag=true
  def commits_start=0
	def String="scm_commits"
//def rigletName=sample riglet name
//	cd ..
//	mkdir -p -- "$rigletName"_bitbucket

  //while $iterate_flag; do

echo $BITBUCKET_USER:$BITBUCKET_PASS "$bitbucket_url/rest/api/1.0/projects/${bitbucket_project_name}/repos/${bitbucket_repo_name}/commits?limit=50&start=$commits_start"

    scm_commits=$(curl -X GET -k --fail -s --user $BITBUCKET_USER:$BITBUCKET_PASS "$bitbucket_url/rest/api/1.0/projects/${bitbucket_project_name}/repos/${bitbucket_repo_name}/commits?limit=50&start=$commits_start")
		
		echo $scm_commits | jq -r '.values' | sed '1d;$d' >> ${rigletName}_bitbucket/bitAllData.json

    isLastPage=$(echo $scm_commits | jq -r ".isLastPage")

  	if [ ! $isLastPage = false ];then
			iterate_flag=false
		else
			echo , >> ${rigletName}_bitbucket/bitAllData.json
			commits_start=`expr $commits_start + 50`
		
		fi

	done
data=$(cat ${rigletName}_bitbucket/bitAllData.json)

	echo [ >> ${rigletName}_bitbucket/bitAllDataResult.json

	cat ${rigletName}_bitbucket/bitAllData.json >> ${rigletName}_bitbucket/bitAllDataResult.json

	echo ] >> ${rigletName}_bitbucket/bitAllDataResult.json

	commitCount=0

	cd ${rigletName}_bitbucket

jq -c '.[]' bitAllDataResult.json | while read i; do

		time=`echo $i | jq '.committerTimestamp'`

		data_date=$(date -d @`expr $time / 1000` +%Y-%m-%d)

		data_date=\"$data_date\"

		name=`echo $i | jq '.committer.name'`

		email=`echo $i | jq '.committer.emailAddress'`

		dateArr=$dateArr$data_date,
		echo $dateArr > dateData

		echo "{\"commitDate\":$data_date,\"contributorsName\":"$name",\"contributorsEmail\":"$email"}," >> bitAllDataDb.json

  done
}
def call()
{
create()
}
