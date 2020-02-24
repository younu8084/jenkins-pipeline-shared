import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class BitBucket {

public static void main(String[] args) throws Exception {
    String username = "rig";
    String password = "rigaDapt@devOps";
    String url = "http://18.224.68.30:7990/rest/api/1.0/projects/EDN/repos/"+username;

    HttpClient client = new DefaultHttpClient();

    JSONParser parser = new JSONParser();

    Object obj = parser.parse(processRequest(url, username, password, client));

    JSONObject jsonObject = (JSONObject) obj;

    JSONArray array = (JSONArray) jsonObject.get("values");
    Set<String> repoNames = new HashSet<>();
    for(int i = 0; i < array.size(); i++){
        repoNames.add(((JSONObject) array.get(i)).get("name").toString());
    }

    long commitCount = 0;
    for(String repoName : repoNames){
        String repoUrl = "http://18.224.68.30:7990/rest/api/1.0/projects/EDN/repos/"+username + "/" + repoName.toLowerCase() + "/changesets?limit=0";
        Object commitobj = parser.parse(processRequest(repoUrl, username, password, client));

        commitCount += (Long) ((JSONObject) commitobj).get("count");
    }
    System.out.println("Total Commit Count across "+repoNames.size() +" repos for user "+username+" = " + commitCount);

}

private static String getBasicAuthenticationEncoding(String username, String password) {

    String userPassword = username + ":" + password;
    return new String(Base64.encodeBase64(userPassword.getBytes()));
}

public static String processRequest(String url, String username, String password, HttpClient client) throws ClientProtocolException, IOException{
    HttpGet request = new HttpGet(url);

    request.addHeader("Authorization", "Basic " + getBasicAuthenticationEncoding(username, password));

    HttpResponse response = client.execute(request);

    System.out.println("\nSending 'GET' request to URL : " + url);
    System.out.println("Response Code : " + 
            response.getStatusLine().getStatusCode());

    BufferedReader rd = new BufferedReader(
            new InputStreamReader(response.getEntity().getContent()));

    StringBuffer result = new StringBuffer();
    String line = "";
    while ((line = rd.readLine()) != null) {
        result.append(line);
    }

    return result.toString();
}

}
