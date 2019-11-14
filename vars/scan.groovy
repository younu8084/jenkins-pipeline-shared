def call(String msg = 'SCAN') {
echo "${msg}"
appscan application: '49f54256-de9f-4a37-9fee-a836311ee015', credentials: 'IBM CREDENTIALS', email: true, failBuild: true, failureConditions: [failure_condition(failureType: 'high', threshold: 100), failure_condition(failureType: 'total', threshold: 100)], name: 'IBM Security', scanner: static_analyzer(hasOptions: false, target: '/var/lib/jenkins/workspace/'), type: 'Static Analyzer', wait: true
}
