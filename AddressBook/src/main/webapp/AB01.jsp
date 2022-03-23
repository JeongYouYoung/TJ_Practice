<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<%

	 /* getParameter */
	String queryName = request.getParameter("query"); //table의 select name = "query"
	String queryContent = request.getParameter("content");//table의 input name = "content"
	
	if(queryName == null){
		queryName = "address";
		queryContent ="";
	}


	request.setCharacterEncoding("utf-8");
	String url_mysql = "jdbc:mysql://localhost:3306/customer?serverTimezone=Asia/Seoul&characterEncoding=utf-8&useSSL=false";
	String id_mysql = "root";
	String pw_mysql = "qwer1234";
	
	
	
	
	String query1 = "select seq, name, tel, address ,email ,rel from addressBook ";//
	String query2 = "where " + queryName + " like '%" + queryContent + "%'";
	
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		
		Statement stmt_mysql = conn_mysql.createStatement();
		ResultSet rs = stmt_mysql.executeQuery(query1 + query2);
		int cnt = 0 ;
%>
		<h3>주소록 명단 리스트 </h3>
		
	<form action="AB01.jsp">
		<table>
			<tr>
			<td>검색 선택 : </td>
			<td><select name="query">
				<option value="name">name</option>
				<option value="address" selected="selected">주소</option>
				<option value="tel">전화번호</option>
				<option value="email">전자우편</option>
				<option value="rel">관계</option>
			</select></td>
			<td><input type="text" name = "content" size ="30"></td>
			<td><input type="submit" value=" 검색 "></td>
			</tr>
		</table>
	</form>
	<br><br>
			
		<table border = "1">
			<tr align="center">
				<th>Seq</th> <th>이름</th><th>전화번호</th> <th>주소</th><th>전자우편</th><th>관계</th>
			</tr>
			
			
<%		while(rs.next()){
	
%>			
			<tr>
				<td>
					<a href ="AB03.jsp?seq=<%=rs.getString(1)%>">
					<%=rs.getString(1)%>
					</a>
				</td>
				<td>
					<%=rs.getString(2)%>
				</td>
				<td>
					<%=rs.getString(3)%>
				</td>
				<td>
					<%=rs.getString(4)%>
				</td>
				<td>
					<%=rs.getString(5)%>
				</td>
				<td>
					<%=rs.getString(6)%>
				</td>
			</tr>

<%	
			cnt++;
		}
%>		
		</table>
		<br>
		<div align="left" style = "width :29%">
		
				<form action="AB02.jsp">
					<input type="submit" value="입력">
				</form>
		</div>
		<h3> 총 인원은 <%=cnt %> 입니다.</h3>
<%
	
		conn_mysql.close();

	}catch(Exception e){
		e.printStackTrace();
		e.getMessage();
		
	}

%>	
</body>
</html>
