package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimesTablesServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter pw = resp.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("		<meta charset=\"UTF-8\">");
		pw.println("		<title>timesTables.html</title>");
		pw.println("		<style type=\"text/css\">");
		pw.println("			td {");
		pw.println("				border : 1px solid pink;"); 
		pw.println("			}");
		pw.println("		</style>");
		pw.println("	</head>");
		pw.println("	<body>");
		pw.println("		<table>");
		int j=1;
		while(j<10){
			pw.println("			<tr>");
			int i = 2;
			while(i<10){
				pw.println("				<td>"+i+"*"+j+"="+i*j+"</td>");
				i++;
			}			
			pw.println("			</tr>");
			j++;
		}
		pw.println("		</table>");
		pw.println("	</body>");
		pw.println("</html>");
	
		            
		pw.flush(); 
		pw.close(); 
			
	}
}
