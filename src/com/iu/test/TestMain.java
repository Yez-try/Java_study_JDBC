package com.iu.test;

import com.iu.countries.CountriesDAO;
import com.iu.countries.CountriesDTO;
import com.iu.countries.CountriesView;
import com.iu.employees.EmployeesDAO;
import com.iu.employees.EmployeesView;
import com.iu.jobs.JobDAO;
import com.iu.jobs.JobView;
import com.iu.regions.RegionsDAO;
import com.iu.regions.RegionsDTO;
import com.iu.regions.RegionsView;
import com.iu.util.DBConnector;

public class TestMain {

	public static void main(String[] args) {
		CountriesDAO cdao = new CountriesDAO();
		CountriesView cv = new CountriesView();
		RegionsDAO rdao = new RegionsDAO();
		RegionsView rv = new RegionsView();
		EmployeesDAO edao = new EmployeesDAO();
		EmployeesView ev = new EmployeesView();
		JobDAO jdao = new JobDAO();
		JobView jv = new JobView();
		
//		try {
//			DBConnector.getConnection();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		try {
//			rv.view(rdao.getList());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			edao.getSalaryInfo();
//			cv.view(cdao.getList());
//			cv.view(cdao.getDetail("J"));
//			jv.view(jdao.getList());
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
//		try {
//			cdao.getList();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//insert 테스트하기
//		RegionsDTO regionsDTO = new RegionsDTO();
//		regionsDTO.setRegion_id(6);
//		regionsDTO.setRegion_name("Mars");
		
		CountriesDTO cdto = new CountriesDTO();
		cdto.setCountry_id("NK");
		cdto.setCountry_name("North Korea");
		cdto.setRegion_id(3);
		try {
//			int result = rdao.setRegion(regionsDTO);
			int result = cdao.setCountry(cdto);
			if(result > 0) {
				System.out.println("성공"+result+"개");
			}else {
				System.out.println("실패");
			}
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}//메인 메서드 종료
}//클래스 종료
