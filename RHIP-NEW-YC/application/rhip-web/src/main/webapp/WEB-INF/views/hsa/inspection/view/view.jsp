<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/js/views/he/upload/upload.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/hsa/common.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/js/views/hsa/inspection/add/view.js" type="text/javascript"></script>
<div class="toolbar" style="margin-top: 10px;">
	<!-- <a href="javascript:void(0)" id="hsa-input-back-btn"><b class="fanhui">返回</b></a> -->
	<a href="javascript:void(0)" id="hsa-input-back-btn"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
</div>
<input type="hidden" id="has-insprecord-flag" value="${flag}">
<input type="hidden" id="has-insprecord-id" value="${inspRecord.id}">
<form id="hsa-input-form">
		<div class="postcontent divFixed105" style="top: 60px;">
			<i class="popno">工作登记</i>
				<c:set var ="locationInfo" value="${inspRecord.locationInfo}" scope="request" />
				<jsp:include page="locationInfoView.jsp"></jsp:include>
			<div class="postdiv">
			<fieldset class="layui-elem-field">
				<table class="posttable">
					<colgroup>
						<col style="width: 12%;" />
						<col style="width: 38%;" />
						<col style="width: 12%;" />
						<col style="width: 38%;" />
					</colgroup>
					<tr>
						<th><label class="required">巡查卫生专业</label></th>
						<td colspan="3"><input type="text" value=' <ehr:dic dicmeta="HSA00006" code="${inspRecord.inspHealthProfessional}"  />'></td>
					</tr>
				</table>
			</fieldset>
		</div>
				<jsp:include page="../add/locationInspAddInput.jsp"></jsp:include>
		</div>
</form>
