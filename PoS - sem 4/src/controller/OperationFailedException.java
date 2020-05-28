package controller;

/**
 * 	Will be thrown when a operation within the controller fails, for instance connection error 
 *  to an external system.
 *
 */
public class OperationFailedException extends Exception {

	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public OperationFailedException(String message, Exception cause) {
		super(message, cause);
	}

}
