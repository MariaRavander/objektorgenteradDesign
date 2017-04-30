package model;

import integration.*;
import java.util.*;

/**
 * This class collects all inspection tasks and calculates the total cost of the entire inspection 
 * for the specified vehicle.
 */
public class Inspection {
	
	private String regNo;
	private InspectionResult inspectionResult;
	private List<InspectionChecklist> inspectionList = new ArrayList<>();
	
	
/**
 * Creates an instance of an inspection containing the inspection tasks with it's inspection results.
 * 
 * @param regNo The registration number of the specified vehicle.
 * @param databaseManager The database manager to use when searching for inspections for the specified vehicle.
 * @param printer The printer that is being used when printing the inspection result.
 */
	
	public Inspection(String regNo, DatabaseManager databaseManager, Printer printer){
		this.regNo = regNo;
		this.inspectionList = databaseManager.getInspections(regNo);
		InspectionResult result = new InspectionResult(regNo, inspectionList);
		this.inspectionResult = result;
	}
	

/**
 * 
 * @return Returns the total cost of the inspection.
 */
	public Amount calculateCost(){
		int totalCost = 0;
		for(InspectionChecklist inspList : inspectionList){
			totalCost = totalCost + inspList.getCost();
		}
		
		Amount cost = new Amount (totalCost);
		return cost;
	}
}