import groovy.json.JsonSlurper
String apiurl1 = "https://api.bitbucket.org/2.0/repositories/Megalai"
String username = "Megalai" 
String password = "admin123"
String userpass = username + ":" + password; 
String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes());

URL url = apiurl1.toURL();
URLConnection connection = url.openConnection();
connection.setRequestProperty("Authorization",basicAuth);
InputStream inputStream = connection.getInputStream();
def names = new groovy.json.JsonSlurper().parseText(inputStream.text);
connection.disconnect();
