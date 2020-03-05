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
  int[] score1= new int[100]
 
for(i=0;i<jsonStringa.size();i++)
  { 
    int score=0
if(jsonStringa[i].contains("bitbucket"))
    {
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
    //  def jsonStringb = bamboo
def jsonObjb = readJSON text: jsonStringa[i]
  //println(jsonObj)
  def cnt =jsonObjb.Bamboo.teamsuccessbuild_cnt
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
    println(score)
  }
  
}
