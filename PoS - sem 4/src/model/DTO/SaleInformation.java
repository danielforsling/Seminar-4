package model.DTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import model.POS.Item;
import model.POS.Sale;
import model.util.Amount;
import model.util.TotalPrice;

/**
 * This class is used as an DTO that contains information about the completed {@link Sale}.
 * When the sale is completed, a first instance of this class is created. The first creation 
 * contains all information of the sale, except for the amount paid by the customer, and the
 * change that will be handed out. After the customer have paid in cash, the final 
 * <code>SaleInformation</code> is created with all important information complete. 
 */
public class SaleInformation {
	
	private final ArrayList <Item> itemList;
	private final LocalTime saleTime;
	private final LocalDate date;
	private final TotalPrice totalPrice;
	private final Amount totalVAT;
	private final Amount amountPaid;
	private final Amount change;
	private final String itemListAsString;
	
	/**
	 * Creates the first instance used by the application.
	 * @param sale Contains all information of the <code>Sale</code>.
	 */
	public SaleInformation(Sale sale)
	{
		this.itemList = sale.getItemsInPurchase();
		this.saleTime = sale.getSaleTime();
		this.date = LocalDate.now();
		this.totalPrice = sale.getTotalPrice();
		this.totalVAT = totalPrice.getTotalVAT();
		this.amountPaid = new Amount(0);
		this.change = new Amount(0);
		this.itemListAsString = sale.itemsToString(); 
	}
	
	/**
	 * Creates the final instance by copying the previous instance, and adding new values 
	 * to change and amountPaid.
	 * 
	 * @param saleInfo The first created instance of <code>SaleInformation</code>.
	 * @param change Represents how much change that will be handed out. Stored as an {@link Amount}-object.
	 * @param amountPaid Represents how much cash the customer paid.
	 * 
	 */
	public SaleInformation(SaleInformation saleInfo, Amount change, Amount amountPaid)
	{
		this.itemList = saleInfo.itemList;
		this.saleTime = saleInfo.saleTime;
		this.date = saleInfo.getDate();
		this.totalPrice = saleInfo.totalPrice;
		this.totalVAT = saleInfo.totalVAT;
		this.itemListAsString = saleInfo.itemListAsString;
		this.change = change;
		this.amountPaid = amountPaid;
	}
	
	/**
	 * Gets the {@link TotalPrice} - totalPrice field.
	 * 
	 * @return the Total price.
	 */
	public TotalPrice getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Gets the <code>LocalTime</code> saleTime field.
	 * 
	 * @return time of the sale.
	 */
	public LocalTime getSaleTime() {
		return saleTime;
	}

	/**
	 * Gets the <code>LocalDate</code> date field.
	 * 
	 * @return  the date of the sale.
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Gets the <code>Amount</code> totalVAT field.
	 * 
	 * @return totalVAT.
	 */
	public Amount getTotalVAT() {
		return totalVAT;
	}

	/**
	 * Gets the <code>String</code>-representation of the <code>ArrayList</code> of items.
	 * 
	 * @return itemListAsString.
	 */
	public String getItemListAsString() {
		return itemListAsString;
	}
	
	/**
	 * Gets the <code>Amount</code> change field.
	 * @return the change.
	 */
	public Amount getChange() {
		return this.change;
	}
	
	/**
	 *  Gets the <code>Amount</code> amountPaid field.
	 * @return amountPaid.
	 */
	public Amount getAmountPaid() {
		return this.amountPaid;
	}
	
	
}
