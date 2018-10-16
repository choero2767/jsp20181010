<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>userAllList</title>

<%@ include file="/common/basicLib.jsp" %>

<!-- jquery ui css -->
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<!-- 주소API(다음) -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<!-- jquery ui api -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>

$(document).ready(function(){
	// 개발 과정에서 사용한 기본 값 설정
	
	
	// 생일 input datepicker 적용
	$("#birth").datepicker({
		yearRange: "1994:2018",
		changeMonth : true,
		changeYear : true,
		dateFormat : "yy-mm-dd"
	});
	
	// 주소 검색 버튼 이벤트 핸들러
	$("#addrSearchBtn").click(function(){
		
		// 주소 검색 버튼 클릭 이벤트가 발생 했을때 실행
		new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	            console.log(data);
	            // 주소 : roadAddress
	            // 상세주소 : ""
	            // 우편번호 : zoneCode
	            
	            // 주소 input value설정 : data.roadAddress
            	$("#add1").val(data.roadAddress);
    	        // 우편번호 input value설정 : data.zoneCode
    	        $("#zipcd").val(data.zonecode);
	        }
	    }).open();
	});
});


	// 주소 검색 버튼 클릭이벤트가 발생 했을때 실행
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
            console.log(data);
            // 주소 : roadAddress
            // 상세주소 : ""
            // 우편번호 : zoneCode
            
        }
    }).open();
	
	
	
</script>

</head>



<body>



	<%-- @은 지시자 --%>
	<%-- header --%>
	<%@ include file="/common/header.jsp" %> 
	
	<div class="container-fluid">
		<div class="row">
		
			<%-- left --%>
			<%@ include file="/common/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form action="/userUpdateForm" method="post" class="form-horizontal" role="form" enctype="multipart/form-data">
				
				<%UserVo userUpdate = (UserVo)request.getAttribute("userVo"); %>
				
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<img src="<%=userUpdate.getProfile() %>">
							<input type="file" name="profile">
						</div>
					</div>
					

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
						
							<input type="text" class="form-control" id="userId" name="userId"
								placeholder="사용자 아이디" value=<%=userUpdate.getUserId() %>>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">비밀번호</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="pass" name="pass"
								placeholder="패스워드" value=<%=userUpdate.getPass() %>>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name" name="name"
								placeholder="이름" value=<%=userUpdate.getName() %>>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="add1" name="add1" readonly
								placeholder="주소" value=<%=userUpdate.getAdd1() %>> <button id="addrSearchBtn" type="button" class="btn btn-default">주소검색</button>
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="add2" name="add2"
								placeholder="상세주소" value=<%=userUpdate.getAdd2() %>>
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="zipcd" name="zipcd" readonly
								placeholder="우편번호" value=<%=userUpdate.getZipcd() %>>
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">생년월일</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="birth" name="birth"
								placeholder="생일" value="<%=userUpdate.getBirth() %>">
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">이메일</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="email" name="email"
								placeholder="이메일" value=<%=userUpdate.getEmail() %>>
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">연락처</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="tel" name="tel"
								placeholder="연락처" value=<%=userUpdate.getTel() %>>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">등 록</button>
						</div>
					</div>
				</form>
	
			</div>
		</div>
	</div>
</div>
</body>
</html>
