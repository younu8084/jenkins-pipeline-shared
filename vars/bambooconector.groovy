def call()
{
 sh 'curl -X POST --user un:pwd "http://18.220.143.53:8085/rest/api/latest/queue/BAM-WEEK?executeAllStages=true"'
}
