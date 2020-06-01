package controller;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import integration.CreateSystems;
import integration.ExternalInventorySystem;
import integration.ExternalSystemsFailureException;
import integration.InvalidItemIDException;
import integration.ItemDescription;
import integration.Printer;
import model.POS.Sale;
import model.util.TotalPrice;

class ControllerTest {
	private CreateSystems systems; 
	private Printer printer; 
	private Controller controllerToTest;
	
	private ExternalInventorySystem inventory;
	private Sale sale;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}

	@BeforeEach
	void setUp() throws Exception {
		systems = new CreateSystems(); 
		printer  = new Printer(); 
		controllerToTest = new Controller(systems, printer);
		
		this.sale = new Sale();
		this.inventory = systems.getExternalInventorySystem();
	}

	@AfterEach
	void tearDown() throws Exception {
		systems = null;
		printer = null;
		controllerToTest = null;
		sale = null;
	}

	@Test
	void testStartSale() {
		TotalPrice testIfSaleIsInitiated = null; 
		testIfSaleIsInitiated = sale.getTotalPrice();
		boolean expectedToBeTrue = false;
		
		if(testIfSaleIsInitiated != null)
			expectedToBeTrue = true;
		assertTrue(expectedToBeTrue, "Sale is created incorrectly");
	}

	@Test
	void testFindItemInInventory() {
		int itemID = 1010;
		String expectedItemName = "Butter";
		ItemDescription returnedItem = null;
		try {
			returnedItem = inventory.findItem(itemID);
		} catch (InvalidItemIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(expectedItemName, returnedItem.getName(), "Wrong item recieved from inventory.");
	}
	
	@Test
	void testInvalidItemIDException () {
		int invalidItemID = 1111;
		try {
			ItemDescription returnedItem = inventory.findItem(invalidItemID);
			fail("Could find an item with invalid id");
		}catch (InvalidItemIDException e) {
			assertTrue(e.getInvalidItemID() == invalidItemID," Correct Exception thrown");
		} 
	}
	
	@Test 
	void testInvalidItemIDExceptionWithControllerInstance()
						throws OperationFailedException {
		int invalidItemID = 2222;
			try {
				controllerToTest.findItem(invalidItemID, 4);
				fail("Could find an item invalid id");
			}catch (InvalidItemIDException e) {
				assertTrue(e.getInvalidItemID() == invalidItemID," Correct Exception thrown");
			} 
		}
	
	@Test
	void testExternalSystemFailureException () {
		int dbErrorID = 1234;
		ExternalSystemsFailureException expectedException = new ExternalSystemsFailureException("Error message");
		
		try {
			ItemDescription returnedItem = inventory.findItem(dbErrorID);
			fail("Connection works, this message should not be printed.");
		}catch (Exception e) {
			assertTrue(e.getClass().equals(expectedException.getClass())," Correct Exception thrown");
		} 
	}
	
	@Test 
	void testIfControllerMethodThrowsCorrectException()
						throws OperationFailedException {
		
		int dbErrorID = 1234;
		String msg = "Error message";
		ExternalSystemsFailureException innerException = new ExternalSystemsFailureException(msg);
		OperationFailedException expectedException = new OperationFailedException(msg, innerException);
		try {
				controllerToTest.findItem(dbErrorID, 7);
				fail("Connection works, this message should not be printed.");
			}catch (Exception e) {
				assertTrue(e.getClass().equals(expectedException.getClass())," Correct Exception thrown");
			} 
		}
	
	
	

}
