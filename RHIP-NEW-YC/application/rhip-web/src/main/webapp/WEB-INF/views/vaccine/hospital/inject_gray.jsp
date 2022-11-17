<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<script src="${pageContext.request.contextPath}/js/views/vaccine/hospital/inject_gray.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/vaccine/hospital/weightdose.js" type="text/javascript"></script>
<form id="vaccine_rabies_contine_save">
	<div class="postdiv">
		<input type="hidden" name="ehrId" value="${ehrId}"/>
		<fieldset class="layui-elem-field">
			<legend>狂犬病人免疫球蛋白注射情况</legend>
			<table style="width:99%" class="posttable">
				<colgroup>
					<col style="width: 15%;">
					<col style="width: 25%">
					<col style="width: 10%">
					<col style="width: 20%">
					<col style="width: 10%">
					<col style="width: 20%">
				</colgroup>
				<tbody>
					<tr>
						<th><label class="required">患者体重：</label></th>
						<td>
							<input type="text" id="pW" name="vaccinationWeight" 
								value="${vaccineRecord.vaccinationWeight}" reg='{"required":"true","maxlength":"4","regex":"^\\d+$"}'
								 onkeyup="OnKey()" maxlength="4"/>&nbsp;公斤
						</td>
						<th>剂量：</th>
						<td>
							<input type="text" readonly="readonly" id="vacDose" name="vaccineMeasurement" style="width:50px"
								reg='{"required":"true","maxlength":"8","regex":"^\\d+$"}'
								value="${vaccineRecord.vaccineMeasurement}"/>&nbsp;iu(<span id="btlCnt"></span>瓶)
						</td>
						<th><label class="required">注射日期：</label></th>
						<td>
							<tag:dateInput name="vaccinationDate"  reg='{"required":"true"}' 
								date="${currentDate}" onlypast="true" />
						</td>
					</tr>
					<tr>
						<th><label class="required">生产厂家：</label></th>
						<td>
							<tag:autoSelect name="vaccineCompanyCode" id="vaccineCompanyCode" codeValue="${vaccineCompanyCode}" style="width:150px"  reg='{"required":"true","maxlength":"33"}'></tag:autoSelect>
							<input type="hidden" name="vaccineFactory" id="vaccineFactory"/>						
							<!--<input type="text" class="factoryClass" name="vaccineFactory" reg='{"required":"true","maxlength":"33"}' 
								value="${vaccineRecord.vaccineFactory}"/>-->
						</td>
						<th><label class="required">批号：</label></th>
						<td>
							<input type="text" name="vaccineLotNumber" reg='{"required":"true","maxlength":"20","regex":"^[A-Za-z0-9]+$"}'
							 value="${vaccineRecord.vaccineLotNumber}"/></td>
					</tr>		
				</tbody>
			</table>
		</fieldset>
		
		<!-- 备注 -->
		<div class="postdiv">
			<fieldset class="layui-elem-field">
			<legend>备注</legend>
			<table>
			<tr>
			<td>
			<textarea class="vacnte" name="comment" style="width: 100%;" rows="5" cols="40">${vaccinationEvent.comments}</textarea>
			</td>
			</tr>
			</table>
			</fieldset>
		</div>
		
		<div class="vacbtn">
			<!-- <input id="rabiesContineSave" class="btn" type="button" value="保存"/> -->
			<button class="layui-btn layui-btn-sm"  id="rabiesContineSave">保存</button>
		</div>
	</div>
</form>