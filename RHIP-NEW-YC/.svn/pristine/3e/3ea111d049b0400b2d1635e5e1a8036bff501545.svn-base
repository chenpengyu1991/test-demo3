<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<table id="cdm-year-report-cdm-age-result" class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
		<col style="width:65px" />
		<col style="width:60px" />
		<col style="width:35px" />
		<col span="20" style="width: 5%" />
		<col  style="width:65px" />
	</colgroup>
	<caption ><span style="font-size: 25px;font-weight:bold;">永城市${currentYear}年慢病分年龄别发病情况</span></caption>
	<thead>
		<tr>
			<th colspan="2" >疾病名称</th>
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
		<c:forEach items="${cdYearReport}" var="item">
			<c:set var="disSize" value="${fn:length(item.value)}"></c:set>
			<tr>
				<td rowspan="${disSize}"><ehr:dic dicmeta="DMD00004"  code="${item.key}" /></td>
				<c:forEach var="report" end="0" items="${item.value}">
						
					<td>
					<ehr:tip trim="true">
				<c:choose>
					<c:when test="${item.key==1}">
						<c:if test="${report.subDisType =='-1'}">
							合计
						</c:if>
						<c:if test="${report.subDisType !='-1'}">
							<ehr:dic dicmeta="DMD00006"  code="${report.subDisType}" />
						</c:if>
					</c:when>
						<c:when test="${item.key==2}">
							<c:if test="${report.subDisType =='-1'}">
								合计
							</c:if>
							<c:if test="${report.subDisType !='-1'}">
								<ehr:dic dicmeta="DMD00007"  code="${report.subDisType}" />
							</c:if>
						</c:when>
						<c:when test="${item.key==3}">
							<c:if test="${report.subDisType =='-1'}">
								合计
							</c:if>
							<c:if test="${report.subDisType !='-1'}">
								<ehr:dic dicmeta="DMD00009"  code="${report.subDisType}" />
							</c:if>
						</c:when>
						<c:when test="${item.key==4}">
							<c:if test="${report.subDisType =='-1'}">
								合计
							</c:if>
							<c:if test="${report.subDisType !='-1'}">
								<ehr:dic dicmeta="DMD00008"  code="${report.subDisType}" />
							</c:if>
						</c:when>
					</c:choose></ehr:tip>
					
					
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
				</c:forEach>
			</tr>
		
				<%--此处从第二次开始循环 --%>
			<c:forEach var="report" begin="1" items="${item.value}">
				<tr>
						<td>
							<ehr:tip trim="true">
								<c:choose>
									<c:when test="${item.key==1}">
										<c:if test="${report.subDisType =='-1'}">
											合计
										</c:if>
										<c:if test="${report.subDisType !='-1'}">
											<ehr:dic dicmeta="DMD00006"  code="${report.subDisType}" />
										</c:if>
									</c:when>
									<c:when test="${item.key==2}">
										<c:if test="${report.subDisType =='-1'}">
											合计
										</c:if>
										<c:if test="${report.subDisType !='-1'}">
											<ehr:dic dicmeta="DMD00007"  code="${report.subDisType}" />
										</c:if>
									</c:when>
									<c:when test="${item.key==3}">
										<c:if test="${report.subDisType =='-1'}">
											合计
										</c:if>
										<c:if test="${report.subDisType !='-1'}">
											<ehr:dic dicmeta="DMD00009"  code="${report.subDisType}" />
										</c:if>
									</c:when>
									<c:when test="${item.key==4}">
										<c:if test="${report.subDisType =='-1'}">
											合计
										</c:if>
										<c:if test="${report.subDisType !='-1'}">
											<ehr:dic dicmeta="DMD00008"  code="${report.subDisType}" />
										</c:if>
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
		</c:forEach>
		<tr style="font-weight:bold;">
			<td colspan="8">报告单位（盖章）:${currentOrgName }</td>
			<td colspan="8">报告人:${currentUserName}</td>
			<td colspan="8">报告日期:<fmt:formatDate pattern="yyyy/MM/dd" value="${currentDate}"/> </td>
		</tr>
	</tbody>
</table>
