package integration;

import model.DTO.Receipt;

/**
 *Represents a Printer with the only function to print receipts. 
 *
 */
public class Printer {
	
	/**
	 * Creates an instance.
	 */
	public Printer() {
	}
	
	/**
	 * Prints the <code>String<code> representation of {@link Receipt }
	 * @param receipt Contains information about the sale.
	 */
	public void printReceipt(Receipt receipt) {

		System.out.println(receipt.toString());
	
	}
}
