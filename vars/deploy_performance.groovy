def call(String msg = 'deploy_per') {
echo "${msg}"
                 sh 'ssh -t -t -i /var/lib/jenkins/.ssh/id_rsa ansadmin@172.31.31.91 "ansible-playbook /opt/playbooks/performance.yml"'

}
