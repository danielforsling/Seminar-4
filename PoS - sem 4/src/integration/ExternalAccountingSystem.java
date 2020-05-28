package integration;

import model.DTO.SaleInformation;
import model.POS.Sale;

/**
 * This class represent an external accounting system at a retail store. The usage of
 * this class in not implemented except for calling dummy-method updateAccounting, which 
 * itself does nothing at this point. 
 *
 */
public class ExternalAccountingSystem {
	
	private ExternalAccountingSystem accounting;
	
	/**
	 * Creates an instance.
	 */
	public ExternalAccountingSystem() {
	
	}
	
	/**
	 * Updates the accounting-system after completed {@link Sale}. Not implemented.
	 * 
	 * @param saleInfo Contains all info about the sale as {@link SaleInformation}-object.
	 */
	public void updateAccounting(SaleInformation saleInfo) {
		//some code
	}

}
