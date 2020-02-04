def call(){
sh 'curl -u rig:rigaDapt@devOps -X POST http://18.224.68.30:7990//rest/api/1.0/projects/BIT/newrepo -F filename.ext=@filename.ext'
}
