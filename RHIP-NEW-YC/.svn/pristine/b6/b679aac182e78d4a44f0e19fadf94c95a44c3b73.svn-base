<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.portal.common.ScheduleStatus" %>
<div  onmouseover="hotExpertSearch.showReserveTimeDiv()"  onmouseout="hotExpertSearch.hideReserveTimeDiv()">
<!-- <div class="reserveTimeTitle">选择并点击以下预约即可</div> -->
	<div class="divReserveTimeTableContent">
	<input id="scheduleId" value="${scheduleId}" type="hidden"/>
		
		<table class="reserveTableInfo" style="width:225px" cellspacing="0" cellpadding="1">
			 <colgroup>
	            <col style="width:40%;"/>
	            <col style="width:20%;"/>
	            <col style="width:20%;"/>
	            <col style="width:20%;"/>
	        </colgroup>
	        <tr>
                <td colspan="4">选择并点击以下预约即可</td>
		    </tr>
			<tr style="background: #DDF1FA; color:#1170A6">
				<th>预约时间段</th>
				<th>总号</th>
				<th>余号</th>
				<th>状态</th>
			</tr>
			<c:forEach var="time" items="${registerScheduleTimeList}">
				<c:choose>
					<c:when test="${(time.admitNum - time.reserveNum) eq 0}">
						<tr style="border:1px solid #ccc">
							<td>${time.timeIntervalStart } ~ ${time.timeIntervalEnd }</td>
							<td>${time.admitNum }</td>
							<td>${time.admitNum - time.reserveNum}</td>
							<td style="color: red">已满</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr style="border:1px solid #ccc"
						 onclick="hotExpertSearch.select({scheduleTimeId:'${time.id }',scheduleId:'${registerSchedule.id }',
						hospitalName:'${registerSchedule.hospitalName }', outClinicName:'${registerSchedule.deptName }', 
						outDoctorName:'${registerSchedule.doctorName }', clinicType:'${registerSchedule.clinicType eq '01'?'普通号':'专家号' }',
						registerFee:'${registerSchedule.registerFee }', 
						requestDate:'<fmt:formatDate value="${registerSchedule.requestDate}" pattern="yyyy/MM/dd"/> ${registerSchedule.ampm eq 'a'?'上午':'下午' }${time.timeIntervalStart}~${time.timeIntervalEnd }'})">
							<td>${time.timeIntervalStart } ~ ${time.timeIntervalEnd }</td>
							<td>${time.admitNum }</td>
							<td>${time.admitNum - time.reserveNum}</td>
							<td style="color: red">坐诊</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</table>
	</div>
</div>
<s><i></i></s>
