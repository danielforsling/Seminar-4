package integration;

import java.util.ArrayList;

import model.DTO.SaleInformation;
import model.util.Amount;

/**
 * Represents a inventory at a retail store. Since no real database is used, a few hardcoded 
 * items is added to the created instance of this class.  
 *
 */
public class ExternalInventorySystem {
	
	private final int dbErrorItem = 1234;
	
	private ArrayList<ItemDescription> goodsInStock = new ArrayList<ItemDescription>();

	/**
	 * Create an instance. Adds a few hardcoded number of {@link ItemDescription} to the 
	 * <code>ArrayList</code> in this instance.
	 */
	public ExternalInventorySystem() {
		addGoods();
	}

	
	/**
	 * Searches the database for a certain <code>ItemDescription</code>. The itemID is compared
	 * and the description is returned if found, if not, <code>null</code> is returned.
	 * 
	 * @param itemID Represents the ID of the item searched for.
	 * @return Description of the found item. Returns <code>null</code> if item is not found.
	 * @throws ExternalInventorySystem when there is no connection to the external systems.
	 * @throws InvalidItemIDException when searching after an item with a non-existing itemID. 
	 */
	public ItemDescription findItem(int itemID) throws InvalidItemIDException {
		for(ItemDescription item: goodsInStock) {
			if(item.getItemID() == itemID) {
				return item;
			} else if(itemID == dbErrorItem) {
				throw new ExternalSystemsFailureException("Connection to the Inventory System could not be established."
															+"\nPlease contact the System administrator");
			}
		}	
		throw new InvalidItemIDException(itemID);
	}

	/**
	 * Updates the inventory after sale is completed, not implemented.
	 * 
	 * @param saleInfo Contains information about the sale as a {@link SaleInformation}-object.
	 */
	public void updateInventory(SaleInformation saleInfo) {
		//some code
	}
	
	/**
	 * The hardcoded inventory.
	 */
	private void addGoods() {
		goodsInStock.add(new ItemDescription(new Amount(50), "Butter", 0.06, 1010));
		goodsInStock.add(new ItemDescription(new Amount(25), "Bread", 0.12, 2020));
		goodsInStock.add(new ItemDescription(new Amount(12), "Flour", 0.25, 3030));
		goodsInStock.add(new ItemDescription(new Amount(16), "Pasta", 0.25, 4040));
		goodsInStock.add(new ItemDescription(new Amount(40), "Coffee", 0.25, 5050));
		goodsInStock.add(new ItemDescription(new Amount(100), "Cheese", 0.12, 6060));
	
	}

	
}
