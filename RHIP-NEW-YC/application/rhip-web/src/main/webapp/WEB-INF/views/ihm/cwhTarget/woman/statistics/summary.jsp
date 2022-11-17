<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:150px;width: 25%;"/>
			<col style="min-width:80px;"/>
			<col style="min-width:80px;"/>
			<col style="min-width:80px;"/>
			<col style="min-width:80px;"/>
			<col style="min-width:80px;"/>
			<col style="min-width:80px;"/>
		</colgroup>
		<thead>
		<tr>
			<th rowspan="2">机构</th>
			<th rowspan="2">孕产妇登记数</th>
			<th rowspan="2">产前检查人次数</th>
			<th rowspan="2">孕妇叶酸发放</th>
			<th rowspan="2">产妇分娩数</th>
			<th rowspan="2">产后42天健康检查</th>
			<th colspan="${deliveryTypesLength}">各种分娩方式分娩人数</th>
		</tr>
		<tr>
			<c:forEach var="deliveryType" items="${deliveryTypes}" varStatus="status">
				<th><ehr:dic dicmeta="CV0210003" code="${deliveryType}"/></th>
			</c:forEach>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="motherhoodPeriodFollowup" items="${motherhoodPeriodFollowupList}" varStatus="status">
			<tr>
				<td class="centertd">
					<c:choose>
						<c:when test="${motherhoodPeriodFollowup.ORGAN_CODE=='合计'}">合计</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${genreCode == '0'}"><ehr:dic dicmeta="FS990001" code="${motherhoodPeriodFollowup.ORGAN_CODE}"/></c:when>
								<c:otherwise><ehr:tip><ehr:org code="${motherhoodPeriodFollowup.ORGAN_CODE}"/></ehr:tip></c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</td>
				<td class="centertd"><ehr:tip>${motherhoodPeriodFollowup.pregnantWomenRegNum}</ehr:tip></td>
				<td class="centertd"><ehr:tip>${motherhoodPeriodFollowup.prenatalExamNum}</ehr:tip></td>
				<td class="centertd"><ehr:tip>${motherhoodPeriodFollowup.prenatalFolicAcidRelease}</ehr:tip></td>
				<td class="centertd"><ehr:tip>${motherhoodPeriodFollowup.childbirthNum}</ehr:tip></td>
				<td class="centertd"><ehr:tip>${motherhoodPeriodFollowup.days42PostPartumExam}</ehr:tip></td>
				<c:forEach var="diffWayChirdbirthNum" items="${motherhoodPeriodFollowup.diffWayChirdbirthNum}" varStatus="status">
					<td class="centertd"><ehr:tip>${diffWayChirdbirthNum}</ehr:tip></td>
				</c:forEach>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>