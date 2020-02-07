def call(message)
{
  Date date = new Date() 
  sh " echo '${date}' BITBUCKET ${message} >>log.txt"
}
