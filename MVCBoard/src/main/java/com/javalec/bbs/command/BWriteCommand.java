package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.BDao;

public class BWriteCommand implements Bcommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {			
			String bName = request.getParameter("bName");
			String bTitle = request.getParameter("bTitle");
			String bContent = request.getParameter("bContent");
			
			
			BDao dao = new BDao();
			dao.write(bName, bTitle, bContent);
		}

	}


