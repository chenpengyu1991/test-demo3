<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--[if IE 6]>
	<style type="text/css">
		.helpImg {
			_margin-top: -10px;
		}
	</style>
<![endif]-->


<c:forEach var="menuForm" items="${menus}">
	<%-- <c:choose>
		<c:when test="${menuForm.menu.theme == '2' || menuForm.menu.theme == '3'}">
			<span><a class="${menuForm.menu.nameEn}" href="${pageContext.request.contextPath}${menuForm.menu.path }" ></a></span>
		</c:when>
		<c:otherwise> --%>
			<span><a class="${menuForm.menu.nameEn}" href="javascript:void(0);" onclick="javascript:baseLayoutLoad.loadMenuContent('${pageContext.request.contextPath}${menuForm.menu.path}');"></a></span>
	<%-- 	</c:otherwise>
	</c:choose> --%>
</c:forEach>
