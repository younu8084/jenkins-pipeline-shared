def call(String msg = 'NEXUS') {
echo "${msg}"
       when { branch "feature1" }
          withCredentials([usernamePassword(credentialsId: 'nexus_creds', passwordVariable: 'password', usernameVariable:'username')]) {
              sh 'curl -u ${username}:${password} --upload-file target/springboot-0.0.1-SNAPSHOT.war http://ec2-18-224-155-110.us-east-2.compute.amazonaws.com:8081/nexus/content/repositories/devopstraining/hexagon6/springboot-0.0.1-SNAPSHOT-feature-$BUILD_NUMBER.war'
         }
         when { branch "developer" }
          withCredentials([usernamePassword(credentialsId: 'nexus_creds', passwordVariable: 'password', usernameVariable:'username')]) {
              sh 'curl -u ${username}:${password} --upload-file target/springboot-0.0.1-SNAPSHOT.war http://ec2-18-224-155-110.us-east-2.compute.amazonaws.com:8081/nexus/content/repositories/devopstraining/hexagon6/springboot-0.0.1-SNAPSHOT-developer-$BUILD_NUMBER.war'
         }
         when { branch "master" }
          withCredentials([usernamePassword(credentialsId: 'nexus_creds', passwordVariable: 'password', usernameVariable:'username')]) {
              sh 'curl -u ${username}:${password} --upload-file target/springboot-0.0.1-SNAPSHOT.war http://ec2-18-224-155-110.us-east-2.compute.amazonaws.com:8081/nexus/content/repositories/devopstraining/hexagon6/springboot-0.0.1-SNAPSHOT-master-$BUILD_NUMBER.war'
         }
         when { branch "release" }
          withCredentials([usernamePassword(credentialsId: 'nexus_creds', passwordVariable: 'password', usernameVariable:'username')]) {
              sh 'curl -u ${username}:${password} --upload-file target/springboot-0.0.1-SNAPSHOT.war http://ec2-18-224-155-110.us-east-2.compute.amazonaws.com:8081/nexus/content/repositories/devopstraining/hexagon6/springboot-0.0.1-SNAPSHOT-release-$BUILD_NUMBER.war'
         }
}
