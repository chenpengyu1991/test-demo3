<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JFZX" value="<%=RoleType.JKJFZX.getValue()%>"/>
<c:set var="JFYS" value="<%=RoleType.ZXJFYS.getValue()%>"/>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<script src="${pageContext.request.contextPath}/js/views/mhm/statistics/report/list.js" type="text/javascript"></script>
<div id="reportList" class="repeattable">
	<form id="reportForm">
		<table id="reportTable" class="layui-table x-admin-sm-table-list-middle">
			<colgroup>
				<ehr:authorize ifAnyGranted="${JFZX},${ADMIN}">
					<c:if test="${empty monthFlag }"><col style="width: 130px;"/></c:if>
				</ehr:authorize>			
				<col style="width: 150px;"/>
				<c:if test="${not empty monthFlag }"><col style="width: 80px;"/></c:if>
				<col style="width: 80px;"/>
				<col style="width: 80px;"/>
				<col style="width: 80px;"/>
				<col style="width: 80px;"/>
				<col style="width: 80px;"/>
				<col style="width: 80px;"/>
				<col style="width: 80px;"/>
				<col style="width: 80px;"/>
				<col style="width: 80px;"/>
				<col style="width: 80px;"/>
				<col style="width: 80px;"/>
				<col style="width: 80px;"/>
				<col style="width: 80px;"/>
				<col style="width: 80px;"/>
				<col style="width: 80px;"/>
				<col style="width: 80px;"/>
				<col style="width: 80px;"/>
				<col style="width: 80px;"/>
				<col style="width: 80px;"/>
				<col style="width: 80px;"/>
				<col style="width: 80px;"/>
				<col style="width: 80px;"/>
 				<col style="width: 80px;"/>
				<col style="width: 80px;"/>
			</colgroup>	
			<thead>
				<tr>
					<ehr:authorize ifAnyGranted="${JFZX},${ADMIN}">
						<c:choose>
							<c:when test="${empty monthFlag }"><th colspan='2'>单位</th></c:when>
							<c:when test="${not empty monthFlag }"><th rowspan='2'>单位</th></c:when>
						</c:choose>
					</ehr:authorize>
					<ehr:authorize ifNotGranted="${JFZX},${ADMIN}"><th rowspan='2'>单位</th></ehr:authorize>
					<c:if test="${not empty monthFlag }"><th rowspan="2">月份</th></c:if>
					<th colspan="5">病人总数</th>
					<th colspan="4">病人增减数</th>
					<th colspan="4">免费发药</th>
					<th colspan="3">随访次数</th>
					<th colspan="6">化验检查</th>
 					<th colspan="2">宣传培训</th>
				</tr>
				<tr>
					<ehr:authorize ifAnyGranted="${JFZX},${ADMIN}"><c:if test="${empty monthFlag }"><th>镇</th><th>中心</th></c:if></ehr:authorize>
					<th>重性病人累计建档</th>
					<th>重性病人数</th>
					<th>重性病人数<br>(贫困)</th>
					<th>重性病人数<br>(非贫困)</th>
					<th>普通病人数</th>
					<th>重性病人增加</th>
					<th>重性病人减少</th>
					<th>普通病人增加</th>
					<th>普通病人减少</th>
					<th>免费发药人数<br>(重性)</th>
					<th>免费发药人数<br>(非重性)</th>
					<th>实际吃药人数<br>(重性)</th>
					<th>实际吃药人数<br>(非重性)</th>
					<th>重性病人数</th>
					<th>服药人数</th>
					<th>普通病人数</th>
					<th>人数</th>
					<th>心电</th>
					<th>B超</th>
					<th>肝功能</th>
					<th>血常规</th>
					<th>其他检查</th>
 					<th>培训人数</th>
					<th>培训次数</th>
				</tr>			
			</thead>
			<tbody>
				<c:forEach var="report" items="${reports}" varStatus="status">
						<tr>
							<ehr:authorize ifAnyGranted="${JFZX},${ADMIN}">
								<c:if test="${report.townCenterCount > 0 }">
									<td  class="centertd" rowspan="${report.townCenterCount + 1}">
										<ehr:tip><ehr:dic dicmeta="FS990001" code="${report.managementTown}"/></ehr:tip>
									</td>	
								</c:if>		
								<c:if test="${report.amountFlag=='1'}"><td></td></c:if>
							</ehr:authorize>							
							<td>
								<c:choose>
									<c:when test="${report.amountFlag=='1'}"><b>总计</b></c:when>
									<c:when test="${report.amountFlag=='2'}"><b>合计</b></c:when>
									<c:otherwise>
										<ehr:authorize ifAnyGranted="${JFZX},${ADMIN}">
											<ehr:tip><ehr:org  code="${report.managementCenter}"/></ehr:tip>
										</ehr:authorize>								
										<ehr:authorize ifAnyGranted="${JFYS}">
											<ehr:tip><ehr:org  code="${report.managementStation}"/></ehr:tip>
										</ehr:authorize>										
									</c:otherwise>
								</c:choose>
							</td>
							<c:if test="${not empty monthFlag }">
								<td><fmt:formatDate value="${report.reportMonth}" pattern="yyyy/MM" /></td>
							</c:if>
							<td><tags:numberLabel value="${report.totalCumulativeFile}"/></td>
							<td><tags:numberLabel value="${report.totalNumSevere}"/></td>
							<td><tags:numberLabel value="${report.totalNumSeverePoor}"/></td>
							<td><tags:numberLabel value="${report.totalNumSevereNotPoor}"/></td>
							<td><tags:numberLabel value="${report.totalNumOrdinary}"/></td>
							<td><tags:numberLabel value="${report.raiseSevere}"/></td>
							<td><tags:numberLabel value="${report.decreaseSevere}"/></td>
							<td><tags:numberLabel value="${report.raiseOrdinary}"/></td>
							<td><tags:numberLabel value="${report.decreaseOrdinary}"/></td>
							<td><tags:numberLabel value="${report.freeDispensingSevere}"/></td>
							<td><tags:numberLabel value="${report.freeDispensingOrdinary}"/></td>
							<td><tags:numberLabel value="${report.realityMedicineSevere}"/></td>
							<td><tags:numberLabel value="${report.realityMedicineOrdinary}"/></td>
							<td><tags:numberLabel value="${report.followupSevere}"/></td>
							<td><tags:numberLabel value="${report.followupNetwork}"/></td>
							<td><tags:numberLabel value="${report.followupOrdinary}"/></td>
							<td><tags:numberLabel value="${report.checkNumber}"/></td>
							<td><tags:numberLabel value="${report.checkEcg}"/></td>
							<td><tags:numberLabel value="${report.checkTypeB}"/></td>
							<td><tags:numberLabel value="${report.checkLiver}"/></td>
							<td><tags:numberLabel value="${report.checkBloodTests}"/></td>
							<td><tags:numberLabel value="${report.checkOther}"/></td>
 							<td><tags:numberLabel value="${report.trainingNumber}"/></td>
							<td><tags:numberLabel value="${report.trainingTime}"/></td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</div>