import jenkins.model.*
 
def  call(String name ='name',int s=0,int e=0)
{
 jenkins = Jenkins.instance
 Jenkins.getItemByFullName(${name}).builds.findAll { it.number > $s && it.number < $e }.each { it.delete() }
}
