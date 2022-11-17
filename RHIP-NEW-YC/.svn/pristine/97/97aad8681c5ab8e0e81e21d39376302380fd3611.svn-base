<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div style="position: relative; z-index: 100; width: 550px;">
	<div style="display: block;" class="divReserveTableContent">
	<input id="scheduleId" value="${registerSchedule.id }" type="hidden"/>
	<input id="scheduleTimeId" value="${registerScheduleTime.id }" type="hidden"/>
		<table class="tableD" width="100%" cellspacing="0" cellpadding="0" border="0">
			<tbody>
				<tr>
					<td class="sign" width="23%">就诊日期：</td>
					<td width="27%">
						<fmt:formatDate value="${registerSchedule.requestDate }" pattern="yyyy年MM月dd日"/><br/>
						<fmt:formatDate value="${registerSchedule.requestDate }" pattern="EEEE"/>
						${registerScheduleTime.timeIntervalStart }~${registerScheduleTime.timeIntervalEnd }
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
					<td>${personInfo.phoneNumber }</td>
					<td class="sign">挂号费：</td>
					<td>${registerSchedule.registerFee }</td>
				</tr>
				<tr>
					<td class="sign">取号时间：</td>
					<td colspan="3" class="red font16">
						<fmt:formatDate value="${registerSchedule.requestDate }" pattern="yyyy年MM月dd日"/>
						<fmt:formatDate value="${registerSchedule.requestDate }" pattern="EEEE"/>
						${registerScheduleTime.takeNoTimeStart }~${registerScheduleTime.takeNoTimeEnd }
					</td>
				</tr>
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
