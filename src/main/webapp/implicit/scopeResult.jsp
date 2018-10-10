<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>scopeResult.jsp</title>
</head>
<body>
	<%-- 
		1. localhost:8081/implicit/scope.jsp에서 전송 (request 영역 확인)
		   requestScope : brown_attribute
		   sessionScope : sally_attribute
		   applicationScope : cony_attribute
			
		2. 새로운 탭을 열어서 (크롬)
		   localhost:8081/implicit/scopeResult.jsp (session 영역 확인)
		   requestScope : null
		   sessionScope : sally_attribute
		   applicationScope : cony_attribute
			
		3. exproler 에서
		   localhost:8081/implicit/scopeResult.jsp (application 영역 확인)
		   requestScope : null
		   sessionScope : null
		   applicationScope : cony_attribute
			
		4. cookie 삭제 후 2번 테스트
	--%>
	requestScope : <%= request.getAttribute("requestScope") %> <br>
	sessionScope : <%= session.getAttribute("sessionScope") %> <br>
	applicationScope : <%= application.getAttribute("applicationScope") %> <br>  
</body>
</html>