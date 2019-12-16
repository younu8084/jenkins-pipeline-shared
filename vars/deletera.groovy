import jenkins.model.*
 
def  call(name,s, e)
{
 jenkins = Jenkins.instance
 Jenkins.getItemByFullName($name).builds.findAll { it.number > $s && it.number < $e }.each { it.delete() }
}
