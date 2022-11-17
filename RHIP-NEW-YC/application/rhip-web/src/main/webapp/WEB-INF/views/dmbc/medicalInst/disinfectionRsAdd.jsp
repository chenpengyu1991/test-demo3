<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/medicalInst/disinfectionRsAdd.js" type="text/javascript"></script>
<div>
	<div class="postcontent">
	  <form:form id="disinfectionRsForm" modelAttribute="disinfectionRs" >
	  	<input type="hidden" name="createBy" value="${createBy}" />
		<input type="hidden" name="createTime" value="${createTime}" />
	  	<form:hidden path="monitorId" />
	  	<form:hidden path="id" />
	  	<form:hidden path="isDelete" value="0" />
	  	<input type="hidden" id="type" value="${type}" />
		<fieldset>
			<legend>消毒质量监测记录:</legend>
			<table class="formtable">
				<tr style="border-bottom:1px solid #A9C3D0">
					<th ><label class="required">科室</label></th>
					<td colspan="2">
						<form:input path="deptName" reg='{"required":"true","maxlength":"20"}' style="width:150px"/>
					</td>
				</tr>
				<tr>
					<th rowspan="6"><label >无菌试验</label></th>
				</tr>
				<tr>
					<td width="80px">针     尖:</td>
					<td colspan="2">
						<label class="required">采样数</label>
						<form:input path="pinpointTotal" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
						<label class="required">合格数</label>
						<form:input path="pinpointAceptNum" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
					</td>
				</tr>
				<tr><td width="80px">注射器:</td>
					<td colspan="2">
						<label class="required">采样数</label>
						<form:input path="syringeTotal" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
						<label class="required">合格数</label>
						<form:input path="syringeAceptNum" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
					</td>
				</tr>
				<tr><td width="80px">纱      布:</td>
					<td colspan="2">
						<label class="required">采样数</label>
						<form:input path="gauzeTotal" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
						<label class="required">合格数</label>
						<form:input path="gauzeAceptNum" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
					</td>
				</tr>
				<tr><td width="80px">刀      片:</td>
					<td colspan="2">
						<label class="required">采样数</label>
						<form:input path="bladeTotal" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
						<label class="required">合格数</label>
						<form:input path="bladeAceptNum" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
					</td>
				</tr>
				<tr style="border-bottom:1px solid #A9C3D0">
					<td width="80px">器械保存液:</td>      
					<td colspan="2">
						<label class="required">采样数</label>
						<form:input path="eqPreSolutionTotal" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
						<label class="required">合格数</label>
						<form:input path="eqPreSolutionAceptNum" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
					</td>
				</tr >
				<tr>
					<th rowspan="6"><label >乙肝表面抗原</label></th>
				</tr>
				<tr>
					<td width="80px">口腔表:</td>
					<td colspan="2">
						<label class="required">采样数</label>
						<form:input path="mouthTotal" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
						<label class="required">合格数</label>
						<form:input path="mouthAceptNum" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
					</td>
				</tr>
				<tr><td width="80px">刮宫器:</td>
					<td colspan="2">
						<label class="required">采样数</label>
						<form:input path="cureInstTotal" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
						<label class="required">合格数</label>
						<form:input path="cureInstAceptNum" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
					</td>
				</tr>
				<tr><td width="80px">牙钳:</td>
					<td colspan="2">
						<label class="required">采样数</label>
						<form:input path="forcepsTotal" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
						<label class="required">合格数</label>
						<form:input path="forcepsAceptNum" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
					</td>
				</tr>
				<tr><td width="80px">牙钻:</td>
					<td colspan="2">
						<label class="required">采样数</label>
						<form:input path="engineBitTotal" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
						<label class="required">合格数</label>
						<form:input path="engineBitAceptNum" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
					</td>
				</tr>
				<tr style="border-bottom:1px solid #A9C3D0">
					<td width="80px">内窥镜:</td>      
					<td colspan="2">
						<label class="required">采样数</label>
						<form:input path="endoscopeTotal" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
						<label class="required">合格数</label>
						<form:input path="endoscopeAceptNum" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
					</td>
				</tr>
				<tr>
					<th rowspan="3"><label >细菌总数</label></th>
				</tr>
				<tr>
					<td width="80px">手:</td>      
					<td colspan="2">
						<label class="required">采样数</label>
						<form:input path="hdGermTotal" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
						<label class="required">合格数</label>
						<form:input path="hdGermAceptNum" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
					</td>
				</tr>
				<tr style="border-bottom:1px solid #A9C3D0">
					<td width="80px">操作台面:</td>      
					<td colspan="2">
						<label class="required">采样数</label>
						<form:input path="tlGermTotal" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
						<label class="required">合格数</label>
						<form:input path="tlGermAceptNum" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
					</td>
				</tr>
				<tr>
					<th rowspan="3"><label >金黄色葡萄球菌</label></th>
				</tr>
				<tr>
					<td width="80px">手:</td>      
					<td colspan="2">
						<label class="required">采样数</label>
						<form:input path="hdMrsaTotal" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
						<label class="required">合格数</label>
						<form:input path="hdMrsaAceptNum" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
					</td>
				</tr>
				<tr style="border-bottom:1px solid #A9C3D0">
					<td width="80px">操作台面:</td>      
					<td colspan="2">
						<label class="required">采样数</label>
						<form:input path="tlMrsaTotal" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
						<label class="required">合格数</label>
						<form:input path="tlMrsaAceptNum" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
					</td>
				</tr>
				<tr>
					<th rowspan="3"><label >大肠杆菌</label></th>
				</tr>
				<tr>
					<td width="80px">手:</td>      
					<td colspan="2">
						<label class="required">采样数</label>
						<form:input path="hdColicinTotal" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
						<label class="required">合格数</label>
						<form:input path="hdColicinAceptNum" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
					</td>
				</tr>
				<tr style="border-bottom:1px solid #A9C3D0">
					<td width="80px">操作台面:</td>      
					<td colspan="2">
						<label class="required">采样数</label>
						<form:input path="tlColicinTotal" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
						<label class="required">合格数</label>
						<form:input path="tlColicinAceptNum" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
					</td>
				</tr>
				<tr>
					<th rowspan="4"><label >空气细菌</label></th>
				</tr>
				<tr>
					<td width="80px">手术室:</td>      
					<td colspan="2">
						<label class="required">采样数</label>
						<form:input path="orBacteriaTotal" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
						<label class="required">合格数</label>
						<form:input path="orBacteriaAceptNum" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
					</td>
				</tr>
				<tr>
					<td width="80px">产房:</td>      
					<td colspan="2">
						<label class="required">采样数</label>
						<form:input path="drBacteriaTotal" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
						<label class="required">合格数</label>
						<form:input path="drBacteriaAceptNum" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
					</td>
				</tr>
				<tr style="border-bottom:1px solid #A9C3D0">
					<td width="80px">监护室:</td>      
					<td colspan="2">
						<label class="required">采样数</label>
						<form:input path="icuBacteriaTotal" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
						<label class="required">合格数</label>
						<form:input path="icuBacteriaAceptNum" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
					</td>
				</tr>
				<tr>
					<th rowspan="4"><label >压力蒸汽灭菌</label></th>
				</tr>
				<tr>
					<td width="80px">指示胶带:</td>      
					<td colspan="2">
						<label class="required">采样数</label>
						<form:input path="itpssTotal" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
						<label class="required">合格数</label>
						<form:input path="itpssAceptNum" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
					</td>
				</tr>
				<tr>
					<td width="80px">化学指示卡:</td>      
					<td colspan="2">
						<label class="required">采样数</label>
						<form:input path="cicpssTotal" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
						<label class="required">合格数</label>
						<form:input path="cicpssAceptNum" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
					</td>
				</tr>
				<tr style="border-bottom:1px solid #A9C3D0">
					<td width="80px">生物指示菌片:</td>      
					<td colspan="2">
						<label class="required">采样数</label>
						<form:input path="bibpssTotal" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
						<label class="required">合格数</label>
						<form:input path="bibpssAceptNum" style="width:60px" reg='{"required":"true","maxlength":"5","digits":"true"}'/>
					</td>
				</tr>
			</table>
		</fieldset>
		</form:form>
		<p style="margin-top: 15px;" align="center">
			<input type="button" id="saveButton" value="保 存" class="btnopr" /> 
			<input type="button" id="cancelButton" value="关 闭" class="btnopr" />
		</p>
	</div>
</div>
