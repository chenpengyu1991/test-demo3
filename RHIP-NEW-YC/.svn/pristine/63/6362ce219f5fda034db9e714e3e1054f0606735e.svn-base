<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript">
var canceled = (function() {
	$(function() {
        $("#returnButton").click(function(){
        	$("#list_view").show();
 			$("#factorsInfo_view").hide();
        });
	});
})();
</script>
<div class="toolbar" align="right">
			<a id="returnButton"><b class="fanhui">返回</b></a>
</div>
<form id="riskFactorsInfo" method="post">	
	<div class="postcontent">	
		<i class="popno">危险因素管理卡首页(已结束管理)</i>
		<div class="postdiv">
			<fieldset>
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
								<input type="hidden" id="dmhighriskRiskFactors.id" name="dmhighriskRiskFactors.id" value="${personInfo.dmhighriskRiskFactors.id}">
								<input type="hidden" id="dmhighriskRiskFactors.personId" name="dmhighriskRiskFactors.personId" value="${personInfo.personId}">
								<input type="hidden" id="dmhighriskRiskFactors.idcard" name="dmhighriskRiskFactors.idcard" value="${personInfo.idcard }">
								<input type="hidden" id="pageMark"  value="${personInfo.pageMark}">
								<input type="hidden" id="riskManageStatus" value="${personInfo.riskManageStatus}">
							</th>
						</tr>	
						<tr>
							<th>姓名</th>
							<td><input readonly="readonly" reg='{"maxlength":"50"}' type="text" id="name" name="name" value="${personInfo.name}"></td>
							<th>性别</th>
							<td><input readonly="readonly" type="text" value="<ehr:dic dicmeta="GBT226112003" code = "${personInfo.gender}"/>"></td>				
						</tr>
						<tr>
							<th>出生年月</th>
							<td><input readonly="readonly" type="text" value="<fmt:formatDate value='${personInfo.birthday}' pattern='yyyy/MM/dd'/>"></td>
							<th>联系电话</th>
							<td><input reg='{"regex":"phone","maxlength":20}' readonly="readonly" type="text" id="phoneNumber" name="phoneNumber" value="${personInfo.phoneNumber}"></td>
						</tr>
						<tr>
							<th>工作单位</th>
							<td colspan="1"><input reg='{"maxlength":"70"}' readonly="readonly" type="text" id="unitName" name="unitName" value="${personInfo.unitName}"></td>
						</tr>
						<tr>
							<th>住址</th>
							<td colspan="2">
								<input type="text" style="width: 430px" readonly="readonly" value="<ehr:dic dicmeta="FS990001" code="${personInfo.patownShip }"></ehr:dic>  <ehr:dic dicmeta="FS990001" code="${personInfo.pastreet }"></ehr:dic>">
							    <input type="text" readonly="readonly" id="pahouseNumber" name="pahouseNumber" value="${personInfo.pahouseNumber}"/>(详细地址)
							</td>
						</tr>		
				 </table>		
			</fieldset>
			<fieldset>
				<legend>危险因素变化</legend>
					<table class="posttable" id="disabledInput">
						<colgroup>
							<col style="width: 12%" />
							<col style="width: 35%" />
							<col style="width: 10%" />
							<col style="width: 35%" />
						</colgroup>		
						<tr>
							<th>超重	</th>
							<td colspan="3">
								<span id="overweightShow">
									B M I 值 :<input readonly="readonly" reg="{'regex':'number','min':'0','max':'99.99'}" style="width: 35px" type="text" id="dmhighriskRiskFactors.bodyMassIndex" name="dmhighriskRiskFactors.bodyMassIndex" 
												 value="${personInfo.dmhighriskRiskFactors.bodyMassIndex}">&nbsp;&nbsp;										
									腰    围:<input readonly="readonly" reg="{'regex':'number','min':'0','max':'9999.9'}" style="width: 35px" type="text" id="dmhighriskRiskFactors.waostline" name="dmhighriskRiskFactors.waostline"
												 value="${personInfo.dmhighriskRiskFactors.waostline}">cm
								</span>
							</td>
						</tr>
						<tr>
							<th>运动量</th>
							<td colspan="3">
								<span id="trainShow" >	
									每周运动:<input readonly="readonly" reg='{"regex":"digits","maxlength":"10"}' style="width: 35px" type="text" id="dmhighriskRiskFactors.weeklyTrain" name="dmhighriskRiskFactors.weeklyTrain"
											 value="${personInfo.dmhighriskRiskFactors.weeklyTrain}">次
								</span>
							</td>
						</tr>
						<tr>
							<th>当前吸烟	</th>
							<td colspan="3">	
								<span id="smokeShow" >	
									每日吸烟:<input readonly="readonly" reg='{"regex":"digits","maxlength":"4"}' style="width: 35px" type="text" id="dmhighriskRiskFactors.dailySmoke" name="dmhighriskRiskFactors.dailySmoke"
											 value="${personInfo.dmhighriskRiskFactors.dailySmoke}">支
								</span>
							</td>
						</tr>
						<tr>
							<th>长期饮酒</th>
							<td colspan="3">
								<span id="drinnkShow" >		
									每周平均:<input readonly="readonly" reg='{"regex":"digits","maxlength":"10"}' style="width: 35px" type="text" id="dmhighriskRiskFactors.weeklyDrinnk" name="dmhighriskRiskFactors.weeklyDrinnk"
									 	     value="${personInfo.dmhighriskRiskFactors.weeklyDrinnk}" >两
								</span>
							</td>
						</tr>
						<tr>
							<th>饮食偏油脂</th>
							<td colspan="3">
								<span id="foodShow" >		
									<input type="text" style="width:220px " readonly="readonly" value="${personInfo.dmhighriskRiskFactors.dailyEatFishFlag eq '1' ? '每天吃8两以上鱼肉' : ''} ${personInfo.dmhighriskRiskFactors.monthlyEatOilFlag eq '1' ? '每月吃油四斤以上' : ''}">
									总胆固醇:<input readonly="readonly" reg='{"regex":"number","min":0,"max":999.99}' style="width: 35px" type="text" name="dmhighriskRiskFactors.tc" value="${personInfo.dmhighriskRiskFactors.tc}">&nbsp;&nbsp;mmol/L								
									甘油三酯:<input readonly="readonly" reg='{"regex":"number","min":0,"max":99.9}' style="width: 35px" type="text" name="dmhighriskRiskFactors.triglycerideValue" value="${personInfo.dmhighriskRiskFactors.triglycerideValue}">mmol/L
								</span>
							</td>						
						</tr>
						<tr>
							<th>家族史</th>
							<td colspan="3">
								<span id="famHistoryShow" >		
									直系亲属高血压、糖尿病史：
									<input type="text" style="width: 330px" readonly="readonly" value="<ehr:dic dicmeta="DMD00001" code ="${personInfo.dmhighriskRiskFactors.immFamHpDiHisFlag}"/>">										
								</span>
							</td>
						</tr>
					</table>
			</fieldset>
			<fieldset>
				 <legend>综合评估</legend>			
				 <table class="posttable">
				 		<colgroup>
							<col style="width: 12%" />
							<col style="width: 35%" />
							<col style="width: 10%" />
							<col style="width: 35%" />
						</colgroup>		
						<tr>
							<th><label for="riskLevel">危险因素分级</label></th>
							<td>										
								<input type="text" readonly="readonly" value="<ehr:dic dicmeta="DMD00011" code ="${personInfo.riskLevel}"/>">										
							</td>
							<th>心理应激评定</th>
							<td>
								<input type="text" readonly="readonly" value="<ehr:dic dicmeta="DMD00012" code ="${personInfo.lcuLevel}"/>">																			
							</td>				
						</tr>
						<tr>
							<th>随访周期</th>
							<td>
								<span style="display:${personInfo.riskLevel eq '1' ? '' : 'none;'}"><input type="text" readonly="readonly" value="一次/年"></span>
								<span style="display:${personInfo.riskLevel eq '2' ? '' : 'none;'}"><input type="text" readonly="readonly" value="二次/年"> </span>
								<span style="display:${personInfo.riskLevel eq '3' ? '' : 'none;'}"> <input type="text" readonly="readonly" value="四次/年"></span>	
							</td>
							<th><label>管理机构</label></th>
							<td>${personInfo.createOrganName}</td>
						</tr>
						<tr>	
							<th>管理医生</th>
							<td>${personInfo.createDoctorName}</td>
							<th>建卡日期</th>
							<td>
								<input type="text" readonly="readonly" value="<fmt:formatDate value='${personInfo.createDate}' pattern='yyyy/MM/dd'/>">
							</td>
						</tr>
						<tr>
							<th>管理意见</th>
							<td colspan="3">
								<input type="text" style="width: 490px" readonly="readonly" value="<ehr:dic dicmeta="DMD00013" code = "${personInfo.manageAdvice}"/>">				
							</td>						
						</tr>				
				  </table>
			</fieldset>
		</div>
	</div>
</form>
