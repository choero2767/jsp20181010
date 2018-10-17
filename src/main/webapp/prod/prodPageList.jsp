<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<style type="text/css">
	.userClick{
		cursor : pointer;
	}
</style>

<script type="text/javascript">
	/*$(document).ready(function addRowHandlers(){
		var table = document.getElementById("tableId");
		var rows = table.getElementsByTagName("tr");
		for(i = 0; i < rows.length; i++){
			var currentRow = table.row[i];
			var createClickHandler = function(row){
				return function(){
					var cell = row.getElementsByTagName("td")[1];
					var id = cell.innerHTML;
					alert("사용자 아이디 : " + id);
				};
			};
			currentRow.onClick = createClickHandler(currentRow);
		}
	});
	*/
	function alertId(userId){
		alert("사용자 아이디 : " + userId);
		location.href = "/userDetail?userId=" + userId; 
	}
	
	// 교수님 방식
	$(document).ready(function(){
		console.log("document.ready");
		
		// tr에 select (class="userClick")
		$(".userClick").click(function(){
			console.log("userClick");
		});
		
		var ev = "click";
		$(".userClick").on("click", function(){
			console.log("userClick");
			var userId = $(this).children()[1].innerText;
			
			$("#userId").val(userId);
			$("frm").submit();
		});
	});
</script>
</head>

<form id="frm" action="/prodPageDetail" method="get">
	<input type="hidden" id="prod_id" name="prod_id"/>
</form>

<body>
	<%-- @은 지시자 --%>
	<%-- header --%>
	<%@ include file="/common/header.jsp" %> 
	
	<div class="container-fluid">
		<div class="row">
		
			<%-- left --%>
			<%@ include file="/common/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">제품</h2>
		<div class="table-responsive">
			<table class="table table-striped table-hover" id = "tableId">
				<tr>
					<th>번호</th>
					<th>제품 아이디</th>
					<th>제품 이름</th>
					<th>제품 별명</th>
				</tr>
				
				<!-- pageList loop 이용하여 출력 -->
				
				
				<c:forEach items="${pageList }" var="vo">
					<tr onClick = "alertId('${vo.userId}')">
						<td>${vo.rnum }</td>
						<td>${vo.prod_id }</td>
						<td>${vo.prod_name }</td>
						<td><fmt:formatDate value="${vo.prod_insdate}" pattern="yyyy-MM-dd"/></td>
					</tr>
				</c:forEach>
				
					
			</table>
		</div>
		
		<!-- userForm -->
		<a class="btn btn-default pull-right" href="/userForm">사용자 등록</a>

		<div class="text-center">
			<ul class="pagination">
			 <li>
      			<a href="/userPageList?page=1&pageSize=10" aria-label="Previous">
       			 <span aria-hidden="true">&laquo;</span>
      			</a>
    		</li>
			
			
			<c:forEach begin="0" end="${pageCnt-1 }" var="i">
					<li><a href="/userPageList?page=${i+1 }&pageSize=10">${i+1 }</a></li>
			</c:forEach>
			
			
			
			 <li>
      		<a href="#" aria-label="Next">
        		<span aria-hidden="true">&raquo;</span>
     		 </a>
    		</li>
			</ul>
		</div>
	</div>
</div>
			</div>
		</div>
	</div>
</body>
</html>
