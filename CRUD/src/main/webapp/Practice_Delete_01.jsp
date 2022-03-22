<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제할 ID 입력</title>
</head>


<body>
	<h3>사용자 ID를 입력후 확인 버튼을 누르세요!</h3>
	
	<form action="Practice_Delete_02.jsp" name="check">
	사용자 ID : <input type="text" name="userid"size="10" onclick="checkId()"><br>
	<input type="submit" value="확인">
	</form>
</body>
</html>