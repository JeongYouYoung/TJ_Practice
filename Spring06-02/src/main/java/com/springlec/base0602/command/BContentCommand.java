package com.springlec.base0602.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.base0602.dao.BContentDao;
import com.springlec.base0602.dto.BDto;

public class BContentCommand implements BCommand {

	private BContentDao cdao = null;
	
	@Autowired
	public void setDao(BContentDao cdao) {
		this.cdao = cdao;
	}
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int bId = Integer.parseInt(request.getParameter("bId")) ;
		System.out.println(bId);
		
//		BContentDao dao = new BContentDao();
		BDto dto = cdao.contentView(bId);
		model.addAttribute("content_view" , dto);
	}

}
