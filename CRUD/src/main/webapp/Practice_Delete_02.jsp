<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@page import="java.sql.*" %>

<%
	request.setCharacterEncoding("utf-8");
	
	
	String strUserid = request.getParameter("userid");
	//request로 받아온값인 userid Session 값으로 저장(set)).
	session.setAttribute("USERID", strUserid);
	
	String strName = "";
	String strTel = "";
	String strAddress = "";

	String url_mysql = "jdbc:mysql://localhost:3306/customer?serverTimezone=Asia/Seoul&characterEncoding=utf-8&useSSL=false";
	String id_mysql = "root";
	String pw_mysql = "qwer1234";
	//String값을 출력할때는  '"+ 요기 "' 안에 넣기
	String query = "select name, tel ,address from purchaserinfo where userid ='" + strUserid+"'";
	
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		Statement stmt_mysql = conn_mysql.createStatement();
		

			
		ResultSet rs = stmt_mysql.executeQuery(query);
		while(rs.next()){
			
			strName = rs.getString("name");
			strTel = rs.getString("tel");
			strAddress = rs.getString("address");
			/* while문 다돌고나서 결과값이 null일때 를 표시. */
		}if(strName.equals("")|| strTel.equals("") || strAddress.equals("")){
			
			response.sendRedirect("Practice_Delete_01.jsp");
		}
		
		
		conn_mysql.close();
		
		/* session으로 전에값 저장. */
		session.setAttribute("NAME", "strName");
		session.setAttribute("TEL", "strTel");
		session.setAttribute("ADDRESS", "strAddress");
		
		
	}catch(Exception e){
		e.printStackTrace();
		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>삭제할 고객정보를 확인후 버튼을 누르세요!</h3>
	
	<form action="Practice_Delete_03.jsp">
		<table>
				<tr>
					<td align="right">사용자 ID </td>
					<td> <input type="text" name="userid" size="10" readonly="readonly" value="<%= strUserid%>"></td>
				</tr>
				<tr>
					<td align="right">성명</td>
					<td> <input type="text" name="name" size="10" value="<%= strName%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td align="right">전화번호</td>
					<td><input type="text" name="tel" size="20" value="<%= strTel%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td align="right">주소</td>
					<td> <input type="text" name="address" size="30" value="<%= strAddress%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td></td>
					<td> <input type="submit" value="확인"></td>
				</tr>
			</table>
	</form>
</body>
</html>