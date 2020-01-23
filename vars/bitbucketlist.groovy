def call(){

sh 'curl GET -v -G -u Megalai:admin123 -H "ContentType: application/json; charset=UTF-8" https://api.bitbucket.org/2.0/repositories/Megalai'

}
