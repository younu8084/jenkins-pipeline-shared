def call(){

sh 'curl -X POST authentication: '$BITBUCKET_COMMON_CREDS', contentType: 'APPLICATION_JSON', "https://api.bitbucket.org/2.0/repositories/Megalai/epo3" -d {"name":"epo3"}'

}

      

