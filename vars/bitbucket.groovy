def call(){

sh 'curl -X POST -v -u Megalai:Mumani1209@98 -H "Content-Type: application/json" \
  https://api.bitbucket.org/2.0/repositories/Megalai/new-repository4 \
  -d '{"scm": "git", "is_private": "true", "fork_policy": "no_public_forks", "project": {"key": "DEM"} }''
}

      

