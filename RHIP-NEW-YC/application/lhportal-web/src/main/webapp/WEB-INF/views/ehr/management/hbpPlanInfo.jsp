<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/manage/hbpPlanInfo.js" type="text/javascript"></script>
<fieldset style="font-size: 12px;">	
	<div class="postcontent">
		<i class="popno">高血压患者 <c:out value="${planInfo.conclusionsOfYear}" /> 年保健计划
		</i>
		<div class="postdiv">
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
								<th><label>血压值:</label></th>
								<td><c:out value="${planInfo.sbp}"/>/ <c:out  value="${planInfo.dbp}"/>mmHg</td>
								<th><label>分级:</label> </th>
								<td>
								<input type="hidden" id="radioRbgLevelHidden" name="hypertensionManagementLevel"
									value="${planInfo.hypertensionManagementLevel}"
								/> <ehr:dic dicmeta="DMD00025" code="${planInfo.hypertensionManagementLevel}" /></td>
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
								<th><label>分级:</label></th>
								<td><input type="hidden" id="radioDiseLevelHidden" name="classificationOfHealth" value="${planInfo.classificationOfHealth}" /> 
								<ehr:dic dicmeta="CV0510013" code="${planInfo.classificationOfHealth}"/></td>
							</tr>
						</table>
						<fieldset>
							<legend>
								<label>(1)心血管疾病（CVD）危险因素:</label>
							</legend>
							<table>
								<tr>
									<td><input type="checkbox" value="1" id="chXin1" disabled="disabled" class="level1" ${cvdElementArr0 eq '1' ? 'checked' : ''} name="cvdElement" />男性
										&gt;55岁&nbsp;&nbsp;&nbsp;&nbsp;女性 &gt;65岁</td>
								</tr>
								<tr>
									<td><input type="checkbox" value="2" id="chXin2" disabled="disabled" class="level1" ${cvdElementArr1 eq '2' ? 'checked' : ''} name="cvdElement" />吸烟</td>
								</tr>
								<tr>
									<td><input type="checkbox" value="3" id="chXin3" disabled="disabled" class="level1" ${cvdElementArr2 eq '3' ? 'checked' : ''} name="cvdElement" />血脂紊乱</td>
								</tr>
								<tr>
									<td><input type="checkbox" value="4" id="chXin4" disabled="disabled" class="level1" ${cvdElementArr3 eq '4' ? 'checked' : ''} name="cvdElement" />早发心血管疾病家族史（一级亲属,发病年龄小于50岁）</td>
								</tr>
								<tr>
									<td><input type="checkbox" value="5" id="chXin5" disabled="disabled" class="level1" ${cvdElementArr4 eq '5' ? 'checked' : ''} name="cvdElement" />腹型肥胖（腹围男≥85cm,女≥80cm或肥胖:BMI&gt;28kg/m²）</td>
								</tr>
								<tr>
									<td><input type="checkbox" value="6" id="chXin6" disabled="disabled" class="level1" ${cvdElementArr5 eq '6' ? 'checked' : ''} name="cvdElement" />缺乏体力活动</td>
								</tr>
								<tr>
									<td><input type="checkbox" value="7" id="chXin7" disabled="disabled" class="level1" ${cvdElementArr6 eq '7' ? 'checked' : ''} name="cvdElement" />高敏C反应蛋白≥3mg/dl或C反应蛋白≥10mg/dl</td>
								</tr>
							</table>
						</fieldset>
						<fieldset>
							<legend>
								<label>(2)靶器官损伤:</label>
							</legend>
							<table>
								<tr>
									<td><input type="checkbox" value="1" id="chXin8" class="level2" disabled="disabled" ${trDamageArr0 eq '1' ? 'checked' : ''} name="trDamage" />左心室肥厚（心电图、超声心动图LVMI或X线）
									</td>
								</tr>
								<tr>
									<td><input type="checkbox" value="2" id="chXin9" class="level2" disabled="disabled" ${trDamageArr1 eq '2' ? 'checked' : ''} name="trDamage" />动脉壁增厚（颈动脉IMT≥0.9mm或粥样硬化斑块）
									</td>
								</tr>
								<tr>
									<td><input type="checkbox" value="3" id="chXin10" class="level2" disabled="disabled" ${trDamageArr2 eq '3' ? 'checked' : ''} name="trDamage" />血清肌酐轻微升高（男115-133umol/L,女107-124umol/L）
									</td>
								</tr>
								<tr>
									<td><input type="checkbox" value="4" id="chXin11" class="level2" disabled="disabled" ${trDamageArr3 eq '4' ? 'checked' : ''} name="trDamage" />微量白蛋白尿(30-300mg/24H白蛋白/肌酐比值男≥22
										女≥31mg/g)</td>
								</tr>
								<tr>
									<td><input type="checkbox" value="5" id="chXin12" class="level2" disabled="disabled" ${trDamageArr4 eq '5' ? 'checked' : ''} name="trDamage" />空腹血糖
										≥7.0mmol/L</td>
								</tr>
								<tr>
									<td><input type="checkbox" value="6" id="chXin13" class="level2" disabled="disabled" ${trDamageArr5 eq '6' ? 'checked' : ''} name="trDamage" />餐后血浆葡萄糖≥11.1mmol/L
									</td>
								</tr>
							</table>
						</fieldset>
						<fieldset>
							<legend>
								<label>(3)相关疾病:</label>
							</legend>
							<table>
								<colgroup>
									<col style="width:20%;" />
									<col style="width: 30%;" />
									<col style="width:15%;" />
									<col style="width: 35%;" />
								</colgroup>
								<tr>
									<th>脑血管疾病</th>
									<td colspan="3"><input type="checkbox" value="1" id="chXin14" disabled="disabled" class="level3" ${relatedDiseasesArr0 eq '1' ? 'checked' : ''}
										name="relatedDiseases"
									/>缺血性脑卒中
									</td>
								</tr>
								<tr>
									<th></th>
									<td colspan="3"><input type="checkbox"  disabled="disabled"
										value="2" id="chXin15" class="level3" ${relatedDiseasesArr1 eq '2' ? 'checked' : ''} name="relatedDiseases"
									/>脑出血
									</td>
								</tr>
								<tr>
									<th></th>
									<td colspan="3"><input type="checkbox"  disabled="disabled"
										value="3" id="chXin16" class="level3" ${relatedDiseasesArr2 eq '3' ? 'checked' : ''} name="relatedDiseases"
									/>一过性脑缺血发作
									</td>
								</tr>
								<tr>
									<th>心血管疾病</th>
									<td colspan="3"><input type="checkbox" value="4"  disabled="disabled" id="chXin17" class="level3" ${relatedDiseasesArr3 eq '4' ? 'checked' : ''}
										name="relatedDiseases"
									/>心肌梗死
									</td>
								</tr>
								<tr>
									<th></th>
									<td colspan="3"><input type="checkbox"
										value="5" id="chXin18" class="level3"  disabled="disabled" ${relatedDiseasesArr4 eq '5' ? 'checked' : ''} name="relatedDiseases"
									/>心绞痛
									</td>
								</tr>
								<tr>
									<th></th>
									<td colspan="3"><input type="checkbox"
										value="6" id="chXin19" class="level3"  disabled="disabled" ${relatedDiseasesArr5 eq '6' ? 'checked' : ''} name="relatedDiseases"
									/>冠脉血运重建
									</td>
								</tr>
								<tr>
									<th></th>
									<td colspan="3"><input type="checkbox"
										value="7" id="chXin20" class="level3"  disabled="disabled" ${relatedDiseasesArr6 eq '7' ? 'checked' : ''} name="relatedDiseases"
									/>心力衰竭
									</td>
								</tr>
								<tr>
									<th>肾脏病变</th>
									<td colspan="3"><input type="checkbox"  disabled="disabled" value="8" id="chXin21" class="level3" ${relatedDiseasesArr7 eq '8' ? 'checked' : ''}
										name="relatedDiseases"
									/>糖尿病性肾脏病变
									</td>
								</tr>
								<tr>
									<th></th>
									<td colspan="3"><input type="checkbox"
										value="9" id="chXin22" class="level3"  disabled="disabled" ${relatedDiseasesArr8 eq '9' ? 'checked' : ''} name="relatedDiseases"
									/>肾损害（血清肌酐升高男＞133 umol/L或女＞124 umol/L）
									</td>
								</tr>
								<tr>
									<th></th>
									<td colspan="3"><input type="checkbox"
										value="10" id="chXin23" class="level3"  disabled="disabled" ${relatedDiseasesArr9 eq '10' ? 'checked' : ''} name="relatedDiseases"
									/>蛋白尿＞300mg/24H
									</td>
								</tr>
								<tr>
									<th></th>
									<td colspan="3"> <input type="checkbox"
										value="11" id="chXin24" class="level3" disabled="disabled" ${relatedDiseasesArr10 eq '11' ? 'checked' : ''} name="relatedDiseases"
									/>肾功能衰竭,血肌酐浓度177umol/L
									</td>
								</tr>
								<tr>
									<th></th>
									<td colspan="3"><input type="checkbox"
										value="12" id="chXin25" class="level3" disabled="disabled" ${relatedDiseasesArr11 eq '12' ? 'checked' : ''} name="relatedDiseases"
									/>外周血管病变
									</td>
								</tr>
								<tr>
									<th></th>
									<td colspan="3"><input type="checkbox"
										value="13" id="chXin26" class="level3" disabled="disabled" ${relatedDiseasesArr12 eq '13' ? 'checked' : ''} name="relatedDiseases"
									/>视网膜病变（出血或渗出，乳头水肿）
									</td>
								</tr>
							</table>
						</fieldset>
					</fieldset>
					<fieldset>
						<legend>3.危险分层</legend>
						<table>
							<tr>
								<td colspan="1"><label>3.高血压危险分层:</label></td>
								<td><input type="hidden" id="radioWxHidden" name="hypertensionRiskHierarchy" value="${planInfo.hypertensionRiskHierarchy}" /> 
								<ehr:dic dicmeta="DMD00036" code="${planInfo.hypertensionRiskHierarchy}" /></td>
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
						<th><label>计划随访:</label></th>
						<td><c:out value="${planInfo.annualVisitTimes}"></c:out>次</td>
					</tr>
					<tr>
						<th><label>本社区随访:</label></th>
						<td><c:out value="${planInfo.followupTimes}"/>次</td>
					</tr>
					<tr>
						<td></td>
						<td colspan="3"><input type="radio" value="1" ${planInfo.dealType eq '1' ? 'checked' : ''} disabled="disabled" name="dealType" />非药物量化管理，完成巩固期后再决定是否进行药物治疗</td>
					</tr>
					<tr>
					<td></td>
						<td colspan="3"><input type="radio" value="2" ${planInfo.dealType eq '2' ? 'checked' : ''} disabled="disabled" name="dealType" />非药物量化管理，完成强化期后再决定是否进行药物治疗</td>
					</tr>
					<tr>
					<td></td>
						<td colspan="3"><input type="radio" value="3" ${planInfo.dealType eq '3' ? 'checked' : ''} disabled="disabled" name="dealType" />非药物量化管理，同时进行药物治疗</td>
					</tr>
					<tr>
					<td></td>
						<td colspan="3"><input type="radio" value="4" ${planInfo.dealType eq '4' ? 'checked' : ''} disabled="disabled" name="dealType" />非药物一般管理，同时进行药物治疗</td>
					</tr>
					<tr>
					<td></td>
						<td colspan="3"><input type="radio" value="5" ${planInfo.dealType eq '5' ? 'checked' : ''} disabled="disabled" name="dealType" />转诊 <input type="hidden"
							name="id" value="${planInfo.id}"
						/></td>
					</tr>
					<tr>
						<th><label>制定日期：</label></th>
						<td><fmt:formatDate value="${planInfo.createDate}" pattern="yyyy/MM/dd" /></td>
						<th><label>医生签名：</label></th>
						<td>
							<ehr:user userCode='${planInfo.createDoctorCode}'></ehr:user>
						</td>
					</tr>
				</table>
			</fieldset>
		</div>
	</div>
</fieldset>
