<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
 <!-- 이미지 경로 입력하는법!  -->
<img src="/spring0201/resources/googlelogo.png">
<img src="/spring0201/img/googlelogo.png"><%-- 이미지 파일은 무조건 servlet-context에 알려줘야함 --%>
</body>
</html>
