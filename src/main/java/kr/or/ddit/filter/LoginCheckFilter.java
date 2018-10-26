package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.UserVo;

public class LoginCheckFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		String uri = ((HttpServletRequest)request).getRequestURI();
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		UserVo userVo = (UserVo) session.getAttribute("S_USER");
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		if(userVo == null){
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
		
	}

}
