package model.util;

import model.POS.Sale;

/**
 *	An observer of the total price in {@link Sale}. When sale is completed, class that
 *implements this interface will update the totalPrice locally.
 */
public interface TotalPriceObserver {
	
	public void showTotalPrice(Amount paidAmount);
}
