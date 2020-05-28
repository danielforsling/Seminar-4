package integration;

import model.DTO.SaleInformation;
import model.util.TotalPrice;


/**
 * Represents an external discount-database where all the discount rules is stored. 
 * Not implemented in this class. 
 *
 */
public class DiscountSystem {
	
	TotalPrice newTotalPrice;
	
	/**
	 * Creates a new instance.
	 */
	public DiscountSystem() {
	}

	/**
	 * Checks if the customer is eligible for discount. Since discount is not 
	 * applied to this task, the same {@link TotalPrice} will always be returned.
	 * @param customerID Represent the unique id for a customer.
	 * @param saleInfo Contains sale information as a {@link SaleInformation}-object.
	 * @return The same total price. 
	 */
	public TotalPrice checkDiscount(int customerID, SaleInformation saleInfo) {
		return saleInfo.getTotalPrice();
	}
	
}
