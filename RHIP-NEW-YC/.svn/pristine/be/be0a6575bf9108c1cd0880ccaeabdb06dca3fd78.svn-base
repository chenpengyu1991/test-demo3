<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/basic/referralEdit.js"/>
<div class="toolbar">
	<!-- <a href="javascript:void(0)"><b class="baocun" id="saveBtn">保存</b></a> -->
	<a href="javascript:void(0)" id="backBtn"><button class=" btn-gray layui-btn layui-btn-sm"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<a href="javascript:void(0)" id="saveBtn"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
</div>
<form id="editForm" class="postcontent">
	<div class="postdiv">
		<c:if test="${referral.dualReferralType eq 1}">
			<i class="popno">双向转诊（转出）单</i>
		</c:if>
		<c:if test="${referral.dualReferralType eq 2}">
			<i class="popno">双向转诊（回转）单</i>
		</c:if>
		<input type="hidden" name="id" value="${referral.id}"/>
		<input type="hidden" id="personId" name="personId" value="${referral.personId}"/>
		<input type="hidden" name="dualReferralType" value="${referral.dualReferralType}"/>
		<input type="hidden" name="referralCode" value="${referral.referralCode}"/>
		<input type="hidden" name="destDeptCode" value="${referral.destDeptCode}"/>
		<fieldset class="layui-elem-field">
			<legend>患者基本信息</legend>
			<table class="posttable">
				<colgroup>
					<col style="width: 20%"/>
					<col style="width: 32%"/>
					<col style="width: 13%"/>
					<col style="width: 35%"/>
				</colgroup>
				<tbody>
				<tr>
					<c:if test="${referral.dualReferralType eq 2}">
						<th>病案号</th>
						<td>${referral.medicalRecordNo}
							<input type="hidden" name="medicalRecordNo" value="${referral.medicalRecordNo}"/>
							<input type="hidden" name="healthFileNo" value="${referral.healthFileNo}"/>
						</td>
					</c:if>
					<c:if test="${referral.dualReferralType eq 1}">
						<th>档案编号</th>
						<td>${referral.healthFileNo}
							<input type="hidden" name="healthFileNo" value="${referral.healthFileNo}"/>
							<input type="hidden" name="medicalRecordNo" value="${referral.medicalRecordNo}"/>
						</td>
					</c:if>
					<th>身份证号</th>
					<td>
						${referral.idCard}
						<input type="hidden" name="idCard" value="${referral.idCard}" />
					</td>
				</tr>
				<tr>
					<th>姓名</th>
					<td>${referral.name}
						<input type="hidden" name="name" value="${referral.name}" />
					</td>
					<th>性别</th>
					<td>
						<ehr:dic code="${referral.gender}" dicmeta="GBT226112003"/>
						<input type="hidden" name="gender" value="${referral.gender}"/>
					</td>
				</tr>
				<tr>
					<th>联系电话</th>
					<td><input type="text" id="patientPhone" name="patientPhone" value="${referral.patientPhone}" reg="{'maxlength':20}"/></td>
					<th>年龄（岁）</th>
					<%--<td><input type="text" id="age" name="age" value="${referral.age}"  reg="{'maxlength':20,'digits':true}"/></td>--%>
					<td><tag:numberInput id="age" name="age" value="${referral.age}" reg="{'maxlength':20,'digits':true}"/></td>
				</tr>
				<tr>
					<th><label class="required">现地址： </label></th>
					<td colspan="3">
						<ehr:dic-town-street-village villageId="village_address" streetId="street_address"
													 townId="town_address" villageName="faGroup" streetName="fastreet"
													 townName="fatownShip" villageValue="${referral.faGroup}" streetValue="${referral.fastreet}"
													 townValue="${referral.fatownShip}" width="118px;" reg="{'required':true}" callback="referralEdit.displayFaAddress"/>
					</td>
				</tr>
				<tr >
					<th class="htr"><label class="required">住址详细地址：</label></th>
					<td class="htr">
						<label id="tempPaValue">${orgPaName}${orgPaNamePastreet}<ehr:dic code="${referral.faGroup}" dicmeta="FS990001"/></label><br/>
						<input type="text" id="text_fahouseNumber" reg='{"required":true,"maxlength":50}'   name="fahouseNumber" value="${referral.fahouseNumber}"/>
					</td>
				</tr>
				</tbody>
			</table>
		</fieldset>
		<c:if test="${referral.dualReferralType eq 1}">
			<fieldset class="layui-elem-field">
				<legend>双向转诊（转出）单信息</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%"/>
						<col style="width: 32%"/>
						<col style="width: 13%"/>
						<col style="width: 35%"/>
					</colgroup>
					<tbody>
					<tr>
						<th><label class="required">转入医院</label></th>
						<td>
							<input type="text" id="referralHospitalName" name="referralHospitalName" value="${referral.referralHospitalName}"  reg="{'required':'true','maxlength':50}"/>
							<%-- <tag:autoSelect name="referralHospitalCode" id="referralHospital" codeValue="${referral.referralHospitalCode}" style="width: 150px" reg="{'required':'true'}"/>
							<input type="hidden" id="referralHospitalName" name="referralHospitalName"/> --%>
						</td>
						<th>转入科室</th>
						<td>
							<input type="text" id="referralDeptName" name="referralDeptName" value="${referral.referralDeptName}"/>
							<%-- <select id="referralDeptCode" name="referralDeptCode" style="width: 150px">
								<option value="">请选择</option>
								<c:forEach var="referralDept" items="${referralDeptList}">
									<option value="${referralDept.deptCode}" ${referral.referralDeptCode eq referralDept.deptCode ? "selected" : ""}>${referralDept.deptName}</option>
								</c:forEach>
							</select>
							<input type="hidden" id="referralDeptName" name="referralDeptName"/> --%>
						</td>
					</tr>
					<tr>
						<th><label class="required">接诊医生</label></th>
						<td><input type="text" name="receptionDoctorName" value="${referral.receptionDoctorName}"  reg="{'required':'true','maxlength':50}"/></td>
					</tr>
					<tr>
						<th>初步印象</th>
						<td colspan="3"><textarea name="primaryDiagnosis" cols="30" rows="4" reg="{'maxlength':200}">${referral.primaryDiagnosis}</textarea></td>
					</tr>
					<tr>
						<th>主要现病史（转出原因）</th>
						<td colspan="3"><textarea name="referralReason" cols="30" rows="4" reg="{'maxlength':100}">${referral.referralReason}</textarea></td>
					</tr>
					<tr>
						<th>主要既往史</th>
						<td colspan="3"><textarea name="medicalHistory" cols="30" rows="4" reg="{'maxlength':200}">${referral.medicalHistory}</textarea></td>
					</tr>
					<tr>
						<th>治疗经过</th>
						<td colspan="3"><textarea name="treatment" cols="30" rows="4" reg="{'maxlength':200}">${referral.treatment}</textarea></td>
					</tr>
					<tr>
						<th><label class="required">转出医院</label></th>
						<td>
							<input type="text" id="destDeptName" name="destDeptName" value="${referral.destDeptName}" reg="{'required':'true','maxlength':50}"/>
						</td>
						<th><label class="required">转诊日期</label></th>
						<td colspan="3">
						<%-- <tag:dateInput name="referralDate" pattern="yyyy/MM/dd" date="${referral.referralDate}" reg="{'required':'true'}" /> --%>
						<input type="text" class="layui-input x-admin-content-sm-date"  reg="{'required':'true'}" name="referralDate" id="referralDate111" style="padding-left: 0px;" value="<fmt:formatDate value='${referral.referralDate}' pattern='yyyy/MM/dd'/>">
						</td>
					</tr>
					<tr>
						<th><label class="required">转诊医生</label></th>
						<td><input type="text" name="referralDoctorName" value="${!empty referral.referralDoctorName ? referral.referralDoctorName : docName}" reg="{'required':'true','maxlength':50}"/></td>
						<th>转诊医生电话</th>
						<td><input type="text" name="referralDoctorPhone" value="${referral.referralDoctorPhone}"  reg="{'maxlength':20}"/></td>
					</tr>
					</tbody>
				</table>
			</fieldset>
		</c:if>
		<c:if test="${referral.dualReferralType eq 2}">
			<fieldset class="layui-elem-field">
				<legend>双向转诊（回转）单信息</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%"/>
						<col style="width: 32%"/>
						<col style="width: 13%"/>
						<col style="width: 35%"/>
					</colgroup>
					<tbody>
					<tr>
						<th><label class="required">转回医院</label></th>
						<td>
							<input type="text" id="referralHospitalName" name="referralHospitalName" value="${referral.referralHospitalName}" reg="{'required':'true','maxlength':50}"/>
							<%-- <tag:autoSelect name="referralHospitalCode" id="referralHospital" codeValue="${referral.referralHospitalCode}" style="width: 150px" reg="{'required':'true'}"/>
							<input type="hidden" id="referralHospitalName" name="referralHospitalName"/> --%>
						</td>
					</tr>
					<tr>
						<th><label class="required">接诊医生</label></th>
						<td><input type="text" name="receptionDoctorName" value="${referral.receptionDoctorName}"  reg="{'required':'true','maxlength':50}"/></td>
					</tr>
					<tr>
						<th>诊断结果</th>
						<td><input type="text" name="diagnosis" value="${referral.diagnosis}" reg="{'maxlength':100}"/></td>
					</tr>
					<tr>
						<th>主要检查结果</th>
						<td colspan="3"><textarea name="checkResult" cols="30" rows="5" reg="{'maxlength':200}">${referral.checkResult}</textarea></td>
					</tr>
					<tr>
						<th>治疗经过</th>
						<td colspan="3"><textarea name="treatment" cols="30" rows="5" reg="{'maxlength':200}">${referral.treatment}</textarea></td>
					</tr>
					<tr>
						<th>下一步治疗方案</th>
						<td colspan="3"><textarea name="treatmentPlan" cols="30" rows="5" reg="{'maxlength':200}">${referral.treatmentPlan}</textarea></td>
					</tr>
					<tr>
						<th>康复建议</th>
						<td colspan="3"><textarea name="rehabilitationGuide" cols="30" rows="5" reg="{'maxlength':100}">${referral.rehabilitationGuide}</textarea></td>
					</tr>
					<tr>
						<th><label class="required">转出医院</label></th>
						<td>
							<input type="text" id="destDeptName" name="destDeptName"  value="${referral.destDeptName}" reg="{'required':'true','maxlength':50}"/>
						</td>
						<th><label class="required">转诊日期</label></th>
						<td colspan="3">
						<input type="text" class="layui-input x-admin-content-sm-date" name="referralDate" id="referralDate111" reg="{'required':'true'}"style="padding-left: 0px; width:75%;" value="<fmt:formatDate value='${referral.referralDate}' pattern='yyyy/MM/dd'/>">
						</td>
					</tr>
					<tr>
						<th><label class="required">转诊医生</label></th>
						<td><input type="text" name="referralDoctorName" value="${!empty referral.referralDoctorName ? referral.referralDoctorName : docName}"  reg="{'required':'true','maxlength':50}"/></td>
						<th>转诊医生电话</th>
						<td><input type="text" name="referralDoctorPhone" value="${referral.referralDoctorPhone}"  reg="{'maxlength':20}"/></td>
					</tr>
					</tbody>
				</table>
			</fieldset>
		</c:if>
	</div>
</form>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
          elem: '#referralDate111'
       	   ,format: 'yyyy/MM/dd'
       		, trigger: 'click'
       			,done:function (value) {
       				if(!$.isEmpty(value)){
       					$("#referralDate111").removeClass("lose");
       				}else{
       					$("#referralDate111").addClass("lose");
       				}
       			}
        });

      });

    </script>