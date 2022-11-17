<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery1.7.2.js"></script>
	<script type="text/javascript">
		var contextPath = "${pageContext.request.contextPath}";
		$.ajaxSetup ({
			cache: false
		});
		function goHome(){
			location.href=contextPath+"/home/index"
		}
	</script>
	
	<tiles:insertAttribute name="content" />

