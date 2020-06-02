package model.util;

import java.util.ArrayList;

import model.DTO.SaleInformation;

/**
 *	A class that has the purpose to notify all observers when the payment of the 
 *	current sale is finished. 
 */
public class ObserverDataHandler {

	private ArrayList<TotalPriceObserver> totalPriceObservers = new ArrayList<>();
	private Amount priceOfCurrentSale;

	/**
	 * Creates an instance.
	 */
	public ObserverDataHandler() {
		
	}

	private void notifyObservers() {
		for(TotalPriceObserver obs : totalPriceObservers)
			obs.showTotalPrice(priceOfCurrentSale);
	}
	
	/**
	 * Adds the list of observers to the current instance.
	 * 
	 * @param observers to be added.
	 */
	public void addTotalPriceObservers(ArrayList<TotalPriceObserver> observers) {
		totalPriceObservers.addAll(observers);
	}
	
	/**
	 *  Retrieves the Total price from the current sale and notifies the observers.
	 *  
	 * @param saleInfo Containing information of the sale.
	 */
	public void updateObservers(SaleInformation saleInfo) {
		priceOfCurrentSale = saleInfo.getTotalPrice().getFinalPrice();
		notifyObservers();
	}
	
}
