package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.javalec.bbs.dto.BDto;

public class BDao {

	//비어 있는 생성자는 만들어 놓는게 좋다 라는 이유가 여기 있쑵다
	//DataSource  ==>  javax.sql로 불러와야 함. 톰캣 아님!!
	DataSource dataSource;
	
	
	//DB연결.-------------------------------------------------------------
	//DAO : DB에서 데이터를 가져오는 애
	//DTO : 데이터를(줄) 전달해줄 애
	public BDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		}catch (Exception e) {
			e.printStackTrace();
		}
	//--------------------------------------------------------------------	
	}
	
	
	//전체검색.
	//메소드를 하나 만들어야함. 
	//검색이 제일 복잡함.
	//list--------------------------------------------------------------------------------
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
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle"); 
				String bContent = resultSet.getString("bContent");
			    Timestamp bDate = resultSet.getTimestamp("bDate");
				
				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate);
				dtos.add(dto);//ArrayList add!!!!
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null)resultSet.close();
				if(preparedStatement !=null)preparedStatement.close();
				if(connection != null)connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}return dtos;
	
	
	}
	
	//write-----------------------------------------------------------------------------
	public void write(String bName, String bTitle, String bContent) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into mvc_board (bName, bTitle, bContent, bDate) values (?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			
			
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
			
		//contentView---------------------------------------------------------------------------
		public BDto contentView(String sbId) {
			BDto dto = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			
			
			try {
				connection = dataSource.getConnection();
				String query = "select * from mvc_board where bId = ?";
				preparedStatement  = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(sbId));
				resultSet = preparedStatement.executeQuery();
				
				//한번만 돌릴땐 if
				if(resultSet.next()) {
					int bId = resultSet.getInt("bId");
					String bName = resultSet.getString("bName");
					String bTitle = resultSet.getString("bTitle"); 
					String bContent = resultSet.getString("bContent");
				    Timestamp bDate = resultSet.getTimestamp("bDate");
					
					dto = new BDto(bId, bName, bTitle, bContent, bDate);
				
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(resultSet != null)resultSet.close();
					if(preparedStatement !=null)preparedStatement.close();
					if(connection != null)connection.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}return dto;
		

	} 

		//modify---------------------------------------------------------------

		public void modify(String bName, String bTitle, String bContent, int bId) {
			BDto dto = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
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
		
		//Delete------------------------------------------------------------------------------------
		
		public void delete(int bId) {
			BDto dto = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
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



