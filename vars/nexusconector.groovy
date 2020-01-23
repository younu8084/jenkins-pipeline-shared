def call()
{
sh 'curl -X POST -H "Content-Type: application/json" -d @repo.json -u admin:admin123 "http://3.15.18.214:8081/nexus/service/local/repositories"'
