package com.hometask.interest;
import java.lang.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CompoundInterestCalculator implements InterestCalculator{

	private static final Logger logger=LogManager.getLogger(CompoundInterestCalculator.class);

	@Override
	public double calculate(Data interestData) {
		logger.info("Calculating Compound Interest..!");
		return ((interestData.getPrinciple())*(Math.pow((1+(interestData.getRateOfInterest())/100), interestData.getTimePeriod()))-interestData.getPrinciple());
	}
}
