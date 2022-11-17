<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript">
	$(function() {
		if($("#bloodGlucoseLeft").val()!=""||$("#bloodGlucoseRight").val()!=""){
			$("#bloodSugarSource").show();
			if($("#idElder").val()=="true"){
				$("#CMedicine").show();
			}else{
				$("#CMedicine").hide();
			}
		}else{
			$("#CMedicine").hide();
			$("#bloodSugarSource").hide();
		}

		if($("#leftBloodUp").val()!=""||$("#leftBloodDown").val()!=""||$("#rightBloodUp").val()!=""||$("#rightBloodDown").val()!=""){
			$("#bloodPressureSource").show();
		}else{
			$("#bloodPressureSource").hide();
		}

		$("input[name='leftDbp']").on("blur", function () {
			if($("#leftBloodUp").val()!=""||$("#leftBloodDown").val()!=""||$("#rightBloodUp").val()!=""||$("#rightBloodDown").val()!=""){
				$("#bloodPressureSource").show();
			}else{
				$("#bloodPressureSource").hide();
			}
		});
		$("input[name='pastHighesDbp']").on("blur", function () {
			if($("#leftBloodUp").val()!=""||$("#leftBloodDown").val()!=""||$("#rightBloodUp").val()!=""||$("#rightBloodDown").val()!=""){
				$("#bloodPressureSource").show();
			}else{
				$("#bloodPressureSource").hide();
			}
		});
		$("input[name='leftSbp']").on("blur", function () {
			if($("#leftBloodUp").val()!=""||$("#leftBloodDown").val()!=""||$("#rightBloodUp").val()!=""||$("#rightBloodDown").val()!=""){
				$("#bloodPressureSource").show();
			}else{
				$("#bloodPressureSource").hide();
			}
		});
		$("input[name='pastHighestSbp']").on("blur", function () {
			if($("#leftBloodUp").val()!=""||$("#leftBloodDown").val()!=""||$("#rightBloodUp").val()!=""||$("#rightBloodDown").val()!=""){
				$("#bloodPressureSource").show();
			}else{
				$("#bloodPressureSource").hide();
			}
		});
	});
</script>
<table class="posttable">
	<colgroup>
		<col style="width:8%">
		<col style="width:15%">
		<col style="width:8%">
		<col style="width:23%">
		<col style="width:8%">
		<col style="width:15%">
		<col style="width:8%">
		<col style="width:15%">
	</colgroup>
	<tr>
		<td colspan="8" align="right">编号：
			<input style="width:120px;" type="text" readonly="readonly"	 value="${examination.physicalExamCode}" />
		</td>
	</tr>
	<tr>


		<td>姓名:</td>
		<td><input type= "text" name="name" readonly="readonly" value="${examination.name}"  ></td>

		<td><label >体检机构:</label></td>
		<td>
			<ehr:org    code="${examination.examinationOrganCode}"></ehr:org>
		</td>


		<td>体检日期:</td>
		<td><fmt:formatDate value="${examination.examinationDate }" pattern="yyyy/MM/dd" />
		</td>

		<td>责任医生:</td>

		<td>
			<ehr:staff-name staffCode="${examination.manaDoctorId}"></ehr:staff-name>
		</td>


	</tr>
</table>
<div class="postdiv">
	<fieldset style="width: 98.5%" class="layui-elem-field">
		<table class="posttable">
			<tr>
				<th style="width: 16%">症状</th>
				<td>
					<input type="radio" name="symptomFlag"  ${examination.symptomFlag eq '0' or examination.symptomFlag eq null ? 'checked' : ''} value="0" onclick="util.clickHideTable(this,'ttb1')" /> 无症状
					<input type="radio" id="symptomFlag" name="symptomFlag"  ${examination.symptomFlag eq '1' ? 'checked':''} value="1"  onclick="util.clickShowTable(this,'ttb1')" /> 有症状
					<table class="tt_hidden" id="ttb1">
						<tr>
							<td><input type="checkbox" name="symptomHeadache" ${examination.symptomHeadache eq '1' ? 'checked':''} value="1"> 头痛 </td>
							<td><input type="checkbox" name="symptomDizzy" ${examination.symptomDizzy eq '1' ? 'checked':''} value="1"> 头晕 </td>
							<td><input type="checkbox" name="symptomPalpitations" ${examination.symptomPalpitations eq '1' ? 'checked':''} value="1"> 心悸 </td>
							<td><input type="checkbox" name="symptomChestTightness" ${examination.symptomChestTightness eq '1' ? 'checked':''} value="1"> 胸闷 </td>
							<td><input type="checkbox" name="symptomChestPain" ${examination.symptomChestPain eq '1' ? 'checked':''} value="1"> 胸痛 </td>
							<td><input type="checkbox" name="symptomChronicCough" ${examination.symptomChronicCough eq '1' ? 'checked':''} value="1"> 慢性咳嗽 </td>
							<td><input type="checkbox" name="symptomCough" ${examination.symptomCough eq '1' ? 'checked':''} value="1"> 咳痰 </td>
							<td><input type="checkbox" name="symptomDyspnea" ${examination.symptomDyspnea eq '1' ? 'checked':''} value="1"> 呼吸困难 </td>
						</tr>
						<tr>
							<td><input type="checkbox" name="symptomPolydipsia" ${examination.symptomPolydipsia eq '1' ? 'checked':''} value="1"> 多饮 </td>
							<td><input type="checkbox" name="symptomPolyuria" ${examination.symptomPolyuria eq '1' ? 'checked':''} value="1"> 多尿 </td>
							<td><input type="checkbox" name="symptomWeightLoss" ${examination.symptomWeightLoss eq '1' ? 'checked':''} value="1"> 体重下降 </td>
							<td><input type="checkbox" name="symptomFatigue" ${examination.symptomFatigue eq '1' ? 'checked':''} value="1"> 乏力 </td>
							<td><input type="checkbox" name="symptomJointPain" ${examination.symptomJointPain eq '1' ? 'checked':''} value="1"> 关节肿痛 </td>
							<td><input type="checkbox" name="symptomBlurredVision" ${examination.symptomBlurredVision eq '1' ? 'checked':''} value="1"> 视力模糊 </td>
							<td><input type="checkbox" name="symptomNumbness" ${examination.symptomNumbness eq '1' ? 'checked':''} value="1"> 手脚麻木 </td>
							<td><input type="checkbox" name="symptomUrgency" ${examination.symptomUrgency eq '1' ? 'checked':''} value="1"> 尿急 </td>
						</tr>
						<tr>
							<td><input type="checkbox" name="symptomDysuria" ${examination.symptomDysuria eq '1' ? 'checked':''} value="1"> 尿痛 </td>
							<td><input type="checkbox" name="symptomConstipation" ${examination.symptomConstipation eq '1' ? 'checked':''} value="1"> 便秘 </td>
							<td><input type="checkbox" name="symptomDiarrhea" ${examination.symptomDiarrhea eq '1' ? 'checked':''} value="1"> 腹泻 </td>
							<td><input type="checkbox" name="symptomNauseaVomiting" ${examination.symptomNauseaVomiting eq '1' ? 'checked':''} value="1"> 恶心呕吐 </td>
							<td><input type="checkbox" name="symptomVertigo" ${examination.symptomVertigo eq '1' ? 'checked':''} value="1"> 眼花 </td>
							<td><input type="checkbox" name="symptomTinnitus" ${examination.symptomTinnitus eq '1' ? 'checked':''} value="1"> 耳鸣 </td>
							<td colspan="2"><input type="checkbox" name="symptomBreastTenderness" ${examination.symptomBreastTenderness eq '1' ? 'checked':''} value="1"> 乳房胀痛 </td>
						</tr>
						<tr>
							<td colspan="8">
								<input type="checkbox" id="symptomOther" onclick="util.clickShowText(this,'symptomOtherDesc')" name="symptomOther" ${examination.symptomOther eq '1' ? 'checked':''} value="1"> 其他症状
								&nbsp;&nbsp;
								<input type="text" name="symptomOtherDesc" id="symptomOtherDesc"  class="hidediv" style="width: 200px;" value="${examination.symptomOtherDesc}" class="nowidth" reg='{"dependOn":"symptomOther","required":"true","maxlength":"33"}'>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</fieldset>
</div>

<div class="postdiv" style="display:none">
	<fieldset class="layui-elem-field">
		<legend>家族史,父母、兄弟姐妹有男性在55岁以前或女性在65岁以前患以下疾病</legend>
		<table class="posttable">
			<tr>
				<th style="width: 16%">高血压</th>
				<td><ehr:dic-radio dicmeta="FS10281" value="${examination.familyHistoryHbpFlg}"  name="familyHistoryHbpFlg" /></td>
				<th style="width: 16%">冠心病</th>
				<td><ehr:dic-radio dicmeta="FS10281" value="${examination.familyHistoryCoronaryFlg}"  name="familyHistoryCoronaryFlg" /></td>
			</tr>
			<tr>
				<th style="width: 16%">脑卒中</th>
				<td><ehr:dic-radio dicmeta="FS10281" value="${examination.familyHistoryStrokeFlg}" name="familyHistoryStrokeFlg" /></td>
				<th style="width: 16%">糖尿病</th>
				<td><ehr:dic-radio dicmeta="FS10281" value="${examination.familyHistoryDiFlg}" name="familyHistoryDiFlg" /></td>
			</tr>
		</table>
	</fieldset>
</div>

<div class="postdiv">
	<fieldset class="layui-elem-field">
		<legend>一般状况</legend>
		<table class="posttable">
			<tr>
				<th style="width: 22%">体温</th>
				<td >
					<tag:numberInput point="point" style="width: 80px" value="${examination.temperature}" name="temperature"  reg="{'min':0,'max':999.9}"></tag:numberInput>℃</td>
				<th>脉率</th>
				<td style="width: 42%"><tag:numberInput style="width: 80px"  name="pulseRate" value="${examination.pulseRate}" reg="{'min':0,'max':9999}"/>次/分钟</td>
			</tr>
			<tr>
				<th>呼吸频率</th>
				<td><tag:numberInput name="respiratoryRate" style="width: 80px"  value="${examination.respiratoryRate}" reg="{'min':0,'max':9999}"/>次/分钟</td>
				<th>血压</th>
				<td>
					左侧
					<tag:numberInput name="leftSbp" value="${examination.leftSbp}"  style="width: 40px" reg="{'min':0,'max':9999}" id="leftBloodUp"/>/
					<tag:numberInput name="leftDbp" value="${examination.leftDbp}"  style="width: 40px" reg="{'min':0,'max':9999}" id="leftBloodDown"/>mmHg
					右侧
					<tag:numberInput  name="pastHighestSbp" value="${examination.rightSbp}" style="width: 40px" reg="{'min':0,'max':9999}" id="rightBloodUp"/>/
					<tag:numberInput  name="pastHighesDbp" value="${examination.rightDbp}"  style="width: 40px"  reg="{'min':0,'max':9999}" id="rightBloodDown"/>mmHg


				</td>
			</tr>
			<tr id="bloodPressureSource" style="display: none">
				<th></th>
				<td></td>
				<th><label class="required">来源</label></th>
				<td>
					<%--<label><input type="radio" name="bloodPressureSource"  value="1"
					${examination.bloodPressureSource eq 1 ? "checked" : "" }  reg="{'required':'true'}"/> 单位体检</label>
					<label><input type="radio" name="bloodPressureSource"  value="2"
					${examination.bloodPressureSource eq 2 ? "checked" : ""}  reg="{'required':'true'}"/> 其他医院</label>--%>
					<%--<label><input type="radio" name="bloodPressureSource" value="3"
					${examination.bloodPressureSource eq 3 ? "checked" : ""}  reg="{'required':'true'}"/> 个人提供</label>--%>
                    <ehr:dic-radio dicmeta="TFJKDA001" name="bloodPressureSource"
                                   value="${examination.bloodPressureSource}" reg="{'required':true}"/>
				</td>
			</tr>
			<tr>
				<th>身高</th>
				<td><tag:numberInput reg="{'min':0,'max':9999.9}" id="personHeightId" point="point" name="height" value="${examination.height}" style="width: 80px" />cm</td>
				<th>体重</th>
				<td><tag:numberInput reg="{'min':0,'max':9999.9}" id="personWeightId" point="point" name="bodyWeight" value="${examination.bodyWeight}" style="width: 80px" />kg</td>
			</tr>
			<tr>
				<th>腰围</th>
				<td><tag:numberInput reg="{'min':0,'max':9999.9}" id="personWaostline" point="point" name="waostline" value="${examination.waostline}" style="width: 80px" />cm</td>
				<th>体质指数（BMI）</th>
				<td><input reg="{'min':0,'max':999.99}" type="text" id="personBMIId" name="indexOfBodyCharacteristics" value="${examination.indexOfBodyCharacteristics}" readonly="readonly" style="width: 80px;"/>kg/㎡</td>
			</tr>
			<%--<tr>
            <th>臀围</th>
            <td><tag:numberInput reg="{'min':0,'max':9999.9}" id="personHip" point="point"  name="hip" value="${examination.hip}" style="width: 80px" />cm</td>
            <th>腰臀围比值</th>
            <td><input id="whrValue" type="text" reg="{'min':0,'max':99.9}" name="whr" value="${examination.whr}" readonly="readonly" style="width: 80px" /></td>
        </tr>--%>
		</table>
	</fieldset>
</div>
<div class="postdiv">
	<fieldset class="layui-elem-field">
		<legend>生活方式</legend>
		<div class="postdiv">
			<fieldset class="layui-elem-field">
				<legend>体育锻炼</legend>
				<table class="posttable" >
					<tr>
						<th width="16%">锻炼频率</th>
						<td colspan="2">
							<ehr:dic-radio name="trainFrequencyTypeCode" dicmeta="FS10208" value="${examination.trainFrequencyTypeCode}"  onchange="addPhyExam.setContentStyle(this,'exerciseTypeSpan:keepTimeSpan:exerciseTimeSpan')"/>
						</td>
					</tr>
					<tr>
						<th>每次锻炼时间</th>
						<td>
				    	<span id="exerciseTimeSpan" >
				        	<tag:numberInput reg="{'min':0,'max':9999}"  name="trainingMin" value="${examination.trainingMin}" style="width: 80px" />分钟
				        </span>
						</td>
						<th>坚持锻炼时间</th>
						<td>
				    	<span id="keepTimeSpan">
				        	<tag:numberInput maxlength="5" name="trainingTotaltime" value="${examination.trainingTotaltime}" style="width: 80px" point="1"/>年
				        </span>
						</td>
					</tr>
					<tr>
						<th>锻炼方式</th>
						<td colspan="3">
				    <span id="exerciseTypeSpan">
						<input type="hidden" value="${examination.trainingWay}" id="text_trainingWay"/>
				    	<ehr:dic-checkbox name="trainingWay" value="${examination.trainingWay}" dicmeta="FS990004"></ehr:dic-checkbox>
				    	<span id="other_train_way_span" class="hidediv">
				    		<input type="text"  name="otherTrainingWay" value="${examination.otherTrainingWay}" style="width: 150px"/>
				    	</span>
				    </span>
						</td>
					</tr>
				</table>
			</fieldset>
		</div>
		<div class="postdiv">
			<fieldset class="layui-elem-field">
				<legend>饮食习惯</legend>
				<table class="posttable">
					<tr>
						<td style="width: 16%"></td>
						<td >
							<input type="checkbox" name="dietHunsuEquilibrium" ${examination.dietHunsuEquilibrium eq"1"?"checked":""} value="1"/>
							荤素均衡
							<input type="checkbox" name="dietMeatMain" ${examination.dietMeatMain eq"2"?"checked":""} value="2"/>
							荤食为主
							<input type="checkbox" name="dietVegetarian" ${examination.dietVegetarian eq"3"?"checked":""} value="3"/>
							素食为主
							<input type="checkbox" name="dietHalophilic" ${examination.dietHalophilic eq"4"?"checked":""} value="4"/>
							嗜盐
							<input type="checkbox" name="dietAddictedOil" ${examination.dietAddictedOil eq"5"?"checked":""} value="5"/>
							嗜油
							<input type="checkbox" name="dietSugarCravings" ${examination.dietSugarCravings eq"6"?"checked":""} value="6"/>
							嗜糖
						</td>
					</tr>
				</table>
			</fieldset>
		</div>
		<div class="postdiv">
			<fieldset class="layui-elem-field">
				<legend>吸烟情况</legend>
				<table class="posttable">

					<colgroup>
						<col style="width:15%">
						<col style="width:85%">
					</colgroup>
					<tr>
						<th width="16%">吸烟状况</th>
						<td >
							<ehr:dic-radio name="smodeStatusCode" dicmeta="CV0300101" value="${examination.smodeStatusCode}" onchange="addPhyExam.setContentStyle(this,'smokePerDaySpan:beginSmokeAgeSpan:endSmokeAgeSpan')"/>
						</td>
					</tr>
					<tr>
						<th>日吸烟量</th>
						<td   >
					    <span id="smokePerDaySpan">
				    		平均
					       <tag:numberInput reg="{'min':0,'max':9999}" name="dailySmoke" value="${examination.dailySmoke}" style="width: 40px"/>支
					    </span>
						</td>
					</tr>
					<tr>
						<th>开始吸烟年龄</th>
						<td>
					     <span id="beginSmokeAgeSpan">
						    	<tag:numberInput reg="{'min':0,'max':999}" name="smokeAge" value="${examination.smokeAge}" style="width: 40px"/>岁
					     </span>
						</td>
					</tr>
					<tr>
						<th>戒烟年龄</th>
						<td>
				    	<span id="endSmokeAgeSpan">
				    		<tag:numberInput reg="{'min':0,'max':999}" name="quitSmokeAge" value="${examination.quitSmokeAge}" style="width: 40px" /> 岁
				    	</span>
						</td>
					</tr>
				</table>
			</fieldset>
		</div>
		<div class="postdiv">
			<fieldset class="layui-elem-field">
				<legend>饮酒情况</legend>
				<table class="posttable">
					<colgroup>
						<col style="width:15%">
						<col style="width:85%">
					</colgroup>

					<tr>
						<th width="16%">饮酒频率</th>
						<td >
							<ehr:dic-radio name="drinkFrequency" value="${examination.drinkFrequency }" dicmeta="CV0300104" onchange="addPhyExam.setContentStyle(this,'wineTypeSpan:isDrunkSpan:beginDrinkingAgeSpan:isEndDrinkingSpan:drinkingPerDaySpan')" code="1,2,3,4"/>
						</td>
					</tr>
					<tr>
						<th>日饮酒量</th>
						<td >
				   		<span id="drinkingPerDaySpan">
				    	平均
				        <tag:numberInput reg="{'min':0,'max':9999}"  name="dailyDrink" value="${examination.dailyDrink}"  style="width: 40px" />两
				        </span>
						</td>
					</tr>
					<tr>
						<th>是否戒酒</th>
						<td >
				    	<span id="isEndDrinkingSpan">
					         <input type="radio" onclick="util.clickHideText(this,'quitDrinkAgeDesc')"  name="nodrink" ${examination.nodrink eq"2" ?"checked" :""} value="2"/> 未戒酒
					         <input type="radio" id="nodrinkId" onclick="util.clickShowText(this,'quitDrinkAgeDesc')" name="nodrink" ${examination.nodrink eq"1" ?"checked" :""} value="1"/>已戒酒
					         <span class="hidediv" id="quitDrinkAgeDesc">&nbsp;&nbsp;&nbsp;
					                                       戒酒年龄:<tag:numberInput name="nodrinkAge" value="${examination.nodrinkAge}"  style="width: 40px" reg="{'dependOn':'nodrinkId','required':'true','regex':'digits','min':0,'max':999}" />岁
					         </span>
				         </span>
						</td>
					</tr>
					<tr>
						<th>开始饮酒年龄</th>
						<td>
				    <span id="beginDrinkingAgeSpan">
				    <tag:numberInput reg="{'min':0,'max':999}"  name="drinkAge" value="${examination.drinkAge}"  style="width: 40px" />岁
				    </span>

							近一年内是否曾醉酒

							<span id="isDrunkSpan">
					    	<ehr:dic-radio name="drunk" value="${examination.drunk }" dicmeta="FS10009"/>
					    </span>
						</td>
					</tr>
					<tr>
						<th>饮酒种类</th>
						<td >
				    	<span id="wineTypeSpan">
				                <input type="checkbox" name="drinkSpirit" ${examination.drinkSpirit eq"1"?"checked":""} value="1"/>
					     白酒
				               <input type="checkbox" name="drinkBeer" ${examination.drinkBeer eq"2"?"checked":""} value="2"/>
				                啤酒
				               <input type="checkbox" name="drinkRedWine" ${examination.drinkRedWine eq"3"?"checked":""} value="3"/>
				                红酒
				                 <input type="checkbox" name="drinkYellowWine" ${examination.drinkYellowWine eq"4"?"checked":""} value="4"/>
				                黄酒
				                <input type="checkbox" id="drinkOther" name="drinkOther"  onclick="util.clickShowText(this,'drinkOtherDesc')" ${examination.drinkOther eq"5"?"checked":""} value="5"/>
				                其他
				               <input class="hidediv" id="drinkOtherDesc" type="text" name="drinkOtherDesc" value="${examination.drinkOtherDesc}" reg='{"dependOn":"drinkOther","required":"true","maxlength":"33"}'  style="width: 200px">
				   		</span>
						</td>
					</tr>
				</table>
			</fieldset>
		</div>
		<div class="postdiv">
			<fieldset class="layui-elem-field">
				<legend>职业病危害因素接触史</legend>
				<table class="posttable">
					<tr>
						<td style="width: 16%"></td>
						<td>
							<label>
								<input type="radio" onclick="util.clickHideTable(this,'occupationExposureDiv')"
									   name="occupationExposureFlag" ${examination.occupationExposureFlag eq"0" || examination.occupationExposureFlag eq null ?"checked" :""}
									   value="0"/>无</label>
							<label>
								<input type="radio" id="occupationExposureFlag" onclick="util.clickShowTable(this,'occupationExposureDiv')"
									   name="occupationExposureFlag" ${examination.occupationExposureFlag eq"1" ?"checked" :""}
									   value="1"/>有</label>
							<div  class="tt_hidden" id="occupationExposureDiv">
								&nbsp;(工种<input reg='{"dependOn":"occupationExposureFlag","required":true,"maxlength":"33"}' type="text" name="riskOccupationDesc" value="${examination.riskOccupationDesc}"  style="width: 40px"/> 从业时间
								<tag:numberInput reg="{'dependOn':'occupationExposureFlag','required':true,'min':0,'max':999}" name="riskOccupationTime" value="${examination.riskOccupationTime}"  style="width: 40px"/>年)
								<table>
                                    <tr><td>毒物种类</td><td colspan="3"></td></tr>
									<tr>
										<td width="10%">粉尘</td>
										<td width="30%"><input reg='{"maxlength":"33"}' type="text"
															   name="dustTypeDesc"
															   value="${examination.dustTypeDesc}"/>
										</td>
										<td width="10%">防护措施</td>
										<td width="50%">
											<label><input type="radio"
														  name="dustProtectionFlag"
														  onclick="util.clickHideText(this,'dustProtectionDesc')"  ${examination.dustProtectionFlag eq"0" ?"checked" :""}
														  value="0"/>无</label>
											<label><input type="radio" id="dustProtectionFlag"
														  name="dustProtectionFlag"
														  onclick="util.clickShowText(this,'dustProtectionDesc')"  ${examination.dustProtectionFlag eq"1" ?"checked" :""}
														  value="1"/>有</label>
											<input type="text"
												   name="dustProtectionDesc"
												   class="hidediv" id="dustProtectionDesc"
												   value="${examination.dustProtectionDesc}"
												   reg='{"dependOn":"dustProtectionFlag","required":"true","maxlength":"33"}'/>
										</td>
									</tr>
									<tr>
										<td>放射物质</td>
										<td><input type="text" reg='{"maxlength":"33"}'
												   name="radiationTypeDesc"
												   value="${examination.radiationTypeDesc}"/>
										</td>
										<td>防护措施</td>
										<td>
											<label><input type="radio"
														  name="radiationProtectionFlag"
														  onclick="util.clickHideText(this,'radiationProtectionDesc')" ${examination.radiationProtectionFlag eq"0" ?"checked" :""}
														  value="0"/>无</label>
											<label><input type="radio" id="radiationProtectionFlag"
														  name="radiationProtectionFlag"
														  onclick="util.clickShowText(this,'radiationProtectionDesc')" ${examination.radiationProtectionFlag eq"1" ?"checked" :""}
														  value="1"/>有</label>
											<input type="text"
												   name="radiationProtectionDesc"
												   class="hidediv" id="radiationProtectionDesc"
												   value="${examination.radiationProtectionDesc}"
												   reg='{"dependOn":"radiationProtectionFlag","required":"true","maxlength":"33"}'/>
										</td>
									</tr>

									<tr>
										<td>物理因素</td>
										<td><input type="text" reg='{"maxlength":"33"}'
												   name="physicsTypeDesc"
												   value="${examination.physicsTypeDesc}"/>
										</td>
										<td>防护措施</td>
										<td>
											<label><input type="radio"
														  name="physicsProtectionFlag"
														  onclick="util.clickHideText(this,'physicsProtectionDesc')" ${examination.physicsProtectionFlag eq"0" ?"checked" :""}
														  value="0"/>无</label>
											<label><input type="radio" id="physicsProtectionFlag"
														  name="physicsProtectionFlag"
														  onclick="util.clickShowText(this,'physicsProtectionDesc')" ${examination.physicsProtectionFlag eq"1" ?"checked" :""}
														  value="1"/>有</label>
											<input type="text"
												   name="physicsProtectionDesc"
												   class="hidediv" id="physicsProtectionDesc" class="hidediv"
												   value="${examination.physicsProtectionDesc}"
												   reg='{"dependOn":"physicsProtectionFlag","required":"true","maxlength":"33"}'/>
										</td>
									</tr>
									<tr>
										<td>化学因素</td>
										<td><input reg='{"maxlength":"33"}' type="text"
												   name="chemistryTypeDesc"
												   value="${examination.chemistryTypeDesc}"/>
										</td>
										<td>防护措施</td>
										<td>
											<label><input type="radio"
														  name="chemistryProtectionFlag"
														  onclick="util.clickHideText(this,'chemistryProtectionDesc')" ${examination.chemistryProtectionFlag eq"0" ?"checked" :""}
														  value="0"/>无</label>
											<label><input type="radio" id="chemistryProtectionFlag"
														  name="chemistryProtectionFlag"
														  onclick="util.clickShowText(this,'chemistryProtectionDesc')" ${examination.chemistryProtectionFlag eq"1" ?"checked" :""}
														  value="1"/>有</label>
											<input type="text"
												   name="chemistryProtectionDesc"
												   class="hidediv" id="chemistryProtectionDesc"
												   value="${examination.chemistryProtectionDesc}"
												   reg='{"dependOn":"chemistryProtectionFlag","required":"true","maxlength":"33"}'/>
										</td>
									</tr>
									<tr>
										<td>其他</td>
										<td><input reg='{"maxlength":"33"}' type="text"
												   name="otherTypeDesc"
												   value="${examination.otherTypeDesc}"/>
										</td>
										<td>防护措施</td>
										<td>
											<label><input type="radio"
														  name="otherProtectionFlag"
														  onclick="util.clickHideText(this,'otherProtectionDesc')" ${examination.otherProtectionFlag eq"0" ?"checked" :""}
														  value="0"/>无</label>
											<label><input type="radio" id="otherProtectionFlag"
														  name="otherProtectionFlag"
														  onclick="util.clickShowText(this,'otherProtectionDesc')" ${examination.otherProtectionFlag eq"1" ?"checked" :""}
														  value="1"/>有</label>
											<input type="text"
												   name="otherProtectionDesc"
												   class="hidediv" id="otherProtectionDesc"
												   value="${examination.otherProtectionDesc}"
												   reg='{"dependOn":"otherProtectionFlag","required":"true","maxlength":"33"}'/>
										</td>
									</tr>
								</table>
							</div >
						</td>
					</tr>
				</table>
			</fieldset>
		</div>
	</fieldset>
</div>
<div class="postdiv">
	<fieldset class="layui-elem-field">
		<legend>脏器功能</legend>
		<table class="posttable">
			<colgroup>
				<col style="width:15%">
				<col style="width:85%">
			</colgroup>
			<tr>
				<th style="width: 16%">口腔</th>
				<td style="width: 84%">
					<table>
						<tr>
							<td colspan="4">口唇&nbsp;
								<ehr:dic-radio name="lipAppearanceCehckResult" value="${examination.lipAppearanceCehckResult }" dicmeta="CV0410007"/>
							</td>
						</tr>
						<tr>
							<td colspan="4">齿列&nbsp;
								<input type="radio" name="dentitionAnomalyFlag" onclick="util.clickHideTable(this,'dentitionAnomalyDiv')" ${examination.dentitionAnomalyFlag eq '0' or examination.dentitionAnomalyFlag eq null ? "checked" : ""} value="0">正常
								<input type="radio" id="dentitionAnomalyFlag" name="dentitionAnomalyFlag" onclick="util.clickShowTable(this,'dentitionAnomalyDiv')" ${examination.dentitionAnomalyFlag eq '1' ?"checked" :""}  value="1">异常
								<div id="dentitionAnomalyDiv" style="display: none;width: 100%; padding-left:31px;">
									<span style="float:left;"><input  type="checkbox" id="missingTooth" name="missingToothFlg" ${examination.missingToothFlg eq '1'?'checked':''} value="1"  onclick="util.clickShowText(this,'ttb3')"> 缺齿 </span>
									<table class="sttb" id="ttb3" style="width: 10%;float:left;margin-right:5px;">
										<tr >
											<td><tag:numberInput reg="{'min':0,'max':999}" name="missingToothNumberUpl"  value="${examination.missingToothNumberUpl}" cssClass="width30" />  </td>
											<td><tag:numberInput  reg="{'min':0,'max':999}" name="missingToothNumberUpr" value="${examination.missingToothNumberUpr}" cssClass="width30" /> </td>
										</tr>
										<tr>
											<td><tag:numberInput  reg="{'min':0,'max':999}" name="missingToothNumberDownl" value="${examination.missingToothNumberDownl}" cssClass="width30" /></td>
											<td><tag:numberInput  reg="{'min':0,'max':999}" name="missingToothNumberDownr" value="${examination.missingToothNumberDownr}" cssClass="width30" /></td>
										</tr>
									</table>
									<span style="float:left;"><input type="checkbox" id="decayedTooth" name="decayedToothFlg" ${examination.decayedToothFlg eq '1'?'checked':''} value="1" onclick="util.clickShowText(this,'ttb4')"> 龋齿</span>
									<table class="sttb" id="ttb4" style="width: 10%;float:left;margin-right:5px;">
										<tr >
											<td><tag:numberInput  reg="{'min':0,'max':999}" name="decayedToothNumberUpl" value="${examination.decayedToothNumberUpl}" cssClass="width30" />  </td>
											<td><tag:numberInput  reg="{'min':0,'max':999}" name="decayedToothNumberUpr" value="${examination.decayedToothNumberUpr}" cssClass="width30" /> </td>
										</tr>
										<tr>
											<td><tag:numberInput  reg="{'min':0,'max':999}" name="decayedToothNumberDownl" value="${examination.decayedToothNumberDownl}" cssClass="width30" /></td>
											<td><tag:numberInput  reg="{'min':0,'max':999}" name="decayedToothNumberDownr" value="${examination.decayedToothNumberDownr}" cssClass="width30" /></td>
										</tr>
									</table>
									<span style="float:left;"><input type="checkbox" id="dentureTooth" name="dentureToothFlg" ${examination.dentureToothFlg eq '1'?'checked':''} value="1"  onclick="util.clickShowText(this,'ttb5')"> 义齿</span>
									<table class="sttb" id="ttb5" style="width: 10%;float:left;margin-right:5px;">
										<tr >
											<td><tag:numberInput  reg="{'min':0,'max':999}" name="dentureToothNumberUpl" value="${examination.dentureToothNumberUpl}" cssClass="width30" />  </td>
											<td><tag:numberInput  reg="{'min':0,'max':999}" name="dentureToothNumberUpr" value="${examination.dentureToothNumberUpr}" cssClass="width30" /> </td>
										</tr>
										<tr>
											<td><tag:numberInput  reg="{'min':0,'max':999}" name="dentureToothNumberDownl" value="${examination.dentureToothNumberDownl}" cssClass="width30" /></td>
											<td><tag:numberInput  reg="{'min':0,'max':999}" name="dentureToothNumberDownr" value="${examination.dentureToothNumberDownr}" cssClass="width30" /></td>
										</tr>
									</table>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="4">咽部&nbsp;
								<ehr:dic-radio name="pharynxCheckResult" value="${examination.pharynxCheckResult }" dicmeta="FS10183"/>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<th>视力</th>
				<td >
					<c:choose>
						<c:when test="${examination.lNakedEye eq '0.0'}">
							左眼<tag:numberInput point="point"   name="lNakedEye" style="width: 40px" reg="{'min':0,'max':99.9}"/>
						</c:when>
						<c:otherwise>
							左眼<tag:numberInput point="point"   name="lNakedEye" value="${examination.lNakedEye}" style="width: 40px" reg="{'min':0,'max':99.9}"/>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${examination.rNakedEye eq '0.0'}">
							右眼<tag:numberInput point="point"   name="rNakedEye"  style="width: 40px" reg="{'min':0,'max':99.9}"/>
						</c:when>
						<c:otherwise>
							右眼<tag:numberInput point="point"   name="rNakedEye" value="${examination.rNakedEye}"  style="width: 40px" reg="{'min':0,'max':99.9}"/>
						</c:otherwise>
					</c:choose>
					（矫正视力:
					<c:choose>
						<c:when test="${examination.lEyecorrection eq '0.0'}">
							左眼<tag:numberInput point="point"   name="lEyecorrection" style="width: 40px"  reg="{'min':0,'max':99.9}"/>
						</c:when>
						<c:otherwise>
							左眼<tag:numberInput point="point"   name="lEyecorrection" value="${examination.lEyecorrection}" style="width: 40px"  reg="{'min':0,'max':99.9}"/>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${examination.rEyecorrection eq '0.0'}">
							右眼<tag:numberInput  point="point"   name="rEyecorrection"   style="width: 40px" reg="{'min':0,'max':99.9}"/>）
						</c:when>
						<c:otherwise>
							右眼<tag:numberInput  point="point"   name="rEyecorrection" value="${examination.rEyecorrection}"  style="width: 40px" reg="{'min':0,'max':99.9}"/>）
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th>听力</th>
				<td >
					<ehr:dic-radio name="hearDetectResult" value="${examination.hearDetectResult }" dicmeta="FS10170"/>
				</td>
			</tr>
			<tr>
				<th>运动功能</th>
				<td >
					<ehr:dic-radio name="motorFuncState" value="${examination.motorFuncState }" dicmeta="FS10212"/>
				</td>
			</tr>
		</table>
	</fieldset>
</div>
<div class="postdiv">
	<fieldset class="layui-elem-field">
		<legend>查体</legend>
		<table class="posttable">
			<colgroup>
				<col style="width:15%">
				<col  style="width:80%">
			</colgroup>
			<tr>
				<th style="width: 16%;">眼底*</th>
				<td  style="width: 84%;">
					<input type="radio" onclick="util.clickHideText(this,'fundusOculiAnomalyDesc')" name="fundusOculiAnomalyFlag" ${examination.fundusOculiAnomalyFlag eq "2" ? "checked" : ""} value="2">未检
					<input type="radio" onclick="util.clickHideText(this,'fundusOculiAnomalyDesc')" name="fundusOculiAnomalyFlag" ${examination.fundusOculiAnomalyFlag eq "0" or examination.fundusOculiAnomalyFlag eq null ? "checked" : ""} value="0">正常
					<input type="radio" id="fundusOculiAnomalyFlag"  onclick="util.clickShowText(this,'fundusOculiAnomalyDesc')" name="fundusOculiAnomalyFlag" ${examination.fundusOculiAnomalyFlag eq"1" ?"checked":""} value="1">异常
					<input type="text" id="fundusOculiAnomalyDesc" class="hidediv" name="fundusOculiAnomalyDesc" value="${examination.fundusOculiAnomalyDesc}" style="width: 200px;" reg='{"dependOn":"fundusOculiAnomalyFlag","required":"true","maxlength":"33"}'>
				</td>
			</tr>
			<tr>
				<th>皮肤</th>
				<td >
					<input type="radio" onclick="util.clickHideText(this,'skinCheckDesc')" name="skinCheckResult" ${examination.skinCheckResult eq "1" or examination.skinCheckResult eq null ? "checked" : ""} value="1">正常
					<input type="radio" onclick="util.clickHideText(this,'skinCheckDesc')"  name="skinCheckResult" ${examination.skinCheckResult eq"2" ?"checked":""} value="2">潮红
					<input type="radio" onclick="util.clickHideText(this,'skinCheckDesc')"  name="skinCheckResult" ${examination.skinCheckResult eq"3" ?"checked":""} value="3">苍白
					<input type="radio" onclick="util.clickHideText(this,'skinCheckDesc')"  name="skinCheckResult" ${examination.skinCheckResult eq"4" ?"checked":""} value="4">发绀
					<input type="radio" onclick="util.clickHideText(this,'skinCheckDesc')"  name="skinCheckResult" ${examination.skinCheckResult eq"5" ?"checked":""} value="5">黄染
					<input type="radio" onclick="util.clickHideText(this,'skinCheckDesc')"  name="skinCheckResult" ${examination.skinCheckResult eq"6" ?"checked":""} value="6">色素沉着
					<input type="radio" id="skinCheckResult" onclick="util.clickShowText(this,'skinCheckDesc')"  name="skinCheckResult" ${examination.skinCheckResult eq"7" ?"checked":""} value="7">其他
					<input type="text" id="skinCheckDesc" class="hidediv" name="skinCheckDesc" value="${examination.skinCheckDesc}" style="width: 200px;" reg='{"dependOn":"skinCheckResult","required":"true","maxlength":"33"}'>
				</td>
			</tr>
			<tr>
				<th>巩膜</th>
				<td >
					<input type="radio"  onclick="util.clickHideText(this,'scleraCheckDesc')"   name="scleraCheckResult" ${examination.scleraCheckResult eq "1" or examination.scleraCheckResult eq null ? "checked" : ""} value="1">正常
					<input type="radio"  onclick="util.clickHideText(this,'scleraCheckDesc')"   name="scleraCheckResult" ${examination.scleraCheckResult eq"2" ?"checked":""} value="2">黄染
					<input type="radio"  onclick="util.clickHideText(this,'scleraCheckDesc')"   name="scleraCheckResult" ${examination.scleraCheckResult eq"3" ?"checked":""} value="3">充血
					<input type="radio" id="scleraCheckResult" onclick="util.clickShowText(this,'scleraCheckDesc')"   name="scleraCheckResult" ${examination.scleraCheckResult eq"4" ?"checked":""} value="4">其他
					<input type="text"  id="scleraCheckDesc" class="hidediv" name="scleraCheckDesc" value="${examination.scleraCheckDesc}"  style="width: 200px;" reg='{"dependOn":"scleraCheckResult","required":"true","maxlength":"33"}'>
				</td>
			</tr>
			<tr>
				<th>淋巴结</th>
				<td >
					<input type="radio" onclick="util.clickHideText(this,'lymphNodeCheckDesc')"  name="lymphNodeCheckResult" ${examination.lymphNodeCheckResult eq "1" or examination.lymphNodeCheckResult eq null ?"checked":""} value="1">未触及
					<input type="radio" onclick="util.clickHideText(this,'lymphNodeCheckDesc')"  name="lymphNodeCheckResult" ${examination.lymphNodeCheckResult eq"2" ?"checked":""} value="2">锁骨上
					<input type="radio" onclick="util.clickHideText(this,'lymphNodeCheckDesc')"  name="lymphNodeCheckResult" ${examination.lymphNodeCheckResult eq"3" ?"checked":""} value="3">腋窝
					<input type="radio" id="lymphNodeCheckResult" onclick="util.clickShowText(this,'lymphNodeCheckDesc')" name="lymphNodeCheckResult" ${examination.lymphNodeCheckResult eq"4" ?"checked":""} value="4">其他
					<input type="text" id="lymphNodeCheckDesc" class="hidediv"  name="lymphNodeCheckDesc" value="${examination.lymphNodeCheckDesc}" style="width: 200px;" reg='{"dependOn":"lymphNodeCheckResult","required":"true","maxlength":"33"}'>
				</td>
			</tr>
			<tr>
				<th>肺</th>
				<td >
					<table>
						<tr>
							<td style="width: 100%;">桶状胸:
								<input type="radio" name="barrelChest" ${examination.barrelChest eq "0" or examination.barrelChest eq null ? "checked" : ""} value="0">否
								<input type="radio" name="barrelChest" ${examination.barrelChest eq "1" ?"checked":""} value="1">是
							</td>
						</tr>
						<tr>
							<td>呼吸音:
								<input type="radio" onclick="util.clickHideText(this, 'lungsAnomalyDesc')" name="lungsAnomalySound" ${examination.lungsAnomalySound eq "1" or examination.lungsAnomalySound eq null ?"checked":""} value="1">正常
								<input type="radio" id="lungsAnomalySound" onclick="util.clickShowTable(this,'lungsAnomalyDesc')" name="lungsAnomalySound" ${examination.lungsAnomalySound eq"0" ?"checked":""} value="0">异常
								<input type="text" id="lungsAnomalyDesc" name="lungsAnomalyDesc" value="${examination.lungsAnomalyDesc}" CLASS="hidediv"  style="width: 150px;" reg='{"dependOn":"lungsAnomalySound","required":"true","maxlength":"33"}'>
							</td>
						</tr>
						<tr>
							<td colspan="4">啰&nbsp;&nbsp;&nbsp;音:
								<input type="radio" onclick="util.clickHideText(this, 'lungsRaleDesc')" name="lungsRaleFlag" ${examination.lungsRaleFlag eq "1" or examination.lungsRaleFlag eq null  ?"checked":""} value="1">无
								<input type="radio" onclick="util.clickHideText(this, 'lungsRaleDesc')"  name="lungsRaleFlag" ${examination.lungsRaleFlag eq"2" ?"checked":""} value="2">干啰音
								<input type="radio" onclick="util.clickHideText(this, 'lungsRaleDesc')"  name="lungsRaleFlag" ${examination.lungsRaleFlag eq"3" ?"checked":""} value="3">湿啰音
								<input type="radio" id="lungsRaleFlag" onclick="util.clickShowTable(this,'lungsRaleDesc')" name="lungsRaleFlag" ${examination.lungsRaleFlag eq"4" ?"checked":""} value="4">其他
								<input type="text" id="lungsRaleDesc" name="lungsRaleDesc" value="${examination.lungsRaleDesc}" CLASS="hidediv" style="width: 150px;" reg='{"dependOn":"lungsRaleFlag","required":"true","maxlength":"33"}'>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<th>心脏</th>
				<td >
					<table>
						<tr>
							<td>
								心率:<tag:numberInput reg="{'min':0,'max':999}" name="heartRate" value="${examination.heartRate}"  style="width: 40px;" />次/分钟
							</td>
						</tr>
						<tr>
							<td>
								心律: <ehr:dic-radio name="cardioverter" dicmeta="FS10176" value="${examination.cardioverter}"/>
							</td>
						</tr>
						<tr>
							<td>
								杂音: <input type="radio" onclick="util.clickHideText(this,'heartMurmurDesc')" name="heartMurmurFlag" ${examination.heartMurmurFlag eq "0" or examination.heartMurmurFlag eq null  ? "checked" : ""} value="0">无
								<input type="radio" id="heartMurmurFlag" onclick="util.clickShowText(this,'heartMurmurDesc')" name="heartMurmurFlag" ${examination.heartMurmurFlag eq"1" ?"checked":""} value="1">有
								<span id="heartMurmurDesc" CLASS="hidediv"> <input reg='{"dependOn":"heartMurmurFlag","required":"true","maxlength":"33"}' type="text" name="heartMurmurDesc" value="${examination.heartMurmurDesc}" style="width: 150px;">次/分钟</span>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<th>腹部</th>
				<td >
					<table>
						<tr>
							<td style="width: 100%">
								压痛:
								<input type="radio" onclick="util.clickHideText(this,'abdominalTendernessDesc')" name="abdominalTendernessFlag" ${examination.abdominalTendernessFlag eq "0" or examination.abdominalTendernessFlag eq null ? "checked" : ""} value="0"/>无
								<input type="radio" id="abdominalTendernessFlag" onclick="util.clickShowText(this,'abdominalTendernessDesc')" name="abdominalTendernessFlag" ${examination.abdominalTendernessFlag eq "1" ? "checked" : ""} value="1" />有
								<input type="text" id="abdominalTendernessDesc" name="abdominalTendernessDesc" value="${examination.abdominalTendernessDesc}" CLASS="hidediv" style="width: 150px;" reg='{"dependOn":"abdominalTendernessFlag","required":"true","maxlength":"33"}'/>
							</td>
						</tr>
						<tr>
							<td>包块:
								<input type="radio" onclick="util.clickHideText(this,'abdominalMassDesc')" name="abdominalMassFlag" ${examination.abdominalMassFlag eq "0" or examination.abdominalMassFlag eq null ? "checked" : ""} value="0">无
								<input type="radio" id="abdominalMassFlag" onclick="util.clickShowText(this,'abdominalMassDesc')" name="abdominalMassFlag" ${examination.abdominalMassFlag eq "1" ? "checked" : ""} value="1">有
								<input type="text"  id="abdominalMassDesc" name="abdominalMassDesc" value="${examination.abdominalMassDesc}" CLASS="hidediv"  style="width: 150px;" reg='{"dependOn":"abdominalMassFlag","required":"true","maxlength":"33"}'>
							</td>
						</tr>
						<tr>
							<td>肝大:
								<input type="radio" onclick="util.clickHideText(this,'liverDesc')" name="liverFlag" ${examination.liverFlag eq "0" or examination.liverFlag eq null ? "checked" : ""} value="0">无
								<input type="radio" id="liverFlag" onclick="util.clickShowText(this,'liverDesc')" name="liverFlag" ${examination.liverFlag eq "1" ? "checked" : ""} value="1">有
								<input type="text"  id="liverDesc" name="liverDesc" value="${examination.liverDesc}" CLASS="hidediv"  style="width: 150px;" reg='{"dependOn":"liverFlag","required":"true","maxlength":"33"}'>
							</td>
						</tr>
						<tr>
							<td>脾大:
								<input type="radio" onclick="util.clickHideText(this,'splenomegalyDesc')" name="splenomegalyFlag" ${examination.splenomegalyFlag eq "0" or examination.splenomegalyFlag eq null ? "checked" : ""} value="0">无
								<input type="radio" id="splenomegalyFlag" onclick="util.clickShowText(this,'splenomegalyDesc')" name="splenomegalyFlag" ${examination.splenomegalyFlag eq "1" ? "checked" : ""} value="1">有
								<input type="text"  id="splenomegalyDesc" name="splenomegalyDesc" value="${examination.splenomegalyDesc}" CLASS="hidediv"  style="width: 150px;" reg='{"dependOn":"splenomegalyFlag","required":"true","maxlength":"33"}'>
							</td>
						</tr>
						<tr>
							<td>移动性浊音:
								<input type="radio" onclick="util.clickHideText(this,'abdominalVoicedDesc')" name="abdominalVoicedFlag" ${examination.abdominalVoicedFlag eq "0" or examination.abdominalVoicedFlag eq null ? "checked" : ""} value="0">无
								<input type="radio" id="abdominalVoicedFlag" onclick="util.clickShowText(this,'abdominalVoicedDesc')" name="abdominalVoicedFlag" ${examination.abdominalVoicedFlag eq "1" ?"checked":""} value="1">有
								<input type="text" id="abdominalVoicedDesc" name="abdominalVoicedDesc" value="${examination.abdominalVoicedDesc}" CLASS="hidediv"  style="width: 150px;" reg='{"dependOn":"abdominalVoicedFlag","required":"true","maxlength":"33"}'>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<th>下肢水肿</th>
				<td >
					<ehr:dic-radio name="legsEdemaCheckResult" dicmeta="CV0410014"  value="${examination.legsEdemaCheckResult}"/>
				</td>
			</tr>
			<tr>
				<th>足背动脉搏动</th>
				<td >
					<ehr:dic-radio name="arteriopalmus" dicmeta="CV0410015" value="${examination.arteriopalmus}"/>
				</td>
			</tr>
	<tr>
                 <th>肛门指诊*</th>
                 <td colspan="3">
                     <label><input id="dreWJ" type="radio" name="dreCheckResultType" ${examination.dreCheckResultType eq "0" ? "checked" : ""} value="0" onchange="toggleOther('dreCheckResultType','dreCheckResultTypeSpan',9)"/>未检</label>
                     <ehr:dic-radio id="dre" name="dreCheckResultType" dicmeta="CV0410013" value="${examination.dreCheckResultType}" onchange="toggleOther('dreCheckResultType','dreCheckResultTypeSpan',9)"/>
                     <span style="display: none;" id="dreCheckResultTypeSpan">
					 	描述:<input reg='{"maxlength":"33"}' type="text" id="dreCheckResultDesc_inputId" name="dreCheckResultDesc" value="${examination.dreCheckResultDesc}"  style="width: 200px;"/>
					 </span>
                 </td>
             </tr>
             <tr>
                 <th>乳腺*</th>
                 <td colspan="3">
                     <label><input type="radio" id="breastAnomaly" onclick="util.clickHideTable(this,'breastAnomalySpan')" name="breastAnomalyFlag" ${examination.breastAnomalyFlag eq "2" ? "checked" : ""} value="2"/>未检</label>
                     <label><input type="radio" id="breastAnomalyZC" onclick="util.clickHideTable(this,'breastAnomalySpan')" name="breastAnomalyFlag" ${examination.breastAnomalyFlag eq "0" ?"checked":""} value="0"> 未见异常</label>
                     <label><input type="radio" id="breastAnomalyFlag" onclick="util.clickShowTable(this,'breastAnomalySpan','breastOtherDesc')" name="breastAnomalyFlag" ${examination.breastAnomalyFlag eq "1" ?"checked":""} value="1"> 有异常</label>
                     <span id="breastAnomalySpan" class="tt_hidden">
			           <label><input reg='{"extension":["breastAnomalyVali","请至少选择一项"]}'  type="checkbox" name="breastResection" ${examination.breastResection eq '1' ? 'checked' : ''} value="1" > 乳房切除 </label>
			           <label><input reg='{"extension":["breastAnomalyVali","请至少选择一项"]}'  type="checkbox" name="breastAnomalyLactation" ${examination.breastAnomalyLactation eq '1' ? 'checked' : ''} value="1"> 异常泌乳</label>
			           <label><input reg='{"extension":["breastAnomalyVali","请至少选择一项"]}'  type="checkbox" name="breastMass" ${examination.breastMass eq '1' ? 'checked' : ''} value="1"> 乳腺包块</label>
			           <label><input reg='{"extension":["breastAnomalyVali","请至少选择一项"]}'  type="checkbox" id="breastOther" onclick="util.clickShowText(this,'breastOtherDesc')" name="breastOther" ${examination.breastOther eq '1' ? 'checked' : ''} value="1"> 其他</label>
			           <input type="text" reg='{"dependOn":"breastOther","maxlength":"33"}' id="breastOtherDesc" name="breastOtherDesc" value="${examination.breastOtherDesc}" CLASS="hidediv"  style="width: 200px;"/>
			       </span>
                   </td>
               </tr>
               <c:if test="${isWoman}">
                   <tr>
                       <th>妇科*</th>
                       <td colspan="3">
                           <table>
                               <tr>
                                   <td title="记录发育情况及婚产式（未婚、已婚未产或经产式）,如有异常情况请具体描述。">外阴&nbsp;&nbsp;
                                       <label><input type="radio" id="vulvaAnomaly" onclick="util.clickHideText(this,'vulvaAnomalyDesc')" name="vulvaAnomalyFlag" ${examination.vulvaAnomalyFlag eq "2" ? "checked" : ""} value="2"/>未检</label>
                                       <label><input type="radio" id="vulvaAnomalyZC" onclick="util.clickHideText(this,'vulvaAnomalyDesc')" name="vulvaAnomalyFlag" ${examination.vulvaAnomalyFlag eq "0" ? "checked" : ""} value="0"> 未见异常</label>
                                       <label><input type="radio" id="vulvaAnomalyFlag" onclick="util.clickShowText(this,'vulvaAnomalyDesc')" name="vulvaAnomalyFlag" ${examination.vulvaAnomalyFlag eq "1" ? "checked" : ""} value="1"> 有异常</label>
                                       <input reg='{"maxlength":"33"}' type="text" id="vulvaAnomalyDesc" name="vulvaAnomalyDesc" value="${examination.vulvaAnomalyDesc}" CLASS="hidediv"  style="width: 200px;" reg='{"dependOn":"vulvaAnomalyFlag","required":"true"}'>
                                   </td>
                               </tr>
                               <tr>
                                   <td title="记录是否通畅,黏膜情况,分泌物量、色、性状一级有无异味等。">阴道&nbsp;&nbsp;
                                       <label><input type="radio" id="vaginaAnomaly" onclick="util.clickHideText(this,'vaginaAnomalyDesc')" name="vaginaAnomalyFlag" ${examination.vaginaAnomalyFlag eq "2" ? "checked" : ""} value="2"/>未检</label>
                                       <label><input type="radio" id="vaginaAnomalyZC" onclick="util.clickHideText(this,'vaginaAnomalyDesc')" name="vaginaAnomalyFlag" ${examination.vaginaAnomalyFlag eq "0" ? "checked" : ""} value="0"> 未见异常</label>
                                       <label><input type="radio" id="vaginaAnomalyFlag" onclick="util.clickShowText(this,'vaginaAnomalyDesc')" name="vaginaAnomalyFlag" ${examination.vaginaAnomalyFlag eq"1" ?"checked":""} value="1"> 有异常</label>
                                       <input reg='{"maxlength":"33"}' type="text" id="vaginaAnomalyDesc" name="vaginaAnomalyDesc" value="${examination.vaginaAnomalyDesc}" CLASS="hidediv" style="width: 200px;" reg='{"dependOn":"vaginaAnomalyFlag","required":"true"}'>
                                   </td>
                               </tr>
                               <tr>
                                   <td title="记录大小、质地、有无糜烂、撕裂、息肉、腺囊肿;有无接触性出血、举痛等。">宫颈&nbsp;&nbsp;
                                       <label><input type="radio" id="cervicalAnomaly" onclick="util.clickHideText(this,'cervicalAnomalyDesc')" name="cervicalAnomalyFlag" ${examination.cervicalAnomalyFlag eq "2" ? "checked" : ""} value="2"/>未检</label>
                                       <label><input type="radio" id="cervicalAnomalyZC" onclick="util.clickHideText(this,'cervicalAnomalyDesc')" name="cervicalAnomalyFlag" ${examination.cervicalAnomalyFlag eq "0" ? "checked" : ""} value="0"> 未见异常</label>
                                       <label><input type="radio" id="cervicalAnomalyFlag" onclick="util.clickShowText(this,'cervicalAnomalyDesc')" name="cervicalAnomalyFlag" ${examination.cervicalAnomalyFlag eq "1" ? "checked" : ""} value="1"> 有异常</label>
                                       <input reg='{"maxlength":"33"}' type="text" id="cervicalAnomalyDesc" name="cervicalAnomalyDesc" value="${examination.cervicalAnomalyDesc}" CLASS="hidediv" style="width: 200px;" reg='{"dependOn":"cervicalAnomalyFlag","required":"true"}'>
                                   </td>
                               </tr>
                               <tr>
                                   <td title="记录位置、大小、质地、活动度;有无压痛等。">宫体&nbsp;&nbsp;
                                       <label><input type="radio" id="corpusAnomaly" onclick="util.clickHideText(this,'corpusAnomalyDesc')" name="corpusAnomalyFlag" ${examination.corpusAnomalyFlag eq "2" ? "checked" : ""} value="2"/>未检</label>
                                       <label><input type="radio" id="corpusAnomalyZC" onclick="util.clickHideText(this,'corpusAnomalyDesc')" name="corpusAnomalyFlag" ${examination.corpusAnomalyFlag eq "0" ? "checked" : ""} value="0"> 未见异常</label>
                                       <label><input type="radio" id="corpusAnomalyFlag" onclick="util.clickShowText(this,'corpusAnomalyDesc')" name="corpusAnomalyFlag" ${examination.corpusAnomalyFlag eq"1" ? "checked" : ""} value="1"> 有异常</label>
                                       <input reg='{"maxlength":"33"}' type="text" id="corpusAnomalyDesc" name="corpusAnomalyDesc" value="${examination.corpusAnomalyDesc}" CLASS="hidediv" style="width: 200px;" reg='{"dependOn":"corpusAnomalyFlag","required":"true"}'>
                                   </td>
                               </tr>
                               <tr>
                                   <td title="记录位置、大小、质地、活动度;有无压痛等。">附件&nbsp;&nbsp;
                                       <label><input type="radio" id="accessoriesAnomaly" onclick="util.clickHideText(this,'accessoriesAnomalyDesc')" name="accessoriesAnomalyFlag" ${examination.accessoriesAnomalyFlag eq "2" ? "checked" : ""} value="2"/>未检</label>
                                       <label><input type="radio" id="accessoriesAnomalyZC" onclick="util.clickHideText(this,'accessoriesAnomalyDesc')" name="accessoriesAnomalyFlag" ${examination.accessoriesAnomalyFlag eq "0" ? "checked" : ""} value="0"> 未见异常</label>
                                       <label><input type="radio" id="accessoriesAnomalyFlag" onclick="util.clickShowText(this,'accessoriesAnomalyDesc')" name="accessoriesAnomalyFlag" ${examination.accessoriesAnomalyFlag eq"1" ?"checked":""} value="1"> 有异常</label>
                                       <input reg='{"maxlength":"33"}' type="text" id="accessoriesAnomalyDesc" name="accessoriesAnomalyDesc" value="${examination.accessoriesAnomalyDesc}" CLASS="hidediv" style="width: 200px;" reg='{"dependOn":"accessoriesAnomalyFlag","required":"true"}'>
                                   </td>
                               </tr>
                           </table>
                       </td>
                   </tr>
               </c:if>
               <tr>
                   <th>其他*</th>
                   <td>
                       <input reg='{"maxlength":"33"}' type="text" name="otherCheckResult" value="${examination.otherCheckResult}" style="width: 200px;">
                   </td>
               </tr>

		</table>
	</fieldset>
</div>
<div class="postdiv">
	<fieldset class="layui-elem-field">
		<legend>辅助检查</legend>
		<table class="posttable">
			<colgroup>
				<col style="width:15%">
				<col style="width:85%">
			</colgroup>
			<tr>
				<th style="width: 16%">血常规*</th>
				<td>
					血红蛋白<tag:numberInput reg="{'min':0,'max':9999}" name="hemoglobinValue" value="${examination.hemoglobinValue}" style="width: 40px;"/>g/L
					&nbsp;&nbsp;&nbsp;&nbsp;
					白细胞<tag:numberInput reg="{'min':0,'max':999.9}" point="point"  name="leukocyteCount" value="${examination.leukocyteCount}"  style="width: 40px;" /> ×10<sup>9</sup>/L
					&nbsp;&nbsp;&nbsp;&nbsp;
					血小板<tag:numberInput reg="{'min':0,'max':9999}" name="plateletCount" value="${examination.plateletCount}"  style="width: 40px;" /> ×10<sup>9</sup>/L
					&nbsp;&nbsp;&nbsp;&nbsp;
					其他&nbsp;&nbsp;<input reg='{"maxlength":"33"}' type="text" name="bloodRoutineOtherDesc" value="${examination.bloodRoutineOtherDesc}"  style="width: 100px;"/>
				</td>
			</tr>
			<tr>
				<th>尿常规*</th>
				<td>
					尿蛋白<input type="text" reg='{"maxlength":"50"}' name="urineProQuantitativeValue" value="${examination.urineProQuantitativeValue}"  style="width: 80px;"/>
					&nbsp;&nbsp;
					尿糖<input type="text" reg='{"maxlength":"50"}' name="urineSugQuantitativeValue" value="${examination.urineSugQuantitativeValue}" style="width: 80px;"/>
					&nbsp;&nbsp;
					尿酮体<input type="text" reg='{"maxlength":"50"}'  name="ketQuantitativeValue" value="${examination.ketQuantitativeValue}"  style="width: 80px;" />
					&nbsp;&nbsp;
					尿潜血<input type="text" reg='{"maxlength":"50"}' name="eryQuantitativeValue" value="${examination.eryQuantitativeValue}"  style="width: 80px;"/>
					&nbsp;&nbsp;
					其他<input type="text" reg='{"maxlength":"100"}' name="urineRoutinesOtherDesc" value="${examination.urineRoutinesOtherDesc}"  style="width: 150px;"/>
				</td>
			</tr>
			<tr>
				<th>空腹血糖*</th>
				<td>
					<tag:numberInput point="point" reg='{"max":"999.9","scale":"2","regex":"number"}' name="fpgMmol" value="${examination.fpgMmol}"  style="width: 40px;"/>mmol/L
					或
					<tag:numberInput point="point" reg='{"max":"999.9","scale":"2","regex":"number"}'  name="fpgMg" value="${examination.fpgMg}"  style="width: 40px;" />mg/dL
				</td>
			</tr>
			<tr id="bloodSugarSource" style="display: none">
				<th>
					<label >来源</label></th>
				<td>
					<%--<label><input type="radio" name="bloodSugarSource"  value="1"
					${examination.bloodSugarSource eq 1 ? "checked" : "" }  reg="{'required':'true'}"/> 单位体检</label>
					<label><input type="radio" name="bloodSugarSource"  value="2"
					${examination.bloodSugarSource eq 2 ? "checked" : ""}  reg="{'required':'true'}"/> 其他医院</label>--%>
					<%--<label><input type="radio" name="bloodSugarSource" value="3"
					${examination.bloodSugarSource eq 3 ? "checked" : ""}  reg="{'required':'true'}"/> 个人提供</label>--%>
                    <ehr:dic-radio dicmeta="TFJKDA001" name="bloodSugarSource" value="${examination.bloodSugarSource}"
                                   reg="{'required':true}"/>
				</td>
			</tr>
			<tr>
				<th>心电图*</th>
				<td>
					<input type="radio" onclick="util.clickHideText(this,'ecgAnomalyDesc')" name="ecgAnomalyFlag" ${examination.ecgAnomalyFlag eq "2" ? "checked" : ""} value="2"> 未检
					<input type="radio" onclick="util.clickHideText(this,'ecgAnomalyDesc')" name="ecgAnomalyFlag" ${examination.ecgAnomalyFlag eq "0" or examination.ecgAnomalyFlag eq null ? "checked" : ""} value="0"> 正常
					<input type="radio" id="ecgAnomalyFlag" onclick="util.clickShowText(this,'ecgAnomalyDesc')" name="ecgAnomalyFlag" ${examination.ecgAnomalyFlag eq"1" ?"checked":""} value="1"> 异常
					<input type="text" id="ecgAnomalyDesc" name="ecgAnomalyDesc" value="${examination.ecgAnomalyDesc}" CLASS="hidediv" style="width: 700px;" reg='{"dependOn":"ecgAnomalyFlag","required":"true","maxlength":"50"}'>
				</td>
			</tr>
			<tr>
				<th>尿微量白蛋白*</th>
				<td>
					<tag:numberInput point="point" reg="{'min':0,'max':9999.9}" name="urineMicroTongAlbumin" value="${examination.urineMicroTongAlbumin}"  style="width: 40px;"/>mg/dL
				</td>
			</tr>
			<tr>
				<th>大便潜血*</th>
				<td>
					<label><input type="radio" name="fecalOccultBlood" ${examination.fecalOccultBlood eq "0" ? "checked" : ""} value="0"/>未检</label>
					<ehr:dic-radio name="fecalOccultBlood" value="${examination.fecalOccultBlood }" dicmeta="FS10058"/>
				</td>
			</tr>
			<tr>
				<th>糖化血红蛋白*</th>
				<td>
					<tag:numberInput  point="point" reg='{"max":"99.99","scale":"2","regex":"number"}' name="hgb" value="${examination.hgb}"  style="width: 40px;" />%
				</td>
			</tr>
			<tr>
				<th>乙型肝炎表面抗原*</th>
				<td>
					<label><input type="radio" name="hbsagDetectResult" ${examination.hbsagDetectResult eq "0" ? "checked" : ""} value="0"/>未检</label>
					<ehr:dic-radio name="hbsagDetectResult" value="${examination.hbsagDetectResult }" dicmeta="FS10058"/>
				</td>
			</tr>
			<tr>
				<th>肝功能*</th>
				<td>
					血清谷丙转氨酶 <tag:numberInput point="point" reg="{'min':0,'max':999.99}"  name="serumGptValue" value="${examination.serumGptValue}" style="width: 80px;" />U/L
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					血清谷草转氨酶 <tag:numberInput point="point" reg="{'min':0,'max':999.99}"  name="serumAstValue" value="${examination.serumAstValue}"  style="width: 80px;" />U/L
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					白蛋白浓度  <tag:numberInput point="point" reg="{'min':0,'max':999.99}"  name="albuminConcentration" value="${examination.albuminConcentration}"  style="width: 80px;"  />g/L
					<br>
					总胆红素  <tag:numberInput point="point" reg="{'min':0,'max':999.9}"  name="totalBilirubin" value="${examination.totalBilirubin}" style="width: 80px;" />μmol/L
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					结合胆红素  <%--<tag:numberInput point="point" reg="{'min':0,'max':9999.9}"  name="conjugatedBilirubin" value="${examination.conjugatedBilirubin}"  style="width: 80px;" />--%>
					<input type="text" name="conjugatedBilirubin" value="${examination.conjugatedBilirubin}"  style="width: 80px;" />μmol/L
				</td>
			</tr>
			<tr>
				<th>肾功能*</th>
				<td>
					血清肌酐 <tag:numberInput point="point" reg="{'min':0,'max':99.9}"  name="creatinine" value="${examination.creatinine}"  style="width: 80px;" />μmol/L
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					血尿素氮 <tag:numberInput point="point" reg="{'min':0,'max':999.9}"  name="bloodUreaNitrogenValue" value="${examination.bloodUreaNitrogenValue}" style="width: 80px;" />mmol/L
					<br>
					血钾浓度  <tag:numberInput point="point"  reg="{'min':0,'max':999.9}" name="potassiumConcentration" value="${examination.potassiumConcentration}"  style="width: 80px;" />mmol/L
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					血钠浓度  <tag:numberInput  reg="{'min':0,'max':9999}"  name="sodiumConcentration" value="${examination.sodiumConcentration}" style="width: 80px;"  />mmol/L
				</td>
			</tr>
			<tr>
				<th>血脂*</th>
				<td >
					总胆固醇 <tag:numberInput point="point" reg="{'min':0,'max':999.99}" name="tc" value="${examination.tc}" style="width: 80px;" />mmol/L
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					甘油三酯 <tag:numberInput point="point" reg="{'min':0,'max':99.9}" name="triglycerideValue" value="${examination.triglycerideValue}"  style="width: 80px;"  />mmol/L
					<br>
					血清低密度脂蛋白胆固醇 <tag:numberInput reg="{'min':0,'max':999.99}" point="point" name="ldlcDetectValue" value="${examination.ldlcDetectValue}"  style="width: 80px;" />mmol/L
					<br>
					血清高密度脂蛋白胆固醇  <tag:numberInput reg="{'min':0,'max':999.99}" point="point" name="hdlcDetectValue" value="${examination.hdlcDetectValue}" style="width: 80px;" />mmol/L
				</td>
			</tr>
			<tr>
				<th>胸部X线片*</th>
				<td>
					<label><input type="radio" onclick="util.clickHideText(this,'chestXAnomalyfDesc')" name="chestXAnomalyfFlag" value="2" ${examination.chestXAnomalyfFlag eq "2" ? "checked" : ""}/>未检</label>
					<label><input type="radio" onclick="util.clickHideText(this,'chestXAnomalyfDesc')" name="chestXAnomalyfFlag" ${examination.chestXAnomalyfFlag eq "0" ?"checked":""} value="0"> 正常</label>
					<label><input type="radio" id="chestXAnomalyfFlag" onclick="util.clickShowText(this,'chestXAnomalyfDesc')" name="chestXAnomalyfFlag" ${examination.chestXAnomalyfFlag eq"1" ?"checked":""} value="1"> 异常</label>
					<input type="text" id="chestXAnomalyfDesc" name="chestXAnomalyfDesc" value="${examination.chestXAnomalyfDesc}" CLASS="hidediv" style="width: 200px;"  reg='{"dependOn":"chestXAnomalyfFlag","required":"true","maxlength":"33"}'>
				</td>
			</tr>
			<tr>
				<th>B超*</th>
				<td id="BUltrason">
					腹部B超
					<label><input type="radio"
								  onclick="util.clickHideText(this,'bmodeAnomalyfDesc')"
								  name="bmodeAnomalyfFlag"
								  value="2" ${examination.bmodeAnomalyfFlag eq "2" ? "checked" : ""}/>未检</label>
					<label><input type="radio"
								  onclick="util.clickHideText(this,'bmodeAnomalyfDesc')"
								  name="bmodeAnomalyfFlag" ${examination.bmodeAnomalyfFlag eq "0" ?"checked":""}
								  value="0"> 正常</label>
					<label><input type="radio" id="bmodeAnomalyfFlag"
								  onclick="util.clickShowText(this,'bmodeAnomalyfDesc')"
								  name="bmodeAnomalyfFlag" ${examination.bmodeAnomalyfFlag eq"1" ?"checked":""}
								  value="1"> 异常</label><br>
					<input type="text" id="bmodeAnomalyfDesc" name="bmodeAnomalyfDesc"
						   title="${examination.bmodeAnomalyfDesc}"
						   value="${examination.bmodeAnomalyfDesc}"
						   style="width: 650px;"
						   reg='{"maxlength":"100"}'>
					<br>
					其他B超
					<label><input type="radio"
								  onclick="util.clickHideText(this,'bmodeOtherAnomalyfDesc')"
								  name="bmodeOtherAnomalyfFlag"
								  value="2" ${examination.bmodeOtherAnomalyfFlag eq "2" ? "checked" : ""}/>未检</label>
					<label><input type="radio"
								  onclick="util.clickHideText(this,'bmodeOtherAnomalyfDesc')"
								  name="bmodeOtherAnomalyfFlag" ${examination.bmodeOtherAnomalyfFlag eq "0" ?"checked":""}
								  value="0"> 正常</label>
					<label><input type="radio"
								  onclick="util.clickShowText(this,'bmodeOtherAnomalyfDesc')"
								  id="bmodeOtherAnomalyfFlag"
								  name="bmodeOtherAnomalyfFlag" ${examination.bmodeOtherAnomalyfFlag eq"1" ?"checked":""}
								  value="1"> 异常</label><br>
					<input type="text" id="bmodeOtherAnomalyfDesc" name="bmodeOtherAnomalyfDesc"
						   value="${examination.bmodeOtherAnomalyfDesc}"
						   title="${examination.bmodeOtherAnomalyfDesc}"
						   style="width: 650px;"
						   reg='{"maxlength":"100"}'>
				</td>
			</tr>
			<c:if test="${isWoman}">
				<tr>
					<th>宫颈涂片*</th>
					<td>
						<label><input type="radio" onclick="util.clickHideText(this,'cervicalSmearAnomalyfDesc')" name="cervicalSmearAnomalyfFlag" value="2" ${examination.cervicalSmearAnomalyfFlag eq "2" ? "checked" : ""}/>未检</label>
						<label><input type="radio" onclick="util.clickHideText(this,'cervicalSmearAnomalyfDesc')" name="cervicalSmearAnomalyfFlag" ${examination.cervicalSmearAnomalyfFlag eq "0" ?" checked" : ""} value="0"> 正常</label>
						<label><input type="radio" id="cervicalSmearAnomalyfFlag" onclick="util.clickShowText(this,'cervicalSmearAnomalyfDesc')"name="cervicalSmearAnomalyfFlag" ${examination.cervicalSmearAnomalyfFlag eq"1" ? "checked" : ""} value="1"> 异常</label>
						<input type="text" id="cervicalSmearAnomalyfDesc" name="cervicalSmearAnomalyfDesc" value="${examination.cervicalSmearAnomalyfDesc}" CLASS="hidediv"  style="width: 200px;" reg='{"dependOn":"cervicalSmearAnomalyfFlag","required":"true","maxlength":"33"}'>
					</td>
				</tr>
			</c:if>
			<tr>
				<th>其他*</th>
				<td>
					<input type="text" reg='{"maxlength":"33"}' name="otherAuxiliaryExamination" value="${examination.otherAuxiliaryExamination}" style="width: 200px;" />
				</td>
			</tr>
		</table>
	</fieldset>
</div>

<div class="postdiv">
	<fieldset class="layui-elem-field">
		<legend>中医体质辨识</legend>
		<table class="posttable" id="CMedicine">
			<tr>
				<input type="hidden" value="${isElder}" id="idElder"/>
				<th style="width: 16%">平和质</th>
				<td>
					<ehr:dic-radio name="tcmPeacefulQuality" dicmeta="FS10186" code="1,2,0" value="${examination.tcmPeacefulQuality}"/>
				</td>
			</tr>
			<tr>
				<th>气虚质</th>
				<td>
					<ehr:dic-radio name="tcmQiQuality" dicmeta="FS10186" code="1,3,0" value="${examination.tcmQiQuality}"/>
				</td>
			</tr>
			<tr>
				<th>阳虚质</th>
				<td>
					<ehr:dic-radio name="tcmYangQuality" dicmeta="FS10186" code="1,3,0" value="${examination.tcmYangQuality}"/>
				</td>
			</tr>
			<tr>
				<th>阴虚质</th>
				<td>
					<ehr:dic-radio name="tcmYinDeficiency" dicmeta="FS10186" code="1,3,0" value="${examination.tcmYinDeficiency}"/>
				</td>
			</tr>
			<tr>
				<th>痰湿质</th>
				<td>
					<ehr:dic-radio name="tcmPhlegmWetness" dicmeta="FS10186" code="1,3,0" value="${examination.tcmPhlegmWetness}"/>
				</td>
			</tr>
			<tr>
				<th>湿热质</th>
				<td>
					<ehr:dic-radio name="tcmHeatMedium" dicmeta="FS10186" code="1,3,0" value="${examination.tcmHeatMedium}"/>
				</td>
			</tr>
			<tr>
				<th>血瘀质</th>
				<td>
					<ehr:dic-radio name="tcmBloodQuality" dicmeta="FS10186" code="1,3,0" value="${examination.tcmBloodQuality}"/>
				</td>
			</tr>
			<tr>
				<th>气郁质</th>
				<td>
					<ehr:dic-radio name="tcmQiStagnation" dicmeta="FS10186" code="1,3,0" value="${examination.tcmQiStagnation}"/>
				</td>
			</tr>
			<tr>
				<th>特秉质</th>
				<td>
					<ehr:dic-radio name="tcmSpecialQuality" dicmeta="FS10186" code="1,3,0" value="${examination.tcmSpecialQuality}"/>
				</td>
			</tr>
		</table>

	</fieldset>
</div>
<c:if test="${hbpFlag eq '2'}">
	<div class="postdiv">
		<fieldset>
			<legend>高血压中医药健康管理</legend>
			<table class="posttable">
				<colgroup>
					<col style="width: 15%">
					<col style="width: 15%">
					<col style="width: 10%">
					<col style="width: 60%">
				</colgroup>
				<tr>
					<th style="width: 16%">阴虚阳亢证</th>
					<td>
						<ehr:dic-radio  name="hyinEmptyYangHyper" dicmeta="FS10186" code="1,0" value="${examination.hyinEmptyYangHyper}"/>
					</td>
					<c:if test="${not empty examination.hyinEmptyYangHyperChg}">
						<td style="text-align: right">中医健康指导：</td>
						<td style="text-align: left">
							<ehr:dic  dicmeta="CHG10509" code="${examination.hyinEmptyYangHyperChg}"></ehr:dic>
							<c:forEach   items="${examination.hyinEmptyYangHyperChg}" var="ex">
								<c:if  test="${ex == '99'}">
									：${examination.hyinEmptyYangHyperDesc}
								</c:if>
							</c:forEach>
						</td>
					</c:if>
				</tr>
				<tr>
					<th>气血两虚证</th>
					<td>
						<ehr:dic-radio  name="hqiBloodEmpty" dicmeta="FS10186" code="1,0" value="${examination.hqiBloodEmpty}"/>
					</td>
					<c:if test="${not empty examination.hqiBloodEmptyChg}">
						<td style="text-align: right">中医健康指导：</td>
						<td style="text-align: left">
							<ehr:dic  dicmeta="CHG10509" code="${examination.hqiBloodEmptyChg}"></ehr:dic>
							<c:forEach   items="${examination.hqiBloodEmptyChg}" var="ex">
								<c:if  test="${ex == '99'}">
									：${examination.hqiBloodEmptyDesc}
								</c:if>
							</c:forEach>
						</td>
					</c:if>
				</tr>
				<tr>
					<th>痰瘀互结证</th>
					<td>
						<ehr:dic-radio  name="hphlegmBloodStasis" dicmeta="FS10186" code="1,0" value="${examination.hphlegmBloodStasis}"/>
					</td>
					<c:if test="${not empty examination.hphlegmBloodStasisChg}">
						<td style="text-align: right">中医健康指导：</td>
						<td style="text-align: left">
							<ehr:dic  dicmeta="CHG10509" code="${examination.hphlegmBloodStasisChg}"></ehr:dic>
							<c:forEach   items="${examination.hphlegmBloodStasisChg}" var="ex">
								<c:if  test="${ex == '99'}">
									：${examination.hphlegmBloodStasisDesc}
								</c:if>
							</c:forEach>
						</td>
					</c:if>
				</tr>
				<tr>
					<th>肾精不足证</th>
					<td>
						<ehr:dic-radio  name="hspermDeficiency" dicmeta="FS10186" code="1,0" value="${examination.hspermDeficiency}"/>
					</td>
					<c:if test="${not empty examination.hspermDeficiencyChg}">
						<td style="text-align: right">中医健康指导：</td>
						<td style="text-align: left">
							<ehr:dic  dicmeta="CHG10509" code="${examination.hspermDeficiencyChg}"></ehr:dic>
							<c:forEach   items="${examination.hspermDeficiencyChg}" var="ex">
								<c:if  test="${ex == '99'}">
									：${examination.hspermDeficiencyDesc}
								</c:if>
							</c:forEach>
						</td>
					</c:if>
				</tr>
				<tr>
					<th>肾阳亏虚证</th>
					<td>
						<ehr:dic-radio  name="hyangEmpty" dicmeta="FS10186" code="1,0" value="${examination.hyangEmpty}"/>
					</td>
					<c:if test="${not empty examination.hyangEmptyChg}">
						<td style="text-align: right">中医健康指导：</td>
						<td style="text-align: left">
							<ehr:dic  dicmeta="CHG10509" code="${examination.hyangEmptyChg}"></ehr:dic>
							<c:forEach   items="${examination.hyangEmptyChg}" var="ex">
								<c:if  test="${ex == '99'}">
									：${examination.hyangEmptyDesc}
								</c:if>
							</c:forEach>
						</td>
					</c:if>
				</tr>
				<tr>
					<th>冲任失调证</th>
					<td>
						<ehr:dic-radio  name="hanOffset" dicmeta="FS10186" code="1,0" value="${examination.hanOffset}"/>
					</td>
					<c:if test="${not empty examination.hanOffsetChg}">
						<td style="text-align: right">中医健康指导：</td>
						<td style="text-align: left">
							<ehr:dic  dicmeta="CHG10509" code="${examination.hanOffsetChg}"></ehr:dic>
							<c:forEach   items="${examination.hanOffsetChg}" var="ex">
								<c:if  test="${ex == '99'}">
									：${examination.hanOffsetDesc}
								</c:if>
							</c:forEach>
						</td>
					</c:if>
				</tr>
			</table>
		</fieldset>
	</div>
</c:if>
<c:if test="${diFlag eq '2'}">
	<div class="postdiv">
		<fieldset>
			<legend>糖尿病中医药健康管理</legend>
			<table class="posttable">
				<colgroup>
					<col style="width: 15%">
					<col style="width: 15%">
					<col style="width: 10%">
					<col style="width: 60%">
				</colgroup>
				<tr>
					<th style="width: 16%">阴虚燥热证</th>
					<td>
						<ehr:dic-radio  name="dyinEmptyHot" dicmeta="FS10186" code="1,0" value="${examination.dyinEmptyHot}"/>
					</td>
					<c:if test="${not empty examination.dyinEmptyHotChg}">
						<td style="text-align: right">中医健康指导：</td>
						<td style="text-align: left">
							<ehr:dic  dicmeta="CHG10509" code="${examination.dyinEmptyHotChg}"></ehr:dic>
							<c:forEach   items="${examination.dyinEmptyHotChg}" var="ex">
								<c:if  test="${ex == '99'}">
									：${examination.dyinEmptyHotDesc}
								</c:if>
							</c:forEach>
						</td>
					</c:if>
				</tr>
				<tr>
					<th style="width: 16%">气阴两虚证</th>
					<td>
						<ehr:dic-radio  name="dqiYinEmpty" dicmeta="FS10186" code="1,0" value="${examination.dqiYinEmpty}"/>
					</td>
					<c:if test="${not empty examination.dqiYinEmptyChg}">
						<td style="text-align: right">中医健康指导：</td>
						<td style="text-align: left">
							<ehr:dic  dicmeta="CHG10509" code="${examination.dqiYinEmptyChg}"></ehr:dic>
							<c:forEach   items="${examination.dqiYinEmptyChg}" var="ex">
								<c:if  test="${ex == '99'}">
									：${examination.dqiYinEmptyDesc}
								</c:if>
							</c:forEach>
						</td>
					</c:if>
				</tr>
				<tr>
					<th style="width: 16%">阴阳两虚证</th>
					<td>
						<ehr:dic-radio  name="dyinYangEmpty" dicmeta="FS10186" code="1,0" value="${examination.dyinYangEmpty}"/>
					</td>
					<c:if test="${not empty examination.dyinYangEmptyChg}">
						<td style="text-align: right">中医健康指导：</td>
						<td style="text-align: left">
							<ehr:dic  dicmeta="CHG10509" code="${examination.dyinYangEmptyChg}"></ehr:dic>
							<c:forEach   items="${examination.dyinYangEmptyChg}" var="ex">
								<c:if  test="${ex == '99'}">
									：${examination.dyinYangEmptyDesc}
								</c:if>
							</c:forEach>
						</td>
					</c:if>
				</tr>
			</table>
		</fieldset>
	</div>
</c:if>
<div class="postdiv">
	<fieldset class="layui-elem-field">
		<legend>现存主要健康问题</legend>
		<table class="posttable">
			<colgroup>
				<col style="width:15%">
				<col style="width:85%">
			</colgroup>
			<tr>
				<th style="width: 16%">脑血管疾病</th>
				<td>
					<input type="radio" onclick="util.clickHideTable(this,'cvascularDiv')" name="cvascularFlag" ${examination.cvascularFlag eq "0" or examination.cvascularFlag eq null ?"checked":""} value="0"> 未发现
					<input type="radio" id="cvascularFlag" onclick="util.clickShowTable(this,'cvascularDiv','cvascularOtherDesc')" name="cvascularFlag" ${examination.cvascularFlag eq"1" ?"checked":""} value="1"> 已发现
					<span id="cvascularDiv" class="tt_hidden">
			            <input type="checkbox" name="cvascularHemorrhageStroke" ${examination.cvascularHemorrhageStroke eq '1' ? 'checked':''} value="1"> 缺血性卒中
			            <input type="checkbox" name="cvascularHemorrhage" ${examination.cvascularHemorrhage eq '1' ? 'checked':''} value="1"> 脑出血
			            <input type="checkbox" name="cvascularSah" ${examination.cvascularSah eq '1' ? 'checked':''} value="1"> 蛛网膜下腔出血
			            <input type="checkbox" name="covascularTransientIschemic" ${examination.covascularTransientIschemic eq '1' ? 'checked':''} value="1"> 短暂性脑缺血发作
			            <input type="checkbox" id="covascularOther" onclick="util.clickShowText(this,'cvascularOtherDesc')" name="covascularOther" ${examination.covascularOther eq '1' ? 'checked':''} value="1"> 其他
			            <input type="text" id="cvascularOtherDesc" name="cvascularOtherDesc" value="${examination.cvascularOtherDesc}" CLASS="hidediv" style="width: 150px;" reg='{"dependOn":"covascularOther","required":"true","maxlength":"33"}'>
			        </span>
				</td>
			</tr>
			<tr>
				<th>肾脏疾病</th>
				<td>
					<input type="radio" onclick="util.clickHideTable(this,'kidneyDiseaseDiv')" name="kidneyDiseaseFlag" ${examination.kidneyDiseaseFlag eq "0"  or examination.kidneyDiseaseFlag eq null ?"checked":""} value="0"> 未发现
					<input type="radio" id="kidneyDiseaseFlag" onclick="util.clickShowTable(this,'kidneyDiseaseDiv','kidneyOtherDesc')" name="kidneyDiseaseFlag" ${examination.kidneyDiseaseFlag eq"1" ?"checked":""} value="1"> 已发现
					<span id="kidneyDiseaseDiv" class="tt_hidden">
			            <input type="checkbox" name="kidneyDiabeticNephropathy" ${examination.kidneyDiabeticNephropathy eq '1' ? 'checked':''} value="1"> 糖尿病肾病
			            <input type="checkbox" name="kidneyRenalFailure" ${examination.kidneyRenalFailure eq '1' ? 'checked':''} value="1"> 肾功能衰竭
			            <input type="checkbox" name="kidneyAcuteNephritis" ${examination.kidneyAcuteNephritis eq '1' ? 'checked':''} value="1"> 急性肾炎
			            <input type="checkbox" name="kidneyChronicNephritis" ${examination.kidneyChronicNephritis eq '1' ? 'checked':''} value="1"> 慢性肾炎
			            <input type="checkbox" id="kidneyOther" onclick="util.clickShowText(this,'kidneyOtherDesc')" name="kidneyOther" ${examination.kidneyOther eq '1' ? 'checked':''} value="1"> 其他
			            <input type="text" id="kidneyOtherDesc" name="kidneyOtherDesc" value="${examination.kidneyOtherDesc}" CLASS="hidediv" style="width: 150px;"  reg='{"dependOn":"kidneyOther","required":"true","maxlength":"33"}'>
			        </span>
				</td>
			</tr>
			<tr>
				<th>心脏疾病</th>
				<td>
					<input type="radio" onclick="util.clickHideTable(this,'heartDiseaseDiv')" name="heartDiseaseFlag" ${examination.heartDiseaseFlag eq "0" or examination.heartDiseaseFlag eq null ?"checked":""} value="0"> 未发现
					<input type="radio" id="heartDiseaseFlag" onclick="util.clickShowTable(this,'heartDiseaseDiv','heartOtherDesc')" name="heartDiseaseFlag" ${examination.heartDiseaseFlag eq"1" ?"checked":""} value="1"> 已发现
					<span id="heartDiseaseDiv" class="tt_hidden">
			            <input type="checkbox" name="heartMiocardialInfarction" ${examination.heartMiocardialInfarction eq '1' ? 'checked':''} value="1"> 心肌梗死
			            <input type="checkbox" name="heartAnginaPectoris" ${examination.heartAnginaPectoris eq '1' ? 'checked':''} value="1"> 心绞痛
			            <input type="checkbox" name="heartCoronary" ${examination.heartCoronary eq '1' ? 'checked':''} value="1"> 冠状动脉血运重建
			            <input type="checkbox" name="heartCongestiveHeart" ${examination.heartCongestiveHeart eq '1' ? 'checked':''} value="1"> 充血性心力衰竭
			            <input type="checkbox" name="heartPrecordialPain" ${examination.heartPrecordialPain eq '1' ? 'checked':''} value="1"> 心前区疼痛
			            <input type="checkbox" id="heartOther" onclick="util.clickShowText(this,'heartOtherDesc')" name="heartOther" ${examination.heartOther eq '1' ? 'checked':''} value="1"> 其他
			            <input type="text" id="heartOtherDesc" name="heartOtherDesc" value="${examination.heartOtherDesc}" CLASS="hidediv" style="width: 100px;"  reg='{"dependOn":"heartOther","required":"true","maxlength":"33"}'>
			         </span>
				</td>
			</tr>
			<tr>
				<th>血管疾病</th>
				<td>
					<input type="radio" onclick="util.clickHideTable(this,'arteryDiseaseDiv')" name="arteryDiseaseFlag" ${examination.arteryDiseaseFlag eq "0" or examination.arteryDiseaseFlag eq null ?"checked":""} value="0"> 未发现
					<input type="radio" id="arteryDiseaseFlag" onclick="util.clickShowTable(this,'arteryDiseaseDiv','arteryOtherDesc')" name="arteryDiseaseFlag" ${examination.arteryDiseaseFlag eq"1" ?"checked":""} value="1"> 已发现
					<span id="arteryDiseaseDiv" class="tt_hidden">
			            <input type="checkbox" name="arteryDissectingAneurysm" ${examination.arteryDissectingAneurysm eq '1' ? 'checked':''} value="1"> 夹层动脉瘤
			            <input type="checkbox" name="arteryPaod" ${examination.arteryPaod eq '1' ? 'checked':''} value="1"> 动脉闭塞性疾病
			            <input type="checkbox" id="arteryOther" onclick="util.clickShowText(this,'arteryOtherDesc')" name="arteryOther" ${examination.arteryOther eq '1' ? 'checked':''} value="1"> 其他
			            <input type="text" id="arteryOtherDesc" name="arteryOtherDesc" value="${examination.arteryOtherDesc}" CLASS="hidediv" style="width: 150px;"  reg='{"dependOn":"arteryOther","required":"true","maxlength":"33"}'>
			         </span>
				</td>
			</tr>
			<tr>
				<th>眼部疾病</th>
				<td>
					<input type="radio" onclick="util.clickHideTable(this,'eyeDiseasesDiv')" name="eyeDiseasesFlag" ${examination.eyeDiseasesFlag eq "0" or examination.eyeDiseasesFlag eq null ?"checked":""} value="0"> 未发现
					<input type="radio" id="eyeDiseasesFlag" onclick="util.clickShowTable(this,'eyeDiseasesDiv','eyeOtherDesc')" name="eyeDiseasesFlag" ${examination.eyeDiseasesFlag eq"1" ?"checked":""} value="1"> 已发现
					<span id="eyeDiseasesDiv" class="tt_hidden">
			            <input type="checkbox" name="eyeRetinalOozing" ${examination.eyeRetinalOozing eq '1' ? 'checked':''} value="1"> 视网膜出血或者渗出
			            <input type="checkbox" name="eyeOpticPapilla" ${examination.eyeOpticPapilla eq '1' ? 'checked':''} value="1"> 视乳头水肿
			            <input type="checkbox" name="eyeCataract" ${examination.eyeCataract eq '1' ? 'checked':''} value="1"> 白内障
			            <input type="checkbox" id="eyeOther" onclick="util.clickShowText(this,'eyeOtherDesc')" name="eyeOther" ${examination.eyeOther eq '1' ? 'checked':''} value="1"> 其他
			            <input type="text" id="eyeOtherDesc" name="eyeOtherDesc" value="${examination.eyeOtherDesc}" class="hidediv" style="width: 200px;"  reg='{"dependOn":"eyeOther","required":"true","maxlength":"33"}'>
			        </span>
				</td>
			</tr>
			<tr>
				<th>神经系统疾病</th>
				<td>
					<input type="radio" id="nervousDiseasesNotFind" onclick="util.clickHideText(this,'nervousDiseasesDesc')" name="nervousDiseasesFlag" ${examination.nervousDiseasesFlag eq "0" or examination.nervousDiseasesFlag eq null ? "checked" : ""} value="0"> 未发现
					<input type="radio" id="nervousDiseasesFlag" onclick="util.clickShowText(this,'nervousDiseasesDesc')" name="nervousDiseasesFlag" ${examination.nervousDiseasesFlag eq"1" ?"checked":""} value="1"> 有
					<input type="text" id="nervousDiseasesDesc" name="nervousDiseasesDesc" value="${examination.nervousDiseasesDesc}" CLASS="hidediv"  style="width: 200px;" reg='{"dependOn":"nervousDiseasesFlag","required":"true","maxlength":"33"}'>
				</td>
			</tr>
			<tr style="display:none">
				<th>高血压</th>
				<td>
					<input type="radio" id="hypertensionFlagNotFind" onclick="util.clickHideText(this,'hypertensionDesc')" name="hypertensionFlag" ${examination.hypertensionFlag eq "0" or examination.hypertensionFlag eq null ? "checked" : ""} value="0"> 未发现
					<input type="radio" id="hypertensionFlag" onclick="util.clickShowText(this,'hypertensionDesc')" name="hypertensionFlag" ${examination.hypertensionFlag eq"1" ?"checked":""} value="1"> 有
					<input type="text" id="hypertensionDesc" name="hypertensionDesc" value="${examination.hypertensionDesc}" CLASS="hidediv"  style="width: 200px;" reg='{"dependOn":"hypertensionFlag","required":"true","maxlength":"100"}'>
				</td>
			</tr>
			<tr style="display:none">
				<th>糖尿病</th>
				<td>
					<input type="radio" id="diabetesMellitusFlagNotFind" onclick="util.clickHideText(this,'diabetesMellituDesc')" name="diabetesMellitusFlag" ${examination.diabetesMellitusFlag eq "0" or examination.diabetesMellitusFlag eq null ? "checked" : ""} value="0"> 未发现
					<input type="radio" id="diabetesMellitusFlag" onclick="util.clickShowText(this,'diabetesMellituDesc')" name="diabetesMellitusFlag" ${examination.diabetesMellitusFlag eq"1" ?"checked":""} value="1"> 有
					<input type="text" id="diabetesMellituDesc" name="diabetesMellituDesc" value="${examination.diabetesMellituDesc}" CLASS="hidediv"  style="width: 200px;" reg='{"dependOn":"diabetesMellitusFlag","required":"true","maxlength":"100"}'>
				</td>
			</tr>
			<tr>
				<th>其他系统疾病</th>
				<td>
					<input type="radio" onclick="util.clickHideText(this,'healthOtherDesc')" name="healthOther" ${examination.healthOther eq "0" or examination.healthOther eq null ? "checked" : ""} value="0"> 未发现
					<input type="radio" id="healthOther" onclick="util.clickShowText(this,'healthOtherDesc')" name="healthOther" ${examination.healthOther eq"1" ?"checked":""} value="1"> 有
					<input type="text" id="healthOtherDesc" name="healthOtherDesc" value="${examination.healthOtherDesc}" CLASS="hidediv"  style="width: 200px;" reg='{"dependOn":"healthOther","required":"true","maxlength":"33"}'>
				</td>
			</tr>
		</table>
	</fieldset>
</div>

<div class="postdiv">
	<fieldset class="layui-elem-field">
		<legend>住院治疗情况</legend>
		<table class="posttable">
			<tr>
				<th style="width: 16%">住院史</th>
				<td>
					<label><input type="radio" name="PersonalPhyExamDTO.hospitalizedHistoryFlg" ${hospitalizedHistoryFlg eq "0" or hospitalizedHistoryFlg eq null? "checked":""} onclick="util.clickHideTable(this,'hospitalizedHistoryDiv')" value="0"> 无</label>
					<label><input type="radio" id="hospitalizedHistoryFlg" name="PersonalPhyExamDTO.hospitalizedHistoryFlg" ${hospitalizedHistoryFlg eq "1" ? "checked":""} onclick="util.clickShowTable(this,'hospitalizedHistoryDiv')" value="1"> 有</label>
					<c:if test="${empty examination.id || empty hospitalizedHistoryList}">
						<table id="hospitalizedHistoryDiv" class="tt_hidden">
							<tr>
								<th style="text-align:center;">入院时间</th><th style="text-align:center;">原因</th><th style="text-align:center;">医疗机构名称</th><th style="text-align:center;">病案号</th>
							</tr>
							<tr>
								<td style="text-align:center;">
									<tag:dateInput reg="{'dependOn':'hospitalizedHistoryFlg','required':true}" onlypast="true" style="width: 70px;" id="hospitalizedHistoryList0inDate" name="PersonalPhyExamDTO.hospitalizedHistoryList[0].inDate" ></tag:dateInput>
									/  <tag:dateInput reg='{"dependOn":"hospitalizedHistoryFlg","required":true,"compare":["hospitalizedHistoryList0inDate","ge","结束日期不能小于开始日期"]}' onlypast="true" style="width: 70px;"  name="PersonalPhyExamDTO.hospitalizedHistoryList[0].outhosDate" ></tag:dateInput>
								</td>
								<td style="text-align:center;">
									<input reg='{"dependOn":"hospitalizedHistoryFlg","required":true,"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[0].inhosReason" CLASS="width100">
								</td>
								<td style="text-align:center;">
									<input reg='{"dependOn":"hospitalizedHistoryFlg","required":true,"maxlength":"23"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[0].inputOrganName" CLASS="width100">
								</td>
								<td style="text-align:center;">
									<input reg='{"maxlength":"18"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[0].medicalRecordNo" CLASS="width100">
								</td>
							</tr>
							<tr>
								<td style="text-align:center;">
									<tag:dateInput onlypast="true" style="width: 70px;" id="hospitalizedHistoryList1inDate" name="PersonalPhyExamDTO.hospitalizedHistoryList[1].inDate"></tag:dateInput>
									/  <tag:dateInput onlypast="true" reg='{"compare":["hospitalizedHistoryList1inDate","ge","结束日期不能小于开始日期"]}' style="width: 70px;" name="PersonalPhyExamDTO.hospitalizedHistoryList[1].outhosDate" ></tag:dateInput>
								</td>
								<td style="text-align:center;">
									<input reg='{"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[1].inhosReason" CLASS="width100">
								</td>
								<td style="text-align:center;">
									<input reg='{"maxlength":"23"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[1].inputOrganName" CLASS="width100">
								</td>
								<td style="text-align:center;">
									<input reg='{"maxlength":"18"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[1].medicalRecordNo" CLASS="width100">
								</td>
							</tr>
							<tr>
								<td style="text-align:center;">
									<tag:dateInput onlypast="true" style="width: 70px;" id="hospitalizedHistoryList2inDate"  name="PersonalPhyExamDTO.hospitalizedHistoryList[2].inDate" ></tag:dateInput>
									/  <tag:dateInput reg='{"compare":["hospitalizedHistoryList2inDate","ge","结束日期不能小于开始日期"]}' onlypast="true" style="width: 70px;" name="PersonalPhyExamDTO.hospitalizedHistoryList[2].outhosDate" ></tag:dateInput>
								</td>
								<td style="text-align:center;">
									<input reg='{"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[2].inhosReason" CLASS="width100">
								</td>
								<td style="text-align:center;">
									<input reg='{"maxlength":"23"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[2].inputOrganName" CLASS="width100">
								</td>
								<td style="text-align:center;">
									<input reg='{"maxlength":"18"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[2].medicalRecordNo" CLASS="width100">
								</td>
							</tr>
						</table>
					</c:if>
					<c:if test="${not empty examination.id}">
						<table id="hospitalizedHistoryDiv" class="tt_hidden">
							<tr>
								<th style="text-align:center;">入院时间</th><th style="text-align:center;">原因</th><th style="text-align:center;">医疗机构名称</th><th style="text-align:center;">病案号</th>
							</tr>
							<c:forEach items="${hospitalizedHistoryList}" var="hospitalizedList" varStatus="status">
								<tr>
									<c:if test="${status.index eq 0}">
										<td style="text-align:center;">
											<tag:dateInput reg="{'dependOn':'hospitalizedHistoryFlg','required':true}" onlypast="true" style="width: 70px;" id="hospitalizedHistoryList${status.index}inDate"  date="${hospitalizedList.inDate}" name="PersonalPhyExamDTO.hospitalizedHistoryList[${status.index}].inDate"></tag:dateInput>
											/  <tag:dateInput reg='{"dependOn":"hospitalizedHistoryFlg","required":true,"compare":["hospitalizedHistoryList${status.index}inDate","ge","结束日期不能小于开始日期"]}' onlypast="true" style="width: 70px;" date="${hospitalizedList.outhosDate}" name="PersonalPhyExamDTO.hospitalizedHistoryList[${status.index}].outhosDate" ></tag:dateInput>
										</td>
										<td style="text-align:center;">
											<input reg='{"dependOn":"hospitalizedHistoryFlg","required":true,"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[${status.index}].inhosReason" value="${hospitalizedList.inhosReason}" CLASS="width100">
										</td>
										<td style="text-align:center;">
											<input reg='{"dependOn":"hospitalizedHistoryFlg","required":true,"maxlength":"23"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[${status.index}].inputOrganName" value="${hospitalizedList.inputOrganName}" CLASS="width100">
										</td>
										<td style="text-align:center;">
											<input reg='{"maxlength":"18"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[${status.index}].medicalRecordNo" value="${hospitalizedList.medicalRecordNo}" CLASS="width100">
										</td>
									</c:if>
									<c:if test="${status.index ne 0}">
										<td style="text-align:center;">
											<tag:dateInput  onlypast="true" style="width: 70px;" id="hospitalizedHistoryList${status.index}inDate"  date="${hospitalizedList.inDate}" name="PersonalPhyExamDTO.hospitalizedHistoryList[${status.index}].inDate"></tag:dateInput>
											/  <tag:dateInput onlypast="true" reg='{"compare":["hospitalizedHistoryList${status.index}inDate","ge","结束日期不能小于开始日期"]}' style="width: 70px;" date="${hospitalizedList.outhosDate}" name="PersonalPhyExamDTO.hospitalizedHistoryList[${status.index}].outhosDate" ></tag:dateInput>
										</td>
										<td style="text-align:center;">
											<input reg='{"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[${status.index}].inhosReason" value="${hospitalizedList.inhosReason}" CLASS="width100">
										</td>
										<td style="text-align:center;">
											<input reg='{"maxlength":"23"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[${status.index}].inputOrganName" value="${hospitalizedList.inputOrganName}" CLASS="width100">
										</td>
										<td style="text-align:center;">
											<input reg='{"maxlength":"18"}' type="text" name="PersonalPhyExamDTO.hospitalizedHistoryList[${status.index}].medicalRecordNo" value="${hospitalizedList.medicalRecordNo}" CLASS="width100">
										</td>
									</c:if>
								</tr>
							</c:forEach>
						</table>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>家庭病床史</th>
				<td>
					<label><input type="radio" name="PersonalPhyExamDTO.familyBedHistoryFlg" ${familyBedHistoryFlg eq '0' or familyBedHistoryFlg eq null ? 'checked':''} onclick="util.clickHideTable(this,'familyBedHistoryDiv')" value="0"> 无</label>
					<label><input type="radio" id="familyBedHistoryFlg" name="PersonalPhyExamDTO.familyBedHistoryFlg" ${familyBedHistoryFlg eq '1' ? 'checked':''} onclick="util.clickShowTable(this,'familyBedHistoryDiv')" value="1"> 有</label>
					<c:if test="${empty examination.id || empty familyBedHistoryList }">
						<table id="familyBedHistoryDiv" class="tt_hidden">
							<tr>
								<th style="text-align:center;">建/撤床日期</th><th style="text-align:center;">原因</th><th style="text-align:center;">医疗机构名称</th><th style="text-align:center;">病案号</th>
							</tr>
							<tr>
								<td style="text-align:center;">
									<tag:dateInput reg="{'dependOn':'familyBedHistoryFlg','required':true}" onlypast="true"  style="width: 70px;" id="familyBedHistoryList0builtBedDate" name="PersonalPhyExamDTO.familyBedHistoryList[0].builtBedDate" ></tag:dateInput>
									/  <tag:dateInput reg='{"dependOn":"familyBedHistoryFlg","required":true,"compare":["familyBedHistoryList0builtBedDate","ge","结束日期不能小于开始日期"]}' onlypast="true"  style="width: 70px;" name="PersonalPhyExamDTO.familyBedHistoryList[0].removeBedDate" ></tag:dateInput>
								</td>
								<td style="text-align:center;">
									<input reg='{"maxlength":"33","dependOn":"familyBedHistoryFlg","required":true}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[0].builtBedReason" CLASS="width100">
								</td>
								<td style="text-align:center;">
									<input reg='{"maxlength":"23","dependOn":"familyBedHistoryFlg","required":true}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[0].inputOrganName" CLASS="width100">
								</td>
								<td style="text-align:center;">
									<input reg='{"maxlength":"18"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[0].medicalRecordNo" CLASS="width100">
								</td>
							</tr>
							<tr>
								<td style="text-align:center;">
									<tag:dateInput onlypast="true" style="width: 70px;" id="familyBedHistoryList1builtBedDate" name="PersonalPhyExamDTO.familyBedHistoryList[1].builtBedDate" ></tag:dateInput>
									/  <tag:dateInput onlypast="true"  reg='{"compare":["familyBedHistoryList1builtBedDate","ge","结束日期不能小于开始日期"]}' style="width: 70px;" name="PersonalPhyExamDTO.familyBedHistoryList[1].removeBedDate" ></tag:dateInput>
								</td>
								<td style="text-align:center;">
									<input reg='{"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[1].builtBedReason" CLASS="width100">
								</td>
								<td style="text-align:center;">
									<input reg='{"maxlength":"23"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[1].inputOrganName" CLASS="width100">
								</td>
								<td style="text-align:center;">
									<input reg='{"maxlength":"18"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[1].medicalRecordNo" CLASS="width100">
								</td>
							</tr>
							<tr>
								<td style="text-align:center;">
									<tag:dateInput onlypast="true" style="width: 70px;" id="familyBedHistoryList2builtBedDate" name="PersonalPhyExamDTO.familyBedHistoryList[2].builtBedDate"></tag:dateInput>
									/  <tag:dateInput onlypast="true"  reg='{"compare":["familyBedHistoryList1bui2tBedDate","ge","结束日期不能小于开始日期"]}' style="width: 70px;" name="PersonalPhyExamDTO.familyBedHistoryList[2].removeBedDate"></tag:dateInput>
								</td>
								<td style="text-align:center;">
									<input reg='{"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[2].builtBedReason" CLASS="width100">
								</td>
								<td style="text-align:center;">
									<input reg='{"maxlength":"23"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[2].inputOrganName" CLASS="width100">
								</td>
								<td style="text-align:center;">
									<input reg='{"maxlength":"18"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[2].medicalRecordNo" CLASS="width100">
								</td>
							</tr>
						</table>
					</c:if>
					<c:if test="${not empty examination.id}">
						<table id="familyBedHistoryDiv" class="tt_hidden">
							<tr>
								<th style="text-align:center;">建/撤床日期</th><th style="text-align:center;">原因</th><th style="text-align:center;">医疗机构名称</th><th style="text-align:center;">病案号</th>
							</tr>
							<c:forEach items="${familyBedHistoryList}" var="familyBed" varStatus="status">
								<tr>
									<c:if test="${status.index eq 0}">
										<td style="text-align:center;">
											<tag:dateInput reg="{'dependOn':'familyBedHistoryFlg','required':true}" onlypast="true" style="width: 70px;" id="familyBedHistoryList${status.index}builtBedDate" date="${familyBed.builtBedDate}" name="PersonalPhyExamDTO.familyBedHistoryList[${status.index}].builtBedDate"></tag:dateInput>
											/  <tag:dateInput reg='{"dependOn":"familyBedHistoryFlg","required":true,"compare":["familyBedHistoryList${status.index}builtBedDate","ge","结束日期不能小于开始日期"]}' onlypast="true" style="width: 70px;" date="${familyBed.removeBedDate}" name="PersonalPhyExamDTO.familyBedHistoryList[${status.index}].removeBedDate"></tag:dateInput>
										</td>
										<td style="text-align:center;">
											<input reg='{"dependOn":"familyBedHistoryFlg","required":true,"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[${status.index}].builtBedReason" value="${familyBed.builtBedReason}" CLASS="width100">
										</td>
										<td style="text-align:center;">
											<input reg='{"dependOn":"familyBedHistoryFlg","required":true,"maxlength":"23"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[${status.index}].inputOrganName" value="${familyBed.inputOrganName}" CLASS="width100">
										</td>
										<td style="text-align:center;">
											<input reg='{"maxlength":"18"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[${status.index}].medicalRecordNo" value="${familyBed.medicalRecordNo}" CLASS="width100">
										</td>
									</c:if>
									<c:if test="${status.index ne 0}">
										<td style="text-align:center;">
											<tag:dateInput onlypast="true" style="width: 70px;" id="familyBedHistoryList${status.index}builtBedDate" date="${familyBed.builtBedDate}" name="PersonalPhyExamDTO.familyBedHistoryList[${status.index}].builtBedDate"></tag:dateInput>
											/  <tag:dateInput onlypast="true" reg='{"compare":["familyBedHistoryList${status.index}builtBedDate","ge","结束日期不能小于开始日期"]}' style="width: 70px;" date="${familyBed.removeBedDate}" name="PersonalPhyExamDTO.familyBedHistoryList[${status.index}].removeBedDate"></tag:dateInput>
										</td>
										<td style="text-align:center;">
											<input reg='{"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[${status.index}].builtBedReason" value="${familyBed.builtBedReason}" CLASS="width100">
										</td>
										<td style="text-align:center;">
											<input reg='{"maxlength":"23"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[${status.index}].inputOrganName" value="${familyBed.inputOrganName}" CLASS="width100">
										</td>
										<td style="text-align:center;">
											<input reg='{"maxlength":"18"}' type="text" name="PersonalPhyExamDTO.familyBedHistoryList[${status.index}].medicalRecordNo" value="${familyBed.medicalRecordNo}" CLASS="width100">
										</td>
									</c:if>
								</tr>
							</c:forEach>
						</table>
					</c:if>
				</td>
			</tr>
		</table>
	</fieldset>
</div>


<div class="postdiv">
	<fieldset class="layui-elem-field">
		<table class="posttable">
			<tr>
				<th style="width: 16%"><label class="required" title="考核项目">主要用药情况</label></th>
				<td>
					<label><input type="radio"  name="PersonalPhyExamDTO.drugHistoryFlag" ${drugHistoryFlag eq '0' or drugHistoryFlag eq null?'checked':'' } onclick="util.clickHideTable(this,'drugHistoryDiv')" value="0"> 无</label>
					<label><input type="radio" id="drugHistoryFlag" name="PersonalPhyExamDTO.drugHistoryFlag" ${drugHistoryFlag eq '1'?'checked':'' } onclick="util.clickShowTable(this,'drugHistoryDiv')" value="1"> 有</label>
					<br>
					<table id="drugHistoryDiv" class="tt_hidden">
						<tr>
							<th style="width: 14%">第一种药物名称</th>
							<td style="width: 23%"><input reg='{"dependOn":"drugHistoryFlag","required":true,"maxlength":"16"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[0].drugGenericName" value="${drugHistoryList[0].drugGenericName}" style="width: 152px"/></td>
							<th style="width: 11%">用法与用量</th>
							<td style="width: 50%">
								<ehr:dic-list reg="{'dependOn':'drugHistoryFlag','required':true}" id="dicList1" name="PersonalPhyExamDTO.drugHistoryList[0].drugUseRouteCode" dicmeta="CV0600102" value="${drugHistoryList[0].drugUseRouteCode}"/>
								每日<input reg='{"dependOn":"drugHistoryFlag","required":true,"maxlength":"20"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[0].drugUseFrequency" value="${drugHistoryList[0].drugUseFrequency}" style="width: 30px"/>次,
								每次<input reg='{"dependOn":"drugHistoryFlag","required":true,"maxlength":"20"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[0].drugUseState" value="${drugHistoryList[0].drugUseState}" style="width: 30px"/>
								<input class="hide">
								<ehr:dic-list dicmeta="DMD00067" reg='{"dependOn":"drugHistoryFlag","required":true}'  name="PersonalPhyExamDTO.drugHistoryList[0].drugUseDoseUnit" value="${drugHistoryList[0].drugUseDoseUnit}"></ehr:dic-list>
							</td>
						</tr>
						<tr>
							<th style="width: 14%">用药时间</th>
							<td style="width: 26%">
								<tag:dateInput reg="{'dependOn':'drugHistoryFlag','required':true}" onlypast="true"  style="width: 70px;" id="drugHistoryList0startDate" name="PersonalPhyExamDTO.drugHistoryList[0].startDate" date="${drugHistoryList[0].startDate}"></tag:dateInput> /
								<tag:dateInput reg='{"compare":["drugHistoryList0startDate","ge","结束日期不能小于开始日期"]}' onlypast="true"  style="width: 70px;" name="PersonalPhyExamDTO.drugHistoryList[0].stopDate" date="${drugHistoryList[0].stopDate}"></tag:dateInput>
							</td>
							<th style="width: 11%">服药依从性</th>
							<td style="width: 49%"><ehr:dic-radio reg="{'dependOn':'drugHistoryFlag','required':true}" name="PersonalPhyExamDTO.drugHistoryList[0].medicationCompliance" dicmeta="FS10141" value="${drugHistoryList[0].medicationCompliance}"/></td>
						</tr>
						<tr>
							<th style="width: 14%">第二种药物名称</th>
							<td style="width: 26%"><input reg='{"maxlength":"16"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[1].drugGenericName" value="${drugHistoryList[1].drugGenericName}" style="width: 152px" /></td>
							<th style="width: 11%">用法与用量</th>
							<td style="width: 49%">
								<ehr:dic-list id="dicList2" name="PersonalPhyExamDTO.drugHistoryList[1].drugUseRouteCode" dicmeta="CV0600102" value="${drugHistoryList[1].drugUseRouteCode}" />
								每日<input reg='{"maxlength":"20"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[1].drugUseFrequency" style="width: 30px" value="${drugHistoryList[1].drugUseFrequency}" />次,
								每次<input reg='{"maxlength":"20"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[1].drugUseState" style="width: 30px" value="${drugHistoryList[1].drugUseState}"/>
								<input class="hide">
								<ehr:dic-list dicmeta="DMD00067"  name="PersonalPhyExamDTO.drugHistoryList[1].drugUseDoseUnit" value="${drugHistoryList[1].drugUseDoseUnit}"></ehr:dic-list>
							</td>
						</tr>
						<tr>
							<th style="width: 14%">用药时间</th>
							<td style="width: 26%">
								<tag:dateInput onlypast="true"  style="width: 70px;" id="drugHistoryList1startDate" name="PersonalPhyExamDTO.drugHistoryList[1].startDate"  date="${drugHistoryList[1].startDate}"></tag:dateInput> /
								<tag:dateInput reg='{"compare":["drugHistoryList1startDate","ge","结束日期不能小于开始日期"]}' onlypast="true"  style="width: 70px;" name="PersonalPhyExamDTO.drugHistoryList[1].stopDate"  date="${drugHistoryList[1].stopDate}"></tag:dateInput>
							</td>
							<th style="width: 11%">服药依从性</th>
							<td style="width: 49%"><ehr:dic-radio name="PersonalPhyExamDTO.drugHistoryList[1].medicationCompliance" dicmeta="FS10141" value="${drugHistoryList[1].medicationCompliance}"/></td>
						</tr>
						<tr>
							<th style="width: 14%">第三种药物名称</th>
							<td style="width: 26%"><input reg='{"maxlength":"16"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[2].drugGenericName" value="${drugHistoryList[2].drugGenericName}" style="width: 152px" /></td>
							<th style="width: 11%">用法与用量</th>
							<td style="width: 49%">
								<ehr:dic-list id="dicList2" name="PersonalPhyExamDTO.drugHistoryList[2].drugUseRouteCode" dicmeta="CV0600102" value="${drugHistoryList[2].drugUseRouteCode}" />
								每日<input reg='{"maxlength":"20"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[2].drugUseFrequency" style="width: 30px" value="${drugHistoryList[2].drugUseFrequency}" />次,
								每次<input reg='{"maxlength":"20"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[2].drugUseState" style="width: 30px" value="${drugHistoryList[2].drugUseState}"/>
								<input class="hide">
								<ehr:dic-list dicmeta="DMD00067"  name="PersonalPhyExamDTO.drugHistoryList[2].drugUseDoseUnit" value="${drugHistoryList[2].drugUseDoseUnit}"></ehr:dic-list>
							</td>
						</tr>
						<tr>
							<th style="width: 14%">用药时间</th>
							<td style="width: 26%">
								<tag:dateInput onlypast="true"  style="width: 70px;" id="drugHistoryList2startDate" name="PersonalPhyExamDTO.drugHistoryList[2].startDate"  date="${drugHistoryList[2].startDate}"></tag:dateInput> /
								<tag:dateInput reg='{"compare":["drugHistoryList2startDate","ge","结束日期不能小于开始日期"]}' onlypast="true"  style="width: 70px;" name="PersonalPhyExamDTO.drugHistoryList[2].stopDate"  date="${drugHistoryList[2].stopDate}"></tag:dateInput>
							</td>
							<th style="width: 11%">服药依从性</th>
							<td style="width: 49%"><ehr:dic-radio name="PersonalPhyExamDTO.drugHistoryList[2].medicationCompliance" dicmeta="FS10141" value="${drugHistoryList[2].medicationCompliance}"/></td>
						</tr>
						<tr>
							<th style="width: 14%">第四种药物名称</th>
							<td style="width: 26%"><input reg='{"maxlength":"16"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[3].drugGenericName" value="${drugHistoryList[3].drugGenericName}" style="width: 152px" /></td>
							<th style="width: 11%">用法与用量</th>
							<td style="width: 49%">
								<ehr:dic-list id="dicList3" name="PersonalPhyExamDTO.drugHistoryList[3].drugUseRouteCode" dicmeta="CV0600102" value="${drugHistoryList[3].drugUseRouteCode}" />
								每日<input reg='{"maxlength":"20"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[3].drugUseFrequency" style="width: 30px" value="${drugHistoryList[3].drugUseFrequency}" />次,
								每次<input reg='{"maxlength":"20"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[3].drugUseState" style="width: 30px" value="${drugHistoryList[3].drugUseState}"/>
								<input class="hide">
								<ehr:dic-list dicmeta="DMD00067"  name="PersonalPhyExamDTO.drugHistoryList[3].drugUseDoseUnit" value="${drugHistoryList[3].drugUseDoseUnit}"></ehr:dic-list>
							</td>
						</tr>
						<tr>
							<th style="width: 14%">用药时间</th>
							<td style="width: 26%">
								<tag:dateInput onlypast="true"  style="width: 70px;" id="drugHistoryList3startDate" name="PersonalPhyExamDTO.drugHistoryList[3].startDate"  date="${drugHistoryList[3].startDate}"></tag:dateInput> /
								<tag:dateInput reg='{"compare":["drugHistoryList3startDate","ge","结束日期不能小于开始日期"]}' onlypast="true"  style="width: 70px;" name="PersonalPhyExamDTO.drugHistoryList[3].stopDate"  date="${drugHistoryList[3].stopDate}"></tag:dateInput>
							</td>
							<th style="width: 11%">服药依从性</th>
							<td style="width: 49%"><ehr:dic-radio name="PersonalPhyExamDTO.drugHistoryList[3].medicationCompliance" dicmeta="FS10141" value="${drugHistoryList[3].medicationCompliance}"/></td>
						</tr>
						<tr>
							<th style="width: 14%">第五种药物名称</th>
							<td style="width: 26%"><input reg='{"maxlength":"16"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[4].drugGenericName" value="${drugHistoryList[4].drugGenericName}" style="width: 152px" /></td>
							<th style="width: 11%">用法与用量</th>
							<td style="width: 49%">
								<ehr:dic-list id="dicList4" name="PersonalPhyExamDTO.drugHistoryList[4].drugUseRouteCode" dicmeta="CV0600102" value="${drugHistoryList[4].drugUseRouteCode}" />
								每日<input reg='{"maxlength":"20"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[4].drugUseFrequency" style="width: 30px" value="${drugHistoryList[4].drugUseFrequency}" />次,
								每次<input reg='{"maxlength":"20"}' type="text" name="PersonalPhyExamDTO.drugHistoryList[4].drugUseState" style="width: 30px" value="${drugHistoryList[4].drugUseState}"/>
								<input class="hide">
								<ehr:dic-list dicmeta="DMD00067"  name="PersonalPhyExamDTO.drugHistoryList[4].drugUseDoseUnit" value="${drugHistoryList[4].drugUseDoseUnit}"></ehr:dic-list>
							</td>
						</tr>
						<tr>
							<th style="width: 14%">用药时间</th>
							<td style="width: 26%">
								<tag:dateInput onlypast="true"  style="width: 70px;" id="drugHistoryList4startDate" name="PersonalPhyExamDTO.drugHistoryList[4].startDate"  date="${drugHistoryList[4].startDate}"></tag:dateInput> /
								<tag:dateInput reg='{"compare":["drugHistoryList4startDate","ge","结束日期不能小于开始日期"]}' onlypast="true"  style="width: 70px;" name="PersonalPhyExamDTO.drugHistoryList[4].stopDate"  date="${drugHistoryList[4].stopDate}"></tag:dateInput>
							</td>
							<th style="width: 11%">服药依从性</th>
							<td style="width: 49%"><ehr:dic-radio name="PersonalPhyExamDTO.drugHistoryList[4].medicationCompliance" dicmeta="FS10141" value="${drugHistoryList[4].medicationCompliance}"/></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</fieldset>
</div>
<div class="postdiv">
	<fieldset class="layui-elem-field">
		<table class="posttable">
			<tr>
				<th style="width: 16%">非免疫规划预防接种史</th>
				<td>
					<label><input type="radio" onclick="util.clickHideTable(this,'vaccinationInfoDiv')" ${vaccinationInfoFlg eq '0' or vaccinationInfoFlg eq null ? 'checked':''} name="PersonalPhyExamDTO.vaccinationInfoFlg" value="0"> 无</label>
					<label><input type="radio" id="vaccinationInfoFlg" onclick="util.clickShowTable(this,'vaccinationInfoDiv')" ${vaccinationInfoFlg eq '1' ? 'checked':''} name="PersonalPhyExamDTO.vaccinationInfoFlg" value="1"> 有</label>
					<c:if test="${empty examination.id || empty vaccinationInfoList }">
						<table id="vaccinationInfoDiv" class="tt_hidden">
							<tr>
								<th style="text-align:center;">名称</th><th style="text-align:center;">接种日期</th><th style="text-align:center;">接种机构</th>
							</tr>
							<tr>
								<td style="text-align:center;">
									<input reg='{"dependOn":"vaccinationInfoFlg","required":true,"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.vaccinationInfoList[0].vaccineName" CLASS="width100">
								</td>
								<td style="text-align:center;">
									<tag:dateInput reg="{'dependOn':'vaccinationInfoFlg','required':true}" onlypast="true" cssClass="width100" id="vaccinationInfoList0vaccinationDate" name="PersonalPhyExamDTO.vaccinationInfoList[0].vaccinationDate" ></tag:dateInput>
								</td>
								<td style="text-align:center;">
									<input reg='{"dependOn":"vaccinationInfoFlg","required":true,"maxlength":"23"}' type="text" name="PersonalPhyExamDTO.vaccinationInfoList[0].vaccinationUnitName" CLASS="width100"/>
								</td>
							</tr>
							<tr>
								<td style="text-align:center;">
									<input type="text" reg='{"maxlength":"33"}'  name="PersonalPhyExamDTO.vaccinationInfoList[1].vaccineName" CLASS="width100">
								</td>
								<td style="text-align:center;">
									<tag:dateInput onlypast="true" cssClass="width100" id="vaccinationInfoList1vaccinationDate" name="PersonalPhyExamDTO.vaccinationInfoList[1].vaccinationDate"></tag:dateInput>
								</td>
								<td style="text-align:center;">
									<input reg='{"maxlength":"23"}'  type="text" name="PersonalPhyExamDTO.vaccinationInfoList[1].vaccinationUnitName" CLASS="width100">
								</td>
							</tr>
							<tr>
								<td style="text-align:center;">
									<input type="text" reg='{"maxlength":"33"}'  name="PersonalPhyExamDTO.vaccinationInfoList[2].vaccineName" CLASS="width100">
								</td>
								<td style="text-align:center;">
									<tag:dateInput onlypast="true" cssClass="width100" id="vaccinationInfoList2vaccinationDate" name="PersonalPhyExamDTO.vaccinationInfoList[2].vaccinationDate"></tag:dateInput>
								</td>
								<td style="text-align:center;">
									<input reg='{"maxlength":"23"}'  type="text" name="PersonalPhyExamDTO.vaccinationInfoList[2].vaccinationUnitName" CLASS="width100">
								</td>
							</tr>
							<tr>
								<td style="text-align:center;">
									<input type="text" reg='{"maxlength":"33"}' name="PersonalPhyExamDTO.vaccinationInfoList[3].vaccineName" CLASS="width100">
								</td>
								<td style="text-align:center;">
									<tag:dateInput onlypast="true" cssClass="width100" id="vaccinationInfoList3vaccinationDate" name="PersonalPhyExamDTO.vaccinationInfoList[3].vaccinationDate"></tag:dateInput>
								</td>
								<td style="text-align:center;">
									<input reg='{"maxlength":"23"}' type="text" name="PersonalPhyExamDTO.vaccinationInfoList[3].vaccinationUnitName" CLASS="width100">
								</td>
							</tr>
						</table>
					</c:if>
					<c:if test="${not empty examination.id }">
						<table id="vaccinationInfoDiv" class="tt_hidden">
							<tr>
								<th style="text-align:center;">名称</th><th style="text-align:center;">接种日期</th><th style="text-align:center;">接种机构</th>
							</tr>
							<c:forEach items="${vaccinationInfoList}" var="vaccinationInfo" varStatus="status">
								<tr>
									<c:if test="${status.index eq 0}">
										<td style="text-align:center;">
											<input reg='{"dependOn":"vaccinationInfoFlg","required":true,"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.vaccinationInfoList[${status.index}].vaccineName" value="${vaccinationInfo.vaccineName}" CLASS="width100">
										</td>
										<td style="text-align:center;">
											<tag:dateInput reg="{'dependOn':'vaccinationInfoFlg','required':true}" onlypast="true" cssClass="width100" id="vaccinationInfoList${status.index}vaccinationDate" date="${vaccinationInfo.vaccinationDate}" name="PersonalPhyExamDTO.vaccinationInfoList[${status.index}].vaccinationDate"></tag:dateInput>
										</td>
										<td style="text-align:center;">
											<input reg='{"dependOn":"vaccinationInfoFlg","required":true,"maxlength":"23"}'  type="text" name="PersonalPhyExamDTO.vaccinationInfoList[${status.index}].vaccinationUnitName" value="${vaccinationInfo.vaccinationUnitName}" CLASS="width100">
										</td>
									</c:if>
									<c:if test="${status.index ne 0}">
										<td style="text-align:center;">
											<input  reg='{"maxlength":"33"}' type="text" name="PersonalPhyExamDTO.vaccinationInfoList[${status.index}].vaccineName" value="${vaccinationInfo.vaccineName}" CLASS="width100">
										</td>
										<td style="text-align:center;">
											<tag:dateInput onlypast="true" cssClass="width100" id="vaccinationInfoList${status.index}vaccinationDate" date="${vaccinationInfo.vaccinationDate}" name="PersonalPhyExamDTO.vaccinationInfoList[${status.index}].vaccinationDate"></tag:dateInput>
										</td>
										<td style="text-align:center;">
											<input reg='{"maxlength":"23"}'  type="text" name="PersonalPhyExamDTO.vaccinationInfoList[${status.index}].vaccinationUnitName" value="${vaccinationInfo.vaccinationUnitName}" CLASS="width100">
										</td>
									</c:if>
								</tr>
							</c:forEach>
						</table>
					</c:if>
				</td>
			</tr>
		</table>
	</fieldset>
</div>

<div class="postdiv">
	<fieldset class="layui-elem-field">
		<table class="posttable">
			<colgroup>
				<col style="width:15%">
				<col style="width:85%">
			</colgroup>
			<tr>
				<th style="width: 16%">健康评价</th>
				<td>
					<input type="radio" onclick="util.clickHideTable(this,'ttb30')" ${examination.healthEvaluateAnomalyFlag eq '0' or examination.healthEvaluateAnomalyFlag eq null ? 'checked' : ''} name="healthEvaluateAnomalyFlag" value="0"> 体检无异常（结合临床表现综合评估）
					<input type="radio" id="healthEvaluateAnomalyFlag" onclick="util.clickShowTable(this,'ttb30')" ${examination.healthEvaluateAnomalyFlag eq '1'?'checked':''} name="healthEvaluateAnomalyFlag" value="1"> 有异常
					<c:set var="healthEvaluateAnomaliesLength" value="${fn:length(examination.healthEvaluateAnomalies) }" ></c:set>
					<div class="hidediv" id="ttb30"><c:if test="${healthEvaluateAnomaliesLength==4}">

						<c:forEach items="${examination.healthEvaluateAnomalies}" var="healEvaluateAnomaly" varStatus="status">
							<c:if test="${status.index eq 0}">异常<input type="text" reg='{"dependOn":"healthEvaluateAnomalyFlg","required":true,"maxlength":"33"}'  name="PersonalPhyExamDTO.healthEvaluateAnomalyList[${status.index}].healthEvaluateAnomalyDesc" value="${healEvaluateAnomaly.healthEvaluateAnomalyDesc}" ><br>
							</c:if>
							<c:if test="${status.index ne 0}">异常<input type="text"  reg='{"maxlength":"33"}'  name="PersonalPhyExamDTO.healthEvaluateAnomalyList[${status.index}].healthEvaluateAnomalyDesc" value="${healEvaluateAnomaly.healthEvaluateAnomalyDesc}"><br>
							</c:if>
						</c:forEach>

					</c:if> <c:if test="${healthEvaluateAnomaliesLength>0 and healthEvaluateAnomaliesLength<4}">
						<c:forEach items="${examination.healthEvaluateAnomalies}" var="healEvaluateAnomaly" varStatus="status">
							<c:if test="${status.index eq 0}">
								异常 <input type="text" reg='{"dependOn":"healthEvaluateAnomalyFlg","required":true,"maxlength":"33"}' name="PersonalPhyExamDTO.healthEvaluateAnomalyList[${status.index}].healthEvaluateAnomalyDesc" value="${healEvaluateAnomaly.healthEvaluateAnomalyDesc}"  > <br>
							</c:if>
							<c:if test="${status.index ne 0}">
								异常 <input type="text"  reg='{"maxlength":"33"}' name="PersonalPhyExamDTO.healthEvaluateAnomalyList[${status.index}].healthEvaluateAnomalyDesc" value="${healEvaluateAnomaly.healthEvaluateAnomalyDesc}"  >
								<br>
							</c:if>
						</c:forEach>
						<c:forEach var="test" varStatus="status" begin="${healthEvaluateAnomaliesLength}" end="${4}">
							异常 <input type="text" name="healthEvaluateAnomalies[${status.index}].healthEvaluateAnomalyDesc" reg='{"maxlength":"33"}' />
							<br>
						</c:forEach>

					</c:if>
						<c:if test="${healthEvaluateAnomaliesLength==0}">
							异常 <input type="text" name="healthEvaluateAnomalies[0].healthEvaluateAnomalyDesc"  reg='{"dependOn":"healthEvaluateAnomalyFlag","required":true,"maxlength":"33"}' style="width: 300px;"> <br>
							异常 <input type="text" name="healthEvaluateAnomalies[1].healthEvaluateAnomalyDesc"  reg='{"maxlength":"33"}' style="width: 300px;"> <br>
							异常 <input type="text" name="healthEvaluateAnomalies[2].healthEvaluateAnomalyDesc"  reg='{"maxlength":"33"}' style="width: 300px;"> <br>
							异常 <input type="text" name="healthEvaluateAnomalies[3].healthEvaluateAnomalyDesc"  reg='{"maxlength":"33"}' style="width: 300px;">

						</c:if>
					</div>
				</td>
			</tr>
		</table>
	</fieldset>
</div>

<div class="postdiv">
	<fieldset class="layui-elem-field">
		<table class="posttable">
			<tr>
				<th style="width: 16%"><label  title="考核项目">健康指导</label></th>
				<td>
					<%--<label>
						<input type="checkbox" name="guideRegularFollowup" ${examination.guideRegularFollowup eq"1" ?"checked":""} value="1" />
						<span>定期随访</span>
					</label>
					<br>--%>
					<label>
						<input type="checkbox" name="guideIntoChronicDisease" ${examination.guideIntoChronicDisease eq"1" ?"checked":""} value="1" />
						<span>纳入慢性病患者健康管理</span>
					</label>
					<br>
					<label>
						<input type="checkbox" name="guideSuggestionReview" ${examination.guideSuggestionReview eq"1" ?"checked":""} value="1" />
						<span>建议复查</span>
					</label>
					<br>
					<label>
						<input type="checkbox" name="guideSuggestionReferral" ${examination.guideSuggestionReferral eq"1" ?"checked":""} value="1" />
						<span>建议转诊</span>
					</label>
					<br/>
					<label>
						<input  type="checkbox" reg='{"extension":["healthGuidanceVali","请至少选择一项"]}'
								name="preventionOsteoporosis" ${examination.preventionOsteoporosis eq"1" ?"checked":""} value="1" />
						<span>骨质疏松预防</span>
					</label>
					<br/>
					<label>
						<input  type="checkbox" reg='{"extension":["healthGuidanceVali","请至少选择一项"]}'
								name="preventionTumble" ${examination.preventionTumble eq"1" ?"checked":""} value="1" />
						<span>防跌倒措施</span>
					</label>
					<br/>
					<label>
						<input  type="checkbox"  reg='{"extension":["healthGuidanceVali","请至少选择一项"]}'
								name="preventionInjury" ${examination.preventionInjury eq"1" ?"checked":""} value="1" />
						<span>意外伤害预防</span>
					</label>
					<%--<br>
					<label>
						<input type="checkbox" name="includedSixManagement" ${examination.includedSixManagement eq"1" ?"checked":""} value="1" />
						<span>纳入0-6岁儿童管理</span>
					</label>
					<br>
					<label>
						<input type="checkbox" name="maternalManagement" ${examination.maternalManagement eq"1" ?"checked":""} value="1" />
						<span>纳入孕产妇管理</span>
					</label>--%>
				</td>
			</tr>
		</table>
	</fieldset>
</div>

<div class="postdiv">
	<fieldset class="layui-elem-field">
		<table class="posttable">
			<colgroup>
				<col style="width:15%">
				<col style="width:85%">
			</colgroup>
			<tr>
				<th style="width: 16%">危险因素控制</th>
				<td>
					<label>
						<input type="checkbox" name="riskQuitSmoking" ${examination.riskQuitSmoking eq '1' ? 'checked' : ''}  value="1"/>
						<span>戒烟</span>
					</label>
					<br>
					<label>
						<input type="checkbox" name="riskHealthDrink" ${examination.riskHealthDrink eq '1' ? 'checked' : ''}  value="1"/>
						<span>健康饮酒</span>
					</label>
					<br>
					<label>
						<input type="checkbox" name="riskDiet" ${examination.riskDiet eq '1' ? 'checked' : ''}  value="1"/>
						<span>饮食</span>
					</label>
					<br>
					<label>
						<input type="checkbox" name="riskExercise" ${examination.riskExercise eq '1' ? 'checked' : ''}  value="1"/>
						<span>锻炼</span>
					</label>
					<br>
					<label>
						<input type="checkbox" id="riskWeightReduction" onclick="util.clickShowText(this,'riskWeightReductionSpan')" name="riskWeightReduction" ${examination.riskWeightReduction eq '1' ? 'checked' : ''}  value="1"/>
						<span>减体重</span>
					</label>
					<span id="riskWeightReductionSpan" class="hidediv">目标:&nbsp;
						<!--  <input type="text" name="riskWeightTarget" value="${examination.riskWeightTarget}">  -->
		            	 <tag:numberInput point="point"  style="width: 40px;"  value="${examination.riskWeightTarget}" name="riskWeightTarget"  cssClass="width30 " reg="{'dependOn':'riskWeightReduction','required':'true','min':0,'max':9999}"/>Kg
		            </span>
					<br>
					<label>
						<input type="checkbox" id="guideVaccination" onclick="util.clickShowText(this,'guideVaccinationSpan')" name="guideVaccination" ${examination.guideVaccination eq '1' ? 'checked' : ''}  value="1"/>
						<span>建议接种疫苗</span>
					</label>
					<span id="guideVaccinationSpan" class="hidediv"> <input type="text" name="guideVaccinationDesc" value="${examination.guideVaccinationDesc}" style="width: 200px;"  reg='{"dependOn":"guideVaccination","required":"true","maxlength":"33"}'> </span>
					<br>
					<label>
						<input type="checkbox" id="riskOther" onclick="util.clickShowText(this,'riskOtherDesc')" name="riskOther" ${examination.riskOther eq '1' ? 'checked' : ''}  value="1"/>
						<span>其他</span></label>
					<span id="riskOtherDesc" class="hidediv"><input type="text" name="riskOtherDesc" value="${examination.riskOtherDesc}" reg='{"dependOn":"riskOther","required":"true","maxlength":"33"}' style="width: 200px;" ></span>
				</td>
			</tr>
		</table>
	</fieldset>
</div>
