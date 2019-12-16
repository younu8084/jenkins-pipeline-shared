def call(String name,int s,int e)
{

Jenkins.instance.getItemByFullName('$msg').builds.findAll { it.number > $s && it.number < $e }.each { it.delete() }
}
