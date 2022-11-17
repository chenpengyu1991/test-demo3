<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/morbilli.js" type="text/javascript"></script>

<c:if test="${isPrint != 1}">
    <jsp:include page="caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
<div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
<i class="popno">
    麻疹个案调查表<br/>
    <span>（乙类传染病）</span>
</i>
<input type="hidden" name="idmId" value="${idmId}"/>

<div class="postdiv">
<fieldset>
    <legend>一、报告卡信息</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 28%"/>
            <col style="width: 22%"/>
            <col style="width: 28%"/>
            <col style="width: 22%"/>
        </colgroup>
        <tr>
            <th>1.1 传染病报告卡卡片编号：</th>
            <td colspan="3">
                ${caseDto.caseInformation.caseNo}
                <input type="hidden" name="caseInformation.caseNo" value="${caseDto.caseInformation.caseNo}" reg='{"maxlength":"14"}'/>
            </td>
        </tr>
        <tr>
            <th><label class="required">1.2 患者姓名</label>：</th>
            <td colspan="3">
                <input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}"
                       reg='{"maxlength":"100","required":"true"}' style="width: 150px;"/>
                （患儿家长姓名：<input type="text" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}"
                               reg='{"maxlength":"50"}' style="width: 150px;"/>）
            </td>
        </tr>
        <tr>
            <th>1.3 身份证号：</th>
            <td><input id="idCard" type="text" name="generalCondition.idcard" value="${caseDto.generalCondition.idcard}" reg='{"idCard":"true"}'
                       placeholder="输入身份证获取个人信息"/></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <th><label class="required">1.4 性别</label>：</th>
            <td><ehr:dic-radio dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${caseDto.generalCondition.gender}"
                               reg='{"required":"true"}'/></td>
        </tr>
        <tr>
            <th><label class="required">1.5 出生日期</label>：</th>
            <td colspan="3">
                <tag:dateInput name="generalCondition.birthday" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.generalCondition.birthday}"
                               reg='{"required":"true"}' style="width:100px;"/>
                <label class="required">（如出生日期不详，实足年龄</label>
                <input type="text" id="age" name="generalCondition.age" style="width: 60px; text-align: center" value="${caseDto.generalCondition.age}"
                        reg='{"maxlength":"6"}'/>
                年龄单位：<ehr:dic-radio name="generalCondition.ageUnit" dicmeta="IDM00003" value="${caseDto.generalCondition.ageUnit}"/>）
            </td>
        </tr>
        <tr>
            <th>1.6 患者工作单位：</th>
            <td colspan="3">
                <input type="text" name="generalCondition.unitName" value="${caseDto.generalCondition.unitName}"
                       reg='{"maxlength":"70"}' style="width: 200px;"/>
                联系电话：<input type="text" name="generalCondition.phoneNumber" value="${caseDto.generalCondition.phoneNumber}"
                            reg='{"regex":"phone"}' style="width: 150px;"/>
            </td>
        </tr>
        <tr>
            <th><label class="required">1.7 病人属于</label>：</th>
            <td colspan="3">
                <ehr:dic-radio name="generalCondition.patientAttribute" dicmeta="CV0201104" value="${caseDto.generalCondition.patientAttribute}"
                               reg='{"required":"true"}' onchange="morbilliCase.toggerAddress();"/>
            </td>
        </tr>
        <tr>
            <th><label class="required">1.8 家庭现住址(详填)</label>：</th>
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
            <th><label class="required">1.9 患者职业</label>：</th>
            <td colspan="3">
                <ehr:dic-list id="occupationId" dicmeta="GBT6565" name="generalCondition.occupation" width="180px;" value="${caseDto.generalCondition.occupation}"
                              code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,
                              CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120299,CV020120217"
                              reg='{"required":"true"}'/>
            </td>
        </tr>
        <tr>
            <th><label class="required">1.10 病例分类</label>：</th>
            <td colspan="3">
                <ehr:dic-radio dicmeta="IDM00040" name="otherCondition.dengueCaseType" code="1,3,2"  value="${caseDto.otherCondition.dengueCaseType}"/>
            </td>
        </tr>
        <tr>
            <th><label class="required">1.11 发病日期</label>：</th>
            <td>
                <tag:dateInput id="pathogenesisDateID" name="attackCondition.pathogenesisDate" pattern="yyyy/MM/dd" onlypast="true"  date="${caseDto.attackCondition.pathogenesisDate}"
                               reg='{"required":"true"}' style="width:100px;"/>
            </td>
        </tr>
        <tr>
            <th><label class="required">1.12 诊断日期</label>：</th>
            <td>
                <tag:dateInput id="confirmationDate" name="attackCondition.confirmationDate" pattern="yyyy/MM/dd HH" date="${caseDto.attackCondition.confirmationDate}"
                               onlypast="true" reg='{"required":"true","compare":["pathogenesisDateID","ge","诊断日期不能小于发病日期"]}' style="width:100px;"/>时
                <input type="hidden" id="confirmationHour" name="attackCondition.confirmationHour">
            </td>
        </tr>
        <tr>
            <th>1.13 死亡日期：</th>
            <td>
                <tag:dateInput name="attackCondition.dieDt" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.dieDt}" onlypast="true" style="width:100px;"
                               reg='{"compare":["pathogenesisDateID","ge","死亡日期不能小于发病日期"]}'/>
            </td>
        </tr>
        <tr>
            <th>1.14 疾病名称：法定传染病：</th>
            <td><input type="text" name="caseInformation.reportDiseases" value="${caseDto.caseInformation.reportDiseases}"
                       reg='{"maxlength":"200"}'/></td>
        </tr>
        <tr>
            <th>1.15 填卡医生：</th>
            <td>
                <%--<input type="text" name="caseInformation.surveyName" value="${caseDto.caseInformation.surveyName}" reg='{"maxlength":"50"}'/>--%>
                <ehr:user userCode="${caseDto.caseInformation.reportPerson}"/>
                    <%--${caseDto.caseInformation.reportPerson}--%>
                <input type="hidden" name="caseInformation.reportPerson" value="${caseDto.caseInformation.reportPerson}"/>
            </td>
        </tr>
        <tr>
            <th>1.16 报告单位：</th>
            <td>
                <%--<input type="text" name="caseInformation.reportOrg" value="${caseDto.caseInformation.reportOrg}" reg='{"maxlength":"200"}'/>--%>
                <ehr:org code="${caseDto.caseInformation.reportOrg}"/>
                <input type="hidden" name="caseInformation.reportOrg" value="${caseDto.caseInformation.reportOrg}"/>
            </td>
        </tr>
        <tr>
            <th>1.17 接触者有无相同症状：</th>
            <td colspan="3">
                <ehr:dic-radio dicmeta="PH00002" name="attackCondition.contactsSymptoms" code="1,2" value="${caseDto.attackCondition.contactsSymptoms}"/>
            </td>
        </tr>
        <tr>
            <th>1.18 备注：</th>
            <td><input type="text" name="attackCondition.remarks" value="${caseDto.attackCondition.remarks}" reg='{"maxlength":"100"}'/></td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>二、流行病学调查信息</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 28%"/>
            <col style="width: 22%"/>
            <col style="width: 8%"/>
            <col style="width: 42%"/>
        </colgroup>
        <tr>
            <th><label class="required">2.1 报告日期</label>：</th>
            <td>
                <fmt:formatDate value='${caseDto.caseInformation.reportDate}' pattern="yyyy/MM/dd" />
                <tag:dateInput id="reportDt" name="caseInformation.reportDate" pattern="yyyy/MM/dd" date="${caseDto.caseInformation.reportDate}"
                               reg='{"required":"true"}' onlypast="true" style="display: none" /></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <th><label class="required">2.2 调查日期</label>：</th>
            <td>
                <tag:dateInput nullToToday="true" name="caseInformation.modifySurveyDate" onlypast="true"
                               pattern="yyyy/MM/dd" date="${caseDto.caseInformation.modifySurveyDate}"
                               reg='{"required":"true","compare":["reportDt","ge","调查日期不能晚于报告日期"]}'/>
        </tr>
        <tr>
            <th><label class="required">2.3 病例户籍</label>：</th>
            <td colspan="3">
                <ehr:dic-radio dicmeta="IDM00561" code="1,2,3,4,99" name="generalCondition.hrPlace"
                               value="${caseDto.generalCondition.hrPlace}"
                               onchange="toggleOther('generalCondition.hrPlace','otherHrPlace',99);"/>
                <span id="otherHrPlace">
                <input type="text" name="generalCondition.otherHrPlace" style="width: 150px" value="${caseDto.generalCondition.otherHrPlace}" reg='{"maxlength":"100"}'/>
            </span>
            </td>
        </tr>
        <tr id="hrvillage_address">
            <th><label class="required">户籍所在地</label>：</th>
            <td colspan="3">
                <input type="text" name="generalCondition.hrhouseNumber" id="hrhouseNumber" value="${caseDto.generalCondition.hrhouseNumber}"
                       style="width: 300px;" reg='{"maxlength":"100"}'>
               <%-- <ehr:dic-town-village villageId="hrvillage_address" townId="hrtown_address" villageName="generalCondition.hrstreet" townName="generalCondition.hrtownShip"
                                      villageValue="${caseDto.generalCondition.hrstreet}" townValue="${caseDto.generalCondition.hrtownShip}" width="180px;"/>
                <input type="text" name="generalCondition.hrhouseNumber" id="hrhouseNumber" value="${caseDto.generalCondition.hrhouseNumber}"
                       style="width: 300px;" reg='{"maxlength":"50"}'>
                <span id="spanHrNumber">(门牌号)</span>--%>
            </td>
        </tr>
        <tr>
            <th><label class="required">户籍地相对现住地址类型</label>：</th>
            <td colspan="3">
                <ehr:dic-radio dicmeta="CV0201104" name="generalCondition.relativeResidence" code="1,2,3,4,5,7" value="${caseDto.generalCondition.relativeResidence}"/>
            </td>
        </tr>
        <tr>
            <th><label class="required">如非本县区，发病时在现住址居住时间</label>：</th>
            <td colspan="3">
                <ehr:dic-radio dicmeta="IDM00629" name="caseInformation.liveTime"  value="${caseDto.caseInformation.liveTime}"/>
                <br>（注：如为外籍或港澳台病例，则选择在中国大陆居住时间）
            </td>
        </tr>
       
        <tr>
            <th>2.4是否在集体单位（如学校、幼儿园、工厂等）：</th>
            <td colspan="3">
                <ehr:dic-radio dicmeta="PH00001" name="epidemiologicalSurvey.collectiveUnit" code="1,2" value="${caseDto.epidemiologicalSurvey.collectiveUnit}"
                        onchange="toggleOther('epidemiologicalSurvey.collectiveUnit','collectiveUnitName',1);"/>
                <span id="collectiveUnitName" style="display: none">
                    &nbsp;&nbsp;&nbsp;如是，所在集体单位具体名称
                    <input type="text" name="epidemiologicalSurvey.collectiveUnitName" value="${caseDto.epidemiologicalSurvey.collectiveUnitName}"
                           reg='{"maxlength":"100"}' style="width: 200px;">
                </span>
            </td>
        </tr>
        <tr>
            <th><label class="required">2.5 发热</label>：</th>
            <td colspan="3"><ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.fever" code="1,2,4" value="${caseDto.clinicalManifestations.fever}"
                   onchange="toggleOther('clinicalManifestations.fever','hotDate',1);" reg='{"required":"true"}'/>
                <span id="hotDate" style="display: none">
                    &nbsp;&nbsp;&nbsp;如是，发热日期：
                    <tag:dateInput name="clinicalManifestations.hotDate" pattern="yyyy/MM/dd" onlypast="true"
                            date="${caseDto.clinicalManifestations.hotDate}" style="width:100px;"/>
                </span>
            </td>
        </tr>
        <tr>
            <th><label class="required">2.6 出疹</label>：</th>
            <td colspan="3">
                <ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="clinicalManifestations.rash" value="${caseDto.clinicalManifestations.rash}"
                        onchange="toggleOther('clinicalManifestations.rash','rashDate',1);" reg='{"required":"true"}'/>
                <span id="rashDate" style="display: none">
                    &nbsp;&nbsp;&nbsp;如是，出疹日期：
                    <tag:dateInput name="clinicalManifestations.rashDate" pattern="yyyy/MM/dd" date="${caseDto.clinicalManifestations.rashDate}"
                                   style="width:100px;" onlypast="true"/>
                </span>
            </td>
        </tr>
        <tr>
            <th><label class="required">2.7 其他临床症状</label>：</th>
            <td colspan="3">
        
                <%--<br>其他症状（鼻塞、流涕、喷嚏等）--%>
                <%--<ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.catarrh" code="1,2,4" value="${caseDto.clinicalManifestations.catarrh}"--%>
                               <%--reg='{"required":"true"}'/>--%>
                <%--<br>结膜炎--%>
                <%--<ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="clinicalManifestations.conjunctivitis" value="${caseDto.clinicalManifestations.conjunctivitis}"--%>
                               <%--reg='{"required":"true"}'/>--%>
                <%--<br>麻疹粘膜斑（柯氏斑）--%>
                <%--<ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.koplikSpots" code="1,2,4" value="${caseDto.clinicalManifestations.koplikSpots}"--%>
                               <%--reg='{"required":"true"}'/>--%>
                <%--<br>淋巴节肿大--%>
                <%--<ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.lymphadenectasis" code="1,2,4" value="${caseDto.clinicalManifestations.lymphadenectasis}"--%>
                               <%--reg='{"required":"true"}'/>--%>
                <%--<br>关节疼痛--%>
                <%--<ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.limbAche" code="1,2,4" value="${caseDto.clinicalManifestations.limbAche}"--%>
                               <%--reg='{"required":"true"}'/>--%>
            </td>
        </tr>
        <tr>
            <th>咳嗽：</th>
            <td colspan="3">

                <ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.cough" code="1,2,4" value="${caseDto.clinicalManifestations.cough}"
                                  reg='{"required":"true"}'/>
            </td>
        </tr>
         <tr>
            <th>卡他性鼻炎：</th>
            <td colspan="3">

                <ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.coryza" code="1,2,4" value="${caseDto.clinicalManifestations.coryza}"
                               reg='{"required":"true"}'/>
            </td>
        </tr>
        <tr>
            <th>结膜炎：</th>
            <td colspan="3">

                <ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="clinicalManifestations.conjunctivitis" value="${caseDto.clinicalManifestations.conjunctivitis}"
                               reg='{"required":"true"}'/>
            </td>
        </tr>
       <%--  <tr>
            <th>麻疹粘膜斑（柯氏斑）：</th>
            <td colspan="3">

                <ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.koplikSpots" code="1,2,4" value="${caseDto.clinicalManifestations.koplikSpots}"
                               reg='{"required":"true"}'/>
            </td>
        </tr> --%>
       
        <tr>
            <th>口腔黏膜斑：</th>
            <td colspan="3">

                <ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.oralMucosalPatches" code="1,2,4" value="${caseDto.clinicalManifestations.oralMucosalPatches}"
                               reg='{"required":"true"}'/>
            </td>
        </tr>
        <tr>
            <th>淋巴节肿大：</th>
            <td colspan="3">

                <ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.lymphadenectasis" code="1,2,4" value="${caseDto.clinicalManifestations.lymphadenectasis}"
                               reg='{"required":"true"}'/>
            </td>
        </tr>
        <tr>
            <th>关节炎/关节疼痛：</th>
            <td colspan="3">

                <ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.limbAche" code="1,2,4" value="${caseDto.clinicalManifestations.limbAche}"
                               reg='{"required":"true"}'/>
            </td>
        </tr>
        <tr>
            <th><label class="required">2.8、是否有其他并发症</label>：</th>
            <td><ehr:dic-radio name="clinicalManifestations.isComplications" dicmeta="PH00001" code="1,2,4"
                               value="${caseDto.clinicalManifestations.isComplications}"
                               onchange="toggleOther('clinicalManifestations.isComplications','complications',1);"/></td>
        </tr>
        <tr id="complications">
            <th><label class="required">具体为</label>：</th>
            <td colspan="3">
                <ehr:dic-checkbox name="clinicalManifestations.complications" dicmeta="IDM00580"
                               value="${caseDto.clinicalManifestations.complications}"
                               onchange="toggleOtherCK('clinicalManifestations.complications','fxOtherMZ',99);"/>
                <span id="fxOtherMZ">
                    <input type="text" id="clinicalManifestations.fxOther" name="clinicalManifestations.fxOther"
                           value="${caseDto.clinicalManifestations.fxOther}" style="width: 100px;">
                </span>
                <%--<input type="text" id="clinicalManifestations.complications" name="clinicalManifestations.complications" value="${caseDto.clinicalManifestations.complications}"
                    style="width: 150px;">--%>
            </td>
        </tr>
		<tr>
            <th><label>2.9 含麻疹/风疹成分疫苗接种史（须详细填写）</label></th>
            <td colspan="3">
            </td>
        </tr>
         <tr>
            <th><label class="required">a 含麻疹成分疫苗接种剂次</label>：</th>
            <td colspan="3">
                <ehr:dic-radio name="epidemiologicalSurvey.measlesvaccineIngredientsNum" dicmeta="IDM00630" value="${caseDto.epidemiologicalSurvey.measlesvaccineIngredientsNum}"
                             reg='{"required":"true"}'/>
            </td>
        </tr>
        <tr>
            <th><label>i 如接种过，第1剂接种日期：</label></th>
            <td><tag:dateInput id="mvInoculateDtID" name="epidemiologicalSurvey.mvInoculateDt" pattern="yyyy/MM/dd" date="${caseDto.epidemiologicalSurvey.mvInoculateDt}" onlypast="true"
                                   style="width:120px;" /></td>
       		<th><label>疫苗种类：</label></th>
            <td><ehr:dic-radio name="epidemiologicalSurvey.mvOne" dicmeta="IDM00562"  value="${caseDto.epidemiologicalSurvey.mvOne}"/></td>
        </tr>
        <tr>
            <th><label>第2剂接种日期：</label></th>
            <td><tag:dateInput id="mvSecInoculateDt" name="epidemiologicalSurvey.mvSecInoculateDt" pattern="yyyy/MM/dd" date="${caseDto.epidemiologicalSurvey.mvSecInoculateDt}" onlypast="true"
                                   style="width:120px;" /></td>
        	<th><label>疫苗种类：</label></th>
            <td><ehr:dic-radio name="epidemiologicalSurvey.mvLast" dicmeta="IDM00562" value="${caseDto.epidemiologicalSurvey.mvLast}"/>
            </td>
        </tr>
        <tr>
            <th><label>最后一剂接种日期：</label></th>
            <td ><tag:dateInput id="mvLastInoculateDtID" name="epidemiologicalSurvey.mvLastInoculateDt" pattern="yyyy/MM/dd" date="${caseDto.epidemiologicalSurvey.mvLastInoculateDt}" onlypast="true"
                                   style="width:120px;" />
      		<th><label>疫苗种类：</label></th>
            <td><ehr:dic-radio name="epidemiologicalSurvey.mvSec" dicmeta="IDM00562" value="${caseDto.epidemiologicalSurvey.mvSec}"/>
            </td>
        </tr>
         <tr>
            <th><label>ii 免疫史信息来源：</label></th>
            <td><ehr:dic-radio name="epidemiologicalSurvey.mvImmunizationHistorySource" dicmeta="IDM00069" code="1,2,3,4" value="${caseDto.epidemiologicalSurvey.mvImmunizationHistorySource}"/>
                     </td>
             <th></th>
             <td></td>
         </tr>
        
         <tr>
            <th><label>iii 如为<15岁儿童且未按照免疫程序完成应接种剂次数，其主要原因是</label></th>
			<td colspan="3"><input type="text" id="epidemiologicalSurvey.mvReason" name="epidemiologicalSurvey.mvReason" value="${caseDto.epidemiologicalSurvey.mvReason}"
                           style="width: 250px;">（注：8～17月龄应已接种1剂，≥18月龄应已接种2剂）</td>
        </tr>
       
         <tr>
            <th><label class="required">b 含风疹成分疫苗接种剂次</label>：</th>
            <td colspan="3">
                 <ehr:dic-radio name="epidemiologicalSurvey.rubellavaccineIngredientsNum" dicmeta="IDM00023" value="${caseDto.epidemiologicalSurvey.rubellavaccineIngredientsNum}"
                              reg='{"required":"true"}'/>
            </td>
        </tr>
        <tr>
            <th><label>i 如接种过，第1剂接种日期：</label></th>
            <td><tag:dateInput id="rvInoculateDtID" name="epidemiologicalSurvey.rvInoculateDt" pattern="yyyy/MM/dd" date="${caseDto.epidemiologicalSurvey.rvInoculateDt}" onlypast="true"
                                   style="width:120px;" /></td>
       		<th><label>疫苗种类：</label></th>
            <td><ehr:dic-radio name="epidemiologicalSurvey.fzOne" dicmeta="IDM00562" value="${caseDto.epidemiologicalSurvey.fzOne}"/>
            </td>
        </tr>
        <tr>
            <th><label>第2剂接种日期：</label></th>
            <td><tag:dateInput id="rvLastInoculateDtID" name="epidemiologicalSurvey.rvLastInoculateDt" pattern="yyyy/MM/dd" date="${caseDto.epidemiologicalSurvey.rvLastInoculateDt}" onlypast="true"
                                   style="width:120px;" /></td>
        	<th><label>疫苗种类：</label></th>
            <td><ehr:dic-radio name="epidemiologicalSurvey.fzLast" dicmeta="IDM00562" value="${caseDto.epidemiologicalSurvey.fzLast}"/>
             </td>
        </tr>
         <tr>
            <th><label>ii免疫史信息来源：</label></th>
            <td>
                <ehr:dic-radio name="epidemiologicalSurvey.rvImmunizationHistorySource" dicmeta="IDM00069" code="1,2,3,4" value="${caseDto.epidemiologicalSurvey.rvImmunizationHistorySource}"/>
                    </td>
             <th></th>
             <td></td>
         </tr>
       <%--  <tr>
            <th><label class="required">a 含麻疹成分疫苗接种剂次</label>：</th>
            <td colspan="3">
                <ehr:dic-radio name="epidemiologicalSurvey.measlesvaccineIngredientsNum" dicmeta="IDM00630" value="${caseDto.epidemiologicalSurvey.measlesvaccineIngredientsNum}"
                            onchange="morbilliCase.toggleMeaslesvaccine('epidemiologicalSurvey.measlesvaccineIngredientsNum')" reg='{"required":"true"}'/>
                <span id="mvImmunizationHistory" style="display: none">
                    <br>免疫史来源
                    <ehr:dic-radio name="epidemiologicalSurvey.mvImmunizationHistorySource" dicmeta="IDM00069" code="1,2,3,4" value="${caseDto.epidemiologicalSurvey.mvImmunizationHistorySource}"/>
                     <br>如如为<15岁儿童且未按照免疫程序完成应接种剂次数（注：8～17月龄应已接种1剂，≥18月龄应已接种2剂），其主要原因是：
                    <input type="text" id="epidemiologicalSurvey.mvReason" name="epidemiologicalSurvey.mvReason" value="${caseDto.epidemiologicalSurvey.mvReason}"
                           style="width: 250px;">
                    <br>如接种过，a.首剂次接种时间：
                    <tag:dateInput id="mvInoculateDtID" name="epidemiologicalSurvey.mvInoculateDt" pattern="yyyy/MM/dd" date="${caseDto.epidemiologicalSurvey.mvInoculateDt}" onlypast="true"
                                   style="width:120px;" reg='{"required":"true","compare":["mvLastInoculateDtID","le","首剂次接种时间不能大于最后一剂接种时间"]}'/>
                    <br>疫苗种类：<ehr:dic-radio name="epidemiologicalSurvey.mvOne" dicmeta="IDM00562"  value="${caseDto.epidemiologicalSurvey.mvOne}"/>
                </span>
                <span id="mvLastInoculateDt" style="display: none">
                    <br>b.最后一剂接种时间：
                    <tag:dateInput id="mvLastInoculateDtID" name="epidemiologicalSurvey.mvLastInoculateDt" pattern="yyyy/MM/dd" date="${caseDto.epidemiologicalSurvey.mvLastInoculateDt}" onlypast="true"
                                   style="width:120px;" reg='{"required":"true","compare":["mvInoculateDtID","ge","最后一剂接种时间不能小于首剂次接种时间"]}'/>
                 <br>疫苗种类：<ehr:dic-radio name="epidemiologicalSurvey.mvLast" dicmeta="IDM00562" value="${caseDto.epidemiologicalSurvey.mvLast}"/>

                </span>
            </td>
        </tr>
        <tr>
            <th><label class="required">b 含风疹成分疫苗接种剂次</label>：</th>
            <td colspan="3">
                <ehr:dic-radio name="epidemiologicalSurvey.rubellavaccineIngredientsNum" dicmeta="IDM00023" value="${caseDto.epidemiologicalSurvey.rubellavaccineIngredientsNum}"
                               onchange="morbilliCase.toggleRubellavaccine('epidemiologicalSurvey.rubellavaccineIngredientsNum')" reg='{"required":"true"}'/>
                <span id="rvImmunizationHistory" style="display: none">
                    <br>免疫史来源
                    <ehr:dic-radio name="epidemiologicalSurvey.rvImmunizationHistorySource" dicmeta="IDM00069" code="1,2,3,4" value="${caseDto.epidemiologicalSurvey.rvImmunizationHistorySource}"/>
                    <br>如接种过，a.首剂次接种时间：
                    <tag:dateInput id="rvInoculateDtID" name="epidemiologicalSurvey.rvInoculateDt" pattern="yyyy/MM/dd" date="${caseDto.epidemiologicalSurvey.rvInoculateDt}" onlypast="true"
                                   style="width:120px;" reg='{"required":"true","compare":["rvLastInoculateDtID","le","首剂次接种时间不能大于最后一剂接种时间"]}'/>
                <br>疫苗种类：<ehr:dic-radio name="epidemiologicalSurvey.fzOne" dicmeta="IDM00562" value="${caseDto.epidemiologicalSurvey.fzOne}"/>
                </span>
                <span id="rvLastInoculateDt" style="display: none">
                    <br>b.最后一剂接种时间：
                    <tag:dateInput id="rvLastInoculateDtID" name="epidemiologicalSurvey.rvLastInoculateDt" pattern="yyyy/MM/dd" date="${caseDto.epidemiologicalSurvey.rvLastInoculateDt}" onlypast="true"
                                   style="width:120px;" reg='{"required":"true","compare":["rvInoculateDtID","ge","最后一剂接种时间不能小于首剂次接种时间"]}'/>
                <br>疫苗种类：<ehr:dic-radio name="epidemiologicalSurvey.fzLast" dicmeta="IDM00562" value="${caseDto.epidemiologicalSurvey.fzLast}"/>
                </span>
            </td>
        </tr> --%>
        <tr>
            <th><label class="required">2.10发病前7-21天是否去过医院</label>：</th>
            <td colspan="3">
                <ehr:dic-radio name="epidemiologicalSurvey.dysenteryBeenHospital" dicmeta="PH00001" code="1,2,4" value="${caseDto.epidemiologicalSurvey.dysenteryBeenHospital}"
                        onchange="toggleOther('epidemiologicalSurvey.dysenteryBeenHospital','dysenteryBeenHospitalName',1);" reg='{"required":"true"}'/>
                <span id="dysenteryBeenHospitalName" style="display: none">
                   <br>若是，医院名称
                    <input type="text" name="epidemiologicalSurvey.dysenteryBeenHospitalName" value="${caseDto.epidemiologicalSurvey.dysenteryBeenHospitalName}"
                           reg='{"maxlength":"100"}' style="width: 200px;"/>
                     <br>日期
                      <tag:dateInput name="epidemiologicalSurvey.dysenteryBeenHospitalDate" pattern="yyyy/MM/dd" onlypast="true"
                                     date="${caseDto.epidemiologicalSurvey.dysenteryBeenHospitalDate}" style="width:100px;"/>
                </span>
            </td>
        </tr>
       <%--  <tr>
            <th><label class="required">2.11发病前7-21天是否接触其他发热出疹性病人</label>：</th>
            <td><ehr:dic-radio name="epidemiologicalSurvey.similarPatients" dicmeta="PH00001" code="1,2,4" value="${caseDto.epidemiologicalSurvey.similarPatients}"
                               reg='{"required":"true"}'/></td>
        </tr> --%>
        <%-- <tr>
            <th><label class="required">2.11 是否与实验室诊断病例有流行病学联系</label>：</th>
            <td colspan="3">
                <ehr:dic-radio name="epidemiologicalSurvey.labPatientsContact" dicmeta="PH00001" code="1,2,4" value="${caseDto.epidemiologicalSurvey.labPatientsContact}"
                               onchange="toggleOther('epidemiologicalSurvey.labPatientsContact','labConfirmedCase',1);
                        toggleOther('epidemiologicalSurvey.labConfirmedCase','mrOther',99);" reg='{"required":"true"}'/>
                <span id="labConfirmedCase" style="display: none">
                    &nbsp;&nbsp;&nbsp;<br>若是，实验室诊断病例为
                    <ehr:dic-radio name="epidemiologicalSurvey.labConfirmedCase" dicmeta="IDM00070" value="${caseDto.epidemiologicalSurvey.labConfirmedCase}"
                                   onchange="toggleOther('epidemiologicalSurvey.labConfirmedCase','mrOther',99);"/>

                    <span id="mrOther" style="display: none">
                        <input type="text" name="epidemiologicalSurvey.mrOther" value="${caseDto.epidemiologicalSurvey.mrOther}"
                               reg='{"maxlength":"200"}' style="width: 150px;"/>
                    </span>
                </span>
            </td>
        </tr> --%>
        <tr>
            <th><label class="required">2.11是否与实验室确诊麻疹病例有流行病学关联</label>：</th>
            <td colspan="3">
                <ehr:dic-radio name="epidemiologicalSurvey.mvLabPatCon" dicmeta="PH00001" code="1,2,4" value="${caseDto.epidemiologicalSurvey.mvLabPatCon}"
                              reg='{"required":"true"}'/>
               
            </td>
        </tr>
        <tr>
            <th><label class="required">是否与实验室确诊风疹病例有流行病学关联</label>：</th>
            <td colspan="3">
                <ehr:dic-radio name="epidemiologicalSurvey.fzLabPatCon" dicmeta="PH00001" code="1,2,4" value="${caseDto.epidemiologicalSurvey.fzLabPatCon}"
                               reg='{"required":"true"}'/>
               
            </td>
        </tr>
        <tr>
            <th><label class="required">2.12 是否为已怀孕妇女</label>：</th>
            <td><ehr:dic-radio name="epidemiologicalSurvey.isPregant" dicmeta="PH00001" code="1,2,4" value="${caseDto.epidemiologicalSurvey.isPregant}"
                               reg='{"required":"true"}'/>
            <br>怀孕周数为： <input type="text" name="epidemiologicalSurvey.pregantWeek" value="${caseDto.epidemiologicalSurvey.pregantWeek}"
                          reg='{"maxlength":"3"}' style="width: 100px;"/>
            </td>
        </tr>
        <tr>
            <th><label class="required">2.13 是否为一起麻疹或风疹暴发疫情的病例</label>：</th>
            <td>
                <ehr:dic-radio name="epidemiologicalSurvey.measlesOutbreakCase" dicmeta="PH00001" code="1,2" value="${caseDto.epidemiologicalSurvey.measlesOutbreakCase}"
                               reg='{"required":"true"}'/>
            </td>
        </tr>
        <tr>
            <th><label class="required">如是，是否为一起新的暴发</label>：</th>
            <td colspan="3">
                <ehr:dic-radio name="epidemiologicalSurvey.newOutbreak" dicmeta="PH00001" code="1,2" value="${caseDto.epidemiologicalSurvey.newOutbreak}"
                       />               
            </td>
        </tr>
        <tr>
            <th><label>暴发编码</label>：</th>
            <td colspan="3"> 
                <input type="text" id="outbreakNoVal" name="epidemiologicalSurvey.outbreakNo" value="${caseDto.epidemiologicalSurvey.outbreakNo}"
                       reg='{"length":"15"}' style="width: 150px;">
            </td>
        </tr>
        
        <tr>
	        <th><label class="required">2.14  可能感染地</label>：</th>
	            <td colspan="3">
	        <ehr:dic-radio dicmeta="IDM00561" name="epidemiologicalSurvey.local"
	                       value="${caseDto.epidemiologicalSurvey.local}"
	        onchange="toggleOther('epidemiologicalSurvey.local','otherLocal',99);"    />
	            <span id="otherLocal">
	                <input type="text" name="epidemiologicalSurvey.otherLocal" value="${caseDto.epidemiologicalSurvey.otherLocal}" style="width: 150px" reg='{"maxlength":"100"}'/>
	            </span>
	            </td>
        </tr>
        <tr>
            <th><label>如果为中国大陆，详细地址为</label>：</th>
            <td>
            <input type="text" name="epidemiologicalSurvey.derailLocal" value="${caseDto.epidemiologicalSurvey.derailLocal}" reg='{"maxlength":"500"}'/>
            </td>
        </tr>
        <tr>
            <th><label>详细感染地来源（尽可能具体到地区及单位）</label>：</th>
           <td> <input type="text" name="epidemiologicalSurvey.detailSource" value="${caseDto.epidemiologicalSurvey.detailSource}" reg='{"maxlength":"500"}'/>
           </td>
        </tr>
        <tr>
            <th><label>详述判断依据（尤其阐明出疹前7～21日详细活动情况）</label>：</th>
            <td><input type="text" name="epidemiologicalSurvey.basis" value="${caseDto.epidemiologicalSurvey.basis}" reg='{"maxlength":"500"}'/>
            </td>
        </tr>
        <tr>
            <th><label class="required">2.15 个案调查备注</label>：</th>
            <td><input type="text" name="epidemiologicalSurvey.examComment" value="${caseDto.epidemiologicalSurvey.examComment}" reg='{"maxlength":"500"}'/>
            </td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>三、标本采集情况</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 28%"/>
            <col style="width: 22%"/>
            <col style="width: 28%"/>
            <col style="width: 22%"/>
        </colgroup>
        <tr>
            <th><label class="required">3.1 是否采集第一份血清标本</label>：</th>
            <td colspan="3">
                <ehr:dic-radio name="labExamine.serumSpecimenF" dicmeta="PH00001" code="1,2" value="${caseDto.labExamine.serumSpecimenF}"
                        onchange="toggleOther('labExamine.serumSpecimenF','serumSpecimenDtF',1);
                        toggleOther('labExamine.serumSpecimenF','serumSpecimenS',1);
                        toggleOther('labExamine.serumSpecimenS','serumSpecimenDtS',1);" reg='{"required":"true"}'/>
                （否，跳到第3.3项）
                <span id="serumSpecimenDtF" style="display: none">
                    &nbsp;&nbsp;&nbsp;采集日期：
                    <tag:dateInput name="labExamine.serumSpecimenDtF" pattern="yyyy/MM/dd" date="${caseDto.labExamine.serumSpecimenDtF}"
                                   onlypast="true" style="width:150px;"/>
                </span>
            </td>
            <td></td>
            <td></td>
        </tr>
        <tr id="serumSpecimenS" style="display: none">
            <th><label class="required">3.2 是否采集第二份血清标本</label>：</th>
            <td colspan="3">
                <ehr:dic-radio name="labExamine.serumSpecimenS" dicmeta="PH00001" code="1,2" value="${caseDto.labExamine.serumSpecimenS}"
                        onchange="toggleOther('labExamine.serumSpecimenS','serumSpecimenDtS',1);"
                        reg='{"dependOn":"labExamine.serumSpecimenF","dependValue":"1","required":"true"}'/>
                <span id="serumSpecimenDtS" style="display: none">
                    &nbsp;&nbsp;&nbsp;采集日期：
                    <tag:dateInput name="labExamine.serumSpecimenDtS" pattern="yyyy/MM/dd" date="${caseDto.labExamine.serumSpecimenDtS}"
                                   onlypast="true" style="width:150px;"/>
                </span>
            </td>
        </tr>
        <tr>
            <th><label class="required">3.3 是否采集病原学检测标本</label>：</th>
            <td colspan="3">
                <ehr:dic-radio name="labExamine.etiologySpecimens" dicmeta="PH00001" code="1,2" value="${caseDto.labExamine.etiologySpecimens}"
                        onchange="toggleOther('labExamine.etiologySpecimens','etiologySpecimensPart',1);
                        toggleOther('labExamine.nasopharyngealSwab','nasopharyngealSwabDate',1);
                        toggleOther('labExamine.urineAliquot','urineAliquotDate',1);
                        toggleOther('labExamine.otherSpecimen','otherSpecimenDate',1);
                        " reg='{"required":"true"}'/>（否，跳到第4.1项）
                <span id="etiologySpecimensPart">
                    <br>a. 鼻咽拭子：<ehr:dic-radio name="labExamine.nasopharyngealSwab" dicmeta="PH00001" code="1,2" value="${caseDto.labExamine.nasopharyngealSwab}"
                                              onchange="toggleOther('labExamine.nasopharyngealSwab','nasopharyngealSwabDate',1);"/>
                    <span id="nasopharyngealSwabDate" style="display: none">
                        &nbsp;&nbsp;&nbsp;采集日期：
                        <tag:dateInput name="labExamine.nasopharyngealSwabDate" pattern="yyyy/MM/dd" date="${caseDto.labExamine.nasopharyngealSwabDate}"
                                       onlypast="true"  style="width:150px;"/>
                    </span>
                    <br>b. 尿标本：<ehr:dic-radio name="labExamine.urineAliquot" dicmeta="PH00001" code="1,2" value="${caseDto.labExamine.urineAliquot}"
                                              onchange="toggleOther('labExamine.urineAliquot','urineAliquotDate',1);"/>
                    <span id="urineAliquotDate" style="display: none">
                        &nbsp;&nbsp;&nbsp;采集日期：
                        <tag:dateInput name="labExamine.urineAliquotDate" pattern="yyyy/MM/dd" date="${caseDto.labExamine.urineAliquotDate}"
                                       onlypast="true" style="width:150px;"/>
                    </span>
                    <br>c. 其他标本：<ehr:dic-radio name="labExamine.otherSpecimen" dicmeta="PH00001" code="1,2" value="${caseDto.labExamine.otherSpecimen}"
                                               onchange="toggleOther('labExamine.otherSpecimen','otherSpecimenDate',1);"/>
                    <span id="otherSpecimenDate" style="display: none">
                        &nbsp;&nbsp;&nbsp;
                        标本名称：
                        <input type="text" name="labExamine.sampleName" value="${caseDto.labExamine.sampleName}"
                               reg='{"maxlength":"100"}' style="width: 150px;">
                        &nbsp;&nbsp;&nbsp;
                        采集日期：
                        <tag:dateInput name="labExamine.otherSpecimenDate" pattern="yyyy/MM/dd" date="${caseDto.labExamine.otherSpecimenDate}"
                                       onlypast="true" style="width:150px;"/>
                    </span>
                </span>
            </td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>四、实验室检测结果反馈信息</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 28%"/>
            <col style="width: 22%"/>
            <col style="width: 28%"/>
            <col style="width: 22%"/>
        </colgroup>
        <tr>
            <th><label class="required">4.1 第一份血标本收到日期</label>：</th>
            <td>
                <tag:dateInput name="labExamine.firstSerumRecentDate" pattern="yyyy/MM/dd" date="${caseDto.labExamine.firstSerumRecentDate}"
                               onlypast="true" style="width:150px;"/>
            </td>
        </tr>
        <tr>
            <th><label class="required">第一份血标本检测单位</label>：</th>
            <td>
                <input type="text" name="labExamine.firstSerumRecentOrg" value="${caseDto.labExamine.firstSerumRecentOrg}"
                       reg='{"maxlength":"100"}' style="width: 150px;">
            </td>
        </tr>
        <tr>
            <th><label class="required">第一份血标本麻疹IgM抗体检测结果</label>：</th>
            <td>
                <ehr:dic-radio dicmeta="PH00004" name="labExamine.firstSerumMeaslesIgm" code="1,2,6" value="${caseDto.labExamine.firstSerumMeaslesIgm}"
                               reg='{"required":"true"}'/>
            </td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <th><label class="required">风疹IgM抗体检测结果</label>：</th>
            <td colspan="3">
                <ehr:dic-radio dicmeta="PH00004" name="labExamine.firstSerumRubellaIgm" code="1,2,6" value="${caseDto.labExamine.firstSerumRubellaIgm}"
                               reg='{"required":"true"}'/>
            </td>
        </tr>
        <tr>
            <th><label class="required">第一份血标本报告日期</label>：</th>
            <td>
                <tag:dateInput name="labExamine.firstSerumResultDate" pattern="yyyy/MM/dd" date="${caseDto.labExamine.firstSerumResultDate}"
                               onlypast="true" style="width:150px;"/>
            </td>
        </tr>
        <tr>
            <th><label class="required">4.2 第二份血标本收到日期</label>：</th>
            <td>
                <tag:dateInput name="labExamine.seconedSerumRecentDate" pattern="yyyy/MM/dd" date="${caseDto.labExamine.seconedSerumRecentDate}"
                               onlypast="true" style="width:150px;"/>
            </td>
        </tr>
        <tr>
            <th><label class="required">第二份血标本检测单位</label>：</th>
            <td>
                <input type="text" name="labExamine.seconedSerumRecentOrg" value="${caseDto.labExamine.seconedSerumRecentOrg}"
                       reg='{"maxlength":"100"}' style="width: 150px;">
            </td>
        </tr>
        <tr>
            <th><label class="required">第二份血标本麻疹IgM抗体检测结果</label>：</th>
            <td colspan="3">
                <ehr:dic-radio dicmeta="PH00004" name="labExamine.secondSerumMeaslesIgm" code="1,2,6" value="${caseDto.labExamine.secondSerumMeaslesIgm}"
                               reg='{"required":"true"}'/>
            </td>
        </tr>
        <tr>
            <th><label class="required">风疹IgM抗体检测结果</label>：</th>
            <td colspan="3">
                <ehr:dic-radio dicmeta="PH00004" name="labExamine.secondSerumRubellaIgm" code="1,2,6" value="${caseDto.labExamine.secondSerumRubellaIgm}"
                               reg='{"required":"true"}'/>
            </td>
        </tr>
        <tr>
            <th><label class="required">第二份血标本报告日期</label>：</th>
            <td>
                <tag:dateInput name="labExamine.seconedSerumResultDate" pattern="yyyy/MM/dd" date="${caseDto.labExamine.seconedSerumResultDate}"
                               onlypast="true" style="width:150px;"/>
            </td>
        </tr>
        <tr>
            <th>4.3 是否采集急性期和恢复期血进行麻疹IgG抗体检测：</th>
            <td colspan="3">
                <ehr:dic-radio name="labExamine.igg" dicmeta="PH00001" code="1,2" value="${caseDto.labExamine.igg}"/>
            </td>
        </tr>
        <tr>
            <th>如是，第二份血麻疹IgG抗体是否≥4倍升高或阳转：</th>
            <td colspan="3">
                <ehr:dic-radio name="labExamine.mzIgg" dicmeta="IDM00563" value="${caseDto.labExamine.mzIgg}"/>
            </td>
        </tr>
        <tr>
            <th>第二份血风疹IgG抗体是否≥4倍升高或阳转：</th>
            <td colspan="3">
                <ehr:dic-radio name="labExamine.fzIgg" dicmeta="IDM00563"  value="${caseDto.labExamine.fzIgg}"/>
            </td>
        </tr>
        <tr>
            <th>检测单位：</th>
            <td colspan="3">
                <input type="text" name="labExamine.iggOrg" value="${caseDto.labExamine.iggOrg}"
                       reg='{"maxlength":"100"}' style="width: 150px;">
            </td>
        </tr>
        <tr>
            <th>检测结果报告日期*：</th>
            <td colspan="3">
                <tag:dateInput name="labExamine.iggResultDate" pattern="yyyy/MM/dd" date="${caseDto.labExamine.iggResultDate}"
                               onlypast="true" style="width:150px;"/>
            </td>
        </tr>
        <%--<tr>
            <th>4.3 麻疹病毒鉴定结果：</th>
            <td colspan="3">
                <ehr:dic-radio dicmeta="PH00004" name="labExamine.morbillivirusResult" code="1,2,6" value="${caseDto.labExamine.morbillivirusResult}"/>
                &nbsp;&nbsp;&nbsp;&nbsp;基因型：<input type="text" name="labExamine.morbillivirusGenotype" value="${caseDto.labExamine.morbillivirusGenotype}"
                           reg='{"maxlength":"100"}' style="width: 200px;"/>
            </td>
        </tr>
        <tr>
            <th>风疹病毒鉴定结果：</th>
            <td colspan="3">
                <ehr:dic-radio dicmeta="PH00004" name="labExamine.rubellavirusResult" code="1,2,6" value="${caseDto.labExamine.rubellavirusResult}"/>
                &nbsp;&nbsp;&nbsp;&nbsp;基因型：<input type="text" name="labExamine.rubellavirusGenotype" value="${caseDto.labExamine.rubellavirusGenotype}"
                           reg='{"maxlength":"100"}' style="width: 200px;"/>
            </td>
        </tr>--%>
    </table>
</fieldset>
    <fieldset>
        <legend>五、核酸检测结果</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 28%"/>
                <col style="width: 22%"/>
                <col style="width: 28%"/>
                <col style="width: 22%"/>
            </colgroup>
            <tr style="display: none">
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr >
                <th>是否开展核酸检测*：</th>
                <td colspan="3">
                    <ehr:dic-radio name="labExamine.nucleicAcidDetection" dicmeta="PH00001" code="1,2" value="${caseDto.labExamine.nucleicAcidDetection}"/>
                </td>
            </tr>
            <tr >
                <th>病原学标本收到日期*：</th>
                <td colspan="3">
                    <tag:dateInput name="labExamine.etiologyRecentDate" pattern="yyyy/MM/dd" date="${caseDto.labExamine.etiologyRecentDate}"
                                   onlypast="true" style="width:150px;"/></td>
            </tr>
            <tr >
                <th>标本类型（可多选）*：</th>
                <td colspan="3">
                    <ehr:dic-checkbox name="labExamine.sampleKind" dicmeta="IDM00564"  value="${caseDto.labExamine.sampleKind}"/>
                </td>
            </tr>
            <tr >
                <th>检测方法（可多选）*：</th>
                <td colspan="3">
                    <ehr:dic-checkbox name="labExamine.sampleTreatment" dicmeta="IDM00565" value="${caseDto.labExamine.sampleTreatment}"/>
                </td>
            </tr>
            <tr >
                <th>麻疹核酸检测结果为*：</th>
                <td colspan="3">
                    <ehr:dic-radio name="labExamine.mzNucleicResult" dicmeta="IDM00560" value="${caseDto.labExamine.mzNucleicResult}"/>
                </td>
            </tr>
            <tr >
                <th>人RNaseP基因检测结果为：</th>
                <td colspan="3">
                    <ehr:dic-radio name="labExamine.mzRnasepResult" dicmeta="IDM00560"  value="${caseDto.labExamine.mzRnasepResult}"/>
                </td>
            </tr>
            <tr >
                <th>风疹核酸检测结果为*：</th>
                <td colspan="3">
                    <ehr:dic-radio name="labExamine.fzNucleicResult" dicmeta="IDM00560"  value="${caseDto.labExamine.fzNucleicResult}"/>
                </td>
            </tr>
            <tr >
                <th>人RNaseP基因检测结果为：</th>
                <td colspan="3">
                    <ehr:dic-radio name="labExamine.fzRnasepResult" dicmeta="IDM00560" value="${caseDto.labExamine.fzRnasepResult}"/>
                </td>
            </tr>
            <tr >
                <th>检测单位：</th>
                <td colspan="3">
                    <input type="text" name="labExamine.nucleicAcidDetectionOrg" value="${caseDto.labExamine.nucleicAcidDetectionOrg}"
                           reg='{"maxlength":"100"}' style="width: 150px;"></td>
            </tr>
            <tr >
                <th>检测结果报告日期：</th>
                <td colspan="3">
                    <tag:dateInput name="labExamine.nucleicResultDate" pattern="yyyy/MM/dd" date="${caseDto.labExamine.nucleicResultDate}"
                                   onlypast="true" style="width:150px;"/></td>
            </tr>

        </table>
    </fieldset>
    <fieldset>
        <legend>六、病毒分离结果</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 28%"/>
                <col style="width: 22%"/>
                <col style="width: 28%"/>
                <col style="width: 22%"/>
            </colgroup>
            <tr style="display: none">
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr >
                <th>6.1 病原学标本收到日期*：</th>
                <td colspan="3">
                    <tag:dateInput name="labExamine.bEtiologyRecentDate" pattern="yyyy/MM/dd" date="${caseDto.labExamine.bEtiologyRecentDate}"
                                   onlypast="true" style="width:150px;"/></td>
            </tr>
            <tr >
                <th>6.2标本类型（可多选）*：</th>
                <td colspan="3">
                    <ehr:dic-checkbox name="labExamine.bSampleKind" dicmeta="IDM00564"  value="${caseDto.labExamine.bSampleKind}"/>
                </td>
            </tr>
            <tr >
                <th>6.3 病毒分离所用细胞*：</th>
                <td colspan="3">
                    <ehr:dic-radio name="labExamine.cellsVirusIsolation" dicmeta="IDM00566" value="${caseDto.labExamine.cellsVirusIsolation}"/>
                </td>
            </tr>
            <tr >
                <th>6.4分离鉴定结果*：</th>
                <td colspan="3">
                    <ehr:dic-radio name="labExamine.seprateResult" dicmeta="IDM00567" value="${caseDto.labExamine.seprateResult}"/>
                </td>
            </tr>
            <tr >
                <th>检测单位：</th>
                <td colspan="3">
                    <input type="text" name="labExamine.bNucleicAcidDetectionOrg" value="${caseDto.labExamine.bNucleicAcidDetectionOrg}"
                           reg='{"maxlength":"100"}' style="width: 150px;"></td>
            </tr>
            <tr >
                <th>检测结果报告日期：</th>
                <td colspan="3">
                    <tag:dateInput name="labExamine.bNucleicResultDate" pattern="yyyy/MM/dd" date="${caseDto.labExamine.bNucleicResultDate}"
                                   onlypast="true" style="width:150px;"/></td>
            </tr>

        </table>
    </fieldset>
    <fieldset>
        <legend>七、基因型鉴定</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 28%"/>
                <col style="width: 22%"/>
                <col style="width: 28%"/>
                <col style="width: 22%"/>
            </colgroup>
            <tr style="display: none">
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr >
                <th>7.1 基因型鉴定标本收到日期：</th>
                <td colspan="3">
                    <tag:dateInput name="labExamine.dnaEtiologyRecentDate" pattern="yyyy/MM/dd" date="${caseDto.labExamine.dnaEtiologyRecentDate}"
                                   onlypast="true" style="width:150px;"/></td>
            </tr>
            <tr >
                <th>7.2标本类型（可多选）*：</th>
                <td colspan="3">
                    <ehr:dic-checkbox name="labExamine.dnaSampleKind" dicmeta="IDM00568"  value="${caseDto.labExamine.dnaSampleKind}"/>
                </td>
            </tr>
            <tr >
                <th>7.3麻疹病毒基因型鉴定结果*：</th>
                <td >
                    <ehr:dic-checkbox name="labExamine.mzDnaResult" dicmeta="IDM00560"  value="${caseDto.labExamine.mzDnaResult}"/>
                </td>
            </tr>
            <tr >
                <th>如为阳性，基因型:</th>
                <td >
                    <input type="text" name="labExamine.mzDnaKind" value="${caseDto.labExamine.mzDnaKind}"
                           reg='{"maxlength":"100"}' style="width: 150px;"></td>
            </tr>
            <tr >
                <th>毒株命名:</th>
                <td >
                    <input type="text" name="labExamine.mzDnaName" value="${caseDto.labExamine.mzDnaName}"
                           reg='{"maxlength":"100"}' style="width: 150px;"></td>
            </tr>
            <tr >
                <th>风疹病毒基因型鉴定结果*</th>
                <td >
                    <ehr:dic-checkbox name="labExamine.fzDnaResult" dicmeta="IDM00560"  value="${caseDto.labExamine.fzDnaResult}"/>
                </td>
            </tr>
            <tr >
                <th>如为阳性，基因型:</th>
                <td >
                    <input type="text" name="labExamine.fzDnaKind" value="${caseDto.labExamine.fzDnaKind}"
                           reg='{"maxlength":"100"}' style="width: 150px;"></td>
            </tr>
            <tr >
                <th>毒株命名:</th>
                <td >
                    <input type="text" name="labExamine.fzDnaName" value="${caseDto.labExamine.fzDnaName}"
                           reg='{"maxlength":"100"}' style="width: 150px;"></td>
            </tr>
            <tr >
                <th>检测单位*：</th>
                <td >
                    <input type="text" name="labExamine.dnaNucleicAcidDetectionOrg" value="${caseDto.labExamine.dnaNucleicAcidDetectionOrg}"
                           reg='{"maxlength":"100"}' style="width: 150px;"></td>
            </tr>
            <tr >
                <th>检测结果报告日期*：</th>
                <td >
                    <tag:dateInput name="labExamine.dnaNucleicResultDate" pattern="yyyy/MM/dd" date="${caseDto.labExamine.dnaNucleicResultDate}"
                                   onlypast="true" style="width:150px;"/>
                </td>
            </tr>


        </table>
    </fieldset>
    <fieldset>
        <legend>八、病例分类：</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 28%"/>
                <col style="width: 22%"/>
                <col style="width: 28%"/>
                <col style="width: 22%"/>
            </colgroup>
            <tr style="display: none">
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr >
                <th>8.1 监测病例分类：</th>
                <td colspan="3">
                    <ehr:dic-checkbox name="otherCondition.mzIllKind" dicmeta="IDM00569"  value="${caseDto.otherCondition.mzIllKind}"/>
                </td>
            </tr>
            <tr >
                <th>8.2 是否为与接种疫苗相关的发热出疹：</th>
                <td colspan="3">
                    <ehr:dic-radio name="otherCondition.mzHot" dicmeta="PH00001" code="1,2"  value="${caseDto.otherCondition.mzHot}"/>
                </td>
            </tr>
            <tr >
                <th>8.3 麻疹病例感染来源*：</th>
                <td colspan="3">
                    <ehr:dic-checkbox name="otherCondition.mzSource" dicmeta="IDM00570"  value="${caseDto.otherCondition.mzSource}"/>
                </td>
            </tr>
            <tr >
                <th>判定依据*：</th>
                <td colspan="3">
                    <input type="text" name="otherCondition.mzBasis" value="${caseDto.otherCondition.mzBasis}"
                           reg='{"maxlength":"100"}' style="width: 150px;"></td>
            </tr>
        </table>
    </fieldset>
<fieldset>
    <table class="posttable">
        <colgroup>
            <col style="width: 28%"/>
            <col style="width: 22%"/>
            <col style="width: 28%"/>
            <col style="width: 22%"/>
        </colgroup>
        <tr>
            <th>调查人员签字：</th>
            <td>
                <ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
                <input type="hidden" name="caseInformation.modifyRespondents" value="${caseDto.caseInformation.modifyRespondents}"/>
            </td>
            <th>调查单位：</th>
            <td>
                <ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/>
                <input type="hidden" name="caseInformation.modifySurveyOrg" value="${caseDto.caseInformation.modifySurveyOrg}"/>
            </td>
        </tr>
    </table>
</fieldset>
</div>
</div>
</form>
