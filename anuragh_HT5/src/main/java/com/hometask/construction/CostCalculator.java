package com.hometask.construction;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CostCalculator {

	private static final Logger logger=LogManager.getLogger(CostCalculator.class);
	private Double costPerSquareFeet;
	private boolean flag=true;
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public Double calculate(Data constructionData,Map<String,Double> materials) {
		logger.info("Calculating the Construction Cost...!");
		try {
			if(materials.get(constructionData.getMaterialType().toLowerCase())==null) {
				logger.warn("The inputed material type is unavaiable");
				this.setFlag(false);
				return (double) 0;
			}
			costPerSquareFeet=materials.get(constructionData.getMaterialType().toLowerCase());
		}
		catch(Exception e) {
			logger.error(e);
		}
		return (costPerSquareFeet*(constructionData.getArea()));
	}
}
