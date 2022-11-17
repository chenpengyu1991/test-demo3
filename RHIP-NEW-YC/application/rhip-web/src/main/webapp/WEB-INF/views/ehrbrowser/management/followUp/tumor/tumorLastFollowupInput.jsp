<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
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
						<th><label for="cancelDate">撤销管理日期</label></th>
						<td><fmt:formatDate value="${tumor.cancelDate}" pattern="yyyy/MM/dd"/></td>
					</tr>
					<tr>
						<th><label  for="deathDate">死亡日期</label></th>
						<td><fmt:formatDate value="${tumor.deathDate}"  pattern="yyyy/MM/dd"/></td>
					</tr>
					<tr>
						<th><label  for="deathReason">死亡原因</label></th>
						<td><ehr:dic dicmeta="DMD00051" code="${tumor.deathReason }" ></ehr:dic></td>
					</tr>
					<tr>
						<th><label  for="deathPlace">死亡地点</label></th>
						<td><ehr:dic dicmeta="DMD00052" code="${tumor.deathPlace }"></ehr:dic></td>
					</tr>
				</table>
				<c:set var="input" value="${tumor}" scope="request"></c:set>
				<jsp:include page="../common/inputInfo.jsp"></jsp:include>
			</fieldset>
		</div>
	</div>
</form>