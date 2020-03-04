import groovy.json.*

def call(jsondata,bitbucket){
def jsonString = jsondata
def jsonObj = readJSON text: jsonString
int ecount = jsonObj.config.emails.email.size()
//List<String> jsonStringa= new ArrayList<String>();
  
def jsonStringa = bitbucket
def jsonObja = readJSON text: jsonStringa
int total=jsonObja.bitbucket.Commit_count
  println(jsonObja)
  println(total)
  int score=1
  if(total>5)
  {
    score=score*10
  }
  println(score)
}
