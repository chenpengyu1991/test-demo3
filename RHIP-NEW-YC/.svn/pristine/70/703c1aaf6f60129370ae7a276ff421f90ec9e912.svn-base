<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/cdm/riskModel/assessmentModel.js" type="text/javascript"></script>
<div class="section">
<div class="toolbar" align="right">
			<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">慢病健康管理</a>
		        <a href="javascript:void(0)">危险因素</a>
		        <a>
		          <cite>危险因素评估模型</cite></a>
		      </span>
    		</div>
	        <%-- <a id="riskFactorSubmit" ><b class="tijiao">提交</b></a> --%>
	        <a id="riskFactorSubmit" ><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe605;</i>提交</button></a>
</div>
<form id="riskFactorsInfo" method="post">	
	<div class="postcontent">	
		<i class="popno">健康危险因素与风险评估模型</i>
		<div class="postdiv searchArea contentItem">
			<fieldset class="layui-elem-field">
				 <legend>第一类标准</legend>			
				 <table class="posttable">
				 		<colgroup>
							<col style="width: 12%" />
							<col style="width: 35%" />
							<col style="width: 12%" />
							<col style="width: 25%" />
						</colgroup>
						<tr>
							<th>血压值</th>
							<td colspan="3">
							    <input type="hidden" name="cfgs[14].standardName" value="第一类评估模型">
							    <input type="hidden" name="cfgs[14].standardCode" value="CDM000000A">
							    <input type="hidden" name="cfgs[14].parameterName" value="收缩压">
							    <input type="hidden" name="cfgs[14].parameterCode" value="CDM0000014">
								收缩压<tag:numberInput reg="{'min':0,'max':9999}" name="minimumSystolicBloodPressure"  id="minimumSystolicBloodPressure" value="${riskFactorModelValues.CDM0000014[0]}"  style="width: 30px" cssClass="x-layui-input" />~
									  <tag:numberInput reg="{'min':0,'max':9999}" name="maximumSystolicBloodPressure"  id="maximumSystolicBloodPressure" value="${riskFactorModelValues.CDM0000014[1]}"  style="width: 30px" cssClass="x-layui-input" />mmHg
								&nbsp;&nbsp;
								<input type="hidden" name="cfgs[15].standardName" value="第一类评估模型">
							    <input type="hidden" name="cfgs[15].standardCode" value="CDM000000A">
							    <input type="hidden" name="cfgs[15].parameterName" value="舒张压">
							    <input type="hidden" name="cfgs[15].parameterCode" value="CDM0000015">
								舒张压<tag:numberInput reg="{'min':0,'max':9999}" name="minimumDiastolicBloodPressure" id="minimumDiastolicBloodPressure" value="${riskFactorModelValues.CDM0000015[0]}"  style="width: 30px" cssClass="x-layui-input" />~
									  <tag:numberInput reg="{'min':0,'max':9999}" name="maximumDiastolicBloodPressure" id="maximumDiastolicBloodPressure" value="${riskFactorModelValues.CDM0000015[1]}"  style="width: 30px" cssClass="x-layui-input" />mmHg
							</td>
						</tr>
						<tr>
							<th>空腹血糖值</th>
							<td>
								<input type="hidden" name="cfgs[2].standardName" value="第一类评估模型">
							    <input type="hidden" name="cfgs[2].standardCode" value="CDM000000A">
							    <input type="hidden" name="cfgs[2].parameterName" value="空腹血糖值">
							    <input type="hidden" name="cfgs[2].parameterCode" value="CDM0000002">
								<tag:numberInput reg="{'min':0,'max':999.9}" point="point" name="lowestBloodSugarLevel" id="lowestBloodSugarLevel" value="${riskFactorModelValues.CDM0000002[0]}" style="width: 30px" cssClass="x-layui-input" />&lt;=FBG&lt;=
								<tag:numberInput reg="{'min':0,'max':999.9}" point="point" name="highestBloodSugarLevel" id="highestBloodSugarLevel" value="${riskFactorModelValues.CDM0000002[1]}"  style="width: 30px" cssClass="x-layui-input" />mmol/L
							</td>	
							<th>血清总胆固醇值</th>
							<td>
								<input type="hidden" name="cfgs[3].standardName" value="第一类评估模型">
							    <input type="hidden" name="cfgs[3].standardCode" value="CDM000000A">
							    <input type="hidden" name="cfgs[3].parameterName" value="血清总胆固醇值">
							    <input type="hidden" name="cfgs[3].parameterCode" value="CDM0000003">
								<tag:numberInput reg="{'min':0,'max':999.99}" point="point" name="lowestSerumTotalCholesterol" id="lowestSerumTotalCholesterol" value="${riskFactorModelValues.CDM0000003[0]}"  style="width: 30px" cssClass="x-layui-input" />&lt;=TC&lt;=
								<tag:numberInput reg="{'min':0,'max':999.99}" point="point" name="highestSerumTotalCholesterol" id="highestSerumTotalCholesterol" value="${riskFactorModelValues.CDM0000003[1]}"  style="width: 30px" cssClass="x-layui-input" />mmol/L
							</td>
						</tr>
						<tr>
							<th>男性腰围值</th>
							<td>
								<input type="hidden" name="cfgs[4].standardName" value="第一类评估模型">
							    <input type="hidden" name="cfgs[4].standardCode" value="CDM000000A">
							    <input type="hidden" name="cfgs[4].parameterName" value="男性腰围值">
							    <input type="hidden" name="cfgs[4].parameterCode" value="CDM0000004">
								&gt;=<tag:numberInput reg="{'min':0,'max':9999.9}" point="point" name="cfgs[4].parameterValue" value="${riskFactorModelValues.CDM0000004}"  style="width: 30px" cssClass="x-layui-input" />cm
							</td>
							<th>女性腰围值</th>
							<td>
							    <input type="hidden" name="cfgs[5].standardName" value="第一类评估模型">
							    <input type="hidden" name="cfgs[5].standardCode" value="CDM000000A">
							    <input type="hidden" name="cfgs[5].parameterName" value="女性腰围值">
							    <input type="hidden" name="cfgs[5].parameterCode" value="CDM0000005">
								&gt;=<tag:numberInput reg="{'min':0,'max':9999.9}" point="point" name="cfgs[5].parameterValue"  value="${riskFactorModelValues.CDM0000005}"  style="width: 30px" cssClass="x-layui-input" />cm
							</td>
						</tr>
						<tr>
							<th>是否吸烟</th>
							<td>
								<input type="hidden" name="cfgs[1].standardName" value="第一类评估模型">
							    <input type="hidden" name="cfgs[1].standardCode" value="CDM000000A">
							    <input type="hidden" name="cfgs[1].parameterName" value="是否吸烟">
							    <input type="hidden" name="cfgs[1].parameterCode" value="CDM0000001">
							    <div class="layui-form">
									<div class="layui-form-item">
									<div class="layui-input-block" style="margin-left: 0px;">
									<label><input type="radio" checked="checked" name="cfgs[1].parameterValue" ${riskFactorModelValues.CDM0000001 eq '1' ? 'checked' : ''} value="1">是</label>
									<label><input type="radio"  name="cfgs[1].parameterValue" ${riskFactorModelValues.CDM0000001 eq '2' ? 'checked' : ''} value="2">否</label>
									</div>
									</div>
									</div>
							</td>			
						</tr>
				 </table>		
			</fieldset>
			<fieldset class="layui-elem-field">
				 <legend>第二类标准</legend>			
				 <table class="posttable">
				 		<colgroup>
							<col style="width: 12%" />
							<col style="width: 35%" />
							<col style="width: 12%" />
							<col style="width: 25%" />
						</colgroup>
						<tr>
							<th>评价对象</th>
							<td class="colinput">
								<input type="hidden" name="cfgs[6].standardName" value="第二类评估模型">
							    <input type="hidden" name="cfgs[6].standardCode" value="CDM000000B">
							    <input type="hidden" name="cfgs[6].parameterName" value="年龄段">
							    <input type="hidden" name="cfgs[6].parameterCode" value="CDM0000006">
								年龄段<tag:numberInput reg="{'min':0,'max':999}" value="${riskFactorModelValues.CDM0000006[0]}" name="beginAge" id="beginAge" style="width:30px;" cssClass="x-layui-input" /> ~ 
								      <tag:numberInput reg="{'min':0,'max':999}" value="${riskFactorModelValues.CDM0000006[1]}" name="endAge" id="endAge" style="width:30px;" cssClass="x-layui-input" />岁
							</td>
							<th>体质指数(BMI)</th>
							<td>
								<input type="hidden" name="cfgs[7].standardName" value="第二类评估模型">
							    <input type="hidden" name="cfgs[7].standardCode" value="CDM000000B">
							    <input type="hidden" name="cfgs[7].parameterName" value="体重">
							    <input type="hidden" name="cfgs[7].parameterCode" value="CDM0000007">
								BMI&gt;=<tag:numberInput reg="{'regex':'number','min':0,'max':9999.9}" point="point" name="cfgs[7].parameterValue" style="width: 30px" value="${riskFactorModelValues.CDM0000007}" cssClass="x-layui-input" />kg/㎡	
							</td>
							
						</tr>
						<tr>
							<th>饮酒状况</th>
							<td>
								<input type="hidden" name="cfgs[10].standardName"  value="第二类评估模型">
							    <input type="hidden" name="cfgs[10].standardCode"  value="CDM000000B">
							    <input type="hidden" name="cfgs[10].parameterName" value="饮酒状况">
							    <input type="hidden" name="cfgs[10].parameterCode" value="CDM0000010">
							    <div class="layui-form">
								<div class="layui-form-item">
									<div class="layui-input-block" style="margin-left: 0px;">
									<label><input type="radio" name="cfgs[10].parameterValue" ${riskFactorModelValues.CDM0000010 eq '1' ? 'checked' : ''} value="1">每天</label>
									<label><input type="radio" name="cfgs[10].parameterValue" ${riskFactorModelValues.CDM0000010 eq '2' ? 'checked' : ''} value="2">经常</label>
									</div>
									</div>
								</div>
							</td>
							<th>运动时间</th>
							<td>
								<input type="hidden" name="cfgs[8].standardName" value="第二类评估模型">
							    <input type="hidden" name="cfgs[8].standardCode" value="CDM000000B">
							    <input type="hidden" name="cfgs[8].parameterName" value="运动时间">
							    <input type="hidden" name="cfgs[8].parameterCode" value="CDM0000008">
								&lt;=<tag:numberInput reg="{'min':0,'max':9999}" name="cfgs[8].parameterValue" value="${riskFactorModelValues.CDM0000008}" style="width: 30px" cssClass="x-layui-input" />分钟/次
							</td>	
						   
						</tr>
						<tr>
							<th>吸烟状况</th>
							<td colspan="3">
								<input type="hidden" name="cfgs[9].standardName" value="第二类评估模型">
							    <input type="hidden" name="cfgs[9].standardCode" value="CDM000000B">
							    <input type="hidden" name="cfgs[9].parameterName" value="吸烟状况">
							    <input type="hidden" name="cfgs[9].parameterCode" value="CDM0000009">
							  <div class="layui-form">
								<div class="layui-form-item">
								<div class="layui-input-block" style="margin-left: 0px;">
								<label><input type="radio" name="cfgs[9].parameterValue" ${riskFactorModelValues.CDM0000009 eq '1' ? 'checked' : ''} value="1">现在每天吸&nbsp;</label>
								<label><input type="radio" name="cfgs[9].parameterValue" ${riskFactorModelValues.CDM0000009 eq '2' ? 'checked' : ''} value="2">现在吸,但不是每天吸&nbsp;</label>
								<label><input type="radio" name="cfgs[9].parameterValue" ${riskFactorModelValues.CDM0000009 eq '3' ? 'checked' : ''} value="3">过去吸,现在不吸&nbsp;</label>
								<label><input type="radio" name="cfgs[9].parameterValue" ${riskFactorModelValues.CDM0000009 eq '4' ? 'checked' : ''} value="4">从不吸 </label>
								</div>
								</div>
							 </div>
							</td>
						</tr>
						<tr>
							<th>饮食偏油脂</th>
							<td colspan="3">
								<input type="hidden" name="cfgs[11].standardName" value="第二类评估模型">
							    <input type="hidden" name="cfgs[11].standardCode" value="CDM000000B">
							    <input type="hidden" name="cfgs[11].parameterName" value="总胆固醇">
							    <input type="hidden" name="cfgs[11].parameterCode" value="CDM0000011">
								总胆固醇 <tag:numberInput reg="{'min':0,'max':999.99}" point="point" name="lowestTotaCholesterol" id="lowestTotaCholesterol" value="${riskFactorModelValues.CDM0000011[0]}" style="width: 30px" cssClass="x-layui-input" />~
									    <tag:numberInput reg="{'min':0,'max':999.99}" point="point" name="highestTotaCholesterol" id="highestTotaCholesterol"  value="${riskFactorModelValues.CDM0000011[1]}" style="width: 30px" cssClass="x-layui-input" />mmol/L&nbsp;&nbsp;
								<input type="hidden" name="cfgs[12].standardName" value="第二类评估模型">
							    <input type="hidden" name="cfgs[12].standardCode" value="CDM000000B">
							    <input type="hidden" name="cfgs[12].parameterName" value="甘油三酯">
							    <input type="hidden" name="cfgs[12].parameterCode" value="CDM0000012">
								甘油三酯 <tag:numberInput reg="{'min':0,'max':99.9}" point="point" name="lowestTriglycerides" id="lowestTriglycerides" value="${riskFactorModelValues.CDM0000012[0]}" style="width: 30px" cssClass="x-layui-input" />~
									    <tag:numberInput reg="{'min':0,'max':99.9}" point="point" name="highestTriglycerides" id="highestTriglycerides" value="${riskFactorModelValues.CDM0000012[1]}" style="width: 30px" cssClass="x-layui-input" />mmol/L
							</td>
						</tr>
						<tr>
							<th>家族史</th>
							<td>
								<input type="hidden" name="cfgs[13].standardName" value="第二类评估模型">
							    <input type="hidden" name="cfgs[13].standardCode" value="CDM000000B">
							    <input type="hidden" name="cfgs[13].parameterName" value="家族史">
							    <input type="hidden" name="cfgs[13].parameterCode" value="CDM0000013">
								<label><input type="checkbox" name="cfgs[13].parameterValue" ${riskFactorModelValues.CDM0000013[0] eq '1' ? 'checked' : ''} value="1" class="x-layui-input" >&nbsp;高血压&nbsp;</label>
								<label><input type="checkbox" name="cfgs[13].parameterValue" ${riskFactorModelValues.CDM0000013[1] eq '2' ? 'checked' : ''} value="2" class="x-layui-input" >&nbsp;糖尿病</label>
							</td>	
						</tr>
				 </table>		
			</fieldset>
		</div>
	</div>
</form>
</div>
