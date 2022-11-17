<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script
	src="${pageContext.request.contextPath}/js/views/cdm/standardization/healthPlan/hbpPlanInfoView.js"
	type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" id="cdm-plan-list-hbp-back-btn"><b
		class="fanhui">返回</b></a>
</div>
<div class="postcontent">
	<i class="popno">高血压患者 <input id="hbpYear" type="text"
		value="${planInfo.conclusionsOfYear}" readonly="readonly"
		style="width: 35px; font-weight: bold" /> 年保健计划
	</i>
	<div class="postdivs">
		<fieldset>
			<legend>诊断结论</legend>
			<div id="tableLinstener">
				<fieldset>
					<legend>1.血压</legend>
					<table>
						<colgroup>
							<col style="width: 20%;" />
							<col style="width: 30%;" />
							<col style="width: 15%;" />
							<col style="width: 35%;" />
						</colgroup>
						<tr>
							<th><label>血压值</label></th>
							<td><label>&nbsp;&nbsp;</label> <input type="text"
								style="width: 35px;" id="txtSbp" readonly="readonly"
								value="${planInfo.sbp}">/ <input type="text"
								style="width: 35px;" id="txtDbp" readonly="readonly"
								value="${planInfo.dbp}">mmHg</td>
							<th><label>分级</label></th>
							<td><input type="text"
								value=" <ehr:dic dicmeta="DMD00025" code="${planInfo.hypertensionManagementLevel}"/>"
								readonly="readonly"></input></td>
						</tr>
					</table>
				</fieldset>
				<fieldset>
					<legend>2.心血管疾病（CVD）危险因素、靶器官损伤和相关疾病部分 </legend>
					<table>
						<colgroup>
							<col style="width: 20%;" />
							<col style="width: 30%;" />
							<col style="width: 15%;" />
							<col style="width: 35%;" />
						</colgroup>
						<tr>
							<td></td>
							<td></td>
							<th><label>分级</label></th>
							<td><input type="text"
								value=" <ehr:dic dicmeta="CV0510013" code="${planInfo.classificationOfHealth}"/>"
								readonly="readonly"></input></td>
						</tr>
					</table>
					<fieldset>
						<legend>
							<label>(1)心血管疾病（CVD）危险因素</label>
						</legend>
						<table class="posttable">
							<colgroup>
								<col style="width: 8%;" />
								<col style="width: 30%;" />
								<col style="width: 15%;" />
								<col style="width: 35%;" />
							</colgroup>
							<tr>
								<th></th>
								<td>
									<c:if test="${cvdElementArr1 eq true}">
										<input type="text" readonly="readonly"
											value="男性 >55岁    女性 >65岁" /><br />
									</c:if>
									 <c:if test="${cvdElementArr2 eq true}">
										<input type="text" readonly="readonly" value="吸烟" /><br />
									</c:if> 
									<c:if test="${cvdElementArr3 eq true}">
										<input type="text" readonly="readonly" value="血脂紊乱" /><br />
									</c:if> 
									<c:if test="${cvdElementArr4 eq true}">
										<input type="text" readonly="readonly"
											value="早发心血管疾病家族史（一级亲属,发病年龄小于50岁）" /><br />
									</c:if> 
									<c:if test="${cvdElementArr5 eq true}">
										<input type="text" readonly="readonly"
											value="腹型肥胖（腹围男≥85cm,女≥80cm或肥胖:BMI>28kg/m²）" /><br />
									</c:if>
									 <c:if test="${cvdElementArr6 eq true}">
										<input type="text" readonly="readonly" value="缺乏体力活动" /><br />
									</c:if> 
									<c:if test="${cvdElementArr7 eq true}">
										<input type="text" readonly="readonly"
											value="高敏C反应蛋白≥3mg/dl或C反应蛋白≥10mg/dl" />
									</c:if>
									<c:if test="${cvdElementArr1 != true && cvdElementArr2 != true && cvdElementArr3 != true && cvdElementArr4 != true && cvdElementArr5 != true && cvdElementArr6 != true && cvdElementArr7 != true}">
										<input type="text" readonly="readonly" value="无"/>
									</c:if>
								</td>
							</tr>

						</table>
					</fieldset>
					<fieldset>
						<legend>
							<label>(2)靶器官损伤</label>
						</legend>
						<table class="posttable">
							<colgroup>
								<col style="width: 8%;" />
								<col style="width: 30%;" />
								<col style="width: 15%;" />
								<col style="width: 35%;" />
							</colgroup>
							<tr>
								<th></th>
								<td>
									<c:if test="${trDamageArr1 eq true}">
										<input type="text" readonly="readonly"
												value="左心室肥厚（心电图、超声心动图LVMI或X线） " /><br />
									</c:if>
		
									<c:if test="${trDamageArr2 eq true}">
										<input type="text" readonly="readonly"
												value="动脉壁增厚（颈动脉IMT≥0.9mm或粥样硬化斑块）  " /><br />
									</c:if>
		
									<c:if test="${trDamageArr3 eq true}">
										<input type="text" readonly="readonly"
												value="血清肌酐轻微升高（男115-133umol/L,女107-124umol/L） " /><br />
									</c:if>
		
									<c:if test="${trDamageArr4 eq true}">
											<input type="text" readonly="readonly"
												value="微量白蛋白尿(30-300mg/24H白蛋白/肌酐比值男≥22 女≥31mg/g)" /><br />
									</c:if>
		
									<c:if test="${trDamageArr5 eq true}">
											<input type="text" readonly="readonly"
												value="空腹血糖 ≥7.0mmol/L" /><br />
									</c:if>
		
									<c:if test="${trDamageArr6 eq true}">
											<input type="text" readonly="readonly"
												value="餐后血浆葡萄糖≥11.1mmol/L " />
									</c:if>
									<c:if test="${trDamageArr1 != true && trDamageArr2 != true && trDamageArr3 != true && trDamageArr4 != true && trDamageArr5 != true && trDamageArr6 != true}">
										<input type="text" readonly="readonly" value="无"/>
									</c:if>
								</td>
							</tr>
						</table>
					</fieldset>
					<fieldset>
						<legend>
							<label>(3)相关疾病</label>
						</legend>
						<table class="posttable">
							<colgroup>
								<col style="width: 8%;" />
								<col style="width: 30%;" />
								<col style="width: 15%;" />
								<col style="width: 35%;" />
							</colgroup>
							<tr>
								<th>脑血管疾病</th>
								<td><c:if test="${relatedDiseasesArr1 eq true}">
										<input type="text" readonly="readonly" value="缺血性脑卒中" />
										<br />
									</c:if> <c:if test="${relatedDiseasesArr2 == true}">
										<input type="text" readonly="readonly" value="脑出血" />
										<br />
									</c:if> <c:if test="${relatedDiseasesArr3 == true}">
										<input type="text" readonly="readonly" value="一过性脑缺血发作" />
									</c:if>
									<c:if test="${relatedDiseasesArr1 != true && relatedDiseasesArr2 != true && relatedDiseasesArr3 != true}">
									 		<input type="text" readonly="readonly" value="无"/>
									</c:if>
								</td>
							</tr>


							<tr>

								<th>心血管疾病</th>
								<td><c:if test="${relatedDiseasesArr4 eq true}">
										<input type="text" readonly="readonly" value="心肌梗死" />
										<br />
									</c:if> <c:if test="${relatedDiseasesArr5 eq true}">
										<input type="text" readonly="readonly" value="心绞痛" />
										<br />
									</c:if> <c:if test="${relatedDiseasesArr6 eq true}">
										<input type="text" readonly="readonly" value="冠脉血运重建" />
										<br />
									</c:if> <c:if test="${relatedDiseasesArr7 eq true}">
										<input type="text" readonly="readonly" value="心力衰竭" />
										<br />
									</c:if>
									<c:if test="${relatedDiseasesArr4 != true && relatedDiseasesArr5 != true && relatedDiseasesArr6 != true && relatedDiseasesArr7 != true}">
									 		<input type="text" readonly="readonly" value="无"/>
									</c:if>
								</td>
							</tr>
							<tr>

								<th>肾脏病变</th>
								<td><c:if test="${relatedDiseasesArr8 eq true}">
										<input type="text" readonly="readonly" value="糖尿病性肾脏病变" />
										<br />
									</c:if> <c:if test="${relatedDiseasesArr9 eq true}">
										<input type="text" readonly="readonly"
											value="肾损害（血清肌酐升高男>133umol/L或女>124 umol/L）" />
										<br />
									</c:if> <c:if test="${relatedDiseasesArr10 eq true}">
										<input type="text" readonly="readonly" value="蛋白尿>300mg/24H" />
										<br />
									</c:if> <c:if test="${relatedDiseasesArr11 eq true}">
										<input type="text" readonly="readonly"
											value="肾功能衰竭（血肌酐浓度177umol/L）" />
										<br />
									</c:if> <c:if test="${relatedDiseasesArr12 eq true}">
										<input type="text" readonly="readonly" value="外周血管病变" />
										<br />
									</c:if> <c:if test="${relatedDiseasesArr13 eq true}">
										<input type="text" readonly="readonly"
											value="视网膜病变（出血或渗出，乳头水肿）" />
									</c:if>
									<c:if test="${relatedDiseasesArr8 != true && relatedDiseasesArr9 != true && relatedDiseasesArr10 != true && relatedDiseasesArr11 != true  && relatedDiseasesArr12 != true  && relatedDiseasesArr13 != true}">
									 		<input type="text" readonly="readonly" value="无"/>
									</c:if>
								</td>

							</tr>


						</table>
					</fieldset>
				</fieldset>
				<fieldset>
					<legend>3.危险分层</legend>
					<table class="posttable">
						<colgroup>
							<col style="width: 20%;" />
							<col style="width: 30%;" />
							<col style="width: 20%;" />
							<col style="width: 30%;" />
						</colgroup>
						<tr>
							<th><label>高血压危险分层</label></th>
							<td><input type="text"
								value=" <ehr:dic dicmeta="DMD00036" code="${planInfo.hypertensionRiskHierarchy}"/>"
								readonly="readonly"></input></td>
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
					<td><input style="width: 30px;" type="text"
						value="${planInfo.annualVisitTimes}" readonly="readonly" />次</td>

					<th><label >本社区随访</label></th>
					<td><input style="width: 30px;" type="text"
						value="${planInfo.followupTimes}" id="followupTimes"
						readonly="readonly" />次</td>
				</tr>
				<tr>
					<th><label>处理方案</label></th>
					<td><input type="text"  style="width: 400px;"
						value=" <ehr:dic dicmeta="DMD00066" code="${planInfo.dealType}"/>"
						readonly="readonly"></input>
					</td>
				</tr>
				<tr>
					<th><label >制定日期</label></th>
					<td><input type="text"
						value='<fmt:formatDate value="${planInfo.createDate}" pattern="yyyy-MM-dd"/>'
						readonly="readonly" style="width: 100px"></input></td>
					<th><label>医生签名</label></th>
					<td>
						<c:choose>
							<c:when test="${planInfo.createDoctorName eq null}">
								<ehr:user userCode='${planInfo.createDoctorCode}'></ehr:user>
							</c:when>
							<c:otherwise>
								${planInfo.createDoctorName}
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</table>
		</fieldset>
	</div>
</div>
