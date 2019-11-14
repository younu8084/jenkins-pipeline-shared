def call(String msg = 'deploy_ansible') {
echo "${msg}"
blazeMeterTest abortJob: true, 
           credentialsId: 'blazemetre', 
           getJtl: true, 
           getJunit: true, 
           testId: '7425390.taurus', 
           workspaceId: '390580'
           }
