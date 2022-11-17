<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.portal.common.HospitalCodeForYC" %>
<c:set var="MATERNAL_CHILD_HOSPITAL" value="<%=HospitalCodeForYC.MATERNAL_CHILD_HOSPITAL.getHospitalCode()%>"/>

<div style="position: relative; z-index: 100; width: 280px;padding-bottom:10px" onmouseover="reserveschedule.showReserveTimeDiv()" onmouseout="reserveschedule.hideReserveTimeDiv()">
<div class="reserveTimeTitle"></div>
	<div class="divReserveTimeTableContent">
	<input id="scheduleId" value="${scheduleId}" type="hidden"/>
	
		<table class="reserveTableInfo" style="width:280px" cellspacing="0" cellpadding="1">
			 <colgroup>
			 	<c:choose>
			 		<c:when test="${isRealTime eq true}">
			 			<col style="width:60%;"/>
			            <col style="width:40%;"/>
			 		</c:when>
			 		<c:otherwise>
			            <col style="width:40%;"/>
			            <col style="width:20%;"/>
			            <col style="width:20%;"/>
			            <col style="width:20%;"/>
			 		</c:otherwise>
			 	</c:choose>
	        </colgroup>
			<tr style="background: #DDF1FA; color:#1170A6">
				<c:choose>
			 		<c:when test="${isRealTime eq true }">
			 			<th>预约时间段</th>
			            <th>状态</th>
			 		</c:when>
			 		<c:otherwise>
			            <th>预约时间段</th>
						<th>总号</th>
						<th>余号</th>
						<th>状态</th>
			 		</c:otherwise>
			 	</c:choose>
			</tr>
		 		<c:choose>
			 		<c:when test="${isRealTime eq true }">
			 			<c:forEach items="${registerScheduleList }" var="registerSchedule" varStatus="status">
							<c:choose>
								<c:when test="${'2' eq registerSchedule.reserveStatus }">
									<tr style="border:1px solid #ccc">
										<td>${registerSchedule.timeIntervalStart} ~ ${registerSchedule.timeIntervalEnd}</td>
										<%-- <td>${registerSchedule.admitNum }</td>
										<td>${registerSchedule.reserveNum}</td> --%>
										<td style="color: red">已满</td>
									</tr>
								</c:when>
								<c:when test="${'3' eq registerSchedule.reserveStatus }">
									<tr style="border:1px solid #ccc">
										<td>${registerSchedule.timeIntervalStart} ~ ${registerSchedule.timeIntervalEnd}</td>
										<td style="color: red">已停诊</td>
									</tr>
								</c:when>
								<c:otherwise>
									<tr style="border:1px solid #ccc"
									 onclick="reserveschedule.select({scheduleTimeId:'',scheduleId:'${registerSchedule.id }',
									hopsitalCode:'${registerSchedule.hospitalCode }', hospitalName:'${registerSchedule.hospitalName }', outClinicName:'${registerSchedule.deptName }', 
									outDoctorName:'${registerSchedule.doctorName }', clinicType:'${registerSchedule.clinicType }', ampm:'${registerSchedule.ampm }',
									registerFee:'${registerSchedule.registerFee }', deptSn:'${registerSchedule.deptSn }', doctorSn:'${registerSchedule.doctorSn }',
									requestDate:'<fmt:formatDate value="${registerSchedule.requestDate}" pattern="yyyy/MM/dd"/>',
									timeIntervalStart:'${registerSchedule.timeIntervalStart}', timeIntervalEnd:'${registerSchedule.timeIntervalEnd}'})">
										<td>${registerSchedule.timeIntervalStart } ~ ${registerSchedule.timeIntervalEnd }</td>
										<%-- <td>${registerSchedule.admitNum }</td>
										<td>${registerSchedule.reserveNum}</td> --%>
										<td style="color: #1170A6">坐诊</td>
									</tr>
									
								</c:otherwise>
							</c:choose>
			 			</c:forEach>
					</c:when>
					<c:otherwise>
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
									 onclick="reserveschedule.select({scheduleTimeId:'${time.id }',scheduleId:'${registerSchedule.id }',
									hopsitalCode:'${registerSchedule.hospitalCode }',
									hospitalName:'${registerSchedule.hospitalName }', outClinicName:'${registerSchedule.deptName }', 
									outDoctorName:'${registerSchedule.doctorName }', clinicType:'${registerSchedule.clinicType eq '01'?'普通号':'专家号' }',
									registerFee:'${registerSchedule.registerFee }', ampm:'${registerSchedule.ampm }',
									deptSn:'${registerSchedule.deptSn }', doctorSn:'${registerSchedule.doctorSn }',
									requestDate:'<fmt:formatDate value="${registerSchedule.requestDate}" pattern="yyyy/MM/dd"/> ${registerSchedule.ampm eq 'a'?'上午':'下午' }${time.timeIntervalStart}~${time.timeIntervalEnd }',
									timeIntervalStart:'${registerSchedule.timeIntervalStart}', timeIntervalEnd:'${registerSchedule.timeIntervalEnd}'})">
										<td>${time.timeIntervalStart } ~ ${time.timeIntervalEnd }</td>
										<td>${time.admitNum }</td>
										<td>${time.admitNum - time.reserveNum}</td>
										<td style="color: #1170A6">坐诊</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:otherwise>
				</c:choose>
		</table>
	</div>
</div>
<s><i></i></s>
