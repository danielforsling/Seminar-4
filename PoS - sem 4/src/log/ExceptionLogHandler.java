package log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * 
 *
 */
public class ExceptionLogHandler {

	private static final String LOG_FILE_NAME = "ERROR-log-POS.txt";
    private PrintWriter logFile;
    
	/**
	 * 
	 * @throws IOException
	 */
	public ExceptionLogHandler() throws IOException {
            logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME), true);
	}
	    
	public void printExceptionToFile(Exception e) {
    //	logFile.println(e.getMessage());
    	StringBuilder logToBeSaved = new StringBuilder();
    	logToBeSaved.append(createTime());
        logToBeSaved.append(", Exception was thrown: ");
        logToBeSaved.append(e.getMessage());
        logFile.println(logToBeSaved);
        e.printStackTrace(logFile);
    }

    private String createTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
    
}
