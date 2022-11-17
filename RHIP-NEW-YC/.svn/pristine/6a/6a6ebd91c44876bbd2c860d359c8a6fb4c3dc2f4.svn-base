<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:120px;width: 15%;"/>
	        <col style="min-width:80px;width: 10%;"/>
			<col style="min-width:80px;width: 10%;"/>
	        <col style="min-width:80px;width: 10%;"/>
			<col style="min-width:140px;width: 15%;"/>
			<col style="min-width:80px;width: 10%;"/>
           	<col style="min-width:80px;width: 10%;"/>
			<col style="min-width:100px;width: 10%;"/>
		</colgroup>
		<thead>
			<tr>
                <th>医疗机构</th>
				<th>监控指标</th>
                <th>
					<c:choose>
                        <c:when test='${monitorIndex == "1"}'>处方金额</c:when>
                        <c:when test='${monitorIndex == "2"}'>最大用量</c:when>
                        <c:when test='${monitorIndex == "3"}'>最大天数</c:when>
                        <c:when test='${monitorIndex == "4"}'>处方品种</c:when>
	                </c:choose>
				</th>
                <th>处方类型</th>
				<th>处方号</th>
                <th>开方日期</th>
               	<th>开方医生</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="unusual" items="${unusuals}" varStatus="status">
				<tr>
                    <td class="centertd"><ehr:tip><ehr:org  code="${fn:toUpperCase(unusual.hospitalCode)}"/></ehr:tip></td>
                    <td class="centertd">
						<c:choose>
	                        <c:when test='${monitorIndex == "1"}'><ehr:tip>处方金额</ehr:tip></c:when>
	                        <c:when test='${monitorIndex == "2"}'><ehr:tip>最大用量</ehr:tip></c:when>
	                        <c:when test='${monitorIndex == "3"}'><ehr:tip>最大天数</ehr:tip></c:when>
	                        <c:when test='${monitorIndex == "4"}'><ehr:tip>处方品种</ehr:tip></c:when>
		                </c:choose>
					</td>
                    <td class="centertd">
						<c:choose>
	                        <c:when test='${monitorIndex == "1"}'><tags:numberLabel value="${unusual.prescriptionTotalCost}" fractionDigits="4"/></c:when>
	                        <c:when test='${monitorIndex == "2"}'><tags:numberLabel value="${unusual.drugUseTotalDose}"/></c:when>
	                        <c:when test='${monitorIndex == "3"}'><tags:numberLabel value="${unusual.drugUseDays}"/></c:when>
	                        <c:when test='${monitorIndex == "4"}'><tags:numberLabel value="${unusual.prescriptionTotalCount}"/></c:when>
		                </c:choose>                    	
					</td>
                    <td class="centertd"><ehr:tip><ehr:dic dicmeta="FS10306" code="${unusual.cmType}"/></ehr:tip></td>
                    <td class="lefttd"><ehr:tip>${unusual.recordNumber}</ehr:tip></td>
                    <td class="centertd"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${unusual.prescribeDate}"/></ehr:tip></td>
                    <td class="centertd"><ehr:tip>${unusual.prescribeDoctorName}</ehr:tip></td>
					<td class="centertd">
						<a href="javascript:void(0)" id="ldaUnusualDetailId${unusual.ehrId}" data-ehrid="${unusual.ehrId}" data-recordnumber="${unusual.recordNumber}" class="person-link-btn">处方详细</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<ehr:paging/>
	<%-- 
	<table>
		<tr>
			<ehr:pagination action="unusualSearch.search" />
		</tr>
	</table> --%>
</div>