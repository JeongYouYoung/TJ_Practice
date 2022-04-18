package com.springlec.base0801;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springlec.base0801.command.BCommand;
import com.springlec.base0801.command.BDeleteCommand;
import com.springlec.base0801.command.BLIstCommand;
import com.springlec.base0801.command.BWriteCommand;
import com.springlec.base0801.dao.IDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	BCommand command = null;
	private BCommand listCommand = null;
	private BCommand writeCommand = null;
	private BCommand deleteCommand = null;
	/*--------------------------------------------------------------*/
	@Autowired
	private SqlSession sqlSession;
	@Autowired	/*Autowired가 서로 떨어져있으니까 각각 붙여줘야함*/
	public void auto(BCommand list, BCommand write, BCommand delete) {
		this.listCommand = list;
		this.writeCommand = write;
		this.deleteCommand = delete;
	}
	/*---------------------------------------------------------------*/
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
	
	/*---------------------------------------------------------------------------*/
	
	/*List*/
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		/* 
		1st
		(2ed에서 : command 사용시 이부분은 command 로 보내서 쓸수 있어.)
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("list", dao.listDao());
		 
		2ed: used command
		command = new BLIstCommand();
		command.execute(sqlSession, model);
		
		3rd : not used new 오타 주의! LIst..라고 적었네;; 대소문자 구분 못해도 오류 걸림!*/
		listCommand.execute(sqlSession, model);
		
		return "/list";
	}
	
	
	/*Write Form*/
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "/writeForm";
	}
	
	
	/*Write*/
	@RequestMapping("/write")/*	주는게 없으니까 모델은 필요x */
	public String write(HttpServletRequest request) {
		System.out.println("write()");
		/* 
		1st 
		(2ed에서 : command 사용시 이부분은 command 로 보내서 쓸수 있어.)
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.writeDao(request.getParameter("mWriter"), request.getParameter("mContent"));
		
		2ed : command 사용
		command = new BWriteCommand();
		command.execute2(request, sqlSession);
		
		3rd : not used new */
		writeCommand.execute2(request, sqlSession);
		
		return "redirect:list";
	}
	
	
	/*Delete*/
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		System.out.println("delete()");
		/*
		1st
		(2ed에서 : command 사용시 이부분은 command 로 보내서 쓸수 있어.)
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.deleteDao(Integer.parseInt(request.getParameter("mId")));
		
		2ed : command 사용
		command = new BDeleteCommand();
		command.execute2(request, sqlSession);
		
		3rd : not used new */
		deleteCommand.execute2(request, sqlSession);
		
		return "redirect:list";
	}
	
	
	
}
