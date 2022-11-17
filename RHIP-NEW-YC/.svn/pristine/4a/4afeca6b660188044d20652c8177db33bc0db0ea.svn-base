<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/WEB-INF/tld/ehr-tag.tld" %>
<%@ page import="com.founder.rhip.portal.common.HospitalCodeForYC" %>
<c:set var="MATERNAL_CHILD_HOSPITAL" value="<%=HospitalCodeForYC.MATERNAL_CHILD_HOSPITAL.getHospitalCode()%>"/>
<c:set var="STOMATOLOGICAL_HOSPITAL" value="<%=HospitalCodeForYC.STOMATOLOGICAL_HOSPITAL.getHospitalCode()%>"/>
<c:if test="${not empty dateList && not empty registerSchedules}">
	<table id="person_record_table" style="font-size:13px; text-align:center;">
        <colgroup>
        	<c:if test="${type eq '02' }">
	        	<col style="width:8%;"/>
            	<col style="width:8%;"/>
        	</c:if>
        	<c:if test="${type eq '01' }">
	        	<col style="width:14%;"/>
        	</c:if>
        	<c:choose>
        		<c:when test="${MATERNAL_CHILD_HOSPITAL eq hospitalCode 
        		|| STOMATOLOGICAL_HOSPITAL eq hospitalCode }">
        			<col style="width:6%;"/>
		            <col style="width:7%;"/>
		            <col style="width:10%;"/>
		            <col style="width:10%;"/>
		            <col style="width:10%;"/>
		            <col style="width:10%;"/>
		            <col style="width:10%;"/>
		            <col style="width:10%;"/>
		            <col style="width:10%;"/>
        		</c:when>
        		<c:otherwise>
		            <col style="width:6%;"/>
		            <col style="width:6%;"/>
		            <col style="width:8%;"/>
		            <col style="width:9%;"/>
		            <col style="width:9%;"/>
		            <col style="width:9%;"/>
		            <col style="width:9%;"/>
		            <col style="width:9%;"/>
		            <col style="width:9%;"/>
		            <col style="width:9%;"/>
        		</c:otherwise>
        	</c:choose>
        </colgroup>
			<thead> 
				<tr style="background-color:#F2F2F2">
					<c:if test="${type eq '02' }">
						<td>医院</td>
						<td>科室</td>
					</c:if>
					<c:if test="${type eq '01' }">
						<td>科室</td>
					</c:if>
					<td>医生</td>
					<c:choose>
						<c:when test="${MATERNAL_CHILD_HOSPITAL != hospitalCode
						&& STOMATOLOGICAL_HOSPITAL != hospitalCode}">
							<td>费用(元)</td>
						</c:when>
					</c:choose>
					<td>时段</td>
					<c:forEach var="oneDate" items="${dateList}">
					<td style="padding:0;margin:0">
						<div style="height:22px; padding-top:4px">
							<fmt:formatDate value="${oneDate}" pattern="MM月dd日"/>
						</div>
						<div style="height:22px;padding-top:4px;background: #b3b3b3 none repeat scroll 0 0;color: #fff;">
							<fmt:formatDate value="${oneDate}" pattern="EEEE"/>
						</div>
					</td>
					</c:forEach>
			   </tr>
			</thead>
			<tbody class="tbody">
				<ehr:registerSchedule contextPath="${pageContext.request.contextPath}" hospitalCode="${hospitalCode }"
				 registerSchedules = "${registerSchedules }" startDate="${startDate}" endDate="${endDate}">
					</ehr:registerSchedule>
			</tbody>
		</table>
		<ehr:pagination action="reserveschedule.search"/>
	</c:if>
	<c:if test="${empty registerSchedules}"><div style="color:#666">无预约资源！</div></c:if>
<div id="showReserveTimeDiv"></div>

