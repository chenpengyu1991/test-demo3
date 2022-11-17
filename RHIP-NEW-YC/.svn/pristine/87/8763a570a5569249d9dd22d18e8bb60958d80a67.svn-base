<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/views/cdm/highRisk/highRiskPersonInfo.js" type="text/javascript"></script>

<div class="section">
<div class="toolbar" align="right">
	<a id="returnButton" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<a id="saveRiskFactors" ><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe605;</i>保存</button></a>
			<%-- <a id="returnButton"><b class="fanhui">返回</b></a> --%>
	        <%-- <a id="saveRiskFactors" ><b class="baocun">保存</b></a> --%>
</div>
<form id="riskFactorsInfo" method="post">	
	<div class="postcontent">	
		<i class="popno">危险因素管理卡首页</i>
		<div class="postdiv contentItem">
			<fieldset class="layui-elem-field">
				 <legend>患者基本信息</legend>			
				 <table class="posttable">
				 		<colgroup>
							<col style="width: 12%" />
							<col style="width: 35%" />
							<col style="width: 10%" />
							<col style="width: 35%" />
						</colgroup>
						<tr style="display: none">
							<th>
								<input type="hidden" id="personId" name="personId" value="${personInfo.personId}">
								<input type="hidden" id="id" name="id" value="${personInfo.id}">
								<input type="hidden" id="idcard" name="idcard" value="${personInfo.idcard}">
								<input type="hidden" id="dmhighriskRiskFactorsId" name="dmhighriskRiskFactors.id" value="${personInfo.dmhighriskRiskFactors.id}">
								<input type="hidden" id="dmhighriskRiskFactors.personId" name="dmhighriskRiskFactors.personId" value="${personInfo.personId}">
								<input type="hidden" id="dmhighriskRiskFactors.idcard" name="dmhighriskRiskFactors.idcard" value="${personInfo.idcard }">
								<input type="hidden" id="pageMark"  value="${personInfo.pageMark}">
								<input type="hidden" id="riskManageStatus" value="${personInfo.riskManageStatus}">
								<input type="hidden" name="dmhighriskRiskFactors.consents" id="consents" value="${personInfo.dmhighriskRiskFactors.consents}">
								<input type="hidden" name="dmhighriskRiskFactors.signatureDate" id="signatureDate" value='<fmt:formatDate value="${personInfo.dmhighriskRiskFactors.signatureDate}" pattern="yyyy/MM/dd"/>'>
								<input type="hidden" name="dmhighriskRiskFactors.lcu" id="lcu" value="${personInfo.dmhighriskRiskFactors.lcu}">
							</th>
						</tr>	
						<tr>
							<th>姓名</th>
							<td><input reg='{"maxlength":"50"}' type="text" id="name" name="name" value="${personInfo.name}" class="x-layui-input"></td>
							<th>性别</th>
							<td>
							<div class="layui-form">
								<div class="layui-form-item">
								<div class="layui-input-block" style="margin-left: 0px;">
								<ehr:dic-radio dicmeta="GBT226112003" name="gender" value="${personInfo.gender}"/>
							    </div>
								</div>
							</div>
							</td>				
						</tr>
						<tr>
							<th>出生年月</th>
							<td>
							<%-- <tag:dateInput name="birthday"  id="birthday" onlypast="true"  date="${personInfo.birthday}"/> --%>
							<input type="text" class="layui-input x-admin-content-sm-date" placeholder="选择日期" name="birthday" id="birthday" value="<fmt:formatDate value='${personInfo.birthday}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
							</td>
							<th>联系电话</th>
							<td><input reg='{"regex":"phone","maxlength":20}' type="text" id="phoneNumber" name="phoneNumber" value="${personInfo.phoneNumber}" class="x-layui-input"></td>
						</tr>
						<tr>
							<th>工作单位</th>
							<td colspan="1"><input reg='{"maxlength":"70"}' type="text" id="unitName" name="unitName" value="${personInfo.unitName}" class="x-layui-input"></td>
						</tr>
						<tr>
							<th>住址</th>
							<td colspan="3">
								<ehr:dic-town-street-village villageId="village_address" streetId="street_address"
															 townId="town_address" villageName="paGroup" streetName="pastreet"
															 townName="patownShip" villageValue="${personInfo.paGroup}" streetValue="${personInfo.pastreet}"
															 townValue="${personInfo.patownShip}" width="148px;"
															 callback="hirhRiskPersonInfo.displayPaAddress" cssClass="x-layui-input"/>
							<br/>
								<span id="text_pahouseNumber_prefix">
									<ehr:dic dicmeta="FS990001" code="${personInfo.patownShip}"/>
									<ehr:dic dicmeta="FS990001" code="${personInfo.pastreet}"/>
									<ehr:dic dicmeta="FS990001" code="${personInfo.paGroup}"/>
								</span>
							<input style="width: 370px" type="text" id="text_pahouseNumber"
							reg='{"maxlength":70}' name="pahouseNumber"
							value="${personInfo.pahouseNumber}" class="x-layui-input"/>(详细地址)</td>
						</tr>
				 </table>		
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>危险因素变化</legend>
					<table class="posttable" id="disabledInput">
						<colgroup>
							<col style="width: 12%" />
							<col style="width: 35%" />
							<col style="width: 10%" />
							<col style="width: 35%" />
						</colgroup>		
						<tr>
							<th>
								<label><input type="checkbox" lay-skin="primary" class="overweight calculateLevel " name="dmhighriskRiskFactors.overweight" id="overweightId"  data-id = "{'this','overweightShow'}"
								${personInfo.dmhighriskRiskFactors.overweight eq '1' ? 'checked' : ''} value="1">&nbsp;超重</label>
							</th>
							<td colspan="3">
								<span id="overweightShow">
									B M I 值 :<tag:numberInput reg="{'min':'0','max':'99.99'}" point="point" style="width: 38px" id="dmhighriskRiskFactors.bodyMassIndex" name="dmhighriskRiskFactors.bodyMassIndex" 
											 value="${personInfo.dmhighriskRiskFactors.bodyMassIndex}" cssClass="x-layui-input"/>&nbsp;&nbsp;										
									腰   围:<tag:numberInput reg="{'min':'0','max':'9999.9'}" point="point" style="width: 38px" id="dmhighriskRiskFactors.waostline" name="dmhighriskRiskFactors.waostline"
										  value="${personInfo.dmhighriskRiskFactors.waostline}" cssClass="x-layui-input" />cm
								</span>
							</td>
						</tr>
						<tr>
							<th>
								<label><input type="checkbox" class="noTrain calculateLevel" name="dmhighriskRiskFactors.noTrain" id="noTrainId"
								${personInfo.dmhighriskRiskFactors.noTrain eq '1' ? 'checked' : ''} value="1">&nbsp;运动量</label>
							</th>
							<td colspan="3">
								<span id="trainShow" >	
									每周运动:<tag:numberInput reg="{'min':'0','max':'999'}" style="width: 38px" id="dmhighriskRiskFactors.weeklyTrain" name="dmhighriskRiskFactors.weeklyTrain"
											 value="${personInfo.dmhighriskRiskFactors.weeklyTrain}" cssClass="x-layui-input" />次
								</span>
							</td>
						</tr>
						<tr>
							<th>
								<label><input type="checkbox" class="currSmokingFlag calculateLevel" name="dmhighriskRiskFactors.currSmokingFlag" id="currSmokingFlagId"
								${personInfo.dmhighriskRiskFactors.currSmokingFlag eq '1' ? 'checked' : ''} value="1" >&nbsp;当前吸烟</label>
							</th>
							<td colspan="3">	
								<span id="smokeShow" >
									每日吸烟:<tag:numberInput reg="{'min':'0','max':'9999'}" style="width: 38px" id="dmhighriskRiskFactors.dailySmoke" name="dmhighriskRiskFactors.dailySmoke"
											 value="${personInfo.dmhighriskRiskFactors.dailySmoke}" cssClass="x-layui-input"/>支
								</span>
							</td>
						</tr>
						<tr>
							<th>
								<label><input type="checkbox" class="longtermDrinkingFlag calculateLevel" name="dmhighriskRiskFactors.longtermDrinkingFlag" id="longtermDrinkingFlagId"
								${personInfo.dmhighriskRiskFactors.longtermDrinkingFlag eq '1' ? 'checked' : ''} value="1">&nbsp;长期饮酒</label>	
							</th>
							<td colspan="3">
								<span id="drinnkShow" >		
									每周平均:<tag:numberInput reg="{'min':'0','max':'9999'}" style="width: 38px" id="dmhighriskRiskFactors.weeklyDrinnk" name="dmhighriskRiskFactors.weeklyDrinnk"
									 	     value="${personInfo.dmhighriskRiskFactors.weeklyDrinnk}" />两
								</span>
							</td>
						</tr>
						<tr>
							<th>
								<label><input type="checkbox"  class="foodGreasyFlag calculateLevel" name="dmhighriskRiskFactors.foodGreasyFlag" id="foodGreasyFlagId"
								${personInfo.dmhighriskRiskFactors.foodGreasyFlag eq '1' ? 'checked' : ''} value="1">&nbsp;饮食偏油脂</label>
							</th>
							<td colspan="3">
								<span id="foodShow" >		
									<label><input type="checkbox" id="dmhighriskRiskFactors.dailyEatFishFlag" name="dmhighriskRiskFactors.dailyEatFishFlag" 
									${personInfo.dmhighriskRiskFactors.dailyEatFishFlag eq '1' ? 'checked' : ''} value="1">&nbsp;每天吃8两以上鱼肉&nbsp;</label>
									<label><input type="checkbox" id="dmhighriskRiskFactors.monthlyEatOilFlag" name="dmhighriskRiskFactors.monthlyEatOilFlag" 
									${personInfo.dmhighriskRiskFactors.monthlyEatOilFlag eq '1' ? 'checked' : ''} value="1">&nbsp;每月吃油四斤以上&nbsp;&nbsp;</label>
									总胆固醇:<tag:numberInput reg='{"min":0,"max":999.99}' point="point" style="width: 38px" name="dmhighriskRiskFactors.tc" value="${personInfo.dmhighriskRiskFactors.tc}" cssClass="x-layui-input"/>&nbsp;&nbsp;mmol/L								
									甘油三酯:<tag:numberInput reg='{"min":0,"max":99.9}' point="point" style="width: 38px" name="dmhighriskRiskFactors.triglycerideValue" value="${personInfo.dmhighriskRiskFactors.triglycerideValue}" cssClass="x-layui-input"/>mmol/L
								</span>
							</td>						
						</tr>
						<tr>
							<th>
								<input type="checkbox" class="famHistoryFlag calculateLevel"  name="dmhighriskRiskFactors.famHistoryFlag" id="famHistoryFlagId"
								${personInfo.dmhighriskRiskFactors.famHistoryFlag eq '1' ? 'checked' : ''} value="1">&nbsp;家族史
							</th>
							<td colspan="3">
								<span id="famHistoryShow" >		
									直系亲属高血压、糖尿病史：
									<ehr:dic-checkbox dicmeta="DMD00001" name="dmhighriskRiskFactors.immFamHpDiHisFlag" value="${personInfo.dmhighriskRiskFactors.immFamHpDiHisFlag}"/>										
								</span>
							</td>
						</tr>
					</table>
			</fieldset>
			<fieldset class="layui-elem-field">
				 <legend>综合评估</legend>			
				 <table class="posttable">
				 		<colgroup>
							<col style="width: 12%" />
							<col style="width: 35%" />
							<col style="width: 10%" />
							<col style="width: 35%" />
						</colgroup>		
						<tr>
							<th><label class="required" for="riskLevel">危险因素分级</label></th>
							<td colspan="3">										
								<ehr:dic-radio reg='{"required":"true"}' dicmeta="DMD00011" name="riskLevel" id="riskLevel" value="${personInfo.riskLevel}"/>
							</td>
						</tr>
						<tr id="psychologicalAssessment" style="display: none;">
							<th>心理应激评定</th>
							<td colspan="3">
								<ehr:dic-radio  dicmeta="DMD00012" name="lcuLevel" id="lcuLevel" value="${personInfo.lcuLevel}"/>																			
								<a href="#" id="assessment" >开始评定</a>
							</td>					
						</tr>
						<tr>
							<th>管理意见</th>
							<td colspan="3">
								<ehr:dic-checkbox dicmeta="DMD00013" name="manageAdvice" id="manageAdvice" value="${personInfo.manageAdvice}"/>				
							</td>						
						</tr>
						<tr>
							<th>随访周期</th>
							<td colspan="3">
								<input type="radio"  name="cycle" id="onceAYear" value="1"> 一次/年
								<input type="radio"  name="cycle" id="twiceAYear" value="2"> 二次/年
								<input type="radio"  name="cycle" id="fourTimesAYear" value="4"> 四次/年
							</td>							
						</tr>
						
						<tr>
							<td style="display: none;">
								<input type="text" id="createOrganCode" name="createOrganCode" value="${personInfo.createOrganCode}" class="x-layui-input" />
								<input type="text" id="createDoctorName" name="createDoctorName" value="${personInfo.createDoctorName}" class="x-layui-input" />
								<input type="text" id="createDoctorCode" name="createDoctorCode" value="${personInfo.createDoctorCode}" class="x-layui-input" />
							</td>	
							<th><label class="required" for="createOrganName">管理机构</label></th>
							<td>
								<ehr:org code="${personInfo.createOrganCode}"/>
							</td>
							<th><label class="required" for="createOrganName">管理医生</label></th>
							<td>
								<ehr:staff-name userCode="${personInfo.createDoctorCode}"/>
							</td>
						</tr>
						<tr>	
							<th><label class="required" for="createOrganName">建卡日期</label></th>
							<td>
							<%-- <tag:dateInput reg='{"required":"true"}' name="createDate"  id="createDate" onlypast="true" date="${personInfo.createDate}"/> --%>
							<input type="text" class="layui-input x-admin-content-sm-date" placeholder="选择时间" name="createDate" id="createDate" value="<fmt:formatDate value='${personInfo.createDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
							</td>
						</tr>				
				  </table>
			</fieldset>
		</div>
	</div>
</form>
</div>
<script type="text/javascript">
layui.use('form', function() {
  var form = layui.form;
  form.render(); // 解决radio不显示问题
});

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    //执行一个laydate实例
    laydate.render({
      elem: '#birthday' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });

    //执行一个laydate实例
    laydate.render({
      elem: '#createDate' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	, trigger: 'click' 
    });
  });
</script>