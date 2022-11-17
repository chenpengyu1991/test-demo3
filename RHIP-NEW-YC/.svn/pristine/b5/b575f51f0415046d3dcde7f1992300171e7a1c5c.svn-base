<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/views/hsa/inspRecord/add/locInspView.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" id="hsa-input-back-btn"><b class="fanhui">返回</b></a> <a href="javascript:void(0)" id="hsa-input-add-btn"><b class="xinz">新增</b></a>
</div>
<input type="hidden" name="locationId" value="${locationId}" id="hiddenLocationId">
<input type="hidden" name="inspLocType" value="${type}" id="hiddenInspType">
<table>
	<tr>
		<td style="vertical-align: top; min-width: 100px; width: 200px;">
			<fieldset>
				<div id="hsa-location-input-list">
					<jsp:include page="locationInspRecordList.jsp"></jsp:include>
				</div>
			</fieldset>
		</td>
		<td style="vertical-align: top;">
			<div class="postdiv" id="hsa-location-input-add">
				<jsp:include page="locationInspViewAdd.jsp"></jsp:include>
			</div>
		</td>
	</tr>
</table>


