
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://bootstrapk.com/favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <%@include file="/common/basicLib.jsp" %>
    <link href="/css/bootstrap.min.css" rel="stylesheet">

	<script type="text/javascript">
		$(document).ready(function(){
			// remember 쿠키값이 Y이면 
			// remember-me 체크박스 체크
			if(getCookie("remember")=="Y"){
				document.getElementById("remember").checked = true;
			// userId input value를 userId 쿠키값으로 설정
				$("#remember").attr("checked", true);
// 				$("#remember").prop("checked", true);
				
				$("#userId").val(getCookie("userId"));
			}
		});
		
	
		function getCookie(cookieName){
			var cookies = document.cookie.split("; ");
			
			var cookieValue = "";
			
			for(var i = 0; i < cookies.length; i++){
				var str = cookies[i];
				if(str.startsWith(cookieName + "="))
					cookieValue = str.substring((cookieName + "=").length);
			}
			return cookieValue;
		}
			console.log(getCookie("remember"));
			console.log(getCookie("userId"));
	</script>
	

    <!-- Custom styles for this template -->
    <link href="/css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="/dditLogin" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input id="userId" type="text" name="user_id" class="form-control" placeholder="User Id" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="user_pw" class="form-control" placeholder="Password" required>
        
         <div class="checkbox">
          <label>
            <input id="remember" type="checkbox" value="remember-me" name="remember-me"> Remember me
          </label>
        </div>
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
