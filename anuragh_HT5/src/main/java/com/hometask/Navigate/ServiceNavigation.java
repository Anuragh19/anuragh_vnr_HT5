package com.hometask.Navigate;
import com.hometask.construction.*;
import com.hometask.interest.*;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServiceNavigation {
	private static final Logger logger=LogManager.getLogger(ServiceNavigation.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    int option=0;
		Scanner input=new Scanner(System.in);
		logger.info("Displaying menu in Service Navigation class");
		logger.info("Enter 1 to activate Interest Service 2 to activate Construction cost Service");
		// 1 for Interest 2 for Construction
		try {
			option=input.nextInt();
		}
		catch(Exception e) {
			logger.error(e);
		}
		if(option==1) {
			//navigating to Interest Service
			logger.info("You have selected option 1");
			logger.info("Navigating you to Interest Calculator Service");
			InterestService interestService=new InterestService();
			//reading input
			interestService.getDataFromInput(input);
			
			if(interestService.isFlag()) {
				interestService.calculateSimpleInterest();
				logger.info("Simple Interest = "+interestService.getSimpleInterest());
				
				interestService.calculateCompoundInterest();
				logger.info("Compound Interest = "+interestService.getCompoundInterest());
			}
			else {
				logger.info("Couldn't process Interest Calculations because of invalid input!");
			}
			logger.info("Exiting from Interest Calculator Service");
		}
		else if(option==2) {
			//navigating to Construction Service
			logger.info("You have selected option 2");
			logger.info("Navigating you to Construction Cost Calculator Service");
			ConstructionCostService constructionService=new ConstructionCostService();
			
			Material material=new Material();
			material.setMaterials();
			
			constructionService.setMaterials(material.getMaterials());
			
			constructionService.getDataFromInput(input);
			if(!constructionService.isInputexception()) {
				constructionService.calculateCost();
				if(constructionService.isFlag()) {
					logger.info("Construction Cost = "+constructionService.getConstructionCost());	
				}	
				else {
					logger.info("Couldn't process Construction cost calculation as inputted material is not found!");
				}
			}
			else {
				logger.info("Couldn't process Interest Calculations because of invalid input!");
			}
			logger.info("Exiting from Construction Cost Calculator Service");
		}
		else {
			//Invalid Entry
			logger.warn("Entered an Invalid Option!");
		}
		logger.info("Exiting from Service Navigation class");
	}

}
