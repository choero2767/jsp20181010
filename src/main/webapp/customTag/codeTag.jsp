<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String username = "pc23";
	String password = "java";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String driver = "oracle.jdbc.driver.OracleDriver";

	// 작업하기 전에 JDBC드라이버를 Build Path에 추가한다.

	// DB작업에 필요한 객체변수 선언
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	try {
		// 1. JDBC 드라이버 로딩 ==> Class.forName()을 이용한다.
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. 해당 DB에 접속하기 
		//      ==> DriverManager.getConnection() 
		//      ==> 접속이 성공하면 Connection객체가 생성된다.
		String urlString = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "pc23"; // 등록된 사용자 ID
		String pass = "java"; // 등록된 패스워드

		conn = DriverManager.getConnection(url, user, pass);
		
		stmt = conn.createStatement();

		String sql = "select * prod_id, prod_name, from prod where prod_lgu = ?";
		
		rs = stmt.executeQuery(sql); 

		out.write("<opsion")
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		// 6. 사용했던 자원을 반납한다.
		if(rs!=null ) try {	rs.close();	} catch (Exception e2) {}
			if(stmt!=null ) try {	stmt.close();	} catch (Exception e2) {}
			if(conn!=null ) try {	conn.close();	} catch (Exception e2) {}
	}
%>
<tag:code code="P201"></tag:code>

</body>
</html>