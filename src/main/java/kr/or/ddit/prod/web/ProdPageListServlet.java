package kr.or.ddit.prod.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.model.pageVo.PageVo;

@WebServlet(urlPatterns={"/prodPageList", "/prodPageDetail"})
public class ProdPageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProdServiceInf service = new ProdService();
		PageVo pageVo = new PageVo();
		
		Map<String, Object> prodVo = service.selectProdPageList(pageVo);

		request.getRequestDispatcher("/prod/prodPageList.jsp").forward(
				request, response);
		
	}
	
	private void prodPageList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 사용자 아이디 파라미터로 넘어옴
		String prod_id = request.getParameter("prod_id");
		
		// 사용자 아이디에 해당하는 사용자 정보 조회 
		ProdServiceInf service = new ProdService();
		ProdVo prodVo = service.selectProdDetail(prod_id);
		
		// jsp로 위임하기 위해 사용자 정보를 request에 저장
		request.setAttribute("prodVo", prodVo);
		
		// 사용자 상세 화면으로 위임
		RequestDispatcher rd = request.getRequestDispatcher("/prod/prodPageDetail.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
