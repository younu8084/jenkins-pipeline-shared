import jenkins.model.*
 
def  call(name,s, e)
{
 jenkins = Jenkins.instance
 Jenkins.getItemByFullName(name).builds.findAll { it.number > s && it.number < e }.each { it.delete() }
}
def del(name, s, e)
{
 
 build job: name, pa1: s,pa2: e
 call(name, s, e)
}
