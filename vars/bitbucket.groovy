def call(){

sh 'curl -X POST --user Megalai:Mumani1209@98 "https://api.bitbucket.org/2.0/repositories/Megalai/repo2" -d {"name":"repo2"}'
sh 'curl -X POST --user Megalai:Mumani1209@98 "https://api.bitbucket.org/2.0/repositories/Megalai/repo2/src" -F "branch=dev"'
}

      

