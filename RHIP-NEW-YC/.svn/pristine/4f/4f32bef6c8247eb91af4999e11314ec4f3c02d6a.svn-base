<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<table id="cdm-year-report-tumor-death-genger-result" class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
		<col style="width: 120px" ></col>
		<col span="6" ></col>
	</colgroup>
	<caption><span style="font-size: 25px;font-weight:bold;">永城市${currentYear}年恶性肿瘤死亡、死亡率情况</span></caption>
	<thead>
	<tr>
		<th rowspan="2"  >疾病名称</th>
		<th colspan="2">男性</th>
		<th colspan="2">女性</th>
		<th colspan="2">合计</th>
	</tr>
	<tr height="33" style="height: 33px">
		<th height="33">死亡数</th>
		<th>死亡率(1/10万)</th>
		<th>死亡数</th>
		<th>死亡率(1/10万)</th>
		<th>死亡数</th>
		<th>死亡率(1/10万)</th>
	</tr>
	</thead>
	<tbody>
			<c:forEach var="report" items="${cdYearReport}">
				<tr>
						<td>
							<ehr:tip trim="true">
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
						</ehr:tip>
					</td>
						<td><tags:numberLabel value="${report.manCount}" type="number" /></td>
						<td><tags:numberLabel value="${report.manIncidence}" fractionDigits="2" type="number" /></td>
						<td><tags:numberLabel value="${report.wmmanCount}" type="number" /></td>
						<td><tags:numberLabel value="${report.wmmanIncidence}" fractionDigits="2" type="number" /></td>
						<td><tags:numberLabel value="${report.total}" type="number" /></td>
						<td><tags:numberLabel value="${report.totalIncidence}" fractionDigits="2" type="number" /></td>
					
				</tr>
			</c:forEach>
		<tr>
			<td colspan="8">备注：市（${currentYear}）年 男性人口数为（${populaceMap.MAN_NUM} ）,女性人口数为（${populaceMap.WOMAN_NUM} ）,总人口数为（${populaceMap.TOTAL_NUM} ）</td>
		</tr>
		<tr style="font-weight:bold;">
			<td colspan="3">报告单位（盖章）:${currentOrgName }</td>
			<td colspan="2">报告人:${currentUserName}</td>
			<td colspan="2">报告日期:<fmt:formatDate pattern="yyyy/MM/dd" value="${currentDate}"/></td>
		</tr>
	</tbody>
</table>
<p>
	<br style="text-align: left;" />
</p>