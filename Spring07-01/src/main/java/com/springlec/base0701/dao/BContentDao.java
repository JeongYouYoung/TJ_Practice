package com.springlec.base0701.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springlec.base0701.dto.BDto;
import com.springlec.base0701.util.Constant;

public class BContentDao {
	
	JdbcTemplate template;
	
	public BContentDao() {
		this.template = Constant.template;
		
	}

	public BDto contentView(int bId){
		
		String query = "Select * from mvc_board where bId = " + bId;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
						/*하나만 불러올때 쓰임.*/
		

}
}
