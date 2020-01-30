import io.wcm.devops.jenkins.pipeline.utils.logging.LogLevel
import io.wcm.devops.jenkins.pipeline.utils.logging.Logger
def call()
{ 
Logger.init(this, [ logLevel: LogLevel.TRACE ])
Logger log = new Logger(this)

log.trace("I am a trace log message")

}
