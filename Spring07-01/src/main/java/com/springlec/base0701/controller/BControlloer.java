package com.springlec.base0701.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0701.command.BCommand;
import com.springlec.base0701.command.BContentCommand;
import com.springlec.base0701.command.BDeleteCommand;
import com.springlec.base0701.command.BListCommand;
import com.springlec.base0701.command.BModifyCommand;
import com.springlec.base0701.command.BWriteCommand;
import com.springlec.base0701.util.Constant;

		/*
		new로 그때그때 만들어주는데 메모리에 쌓이는거니까. 정신이 없어져. 
		그걸 해결하자가 'Di' case by case 로 만들어주겠다 
		커멘드와 컨트롤러에 new가 없어야 spring 이다.
		*/
@Controller
public class BControlloer {

	BCommand command = null;
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");//ActionDo 랑 같음 확인.
		command = new BListCommand();
		
		command.execute(model);
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		return "write_view";
	}
	
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	
	@RequestMapping("/content_view")
	public String content(HttpServletRequest request, Model model) {
		System.out.println("contentView()");
		
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	
	@RequestMapping("modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");
		model.addAttribute("request" ,request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
		
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) {
		
		System.out.println("delete()");
		model.addAttribute("request" ,request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	
	
	
	
}
