package com.jacalec.mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.mvc.dao.OLDao;


public class OLWriteCommand implements OLcommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		
		String bNmae = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		
		
		OLDao dao = new OLDao();
		dao.write(bNmae, bTitle);
	
	
	
	
	
	
	}

}
