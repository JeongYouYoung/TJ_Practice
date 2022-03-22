<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>


<%
	String userid = request.getParameter("userid");
	/* jdbc : 자바데이터베이스??커넥트 */
	String url_mysql = "jdbc:mysql://localhost:3306/eclipse?serverTimezone=Asia/Seoul&characterEncoding=utf-8&useSSL=false";
	String id_mysql = "root";
	String pw_mysql = "qwer1234";
	
	
	PreparedStatement ps = null;
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");//여기 애러는 내톰켓에 뭐가 없다는데,,?
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();
		
		
		/* String으로 SQL문장을 가져옴 */
		/*  붙여쓸때 띄어쓰기 잘해야함 */
		String A = "insert into wtest (userid";
		String B = ") values (?)";
		/* ?가 여러개면 ps.setStrint/int(?순서, 들어갈값.) */
		/* String A = "insert into wtest (userid)^요기^values (?)"; <== 띄어쓰기가 없어서 애러가 뜬다는데..? */
		
		ps = conn_mysql.prepareStatement(A+B);
		ps.setString(1, userid);
		ps.executeUpdate();
		
		/* DB는 커넥터 꺼야함. 그래야 다른 사람이 들어옴 */
		conn_mysql.close();
		
	}catch(Exception e){
		e.printStackTrace();
		
	}
	
	response.sendRedirect("insertTest_03.jsp");

%>