package com.iu.test;

import com.iu.countries.CountriesDAO;
import com.iu.countries.CountriesView;
import com.iu.employees.EmployeesDAO;
import com.iu.employees.EmployeesView;
import com.iu.jobs.JobDAO;
import com.iu.jobs.JobView;
import com.iu.regions.RegionsDAO;
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
		
		try {
			edao.getSalaryInfo();
//			cv.view(cdao.getList());
//			cv.view(cdao.getDetail("J"));
//			jv.view(jdao.getList());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		try {
//			cdao.getList();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}//메인 메서드 종료
}//클래스 종료
