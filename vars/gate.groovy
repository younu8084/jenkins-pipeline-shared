def call(String msg = 'GATE') {
echo "${msg}"
   timeout(time: 5, unit: 'MINUTES') { // Just in case something goes wrong, pipeline will be killed after a timeout
                waitForQualityGate abortPipeline: true //waiting for a task to be completed
              }
}
