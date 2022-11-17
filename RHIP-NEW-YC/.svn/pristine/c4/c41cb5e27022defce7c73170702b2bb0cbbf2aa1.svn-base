<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page contentType="text/html;charset=UTF-8"%>
<%
	response.setHeader("PRagma","No-cache");
	response.setHeader("Cache-Control","no-cache");
	response.setDateHeader("Expires", 0);
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>基本公共卫生管理系统</title>
	<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
	<META HTTP-EQUIV="Expires" CONTENT="0">
	<link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/base/login.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/newbase/base.css" type="text/css"  rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/css/newbase/chooseOrg.css" type="text/css"  rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/css/redmond/jquery-ui-1.11.0.custom.css" type="text/css"  rel="stylesheet" />
	<link rel = "Shortcut Icon" href="${pageContext.request.contextPath}/images/favicon.ico">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/fonts/iconic/css/material-design-iconic-font.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login/util.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login/main.css">
	
	
	<script src="${pageContext.request.contextPath}/js/jquery/jquery-1.1.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/jquery/jquery-ui-1.11.0.custom.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js" type="text/javascript"></script>
	<!--[if lt IE 7.]>
	<script src="${pageContext.request.contextPath}/js/png/DD_belatedPNG.js" type="text/javascript"></script>
	<![endif]-->
	<script type="text/javascript">
        function choose(link) {
            $(".caption").removeClass("chosen");
            $(link).parent().addClass("chosen");
            $("#orgCode").val($(link).attr("data-code"));
        }

        function login()
        {
            var form = document.getElementById('loginFormId');
            var orgId=$("#orgCode").val();
            if(orgId==undefined)
            {
                alert("请选择机构");
                return false;
            }
            form.action = "${pageContext.request.contextPath}/access/getAccess/"+orgId;
            form.submit();
        }

        $(function(){
        	
        	$("#loginOrgBtnId").click(function(e) {
				e.preventDefault();
				login();
			});
        	
            document.onkeydown = function(e){
                var ev = document.all ? window.event : e;
                if(ev.keyCode==13) {
                    login();
                }
            }
        })
        

	</script>
</head>

<body id="login_bg">
<p align="center" class="title_txt">
	<%-- <img src="${pageContext.request.contextPath}/images/title_txt.png" /> --%>
</p>
<div class="container">
	<div class="well">
		<div class="container-fluid">
			<div>
				<c:forEach var="org" items="${organizations}">
					<div class="col-md-2 col-sm-4-col-xs-6 station-item">
						<div class="caption ${org.organCode eq lastLoginOrg ? 'chosen' : ''}">
							<a href="javascript:void(0)" onclick="choose(this)" data-code="${org.organCode}">
								<img src="${pageContext.request.contextPath}/images/org/station.png" class="station">
								<p>${org.organName}</p>
							</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
<div>
	<form id="loginFormId" name="loginForm" action="" method="post">
		<input type="hidden" id="orgCode" value="${lastLoginOrg}">
	</form>
	<p align="center">
		<!-- <input name="login" type="button" class="btn_login" onClick="login()" /> -->
		<div class="container-login100-form-btn">
						<button class="login100-form-btn" id="loginOrgBtnId">
							登录
						</button>
					</div>
	</p>
</div>
</body>
</html>
