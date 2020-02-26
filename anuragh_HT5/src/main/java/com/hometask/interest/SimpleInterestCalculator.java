package com.hometask.interest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleInterestCalculator implements InterestCalculator{

	private static final Logger logger=LogManager.getLogger(SimpleInterestCalculator.class);
	
	@Override
	public double calculate(Data interestData) {
		logger.info("Calculating Simple Interest..!");
		return (interestData.getPrinciple()*interestData.getRateOfInterest()*interestData.getTimePeriod())/100;
	}
}
