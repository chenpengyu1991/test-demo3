<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ep/iodineNutrition/samplingInfoEdit.js"></script>
<div id="infoEditFormDiv">
<form id="infoEditForm">
	<div class="postcontent">
		<div class="postdiv">
			<fieldset>
				<legend>抽样信息</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 80px; width: 30%;"/>
						<col style="min-width: 150px; width: 70%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th><label class="required">抽样点序号</label></th>
						<td>
						    <c:if test="${empty sampling.samplingNo}">
						    	<input type="text" name="samplingNo" value="${sampling.samplingNo}" style="width: 60px" reg='{"required":"true", "maxlength":"10"}' />
						    </c:if>
							<c:if test="${not empty sampling.samplingNo}">${sampling.samplingNo}
								<input type="hidden" name="id" value="${sampling.id}" />
								<input type="hidden" name="samplingNo" value="${sampling.samplingNo}" />
							</c:if>
						</td>
					</tr>
					<tr>
						<th><label class="required">抽样点类型</label></th>
						<td><ehr:dic-list id="sampling_type" name="type" dicmeta="FS10272" value="${sampling.type}" reg='{"required":"true"}' /></td>
					</tr>
					<tr>
						<th><label class="required">抽样点名称</label></th>
						<td><tag:autoSelect id="sampling_name" name="code" nameValue="${sampling.name}" codeValue="${sampling.code}"  reg="{'required':'true'}" /></td>
					</tr>
					<tr>
						<th>备注</th>
						<td colspan="3"><input type="text" name="remark" value="${sampling.remark}" reg='{"maxlength":"100"}' /></td>
					</tr>
					</tbody>
				</table>
			</fieldset>
		</div>
	</div>
</form>
<div class="toolbarpop" style="margin-top: -50px;">
	<input type="button" id="save" value="保 存"/>
</div>
</div>