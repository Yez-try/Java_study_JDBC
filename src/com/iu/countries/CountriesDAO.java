package com.iu.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class CountriesDAO {
	
	public CountriesDTO getDetail(String country_id) throws Exception{
		//1. 로그인하고 DB연결하기
		Connection con = DBConnector.getConnection();
		
		//2. SQL문 전달
		String sql = "select * from countries where country_id=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		//3. 변수값 세팅 후 전송
		st.setString(1, country_id);
		
		ResultSet rs = st.executeQuery();
		
		//4. 결과 처리
		
		CountriesDTO cdto = new CountriesDTO();
		if(rs.next()) {
			
			cdto.setCountry_id(rs.getString("COUNTRY_ID"));
			cdto.setCountry_name(rs.getString("COUNTRY_NAME"));
			cdto.setRegion_id(rs.getInt("REGION_ID"));

		}
		DBConnector.disConnect(rs, st, con);
		
		return cdto;
	}
	
	public ArrayList<CountriesDTO> getList() throws Exception {
		//로그인하고 DB연결하기
		Connection con = DBConnector.getConnection();
		
		//쿼리문 전달
		String sql = "SELECT * FROM COUNTRIES";
		PreparedStatement st = con.prepareStatement(sql);
		
		//전송후 결과처리
		ResultSet rs = st.executeQuery();
		
		ArrayList<CountriesDTO> ar = new ArrayList<>();
		while(rs.next()) {//순서가 유지되지 않는다. 꺼내올때 정렬해서 꺼내와야함
			CountriesDTO cdto = new CountriesDTO();
			
			cdto.setCountry_id(rs.getString("COUNTRY_ID"));
			cdto.setCountry_name(rs.getString("COUNTRY_NAME"));
			cdto.setRegion_id(rs.getInt("REGION_ID"));
			
			ar.add(cdto);
		}
		
		DBConnector.disConnect(rs, st, con);
		return ar;
	}

}
