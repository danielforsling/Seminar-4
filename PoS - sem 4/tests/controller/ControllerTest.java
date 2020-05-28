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
import integration.InvalidItemIDException;
import integration.ItemDescription;
import integration.Printer;
import model.POS.Sale;
import model.util.TotalPrice;

class ControllerTest {
	private CreateSystems systems = new CreateSystems(); 
	private Printer printer  = new Printer(); 
	private Controller controllerToTest = new Controller(systems, printer);
	
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
	

}
