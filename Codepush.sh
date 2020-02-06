#!/usr/bin/bash
git config --global user.name "rig"
git clone https://github.com/kavi1997/TestProject.git 
git clone http://{rig}:{rigaDapt@devOps}@18.224.68.30:7990/scm/bit/newrepo3.git
cp -r ./TestProject/* ./app
cd app
git init
git add --all
git commit -m "initial commit"
git remote add origin http://rig@18.224.68.30:7990/scm/bit/newrepo3.git
git push -u origin master
