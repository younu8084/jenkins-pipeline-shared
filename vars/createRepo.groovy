def call()
{
//You can change the log content
def content = "This is the message that user like to log, but to a file"
//You can change the file name
def fileName = '/tmp/test.log'
//Write to the file
new File(fileName).write(content)
}
