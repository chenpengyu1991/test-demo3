<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page import="com.founder.rhip.idm.common.ReportStatus" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>" />
<c:set var="YYCRB" value="<%=RoleType.YYCRB.getValue()%>" />
<c:set var="ZXCRB" value="<%=RoleType.ZXCRB.getValue()%>"/>
<c:set var="CANCEL" value="<%=ReportStatus.CANCEL.getValue()%>"/>

<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:70px;width: 7%;"/>
	        <col style="min-width:50px;width: 5%;"/>
			<%-- <col style="min-width:50px;width: 5%;"/> --%>
	        <col style="min-width:90px;width: 7%;"/>
	       <%--  <col style="min-width:80px;width: 7%;"/> --%>
			<col style="min-width:100px;width: 12%;"/>
			<%-- <col style="min-width:80px;width: 9%;"/> --%>
			<col style="min-width:80px;width: 9%;"/>
            <col style="min-width:60px;width: 8%;"/>
            <col style="min-width:60px;width: 13%;"/>
            <col style="min-width:60px;width: 13%;"/>
            <col style="min-width:60px;width: 13%;"/>
            <col style="min-width:60px;width: 13%;"/>
			<%-- <col style="min-width:70px;width:70px;"/> --%>
            
		</colgroup>
		<thead>
			<tr>
				<th>姓名</th>
                <th>性别</th>
				<!-- <th>年龄</th> -->
				<th>疾病名称</th>
				<!-- <th>疾病类型</th> -->
				<th>现住地</th>
                <th>上报单位</th>
				<%--<th>类型</th>--%>
				<!-- <th>职业</th> -->
				<th>发病日期</th>
				<th>诊断时间</th>
				<th>原始诊断时间</th>
				<th>录入时间</th>
				<th>原始录入时间时间</th>
                <!-- <th>报卡来源</th>    -->
			</tr>
		</thead>
		<tbody>
			<c:forEach var="report" items="${reports.list}" varStatus="status">
				<tr>
					<td class="centertd" title="${report.name}">${report.name}</td>
                    <td class="centertd"><ehr:dic dicmeta="GBT226112003" code="${report.gender}" /></td>
					<%-- <td title="${report.age}" class="centertd">${report.age}<ehr:dic dicmeta="IDM00003" code="${report.ageUnit}" /></td> --%>
					<td title="${report.infectiousName}">${report.infectiousName}</td>
					<%-- <td><ehr:tip><ehr:dic dicmeta="CV0501002" code="${report.caseCategory}"/></ehr:tip></td> --%>
					<td title="${report.paAddress}">${report.paAddress}</td>
                    <td title="${report.fillOrganName}">${report.fillOrganName}</td>
					<%--<td class="centertd"><ehr:dic  dicmeta="FS10063" code="${report.infectiousType}" /></td>--%>
		<%-- 			<td class="centertd"><ehr:dic  dicmeta="GBT6565" code="${report.occupation}" /></td> --%>
					<td class="centertd"><fmt:formatDate value="${report.pathogenesisDate}" pattern="yyyy/MM/dd" /></td>
					<td class="centertd"><fmt:formatDate value="${report.diagnosisDate}" pattern="yyyy/MM/dd HH:mm:ss"  /></td>
					<td class="centertd"><fmt:formatDate value="${report.currentDiagnosisTime}" pattern="yyyy/MM/dd HH:mm:ss" /></td>
					<td class="centertd"><fmt:formatDate value="${report.fillDate}" pattern="yyyy/MM/dd HH:mm:ss" /></td>
					<td class="centertd"><fmt:formatDate value="${report.currentFillTime}" pattern="yyyy/MM/dd HH:mm:ss" /></td>
                   <%--  <td><ehr:tip><ehr:dic dicmeta="IDM00408" code="${report.reportSource}"/></ehr:tip></td> --%>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="reportSearch.searchHistory" colspan="10"/>
		</tr>
		</tbody>
	</table>
	
	<%-- <table>
		<tr>
			<ehr:pagination action="reportSearch.searchHistory" />
		</tr>
	</table> --%>
</div>