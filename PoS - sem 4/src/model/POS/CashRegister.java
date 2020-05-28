package model.POS;

import model.util.Amount;
/**
 * Represents a cash-register in a POS.
 *
 */
public class CashRegister {
	
	private Amount storedAmount;
	
	/**
	 * Creates a new instance with the {@link Amount} of 5000.
	 */
	public CashRegister() {
		storedAmount= new Amount(5000);
	}

	/**
	 * Updates the <code>Amount</code> of cash stored in the register.
	 * 
	 * @param cash represents the amount to be added
	 */
	public void updateAmountStored(Amount cash) {
		storedAmount = storedAmount.addAmounts(cash);
	}
	
	
}
