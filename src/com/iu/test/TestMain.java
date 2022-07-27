package com.iu.test;

import com.iu.util.DBConnector;

public class TestMain {

	public static void main(String[] args) {
		
		DBConnector dbc = new DBConnector();
		
		try {
			dbc.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//메인 메서드 종료
}//클래스 종료
