<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="ehr" uri="/WEB-INF/tld/ehr-tag.tld"%>
<script src="${pageContext.request.contextPath}/js/views/layouts/page.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/fileManager/init.js" type="text/javascript"></script>

<input type="hidden" id="type" value="${type}"/>
<div class="navRight">
	<div class="contentlist">
		<div class="location">
		  	当前位置：<a id="zlxz" class="space">资料下载</a>
		  	<c:if test="${not empty type}">
				<c:if test="${type == '01'}">&gt;&gt;<a id="bgxz1">表格下载</a></c:if>
				<c:if test="${type == '02'}">&gt;&gt;<a id="zcwj1">政策文件</a></c:if>
				<c:if test="${type == '03'}">&gt;&gt;<a id="rjxz1">软件下载</a></c:if>
			</c:if>
		</div>
		<div class="contents">
			<ul>
			 	<c:forEach items="${fileList}" var="record">
		      		<li>
	           			<a id="fileManagerDetail${record.id}" data-id="${record.id}" data-type="${record.fileType}" style="float:left" >${record.title}</a>
	           			<span style="float:right"><fmt:formatDate value='${record.createDate}' pattern='yyyy/MM/dd'/></span>
		            </li>
		      </c:forEach>
			</ul>
		</div>
		<ehr:pagination action="contentPage.fileManagerSearch"/>
	</div>
</div>