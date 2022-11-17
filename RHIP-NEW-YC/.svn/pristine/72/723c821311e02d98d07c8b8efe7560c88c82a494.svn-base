<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/views/fileManager/init.js" type="text/javascript"></script>

<!-- 资料下载 -->
<div class="navRight">
	<div class="location">
	  	当前位置：<a id="zlxz" class="space">资料下载</a>
	  	<c:if test="${not empty type}">
			<c:if test="${type == '01'}">&gt;&gt;<a id="bgxz2">表格下载</a></c:if>
			<c:if test="${type == '02'}">&gt;&gt;<a id="zcwj2">政策文件</a></c:if>
			<c:if test="${type == '03'}">&gt;&gt;<a id="rjxz2">软件下载</a></c:if>
		</c:if>
	</div>
	<div id="title" class="detailTitle">
		${fileDetail.title }
	</div>
	<div class="publishTime">
		<span>发布者：<ehr:user-org userCode="${fileDetail.createUserCode}"/></span>
		<span>发稿时间：<fmt:formatDate value="${fileDetail.createDate}" pattern="yyyy/MM/dd"/></span>
		<span>阅读次数：${fileDetail.times }</span>
	</div>
	<div class="detailContent">
		${fileDetail.contents }
	</div>
	<div class="downloadContent">
		<span>资料下载：</span>
		<ul>
			<c:forEach items="${uploadInfoRecord}" var="record" varStatus="status">
	      		<li>
		      		${status.count }、<a target="blank" id="fileDownload${record.id}" data-id="${record.id}">${record.originalFileName}</a>
	            </li>
	        </c:forEach>
        </ul>
	</div>
</div>

