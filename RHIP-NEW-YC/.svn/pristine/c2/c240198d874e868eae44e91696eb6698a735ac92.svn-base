<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<table id="cdm-year-report-tumor-death-age-result" class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
		<col style="width:120px" ></col>
		<col style="width:35px" ></col>
		<col span="20" style="width: 5%" ></col>
		<col  style="width:65px" ></col>
	</colgroup>
	<caption ><span style="font-size: 25px;font-weight:bold;">永城市${currentYear}年恶性肿瘤分年龄别死亡情况</span></caption>
	<thead>
		<tr>
			<th>疾病名称</th>
			<th>合计</th>
			<th>0岁-</th>
			<th>1岁-</th>
			<th>5岁-</th>
			<th>10岁-</th>
			<th>15岁-</th>
			<th>20岁-</th>
			<th>25岁-</th>
			<th>30岁-</th>
			<th>35岁-</th>
			<th>40岁-</th>
			<th>45岁-</th>
			<th>50岁-</th>
			<th>55岁-</th>
			<th>60岁-</th>
			<th>65岁-</th>
			<th>70岁-</th>
			<th>75岁-</th>
			<th>80岁-</th>
			<th>85岁-</th>
			<th>不详</th>
			<th>构成比(%)</th>
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
						<td><tags:numberLabel value="${report.total}" type="number" /> </td>
						<td><tags:numberLabel value="${report.one}" type="number" /></td>
						<td><tags:numberLabel value="${report.two}" type="number" /></td>
						<td><tags:numberLabel value="${report.three}" type="number" /></td>
						<td><tags:numberLabel value="${report.four}" type="number" /></td>
						<td><tags:numberLabel value="${report.five}" type="number" /></td>
						<td><tags:numberLabel value="${report.six}" type="number" /></td>
						<td><tags:numberLabel value="${report.serven}" type="number" /></td>
						<td><tags:numberLabel value="${report.eight}" type="number" /></td>
						<td><tags:numberLabel value="${report.nine}" type="number" /></td>
						<td><tags:numberLabel value="${report.ten}" type="number" /></td>
						<td><tags:numberLabel value="${report.eleven}" type="number" /></td>
						<td><tags:numberLabel value="${report.twelve}" type="number" /></td>
						<td><tags:numberLabel value="${report.thirteen}" type="number" /></td>
						<td><tags:numberLabel value="${report.fourteen}" type="number" /></td>
						<td><tags:numberLabel value="${report.fifteen}" type="number" /></td>
						<td><tags:numberLabel value="${report.sixteen}" type="number" /></td>
						<td><tags:numberLabel value="${report.seventeen}" type="number" /></td>
						<td><tags:numberLabel value="${report.eighteen}" type="number" /></td>
						<td><tags:numberLabel value="${report.nineteen}" type="number" /></td>
						<td><tags:numberLabel value="${report.zero}" type="number" /></td>
						<td><tags:numberLabel value="${report.subIncidence}" fractionDigits="2" type="percent" /></td>
				</tr>
				</c:forEach>

		<tr style="font-weight:bold;">
			<td colspan="7">报告单位（盖章）:${currentOrgName }</td>
			<td colspan="8">报告人:${ currentUserName}</td>
			<td colspan="8">报告日期:<fmt:formatDate pattern="yyyy/MM/dd" value="${currentDate}"/> </td>
		</tr>
	</tbody>
</table>
