import groovy.json.*

def call(jsondata,bitbucket,bamboo,gitlab){
def jsonString = jsondata
def jsonObj = readJSON text: jsonString
int ecount = jsonObj.config.emails.email.size()
List<String> jsonStringa= new ArrayList<String>();
  jsonStringa.add(bitbucket)
   jsonStringa.add(bamboo)
   jsonStringa.add(gitlab)
  //println(jsonStringa)
/*def jsonStringa = bitbucket
def jsonObja = readJSON text: jsonStringa
  
def jsonStringb = bamboo
def jsonObjb = readJSON text: jsonStringb*/
 // int[] score1= new int[100]
 List<String> JSON = new ArrayList<String>();
  List<String> LIST = new ArrayList<String>();
  List<String> JSON1 = new ArrayList<String>();
/*for(i=0;i<jsonStringa.size();i++)
  { 
    int score=0
    String name="  "
if(jsonStringa[i].contains("bitbucket"))
    {
      name="Bitbucket"
//def jsonStringa = bitbucket
def jsonObja = readJSON text: jsonStringa[i]
int total=jsonObja.bitbucket.Commit_count
 // println(jsonObja)
  //println(total)
 
  if(total>5)
  {
    score=score+10
  }
  }
   if(jsonStringa[i].contains("Bamboo"))
    {
      name="Bamboo"
    //  def jsonStringb = bamboo
def jsonObjb = readJSON text: jsonStringa[i]
  //println(jsonObj)
  def scnt =jsonObjb.Bamboo.teamsuccessbuild_cnt
      
 // def res=bamboo1.bamboo.teamsuccessbuild_cnt
 // def obj = JSON.parse(bamboo1)
 //println(cnt)
 
 if(cnt>10)
  {
   score=score+10 
  }
    }
    
   if(jsonStringa[i].contains("gitlab"))
      {
        name="Gitlab"
        def jsonObjc= readJSON text: jsonStringa[i]
  //println(jsonObj)
  def cnt =jsonObjc.gitlab.commit_cnt
   // println(cnt)
   if(cnt>5)
  {
    score=score+10
  }
      }
    score1[i]=score
    //println(score)
   JSON.add(["TeamName":"riglet_info","Tool":name,"Score":score])  
  }
def jsonBuilder = new groovy.json.JsonBuilder()

jsonBuilder(
  "Teamdetails" : JSON
  
) 
  
  File file = new File("/var/lib/jenkins/workspace/${JOB_NAME}/Teamscore.json")
file.write(jsonBuilder.toPrettyString())	*/
  
  for(i=0;i<jsonStringa.size();i++)
  { 
    int score=0
    String name="  "
if(jsonStringa[i].contains("bitbucket"))
    {
      name="Bitbucket"
//def jsonStringa = bitbucket
def jsonObja = readJSON text: jsonStringa[i]
int total=jsonObja.bitbucket.Commit_count
 // println(jsonObja)
  //println(total)
 
  if(total>5)
  {
    score=score+10
  }
  }
   if(jsonStringa[i].contains("Bamboo"))
    { for(j=0;j<ecount;j++)
   {
	 def email=jsonObj.config.emails.email[j] 
	   
	    
     // name="Bamboo"
    //  def jsonStringb = bamboo
def jsonObjb = readJSON text: jsonStringa[i]
  //println(jsonObj)
  def scnt =jsonObjb.Bamboo.individualsuccess[j].Success_cnt
  def fcnt =jsonObjb.Bamboo.individualfailure[j].Failure_cnt
 def email1=jsonObjb.bamboo.individualsuccess[j].email
      
 // def res=bamboo1.bamboo.teamsuccessbuild_cnt
 // def obj = JSON.parse(bamboo1)
 //println(cnt)
 
 if(email==email1 && scnt>10)
  {
   score=score+10 
    LIST.add(["metric":"No of more successful builds","score":score])
    score=0
  }
     if(email==email1 && fcnt<2)
  {
   score=score+10 
    LIST.add(["metric":"No of least failure builds","score":score])
    score=0
  }
    }
     JSON1[j]=LIST.clone()
   JSON.add(["email":email,"metrics":JSON1[j]])
    LIST.clear()
    }
    
   if(jsonStringa[i].contains("gitlab"))
      {
        name="Gitlab"
        def jsonObjc= readJSON text: jsonStringa[i]
  //println(jsonObj)
  def cnt =jsonObjc.gitlab.commit_cnt
   // println(cnt)
   if(cnt>5)
  {
    score=score+10
  }
      }
    //score1[i]=score
    //println(score
    
  }
     //JSON1[j]=LIST.clone()
   //JSON.add(["email":email,"metrics":JSON1[j]])
   // LIST.clear()
   }
  println(JSON)
}

