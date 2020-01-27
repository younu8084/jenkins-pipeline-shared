def call(){
  sh 'curl -X GET -v -u un:pwd -H "ContentType: application/json; charset=UTF-8" "http://3.15.18.214:8081/nexus/service/local/repositories" '
}
