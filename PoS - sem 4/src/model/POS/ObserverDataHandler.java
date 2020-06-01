package model.POS;

import java.util.ArrayList;

import model.util.Amount;
import model.util.TotalPriceObserver;

/**
 *	A class that has the purpose to notify all observers when the payment of the 
 *	current sale is finished. 
 */
public class ObserverDataHandler {

	private ArrayList<TotalPriceObserver> totalPriceObservers = new ArrayList<>();
	private Amount priceOfCurrentSale;

	/**
	 * 
	 */
	public ObserverDataHandler() {
		
	}

	private void notifyObservers() {
		for(TotalPriceObserver obs : totalPriceObservers)
			obs.showTotalPrice(priceOfCurrentSale);
	}
	
	/**
	 * 
	 * @param observers
	 */
	public void addTotalPriceObservers(ArrayList<TotalPriceObserver> observers) {
		totalPriceObservers.addAll(observers);
	}
	
	public void updateObservers(Amount totalPrice) {
		priceOfCurrentSale = totalPrice;
		notifyObservers();
	}
	
}
