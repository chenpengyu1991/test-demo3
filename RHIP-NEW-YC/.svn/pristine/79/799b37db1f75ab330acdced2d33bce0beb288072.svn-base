<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="${pageContext.request.contextPath}/js/views/idm/case/export.js" type="text/javascript"></script>
<form id="exportSearch">
	<input type="hidden" id="idcard" name="idcard" value="${searchForm.idcard}">
	<input type="hidden" id="name" name="name" value="${searchForm.name}">
	<input type="hidden" id="birthBeginDate" name="birthBeginDate" value="${searchForm.birthBeginDate}">
	<input type="hidden" id="birthEndDate" name="birthEndDate" value="${searchForm.birthEndDate}">
	<input type="hidden" id="surveyOrgCode" name="surveyOrgCode" value="${searchForm.surveyOrgCode}">
	<input type="hidden" id="infectiousCode" name="infectiousCode" value="${searchForm.infectiousCode}">
	<input type="hidden" id="caseStatus" name="caseStatus" value="${searchForm.caseStatus}">
	<input type="hidden" id="logoff" name="logoff" value="${searchForm.logoff}">
	<div class="postcontent">
		<div class="postdiv">
			<fieldset>
				<legend>选择导出列</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%"/>
						<col style=""/>
					</colgroup>
					<tr>
						<th>列名</th>
						<td>
							<c:forEach var="columnCN" items="${columnCNs}">   
					           <input type="checkbox" name="columnName" value="${columnCN.key}" /> ${columnCN.value} &nbsp;&nbsp;
					        </c:forEach>
						</td>
					</tr>
				</table>
			</fieldset>
			<div style="text-align: center">
				<input type="button" id="export" name="export" onclick="exportTable.addColumns()" value="添加导出列"/>
			</div>
			<div id="warmTips" style="text-align: center; color: red; display: none;">
				<label>请选择导出列</label>
			</div>
			<div id="resultDiv">

			</div>
		</div>
	</div>
</form>