package com.iu.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class RegionsDAO  {
	
	//1.Regions의 모든 데이터 가져오기
	
	public ArrayList<RegionsDTO> getList() throws Exception {
		//DB에 접근해서 가져오려고 해
		//1. 로그인하고 DB연결하기
		Connection con = DBConnector.getConnection();
		
		//2. Query문 작성
		String sql = "SELECT * FROM REGIONS"; //자바에서 쓸때는 자동으로 세미콜론이 붙으므로 붙이지 않는다.
		//이 쿼리문을 Connection한테 보내 DB한테 보낸다.
		
		//3. Query문 미리 전달
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. 최종전송 후 결과를 처리
		ResultSet rs = st.executeQuery();
		
		ArrayList<RegionsDTO> ar = new ArrayList<>();
		while(rs.next()){//한줄을 읽으세요. true면 데이터가 있다는 의미
			//SQL에서의 데이터 타입을 확인하고 해당 타입을 반환받는다.
			
			RegionsDTO rdto = new RegionsDTO();
			rdto.setRegion_id(rs.getInt("REGION_ID"));
			rdto.setRegion_name(rs.getString("REGION_NAME"));
			ar.add(rdto);
		}
		
		return ar;
		
	}//getList()메서드 종료
	
	public RegionsDTO getDetail(int regionId) throws Exception{
		
		//1.DB연결
		Connection con = DBConnector.getConnection();
		
		//2.SQL문 미리 작성해 전송
//		String sql = "SELECT * FROM regions where region_id ="+region_id; //이렇게 하면 sql 인젝션으로 바로 뚫리는 방식
		String sql = "select * from regions where region_id=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		//3.?값 세팅
		st.setInt(/*int parameterIndex: 몇번째 물음표냐, 오라클은 1번부터 시작한다*/1, regionId);
		//ex. where num between ?(1) and ?(2);라고 하면 앞은 1번 뒤는 2번임
		
		//4.최종 전송
		ResultSet rs = st.executeQuery();
		
		//5.결과 처리
		//만약 region_id값이 없다면 값을 가져올 수 없게된다.
		
		RegionsDTO rdto = new RegionsDTO();
		if(rs.next()) {
			int rId = rs.getInt(1); //오라클은 1번부터 시작
			String rName = rs.getString(2);
			
			rdto.setRegion_id(regionId);
			rdto.setRegion_name(rName);
			
		}
		return rdto;

	}

}
