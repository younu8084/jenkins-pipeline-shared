def call(String msg = 'SCAN') {
echo "${msg}"
appscan application: '5a4f60ed-f85e-4251-94ad-29481ec4e3dc', credentials: 'IBM2', email: true, failBuild: true, failureConditions: [failure_condition(failureType: 'high', threshold: 1000), failure_condition(failureType: 'total', threshold: 1000)], name: 'IBM2', scanner: static_analyzer(hasOptions: false, target: '/var/lib/jenkins/workspace/'), type: 'Static Analyzer', wait: true
}
