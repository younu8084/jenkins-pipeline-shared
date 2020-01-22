def call(){
sh 'curl -X POST -H "Content-Type: application/json" -d '{
    "scm": "git",
    "project": {
        "key": "DEM"
    }
}' https://api.bitbucket.org/2.0/user/megalai1/projects/DEM/repositories/repo1'
}

      

