package com.springlec.base0601.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BDeleteDao {

DataSource dataSource;
	
	public BDeleteDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
		} catch (Exception e) {
			e.printStackTrace();/*개발할때 오류코드보겠다.개발할때만 사용*/
		}
		
	}
	public void delete(int bId){
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "delete from mvc_board where bId =?";
			preparedStatement = connection.prepareStatement(query);
			
			
			preparedStatement.setInt(1, bId);
			
			preparedStatement.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
}
}
