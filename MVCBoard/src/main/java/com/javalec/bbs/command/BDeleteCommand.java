package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.BDao;

public class BDeleteCommand implements Bcommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		int bId = Integer.parseInt(request.getParameter("bId"));
		
		BDao dao = new BDao();
		dao.delete(bId);
	}

}
