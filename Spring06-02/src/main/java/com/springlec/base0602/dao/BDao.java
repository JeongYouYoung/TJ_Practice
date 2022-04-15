package com.springlec.base0602.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.springlec.base0602.dto.BDto;

public class BDao {

	
	DataSource dataSource;
	
	public BDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
		} catch (Exception e) {
			e.printStackTrace();//개발할때 오류코드보겠다.개발할때만 사용
		}
		
	}
	
	public ArrayList<BDto> list(){
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select bId, bName, bTitle, bContent, bDate from mvc_board";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				int bId =  resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bcontent = resultSet.getString("bcontent");
				Timestamp bDate =  resultSet.getTimestamp("bDate");
				
				BDto dto = new BDto(bId, bName, bTitle, bcontent, bDate);
				dtos.add(dto);
						
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try{
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null)connection.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;		
		
		
	}
	
	
	
}
