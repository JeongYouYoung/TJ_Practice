package com.jacalec.mvc.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.mvc.dao.OLDao;
import com.javalec.mvc.dto.OLDto;

public class OLListCommand implements OLcommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		OLDao dao = new OLDao();//다오에서 나온걸 가져올꺼니까 dao로 가져오겠다.
		
		
		
		//행으로 차곡차곡 쌓아서 가져와야 하니까 ArrayList사용!
		ArrayList<OLDto> dto = dao.list();//dao에서 받아오기! Dao go!
		request.setAttribute("list", dto);//setAttribute ==> ${ } 사용할수 있어!
		
		
		
		
		
	}

}
