package integration;

import model.DTO.SaleInformation;
/**
 * Represents the stores sale log, where the information about every purchase is stored.
 *  Not implemented in this task. 
 */
public class SaleLog {
	
	private SaleLog saleLog;
	
	/**
	 * Creates an instance.
	 */
	public SaleLog() {
	}
	
	public SaleLog getSaleLog() {
		return saleLog;	
	}
	
	/**
	 * Stores the information about the sale in the sale log. Not implemented.
	 * @param CustomerID Represents a customer id-code.
	 * @param saleInfo Contains information about the sale.
	 */
	public void storeSaleInformation(int CustomerID, SaleInformation saleInfo) {
		//some code
	}

}
