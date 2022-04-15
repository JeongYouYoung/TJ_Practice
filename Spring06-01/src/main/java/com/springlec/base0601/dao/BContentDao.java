package com.springlec.base0601.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.springlec.base0601.dto.BDto;

public class BContentDao {
	
	DataSource dataSource;
	
	public BContentDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
		} catch (Exception e) {
			e.printStackTrace();/*개발할때 오류코드보겠다.개발할때만 사용*/
		}
		
	}
	public BDto contentView(int bId2){
		
		BDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "Select * from mvc_board where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, bId2);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
					int bId = resultSet.getInt("bId");
					String bName = resultSet.getString("bName");
					String bTitle = resultSet.getString("bTitle");
					String bContent = resultSet.getString("bContent");
					Timestamp bDate = resultSet.getTimestamp("bDate");
					
					dto = new BDto(bId, bName, bTitle, bContent, bDate);
					System.out.println(bId+bName+bTitle+bContent+bDate);
					
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}return dto;
			
}
}
