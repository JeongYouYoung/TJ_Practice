package com.springlec.base0601.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.springlec.base0601.dto.BDto;

public class BModifyDao {

DataSource dataSource;
	
	public BModifyDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
		} catch (Exception e) {
			e.printStackTrace();/*개발할때 오류코드보겠다.개발할때만 사용*/
		}
		
	}
	public void modify(String bName, String bTitle, String bContent, int bId){
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "update mvc_board set bName =?, bTitle =?, bContent =? where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setInt(4, bId);
			
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
