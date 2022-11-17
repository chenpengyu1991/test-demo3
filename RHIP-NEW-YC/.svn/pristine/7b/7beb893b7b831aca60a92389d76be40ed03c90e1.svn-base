<%@page import="com.founder.rhip.portal.util.InfoConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script src="${pageContext.request.contextPath}/js/views/serviceInfo/init.js" type="text/javascript"></script>

<div class="navRight">
	<div class="location">
		当前位置：<c:if test="${parentInfoType!=null}"><a id="title${parentInfoType.id}" data-code="${parentInfoType.id}" class="space">${parentInfoType.name}</a></c:if>
		<c:if test="${infoType!=null}">&gt;&gt;<a id="subTitle${infoType.id}" data-code="${infoType.id}" data-parentCode="${infoType.parentCode}">${infoType.name}</a></c:if>
	</div>
	<div id="title" class="detailTitle">
		${serviceInfo.title }
	</div>
	<div class="publishTime">
		<span>发布者：${serviceInfo.author }</span>
		<span>发稿时间：<fmt:formatDate value="${serviceInfo.creatTime}" pattern="yyyy/MM/dd"/></span>
		<span>阅读次数：${serviceInfo.times }</span>
	</div>
	<div class="detailContent">
		${serviceInfo.contents}
	</div>
</div>