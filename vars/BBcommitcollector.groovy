def call()
{
sh 'curl -v -G --user rig:rigaDapt@devOps http://18.224.68.30:7990/rest/api/1.0/users/rig/repos/newrepo/commits'
}
