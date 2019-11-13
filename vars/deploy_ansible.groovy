def call(String msg = 'deploy_ansible') {
echo "${msg}"
  sh 'scp -i /var/lib/jenkins/.ssh/id_rsa -r /var/lib/jenkins/workspace/springboot-demo/target/springboot-0.0.1-SNAPSHOT.war ansadmin@172.31.31.91:/projects'
}
