package com.springlec.base0301;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
//board 선언
@RequestMapping ("/board")
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
	
	//swich case 다 없어짐
	@RequestMapping("/view")
	public String view() {
		return "board/view";
		
	}
	 @RequestMapping("/content")//model쓰는법
	 public String contetn(Model model) {
		 model.addAttribute("id", 30);
		 return "board/content";
	 }
	 @RequestMapping("/reply")//예전 model쓰는법 회사에서 이걸 쓰는경우도 있음.
	 public ModelAndView reply() {
		 ModelAndView modelandView = new ModelAndView();
		 modelandView.addObject("id", 30);
		 modelandView.setViewName("board/reply");
		 
		 return modelandView;
	 }
	 
//----------------Test----아직못했어.-----------------
	 @RequestMapping("test/view1")
	 public String view(Model model) {
		 model.addAttribute("id",1);
		 model.addAttribute("id",2);
		 return "test/view1";
		 
		 
		 
		 
		 
		 
		 
		 
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
