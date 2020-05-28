/**
 * 
 */
package model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 */
class AmountTest {
	
	private Amount emptyAmount;
	private Amount amtwithValueFive;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		emptyAmount = new Amount();
		amtwithValueFive = new Amount (5);
		

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		emptyAmount =null;
		amtwithValueFive = null;
		
	}

	/**
	 * Test method for {@link model.util.Amount#addAmounts(model.util.Amount)}.
	 */
	@Test
	void testAddAmounts() {
		Amount amountToBeAdded = new Amount(10);
		double expResult = 5 + 10;
		Amount result = amtwithValueFive.addAmounts(amountToBeAdded);
		
		assertEquals(expResult, result.getValue(),"Incorrect value when adding two Amounts. "
						+ "expected result: "+ expResult + "but got " + result.getValue());	
		}

	/**
	 * Test method for {@link model.util.Amount#addDouble(double)}.
	 */
	@Test
	void testAddDouble() {
		double doubleToBeAdded = 10;
		double expResult = 5 + 10;
		Amount result = amtwithValueFive.addDouble(doubleToBeAdded);
		
		assertEquals(expResult, result.getValue(),"Incorrect value when adding two Amounts. ");
	}

	/**
	 * Test method for {@link model.util.Amount#subractCurrentAmount(model.util.Amount)}.
	 */
	@Test
	void testSubractCurrentAmount() {
		Amount biggerValue = new Amount(10);
		Amount expResult =  new Amount (10-5);
		Amount result = amtwithValueFive.subractCurrentAmount(biggerValue);
		
		assertEquals(expResult.getValue(), result.getValue(),"Incorrect value when subtracting two Amounts. ");
	}

	/**
	 * Test method for {@link model.util.Amount#multiplyAmount(int)}.
	 */
	@Test
	void testMultiplyAmount() {
		int numberToBeMultiplied = 5;
		Amount expResult = new Amount(5*5);
		Amount result = amtwithValueFive.multiplyAmount(numberToBeMultiplied);
		
		assertEquals(expResult.getValue(), result.getValue(), "Incorrect value when multiplying two Amounts");
	}

	/**
	 * Test method for {@link model.util.Amount#multiplyAmountDouble(double)}.
	 */
	@Test
	void testMultiplyAmountDouble() {
		double numberToBeMultiplied = 5.5;
		Amount expResult = new Amount(27.5);
		Amount result = amtwithValueFive.multiplyAmountDouble(numberToBeMultiplied);
		
		assertEquals(expResult.getValue(), result.getValue(), "Incorrect value when multiplying a Amount with a double");
	}

	/**
	 * Test method for {@link model.util.Amount#getValue()}.
	 */
	@Test
	void testGetValue() {
		double expResult = 5;
		double result = amtwithValueFive.getValue();
		assertEquals(expResult, result, "Incorrect result when getting the value from a Amount-object");
		
	}

}
