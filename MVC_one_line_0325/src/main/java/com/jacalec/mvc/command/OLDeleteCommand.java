package com.jacalec.mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.mvc.dao.OLDao;

public class OLDeleteCommand implements OLcommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		
			int bId = Integer.parseInt(request.getParameter("bId"));
			
			OLDao dao = new OLDao();
			dao.delete(bId);
	}	

}
