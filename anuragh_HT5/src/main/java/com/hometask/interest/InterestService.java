package com.hometask.interest;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InterestService {

	private Data interestData;
	private double simpleInterest,compoundInterest;
	private boolean flag=true;
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	private static final Logger logger=LogManager.getLogger(InterestService.class);
	public double getSimpleInterest() {
		return simpleInterest;
	}
	public void setSimpleInterest(double simpleInterest) {
		this.simpleInterest = simpleInterest;
	}
	public double getCompoundInterest() {
		return compoundInterest;
	}
	public void setCompoundInterest(double compoundInterest) {
		this.compoundInterest = compoundInterest;
	}
	public void getDataFromInput(Scanner input) {
		
		logger.info("Entered into getDataFromInput Function in Interest Calculator Service Class");
		logger.info("Reading Principle, Rate of Interest and Time period from User Input");
		this.interestData=new Data();
		
		try {
			//input for Principle (P)
			this.interestData.setPrinciple(input.nextDouble());
			//input for RateOfInterest (R)
			this.interestData.setRateOfInterest(input.nextDouble());
			//input for Time Period (T)
			this.interestData.setTimePeriod(input.nextDouble());
		}
		catch(Exception e) {
			logger.error(e);
			this.setFlag(false);
		}
		finally {
			if(this.isFlag()) {
				logger.info("The Values inputed are:");
				logger.info("Principle value = "+this.interestData.getPrinciple());
				logger.info("Rate of Interest value = "+this.interestData.getRateOfInterest());
				logger.info("Time Period = "+this.interestData.getTimePeriod());
			}
			logger.info("Exited from getDataFromInput Function in Interest Calculator Service Class");
		}
	}
	public Data getInterestData() {
		return interestData;
	}
	public void setInterestData(Data interestData) {
		this.interestData = interestData;
	}
	public void calculateSimpleInterest() {
		
		InterestCalculator simpleInterestCalculator=new SimpleInterestCalculator();
		this.setSimpleInterest(simpleInterestCalculator.calculate(interestData));
	}
	public void calculateCompoundInterest() {
		InterestCalculator compoundInterestCalculator=new CompoundInterestCalculator();
		this.setCompoundInterest(compoundInterestCalculator.calculate(interestData));
	}
}
