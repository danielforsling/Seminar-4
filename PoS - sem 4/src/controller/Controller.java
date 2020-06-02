package controller;

import java.util.ArrayList;
import integration.CreateSystems;
import integration.DiscountSystem;
import integration.ExternalAccountingSystem;
import integration.ItemDescription;
import integration.ExternalInventorySystem;
import integration.ExternalSystemsFailureException;
import integration.InvalidItemIDException;
import integration.Printer;
import integration.SaleLog;
import model.DTO.PresentSaleDTO;
import model.DTO.Receipt;
import model.DTO.SaleInformation;
import model.POS.CashRegister;
import model.POS.Sale;
import model.util.Amount;
import model.util.Change;
import model.util.ObserverDataHandler;
import model.util.TotalPrice;
import model.util.TotalPriceObserver;

/**
 * 	This class is the application's only controller. All calls from the view
 *	pass through here.
 */
public class Controller {

	private ExternalInventorySystem inventory;
	private DiscountSystem discSys;
	private ExternalAccountingSystem accounting;
	private SaleLog saleLog;
	
	private Printer printer;
	private CashRegister register;
	private Sale sale;
	private SaleInformation saleInfo;
	
	private ArrayList<TotalPriceObserver> totalPriceObservers = new ArrayList<>();
	private ObserverDataHandler dataHandler = new ObserverDataHandler();
	
	/**
	 * Creates an instance.
	 * 
	 * @param systems
	 * @param printer Represents a Printer that will print {@link}
	 */
	public Controller(CreateSystems systems, Printer printer) {
		
		this.inventory = systems.getExternalInventorySystem();
		this.discSys = systems.getDiscountSystem();
		this.accounting = systems.getExternalAccountingSystem();
		this.saleLog = systems.getSaleLog();
		this.printer = printer;
		
		this.register = new CashRegister();
		
	}
	
	
	/**
	 *  Starts the sale.
	 */
	
	public void startSale() {
		this.sale = new Sale();
	}
	
	/**
	 *  Scans a particular item and forward that item to the <code>Sale</code> class.
	 * 	Returns some information about the sale, and the most recent scanned item.
	 * 
	 * @param itemID Represent the unique ID that every type of item has.
	 * @param quantity The quantity of the scanned item.
	 * @return PresentSaleDTO that contains information about the sale.
	 * @throws InvalidItemIDException when searching with an invalid-id
	 * @throws OperationFailedException when lost connection to external systems.
	 * 				
	 */
	public PresentSaleDTO findItem(int itemID, int quantity) 
								throws OperationFailedException, InvalidItemIDException {

		PresentSaleDTO displaySale = null;
	
		ItemDescription itemToBeAdded = null;
		try {
			itemToBeAdded = inventory.findItem(itemID);
		} catch (ExternalSystemsFailureException e) {
			throw new OperationFailedException("Lost connection to the External systems", e);
		}
		
		if(itemToBeAdded!=null) {
			displaySale = this.sale.addItemToList(itemToBeAdded, quantity);
		}
	
		return displaySale;
	}
	
	
	/**
	 * Stops the sale.
	 * @return Information about the sale as an SaleInformation-object. 
	 */
	public SaleInformation stopSale() {
		return this.saleInfo = sale.stopSale();
	}
	
	/**
	 *  Check if the customer is eligible for discount. Since it's not applied to this task,
	 *  the same total price stored in saleInfo will be returned. 
	 *  
	 * @param customerID Represents the unique id for the customer.
	 * @param saleInfo Contains information about the sale
	 * @return The same total price as in the <code>SaleInformation</code> object.
	 */
	public TotalPrice checkDiscount(int customerID, SaleInformation saleInfo) {
		return discSys.checkDiscount(customerID, saleInfo);
	}
	
	/**
	 *  Receives cash pays as an <code>Amount</code>, updates amount stored in <code>CashRegister</code>,
	 *  calculates the <code>Change</code>. Then creates the final <code>SaleInformation</code> that
	 *  will be used to update the systems. 
	 *   
	 * @param amountPaid Represents the cash paid as an <code>Amount</code> object.
	 * @return
	 */
	public void enterAmountPaid(Amount amountPaid) {
		Change change = new Change(this.saleInfo);
		
		register.updateAmountStored(saleInfo.getTotalPrice().getFinalPrice());
		change.calculateChange(amountPaid);
		createFinalSaleInformation(change.getChange(), amountPaid);
		
		updateSystems();
		
	}
	
	/**
	 * Adds an Observer to the ArrayList in the instance and also in the observed class
	 * {@link ObserverDataHandler}. 
	 * 
	 * @param obs The Observer interface to be added.
	 */
	public void addTotalPriceObservers(TotalPriceObserver obs) {
		totalPriceObservers.add(obs);
		dataHandler.addTotalPriceObservers(totalPriceObservers);
	}
	
	private void updateSystems() {
		inventory.updateInventory(saleInfo);
		accounting.updateAccounting(saleInfo);
		saleLog.storeSaleInformation(0, saleInfo);
		printReceipt();
		dataHandler.updateObservers(saleInfo);
	}
	
	/**
	 *  Creates the final <code>SaleInformation</code>, that will be used to update the systems
	 *  and databases.
	 
	 * @param change How much change the customer will receive.
	 * @param amountPaid The amount paid by the customer.
	 */
	private void createFinalSaleInformation(Amount change, Amount amountPaid) {
		saleInfo = new SaleInformation(this.saleInfo, change, amountPaid);
	}
	
	private void printReceipt() {
		printer.printReceipt(new Receipt(this.saleInfo));
	}
	

}
