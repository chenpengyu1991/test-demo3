<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/js/views/mhm/patient/into/intoEdit.js" type="text/javascript"></script>
<c:set var="JFZX" value="<%=RoleType.JKJFZX.getValue()%>"/>
<c:set var="JFYS" value="<%=RoleType.ZXJFYS.getValue()%>"/>
<c:set var="ZJSB" value="<%=RoleType.ZJSB.getValue()%>"/>
<script type="text/javascript">
    $(document).ready(function()
    {
        intoEdit.uploadFile("blFile", "/he/upload/uploadFile/hzbl", "/he/upload/deleteFile/hzbl");
    });
</script>
<div class="toolbar">
    <div class="toolbar" style="background: none">
        <a href="javascript:void(0)" id = "back"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
        <c:if test="${logoff != 1}">
            <ehr:authorize ifAnyGranted="${JFZX},${JFYS},${ZJSB}">
                <!-- <a id="save1" href="javascript:intoEdit.saveMgnt()"><b class="baocun">纳入管理</b></a> -->
                <a id="save1" href="javascript:intoEdit.saveMgnt()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>纳入管理</button></a>
                <!-- <a id="save2" href="javascript:intoEdit.saveBaseInfo()"><b class="baocun">保存</b></a> -->
                <a id="save2" href="javascript:intoEdit.saveBaseInfo()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
            </ehr:authorize>
        </c:if>
    </div>
</div>
<form id="baseForm">
<div class="postcontent" style="margin-top: 10px;">
<input type="hidden" name="statusId" value="${managementDto.statusId}"/>
<input type="hidden" name="eventId" value="${managementDto.eventId}"/>
<input type="hidden" id="bringIntoFlag" value="${managementDto.mhmOtherInfo.bringIntoFlag}">

<input type="hidden" name="mhmBasicsInfo.id"  value="${managementDto.mhmBasicsInfo.id}">
<input type="hidden" name="mhmBasicsInfo.age"  value="${managementDto.mhmBasicsInfo.age}">
<input type="hidden" name="mhmOtherInfo.id"  value="${managementDto.mhmOtherInfo.id}">
<input type="hidden" name="mhmPathHistory.id"  value="${managementDto.mhmPathHistory.id}">
<input type="hidden" name="mhmDiagnosis.id"  value="${managementDto.mhmDiagnosis.id}">
<%--<input type="hidden" name="mhmDiagnosis.diagnosisContent" value="${managementDto.mhmDiagnosis.diagnosisContent}">--%>
<input type="hidden" id="logoffIdd" name="logoff" value="${managementDto.logoff}"/>
<div class="postdiv divAbsolute55">
<fieldset class="layui-elem-field">
<legend>病人基本信息</legend>
<table class="posttable">
<colgroup>
    <col style="width: 23%" />
    <col style="width: 27%" />
    <col style="width: 23%" />
    <col style="width: 27%" />
</colgroup>
<tr>
    <th>身份证号：</th>
    <td  colspan="3">
        <input id="idCard" type="text" name="mhmBasicsInfo.idcard" value="${managementDto.mhmBasicsInfo.idcard}"
               placeholder="输入身份证获取个人信息" reg='{"idCard":"true"}' style="width: 180px;"/>(如有身份证，请先输入病人身份证信息)
    </td>
</tr>
<tr>
    <th><label class="required">姓名：</label></th>
    <td><input type="text" id="baseName" name="mhmBasicsInfo.name" value="${managementDto.mhmBasicsInfo.name}" reg='{"maxlength":"50","required":"true"}'></td>
    <th>曾用名：</th>
    <td>
        <input type="text" name="mhmBasicsInfo.formerName" value="${managementDto.mhmBasicsInfo.formerName}" reg='{"maxlength":"50"}'>
    </td>
</tr>
<tr>
    <th><label class="required">性别：</label></th>
    <td><ehr:dic-radio name="mhmBasicsInfo.gender" dicmeta="GBT226112003" value="${managementDto.mhmBasicsInfo.gender}" code="1,2"  reg='{"required":"true"}'/>
    </td>
    <th>民族：</th>
    <td>
        <ehr:dic-list name="mhmBasicsInfo.nation" dicmeta="GBT3304" value="${managementDto.mhmBasicsInfo.nation}" width="140px;"/>
    </td>
</tr>
<tr>
    <th><label class="required">常住类型：</label></th>
    <td><ehr:dic-radio name="mhmBasicsInfo.floatPopulation" dicmeta="FS10005" reg='{"required":"true"}'
                       value="${managementDto.mhmBasicsInfo.floatPopulation}" onchange="intoEdit.toggleLocalAddress('mhmBasicsInfo.floatPopulation', 'localPart', 1);"/>
    </td>
</tr>
<tr>
    <th>现住地详址：</th>
    <td colspan="3">
    		
    		<span id="localParts">
    		<ehr:dic-town-street-village villageId="pavillage_address" streetId="pastreet_address" callback="intoEdit.displayPaAddress()"
														 townId="patown_address" villageName="mhmBasicsInfo.paGroup" streetName="mhmBasicsInfo.pastreet"
														 townName="mhmBasicsInfo.patownShip" villageValue="${managementDto.mhmBasicsInfo.paGroup}" streetValue="${managementDto.mhmBasicsInfo.pastreet}"
														 townValue="${managementDto.mhmBasicsInfo.patownShip}"  width="180px;"/>
            <br><label id="tempPaValue">
                <ehr:dic code="${managementDto.mhmBasicsInfo.patownShip}" dicmeta="FS990001"/><ehr:dic code="${managementDto.mhmBasicsInfo.pastreet}" dicmeta="FS990001"/><ehr:dic code="${managementDto.mhmBasicsInfo.paGroup}" dicmeta="FS990001"/>
            </label></span>
        <input type="text" id="pahouseNumber" name="mhmBasicsInfo.pahouseNumber" value="${managementDto.mhmBasicsInfo.pahouseNumber}"
               reg='{"maxlength":"50"}'  style="width: 150px;">
        <span id="spanPaNumber">(门牌号)</span>
    </td>
</tr>
<tr>
    <th>户籍地详址：</th>
    <td colspan="3">
        <span id="localPart">
        		<ehr:dic-town-street-village
								villageId="homeVillage_address" townId="homeTown_address" streetId="homeStreet_address"
								villageName="mhmBasicsInfo.hrGroup" streetName="mhmBasicsInfo.hrstreet"
								townName="mhmBasicsInfo.hrtownShip" streetValue="${managementDto.mhmBasicsInfo.hrstreet}"
								villageValue="${managementDto.mhmBasicsInfo.hrGroup}" 
								townValue="${managementDto.mhmBasicsInfo.hrtownShip}" callback="intoEdit.displayHrAddress" width="180px;" />
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
        <ehr:dic-list name="mhmBasicsInfo.education" dicmeta="GBT46582006" code="IDM01,IDM02,IDM03,IDM04,IDM05"
                      value="${managementDto.mhmBasicsInfo.education}" width="140px;"/>
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
        <ehr:dic-list dicmeta="GBT226122003" name="mhmBasicsInfo.marriage" value="${managementDto.mhmBasicsInfo.marriage}" width="140px;"/>
    </td>
    <th><label class="required">病人类型：</label></th>
    <td>
        <ehr:dic-radio name="mhmOtherInfo.patientType" dicmeta="MH00003" value="${managementDto.mhmOtherInfo.patientType}" reg='{"required":"true"}'/>
    </td>
</tr>
<tr>
    <th>工作单位：</th>
    <td colspan="2">
        <input type="text" name="mhmBasicsInfo.unitName" value="${managementDto.mhmBasicsInfo.unitName}" reg='{"maxlength":"70"}'/>
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
    <th><label class="required">监护人姓名：</label></th>
    <td>
        <input type="text" name="mhmBasicsInfo.parentsName" value="${managementDto.mhmBasicsInfo.parentsName}" reg='{"maxlength":"50","required":"true"}'>
    </td>
    <th><label class="required">监护人与病人关系：</label></th>
    <td>
        <ehr:dic-list dicmeta="MH00044" name="mhmBasicsInfo.guarderRelationCode" value="${managementDto.mhmBasicsInfo.guarderRelationCode}" reg='{"required":"true"}' width="140px;"/>
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
    	<%-- <ehr:dic-radio name="mhmOtherInfo.informedConsent" dicmeta="FS10400" value="${managementDto.mhmOtherInfo.informedConsent}" /> --%>
        <input type="text" name="mhmOtherInfo.informedConsent" value="${managementDto.mhmOtherInfo.informedConsent}" reg='{"maxlength":"20"}'>
    </td>
    <th>知情同意签字时间：</th>
    <td valign="top">
        <%-- <tag:dateInput name="mhmOtherInfo.informedConsentSignDate" date="${managementDto.mhmOtherInfo.informedConsentSignDate}"/> --%>
        <input type="text" class="layui-input x-admin-content-sm-date"  name="mhmOtherInfo.informedConsentSignDate" id="mhmOtherInfoInformedConsentSignDateId" style="padding-left: 0px;" value="<fmt:formatDate value='${managementDto.mhmOtherInfo.informedConsentSignDate}' pattern='yyyy/MM/dd'/>" />
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
        <input type="text" class="layui-input x-admin-content-sm-date"  name="mhmPathHistory.firstDiseaseDate" id="mhmPathHistoryFirstDiseaseDateId" style="padding-left: 0px;" value="<fmt:formatDate value='${managementDto.mhmPathHistory.firstDiseaseDate}' pattern='yyyy/MM/dd'/>" />
    </td>
</tr>
<tr>
    <th>住院情况：</th>
    <td>
        <input type="text" name="mhmPathHistory.hospitalCourse" value="${managementDto.mhmPathHistory.hospitalCourse}" reg='{"maxlength":"200"}'>
    </td>
    
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
        <ehr:dic-radio name="mhmPathHistory.previousTreatment" dicmeta="FS10401" value="${managementDto.mhmPathHistory.previousTreatment}" />
        <br>
    首次抗精神病药治疗时间：
        <%-- <tag:dateInput style="width: 80px;" name="mhmPathHistory.firstTreatmentDate" date="${managementDto.mhmPathHistory.firstTreatmentDate}"/> --%>
        <input type="text" class="layui-input x-admin-content-sm-date"  name="mhmPathHistory.firstTreatmentDate" id="mhmPathHistoryFirstTreatmentDateId" style="padding-left: 0px;" value="<fmt:formatDate value='${managementDto.mhmPathHistory.firstTreatmentDate}' pattern='yyyy/MM/dd'/>" />
       <br> 
        住院： 曾住精神专科医院/综合医院精神专科
        <input type="text" name="mhmPathHistory.previousInhospitalTimes" value="${managementDto.mhmPathHistory.previousInhospitalTimes}"
               reg='{"digits":"true","min":"1","max":"100"}' style="width: 80px;text-align: center">次
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
        <br><label class="required">诊断医院：</label>
        <ehr:org-type-list id="diagnosisHospital"  width="200px" reg="{'required':true}" name="mhmDiagnosis.diagnosisHospital" type="hospital,centre"  value="${managementDto.mhmDiagnosis.diagnosisHospital}"/>
        外地诊断:<input id="isForeignFlag" type="checkbox" value="2" name="mhmDiagnosis.isForeign" ${managementDto.mhmDiagnosis.isForeign eq '2' ?'checked':''} >
        <input id="foreignHospital" type="text" value="${managementDto.mhmDiagnosis.foreignUnit}" name="mhmDiagnosis.foreignUnit"
               style="width:150px;display: none " reg="{'maxlength':100,'dependOn':'isForeignFlag','required':true}" >
        <br>诊断医师：<input type="text" name="mhmDiagnosis.diagnosisDoctor" value="${managementDto.mhmDiagnosis.diagnosisDoctor}" style="width: 120px;" reg='{"maxlength":"50"}'>
        <br>确诊日期：<%-- <tag:dateInput name="mhmDiagnosis.diagnosisDate" date="${managementDto.mhmDiagnosis.diagnosisDate}" style="width: 120px;"/> --%>
        <input type="text" class="layui-input x-admin-content-sm-date"  name="mhmDiagnosis.diagnosisDate" id="mhmDiagnosisDiagnosisDateId" style="padding-left: 0px;width: 120px;" value="<fmt:formatDate value='${managementDto.mhmDiagnosis.diagnosisDate}' pattern='yyyy/MM/dd'/>" />
    </td>
</tr>
<tr>
    <th>最近一次治疗效果：</th>
    <td>
        <ehr:dic-radio name="mhmPathHistory.lastInhospitalEffect" dicmeta="MH00013" value="${managementDto.mhmPathHistory.lastInhospitalEffect}"/>
    </td>

</tr>
<tr>
    <th>患者是否对家庭社会有影响：</th>
    <td>
        <ehr:dic-radio name="mhmOtherInfo.effectFlag" dicmeta="PH00001" code="1,2" value="${managementDto.mhmOtherInfo.effectFlag}"
                       onchange="toggleOther('mhmOtherInfo.effectFlag', 'ref', 1);"/>
    </td>
</tr>
<tr id="ref" style="display:none">
    <th>患者对家庭社会的影响：</th>
    <td colspan="3">
        1. 轻度滋事
        <input type="text" name="mhmOtherInfo.mildAffray" value="${managementDto.mhmOtherInfo.mildAffray}"
                      reg='{"digits":"true","min":"1","max":"99"}' style="width: 80px; text-align: center"> 次
        <br>2. 肇事
        <input type="text" name="mhmOtherInfo.causeTrouble" value="${managementDto.mhmOtherInfo.causeTrouble}"
                        reg='{"digits":"true","min":"1","max":"99"}' style="width: 80px; text-align: center"> 次
        <br>3. 肇祸
        <input type="text" name="mhmOtherInfo.accident" value="${managementDto.mhmOtherInfo.accident}"
                        reg='{"digits":"true","min":"1","max":"99"}' style="width: 80px; text-align: center"> 次
        <br>4. 自伤
        <input type="text" name="mhmOtherInfo.autolesion" value="${managementDto.mhmOtherInfo.autolesion}"
                        reg='{"digits":"true","min":"1","max":"99"}' style="width: 80px; text-align: center"> 次
        <br>5. 自杀未遂
        <input type="text" name="mhmOtherInfo.attemptedSuicide" value="${managementDto.mhmOtherInfo.attemptedSuicide}"
                  reg='{"digits":"true","min":"1","max":"99"}' style="width: 80px; text-align: center"> 次
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
            鉴定时间：<%-- <tag:dateInput name="mhmOtherInfo.challengedIdentifyDate" date="${managementDto.mhmOtherInfo.challengedIdentifyDate}" style="width:100px;"/> --%>
       <input type="text"  class="layui-input x-admin-content-sm-date"  name="mhmOtherInfo.challengedIdentifyDate" id="challengedIdentifyDate" style="padding-left: 0px;width:100px;" value="<fmt:formatDate value='${managementDto.mhmOtherInfo.challengedIdentifyDate}' pattern='yyyy/MM/dd'/>" />     
            ）</span>
    </td>
</tr>
<tr>
    <th>末次出院日期：</th>
    <td>
        <%-- <tag:dateInput name="mhmPathHistory.lastLeaveHospitalDate" date="${managementDto.mhmPathHistory.lastLeaveHospitalDate}"/> --%>
        <input type="text" class="layui-input x-admin-content-sm-date"  name="mhmPathHistory.lastLeaveHospitalDate" id="mhmPathHistoryLastLeaveHospitalDateId" style="padding-left: 0px;" value="<fmt:formatDate value='${managementDto.mhmPathHistory.lastLeaveHospitalDate}' pattern='yyyy/MM/dd'/>" />
    </td>
    <th>末次住院医院：</th>
    <td>
        <input type="text" name="mhmPathHistory.lastInhospital" value="${managementDto.mhmPathHistory.lastInhospital}" reg='{"maxlength":"100"}'>
    </td>
</tr>
<tr>
    <th><label class="required">是否免费服药：</label></th>
    <td>
        <ehr:dic-radio name="mhmOtherInfo.freeFlag" dicmeta="PH00001" code="1,2" value="${managementDto.mhmOtherInfo.freeFlag}"
                       onchange="intoEdit.changeFreeFlag()" reg='{"required":"true"}'/>
    </td>
</tr>
<tr>
    <th><label class="required">是否纳入管理：</label></th>
    <td>
        <ehr:dic-radio dicmeta="PH00001" code="1" name="mhmOtherInfo.bringIntoFlag" value="${managementDto.mhmOtherInfo.bringIntoFlag eq null ? 1 :managementDto.mhmOtherInfo.bringIntoFlag}"
                       onchange="intoEdit.toggleOtherMgnt('mhmOtherInfo.bringIntoFlag',1)" reg='{"required":"true"}' />
    </td>
</tr>
<tbody id="mgntPart" style="display: none">
<tr>
    <th><label class="required">管理方式：</label></th>
    <td colspan="3">
        <ehr:dic-list name="mhmOtherInfo.bringIntoMode" dicmeta="MH00006" value="${managementDto.mhmOtherInfo.bringIntoMode}"
                      code="2" defaultval="Y" onchange="toggleOtherSC('mhmOtherInfo.bringIntoMode', 'bringIntoModeBase', 2)"
                      reg='{"required":"true"}' width="140px;"/>
            <span id="bringIntoModeBase" style="display: none">
             &nbsp;&nbsp;进入个案管理之前是否纳入基础管理：
                <ehr:dic-radio name="mhmOtherInfo.isBase" dicmeta="PH00001" code="1,2" value="${managementDto.mhmOtherInfo.isBase}"/>
             &nbsp;&nbsp;时间
                <%-- <tag:dateInput name="mhmOtherInfo.baseDt" date="${managementDto.mhmOtherInfo.baseDt}" style="width:150px;"/> --%>
                <input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date"  name="mhmOtherInfo.baseDt" id="baseDt" style="padding-left: 0px;width:150px;" value="<fmt:formatDate value='${managementDto.mhmOtherInfo.baseDt}' pattern='yyyy/MM/dd'/>" />
                
                
                </span>
    </td>
</tr>
<tr>
    <th><label class="required">管理单位：</label></th>
    <td class="colinput" colspan="3">
        <ehr:dic-town-centre-station isShow="true" townId="tid" centreId="cid" stationId="sid" centreName="mhmOtherInfo.managementCenter" stationName="mhmOtherInfo.managementStation" townName="mhmOtherInfo.managementTown"
            townValue="${managementDto.mhmOtherInfo.managementTown}" centreValue="${managementDto.mhmOtherInfo.managementCenter}" stationValue="${managementDto.mhmOtherInfo.managementStation}" width="140px"
            reg='{"required":"true"}'/>
    </td>
</tr>
<tr>
    <th><label class="required">纳入管理时间：</label></th>
    <td>
        <%-- <tag:dateInput name="mhmOtherInfo.bringIntoDate" date="${managementDto.mhmOtherInfo.bringIntoDate}" reg='{"required":"true"}'/> --%>
        <input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date"  name="mhmOtherInfo.bringIntoDate" id="mhmOtherInfoBringIntoDateId" style="padding-left: 0px;" value="<fmt:formatDate value='${managementDto.mhmOtherInfo.bringIntoDate}' pattern='yyyy/MM/dd'/>" />
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
                <ehr:dic-list name="mhmOtherInfo.medicalInsurance" dicmeta="MH00008" value="${managementDto.mhmOtherInfo.medicalInsurance}" width="140px;"/>
            </td>
            <th>低保情况：</th>
            <td>
                <ehr:dic-radio name="mhmOtherInfo.subsistenceOption" dicmeta="PH00001" code="1,2" value="${managementDto.mhmOtherInfo.subsistenceOption}"/>
            </td>
        </tr>
        <tr>
            <th><label class="required">经济状况：</label></th>
            <td colspan="3">
                <ehr:dic-list id="stateEconomyId" name="mhmOtherInfo.stateEconomy" dicmeta="MH00042" value="${managementDto.mhmOtherInfo.stateEconomy}" reg='{"required":"true"}' width="140px;"/>
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
                <input type="text" class="layui-input x-admin-content-sm-date"  name="mhmOtherInfo.fillDate" id="mhmOtherInfoFillDateId" style="padding-left: 0px;" value="<fmt:formatDate value='${managementDto.mhmOtherInfo.fillDate}' pattern='yyyy/MM/dd'/>" />
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
       	, trigger: 'click'
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
          	 , trigger: 'click'
          });
        laydate.render({
            elem: '#challengedIdentifyDate'
             ,format: 'yyyy/MM/dd'
          	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#mhmOtherInfoBringIntoDateId'
             ,format: 'yyyy/MM/dd'
          	   ,max:0
          	 , trigger: 'click'
            ,done:function(value) {
                if(!$.isEmpty(value)){
                    $("#mhmOtherInfoBringIntoDateId").removeClass("lose");
                }else{
                    $("#mhmOtherInfoBringIntoDateId").addClass("lose");
                }
            }
          });
        laydate.render({
            elem: '#baseDt'
             ,format: 'yyyy/MM/dd'
          	 , trigger: 'click'
             ,done:function(value) {
            if(!$.isEmpty(value)){
                $("#baseDt").removeClass("lose");
            }else{
                $("#baseDt").addClass("lose");
            }
        }
          });
        
        laydate.render({
            elem: '#mhmOtherInfoFillDateId'
             ,format: 'yyyy/MM/dd'
          	   ,max:0
          	 , trigger: 'click'
          });
        
        
      });

    </script>