package com.springlec.base0701.dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springlec.base0701.dto.BDto;
import com.springlec.base0701.util.Constant;

public class BDao {

	
	JdbcTemplate template;
	
	public BDao() {
		this.template = Constant.template;
		
	}
	
	public ArrayList<BDto> list(){
	
//		ArrayList<BDto> dtos = null;
//		String query = "select bId, bName, bTitle, bContent, bDate from mvc_board";
//		dtos = (ArrayList<BDto>)template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
//		return dtos;
		
		
		String query = "select bId, bName, bTitle, bContent, bDate from mvc_board";
		return (ArrayList<BDto>)template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		
		
		

	}
	
	
	
}
