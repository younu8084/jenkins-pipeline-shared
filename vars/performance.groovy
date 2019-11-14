def call(String msg = 'performance_test') {
echo "${msg}"
blazeMeterTest abortJob: true, 
           credentialsId: 'blazemetre', 
           getJtl: true, 
           getJunit: true, 
           testId: '7425390.taurus', 
           workspaceId: '390580'
           }
