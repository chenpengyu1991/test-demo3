<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<script src="${pageContext.request.contextPath}/js/views/vaccine/hospital/contine_vaccine.js" type="text/javascript"></script>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKYFJZ" value="<%=RoleType.JKYFJZ.getValue()%>"/>
<c:set var="ZXYFJZ" value="<%=RoleType.ZXYFJZ.getValue()%>"/>
<c:set var="YYFJZ" value="<%=RoleType.YYFJZ.getValue()%>"/>

<!-- 接种信息  -->
<div class="postdiv">
	<fieldset class="layui-elem-field">
	<legend>乙肝疫苗接种情况</legend>
	<c:if test="${empty vaccinationInfoList}">
			尚未接种疫苗
	</c:if>

	<c:forEach items="${vaccinationInfoList}" var="vaccineRecordDTO1">
	<table style="width:99%;border: 1px solid #e6e6e6;" class="posttable">
		<colgroup >
			<col width="13%" />
			<col width="20%" />
			<col width="10%" />
			<col width="26%" />
			<col width="10%" />
			<col width="20%" />
		<colgroup>
		<tbody>
			<tr>
				<th>
					<c:if test="${operate == 2}">
						<ehr:authorize ifAnyGranted="${JKYFJZ},${ZXYFJZ},${YYFJZ}">
							<img alt="删除" title="删除" onclick="contineRabiesPage.deleteVaccine(${vaccineRecordDTO1.id})"
							style="cursor: pointer;" src="${pageContext.request.contextPath}/images/vaccine/deletebtn.png">
						</ehr:authorize>
					</c:if>
					接种次数：
				</th>
				<td onmousemove="this.setCapture();" onmouseout="this.releaseCapture();">
					<select id="vaccineType"  onfocus="this.blur()" name="CDCVaccinationDetailsDTO.vaccineRecordDTO.vaccineIndex">
						<option value="1" ${vaccineRecordDTO1.inoculationTimes eq '1' ? 'selected' : ''}>第一次接种</option>
						<option value="2" ${vaccineRecordDTO1.inoculationTimes eq '2' ? 'selected' : ''}>第二次接种</option>
						<option value="3" ${vaccineRecordDTO1.inoculationTimes eq '3' ? 'selected' : ''}>第三次接种</option>
						<option value="4" ${vaccineRecordDTO1.inoculationTimes eq '4' ? 'selected' : ''}>第四次接种</option>
						<option value="5" ${vaccineRecordDTO1.inoculationTimes eq '5' ? 'selected' : ''}>第五次接种</option>
					</select>
				</td>
				<th>接种日期：</th>
				<td><fmt:formatDate value='${vaccineRecordDTO1.vaccinationDate}' pattern='yyyy/MM/dd'/></td>
				<th>剂量：</th>
				<td>${vaccineRecordDTO1.vaccineMeasurement}&nbsp;剂</td>
			</tr>
			<tr>
				<th>生产厂家：</th>
				<td>${vaccineRecordDTO1.vaccineFactory}</td>
				<%-- <th>制品名称：</th>
				<td>${vaccineRecordDTO1.vaccineName}</td> --%>
				<th>疫苗批号：</th>
				<td>${vaccineRecordDTO1.vaccineLotNumber}</td>
				<th>接种人：</th>
				<td>${vaccineRecordDTO1.vaccinationDoctorName}</td>
			</tr>
			<%-- <tr>
				<th>接种人：</th>
				<td colspan="5">${vaccineRecordDTO1.vaccinationDoctorName}</td>
			</tr> --%>
		</tbody>
	</table>
	&nbsp;
	</c:forEach>
	</fieldset>
</div>
<!-- 接种信息  -->

<!-- 备注 -->
<div id="continueRabies">
	<div class="postdiv">
		<fieldset class="layui-elem-field">
			<legend>备注</legend>
			<textarea class="vacnte" readonly="readonly" rows="5" cols="40">${vaccinationEvent.comments}</textarea>
		</fieldset>
	</div>
	<c:if test="${operate == 2}">
		<ehr:authorize ifAnyGranted="${JKYFJZ},${ZXYFJZ},${YYFJZ}">
			<div style="text-align: center;">
				<c:if test="${continueInject}">
					<!-- <input id="injectVaccineBtn" class="btn" type="button" value="登记疫苗接种"/> -->
					<button class="layui-btn layui-btn-sm"  id="injectVaccineBtn">登记疫苗接种</button>
				</c:if>
			</div>
		</ehr:authorize>
	</c:if>
</div>
