package com.iu.jobs;

import java.util.ArrayList;

public class JobView {
	
	public void view(ArrayList<JobDTO> ar) {
		for(JobDTO jdto : ar) {
			
			System.out.println(jdto.getJob_id());
			System.out.println(jdto.getJob_title());
			System.out.println(jdto.getMax_salary());
			System.out.println(jdto.getMin_salary());
			System.out.println("---------------------");
		}
	}

}
