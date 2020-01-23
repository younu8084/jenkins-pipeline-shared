
def call(){

      sh 'curl -X POST -v --user Megalai:admin123 -H "ContentType: application/json; charset=UTF-8" "https://api.bitbucket.org/2.0/repositories/Megalai/repo8" -d {"name":"repo8"}'

}

      

