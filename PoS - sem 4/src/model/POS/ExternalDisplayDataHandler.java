package model.POS;

import java.util.ArrayList;

import model.util.Amount;
import model.util.TotalPriceObserver;

/**
 *	A class that has the purpose to notify all observers when the payment of the 
 *	current sale is finished. 
 */
public class ExternalDisplayDataHandler {

	private ArrayList<TotalPriceObserver> totalPriceObservers = new ArrayList<>();
	private Amount totalPrice;

	/**
	 * 
	 * @param observers
	 * @param totalPrice
	 */
	public ExternalDisplayDataHandler(ArrayList<TotalPriceObserver> observers, Amount totalPrice) {
		totalPriceObservers.addAll(observers);
		this.totalPrice = totalPrice;
		notifyObservers();
	}

	private void notifyObservers() {
		for(TotalPriceObserver obs : totalPriceObservers)
			obs.showTotalPrice(totalPrice);
	}
	
	/**
	 * 
	 * @param observers
	 */
	public void addTotalPriceObservers(ArrayList<TotalPriceObserver> observers) {
		totalPriceObservers.addAll(observers);
	}
	
}
