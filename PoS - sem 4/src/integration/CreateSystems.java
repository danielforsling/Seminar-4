package integration;

/**
 * The purpose of this class is to create new instances to all external systems,
 * and to give access to the caller of this instance.
 */
public class CreateSystems {
	
	private ExternalInventorySystem inventory;
	private ExternalAccountingSystem accounting;
	private SaleLog saleLog;
	private DiscountSystem discSys;
	
	/**
	 * Creates an new instance by creating new instances of the external systems.
	 */
	public CreateSystems()
	{
		inventory = new ExternalInventorySystem();
		accounting = new ExternalAccountingSystem();
		saleLog = new SaleLog();
		discSys = new DiscountSystem();
	}

	/**
	 * Returns the {@link ExternalInventorySystem} inventory field. 
	 * 
	 * @return inventory
	 */
	public ExternalInventorySystem getExternalInventorySystem() {
		return inventory;
	}

	/**
	 * Returns the {@link ExternalAccountingSystem} accounting field.
	 *  
	 * @return accounting
	 */
	public ExternalAccountingSystem getExternalAccountingSystem() {
		return accounting;
	}

	/**
	 * Returns the {@link SaleLog} saleLog field. 
	 * 
	 * @return saleLog
	 */
	public SaleLog getSaleLog() {
		return saleLog;
	}

	/**
	 * Returns the {@link DiscountSystem} discSys field. 
	 * @return discSys
	 */
	public DiscountSystem getDiscountSystem() {
		return discSys;
	}

}
