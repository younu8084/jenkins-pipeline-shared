def connection = new URL( "https://api.bitbucket.org/2.0/repositories/Megalai")
        .openConnection() as HttpURLConnection

connection.setRequestProperty( 'Accept', 'application/json' )

// get the response code - automatically sends the request
println connection.inputStream.text
