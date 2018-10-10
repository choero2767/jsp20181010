<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sumInput.jsp</title>
</head>
<body>
	<form action="/sumCalculation" method="post">
		<input type="number" name="start" > <br>
		<input type="number" name="end" > <br>
		<input type="submit" value="전송"> <br>
	</form>
</body>
</html>