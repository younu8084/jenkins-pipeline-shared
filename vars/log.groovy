def call()
{
File file = new File("log.txt")
file.write "First line\n"
file << "Second line\n"
 
println file.text
}
