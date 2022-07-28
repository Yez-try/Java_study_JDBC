package com.iu.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class EmployeesDAO {
	
	public void getSalaryInfo() throws Exception{
		//1.DB와 연결
		Connection con = DBConnector.getConnection();
		
		//2.sql문 작성
		String sql = "select sum(salary), avg(salary), max(salary) from employees";
		
		//3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		int sum =0;
		double avg =0;
		int max =0;
		
		
		if(rs.next()) {
			sum = rs.getInt("SUM(SALARY)");
			avg = rs.getDouble("AVG(salary)");
			max = rs.getInt("max(salary)");
		}
		System.out.println(sum+" \t "+avg+" \t"+ max);
		
	}
	
	public EmployeesDTO getRow(int employee_id) throws Exception{
		//1.DB와 연결
		Connection con = DBConnector.getConnection();
		
		//2.sql문 작성
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		
		//3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 셋팅하기
		st.setInt(1, employee_id);
		
		//5.
		ResultSet rs = st.executeQuery();
		
		EmployeesDTO edto = new EmployeesDTO();
		if(rs.next()) {//데이터를 꺼내기 위해서는 next()메서드를 꼭 써줘야한다.
			edto.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			edto.setFirst_name(rs.getString("FIRST_NAME"));
			edto.setLast_name(rs.getString("LAST_NAME"));
			edto.setEmail(rs.getString("EMAIL"));
			edto.setPhone_number(rs.getString("PHONE_NUMBER"));
			edto.setHire_date(rs.getDate("HIRE_DATE"));
			edto.setJob_id(rs.getString("JOB_ID"));
			edto.setSalary(rs.getDouble("SALARY"));
			edto.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			edto.setManager_id(rs.getInt("MANAGER_ID"));
			edto.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
		}
		
		DBConnector.disConnect(rs, st, con);
		return edto;
	}
	
	public ArrayList<EmployeesDTO> getList() throws Exception{
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM EMPLOYEES";
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		ArrayList<EmployeesDTO> ar = new ArrayList<>();
		while(rs.next()) {
			EmployeesDTO edto = new EmployeesDTO();
			
			edto.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			edto.setFirst_name(rs.getString("FIRST_NAME"));
			edto.setLast_name(rs.getString("LAST_NAME"));
			edto.setEmail(rs.getString("EMAIL"));
			edto.setPhone_number(rs.getString("PHONE_NUMBER"));
			edto.setHire_date(rs.getDate("HIRE_DATE"));
			edto.setJob_id(rs.getString("JOB_ID"));
			edto.setSalary(rs.getDouble("SALARY"));
			edto.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			edto.setManager_id(rs.getInt("MANAGER_ID"));
			edto.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			
			ar.add(edto);
		}
		
		DBConnector.disConnect(rs, st, con);
		return ar;
		
	}

}
