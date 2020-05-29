package integration;

/**
 * Exception that will be thrown when trying to access the Inventory system with an
 * invalid itemID.
 *
 */
public class InvalidItemIDException extends Exception {
	
	private int invalidItemID;
	
	/**
	 *  Creates an instance with a message that shows the invalid ID
	 *  
	 * @param itemID Represents the invalid ID.
	 */
	public InvalidItemIDException(int itemID) {
		super("The entered ID: " + itemID + " is invalid.\nNo item found with matching ID.");
		
		this.invalidItemID = itemID;	
	}
	
	/**
	 * 
	 * @return The invalid ID.
	 */
	public int getInvalidItemID() {
		return invalidItemID;
	}

}
