import jenkins.model.*
def call(String name ="name"){

      sh 'curl -X POST -v --user ${name}:admin123 -H "ContentType: application/json; charset=UTF-8" "https://api.bitbucket.org/2.0/repositories/Megalai/repo8" -d {"name":"repo8"}'

}

      

