def call(message)
{
 println(message)
  Date date = new Date() 
 
      sh " echo '${date}' Bitbucket  ${message}  >>log.txt"
}
