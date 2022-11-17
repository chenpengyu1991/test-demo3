<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<table id="cdm-year-report-tumor-genger-result" class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
		<col style="width: 65px"></col>
		<col style="width:120px"></col>
		<col span="6"></col>
	</colgroup>
	<caption><span style="font-size: 25px;font-weight:bold;">永城市${currentYear}年肿瘤发病、发病率情况</span></caption>
	<thead>
	<tr>
		<th colspan="2" rowspan="2">疾病名称</th>
		<th rowspan="2">ICD-10</th>
		<th colspan="2">男性</th>
		<th colspan="2">女性</th>
		<th colspan="2">合计</th>
	</tr>
	<tr height="33" style="height: 33px">
		<th height="33">发病数</th>
		<th>发病率(1/10万)</th>
		<th>发病数</th>
		<th>发病率(1/10万)</th>
		<th>发病数</th>
		<th>发病率(1/10万)</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach items="${cdYearReport}" var="item">
			<c:set var="disSize" value="${fn:length(item.value)}"></c:set>
			<tr>
				<td rowspan="${disSize}"><ehr:tip trim="true">
				<c:if test="${item.key ==1}">
								恶性肿瘤
							</c:if>
							<c:if test="${item.key ==2}">
								非恶性肿瘤
							</c:if>
				</ehr:tip>
				</td>
				<c:forEach var="report" end="0" items="${item.value}">
						
						<td><ehr:tip trim="true">
							<c:choose><c:when test="${not empty report.subDisTypeName }">
									${report.subDisTypeName }
								</c:when>
								<c:when test="${report.subDisType =='-1'}">
									合计
								</c:when>
								<c:when test="${report.subDisType !='-1'}">
									${report.subDisType }
								</c:when>
							</c:choose>
						</ehr:tip></td>
						<td><c:if test="${report.subDisType !='-1'}">
								<ehr:tip trim="true">${report.subDisType}</ehr:tip>
							</c:if></td>
						<td><tags:numberLabel value="${report.manCount}" type="number" /></td>
						<td><tags:numberLabel value="${report.manIncidence}" fractionDigits="2" type="number" /></td>
						<td><tags:numberLabel value="${report.wmmanCount}" type="number" /></td>
						<td><tags:numberLabel value="${report.wmmanIncidence}" fractionDigits="2" type="number" /></td>
						<td><tags:numberLabel value="${report.total}" type="number" /></td>
						<td><tags:numberLabel value="${report.totalIncidence}" fractionDigits="2" type="number" /></td>
						
				</c:forEach>
			</tr>
		
				<%--此处从第二次开始循环 --%>
			<c:forEach var="report" begin="1" items="${item.value}">
				<tr>
						<td><ehr:tip trim="true">
							<c:choose><c:when test="${not empty report.subDisTypeName }">
									${report.subDisTypeName }
								</c:when>
								<c:when test="${report.subDisType =='-1'}">
									合计
								</c:when>
								<c:when test="${report.subDisType !='-1'}">
								${report.subDisType }
								</c:when>
							</c:choose>
						</ehr:tip></td>
						<td><c:if test="${report.subDisType !='-1'}">
								<ehr:tip trim="true">${report.subDisType}</ehr:tip>
							</c:if></td>
						<td><tags:numberLabel value="${report.manCount}" type="number" /></td>
						<td><tags:numberLabel value="${report.manIncidence}" fractionDigits="2" type="number" /></td>
						<td><tags:numberLabel value="${report.wmmanCount}" type="number" /></td>
						<td><tags:numberLabel value="${report.wmmanIncidence}" fractionDigits="2" type="number" /></td>
						<td><tags:numberLabel value="${report.total}" type="number" /></td>
						<td><tags:numberLabel value="${report.totalIncidence}" fractionDigits="2" type="number" /></td>
					
				</tr>
			</c:forEach>
		</c:forEach>
		<tr>
			<td colspan="8">备注：市（${currentYear}）年 男性人口数为（${populaceMap.MAN_NUM} ）,女性人口数为（${populaceMap.WOMAN_NUM} ）,总人口数为（${populaceMap.TOTAL_NUM} ）</td>
		</tr>
		<tr style="font-weight:bold;">
			<td colspan="4">报告单位（盖章）:${currentOrgName }</td>
			<td colspan="3">报告人:${currentUserName}</td>
			<td colspan="2">报告日期:<fmt:formatDate pattern="yyyy/MM/dd" value="${currentDate}"/></td>
		</tr>
	</tbody>
</table>
<p>
	<br style="text-align: left;" />
</p>