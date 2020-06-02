package log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 *	This class logs the exceptions that gets thrown in this application. 
 */
public class ExceptionLogHandler {

	private static final String LOG_FILE_NAME = "ERROR-log-POS.txt";
    private PrintWriter logFile;
    
	/**
	 * Creates an instance.
	 * 
	 * @throws IOException when something failed initiating the textfile. 
	 */
	public ExceptionLogHandler() throws IOException {
            logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME), true);
	}
	    
	/**
	 *  Prints an description of the thrown exception.
	 *  
	 * @param exception The exception to be logged.
	 */
	public void printExceptionToFile(Exception exception) {
    	StringBuilder logToBeSaved = new StringBuilder();
    	logToBeSaved.append("Exception was thrown: ");
    	logToBeSaved.append(createTime());
        logToBeSaved.append("\n");
        logToBeSaved.append(exception.getMessage());
        logFile.println(logToBeSaved);
        exception.printStackTrace(logFile);
    }

    private String createTime() {
        DateTimeFormatter timeAndDate = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return LocalDateTime.now().format(timeAndDate);
    }
    
}
