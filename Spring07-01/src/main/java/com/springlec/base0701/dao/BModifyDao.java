package com.springlec.base0701.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.springlec.base0701.util.Constant;

public class BModifyDao {

	JdbcTemplate template;
	
	public BModifyDao() {
		
		this.template = Constant.template;
		}
		
	public void modify(final String bName, final String bTitle, final String bContent,final int bId){
		String query = "update mvc_board set bName =?, bTitle =?, bContent =? where bId = ?";
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, bId);
			}
		});
		
		
	
			
}
}
