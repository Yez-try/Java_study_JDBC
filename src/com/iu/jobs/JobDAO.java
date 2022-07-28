package com.iu.jobs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class JobDAO {
	
	public ArrayList<JobDTO> getList() throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "select * from jobs";
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		
		ArrayList<JobDTO> ar = new ArrayList<>();
		while(rs.next()) {
			JobDTO jdto = new JobDTO();
			
			jdto.setJob_id(rs.getString("JOB_ID"));
			jdto.setJob_title(rs.getString("JOB_TITLE"));
			jdto.setMax_salary(rs.getInt("MAX_SALARY"));
			jdto.setMin_salary(rs.getInt("MIN_SALARY"));
			
			ar.add(jdto);
		}
		
		DBConnector.disConnect(rs, st, con);
		return ar;
	}

}
