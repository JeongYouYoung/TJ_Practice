<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view1</title>
</head>
<body>
	<% 
	if(request.getAttribute("id") == "1"){
	%>
			"안녕하세요"
	<%
	}else if(request.getAttribute("id") == "2"){
	%>	 
			"반갑습니다"
	<%	
	}
	%>
	
	<%-- <c:choose>
	<c:when test="${id eq 1 }">
	"안녕하세요"
	</c:when>
	<c:when test="${id eq 2 }">
	"반갑습니다."
	</c:when>
	</c:choose> --%>

	
</body>
</html>