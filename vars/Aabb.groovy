import groovy.json.*
def call()
{
  sh "curl -X GET -s -u rig:rigaDapt@devOps http://18.224.68.30:7990/rest/api/1.0/projects/EDN/repos/demo12/commits -o ouput.json"
  def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/ouput.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
  def size = resultJson.size()
  for(i=0;i<size;i++){
def uname=resultJson.values[i].author.name
  println(uname)
def commit=resultJson.values[i].commits
println(commit)
  }
  //ef val=arr  { reg
  //println(val)
}
