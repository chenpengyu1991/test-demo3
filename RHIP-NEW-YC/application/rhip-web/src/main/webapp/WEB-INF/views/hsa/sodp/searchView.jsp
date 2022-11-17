<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div class="toolbar">
	<a href="javascript:void(0)" id="return-sus-occ-di-button"><b class="fanhui">返回</b></a>
</div>
<form id="sus-occ-dis-form">
	<div class="postcontent">
		<i class="popno">门诊职业健康教育、咨询、指导记录表</i>
		<div class="postdiv">
			<input type="hidden" id="id" name="id" value="${susOccDiInfo.id}" />
			<fieldset>
				<legend>接诊情况</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 10%; min-width: 100px;" />
						<col style="width: 18%; min-width: 200px;" />
						<col style="width: 10%; min-width: 100px;" />
						<col style="width: 18%; min-width: 200px;" />
					</colgroup>
					<tr>
						<th><label for="admissionOrganName">接诊单位名称</label></th>
						<td><input type="text" readonly="readonly" id="admissionOrganName" name="admissionOrganName" value="${susOccDiInfo.admissionOrganName}"
							reg="{'maxlength':70}"
						></input></td>
						<th><label for="admissionDeptName">接诊部门名称</label></th>
						<td><input type="text" readonly="readonly" id="admissionDeptName" name="admissionDeptName" value="${susOccDiInfo.admissionDeptName}"
							reg="{'maxlength':70}"
						></input></td>
					</tr>
					<tr>
						<th><label for="admissionDoctorName">接诊人姓名</label></th>
						<td><input type="text" id="admissionDoctorName" readonly="readonly" name="admissionDoctorName" value="${susOccDiInfo.admissionDoctorName}"
							reg="{'maxlength':50}"
						></input></td>
						<th><label for="admissionDate">接诊时间</label></th>
						<td><input type="text" readonly="readonly" value="<fmt:formatDate value='${susOccDiInfo.admissionDate}' pattern='yyyy/MM/dd'/>" /></td>
					</tr>
						<tr>
						<th><label for="ehrNo">门诊号</label></th>
						<td><input type="text" id="ehrNo" name="ehrNo" value="${susOccDiInfo.ehrNo}" reg="{'maxlength':20}"></input></td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>就诊者情况</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 10%; min-width: 100px;" />
						<col style="width: 18%; min-width: 200px;" />
						<col style="width: 10%; min-width: 100px;" />
						<col style="width: 18%; min-width: 200px;" />
					</colgroup>
					<tr>
						<th><label for="idcard">居民身份证</label></th>
						<td><input type="text" readonly="readonly" id="idcard" name="idcard" value="${susOccDiInfo.idcard}" reg="{'maxlength':20}"></input></td>
						<th><label for="name">姓名</label></th>
						<td><input type="text" readonly="readonly" id="name" name="name" value="${susOccDiInfo.name}" reg="{'maxlength':50}"></input></td>
					</tr>
					<tr>
						<th><label for="gender">性别</label></th>
						<td><input type="text" readonly="readonly" value="<ehr:dic dicmeta="GBT226112003" code = "${susOccDiInfo.gender}"/>"></td>
						<th><label for="age">年龄</label></th>
						<td><input type="text" readonly="readonly" id="age" name="age" value="${susOccDiInfo.age}" reg="{'maxlength':10}"></input></td>
					</tr>
					<tr>
						<th><label for="unitName">工作单位</label></th>
						<td><input type="text" readonly="readonly" id="unitName" name="unitName" value="${susOccDiInfo.unitName}" reg="{'maxlength':100}"></input></td>
						<th><label for="unitAddress">工作单位地址</label></th>
						<td><input type="text" readonly="readonly" id="unitAddress" name="unitAddress" value="${susOccDiInfo.unitAddress}" reg="{'maxlength':100}"></input></td>
					</tr>
					<tr>
						<th><label class="">常住类型</label></th>
						<td><input type="text" readonly="readonly" value="<ehr:dic dicmeta="FS10005" code = "${susOccDiInfo.domicileType}"/>" />
						<th><label for="unitPhoneNumber">联系电话</label></th>
						<td><input type="text" readonly="readonly" id="phoneNumber" name="phoneNumber" value="${susOccDiInfo.phoneNumber}" reg="{'maxlength':20}"></input></td>
					</tr>
					<tr>
						<th>现住址</th>
						<td colspan="2"><input type="text" style="width: 180px" readonly="readonly"
							value="<ehr:dic dicmeta="FS990001" code="${susOccDiInfo.patownShip }"></ehr:dic>  <ehr:dic dicmeta="FS990001" code="${susOccDiInfo.pastreet }"></ehr:dic>"
						> <input style="width: 200px" type="text" readonly="readonly" id="pahouseNumber" name="pahouseNumber" value="${susOccDiInfo.pahouseNumber}" />(详细地址)</td>
					</tr>
					<tr>
						<th>户籍地址</th>
						<td colspan="2"><input class="${'1' ne susOccDiInfo.domicileType?'hide':'' }" type="text" style="width: 180px" readonly="readonly"
							value="<ehr:dic dicmeta="FS990001" code="${susOccDiInfo.hrtownShip }"></ehr:dic>  <ehr:dic dicmeta="FS990001" code="${susOccDiInfo.hrstreet }"></ehr:dic>"
						> <input style="width: 200px" type="text" readonly="readonly" id="hrhouseNumber" name="hrhouseNumber" value="${susOccDiInfo.hrhouseNumber}" />(详细地址)</td>
					</tr>
					<tr>
						<th><label for="chiefComplaintSymptoms">主要自诉症状</label></th>
						<td colspan="3"><input type="text" readonly="readonly" id="chiefComplaintSymptoms" name="chiefComplaintSymptoms"
							value="${susOccDiInfo.chiefComplaintSymptoms}" reg="{'maxlength':200}"
						></input></td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>询问内容</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 10%; min-width: 100px;" />
						<col style="width: 18%; min-width: 200px;" />
						<col style="width: 10%; min-width: 100px;" />
						<col style="width: 18%; min-width: 200px;" />
					</colgroup>
					<tr>
						<th><label for="occupation">工种</label></th>
						<td><input type="text" readonly="readonly" value="${susOccDiInfo.occupation}"></td>
						<th><label for="workPalce">工作场所</label></th>
						<td><input type="text" readonly="readonly" id="workPalce" name="workPalce" value="${susOccDiInfo.workPalce}" reg="{'maxlength':100}"></input></td>
					</tr>
					<tr>
						<th><label for="riskFactorsMayContact">可能接触的危险因素</label></th>
						<td><input type="text" readonly="readonly" id="riskFactorsMayContact" name="riskFactorsMayContact"
							value="${susOccDiInfo.riskFactorsMayContact}" reg="{'maxlength':100}"
						></input></td>
						<th><label for="contactRiskWorkingTime">接害工作时间</label></th>
						<td><input type="text" readonly="readonly" value="<fmt:formatDate value='${susOccDiInfo.contactRiskWorkingTime}' pattern='yyyy/MM/dd'/>" /></td>
					</tr>
					<tr>
						<th><label for="incidenceProcess">发病过程</label></th>
						<td colspan="3"><input type="text" readonly="readonly" id="incidenceProcess" name="incidenceProcess"
							value="${susOccDiInfo.incidenceProcess}" reg="{'maxlength':200}"
						></input></td>
					</tr>
					<tr>
						<th><label for="otherCases">其它情况</label></th>
						<td colspan="3"><input type="text" readonly="readonly" id="otherCases" name="otherCases" value="${susOccDiInfo.otherCases}"
							reg="{'maxlength':200}"
						></input></td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>健康教育、咨询、指导</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 18%; min-width: 100px;" />
						<col style="width: 82%; min-width: 200px;" />
					</colgroup>
					<tr>
						<th><label for="guidanceTime">指导时间(分钟)</label></th>
						<td><input type="text" readonly="readonly" style="width: 155px;" id="guidanceTime" name="guidanceTime" value="${susOccDiInfo.guidanceTime}"
							reg="{}"
						></input></td>
					</tr>
					<tr>
						<th><label for="mainContent">主要内容</label></th>
						<td><textarea readonly="readonly" style="min-width: 500px; height: 120px" id="mainContent" name="mainContent" reg="{'maxlength':500}">${susOccDiInfo.mainContent}</textarea></td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>告知情况</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 10%; min-width: 100px;" />
						<col style="width: 18%; min-width: 200px;" />
						<col style="width: 10%; min-width: 100px;" />
						<col style="width: 18%; min-width: 200px;" />
					</colgroup>
					<tr>
						<th></th>
						<td colspan="3">&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;告知就诊者、患者，若怀疑职业病可到有职业健康检查资质或职业病诊断管理的医疗卫生机构</br>（如，疾病预防控制中心）进行规范体检，以确定是否为疑似职业病。 <input
							disabled="disabled" type="radio" ${susOccDiInfo.informeFlag eq '1'? 'checked':'' } name="informeFlag"
						>无 <input disabled="disabled" type="radio" ${susOccDiInfo.informeFlag eq '2'? 'checked':'' } name="infomeFlag" />有
						</td>
					</tr>
					<tr>
						<th><label for="reporterName">报告人姓名</label></th>
						<td><input type="text" readonly="readonly" id="reporterName" name="reporterName" value="${susOccDiInfo.reporterName}"
							reg="{'maxlength':50}"
						></input></td>
						<th><label for="reportDate">报告日期</label></th>
						<td><input type="text" readonly="readonly" value="<fmt:formatDate value='${susOccDiInfo.reportDate}' pattern='yyyy/MM/dd'/>" /></td>
					</tr>
				</table>
			</fieldset>
		</div>
	</div>
</form>
