<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cleave/cleave.min.js"></script>
<div class="dm-followup-from-content">
<form id="dm-followup-last-from" class="dm-followup-from">
	<input type="hidden" name="id" value="${tumor.id}" />
	<div class="postcontent">
		<div class="postdiv">
			<fieldset>
				<legend>肿瘤末次随访</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 100px; width: 30%" />
						<col style="min-width: 150px; width: 70%" />
					</colgroup>
					<tr>
						<th><label class="required" for="cancelDate">撤销管理日期</label></th>
						<td><tag:dateInput style="width:178px;"  onlypast="true" id="cancelDate" name="cancelDate" date="${tumor.cancelDate}" reg='{"required":true,"compare":["deathDate","ge","撤销管理日期不能小于死亡日期"]}' /></td>
					</tr>
					<tr>
						<th><label  class="required" for="deathDate">死亡日期</label></th>
						<td><tag:dateInput style="width:178px;"  onlypast="true" id="deathDate" name="deathDate" date="${tumor.deathDate}" reg='{"required":true,"compare":["cancelDate","le","死亡日期不能大于撤销管理日期"]}' /></td>
					</tr>
					<tr>
						<th><label  class="required" for="deathReason">死亡原因</label></th>
						<td><ehr:dic-radio dicmeta="DMD00051" name="deathReason" value="${tumor.deathReason }" reg="{'required':true}" /></td>
					</tr>
					<tr>
						<th><label  class="required" for="deathPlace">死亡地点</label></th>
						<td><ehr:dic-radio dicmeta="DMD00052" name="deathPlace" value="${tumor.deathPlace }" reg="{'required':true}" /></td>
					</tr>
				</table>
				<c:set var="input" value="${tumor}" scope="request"></c:set>
			</fieldset>
			<jsp:include page="../common/inputInfo.jsp"></jsp:include>
		</div>
	</div>
</form>
</div>

<script type="text/javascript">
	$(function () {
		autoFormatDate('cancelDate');
		autoFormatDate('deathDate');
	});
</script>