def call(String msg = 'deploy_ansible') {
echo "${msg}"
  when{ branch "developer"}
  sh 'scp -i /var/lib/jenkins/.ssh/id_rsa -r /var/lib/jenkins/workspace/springboot-demo_developer/target/springboot-0.0.1-SNAPSHOT.war ansadmin@172.31.31.91:/projects/developer/playfile.yml'
  when{ branch "master"}
  sh 'scp -i /var/lib/jenkins/.ssh/id_rsa -r /var/lib/jenkins/workspace/springboot-demo_master/target/springboot-0.0.1-SNAPSHOT.war ansadmin@172.31.31.91:/projects/developer/performance.yml'
  when{ branch "release"}
  sh 'scp -i /var/lib/jenkins/.ssh/id_rsa -r /var/lib/jenkins/workspace/springboot-demo_release/target/springboot-0.0.1-SNAPSHOT.war ansadmin@172.31.31.91:/projects/developer/production.yml'
}
