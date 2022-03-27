<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 이게...뭐였지... -->    
<%-- 
1. controller request 받아온다는 메세지랑 viewPage넘어가는 명령어를 안적었음..

2.Table name...잘못적음

3.Dto에 bDate를 bdate로 적어서 오류... 

--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
	<h2>One Line 게시판</h2>
	<br>
	<br>
	<br>
		
	
	<table border="1">
			
			<tr>
				<th>번호</th><th>이름</th><th>제목</th><th>날짜</th><th>삭제</th>
			</tr>
			
				<c:forEach items="${list }" var="dto">
			
					<tr>
						<td>${dto.bId }</td>
					
						<td>${dto.bName }</td>
					
						<td>${dto.bTitle }</td>
					
						<td>${dto.bDate }</td>
					
						<td><a href="delete.do?bId=${dto.bId }">X</a></td>
					</tr>
				
				</c:forEach>	
					
					<tr>
						<td colspan="5"><a href="write_view.do">글작성</a></td>
					</tr>	
			
	</table>
		
	
</body>
</html>