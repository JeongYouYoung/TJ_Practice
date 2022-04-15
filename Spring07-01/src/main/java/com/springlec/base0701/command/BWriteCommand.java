package com.springlec.base0701.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.springlec.base0701.dao.BWriteDao;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		/* 확인용 */
		//System.out.println(bName + bTitle + bContent);
		BWriteDao dao = new BWriteDao();
		dao.write(bName, bTitle, bContent);
	}

}
