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

<form id="frm" action="/userDetail" method="get">
	<input type="hidden" id="userId" name="userId"/>
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
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped table-hover" id = "tableId">
				<tr>
					<th>번호</th>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>사용자 별명</th>
				</tr>
				
				<!-- pageList loop 이용하여 출력 -->
				<% List<UserVo> pageList = (List<UserVo>) request.getAttribute("pageList"); %>
				<% for(int i = 0; i < pageList.size(); i++){ %>
				<tr onClick = "alertId('<%=pageList.get(i).getUserId()%>')">
					<td><%=pageList.get(i).getRnum() %></td>
					<td><%=pageList.get(i).getUserId() %></td>
					<td><%=pageList.get(i).getName() %></td>
					<td><%=pageList.get(i).getBirth() %></td>
				</tr>
				<% } %>
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
			<%int count = (Integer)(request.getAttribute("pageCnt")); %>
			<%for(int i=0; i < count; i++){ %>
			<li><a href="/userPageList?page=<%=i+1 %>&pageSize=10"><%=i+1 %></a></li>
			<%} %>
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
