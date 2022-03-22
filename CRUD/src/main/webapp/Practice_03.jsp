<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 값.</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	
		<table>
				<tr>
					<td align="right">사용자 ID : </td>
					<td> <%=session.getAttribute("ID") %></td>
				</tr>
				<tr>
					<td align="right">성명 : </td>
					<td> <%=session.getAttribute("NAME") %></td>
				</tr>
				<tr>
					<td align="right">전화번호 : </td>
					<td><%=session.getAttribute("TEL") %></td>
				</tr>
				<tr>
					<td align="right">주소 : </td>
					<td><%=session.getAttribute("ADDRESS") %></td>
				</tr>
				
			</table>
			<br>
			<br>
		
		 
		 상기의 정보로 입력되었습니다.갑사합니다.
</body>
</html>