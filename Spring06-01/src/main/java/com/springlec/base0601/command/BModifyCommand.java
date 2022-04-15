package com.springlec.base0601.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.springlec.base0601.dao.BModifyDao;

public class BModifyCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		BModifyDao dao = new BModifyDao();
		dao.modify(bName, bTitle, bContent, bId);
	}

}
