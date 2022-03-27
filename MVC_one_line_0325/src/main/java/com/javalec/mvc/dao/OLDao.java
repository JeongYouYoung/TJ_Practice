package com.javalec.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.mvc.dto.OLDto;

public class OLDao {
	
	DataSource dataSource;
	
	
	//DB연결-----------------------------------------------------------------------
	
	public OLDao() {
		try {
			Context context = new InitialContext();//context javax.naming로 불러와야 하네
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/one_line");
		} catch (Exception e) {
			e.printStackTrace();
		}
	//------------------------------------------------------------------------------------
	}
	
	public ArrayList<OLDto> list(){
		
		ArrayList<OLDto> dtos = new ArrayList<OLDto>();
		
		Connection connection = null;
		PreparedStatement prepareStatement= null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select bId, bName, bTitle, bDate from board";//SQL문 확인.
			prepareStatement = connection.prepareStatement(query);	//prepareStatement : 쿼리에 인자를 부여
			resultSet = prepareStatement.executeQuery(); 			//execteQuery : DB에 명령
																	//ResultSet : 명령에 대한 반환값.
			
			while (resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle"); 
			    Timestamp bDate = resultSet.getTimestamp("bDate");
				
				OLDto dto = new OLDto(bId, bName, bTitle, bDate);
				dtos.add(dto);	//ArrayList add!

				}
		}catch (Exception e) {
					e.printStackTrace();
		}finally {
			try {
				if(resultSet != null)resultSet.close();
				if(prepareStatement != null)prepareStatement.close();
				if(connection != null)connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		
		}return dtos;
				
		
		
	}
	//-------------------------------------------------------------------------------
	public void write(String bName, String bTitle) {
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into board (bName, bTitle, bDate) values (?,?,now())";//SQL확인
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			
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
	//-------------------------------------------------------------------------------
	public void delete(int bId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	
	
	try {
		connection = dataSource.getConnection();
		String query = "delete from board where bId = ?";//SQL확인
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
	
	
	
	

