<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<script src="${pageContext.request.contextPath}/js/views/idm/statistics/report/monthReport/interview/list.js" type="text/javascript"></script>
<div id="interviewList" class="repeattable">
	<form id = "interviewForm">
		<input type="hidden" name="currentOrgCode" value="${currentOrgCode}"/>
		<input type="hidden" name="currentMonth" value="${currentMonth}"/>
		<input type="hidden" id="reportNameId" name="reportName" value="<ehr:org code="${fillOrgCode}"/>${reportMonth}传染病管理月报表"/>
	<table id="interviewtable">
		<colgroup>
			<col style="width: 120px;"/>
			<col style="width: 70px;"/>
			<col style="width: 70px;"/>
			<col style="width: 70px;"/>
			<col style="width: 70px;"/>
			<col style="width: 70px;"/>
			<col style="width: 70px;"/>
			<col style="width: 70px;"/>
			<col style="width: 70px;"/>
			<col style="width: 70px;"/>
			<col style="width: 150px;"/>
		</colgroup>	
		<thead>
			<tr style="text-align: center;">
				<td style="border:none;"></td>
				<td style="border:none;" colspan="9">
					<h1 style="font-size:150%;margin: 20px 0px 20px 0px">传染病访视月报表</h1>
				</td>
				<td style="border:none;"></td>
			</tr>
			<tr>
				<th rowspan="2">传染病名称</th>
				<th rowspan="2">报告发病数</th>
				<th rowspan="2">访视数</th>
				<th colspan="5">访视情况</th>
				<th rowspan="2">密切接触人数</th>
				<th rowspan="2">接种疫苗人数</th>
				<th rowspan="2">其他</th>
			</tr>
			<tr>
				<th>住院人数</th>
				<th>在家人数</th>
				<th>查无此人</th>
				<th>误诊</th>
				<th>其他</th>
			</tr>			
		</thead>
		<tbody>
			<c:forEach var="interview" items="${interviews}" varStatus="status">
				<c:if test="${interview.diseaseCode !='-1'}">
					<tr>
						<td>
							<ehr:tip><ehr:dic dicmeta="CV0501017" code="${interview.diseaseCode}"/></ehr:tip>
							<input type="hidden" name="diseaseCode" value="${interview.diseaseCode}"/>
						</td>
						<td><tags:numberLabel value="${interview.reportNumber}"/></td>
						<td><tags:numberLabel value="${interview.interviewNumber}"/></td>
						<td><tags:numberLabel value="${interview.inHospitalNumber}"/></td>
						<td><tags:numberLabel value="${interview.inHomeNumber}"/></td>
						<td>
							<span id="viewReport1${status.count}Id" style="float:right;">${interview.unknownPerson}</span>
							<input type="text" id="editReport1${status.count}Id" name="unknownPerson${interview.diseaseCode}" value="${interview.unknownPerson}" style="width: 95%;text-align:right;" reg='{"digits":"true","min":"0","max":"10000"}'/>
						</td>
						<td>
							<span id="viewReport2${status.count}Id" style="float:right;">${interview.misdiagnose}</span>
							<input type="text" id="editReport2${status.count}Id" name="misdiagnose${interview.diseaseCode}" value="${interview.misdiagnose}" style="width: 95%;text-align: right;" reg='{"digits":"true","min":"0","max":"10000"}'/>
						</td>
						<td>
							<span id="viewReport3${status.count}Id" style="float:right;">${interview.interviewOther}</span>
							<input type="text" id="editReport3${status.count}Id" name="interviewOther${interview.diseaseCode}" value="${interview.interviewOther}" style="width: 95%;text-align: right;" reg='{"digits":"true","min":"0","max":"10000"}'/>
						</td>
						<td><tags:numberLabel value="${interview.contactNumber}"/></td>
						<td>
							<span id="viewReport4${status.count}Id" style="float:right;">${interview.vaccinationNumber}</span>
							<input type="text" id="editReport4${status.count}Id" name="vaccinationNumber${interview.diseaseCode}" value="${interview.vaccinationNumber}" style="width: 95%;text-align: right;" reg='{"digits":"true","min":"0","max":"10000"}'/>
						</td>
						<td>
							<span id="viewReport5${status.count}Id" style="float:left;">${interview.other}</span>
							<input type="text" id="editReport5${status.count}Id" name="other${interview.diseaseCode}" value="${interview.other}" style="width: 95%;" reg='{"maxlength":100}'/>
						</td>
					</tr>
				</c:if>
			</c:forEach>
			<c:forEach var="interview" items="${interviews}" varStatus="status">
				<c:if test="${interview.diseaseCode =='-1'}">
					<tr>
						<td><b><ehr:tip>合计</ehr:tip></b></td>
						<td><b><tags:numberLabel value="${interview.reportNumber}"/></b></td>
						<td><b><tags:numberLabel value="${interview.interviewNumber}"/></b></td>
						<td><b><tags:numberLabel value="${interview.inHospitalNumber}"/></b></td>
						<td><b><tags:numberLabel value="${interview.inHomeNumber}"/></b></td>
						<td><b><tags:numberLabel value="${interview.unknownPerson}"/></b></td>
						<td><b><tags:numberLabel value="${interview.misdiagnose}"/></b></td>
						<td><b><tags:numberLabel value="${interview.interviewOther}"/></b></td>
						<td><b><tags:numberLabel value="${interview.contactNumber}"/></b></td>
						<td><b><tags:numberLabel value="${interview.vaccinationNumber}"/></b></td>
						<td></td>
					</tr>
				</c:if>
			</c:forEach>
			<tr>
				<td colspan="11" style="border:none;text-align: left;">
					<p>填表要求：各单位于每月3日前将上月的《传染病管理月报表》通过市疾病预防</p>
				</td>
			</tr>
			<tr>
				<td colspan="11" style="border:none;text-align: right;">
					<c:choose>
						<c:when test="${empty fillUserId}">
							<span style="margin: 0px 180px 20px 0px">填表单位</span>
							<span style="margin:0px 100px 20px 0px">填报人：</span>
							<span style="margin: 0px 150px 20px 0px">填报日期：</span>						
						</c:when>
						<c:otherwise>
							<span style="margin: 0px 10px 20px 0px">填表单位</span>
							<span style="margin: 0px 10px 0px 0px"><b><ehr:org code="${fillOrgCode}"/></b></span>
							<span style="margin: 0px 10px 20px 0px">填报人：</span>
							<span style="margin: 0px 10px 0px 0px"><b><ehr:user userCode="${fillUserId}"/></b></span>
							<span style="margin: 0px 100px 20px 0px">填报日期：<b><fmt:formatDate pattern="yyyy/MM/dd" value="${fillDt}"/></b></span>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>							
		</tbody>
	</table>
	</form>
</div>