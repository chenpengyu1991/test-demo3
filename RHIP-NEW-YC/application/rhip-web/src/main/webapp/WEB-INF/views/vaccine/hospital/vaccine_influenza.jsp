<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/vaccine/hospital/contine_vaccine.js" type="text/javascript"></script>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKYFJZ" value="<%=RoleType.JKYFJZ.getValue()%>"/>
<c:set var="ZXYFJZ" value="<%=RoleType.ZXYFJZ.getValue()%>"/>
<c:set var="YYFJZ" value="<%=RoleType.YYFJZ.getValue()%>"/>

    
	<!-- 接种信息  -->
	<div class="postdiv">
        <fieldset class="layui-elem-field">
        <legend>流感疫苗接种情况</legend>
        
        <c:if test="${empty vaccineRecord}">
			尚未接种疫苗
		</c:if>
        <c:if test="${not empty vaccineRecord}">
        	<table style="width:99%" class="posttable">
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
								<img alt="删除" title="删除" onclick="contineRabiesPage.deleteVaccine(${vaccineRecord.id})"
									style="cursor: pointer;" src="${pageContext.request.contextPath}/images/vaccine/deletebtn.png">
								</ehr:authorize>
							</c:if>
							接种日期：
						</th>
						<td><fmt:formatDate value='${vaccineRecord.vaccinationDate}' pattern='yyyy/MM/dd'/></td>
	                    <%-- <th>制品名称：</th>
	                    <td>${vaccineRecord.vaccineName}</td> --%>
	                    <th>剂量：</th>
						<td>${vaccineRecord.vaccineMeasurement} &nbsp;剂</td>
						<th>疫苗规格：</th>
	                    <td>${vaccineRecord.vaccineSpec}</td>
					</tr>
					<tr>
						<th>生产厂家：</th>
						<td>${vaccineRecord.vaccineFactory}</td>
						<th>疫苗批号：</th>
						<td>${vaccineRecord.vaccineLotNumber}</td>
						<th>接种人：</th>
						<td>${vaccineRecord.vaccinationDoctorName}</td>
					</tr>
					<tr>
						<th>接种部位：</th>
						<td><ehr:dic code="${vaccineRecord.immuPosition}" dicmeta="FS990031"/></td>
						<th>接种途径：</th>
						<td><ehr:dic code="${vaccineRecord.vaccineWay}" dicmeta="FS990032"/></td>
						<th>是否收费：</th>
						<td>
							<ehr:dic code="${vaccineRecord.feeFlag}" dicmeta="PH00001"/>
							<c:if test="${vaccineRecord.feeFlag eq '1'}">
								${vaccineRecord.fee}元
							</c:if>
						</td>
					</tr>
			</tbody>
			</table>
        </c:if>
		</fieldset>
    </div>
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