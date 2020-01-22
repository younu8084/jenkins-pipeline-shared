def call(){
   sh ' curl -X POST -H "Content-Type: application/json" -d '{
      "scm": "git",
         "project": {
            "key": "TAS"
         }
   }' https://bitbucket.org/account/user/megalai1/projects/TAS
}
      

