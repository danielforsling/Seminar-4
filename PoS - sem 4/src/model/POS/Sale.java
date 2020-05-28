package model.POS;

import java.time.LocalTime;
import java.util.ArrayList;

import integration.ItemDescription;
import model.DTO.PresentSaleDTO;
import model.DTO.SaleInformation;
import model.util.Amount;
import model.util.TotalPrice;

/**
 * This class represents a purchase of goods made by a single customer. 
 * Contains most of the business-logic in this application. 
 * 
 */
public class Sale {
	
	private LocalTime saleTime;
	private ArrayList<Item> itemsInPurchase = new ArrayList<>();
	private TotalPrice totalPrice;
	
	/**
	 * Creates a new instance. The time of sale is when the instance is initiated.
	 */
	public Sale()
	{
		saleTime = LocalTime.now();
		totalPrice = new TotalPrice();
	}
	
	/**
	 * Adds a {@link Item} to the <code>ArrayList</code> of goods to be purchased. Updates the
	 * {@link TotalPrice}, both the total price and VAT-total. Returns the most recent scanned item and some information about the 
	 * sale as a {@link PresentSaleDTO}-object.
	 * 
	 * @param newItem The {@link ItemDescription} of the <code>Item</code> to be added.
	 * @param quantity Represents the number of items to be added.
	 */
	public PresentSaleDTO addItemToList(ItemDescription newItem, int quantity) {
		updateList(newItem, quantity);
		updateTotalPriceAndVAT(newItem, quantity);
		
		Item recentItem = getMostRecentItem(newItem);
		return new PresentSaleDTO(recentItem, totalPrice);
	}

	/**
	 * Updates the <code>ArrayList</code> with a new <code>Item</code>. If the <code>Item</code> is already
	 * in the list, then the quantity of that <code>Item</code> increases.
	 * 
	 * @param itemToBeChecked Is the the <code>ItemDescription</code> of the <code>Item</code> to be added.
	 * @param quantity The quantity of the <code>Item</code>.
	 */
	private void updateList(ItemDescription itemToBeChecked, int quantity) {
		if(this.itemIsInList(itemToBeChecked)) {
			for(Item item: itemsInPurchase) {
				if(item.getItemDescription().equalID(itemToBeChecked)) {
					item.updateQuantity(quantity);
					break;
				}
			}
		}	
		else {
			itemsInPurchase.add(new Item(itemToBeChecked, quantity));
		}		
	}
	
	
	private void updateTotalPriceAndVAT(ItemDescription item, int quantity) {
		Amount priceOfItem = calculatePriceOfItem(item, quantity);
		Amount VAT = calulateVAT(item.getVATRate(), priceOfItem);
	
		totalPrice.addToTotalPrice(priceOfItem);
		totalPrice.addToTotalVAT(VAT);
	}
	
	private Amount calulateVAT (double VATrate, Amount price) {
		return price.multiplyAmountDouble(VATrate);
	}
	
	private Amount calculatePriceOfItem(ItemDescription item, int quantity) {
		return item.getPrice().multiplyAmount(quantity);
	}
	
	
	
	/**
	 * Checks if the <code>ArrayList</code> of items contains an <code>Item</code> with a
	 * matching ID with the parameter <code>ItemDescription</code>.
	 * 
	 * @param checkedItem Represent the description of the item to be checked.
	 * @return <code>True</code> if the list contains a matching item, else <code>False</code>.
	 */
	private boolean itemIsInList(ItemDescription checkedItem)
	{
		for(Item item: itemsInPurchase)
		{
			if(item.getItemDescription().equals(checkedItem))				
				return true;
		}	
			
		return false;
	}
	
	/**
	 * Returns the most recent scanned item.
	 * 
	 * @param itemDescription <code>ItemDescription</code> of the most recent scanned item.
	 * @return The <code>Item</code> searched for.
	 */
	private Item getMostRecentItem(ItemDescription itemDescription) {
		int index = getIndexOfItemInList(itemDescription);
		Item newItem = itemsInPurchase.get(index);
		return newItem;
	}
	
	/**
	 * Searches the list of items for a specified <code>Item</code>. If a matching <code>Item</code> is found, 
	 * the index of that item is returned. If not, -1 is returned.
	 * 
	 * @param itemDesc <code>ItemDescription</code> of the item searched for.
	 * @return The index of the searched <code>Item</code> if found, else <code>-1</code>.
	 */
	private int getIndexOfItemInList(ItemDescription itemDesc) {
		int index = -1;
		for(Item item: itemsInPurchase) {
			if(item.getItemDescription().equalID(itemDesc)) {
				index= itemsInPurchase.indexOf(item);
			}
		}
		return index;
	}

	/**
	 * Stops the <code>Sale</code> and returns the first instance of <code>SaleInformation</code>.
	 */
	public SaleInformation stopSale() {
		SaleInformation saleInfo = new SaleInformation(this);
		return saleInfo;
	}
	
	/**
	 *  Returns the itemList as a <code>String</code>, will be used when printing receipt.
	 *  
	 * @return <code>String</code>-representation of the list if items.
	 */
	public String itemsToString() {
		StringBuilder builder = new StringBuilder();
		
		for(Item item: itemsInPurchase)
		{
			builder.append(item.toString()+"\n");
		}	
		
		return builder.toString();
	}
	
	/**
	 * Returns the <code>TotalPrice</code> that contains the total price and VAT-total.
	 * 
	 * @return The total price of the current <code>Sale</code>.
	 */
	public TotalPrice getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Returns the time when the <code>Sale</code> started.
	 * 
	 * @return saleTime as a <code>LocalTime</code>-object.
	 */
	public LocalTime getSaleTime() {
		return saleTime;
	}

	/**
	 * Returns the <code>ArrayList</code>.
	 * 
	 * @return The list of all items. 
	 */
	public ArrayList<Item> getItemsInPurchase() {
		return itemsInPurchase;
	}
	
}

