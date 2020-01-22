def call(){

sh 'curl -k -X POST --user user:pass "https://api.bitbucket.org/2.0/repositories/mani123_" -d "name=project_name"'
}

      

