import jenkins.model.*
 
def  call(String name ='name')
{
 jenkins = Jenkins.instance
 Jenkins.instance.getItemByFullName("${name}").builds.findAll { it.number > 110 && it.number < 138 }.each { it.delete() }
}
