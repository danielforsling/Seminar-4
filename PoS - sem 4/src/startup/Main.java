package startup;

import controller.Controller;
import integration.CreateSystems;
import integration.Printer;
import view.View;
/**
 *	Starts the entire application. 
 */
public class Main {

	/**
	 * The main method used to start the application. 
	 * 
	 * @param args The application does not take any command line parameters.
	 */
	public static void main(String[] args) {

		CreateSystems system = new CreateSystems();
		Printer printer = new Printer();
		Controller controller = new Controller(system, printer);
		View view = new View(controller);
		
		view.userTestRun();
	}

}

