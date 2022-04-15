package com.springlec.base0701.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.springlec.base0701.util.Constant;

public class BDeleteDao {

	JdbcTemplate template;
	
	public BDeleteDao() {
		this.template = Constant.template;
	}
	public void delete(final int bId){
	
		String query = "delete from mvc_board where bId =?";	
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, bId);
			}
		});
		
}
}
