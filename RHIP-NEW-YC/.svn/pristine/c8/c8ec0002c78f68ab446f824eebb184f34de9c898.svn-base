<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKJFZX" value="<%=RoleType.JKJFZX.getValue()%>"/>
<c:set var="ZJSB" value="<%=RoleType.ZJSB.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/mhm/management/baseArchives/baseArchives.js" type="text/javascript"></script>
<div class="toolbar" style="margin-top: -8px;">
    <div class="toolbar" style="background: none">
        <!-- <a href="javascript:mhmCommon.returnSearch(managementSearch.search)" id="cancelContact"><b class="fanhui">返回</b></a> -->
        <a href="javascript:mhmCommon.returnSearch(managementSearch.search)" id="cancelContact" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
        <c:if test="${logoff != 1}">
            <%--<ehr:authorize ifAnyGranted="${JKJFZX}">
                &lt;%&ndash;<a href="javascript:baseArchives.save()"><b class="xiug">修改</b></a>&ndash;%&gt;
                <!-- <a href="javascript:baseArchives.save()"><b class="baocun">保存</b></a> -->
            </ehr:authorize>--%>
            <ehr:authorize ifNotGranted="${ADMIN}">
                <a href="javascript:baseArchives.save()"  ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
            </ehr:authorize>
        </c:if>
    </div>
</div>
<form id="baseForm">
<div class="postcontent divFixed105">
<input type="hidden" name="statusId" value="${managementDto.statusId}"/>
<input type="hidden" id="eventIdB" name="eventId" value="${managementDto.eventId}"/>
<%--是否管理不能修改，永远是已管理，所以永远是1--%>
<input type="hidden" id="bringIntoFlag" name="mhmOtherInfo.bringIntoFlag" value="1">

<input type="hidden" name="mhmBasicsInfo.id"  value="${managementDto.mhmBasicsInfo.id}">
<input type="hidden" name="mhmBasicsInfo.age"  value="${managementDto.mhmBasicsInfo.age}">
<input type="hidden" name="mhmOtherInfo.id"  value="${managementDto.mhmOtherInfo.id}">
<input type="hidden" name="mhmPathHistory.id"  value="${managementDto.mhmPathHistory.id}">
<input type="hidden" name="mhmDiagnosis.id"  value="${managementDto.mhmDiagnosis.id}">
<%--<input type="hidden" name="mhmDiagnosis.diagnosisContent" value="${managementDto.mhmDiagnosis.diagnosisContent}">--%>
<input type="hidden" id="logoffId" name="logoff" value="${managementDto.logoff}"/>
<div class="postdiv">
<fieldset class="layui-elem-field">
<legend>病人基本信息</legend>
<table class="posttable">
<colgroup>
    <col style="width: 23%" />
    <col style="width: 27%" />
    <col style="width: 23%" />
    <col style="width: 27%" />
</colgroup>
<%--<tr>--%>
    <%--<th><label class="required">现住地国标码：</label></th>--%>
    <%--<td>--%>
        <%--<input type="text" name="generalCondition.name" value="${malariaDto.generalCondition.name}"--%>
               <%--reg='{"maxlength":"50"}'/>--%>
    <%--</td>--%>
    <%--<th><label class="required">户籍地国标码：</label></th>--%>
    <%--<td>--%>
        <%--<input type="text" name="generalCondition.idcard" value="${malariaDto.generalCondition.idcard}"--%>
               <%--reg='{"idCard":"idCard"}'/>--%>
    <%--</td>--%>
<%--</tr>--%>
<tr>
    <th>身份证号：</th>
    <td  colspan="3">
        <input id="idCard" type="text" name="mhmBasicsInfo.idcard" value="${managementDto.mhmBasicsInfo.idcard}"
               placeholder="输入身份证获取个人信息" reg='{"idCard":"idCard"}' style="width: 180px;"/>(如有身份证，请先输入病人身份证信息)
    </td>
</tr>
<tr>
    <th>姓名：</th>
    <td><input id="baseName" type="text" name="mhmBasicsInfo.name" value="${managementDto.mhmBasicsInfo.name}" reg='{"maxlength":"50"}'></td>
    <th>曾用名：</th>
    <td>
        <input type="text" name="mhmBasicsInfo.formerName" value="${managementDto.mhmBasicsInfo.formerName}" reg='{"maxlength":"50"}'>
    </td>
</tr>
<tr>
    <th>性别：</th>
    <td><ehr:dic-radio name="mhmBasicsInfo.gender" dicmeta="GBT226112003" value="${managementDto.mhmBasicsInfo.gender}" code="1,2" />
    </td>
    <th>民族：</th>
    <td>
        <ehr:dic-list id="nationId" name="mhmBasicsInfo.nation" dicmeta="GBT3304" value="${managementDto.mhmBasicsInfo.nation}"/>
    </td>
</tr>
<tr> 
    <th>常住类型：</th>
    <td><ehr:dic-radio name="mhmBasicsInfo.floatPopulation" dicmeta="FS10005"
                       value="${managementDto.mhmBasicsInfo.floatPopulation}" onchange="baseArchives.toggleLocalAddress('mhmBasicsInfo.floatPopulation', 'localPart', 1);"/>
    </td>
    <th>户别：</th>
    <td><ehr:dic-radio name="mhmBasicsInfo.household" dicmeta="IDM00011" value="${managementDto.mhmBasicsInfo.household}" />
    </td>
    
</tr>
<tr>
<tr>
    <th>现住地详址：</th>
    <td colspan="3">
    <ehr:dic-town-street-village villageId="pavillage_address" streetId="pastreet_address" 
														 townId="patown_address" villageName="mhmBasicsInfo.paGroup" streetName="mhmBasicsInfo.pastreet"
														 townName="mhmBasicsInfo.patownShip" villageValue="${managementDto.mhmBasicsInfo.paGroup}" streetValue="${managementDto.mhmBasicsInfo.pastreet}"
														 townValue="${managementDto.mhmBasicsInfo.patownShip}" callback="baseArchives.displayPaAddress" width="180px;"/>
        <%-- <ehr:dic-town-village villageId="pavillage_address" townId="patown_address" villageName="mhmBasicsInfo.pastreet" townName="mhmBasicsInfo.patownShip"
                              villageValue="${managementDto.mhmBasicsInfo.pastreet}" townValue="${managementDto.mhmBasicsInfo.patownShip}" width="180px;"/> --%>
        <br><label id="tempPaValue">
        <ehr:dic code="${managementDto.mhmBasicsInfo.patownShip}" dicmeta="FS990001"/><ehr:dic code="${managementDto.mhmBasicsInfo.pastreet}" dicmeta="FS990001"/><ehr:dic code="${managementDto.mhmBasicsInfo.paGroup}" dicmeta="FS990001"/>
        </label>
        <input type="text" id="pahouseNumber" name="mhmBasicsInfo.pahouseNumber" value="${managementDto.mhmBasicsInfo.pahouseNumber}"
               reg='{"maxlength":"50"}'  style="width: 150px;">
        <span id="spanPaNumber">(门牌号)</span>
    </td>
</tr>
<tr>
    <th>户籍地详址：</th>
    <td colspan="3">
        <span id="localPart">
            <%-- <ehr:dic-town-village villageId="hrvillage_address" townId="hrtown_address" villageName="mhmBasicsInfo.hrstreet" townName="mhmBasicsInfo.hrtownShip"
                                  villageValue="${managementDto.mhmBasicsInfo.hrstreet}" townValue="${managementDto.mhmBasicsInfo.hrtownShip}" width="180px;"/> --%>
            <ehr:dic-town-street-village
								villageId="homeVillage_address" townId="homeTown_address" streetId="homeStreet_address"
								villageName="mhmBasicsInfo.hrGroup" streetName="mhmBasicsInfo.hrstreet"
								townName="mhmBasicsInfo.hrtownShip" streetValue="${managementDto.mhmBasicsInfo.hrstreet}"
								villageValue="${managementDto.mhmBasicsInfo.hrGroup}" 
								townValue="${managementDto.mhmBasicsInfo.hrtownShip}" callback="baseArchives.displayHrAddress" width="180px;" />
        
            <br><label id="tempHrValue">
            <ehr:dic code="${managementDto.mhmBasicsInfo.hrtownShip}" dicmeta="FS990001"/><ehr:dic code="${managementDto.mhmBasicsInfo.hrstreet}" dicmeta="FS990001"/><ehr:dic code="${managementDto.mhmBasicsInfo.hrGroup}" dicmeta="FS990001"/>
            </label>
        </span>
        <input type="text" name="mhmBasicsInfo.hrhouseNumber" id="hrhouseNumber" value="${managementDto.mhmBasicsInfo.hrhouseNumber}"
               style="width: 150px;" reg='{"maxlength":"50"}'>
        <span id="spanHrNumber">(门牌号)</span>
    </td>
</tr>
<tr>
    <th>现住地派出所：</th>
    <td>
        <input type="text" name="mhmBasicsInfo.paPoliceStation" value="${managementDto.mhmBasicsInfo.paPoliceStation}" reg='{"maxlength":"100"}'>
    </td>
    <th>户籍地派出所：</th>
    <td>
        <input type="text" name="mhmBasicsInfo.hrPoliceStation" value="${managementDto.mhmBasicsInfo.hrPoliceStation}" reg='{"maxlength":"100"}'>
    </td>
</tr>
<tr>
    <th>文化程度：</th>
    <td>
        <ehr:dic-list id="educationId" name="mhmBasicsInfo.education" dicmeta="GBT46582006" code="IDM01,IDM02,IDM03,IDM04,IDM05"
                      value="${managementDto.mhmBasicsInfo.education}"/>
    </td>
    <th>就业情况：</th>
    <td>
        <ehr:dic-list dicmeta="GBT6565" name="mhmBasicsInfo.occupation" width="140px;" value="${managementDto.mhmBasicsInfo.occupation}"
                      code="CV020120230,CV020120231,CV020120211,CV020120232,CV020120229,CV020120228,1/2,CV020120299,CV020120217"/>
    </td>
</tr>
<tr>
    <th>婚姻状况：</th>
    <td>
        <ehr:dic-list dicmeta="GBT226122003" name="mhmBasicsInfo.marriage" value="${managementDto.mhmBasicsInfo.marriage}" />
    </td>

</tr>
<tr>
    <th><label class="required">病人类型：</label></th>
    <td  colspan="3">
        <ehr:dic-radio name="mhmOtherInfo.patientType" dicmeta="MH00003" value="${managementDto.mhmOtherInfo.patientType}" reg='{"required":"true"}'/>
        <a href="javascript:void(0)" onclick="baseArchives.popupPatientType('${managementDto.eventId}')"><b class="jilu" style="padding-left: 20px;">病人类型变更记录</b></a>
    </td>
</tr>
<tr>
    <th>工作单位：</th>
    <td colspan="2">
        <input id="unitNameId" type="text" name="mhmBasicsInfo.unitName" value="${managementDto.mhmBasicsInfo.unitName}" reg='{"maxlength":"70"}'/>
    </td>
</tr>
<tr>
    <th>基层医疗卫生机构：</th>
    <td colspan="2">
        <input type="text" name="mhmOtherInfo.basicMedicalUnit" value="${managementDto.mhmOtherInfo.basicMedicalUnit}" reg='{"maxlength":"100"}'/>
    </td>
</tr>
<tr>
    <th>监护人身份证号码：</th>
    <td>
        <input type="text" name="mhmBasicsInfo.guarderIdcard" value="${managementDto.mhmBasicsInfo.guarderIdcard}" reg='{"idCard":"idCard"}'>
    </td>
</tr>
<tr>
    <th>监护人姓名：</th>
    <td>
        <input type="text" name="mhmBasicsInfo.parentsName" value="${managementDto.mhmBasicsInfo.parentsName}" reg='{"maxlength":"50"}'>
    </td>
    <th>监护人与病人关系：</th>
    <td>
        <ehr:dic-list dicmeta="MH00044" name="mhmBasicsInfo.guarderRelationCode" value="${managementDto.mhmBasicsInfo.guarderRelationCode}"/>
    </td>
</tr>
<tr>
    <th>监护人住址：</th>
    <td colspan="3">
        <input type="text" name="mhmBasicsInfo.guarderAddress" value="${managementDto.mhmBasicsInfo.guarderAddress}" reg='{"maxlength":"100"}'>
    </td>
</tr>
<tr>
    <th>监护人联系电话：</th>
    <td>
        <input type="text" name="mhmBasicsInfo.guarderPhone" value="${managementDto.mhmBasicsInfo.guarderPhone}" reg='{"regex":"phone"}'>
    </td>
    <th>监护人服务处所：</th>
    <td>
        <input type="text" name="mhmBasicsInfo.guarderServiceCenter" value="${managementDto.mhmBasicsInfo.guarderServiceCenter}" reg='{"maxlength":"100"}'>
    </td>
</tr>
<tr>
    <th>辖区村（居）委会联系人：</th>
    <td>
        <input type="text" name="mhmBasicsInfo.viceroyshipContact" value="${managementDto.mhmBasicsInfo.viceroyshipContact}" reg='{"maxlength":"50"}'>
    </td>
    <th>辖区村（居）委会联系人电话：</th>
    <td>
        <input type="text" name="mhmBasicsInfo.viceroyshipTel" value="${managementDto.mhmBasicsInfo.viceroyshipTel}" reg='{"regex":"phone"}'>
    </td>
</tr>
<tr>
    <th>知情同意：</th>
    <td>
    	<ehr:dic-radio name="mhmBasicsInfo.informedConsent" dicmeta="FS10400" value="${managementDto.mhmOtherInfo.informedConsent}" />
        <%-- <input type="text" name="mhmOtherInfo.informedConsent" value="${managementDto.mhmOtherInfo.informedConsent}" reg='{"maxlength":"20"}'> --%>
    </td>
    <th>知情同意签字时间：</th>
    <td>
        <%-- <tag:dateInput name="mhmOtherInfo.informedConsentSignDate" date="${managementDto.mhmOtherInfo.informedConsentSignDate}"/> --%>
        <input type="text" class="layui-input x-admin-content-sm-date"  name="mhmOtherInfo.informedConsentSignDate" id="mhmOtherInfoInformedConsentSignDateId" value="<fmt:formatDate value='${managementDto.mhmOtherInfo.informedConsentSignDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
    </td>
</tr>
<tr>
    <th>签字人：</th>
    <td>
        <input type="text" name="mhmOtherInfo.informedConsentName" value="${managementDto.mhmOtherInfo.informedConsentName}" reg='{"maxlength":"50"}'>
    </td>
    <th>初次发病时间：</th>
    <td>
        <%-- <tag:dateInput name="mhmPathHistory.firstDiseaseDate" date="${managementDto.mhmPathHistory.firstDiseaseDate}"/> --%>
        <input type="text" class="layui-input x-admin-content-sm-date"  name="mhmPathHistory.firstDiseaseDate" id="mhmPathHistoryFirstDiseaseDateId" value="<fmt:formatDate value='${managementDto.mhmPathHistory.firstDiseaseDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
    </td>
</tr>
<tr>
    <th>住院情况：</th>
    <td colspan="3">
        <input type="text" name="mhmPathHistory.hospitalCourse" value="${managementDto.mhmPathHistory.hospitalCourse}" reg='{"maxlength":"200"}'>
    </td>
    <%-- <th>首次抗精神病药治疗时间：</th>
    <td>
        <tag:dateInput name="mhmPathHistory.firstTreatmentDate" date="${managementDto.mhmPathHistory.firstTreatmentDate}"/>
    </td> --%>
</tr>
<tr>
    <th>既往主要症状：</th>
    <td colspan="3">
        <ehr:dic-checkbox name="mhmPathHistory.symptom" dicmeta="MH00009" value="${managementDto.mhmPathHistory.symptom}" reg='{"maxlength":"200"}'/>
    </td>
</tr>
<tr>
    <th>既往治疗情况：</th>
    <td colspan="3">
        门诊：
        <ehr:dic-radio name="mhmBasicsInfo.previousTreatment" dicmeta="FS10401" value="${managementDto.mhmPathHistory.previousTreatment}" />
        <%-- <input type="text" name="mhmPathHistory.previousTreatment" value="${managementDto.mhmPathHistory.previousTreatment}" reg='{"maxlength":"200"}' style="width: 200px;"> --%>
        <br>
         首次抗精神病药治疗时间：
        <%-- <tag:dateInput style="width: 80px;" name="mhmPathHistory.firstTreatmentDate" date="${managementDto.mhmPathHistory.firstTreatmentDate}"/> --%>
        <input type="text" class="layui-input x-admin-content-sm-date"  name="mhmPathHistory.firstTreatmentDate" id="mhmPathHistoryFirstTreatmentDateId" value="<fmt:formatDate value='${managementDto.mhmPathHistory.firstTreatmentDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
         <br>
        住院： 曾住精神专科医院/综合医院精神专科
        <input type="text" name="mhmPathHistory.previousInhospitalTimes" value="${managementDto.mhmPathHistory.previousInhospitalTimes}"
               reg='{"maxlength":"5"}' style="width: 80px;text-align: center">次
    </td>
</tr>

<c:if test="${not empty attches}">
    <tr>
        <th>附件：</th>
        <td colspan="3">
            <c:forEach items="${attches}" var="attche" >
                <div style="width: 300px;float: left;margin-top: 5px;text-align: left;" id="${attche.id}-div">
                    <c:if test="${attche.imageFlag eq true}">
                        <a target="blank" href="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=1"><img alt="点击查看大图" title="点击查看大图"
                                                                                                                                   src="${pageContext.request.contextPath}/he/upload/showSmallImage/${attche.id}"
                        /></a>
                    </c:if>
                    <c:if test="${attche.imageFlag eq false}">
                        <a target="blank"  href="${pageContext.request.contextPath}/he/upload/download/${attche.id}" onclick="javascript:void(0)">${attche.originalFileName}</a>
                    </c:if>
                        <%--<a href="javascript:void(0);" onclick="intoEdit.deleteFile('${attche.id}')">删除</a>--%>
                </div>
            </c:forEach>
        </td>
    </tr>
</c:if>
<c:if test="${empty attches}">
    <tr>
        <th>附件：</th>
        <td colspan="3" style="width: 100px">
            <div id="blFile"></div>
        </td>
    </tr>
</c:if>

<tr>
    <th>目前诊断：</th>
    <td colspan="2">
        诊断结果：
        <%--<input type="text" name="mhmDiagnosis.currentDiagnosis" value="${managementDto.mhmDiagnosis.currentDiagnosis}" reg='{"maxlength":"400"}' style="width: 120px;">--%>
        <%--<ehr:dic-list name="mhmDiagnosis.diagnosisContent" dicmeta="MH00052" value="${managementDto.mhmDiagnosis.diagnosisContent}"></ehr:dic-list>--%>
        <input type="text" id="mhmIcd10CodeId" name="mhmDiagnosis.diagnosisContent" value="${managementDto.mhmDiagnosis.diagnosisContent}"/>
        <br>诊断医院：
        <ehr:org-type-list id="diagnosisHospital"  width="200px" reg="{'required':true}" name="mhmDiagnosis.diagnosisHospital" type="hospital,centre"  value="${managementDto.mhmDiagnosis.diagnosisHospital}"/>
            外地诊断:<input id="isForeignFlag" type="checkbox" value="2" name="mhmDiagnosis.isForeign" ${managementDto.mhmDiagnosis.isForeign eq '2' ?'checked':''} >
            <input id="foreignHospital" type="text" value="${managementDto.mhmDiagnosis.foreignUnit}" name="mhmDiagnosis.foreignUnit"
                   style="width:150px " reg="{'maxlength':100,'dependOn':'isForeignFlag','required':true}" >
        <br>诊断医师：<input type="text" name="mhmDiagnosis.diagnosisDoctor" value="${managementDto.mhmDiagnosis.diagnosisDoctor}" style="width: 120px;" reg='{"maxlength":"50"}'>
        <br>确诊日期：<%-- <tag:dateInput name="mhmDiagnosis.diagnosisDate" date="${managementDto.mhmDiagnosis.diagnosisDate}" style="width: 120px;"/> --%>
        <input type="text" class="layui-input x-admin-content-sm-date"  name="mhmDiagnosis.diagnosisDate" id="mhmDiagnosisDiagnosisDateId" value="<fmt:formatDate value='${managementDto.mhmDiagnosis.diagnosisDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 120px;" />
    </td>
</tr>
<tr>
    <th>最近一次治疗效果：</th>
    <td>
        <ehr:dic-radio name="mhmPathHistory.lastInhospitalEffect" dicmeta="MH00013" value="${managementDto.mhmPathHistory.lastInhospitalEffect}"/>
    </td>

</tr>
<%-- <tr>
    <th>患者是否对家庭社会有影响：</th>
    <td>
        <ehr:dic-radio name="mhmOtherInfo.effectFlag" dicmeta="PH00001" code="1,2" value="${managementDto.mhmOtherInfo.effectFlag}"
                onchange="toggleOther('mhmOtherInfo.effectFlag', 'ref', 1);"/>
    </td>
</tr> --%>
<tr id="ref" >
    <th>危险行为：</th>
    <td colspan="3">
        1. 轻度滋事
        <input type="text" name="mhmOtherInfo.mildAffray" value="${managementDto.mhmOtherInfo.mildAffray}"
               reg='{"maxlength":"2"}' style="width: 80px; text-align: center"> 次
        <br>2. 肇事
        <input type="text" name="mhmOtherInfo.causeTrouble" value="${managementDto.mhmOtherInfo.causeTrouble}"
               reg='{"maxlength":"2"}' style="width: 80px; text-align: center"> 次
        <br>3. 肇祸
        <input type="text" name="mhmOtherInfo.accident" value="${managementDto.mhmOtherInfo.accident}"
               reg='{"maxlength":"2"}' style="width: 80px; text-align: center"> 次
        <br>4. 自伤
        <input type="text" name="mhmOtherInfo.autolesion" value="${managementDto.mhmOtherInfo.autolesion}"
               reg='{"maxlength":"2"}' style="width: 80px; text-align: center"> 次
        <br>5. 自杀未遂
        <input type="text" name="mhmOtherInfo.attemptedSuicide" value="${managementDto.mhmOtherInfo.attemptedSuicide}"
               reg='{"maxlength":"2"}' style="width: 80px; text-align: center"> 次
    </td>
</tr>
<tr>
    <th>既往关锁情况：</th>
    <td>
        <ehr:dic-radio dicmeta="MH00007" name="mhmOtherInfo.lockState" value="${managementDto.mhmOtherInfo.lockState}"/>
    </td>
    <th>两系三代精神疾病家族史：</th>
    <td>
        <ehr:dic-radio name="mhmPathHistory.familyHistory" dicmeta="PH00001" code="1,2" value="${managementDto.mhmPathHistory.familyHistory}"/>
    </td>
</tr>
<tr>
    <th>共同居住者：</th>
    <td colspan="3">
        <ehr:dic-checkbox name="mhmOtherInfo.jointHabitation" dicmeta="MH00045" value="${managementDto.mhmOtherInfo.jointHabitation}"/>
    </td>
</tr>
<tr>
    <th>有无残疾证：</th>
    <td colspan="3">
        <ehr:dic-radio name="mhmOtherInfo.challengedFlag" dicmeta="PH00001" code="1,2" value="${managementDto.mhmOtherInfo.challengedFlag}"
                onchange="toggleOther('mhmOtherInfo.challengedFlag', 'challenged', 1);"/>
        <span id="challenged" style="display: none">
            （残疾类别：<input type="text" name="mhmOtherInfo.challengedCategory" value="${managementDto.mhmOtherInfo.challengedCategory}" style="width: 100px;" reg='{"maxlength":"20"}'>
            等级：<input type="text" name="mhmOtherInfo.challengedGrade" value="${managementDto.mhmOtherInfo.challengedGrade}" style="width: 100px;" reg='{"maxlength":"20"}'>
            鉴定时间：<tag:dateInput name="mhmOtherInfo.challengedIdentifyDate" date="${managementDto.mhmOtherInfo.challengedIdentifyDate}" style="width:100px;"/>）</span>
    </td>
</tr>
<tr>
    <th>末次出院日期：</th>
    <td>
        <%-- <tag:dateInput name="mhmPathHistory.lastLeaveHospitalDate" date="${managementDto.mhmPathHistory.lastLeaveHospitalDate}"/> --%>
        <input type="text" class="layui-input x-admin-content-sm-date"  name="mhmPathHistory.lastLeaveHospitalDate" id="mhmPathHistoryLastLeaveHospitalDateId" value="<fmt:formatDate value='${managementDto.mhmPathHistory.lastLeaveHospitalDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
    </td>
    <th>末次住院医院：</th>
    <td>
        <input type="text" name="mhmPathHistory.lastInhospital" value="${managementDto.mhmPathHistory.lastInhospital}" reg='{"maxlength":"100"}'>
    </td>
</tr>
<tr>
    <th><label class="required">是否免费服药：</label></th>
    <td>
     <ehr:dic-radio name="mhmOtherInfo.freeFlag" dicmeta="PH00001" code="1,2" value="${managementDto.mhmOtherInfo.freeFlag}" onchange="baseArchives.changeFreeFlag()"
                    reg='{"required":"true"}'/>
        &nbsp;&nbsp;
        <a href="javascript:void(0)" onclick="baseArchives.popupDrugFree('${managementDto.eventId}')"><b class="jilu" style="padding-left: 20px;">免费服药变更记录</b></a>
    </td>
</tr>
<tr>
    <th>是否纳入管理：</th>
    <td>
        <ehr:dic dicmeta="PH00001" code="${managementDto.mhmOtherInfo.bringIntoFlag}"/>
    </td>
</tr>
<tbody id="mgntPart">
    <tr>
        <th><label class="required">管理方式：</label></th>
        <td colspan="3">
            <ehr:dic-list name="mhmOtherInfo.bringIntoMode" dicmeta="MH00006" value="${managementDto.mhmOtherInfo.bringIntoMode}" width="150px"
                          onchange="toggleOtherSC('mhmOtherInfo.bringIntoMode', 'bringIntoModeBase', 2)"
                          reg='{"required":"true"}'/>
            <span id="bringIntoModeBase" style="display: none">
             &nbsp;&nbsp;进入个案管理之前是否纳入基础管理：
                <ehr:dic-radio name="mhmOtherInfo.isBase" dicmeta="PH00001" code="1,2" value="${managementDto.mhmOtherInfo.isBase}"/>
             &nbsp;&nbsp;时间
                <%-- <tag:dateInput name="mhmOtherInfo.baseDt" date="${managementDto.mhmOtherInfo.baseDt}" style="width:150px;"/></span> --%>
                <input type="text" class="layui-input x-admin-content-sm-date"  name="mhmOtherInfo.baseDt" id="mhmOtherInfoBaseDtId" value="<fmt:formatDate value='${managementDto.mhmOtherInfo.baseDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:150px;" />
            &nbsp;&nbsp;
            <a href="javascript:void(0)" onclick="baseArchives.popupMgntType('${managementDto.eventId}')"><b class="jilu" style="padding-left: 20px;">管理变更记录</b></a>
        </td>
    </tr>
    <tr>
        <th>管理单位：</th>
        <td id="mgntUnitPart" class="colinput" colspan="3">
            <%--影响下面标签显示<span style="display: none">
            <ehr:dic-town-centre-station isShow="false" centreName="mhmOtherInfo.managementCenter"
                                                stationName="mhmOtherInfo.managementStation" townName="mhmOtherInfo.managementTown"
                                                townValue="${managementDto.mhmOtherInfo.managementTown}" centreValue="${managementDto.mhmOtherInfo.managementCenter}"
                                                stationValue="${managementDto.mhmOtherInfo.managementStation}" width="150px"
                                                reg='{"required":"true"}'/>
            </span>--%>
            <input type="hidden" name="mhmOtherInfo.managementTown" value="${managementDto.mhmOtherInfo.managementTown}"/>
            <input type="hidden" name="mhmOtherInfo.managementCenter" value="${managementDto.mhmOtherInfo.managementCenter}"/>
            <input type="hidden" name="mhmOtherInfo.managementStation" value="${managementDto.mhmOtherInfo.managementStation}"/>
            <ehr:org code="${managementDto.mhmOtherInfo.managementCenter}"/>
            <ehr:org code="${managementDto.mhmOtherInfo.managementStation}"/>
        </td>
    </tr>
    <tr>
        <th>纳入管理时间：</th>
        <td>
            <fmt:formatDate value="${managementDto.mhmOtherInfo.bringIntoDate}" pattern="yyyy/MM/dd" />
            <input type="hidden" name="mhmOtherInfo.bringIntoDate" value="<fmt:formatDate value="${managementDto.mhmOtherInfo.bringIntoDate}" pattern="yyyy/MM/dd" />" />
        </td>
    </tr>
</tbody>
</table>
</fieldset>
<fieldset class="layui-elem-field">
    <legend>社保、医保情况</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 23%" />
            <col style="width: 27%" />
            <col style="width: 23%" />
            <col style="width: 27%" />
        </colgroup>
        <tr>
            <th>是否为精准扶贫对象：</th>
            <td>
                <ehr:dic-radio name="mhmOtherInfo.poorFamiliesFlag" dicmeta="PH00001" code="1,2" value="${managementDto.mhmOtherInfo.poorFamiliesFlag}"/>
            </td>
            <th>是否为监护补助对象：</th>
            <td>
                <ehr:dic-radio name="mhmOtherInfo.subsidizedFlag" dicmeta="PH00001" code="1,2" value="${managementDto.mhmOtherInfo.subsidizedFlag}"/>
            </td>
        </tr>
        <tr>
            <th>是否为关爱帮扶小组服务对象：</th>
            <td>
                <ehr:dic-radio name="mhmOtherInfo.helpServiceFlag" dicmeta="PH00001" code="1,2" value="${managementDto.mhmOtherInfo.helpServiceFlag}"/>
            </td>
            <th><label>是否为家庭医师签约服务对象：</label></th>
            <td>
                <ehr:dic-radio name="mhmOtherInfo.familyDoctorFlag" dicmeta="PH00001" code="1,2" value="${managementDto.mhmOtherInfo.familyDoctorFlag}"/>
            </td>
        </tr>
        <tr>
            <th><label>是否参加社区康复服务：</label></th>
            <td colspan="3">
                <ehr:dic-radio name="mhmOtherInfo.communityRehabilittationFlag" dicmeta="PH00001" code="1,2" value="${managementDto.mhmOtherInfo.communityRehabilittationFlag}"/>
            </td>
        </tr>
        <tr>
            <th>医保情况：</th>
            <td>
                <ehr:dic-list name="mhmOtherInfo.medicalInsurance" dicmeta="MH00008" value="${managementDto.mhmOtherInfo.medicalInsurance}"/>
            </td>
            <th>低保情况：</th>
            <td>
                <ehr:dic-radio name="mhmOtherInfo.subsistenceOption" dicmeta="PH00001" code="1,2" value="${managementDto.mhmOtherInfo.subsistenceOption}"/>
            </td>
        </tr>
        <tr>
            <th><label class="required">经济状况：</label></th>
            <td colspan="3">
                <ehr:dic-list id="stateEconomyId" name="mhmOtherInfo.stateEconomy" dicmeta="MH00042" value="${managementDto.mhmOtherInfo.stateEconomy}" reg='{"required":"true"}' width="250px"/>
                <%--&nbsp;&nbsp;--%>
                <%--<a href="javascript:void(0)" onclick="baseArchives.popupEconomy('${managementDto.eventId}')"><b class="jilu" style="padding-left: 20px;">经济状况变更记录</b></a>--%>
            </td>
        </tr>
        <tr>
            <th>专科医生意见：</th>
            <td colspan="3">
                <textarea rows="3" cols="4" style="width: 100%" name="mhmDiagnosis.specialistAdvice" reg='{"maxlength":"400"}'>${managementDto.mhmDiagnosis.specialistAdvice}</textarea>
            </td>
        </tr>
        <tr>
            <th>填表日期：</th>
            <td>
                <%-- <tag:dateInput name="mhmOtherInfo.fillDate" date="${managementDto.mhmOtherInfo.fillDate}"/> --%>
                <input type="text" class="layui-input x-admin-content-sm-date"  name="mhmOtherInfo.fillDate" id="mhmOtherInfoFillDateId" value="<fmt:formatDate value='${managementDto.mhmOtherInfo.fillDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
            </td>
            <th>医生签字：</th>
            <td>
                <ehr:user userCode="${managementDto.mhmOtherInfo.fillDoctorId}"/>
                <input type="hidden" name="mhmOtherInfo.fillDoctorId" value="${managementDto.mhmOtherInfo.fillDoctorId}"/>
                <input type="hidden" name="mhmOtherInfo.fillOrganCode" value="${managementDto.mhmOtherInfo.fillOrganCode}"/>
            </td>
        </tr>
    </table>
</fieldset>
</div>

</div>
</form>

<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#mhmOtherInfoInformedConsentSignDateId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });

    laydate.render({
      elem: '#mhmPathHistoryFirstDiseaseDateId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	, trigger: 'click' 
    });
    
    laydate.render({
        elem: '#mhmPathHistoryFirstTreatmentDateId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#mhmDiagnosisDiagnosisDateId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#mhmPathHistoryLastLeaveHospitalDateId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#mhmOtherInfoBaseDtId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#mhmOtherInfoFillDateId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
  });
</script>