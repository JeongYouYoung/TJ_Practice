<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>수정 및 삭제</title>
</head>
<body>

	<h2>글 수정 및 삭제</h2>
	<table border = "0"> 
		<form action="modify.do" method="post">
		
		<tr>
			<td>번호</td>
			<td><input type="text" name="bId" size="5" value="${content_view.bId }" readonly="readonly"></td>
		</tr>
		
		<tr>
			<td>이름</td>
			<td><input type="text" name="bName" size="20" value="${content_view.bName }"></td>
		</tr>
		
		<tr>
			<td>제목</td>
			<td><input type="text" name="bTitle" size="20" value="${content_view.bTitle }"></td>
		</tr>
		
		<tr>
			<td>내용</td>
		 	<td><textarea rows="10" cols="50" name="bContent">${content_view.bContent }</textarea></td>
		</tr>
		
		<td colspan="2"><input type="submit" value="수정">
	</form>
	</table>
	<form action="delete.do" method="post">
		<input name="bId" type="hidden" value="${content_view.bId }">
		<input type="submit" value="삭제">
		<a href="list.do">목록보기</a>
	</form>
		
	

	
	
</body>
</html>