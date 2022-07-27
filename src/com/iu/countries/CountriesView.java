package com.iu.countries;

import java.util.ArrayList;

public class CountriesView {
	
	public void view(ArrayList<CountriesDTO> ar) {
		
		System.out.println("COUNTRY_ID \tCOUNTRY_NAME \t\tREGION_ID");
		System.out.println("-------------------------------------------------------------");
		for(CountriesDTO cdto:ar) {
			this.view(cdto);
			System.out.println();
		}
	}
	
	public void view(CountriesDTO cdto) {
		System.out.print(cdto.getCountry_id()+"\t\t");
		System.out.printf("%-25s\t",cdto.getCountry_name());
		System.out.print('\t'+cdto.getRegion_id());
		
	}

}
