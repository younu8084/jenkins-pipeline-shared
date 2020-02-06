 def call(){

  
  def link1 = "rm -rf ./* && git clone https://github.com/kavi1997/TestProject.git && git clone http://rig:rigaDapt%40devOps@18.224.68.30:7990/scm/edn/rig.git && cp -r ./TestProject/* ./app && pwd && cd app && pwd && git init && git add --all && git status && git commit -m 'commit' && git remote add origin http://rig:rigaDapt%40devOps@18.224.68.30:7990/scm/edn/rig.git && git push -u origin master"
   
  
   sh(link1)
   
    
  }

         
 
