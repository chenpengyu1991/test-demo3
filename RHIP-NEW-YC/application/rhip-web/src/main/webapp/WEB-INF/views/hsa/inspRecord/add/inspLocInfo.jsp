<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<fieldset>
	<legend>巡查地点信息</legend>
	<table class="posttable">
		<colgroup>
			<col style="width: 12%;" />
			<col style="width: 21%;" />
			<col style="width: 12%;" />
			<col style="width: 21%;" />
			<col style="width: 12%;" />
			<col style="width: 21%;" />
		</colgroup>
		<tr>
			<th><label for="hsa-location-search-input" ${flag!="view"?"class='required'":''}>巡查地点</label></th>
			<td><tag:autoSelect name="locationId" id="hsa-location-search-input" style="width:200px;" codeValue="${locationInfo.id}"
					reg="{'required':true}" nameValue="${locationInfo.unitName}"
				></tag:autoSelect></td>
			<c:if test="${flag!='view'}">
				<td colspan="4"><a style="" href="javascript:void(0)" id="hsa-add-location-info"> <b class="xinz"
						style="font-weight: normal; margin-right: 6px; padding-left: 20px; padding-top: 1px; padding-bottom: 1px; height: 32px; line-height: 32px;"
					>增加</b></a></td>
			</c:if>
		</tr>
	</table>
	<jsp:include page="locationInfoView.jsp"></jsp:include>
</fieldset>
