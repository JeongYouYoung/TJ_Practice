<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@page import="java.sql.*" %>


<%
	/* 2번에서 바뀐값 저장. */
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	String address = request.getParameter("address");
	
	/* session으로 새값 저장. */
	session.setAttribute("NEWNAME", name);
	session.setAttribute("NEWTEL", tel);
	session.setAttribute("NEWADDRESS", address);

	
	String url_mysql = "jdbc:mysql://localhost:3306/customer?serverTimezone=Asia/Seoul&characterEncoding=utf-8&useSSL=false";
	String id_mysql = "root";
	String pw_mysql = "qwer1234";
	
	
	PreparedStatement ps = null;
	
	
	/* --------------세션값은 오브젝트로 저장------------------ */
	String newName = (String)session.getAttribute("NEWNAME");
	String newTel= (String)session.getAttribute("NEWTEL");
	String newAddress = (String)session.getAttribute("NEWADDRESS");
	String oldName = (String)session.getAttribute("OLDNAME");
	String oldTel = (String)session.getAttribute("OLDTEL");
	String oldAddress = (String)session.getAttribute("OLDADDRESS");
	/* 처음입력했던 userid값. */
	String userid = (String)session.getAttribute("USERID");
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();
		
		
		/* --------------------------------update---------------------------- */
		
		String A = "update purchaserinfo set name = ?, tel = ?, address = ? where userid = ?";
		
		
		
		ps = conn_mysql.prepareStatement(A);
		ps.setString(1, newName);
		ps.setString(2, newTel);
		ps.setString(3, newAddress);
		ps.setString(4, userid);
		ps.executeUpdate();
		
		
		conn_mysql.close();
		
	}catch(Exception e){
		e.printStackTrace();
		
	}
	
	response.sendRedirect("Practice_update_04.jsp");

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