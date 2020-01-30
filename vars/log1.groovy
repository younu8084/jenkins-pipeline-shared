def call()
{
class myClass implements Serializable {
    def _logger
    def script
    myClass(def script, Map config) {
        _logger = script.getContext(TaskListener.class).getLogger()
        this.script = script
        this.config = config // some data
        log 'Initializing myClass...'
    }

  @NonCPS
    private void log(message) {
        script.getContext(TaskListener.class).getLogger().println(message)
    }
...

def someMethod(){
    ...
    script.sh(someScript)
    ...
}
}
}
