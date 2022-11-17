<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<head>
	<title>基本公共卫生管理系统</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/fonts/iconic/css/material-design-iconic-font.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login/util.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login/main.css">
	<%-- <script src="${pageContext.request.contextPath}/js/login/vendor/jquery/jquery-3.2.1.min.js"></script> --%>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery1.7.2.js"></script>
	<script src="${pageContext.request.contextPath}/js/login/main.js"></script>
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100" style="background-image: url('${pageContext.request.contextPath}/images/login/bg-02.jpg');">
			<div class="wrap-login100">
				<form class="login100-form"  id="loginFormId" name="loginForm" method="post">
					<%-- <span class="login100-form-logo">
						<img alt="" src="${pageContext.request.contextPath}/images/wsb.png" style="width: 120px;height: 170px;margin-bottom: -51px;"/>
					</span> --%>

					<span class="login100-form-title p-b-34 p-t-27">
							基本公共卫生管理系统
			       </span>
					<div class="wrap-input100 validate-input" data-validate = "输入用户名">
						<input class="input100" type="text" name="userName" placeholder="用户名" id="nameTextId" />
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="输入密码">
						<input class="input100" type="password" name="password" placeholder="密码" id="passwordTextId" />
						<span class="focus-input100" data-placeholder="&#xf191;"></span>
					</div>


					<div class="container-login100-form-btn">
						<button class="login100-form-btn" id="loginBtnId">
							登录
						</button>
					</div>
					
					<div class="text-center p-t-90">
						<c:if test="${not empty message}">
							<span style="color: red;font-style: italic;letter-spacing:2px;">${message}</span>
						</c:if>
					</div>
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<script language="javascript" type="text/javascript">
	    function login()
	    { 
			var form = document.getElementById('loginFormId');	
			/* var type=$(":radio:checked").val();			
			var act=type=="0"?"login":"plogin";  */
			form.action = "${pageContext.request.contextPath}/access/"+"login"; 
			form.submit(); 
	    }
	   $(function(){
			$("#nameTextId")[0].focus();
			document.onkeydown = function(e){ 
			    var ev = document.all ? window.event : e;
			    if(ev.keyCode==13) {
			    	login();
			    }
			}
			
			$("#loginBtnId").click(function(e) {
				e.preventDefault();
				login();
			});
	   });
	   
	   // 解决会话过期登录页面问题
	   if(window !=top) {
		   top.location.href = "${pageContext.request.contextPath}/access/logout";
	    }
	   
	</script> 
</body>
</html>