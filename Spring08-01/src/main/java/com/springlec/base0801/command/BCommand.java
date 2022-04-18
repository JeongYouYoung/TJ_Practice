package com.springlec.base0801.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface BCommand {

	
	void execute(SqlSession sqlSession , Model model);
	
	void execute2(HttpServletRequest request, SqlSession sqlSession);
}
