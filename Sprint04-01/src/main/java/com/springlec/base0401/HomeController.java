package com.springlec.base0401;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping("board/confirmId")//http에서 받아오려면 때려죽여도 이걸루 받아와야햄..
	public String confirmId(HttpServletRequest request, Model model) {
		//version 3 방식
		//포폴엔 ver3/ver4 방식 둘다 있으면 좋다
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "board/confirmId";
	}
	
	@RequestMapping("board/checkId")
	public String checkId(@RequestParam("id") String id, @RequestParam("pw") int pw, Model model) {
		//version 4 방식
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "board/confirmId";//jsp 더 만들기 싫어서 confirmId.jsp로 보냄.
		
	}
	
//	@RequestMapping("member/join")
//	public String join(@RequestParam("name") String name,
//						@RequestParam("id") String id,
//						@RequestParam("pw") String pw,
//						@RequestParam("email") String email,
//						Model model	) {
//		Member member = new Member();
//		member.setName(name);
//		member.setId(id);
//		member.setPw(pw);
//		member.setEmail(email);
//		
//		model.addAttribute("member", member);
//		
//		return "member/join";
//	}
	
	@RequestMapping("member/join")//dto 한번에 보낼게 많을때 쓰면 좋아.
	public String joinData(Member member) {
		return"member/join";
		
	}
	
	@RequestMapping("student/{studentId}")/*{data}받아올수 있어.url에 값을 넣어서 보낼때/다음 바로 값적어서 보낼수 있어.*/
	public String getStudent(@PathVariable String studentId, Model model) {
		model.addAttribute("studentId", studentId);
		return "student/studentview";
	}

	
	@RequestMapping("test/login")
	public String login() {
		return "test/login";
	}
	
	/*@RequestParam 사용*/
//	@RequestMapping("test/viewIDPW")
//	public String loginview(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
//		 
//		model.addAttribute("id", id);
//		model.addAttribute("pw", pw);
//		return "test/viewIDPW";
//	}
	
	/*dto 사용*/
//	@RequestMapping("test/viewIDPW")//${user.id } 이런식으로 받아야함.
//	public String loginview(User user) {
//		return "test/viewIDPW";
//	}
	
	/*HttpServletRequest request*/
	@RequestMapping("test/viewIDPW")
	public String loginview(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "test/viewIDPW";
	}
	
	
	
}
