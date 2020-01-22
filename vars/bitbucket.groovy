def call(){
   sh 'curl -X POST -v -user Megalai:Mumani1209@98 "https://api.bitbucket.org/2.0/repositories/Megalai/repo1" -d -d '{"has_wiki": true, "is_private": true, "project": {"key": "PRJ_KEY"}}''
}


      

