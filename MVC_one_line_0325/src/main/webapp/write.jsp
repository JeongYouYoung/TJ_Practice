<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력창</title>
</head>
	<body>
		<h2>One Line 게시판</h2>
		<br>
		<br><form action="write.do" method="post">
			<table>
				
				  <tr>
				  	<td>이름</td>
				  	<td><input type="text" size="50" name="bName"></td>
				 </tr>
				  <tr>
				  	<td>제목</td>
				  	<td><input type="text" size="50" name="bTitle"></td>
				 </tr>
			 	
			 		<tr>
			 			<td><input type="submit" value="입력"></td>
			 			<td><a href="list.do">목록보기</a></td>
			 		</tr>
			 	
			</table></form>
		
		
		</body>
		
		
		
	</html>
	