<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.sql.*" %>


<%
	request.setCharacterEncoding("utf-8");

	int id = Integer.parseInt(request.getParameter("id"));/* 앞에서 가져올거 */
	String strUserid = "";/* 뒤로 넘겨줄거 */
	
	
	String url_mysql = "jdbc:mysql://localhost:3306/eclipse?serverTimezone=Asia/Seoul&characterEncoding=utf-8&useSSL=false";
	String id_mysql = "root";
	String pw_mysql = "qwer1234";
	
	String query = "select userid from wtest where id =" + id;
	
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();
		

		/* ----이부분은 select만 쓴다.----- */		
		ResultSet rs = stmt_mysql.executeQuery(query);
		
		while(rs.next()){
			strUserid = rs.getString(1);
		}
		/* ---------------------------- */
		
		conn_mysql.close();
		
		/* session으로 전아이디값 저장. */
		session.setAttribute("OLD", strUserid);
		
		
	}catch(Exception e){
		e.printStackTrace();
		
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정화면</title>
</head>
<body>
		<h3>수정후 확인 버튼을 누르세요</h3>
		
		<form action="updateTest_03.jsp" method="post">
		사용자 ID : <input type="text" name="userid" size="10" value="<%=strUserid %>">
		<input type="submit" value="OK">
		</form>
</body>











</html>