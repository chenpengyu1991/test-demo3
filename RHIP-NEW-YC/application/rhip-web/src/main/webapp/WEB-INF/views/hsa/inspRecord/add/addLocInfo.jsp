<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/hsa/inspRecord/add/inspLocInfo.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" id="hsa-back-locInfo-btn"><b class="fanhui">返回</b></a> <a href="javascript:void(0)" id="hsa-save-LocInfo-btn"><b
		class="baocun"
	>保存</b></a>
</div>
<jsp:include page="addLocInfoInput.jsp"></jsp:include>