<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% request.setAttribute("userId", "brown");
   request.setAttribute("userId", "cony");	
%>

<lable>userId : </lable> <c:out value="${userId }"></c:out> <br>
<lable>user : </lable> <c:out value="${user }" default="brownDefault"></c:out>

</body>
</html>