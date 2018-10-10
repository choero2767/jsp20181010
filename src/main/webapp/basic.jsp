<!-- 지시자 jsp가 어떻게 생겼는지 설명 -->
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>basic.jsp</title>
</head>
<% UserVo userVo = (UserVo)session.getAttribute("userVo"); %>
<%= userVo.getName()+"["+userVo.getAlias()+ "] 님 안녕하세요."%> 
<%-- 스크립틀릿 <% %> : 자바 코드 작성용도 --%>
<%-- 표현식 <%= %> : 출력을 표현 --%>
<% 
	Date date = new Date();
	String simpleDate = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	simpleDate = sdf.format(date);
	
	String msg = "first jsp";
	
%>

<body>
	hello, world
	<br>
	<%=simpleDate %>
</body>
</html>

<!-- http://localhost:8081/basic.jsp -->