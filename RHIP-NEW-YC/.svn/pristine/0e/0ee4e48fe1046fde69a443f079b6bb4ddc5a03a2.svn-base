<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/diagnosis.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/tb_common.js" type="text/javascript"></script>

<div class="toolbar">
    <%--<a href="javascript:tbCommon.returnSearch('diagnosis.searchTemp')"><b class="fanhui">返回</b></a>--%>
	<a href="javascript:tbCommon.returnSearch('diagnosis.searchTemp')" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    <c:if test="${type=='2'}">
        <%--<a href="javascript:diagnosis.updateDiagnosis()"><b class="baocun">保存</b></a>--%>
		<a href="javascript:diagnosis.updateDiagnosis()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
   	</c:if>
    <input type="hidden" id="pageIndex" value="${pageIndex}">
</div>
<form id="tbForm">
	<input type="hidden" name="singleId" value="${tbSaveDto.singleId}" id="singleId"/>
	<input type="hidden" name="eventId" value="${tbSaveDto.eventId}" id="eventId"/>
	<input type="hidden" name="idmId" value="${tbSaveDto.idmId}" id="idmId"/>
	
	<input type="hidden" name="diagnosis.diagnosisReason" value="${tbSaveDto.diagnosis.diagnosisReason}"/>
	<input type="hidden" name="diagnosis.transferTreatmentAccording" value="${tbSaveDto.diagnosis.transferTreatmentAccording}"/>
	<input type="hidden" name="diagnosis.id" value="${tbSaveDto.diagnosis.id}"/>
	<input type="hidden" name="diagnosis.idmId" value="${tbSaveDto.singleId}"/>
	<input type="hidden" name="otherCondition.idmId" value="${tbSaveDto.singleId}"/>
	<input type="hidden" name="labExamine.idmId" value="${tbSaveDto.singleId}"/>
	<tag:dateInput style="display:none;" name="caseInformation.transferTreatmentDt" date="${tbSaveDto.caseInformation.transferTreatmentDt}" pattern="yyyy/MM/dd" />
	
	<div class="postcontent">
		<i class="popno">诊断结果</i>
		<div class="postdiv">
			<fieldset>
				<legend>诊断依据</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 80%" />
					</colgroup>
					<tr>
						<th>胸片来源:</th>
						<td><ehr:dic-radio dicmeta="IDM00225" name="labExamine.xSource"  value="${tbSaveDto.labExamine.xSource}"/> </td>
					</tr>
					<tr>
						<th>X线片号:</th>
						<td><input type="text" id="xNo" name="labExamine.xNo" value="${tbSaveDto.labExamine.xNo}" reg='{"maxlength":"20"}'/></td>
					</tr>
					<tr>
						<th>X射线检查结果:</th>
						<td><input type="text" name="labExamine.xrayTestResult" value="${tbSaveDto.labExamine.xrayTestResult}" reg='{"maxlength":"20"}'/></td>
					</tr>
					<tr>
						<th><label class="required">空洞有无:</label></th>
						<td><ehr:dic-radio dicmeta="PH00002" name="labExamine.cavityFlag" code="1,2" value="${tbSaveDto.labExamine.cavityFlag}" reg='{"required":"true"}'/></td>
					</tr>
					<tr>
						<th>痰涂片:</th>
						<td>
							<ehr:dic-radio name="labExamine.phlegmPcr" dicmeta="PH00022" value="${tbSaveDto.labExamine.phlegmPcr }"
								onchange="toggleOther('labExamine.phlegmPcr','picOther','99')"/>
		                     <span id="picOther" style="${tbSaveDto.labExamine.phlegmPcr=='99' ? '' : 'display: none;'}">
		                     	<input type="text" name="labExamine.phlegmPcrResult" value="${tbSaveDto.labExamine.phlegmPcrResult }" reg='{"maxlength":"20"}' style="width: 40%;" reg='{"maxlength":"50"}'/>
		                     </span>
						</td>
					</tr>
					<tr>
						<th>痰培养:</th>
						<td>
							<ehr:dic-radio name="labExamine.phlegmRtPcr" dicmeta="PH00022" value="${tbSaveDto.labExamine.phlegmRtPcr }"
								onchange="toggleOther('labExamine.phlegmRtPcr','culOther','99')"/>
		                     <span id="culOther" style="${tbSaveDto.labExamine.phlegmRtPcr=='99' ? '' : 'display: none;'}">
		                     	<input type="text" name="labExamine.phlegmRtPcrResult" value="${tbSaveDto.labExamine.phlegmRtPcrResult }" reg='{"maxlength":"20"}' style="width: 40%;" reg='{"maxlength":"50"}'/>
		                     </span>
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>诊断结果</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 80%" />
					</colgroup>
					<tr>
						<th><label class="required">治疗处理结果:</label></th>
						<td><ehr:dic-radio dicmeta="IDM00224" name="diagnosis.diagnosisType" value="${tbSaveDto.diagnosis.diagnosisType}" reg='{"required":"true"}'/> </td>
					</tr>
					<tr>
						<th>治疗分类:</th>
						<td><ehr:dic-radio dicmeta="IDM00219" name="otherCondition.caseType"  value="${tbSaveDto.otherCondition.caseType}"/> </td>
					</tr>
					<tr>
						<th>诊断医生:</th>
						<td>
							<ehr:user userCode="${tbSaveDto.diagnosis.diagnosisDoctor == null ? currentUser.userCode : tbSaveDto.diagnosis.diagnosisDoctor}"/>
							<input type="hidden" name="diagnosis.diagnosisDoctor" value="${tbSaveDto.diagnosis.diagnosisDoctor == null ? currentUser.userCode : tbSaveDto.diagnosis.diagnosisDoctor}"/>
						</td>
					</tr>
					<tr>
						<th>诊断日期:</th>
						<td>
							<tag:dateInput name="diagnosis.registerDt" date="${tbSaveDto.diagnosis.registerDt}" nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"/>
						</td>
					</tr>
				</table>
			</fieldset>
		</div>
	</div>
</form>