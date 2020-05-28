package log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
    	logFile.println(e.getMessage());
    }
}
