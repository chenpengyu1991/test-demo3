<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.portal.common.HospitalCodeForYC" %>
<c:set var="MATERNAL_CHILD_HOSPITAL" value="<%=HospitalCodeForYC.MATERNAL_CHILD_HOSPITAL.getHospitalCode()%>"/>
<c:set var="STOMATOLOGICAL_HOSPITAL" value="<%=HospitalCodeForYC.STOMATOLOGICAL_HOSPITAL.getHospitalCode()%>"/>
<div style="position: relative; z-index: 100; width: 550px;">
	<div style="display: block;" class="divReserveTableContent">
	<div id="showReserve">
		<form id= "register_form">
			<input id="clinicType" name="clinicType" value="${registerSchedule.clinicType }" type="hidden"/>
			<input id="scheduleId" name="scheduleId" value="${registerSchedule.id }" type="hidden"/>
			<input id="scheduleTimeId" name="scheduleTimeId" value="${registerScheduleTime.id }" type="hidden"/>
			<input id="hospitalCode" name="hospitalCode" value="${registerSchedule.hospitalCode }" type="hidden"/>
			<input id="hospitalName" name="hospitalName" value="${registerSchedule.hospitalName }" type="hidden"/>
			<input id="deptSn" name="deptSn" value="${registerSchedule.deptSn}" type="hidden"/>
			<input id="deptName" name="deptName" value="${registerSchedule.deptName }" type="hidden"/>
			<input id="doctorSn" name="doctorSn" value="${registerSchedule.doctorSn }" type="hidden"/>
			<input id="doctorName" name="doctorName" value="${registerSchedule.doctorName }" type="hidden"/>
			<input id="requestDate" name="requestDate" value="<fmt:formatDate value="${registerSchedule.requestDate }" pattern="yyyy/MM/dd"/>" type="hidden"/>
			<input id="ampm" name="ampm" value="${registerSchedule.ampm }" type="hidden"/>
			<input id="registerFee" name="registerFee" value="${registerSchedule.registerFee }" type="hidden"/>
			<c:choose>
				<c:when test="${isRealTime eq true}">
					<input id="timeIntervalStart" name="timeIntervalStart" value="${registerSchedule.timeIntervalStart }" type="hidden"/>
					<input id="timeIntervalEnd" name="timeIntervalEnd" value="${registerSchedule.timeIntervalEnd }" type="hidden"/>
					<input id="takeNoTimeStart" name="takeNoTimeStart" value="" type="hidden"/>
					<input id="takeNoTimeEnd" name="takeNoTimeEnd" value="" type="hidden"/>
				</c:when>
				<c:otherwise>
					<input id="timeIntervalStart" name="timeIntervalStart" value="${registerScheduleTime.timeIntervalStart }" type="hidden"/>
					<input id="timeIntervalEnd" name="timeIntervalEnd" value="${registerScheduleTime.timeIntervalEnd }" type="hidden"/>
					<input id="takeNoTimeStart" name="takeNoTimeStart" value="${registerScheduleTime.takeNoTimeStart }" type="hidden"/>
					<input id="takeNoTimeEnd" name="takeNoTimeEnd" value="${registerScheduleTime.takeNoTimeEnd }" type="hidden"/>
				</c:otherwise>
			</c:choose>
		</form>
	</div>
		<table class="tableD" width="100%" cellspacing="0" cellpadding="0" border="0">
			<tbody>
				<tr>
					<td class="sign" width="23%">就诊日期：</td>
					<td width="27%">
						<fmt:formatDate value="${registerSchedule.requestDate }" pattern="yyyy年MM月dd日"/><br/>
						<fmt:formatDate value="${registerSchedule.requestDate }" pattern="EEEE"/>
						<c:choose>
							<c:when test="${isRealTime eq true}">
								${registerSchedule.timeIntervalStart }~${registerSchedule.timeIntervalEnd }
							</c:when>
							<c:otherwise>
								${registerScheduleTime.timeIntervalStart }~${registerScheduleTime.timeIntervalEnd }
							</c:otherwise>
						</c:choose>
					</td>
					<td class="sign" width="23%">医院名称：</td>
					<td width="27%">${registerSchedule.hospitalName }</td>
				</tr>
				<tr>
					<td class="sign">科室名称：</td>
					<td>${registerSchedule.deptName }</td>
					<td class="sign">医生姓名：</td>
					<td>${registerSchedule.doctorName }</td>
				</tr>
				<tr>
					<td class="sign">就诊者姓名：</td>
					<td>${personInfo.name }</td>
					<td class="sign">证件号码：</td>
					<td>${personInfo.idcard }</td>
				</tr>
				<tr>
					<td class="sign">手机：</td>
					<c:choose>
						<c:when test="${MATERNAL_CHILD_HOSPITAL != registerSchedule.hospitalCode 
						&& STOMATOLOGICAL_HOSPITAL != registerSchedule.hospitalCode}">
							<td>${personInfo.phoneNumber }</td>
							<td class="sign">挂号费：</td>
							<td>${registerSchedule.registerFee }</td>
						</c:when>
						<c:otherwise>
							<td colspan="3">${personInfo.phoneNumber }</td>
						</c:otherwise>
					</c:choose>
				</tr>
				<c:if test="${isRealTime eq false }">
					<tr>
						<td class="sign">取号时间：</td>
						<td colspan="3" class="red font16">
							<fmt:formatDate value="${registerSchedule.requestDate }" pattern="yyyy年MM月dd日"/>
							<fmt:formatDate value="${registerSchedule.requestDate }" pattern="EEEE"/>
							${registerScheduleTime.takeNoTimeStart }~${registerScheduleTime.takeNoTimeEnd }
						</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>
	<div class="reserve-tip">
		<div class="tip-img">
		
		</div>
		<div class="tip-content">
			请您及时就诊，三次逾期未就诊将自动拉入黑名单，用户在医院规定的取消时限内取消预约号，一般截止时间为就诊日期的前一天下午16:00点，就诊当天不能取消当日预约号。
		</div>
	</div>
	<div class="btnArea1">
		<input class="btnNormal" type="button" onclick="reserveCommon.save()" value="确认">
		<input class="btnNormal" type="button" onclick="reserveCommon.confirmClose()" value="取消" name="input">
	</div>
	
	
</div>
<div id="loading" class="loading-grid" style="position: absolute;padding-top:80px;margin-top:-250px;height:170px;padding-left:250px;">
    <div class="loading-cell">
      <div class="loading-card">
        <span class="loading-spinner-loader">Loading&#8230;</span>
      </div>
    </div>
</div>
