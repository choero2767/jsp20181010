package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.StringUtil;

@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet("/userUpdateForm")
public class UserUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	// 사용자 수정 화면
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String userId = request.getParameter("userId");
		
		System.out.println(userId);
		
		// 사용자 아이디에 해당하는 사용자 정보 조회 
		UserServiceInf service = new UserService();
		UserVo userVo = service.selectUser(userId);
		
		// jsp로 위임하기 위해 사용자 정보를 request에 저장
		request.setAttribute("userVo", userVo);
		
		// 사용자 상세 화면으로 위임
		request.getRequestDispatcher("/user/userUpdateForm.jsp").forward(request, response);
		
	}
	
	// 사용자 수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 한글 파라미터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String addr1 = request.getParameter("add1");
		String addr2 = request.getParameter("add2");
		String birth = request.getParameter("birth");
		String zipcd = request.getParameter("zipcd");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		
		Part profilePart = request.getPart("profile");
		
		String contentDisposition =  profilePart.getHeader("Content-disposition");
		
		String fileName = StringUtil.getFileNameFromHeader(contentDisposition);
		

		String[] splits = contentDisposition.split("; ");
		
		
		
		// 파일쓰기
		// url정보를 실제 파일경로로 변경
		String path = getServletContext().getRealPath("/profile");

		// profile 신규 입력 값
		String profile = "/profile/"+fileName;
		
		profilePart.write(path + File.separator + fileName);
		
		profilePart.delete();
		
		
		// 파라미터를 userVo
		UserVo userVo = new UserVo();
		userVo.setProfile(profile);
		userVo.setUserId(userId);
		userVo.setName(name);
		userVo.setAdd1(addr1);
		userVo.setAdd2(addr2);
		userVo.setZipcd(zipcd);
		userVo.setPass(pass);
		userVo.setEmail(email);
		userVo.setTel(tel);
		try {
			// yyyy-MM-dd
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			userVo.setBirth(sdf.parse(birth));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// 사용자 등록 서비스 호출(
		UserServiceInf userService = new UserService();
		
		int updateCnt = userService.updateUser(userVo);
		
		// 사용자 리스트로 이동
		// (redirect : 서버 상태가 변경되므로 사용자가 새로고침을 통해
		// 재요청시 중복 등록되는 현상을 막는다.
		
		if(updateCnt != 0){
			response.sendRedirect("/userPageList?page=1&pageSize=10");
		}else {
			response.sendRedirect("/userUpdateForm");
		}
		
		
		
	}

}
