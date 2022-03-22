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
		/* next함수는 ResultSet에 저장된 SELECT문 실행 결과를 행단위로 1행씩 넘겨서 
		만약에 다음 행이 있으면 true, 다음 행이 없으면 false를 반환하는 함수다. 
		while(rs.next())를 하게되면 한 루프가 돌아갈 때 마다 1행씩 넘겨주다가
		더이상 행이 없으면 while문이 끝나게 된다*/
		while(rs.next()){
			
			strName = rs.getString("name");
			strTel = rs.getString("tel");
			strAddress = rs.getString("address");
			
		}
		
		
		conn_mysql.close();
		
		/* session으로 전에값 저장. */
		session.setAttribute("OLDNAME", "strName");
		session.setAttribute("OLDTEL", "strTel");
		session.setAttribute("OLDADDRESS", "strAddress");
		
		
	}catch(Exception e){
		e.printStackTrace();
		
	}
	
	
	
	
	
	
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정확인</title>
</head>
<body>
	<h3>수정후 확인 버튼을 누르세요!</h3>
	
	<form action="Practice_update_03.jsp">
		<table>
				<tr>
					<td align="right">사용자 ID </td>
					<td> <input type="text" name="userid" size="10" readonly="readonly" value="<%= strUserid%>"></td>
				</tr>
				<tr>
					<td align="right">성명</td>
					<td> <input type="text" name="name" size="10" value="<%= strName%>"></td>
				</tr>
				<tr>
					<td align="right">전화번호</td>
					<td><input type="text" name="tel" size="20" value="<%= strTel%>"></td>
				</tr>
				<tr>
					<td align="right">주소</td>
					<td> <input type="text" name="address" size="30" value="<%= strAddress%>"></td>
				</tr>
				<tr>
					<td></td>
					<td> <input type="submit" value="확인"></td>
				</tr>
			</table>
	</form>
</body>
</html>