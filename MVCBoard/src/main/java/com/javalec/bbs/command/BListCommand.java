//interface 만들어 놓은걸 넣어
//내용이 있으니까Class!!
package com.javalec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.BDao;
import com.javalec.bbs.dto.BDto;


public class BListCommand implements Bcommand {

	@Override // 이게 내용!! 그래서 오버라이드 들어옴. 인터페이스 차이점?'';;
	//익스큐트 내용을 다오가 가지고 있나?;;         request,response가 이미 대기중! 리퀘스트로 받아올수 있는 이유.
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		//계속 서로 통신방법이 request,response
		BDao dao = new BDao();
		
		 ArrayList<BDto> dtos = dao.list();
		 //Attribute로 잡아줘서 jsp에서 $로 받아올수 있어.
		 request.setAttribute("list", dtos);
		
		
		

	}

}
