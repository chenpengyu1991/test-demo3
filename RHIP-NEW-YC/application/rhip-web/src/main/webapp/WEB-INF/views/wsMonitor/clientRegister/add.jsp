<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script type="text/javascript">
	require(['views/wsMonitor/clientRegister/add'],function(clientRegisterAdd){
		clientRegisterAdd.load();
	});
</script>

<div class="postcontent">
	<form id="clientInfoAddForm" name="clientInfoAddForm" action="" method="post">
		<input type="hidden" name="id" value="${clientInfo.id}">
		<div class="postdiv">
			<table style="width:99%" class="posttable">
				<colgroup>
					<col style="width: 30%;"/>
					<col style="width: 70%;"/>
				</colgroup>
				<tr>
					<th>
						<label class="required">来访机器IP地址</label>
					</th>
					<td>
						<input type="text" id="userIp" name="userIp" reg='{"required":"true","maxlength":"50"}' value="${clientInfo.userIp}"/>
					</td>
				</tr>
				<tr>
					<th>
						<label class="required">所属机构</label>
					</th>
					<td>
						<tag:autoSelect name="orgCode" id="orgCodeForAdd" codeValue="${clientInfo.orgCode}" reg='{"required":"true"}' style="width:200px" ></tag:autoSelect>
					</td>
				</tr>
				<tr>
					<th>
						<label>备注</label>
					</th>
					<td>
						<textarea id="remark" name="remark" reg="{'maxlength':200}" rows="3">${clientInfo.remark}</textarea>
					</td>
				</tr>
				<tr style="width:100%;">
					<td colspan="2" style="width:100%;">请选择需要关联的服务端(必选)：</td>
				</tr>
				<tr style="width:100%;">
					<td colspan="2" style="width:100%;">
						<jsp:include page="./servicelist.jsp"/>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>
