def call(){

sh 'curl -X POST --user '$BITBUCKET_COMMON_CREDS' "https://api.bitbucket.org/2.0/repositories/Megalai/epo3" -d {"name":"epo3"}'

}

      

