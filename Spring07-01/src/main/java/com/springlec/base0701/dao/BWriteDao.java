package com.springlec.base0701.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.springlec.base0701.util.Constant;

public class BWriteDao {

	JdbcTemplate template;
	
	public BWriteDao() {
		
		this.template = Constant.template;}
	
		public void write(final String bName, final String bTitle, final String bContent){
	
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String query = "insert into mvc_board (bName, bTitle, bContent, bDate) values (?,?,?,now())";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1,bName);
				pstmt.setString(2,bTitle);
				pstmt.setString(3,bContent);
				return pstmt;
			}
		});
		
		
		
		}
}

