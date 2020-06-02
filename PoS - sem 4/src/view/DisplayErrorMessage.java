package view;

/**
 *	A class that prints the error messages in this application.
 */
public class DisplayErrorMessage {

	/**
	 * Creates an instance
	 */
	public DisplayErrorMessage() {
		
	}
	
	/**
	 * This method is called when an error-message will be printed.
	 * @param message
	 */
	public void showErrorMessage(String message) {
		System.out.println(createErrorMessage(message));
	}

	private String createErrorMessage (String message) {
		StringBuilder sb = new StringBuilder();
		sb.append("***Error Message***\n");
		sb.append(message);
		sb.append("\n*******************");
		return sb.toString();
	}
	
}
