<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/hbv.js" type="text/javascript"></script>

<c:if test="${isPrint != 1}">
    <jsp:include page="caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
    <div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
		<i class="popno"> 江苏省乙型肝炎病例流行病学调查表<br /> <span>（乙类传染病）</span>
		</i>
		<input type="hidden" name="idmId" value="${idmId}"/>
		<div class="postdiv">
            <table  class="posttable" >
                <colgroup>
                    <col style="width: 30%;"/>
                    <col style="width: 40%;"/>
                    <col style="width: 30%;"/>
                </colgroup>
                <tr>
                    <td>病例编号：<input type="text" name="caseInformation.mediRecordNum" style="width: 120px;"
                                   value="${caseDto.caseInformation.mediRecordNum}" reg='{"maxlength":"14"}'/></td>
                    </tr>
                    <tr>
                    <td colspan="4">（此项为“病例所在县区编码＋患者出生日期”，共14位，如北京市通州区编码110112患者出生日期为2003年1月8日，则病例编码为11011220030108）
                    </td>
                </tr>
                <tr>
                    <td style="text-align: left;">所在县区编码:<input type="text" name="caseInformation.wayResearchCode" style="width: 120px;"
                               value="${caseDto.caseInformation.wayResearchCode}" reg='{"length":"6"}'/></td>
                               <td style="text-align: right;">调查单位类别:<ehr:dic-radio name="caseInformation.surveyOrgGrade" dicmeta="IDM00208" value="${caseDto.caseInformation.surveyOrgGrade}"/></td>
                    <td style="text-align: right;">调查单位级别:<ehr:dic-radio name="caseInformation.surveyOrgType" dicmeta="IDM00372" value="${caseDto.caseInformation.surveyOrgType}" code="1,2,3,4"/></td>
                </tr>
            </table>
			<fieldset>
				<legend>A 基本情况</legend>
				<table class="posttable">
                    <colgroup>
                        <col style="width: 25%" />
                        <col style="width: 35%" />
                        <col style="width: 15%" />
                        <col style="width: 25%" />
                    </colgroup>
					<tr>
						<th>A1 患者姓名：</th>
						<td colspan="3">
                            <input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}"
                                   reg='{"maxlength":"100"}' style="width: 150px;"/>
                            （患儿家长姓名<input type="text" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}"
                                          reg='{"maxlength":"50"}' style="width: 150px;"/>）
                        </td>
					</tr>
					<tr>
						<th>A2 民族：</th>
						<td><ehr:dic-list name="generalCondition.nation" dicmeta="GBT3304" value="${caseDto.generalCondition.nation}" code="01,02,03,04,05,08,11,99"/></td>
					</tr>
					<tr>
						<th>A3 文化程度：</th>
						<td colspan="3"><ehr:dic-radio name="generalCondition.education" dicmeta="GBT46582006"
													   code="IDM01,IDM02,IDM03,IDM04,IDM05" value="${caseDto.generalCondition.education}"/></td>
					</tr>
					<tr>
						<th>A4 婚姻：</th>
						<td colspan="3"><ehr:dic-radio name="generalCondition.marriage" dicmeta="GBT226122003" code="10,20,40,50,30"
													   value="${caseDto.generalCondition.marriage}"/></td>
					</tr>
					<tr>
						<th>A5 常住类型：</th>
						<td>
							<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
										   value="${caseDto.generalCondition.floatPopulation}" onchange="caseEdit.toggerAddress()"/>
						</td>
					</tr>
					<tr>
						<th>A6 现住址：</th>
						<td colspan="3">
							<ehr:dic-town-street-village streetId="pastreet_address" townId="patown_address" streetName="generalCondition.pastreet" townName="generalCondition.patownShip"
														 streetValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="140px;"
														 villageId="pavillage_address" villageName="generalCondition.paGroup" villageValue="${caseDto.generalCondition.paGroup}"/>
							<input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
								   style="width: 180px;" reg='{"maxlength":"50"}'>
							<span id="spanPaNumber">(门牌号)</span>
						</td>
					</tr>
					<tr>
						<th>A7 联系电话：</th>
						<td><input type="text" name="generalCondition.phoneNumber" value="${caseDto.generalCondition.phoneNumber}"
								   reg='{"regex":"phone"}'></td>
					</tr>
					<tr>
						<th>A8 居住地类型：</th>
						<td><ehr:dic-radio name="generalCondition.residenceType" dicmeta="IDM00011" value="${caseDto.generalCondition.residenceType}"/></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<th>A9 诊断单位级别：</th>
						<td><ehr:dic-radio name="generalCondition.organLevel" dicmeta="IDM00004" code="5,4,3,2,1" value="${caseDto.generalCondition.organLevel}"/></td>
					</tr>
					<tr>
						<th>A10 实验室检测结果：</th>
					</tr>
					<tr>
						<th>A10.1 HBsAg阳性时间：</th>
						<td><ehr:dic-radio dicmeta="IDM00343" name="labExamine.hbsagPositiveDt" value="${caseDto.labExamine.hbsagPositiveDt}"/></td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<th>A10.2首次出现乙肝症状和体征的时间：</th>
						<td><ehr:dic-radio name="labExamine.hbvSign" dicmeta="PH00002" code="1,2" value="${caseDto.labExamine.hbvSign}"
										   onchange="toggleOther('labExamine.hbvSign','hbvSignDiv',1);"/>
							<span id="hbvSignDiv" style="display:none;">
							时间：<tag:dateInput name="labExamine.hbvSignDt" pattern="yyyy/MM/dd"  onlypast="true" date="${caseDto.labExamine.hbvSignDt}" style="width:100px;"/></span>

							<%-- 年月:<tag:dateInput name="labExamine.hbvSignDt" pattern="yyyy/MM/dd" onlypast="true"
                                          date="${caseDto.labExamine.hbvSignDt}" style="width:100px;"/></span> --%>
						</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<th>A10.3本次ALT：</th>
						<td>
							<input type="text" name="labExamine.alt" value="${caseDto.labExamine.alt}"
								   style="width: 180px;" reg='{"maxlength":"50"}'>U/L

						</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<th>A10.4抗-HBc IgM 1:1000检测结果：</th>
						<td><ehr:dic-radio name="labExamine.hbcCheckResult" dicmeta="CV0300404" code="2,3,1" value="${caseDto.labExamine.hbcCheckResult}"/></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<th>A10.5肝穿检测结果：</th>
						<td><ehr:dic-radio name="labExamine.punctureCheckResult" dicmeta="IDM00344" value="${caseDto.labExamine.punctureCheckResult}"/></td>
						<td></td>
						<td></td>
					</tr>
					<%--<tr>
						<th>A2 性别：</th>
						<td><ehr:dic-radio id="gender" name="generalCondition.gender"
                                           dicmeta="GBT226112003" value="${caseDto.generalCondition.gender}" code="1,2" /></td>
					</tr>
					<tr>
						<th>A3 出生日期：</th>
						<td><tag:dateInput name="generalCondition.birthday" onlypast="true" pattern="yyyy/MM/dd" date="${caseDto.generalCondition.birthday}"/></td>
					</tr>
--%>
				</table>
			</fieldset>
		</div>
		<div class="postdiv">
			<fieldset>
				<legend>B 既往免疫史及肝病史</legend>
				<table class="posttable">
                    <colgroup>
                        <col style="width: 35%" />
                        <col style="width: 65%" />
                    </colgroup>
					<tr>
						<th style="font-weight: bold;">B1 乙肝免疫史：</th>
					</tr>
					<tr>
						<th>B1.1 是否接种过乙肝疫苗吗？：</th>
						<td><ehr:dic-radio name="epidemiologicalSurvey.hepatitisBVaccine" dicmeta="IDM00013" value="${caseDto.epidemiologicalSurvey.hepatitisBVaccine}"
                                           onchange="toggleOther('epidemiologicalSurvey.hepatitisBVaccine','hepatitisBVaccinePart',2);
                                           toggleOther('epidemiologicalSurvey.hepatitisBVaccine','hbs',2)"/></td>
					</tr>
                    <tr id="hepatitisBVaccinePart" style="display: none">
                        <th>B1.2 如接种过乙肝疫苗，打过几针？：</th>
                        <td><ehr:dic-radio name="epidemiologicalSurvey.hepatitisBVaccineNum" dicmeta="IDM00012" value="${caseDto.epidemiologicalSurvey.hepatitisBVaccineNum}"
                                          onchange="hbvCase.togglehepatitisBVaccine('epidemiologicalSurvey.hepatitisBVaccineNum')" /></td>
                    </tr>
                    <tr id="hepatitisBVaccineL" style="display: none;">
                        <th>B1.3 如接种过乙肝疫苗，请填写接种时间：</th>
                    </tr>
                    <tr id="hepatitisBVaccineDt1" style="display: none;">
                        <th>第一针：</th>
                        <td><tag:dateInput id="hepatitisBVaccineDtFId" name="epidemiologicalSurvey.hepatitisBVaccineDtF" pattern="yyyy/MM/dd" onlypast="true"
                                           date="${caseDto.epidemiologicalSurvey.hepatitisBVaccineDtF}" style="width:100px;" reg='{"compare":["hepatitisBVaccineDtSId","le","第一针时间不能晚于第二针时间"]}'/></td>
                    </tr>
                    <tr id="hepatitisBVaccineDt2" style="display: none;">
                        <th>第二针：</th>
                        <td><tag:dateInput id="hepatitisBVaccineDtSId" name="epidemiologicalSurvey.hepatitisBVaccineDtS" pattern="yyyy/MM/dd" onlypast="true"
                                           date="${caseDto.epidemiologicalSurvey.hepatitisBVaccineDtS}" style="width:100px;" reg='{"compare":["hepatitisBVaccineDtFId","ge","第二针时间不能早于第一针时间"]}'/></td>
                    </tr>
                    <tr id="hepatitisBVaccineDt3" style="display: none;">
                        <th>第三针：</th>
                        <td><tag:dateInput name="epidemiologicalSurvey.hepatitisBVaccineDtT" pattern="yyyy/MM/dd" onlypast="true"
                                           date="${caseDto.epidemiologicalSurvey.hepatitisBVaccineDtT}" style="width:100px;" reg='{"compare":["hepatitisBVaccineDtSId","ge","第三针时间不能早于第二针时间"]}'/></td>
                    </tr>
                    <tr id="hbs" style="display: none">
                        <th>B1.4 接种乙肝疫苗最后一针1～2月后，是否检测过抗-HBs？：</th>
                        <td><ehr:dic-radio name="epidemiologicalSurvey.hbs" dicmeta="PH00004" code="3,1,2,4" value="${caseDto.epidemiologicalSurvey.hbs}"/></td>
                    </tr>
					<tr>
						<th>B1.5 您是否接种过乙肝高效价免疫球蛋白？：</th>
						<td><ehr:dic-radio name="epidemiologicalSurvey.hepatitisBImmunoglobulin" dicmeta="IDM00013" value="${caseDto.epidemiologicalSurvey.hepatitisBImmunoglobulin}"
                                onchange="toggleOther('epidemiologicalSurvey.hepatitisBImmunoglobulin','hepatitisBImmunoglobulinDt',2)"/></td>
					</tr>
					<tr id="hepatitisBImmunoglobulinDt" style="display:none">
						<th>B1.6 乙肝高效价免疫球蛋白接种时间？：</th>
						<td><tag:dateInput name="epidemiologicalSurvey.hepatitisBImmunoglobulinDt" pattern="yyyy/MM/dd" onlypast="true"
                                           date="${caseDto.epidemiologicalSurvey.hepatitisBImmunoglobulinDt}" style="width:100px;"/></td>
					</tr>
					<%--<tr>
						<th style="font-weight: bold;">B2 甲肝免疫史：</th>
					</tr>
					<tr>
						<th>B2.1 既往是否接种过甲肝疫苗？：</th>
						<td><ehr:dic-radio name="epidemiologicalSurvey.aimmugen" dicmeta="IDM00013" value="${caseDto.epidemiologicalSurvey.aimmugen}"
                                onchange="toggleOther('epidemiologicalSurvey.aimmugen','aimmugenPart',2)"/></td>
					</tr>
                    <tbody id="aimmugenPart" style="display: none">
                        <tr>
                            <th>B2.2 甲肝疫苗种类？：</th>
                            <td><ehr:dic-radio name="epidemiologicalSurvey.aimmugenCategory" dicmeta="IDM00014" code="1,2,4"
                                               value="${caseDto.epidemiologicalSurvey.aimmugenCategory}"/></td>
                        </tr>
                        <tr>
                            <th>B2.3 接种甲肝疫苗的次数？：</th>
                            <td><ehr:dic-radio name="epidemiologicalSurvey.aimmugenNum" dicmeta="IDM00015" value="${caseDto.epidemiologicalSurvey.aimmugenNum}"
                                    onchange="hbvCase.toggleHav('epidemiologicalSurvey.aimmugenNum');"/></td>
                        </tr>
                        <tr id="aimmugenDt" style="display: none">
                            <th>B2.4 甲肝疫苗接种时间？：</th>
                        </tr>
                        <tr id="aimmugenDt1" style="display: none">
                            <th>第一针：</th>
                            <td>
                                <tag:dateInput name="epidemiologicalSurvey.aimmugenDtF" pattern="yyyy" id="aimmugenDtF" onlypast="true"
                                               date="${caseDto.epidemiologicalSurvey.aimmugenDtF}" style="width:100px;" reg='{"compare":["aimmugenDtS","le","第一针时间不能晚于第二针时间"]}'/>年
                            </td>
                        </tr>
                        <tr id="aimmugenDt2" style="display: none">
                            <th>第二针：</th>
                            <td>
                                <tag:dateInput name="epidemiologicalSurvey.aimmugenDtS" pattern="yyyy" id="aimmugenDtS" onlypast="true"
                                               date="${caseDto.epidemiologicalSurvey.aimmugenDtS}" style="width:100px;" reg='{"compare":["aimmugenDtF","ge","第二针时间不能早于第一针时间"]}'/>年
                            </td>
                        </tr>
                    </tbody>
					<tr>
						<th>B2.5 您是否接种过甲肝丙种球蛋白？：</th>
						<td><ehr:dic-radio name="epidemiologicalSurvey.hepatitisAGammaGlobulin" dicmeta="PH00001" code="2,1,4" value="${caseDto.epidemiologicalSurvey.hepatitisAGammaGlobulin}"
                                           onchange="toggleOther('epidemiologicalSurvey.hepatitisAGammaGlobulin','hepatitisAGammaGlobulinDt',1);"/></td>
					</tr>
					<tr id="hepatitisAGammaGlobulinDt">
						<th>B2.6 甲肝丙种球蛋白接种时间？：</th>
						<td><tag:dateInput name="epidemiologicalSurvey.hepatitisAGammaGlobulinDt" pattern="yyyy/MM/dd" onlypast="true"
                                           date="${caseDto.epidemiologicalSurvey.hepatitisAGammaGlobulinDt}" style="width:100px;"/></td>
					</tr>--%>
					<tr>
						<th style="font-weight: bold;">B2 既往肝病史：</th>
					</tr>
					<tr>
						<th>B2.1 您是否曾经被明确诊断过以下“肝病”？（可多选）：</th>
						<td>
                            <ehr:dic-radio name="epidemiologicalSurvey.hepatitis" dicmeta="PH00001" code="1,2" value="${caseDto.epidemiologicalSurvey.hepatitis}"
                                    onchange="toggleOther('epidemiologicalSurvey.hepatitis','diagnosisLiverCategory',1);
                                   toggleOtherCK('epidemiologicalSurvey.diagnosisLiverCategory','chHepatitisOther',99);"/>
                            <span id="diagnosisLiverCategory" style="display: none">
                                <br><ehr:dic-checkbox name="epidemiologicalSurvey.diagnosisLiverCategory" dicmeta="IDM00016" code="2,3,4,6,8,9,10,11,99"
                                                  value="${caseDto.epidemiologicalSurvey.diagnosisLiverCategory}"
                                                  onchange="toggleOtherCK('epidemiologicalSurvey.diagnosisLiverCategory','chHepatitisOther',99);"/>
                                <span id="chHepatitisOther" style="display: none">
                                    <input type="text" name="epidemiologicalSurvey.chHepatitisOther" placeholder="请注明其他"
                                            value="${caseDto.epidemiologicalSurvey.chHepatitisOther}" reg='{"maxlength":"100"}' style="width: 150px;"/>
                                </span>
                            </span>
                        </td>
					</tr>
					<tr>
						<th>B2.2 如果您曾经被诊断过“乙肝”，请继续填写如下问题：</th>
					</tr>
					<tr>
						<th>B2.2.1 初次诊断时间：</th>
						<td>
                            <tag:dateInput name="epidemiologicalSurvey.liverFirstEpisodeDt" pattern="yyyy/MM/dd" style="width:100px;" onlypast="true"
                                           date="${caseDto.epidemiologicalSurvey.liverFirstEpisodeDt}"/>
                        </td>
					</tr>
					<tr>
						<th>B2.2.2 临床诊断为：</th>
						<td><ehr:dic-radio name="epidemiologicalSurvey.liverDiagnosis" dicmeta="IDM00017" value="${caseDto.epidemiologicalSurvey.liverDiagnosis}"/></td>
					</tr>
					<tr>
						<th>B2.2.3 诊断单位：</th>
						<td><ehr:dic-radio name="epidemiologicalSurvey.liverDiagnosisUnit" dicmeta="IDM00004" code="5,4,3,2,1"
                                           value="${caseDto.epidemiologicalSurvey.liverDiagnosisUnit}"/></td>
					</tr>
				</table>
			</fieldset>
		</div>
		<div class="postdiv">
			<fieldset>
				<legend>C 危险因素暴露史（请填写半年以内的暴露史）</legend>
				<table class="posttable">
                    <colgroup>
                        <col style="width: 35%" />
                        <col style="width: 65%" />
                    </colgroup>
					<tr>
						<th>C1 日常密切接触者中是否有乙肝病人或表面抗原携带者？：</th>
						<td><ehr:dic-radio name="exposureHistory.hepatitisBPatientContact" dicmeta="PH00002" code="2,1,4" value="${caseDto.exposureHistory.hepatitisBPatientContact}"
                                          onchange="toggleOther('exposureHistory.hepatitisBPatientContact','hepatitisBPatientCategory',1);"/></td>
					</tr>
					<tr id="hepatitisBPatientCategory" style="display: none">
						<th>C1.1 如有，是谁？(可多选)：</th>
						<td>
                            <ehr:dic-checkbox name="exposureHistory.hepatitisBPatientCategory" dicmeta="IDM00018" value="${caseDto.exposureHistory.hepatitisBPatientCategory}"
                                               onchange="toggleOtherCK('exposureHistory.hepatitisBPatientCategory','hepatitisBPatientOther',99);" />
                        </td>
					</tr>
                    <tr  id="hepatitisBPatientOther" style="display: none">
                        <th>：</th>
                        <td>
                            <input type="text" name="exposureHistory.hepatitisBPatientOther" placeholder="请注明其他"
                                   value="${caseDto.exposureHistory.hepatitisBPatientOther}" reg='{"maxlength":"100"}'/>
                        </td>
                    </tr>
					<tr>
						<th>C2 是否与他人共用剃须刀？：</th>
						<td><ehr:dic-radio name="exposureHistory.shareRazor" dicmeta="PH00001" code="2,1" value="${caseDto.exposureHistory.shareRazor}"/></td>
					</tr>
					<tr>
						<th>C3 是否与他人共用牙刷？：</th>
						<td><ehr:dic-radio name="exposureHistory.shareToothbrush" dicmeta="PH00001" code="2,1" value="${caseDto.exposureHistory.shareToothbrush}"/></td>
					</tr>
					<tr>
						<th>C4 有无手术治疗史？：</th>
						<td><ehr:dic-radio name="exposureHistory.operation" dicmeta="PH00002" code="2,1" value="${caseDto.exposureHistory.operation}"/></td>
					</tr>
					<tr>
						<th>C5 有无拔牙、补牙、洗牙等口腔诊疗史？：</th>
						<td><ehr:dic-radio name="exposureHistory.tooth" dicmeta="PH00002" code="2,1" value="${caseDto.exposureHistory.tooth}"/></td>
					</tr>
					<tr>
						<th>C6 有无介入性（胃镜、肠镜、支纤镜、腹腔镜等）医学诊疗史？：</th>
                        <td><ehr:dic-radio name="exposureHistory.interventionalHistory" dicmeta="PH00002" code="2,1"
                                           value="${caseDto.exposureHistory.interventionalHistory}"/></td>
					</tr>
					<tr>
						<th>C7 有无输血（或血制品）史？：</th>
						<td><ehr:dic-radio name="exposureHistory.receptionBloodHistory" dicmeta="PH00002" code="2,1"
                                           value="${caseDto.exposureHistory.receptionBloodHistory}"/></td>
					</tr>
					<tr>
						<th>C8 有无有偿献血史？：</th>
						<td><ehr:dic-radio name="exposureHistory.donateBloodHistory" dicmeta="PH00002" code="2,1"
                                           value="${caseDto.exposureHistory.donateBloodHistory}"/></td>
					</tr>
					<tr>
						<th>C9 有无针灸治疗史？：</th>
						<td><ehr:dic-radio name="exposureHistory.acupuncture" dicmeta="PH00002" code="2,1"
                                           value="${caseDto.exposureHistory.acupuncture}"/></td>
					</tr>
					<tr>
						<th>C10 有无与他人共用注射器史？：</th>
						<td><ehr:dic-radio name="exposureHistory.shareSyringe" dicmeta="PH00002" code="2,1"
                                           value="${caseDto.exposureHistory.shareSyringe}"/></td>
					</tr>
					<tr>
						<th>C11 您曾去美容院做过创伤性治疗（纹眉、眼线、唇线、纹身、打耳洞等）吗？：</th>
						<td><ehr:dic-radio name="exposureHistory.traumaticTreatment" dicmeta="PH00002" code="2,1"
                                           value="${caseDto.exposureHistory.traumaticTreatment}"/></td>
					</tr>
					<tr>
						<th>C12 您经常去理发店修面或刮胡须吗？：</th>
						<td><ehr:dic-radio name="exposureHistory.shaveFrequency" dicmeta="IDM00019" value="${caseDto.exposureHistory.shaveFrequency}"/></td>
					</tr>
					<tr>
						<th>C13 您经常去洗浴场所或足浴店修脚吗？：</th>
						<td><ehr:dic-radio name="exposureHistory.pedicureFrequency" dicmeta="IDM00020" value="${caseDto.exposureHistory.pedicureFrequency}"/></td>
					</tr>
					<%--<tr>
						<th>C14 有无血液透析治疗史？：</th>
						<td><ehr:dic-radio name="exposureHistory.hemodialysisHistory" dicmeta="PH00002" code="2,1"
                                           value="${caseDto.exposureHistory.hemodialysisHistory}"/></td>
					</tr>
					<tr>
						<th>C15 如是医务人员，是否接触血液标本？：</th>
						<td><ehr:dic-radio name="exposureHistory.bloodSample" dicmeta="PH00002" code="2,1" value="${caseDto.exposureHistory.bloodSample}"
                                          onchange="toggleOther('exposureHistory.bloodSample','bloodSampleFrequency',1);"/></td>
					</tr>
					<tr id="bloodSampleFrequency" style="display: none">
						<th>C 15.1接触频次：</th>
						<td><ehr:dic-radio name="exposureHistory.bloodSampleFrequency" dicmeta="IDM00021"
                                           value="${caseDto.exposureHistory.bloodSampleFrequency}"/></td>
					</tr>--%>
				</table>
			</fieldset>
		</div>
		<div class="postdiv">
			<fieldset>
				<table class="posttable">
                    <colgroup>
                        <col style="min-width: 80px; width: 15%" />
                        <col style="min-width: 280px; width: 35%" />
                        <col style="min-width: 80px; width: 15%" />
                        <col style="min-width: 280px; width: 35%" />
                    </colgroup>
					<tr>
						<th>调查单位：</th>
						<td>
                            <ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/>
                        </td>
						<th>调查者：</th>
						<td>
                            <ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
                        </td>
					</tr>
					<tr>
						<th>调查时间：</th>
						<td><tag:dateInput name="caseInformation.modifySurveyDate" onlypast="true" pattern="yyyy/MM/dd" date="${caseDto.caseInformation.modifySurveyDate}"/></td>
						<th>审核者：</th>
						<td>
                            <ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
                        </td>
					</tr>
					<tr style="display:none;">
			             <td>
			             	<input type="hidden" name="caseInformation.caseFillOrg" value="${caseDto.caseInformation.caseFillOrg}"/>
			             	<input type="hidden" name="caseInformation.modifySurveyOrg" value="${caseDto.caseInformation.modifySurveyOrg}"/>
			             	<input type="hidden" name="caseInformation.modifyRespondents" value="${caseDto.caseInformation.modifyRespondents}"/>
			             	<input type="hidden" name="caseInformation.auditor" value="${caseDto.caseInformation.auditor}"/>
			             </td> 
			         </tr>
				</table>
			</fieldset>
		</div>
	</div>
</form>
