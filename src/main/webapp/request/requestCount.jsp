<%@page import="kr.or.ddit.filter.RequestCounterFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>requestCount.jsp</title>
</head>
<body>
requestCount.jsp
<c:forEach items="${rcMap }" var="entry">
	${entry.key } : ${entry.value }
</c:forEach>

</body>
</html>