<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script
	src="${pageContext.request.contextPath}/js/views/cdm/standardization/healthPlan/diPlanInfo.js"
	type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" id="cdm-plan-list-di-back-btn"><b class="fanhui" >返回</b></a> 
	<a href="javascript:void(0)" id="cdm-plan-list-di-save-btn"><b class="baocun" >保存</b></a>
</div>
<input type="hidden" id="cdmPlanHiddenId" value="${planInfo.id}"/>
<form method="post" id="diPlanForm">	
<fieldset>
	<div class="postcontent">
		<i class="popno">糖尿病患者 <input id="diYear" name="conclusionsOfYear"
			type="text" value="${planInfo.conclusionsOfYear}" maxlength="10"
			readonly="readonly" style="width: 35px; font-weight: bold"
			reg="{'required':true}" /> 年保健计划
		</i>
		<div class="postdivs">
			<fieldset>
				<legend>诊断结论</legend>
				<table class="posttable" id="diHealthPlan">
					<colgroup>
						<col style="width: 35%;" />
						<col style="width: 60%;" />
					</colgroup>
					<tr>
						<th><label>确诊日期</label></th>
						<td><fmt:formatDate value="${planInfo.diDiagnosedDate}"></fmt:formatDate></td>
					</tr>
					<tr>
						<th><label>诊断医院</label></th>
						<td><ehr:org code="${planInfo.diDiagnosedOrganCode}"/></td>
					</tr>
					<tr>
						<th><label>分型</label></th>
						<td><ehr:dic dicmeta="DMD00007" code="${planInfo.diType}" />
						</td>
					</tr>

					<tr>
						<th id="rbgId">糖尿病症状+随机血浆葡萄糖</th>

						<td><input type="text" style="width: 50%" name="rbg"
							value="${planInfo.rbg}"
							reg='{"max":"999.9","scale":"2","regex":"number"}'>（单位：mmol/L）
						</td>
					</tr>

					<tr>
						<th id="fpgId">空腹血糖（FPG）</th>
						<td><input type="text" style="width: 50%" name="fpg"
							value="${planInfo.fpg}"
							reg='{"max":"999.9","scale":"2","regex":"number"}'>（单位：mmol/L）
						</td>
					</tr>

					<tr>
						<th id="gluValueId">糖耐量（OGTT2HPG）</th>
						<td><input type="text" style="width: 50%" name="gluValue"
							value="${planInfo.gluValue}"
							reg='{"max":"999.9","scale":"2","regex":"number"}'>（单位：mmol/L）
						</td>
					</tr>

					<tr>
						<th>复查血糖值未达到诊断标准</th>
						<td colspan="1"><input type="checkbox"
							${planInfo.doubleCheck eq '1' ? 'checked' : ''} value='1'
							name="doubleCheck"></td>
					</tr>
				</table>
			</fieldset>



			<fieldset>
				<legend>处理</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%;" />
						<col style="width: 30%;" />
						<col style="width: 20%;" />
						<col style="width: 30%;" />
					</colgroup>
					<tr>
						<th><label>糖尿病</label></th>
						<td colspan="3"><ehr:dic-radio dicmeta="DMD00037"
								name="manageLevel" value="${planInfo.manageLevel}" /></td>
					</tr>

					<tr>
						<th><label>处理方案</label></th>
						<td colspan="3"><input type="radio" value="1"
							${planInfo.process eq '1' ? 'checked' : ''} name="process">1.定期复查血糖(至少每三月一次)
						</td>
					</tr>

					<tr>
						<th colspan="1"><label></label></th>
						<td colspan="3"><input type="radio" value="2"
							${planInfo.process eq '2' ? 'checked' : ''} name="process">2.按糖尿病管理,血糖无法控制,原因不明者定期检查血糖
						</td>
					</tr>

					<tr>
						<th colspan="1"><label></label></th>
						<td colspan="3"><input type="radio" value="3"
							${planInfo.process eq '3' ? 'checked' : ''} name="process">3.非药物量化管理
						</td>
					</tr>

					<tr>
						<th colspan="1"><label></label></th>
						<td colspan="3"><input type="radio" value="4"
							${planInfo.process eq '4' ? 'checked' : ''} name="process">4.非药物量化管理，同时进行药物治疗
						</td>
					</tr>

					<tr>
						<th colspan="1"><label></label></th>
						<td colspan="3"><input type="radio" value="5"
							${planInfo.process eq '5' ? 'checked' : ''} name="process">5.药物治疗,同时进行非药物一般管理，必要时转诊
						</td>
					</tr>

					<tr>
						<th colspan="1"><label></label></th>
						<td colspan="3"><input type="radio" value="6"
							${planInfo.process eq '6' ? 'checked' : ''} name="process">6.转诊
							<input type="hidden" name="id" value="${planInfo.id}" /> <input
							type="hidden" name="diseaseType" value="2" /> <input
							type="hidden" name="personId" value="${planInfo.personId}" /> <input
							type="hidden" name="idcard" value="${planInfo.idcard}" /></td>
					</tr>

					<tr>
						<th><label class="required">制定日期</label></th>
						<td><tag:dateInput style="width:100px;" name="createDate"
								id="createDiDate" onlypast="true" date="${planInfo.createDate}"
								reg="{'required':true}" /></td>

						<th><label>医生签名</label></th>
						<td><input type="text" style="width: 100px;" value="<ehr:user userCode='${planInfo.createDoctorCode}'></ehr:user>" readonly="readonly"/> </td>
						
					</tr>
				</table>
			</fieldset>
		</div>
	</div>
</fieldset>
</form>
