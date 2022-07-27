package com.iu.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class EmployeesDAO {
	
	public EmployeesDTO getRow(int employee_id) throws Exception{
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, employee_id);
		
		ResultSet rs = st.executeQuery();
		
		EmployeesDTO edto = new EmployeesDTO();
		if(rs.next()) {
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
		
		return edto;
	}
	
	public ArrayList<EmployeesDTO> getList() throws Exception{
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM EMPLOYEES";
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.getResultSet();
		
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
