//command interface 처음에 지정하는 방법을 자세히 알아봐야 겠다..



package com.jacalec.mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface OLcommand {

	public void excute(HttpServletRequest request, HttpServletResponse response);
}
