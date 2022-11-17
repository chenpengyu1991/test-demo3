<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

	<div class="postcontent">
			<div class="postdiv">
		<fieldset>
			<legend>肿瘤随访</legend>
			<table class="posttable">
				<colgroup>
					<col style="min-width: 100px; width: 30%" />
					<col style="min-width: 150px; width: 70%" />
				</colgroup>
				<tr>
					<th><label for="visitDate">随访日期</label></th>
					<td><fmt:formatDate value="${tumor.visitDate}" pattern="yyyy/MM/dd"/></td>
				<tr>
					<th><label  for="visitWayCode">随访方式</label></th>
					<td><ehr:dic dicmeta="DMD00026"  code="${tumor.visitWayCode}" ></ehr:dic>
				</tr>
				<tr>
					<th>治疗情况</th>
					<td><ehr:dic dicmeta="DMD00048" code="${tumor.cure }"></ehr:dic></td>
				</tr>
				<tr>
					<th><label for="recur">有无复发</label></th>
					<td><ehr:dic dicmeta="FS10238" code="${tumor.recur }"></ehr:dic>
					<span style="display:${tumor.recur !='2'?'none':'inline' }">复发次数:
					<c:out value="${tumor.recurTime}" />次</span></td>
				</tr>
				<tr>
					<th><label for="metastasis">转移情况</label></th>
					<td><ehr:dic dicmeta="FS10238" code="${tumor.metastasis }"></ehr:dic>
					<span style="display:${tumor.metastasis !='2'?'none':'inline' }" >
					转移部位:<c:out value="${tumor.metastasisPart }" /></span></td>
				</tr>
				<tr>
					<th><label >目前情况</label></th>
					<td><ehr:dic dicmeta="DMD00049" code="${tumor.currentStatusFlag}"/></td>
				</tr>
				<tr>
					<th><label for="guidanceContent">指导内容</label></th>
					<td><ehr:dic dicmeta="DMD00050" code="${tumor.guidanceContent }"></ehr:dic></td>
				</tr>
				<tr>
					<th><label for="curSymptom">卡氏评分</label></th>
					<td>
						<c:out value="${tumor.crtesianValue}" />
					</td>
				</tr>
				<tr>
					<th><label for="nextVisitDate">备注</label></th>
					<td><c:out value="${tumor.remark }" /></td>
				</tr>
			</table>
				<c:set var="input" value="${tumor}" scope="request"></c:set>
				<jsp:include page="../common/inputInfo.jsp"></jsp:include>
		</fieldset>
		</div>
	</div>