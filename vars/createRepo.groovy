import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
def call(){

final Logger logger = LoggerFactory.getLogger("myGroovyLogger");
logger.trace("Test log output message");
myGroovyLogger.level=FINEST
}
