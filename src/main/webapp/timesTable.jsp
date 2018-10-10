<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>timesTable.jsp</title>
<style type="text/css">
	td {
		border : 1px solid pink;
	}
</style>
</head>
<body>
	<table>
	<%
		int j = 1;
		while(j<10){
	%>
			<tr>		
	<%
			int i = 2;
			while(i<10){
	%>
				<td><%=i+"*"+j+"="+i * j%></td>
	<%
				i++;
			}
	%>
			</tr>
	<%
			j++;
		}
	%>
	</table>
</body>
</html>