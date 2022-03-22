<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- import 잊지말자! -->
<%@page import="java.sql.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보 받고 전달.</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	
	String userid = request.getParameter("userid");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	String address = request.getParameter("address");
	String url_mysql = "jdbc:mysql://localhost:3306/customer?serverTimezone=Asia/Seoul&characterEncoding=utf-8&useSSL=false";
	String id_mysql = "root";
	String pw_mysql = "qwer1234";
	
	
	PreparedStatement ps = null;
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();
		
		/* 여기는 SQL 을 쓰는 부분인듯하다.. */
		
		String A = "insert into purchaserinfo (userid, name, tel, address,insertdate";
		String B = ") values (?,?,?,?,now())";
		
			ps = conn_mysql.prepareStatement(A+B);
		ps.setString(1, userid);
		ps.setString(2, name);
		ps.setString(3, tel);
		ps.setString(4, address);
		ps.executeUpdate();
		
		
		conn_mysql.close();
		
	}catch(Exception e){
		e.printStackTrace();
		
	}
	
	session.setAttribute("ID", userid);
	session.setAttribute("NAME", name);
	session.setAttribute("TEL", tel);
	session.setAttribute("ADDRESS", address);
	
	response.sendRedirect("Practice_03.jsp");

%>
</body>
</html>