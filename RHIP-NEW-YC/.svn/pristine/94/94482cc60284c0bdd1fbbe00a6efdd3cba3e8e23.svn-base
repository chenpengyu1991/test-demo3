<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.idm.common.ReportStatus" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:60px;width: 8%;"/>
	        <col style="min-width:60px;width: 5%;"/>
			<col style="min-width:60px;width: 5%;"/>
	        <col style="min-width:100px;width: 14%;"/>
			<col style="min-width:1000px;"/>
			<col style="min-width:80px;width: 10%;"/>
			<%--<col style="min-width:80px;width: 6%;"/>--%>
			<col style="min-width:80px;width: 9%;"/>
            <col style="min-width:60px;width: 8%;"/>
            <col style="min-width:60px;width: 8%;"/>
            <col style="min-width:60px;width: 8%;"/>
            <ehr:authorize ifAnyGranted="${SQZX},${SJYYFBK},${FYK}">
				<col style="min-width:80px;width: 10%;width:80px;"/>
            </ehr:authorize>
		</colgroup>
		<thead>
			<tr>
				<th>姓名</th>
                <th>性别</th>
				<th>年龄</th>
				<th>疾病名称</th>
				<th>现住地</th>
                <th>上报单位</th>
				<th>职业</th>
				<th>发病日期</th>
				<th>诊断时间</th>
                <th>录入时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="report" items="${reports}" varStatus="status">
				<tr>
					<td class="centertd" title="${report.name}">${report.name}</td>
                    <td class="centertd"><ehr:dic dicmeta="GBT226112003" code="${report.gender}" /></td>
					<td title="${report.age}" class="centertd">${report.age}<ehr:dic dicmeta="IDM00003" code="${report.ageUnit}" /></td>
					<td title="${report.infectiousName}">${report.infectiousName}</td>
					<td title="${report.paAddress}">${report.paAddress}</td>
                    <td title="${report.fillOrganName}">${report.fillOrganName}</td>
					<td><ehr:dic  dicmeta="GBT6565" code="${report.occupation}" /></td>
					<td class="centertd"><fmt:formatDate value="${report.pathogenesisDate}" pattern="yyyy/MM/dd" /></td>
					<td class="centertd"><ehr:tip><fmt:formatDate value="${report.diagnosisDate}" pattern="yyyy/MM/dd HH:mm:ss" /></ehr:tip></td>
					<td class="centertd"><fmt:formatDate value="${report.fillDate}" pattern="yyyy/MM/dd" /></td>
					<td class="centertd">
						<a href="javascript:void(0)" onclick="notReportSuspected.initAddSuspected('${report.id}','${report.statusId}')"class="person-link-btn">填写报卡</a>&nbsp;
					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="notReportSuspected.searchNotReportLeprosy" />
		</tr>
	</table>
</div>