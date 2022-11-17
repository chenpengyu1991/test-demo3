<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script data-main="${pageContext.request.contextPath}/js/util/main_report_dref" src="${pageContext.request.contextPath}/js/require/require.js"></script>


<div class="toolbar">
	<!-- <a href="javascript:void(0)" id="back"><b class="fanhui">返回</b></a> -->
	<a href="javascript:void(0)" id="saveOut"><b class="baocun">保存并打印</b></a>
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
		<input type="hidden" id="print1Id">
		<input type="hidden" name="id" value="${referral.id}"/>
		<input type="hidden" id="personId" name="personId" value="${referral.personId}"/>
		<input type="hidden" id="healthFileNo" name="healthFileNo" value="${referral.healthFileNo}"/>
		<input type="hidden" name="dualReferralType" value="${drefType}"/>
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
					<th><label class="required">身份证号</label></th>
					<td><input type="text" id="idCard" name="idCard" placeholder="输入身份证获取个人信息"
					           value="${referral.idCard}" style="width: 150px" reg='{"required":"true", "idCard":"true"}'/></td>
					<c:if test="${drefType eq 2}">
						<th>病案号</th>
						<td><input type="text" id="medicalRecordNo" name="medicalRecordNo" value="${referral.medicalRecordNo}" style="width: 150px" reg="{'maxlength':18}"/></td>
					</c:if>
				</tr>
				<tr>
					<th><label class="required">姓名</label></th>
					<td><input type="text" id="name" name="name" value="${referral.name}" style="width: 150px" reg="{'required':'true','maxlength':50}"/></td>
					<th><label class="required">出生日期</label></th>
					<td colspan="3"><tag:dateInput id="birthday" name="birthday" pattern="yyyy/MM/dd" date="${referral.birthday}" style="width: 150px" reg="{'required':'true'}"/></td>
				</tr>
				<tr>
					<th><label class="required">性别</label></th>
					<td><ehr:dic-radio id="gender" name="gender" dicmeta="GBT226112003" value="${referral.gender}" reg="{'required':'true'}"/></td>
					<th>联系电话</th>
					<td><input type="text" id="patientPhone" name="patientPhone" value="${referral.patientPhone}" style="width: 150px" reg="{'maxlength':20}"/></td>
				</tr>
				<tr>
					<th>家庭地址</th>
					<td colspan="3">
						<ehr:dic-town-village townName="fatownShip" villageName="fastreet" townId="fatownShip" villageId="fastreet"
								townValue="${referral.fatownShip}" villageValue="${referral.fastreet}" width="200px" callback="dualReferralEdit.addressPrefix"/>
						<br/>
						<span id="addressPrefix"></span>
						<input type="text" id="fahouseNumber" name="fahouseNumber" value="${referral.fahouseNumber}" style="width: 200px" reg="{'maxlength':70}"/>（详细地址）
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
					<td>
                        <%--${currentOrgan.organName}--%>${!empty referral.destDeptName ? referral.destDeptName : currentOrgan.organName}
                        <input type="hidden" id="destDeptCode" name="destDeptCode" value="${!empty referral.destDeptCode ? referral.destDeptCode : currentOrgan.organCode}"/>
                        <input type="hidden" name="destDeptName" value="${!empty referral.destDeptName ? referral.destDeptName : currentOrgan.organName}"/>
					</td>
					<th><label class="required">转入医院</label></th>
					<td>
						<tag:autoSelect name="referralHospitalCode" id="referralHospital" codeValue="${referral.referralHospitalCode}" style="width: 150px" reg="{'required':'true'}"/>
						<input type="hidden" id="referralHospitalName" name="referralHospitalName"/>
					</td>
				</tr>
				<tr>
					<th>转出科室</th>
					<td>
						<select id="destRoomCode" name="destRoomCode" style="width: 150px">
							<option value="">请选择</option>
							<c:forEach var="destRoom" items="${destRoomList}">
								<option value="${destRoom.deptCode}" ${referral.destRoomCode eq destRoom.deptCode ? "selected" : ""}>${destRoom.deptName}</option>
							</c:forEach>
						</select>
						<input type="hidden" id="destRoomName" name="destRoomName"/>
					</td>
					<th>转入科室</th>
					<td>
						<select id="referralDeptCode" name="referralDeptCode" style="width: 150px">
							<option value="">请选择</option>
							<c:forEach var="referralDept" items="${referralDeptList}">
								<option value="${referralDept.deptCode}" ${referral.referralDeptCode eq referralDept.deptCode ? "selected" : ""}>${referralDept.deptName}</option>
							</c:forEach>
						</select>
						<input type="hidden" id="referralDeptName" name="referralDeptName"/>
					</td>
				</tr>
				<tr>
					<th><label class="required">转诊医生</label></th>
					<td><input type="text" name="referralDoctorName" value="${referral.referralDoctorName}" style="width: 150px" reg="{'required':'true','maxlength':50}"/></td>
					<th><label class="required">接诊医生</label></th>
					<td><input type="text" name="receptionDoctorName" value="${referral.receptionDoctorName}" style="width: 150px" reg="{'required':'true','maxlength':50}"/></td>
				</tr>
				<tr>
					<th>转诊医生电话</th>
					<td><input type="text" name="referralDoctorPhone" value="${referral.referralDoctorPhone}" style="width: 150px" reg="{'maxlength':20}"/></td>
					<th><label class="required">转诊日期</label></th>
					<td colspan="3"><tag:dateInput name="referralDate" pattern="yyyy/MM/dd" date="${referral.referralDate}" reg="{'required':'true'}" style="width: 150px"/></td>
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
				<c:if test="${drefType eq 1}">
					<tr>
						<th>初步印象</th>
						<td><textarea name="primaryDiagnosis" cols="30" rows="5" reg="{'maxlength':200}">${referral.primaryDiagnosis}</textarea></td>
					</tr>
					<tr>
						<th>转出原因</th>
						<td><textarea name="referralReason" cols="30" rows="5" reg="{'maxlength':100}">${referral.referralReason}</textarea></td>
					</tr>
					<tr>
						<th>主要既往史</th>
						<td><textarea name="medicalHistory" cols="30" rows="5" reg="{'maxlength':200}">${referral.medicalHistory}</textarea></td>
					</tr>
					<tr>
						<th>治疗经过</th>
						<td><textarea name="treatment" cols="30" rows="5" reg="{'maxlength':200}">${referral.treatment}</textarea></td>
					</tr>
				</c:if>
				<c:if test="${drefType eq 2}">
					<tr>
						<th>诊断结果</th>
						<td><input type="text" name="diagnosis" value="${referral.diagnosis}" reg="{'maxlength':100}"/></td>
					</tr>
					<tr>
						<th>主要检查结果</th>
						<td><textarea name="checkResult" cols="30" rows="5" reg="{'maxlength':200}">${referral.checkResult}</textarea></td>
					</tr>
					<tr>
						<th>治疗经过</th>
						<td><textarea name="treatment" cols="30" rows="5" reg="{'maxlength':200}">${referral.treatment}</textarea></td>
					</tr>
					<tr>
						<th>下一步治疗方案</th>
						<td><textarea name="treatmentPlan" cols="30" rows="5" reg="{'maxlength':200}">${referral.treatmentPlan}</textarea></td>
					</tr>
					<tr>
						<th>康复建议</th>
						<td><textarea name="rehabilitationGuide" cols="30" rows="5" reg="{'maxlength':100}">${referral.rehabilitationGuide}</textarea></td>
					</tr>
				</c:if>
				</tbody>
			</table>
		</fieldset>
	</div>
</form>