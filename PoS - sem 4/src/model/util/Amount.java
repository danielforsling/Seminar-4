package model.util;

/**
 * This class represent the amount of money used in the application. 
 *
 */
public class Amount {
	
	private final double amount;
	
	/**
	 *  Creates an instance of this class with default constructor. Sets the value to <code>0</code>.
	 */
	public Amount() {
		this(0);
	}
	
	/**
	 *  Creates an new instance of this class using a <code>double</code>.
	 *  
	 * @param amount Represent the value of the new instance.
	 */
	public Amount(double amount) {
		this.amount = amount;
	}
	
	/**
	 * Adds another <code>Amount</code> to the current instance of this class.
	 * 
	 * @param other Represents the <code>Amount</code> that will be added.
	 * 
	 * @return the new updated amount
	 */
	public Amount addAmounts(Amount other) {
        return new Amount(this.amount + other.amount);
    }
	
	public Amount addDouble(double value) {
		return new Amount(this.amount +value);
	}
	
	/**
	 * Subtracts the current instance from another <code>Amount</code>-object.
	 * 
	 * @param biggerAmount The <code>Amount</code> that the current instance will be subtracted from.
	 * @return The new updated <code>Amount</code>.
	 */
	public Amount subractCurrentAmount(Amount biggerAmount) {
        return new Amount(biggerAmount.amount - amount);
    }
	
	/**
	 * Multiply the current instance with the <code>int</code>-parameter.
	 * 
	 * @param number The number of times the current instance will be multiplied.
	 * @return The new updated <code>Amount</code>.
	 */
	public Amount multiplyAmount(int number) {
        return new Amount(amount * number);
    }
	
	/**
	 * Multiply the current instance with the <code>double</code>-parameter.
	 * 
	 * @param number The number of times the current instance will be multiplied.
	 * @return The new updated <code>Amount</code>.
	 */
	public Amount multiplyAmountDouble(double number) {
	//	BigDecimal exactValue = new BigDecimal(number);
	//	System.out.println("MAD:\n amount: " + amount + "VAT: "+ exactValue + "\nequals ");
        return new Amount(amount * number);
    }
	
	/**
	 * Get the value that the current instance represents.
	 * 
	 * @return The value as a <code>double</code>.
	 */
	public double getValue() {
		return amount;
	}
	
	/**
	 * Returns the instance as a <code>String</code>-representation.
	 */
	@Override
	public String toString()
	{
		return Double.toString(amount);
	}
}
