<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/js/views/he/upload/upload.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/hsa/inspection/add/add.js" type="text/javascript"></script>
<div class="toolbar" style="margin-top: 10px;">
	<!-- <a href="javascript:void(0)" id="hsa-location-inspiron-back-btn"><b class="fanhui">返回</b></a> -->
	<a href="javascript:void(0)" id="hsa-location-inspiron-back-btn"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	 <!-- <a href="javascript:void(0)"
		id="hsa-location-inspiron-out-update-btn"
	><b class="baocun">保存</b></a> -->
	<a href="javascript:void(0)"
		id="hsa-location-inspiron-out-update-btn"  ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
</div>
<div class="postcontent divAbsolute55" style="top: 160px;">
	<i class="popno">工作登记</i> <input type="hidden" id="hsaInspRecordHiddenId" value="${inspRecord.id}" name="id" /> <input type="hidden"
		id="hsaInspRecordIsGuide" value="${inspRecord.isGuide}"
	/> <input type="hidden" id="hsaInspRecordIsReport" value="${inspRecord.isReport}" />
</div>
<form id="hsa-input-form">
	<input type="hidden" value="${inspRecord.id}" name="id" /> 
	<div class="postcontent">
		<jsp:include page="../view/locationInfoView.jsp"></jsp:include>
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
						<td colspan="1"><input type="hidden" value="${inspRecord.inspHealthProfessional}" name="inspHealthProfessional" /> <input readonly="readonly" type="text" value=' <ehr:dic dicmeta="HSA00006" code="${inspRecord.inspHealthProfessional}"  />'></td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</fieldset>
		</div>
		<jsp:include page="locationInspAddInput.jsp"></jsp:include>
	</div>
</form>