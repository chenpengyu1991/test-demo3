<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/views/mhm/management/outInfo/edit.js" type="text/javascript"></script>

<div class="postcontent postdiv" id="detailDiv">

<fieldset style="margin-top: 10px">
<form id="outInfoForm">

<input type="hidden" name="statusId" value="${managementDto.statusId}"/>
<input type="hidden" name="eventId" value="${managementDto.eventId}"/>

<input type="hidden" name="mhmBasicsInfo.id" value="${managementDto.mhmBasicsInfo.id}"/>
<input type="hidden" name="mhmOtherInfo.id" value="${managementDto.mhmOtherInfo.id}"/>
<input type="hidden" name="mhmPathHistory.id" value="${managementDto.mhmPathHistory.id}"/>
<input type="hidden" name="mhmInhospital.id" value="${managementDto.mhmInhospital.id}"/>

<input type="hidden" name="inMedication" id="inMedication">
<input type="hidden" name="nextMedication" id="nextMedication">

<table class="posttable">
    <colgroup>
        <col/>
        <col style="width:150px;"/>
    </colgroup>
    <tr>
        <td colspan="2" style="text-align: center">
            <i class="popno" style="width: auto">出院信息</i></td>
    </tr>
</table>
<table class="posttable">
    <colgroup>
        <col style="min-width: 50px; width: 23%;"/>
        <col style="min-width: 80px; width: 27%;"/>
        <col style="min-width: 50px; width: 23%;"/>
        <col style="min-width: 80px; width: 27%;"/>
    </colgroup>
    <input type="hidden" id="eventIdOut" value="${managementDto.mhmBasicsInfo.eventId}">
    <tr>
        <th><label class="required">身份证号：</label></th>
        <td>
            <input type="text" name="mhmBasicsInfo.idcard" value="${managementDto.mhmBasicsInfo.idcard}" reg='{"idCard":"idCard","required":"true"}'/>
        </td>
        <th><label class="required">姓名：</label></th>
        <td>
            <input type="text" name="mhmBasicsInfo.name" value="${managementDto.mhmBasicsInfo.name}" reg='{"maxlength":"10","required":"true"}'/>
        </td>
    </tr>
    <tr>
        <th><label class="required">性别：</label></th>
        <td>
            <ehr:dic-radio name="mhmBasicsInfo.gender" dicmeta="GBT226112003" value="${managementDto.mhmBasicsInfo.gender}" code="1,2" reg='{"required":"true"}'/>
        </td>
        <th><label class="required">出生日期：</label></th>
        <td>
            <tag:dateInput name="mhmBasicsInfo.birthdate" style="width: 100px;" reg='{"regex":"date", "required":"true"}'  pattern="yyyy/MM/dd"
                           date="${managementDto.mhmBasicsInfo.birthdate}" onlypast="true"/>
        </td>
    </tr>
    <tr>
        <th>所在辖区：</th>
        <td>
            <input type="text" name="mhmBasicsInfo.viceroyship" value="${managementDto.mhmBasicsInfo.viceroyship}" reg='{"maxlength":100}'/>
        </td>
        <th>家庭电话：</th>
        <td>
            <input type="text" name="mhmBasicsInfo.familyPhone" value="${managementDto.mhmBasicsInfo.familyPhone}" reg='{"regex":"phone","maxlength":20}'/>
        </td>
    </tr>
    <tr>
        <th>联系人姓名：</th>
        <td>
            <input type="text" name="mhmBasicsInfo.contactName" value="${managementDto.mhmBasicsInfo.contactName}" reg='{"maxlength":50}'/>
        </td>
        <th>联系人电话：</th>
        <td>
            <input type="text" name="mhmBasicsInfo.contactPhone" value="${managementDto.mhmBasicsInfo.contactPhone}" reg='{"regex":"phone","maxlength":20}'/>
        </td>
    </tr>
    <tr>
        <th>常住类型：</th>
        <td>
            <ehr:dic-radio name="mhmBasicsInfo.floatPopulation" dicmeta="FS10005" value="${managementDto.mhmBasicsInfo.floatPopulation}"/>
        </td>
        <th><label class="required">民族：</label></th>
        <td>
            <ehr:dic-list name="mhmBasicsInfo.nation" dicmeta="GBT3304" value="${managementDto.mhmBasicsInfo.nation}" uninclude="99" reg='{"required":"true"}'/>
        </td>
    </tr>
    <tr>
        <th><label class="required">监护人姓名：</label></th>
        <td>
            <input type="text" name="mhmBasicsInfo.parentsName" value="${managementDto.mhmBasicsInfo.parentsName}" reg='{"maxlength":"50","required":"true"}'/>
        </td>
        <th><label class="required">监护人与病人关系：</label></th>
        <td>
            <ehr:dic-list name="mhmBasicsInfo.guarderRelationCode" dicmeta="MH00044" value="${managementDto.mhmBasicsInfo.guarderRelationCode}" reg='{"required":"true"}'/>
        </td>
    </tr>
    <tr>
        <th><label class="required">监护人联系电话：</label></th>
        <td>
            <input type="text" name="mhmBasicsInfo.guarderPhone" value="${managementDto.mhmBasicsInfo.guarderPhone}" reg='{"required":"true","regex":"phone","maxlength":20}'/>
        </td>
        <th><label class="required">初次发病时间：</label></th>
        <td>
            <tag:dateInput name="mhmPathHistory.firstDiseaseDate" style="width: 100px;" reg='{"regex":"date","required":"true"}'  pattern="yyyy/MM/dd" date="${managementDto.mhmPathHistory.firstDiseaseDate}" onlypast="true"/>
        </td>
    </tr>
    <tr>
        <th><label class="required">知情同意：</label></th>
        <td>
            <ehr:dic-radio name="mhmOtherInfo.informedConsent" dicmeta="MH00051" value="${managementDto.mhmOtherInfo.informedConsent}" reg='{"required":"true"}'/>
        </td>
        <th><label class="required">知情同意签字时间：</label></th>
        <td>
            <tag:dateInput name="mhmOtherInfo.informedConsentSignDate" style="width: 100px;" reg='{"regex":"date","required":"true"}'
                           pattern="yyyy/MM/dd" date="${managementDto.mhmOtherInfo.informedConsentSignDate}" onlypast="true"/>
        </td>
    </tr>
    <tr>
        <th>知情同意签字：</th>
        <td>
            <input type="text" name="mhmOtherInfo.informedConsentName" value="${managementDto.mhmOtherInfo.informedConsentName}" reg='{"maxlength":50}'/>
        </td>
        <th><label class="required">两系三代精神疾病家族史：</label></th>
        <td>
            <ehr:dic-radio name="mhmPathHistory.familyHistory" dicmeta="PH00002" value="${managementDto.mhmPathHistory.familyHistory}" reg='{"required":"true"}' code="1,2"/>
        </td>
    </tr>
    <tr>
        <th><label class="required">文化程度：</label></th>
        <td>
            <ehr:dic-list name="mhmBasicsInfo.education" dicmeta="GBT46582006" value="${managementDto.mhmBasicsInfo.education}"
                          reg='{"required":"true"}' code="IDM09,IDM14,IDM07,IDM02,IDM03,IDM04,IDM15,IDM08,IDM10"/>
        </td>
        <th><label class="required">职业：</label></th>
        <td>
            <ehr:dic-list dicmeta="GBT6565" name="mhmBasicsInfo.occupation" width="140px;" value="${managementDto.mhmBasicsInfo.occupation}"
                          code="CV020120230,CV020120231,CV020120211,CV020120232,CV020120229,CV020120228,1/2,CV020120299,CV020120217" reg='{"required":"true"}'/>
        </td>
    </tr>
    <tr>
        <th><label class="required">婚姻状况：</label></th>
        <td>
            <ehr:dic-list dicmeta="GBT226122003" name="mhmBasicsInfo.marriage" value="${managementDto.mhmBasicsInfo.marriage}" code="10,20,30,40,90,91" reg='{"required":"true"}'/>
        </td>
    </tr>
    <tr>
        <th><label class="required">现住地详址：</label></th>
        <td colspan="3">
            <div class="${'2' eq managementDto.mhmBasicsInfo.floatPopulation?'hide':'' }" id="pa-address-select">
                
                <ehr:dic-town-street-village  villageId="pavillage_address" streetId="pastreet_address" 
														 townId="patown_address" villageName="mhmBasicsInfo.paGroup" streetName="mhmBasicsInfo.pastreet"
														 townName="mhmBasicsInfo.patownShip" villageValue="${managementDto.mhmBasicsInfo.paGroup}" streetValue="${managementDto.mhmBasicsInfo.pastreet}"
														 townValue="${managementDto.mhmBasicsInfo.patownShip}" callback="baseArchives.displayPaAddress" width="180px;"  reg='{"dependOn":"mhmBasicsInfo.floatPopulation","dependValue":"1","required":"true"}'/>
                <%-- <ehr:dic-town-village villageId="pavillage_address" townId="patown_address"
                                      villageName="mhmBasicsInfo.pastreet" townName="mhmBasicsInfo.patownShip"
                                      villageValue="${managementDto.mhmBasicsInfo.pastreet}"
                                      townValue="${managementDto.mhmBasicsInfo.patownShip}" width="180px;"
                                      reg='{"dependOn":"mhmBasicsInfo.floatPopulation","dependValue":"1","required":"true"}'/> --%>
            </div>
            <label id="tempPaValue">
                <ehr:dic code="${managementDto.mhmBasicsInfo.patownShip}" dicmeta="FS990001"/><ehr:dic code="${managementDto.mhmBasicsInfo.pastreet}" dicmeta="FS990001"/>
            </label>
            <input type="text" id="pahouseNumber" name="mhmBasicsInfo.pahouseNumber" value="${managementDto.mhmBasicsInfo.pahouseNumber}"
                   reg='{"required":"true","maxlength":"70"}' style="width: 180px;"/>
            <span id="spanPaNumber">(门牌号)</span>
        </td>
    </tr>
    <tr>
        <th><label class="required">既往主要症状：</label></th>
        <td colspan="3">
            <ehr:dic-checkbox name="mhmPathHistory.symptom" dicmeta="MH00009" value="${managementDto.mhmPathHistory.symptom}" reg='{"required":"true"}'/>
        </td>
    </tr>
    <tr>
        <th>患者对家庭社会的影响：</th>
        <td colspan="3">
            轻度滋事次数：<input type="text" style="width: 80px; text-align: center" name="mhmOtherInfo.mildAffray" value="${managementDto.mhmOtherInfo.mildAffray}" reg='{"digits":"true","min":"0","max":"99"}'>
            <br>肇事次数：<input type="text" style="width: 80px; text-align: center" name="mhmOtherInfo.causeTrouble" value="${managementDto.mhmOtherInfo.causeTrouble}" reg='{"digits":"true","min":"0","max":"99"}'>
            <br>肇祸次数：<input type="text" style="width: 80px; text-align: center" name="mhmOtherInfo.accident" value="${managementDto.mhmOtherInfo.accident}" reg='{"digits":"true","min":"0","max":"99"}'>
            <br>自伤次数：<input type="text" style="width: 80px; text-align: center" name="mhmOtherInfo.autolesion" value="${managementDto.mhmOtherInfo.autolesion}" reg='{"digits":"true","min":"0","max":"99"}'>
            <br>自杀未遂次数：<input type="text" style="width: 80px; text-align: center" name="mhmOtherInfo.attemptedSuicide" value="${managementDto.mhmOtherInfo.attemptedSuicide}" reg='{"digits":"true","min":"0","max":"99"}'>
            <br>其他需要说明的特殊情况：<input type="text" style="width: 180px; text-align: center" name="mhmOtherInfo.otherSpecial" value="${managementDto.mhmOtherInfo.otherSpecial}" reg='{"maxlength":"100"}'>
        </td>
    </tr>
    <tr>
        <th>既往治疗情况：</th>
        <td colspan="3">
            门诊：<input type="text" style="width: 200px;" name="mhmPathHistory.previousTreatment" value="${managementDto.mhmPathHistory.previousTreatment}" reg='{"maxlength":"200"}'>
            <br>
            住院： 曾住精神专科医院/综合医院精神专科<input type="text" style="width: 80px;text-align: center" name="mhmPathHistory.previousInhospitalTimes" value="${managementDto.mhmPathHistory.previousInhospitalTimes}" reg='{"digits":"true","min":"0","max":"99"}'>次
        </td>
    </tr>
    <tr>
        <th>病案号：</th>
        <td colspan="3">
            住院：<input type="text" style="width: 200px;" name="mhmInhospital.inpatientRecordNo" value="${managementDto.mhmInhospital.inpatientRecordNo}" reg='{"maxlength":"18"}'>
            <br>
            门诊：<input type="text" style="width: 200px;" name="mhmInhospital.outpatientRecordNo" value="${managementDto.mhmInhospital.outpatientRecordNo}" reg='{"maxlength":"18"}'>
        </td>
    </tr>
    <tr>
        <th>住院诊断：</th>
        <td colspan="2">
            <label class="required">诊断：</label>
            <%--<ehr:dic-list name="mhmInhospital.inpatientDiagnosis" dicmeta="MH00052" value="${managementDto.mhmInhospital.inpatientDiagnosis}" reg='{"required":"true"}'/>--%>
            <input type="text" name="mhmInhospital.inpatientDiagnosis" value="${managementDto.mhmInhospital.inpatientDiagnosis}">
            <%--<input type="text" id="inpatientDiagnosisId" name="mhmInhospital.inpatientDiagnosis" value="${managementDto.mhmInhospital.inpatientDiagnosis}" reg='{"required":"true"}'/>--%>
            <br>
            日期：
            <tag:dateInput name="mhmInhospital.inhospitalDate" style="width: 100px;" reg='{"regex":"date"}' date="${managementDto.mhmInhospital.inhospitalDate}" onlypast="true"/>
        </td>
    </tr>
</table>

<table class="posttable">
    <colgroup>
        <col style="min-width: 50px; width: 23%;" />
        <col style="min-width: 80px; width: 27%;" />
        <col style="min-width: 50px; width: 23%;" />
        <col style="min-width: 80px; width: 27%;" />
    </colgroup>
    <tr>
        <td colspan="3">
            <b style="margin: 15px;">住院用药：</b>
            <a href="javascript:void(0)" id="1" onclick="outInfo.popupMedication(this,'add','inMedicationTable')"><b class="xinz" style="padding-left: 20px;">添加</b></a>
        </td>
    </tr>
    <tr>
        <td colspan="4">
            <div class="repeattable">
                <div class="toolbarsublist">
                    <%--<a href="javascript:void(0)"><b class="xinz">添加</b></a></b>--%>
                </div>
                <table id="inMedicationTable">
                    <thead>
                    <tr>
                        <th class="centerth" style="width: 100px;">药物名称</th>
                        <th class="centerth" style="width: 60px;">早</th>
                        <th class="centerth" style="width: 60px;">中</th>
                        <th class="centerth" style="width: 60px;">晚</th>
                        <th class="centerth" style="width: 60px;">单位</th>
                        <th class="centerth" >特殊情况</th>
                        <th class="centerth" style="width: 70px;">操作</th>
                    </tr>
                    </thead>
                    <c:forEach var="inMedication" items="${managementDto.inMedicationRecords}">
                        <tr>
                            <td field="drugName"><ehr:tip>${inMedication.drugName}</ehr:tip></td>
                            <td field="drugMorning"><ehr:tip>${inMedication.drugMorning}</ehr:tip></td>
                            <td field="drugNoon"><ehr:tip>${inMedication.drugNoon}</ehr:tip></td>
                            <td field="drugEvening"><ehr:tip>${inMedication.drugEvening}</ehr:tip></td>
                            <td field="unit"><ehr:tip>${inMedication.unit}</ehr:tip></td>
                            <td field="drugSpecial"><ehr:tip>${inMedication.drugSpecial}</ehr:tip></td>
                            <td field="drugId" style="display: none">${inMedication.drugId}</td>
                            <td class="btnsublist">
                                <a href="javascript:void(0)" onclick="outInfo.popupMedication(this,'edit','inMedicationTable')">修改</a>&nbsp;
                                <a href="javascript:void(0)" onclick="mhmCommon.removeTr(this)">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </td>
    </tr>
    <tr>
        <th>住院康复措施：</th>
        <td colspan="3">
            <ehr:dic-checkbox dicmeta="MH00011" name="mhmInhospital.recoveryMeasure" value="${managementDto.mhmInhospital.recoveryMeasure}" onchange="toggleOtherCK('mhmInhospital.recoveryMeasure', 'spanRecoveryMeasureId', 99)"/>
            <input id="spanRecoveryMeasureId" type="text" style="width: 150px;display: none;" name="mhmInhospital.recoveryMeasureOther" value="${managementDto.mhmInhospital.recoveryMeasureOther}" reg='{"maxlength":"100"}'/>
        </td>
    </tr>
    <tr>
        <th><label class="required">住院疗效：</label></th>
        <td colspan="3">
            <ehr:dic-radio name="mhmInhospital.inpatientEffect" dicmeta="MH00013" value="${managementDto.mhmInhospital.inpatientEffect}" reg='{"required":"true"}'/>
        </td>
    </tr>
    <tr>
        <th>本次住院患者有否获得经费补助：</th>
        <td>
            <ehr:dic-list name="mhmInhospital.economicGrantDept" dicmeta="MH00010" value="${managementDto.mhmInhospital.economicGrantDept}"/>
        </td>
        <th><label class="required">既往关锁情况</label></th>
        <td><ehr:dic-list name="mhmPathHistory.lockState" dicmeta="MH00007" value="${managementDto.mhmPathHistory.lockState}" reg='{"required":"true"}'/></td>
    </tr>

    <tr>
        <td colspan="3">
            <b style="margin: 15px;">下一步治疗方案及康复建议：</b>
            <a href="javascript:void(0)" id="addEfcList" onclick="outInfo.popupMedication(this,'add', 'nextMedicationTable')"><b class="xinz" style="padding-left: 20px;">添加</b></a>
        </td>
    </tr>
    <tr>
        <td colspan="4">
            <div class="repeattable">
                <div class="toolbarsublist">
                </div>
                <table id="nextMedicationTable">
                    <thead>
                    <tr>
                        <th class="centerth" style="width: 100px;">药物名称</th>
                        <th class="centerth" style="width: 60px;">早</th>
                        <th class="centerth" style="width: 60px;">中</th>
                        <th class="centerth" style="width: 60px;">晚</th>
                        <th class="centerth" style="width: 60px;">单位</th>
                        <th class="centerth" >特殊情况</th>
                        <th class="centerth" style="width: 70px;">操作</th>
                    </tr>
                    </thead>
                    <c:forEach var="nextMedication" items="${managementDto.nextMedicationRecords}">
                        <tr>
                            <td field="drugName"><ehr:tip>${nextMedication.drugName}</ehr:tip></td>
                            <td field="drugMorning"><ehr:tip>${nextMedication.drugMorning}</ehr:tip></td>
                            <td field="drugNoon"><ehr:tip>${nextMedication.drugNoon}</ehr:tip></td>
                            <td field="drugEvening"><ehr:tip>${nextMedication.drugEvening}</ehr:tip></td>
                            <td field="unit"><ehr:tip>${nextMedication.unit}</ehr:tip></td>
                            <td field="drugSpecial"><ehr:tip>${nextMedication.drugSpecial}</ehr:tip></td>
                            <td field="drugId" style="display: none">${nextMedication.drugId}</td>
                            <td class="btnsublist">
                                <a href="javascript:void(0)" onclick="outInfo.popupMedication(this,'edit','nextMedicationTable')">修改</a>&nbsp;
                                <a href="javascript:void(0)" onclick="mhmCommon.removeTr(this)">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </td>
    </tr>
    <tr>
        <th>康复措施：</th>
        <td colspan="3">
            <ehr:dic-checkbox dicmeta="MH00011" name="mhmInhospital.nextRecoveryMeasure" value="${managementDto.mhmInhospital.nextRecoveryMeasure}" onchange="toggleOtherCK('mhmInhospital.nextRecoveryMeasure', 'spanNextRecoveryMeasureId', 99)"/>
            <input id="spanNextRecoveryMeasureId" type="text" style="width: 150px;display: none;" name="mhmInhospital.nextRecoveryMeasureOther" value="${managementDto.mhmInhospital.nextRecoveryMeasureOther}" reg='{"maxlength":"100"}'/>
        </td>
    </tr>
</table>

<table class="posttable">
    <colgroup>
        <col style="min-width: 50px; width: 20%;"/>
        <col style="min-width: 80px; width: 29%;"/>
        <col style="min-width: 50px; width: 23%;"/>
        <col style="min-width: 80px; width: 28%;"/>
    </colgroup>
    <tr>
        <th><label class="required">经治医生：</label></th>
        <td>
            <%--<ehr:user userCode="${managementDto.mhmInhospital.treatingPhysician}"/>--%>
            <input type="text" name="mhmInhospital.treatingPhysician" value="${managementDto.mhmInhospital.treatingPhysician}" reg='{"required":"true","maxlength":"50"}'/>
        </td>
        <th><label class="required">联系电话：</label></th>
        <td><input type="text" name="mhmInhospital.contactNumber" value="${managementDto.mhmInhospital.contactNumber}" reg='{"required":"true","regex":"phone","maxlength":20}'/></td>
    </tr>
    <tr>
        <th><label class="required">住院医院：</label></th>
        <td>
            <input type="text" name="mhmInhospital.inpatientOrganCode" value="${managementDto.mhmInhospital.inpatientOrganCode}" reg='{"required":"true","maxlength":"50"}'/>
        </td>
        <th><label class="required">出院日期：</label></th>
        <td><tag:dateInput pattern="yyyy/MM/dd" onlypast="true" name="mhmInhospital.dischargeDate" date="${managementDto.mhmInhospital.dischargeDate}" reg='{"required":"true"}'/></td>
    </tr>
</table>

</form>
</fieldset>
</div>
