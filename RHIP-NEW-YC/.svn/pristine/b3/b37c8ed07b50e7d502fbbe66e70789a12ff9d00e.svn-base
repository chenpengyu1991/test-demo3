<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/hsa/sodp/addsodpform.js"></script>
<%--可疑职业病人弹窗 --%>
<div class="toolbar">
	<!--  <a href="javascript:void(0)" id="sodp-form-back-btn"><b class="fanhui">取消</b></a> -->
	<c:choose>
		<c:when test="${update==true}">
			<a href="javascript:void(0);" id="sodp-form-save-btn"><b class="baocun">保存</b></a>
		</c:when>
		<c:otherwise>
			<a href="javascript:void(0);" id="sodp-form-add-btn"><b class="tijiao" >添加</b></a>
		</c:otherwise>
	</c:choose>
</div>
<div id="health-card-main">
	<form id="sodp-add-dia-form">
		<div class="postcontent">
			<div class="postdiv">
					<jsp:include page="perdis.jsp"></jsp:include>
			</div>
		</div>
	</form>
</div>
