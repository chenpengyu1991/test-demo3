<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/hfmd.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<c:if test="${isPrint != 1}">
    <jsp:include page="../caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
	<div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
		<i class="popno">
			手足口病个案调查表<br />
			<span>（丙类传染病）</span>
		</i>
		<input type="hidden" name="idmId" value="${idmId}" id="idmId"/>
        <input type="hidden" name="esList" id="esList"/>
        <input type="hidden" name="efcList" id="efcList"/>
		<div class="postdiv">
            <table  class="posttable">
                <colgroup>
                    <col style="width: 60%;" />
                    <col style="width: 300px;" />
                </colgroup>
                <tr>
                    <td style="text-align: left;">编号:
                    <input type="text" name="caseInformation.mediRecordNum" style="width: 120px;"
                           value="${caseDto.caseInformation.mediRecordNum}" reg='{"maxlength":"12"}'/></td>
                    <td style="text-align: right;">调查单位: <ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: left;"><span>（按照国家标准编码：省编码＋市编码＋县编码＋病例序号）</span></td>
                </tr>
            </table>

			<fieldset>
				<legend>一、一般情况</legend>
				<table class="posttable">
					<colgroup>
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                        <col style="width: 20%" />
                        <col style="width: 30%" />
					</colgroup>
					<tr>
						<th>患者姓名：</th>
						<td><input type="text" name="generalCondition.name" reg='{"maxlength":"100"}'
							value="${caseDto.generalCondition.name}" style="width:150px;"/></td>
                        <td></td>
                        <td></td>
					</tr>
                    <tr>
                        <th>性别：</th>
                        <td>
                            <ehr:dic-radio name="generalCondition.gender"
                                           dicmeta="GBT226112003" value="${caseDto.generalCondition.gender}" code="1,2" />
                        </td>
                    </tr>
					<tr>
						<th>出生日期：</th>
						<td>
                            <tag:dateInput name="generalCondition.birthday" pattern="yyyy/MM/dd" date="${caseDto.generalCondition.birthday}" style="width:150px;"/>
                            <ehr:dic-radio name="generalCondition.birthdateType" dicmeta="IDM00002" value="${caseDto.generalCondition.birthdateType}"/>
                        </td>

					</tr>
                    <tr>
                        <th>职业：</th>
                        <td colspan="3">
                            <ehr:dic-list dicmeta="GBT6565" name="generalCondition.occupation" width="150px;" value="${caseDto.generalCondition.occupation}"
                                          code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120299"
                                          onchange="toggleOtherSC('generalCondition.occupation','occupationPart','CV020120299');"/>
                            <span  id="occupationPart" style="display: none">
                                <input type="text" name="generalCondition.occupationOther" value="${caseDto.generalCondition.occupationOther}"
                                       reg='{"maxlength":"30"}' placeholder="若选择其他，请描叙" style="width: 200px;"/>
                            </span>
                        </td>
                    </tr>
					<tr>
						<th>工作单位：</th>
						<td colspan="3"><input type="text" name="generalCondition.unitName" reg='{"maxlength":"70"}'
							value="${caseDto.generalCondition.unitName}" style="width:250px;"/><span>（就读学校或托幼机构）</span>
						</td>
					</tr>
                    <tr>
                        <th>家长姓名：</th>
                        <td><input type="text" name="generalCondition.parentsName" reg='{"maxlength":"50"}'
                                   value="${caseDto.generalCondition.parentsName}" style="width:150px;"/></td>
                    </tr>
                    <tr>
                    	<th>常住类型：</th>
                    	<td>
		            		<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
                        		value="${caseDto.generalCondition.floatPopulation}" onchange="caseEdit.toggerAddress()"/>
                    	</td>
                    </tr>
					<tr>
						<th>家庭住址：</th>
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
                        <th>家庭电话：</th>
                        <td>
                        	<input type="text" name="generalCondition.familyPhone" value="${caseDto.generalCondition.familyPhone}"
                            	reg='{"regex":"phone"}' style="width:150px;"/></td>
                    </tr>
				</table>
			</fieldset>

			<fieldset>
				<legend>二、发病及就诊情况</legend>
				<table class="posttable">
					<colgroup>
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                        <col style="width: 20%" />
                        <col style="width: 30%" />
					</colgroup>
					<tr>
						<th>1、发病日期：</th>
						<td><tag:dateInput id="pathogenesisDateId" name="attackCondition.pathogenesisDate" date="${caseDto.attackCondition.pathogenesisDate}"
                                           pattern="yyyy/MM/dd" onlypast="true" style="width:100px;"
                                           reg='{"compare":["firstVisitDateId","le","发病日期不能晚于初诊日期"]}'/></td>
                        <td></td>
                        <td></td>
					</tr>
                    <tr>
                        <th>2、初诊日期：</th>
                        <td colspan="3">
                            <tag:dateInput id="firstVisitDateId" name="attackCondition.firstVisitDate" pattern="yyyy/MM/dd" onlypast="true"
                                           date="${caseDto.attackCondition.firstVisitDate}" style="width:100px;"
                                           reg='{"compare":["pathogenesisDateId","ge","初诊日期不能早于发病日期"]}'/>
                            &nbsp;&nbsp;&nbsp;初诊单位
                            <ehr:dic-radio name="attackCondition.firstVisitUnit" dicmeta="IDM00004" code="1,2,3,4,5" reg='{"maxlength":"100"}'
                                           value="${caseDto.attackCondition.firstVisitUnit}"/>
                            &nbsp;&nbsp;&nbsp;&nbsp;初步诊断
                            <input type="text" name="attackCondition.firstVisitName" value="${caseDto.attackCondition.firstVisitName}"
                                   reg='{"maxlength":"100"}' style="width: 200px;"/>
                        </td>
                    </tr>
					<tr>
						<th>3、住院治疗：</th>
						<td colspan="3">
                            <ehr:dic-radio dicmeta="PH00001" name="attackCondition.admissionFlg" code="1,2" value="${caseDto.attackCondition.admissionFlg}"
                                    onchange="toggleOther('attackCondition.admissionFlg','admissionFlgTb',1)"/>
                            <span id="admissionFlgTb" style="display: none">
                                  <br>所住医院<input type="text" name="attackCondition.admissionHospital" reg='{"maxlength":"100"}' style="width: 200px;"
                                             value="${caseDto.attackCondition.admissionHospital}"/>
                                  病程<input type="text" name="attackCondition.diagnosisCourseDay" reg='{"maxlength":"20"}'
                                           value="${caseDto.attackCondition.diagnosisCourseDay}" style="width:60px;text-align: center"/>天
                                  <br>入院日期<tag:dateInput id="inhosDateId" name="attackCondition.inhosDate" pattern="yyyy/MM/dd" style="width: 100px;"
                                                         onlypast="true" date="${caseDto.attackCondition.inhosDate}"
                                                         reg='{"compare":["outHospitalDateId","le","入院日期不能晚于出院日期"]}'/>
                                  入院诊断<input type="text" name="attackCondition.inhosDiagnosisOther" value="${caseDto.attackCondition.inhosDiagnosisOther}"
                                             reg='{"maxlength":"100"}'  style="width: 250px;"/>
                                  <br>出院日期<tag:dateInput id="outHospitalDateId" name="attackCondition.outHospitalDate" style="width: 100px;" onlypast="true"
                                                         pattern="yyyy/MM/dd" date="${caseDto.attackCondition.outHospitalDate}"
                                                         reg='{"compare":["inhosDateId","ge","出院日期不能早于入院日期"]}'/>
                                  出院诊断<input type="text" name="attackCondition.outDiagnosisOther" value="${caseDto.attackCondition.outDiagnosisOther}"
                                  reg='{"maxlength":"100"}' style="width: 250px;"/>
                            </span>
                        </td>
					</tr>
					<tr>
						<th>4、预后：</th>
						<td colspan="3">
                            <ehr:dic-radio name="attackCondition.prognosis" dicmeta="IDM00005" code="1,2,3,4,99" value="${caseDto.attackCondition.prognosis}"
                                    onchange="toggleOther('attackCondition.prognosis','prognosisOther',99)"/>
                            <span id="prognosisOther" style="display: none">
                                <input type="text" name="attackCondition.prognosisOther" value="${caseDto.attackCondition.prognosisOther}"
                                       reg='{"maxlength":"100"}' style="width: 150px;"/>
                            </span>
                            <br>后遗症&nbsp;&nbsp;
                            <ehr:dic-radio dicmeta="PH00002" name="attackCondition.sequelae" code="1,2" value="${caseDto.attackCondition.sequelae}"
                                           onchange="toggleOther('attackCondition.sequelae','sequelaeName',1)"/>
                            <span id="sequelaeName" style="display: none">
                                <input type="text" name="attackCondition.sequelaeName" value="${caseDto.attackCondition.sequelaeName}"
                                       reg='{"maxlength":"100"}' style="width: 150px;"/>
                            </span>
                        </td>
					</tr>
				</table>
			</fieldset>

			<fieldset>
				<legend>三、临床情况</legend>
				<table class="posttable">
					<colgroup>
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                        <col style="width: 20%" />
                        <col style="width: 30%" />
					</colgroup>
					<tr>
						<td colspan="4" style="text-align: left;">（一）临床症状</td>
					</tr>
					<tr>
						<th>1、发热：</th>
						<td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.fever" code="1,2" value="${caseDto.clinicalManifestations.fever}"
                                           onchange="toggleOther('clinicalManifestations.fever','highestTemperature',1)"/>
                            <span id="highestTemperature" style="display: none">
                                <input type="text" name="clinicalManifestations.highestTemperature" value="${caseDto.clinicalManifestations.highestTemperature}"
                                       style="width: 80px;" reg='{"maxlength":"20"}'>℃
                            </span>
						</td>
					</tr>
                    <tr>
                        <th>2、皮疹：</th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.rash" code="1,2" value="${caseDto.clinicalManifestations.rash}"
                                           onchange="toggleOther('clinicalManifestations.rash','rashParts',1)"/>
                            <span id="rashParts" style="display: none">主要部位:
                                <input type="text" name="clinicalManifestations.rashParts" value="${caseDto.clinicalManifestations.rashParts}"
                                       reg='{"maxlength":"20"}' style="width: 120px;">
                            </span>
                        </td>
                    </tr>
					<tr>
						<th>3、口腔炎：</th>
						<td colspan="3">口腔粘膜上出现红色溃疡型疱疹
                            <ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.oralMucousUlcerHerpes" code="1,2"
                                           value="${caseDto.clinicalManifestations.oralMucousUlcerHerpes}"/></td>
					</tr>
					<tr>
					</tr>
					<tr>
						<th>4、呼吸系统：</th>
                        <td colspan="3">
                            <ehr:dic-checkbox name="clinicalManifestations.respiratory" dicmeta="IDM00205" value="${caseDto.clinicalManifestations.respiratory}"
                                    onchange="toggleOtherCK('clinicalManifestations.respiratory','otherRespiratory',99)"/>
                            <span id="otherRespiratory" style="display: none">
                                <input type="text" name="clinicalManifestations.otherRespiratory" value="${caseDto.clinicalManifestations.otherRespiratory}"
                                       style="width: 150px;" reg='{"maxlength":"100"}' placeholder="若选择其他，请描述">
                            </span>
                        </td>
					</tr>
                    <tr>
                        <th>5、消化系统：</th>
                        <td colspan="3">
                            <ehr:dic-checkbox name="clinicalManifestations.digestiveSystem" dicmeta="IDM00206" value="${caseDto.clinicalManifestations.digestiveSystem}"
                                              onchange="toggleOtherCK('clinicalManifestations.digestiveSystem','otherDigestiveSystem',99)"/>
                            <span id="otherDigestiveSystem" style="display: none">
                                <input type="text" name="clinicalManifestations.otherDigestiveSystem" value="${caseDto.clinicalManifestations.otherDigestiveSystem}"
                                       style="width: 150px;" reg='{"maxlength":"100"}'placeholder="若选择其他，请描述">
                            </span>
                        </td>
                    </tr>
					<tr>
						<th>6、神经系统：</th>
						<td colspan="3">
                            <ehr:dic-checkbox name="clinicalManifestations.nervousSystem" dicmeta="IDM00207" value="${caseDto.clinicalManifestations.nervousSystem}"/>
                        </td>
					</tr>
                    <tr>
                        <th>7、心血管系统：</th>
                        <td>心律失常：<ehr:dic-radio dicmeta="PH00002"
                                           name="clinicalManifestations.arrhythmia" code="1,2" value="${caseDto.clinicalManifestations.arrhythmia}"/>
                        </td>
                    </tr>
					<tr>
						<td colspan="4" style="text-align: left;">（二）体征</td>
					</tr>
					<tr>
						<th>颈项强直：</th>
						<td><ehr:dic-radio dicmeta="PH00002"
								name="clinicalManifestations.neckRigidity" code="1,2" value="${caseDto.clinicalManifestations.neckRigidity}"/></td>
						<th>巴氏症：</th>
						<td><ehr:dic-radio dicmeta="PH00002"
								name="clinicalManifestations.pasteurelleses" code="1,2" value="${caseDto.clinicalManifestations.pasteurelleses}"/></td>
					</tr>
					<tr>
						<th>克氏症：</th>
						<td><ehr:dic-radio dicmeta="PH00002"
								name="clinicalManifestations.louGehrigsDisease" code="1,2" value="${caseDto.clinicalManifestations.louGehrigsDisease}"/></td>
						<th>布氏症：</th>
						<td><ehr:dic-radio dicmeta="PH00002"
								name="clinicalManifestations.brucellosis" code="1,2" value="${caseDto.clinicalManifestations.brucellosis}"/></td>
					</tr>
					<tr>
						<th>腱反射：</th>
						<td><ehr:dic-radio dicmeta="IDM00118"
								name="clinicalManifestations.tendonReflex" code="3,4,2" value="${caseDto.clinicalManifestations.tendonReflex}"/></td>

						<th>肌张力：</th>
						<td><ehr:dic-radio dicmeta="IDM00118"
								name="clinicalManifestations.muscleTension" code="3,4,2" value="${caseDto.clinicalManifestations.muscleTension}"/></td>
					</tr>
					<tr>
						<td style="text-align: left;" colspan="4">（三）辅助检查</td>
					</tr>
					<tr>
						<th>1、血象：</th>
						<td colspan="3"><ehr:dic-radio dicmeta="PH00002" name="labExamine.hemogram" code="1,2" value="${caseDto.labExamine.hemogram}"
                                onchange="toggleOther('labExamine.hemogram','hemogramPart',1)"/>
                            <span id="hemogramPart" style="display: none">
                                WBC<input type="text" style="width: 80px; text-align: center" name="labExamine.hemogramWbc"
                                          value="${caseDto.labExamine.hemogramWbc}" reg='{"maxlength":"20"}'/>×10<sup>4</sup>/L,&nbsp;
                                N<input type="text" style="width: 80px; text-align: center" name="labExamine.hemogramN"
                                        value="${caseDto.labExamine.hemogramN}" reg='{"maxlength":"20"}'/>%, &nbsp;
                                L<input type="text" style="width: 80px; text-align: center" name="labExamine.hemogramL"
                                        value="${caseDto.labExamine.hemogramL}" reg='{"maxlength":"20"}'/>%
                            </span>
                        </td>
					</tr>
					<tr>
						<th>2、脑脊液：</th>
						<td colspan="3">
                            压力<input type="text" name="labExamine.cerebrospinalPressure" style="width: 80px;text-align: center"
                                   value="${caseDto.labExamine.cerebrospinalPressure}" reg='{"maxlength":"20"}'/>Pa
                            , 外观<ehr:dic-radio name="labExamine.cerebrospinalAspect" dicmeta="PH00003" code="1,2" value="${caseDto.labExamine.cerebrospinalAspect}"/>
                            , 细胞记数
                            <input type="text" name="labExamine.cerebrospinalcellCount" value="${caseDto.labExamine.cerebrospinalcellCount}"
                                   reg='{"maxlength":"20"}' style="width: 80px;text-align: center"/>个
                            , <br>蛋白<input style="width: 180px;" type="text"  name="labExamine.cerebrospinalProtein"
                                       reg='{"maxlength":"20"}' value="${caseDto.labExamine.cerebrospinalProtein}"/> &nbsp;
                            , 糖含量<input type="text" style="width: 180px;" name="labExamine.cerebrospinalSugar"
                                       reg='{"maxlength":"20"}' value="${caseDto.labExamine.cerebrospinalSugar}"/>
                        </td>
					</tr>
					<tr>
						<th>3、X线检查结果：</th>
						<td colspan="3"><ehr:dic-radio dicmeta="PH00002" name="labExamine.xrayTestResult" code="1,2" value="${caseDto.labExamine.xrayTestResult}"
                                onchange="toggleOther('labExamine.xrayTestResult','xrayTestExpression',1)"/>
                            <span id="xrayTestExpression">
                                  &nbsp;&nbsp;表现为<input type="text" name="labExamine.xrayTestExpression" value="${caseDto.labExamine.xrayTestExpression}"
                                            reg='{"maxlength":"100"}' style="width: 200px;"/>
                            </span>
                        </td>
					</tr>
					<tr>
						<th>4、心肌酶谱：</th>
						<td colspan="3">
                            肌钙蛋白酶<input type="text" name="labExamine.muscleCalpain" value="${caseDto.labExamine.muscleCalpain}"
                                        reg='{"maxlength":"100"}' style="width: 150px;"/>
                            肌红蛋白酶<input type="text" name="labExamine.myoglobin" value="${caseDto.labExamine.myoglobin}"
                                        reg='{"maxlength":"100"}' style="width: 150px;"/>
                        </td>
						<%--<th>肌红蛋白酶：</th>--%>
						<%--<td><input type="text" name="labExamine.myoglobin" value="${caseDto.labExamine.myoglobin}"/></td>--%>
					</tr>
					<tr>
						<td style="text-align: left;" colspan="4">（四）合并症及并发症</td>
					</tr>
					<tr>
						<th>合并症：</th>
						<td><ehr:dic-radio dicmeta="PH00002" code="1,2" name="clinicalManifestations.compl" value="${caseDto.clinicalManifestations.compl}"
                                onchange="toggleOther('clinicalManifestations.compl','complDescription',1)"/>
                            <span id="complDescription" style="display: none;">
                                <input type="text" name="clinicalManifestations.complDescription" value="${caseDto.clinicalManifestations.complDescription}"
                                       reg='{"maxlength":"100"}' style="width: 150px;" placeholder="若有，请描述"/>
                            </span>
                        </td>
					</tr>
                    <tr>
                        <th>并发症：</th>
                        <td>
                            <ehr:dic-radio dicmeta="PH00002" code="1,2" name="clinicalManifestations.isComplications" value="${caseDto.clinicalManifestations.isComplications}"
                                    onchange="toggleOther('clinicalManifestations.isComplications','complications',1)"/>
                            <span id="complications" style="display: none;">
                                <input type="text" name="clinicalManifestations.complications" value="${caseDto.clinicalManifestations.complications}"
                                       reg='{"maxlength":"200"}' style="width: 150px;" placeholder="若有，请描述"/>
                            </span>
                        </td>
                    </tr>
				</table>
			</fieldset>

			<fieldset>
				<legend>四、流行病学资料</legend>
				<table class="posttable">
					<colgroup>
                        <col style="width: 28%" />
                        <col style="width: 72%" />
					</colgroup>
					<tr>
						
						<td style="width: 15%; text-align: left;" colspan="2">（一）患者接触史（填写病例发病6天前与手足口病、病脑、病毒心肌炎的接触史）：
							
                            <ehr:dic-radio name="epidemiologicalSurvey.contactHistory" dicmeta="PH00002" code="1,2" value="${caseDto.epidemiologicalSurvey.contactHistory}"
                                    onchange="toggleOther('epidemiologicalSurvey.contactHistory','contactHistoryPart',1);"/>
                        </td>
					</tr>
                    <tbody id="contactHistoryPart">
                        <tr>
                            <td colspan="4">
                                <div id="contactList">
									<jsp:include page="contactList.jsp"></jsp:include>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4">备注：1、与病例关系，指本调查病例发病前与相关患者的关系。包括（填写）家人、亲戚、同班、<br />同校、同村或其它等关系。<br />
                                2、临床诊断填写：手足口病、病脑、病毒心肌炎、肺水肿等。
                            </td>
                        </tr>
                    </tbody>
					<tr>
						<td colspan="2" style="text-align: left;">（二）病例密切接触者，患者发病前7天以来，接触的人群情况：</td>
					</tr>
					<tr>
						<td colspan="2">
                            <div id="contactedList">
								<jsp:include page="contactedList.jsp"></jsp:include>
                            </div>							
						</td>
					</tr>
					<tr>
						<td colspan="2">备注：1、接触患者的密切人员与患者关系，填写家人、亲戚、同班、同校、同村或其它等关系。<br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            2、临床诊断填写：手足口病、病脑、病毒心肌炎、肺水肿等。
						</td>
					</tr>
					<tr>
						<th style="text-align: left;">（三）发病6天前是否到过手足口病流行地：</th>
						<td>
                            <ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="beforeDiseaseDiet.goHfmDisease" value="${caseDto.beforeDiseaseDiet.goHfmDisease}"
                                onchange="toggleOther('beforeDiseaseDiet.goHfmDisease','goHfmDiseasePart',1)"/>
                            <span id="goHfmDiseasePart" style="display: none;">
                                时间
                                <tag:dateInput name="beforeDiseaseDiet.goHfmDiseaseDt" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.beforeDiseaseDiet.goHfmDiseaseDt}" style="width:80px;"/>
                                地点
                                <input type="text" name="beforeDiseaseDiet.goHfmDiseaseAddr" value="${caseDto.beforeDiseaseDiet.goHfmDiseaseAddr}" style="width: 240px;" reg='{"maxlength":"200"}'/>
                            </span>
                        </td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: left;">（四）发病前6天前饮食（水）史：</td>
					</tr>
					<tr>
						<th>1、外出就餐：</th>
						<td>
                            <ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.outsideDiningHistory" code="1,2,4" value="${caseDto.beforeDiseaseDiet.outsideDiningHistory}"
                                onchange="toggleOther('beforeDiseaseDiet.outsideDiningHistory','outsideDiningHistoryPart',1)"/>
                            <span id="outsideDiningHistoryPart" style="display: none;">
                                时间<tag:dateInput name="beforeDiseaseDiet.eatTime" pattern="yyyy/MM/dd" nullToToday="true" onlypast="true"
                                                 date="${caseDto.beforeDiseaseDiet.eatTime}" style="width: 80px;"/>
                                地点<input type="text" name="beforeDiseaseDiet.eatPlace" value="${caseDto.beforeDiseaseDiet.eatPlace}" style="width: 240px;" reg='{"maxlength":"200"}'/>
                            </span>
                        </td>
					</tr>
					<tr>
						<th>2、饮用生水或使用不洁水源清洗入口食物、洗碗、漱口等：</th>
						<td>
                            水源类型<input type="text" name="beforeDiseaseDiet.outDrinkingType" value="${caseDto.beforeDiseaseDiet.outDrinkingType}"
                                       reg='{"maxlength":"50"}' style="width: 150px;">
                            地点<input type="text" name="beforeDiseaseDiet.outDrinkingPlace" value="${caseDto.beforeDiseaseDiet.outDrinkingPlace}"
                                     reg='{"maxlength":"200"}' style="width: 220px;"/>
                            <br>频率&nbsp;&nbsp;&nbsp;&nbsp;
                            <ehr:dic-radio dicmeta="IDM00007"
                              name="beforeDiseaseDiet.outDrinkingRate" value="${caseDto.beforeDiseaseDiet.outDrinkingRate}"></ehr:dic-radio>
                        </td>
					</tr>
				</table>
			</fieldset>

			<fieldset>
				<table class="posttable">
					<colgroup>
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                        <col style="width: 20%" />
                        <col style="width: 30%" />
					</colgroup>
					<tr>
						<th>调查人：</th>
						<td>
                            <ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
                        </td>
						<th>调查日期：</th>
						<td><tag:dateInput name="caseInformation.modifySurveyDate"
								pattern="yyyy/MM/dd" nullToToday="true" onlypast="true" date="${caseDto.caseInformation.modifySurveyDate}"/></td>
					</tr>
					 <tr style="display:none;">
		                 <td>
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
