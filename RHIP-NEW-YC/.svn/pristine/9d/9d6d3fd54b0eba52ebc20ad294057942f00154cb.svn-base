<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.founder.elb.entity.User"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>index</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/layout.css" />
	<!--[if IE 6]>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/DD_belatedPNG.js" ></script>
	<script type="text/javascript">
		DD_belatedPNG.fix('');
	</script>
	<![endif]-->
	<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/layout.js" type="text/javascript"></script>
	<script type="text/javascript">
		function f_addTab(tabid, text, url) {
			tab.addTabItem({
				tabid : tabid,
				text : text,
				url : url
			});
		}
	
		function logout() {
			var path = "${pageContext.request.contextPath}/access/logout";
			window.location.href = path;
		}
	
		function goTo(path) {
			f_addTab(tabid, tabname, path);
		}
		
		function navigate(url){
			var urlStr="${pageContext.request.contextPath}"+url;
			$("#mainframe").attr("src",urlStr);
		}		
	</script>
</head>

<%
	User currentUser = null;
	if (null != session.getAttribute("currentUser")) {
		currentUser = (User) session.getAttribute("currentUser");
	}
	String logonUserName = null != currentUser ? currentUser.getName() : "";
%>

<body>
	<div id="header"><i></i><s></s>
		<div id="banner">欢迎：<a target="mainframe" href="${pageContext.request.contextPath}/user/userUpdate"><%=logonUserName%></a>登录本系统！
			<span>
				<a href="${pageContext.request.contextPath}/user/changepwd" target="mainframe">修改密码</a> 
				<a href="${pageContext.request.contextPath}/home/list" target="mainframe">首页</a>
				<a href="javascript:logout()">退出系统</a>
			</span>
		</div>
	</div>
	<div id="side">
		<div id="menu">
			<ul>
			<c:if test="${ not empty menus}">${menus}</c:if>
			</ul>
		</div>
	</div>
	<div id="main" class="main"><iframe frameborder="0" id="mainframe"></iframe></div>
	<div id="split" class="split" ></div>	
    <div id="footer">Copyright &copy; 2012-2022 Founder International Co., Ltd.</div>
</body>
</html>
