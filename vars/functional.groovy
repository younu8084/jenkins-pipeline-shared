def call(String msg = 'performance_test') {
echo "${msg}"
 
      blazeMeterTest credentialsId: 'NEWONE', getJtl: true, getJunit: true, testId: '7425961.functionalGui', workspaceId: '390025'
    
    }
