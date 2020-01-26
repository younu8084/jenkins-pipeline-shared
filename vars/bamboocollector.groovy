def call()
{
 sh 'curl -X GET --user un:pwd "http://18.220.143.53:8085/rest/api/latest/plan.json"'
 sh 'curl -X GET --user un:pwd "http://18.220.143.53:8085/rest/api/latest/currentUser.json"'
}
