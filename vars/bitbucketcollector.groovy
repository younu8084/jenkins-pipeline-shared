import groovy.json.JsonSlurper
def json = new JsonSlurper().parseText( new URL( 'https://api.bitbucket.org/2.0/repositories/Megalai/namerepo' ).text )

json.each { println it }
