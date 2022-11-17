<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<% 
response.setHeader("PRagma","No-cache"); 
response.setHeader("Cache-Control","no-cache"); 
response.setDateHeader("Expires", 0);
%> 

 	
	<script type="text/javascript">
		var contextPath = "${pageContext.request.contextPath}";
        var casLogoutUrl="${logoutUrl}";
        var logoutServeceUrl="${logoutServeceUrl}";
		//在查询预约详细的时候使用到，用于区分患者页面的显示
		var showBack = false;
		var isJg = "";
		var showList = "";
	</script>
	 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin/font.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin/xadmin.css">
    <%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.css" /> --%>

	<script data-main="${pageContext.request.contextPath}/js/util/main_x_admin" src="${pageContext.request.contextPath}/js/require/require.js"></script>


