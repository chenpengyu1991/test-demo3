<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/dref/edit.js"/>

<div class="toolbar">
	<a href="javascript:void(0)" id="back" onclick="dualReferralEdit.goBack()"><b class="fanhui">返回</b></a>
	<a href="javascript:void(0)" id="print1" ><b class="baocun">打印</b></a>
</div>
<form id="editForm" class="postcontent">
	<div class="postdiv">
		<c:if test="${drefType eq 1}">
			<i class="popno">双向转诊（转出）单</i>
		</c:if>
		<c:if test="${drefType eq 2}">
			<i class="popno">双向转诊（回转）单</i>
		</c:if>
		<input type="hidden" id="print1Id" value="${referral.id}">
		<fieldset>
			<legend>患者基本信息</legend>
			<table class="posttable">
				<colgroup>
					<col style="width: 15%"/>
					<col style="width: 35%"/>
					<col style="width: 15%"/>
					<col style="width: 35%"/>
				</colgroup>
				<tbody>
				<tr>
					<th>身份证号</th>
					<td>${referral.idCard}</td>
					<c:if test="${drefType eq 2}">
						<th>病案号</th>
						<td>${referral.medicalRecordNo}</td>
					</c:if>
				</tr>
				<tr>
					<th>姓名</th>
					<td>${referral.name}</td>
					<th>出生日期</th>
					<td colspan="3"><fmt:formatDate value="${referral.birthday}" pattern="yyyy/MM/dd"/></td>
				</tr>
				<tr>
					<th>性别</th>
					<td><ehr:dic dicmeta="GBT226112003" code="${referral.gender}"/></td>
					<th>联系电话</th>
					<td>${referral.patientPhone}</td>
				</tr>
				<tr>
					<th>家庭地址</th>
					<td colspan="3">
						<ehr:dic code="${referral.fatownShip}" dicmeta="FS990001"/>
						<ehr:dic code="${referral.fastreet}" dicmeta="FS990001"/>
						${referral.fahouseNumber}
					</td>
				</tr>
				</tbody>
			</table>
		</fieldset>
		<fieldset>
			<legend>转诊基本信息</legend>
			<table class="posttable">
				<colgroup>
					<col style="width: 15%"/>
					<col style="width: 35%"/>
					<col style="width: 15%"/>
					<col style="width: 35%"/>
				</colgroup>
				<tbody>
				<tr>
					<th>转出医院</th>
					<td>${referral.destDeptName}</td>
					<th>转入医院</th>
					<td>${referral.referralHospitalName}</td>
				</tr>
				<tr>
					<th>转出科室</th>
					<td>${referral.destRoomName}</td>
					<th>转入科室</th>
					<td>${referral.referralDeptName}</td>
				</tr>
				<tr>
					<th>转诊医生</th>
					<td>${referral.referralDoctorName}</td>
					<th>接诊医生</th>
					<td>${referral.receptionDoctorName}</td>
				</tr>
				<tr>
					<th>转诊医生电话</th>
					<td>${referral.referralDoctorPhone}</td>
					<th>转诊日期</th>
					<td colspan="3"><fmt:formatDate value="${referral.referralDate}" pattern="yyyy/MM/dd"/></td>
				</tr>
				<tr>
					<th>转诊来源</th>
					<td>${referral.referralSource eq '1'?'手机App':(referral.referralSource eq '2'?'平台':'')}</td>
					<th>接诊状态</th>
					<td>${referral.referralStatus eq '0'?'未接收':(referral.referralStatus eq '1'?'已接收':(referral.referralStatus eq '2'?'拒绝接收':''))}</td>
				</tr>
				</tbody>
			</table>
		</fieldset>
		<fieldset>
			<legend>转诊详细信息</legend>
			<table class="posttable">
				<colgroup>
					<col style="width: 15%"/>
					<col style="width: 85%"/>
				</colgroup>
				<tbody>
				<c:choose>
					<c:when test="${referral.referralStatus eq '2'}">
						<tr>
							<th>拒绝接收原因</th>
							<td>${referral.refuseReason}</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:if test="${drefType eq 1}">
							<tr>
								<th>初步印象</th>
								<td>${referral.primaryDiagnosis}</td>
							</tr>
							<tr>
								<th>转出原因</th>
								<td>${referral.referralReason}</td>
							</tr>
							<tr>
								<th>主要既往史</th>
								<td>${referral.medicalHistory}</td>
							</tr>
							<tr>
								<th>治疗经过</th>
								<td>${referral.treatment}</td>
							</tr>
						</c:if>
						<c:if test="${drefType eq 2}">
							<tr>
								<th>诊断结果</th>
								<td>${referral.diagnosis}</td>
							</tr>
							<tr>
								<th>主要检查结果</th>
								<td>${referral.checkResult}</td>
							</tr>
							<tr>
								<th>治疗经过</th>
								<td>${referral.treatment}</td>
							</tr>
							<tr>
								<th>下一步治疗方案</th>
								<td>${referral.treatmentPlan}</td>
							</tr>
							<tr>
								<th>康复建议</th>
								<td>${referral.rehabilitationGuide}</td>
							</tr>
						</c:if>
					</c:otherwise>
				</c:choose>
				</tbody>
			</table>
		</fieldset>
	</div>
</form>