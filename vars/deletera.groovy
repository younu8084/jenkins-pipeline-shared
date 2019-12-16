import jenkins.model.*
 jenkins = Jenkins.instance
 
def  call(String name ="name")
{
 
 Jenkins.instance.getItemByFullName("${name}").builds.findAll { it.number > 110 && it.number < 138 }.each { it.delete() }
}
