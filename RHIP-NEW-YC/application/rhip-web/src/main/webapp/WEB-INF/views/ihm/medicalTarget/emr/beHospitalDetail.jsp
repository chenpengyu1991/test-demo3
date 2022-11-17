<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="postcontent">
	<table class="posttable">
		<colgroup>
			<col style="min-width:150px;width:20%;"/>
	        <col style="min-width:80px;width:30%;"/>
			<col style="min-width:80px;width:20%;"/>
	        <col style="min-width:80px;width:30%"/>
		</colgroup>
		<tr>
			<th>住院号：</th>
			<th style="text-align: left">${inpatientInfo.admissionNo}</th>
			<th>病案号：</th>
			<th style="text-align: left">${inpatientInfo.medicalRecordNo}</th>
		</tr>
		<tr>
			<th>姓名：</th>
			<th style="text-align: left">${inpatientInfo.name}</th>
			<th>性别：</th>
			<th style="text-align: left">
			    <ehr:dic dicmeta="GBT226112003" code="${inpatientInfo.gender}"/>
			</th>
		</tr>
		<tr>
			<th>年龄：</th>
			<th style="text-align: left">${inpatientInfo.age}</th>
			<th>出生日期：</th>
			<th style="text-align: left">${inpatientInfo.birthday}</th>
		</tr>
		<tr>
			<th>婚姻状况：</th>
			<th style="text-align: left">
			    <ehr:dic dicmeta="GBT226122003" code="${inpatientInfo.marriage}"/>
		    </th>
			<th>病区名称：</th>
			<th style="text-align: left">${inpatientInfo.sickAreaName}</th>
		</tr>
		<tr>
			<th>病房号：</th>
			<th style="text-align: left">${inpatientInfo.sickroomNo}</th>
			<th>病床号：</th>
			<th style="text-align: left">${inpatientInfo.sickbedNo}</th>
		</tr>
		<tr>
			<th>发病日期时间：</th>
			<th style="text-align: left">${inpatientInfo.pathogenesisDate}</th>
			<th>主治医生名称：</th>
			<th style="text-align: left">${inpatientInfo.attendingPhysicianName}</th>
		</tr>
		<tr>
			<th>入院病情：</th>
			<th style="text-align: left">${inpatientInfo.inhosCondition}</th>
			<th>住院次数：</th>
			<th style="text-align: left">${inpatientInfo.inhosCount}</th>
		</tr>
		<tr>
			<th>住院天数：</th>
			<th style="text-align: left">${inpatientInfo.inhosDays}</th>
			<th>抢救次数：</th>
			<th style="text-align: left">${inpatientInfo.inhosRescueTimes}</th>
		</tr>
		<tr>
			<th>转出机构名称：</th>
			<th style="text-align: left">${inpatientInfo.destDeptName}</th>
			<th>转出机构科室名称：</th>
			<th style="text-align: left">${inpatientInfo.destRoomName}</th>
		</tr>
		<tr>
			<th>创建机构名称：</th>
			<th style="text-align: left">${inpatientInfo.referralHospitalName}</th>
			<th>转入机构名称：</th>
			<th style="text-align: left">${inpatientInfo.referralDeptName}</th>
		</tr>
		<tr>
			<th>入院原因：</th>
			<th style="text-align: left">${inpatientInfo.inhosReason}</th>
			<th>入院日期：</th>
			<th style="text-align: left">${inpatientInfo.inhosDate}</th>
		</tr>
	</table>
</div>