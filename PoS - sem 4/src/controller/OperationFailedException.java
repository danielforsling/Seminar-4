package controller;

/**
 * 	Will be thrown when a operation within the controller fails, for instance connection error 
 *  to an external system.
 *
 */
public class OperationFailedException extends Exception {

	/**
	 *  Creates an instance.
	 *  
	 * @param message The message explaining the Exception
	 * @param cause The previously caught exception
	 */
	public OperationFailedException(String message, Exception cause) {
		super(message, cause);
	}

}
