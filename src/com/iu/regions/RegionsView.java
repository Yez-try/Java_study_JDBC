package com.iu.regions;

import java.util.ArrayList;

public class RegionsView {

	//출력
	public void view(ArrayList<RegionsDTO> ar) {
		
		System.out.println("REGION_ID \tREGION_NAME");
		System.out.println("--------------------------------------");
		for(RegionsDTO rdto : ar) {
			System.out.print("\t");
			this.view(rdto);			
		}
		
	}
	
	public void view(RegionsDTO rdto) {
		System.out.println(rdto.getRegion_id()+"\t" + rdto.getRegion_name());
	}
	
	
	
}
