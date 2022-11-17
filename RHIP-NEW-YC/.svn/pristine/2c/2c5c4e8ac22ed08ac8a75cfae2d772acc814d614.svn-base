<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/views/cdm/highRisk/loadManagePlan.js" type="text/javascript"></script>

<fieldset  style="margin-top:2px;float:right;width:48%;height:324px;overflow: auto" class="layui-elem-field">>
	<input type="hidden" id="riskLevel" value="${riskLevel}">
	<input type="hidden" id="buildPlan" value="${buildPlan}">
	<table class="posttable">
		<colgroup>
			<col style="width:40px;"/>
			<col style="width:100px;"/>
		</colgroup>
		<tr style="display:none">
			<th>计划id</th>
			<td><input type="text" id="followUpId" name="id"  value="${followUpPlanInfo.id}"></td>
			<td><input type="text" id="dmFollowId" name="dmFollowupPlan.id"  value="${followUpPlanInfo.dmFollowupPlan.id}"></td>
		</tr>
		<tr>
			<th>体重指数(BMI)</th>
			<td><tag:numberInput reg="{'min':'0','max':'99.99'}" point="point" id="bodyMassIndex" name="bodyMassIndex"  value="${followUpPlanInfo.bodyMassIndex}"/></td>
		</tr>
		<tr>
			<th>腰围</th>
		<td><tag:numberInput reg="{'min':'0','max':'9999.9'}" point="point" id="waostline" name="waostline" value="${followUpPlanInfo.waostline}"/>cm</td>
		</tr>
		<tr>
			<th>运动</th>
			<td><tag:numberInput reg="{'min':'0','max':'999'}" id="weeklyTrain" name="weeklyTrain" value="${followUpPlanInfo.weeklyTrain}"/>次/每周</td>
		</tr>
		<tr>
			<th>吸烟</th>
			<td><tag:numberInput reg="{'min':'0','max':'9999'}" id="dailySmoke" name="dailySmoke" value="${followUpPlanInfo.dailySmoke}"/>支/每日</td>
		</tr>
		<tr>
			<th>饮酒</th>
			<td><tag:numberInput reg="{'min':'0','max':'9999'}" id="weeklyDrinnk" name="weeklyDrinnk" value="${followUpPlanInfo.weeklyDrinnk}"/>两/每周</td>
		</tr>
		<tr>
			<th>每天吃鱼肉</th>
			<td><tag:numberInput reg="{'min':'0','max':'9999'}" id="dailyFish" name="dailyFish" value="${followUpPlanInfo.dailyFish}"/>两</td>
		</tr>
		<tr>
			<th>总胆固醇</th>
			<td><tag:numberInput reg='{"min":0,"max":999.99}' point="point" id="tc" name="tc" value="${followUpPlanInfo.tc}"/>mmol/L</td>
		</tr>
		<tr>
			<th>甘油三酯</th>
			<td><tag:numberInput reg='{"min":0,"max":99.9}' point="point" id="triglycerideValue" name="triglycerideValue" value="${followUpPlanInfo.triglycerideValue}"/>mmol/L</td>
		</tr>
		<tr>
			<th>心理咨询</th>
			<td>
				<input type="radio" name="psyCounsellingType" value="1"  ${followUpPlanInfo.psyCounsellingType eq '1' ? 'checked' : ''}/>有
				<input type="radio" name="psyCounsellingType" value="2"  ${followUpPlanInfo.psyCounsellingType eq '2' ? 'checked' : ''}/>无					
			</td>
		</tr>
		<tr>
			<th>随访方式</th>
			<td>			
				<ehr:dic-radio dicmeta="DMD00003" name="visitWayCode" value="${followUpPlanInfo.visitWayCode}"/>			
			</td>
		</tr>
		<tr>
			<th><label class="required" for="visitDate">随访日期</label></th>
			<td><tag:dateInput reg='{"required":"true"}' name="visitDate"  id="visitDate" onlypast="true" date="${followUpPlanInfo.visitDate}"/></td>
		</tr>					 
		<tr>
			<th><label class="required" for="visitName">随访医生</label></th>
			<td>
				<input type="text"  readonly="readonly" value="<ehr:user userCode='${followUpPlanInfo.visitCode}'/>" />
                <input reg='{"required":"true"}' type="hidden" id="visitCode" name="visitCode" value="${followUpPlanInfo.visitCode}">	
			</td>
		</tr>
		<tr>
			<th>其他</th>
			<td><input reg='{"maxlength":"100"}' type="text" id="other" name="other" value="${followUpPlanInfo.other}"></td>
		</tr>			
	</table>
</fieldset>			