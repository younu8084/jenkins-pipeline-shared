def call(String msg = 'deploy_dev') {
echo "${msg}"
deploy adapters: [tomcat8(credentialsId: 'tomcat', path: '', url: 'http://18.221.174.168:8000/')], contextPath: null, onFailure: false, war: '**/*.war'
            }

