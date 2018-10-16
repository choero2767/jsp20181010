<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jndiConnection.jsp</title>
</head>
<body>
	<% // jndi connection
	   Context initialContext = new InitialContext();
	   DataSource ds = (DataSource)initialContext.lookup("java:comp/env/jdbc/oracleDB");
	   
	   Connection conn = null;
	   
	 	long startTime = System.currentTimeMillis();
		for(int i = 0; i < 30; i++){
			conn = ds.getConnection();
			out.println("schema : " + conn.getSchema() + "<br>");
			try {	conn.close();	} catch (Exception e2) {}
		}
		long endTime = System.currentTimeMillis();
		out.println("endTime - startTime : " + (endTime - startTime)+"ms");
		
		
	   
	%>
</body>
</html>