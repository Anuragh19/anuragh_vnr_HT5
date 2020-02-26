package com.hometask.construction;

import java.util.HashMap;
import java.util.Map;

public class Material {

	Map<String,Double> materials;
	
	public void setMaterials() {
		
		materials=new HashMap<String, Double>();
		materials.put("standard materials", (double) 1200);
		materials.put("above standard materials", (double) 1500);
		materials.put("high standard materials", (double) 1800);
		materials.put("high standard materials and fully automated", (double) 2500);
	}

	public Map<String, Double> getMaterials() {
		return materials;
	}
}
