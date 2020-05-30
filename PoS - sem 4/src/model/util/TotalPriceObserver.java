package model.util;

import model.POS.Sale;

/**
 *	An observer of the total price in {@link Sale}. When sale is completed, class that
 *	implements this interface will receive notifications about the total price.
 */
public interface TotalPriceObserver {
	
	/**
	 * Invoked when a sale has been paid.
	 * 
	 * @param totalPrice The totalPrice of the completed sale.
	 */
	public void showTotalPrice(Amount totalPrice);
}
