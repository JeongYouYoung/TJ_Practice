package com.springlec.base0302;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 이걸 선언해줘야 컨트롤러로 사용가능
public class MyController {
	
	
	@RequestMapping("/content")//처음에 return값에 jsp달라고 할꺼 같음.. ㅋㅋ..
	public String content(Model model) {
		model.addAttribute("id" , "tester");
		return "content"; 
	}
}
