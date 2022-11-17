<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/WEB-INF/tld/ehr-tag.tld"%>

<script src="${pageContext.request.contextPath}/js/views/layouts/page.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/serviceInfo/init.js" type="text/javascript"></script>

<div class="navRight">
	<div class="contentlist">
		  <input type="hidden" id="code" value="${id}"/>
		  <input type="hidden" id="parentCode" value="${parentCode}"/>
		  <div class="location">
		  	当前位置：<c:if test="${parentInfoType!=null}"><a id="title${parentInfoType.id}" data-code="${parentInfoType.id}" class="space">${parentInfoType.name}</a></c:if>
			<c:if test="${infoType!=null}">&gt;&gt;<a id="subTitle${infoType.id}" data-code="${infoType.id}" data-parentCode="${infoType.parentCode}">${infoType.name}</a></c:if>
		  </div>
		  <div class="contents">
			  <ul>
			  	<c:forEach items="${serviceInfoList}" var="serviceInfo">
			      	<li>
		           		<a id="serviceInfoDetail${serviceInfo.id}" data-id="${serviceInfo.id}">${serviceInfo.title}</a>
		           		<span><fmt:formatDate value="${serviceInfo.creatTime}" pattern="yyyy/MM/dd"/></span>
		           </li>
		      </c:forEach>
			  </ul>
			</div>
			<ehr:pagination action="contentPage.recordsPerform"/>
	</div>
</div>
