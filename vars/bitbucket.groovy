import jenkins.model.*
def call(String name ="name"){

      sh 'curl -X POST -v --user Megalai:admin123 -H "ContentType: application/json; charset=UTF-8" "${name}" -d {"name":"repo8"}'

}

      

