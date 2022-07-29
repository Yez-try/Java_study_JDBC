package com.iu.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class EmployeesDAO {
	
	public void getJoinTest(EmployeesDTO edto) throws Exception{
		//1. DB연결
		Connection con = DBConnector.getConnection();
		
		//2. SQL문 생성
		String sql = "SELECT E.LAST_NAME, E.SALARY, D.DEPARTMENT_NAME "
				+ "FROM EMPLOYEES E "
				+ "    INNER JOIN "
				+ "    DEPARTMENTS D "
				+ "    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID "
				+ "WHERE E.EMPLOYEE_ID = ?";
		
		//3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ? 세팅
		st.setInt(1, edto.getEmployee_id());
		
		//5. 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			edto = new EmployeesDTO();
			edto.setLast_name(rs.getString("LAST_NAME"));
			edto.setSalary(rs.getInt("SALARY"));
			//부서명은 어떻게 하지???
			//상속 불가능 (부서는 사원이다 X, 사원은 부서이다 X)
			//부서는 사원을 가지고 있다(O) => departmentsDTO내에 employeesDTO를 멤버변수로 선언해서 사용하면 적절하다.
			//근데 부서는 사원'들'을 가지고 있으므로 arraylist를 선언해서 사용한다. 
			
			//혹은 이렇게 하나의 값만 받는 경우 각각 edto, Ddto에 받아서 각 dto를 맵이나 어레이리스트에 받아서 리턴한다.
			//근데 뒤로 가면 더 간단하게 쓸 수 있으므로 나중에 걱정하자!
			//나중에는 간단하게 할 수 있지만 순서를 모르면 에러를 고칠 수 없다. 그래서 순서를 알아둬야 한다!
		}
		//6. 연결 해제
		DBConnector.disConnect(rs, st, con);
		
		
	}
	
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
