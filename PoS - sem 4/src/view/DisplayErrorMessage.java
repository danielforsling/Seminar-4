package view;

/**
 * 
 *
 */
public class DisplayErrorMessage {

	/**
	 * 
	 * @param message
	 */
	public DisplayErrorMessage() {
		
	}
	
	public void showErrorMessage(String message) {
		System.out.println(createErrorMessage(message));
	}

	private String createErrorMessage (String message) {
		StringBuilder sb = new StringBuilder();
		sb.append("***Error Message***\n");
		sb.append(message);
		sb.append("*******************");
		return sb.toString();
	}
	
}
