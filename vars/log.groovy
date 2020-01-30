def call()
{
def fileName = '/tmp/test.log'
fileName.write "First line\n"
fileName << "Second line\n"
 
println fileName.text
}
