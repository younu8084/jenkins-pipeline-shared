def call(String buildStatus = 'BUILD') {
echo "${msg}"
   sh 'mvn clean install'
}
