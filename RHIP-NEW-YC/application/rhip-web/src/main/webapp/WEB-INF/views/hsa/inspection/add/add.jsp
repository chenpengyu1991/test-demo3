<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/js/views/he/upload/upload.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/hsa/common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/hsa/inspection/add/add.js" type="text/javascript"></script>
<div class="toolbar" style="margin-top: 10px;">
	<!-- <a href="javascript:void(0)" id="hsa-location-inspiron-back-btn"><b class="fanhui">返回</b></a> --> 
	<a href="javascript:void(0)" id="hsa-location-inspiron-back-btn"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<!-- <a href="javascript:void(0)" id="hsa-location-inspiron-out-save-btn"><b class="baocun">保存</b></a> -->
	<a href="javascript:void(0)" id="hsa-location-inspiron-out-save-btn"  ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
</div>

<form id="hsa-input-form">
	<input type="hidden" value="${inspRecord.id}" name="id" />
	<div class="postcontent divFixed105" style="top: 60px;">
		<i class="popno">工作登记</i>
		<jsp:include page="../../location/list/locationSelect.jsp"></jsp:include>
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
						<td colspan="3"><input type="radio" reg='{"required":true}' name="inspHealthProfessional" style="display: none" data-validate="true" value=""><ehr:dic-radio dicmeta="HSA00006"   value="${inspRecord.inspHealthProfessional}" name="inspHealthProfessional" uninclude="1,4,99" parentCode="0"/></td>
					</tr>
				</table>
			</fieldset>
		</div>
		<jsp:include page="locationInspAddInput.jsp"></jsp:include>
	</div>
</form>
