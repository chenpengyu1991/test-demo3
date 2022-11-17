<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/mdm/organizationArea/orgIndex.js" type="text/javascript"></script>
<div  class="sectionnoborder">
	<%-- <ul id=tags>
		<c:forEach var="year" items="${years}" varStatus="status">
			<c:set var="selectTagClass" value=""/>
			<c:if test="${status.index eq 0}">
				<c:set var="selectTagClass" value="selectTag"/>
			</c:if>
			<li  class="${selectTagClass}" >
				<a id='taga${year}' data-year="${year}" href='javascript:void(0)'>${year}年</a>
			</li>
		</c:forEach>
	</ul>

	<div id="tagContent">
		<div id="tagContent3" class="selectTag"  style='height:600px;'></div>
	</div> --%>
	
	<div class="layui-tab layui-tab-brief" lay-filter="administrativeOrganizationTab">
	   <ul class="layui-tab-title">
	   <c:forEach var="year" items="${years}" varStatus="status">
	   		<li <c:if test="${status.index eq 0}">class="layui-this"</c:if> lay-id="${year}">
	   			<a id='taga${year}' data-year="${year}" href='javascript:void(0)' tab-content-id="tagContent-${year}">${year}年</a>
	   		</li>
		</c:forEach>
	 </ul>
	<div class="layui-tab-content" style="margin-top: -10px;">
		<c:forEach var="year" items="${years}" varStatus="status">
			 <div <c:if test="${status.index eq 0}">class="layui-tab-item layui-show"</c:if><c:if test="${status.index ne 0}">class="layui-tab-item"</c:if> id="tagContent-${year}" ></div>
		</c:forEach>
	 </div>
  </div>
  
    <input type="hidden" id="tag">
	<input type="hidden" id="currentYear" value="${currentYear}">
</div>