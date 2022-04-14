<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%-- dto 사용할떄 사용
	ID : ${user.id }<br>
	PW : ${user.pw }
	 --%>
	ID : ${id }<br>
	PW : ${pw }
	
	<form action="login">
	<input type="submit" value="돌아가기">
	</form>
	
</body>
</html>