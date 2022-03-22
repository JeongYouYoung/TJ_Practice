<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보 입력</title>
</head>
<body>
	<h2>아래의 항목을 입력후 확인 버튼을 누르세요!</h2>
		
		<form action="Practice_02.jsp" name="purchaserinfo">
			<table>
				<tr>
					<td align="right">사용자 ID </td>
					<td> <input type="text" name="userid"></td>
				</tr>
				<tr>
					<td align="right">성명</td>
					<td> <input type="text" name="name"></td>
				</tr>
				<tr>
					<td align="right">전화번호</td>
					<td><input type="text" name="tel"></td>
				</tr>
				<tr>
					<td align="right">주소</td>
					<td> <input type="text" name="address"></td>
				</tr>
				<tr>
					<td></td>
					<td> <input type="submit" value="확인"></td>
				</tr>
			</table>
		</form>
			
</body>
</html>