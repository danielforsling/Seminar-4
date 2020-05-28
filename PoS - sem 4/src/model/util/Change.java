package model.util;

import model.DTO.SaleInformation;

/**
 * Represents the change that the customer will receive after the whole purchase is paid in cash.
 *
 */
public class Change {
	
	private Amount amount;
	
	/**
	 * Creates an instance using the {@link TotalPrice} field in {@link SaleInformation}.
	 *  
	 * @param saleInfo Contains information about the sale.
	 */
	public Change(SaleInformation saleInfo) {
		this.amount = saleInfo.getTotalPrice().getFinalPrice();
	}

	/**
	 *  Updates this instance by subtracting the {@link Amount} paidAmount with the total price.
	 *  
	 * @param paidAmount Represent the <code>Amount</code> paid in cash.
	 */
	public void calculateChange(Amount paidAmount) {
		this.amount = amount.subractCurrentAmount(paidAmount);
	}
	
	/**
	 * Returns the <code>Amount</code>-instance of <code>Change</code>.
	 * 
	 * @return Returns the change.
	 */
	public Amount getChange() {
		return amount;
	}
}
