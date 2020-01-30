import java.util.logging.Logger
import java.util.logging.FileHandler
import java.util.logging.SimpleFormatter
import java.io.IOException
import java.util.logging.LogManager
import java.util.logging.Level

int FILE_SIZE = 1024
def call(){

def logger = Logger.getLogger("")
LogManager.getLogManager().reset()


try {
	//
	// Creating an instance of FileHandler with 5 logging files
	// sequences.
	//
	FileHandler handler = new FileHandler("myapp.log", FILE_SIZE, 5, true);
	handler.setFormatter(new SimpleFormatter());
	logger.addHandler(handler);
	//logger.setUseParentHandlers(false);
} catch (IOException e) {
	logger.warning("Failed to initialize logger handler.");
}

for (i = 0; i < 5000; i++) {
	logger.info ("I am a test info log")
}
}
