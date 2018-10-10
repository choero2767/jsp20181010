<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sumResult.jsp</title>
</head>
<body>
	session에 저장된 값 : <%= session.getAttribute("sumResult") %>
</body>
</html>