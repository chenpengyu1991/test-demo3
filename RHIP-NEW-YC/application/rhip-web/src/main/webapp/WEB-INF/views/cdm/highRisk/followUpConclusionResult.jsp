<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/views/cdm/highRisk/checkStatus.js" type="text/javascript"></script>
<fieldset  style="margin-top:-8px;float:right;width:60%;height:324px;overflow: auto" class="layui-elem-field">
	<table class="posttable">
		<colgroup>
			<col style="width:100px;"/>
			<col style="width:370px;"/>
		</colgroup>
		<tr><td colspan="2"><h3 align="center">危险因素变化</h3></td></tr>
		<tr style="display:none">
			<th>管理评价id、危险因素id</th>
			<td><input type="text" id="factorId" name="factorId" class="x-layui-input" value="${conclusionInfo.factorId}"></td>
			<td><input type="text" id="conclusionId" name="id"  class="x-layui-input" value="${conclusionInfo.id}"></td>
		</tr>
		<tr>
			<th align="center">
				<label><input type="checkbox" class="overweight calculateLevel" name="overweight" ${factorsInfo.overweight eq '1' ? 'checked' : ''}  value="1" onclick="checkStatusUtil.clickShowText(this,'overweightShow');">&nbsp;超重</label>
			</th>
			<td>
				<span id="overweightShow">
					B M I 值 :<tag:numberInput reg="{'min':'0','max':'99.99'}" point="point" style="width: 38px" id="bodyMassIndex" name="bodyMassIndex" value="${factorsInfo.bodyMassIndex}" cssClass="x-layui-input"/>&nbsp;	&nbsp;			
					腰   围:<tag:numberInput reg="{'min':'0','max':'9999.9'}" point="point" style="width: 38px" id="waostline" name="waostline" value="${factorsInfo.waostline}" cssClass="x-layui-input"/>cm
				</span>
			</td>
		</tr>
		<tr>
			<th>
				<label><input type="checkbox" class="noTrain calculateLevel" name="noTrain" ${factorsInfo.noTrain eq '1' ? 'checked' : ''} value="1" onclick="checkStatusUtil.clickShowText(this,'trainShow');">&nbsp;运动量	</label>
			</th>
			<td>
				<span id="trainShow">	
					每周运动:<tag:numberInput reg="{'min':'0','max':'999'}" style="width: 38px" id="weeklyTrain" name="weeklyTrain" value="${factorsInfo.weeklyTrain}" cssClass="x-layui-input"/>次
				</span>
			</td>
		</tr>
		<tr>
			<th align="center">
				<label><input type="checkbox" class="currSmokingFlag calculateLevel" name="currSmokingFlag" ${factorsInfo.currSmokingFlag eq '1' ? 'checked' : ''} value="1" onclick="checkStatusUtil.clickShowText(this,'smokeShow');">&nbsp;当前吸烟</label>
			</th>
			<td>
				<span id="smokeShow">		
					每日吸烟:<tag:numberInput reg="{'min':'0','max':'9999'}" style="width: 38px" id="dailySmoke" name="dailySmoke" value="${factorsInfo.dailySmoke}" cssClass="x-layui-input"/>支
				</span>
			</td>
		</tr>
		<tr>
			<th align="center">
				<label><input type="checkbox" class="longtermDrinkingFlag calculateLevel" name="longtermDrinkingFlag" ${factorsInfo.longtermDrinkingFlag eq '1' ? 'checked' : ''} value="1" onclick="checkStatusUtil.clickShowText(this,'drinnkShow');">&nbsp;长期饮酒</label>
			</th>
			<td>	
				<span id="drinnkShow">
					每周平均:<tag:numberInput reg="{'min':'0','max':'9999'}" style="width: 38px" id="weeklyDrinnk" name="weeklyDrinnk" value="${factorsInfo.weeklyDrinnk}" cssClass="x-layui-input"/>两
				</span>
			</td>
		</tr>
		<tr>
			<th align="center">
				<label><input type="checkbox" class="foodGreasyFlag calculateLevel" name="foodGreasyFlag" ${factorsInfo.foodGreasyFlag eq '1' ? 'checked' : ''}  value="1" onclick="checkStatusUtil.clickShowText(this,'foodShow');">&nbsp;饮食偏油脂</label>
			</th>
			<td>
				<span id="foodShow">	
					<label><input type="checkbox" id="dailyEatFishFlag" name="dailyEatFishFlag" ${factorsInfo.dailyEatFishFlag eq '1' ? 'checked' : ''} value="1">&nbsp;每天吃8两以上鱼肉&nbsp;</label>
					<label><input type="checkbox" id="monthlyEatOilFlag" name="monthlyEatOilFlag" ${factorsInfo.monthlyEatOilFlag eq '1' ? 'checked' : ''} value="1">&nbsp;每月吃油四斤以上</label><br>
					总胆固醇:<tag:numberInput reg='{"min":0,"max":999.99}' point="point" style="width: 38px" name="tc" value="${factorsInfo.tc}" cssClass="x-layui-input"/>&nbsp;&nbsp;mmol/L									
				           甘油三酯:<tag:numberInput reg='{"min":0,"max":99.9}' point="point" style="width: 38px" name="triglycerideValue" value="${factorsInfo.triglycerideValue}" cssClass="x-layui-input"/>mmol/L
				</span>
			</td>
		</tr>
		<tr>
			<th align="center">
				<label><input type="checkbox" class="famHistoryFlag calculateLevel" name="famHistoryFlag"  ${factorsInfo.famHistoryFlag eq '1' ? 'checked' : ''} value="1" onclick="checkStatusUtil.clickShowText(this,'famHistoryShow');">&nbsp;家族史</label>
			</th>
			<td>
				<span id="famHistoryShow">	
					直系亲属高血压、糖尿病史：
					<ehr:dic-checkbox dicmeta="DMD00001" name="immFamHpDiHisFlag" value="${factorsInfo.immFamHpDiHisFlag}"/>										
				</span>
			</td>
		</tr>
		<tr>
			<th>危险因素分级</th>
			<td colspan="3">
				<ehr:dic-radio reg='{"required":"true"}' dicmeta="DMD00011" name="riskLevel" id="riskLevel" value="${factorsInfo.riskLevel}"/>
			</td>
		</tr>
		<tr><td colspan="2"><h3 align="center">管理评价</h3></td></tr>
		<tr>
			<th><label class="required" for="year">年度</label></th>
			<td class="colinput">
				<%-- <input reg='{"required":"true"}' id="year" name="year" type="text" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy',opposite:true,disabledDates:[${yearList}]})"
					   maxlength="10" readonly="true" style="width:178px" value="${conclusionInfo.year}"/> --%>
					   <input type="text" reg='{"required":"true"}' readonly  class="layui-input x-admin-content-sm-date" placeholder="选择年份" name="year" id="conclusionInfoYear" value="${conclusionInfo.year}"  style="padding-left: 0px;"/>
					   年
			</td>
		</tr>
		<tr>
			<th><label class="required" for="manageResult">管理结束</label></th>
			<td>
				<ehr:dic-radio reg='{"required":"true"}' dicmeta="DMD00002" name="manageResult" id="manageResult" value="${conclusionInfo.manageResult}"/>
			</td>
		</tr>
		<tr>
			<th align="center"><label class="required" for="continueManageFlag">是否继续管理</label></th>
			<td>
				<ehr:dic-radio reg='{"required":"true"}' dicmeta="FS10246" name="continueManageFlag" id="continueManageFlag" value="${conclusionInfo.continueManageFlag}"/>
				<input reg='{"maxlength":"100","required":true,"dependValue":"2","dependOn":"continueManageFlag"}' type="text"  id="other" name="other" value="${conclusionInfo.other}" style="width: 112px; display: none">
			</td>
		</tr>
		<tr>
			<th align="center"><label class="required" for="manageEndData">管理评价日期</label></th>
			<td>
				<%-- <tag:dateInput reg='{"required":"true"}' style="width:178px" name="manageEndData" id="manageEndData" onlypast="true" date="${conclusionInfo.manageEndData}"/> --%>
				<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date" placeholder="选择日期" name="manageEndData" id="manageEndData" value="<fmt:formatDate value='${conclusionInfo.manageEndData}' pattern='yyyy/MM/dd'/>"  style="padding-left: 0px;"/>
			</td>
		</tr>
		<tr>
			<th align="center"><label class="required">医生签名</label></th>
			<td>
				<input type="text" style="width:178px" readonly="readonly" value="<ehr:user userCode='${conclusionInfo.doctorCode}' />" />
				<input reg='{"required":"true"}' style="width:178px" readonly="readonly" type="hidden" id="doctorCode" name="doctorCode" value="${conclusionInfo.doctorCode}">
			</td>
		</tr>
	</table>
</fieldset>
<script type="text/javascript">
layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    //执行一个laydate实例
    laydate.render({
      elem: '#conclusionInfoYear' 
      ,type:'year'
    	  , trigger: 'click' 
    });
	
    //执行一个laydate实例
    laydate.render({
      elem: '#manageEndData' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	 , trigger: 'click' 
    });
    
  });
</script>