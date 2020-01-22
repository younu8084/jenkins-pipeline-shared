def call(){
sh curl -X POST -v -u ${username}:${password} "https://api.bitbucket.org/2.0/repositories/Megalai" -H "Content-Type: application/json"  -d '{"is_private": true, "project": {"key": "PRJ_KEY"}}'
}
