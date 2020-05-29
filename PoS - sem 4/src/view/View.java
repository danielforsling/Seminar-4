package view;

import controller.Controller;
import controller.OperationFailedException;
import integration.InvalidItemIDException;
import log.ExceptionLogHandler;
import model.DTO.PresentSaleDTO;
import model.DTO.SaleInformation;
import model.util.Amount;

import java.io.IOException;
import java.util.Scanner;

/**
 *	This class represents the User Interface in the application. 
 *
 */
public class View {
	
	Controller controller;
	DisplayErrorMessage errorMessages = new DisplayErrorMessage();
	ExceptionLogHandler errorLog;
	
	/**
	 * Creates a new instance.
	 * @param controller
	 * @throws IOException if failed to initiate the error-log.
	 */
	public View(Controller controller) throws IOException {
		this.controller = controller;
		this.errorLog = new ExceptionLogHandler();
		
	}

	/**
	 * 
	 * This method simulates a purchase. The user enters the id of the item, and 
	 * the quantity of that item. To end the input of item, enter "0".
	 * 
	 * The available items to enter are:
	 * 1010 - Butter
	 * 2020 - Bread
	 * 3030 - Flour
	 * 4040 - Pasta
	 * 5050 - Coffee
	 * 6060 - Cheese
	 * 
	 * 1234 - to simulate database-error
	 * 
	 */
	public void userTestRun() {
		
		Scanner input = new Scanner(System.in);
		
		controller.startSale();
		userScanningItems();
		SaleInformation saleInfo = controller.stopSale();
		System.out.println("Checking discount...");
		System.out.println("\nTotal price: " + 
				controller.checkDiscount(0, saleInfo).getFinalPrice());
		System.out.println("Enter amount paid in cash: ");
		int amountPaid = input.nextInt();
		System.out.println("Printing Receipt...\n");
		controller.enterAmountPaid(new Amount(amountPaid));
	}
	
	private void userScanningItems() {
		Scanner input = new Scanner(System.in);
		PresentSaleDTO displaySale = null;
		
		int itemID = 1;
		int quantity = 1;
		
		while(itemID!= 0) {
			System.out.println("Enter itemID: ");
			itemID = input.nextInt(); 
			
			if(itemID==0)
				break;
			
			System.out.println("No of items: ");
			quantity = input.nextInt(); 
			
			if(quantity>0) {
				try {
					displaySale = controller.findItem(itemID, quantity);
				} catch(InvalidItemIDException e) {
					errorMessages.showErrorMessage(e.getMessage());					
				} catch(OperationFailedException oe) {
					LocalExceptionHandler("Operation failed", oe);
				}
			}
				
			else
				displaySale = null;
			
			if(displaySale!=null)
				System.out.println(displaySale.toString());
		}
	}
	
	private void LocalExceptionHandler(String message, Exception e) {
		errorMessages.showErrorMessage(message);
		errorLog.printExceptionToFile(e);
	}
}
