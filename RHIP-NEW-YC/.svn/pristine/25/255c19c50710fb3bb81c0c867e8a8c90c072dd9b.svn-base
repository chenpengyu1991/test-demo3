<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script
	src="${pageContext.request.contextPath}/js/views/idm/case/edit.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/views/idm/case/apf.js"
	type="text/javascript"></script>
<c:if test="${isPrint != 1}">
    <jsp:include page="../caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
	<input type="hidden" name="caseInformation.modifySurveyOrg" value="${caseDto.caseInformation.modifySurveyOrg}"/>
	<div class="postcontent <c:if test="${isPrint != 1}">contentfixed32</c:if>">
		<i class="popno"> 急性弛缓性麻痹病例个案调查表<br /> <span>（乙类传染病脊髓灰质炎监测病例）</span>
		</i> <input type="hidden" name="idmId" value="${idmId}" id="idmId" />
		<table class="posttable">
			<tr>
				<td>省级CDC收到本表的时间：
					<%--<tag:dateInput
						name="caseInformation.provinceSurveyDate"
						date="${caseDto.caseInformation.provinceSurveyDate }"
						style="width: 160px;">
					</tag:dateInput>--%>
					<input type="text" id="provinceSurveyDateId" name="caseInformation.provinceSurveyDate" value='<fmt:formatDate value="${caseDto.caseInformation.provinceSurveyDate}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
			</tr>
		</table>
		<div class="postdiv">
			<fieldset>
				<legend>1. 编号</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 18%" />
						<col style="width: 32%" />
						<col style="width: 18%" />
						<col style="width: 32%" />
					</colgroup>
					<tr>
						<th>a. 病例编号：</th>
						<td><input type="text" name="caseInformation.mediRecordNum"
							value="${caseDto.caseInformation.mediRecordNum}"
							reg='{"maxlength":"14"}' /></td>
						<th>b. 调查日期：</th>
						<td>
							<input type="text" id="surveyDateId" name="caseInformation.surveyDate" value='<fmt:formatDate value="${caseDto.caseInformation.surveyDate}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
						</td>
					</tr>
					<tr>
						<th>c. 调查单位：</th>
						<td><ehr:dic-radio dicmeta="IDM00115"
								name="caseInformation.surveyOrgGrade"
								value="${caseDto.caseInformation.surveyOrgGrade}" /></td>
						<th>d. 调查人：</th>
						<td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}" /></td>
					</tr>
					 <tr style="display:none;">
		                 <td>
		                 	<input type="hidden" name="caseInformation.modifyRespondents" value="${caseDto.caseInformation.modifyRespondents}"/>
		                 	<input type="hidden" name="caseInformation.auditor" value="${caseDto.caseInformation.auditor}"/>
		                 </td> 
		             </tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>2. 基本情况</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 18%" />
						<col style="width: 32%" />
						<col style="width: 18%" />
						<col style="width: 32%" />
					</colgroup>
					<tr>
						<th>a 姓名：</th>
						<td><input type="text" name="generalCondition.name"
							value="${caseDto.generalCondition.name }"
							reg='{"maxlength":"100"}' /></td>
						<th>b 性别：</th>
						<td><ehr:dic-radio name="generalCondition.gender"
								dicmeta="GBT226112003"
								value="${caseDto.generalCondition.gender}" code="1,2" /></td>
					</tr>
					<tr>
						<th>c. 民族：</th>
						<td><input type="text" name="generalCondition.nationOther"
							value="${caseDto.generalCondition.nationOther}"
							reg='{"maxlength":"20"}' /></td>
						<th>d. 出生日期(公历)：</th>
						<td>
							<input type="text" id="birthdayId" name="generalCondition.birthday" value='<fmt:formatDate value="${caseDto.generalCondition.birthday}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
						</td>
					</tr>
					<tr>
						<th>e. 如无出生日期,年龄：</th>
						<td><input type="text" name="generalCondition.age"
							value="${caseDto.generalCondition.age }" style="width: 40px"
							reg='{"maxlength":"6"}' />&nbsp;&nbsp;年龄单位<ehr:dic-radio
								dicmeta="IDM00003" name="generalCondition.ageUnit"
								value="${caseDto.generalCondition.ageUnit }"></ehr:dic-radio></td>
						<th>f. 居住状况：</th>
						<td><ehr:dic-list name="generalCondition.livingConditions"
								dicmeta="IDM00252"
								value="${caseDto.generalCondition.livingConditions }"></ehr:dic-list>
							<input id="livingConditionsOther" type="text" name="generalCondition.livingConditionsOther" value="${caseDto.generalCondition.livingConditionsOther}" style="width:100px">
						</td>
					</tr>
					 <tr>
                    	<th>常住类型：</th>
                    	<td>
		            		<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
                        		value="${caseDto.generalCondition.floatPopulation}" onchange="caseEdit.toggerAddress()"/>
                    	</td>
                    </tr>
					<tr>
						<th>g. 病人详细地址：</th>
                        <td colspan="3">
                             <ehr:dic-town-street-village streetId="pastreet_address" townId="patown_address" streetName="generalCondition.pastreet" townName="generalCondition.patownShip"
														streetValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="140px;"
														villageId="pavillage_address" villageName="generalCondition.paGroup" villageValue="${caseDto.generalCondition.paGroup}"/>
						    <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
			                        reg='{"maxlength":"50"}'  style="width: 180px;">
			             	<span id="spanPaNumber">(门牌号)</span>
                        </td>
					</tr>
					<tr>
						<th>h. 家长姓名：</th>
						<td><input type="text" name="generalCondition.parentsName"
							value="${caseDto.generalCondition.parentsName }"
							reg='{"maxlength":"50"}' /></td>
						<th>i. 家长工作单位：</th>
						<td><input type="text" name="generalCondition.parentsUnit"
							value="${caseDto.generalCondition.parentsUnit }"
							reg='{"maxlength":"20"}' /></td>
					</tr>
					<tr>
						<th>j. 家长电话号码：</th>
						<td><input type="text" name="generalCondition.parentsPhone"
							value="${caseDto.generalCondition.parentsPhone }"
							reg='{"regex":"phone","maxlength":"20"}' /></td>
						<th>k. 病例报告单位级别：</th>
						<td><ehr:dic-list name="caseInformation.reportUnitType"
								dicmeta="IDM00004"
								value="${caseDto.caseInformation.reportUnitType }"
								uninclude="99" /></td>
					</tr>
					<tr>
						<th>l. 病例报告单位名称：</th>
						<td>
                            <ehr:org code="${caseDto.caseInformation.reportOrg}" />
                            <input type="hidden" value="${caseDto.caseInformation.reportOrg}" name="caseInformation.reportOrg">
                        </td>
						<th>m. 病例报告日期：</th>
						<td>
                            <fmt:formatDate value='${caseDto.caseInformation.reportDate}' pattern="yyyy/MM/dd" />
                            <tag:dateInput nullToToday="true" name="caseInformation.reportDate" onlypast="true" pattern="yyyy/MM/dd"
                                               date="${caseDto.caseInformation.reportDate}" style="display: none" />
                        </td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>3. 临床症状和体征</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 25%" />
						<col style="width: 25%" />
						<col style="width: 25%" />
						<col style="width: 25%" />
					</colgroup>
					<tr>
						<th>麻痹出现前症状：</th>
					</tr>
					<tr>
						<th>a. 发热：</th>
						<td><ehr:dic-radio dicmeta="PH00002"
								name="clinicalManifestations.fever"
								value="${caseDto.clinicalManifestations.fever }" uninclude="3,5" /></td>
						<th>b. 腹泻：</th>
						<td><ehr:dic-radio dicmeta="PH00002"
								name="clinicalManifestations.diarrhea"
								value="${caseDto.clinicalManifestations.diarrhea }"
								uninclude="3,5" /></td>
					</tr>
					<tr>
						<th>c. 颈项强直：</th>
						<td><ehr:dic-radio dicmeta="PH00002"
								name="clinicalManifestations.neckRigidity"
								value="${caseDto.clinicalManifestations.neckRigidity }"
								uninclude="3,5" /></td>
						<th>d. 肌肉疼痛：</th>
						<td><ehr:dic-radio dicmeta="PH00002"
								name="clinicalManifestations.muscularStiffness"
								value="${caseDto.clinicalManifestations.muscularStiffness }"
								uninclude="3,5" /></td>
					</tr>
					<tr>
						<th>e. 3天内注射史：</th>
						<td><ehr:dic-radio dicmeta="PH00002"
								name="clinicalManifestations.threeDaysInjectionHistory"
								value="${caseDto.clinicalManifestations.threeDaysInjectionHistory }"
								code="1,2" /></td>
						<th>f. 麻痹出现日期：</th>
						<td>
							<input type="text" id="paralysisAppearDateId" name="clinicalManifestations.paralysisAppearDate" value='<fmt:formatDate value="${caseDto.clinicalManifestations.paralysisAppearDate}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
						</td>
					</tr>
					<tr>
						<th>麻痹部位及程度：</th>
					</tr>
					<tr>
						<th>g. 左上肢：</th>
						<td><ehr:dic-list
								name="clinicalManifestations.leftUpperExtremity"
								value="${caseDto.clinicalManifestations.leftUpperExtremity }"
								dicmeta="IDM00116" /></td>
						<th>h. 右上肢：</th>
						<td><ehr:dic-list
								name="clinicalManifestations.rightUpperExtremity"
								value="${caseDto.clinicalManifestations.rightUpperExtremity }"
								dicmeta="IDM00116" /></td>
					</tr>
					<tr>
						<th>i. 左下肢：</th>
						<td><ehr:dic-list
								name="clinicalManifestations.leftLowerExtremity"
								value="${caseDto.clinicalManifestations.leftLowerExtremity }"
								dicmeta="IDM00116" /></td>
						<th>j. 右下肢：</th>
						<td><ehr:dic-list
								name="clinicalManifestations.rightLowerExtremity"
								value="${caseDto.clinicalManifestations.rightLowerExtremity }"
								dicmeta="IDM00116" /></td>
					</tr>
					<tr>
						<th>k. 呼吸困难：</th>
						<td><ehr:dic-list name="clinicalManifestations.dyspneaType"
								dicmeta="IDM00117"
								value="${caseDto.clinicalManifestations.dyspneaType }" /></td>
						<th>l. 肢体感觉障碍：</th>
						<td><ehr:dic-radio dicmeta="PH00002"
								name="clinicalManifestations.bodyObstacle"
								value="${caseDto.clinicalManifestations.bodyObstacle }"
								uninclude="3,5" /></td>
					</tr>
					<tr>
						<th>m. 大小便失禁：</th>
						<td><ehr:dic-radio dicmeta="PH00002"
								name="clinicalManifestations.gatism"
								value="${caseDto.clinicalManifestations.gatism }" code="1,2" /></td>
						<th>n. 巴彬斯基氏反射：</th>
						<td><ehr:dic-radio dicmeta="PH00002"
								name="clinicalManifestations.babinskiReflection" uninclude="3,5"
								value="${caseDto.clinicalManifestations.babinskiReflection }" /></td>
					</tr>
					<tr>
						<th>o. 踝阵挛：</th>
						<td><ehr:dic-radio dicmeta="PH00002"
								name="clinicalManifestations.ankkclonus"
								value="${caseDto.clinicalManifestations.ankkclonus }"
								uninclude="3,5" /></td>
						<th>p. 深部腱反射：</th>
						<td><ehr:dic-list
								name="clinicalManifestations.deepTendonReflex"
								dicmeta="IDM00118"
								value="${caseDto.clinicalManifestations.deepTendonReflex }" /></td>
					</tr>
					<tr>
						<th>q. 最初麻痹时伴发热（>37℃）：</th>
						<td><ehr:dic-radio dicmeta="PH00002"
								name="clinicalManifestations.firstAttackFever"
								value="${caseDto.clinicalManifestations.firstAttackFever }"
								uninclude="3,5" /></td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>4. 麻痹后就诊情况（含本次就诊）</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 25%" />
						<col style="width: 25%" />
						<col style="width: 18%" />
						<col style="width: 32%" />
					</colgroup>
					<tr>
						<th>a. 就诊次数：</th>
						<td><ehr:dic-list name="clinicalManifestations.clinicTimes"
								value="${caseDto.clinicalManifestations.clinicTimes }"
								dicmeta="IDM00119" /></td>
						<th>b. 本次就诊日期：</th>
						<td>
							<input type="text" id="thisClinicDateId" name="clinicalManifestations.thisClinicDate" value='<fmt:formatDate value="${caseDto.clinicalManifestations.thisClinicDate}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
<%--							<tag:dateInput
								name="clinicalManifestations.thisClinicDate"
								pattern="yyyy/MM/dd"
								date="${caseDto.clinicalManifestations.thisClinicDate }" />--%>
						</td>
					</tr>
					<tr>
						<th>c. 本次就诊的诊断结果：</th>
						<td><ehr:dic-radio dicmeta="IDM00120"
								name="clinicalManifestations.thisClinicDiagnosis" uninclude="4"
								value="${caseDto.clinicalManifestations.thisClinicDiagnosis }" /></td>
					</tr>
					<tr>
						<th>d. 麻痹后第一次就诊：</th>
					</tr>
					<tr>
						<th>1) 就诊单位：</th>
						<td><ehr:dic-list name="clinicalManifestations.medicalOrgF"
								dicmeta="IDM00004"
								value="${caseDto.clinicalManifestations.medicalOrgF }"
								uninclude="99" /></td>
						<th>2) 就诊日期：</th>
						<td>
							<input type="text" id="clinicDateFId" name="clinicalManifestations.clinicDateF" value='<fmt:formatDate value="${caseDto.clinicalManifestations.clinicDateF}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
<%--							<tag:dateInput name="clinicalManifestations.clinicDateF"
								pattern="yyyy/MM/dd"
								date="${caseDto.clinicalManifestations.clinicDateF }" />--%>
						</td>
					</tr>
					<tr>
						<th>3) 诊断结果：</th>
						<td><ehr:dic-radio dicmeta="IDM00120"
								name="clinicalManifestations.diagnosisF"
								value="${caseDto.clinicalManifestations.diagnosisF}"
								uninclude="4" /></td>
						<th>4) 是否报告：</th>
						<td><ehr:dic-radio dicmeta="PH00002"
								name="clinicalManifestations.isReportF"
								value="${caseDto.clinicalManifestations.isReportF }" code="1,2" /></td>
					</tr>
					<tr>
						<th>e. 麻痹后第一次到县及县以上级医院就诊情况：</th>
					</tr>
					<tr>
						<th>1) 就诊日期：</th>
						<td>
							<input type="text" id="clinicDateLId" name="clinicalManifestations.clinicDateL" value='<fmt:formatDate value="${caseDto.clinicalManifestations.clinicDateL}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
							<%--<tag:dateInput name="clinicalManifestations.clinicDateL"
								pattern="yyyy/MM/dd"
								date="${caseDto.clinicalManifestations.clinicDateL }" />--%>
						</td>
						<th>2) 诊断结果：</th>
						<td><ehr:dic-radio dicmeta="IDM00120"
								name="clinicalManifestations.diagnosisL"
								value="${caseDto.clinicalManifestations.diagnosisL}"
								uninclude="4" /></td>
					</tr>
					<tr>
						
						<th>3) 是否报告：</th>
						<td><ehr:dic-radio dicmeta="PH00002"
								name="clinicalManifestations.isReportL"
								value="${caseDto.clinicalManifestations.isReportL }" code="1,2" /></td>
					</tr>
					<tr>
						<th>f. 如住院治疗：</th>
					</tr>
					<tr>
						<th>1) 医院类别：</th>
						<td><ehr:dic-list name="clinicalManifestations.hospitalType"
								dicmeta="IDM00004"
								value="${caseDto.clinicalManifestations.hospitalType }"
								uninclude="99" /></td>
						<th>2) 医院名称：</th>
						<td><input type="text"
							name="clinicalManifestations.hospitalName"
							value="${caseDto.clinicalManifestations.hospitalName }"
							reg='{"maxlength":"50"}' /></td>
					</tr>
					<tr>
						<th>3) 病案编号：</th>
						<td><input type="text"
							name="clinicalManifestations.medicalRecordNum"
							value="${caseDto.clinicalManifestations.medicalRecordNum }"
							reg='{"maxlength":"100"}' /></td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>5. 初步调查结果</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 80%" />
					</colgroup>
					<tr>
						<th>a. 是否是AFP病例：</th>
						<td><ehr:dic-radio dicmeta="PH00001" name="diagnosis.afp"
								code="1,2" value="${caseDto.diagnosis.afp }" /></td>
					</tr>
					<tr id="afpCategory" style="display: none">
						<th>1) 如是：</th>
						<td><ehr:dic-list name="diagnosis.afpCategory"
								dicmeta="IDM00121" value="${caseDto.diagnosis.afpCategory }" uninclude="3,7"/><input
							id="afpOther" type="text" name="diagnosis.afpOther"
							value="${caseDto.diagnosis.afpOther }" style="width: 100px" reg='{"maxlength":"100"}'/></td>
					</tr>
					<tr id="unAfp" style="display: none">
						<th>2) 如否：</th>
						<td><ehr:dic-list name="diagnosis.unAfp" dicmeta="IDM00122"
								value="${caseDto.diagnosis.unAfp }" /><input id="unAfpOther"
							type="text" name="diagnosis.unAfpOther"
							value="${caseDto.diagnosis.unAfpOther }" style="width: 100px" reg='{"maxlength":"100"}'/></td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>6. 免疫史</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 18%" />
						<col style="width: 32%" />
						<col style="width: 18%" />
						<col style="width: 32%" />
					</colgroup>
					<tr>
						<th>a. 累计服脊灰疫苗次数：</th>
						<td><ehr:dic-list name="epidemiologicalSurvey.opvNum"
								dicmeta="IDM00251"
								value="${caseDto.epidemiologicalSurvey.opvNum }" uninclude="3"></ehr:dic-list></td>
					</tr>
					<tr>
						<th>b. 服苗依据：</th>
						<td><ehr:dic-list dicmeta="IDM00069"
								name="epidemiologicalSurvey.immunizationHistorySource"
								code="1,2,6"
								value="${caseDto.epidemiologicalSurvey.immunizationHistorySource }" /></td>
					</tr>
					<tr>
						<th>c. 麻痹前最近一次服苗 1) 日期：</th>
						<td>
							<input type="text" id="palsyLastDtId" name="epidemiologicalSurvey.palsyLastDt" value='<fmt:formatDate value="${caseDto.epidemiologicalSurvey.palsyLastDt}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
							<%--<tag:dateInput name="epidemiologicalSurvey.palsyLastDt"
								pattern="yyyy/MM/dd"
								date="${caseDto.epidemiologicalSurvey.palsyLastDt }" />--%>
						</td>
						<th>2) 服苗形式：</th>
						<td><ehr:dic-list dicmeta="IDM00123"
								name="epidemiologicalSurvey.immunizationHistoryForm"
								value="${caseDto.epidemiologicalSurvey.immunizationHistoryForm }" /><input
							type="text" id="immuniHistoryFormOther"
							name="epidemiologicalSurvey.immuniHistoryFormOther"
							value="${caseDto.epidemiologicalSurvey.immuniHistoryFormOther }"
							style="width: 100px" /></td>
					</tr>
					<tr>
						<th>d．采便前最近一次服苗 1) 日期：</th>
						<td>
							<input type="text" id="stoolLastDtId" name="epidemiologicalSurvey.stoolLastDt" value='<fmt:formatDate value="${caseDto.epidemiologicalSurvey.stoolLastDt}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
							<%--<tag:dateInput name="epidemiologicalSurvey.stoolLastDt"
								pattern="yyyy/MM/dd"
								date="${caseDto.epidemiologicalSurvey.stoolLastDt }" />--%>
						</td>
					</tr>
					<tr>
						<th>e. 未全程免疫主要原因：</th>
						<td><ehr:dic-list dicmeta="IDM00084"
								name="epidemiologicalSurvey.unvaccinatedReason"
								uninclude="5,6,7"
								value="${caseDto.epidemiologicalSurvey.unvaccinatedReason }" /><input
							type="text" name="epidemiologicalSurvey.unvaccinatedReasonOther"
							value="${caseDto.epidemiologicalSurvey.unvaccinatedReasonOther }"
							id="unvaccinatedReasonOther" style="width: 200px" reg='{"maxlength":"100"}'/></td>
					</tr>
					<tr>
						<th>f. 详细接种史：</th>
					</tr>
					<tr>
						<th>第一剂次：</th>
					</tr>
					<tr>
						<th>1)  日期：</th>
						<td>
							<input type="text" id="hepatitisBVaccineDtFId" name="epidemiologicalSurvey.hepatitisBVaccineDtF" value='<fmt:formatDate value="${caseDto.epidemiologicalSurvey.hepatitisBVaccineDtF}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
							<%--<tag:dateInput name="epidemiologicalSurvey.hepatitisBVaccineDtF"
								pattern="yyyy/MM/dd"
								date="${caseDto.epidemiologicalSurvey.hepatitisBVaccineDtF}" />--%>
						</td>
					</tr>
					<tr>
						<th>2)	接种苗类型：</th>
						<%-- <td><input type="text"
							name="clinicalManifestations.medicalRecordNum"
							value="${caseDto.clinicalManifestations.medicalRecordNum }"
							reg='{"maxlength":"100"}' /></td> --%>
					</tr>
					<tr>
						<th>3)  服苗形式: </th>
						<td><ehr:dic-list dicmeta="IDM00123"
								name="epidemiologicalSurvey.immunizationHistoryFormF"
								value="${caseDto.epidemiologicalSurvey.immunizationHistoryFormF }" /><input
							type="text" id="immuniHistoryFormFOther"
							name="epidemiologicalSurvey.immuniHistoryFormFOther"
							value="${caseDto.epidemiologicalSurvey.immuniHistoryFormFOther }"
							style="width: 100px" /></td>
					</tr>
					<tr>
						<th>第二剂次：</th>
					</tr>
					<tr>
						<th>1)  日期： </th>
						<td>
							<input type="text" id="hepatitisBVaccineDtSId" name="epidemiologicalSurvey.hepatitisBVaccineDtS" value='<fmt:formatDate value="${caseDto.epidemiologicalSurvey.hepatitisBVaccineDtS}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
							<%--<tag:dateInput name="epidemiologicalSurvey.hepatitisBVaccineDtS"
								pattern="yyyy/MM/dd"
								date="${caseDto.epidemiologicalSurvey.hepatitisBVaccineDtS}" />--%>
						</td>
					</tr>
					<tr>
						<th>2)	接种苗类型：</th>
						<%-- <td><input type="text"
							name="clinicalManifestations.medicalRecordNum"
							value="${caseDto.clinicalManifestations.medicalRecordNum }"
							reg='{"maxlength":"100"}' /></td> --%>
					</tr>
					<tr>
						<th>3)  服苗形式: </th>
						<td><ehr:dic-list dicmeta="IDM00123"
								name="epidemiologicalSurvey.immunizationHistoryFormS"
								value="${caseDto.epidemiologicalSurvey.immunizationHistoryFormS }" /><input
							type="text" id="immuniHistoryFormSOther"
							name="epidemiologicalSurvey.immuniHistoryFormSOther"
							value="${caseDto.epidemiologicalSurvey.immuniHistoryFormSOther}"
							style="width: 100px" /></td>
					</tr>
					<tr>
						<th>第三剂次：</th>
					</tr>
					<tr>
						<th>1)  日期： </th>
						<td>
							<input type="text" id="hepatitisBVaccineDtTId" name="epidemiologicalSurvey.hepatitisBVaccineDtT" value='<fmt:formatDate value="${caseDto.epidemiologicalSurvey.hepatitisBVaccineDtT}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
							<%--<tag:dateInput name="epidemiologicalSurvey.hepatitisBVaccineDtT"
								pattern="yyyy/MM/dd"
								date="${caseDto.epidemiologicalSurvey.hepatitisBVaccineDtT}" />--%>
						</td>
					</tr>
					<tr>
						<th>2)	接种苗类型：</th>
						<%-- <td><input type="text"
							name="clinicalManifestations.medicalRecordNum"
							value="${caseDto.clinicalManifestations.medicalRecordNum }"
							reg='{"maxlength":"100"}' /></td> --%>
					</tr>
					<tr>
						<th>3)  服苗形式: </th>
						<td><ehr:dic-list dicmeta="IDM00123"
								name="epidemiologicalSurvey.immunizationHistoryFormT"
								value="${caseDto.epidemiologicalSurvey.immunizationHistoryFormT }" />
								<input
									type="text" id="immuniHistoryFormTOther"
									name="epidemiologicalSurvey.immuniHistoryFormTOther"
									value="${caseDto.epidemiologicalSurvey.immuniHistoryFormTOther}"
									style="width: 100px" /></td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>7. 实验室资料</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 18%" />
						<col style="width: 32%" />
						<col style="width: 18%" />
						<col style="width: 32%" />
					</colgroup>
					<tr>
						<th>a. 第一份粪便标本：</th>
					</tr>
					<tr>
						<th>1) 采集日期：</th>
						<td>
							<input type="text" id="stoolCollecttime1Id" name="labExamine.stoolCollecttime_1" value='<fmt:formatDate value="${caseDto.labExamine.stoolCollecttime_1}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
							<%--<tag:dateInput name="labExamine.stoolCollecttime_1"
								pattern="yyyy/MM/dd"
								date="${caseDto.labExamine.stoolCollecttime_1 }" />--%>
						</td>
						<th>2) 采集人姓名：</th>
						<td><input type="text" name="labExamine.stoolCollectname_1"
							value="${caseDto.labExamine.stoolCollectname_1 }"
							reg='{"maxlength":"50"}' /></td>
					</tr>
					<tr>
						<th>3) 采集人单位：</th>
						<td><input type="text" name="labExamine.stoolCollectunit_1"
							value="${caseDto.labExamine.stoolCollectunit_1 }"
							reg='{"maxlength":"100"}' /></td>
						<th>4) 省级实验室收到粪便日期：</th>
						<td>
							<input type="text" id="provincialReceiveDate1Id" name="labExamine.provincialReceiveDate_1" value='<fmt:formatDate value="${caseDto.labExamine.provincialReceiveDate_1}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
							<%--<tag:dateInput name="labExamine.provincialReceiveDate_1"
								date="${caseDto.labExamine.provincialReceiveDate_1 }"
								pattern="yyyy/MM/dd" />--%>
						</td>
					</tr>
					<tr>
						<th>5) 标本是否带冰运送：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.withIceFlg_1"
								value="${caseDto.labExamine.withIceFlg_1 }" code="1,2" /></td>
						<th>6) 标本状态：</th>
						<td><ehr:dic-radio dicmeta="FS10129"
								name="labExamine.sampleStatus_1"
								value="${caseDto.labExamine.sampleStatus_1 }" code="1,3" /></td>
					</tr>
					<tr>
						<th>7) 标本量：</th>
						<td><ehr:dic-list name="labExamine.sampleNumberFlag_1"
								dicmeta="PH00002" code="1,4"
								value="${caseDto.labExamine.sampleNumberFlag_1 }"></ehr:dic-list>
							<span style="display: none" id="sampleNumber_1">约 <input
								type="text" name="labExamine.sampleNumber_1"
								value="${caseDto.labExamine.sampleNumber_1 }"
								style="width: 180px"
								reg='{"regx":"number", "scale":"1", "min":0, "max":9999}' />克
						</span></td>
						<th>8) 是否进行病毒分离：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.viralIsolationFlg_1" code="1,2"
								value="${caseDto.labExamine.viralIsolationFlg_1 }" /></td>
					</tr>
					<tr>
						<th>9) 标本接种日期：</th>
						<td>
							<input type="text" id="vaccinateDate1Id" name="labExamine.vaccinateDate_1" value='<fmt:formatDate value="${caseDto.labExamine.vaccinateDate_1}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
							<%--<tag:dateInput name="labExamine.vaccinateDate_1"
								pattern="yyyy/MM/dd"
								date="${caseDto.labExamine.vaccinateDate_1 }" />--%>
						</td>
						<th>10) 是否进行脊灰病毒分型：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.poliovirusGroupFlg_1" code="1,2"
								value="${caseDto.labExamine.poliovirusGroupFlg_1 }" /></td>
					</tr>
					<tr>
						<th>11) Ⅰ型病毒：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.viralType_1_1"
								value="${caseDto.labExamine.viralType_1_1 }" code="1,2" /></td>
						<th>12) Ⅱ型病毒：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.viralType_2_1"
								value="${caseDto.labExamine.viralType_2_1 }" code="1,2" /></td>
					</tr>
					<tr>
						<th>13) Ⅲ型病毒：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.viralType_3_1"
								value="${caseDto.labExamine.viralType_3_1 }" code="1,2" /></td>
						<th>14) 其它肠道病毒：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.otherEnterovirus_1"
								value="${caseDto.labExamine.otherEnterovirus_1 }" code="1,2" /></td>
					</tr>
					<tr>
						<th>15) 检验结果报告日期：</th>
						<td>
							<input type="text" id="resultReportDate1Id" name="labExamine.resultReportDate_1" value='<fmt:formatDate value="${caseDto.labExamine.resultReportDate_1}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
							<%--<tag:dateInput name="labExamine.resultReportDate_1"
								date="${caseDto.labExamine.resultReportDate_1 }"
								pattern="yyyy/MM/dd" />--%>
						</td>
						<th>16) 国家级实验室收到分离物日期：</th>
						<td>
							<input type="text" id="nationalReceiveDate1Id" name="labExamine.nationalReceiveDate_1" value='<fmt:formatDate value="${caseDto.labExamine.nationalReceiveDate_1}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
							<%--<tag:dateInput name="labExamine.nationalReceiveDate_1"
								date="${caseDto.labExamine.nationalReceiveDate_1 }"
								pattern="yyyy/MM/dd" />--%>
						</td>
					</tr>
					<tr>
						<th>17) 收到国家级实验室结果日期：</th>
						<td>
							<input type="text" id="nationalReportDate1Id" name="labExamine.nationalReportDate_1" value='<fmt:formatDate value="${caseDto.labExamine.nationalReportDate_1}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
							<%--<tag:dateInput name="labExamine.nationalReportDate_1"
								date="${caseDto.labExamine.nationalReportDate_1 }"
								pattern="yyyy/MM/dd" />--%>
						</td>
					</tr>
					<tr>
						<th>b. 第二份粪便标本：</th>
					</tr>
					<tr>
						<th>1) 采集日期：</th>
						<td>
							<input type="text" id="stoolCollecttime2Id" name="labExamine.stoolCollecttime_2" value='<fmt:formatDate value="${caseDto.labExamine.stoolCollecttime_2}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
							<%--<tag:dateInput name="labExamine.stoolCollecttime_2"
								date="${caseDto.labExamine.stoolCollecttime_2 }"
								pattern="yyyy/MM/dd" />--%>
						</td>
						<th>2) 采集人姓名：</th>
						<td><input type="text" name="labExamine.stoolCollectname_2"
							value="${caseDto.labExamine.stoolCollectname_2 }"
							reg='{"maxlength" : "50"}' /></td>
					</tr>
					<tr>
						<th>3) 采集人单位：</th>
						<td><input type="text" name="labExamine.stoolCollectunit_2"
							value="${caseDto.labExamine.stoolCollectunit_2 }"
							reg='{"maxlength" : "100"}' /></td>
						<th>4) 省级实验室收到粪便日期：</th>
						<td>
							<input type="text" id="provincialReceiveDate2Id" name="labExamine.provincialReceiveDate_2" value='<fmt:formatDate value="${caseDto.labExamine.provincialReceiveDate_2}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
							<%--<tag:dateInput name="labExamine.provincialReceiveDate_2"
								date="${caseDto.labExamine.provincialReceiveDate_2 }"
								pattern="yyyy/MM/dd" />--%>
						</td>
					</tr>
					<tr>
						<th>5) 标本是否带冰运送：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.withIceFlg_2"
								value="${caseDto.labExamine.withIceFlg_2 }" code="1,2" /></td>
						<th>6) 标本状态：</th>
						<td><ehr:dic-radio dicmeta="FS10129"
								name="labExamine.sampleStatus_2"
								value="${caseDto.labExamine.sampleStatus_2 }" code="1,3" /></td>
					</tr>
					<tr>
						<th>7) 标本量：</th>
						<td><ehr:dic-list name="labExamine.sampleNumberFlag_2"
								dicmeta="PH00002" code="1,4"
								value="${caseDto.labExamine.sampleNumberFlag_2 }"></ehr:dic-list>
							<span style="display: none" id="sampleNumber_2">约 <input
								type="text" name="labExamine.sampleNumber_2"
								value="${caseDto.labExamine.sampleNumber_2 }"
								style="width: 180px"
								reg='{"regx":"number", "scale":"1", "min":0, "max":9999}' />克
						</span></td>
						<th>8) 是否进行病毒分离：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.viralIsolationFlg_2" code="1,2"
								value="${caseDto.labExamine.viralIsolationFlg_2 }" /></td>
					</tr>
					<tr>
						<th>9) 标本接种日期：</th>
						<td>
							<input type="text" id="vaccinateDate2Id" name="labExamine.vaccinateDate_2" value='<fmt:formatDate value="${caseDto.labExamine.vaccinateDate_2}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
							<%--<tag:dateInput name="labExamine.vaccinateDate_2"
								pattern="yyyy/MM/dd"
								date="${caseDto.labExamine.vaccinateDate_2 }" />--%>
						</td>
						<th>10) 是否进行脊灰病毒分型：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.poliovirusGroupFlg_2" code="1,2"
								value="${caseDto.labExamine.poliovirusGroupFlg_2 }" /></td>
					</tr>
					<tr>
						<th>11) Ⅰ型病毒：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.viralType_1_2"
								value="${caseDto.labExamine.viralType_1_2 }" code="1,2" /></td>
						<th>12) Ⅱ型病毒：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.viralType_2_2"
								value="${caseDto.labExamine.viralType_2_2 }" code="1,2" /></td>
					</tr>
					<tr>
						<th>13) Ⅲ型病毒：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.viralType_3_2"
								value="${caseDto.labExamine.viralType_3_2 }" code="1,2" /></td>
						<th>14) 其它肠道病毒：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.otherEnterovirus_2"
								value="${caseDto.labExamine.otherEnterovirus_2 }" code="1,2" /></td>
					</tr>
					<tr>
						<th>15) 检验结果报告日期：</th>
						<td>
							<input type="text" id="resultReportDate2Id" name="labExamine.resultReportDate_2" value='<fmt:formatDate value="${caseDto.labExamine.resultReportDate_2}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
							<%--<tag:dateInput name="labExamine.resultReportDate_2"
								date="${caseDto.labExamine.resultReportDate_2 }"
								pattern="yyyy/MM/dd" />--%>
						</td>
						<th>16) 国家级实验室收到分离物日期：</th>
						<td>
							<input type="text" id="nationalReceiveDate2Id" name="labExamine.nationalReceiveDate_2" value='<fmt:formatDate value="${caseDto.labExamine.nationalReceiveDate_2}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
							<%--<tag:dateInput name="labExamine.nationalReceiveDate_2"
								date="${caseDto.labExamine.nationalReceiveDate_2 }"
								pattern="yyyy/MM/dd" />--%>
						</td>
					</tr>
					<tr>
						<th>17) 收到国家级实验室结果日期：</th>
						<td>
							<input type="text" id="nationalReportDate2Id" name="labExamine.nationalReportDate_2" value='<fmt:formatDate value="${caseDto.labExamine.nationalReportDate_2}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
							<%--<tag:dateInput name="labExamine.nationalReportDate_2"
								date="${caseDto.labExamine.nationalReportDate_2 }"
								pattern="yyyy/MM/dd" />--%>
						</td>
					</tr>
					<tr>
						<th>c. 国家级实验室鉴定结果：</th>
					</tr>
					<tr>
						<th>1）毒株性质：</th>
					</tr>
					<tr>
						<th>Ⅰ型脊灰野病毒：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.poliomyelitisType_1" code="1,2"
								value="${caseDto.labExamine.poliomyelitisType_1 }" /></td>
						<th>Ⅱ型脊灰野病毒：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.poliomyelitisType_2" code="1,2"
								value="${caseDto.labExamine.poliomyelitisType_2 }" /></td>
					</tr>
					<tr>
						<th>Ⅲ型脊灰野病毒：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.poliomyelitisType_3" code="1,2"
								value="${caseDto.labExamine.poliomyelitisType_3 }" /></td>
						<th>Ⅰ型脊灰疫苗病毒：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.polioVaccineVirusType_1" code="1,2"
								value="${caseDto.labExamine.polioVaccineVirusType_1 }" /></td>
					</tr>
					<tr>
						<th>Ⅱ型脊灰疫苗病毒：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.polioVaccineVirusType_2" code="1,2"
								value="${caseDto.labExamine.polioVaccineVirusType_2 }" /></td>
						<th>Ⅲ型脊灰疫苗病毒：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.polioVaccineVirusType_3" code="1,2"
								value="${caseDto.labExamine.polioVaccineVirusType_3 }" /></td>
					</tr>
					<tr>
						<th>Ⅰ型脊灰疫苗衍生病毒：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.vdpvType_1"
								value="${caseDto.labExamine.vdpvType_1 }" code="1,2" /></td>
						<th>Ⅱ型脊灰疫苗衍生病毒：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.vdpvType_2"
								value="${caseDto.labExamine.vdpvType_2 }" code="1,2" /></td>
					</tr>
					<tr>
						<th>Ⅲ型脊灰疫苗衍生病毒：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.vdpvType_3"
								value="${caseDto.labExamine.vdpvType_3 }" code="1,2" /></td>
						<th>其它肠道病毒：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.otherEnterovirus"
								value="${caseDto.labExamine.otherEnterovirus }" code="1,2" /></td>
					</tr>
					<tr>
						<th>待定：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="labExamine.undetermined"
								value="${caseDto.labExamine.undetermined }" code="1,2" /></td>
						<th>2) 国家级实验室 鉴定报告日期：</th>
						<td>
							<input type="text" id="inspectionReportDateId" name="labExamine.inspectionReportDate" value='<fmt:formatDate value="${caseDto.labExamine.inspectionReportDate}" pattern="yyyy/MM/dd"/>'  style="width: 100px;"/>
							<%--<tag:dateInput name="labExamine.inspectionReportDate"
								date="${caseDto.labExamine.inspectionReportDate }"
								pattern="yyyy/MM/dd" />--%>
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>8.最后诊断及分类(省填写)</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 80%" />
					</colgroup>
					<tr>
						<th>最后诊断及分类(省填写)：</th>
						<td><ehr:dic-radio name="diagnosis.diagnosisCategory"
								dicmeta="IDM00124"
								value="${caseDto.diagnosis.diagnosisCategory }" /></td>
					</tr>
					<tr class="noSpecimen">
						<th>a. 如为临床符合病例, 依据：</th>
					</tr>
					<tr class="noSpecimen">
						<th>1) 无合格粪便标本或无标本：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="diagnosis.noSpecimen"
								value="${caseDto.diagnosis.noSpecimen }" code="1,2" /></td>
					</tr>
					<tr class="noSpecimen">
						<th>2) 发病60天后残留麻痹：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="diagnosis.residualParalysis"
								value="${caseDto.diagnosis.residualParalysis }" code="1,2" /></td>
					</tr>
					<tr class="noSpecimen">
						<th>3) 病例失访：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="diagnosis.caseLostFollowup"
								value="${caseDto.diagnosis.caseLostFollowup }" code="1,2" /></td>
					</tr>
					<tr class="noSpecimen">
						<th>4) 病例死亡：</th>
						<td><ehr:dic-radio dicmeta="PH00001" name="diagnosis.caseDie"
								value="${caseDto.diagnosis.caseDie }" code="1,2" /></td>
					</tr>
					<tr class="noSpecimen">
						<th>5) 省级专家诊断小组认定：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="diagnosis.expertAffirm"
								value="${caseDto.diagnosis.expertAffirm }" code="1,2" /></td>
					</tr>
					<tr class="polioExcludeReason">
						<th>b. 如为脊灰排除病例,依据：</th>
						<td><ehr:dic-list name="diagnosis.polioExcludeReason"
								value="${caseDto.diagnosis.polioExcludeReason }"
								dicmeta="IDM00125" /></td>
					</tr>
					<tr class="polioDiagnosisReason">
						<th>c. 如为脊灰确诊病例,依据：</th>
						<td><ehr:dic-list name="diagnosis.polioDiagnosisReason"
								value="${caseDto.diagnosis.polioDiagnosisReason }"
								dicmeta="IDM00126" /></td>
					</tr>

					<tr class="polioExcludeReason">
						<th>d. 脊灰排除病例临床诊断：</th>
						<td><ehr:dic-list name="diagnosis.polioExcludeDiagnosis"
								value="${caseDto.diagnosis.polioExcludeDiagnosis }"
								dicmeta="IDM00121" uninclude="1,6" /> <input type="text"
							name="diagnosis.other" value="${caseDto.diagnosis.other }"
							style="width: 180px; display: none;" id="diagnosisOther" reg='{"maxlength" : "100"}'/></td>
					</tr>
				</table>
			</fieldset>
			<%-- <jsp:include page="followUp.jsp" /> --%>
		</div>
	</div>
</form>
<script type="text/javascript">
	layui.use('laydate', function() {
		var laydate = layui.laydate;
		//执行一个laydate实例
		laydate.render({
			elem: '#provinceSurveyDateId'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#surveyDateId'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#birthdayId'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#paralysisAppearDateId'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#thisClinicDateId'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#clinicDateFId'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#clinicDateLId'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#palsyLastDtId'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#stoolLastDtId'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#hepatitisBVaccineDtFId'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#hepatitisBVaccineDtSId'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#hepatitisBVaccineDtTId'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#stoolCollecttime1Id'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#provincialReceiveDate1Id'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#vaccinateDate1Id'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#resultReportDate1Id'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#nationalReceiveDate1Id'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#nationalReportDate1Id'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#stoolCollecttime2Id'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#provincialReceiveDate2Id'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#vaccinateDate2Id'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#resultReportDate2Id'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#nationalReceiveDate2Id'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#nationalReportDate2Id'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
		laydate.render({
			elem: '#inspectionReportDateId'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});

	});
</script>