package com.hometask.construction;

import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConstructionCostService {

	private static final Logger logger=LogManager.getLogger(ConstructionCostService.class);
	private boolean flag=true,inputexception=false;
	private Data constructionData;
	private Double constructionCost;
	private Map<String,Double>materials;
	public Data getConstructionData() {
		return constructionData;
	}
	public boolean isInputexception() {
		return inputexception;
	}
	public void setInputexception(boolean inputexception) {
		this.inputexception = inputexception;
	}
	public void setConstructionData(Data constructionData) {
		this.constructionData = constructionData;
	}
	public Double getConstructionCost() {
		return constructionCost;
	}
	public void setConstructionCost(Double constructionCost) {
		this.constructionCost = constructionCost;
	}
	public void getDataFromInput(Scanner input) {
		
		logger.info("Entered into getDataFromInput Function in ConstructionCost Calculator Service Class");
		logger.info("Reading Area and Material type from User Input");
		
		this.constructionData=new Data();
		
		try {
			//input for area
			this.constructionData.setArea(input.nextDouble());
			
			input.nextLine();
			
			//input for material type
			this.constructionData.setMaterialType(input.nextLine());
		}
		catch(Exception e) {
			logger.error(e);
			this.setInputexception(true);
		}
		finally {
			if(!this.isInputexception()) {
				logger.info("The Values inputed are:");
				logger.info("Area value = "+this.constructionData.getArea());
				logger.info("Material Type= "+this.constructionData.getMaterialType());	
			}
			logger.info("Exited from getDataFromInput Function in ConstructionCost Calculator Service Class");
		}
	}
	public void calculateCost() {
		CostCalculator costCalculator = new CostCalculator();
		this.setConstructionCost(costCalculator.calculate(this.constructionData, materials));
		this.setFlag(costCalculator.isFlag());
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public void setMaterials(Map<String,Double> materials) {
		this.materials = materials;
	}
}
