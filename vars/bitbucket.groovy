import jenkins.model.*
 jenkins = Jenkins.instance
 
def  call(String name = "bitbucketRepoName")
{     
sh 'curl -X POST -v --user Megalai:admin123 -H "ContentType: application/json; charset=UTF-8" "https://api.bitbucket.org/2.0/repositories/Megalai/${bitbucketRepoName}" -d {"name":"bitbucketRepoName"}'
}

      

