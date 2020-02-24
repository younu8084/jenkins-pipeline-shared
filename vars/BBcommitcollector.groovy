def call(){
 Date date = new Date() 
sh "curl -X GET  -H -d  -u  rig:rigaDapt@devOps http://18.224.68.30:7990/rest/api/1.0/projects/EDN/repos/demo12/users/rig/commits?since='${date}'&until='${date}' "
 }
