import groovy.json.JsonSlurper 
class Example {
   static void main(String[] args) {
      def jsonSlurper = new JsonSlurper()
      Object lst = jsonSlurper.parseText('{ "url": "https://api.bitbucket.org/2.0/repositories/Megalai" }')
      lst.each { println it }
   } 
}
