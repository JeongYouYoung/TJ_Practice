package com.javalec.mvc.maincontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jacalec.mvc.command.OLDeleteCommand;
import com.jacalec.mvc.command.OLListCommand;
import com.jacalec.mvc.command.OLWriteCommand;
import com.jacalec.mvc.command.OLcommand;

/**
 * Servlet implementation class onelineMainController
 */
@WebServlet("*.do")
public class onelineMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public onelineMainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doGet");// 잘 작동하면 출력!
		actionDo(request, response);//get.post 를 가져올 메소드
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost");// 잘 작동하면 출력!
		actionDo(request, response);//get.post 를 가져올 메소드
		
	}

	
	//get,post를 다 받아오려면 위에 있는 Method선언 내용들을 다 카피해야함.
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		System.out.println("actionDo");// 잘 작동하면 출력!
		request.setCharacterEncoding("utf-8");//한글 받아오기위해서 인코딩.
		
		
		/* 
		 내가 만든 메소드에서 .jsp , DAO 를 왔다갔다 하면서 일을 시켜야 함. 
		 switch로 변수값을 바꿔가면서 보낼꺼임. 
		*/
		
		
		//-------------.jsp용 변수-------------------
		String viewPage = null;
		
		//-------------switch 결과값 변수--------------
		OLcommand olcommand = null; // switch에서 서로다른 값을 넣어서 출력할 변수 선언.
								   //interface 로 만들어놓은 command값.
								   //얘를 기준으로 커맨드들이 왔다갔다 할꺼임.
		
		
		//-------------switch용 전용 변수 선언 'com'만 사용할꺼임.--------------------
		//이거 왜하나 했는데 뒤에 주소만 떼오려구 한거구나!!
		String uri =  request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		
		//------------------switch변수 출력확인.---------------------------
//			System.out.println(uri);	//-----> /MVC_one_line_0325/*.do
//			System.out.println(conPath);//-----> /MVC_one_line_0325
//			System.out.println(com);	//-----> /*.do
		
		
			
			
		/*
		 get.post값을action으로 받아오고 왔다갔다할 주소값을(jsp) 'com'으로 받아와서
		 command를 사용해 왔다갔다 할 준비 완료!
		*/
		//---------------------switch문 시작------------------------------
			
			switch (com) {
			case ("/list.do"):
				olcommand = new	OLListCommand();
				olcommand.excute(request, response); //list값을 눌렀으니 OLcommand에 값이 들어왔음 
				viewPage = "list.jsp";				 //excute메소드로 값을 .jsp출력
				break;
				
			case("/write_view.do"):
				viewPage = "write.jsp";
				break;//비어있는 화면을 넣어줘야 반응을 두번 안해!!
				
			case("/write.do"):
				olcommand = new OLWriteCommand();
				olcommand.excute(request, response);
				viewPage = "list.do";
				break;
				
			case("/delete.do"):
				olcommand = new OLDeleteCommand();
				olcommand.excute(request, response);
				viewPage = "list.do";
				break;
			}
			
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
			
			
			
			
			
			
		
	}
}
