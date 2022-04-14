package com.springlec.base0501;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	
	@RequestMapping("studentOK")//폴더이름 쓸필요 없어
	public String studentOK1111(){
		return "student/studentOK";
	}
	
	
	@RequestMapping("studentNG")//폴더이름 쓸필요 없어
	public String studentNG2222(){
		return "student/studentNG";
	}
	
//	@RequestMapping("studentConfirm")
//	public String studentOK3333(HttpServletRequest request) {
//		
//		String returnStatmane = "";
//		
//		String id = request.getParameter("id");
//		if(id.equals("abc")) {
//			return "redirect:studentOK"; //DB에서 찾아서 보여줘야 하는경우에 jsp로 가는게 아니라 위에 컨트롤러로 날라가게 하는거.
//		}else {
//			return "redirect:studentNG";
//		}
//		
//		return returnStatmane;
//	}
	//둘이 같은거임 선생님은 밑에꺼를 더 많이쓰심
	@RequestMapping("studentConfirm")
	public String studentOK3333(HttpServletRequest request) {
		
		String returnStatmane = "";
		
		String id = request.getParameter("id");
		if(id.equals("abc")) {
			returnStatmane = "studentOK"; //DB에서 찾아서 보여줘야 하는경우에 jsp로 가는게 아니라 위에 컨트롤러로 날라가게 하는거.
										  //중간중간에 return	이 많으면 정신없어서 하나만 써주는게 좋아.
		}else {
			returnStatmane = "studentNG";
		}
		
		return "redirect:" + returnStatmane;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
