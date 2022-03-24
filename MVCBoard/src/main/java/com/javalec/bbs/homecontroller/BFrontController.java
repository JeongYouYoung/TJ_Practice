package com.javalec.bbs.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.command.BContentCommand;
import com.javalec.bbs.command.BDeleteCommand;
import com.javalec.bbs.command.BListCommand;
import com.javalec.bbs.command.BModifyCommand;
import com.javalec.bbs.command.BWriteCommand;
import com.javalec.bbs.command.Bcommand;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")//do라고 끝나는거는 다 나한테오라는 신호
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		
		//두개다 가져울메소드를 만들어
		actionDo(request, response); //가져온걸 저장해야해
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		actionDo(request, response);
		
	}
		//따라쟁이 메소드를 만들어서 다 받아옴.
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 System.out.println("actionDo");
		 request.setCharacterEncoding("utf-8");//제일 처음 컨트롤러가 한글처리가 안되면 다 에러
		
		
		 String viewPage = null; //jsp에서 ~~.~하고 주려고 만든거
		 
		 Bcommand command = null; 
		 //컨트롤 스페이스로 받아라 임포트 들어옴!
		 //command 를 널로 받고 스위치에서 서로 다른값을 받아가려고 쓰는게 인터페이스!
		 
		 
		 
		 String uri = request.getRequestURI(); //스위치에서 사용하려고 만듦
		 String conPath = request.getContextPath(); // 스위치에서 사용하려고 만듦
		 String com = uri.substring(conPath.length()); //스위치에서 사용하려고 만듦
		 
		 
//		미리 확인 : 실행누르고 404에러뜨면 URL에 ***.do 를 미리쳐서 콘솔창에 doGet actionDo 이뜨면 일단 OK.
//		 System.out.println(uri);
//		 System.out.println(conPath);
//		 System.out.println(com);
		 
		 	switch(com) {
		 	case("/list.do"): //전체 내용 보여주기
		 	//커맨드를 통일하자 이름이 많아 지니까 ==> 인터페이스.
		 		command = new BListCommand();
		 		command.execute(request, response); //익스큐트 있는 내용을 컨트롤러가 실행..
		 		viewPage = "list.jsp"; //컨트롤러가 jsp 한테 일을 시키는 과정
		 		break;//컨트롤러 끝.
		 	case("/write_view.do"): //전체 내용 보여주기
			 	//커맨드를 통일하자 이름이 많아 지니까 ==> 인터페이스.
			
			 	viewPage = "write_view.jsp"; //컨트롤러가 write_view.jsp 한테 날라가서 일하라고 보냄.
			 	break;//컨트롤러 끝.
			 	
		 	case("/write.do"):
		 		command = new BWriteCommand();
		 		command.execute(request, response);
		 		viewPage= "list.do";
		 		break;
		 		
		 	case("/content_view.do"):
		 		command = new BContentCommand();
		 		command.execute(request, response);
		 		viewPage = "content_view.jsp";
		 		break;
		 	case("/modify.do"):
		 		command = new BModifyCommand();
			 	command.execute(request, response);
			 	viewPage = "list.do";
			 	break;
		 	case("/delete.do"):
		 		command = new BDeleteCommand();
		 		command.execute(request, response);
			 	viewPage = "list.do";
			 	break;
		 		
		 	}
		 
		 
		 RequestDispatcher dispatcher =  request.getRequestDispatcher(viewPage);
		 dispatcher.forward(request, response);
		 
		 
		 
	}
	
	
	

}
	