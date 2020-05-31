package view;

import model.util.Amount;
import model.util.TotalPriceObserver;

/**
 *	Prints the totalPrice of the sale on a simulated external display.
 */
public class TotalRevenueView implements TotalPriceObserver{
	
	private Amount totalPrice;
	
	/**
	 *  Creates an instance, set the field totalPrice to zero.
	 */
	public TotalRevenueView() {
			totalPrice = new Amount(0);
	}
	
	@Override
	public void showTotalPrice(Amount totalPrice) {
		this.totalPrice = this.totalPrice.addAmounts(totalPrice);
		printCurrentState();
	}
	
	private void printCurrentState() {
		System.out.println();
		System.out.println("******External Display******");
		System.out.println("Total revenue: " + totalPrice.toString());
		System.out.println("****************************");
		
	}

}
