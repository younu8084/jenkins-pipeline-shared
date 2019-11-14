def call(String msg = 'deploy_dev') {
echo "${msg}"
deploy adapters: [tomcat8(credentialsId: 'tomcat', path: '', url: 'http://3.134.99.123:8000/')], contextPath: null, onFailure: false, war: '**/*.war'
            }

