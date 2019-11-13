def call(String buildStatus = 'clean') {
echo "${msg}"
   sh 'mvn clean install'
}
