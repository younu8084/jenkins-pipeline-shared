def call(){
   sh 'curl -X POST -v -user Megalai:Mumani1209@98 "https://api.bitbucket.org/2.0/repositories/Megalai1/repo1" -d "scm=git", "is_private=true", "fork_policy=no_public_forks"'
}

