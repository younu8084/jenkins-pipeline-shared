def call(String msg = 'deploy_dev') {
echo "${msg}"
deploy adapters: [tomcat8(credentialsId: 'tomcat', path: '', url: 'http://3.14.72.144:8000/')], contextPath: null, onFailure: false, war: '**/*.war'
            }

