import groovy.json.*
import groovy.json.JsonOutput
def call(jsondata,bamboo,bitbucket)
{
def jsonString = jsondata
def jsonObj = readJSON text: jsonString
int ecount = jsonObj.config.emails.email.size()
List<String> jsonStringa= new ArrayList<String>();
  jsonStringa.add(bitbucket)
   jsonStringa.add(bamboo)
   //jsonStringa.add(gitlab)
 
 List<String> JSON = new ArrayList<String>();
  List<String> LIST = new ArrayList<String>();
  List<String> JSON1 = new ArrayList<String>();

  for(j=0;j<jsonStringa.size();j++)
   {
	 def email=jsonObj.config.emails.email[j] 
	
	 if(jsonStringa[j].contains("Bamboo"))
    {   
     // name="Bamboo"
    //  def jsonStringb = bamboo
def jsonObjb = readJSON text: jsonStringa[j]
for(i=0;i<ecount;i++)
	   {
  //println(jsonObj)
  def scnt =jsonObjb.Bamboo.individualsuccess[i].Success_cnt
  def fcnt =jsonObjb.Bamboo.individualfailure[i].Failure_cnt
 def email1=jsonObjb.Bamboo.individualsuccess[i].email
      
 // def res=bamboo1.bamboo.teamsuccessbuild_cnt
 // def obj = JSON.parse(bamboo1)
 println(scnt)
 int score=0
	   int reward=0
 if(email==email1 && scnt>1)
  {
   score=score+10 
    LIST.add(["metric":"No of more successful builds","score":score])
	reward=reward+score  
    score=0
  }
     if(email==email1 && fcnt<2 && scnt!=0)
  {
   score=score+10 
    LIST.add(["metric":"No of least failure builds","score":score])
	  reward=reward+score 
    score=0
  }}
	   }
  if(jsonStringa[j].contains("bitbucket"))
    {
    def jsonObja = readJSON text: jsonStringa[j]
 int total=jsonObja.bitbucket.Commit_count
	    for(i=0;i<total;i++)
	    {
int total1=jsonObja.bitbucket.Individual_commits[i].Commit_count
def email1=jsonObja.bitbucket.Individual_commits[i].Email
    int score=0
	   int reward=0
 if(email==email1 && total1>2)
  {
   score=score+10 
    LIST.add(["metric":"Commits Score","score":score])
	reward=reward+score  
    score=0
  }
	    }
    }
	   JSON1=LIST.clone()
	   
   JSON.add(["email":email,"reward": reward,"metrics":JSON1])
    LIST.clear()
    }
     
    
  println(JSON)
}
