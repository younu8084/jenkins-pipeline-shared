def call()
{
if (manager.currentBuild.logContains('HTTP/1.1 200 OK')) {
          echo "new repo created"  
}
}
