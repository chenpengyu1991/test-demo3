<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<thead>
	<tr>
		<th rowspan="2" colspan="${isGbcode==true?'2':'1'}">报告单位</th>
		<th colspan="6">糖尿病</th>
		<th colspan="6">脑卒中</th>
		<th colspan="6">冠心病</th>
	</tr>
	<tr>
		<th>1型</th>
		<th>2型</th>
		<th>妊娠期糖尿病</th>
		<th>其他特殊糖尿病</th>
		<th>合计</th>
		<th>累计</th>
		<th>脑出血</th>
		<th>脑梗塞</th>
		<th>蛛网膜下腔出血</th>
		<th>其他</th>
		<th>合计</th>
		<th>累计</th>
		<th>急性心梗</th>
		<th>心绞痛</th>
		<th>冠心病猝死</th>
		<th>其他</th>
		<th>合计</th>
		<th>累计</th>
	</tr>
</thead>
<tbody>
	<c:set var="size" value="${fn:length(cdMonthReport)}"></c:set>
	<c:if test="${size>0}">
		<c:forEach items="${cdMonthReport}" var="report">
			<c:choose>
                <c:when test="${report.organCode=='-1' and isGbcode ==true  and report.gbCode=='-1'}">
                    <c:set var="total" scope="request" value="${report}"></c:set>
                </c:when>
                <c:when test="${report.organCode=='-1' and isGbcode==false}">
                    <c:set var="total" scope="request" value="${report}"></c:set>
                </c:when>
				<c:when test="${report.organCode=='-2'}">
					<c:set var="other" scope="request" value="${report}"></c:set>
				</c:when>
				<c:otherwise>
					<tr>
						<c:if test="${isGbcode==true}">
                            <td data-code="${report.gbCode}">
								<ehr:tip trim="true">
									<ehr:dic code="${report.gbCode}" dicmeta="FS990001"></ehr:dic>
								</ehr:tip></td>
                            <td>
                                <c:if test="${report.organCode=='-1'}">
                                    合计
                                </c:if>
                                <c:if test="${report.organCode!='-1'}">
                                    <ehr:tip trim="true">
                                        <ehr:org code="${report.organCode}"></ehr:org>
                                    </ehr:tip>
                                </c:if>
                            </td>
							</c:if>
                        <c:if test="${isGbcode==false}">
                        <td>
                            <c:if test="${report.organCode=='-1'}">
                                合计
                            </c:if>
                            <c:if test="${report.organCode!='-1'}">
								<ehr:tip trim="true">
									<ehr:org code="${report.organCode}"></ehr:org>
								</ehr:tip>
                            </c:if>
                        </td>
							</c:if>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.a1}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.a2}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.a3}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.a4}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.a5}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.a51}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.b1}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.b2}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.b3}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.b4}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.b5}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.b51}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.c1}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.c2}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.c3}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.c4}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.c5}" type="number" /></td>
						<td><tags:numberLabel userGroup="true" defaultValue="0" value="${report.c51}" type="number" /></td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${not empty other }">
			<tr>
				<td>外地诊断</td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.a1}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.a2}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.a3}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.a4}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.a5}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.a51}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.b1}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.b2}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.b3}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.b4}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.b5}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.b51}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.c1}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.c2}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.c3}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.c4}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.c5}" type="number" /></td>
				<td><tags:numberLabel userGroup="true" defaultValue="0" value="${other.c51}" type="number" /></td>
			</tr>
		</c:if>
		<tr>
			<td colspan="${isGbcode==true?'2':'1'}">合计</td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.a1}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.a2}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.a3}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.a4}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.a5}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.a51}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.b1}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.b2}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.b3}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.b4}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.b5}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.b51}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c1}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c2}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c3}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c4}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c5}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c51}" type="number" /></td>
		</tr>
		<tr>
			<td colspan="${isGbcode==true?'2':'1'}">累计</td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.a11}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.a21}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.a31}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.a41}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.a51}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.a51}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.b11}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.b21}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.b31}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.b41}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.b51}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.b51}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c11}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c21}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c31}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c41}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c51}" type="number" /></td>
			<td><tags:numberLabel userGroup="true" defaultValue="0" value="${total.c51}" type="number" /></td>
		</tr>
	</c:if>
</tbody>
<tfoot>
	<tr  style="font-weight:bold;">
		<td colspan="${isGbcode==true?'8':'7'}">报告单位（盖章）:${currentOrgName }</td>
		<td colspan="6">报告人:${currentUserName}</td>
		<td colspan="6">报告日期:<fmt:formatDate pattern="yyyy/MM/dd" value="${currentDate}" /></td>
	</tr>
</tfoot>
