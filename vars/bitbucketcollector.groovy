import groovyx.net.http.RESTClient
 
def client = new RESTClient( 'https://api.bitbucket.org/2.0/Megalai/' )
def resp = client.post( path : '/repositories/details')
                 
assert resp.status == 200
