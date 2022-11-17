	<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/cdm/standardization/healthPlan/hbpPlanInfo.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" id="cdm-plan-list-hbp-back-btn"><b class="fanhui" >返回</b></a> 
	<a href="javascript:void(0)" id="cdm-plan-list-hbp-save-btn"><b class="baocun" >保存</b></a>
</div>
<input type="hidden" id="cdmPlanHiddenId" value="${planInfo.id}"/>
<form method="post" id="hbpPlanForm">
	<div class="postcontent">
		<i class="popno">高血压患者 <input id="hbpYear" name="conclusionsOfYear" type="text" value="${planInfo.conclusionsOfYear}" maxlength="10"
			readonly="readonly" style="width: 35px; font-weight: bold" reg="{'required':true}"
		/> 年保健计划
		</i>
		<div class="postdivs">
			<fieldset>
				<legend>诊断结论</legend>
				<div id="tableLinstener">
					<fieldset>
						<legend>1.血压</legend>
						<table>
						<colgroup>
						<col style="width:20%;" />
						<col style="width: 30%;" />
						<col style="width:15%;" />
						<col style="width: 35%;" />
					</colgroup>
							<tr>
								<th><label>血压值</label></th>
								<td><label class="required">&nbsp;&nbsp;</label> <input type="text" style="width: 35px;" id="txtSbp" name="sbp" value="${planInfo.sbp}"
									reg='{"required":"true","maxlength":"3","regex":"digits","compare":["txtDbp","gt","收缩压不能小于或者等于舒张压"]}'
								>/ <input type="text" style="width: 35px;" id="txtDbp" name="dbp" value="${planInfo.dbp}"
									reg='{"required":"true","maxlength":"3","regex":"digits","compare":["txtSbp","lt","舒张压不能大于或者等于收缩压"]}'
								>mmHg</td>
								<th><label>分级</label> </th>
								<td>
								<input type="hidden" id="radioRbgLevelHidden" name="hypertensionManagementLevel"
									value="${planInfo.hypertensionManagementLevel}"
								/> <ehr:dic-radio dicmeta="DMD00025" name="radioRbgLevel" value="${planInfo.hypertensionManagementLevel}" /></td>
							</tr>
						</table>
					</fieldset>
					<fieldset>
						<legend>2.心血管疾病（CVD）危险因素、靶器官损伤和相关疾病部分 </legend>
						<table>
						<colgroup>
						<col style="width:20%;" />
						<col style="width: 30%;" />
						<col style="width:15%;" />
						<col style="width: 35%;" />
					</colgroup>
							<tr>
								<td></td>
								<td></td>
								<th><label>分级</label></th>
								<td><input type="hidden" id="radioDiseLevelHidden" name="classificationOfHealth" value="${planInfo.classificationOfHealth}" /> <ehr:dic-radio
										dicmeta="CV0510013" name="radioDiseLevel" value="${planInfo.classificationOfHealth}" code="2,3,4"
									/></td>
							</tr>
						</table>
						<fieldset>
							<legend>
								<label>(1)心血管疾病（CVD）危险因素</label>
							</legend>
							<table>
								<tr>
									<td><input type="checkbox" value="1" id="chXin1" class="level1" ${cvdElementArr1 eq true ? 'checked' : ''} name="cvdElement" />男性
										&gt;55岁&nbsp;&nbsp;&nbsp;&nbsp;女性 &gt;65岁</td>
								</tr>
								<tr>
									<td><input type="checkbox" value="2" id="chXin2" class="level1" ${cvdElementArr2 eq true ? 'checked' : ''} name="cvdElement" />吸烟</td>
								</tr>
								<tr>
									<td><input type="checkbox" value="3" id="chXin3" class="level1" ${cvdElementArr3 eq true ? 'checked' : ''} name="cvdElement" />血脂紊乱</td>
								</tr>
								<tr>
									<td><input type="checkbox" value="4" id="chXin4" class="level1" ${cvdElementArr4 eq true ? 'checked' : ''} name="cvdElement" />早发心血管疾病家族史（一级亲属,发病年龄小于50岁）</td>
								</tr>
								<tr>
									<td><input type="checkbox" value="5" id="chXin5" class="level1" ${cvdElementArr5 eq true ? 'checked' : ''} name="cvdElement" />腹型肥胖（腹围男≥85cm,女≥80cm或肥胖:BMI&gt;28kg/m²）</td>
								</tr>
								<tr>
									<td><input type="checkbox" value="6" id="chXin6" class="level1" ${cvdElementArr6 eq true ? 'checked' : ''} name="cvdElement" />缺乏体力活动</td>
								</tr>
								<tr>
									<td><input type="checkbox" value="7" id="chXin7" class="level1" ${cvdElementArr7 eq true ? 'checked' : ''} name="cvdElement" />高敏C反应蛋白≥3mg/dl或C反应蛋白≥10mg/dl</td>
								</tr>
							</table>
						</fieldset>
						<fieldset>
							<legend>
								<label>(2)靶器官损伤</label>
							</legend>
							<table>
								<tr>
									<td><input type="checkbox" value="1" id="chXin8" class="level2" ${trDamageArr1 eq true ? 'checked' : ''} name="trDamage" />左心室肥厚（心电图、超声心动图LVMI或X线）
									</td>
								</tr>
								<tr>
									<td><input type="checkbox" value="2" id="chXin9" class="level2" ${trDamageArr2 eq true ? 'checked' : ''} name="trDamage" />动脉壁增厚（颈动脉IMT≥0.9mm或粥样硬化斑块）
									</td>
								</tr>
								<tr>
									<td><input type="checkbox" value="3" id="chXin10" class="level2" ${trDamageArr3 eq true ? 'checked' : ''} name="trDamage" />血清肌酐轻微升高（男115-133umol/L,女107-124umol/L）
									</td>
								</tr>
								<tr>
									<td><input type="checkbox" value="4" id="chXin11" class="level2" ${trDamageArr4 eq true ? 'checked' : ''} name="trDamage" />微量白蛋白尿(30-300mg/24H白蛋白/肌酐比值男≥22
										女≥31mg/g)</td>
								</tr>
								<tr>
									<td><input type="checkbox" value="5" id="chXin12" class="level2" ${trDamageArr5 eq true ? 'checked' : ''} name="trDamage" />空腹血糖
										≥7.0mmol/L</td>
								</tr>
								<tr>
									<td><input type="checkbox" value="6" id="chXin13" class="level2" ${trDamageArr6 eq true ? 'checked' : ''} name="trDamage" />餐后血浆葡萄糖≥11.1mmol/L
									</td>
								</tr>
							</table>
						</fieldset>
						<fieldset>
							<legend>
								<label>(3)相关疾病</label>
							</legend>
							<table>
								<colgroup>
									<col style="width:8%;" />
									<col style="width: 30%;" />
									<col style="width:15%;" />
									<col style="width: 35%;" />
								</colgroup>
								<tr>
									<th>脑血管疾病</th>
									<td colspan="3"><input type="checkbox" value="1" id="chXin14" class="level3" ${relatedDiseasesArr1 eq true ? 'checked' : ''}
										name="relatedDiseases"
									/>缺血性脑卒中
									</td>
								</tr>
								<tr>
									<th></th>
									<td colspan="3"><input type="checkbox"
										value="2" id="chXin15" class="level3" ${relatedDiseasesArr2 eq true ? 'checked' : ''} name="relatedDiseases"
									/>脑出血
									</td>
								</tr>
								<tr>
									<th></th>
									<td colspan="3"><input type="checkbox"
										value="3" id="chXin16" class="level3" ${relatedDiseasesArr3 eq true ? 'checked' : ''} name="relatedDiseases"
									/>一过性脑缺血发作
									</td>
								</tr>
								<tr>
									<th>心血管疾病</th>
									<td colspan="3"><input type="checkbox" value="4" id="chXin17" class="level3" ${relatedDiseasesArr4 eq true ? 'checked' : ''}
										name="relatedDiseases"
									/>心肌梗死
									</td>
								</tr>
								<tr>
									<th></th>
									<td colspan="3"><input type="checkbox"
										value="5" id="chXin18" class="level3" ${relatedDiseasesArr5 eq true ? 'checked' : ''} name="relatedDiseases"
									/>心绞痛
									</td>
								</tr>
								<tr>
									<th></th>
									<td colspan="3"><input type="checkbox"
										value="6" id="chXin19" class="level3" ${relatedDiseasesArr6 eq true ? 'checked' : ''} name="relatedDiseases"
									/>冠脉血运重建
									</td>
								</tr>
								<tr>
									<th></th>
									<td colspan="3"><input type="checkbox"
										value="7" id="chXin20" class="level3" ${relatedDiseasesArr7 eq true ? 'checked' : ''} name="relatedDiseases"
									/>心力衰竭
									</td>
								</tr>
								<tr>
									<th>肾脏病变</th>
									<td colspan="3"><input type="checkbox" value="8" id="chXin21" class="level3" ${relatedDiseasesArr8 eq true ? 'checked' : ''}
										name="relatedDiseases"
									/>糖尿病性肾脏病变
									</td>
								</tr>
								<tr>
									<th></th>
									<td colspan="3"><input type="checkbox"
										value="9" id="chXin22" class="level3" ${relatedDiseasesArr9 eq true ? 'checked' : ''} name="relatedDiseases"
									/>肾损害（血清肌酐升高男>133 umol/L或女>124 umol/L）
									</td>
								</tr>
								<tr>
									<th></th>
									<td colspan="3"><input type="checkbox"
										value="10" id="chXin23" class="level3" ${relatedDiseasesArr10 eq true ? 'checked' : ''} name="relatedDiseases"
									/>蛋白尿>300mg/24H
									</td>
								</tr>
								<tr>
									<th></th>
									<td colspan="3"> <input type="checkbox"
										value="11" id="chXin24" class="level3" ${relatedDiseasesArr11 eq true ? 'checked' : ''} name="relatedDiseases"
									/>肾功能衰竭（血肌酐浓度177umol/L） 
									</td>
								</tr>
								<tr>
									<th></th>
									<td colspan="3"><input type="checkbox"
										value="12" id="chXin25" class="level3" ${relatedDiseasesArr12 eq true ? 'checked' : ''} name="relatedDiseases"
									/>外周血管病变
									</td>
								</tr>
								<tr>
									<th></th>
									<td colspan="3"><input type="checkbox"
										value="13" id="chXin26" class="level3" ${relatedDiseasesArr13 eq true ? 'checked' : ''} name="relatedDiseases"
									/>视网膜病变（出血或渗出，乳头水肿）
									</td>
								</tr>
							</table>
						</fieldset>
					</fieldset>
					<fieldset>
						<legend>3.危险分层</legend>
						<table>
						  <colgroup>
							<col style="width:25%;" />
							<col style="width: 40%;" />
							<col style="width:10%;" />
							<col style="width: 25%;" />
						 </colgroup>
							<tr>
								<th ><label>3.高血压危险分层</label></th>
								<td><input type="hidden" id="radioWxHidden" name="hypertensionRiskHierarchy" value="${planInfo.hypertensionRiskHierarchy}" /> <ehr:dic-radio
										dicmeta="DMD00036" name="radioWx" value="${planInfo.hypertensionRiskHierarchy}"
									/></td>
								<td></td>
								<td></td>
							</tr>
						</table>
					</fieldset>
				</div>
				
				
				
			</fieldset>
			<fieldset>
				<legend>处理</legend>
				<table class="posttable">
					<colgroup>
							<col style="width: 20%;" />
							<col style="width: 30%;" />
							<col style="width: 15%;" />
							<col style="width: 35%;" />
						</colgroup>
					<tr>
						<th><label>计划随访</label></th>
						<td><input style="width: 30px;" type="text" value="${planInfo.annualVisitTimes}" name="annualVisitTimes" id="annualVisitTimes" readonly="readonly" />次</td>
						
						<th><label class="required">本社区随访</label></th>
						<td><input id="hbpPlanFollowupTimes" style="width: 30px;" type="text" value="4" name="followupTimes" id="followupTimes" reg='{"required":"true","regex":"digits" ,"max":"12","min":"1"}' readonly="readonly"/>次</td>
					</tr>
					<tr>
						<th><label>处理方案</label></th>
						<td colspan="3"><input type="radio" value="1" ${planInfo.dealType eq '1' ? 'checked' : ''} name="dealType" />非药物量化管理，完成巩固期后再决定是否进行药物治疗</td>
					</tr>
					<tr>
					<th colspan="1"><label></label></th>
						<td colspan="3"><input type="radio" value="2" ${planInfo.dealType eq '2' ? 'checked' : ''} name="dealType" />非药物量化管理，完成强化期后再决定是否进行药物治疗</td>
					</tr>
					<tr>
					<th colspan="1"><label></label></th>
						<td colspan="3"><input type="radio" value="3" ${planInfo.dealType eq '3' ? 'checked' : ''} name="dealType" />非药物量化管理，同时进行药物治疗</td>
					</tr>
					<tr>
					<th colspan="1"><label></label></th>
						<td colspan="3"><input type="radio" value="4" ${planInfo.dealType eq '4' ? 'checked' : ''} name="dealType" />非药物一般管理，同时进行药物治疗</td>
					</tr>
					<tr>
					<th colspan="1"><label></label></th>
						<td colspan="3"><input type="radio" value="5" ${planInfo.dealType eq '5' ? 'checked' : ''} name="dealType" />转诊 <input type="hidden"
							name="id" value="${planInfo.id}"
						/> <input type="hidden" name="diseaseType" value="1" /> <input type="hidden" name="personId" value="${planInfo.personId}" /> <input
							type="hidden" name="idcard" value="${planInfo.idcard}"
						/></td>
					</tr>
					<tr>
						<th><label class="required">制定日期</label></th>
						<td><tag:dateInput style="width:100px;" name="createDate" id="createHbpDate" onlypast="true" date="${planInfo.createDate}"
								reg="{'required':true}"
							/></td>
						<th><label >医生签名</label></th>
						<td><input type="text" style="width: 100px;" value="<ehr:user userCode='${planInfo.createDoctorCode}'></ehr:user>" readonly="readonly"/> </td>
					</tr>
				</table>
			</fieldset>
		</div>
	</div>
</form>