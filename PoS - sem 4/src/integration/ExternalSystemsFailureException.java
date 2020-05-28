package integration;

/**
 * Exception that will be thrown when simulating an database-connection exception. 
 * Could be that that one of the databases is offline or not connected to the network and so on.
 *
 */
public class ExternalSystemsFailureException extends RuntimeException {
	
	/**
	 *  Creates an instance with a message that shows the invalid ID
	 *  
	 * @param msg Represents the error message.
	 */
	public ExternalSystemsFailureException(String msg) {
		super(msg);
	}
	
}


