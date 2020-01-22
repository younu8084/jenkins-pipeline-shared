def call(){

sh 'curl -k -X POST --user user:pass "https://api.bitbucket.org/2.0/repositories/Megalai" -d "name=project_name"'
}

      

