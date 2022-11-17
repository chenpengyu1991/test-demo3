<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/WEB-INF/tld/ehr-tag.tld" %>

<div class="repeattable" style="margin: 15px;">
	<table id="person_record_table">
        <colgroup>
            <col style="width:20%;"/>
            <col style="width:8%;"/>
            <col style="width:5%;"/>
            <col style="width:5%;"/>
            <col style="width:7%;"/>
            <col style="width:7%;"/>
            <col style="width:7%;"/>
            <col style="width:7%;"/>
            <col style="width:7%;"/>
            <col style="width:7%;"/>
            <col style="width:7%;"/>
        </colgroup>
			<thead> 
				<tr>
					<th rowspan="2">科室</th>
					<th rowspan="2">医生</th>
					<th rowspan="2">费用</th>
					<th rowspan="2">上午/<br/>下午</th>
					<c:forEach var="oneDate" items="${dateList}">
					<th>
						<fmt:formatDate value="${oneDate}" pattern="EEEE"/>
						<br/>
						<fmt:formatDate value="${oneDate}" pattern="MM/dd"/>
					</th>
					</c:forEach>
			   </tr>
			</thead>
			<tbody class="tbody"> 
				<c:forEach items="${registerSchedules}" var="registerSchedule" varStatus="status">
					<ehr:registerSchedule hospitalCode="${registerSchedule.hospitalCode }"
						 deptSn="${registerSchedule.deptSn}" doctorSn="${registerSchedule.doctorSn}"
						 clinicType="${registerSchedule.clinicType}" registerFee="${registerSchedule.registerFee}"
						 startDate="${startDate}"
						 endDate="${endDate}"
						 >
					</ehr:registerSchedule>
				</c:forEach>
			</tbody>
		</table>
	<ehr:paging action="reserveschedule.search" hidePageSize="true"/>
	<!-- 实现分页功能 -->
</div>
<div id="showReserveTimeDiv"></div>


