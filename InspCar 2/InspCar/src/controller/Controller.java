package controller;

import integration.*;
import model.*;

/**
 * 
 * This is the application's only controller class.
 * All calls to the model pass through here.
 *
 */

public class Controller {
	
	private Printer printer;
	private DatabaseManager databaseManager;
	
	public Controller(Printer printer, DatabaseManager databaseManager) {
		this.printer = printer;
		this.databaseManager = databaseManager;
	}
	
	Garage garage = new Garage();
	
	/**
	 * 
	 */
	
	public void callInNextCustomer(){
		garage.nextCustomer();
		garage.closeDoor();
	}
	
	public Amount enterRegNo(String regNo){
		Inspection inspection = new Inspection(regNo, databaseManager, printer);
		
		return inspection.calculateCost();
	}
}
