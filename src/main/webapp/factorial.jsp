<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>factorial.jsp</title>
</head>
<body>
<%!
	// factorial method 선언
	public String msg(){
		return "hello, World";
	}

	public int factorial(int a){
		if(a == 1 || a == 0){
			return 1;
		}
		return a * factorial(a-1);
	}
%>
<%= msg() %><br>
<% for(int i=1; i<9; i++){%>
	factorial(<%=i %>) = <%=factorial(i) %><br>
<%} %>
</body>
</html>