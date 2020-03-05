import groovy.json.*

def call(jsondata,bitbucket,bamboo){
def jsonString = jsondata
def jsonObj = readJSON text: jsonString
int ecount = jsonObj.config.emails.email.size()
List<String> jsonStringa= new ArrayList<String>();
  jsonStringa.add(bitbucket)
   jsonStringa.add(bamboo)
  println(jsonStringa)
/*def jsonStringa = bitbucket
def jsonObja = readJSON text: jsonStringa
  
def jsonStringb = bamboo
def jsonObjb = readJSON text: jsonStringb*/
 
for(i=0;i<jsonStringa.size();i++)
  { 
if(jsonStringa[i]==bitbucket)
    {
//def jsonStringa = bitbucket
def jsonObja = readJSON text: jsonStringa
int total=jsonObja.bitbucket.Commit_count
 // println(jsonObja)
  //println(total)
  int score=1
  if(total>5)
  {
    score=score*10
  }
  }
   if(jsonStringa[i]==bamboo)
    {
    //  def jsonStringb = bamboo
def jsonObjb = readJSON text: jsonStringa
  //println(jsonObj)
  def cnt =jsonObj.Bamboo.teamsuccessbuild_cnt
 // def res=bamboo1.bamboo.teamsuccessbuild_cnt
 // def obj = JSON.parse(bamboo1)
 println(cnt)
 def score=1
 if(cnt>10)
  {
   score=1*10 
  }
    }
  }
  println(score)
}
