package model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TotalPriceTest {
	
	TotalPrice totalPriceEmpty;
	TotalPrice totalPriceWithValueTenInBothFields;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		totalPriceEmpty = new TotalPrice();
		totalPriceWithValueTenInBothFields = new TotalPrice();
		totalPriceWithValueTenInBothFields.addToTotalPrice(new Amount(10));
		totalPriceWithValueTenInBothFields.addToTotalVAT(new Amount(10));
	}

	@AfterEach
	void tearDown() throws Exception {
		totalPriceEmpty = null;
		totalPriceWithValueTenInBothFields = null;
	}



	@Test
	void testAddToTotalPrice() {
		
		Amount amtToBeAdded = new Amount(1000);
		double expResult = 1000;
		totalPriceEmpty.addToTotalPrice(amtToBeAdded);
		double result = totalPriceEmpty.getPriceWithoutVAT().getValue();
		
		assertEquals(expResult, result, "Incorrect value when adding to the total price.");
	}
	
	@Test
	void testAddToTotalPriceWhenNotEmpty() {
		
		Amount amtToBeAdded = new Amount(333);
		double expResult = 343;
		totalPriceWithValueTenInBothFields.addToTotalPrice(amtToBeAdded);
		double result = totalPriceWithValueTenInBothFields.getPriceWithoutVAT().getValue();
		
		assertEquals(expResult, result, "Incorrect value when adding to the total price.");
	}

	@Test
	void testAddToTotalVAT() {
		Amount amtToBeAdded = new Amount(4.25);
		double expResult = 4.25;
		totalPriceEmpty.addToTotalVAT(amtToBeAdded);
		double result = totalPriceEmpty.getTotalVAT().getValue();
		
		assertEquals(expResult, result, "Incorrect value when adding to the total VAT.");
	}
	
	@Test
	void testAddToTotalVATWhenNotEmpty() {
		
		Amount amtToBeAdded = new Amount(10.33);
		double expResult = 20.33;
		totalPriceWithValueTenInBothFields.addToTotalVAT(amtToBeAdded);
		double result = totalPriceWithValueTenInBothFields.getTotalVAT().getValue();
		
		assertEquals(expResult, result, "Incorrect value when adding to the total VAT.");
	}

	@Test
	void testGetFinalPrice() {
		double expResult = 20;
		double result = totalPriceWithValueTenInBothFields.getFinalPrice().getValue();
		assertEquals(expResult, result, "Incorrect value when adding the two fields to get final total price.");
	}

}
