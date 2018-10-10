<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pageContext.jsp</title>
</head>
<body>
	<%-- 
		내장객체 (implicit)
		request, session, response, application, out, pageContext(application의 전반적인 함수 소유) 
	--%>
	<%
		pageContext.getOut(); // out
		pageContext.getRequest(); // request
		pageContext.getSession(); // session
		pageContext.getResponse(); // response
		pageContext.getPage(); // page
		pageContext.getServletContext(); // application
	
	%>
	<h3>=====pageContext=====</h3>
	pageContext.getOut() : <%= out.equals(pageContext.getOut()) %>                     <br>
	pageContext.getRequest() : <%= request.equals(pageContext.getRequest()) %>                    <br>
	pageContext.getSession() : <%= session.equals(pageContext.getSession()) %>                    <br>
	pageContext.getResponse() : <%= response.equals(pageContext.getResponse()) %>                 <br>
	pageContext.getPage() : <%= page.equals(pageContext.getPage()) %>                             <br>
	pageContext.getServletContext() : <%= application.equals(pageContext.getServletContext()) %>  <br>
</body>
</html>