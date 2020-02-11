def call()
{
def json= sh 'curl -v -G --user rig:rigaDapt@devOps http://18.224.68.30:7990/rest/api/1.0/projects/edn/repos/rig/commits -o ouput.json'
 
}
