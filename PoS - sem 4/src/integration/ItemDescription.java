package integration;

import model.util.Amount;

/**
 * This class represents the information about an item 
 * stored in an external database.
 */
public class ItemDescription {
	
	private Amount price; 
	private String name;
	private double VATRate;
	private int itemID;
	
	/**
	 * Creates a new instance of this type.
	 * @param price The price of the item.
	 * @param name The name of the item.
	 * @param VATRate The VAT-rate of the item.
	 * @param itemID The itemID of the item.
	 */
	public ItemDescription(Amount price, String name, double VATRate, int itemID) {
		this.price = price;
		this.name = name;
		this.VATRate = VATRate;
		this.itemID = itemID;
		
	}
	
	/**
	 *  Returns the itemID of the current instance.
	 *  
	 * @return The itemID of this instance.
	 */
	public int getItemID()
	{
		return this.itemID;
	}
	
	/**
	 * Returns the price as an {@link Amount}-object.
	 * 
	 * @return The price of this instance.
	 */
	public Amount getPrice()
	{
		return this.price;
	}
	
	/**
	 * Returns the name of the item as a <code>String</code>
	 * @return The name of this instance
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Returns the VAT-rate of the current instance. 
	 * @return The VAT rate as a <code>double</code>.
	 */
	public double getVATRate() {
		return this.VATRate;
	}
	
	
	/**
	 * If two <code>ItemDescription</code> objects have the same itemID, they are
	 * considered equal.
	 * 
	 * @param otherItem The <code>ItemDescription</code> to compare with this instance.
	 * @return <code>true</code> if the objects are equal. <code>false</code> if they are not.
	 */
	public boolean equalID(ItemDescription otherItem) {
		if(this.itemID==otherItem.getItemID())
			return true;
		else 
			return false;
	}
	
	/**
	 * Returns the VAT-cost of this instance as an <code>Amount</code>-object.  
	 * @return The VAT-cost of the item.
	*/
	public Amount getVATCost() {
		return price.multiplyAmountDouble(VATRate);
	}
	
}
