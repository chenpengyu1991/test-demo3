<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script
	src="${pageContext.request.contextPath}/js/views/mhm/management/followUp/edit.js"
	type="text/javascript"></script>
<div class="postcontent postdiv" id="detailDiv">
	<form id="followUpForm">
		<input type="hidden" name="eventId" id="eventId"
			value="${managementDto.eventId}"> <input type="hidden"
			name="statusId" id="statusId" value="${managementDto.statusId}">
		<input type="hidden" name="mhmFollowup.fillOrganCode"
			value="${managementDto.mhmFollowup.fillOrganCode}"> <input
			type="hidden" name="mhmFollowup.fillDoctorId"
			value="${managementDto.mhmFollowup.fillDoctorId}"> <input
			type="hidden" name="mhmFollowup.fillDate"
			value="<fmt:formatDate value="${managementDto.mhmFollowup.fillDate}" pattern="yyyy/MM/dd"/>">
		<input type="hidden" id="followupId" name="mhmFollowup.id"
			value="${managementDto.mhmFollowup.id}"> <input type="hidden"
			id="hHospitalCourse" name="mhmFollowup.hospitalCourse"> <input
			type="hidden" id="hLastleaveHospitalDate"
			name="mhmFollowup.lastleaveHospitalDate"> <input
			type="hidden" id="hEconomicGrantDept"
			name="mhmFollowup.economicGrantDept"> <input type="hidden"
			id="hLockState" name="mhmFollowup.lockState"> <input
			type="hidden" name="followupMedication" id="followupMedication">
		<input type="hidden" id="followupDtFlag" value="1" /> <input
			type="hidden" id="followupStatus" name="mhmFollowup.followupStatus"
			value="${managementDto.mhmFollowup.followupStatus}" />
		<fieldset style="margin-top: 10px" class="layui-elem-field">
			<legend>基本信息</legend>
			<table class="posttable">
				<colgroup>
					<col style="min-width: 120px; width: 20%;" />
					<col style="min-width: 180px; width: 30%;" />
					<col style="min-width: 80px; width: 20%;" />
					<col style="min-width: 250px; width: 30%;" />
				</colgroup>
				<tr>
					<th><label class="required">本次随访时间：</label></th>
					<td>
						<%-- <tag:dateInput id="followupDt" name="mhmFollowup.followupDt" date="${managementDto.mhmFollowup.followupDt}" pattern="yyyy/MM/dd" 
		            	reg='{"regex":"date","required":"true"}' style="width:120px;"/> --%>
						<input type="text" reg='{"regex":"date","required":"true"}'
						class="layui-input x-admin-content-sm-date"
						name="mhmFollowup.followupDt" id="followupDt"
						value="<fmt:formatDate value='${managementDto.mhmFollowup.followupDt}' pattern='yyyy/MM/dd'/>"
						style="padding-left: 0px; width: 120px;" />
					</td>
				</tr>
				<tr>
					<th>身份证号：</th>
					<td><input type="text" name="mhmFollowup.idcard"
						value="${managementDto.mhmFollowup.idcard}"
						reg='{"idCard":"idCard"}' style="width: 150px;" /></td>
					<th>姓名：</th>
					<td><input type="text" name="mhmFollowup.name"
						value="${managementDto.mhmFollowup.name}"
						reg='{"maxlength":"10","required":"true"}' style="width: 150px;" />
					</td>
				</tr>
				<tr>
					<th>是否访到</th>
					<td><ehr:dic-radio name="mhmFollowup.type"
							value="${managementDto.mhmFollowup.type}" dicmeta="PH00001"
							code="1,2" onchange="followUpEdit.toggleWay()" /></td>
					<th>本次随访形式：</th>
					<td><ehr:dic-list name="mhmFollowup.illnessType"
							value="${managementDto.mhmFollowup.illnessType}"
							dicmeta="MH00039" /></td>

				</tr>
				<%--  <tr>
		        <th>基础管理随访病情分类：</th>
		        <td><ehr:dic-list id="followupType" name="mhmFollowup.followupType" dicmeta="MH00038" value="${managementDto.mhmFollowup.followupType}" /></td>
		        		    </tr> --%>
				<tr>
					<th>本次随访对象：</th>
					<td colspan="3"><ehr:dic-radio
							name="mhmFollowup.followupPatients"
							value="${managementDto.mhmFollowup.followupPatients}"
							dicmeta="FS10402" /></td>
				</tr>
				<tr>
					<th>本次随访分类：</th>
					<td colspan="3"><ehr:dic-list id="followupType"
							name="mhmFollowup.followupType" dicmeta="MH00038"
							value="${managementDto.mhmFollowup.followupType}" width="120px;" /></td>
				</tr>

				<tr>
					<td></td>
					<td colspan="3">
						<div
							style="border: #cad9ea solid 1px; padding-bottom: 10px; margin: 0px 0px 10px 0px">
							<div style="background-color: #cad9ea">
								<b>提示：</b>
							</div>
							<div>
								<span style="font-weight: bold; margin: 0px 50px 0px 0px">1.病情不稳定</span>
								<span style="font-weight: bold; margin: 0px 0px 0px 10px">2.病情基本稳定</span>
							</div>
							<div style="font-weight: bold;">3.病情稳定</div>
							<div style="color: #dd0000;">注意：</div>
							<div style="line-height: 120%">
								<span>病情不稳定：危险评估等级为3-5级或症状明显患者</span><br> <span>病情基本稳定：危险评估等级为1-2级或症状、自知力、社会功能中至少有一项较差者</span><br>
								<span>病情稳定：危险评估等级为0级的患者</span><br>
							</div>
						</div>
					</td>
				</tr>
				<tr id="followUpId1">
					<th>危险性评估：</th>
					<td><ehr:dic-list name="mhmFollowup.riskRegister"
							value="${managementDto.mhmFollowup.riskRegister}"
							dicmeta="MH00021" /></td>
					<th>两次随访期间关锁情况：</th>
					<td><ehr:dic-list id="lockState" name="lockState"
							value="${managementDto.mhmFollowup.lockState}" dicmeta="MH00007" /></td>
				</tr>
				<tr id="followUpId2">
					<th>两次随访期间住院情况：</th>
					<td colspan="3"><ehr:dic-list id="hospitalCourse"
							name="hospitalCourse"
							value="${managementDto.mhmFollowup.hospitalCourse}"
							onchange="followUpEdit.toggleHospitalCourse();" dicmeta="MH00019"
							width="150px" /> <span id="spanHospitalCourse"> 末次出院日期：<%-- <tag:dateInput id="lastleaveHospitalDate" name="lastleaveHospitalDate" date="${managementDto.mhmFollowup.lastleaveHospitalDate}" style="width: 100px;"/> --%>
							<input type="text" reg='{"regex":"date","required":"true"}'
							class="layui-input x-admin-content-sm-date"
							name="lastleaveHospitalDate" id="lastleaveHospitalDate"
							value="<fmt:formatDate value='${managementDto.mhmFollowup.lastleaveHospitalDate}' pattern='yyyy/MM/dd'/>"
							style="padding-left: 0px; width: 100px;" />
					</span></td>
				</tr>
				<tr id="followUpId3">
					<th>住院患者有否获得经费补助：</th>
					<td><ehr:dic-radio id="economicGrantDept"
							name="economicGrantDept"
							value="${managementDto.mhmFollowup.economicGrantDept}"
							dicmeta="PH00002" code="1,2" /></td>
					<th>是否为686免费住院治疗：</th>
					<td><ehr:dic-radio name="mhmFollowup.freeInhospital"
							value="${managementDto.mhmFollowup.freeInhospital}"
							dicmeta="PH00002" code="1,2" /></td>
				</tr>
			</table>
		</fieldset>
		<fieldset style="margin-top: 10px" id="followUpIdSymptom"
			class="layui-elem-field">
			<legend>目前症状</legend>
			<table class="posttable">
				<colgroup>
					<col style="min-width: 120px; width: 20%;" />
					<col style="min-width: 180px; width: 30%;" />
					<col style="min-width: 80px; width: 20%;" />
					<col style="min-width: 250px; width: 30%;" />
				</colgroup>
				<tr>
					<th>目前症状：</th>
					<td colspan="3"><ehr:dic-checkbox name="mhmFollowup.symptom"
							dicmeta="MH00009" value="${managementDto.mhmFollowup.symptom}"
							onchange="toggleOtherCK('mhmFollowup.symptom','divSymptom','99')" />
						<div id="divSymptom">
							<input type="text" name="mhmFollowup.symptomOther"
								value="${managementDto.mhmFollowup.symptomOther}"
								style="width: 180px;" reg='{"maxlength":"10","required":"true"}' />
						</div></td>
				</tr>
				<tr>
					<th>自知力：</th>
					<td><ehr:dic-list name="mhmFollowup.insight"
							value="${managementDto.mhmFollowup.insight}" dicmeta="MH00040" />
					</td>
				</tr>
				<tr>
					<th>睡眠情况：</th>
					<td><ehr:dic-radio name="mhmFollowup.sleepCondition"
							value="${managementDto.mhmFollowup.sleepCondition}"
							dicmeta="FS10175" code="1,2,3" /></td>
					<th>饮食情况：</th>
					<td><ehr:dic-radio name="mhmFollowup.dietCondition"
							value="${managementDto.mhmFollowup.dietCondition}"
							dicmeta="FS10175" code="1,2,3" /></td>
				</tr>
				<tr>
					<th>社会功能情况：</th>
					<td colspan="3">个人生活料理：SDSS编码：<ehr:dic-list
							name="mhmFollowup.liveArrange"
							value="${managementDto.mhmFollowup.liveArrange}"
							dicmeta="PH00029" width="100px;" /> <br>家务劳动：SDSS编码：<ehr:dic-list
							name="mhmFollowup.housework"
							value="${managementDto.mhmFollowup.housework}" dicmeta="PH00029"
							width="100px;" /> <br>生产劳动及工作：SDSS编码：<ehr:dic-list
							name="mhmFollowup.productiveLabor"
							value="${managementDto.mhmFollowup.productiveLabor}"
							dicmeta="PH00029" width="100px;" /> <br>学习能力：SDSS编码：<ehr:dic-list
							name="mhmFollowup.studyCapacity"
							value="${managementDto.mhmFollowup.studyCapacity}"
							dicmeta="PH00029" width="100px;" /> <br>社会人际交往：SDSS编码：<ehr:dic-list
							name="mhmFollowup.interpersonalCommunication"
							value="${managementDto.mhmFollowup.interpersonalCommunication}"
							dicmeta="PH00029" width="100px;" />
					</td>
				</tr>
				<tr>
					<th>危险行为：</th>
					<td colspan="3">轻度滋事次数：<input type="text"
						style="width: 80px; text-align: center"
						name="mhmFollowup.mildAffray"
						value="${managementDto.mhmFollowup.mildAffray}"
						reg='{"digits":"true","min":"0","max":"200"}' /> <br>肇事次数：<input
						type="text" style="width: 80px; text-align: center"
						name="mhmFollowup.causeTrouble"
						value="${managementDto.mhmFollowup.causeTrouble}"
						reg='{"digits":"true","min":"0","max":"200"}' /> <br>肇祸次数：<input
						type="text" style="width: 80px; text-align: center"
						name="mhmFollowup.accident"
						value="${managementDto.mhmFollowup.accident}"
						reg='{"digits":"true","min":"0","max":"200"}' /> <br>其他危害行为次数：<input
						type="text" style="width: 80px; text-align: center"
						name="mhmFollowup.otherHarmfulBehaviors"
						value="${managementDto.mhmFollowup.otherHarmfulBehaviors}"
						reg='{"digits":"true","min":"0","max":"200"}' /> <br>自伤次数：<input
						type="text" style="width: 80px; text-align: center"
						name="mhmFollowup.autolesion"
						value="${managementDto.mhmFollowup.autolesion}"
						reg='{"digits":"true","min":"0","max":"200"}' /> <br>自杀未遂次数：<input
						type="text" style="width: 80px; text-align: center"
						name="mhmFollowup.attemptedSuicide"
						value="${managementDto.mhmFollowup.attemptedSuicide}"
						reg='{"digits":"true","min":"0","max":"200"}' />
					</td>
				</tr>
			</table>
		</fieldset>
		<fieldset style="margin-top: 10px" id="followUpIdmeasure"
			class="layui-elem-field">
			<legend>治疗情况与措施</legend>
			<table class="posttable">
				<colgroup>
					<col style="min-width: 120px; width: 20%;" />
					<col style="min-width: 180px; width: 30%;" />
					<col style="min-width: 80px; width: 20%;" />
					<col style="min-width: 250px; width: 30%;" />
				</colgroup>
				<tr>
					<th>用药依从性：</th>
					<td colspan="3"><ehr:dic-radio
							name="mhmFollowup.medicationCompliance"
							value="${managementDto.mhmFollowup.medicationCompliance}"
							dicmeta="MH00012" /></td>
				</tr>
				<tr>
					<th>药物不良反应：</th>
					<td colspan="3"><ehr:dic-radio
							name="mhmFollowup.drugAdverseReaction"
							value="${managementDto.mhmFollowup.drugAdverseReaction}"
							dicmeta="FS10404"
							onchange="toggleOtherCK('mhmFollowup.drugAdverseReaction','divDrugAdverseReaction','2')"
							code="1,2" />
						<div id="divDrugAdverseReaction">
							<input type="text" name="mhmFollowup.drugAdverseReactionOther"
								value="${managementDto.mhmFollowup.drugAdverseReactionOther}"
								style="width: 180px;" reg='{"maxlength":"100"}' />
						</div></td>
				</tr>
				<tr>
					<th>治疗效果：</th>
					<td colspan="3"><ehr:dic-radio
							name="mhmFollowup.therapeuticEffect"
							value="${managementDto.mhmFollowup.therapeuticEffect}"
							dicmeta="MH00013" /></td>
				</tr>
				<tr>
					<th rowspan="4">转诊情况：</th>
					<td colspan="3">是否建议转诊： <ehr:dic-radio
							name="mhmFollowup.referrals"
							value="${managementDto.mhmFollowup.referrals}" dicmeta="PH00001"
							code="2,1"
							onchange="toggleOtherCK('mhmFollowup.referrals','divReferralsReason','1')" />
					</td>
				</tr>
				<tr>
					<td colspan="3">
					<span id="divReferralsReason"> 需转诊的原因：<input type="text"
							name="mhmFollowup.referralsReason"
							value="${managementDto.mhmFollowup.referralsReason}"
							 reg='{"maxlength":"100"}' />
					</span>
					</td>
				</tr>
				<tr>
					<td colspan="3" style="padding-top: 20px;">是否已转诊： <ehr:dic-radio
							name="mhmFollowup.completedReferral"
							value="${managementDto.mhmFollowup.completedReferral}"
							dicmeta="PH00001" code="2,1"
							onchange="toggleOtherCK('mhmFollowup.completedReferral','divReferralsToOrgan','1')" />
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<span id="divReferralsToOrgan"> 转诊的机构及科室：<input type="text"
							name="mhmFollowup.referralsToOrgan"
							value="${managementDto.mhmFollowup.referralsToOrgan}"
							 reg='{"maxlength":"100"}' />
					</span>
					</td>
				
				</tr>
				<%--  <tr>
		            <th>转诊原因：</th>
		            <td>
		                <input type="text" name="mhmFollowup.referralsReason" value="${managementDto.mhmFollowup.referralsReason}" 
		                	style="width:120px;" reg='{"maxlength":"100"}'/>
		            </td>
		            <th>转诊至机构：</th>
		            <td>
		                <input type="text" name="mhmFollowup.referralsToOrgan" value="${managementDto.mhmFollowup.referralsToOrgan}" 
		                	style="width:120px;" reg='{"maxlength":"100"}'/>
		            </td>
		        </tr> --%>
				<!-- <tr>
		            <td colspan="3">
		                <b style="margin: 15px;">用药情况：</b>
		               <a href="javascript:void(0)" id="popupMedication" ><b class="xinz" style="padding-left: 20px;">添加</b></a>
		            </td>
		        </tr> -->

				<%-- <tr>
		            <td colspan="4">
		                <div class="repeattable">
		                    <div class="toolbarsublist">
		                    </div>
		                    <table id="frMedicationTable">
		                        <thead>
		                        <tr>
		                            <th class="centerth" style="width: 100px;">药物名称</th>
		                            <th class="centerth" style="width: 60px;">早</th>
		                            <th class="centerth" style="width: 60px;">中</th>
		                            <th class="centerth" style="width: 60px;">晚</th>
		                            <th class="centerth" style="width: 60px;">单位</th>
		                            <th class="centerth" >特殊情况</th>
		                            <th class="centerth" style="width: 70px;">操作</th>
		                        </tr>
		                        </thead>
		                        <tbody>
									<c:forEach var="medication" items="${managementDto.followupMedicationRecords}" varStatus="status">
										<tr item="${status.count}">
											<td field="drugName"><ehr:tip>${medication.drugName}</ehr:tip></td>
											<td field="drugMorning"><ehr:tip>${medication.drugMorning}</ehr:tip></td>
											<td field="drugNoon"><ehr:tip>${medication.drugNoon}</ehr:tip></td>
											<td field="drugEvening"><ehr:tip>${medication.drugEvening}</ehr:tip></td>
											<td field="unit"><ehr:tip>${medication.unit}</ehr:tip></td>
											<td field="drugSpecial"><ehr:tip>${medication.drugSpecial}</ehr:tip></td>
											<td field="type" style="display:none;">${medication.type}</td>
											<td field="drugId" style="display:none;">${medication.drugId}</td>
											<td class="btnsublist" field="btn">
												<a href="javascript:void(0)" onclick='followUpEdit.popupMedication(this,"edit")'>修改</a>				
												<a href="javascript:void(0)" onclick="mhmCommon.removeTr(this);" >删除</a>
											</td>											
										</tr>
									</c:forEach>
		                        </tbody>
		                    </table>
		                </div>
		            </td>
		        </tr> --%>
			</table>
			<table class="posttable" style="margin-top: 20px;">
				<colgroup>
					<col style="min-width: 120px; width: 20%;" />
					<col style="min-width: 180px; width: 80%;" />
				</colgroup>
				<tr>
					<th rowspan="6">用药情况：</th>
					<td>药物1：<input type="text" name="mhmFollowup.medicationOne"
						value="${managementDto.mhmFollowup.medicationOne}"
						 />
					</td>
				</tr>
				 <tr>
					<td colspan="2">每日(月)剂量<input type="text"
						name="mhmFollowup.medicationDoseOne"
						reg='{"scale":"2","regex":"number"}'
						value="${managementDto.mhmFollowup.medicationDoseOne}"
						style="width: 120px;" />mg
					</td>
				</tr>
				<tr>
					<td style="padding-top: 20px">药物2：<input type="text" name="mhmFollowup.medicationTwo"
						value="${managementDto.mhmFollowup.medicationTwo}"
						 />
					</td>
				</tr>
				<tr>
					<td colspan="2">每日(月)剂量<input type="text"
						name="mhmFollowup.medicationDoseTwo"
						reg='{"scale":"2","regex":"number"}'
						value="${managementDto.mhmFollowup.medicationDoseTwo}"
						style="width: 120px;" />mg
					</td>
				</tr>
				
				<tr>
					<td style="padding-top: 20px">药物3：<input type="text" name="mhmFollowup.medicationThree"
						value="${managementDto.mhmFollowup.medicationThree}"
						 />
					</td>
				</tr>
				<tr>
					<td colspan="2">每日(月)剂量<input type="text"
						name="mhmFollowup.medicationDoseThree"
						reg='{"scale":"2","regex":"number"}'
						value="${managementDto.mhmFollowup.medicationDoseThree}"
						style="width: 120px;" />mg
					</td>
				</tr>
			</table>
			<table class="posttable" style="margin-top: 20px;">
				<colgroup>
					<col style="min-width: 120px; width: 20%;" />
					<col style="min-width: 180px; width: 80%;" />
				</colgroup>
				<tr>
					<th rowspan="9">用药指导：</th>
					<td valign="middle" style="vertical-align: top">药物1：<input
						type="text" name="mhmFollowup.guidanceOne"
						value="${managementDto.mhmFollowup.guidanceOne}"
						 />
					</td>
				</tr>
				<tr>
					<td colspan="2">用法：早<input type="text"
						name="mhmFollowup.morningOne"
						value="${managementDto.mhmFollowup.morningOne}"
						reg='{"scale":"2","regex":"number"}' style="width: 60px;" />mg; 中<input
						type="text" name="mhmFollowup.noonOne"
						value="${managementDto.mhmFollowup.noonOne}" style="width: 60px;"
						reg='{"scale":"2","regex":"number"}' />mg; 晚<input type="text"
						name="mhmFollowup.nightOne"
						value="${managementDto.mhmFollowup.nightOne}" style="width: 60px;"
						reg='{"scale":"2","regex":"number"}' />mg;
					</td>
				</tr>
				<tr>
					<td colspan="2">长效药：每<input type="text"
						name="mhmFollowup.weekOne"
						value="${managementDto.mhmFollowup.weekOne}" style="width: 60px;"
						reg='{"scale":"2","regex":"number"}' />周一次; 每次<input type="text"
						name="mhmFollowup.timeOne"
						value="${managementDto.mhmFollowup.timeOne}" style="width: 60px;"
						reg='{"scale":"2","regex":"number"}' />mg;
					</td>
				</tr>
				<tr>
					<td valign="middle" style="vertical-align: top; padding-top: 20px"
						colspan="2">药物2：<input type="text"
						name="mhmFollowup.guidanceTwo"
						value="${managementDto.mhmFollowup.guidanceTwo}"
						 />
					</td>
				</tr>
				<tr>
					<td colspan="2">用法：早<input type="text"
						name="mhmFollowup.morningTwo"
						value="${managementDto.mhmFollowup.morningTwo}"
						style="width: 60px;" reg='{"scale":"2","regex":"number"}' />mg; 中<input
						type="text" name="mhmFollowup.noonTwo"
						value="${managementDto.mhmFollowup.noonTwo}" style="width: 60px;"
						reg='{"scale":"2","regex":"number"}' />mg; 晚<input type="text"
						name="mhmFollowup.nightTwo"
						value="${managementDto.mhmFollowup.nightTwo}" style="width: 60px;"
						reg='{"scale":"2","regex":"number"}' />mg;
					</td>
				</tr>
				<tr>
					<td colspan="2">长效药：每<input type="text"
						name="mhmFollowup.weekTwo"
						value="${managementDto.mhmFollowup.weekTwo}" style="width: 60px;"
						reg='{"scale":"2","regex":"number"}' />周一次; 每次<input type="text"
						name="mhmFollowup.timeTwo"
						value="${managementDto.mhmFollowup.timeTwo}" style="width: 60px;"
						reg='{"scale":"2","regex":"number"}' />mg;
					</td>
				</tr>
				<tr>
					<td valign="middle" style="vertical-align: top; padding-top: 20px"
						colspan="2">药物3：<input type="text"
						name="mhmFollowup.guidanceThree"
						value="${managementDto.mhmFollowup.guidanceThree}"
						 />
				</tr>
				<tr>
					<td colspan="2">用法：早<input type="text"
						name="mhmFollowup.morningThree"
						value="${managementDto.mhmFollowup.morningThree}"
						style="width: 60px;" reg='{"scale":"2","regex":"number"}' />mg; 中<input
						type="text" name="mhmFollowup.noonThree"
						value="${managementDto.mhmFollowup.noonThree}"
						style="width: 60px;" reg='{"scale":"2","regex":"number"}' />mg; 晚<input
						type="text" name="mhmFollowup.nightThree"
						value="${managementDto.mhmFollowup.nightThree}"
						style="width: 60px;" reg='{"scale":"2","regex":"number"}' />mg;
					</td>
				</tr>
				<tr>
					<td colspan="2">长效药：每<input type="text"
						name="mhmFollowup.weekThree"
						value="${managementDto.mhmFollowup.weekThree}"
						style="width: 60px;" reg='{"scale":"2","regex":"number"}' />周一次;
						每次<input type="text" name="mhmFollowup.timeThree"
						value="${managementDto.mhmFollowup.timeThree}"
						style="width: 60px;" reg='{"scale":"2","regex":"number"}' />mg;
					</td>
				</tr>
			</table>
			<table class="posttable" style="margin-top: 20px;">
				<colgroup>
					<col style="min-width: 120px; width: 20%;" />
					<col style="min-width: 180px; width: 30%;" />
					<col style="min-width: 80px; width: 20%;" />
					<col style="min-width: 250px; width: 30%;" />
				</colgroup>
				<tr>
					<th>实验室检查：</th>
					<td colspan="3"><ehr:dic-radio name="mhmFollowup.isCheck"
							value="${managementDto.mhmFollowup.isCheck}" dicmeta="PH00002"
							code="2,1"
							onchange="toggleOther('mhmFollowup.isCheck','spanCheckType','1')" />
						<span id="spanCheckType"> <input type="text"
							name="mhmFollowup.checkOther"
							value="${managementDto.mhmFollowup.checkOther}"
							reg='{"maxlength":"100"}' />
					</span> <%-- <ehr:dic-radio name="mhmFollowup.isCheck" value="${managementDto.mhmFollowup.isCheck}" 
		                	dicmeta="PH00002" code="1,2" onchange="toggleOther('mhmFollowup.isCheck','spanIsCheck','1')"/>
		                <span id="spanIsCheck">
		                	<ehr:dic-checkbox name="mhmFollowup.checkType" value="${managementDto.mhmFollowup.checkType}" 
		                		dicmeta="MH00054" code="A01,A02,A03,A04,A99" onchange="toggleOtherCK('mhmFollowup.checkType','spanCheckType','A99')"/>
		                	<span id="spanCheckType">
		                		<input type="text" name="mhmFollowup.checkOther" value="${managementDto.mhmFollowup.checkOther}" 
		                			reg='{"maxlength":"100"}'/>
		                	</span>	
		                </span> --%></td>
				</tr>
			</table>
		</fieldset>
		<fieldset style="margin-top: 10px" id="followUpIdSociety"
			class="layui-elem-field">
			<legend>社会功能与康复措施</legend>
			<table class="posttable">
				<colgroup>
					<col style="min-width: 120px; width: 20%;" />
					<col style="min-width: 180px; width: 30%;" />
					<col style="min-width: 80px; width: 20%;" />
					<col style="min-width: 250px; width: 30%;" />
				</colgroup>
				<tr>
					<th>未治疗原因：</th>
					<td colspan="3"><ehr:dic-list name="mhmFollowup.uncureReason"
							value="${managementDto.mhmFollowup.uncureReason}"
							dicmeta="MH00016"
							onchange="toggleOtherSC('mhmFollowup.uncureReason','divUncureReason','99')"
							width="150px" />
						<div id="divUncureReason">
							<input type="text" name="mhmFollowup.uncureReasonOther"
								value="${managementDto.mhmFollowup.uncureReasonOther}"
								style="width: 120px;" reg='{"maxlength":"100"}' />
						</div></td>
				</tr>
				<tr>
					<th>康复措施：</th>
					<td colspan="3"><ehr:dic-checkbox
							name="mhmFollowup.recoveryMeasures"
							value="${managementDto.mhmFollowup.recoveryMeasures}"
							dicmeta="MH00011"
							onchange="toggleOtherCK('mhmFollowup.recoveryMeasures','divRecoveryMeasures','99')" />
						<div id="divRecoveryMeasures">
							康复措施其他：<input type="text"
								name="mhmFollowup.recoveryMeasuresOther"
								value="${managementDto.mhmFollowup.recoveryMeasuresOther}"
								reg='{"maxlength":"100"}' style="width: 350px;" />
						</div></td>
				</tr>
				<tr>
					<th>个案管理病情总体评估：</th>
					<td colspan="3"><ehr:dic-list name="mhmFollowup.evaluation"
							value="${managementDto.mhmFollowup.evaluation}" dicmeta="MH00017"
							width="150px" /></td>
				</tr>
				<tr>
					<th>个案管理社会功能总评：</th>
					<td><ehr:dic-radio name="mhmFollowup.socialFunction"
							value="${managementDto.mhmFollowup.socialFunction}"
							dicmeta="PH00009" /></td>
					<th>应急处置：</th>
					<td><ehr:dic-radio name="mhmFollowup.emergencyDisposal"
							value="${managementDto.mhmFollowup.emergencyDisposal}"
							dicmeta="PH00001" code="1,2" /></td>
				</tr>
				<tr>
					<th>有否进行个案管理：</th>
					<td colspan="3"><ehr:dic-radio name="mhmFollowup.isCase"
							value="${managementDto.mhmFollowup.isCase}" dicmeta="PH00002"
							code="1,2" /></td>
				</tr>
				<tr>
					<th>备注</th>
					<td colspan="3"><textarea name="mhmFollowup.comments" cols="3"
							rows="4" style="width: 100%" reg='{"maxlength":"100"}'>${managementDto.mhmFollowup.comments}</textarea>
					</td>
				</tr>
			</table>
		</fieldset>
		<div id="lostFollowUp">
			<jsp:include page="content.jsp"></jsp:include>
		</div>
		<fieldset style="margin-top: 10px;" class="layui-elem-field">
			<table class="posttable">
				<colgroup>
					<col style="min-width: 120px; width: 20%;" />
					<col style="min-width: 180px; width: 30%;" />
					<col style="min-width: 80px; width: 20%;" />
					<col style="min-width: 250px; width: 30%;" />
				</colgroup>
				<tr>
					<th>随访医生签名：</th>
					<td colspan="3"><ehr:user
							userCode="${managementDto.mhmFollowup.fillDoctorId}" /></td>
				</tr>

				<tr>
					<th>下次随访日期</th>
					<td colspan="3">
						<%-- <tag:dateInput id="nextFollowupDt" name="mhmFollowup.nextFollowupDt" date="${managementDto.mhmFollowup.nextFollowupDt}" pattern="yyyy/MM/dd"
		                	style="width:120px;"/> --%> <input type="text"
						reg='{"regex":"date","required":"true"}'
						class="layui-input x-admin-content-sm-date"
						name="mhmFollowup.nextFollowupDt" id="nextFollowupDt"
						value="<fmt:formatDate value='${managementDto.mhmFollowup.nextFollowupDt}' pattern='yyyy/MM/dd'/>"
						style="padding-left: 0px; width: 120px;" />
					</td>
				</tr>

			</table>
		</fieldset>
	</form>
</div>

<script type="text/javascript">
	layui.use('laydate', function() {
		var laydate = layui.laydate;

		laydate.render({
			elem : '#followupDt',
			format : 'yyyy/MM/dd',
			trigger : 'click',
			max : 0,
			done : function(value) {
				if (!$.isEmpty(value)) {
					$("#followupDt").removeClass("lose");
				} else {
					$("#followupDt").addClass("lose");
				}
			}
		});

		laydate.render({
			elem : '#lastleaveHospitalDate',
			format : 'yyyy/MM/dd',
			trigger : 'click'
		});

		laydate.render({
			elem : '#nextFollowupDt',
			format : 'yyyy/MM/dd',
			trigger : 'click',
			done : function(value) {
				if (!$.isEmpty(value)) {
					$("#nextFollowupDt").removeClass("lose");
				} else {
					$("#nextFollowupDt").addClass("lose");
				}
			}
		});

	});
</script>