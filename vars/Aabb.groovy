import groovy.json.*

int totalbuilds;

def call()
{
sh 'curl -X GET  -H -d  -u rig:rigaDapt@devOps "http://18.224.68.30:7990/rest/api/1.0/projects/EDN/repos/demo12/commits" -o ouput.json' 
 def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/ouput.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
def nobuild=resultJson.imageMap
 // env.name = nobuild

println(nobuild)
  if(nobuild!=null)
  {
    def val = nobuild.split('title=\"')
   // println(val[1])
   //def val1=val[1]
     //println(val1)
     def vals = val[1].split(' ')
    def totalbuild=vals[3]
    println(totalbuild)
  // success(totalbuild);
    return totalbuild
  }
  else
  {
    
    echo "the no of build is 0" 
    return 0
  }
 
}

def success(totalbuilds)
{
   sh sh 'curl -X GET  -H -d  -u rig:rigaDapt@devOps "http://18.224.68.30:7990/rest/api/1.0/projects/EDN/repos/demo12/commits" -o ouput.json' 
    def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/ouput.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
    def nbuild=resultJson.imageMap
      def val2 = nbuild.split('title=\"')
     def builds = val2[1].split(' ')
    def Failbuild=builds[2]
    println(Failbuild)
  println(totalbuilds)
  //def var=totalbuilds
  def successbuild=totalbuilds.toInteger()-Failbuild.toInteger()
     println(successbuild)
}
