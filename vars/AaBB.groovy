def call()
{
  sh "curl -X GET -s -u rig:rigaDapt@devOps http://18.224.68.30:7990/rest/api/1.0/projects/EDN/repos/demo12/commits?merges=exclude&since=f01525bb2d3&until=f01525bb2d3 -o ouput.json"
}
