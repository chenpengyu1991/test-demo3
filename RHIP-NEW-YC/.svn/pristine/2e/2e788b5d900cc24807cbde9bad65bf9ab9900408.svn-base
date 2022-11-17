<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/encephalitisB.js" type="text/javascript"></script>

<c:if test="${isPrint != 1}">
    <jsp:include page="caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
    <div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
    <i class="popno">
        流行性乙型脑炎病例个案调查表<br/>
        <span>（乙类传染病）</span>
    </i>
    <table class="posttable">
        <tr style="text-align: right;">
            <td style="text-align: right">病例编码：
                <input type="text" name="caseInformation.mediRecordNum" value="${caseDto.caseInformation.mediRecordNum}"
                       style="width: 120px;" reg='{"maxlength":"14","digits":"true"}'/>
            </td>
        </tr>
    </table>
    <input type="hidden" name="idmId" value="${idmId}"/>

    <div class="postdiv">
    <fieldset>
        <legend>一. 一般情况</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 30%"/>
                <col style="width: 25%"/>
                <col style="width: 22%"/>
                <col style="width: 23%"/>
            </colgroup>
            <tr>
                <th><label class="required">1.1 传染病报告卡卡片编号</label>：</th>
                <td colspan="3">
                    ${caseDto.caseInformation.caseNo}
                    <input type="hidden" name="caseInformation.caseNo" value="${caseDto.caseInformation.caseNo}"/>
                </td>
            </tr>
            <tr>
                <th><label class="required">1.2 身份证号</label>：</th>
                <td>
                    <input type="text" id="idCard" name="generalCondition.idcard" value="${caseDto.generalCondition.idcard}" reg='{"idCard":"true","required":"true"}'
                           placeholder="输入身份证获取个人信息"/>
                </td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <th><label class="required">1.3 报告日期</label>：</th>
                <td>
                    <tag:dateInput id="reportDate" name="caseInformation.reportDate" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.caseInformation.reportDate}"
                                   reg='{"required":"true"}' style="display:none"/>
                    <fmt:formatDate pattern="yyyy/MM/dd" value="${caseDto.caseInformation.reportDate}"/>
                </td>
            </tr>
            <tr>
                <th><label class="required">1.4 调查日期</label>：</th>
                <td><tag:dateInput name="caseInformation.modifySurveyDate" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.caseInformation.modifySurveyDate}"
                                   reg='{"required":"true","compare":["reportDate","ge","调查日期不能早于报告日期"]}'/></td>
            </tr>
            <tr>
                <th><label class="required">1.5 患者姓名</label>：</th>
                <td colspan="3">
                    <input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}"
                           reg='{"maxlength":"100","required":"true"}' style="width: 150px;"/>
                </td>
            </tr>
            <tr>
                <th><label class="required">1.6 性 别</label>：</th>
                <td>
                    <ehr:dic-radio dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${caseDto.generalCondition.gender}"
                                   reg='{"required":"true"}'/>
                </td>
            </tr>
            <tr>
                <th><label class="required">1.7 出生日期</label>：</th>
                <td>
                    <tag:dateInput name="generalCondition.birthday" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.generalCondition.birthday}"
                                   reg='{"required":"true"}' style="width:100px;"/>
                </td>
            </tr>
            <tr>
                <th><label class="required">1.7.1 如出生日期不详，实足年龄</label>：</th>
                <td colspan="3">
                    <input id="age" type="text" name="generalCondition.age" style="width: 60px; text-align: center" value="${caseDto.generalCondition.age}"
                          reg='{"digits":"true", "range":"0,99"}'/>
                    年龄单位：<ehr:dic-radio name="generalCondition.ageUnit" dicmeta="IDM00003" value="${caseDto.generalCondition.ageUnit}"/>
                </td>
            </tr>
            <tr>
                <th><label class="required">1.8 病人属于</label>：</th>
                <td colspan="3">
                    <ehr:dic-radio name="generalCondition.patientAttribute" dicmeta="CV0201104" value="${caseDto.generalCondition.patientAttribute}"
                                   reg='{"required":"true"}' onchange="encephalitisBCase.toggerAddress()"/>
                </td>
            </tr>
            <tr>
                <th><label class="required">1.9 患者职业</label>：</th>
                <td>
                    <ehr:dic-list id="occupationId" dicmeta="GBT6565" name="generalCondition.occupation" width="180px;" value="${caseDto.generalCondition.occupation}"
                                  code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120299,CV020120217"
                                  reg='{"required":"true"}'/>
                </td>
            </tr>
           <%--  <tr>
                <th>1.10 居住情况：</th>
                <td colspan="3">
                    <ehr:dic-radio name="generalCondition.livingConditions" dicmeta="IDM00252" value="${caseDto.generalCondition.livingConditions}"/>
                </td>
            </tr>
            <tr>
                <th><label class="required">1.11 户籍地</label>：</th>
                <td colspan="3">
                    <ehr:dic-radio name="generalCondition.hrPlace" dicmeta="CV0201104" code="1,3,4" value="${caseDto.generalCondition.hrPlace}"
                           onchange="encephalitisBCase.showHRplace('generalCondition.hrPlace')"/>
                    <br>
                    <span id="hrPart" style="display: none">
                        <ehr:dic-town-village
                                villageId="hrstreet" townId="hrtownShip" villageName="generalCondition.hrstreet" townName="generalCondition.hrtownShip"
                                villageValue="${caseDto.generalCondition.hrstreet}" townValue="${caseDto.generalCondition.hrtownShip}" width="25%;"
                                reg="{'dependOn':'generalCondition.hrPlace','dependValue':'1','required':true}" />
                    </span>
                    <input id="hrhouseNumberID" type="text" name="generalCondition.hrhouseNumber" value="${caseDto.generalCondition.hrhouseNumber}"
                           style="width: 220px;" reg='{"required":"true", "maxlength":"50"}'/>
                </td>
            </tr>
            <tr id="residenceTime">
                <th><label class="required">1.11.1 若是非本县区户口，本县居住时间</label>：</th>
                <td colspan="3"><ehr:dic-radio name="generalCondition.residenceTime" dicmeta="IDM00079" value="${caseDto.generalCondition.residenceTime}"/>
                                              

                </td>
            </tr>
            <tr>
                <th><label class="required">1.11.2 发病前25天内外出情况，及其外出范围</label>：</th>
                <td colspan="3">
                    <ehr:dic-radio name="generalCondition.outgoRange" dicmeta="IDM00080" value="${caseDto.generalCondition.outgoRange}"
                            onchange="toggleOther('generalCondition.outgoRange','rangeOtherProvinces',3);" reg='{"required":"true"}'/>
                    <span id="rangeOtherProvinces" style="display: none">
                        <input type="text" name="generalCondition.rangeOtherProvinces" value="${caseDto.generalCondition.rangeOtherProvinces}"
                               reg='{"maxlength":"100"}' style="width: 150px;"/>
                    </span>
                </td>
            </tr>
            <tr>
                <th><label class="required">1.12 联系人</label>：</th>
                <td colspan="3">
                    <input type="text" name="generalCondition.contactName" value="${caseDto.generalCondition.contactName}" style="width: 150px;"
                           reg='{"required":"true", "maxlength":"50"}'/>
                    联系电话<input type="text" name="generalCondition.contactPhone" value="${caseDto.generalCondition.contactPhone}" style="width: 150px;"
                               reg='{"regex":"phone"}'/>
                    <br>工作单位<input type="text" name="generalCondition.unitName" value="${caseDto.generalCondition.unitName}" style="width: 300px;"
                                   reg='{"maxlength":"70"}'/>
                </td>
            </tr> --%>
           
            <tr>
                <th><label class="required">1.10 详细住址（具体到门牌号）</label>：</th>
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
				<th>1.11  家长姓名：</th>
				<td><input type="text" name="generalCondition.parentsName"
					value="${caseDto.generalCondition.parentsName }"
					reg='{"maxlength":"50"}' /></td>
			</tr>
            <tr>
				<th>1.12 家长电话号码：</th>
				<td><input type="text" name="generalCondition.parentsPhone"
					value="${caseDto.generalCondition.parentsPhone }"
					reg='{"regex":"phone","maxlength":"20"}' /></td>
			</tr>
        </table>
    </fieldset>
    <fieldset>
        <legend>二. 发病情况</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 30%"/>
                <col style="width: 25%"/>
                <col style="width: 22%"/>
                <col style="width: 23%"/>
            </colgroup>
            <tr>
                <th><label class="required">2.1 发病日期</label>：</th>
                <td colspan="3">
                    <tag:dateInput name="attackCondition.pathogenesisDate" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.attackCondition.pathogenesisDate}"
                                   style="width:100px;" reg='{"required":"true"}'/>
                    （病原携带者填初检日期或就诊时间）</td>
            </tr>
            <tr>
                <th><label >2.2 就诊日期</label>：</th>
                <td><tag:dateInput name="attackCondition.clinicDate" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.attackCondition.clinicDate}"
                                    /></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <th>2.3 发病地点：</th>
                <td colspan="2"><input type="text" name="attackCondition.pathogenesisPlace" value="${caseDto.attackCondition.pathogenesisPlace}"
                                       reg='{"maxlength":"100"}'/></td>
            </tr>
            <tr>
                <th>2.4 病例报告单位：</th>
                <td colspan="2">
                    <ehr:org code="${caseDto.caseInformation.reportOrg}"/>
                    <%--<input type="text" name="caseInformation.reportOrg" value="${caseDto.caseInformation.reportOrg}" reg='{"maxlength":"200"}'/>--%>
                    <input type="hidden" name="caseInformation.reportOrg" value="${caseDto.caseInformation.reportOrg}"/>
                </td>
            </tr>
            <tr>
                <th>2.5 病例报告单位级别：</th>
                <td colspan="3">
                    <ehr:dic-radio name="caseInformation.reportUnitType" dicmeta="IDM00004" code="5,4,3,2,1,99"
                                              value="${caseDto.caseInformation.reportUnitType}"/></td>
            </tr>
            <tr>
                <th><label >2.6 住院日期</label>：</th>
                <td><tag:dateInput id="inhosDateId" name="attackCondition.inhosDate" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.attackCondition.inhosDate}"
                                   reg='{"compare":["outHospitalDateId","le","住院日期不能晚于出院日期"]}'/></td>
            </tr>
            <tr>
                <th><label>2.7 入院诊断</label>：</th>
                <td colspan="3"><ehr:dic-radio name="attackCondition.inhosDiagnosis" dicmeta="IDM00040" code="1,2,3,99"
                        value="${caseDto.attackCondition.inhosDiagnosis}" /></td>
            </tr>
            <tr>
                <th><label >2.8 临床诊断日期</label>：</th>
                <td><tag:dateInput name="attackCondition.inhosDiagnosisDate" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.attackCondition.inhosDiagnosisDate}"
                                   /></td>
            </tr>
            <tr>
                <th><label >2.9 临床分型</label>：</th>
                <td><ehr:dic-radio name="attackCondition.clinicalClassification" dicmeta="IDM00610"
                        value="${caseDto.attackCondition.clinicalClassification}" /></td>
            </tr>
            <tr>
                <th><label >2.10 出院日期</label>：</th>
                <td><tag:dateInput id="outHospitalDateId" name="attackCondition.outHospitalDate" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.attackCondition.outHospitalDate}"
                                   reg='{"compare":["inhosDateId","ge","出院日期不能早于住院日期"]}'/></td>
            </tr>
            <tr>
                <th><label >2.11 死亡日期</label>：</th>
                <td><tag:dateInput name="attackCondition.dieDt" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.attackCondition.dieDt}"
                                   reg='{"compare":["inhosDateId","ge","死亡日期不能早于住院日期"]}'/></td>
            </tr>
            <tr>
                <th><label >2.12 出院诊断</label>：</th>
                <td colspan="3"><ehr:dic-radio name="attackCondition.outDiagnosis" dicmeta="IDM00040" code="2,3,5,6,99" value="${caseDto.attackCondition.outDiagnosis}"
                                                onchange="toggleOther('attackCondition.outDiagnosis','outDiagnosisOther',99);"/>
                    <span id="outDiagnosisOther" style="display: none">
                        <input type="text" name="attackCondition.outDiagnosisOther" value="${caseDto.attackCondition.outDiagnosisOther}" style="width: 150px;"
                               reg='{"maxlength":"100"}'/>
                    </span>
                </td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend>三．临床表现</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 30%"/>
                <col style="width: 25%"/>
                <col style="width: 22%"/>
                <col style="width: 23%"/>
            </colgroup>
            <tr>
                <th><b>3.1 临床症状</b>：</th>
            </tr>
           
            <tr>
                <th><label >3.1.1 循环衰竭</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" code="1,2" name="clinicalManifestations.circulatoryFailure"
                                   value="${caseDto.clinicalManifestations.circulatoryFailure}"/></td>
            </tr>
            <tr>
                <th><label >3.1.2 发热</label>：</th>
                <td><ehr:dic-radio name="clinicalManifestations.fever" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.fever}"
                                   onchange="toggleOther('clinicalManifestations.fever','feverLimits',1);"/></td>
            </tr>
            <tr id="feverLimits" style="display: none">
                <th><label >3.1.2.1 如有发热</label>：</th>
                <td colspan="3"><ehr:dic-radio name="clinicalManifestations.feverLimits" dicmeta="IDM00611" value="${caseDto.clinicalManifestations.feverLimits}"
                                   reg='{"dependOn":"clinicalManifestations.fever","dependValue":"1"}'/></td>
            </tr>
            <tr>
                <th><label >3.1.3 头痛</label>：</th>
                <td colspan="3"><ehr:dic-radio name="clinicalManifestations.headache" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.headache}"
                                  /></td>
            </tr>
            <tr>
                <th><label >3.1.4 头晕</label>：</th>
                <td colspan="3"><ehr:dic-radio name="clinicalManifestations.headacheDizziness" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.headacheDizziness}"
                                  /></td>
            </tr>
            <tr>
                <th><label >3.1.5 腹痛</label>：</th>
                <td colspan="3"><ehr:dic-radio name="clinicalManifestations.stomachache" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.stomachache}"
                                  /></td>
            </tr>
            <tr>
                <th>3.1.6 腹泻：</th>
                <td>
                    <ehr:dic-radio name="clinicalManifestations.diarrhea" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.diarrhea}"/>
                </td>
            </tr>
            <tr>
                <th>3.1.7 恶心：</th>
                <td colspan="3">
                    <ehr:dic-radio name="clinicalManifestations.nausea" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.nausea}"/>
                </td>
            </tr>
            <tr>
                <th><label >3.1.8 喷射性呕吐</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.vomit" code="1,2" value="${caseDto.clinicalManifestations.vomit}"
                        onchange="toggleOther('clinicalManifestations.vomit','bloodyVomit',1);" /></td>
            </tr>
            <%-- <tr id="bloodyVomit">
                <th><label >3.1.8.1 如有呕吐， 喷射性呕吐</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.bloodyVomit" code="1,2"
                           value="${caseDto.clinicalManifestations.bloodyVomit}"
                           reg='{"dependOn":"clinicalManifestations.vomit","dependValue":"1"}'
                /></td>
            </tr>--%>
            <tr>
                <th><label>3.1.9 精神萎靡</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.spiritsDrooping" code="1,2"
                        value="${caseDto.clinicalManifestations.spiritsDrooping}"/></td>
            </tr>
            <tr>
                <th>3.1.10 易激惹：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.fussiness" code="1,2"
                                   value="${caseDto.clinicalManifestations.fussiness}"/></td>
            </tr>
            <tr>
                <th><label >3.1.11 嗜睡</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.sleepiness" code="1,2"
                                   value="${caseDto.clinicalManifestations.sleepiness}"/></td>
            </tr>
            <tr>
                <th><label >3.1.12 烦躁</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.irritability" code="1,2"
                                   value="${caseDto.clinicalManifestations.irritability}"/></td>
            </tr>
            <tr>
                <th>3.1.13 惊厥：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.seizure" code="1,2"
                                   value="${caseDto.clinicalManifestations.seizure}"/></td>
            </tr>
            <tr>
                <th><label >3.1.14 意识障碍</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.disturbanceConsciousness" code="1,2"
                                   value="${caseDto.clinicalManifestations.disturbanceConsciousness}"/></td>
            </tr>
          
            <tr>
                <th><label >3.1.15 呼吸衰竭</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" code="1,2" name="clinicalManifestations.respiratoryFailure"
                                   value="${caseDto.clinicalManifestations.respiratoryFailure}"/></td>
            </tr>
            
            <tr>
                <th><b>3.2 临床体征</b>：</th>
            </tr>
            <tr>
                <th><label >3.2.1 血压改变</label>：</th>
                <td><ehr:dic-radio name="clinicalManifestations.bloodPressureChange" dicmeta="PH00002"  code="1,2"
                        value="${caseDto.clinicalManifestations.bloodPressureChange}"/></td>
            </tr>
            <tr>
                <th>3.2.2 呼吸节律改变：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.breathRhythmChange" code="1,2"
                                   value="${caseDto.clinicalManifestations.breathRhythmChange}"/></td>
            </tr>
            <tr>
                <th>3.2.3 瞳孔大小改变：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.pupilSizeChange" code="1,2"
                                   value="${caseDto.clinicalManifestations.pupilSizeChange}"/></td>
            </tr>
            <tr>
                <th><label >3.2.4 脑膜刺激征</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.meningealIrritation" code="1,2"
                                   value="${caseDto.clinicalManifestations.meningealIrritation}"/></td>
            </tr>
            <tr>
                <th><label >3.2.5 前囱膨隆</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.chimney"  code="1,2"
                                   value="${caseDto.clinicalManifestations.chimney}"/></td>
            </tr>
            <tr>
                <th>3.2.6 腹壁反射：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.abdominalReflexes" code="1,2"
                                   value="${caseDto.clinicalManifestations.abdominalReflexes}"/></td>
            </tr>
            <tr>
                <th>3.2.7 提睾反射：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.cremastericFrelex" code="1,2"
                                   value="${caseDto.clinicalManifestations.cremastericFrelex}"/></td>
            </tr>
            <tr>
                <th>3.2.8 病理反射：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.pathorogicalReflex" code="1,2"
                                   value="${caseDto.clinicalManifestations.pathorogicalReflex}"/></td>
            </tr>
            <tr>
                <th><label >3.2.8.1 肌张力增强</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.muscleTensionEnhanced" code="1,2"
                                   value="${caseDto.clinicalManifestations.muscleTensionEnhanced}"/></td>
            </tr>
            <tr>
                <th><label >3.2.8.2 巴彬斯基征</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.babinskiSign" code="1,2"
                                   value="${caseDto.clinicalManifestations.babinskiSign}"/></td>
            </tr>
            <tr>
                <th><b>3.3 并发症</b>：</th>
            </tr>
            <tr>
                <th><label >3.3.1 支气管肺炎</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.bronchopneumonia" code="1,2"
                        value="${caseDto.clinicalManifestations.bronchopneumonia}"/></td>
            </tr>
            <tr>
                <th><label >3.3.2 肺不张</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.pulmonaryAtelectasis" code="1,2"
                                   value="${caseDto.clinicalManifestations.pulmonaryAtelectasis}"/></td>
            </tr>
            <tr>
                <th><label >3.3.3 败血症</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.sepsis" code="1,2"
                                   value="${caseDto.clinicalManifestations.sepsis}"/></td>
            </tr>
            <tr>
                <th><label >3.3.4 胃肠道出血</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.gastrointestinalBleeding" code="1,2"
                                   value="${caseDto.clinicalManifestations.gastrointestinalBleeding}"/></td>
            </tr>
            <tr>
                <th><label >3.3.5 尿路感染</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.urinaryTractInfection" code="1,2"
                                   value="${caseDto.clinicalManifestations.urinaryTractInfection}"/></td>
            </tr>
            <tr>
                <th>3.3.6 其它（请注明）：</th>
                <td colspan="2"><input type="text" name="clinicalManifestations.other" value="${caseDto.clinicalManifestations.other}" reg='{"maxlength":"500"}'/></td>
            </tr>
            <tr>
                <th><label >3.4 病情转归</label>：</th>
                <td><ehr:dic-radio dicmeta="IDM00005" name="clinicalManifestations.outcome" code="2,1,7,4"
                                   value="${caseDto.clinicalManifestations.outcome}"/></td>
            </tr>
            <tr>
                <th><label >3.4.1 语言迟钝</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.languageRetardation" code="1,2"
                                   value="${caseDto.clinicalManifestations.languageRetardation}"/></td>
            </tr>
            <tr>
                <th><label >3.4.2 失语</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.aphasia" code="1,2"
                                   value="${caseDto.clinicalManifestations.aphasia}"/></td>
            </tr>
            <tr>
                <th><label >3.4.3 痴呆</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.stupid" code="1,2"
                                   value="${caseDto.clinicalManifestations.stupid}"/></td>
            </tr>
            <tr>
                <th><label >3.4.4瘫痪</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.palsy" code="1,2"
                                   value="${caseDto.clinicalManifestations.palsy}"/></td>
            </tr>
            <tr>
                <th><label >3.4.5 记忆力及理解减退</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.memoryImpairmentUnderstand" code="1,2"
                                   value="${caseDto.clinicalManifestations.memoryImpairmentUnderstand}"/></td>
            </tr>
            <tr>
                <th><label >3.4.6 耳聋</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.deaf" code="1,2"
                                   value="${caseDto.clinicalManifestations.deaf}"/></td>
            </tr>
            <tr>
                <th><label >3.4.7 癫痫</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.epilepsy" code="1,2"
                                   value="${caseDto.clinicalManifestations.epilepsy}"/></td>
            </tr>
            <tr>
                <th><label >3.4.8 吞咽困难</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.dysphagia" code="1,2"
                                   value="${caseDto.clinicalManifestations.dysphagia}"/></td>
            </tr>
            <tr>
                <th><label >3.4.9 视神经萎缩</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.opticAtrophy" code="1,2"
                                   value="${caseDto.clinicalManifestations.opticAtrophy}"/></td>
            </tr>
            <tr>
                <th><label >3.4.10 流涎</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.hydrostomia" code="1,2"
                                   value="${caseDto.clinicalManifestations.hydrostomia}"/></td>
            </tr>
            <tr>
                <th><label>3.4.11其他</label>：</th>
                <td><input type="text" name="clinicalManifestations.outcomeOtherWrite" value="${caseDto.clinicalManifestations.outcomeOtherWrite}"
                           style="width: 120px;" reg='{"maxlength":"100"}'/></td>
            </tr>
            <tr>
                <th><label >3.4.12 死亡原因</label>：</th>
                <td colspan="3"><ehr:dic-radio dicmeta="IDM00092" name="clinicalManifestations.deathReason"
                                   value="${caseDto.clinicalManifestations.deathReason}"
                                   onchange="toggleOther('clinicalManifestations.deathReason','deathReasonOther',99);" />
                    <span id = "deathReasonOther" style="display:none;">
                    <input type="text" name="clinicalManifestations.deathReasonOther" value="${caseDto.clinicalManifestations.deathReasonOther}"
                           style="width: 120px;" reg='{"maxlength":"100"}'/>
                    </span></td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend>四. 乙脑疫苗免疫史</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 30%"/>
                <col style="width: 25%"/>
                <col style="width: 22%"/>
                <col style="width: 23%"/>
            </colgroup>
            <tr>
                <th><label >4.1 乙脑疫苗接种史</label>：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.inoculateHistory" code="1,2,4" value="${caseDto.epidemiologicalSurvey.inoculateHistory}"
                                    onchange="encephalitisBCase.toggleinoculate('epidemiologicalSurvey.inoculateHistory')"/></td>
                <td></td>
                <td></td>
            </tr>
            <tbody id="inoculatePart" style="display: none">
                <tr>
                    <th><label >4.2 接种依据</label>：</th>
                    <td colspan="3">
                        <ehr:dic-radio name="epidemiologicalSurvey.vaccinationReason" dicmeta="IDM00069" code="1,2,6,99" value="${caseDto.epidemiologicalSurvey.vaccinationReason}"
                                       reg='{"dependOn":"epidemiologicalSurvey.inoculateHistory","dependValue":"1"}'/>
                    </td>
                </tr>
                <tr>
                    <th><label >4.3 若接种,则疫苗种类</label>：</th>
                    <td colspan="3">
                        <ehr:dic-radio name="epidemiologicalSurvey.jespectCategory" dicmeta="IDM00014" value="${caseDto.epidemiologicalSurvey.jespectCategory}"
                                      reg='{"dependOn":"epidemiologicalSurvey.inoculateHistory","dependValue":"1"}'/>
                    </td>
                </tr>
                <tr>
                    <th>4.4 若接种过乙脑疫苗,则接种次数：</th>
                    <td colspan="3"><ehr:dic-radio name="epidemiologicalSurvey.inoculateNum" dicmeta="IDM00612"
                                      value="${caseDto.epidemiologicalSurvey.inoculateNum}" onchange="toggleOther('epidemiologicalSurvey.inoculateNum','inoculateNum',99);"/>
                                    <span id="inoculateNum" style="display: none">
				                        <input type="text" name="epidemiologicalSurvey.other" value="${caseDto.epidemiologicalSurvey.other}"
				                                style="width: 100px;" reg='{"maxlength":"20"}'/>
				                    </span>
                     </td>
                </tr>
                <tr>
                    <th><label >4.5 乙脑疫苗接种时间</label>：</th>
                </tr>
                <tr>
                    <th><label >4.5.1 乙脑灭活疫苗</label>：</th>
                </tr>
                <tr>
                    <th>a. 第1次接种时间：</th>
                    <td><tag:dateInput id="jespectInactivateDtF" name="epidemiologicalSurvey.jespectInactivateDtF" pattern="yyyy/MM/dd" onlypast="true"
                                       date="${caseDto.epidemiologicalSurvey.jespectInactivateDtF}" reg='{"compare":["jespectInactivateDtS","le","第1次接种时间不能晚于第2次接种时间"]}'/></td>
                </tr>
                <tr>
                    <th>b. 第2次接种时间：</th>
                    <td><tag:dateInput id="jespectInactivateDtS" name="epidemiologicalSurvey.jespectInactivateDtS" pattern="yyyy/MM/dd" onlypast="true"
                                       date="${caseDto.epidemiologicalSurvey.jespectInactivateDtS}" reg='{"compare":["jespectInactivateDtF","ge","第2次接种时间不能早于第1次接种时间"]}'/></td>
                </tr>
                <tr>
                    <th>c. 第3次接种时间：</th>
                    <td><tag:dateInput id="jespectInactivateDtT" name="epidemiologicalSurvey.jespectInactivateDtT" pattern="yyyy/MM/dd" onlypast="true"
                                       date="${caseDto.epidemiologicalSurvey.jespectInactivateDtT}" reg='{"compare":["jespectInactivateDtS","ge","第3次接种时间不能早于第2次接种时间"]}'/></td>
                </tr>
                <tr>
                    <th>d. 第4次接种时间：</th>
                    <td><tag:dateInput id="jespectInactivateDtFo" name="epidemiologicalSurvey.jespectInactivateDtFo" pattern="yyyy/MM/dd" onlypast="true"
                                       date="${caseDto.epidemiologicalSurvey.jespectInactivateDtFo}" reg='{"compare":["jespectInactivateDtT","ge","第4次接种时间不能早于第3次接种时间"]}'/></td>
                </tr>
                <tr>
                    <th>e. 最后1次接种时间：</th>
                    <td><tag:dateInput name="epidemiologicalSurvey.jespectInactivateLast" pattern="yyyy/MM/dd" onlypast="true"
                                       date="${caseDto.epidemiologicalSurvey.jespectInactivateLast}" reg='{"compare":["jespectInactivateDtFo","ge","最后一次接种时间不能早于第4次接种时间"]}'/></td>
                </tr>
                <tr>
                    <th><label class="required">4.5.2 乙脑减毒活疫苗</label>：</th>
                </tr>
                <tr>
                    <th>a. 第1次接种时间：</th>
                    <td><tag:dateInput id="jespectAttenuatedDtF" name="epidemiologicalSurvey.jespectAttenuatedDtF" pattern="yyyy/MM/dd" onlypast="true"
                                       date="${caseDto.epidemiologicalSurvey.jespectAttenuatedDtF}" reg='{"compare":["jespectAttenuatedDtS","le","第1次接种时间不能晚于第2次接种时间"]}'/></td>
                </tr>
                <tr>
                    <th>b. 第2次接种时间：</th>
                    <td><tag:dateInput id="jespectAttenuatedDtS" name="epidemiologicalSurvey.jespectAttenuatedDtS" pattern="yyyy/MM/dd" onlypast="true"
                                       date="${caseDto.epidemiologicalSurvey.jespectAttenuatedDtS}" reg='{"compare":["jespectAttenuatedDtF","ge","第2次接种时间不能早于第1次接种时间"]}'/></td>
                </tr>
                <tr>
                    <th>c. 第3次接种时间：</th>
                    <td><tag:dateInput id="jespectAttenuatedDtT" name="epidemiologicalSurvey.jespectAttenuatedDtT" pattern="yyyy/MM/dd" onlypast="true"
                                       date="${caseDto.epidemiologicalSurvey.jespectAttenuatedDtT}" reg='{"compare":["jespectAttenuatedDtS","ge","第3次接种时间不能早于第2次接种时间"]}'/></td>
                </tr>
                <tr>
                    <th>d. 最后1次接种时间：</th>
                    <td><tag:dateInput name="epidemiologicalSurvey.jespectAttenuatedLast" pattern="yyyy/MM/dd" onlypast="true"
                                       date="${caseDto.epidemiologicalSurvey.jespectAttenuatedLast}" reg='{"compare":["jespectAttenuatedDtT","ge","最后一次接种时间不能早于第3次接种时间"]}'/></td>
                </tr>
            </tbody>
            <tr id="unvaccinatedReasonPart" style="display: none">
                <th>4.5.3 未接种疫苗原因：</th>
                <td colspan="3"><ehr:dic-list id="unvaccinatedReason" name="epidemiologicalSurvey.unvaccinatedReason" dicmeta="IDM00084" code="1,2,3,4,5,99" value="${caseDto.epidemiologicalSurvey.unvaccinatedReason}"
                                  onchange="toggleOtherSC('epidemiologicalSurvey.unvaccinatedReason','unvaccinatedReasonOther',99);"/>
                    <span id="unvaccinatedReasonOther" style="display: none">
                        <input type="text" name="epidemiologicalSurvey.unvaccinatedReasonOther" value="${caseDto.epidemiologicalSurvey.unvaccinatedReasonOther}"
                                style="width: 200px;" reg='{"maxlength":"20"}'/>
                    </span>
                </td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend>五.实验室常规及辅助检查</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 30%"/>
                <col style="width: 25%"/>
                <col style="width: 22%"/>
                <col style="width: 23%"/>
            </colgroup>
            <tr>
                <th>5.1 血清检测：</th>
            </tr>
            

            <tr>
                <th><label >5.1.1 疾病预防控制机构检测用第1份血清</label>：</th>
                <td><ehr:dic-radio dicmeta="IDM00085" name="labExamine.firstSerum"  value="${caseDto.labExamine.firstSerum}"
                        onchange="toggleOther('labExamine.firstSerum','firstSerumPart',1);"/></td>
            </tr>
            <tbody id="firstSerumPart" style="display: none">
                <tr>
                    <th><label >5.1.1.1 采集时间</label>：</th>
                    <td colspan="2">
                        <tag:dateInput name="labExamine.firstSerumCollectTime" pattern="yyyy/MM/dd" style="width:100px;"
                               date="${caseDto.labExamine.firstSerumCollectTime}" onlypast="true"
                               reg='{"dependOn":"labExamine.firstSerum","dependValue":"1"}'/></td>
                </tr>
                <tr>
                    <th><label >5.1.1.2 检测时间</label>：</th>
                    <td><tag:dateInput name="labExamine.firstSerumReportTime" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.labExamine.firstSerumReportTime}"
                                       reg='{"dependOn":"labExamine.firstSerum","dependValue":"1"}'/></td>
                </tr>
                <tr>
                    <th><label >5.1.1.3白细胞计数（×10<sup>9</sup> /L）</label>：</th>
                    <td><input type="text" name="labExamine.plateletReduce" value="${caseDto.labExamine.plateletReduce}"
                               reg='{"dependOn":"labExamine.serumCollectFlg","dependValue":"1","maxlength":"20"}'/></td>
                </tr>
                 <tr>
                   	<th><label >5.1.1.4 淋巴比例（%）</label>：</th>
                    <td><input type="text" name="labExamine.limphOne" value="${caseDto.labExamine.limphOne}"
                               reg='{"maxlength":"100"}'/></td>
                </tr> 
               <tr>
                    <th><label >5.1.1.5 实验室检测方法</label>：</th>
                    <td><ehr:dic-list name="labExamine.firstSerumMethod" dicmeta="IDM00086" value="${caseDto.labExamine.firstSerumMethod}"
                                      reg='{"dependOn":"labExamine.firstSerum","dependValue":"1"}'/></td>
                </tr>
                <tr>
                    <th><label >5.1.1.6 乙脑特异性抗体IgM</label>：</th>
                    <td><ehr:dic-radio name="labExamine.firstSerumJeAntibodyIgm" dicmeta="PH00004" code="2,1" value="${caseDto.labExamine.firstSerumJeAntibodyIgm}"
                                       reg='{"dependOn":"labExamine.firstSerum","dependValue":"1"}'/></td>
                </tr>
                <tr>
                    <th><label >5.1.1.7 乙脑特异性抗体IgG</label>：</th>
                    <td><ehr:dic-radio name="labExamine.firstSerumJeAntibodyIgg" dicmeta="PH00004" code="2,1" value="${caseDto.labExamine.firstSerumJeAntibodyIgg}"
                                       reg='{"dependOn":"labExamine.firstSerum","dependValue":"1"}'/></td>
                </tr>
                <tr>
                    <th><label >5.1.1.7.1 乙脑特异性IgG的效价,抗体效价</label>：</th>
                    <td><input type="text" name="labExamine.firstSerumJeIggTiter" value="${caseDto.labExamine.firstSerumJeIggTiter}"
                               reg='{"dependOn":"labExamine.firstSerum","dependValue":"1","maxlength":"20"}'/></td>
                </tr>
                
            </tbody>

             <tr>
                <th>5.1.2 疾病预防控制机构检测用第2份血清：</th>
                <td><ehr:dic-radio dicmeta="IDM00085" name="labExamine.secondSerum" value="${caseDto.labExamine.secondSerum}"
                        onchange="toggleOther('labExamine.secondSerum','secondSerumPart',1);"/></td>
            </tr>
            <tbody id="secondSerumPart" style="display: none">
                <tr>
                    <th><label >5.1.2.1 采集时间</label>：</th>
                    <td><tag:dateInput name="labExamine.secondSerumCollectTime" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.labExamine.secondSerumCollectTime}"
                                       reg='{"dependOn":"labExamine.secondSerum","dependValue":"1"}'/></td>
                </tr>
                <tr>
                    <th><label>5.1.2.2 检测时间</label>：</th>
                    <td><tag:dateInput name="labExamine.secondSerumReportTime" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.labExamine.secondSerumReportTime}"
                                        reg='{"dependOn":"labExamine.secondSerum","dependValue":"1"}'/></td>
                </tr>
               
                <tr>
                    <th><label >5.1.2.3 乙脑特异性抗体IgM</label>：</th>
                    <td><ehr:dic-radio name="labExamine.secondSerumJeAntibodyIgm" dicmeta="PH00004" code="2,1" value="${caseDto.labExamine.secondSerumJeAntibodyIgm}"
                                       reg='{"dependOn":"labExamine.secondSerum","dependValue":"1"}'/></td>
                </tr>
                <tr>
                    <th><label >5.1.2.3.1 乙脑特异性抗体IgG</label>：</th>
                    <td><ehr:dic-radio name="labExamine.secondSerumJeAntibodyIgg" dicmeta="PH00004" code="2,1" value="${caseDto.labExamine.secondSerumJeAntibodyIgg}"
                                       reg='{"dependOn":"labExamine.secondSerum","dependValue":"1"}'/></td>
                </tr>
             
            </tbody>
            <tr>
                <th><label >5.2 脑脊液检测</label>：</th>
                <td><ehr:dic-radio dicmeta="IDM00085" name="labExamine.csfCheck" value="${caseDto.labExamine.csfCheck}"
                        onchange="toggleOther('labExamine.csfCheck','csfCheckPart',1);"/></td>
            </tr>
            <tbody id="csfCheckPart" style="display: none">
                <tr>
                    <th><label >5.2.1 采集时间</label>：</th>
                    <td><tag:dateInput name="labExamine.csfCheckCollectTime" pattern="yyyy/MM/dd" onlypast="true"
                                       date="${caseDto.labExamine.csfCheckCollectTime}" reg='{"dependOn":"labExamine.csfCheck","dependValue":"1"}'/></td>
                </tr>
                <tr>
                    <th><label >5.2.2 检测时间</label>：</th>
                    <td><tag:dateInput name="labExamine.csfCheckReportTime" pattern="yyyy/MM/dd" onlypast="true"
                                       date="${caseDto.labExamine.csfCheckReportTime}" reg='{"dependOn":"labExamine.csfCheck","dependValue":"1"}'/></td>
                </tr>
                <tr>
                    <th><label >5.2.3 物理检测</label>：</th>
                    <td colspan="3"><ehr:dic-radio name="labExamine.csfPhysicsTest" dicmeta="IDM00087"
                                      value="${caseDto.labExamine.csfPhysicsTest}" reg='{"dependOn":"labExamine.csfCheck","dependValue":"1"}'/>
                    </td>
                </tr>
                <tr>
                    <th>5.2.4 生化检测：</th>
                </tr>
                <tr>
                    <th><label >5.2.4.1细胞数(正常值0~15/μl)</label>：</th>
                    <td><input type="text" name="labExamine.csfCell"
                               value="${caseDto.labExamine.csfCell}" reg='{"dependOn":"labExamine.csfCheck","dependValue":"1","maxlength":"20"}'/></td>
                </tr>
                <tr>
                    <th><label >5.2.4.2蛋 白(正常值<0.45 g/l)</label>：</th>
                    <td><input type="text" name="labExamine.csfAlbumen" value="${caseDto.labExamine.csfAlbumen}"
                               reg='{"dependOn":"labExamine.csfCheck","dependValue":"1","maxlength":"20"}'/></td>
                </tr>
                <tr>
                    <th><label >5.2.4.3 糖(mmol/L)</label>：</th>
                    <td>
                    <ehr:dic-radio dicmeta="PH00013" name="labExamine.csfSugar" code="1,2,3" value="${caseDto.labExamine.csfSugar}"
                                       reg='{"dependOn":"labExamine.csfCheck","dependValue":"1"}'/></td>
                </tr>
                <tr>
                    <th>5.2.4.3.1 糖检测值：</th>
                    <td><input type="text" name="labExamine.csfSugarCount" value="${caseDto.labExamine.csfSugarCount}" reg='{"maxlength":"20"}'/>mmol/L</td>
                </tr>
                <tr>
                    <th><label >5.2.4.4 氯化物(mmol/L)</label>：</th>
                    <td><ehr:dic-radio dicmeta="PH00013" name="labExamine.csfChloride" code="1,2,3" value="${caseDto.labExamine.csfChloride}"
                                       reg='{"dependOn":"labExamine.csfCheck","dependValue":"1"}'/></td>
                </tr>
                <tr>
                    <th>5.2.4.4.1 氯化物检测值：</th>
                    <td><input type="text" name="labExamine.csfChlorideCount" value="${caseDto.labExamine.csfChlorideCount}" reg='{"maxlength":"20"}'/>mmol/L</td>
                </tr>
                <tr>
                    <th><label >5.2.4.5 乙脑特异性抗体IgM</label>：</th>
                    <td><ehr:dic-radio  dicmeta="PH00004" code="2,1" name="labExamine.csfJeAntibody" value="${caseDto.labExamine.csfJeAntibody}"
                                        reg='{"dependOn":"labExamine.csfCheck","dependValue":"1"}'/></td>
                </tr>
            </tbody>

            <tr>
                <th>5.3 病毒分离：</th>
                <td><ehr:dic-radio dicmeta="IDM00089" name="labExamine.jeViralIsolation" value="${caseDto.labExamine.jeViralIsolation}"
                        onchange="toggleOther('labExamine.jeViralIsolation','jeViralIsolationPart',1);"/></td>
            </tr>
            <tbody id="jeViralIsolationPart" style="display: none">
                <tr>
                    <th>5.3.1 病毒分离标本：</th>
                    <td colspan="3"><ehr:dic-radio dicmeta="IDM00088" name="labExamine.jeViralIsolationSample" value="${caseDto.labExamine.jeViralIsolationSample}"/></td>
                </tr>
                <tr>
                    <th><label >5.3.2 病毒分离时间</label>：</th>
                    <td><tag:dateInput name="labExamine.jeViralIsolationTime" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.labExamine.jeViralIsolationTime}"
                               reg='{"dependOn":"labExamine.jeViralIsolation","dependValue":"1"}'/></td>

                </tr>
                <tr>
                    <th><label >5.3.3病毒分离结果</label>：</th>
                    <td><ehr:dic-radio dicmeta="PH00004" name="labExamine.jeViralIsolationResult" code="2,1" value="${caseDto.labExamine.jeViralIsolationResult}"
                               reg='{"dependOn":"labExamine.jeViralIsolation","dependValue":"1"}'/></td>
                </tr>
                <tr>
                    <th>5.3.4病毒鉴定结果：</th>
                    <td><input type="text" name="labExamine.jeViralIdentiResult"
                               value="${caseDto.labExamine.jeViralIdentiResult}" reg='{"maxlength":"20"}'/>
                    <%-- <ehr:dic-radio dicmeta="IDM00234" name="labExamine.jeViralIdentiResult" value="${caseDto.labExamine.jeViralIdentiResult}"/> --%></td>
                </tr>
                <tr>
                    <th>5.3.5 聚合酶链反应(PCR)结果：</th>
                    <td><input type="text" name="labExamine.jeViralPcr"
                               value="${caseDto.labExamine.jeViralPcr}" reg='{"maxlength":"20"}'/>
                   
                </tr>
            </tbody>
        </table>
    </fieldset>
    <fieldset>
        <legend>六.结论</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 30%"/>
                <col style="width: 25%"/>
                <col style="width: 22%"/>
                <col style="width: 23%"/>
            </colgroup>
            <tr>
                <th><label >6.1 最终病例分类</label>：</th>
                <td colspan="3">
                    <ehr:dic-radio name="otherCondition.caseType" dicmeta="IDM00040" code="1,2,3,5,6" value="${caseDto.otherCondition.caseType}"/>
                </td>
            </tr>
            <tr>
                <th>6.2 病例疫情：</th>
                <td ><ehr:dic-radio name="otherCondition.caseEpidemic" dicmeta="IDM00574"
                                    value="${caseDto.otherCondition.caseEpidemic}"/>
                </td>
            </tr>
            <tr>
                <th>6.3如为排除病例，依据为：</th>
                <td colspan="3"><ehr:dic-list name="otherCondition.classifyAccording" dicmeta="IDM00090" value="${caseDto.otherCondition.classifyAccording}"
                        onchange="toggleOtherSC('otherCondition.classifyAccording','classifyAccordingOther',99);"/>
                    <span id="classifyAccordingOther" style="display: none">
                        <input type="text" name="otherCondition.classifyAccordingOther" style="width: 200px;"
                               value="${caseDto.otherCondition.classifyAccordingOther}" reg='{"maxlength":"20"}'/>
                    </span>
                </td>
            </tr> 
            <tr>
                <th>被调查人(与患者关系)：</th>
                <td><input type="text" name="caseInformation.informantPatienRel" value="${caseDto.caseInformation.informantPatienRel}" reg='{"maxlength":"20"}'/></td> 
            </tr>
            <tr>
                <th>调 查 人：</th>
                <td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/></td>
                <th>调查单位：</th>
                <td><ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/></td>
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

