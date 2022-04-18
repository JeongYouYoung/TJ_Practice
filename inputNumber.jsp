<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<!-- 자바스크립트 구간 -->
<script type="text/javascript">
	/* 사용할 변수 선언 */
	var num1, num2 ;
	var num3
	
	/* num1 + num2  */
	function add(){
		num1 = Number(document.getElementById('num1').value);
		num2 = Number(document.getElementById('num2').value);
		num3 = num1 + num2
		alert(num1 + " + " + num2 + " = " + num3);
	}

	/* num1 - num2  */
	function sub(){
		num1 = Number(document.getElementById('num1').value);
		num2 = Number(document.getElementById('num2').value);
		num3 = num1 - num2
		alert(num1 + " - " + num2 + " = " + num3);
	}
	
	/* num1 x num2  */
	function mul(){
		num1 = Number(document.getElementById('num1').value);
		num2 = Number(document.getElementById('num2').value);
		num3 = num1 * num2
		alert(num1 + " x " + num2 + " = " + num3);
	}

	/* num1 / num2  */
	function div(){
		num1 = Number(document.getElementById('num1').value);
		num2 = Number(document.getElementById('num2').value);
		num3 = num1 / num2
		alert(num1 + " / " + num2 + " = " + num3);
	}
	
</script>

<meta charset="UTF-8">
<title>Input Number</title>
</head>
<body>
	<!-- JSP 구간 계산할 값을 받아오는곳입니다. -->	
	<form action="#">
		<h2>숫자를 입력하세요</h2>
		숫자1 :<input type="text" id="num1" name="num1"><br>
		숫자2 :<input type="text" id="num2" name="num2"><br>
	</form>
		<button  name="add" onclick="add()">덧셈</button>	
		<button  name="sub" onclick="sub()" >뺄셈</button>
		<button  name="mul" onclick="mul()">곱셈</button>
		<button  name="div" onclick="div()">나눗셈</button>
	
	
</body>
</html>