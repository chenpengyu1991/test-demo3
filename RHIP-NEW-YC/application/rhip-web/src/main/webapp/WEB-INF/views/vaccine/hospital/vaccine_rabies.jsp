<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKYFJZ" value="<%=RoleType.JKYFJZ.getValue()%>"/>
<c:set var="ZXYFJZ" value="<%=RoleType.ZXYFJZ.getValue()%>"/>
<c:set var="YYFJZ" value="<%=RoleType.YYFJZ.getValue()%>"/>
	
<!-- 接种信息  -->
<div id="vaccineDiv" class="postdiv">
<fieldset class="layui-elem-field">
<legend>人用狂犬病疫苗接种情况</legend>
	<c:if test="${empty vaccinationInfoList}">
		尚未接种疫苗
	</c:if>

	<c:forEach items="${vaccinationInfoList}" var="vaccineRecordDTO1" varStatus="status">
	<table <c:if test="${status.index eq 0}">style="width:99%;border: 1px solid #e6e6e6;"</c:if> <c:if test="${status.index ne 0}">style="width:99%;border-left: 1px solid #e6e6e6;border-bottom: 1px solid #e6e6e6;border-right: 1px solid #e6e6e6;"</c:if>style="width:99%;border: 1px solid #e6e6e6;" class="posttable">
		<colgroup>
			<col style="width: 15%;">
			<col style="width: 25%">
			<col style="width: 10%">
			<col style="width: 20%">
			<col style="width: 10%">
			<col style="width: 20%">
		</colgroup>
		<tbody>
			<tr>
				<th>
					<c:if test="${operate == 2}">
						<ehr:authorize ifAnyGranted="${JKYFJZ},${ZXYFJZ},${YYFJZ}">
							<img alt="删除" title="删除" onclick="contineRabiesPage.deleteVaccine(${vaccineRecordDTO1.id},${vaccineRecordDTO1.ehrId})"
								style="cursor: pointer;" src="${pageContext.request.contextPath}/images/vaccine/deletebtn.png">
						</ehr:authorize>
					</c:if>
				接种次数：
				</th>
				<td>
					<c:choose>
						<c:when test="${vaccineRecordDTO1.inoculationTimes eq '1'}">第一次接种</c:when>
						<c:when test="${vaccineRecordDTO1.inoculationTimes eq '2'}">第二次接种</c:when>
						<c:when test="${vaccineRecordDTO1.inoculationTimes eq '3'}">第三次接种</c:when>
						<c:when test="${vaccineRecordDTO1.inoculationTimes eq '4'}">第四次接种</c:when>
						<c:when test="${vaccineRecordDTO1.inoculationTimes eq '5'}">第五次接种</c:when>
					</c:choose>
				</td>
				<th>接种日期：</th>
				<td><fmt:formatDate value="${vaccineRecordDTO1.vaccinationDate}" pattern='yyyy/MM/dd'/></td>
				<th>剂量：</th>
				<td>${vaccineRecordDTO1.vaccineMeasurement} &nbsp;剂</td>
			</tr>
			<tr>
				<th>生产厂家：</th>
				<td>${vaccineRecordDTO1.vaccineFactory}</td>
				<th>疫苗批号：</th>
				<td>${vaccineRecordDTO1.vaccineLotNumber}</td>
				<th>接种人：</th>
				<td>${vaccineRecordDTO1.vaccinationDoctorName}</td>
			</tr>
		</tbody>
	</table>
	</c:forEach>
</fieldset>
</div>
	
<!-- 人用狂犬病疫苗接种情况 -->
<c:if test="${not empty grayInfo}">
	<div class="postdiv" id="vaccination2">
		<fieldset class="layui-elem-field">
			<legend>狂犬病人免疫球蛋白注射情况</legend>
			<table style="width:99%;" class="posttable">
				<colgroup>
					<col style="width: 15%;">
					<col style="width: 25%">
					<col style="width: 10%">
					<col style="width: 20%">
					<col style="width: 10%">
					<col style="width: 20%">
				</colgroup>
				<tbody>
					<tr>
						<th><!--ehr:authorize ifAnyGranted="33,34,35,06,17,31"-->
							<c:if test="${operate == 2}">
								<ehr:authorize ifAnyGranted="${JKYFJZ},${ZXYFJZ},${YYFJZ}">
								<img alt="删除" title="删除" onclick="contineRabiesPage.deleteVaccine(${grayInfo.id})"
									style="cursor: pointer;" src="${pageContext.request.contextPath}/images/vaccine/deletebtn.png">
								</ehr:authorize>
							</c:if>患者体重：
						</th>
						<td>${grayInfo.vaccinationWeight}&nbsp;公斤</td>
						<th>剂量：</th>
						<td>${grayInfo.vaccineMeasurement}&nbsp;iu(<fmt:formatNumber type="number" value="${grayInfo.vaccineMeasurement/200}" maxFractionDigits="0"/>瓶)</td>
						<th>注射日期：</th>
						<td><fmt:formatDate value="${grayInfo.vaccinationDate}" pattern='yyyy/MM/dd'/></td>
					</tr>
					<tr>
						<th>生产厂家：</th>
						<td>${grayInfo.vaccineFactory}</td>
						<th>批号：</th>
						<td>${grayInfo.vaccineLotNumber}</td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</div>
	</c:if>

<!-- 备注 -->
<%--
<div id="continueRabies">
	<div class="postdiv">
		<fieldset class="layui-elem-field">
			<legend>备注</legend>
			<textarea class="vacnte" readonly="readonly" rows="5" cols="40">${vaccinationEvent.comments}</textarea>
		</fieldset>
	</div>
	&lt;%&ndash;<ehr:authorize ifAnyGranted="06,17,31,33,34,35">&ndash;%&gt;
	<c:if test="${operate == 2}">
		<ehr:authorize ifAnyGranted="${JKYFJZ},${ZXYFJZ},${YYFJZ}">
			<div style="text-align: center;">
				<c:if test="${continueInject}">
					<!-- <input id="injectVaccineBtn" class="btn" type="button" value="登记疫苗接种"/> -->
					<button class="layui-btn layui-btn-sm"  id="injectVaccineBtn">登记疫苗接种</button>
				</c:if>
				<c:if test="${continueGray}">
					<!-- 免疫球蛋白护士不能接种医生可以接种 -->

					<!-- <input id="injectGrayBtn" class="btn" type="button" value="登记免疫蛋白接种"/> -->
					<button class="layui-btn layui-btn-sm"  id="injectGrayBtn">登记免疫蛋白接种</button>
				</c:if>
			</div>
		</ehr:authorize>
	</c:if>
</div>--%>
