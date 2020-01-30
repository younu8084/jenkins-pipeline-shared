def call()
{
File file = new File("test/out.txt")
file.write "First line\n"
file << "Second line\n"
 
println file.text
}
