<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	사용자 ID : <%=session.getAttribute("USERID") %>
	<br>
	<br>
	상기의 정보가 삭제되었습니다.감사합니다.
</body>
</html>