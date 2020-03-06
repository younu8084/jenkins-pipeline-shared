import groovy.json.*

def call(jsondata,bitbucket,bamboo,gitlab){
def jsonString = jsondata
def jsonObj = readJSON text: jsonString
int ecount = jsonObj.config.emails.email.size()
	def team=jsonObj.riglet_info.name
List<String> jsonStringa= new ArrayList<String>();
  jsonStringa.add(bitbucket)
   jsonStringa.add(bamboo)
   jsonStringa.add(gitlab)
  //println(jsonStringa)
/*def jsonStringa = bitbucket
def jsonObja = readJSON text: jsonStringa
  
def jsonStringb = bamboo
def jsonObjb = readJSON text: jsonStringb*/
 int[] score1= new int[100]
 List<String> JSON = new ArrayList<String>();
  List<String> LIST = new ArrayList<String>();
  List<String> JSON1 = new ArrayList<String>();
for(i=0;i<jsonStringa.size();i++)
  { 
    int score=0
    String name="  "
	  String metric=" "
if(jsonStringa[i].contains("bitbucket"))
    {
      name="bitbucket"
	    metric="commits"
//def jsonStringa = bitbucket
def jsonObja = readJSON text: jsonStringa[i]
int total=jsonObja.bitbucket.Commit_count
 // println(jsonObja)
  //println(total)
 score=total
 /* if(total>5)
  {
    score=score+10
  }*/
  }
   if(jsonStringa[i].contains("Bamboo"))
    {
      name="bamboo"
	    metric="successful builds"
    //  def jsonStringb = bamboo
def jsonObjb = readJSON text: jsonStringa[i]
  //println(jsonObj)
  def scnt =jsonObjb.Bamboo.teamsuccessbuild_cnt
      
 // def res=bamboo1.bamboo.teamsuccessbuild_cnt
 // def obj = JSON.parse(bamboo1)
 //println(cnt)
 score=scnt
 /*if(cnt>10)
  {
   score=score+10 
  }*/
    }
    
   if(jsonStringa[i].contains("gitlab"))
      {
        name="gitlab"
	      metric="commits"
        def jsonObjc= readJSON text: jsonStringa[i]
  //println(jsonObj)
  def cnt =jsonObjc.gitlab.commit_cnt
   // println(cnt)
	      score=cnt
  /* if(cnt>5)
  {
    score=score+10
  }*/
      }
    score1[i]=score
    //println(score)
   JSON.add(["toolName":name,"metricName":metric,"value":score])  
  }
def jsonBuilder = new groovy.json.JsonBuilder()

jsonBuilder(
 "teamName":team,
  "metrics" : JSON
  
) 
  
  File file = new File("/var/lib/jenkins/workspace/${JOB_NAME}/Teamscore.json")
file.write(jsonBuilder.toPrettyString())	
  
 
  println(JSON)
}

