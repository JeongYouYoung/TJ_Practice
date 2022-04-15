package com.springlec.base0701.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.springlec.base0701.dao.BContentDao;
import com.springlec.base0701.dto.BDto;

public class BContentCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int bId = Integer.parseInt(request.getParameter("bId")) ;
		System.out.println(bId);
		
		BContentDao dao = new BContentDao();
		BDto dto = dao.contentView(bId);
		model.addAttribute("content_view" , dto);
	}

}
