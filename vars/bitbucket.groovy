def call(){

sh 'curl -k -X POST --user user:pass "https://api.bitbucket.org/2.0/repositories/Megalai/repo1" -d "name=project_name"'
}

      

