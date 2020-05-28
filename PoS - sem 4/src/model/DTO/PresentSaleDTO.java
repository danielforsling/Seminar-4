package model.DTO;

import model.POS.Item;
import model.util.TotalPrice;

/**
 * This class is used as an DTO, and contains some information about the sale. 
 *
 */
public class PresentSaleDTO {

	private Item mostRecentScannedItem;
	private TotalPrice totalPrice;

	/**
	 * Creates an instance
	 * 
	 * @param scannedItem Represent the most recent scanned {@link Item}.
	 * @param totalPrice The current {@link TotalPrice} of the sale.
	 */
	public PresentSaleDTO(Item scannedItem, TotalPrice totalPrice) {
		this.mostRecentScannedItem = scannedItem;
		this.totalPrice = totalPrice;
		
	}
	
	/**
	 * Returns a <code>String</code>-representation of this instance. 
	 */
	@Override
	public String toString()
	{
		if(mostRecentScannedItem.getQuantity()>1) {
		return mostRecentScannedItem.getItemDescription().getName() + "\t\t"
		+mostRecentScannedItem.getQuantity()+"*\t"+ mostRecentScannedItem.getItemDescription().getPrice()
			+"\nVAT for this item: " + mostRecentScannedItem.getItemDescription().getVATCost()		
			+"*"+mostRecentScannedItem.getQuantity()+"\nTotal Price: \t\t" + totalPrice.getFinalPrice()+"\n";
		}
		else
			return mostRecentScannedItem.getItemDescription().getName() + "\t\t\t"
				+ mostRecentScannedItem.getItemDescription().getPrice()
				+"\nVAT for this item: " + mostRecentScannedItem.getItemDescription().getVATCost()		
				+"\nTotal Price: \t\t" + totalPrice.getFinalPrice()+"\n";
	}

}
