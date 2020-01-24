import jenkins.model.*
 jenkins = Jenkins.instance
 
def  call(String name ="name1")
{
 
 sh ".... ${bitbucketRepoName}.git ...."
      
sh 'curl -X POST -v --user Megalai:admin123 -H "ContentType: application/json; charset=UTF-8" "https://api.bitbucket.org/2.0/repositories/Megalai/name1" -d {"name":"name1"}'
}

      

