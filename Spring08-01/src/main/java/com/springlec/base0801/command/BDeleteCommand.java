package com.springlec.base0801.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.base0801.dao.IDao;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute2(HttpServletRequest request, SqlSession sqlSession) {
		// TODO Auto-generated method stub
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.deleteDao(Integer.parseInt(request.getParameter("mId")));
		
	}

}
