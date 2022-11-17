<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/gonorrhea.js" type="text/javascript"></script>

<c:if test="${isPrint != 1}">
    <jsp:include page="caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
<div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
        <i class="popno">
            淋病个案调查表<br />
            <span>（乙类传染病）</span>
        </i>
        <input type="hidden" name="idmId" value="${idmId}"/>
        <table class="posttable" style="text-align: right;">
            <tr>
                <td style="text-align: right">病例编码:
                    <input type="text" name="caseInformation.mediRecordNum" value="${caseDto.caseInformation.mediRecordNum}"
                           style="width: 120px;" reg='{"digits":"true","maxlength":"14"}'/></td>
            </tr>
        </table>
        <div class="postdiv">
            <fieldset>
                <legend>1.一般情况</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 27%"/>
                        <col style="width: 30%" />
                        <col style="width: 23%" />
                        <col style="width: 20%" />
                    </colgroup>
                    <tr>
                        <th>1.1 姓名：</th>
                        <td><input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}" reg='{"maxlength":"100"}'/></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>1.2 身份证号码：</th>
                        <td><input id="idCard" type="text" name="generalCondition.idcard" value="${caseDto.generalCondition.idcard}" reg='{"idCard":"true"}'
                                   placeholder="输入身份证获取个人信息"/></td>
                    </tr>
                    <tr>
                        <th>1.3 性别：</th>
                        <td><ehr:dic-radio dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${caseDto.generalCondition.gender}"/></td>
                    </tr>
                    <tr>
                        <th>1.4 年龄(岁)：</th>
                        <td><input id="age" type="text" name="generalCondition.age" value="${caseDto.generalCondition.age}" reg='{"maxlength":"6"}'/></td>
                    </tr>
                    <tr>
                        <th>1.5 职业：</th>
                        <td colspan="3">
                            <ehr:dic-list id="occupationId" dicmeta="GBT6565" name="generalCondition.occupation" width="180px;" value="${caseDto.generalCondition.occupation}"
                                          code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120299,CV020120217"
                                          onchange="toggleOtherSC('generalCondition.occupation','occupationOtherPart','CV020120299');"/>
                                    <span id="occupationOtherPart" style="display: none">
                                        <input type="text" name="generalCondition.occupationOther" value="${caseDto.generalCondition.occupationOther}"
                                               reg='{"maxlength":"30"}' placeholder="若选择其他，请描叙" style="width: 150px;"/>
                                    </span>
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
                        <th>1.6 现居住地：</th>
                        <td colspan="3">
                            <ehr:dic-town-street-village streetId="pastreet_address" townId="patown_address" streetName="generalCondition.pastreet" townName="generalCondition.patownShip"
                                                         streetValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="140px;"
                                                         villageId="pavillage_address" villageName="generalCondition.paGroup" villageValue="${caseDto.generalCondition.paGroup}"/>
                            <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
                                   reg='{"maxlength":"50"}' style="width: 180px;">
                            <span id="spanPaNumber">(门牌号)</span>
                        </td>
                    </tr>

                    <tr>
                        <th>1.7 联系电话：</th>
                        <td><input type="text" name="generalCondition.phoneNumber" value="${caseDto.generalCondition.phoneNumber}"
                                   reg='{"regex":"phone"}' /></td>
                    </tr>
                    <tr>
                        <th>1.8 家长或监护人姓名：</th>
                        <td><input type="text" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}"
                                   reg='{"maxlength":"50"}'/></td>
                    </tr>

                    <tr>
                        <th>1.9 工作或学习单位：</th>
                        <td><input type="text" name="generalCondition.unitName" value="${caseDto.generalCondition.unitName}"
                                   reg='{"maxlength":"70"}'/></td>
                    </tr>
                    <tr>
                        <th>1.10 户口所在地：</th>
                        <td colspan="3">
                            <ehr:dic-town-street-village villageId="hrvillage_address" townId="hrtown_address" villageName="generalCondition.paGroup" townName="generalCondition.hrtownShip"
                                                         villageValue="${caseDto.generalCondition.paGroup}" townValue="${caseDto.generalCondition.hrtownShip}" width="140px;"
                                                         streetId="hrstreet_address" streetName="generalCondition.hrstreet" streetValue="${caseDto.generalCondition.hrstreet}"/>

                            <input type="text" name="generalCondition.hrhouseNumber" id="hrhouseNumber" value="${caseDto.generalCondition.hrhouseNumber}"
                                    style="width: 300px;" reg='{"maxlength":"50"}'>
                            <span id="spanHrNumber">(门牌号)</span>
                        </td>
                    </tr>
                    <tr>
                        <th>1.11 发病时间：</th>
                        <td>
                            <tag:dateInput id="pathogenesisDateId" name="attackCondition.pathogenesisDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.pathogenesisDate}" reg='{"compare":["firstVisitDateId","le","发病时间不能晚于初诊时间"]}'/>
                        </td>
                    </tr>
                    <tr>
                        <th>1.12 发病地点：</th>
                        <td>
                            <input type="text" name="attackCondition.pathogenesisPlace" value="${caseDto.attackCondition.pathogenesisPlace}"
                                   reg='{"maxlength":"100"}'>
                        </td>
                    </tr>
                    <tr>
                        <th>1.13 初诊时间：</th>
                        <td>
                            <tag:dateInput id="firstVisitDateId" name="attackCondition.firstVisitDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.firstVisitDate}" reg='{"compare":["pathogenesisDateId","ge","初诊时间不能早于发病时间"]}'/>
                        </td>
                    </tr>
                    <tr>
                        <th>1.14 初诊单位：</th>
                        <td><input type="text" name="attackCondition.firstVisitUnit" value="${caseDto.attackCondition.firstVisitUnit}"
                                   reg='{"maxlength":"100"}'/>
                        </td>
                    </tr>
                    <tr>
                        </td>
                        <th>1.15 初诊病名：</th>
                        <td><input type="text" name="attackCondition.firstVisitName" value="${caseDto.attackCondition.firstVisitName}"
                                   reg='{"maxlength":"100"}'/></td>
                    </tr>
                    <tr>
                        <th>1.16 确诊时间：</th>
                        <td>
                            <tag:dateInput name="attackCondition.confirmationDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.confirmationDate}" reg='{"compare":["firstVisitDateId","ge","确诊时间不能早于初诊时间"]}'/>
                        </td>
                    </tr>
                    <tr>
                        <th>1.17 确诊单位：</th>
                        <td><input type="text" name="attackCondition.confirmationHospital" value="${caseDto.attackCondition.confirmationHospital}"
                                   reg='{"maxlength":"100"}'/></td>
                    </tr>
                    <tr>
                        <th>1.18 入院时间：</th>
                        <td>
                            <tag:dateInput id="inhosDateId" name="attackCondition.inhosDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.inhosDate}" reg='{"compare":["outHospitalDateId","le","入院日期不能晚于出院日期"]}'/>
                        </td>
                    </tr>
                    <tr>
                        <th>1.19 所住医院：</th>
                        <td><input type="text" name="attackCondition.admissionHospital" value="${caseDto.attackCondition.admissionHospital}"
                                   reg='{"maxlength":"100"}'/></td>
                    </tr>
                    <tr>
                        <th>1.20 出院时间：</th>
                        <td>
                            <tag:dateInput id="outHospitalDateId" name="attackCondition.outHospitalDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.outHospitalDate}" reg='{"compare":["inhosDateId","ge","出院日期不能早于入院日期"]}'/>
                        </td>
                    </tr>
                </table>
            </fieldset>

            <fieldset>
                <legend>2.临床表现</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 27%"/>
                        <col style="width: 30%" />
                        <col style="width: 23%" />
                        <col style="width: 20%" />
                    </colgroup>
                    <tr>
                        <th>2.1 出现症状时间：</th>
                        <td>
                            <tag:dateInput name="clinicalManifestations.symptomsTime" pattern="yyyy/MM/dd" date="${caseDto.clinicalManifestations.symptomsTime}"/>
                        </td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>2.2 尿道口或宫颈是否有红肿：</th>
                        <td>
                            <ehr:dic-radio name="clinicalManifestations.isRedMeatusCervical" dicmeta="PH00001" code="1,2" value="${caseDto.clinicalManifestations.isRedMeatusCervical}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>2.3 是否有尿痛：</th>
                        <td>
                            <ehr:dic-radio name="clinicalManifestations.isOdynuria" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.isOdynuria}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>2.4 是否有尿频：</th>
                        <td>
                            <ehr:dic-radio name="clinicalManifestations.isFrequentMicturition" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.isFrequentMicturition}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>2.5 是否有尿急：</th>
                        <td>
                            <ehr:dic-radio name="clinicalManifestations.isUrgencyUrination" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.isUrgencyUrination}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>2.6 尿道或阴道是否有脓性分泌物：</th>
                        <td>
                            <ehr:dic-radio name="clinicalManifestations.isSecretionUrethralVaginal" dicmeta="PH00001" code="1,2" value="${caseDto.clinicalManifestations.isSecretionUrethralVaginal}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>2.7 其它：</th>
                        <td colspan="3"><input type="text" name="clinicalManifestations.other" value="${caseDto.clinicalManifestations.other}"
                                               reg='{"maxlength":"500"}'/> </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset>
                <legend>3.实验室检</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 27%"/>
                        <col style="width: 30%" />
                        <col style="width: 23%" />
                        <col style="width: 20%" />
                    </colgroup>
                    <tr>
                        <th>3.1 淋球菌涂片检查：</th>
                        <td>
                            <ehr:dic-radio name="labExamine.gonococcusTest" dicmeta="PH00004" code="1,2" value="${caseDto.labExamine.gonococcusTest}"/>
                        </td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>3.2 淋球菌培养：</th>
                        <td>
                            <ehr:dic-radio name="labExamine.gonococcusCulture" dicmeta="PH00004" code="1,2" value="${caseDto.labExamine.gonococcusCulture}"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset>
                <legend>4.流行病学调查</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 27%"/>
                        <col style="width: 30%" />
                        <col style="width: 23%" />
                        <col style="width: 20%" />
                    </colgroup>
                    <tr>
                        <th>4.1 外出史：</th>
                        <td>
                            <ehr:dic-radio name="epidemiologicalSurvey.outHistory" dicmeta="PH00002" code="1,2" value="${caseDto.epidemiologicalSurvey.outHistory}"
                                           onchange="toggleOther('epidemiologicalSurvey.outHistory','outHistoryAddr',1)"/>
                            （无，跳至4．3）
                        </td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr id="outHistoryAddr" style="display: none">
                        <th>4.2 外出地点：</th>
                        <td>
                            <ehr:dic-radio name="epidemiologicalSurvey.outHistoryAddr" dicmeta="IDM00009" value="${caseDto.epidemiologicalSurvey.outHistoryAddr}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>4.3 既往性病史：</th>
                        <td>
                            <ehr:dic-radio name="pastHistory.vdHistory" dicmeta="PH00002" code="1,2" value="${caseDto.pastHistory.vdHistory}"
                                           onchange="toggleOther('pastHistory.vdHistory','vdName',1);toggleOther('pastHistory.vdHistory','vdDatePart',1)"/>
                            （无，跳至4．6）
                        </td>
                    </tr>
                    <tr id="vdName" style="display: none">
                        <th>4.4 病名：</th>
                        <td><input type="text" name="pastHistory.vdName" value="${caseDto.pastHistory.vdName}"
                                   reg='{"maxlength":"100"}'/></td>
                    </tr>
                    <tr id="vdDatePart" style="display: none">
                        <th>4.5 患病时间：</th>
                        <td>
                            <tag:dateInput id='vdDate' name="pastHistory.vdDate" pattern="yyyy/MM" date="${caseDto.pastHistory.vdDate}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>4.6 配偶性病史：</th>
                        <td>
                            <ehr:dic-radio name="pastHistory.spouseVdHistory" dicmeta="PH00002" code="1,2" value="${caseDto.pastHistory.spouseVdHistory}"
                                           onchange="toggleOther('pastHistory.spouseVdHistory','spouseVdName',1);toggleOther('pastHistory.spouseVdHistory','spouseVdDatePart',1)"/>
                            （无，跳至4．9）
                        </td>
                    </tr>
                    <tr id="spouseVdName" style="display: none">
                        <th>4.7 病名：</th>
                        <td><input type="text" name="pastHistory.spouseVdName" value="${caseDto.pastHistory.spouseVdName}"
                                   reg='{"maxlength":"100"}'/></td>
                    </tr>
                    <tr  id="spouseVdDatePart" style="display: none">
                        <th>4.8 患病时间：</th>
                        <td><tag:dateInput id="spouseVdDate" name="pastHistory.spouseVdDate" pattern="yyyy/MM" date="${caseDto.pastHistory.spouseVdDate}"/></td>
                    </tr>
                    <tr>
                        <th>4.9 最近一次与配偶性接触时间：</th>
                        <td><input type="text" name="epidemiologicalSurvey.sexDays" value="${caseDto.epidemiologicalSurvey.sexDays}"
                                   style="width: 80px;text-align: center" reg='{"maxlength":"20"}'/>天</td>
                    </tr>
                    <tr>
                        <th>4.10 婚外性接触史：</th>
                        <td>
                            <ehr:dic-radio name="epidemiologicalSurvey.extramaritalSex" dicmeta="PH00002" code="1,2" value="${caseDto.epidemiologicalSurvey.extramaritalSex}"
                                           onchange="toggleOther('epidemiologicalSurvey.extramaritalSex','useCondom',1);toggleOther('epidemiologicalSurvey.extramaritalSex','lastExtramaritalSexDays',1);"/>
                            （无，跳至4.13）
                        </td>
                    </tr>
                    <tr id="useCondom" style="display: none">
                        <th>4.11 婚外性接触时，避孕套使用情况：</th>
                        <td>
                            <ehr:dic-radio name="epidemiologicalSurvey.useCondom" dicmeta="IDM00010" code="1,2,4" value="${caseDto.epidemiologicalSurvey.useCondom}"/>
                        </td>
                    </tr>
                    <tr  id="lastExtramaritalSexDays" style="display: none">
                        <th>4.12 最近一次婚外性接触时间：</th>
                        <td><input type="text" name="epidemiologicalSurvey.lastExtramaritalSexDays" value="${caseDto.epidemiologicalSurvey.lastExtramaritalSexDays}"
                                   style="width: 80px;text-align: center" reg='{"maxlength":"20"}'/> 天前</td>
                    </tr>
                    <tr>
                        <th>4.13 父母性病史：</th>
                        <td>
                            <ehr:dic-radio name="epidemiologicalSurvey.sexHistory" dicmeta="PH00002" code="1,2" value="${caseDto.epidemiologicalSurvey.sexHistory}"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset>
                <legend>5.小结</legend>
                <table class="posttable">
                    <tr>
                        <td><textarea style="width: 100%" rows="5"
                                      name="otherCondition.surveySummary" reg='{"maxlength":"1000"}'>${caseDto.otherCondition.surveySummary}</textarea>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 80px; width: 15%" />
                        <col style="min-width: 280px; width: 35%" />
                        <col style="min-width: 80px; width: 15%" />
                        <col style="min-width: 280px; width: 35%" />
                    </colgroup>
                    <tr>
                        <th>调查者单位 ：</th>
                        <td>
                            <ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/>
                        </td>
                        <th>调查者：</th>
                        <td>
                            <ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>审查者：</th>
                        <td>
                            <ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
                        </td>
                        <th>调查时间：</th>
                        <td>
                            <tag:dateInput name="caseInformation.modifySurveyDate" pattern="yyyy/MM/dd" date="${caseDto.caseInformation.modifySurveyDate}"/>
                        </td>
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
