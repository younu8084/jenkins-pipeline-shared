import jenkins.model.*
 
def  call(String name="jn",int s,int e)
{
 jenkins = Jenkins.instance
 Jenkins.getItemByFullName("${msg}").builds.findAll { it.number > ${s} && it.number < ${e} }.each { it.delete() }
}
