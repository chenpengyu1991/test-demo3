<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<form id="dm-followup-tumor-first-from" class="dm-followup-from">
	<input type="hidden" name="id" value="${tumor.id}" /> <input type="hidden" name="followupFlag" value="${tumor.followupFlag}" />
	<div class="postcontent">
		<div class="postdiv">
			<fieldset>
				<legend>肿瘤首次随访</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 100px; width: 30%" />
						<col style="min-width: 150px; width: 70%" />
					</colgroup>
					<tr>
						<th><label for="visitDate">随访日期</label></th>
						<td><fmt:formatDate value="${tumor.visitDate}" pattern="yyyy/MM/dd"/></td>
					</tr>
					<tr>
						<th><label  for="visitWayCode">随访方式</label></th>
						<td><ehr:dic dicmeta="DMD00026" code="${tumor.visitWayCode}" ></ehr:dic></td>
					</tr>
					<tr>
						<th><label>治疗情况</label></th>
						<td><ehr:dic dicmeta="DMD00048" code="${tumor.cure}"></ehr:dic></td>
					</tr>
					<tr>
						<th><label>治疗项目</label></th>
						<td><ehr:dic dicmeta="DMD00047" code="${tumor.cureProject}"></ehr:dic></td>
					</tr>
					<tr>
						<th><label for="opsHospital">手术医院</label></th>
						<td><c:out value="${tumor.opsHospital }" /></td>
					</tr>
					<tr>
						<th><label for="radiotherapyHospital">放疗医院</label></th>
						<td><c:out value="${tumor.radiotherapyHospital }" /></td>
					</tr>
					<tr>
						<th><label for="chemotherapyHospital">化疗医院</label></th>
						<td><c:out value="${tumor.chemotherapyHospital }"/></td>
					</tr>
					<tr>
						<th><label for="metastasis">转移情况</label></th>
						<td><ehr:dic dicmeta="FS10238" code="${tumor.metastasis }"></ehr:dic>
						<span style="display:${tumor.metastasis !='2'?'none':'inline' }" id="metastasisPart">转移部位:
						<c:out value="${tumor.metastasisPart }"  /></span></td>
					</tr>
					<tr>
						<ehr:dic dicmeta="FS10238" code="${tumor.theriomaHistoryFlag }"></ehr:dic>
						<span style="display:${tumor.theriomaHistoryFlag != '2' ? 'none' : 'inline' }">关系称谓,病名：
							<c:out value="${tumor.theriomaHistoryDetail }" />
						</span>
					</tr>
					<tr>
						<th><label for="currentStatusFlag">目前情况</label></th>
						<td><ehr:dic dicmeta="DMD00049" code="${tumor.currentStatusFlag}" /></td>
					</tr>
					<tr>
						<th><label for="guidanceContent">指导内容</label></th>
						<td><ehr:dic dicmeta="DMD00050" code="${tumor.guidanceContent }" /></td>
					</tr>
					<tr>
						<th><label  for="crtesianValue">卡氏评分</label></th>
						<td colspan="3">
							<c:out value="${tumor.crtesianValue}"></c:out>
						</td>
					</tr>
					<tr>
						<th><label for="definitionNextDate">下次随访日期</label></th>
						<td><fmt:formatDate value="${tumor.definitionNextDate}" pattern="yyyy/MM/dd"/></td>
					</tr>
				</table>
				<c:set var="input" value="${tumor}" scope="request"></c:set>
				<jsp:include page="../common/inputInfo.jsp"></jsp:include>
			</fieldset>
		</div>
	</div>
</form>