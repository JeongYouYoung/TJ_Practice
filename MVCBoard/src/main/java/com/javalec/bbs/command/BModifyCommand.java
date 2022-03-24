package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.BDao;

public class BModifyCommand implements Bcommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int bId = Integer.parseInt(request.getParameter("bId"));
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BDao dao = new BDao();

		dao.modify(bName, bTitle, bContent, bId);
		
	}

}
