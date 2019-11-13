def call(String msg = 'NEXUS') {
echo "${msg}"
       withCredentials([usernamePassword(credentialsId: 'nexus_creds', passwordVariable: 'password', usernameVariable:'username')]) {
              sh 'curl -u ${username}:${password} --upload-file target/myWebApp_Test-${BUILD_NUMBER}.war http://ec2-18-224-155-110.us-east-2.compute.amazonaws.com:8081/nexus/content/repositories/devopstraining/phoenixTeam/myWebApp_Test-${BUILD_NUMBER}.war'
         }
}
