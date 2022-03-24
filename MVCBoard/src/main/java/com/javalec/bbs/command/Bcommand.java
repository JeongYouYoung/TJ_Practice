package com.javalec.bbs.command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//command이름만 정하는것
public interface Bcommand {
	//상속을 받으면 메소드 이름을 정해주겠다

	public void execute(HttpServletRequest request,HttpServletResponse response);
	 
}
