import jenkins.model.*
 jenkins = Jenkins.instance
def call(String name ="name",String pwd ="pwd",string repo="repon"){

      sh 'curl -X POST -v --user "${name}":admin123 -H "ContentType: application/json; charset=UTF-8" "https://api.bitbucket.org/2.0/repositories/Megalai/repo7" -d {"name":"repo7"}'

}

      

