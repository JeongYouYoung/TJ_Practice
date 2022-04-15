package com.springlec.base0602.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.base0602.dao.BDeleteDao;

public class BDeleteCommand implements BCommand {
	
	private BDeleteDao ddao = null;
	@Autowired
	public void setDao(BDeleteDao ddao) {
		this.ddao = ddao;
	}
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		//BDeleteDao dao = new BDeleteDao();
		ddao.delete(bId);
	}

}
