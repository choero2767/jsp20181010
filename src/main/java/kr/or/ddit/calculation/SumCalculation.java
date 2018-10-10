package kr.or.ddit.calculation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SumCalculation
 */
@WebServlet("/sumCalculation")
public class SumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		
		CalculationLogic logic = new CalculationLogic();
		int sum = logic.sumBetweenTwoNumbers(start, end);	
		
		System.out.print(start +" ~ "+end+"사이 값의 합 : "+sum);
		
		HttpSession session = request.getSession();
		session.setAttribute("sumResult", sum);
		
		RequestDispatcher rd = request.getRequestDispatcher("/calculation/sumResult.jsp");
		rd.forward(request, response);
		
	}

}
