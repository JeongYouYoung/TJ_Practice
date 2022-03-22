<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.sql.*" %>


<%
	String url_mysql = "jdbc:mysql://localhost:3306/customer?serverTimezone=Asia/Seoul&characterEncoding=utf-8&useSSL=false";
	String id_mysql = "root";
	String pw_mysql = "qwer1234";
	
	
	PreparedStatement ps = null;
	
	
	/* --------------세션값 USERID 오브젝트로 저장------------------ */
	String userid = (String)session.getAttribute("USERID");
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();
		
		
		/* --------------------------------update---------------------------- */
		
		String A = "delete from purchaserinfo where userid = ?";
		
		
		
		ps = conn_mysql.prepareStatement(A);
		
		ps = conn_mysql.prepareStatement(A);
		ps.setString(1, userid);
		ps.executeUpdate();
		
		
		conn_mysql.close();
		
	}catch(Exception e){
		e.printStackTrace();
		
	}
	
	response.sendRedirect("Practice_Delete_04.jsp");

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>