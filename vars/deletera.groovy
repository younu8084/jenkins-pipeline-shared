def call(name,s,e)
{

Jenkins.instance.getItemByFullName('$name').builds.findAll { it.number > $s && it.number < $e }.each { it.delete() }
}
