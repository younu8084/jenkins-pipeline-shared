def call(tool,message)
{
  Date date = new Date() 
  sh " echo '${date}' ${tool} ${message} >>log_'${BUILDNUMBER}'.txt"
}
