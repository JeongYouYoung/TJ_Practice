<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>


<%
	String userid = request.getParameter("userid");
	
	/* session으로 새 아이디값 저장. */
	session.setAttribute("NEW", userid);

	
	String url_mysql = "jdbc:mysql://localhost:3306/eclipse?serverTimezone=Asia/Seoul&characterEncoding=utf-8&useSSL=false";
	String id_mysql = "root";
	String pw_mysql = "qwer1234";
	
	
	PreparedStatement ps = null;
	
	
	/* --------------세션값은 오브젝트.------------------ */
	String newId = (String)session.getAttribute("NEW");
	String oldId = (String)session.getAttribute("OLD");
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();
		
		
		/* --------------------------------update---------------------------- */
		/* update는 다 할수 있어서 다설정해야함. key값빼고 그래서 키값은 =readonly */
		String A = "update wtest set userid = ? where userid = ?";
		/* ----------------------------------1번----------------2번----------- */
		
		
		ps = conn_mysql.prepareStatement(A);
		ps.setString(1, newId);
		ps.setString(2, oldId);
		ps.executeUpdate();
		
		
		conn_mysql.close();
		
	}catch(Exception e){
		e.printStackTrace();
		
	}
	
	response.sendRedirect("updateTest_04.jsp");

%>