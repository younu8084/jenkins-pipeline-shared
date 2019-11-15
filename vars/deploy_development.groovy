def call(String msg = 'deploy_dev') {
echo "${msg}"
deploy adapters: [tomcat8(credentialsId: 'tomcat', path: '', url: 'http://3.133.86.107:8000/')], contextPath: null, onFailure: false, war: '**/*.war'
            }

