<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"/>
<script src="${pageContext.request.contextPath}/js/views/idm/case/dengue.js" type="text/javascript"/>

<c:if test="${isPrint != 1}">
    <jsp:include page="caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
<div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
<i class="popno">
    登革热（登革出血热）个案调查表<br/>
    <span>（乙类传染病）</span>
</i>

<input type="hidden" name="idmId" id="idmId" value="${idmId}"/>

<div class="postdiv">
<fieldset>
    <table class="posttable">
        <colgroup>
            <col style="width: 13%"/>
            <col style="width: 20%"/>
            <col style="width: 13%"/>
            <col style="width: 20%"/>
            <col style="width: 13%"/>
            <col style="width: 10%"/>
        </colgroup>
        <tr>
            <th>病例编号：</th>
            <td><input type="text" name="caseInformation.mediRecordNum" value="${caseDto.caseInformation.mediRecordNum}"
                       reg='{"maxlength":"14"}'/><!-- （年份-本县区病例顺序号） --></td>
        </tr>
    </table>
</fieldset>

<fieldset>
    <legend>一、基本情况</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 25%"/>
            <col style="width: 25%"/>
            <col style="width: 25%"/>
            <col style="width: 25%"/>
        </colgroup>
        <tr>
            <th>1. 患者姓名：</th>
            <td colspan="3">
                <input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}"
                       reg='{"maxlength":"100","required":"true"}' style="width: 150px;"/>
               
            </td>
        </tr>
        <tr>
            <th>2. 性别：</th>
            <td>
                <ehr:dic-radio dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${caseDto.generalCondition.gender}"/>
            </td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <th>3. 年龄：</th>
            <td><input type="text" name="generalCondition.age" value="${caseDto.generalCondition.age}" reg='{"maxlength":"6"}' style="width: 150px;"/>岁</td>
        </tr>      
        <tr>
            <th>4. 职业：</th>
            <td colspan="3"><ehr:dic-list dicmeta="GBT6565" name="generalCondition.occupation" width="150px;" value="${caseDto.generalCondition.occupation}"
                      code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,
                      CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120299"
                      onchange="toggleOtherSC('generalCondition.occupation','studentsDiv','CV020120203');"/>  
                <span id="studentsDiv" style="display: none">
                    &nbsp;&nbsp;如为学生，则学校（幼儿园）名称：<input type="text" name="generalCondition.schoolName" value="${caseDto.generalCondition.schoolName}" style="width: 150px;" reg='{"maxlength":"50"}'/> 
                    &nbsp;&nbsp;年纪：<input type="text" name="generalCondition.grades" value="${caseDto.generalCondition.grades}" style="width: 40px;" reg='{"maxlength":"20"}'/>
                    &nbsp;&nbsp;班级：<input type="text" name="generalCondition.classes" value="${caseDto.generalCondition.classes}" style="width: 40px;" reg='{"maxlength":"20"}'/>
                    
                </span>
            </td>
        </tr>
        <tr>
            <th>5．家长姓名：</th>
            <td colspan="3">
                <input type="text" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}"
                                       reg='{"maxlength":"50"}' style="width: 150px;"/>
           		 单位：<input type="text" name="generalCondition.unitName" value="${caseDto.generalCondition.unitName}" style="width: 200px;" reg='{"maxlength":"70"}'/>
               
            </td>
        </tr>
        <tr>
            <th>6．常住类型：</th>
            <td>
                <ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
                               value="${caseDto.generalCondition.floatPopulation}" onchange="caseEdit.toggerAddress()"/>
            </td>
        </tr>
        <tr>
            <th>7．住址：</th>
            <td colspan="3">
                <ehr:dic-town-street-village streetId="pastreet_address" townId="patown_address" streetName="generalCondition.pastreet" townName="generalCondition.patownShip"
                                             streetValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="140px;"
                                             villageId="pavillage_address" villageName="generalCondition.paGroup" villageValue="${caseDto.generalCondition.paGroup}"/>
                <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
                       reg='{"maxlength":"50"}'  style="width: 180px;">
                <span id="spanPaNumber">(门牌号)</span>
            </td>
        </tr>

        <%-- <tr>
            <th>6．住址：</th>
            <td colspan="3">
                <ehr:dic-town-village villageId="pavillage_address" townId="patown_address" villageName="generalCondition.pastreet" townName="generalCondition.patownShip"
                                      villageValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="150px;"/>
                <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
                       reg='{"maxlength":"50"}'  style="width: 100px;">
                <span id="spanPaNumber">(门牌号)</span>
                  <br/>联系电话&nbsp;&nbsp;
                <input type="text" name="generalCondition.phoneNumber" value="${caseDto.generalCondition.phoneNumber}" style="width: 120px;" reg='{"regex":"phone"}'/>         
            </td>
        </tr> --%>
    </table>
</fieldset>
<fieldset>
    <legend>二、发病情况</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 25%"/>
            <col style="width: 30%"/>
            <col style="width: 15%"/>
            <col style="width: 30%"/>
        </colgroup>
        <tr>
            <th>1. 发病日期：</th>
            <td><tag:dateInput id="pathogenesisDate" name="attackCondition.pathogenesisDate" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.attackCondition.pathogenesisDate}" reg='{"compare":["clinicDate","le","发病日期不能晚于就诊日期"]}'/></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <th>2. 初诊日期：</th>
            <td><tag:dateInput id="clinicDate" name="attackCondition.clinicDate" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.attackCondition.clinicDate}" reg='{"compare":["pathogenesisDate","ge","就诊日期不能早于发病日期"]}'/></td>
        </tr>
        <tr>
            <th>3. 住院医院：</th>
            <td>
                <input type="text" name="attackCondition.admissionHospital" value="${caseDto.attackCondition.admissionHospital}" reg='{"maxlength":"100"}'/>
            </td>
        </tr>
         <tr>
            <th>4. 住院号：</th>
            <td><input type="text" name="attackCondition.admissionNo" value="${caseDto.attackCondition.admissionNo}" reg='{"maxlength":"50"}'/></td>
        </tr>
         <tr>
            <th>5. 住院日期：</th>
            <td><tag:dateInput id="inhosDateId" name="attackCondition.inhosDate" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.attackCondition.inhosDate}" reg='{"compare":["outHospitalDateId","le","住院日期不能晚于出院日期"]}'/></td>
        </tr>
        <tr>
            <th>6. 出院日期：</th>
            <td><tag:dateInput id="outHospitalDateId" name="attackCondition.outHospitalDate" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.attackCondition.outHospitalDate}" reg='{"compare":["inhosDateId","ge","出院日期不能早于住院日期"]}'/></td>
        </tr>
         <tr>
            <th>7. 入院诊断：</th>
            <td colspan="3">
                <ehr:dic-radio name="attackCondition.dengueInhosDiagnosis" dicmeta="IDM00040" code="1,2,3,99" value="${caseDto.attackCondition.dengueInhosDiagnosis}"
                        onchange="toggleOther('attackCondition.dengueInhosDiagnosis','dengueInhosDiagnosisOther',99);"/>
                <span id="dengueInhosDiagnosisOther" style="display: none">
                    <input type="text" name="attackCondition.dengueInhosDiagnosisOther" value="${caseDto.attackCondition.dengueInhosDiagnosisOther}"
                           style="width: 150px;" reg='{"maxlength":"100"}'/>
                </span>
            </td>
        </tr>
         <tr>
            <th>8. 出院诊断：</th>
            <td colspan="3"><ehr:dic-radio name="attackCondition.dengueOutDiagnosis" dicmeta="IDM00040" code="1,2,3,99" value="${caseDto.attackCondition.dengueOutDiagnosis}"
                    onchange="toggleOther('attackCondition.dengueOutDiagnosis','dengueOutDiagnosisOther',99);"/>
                <span id="dengueOutDiagnosisOther">
                    <input type="text" name="attackCondition.dengueOutDiagnosisOther" value="${caseDto.attackCondition.dengueOutDiagnosisOther}"
                           style="width: 150px;" reg='{"maxlength":"100"}'/>
                </span>
            </td>
        </tr>
         <tr>
            <th>9. 转归：</th>
            <td colspan="3"><ehr:dic-radio name="otherCondition.outcomeCode" dicmeta="CV550102" code="1,2,4" value="${caseDto.otherCondition.outcomeCode}"
                    onchange="toggleOther('otherCondition.outcomeCode','deathTime',4);toggleOther('otherCondition.outcomeCode','diseaseRecord',1);"/>
                <span id="diseaseRecord" style="display: none">
                    &nbsp;&nbsp;病程：
                    <input type="text" name="otherCondition.diseaseRecord" value="${caseDto.otherCondition.diseaseRecord}"
                           style="width: 100px;" reg='{"maxlength":"20"}'/> 天     
                </span>
                <span id="deathTime" style="display: none">
                    &nbsp;&nbsp;死亡日期：
                    <tag:dateInput name="otherCondition.deathTime" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.otherCondition.deathTime}" style="width: 100px;"/>
                </span>
            </td>
        </tr>  
        <tr>
            <th>10．症状和体征及一般实验室检查：</th>     
        </tr>
        <tr>
        	<th>起病急：</th>
            <td colspan="3"><ehr:dic-radio dicmeta="IDM00535" name="clinicalManifestations.onset" 
                               value="${caseDto.clinicalManifestations.onset}"/>
                               起病后第 <input type="text" name="clinicalManifestations.onsetFromDay" value="${caseDto.clinicalManifestations.onsetFromDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天到第<input type="text" name="clinicalManifestations.onsetToDay" value="${caseDto.clinicalManifestations.onsetToDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天
                               </td>
        </tr>
        <tr>
            <th>发热：</th>
            <td colspan="3">
                <ehr:dic-radio dicmeta="IDM00535" name="clinicalManifestations.fever" 
                               value="${caseDto.clinicalManifestations.fever}"
                       />
                        起病后第 <input type="text" name="clinicalManifestations.feverFromDay" value="${caseDto.clinicalManifestations.feverFromDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天到第<input type="text" name="clinicalManifestations.feverToDay" value="${caseDto.clinicalManifestations.feverToDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天
                

            </td>
        </tr>
        <tr>
         	<th>头痛：</th>
            <td colspan="3"><ehr:dic-radio dicmeta="IDM00535" name="clinicalManifestations.headache" 
                               value="${caseDto.clinicalManifestations.headache}"/>
                                起病后第 <input type="text" name="clinicalManifestations.headacheFromDay" value="${caseDto.clinicalManifestations.headacheFromDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天到第<input type="text" name="clinicalManifestations.headacheToDay" value="${caseDto.clinicalManifestations.headacheToDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天</td>
        </tr>
        <tr>
        <th>颜面潮红：</th>
            <td colspan="3"><ehr:dic-radio dicmeta="IDM00535" name="clinicalManifestations.facialBlushing" 
                               value="${caseDto.clinicalManifestations.facialBlushing}"/>
                                起病后第 <input type="text" name="clinicalManifestations.facialBlushingFromDay" value="${caseDto.clinicalManifestations.facialBlushingFromDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天到第<input type="text" name="clinicalManifestations.facialBlushingToDay" value="${caseDto.clinicalManifestations.facialBlushingToDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天</td>
        </tr>
        <tr>
         	<th>眼眶后痛：</th>
            <td colspan="3"><ehr:dic-radio dicmeta="IDM00535" name="clinicalManifestations.orbitPain" 
                               value="${caseDto.clinicalManifestations.orbitPain}"/>
                                起病后第 <input type="text" name="clinicalManifestations.orbitPainFromDay" value="${caseDto.clinicalManifestations.orbitPainFromDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天到第<input type="text" name="clinicalManifestations.orbitPainToDay" value="${caseDto.clinicalManifestations.orbitPainToDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天</td>
        </tr>
        <tr>
        <th>肌肉痛：</th>
            <td colspan="3"><ehr:dic-radio dicmeta="IDM00535" name="clinicalManifestations.myalgia" 
                               value="${caseDto.clinicalManifestations.myalgia}"/>
                                起病后第 <input type="text" name="clinicalManifestations.myalgiaFromDay" value="${caseDto.clinicalManifestations.myalgiaFromDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天到第<input type="text" name="clinicalManifestations.myalgiaToDay" value="${caseDto.clinicalManifestations.myalgiaToDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天</td>
        </tr>
        <tr>
        	<th>关节痛：</th>
            <td colspan="3"><ehr:dic-radio dicmeta="IDM00535" name="clinicalManifestations.limbAche" 
                               value="${caseDto.clinicalManifestations.limbAche}"/>
                                起病后第 <input type="text" name="clinicalManifestations.limbAcheFromDay" value="${caseDto.clinicalManifestations.limbAcheFromDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天到第<input type="text" name="clinicalManifestations.limbAcheToDay" value="${caseDto.clinicalManifestations.limbAcheToDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天</td>
        </tr>
        <tr>    
        <th>鼻出血：</th>
             <td colspan="3"><ehr:dic-radio dicmeta="IDM00535" name="clinicalManifestations.epistaxis" 
                               value="${caseDto.clinicalManifestations.epistaxis}"/>
                                起病后第 <input type="text" name="clinicalManifestations.epistaxisFromDay" value="${caseDto.clinicalManifestations.epistaxisFromDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天到第<input type="text" name="clinicalManifestations.epistaxisToDay" value="${caseDto.clinicalManifestations.epistaxisToDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天</td>
        
        </tr>
        <tr>
        <th>牙龈出血：</th>
            <td colspan="3"><ehr:dic-radio dicmeta="IDM00535" name="clinicalManifestations.gingivalBleeding" 
                               value="${caseDto.clinicalManifestations.gingivalBleeding}"/>
                                起病后第 <input type="text" name="clinicalManifestations.gingivalBleedingFromDay" value="${caseDto.clinicalManifestations.gingivalBleedingFromDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天到第<input type="text" name="clinicalManifestations.gingivalBleedingToDay" value="${caseDto.clinicalManifestations.gingivalBleedingToDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天</td>
        </tr>
        <tr>    
        	<th>呕血：</th>
            <td colspan="3"><ehr:dic-radio dicmeta="IDM00535" name="clinicalManifestations.haematemesis" 
                               value="${caseDto.clinicalManifestations.haematemesis}"/>
                                起病后第 <input type="text" name="clinicalManifestations.haematemesisFromDay" value="${caseDto.clinicalManifestations.haematemesisFromDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天到第<input type="text" name="clinicalManifestations.haematemesisToDay" value="${caseDto.clinicalManifestations.haematemesisToDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天</td>
        </tr>
        <tr>
            <th>便血：</th>
            <td colspan="3"><ehr:dic-radio dicmeta="IDM00535" name="clinicalManifestations.hemafecia" 
                               value="${caseDto.clinicalManifestations.hemafecia}"/>
                                起病后第 <input type="text" name="clinicalManifestations.hemafeciaFromDay" value="${caseDto.clinicalManifestations.hemafeciaFromDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天到第<input type="text" name="clinicalManifestations.hemafeciaToDay" value="${caseDto.clinicalManifestations.hemafeciaToDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天</td>
        </tr>
        <tr>
            <th>血尿：</th>
            <td colspan="3"><ehr:dic-radio dicmeta="IDM00535" name="clinicalManifestations.hematuresis" 
                               value="${caseDto.clinicalManifestations.hematuresis}"/>
                                起病后第 <input type="text" name="clinicalManifestations.hematuresisFromDay" value="${caseDto.clinicalManifestations.hematuresisFromDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天到第<input type="text" name="clinicalManifestations.hematuresisToDay" value="${caseDto.clinicalManifestations.hematuresisToDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天</td>
        </tr>
        <tr>
        	 <th>其他出血：</th>
             <td colspan="3"><ehr:dic-radio dicmeta="IDM00535" name="clinicalManifestations.skinBleTypeOth" 
                               value="${caseDto.clinicalManifestations.skinBleTypeOth}"/>
                                起病后第 <input type="text" name="clinicalManifestations.skinBleTypeOthFromDay" value="${caseDto.clinicalManifestations.skinBleTypeOthFromDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天到第<input type="text" name="clinicalManifestations.skinBleTypeOthToDay" value="${caseDto.clinicalManifestations.skinBleTypeOthToDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天</td>
        </tr>
        <tr>  
            <th>皮肤出血点：</th>
            <td colspan="3">
                <ehr:dic-radio dicmeta="IDM00535" name="clinicalManifestations.bleedingSpotsSkin" 
                               value="${caseDto.clinicalManifestations.bleedingSpotsSkin}"
                        />
                         起病后第 <input type="text" name="clinicalManifestations.bleedingSpotsSkinFromDay" value="${caseDto.clinicalManifestations.bleedingSpotsSkinFromDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天到第<input type="text" name="clinicalManifestations.bleedingSpotsSkinToDay" value="${caseDto.clinicalManifestations.bleedingSpotsSkinToDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天
        </tr>       
        <tr>
        	<th>皮疹（形态）：</th>
            <td colspan="3"><ehr:dic-radio dicmeta="IDM00535" name="clinicalManifestations.rashType" value="${caseDto.clinicalManifestations.rashType}"
                                      onchange="toggleOtherSC('clinicalManifestations.rashType','rashTypeOther',99);"/>
                        <span id="rashTypeOther" style="display: none">
                            <input type="text" name="clinicalManifestations.rashTypeOther" style="width: 120px;"
                                   value="${caseDto.clinicalManifestations.rashTypeOther}" reg='{"maxlength":"100"}'/>
                        </span>
                                起病后第 <input type="text" name="clinicalManifestations.rashTypeFromDay" value="${caseDto.clinicalManifestations.rashTypeFromDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天到第<input type="text" name="clinicalManifestations.rashTypeToDay" value="${caseDto.clinicalManifestations.rashTypeToDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天</td>
            
        </tr>
        <tr>
        	<th>皮疹（部位）：</th>
            <td colspan="3"><ehr:dic-radio dicmeta="IDM00535" name="clinicalManifestations.rashParts" value="${caseDto.clinicalManifestations.rashParts}"/>
                                起病后第 <input type="text" name="clinicalManifestations.rashPartsFromDay" value="${caseDto.clinicalManifestations.rashPartsFromDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天到第<input type="text" name="clinicalManifestations.rashPartsToDay" value="${caseDto.clinicalManifestations.rashPartsToDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天</td>
        </tr>
       <tr>
            <th>烦躁：</th>
            <td colspan="3" ><ehr:dic-radio dicmeta="IDM00535" name="clinicalManifestations.irritability" 
                               value="${caseDto.clinicalManifestations.irritability}"/>
                                起病后第 <input type="text" name="clinicalManifestations.irritabilityFromDay" value="${caseDto.clinicalManifestations.irritabilityFromDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天到第<input type="text" name="clinicalManifestations.irritabilityToDay" value="${caseDto.clinicalManifestations.irritabilityToDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天</td>
        </tr>
        <tr>
        	<th>昏迷：</th>
            <td colspan="3"><ehr:dic-radio dicmeta="IDM00535" name="clinicalManifestations.coma" 
                               value="${caseDto.clinicalManifestations.coma}"/>
                                起病后第 <input type="text" name="clinicalManifestations.comaFromDay" value="${caseDto.clinicalManifestations.comaFromDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天到第<input type="text" name="clinicalManifestations.comaToDay" value="${caseDto.clinicalManifestations.comaToDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天</td>
        </tr>
        <tr>
            <th>休克：</th>
            <td colspan="3"><ehr:dic-radio dicmeta="IDM00535" name="clinicalManifestations.septicStock" 
                               value="${caseDto.clinicalManifestations.septicStock}"/>
                                起病后第 <input type="text" name="clinicalManifestations.septicStockFromDay" value="${caseDto.clinicalManifestations.septicStockFromDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天到第<input type="text" name="clinicalManifestations.septicStockToDay" value="${caseDto.clinicalManifestations.septicStockToDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天</td>
        </tr>
        <tr>
        	<th>束臂试验：</th>
            <td colspan="3"><ehr:dic-radio dicmeta="IDM00535" name="clinicalManifestations.cuffButter" value="${caseDto.clinicalManifestations.cuffButter}"/>
            	起病后第 <input type="text" name="clinicalManifestations.cuffButterFromDay" value="${caseDto.clinicalManifestations.cuffButterFromDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天到第<input type="text" name="clinicalManifestations.cuffButterToDay" value="${caseDto.clinicalManifestations.cuffButterToDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天
            </td>        
        </tr>
        <tr>
        	<th>肝肿大：</th>
            <td colspan="3"><ehr:dic-radio dicmeta="IDM00535" name="clinicalManifestations.hepatomegaly"
                               value="${caseDto.clinicalManifestations.hepatomegaly}"/>
                                起病后第 <input type="text" name="clinicalManifestations.hepatomegalyFromDay" value="${caseDto.clinicalManifestations.hepatomegalyFromDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天到第<input type="text" name="clinicalManifestations.hepatomegalyToDay" value="${caseDto.clinicalManifestations.hepatomegalyToDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天</td>
        </tr>
        <tr> 
            <th>脾肿大：</th>
            <td colspan="3"><ehr:dic-radio dicmeta="IDM00535" name="clinicalManifestations.splenomegaly"
                               value="${caseDto.clinicalManifestations.splenomegaly}"/>
                                起病后第 <input type="text" name="clinicalManifestations.splenomegalyFromDay" value="${caseDto.clinicalManifestations.splenomegalyFromDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天到第<input type="text" name="clinicalManifestations.splenomegalyToDay" value="${caseDto.clinicalManifestations.splenomegalyToDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天</td>
           
        </tr>
        <tr>
             <th>淋巴结大：</th>
            <td colspan="3"><ehr:dic-radio dicmeta="IDM00535" name="clinicalManifestations.lymphadenectasis"
                               value="${caseDto.clinicalManifestations.lymphadenectasis}"/>
                                起病后第 <input type="text" name="clinicalManifestations.lymphadenectasisSkinFromDay" value="${caseDto.clinicalManifestations.lymphadenectasisSkinFromDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天到第<input type="text" name="clinicalManifestations.lymphadenectasisSkinToDay" value="${caseDto.clinicalManifestations.lymphadenectasisSkinToDay}"
                               style="width: 70px;text-align: center" reg='{"maxlength":"20"}'/>天</td>
        </tr>
        <tr> 
            <th>白细胞计数：</th>
            <td><input type="text" name="labExamine.leukocyteCountFlg" value="${caseDto.labExamine.leukocyteCountFlg}"
                               style="width: 70px;" reg='{"maxlength":"20"}'/> x 10^-9/升
            </td>
        </tr>
        <tr> 
            <th>淋巴细胞：</th>
            <td><input type="text" name="labExamine.lymphocyte" value="${caseDto.labExamine.lymphocyte}"
                       style="width: 100px;" reg='{"maxlength":"20"}'>％</td>
          </tr>
          <tr> 
            <th>中性粒：</th>
            <td><input type="text" name="labExamine.neutrophilcell" value="${caseDto.labExamine.neutrophilcell}"
                       style="width: 100px;" reg='{"maxlength":"20"}'>％</td>
        </tr>
        <tr>
            <th>血小板计数：</th>
            <td><input type="text" style="width: 100px;" name="labExamine.plateletReduce" value="${caseDto.labExamine.plateletReduce}" reg='{"maxlength":"100"}'>x 10^-9/升</td>
        </tr>
        <tr>   
        	<th>红细胞压积：</th>
            <td><input type="text" style="width: 100px;" name="labExamine.hematokrit" value="${caseDto.labExamine.hematokrit}" reg='{"maxlength":"100"}'></td>
        </tr>
        <tr>
        	<th>尿常规：</th>
            <td><input type="text" style="width: 100px;"  name="labExamine.urineRoutine" value="${caseDto.labExamine.urineRoutine}" reg='{"maxlength":"100"}'><td>
       </tr>
        <tr>      
            <th>尿蛋白：</th>
            <td><input type="text" style="width: 100px;" name="labExamine.urineProtein" value="${caseDto.labExamine.urineProtein}" reg='{"maxlength":"100"}'><td>
        </tr>
        <tr>
        	<th>尿糖：</th>
            <td><input type="text" style="width: 100px;" name="labExamine.urineSugar" value="${caseDto.labExamine.urineSugar}" reg='{"maxlength":"100"}'>mmol/L<td>
        </tr>
        <tr> 
        	 <th>比重：</th>
            <td><input type="text" style="width: 100px;" name="labExamine.urineProportion" value="${caseDto.labExamine.urineProportion}" reg='{"maxlength":"100"}'><td>
        </tr>
        <tr>
			<th >肝功能</th>
		</tr>
        <tr>
        	<th>谷草转氨酶AST：</th>
            <td><input type="text" style="width: 100px;" name="labExamine.ast" value="${caseDto.labExamine.ast}" reg='{"maxlength":"20"}'>U/L<td>
        </tr>
        <tr>
            <th>谷丙转氨酶ALT：</th>
            <td><input type="text" style="width: 100px;" name="labExamine.alt" value="${caseDto.labExamine.alt}" reg='{"maxlength":"20"}'>U/L<td>
        </tr>
        <tr>
        	<th>总胆红素TBLL：</th>
            <td><input type="text" style="width: 100px;"  name="labExamine.tbil" value="${caseDto.labExamine.tbil}" reg='{"maxlength":"20"}'>umol/L<td>
        </tr>
        <tr>  
        	 <th>胆汁酸：</th>
            <td><input type="text" style="width: 100px;" name="labExamine.bileAcid" value="${caseDto.labExamine.bileAcid}" reg='{"maxlength":"20"}'><td>
        </tr>
        <tr>
        	<th>直接胆红素DBLL：</th>
            <td><input type="text" style="width: 100px;" name="labExamine.dbll" value="${caseDto.labExamine.dbll}" reg='{"maxlength":"20"}'>umol/L<td>
         </tr>
         <tr>
            <th>间接胆红素：</th>
            <td><input type="text" style="width: 100px;" name="labExamine.ibll" value="${caseDto.labExamine.ibll}" reg='{"maxlength":"20"}'>umol/L<td>
        </tr>
        <tr>
        	<th>碱性磷酸酶ACP：</th>
            <td><input type="text" style="width: 100px;" name="labExamine.acp" value="${caseDto.labExamine.acp}" reg='{"maxlength":"20"}'>U/L<td>
         </tr>
         <tr>  
         	<th>-谷氨酰转肽酶：</th>
            <td><input type="text" style="width: 100px;" name="labExamine.glutamylAminopeptidase" value="${caseDto.labExamine.glutamylAminopeptidase}" reg='{"maxlength":"20"}'>U/L<td>
        </tr>
        <tr>
        	<th>总蛋白：</th>
            <td><input type="text" style="width: 100px;" name="labExamine.tp" value="${caseDto.labExamine.tp}" reg='{"maxlength":"20"}'>g/L<td>
        </tr>
         <tr>
              <th>白蛋白：</th>
            <td><input type="text" style="width: 100px;" name="labExamine.albumin" value="${caseDto.labExamine.albumin}" reg='{"maxlength":"20"}'>g/L<td>
        </tr>
         <tr>
        	<th>球蛋白：</th>
            <td><input type="text" style="width: 100px;" name="labExamine.globulin" value="${caseDto.labExamine.globulin}" reg='{"maxlength":"20"}'>g/L<td>
          </tr>
         <tr>   
         	<th>白球比例A/G：</th>
            <td><input type="text" style="width: 100px;" name="labExamine.ag" value="${caseDto.labExamine.ag}" reg='{"maxlength":"20"}'><td>
        </tr>
         <tr>
			<!-- <td>脑脊液</td> -->
			<th>脑脊液</th>
		</tr>
        <tr>
        	<th>浑浊：</th>
            <td><ehr:dic-radio dicmeta="PH00001" code="1,2" name="labExamine.csfCheck" value="${caseDto.labExamine.csfCheck}"/><td>
          </tr>
         <tr> 
            <th>潘氏球蛋白试验：</th>
            <td>
           		<ehr:dic-radio dicmeta="PH00004" code="1,2" name="labExamine.csfAlbumen" value="${caseDto.labExamine.csfAlbumen}"/><td>
        </tr>
        <tr>
        	<th>细胞计数：</th>
            <td><input type="text" name="labExamine.cerebrospinalcellCount" value="${caseDto.labExamine.cerebrospinalcellCount}" reg='{"maxlength":"20"}'><td>
         </tr>
         <tr> 
             <th>葡萄糖：</th>
            <td><input type="text" name="labExamine.csfSugarCount" value="${caseDto.labExamine.csfSugarCount}" reg='{"maxlength":"20"}'>mmol /L<td>
        </tr>
         <tr>
        	<th>氯化物：</th>
            <td><input type="text" name="labExamine.csfChloride" value="${caseDto.labExamine.csfChloride}" reg='{"maxlength":"20"}'>mmol /L<td>
        </tr>
        <tr>
            <th>出血时间：</th>
            <td>
            	<input type="text" name="labExamine.haemorrhageTime" value="${caseDto.labExamine.haemorrhageTime}" reg='{"maxlength":"20"}'><td>
            	<%-- <tag:dateInput name="labExamine.haemorrhageTime" date="${caseDto.labExamine.haemorrhageTime}" pattern="yyyy/MM/dd" style="width:90px;"/> --%>
            </td>
        </tr>
         <tr> 
           <th>凝血时间：</th>
            <td>
            <input type="text" name="labExamine.cruorTime" value="${caseDto.labExamine.cruorTime}" reg='{"maxlength":"20"}'><td>
            <%-- <tag:dateInput name="labExamine.cruorTime" date="${caseDto.labExamine.cruorTime}" pattern="yyyy/MM/dd" style="width:90px;"/> --%>
           </td>
        </tr>
         <tr>
            <th>心电图：</th>
            <td><input type="text" name="labExamine.electrocardiogram" value="${caseDto.labExamine.electrocardiogram}" reg='{"maxlength":"20"}'>
            </td>
         </tr>
         <tr>
           <th>超声波：</th>
            <td><input type="text" name="labExamine.ultrasonic" value="${caseDto.labExamine.ultrasonic}" reg='{"maxlength":"20"}'></td>
        </tr>
         <tr>
            <th>X线光：</th>
            <td><input type="text" name="labExamine.xRay" value="${caseDto.labExamine.xRay}" reg='{"maxlength":"20"}'>
        </tr>
        <tr>
             <td colspan="4" style="padding: 0px;">
                 <table class="posttable">
                     <thead>
		                <tr>
		                    <th class="rightth" style="width: 25%">项目</th>
		                    <th class="centerth" style="width: 15%">标本采集时间</th>
		                    <th class="centerth" style="width: 30%">检测方法</th>
		                    <th class="centerth" style="width: 30%">检测结果</th>
		                </tr>
		            </thead>
                      <tr>
		                <td class="righttd">登革抗体IgM</td>
		                <td>
		                    <tag:dateInput name="labExamine.dengueIgmCollectTime" onlypast="true" date="${caseDto.labExamine.dengueIgmCollectTime}"/>
		                </td>
		                <td><input type="text" name="labExamine.dengueIgmTestMethod" value="${caseDto.labExamine.dengueIgmTestMethod}" reg='{"maxlength":"100"}'></td>
		                <td><input type="text" name="labExamine.dengueIgmTestResult" value="${caseDto.labExamine.dengueIgmTestResult}" reg='{"maxlength":"100"}'></td>
		            	
		            </tr>
		            <tr>
		                <td class="righttd">登革抗体IgG</td>
		                <td>
		                    <tag:dateInput name="labExamine.dengueIggCollectTime" onlypast="true" date="${caseDto.labExamine.dengueIggCollectTime}"/>
		                </td>
		                <td><input type="text" name="labExamine.dengueIggTestMethod" value="${caseDto.labExamine.dengueIggTestMethod}" reg='{"maxlength":"100"}'></td>
		                <td><input type="text" name="labExamine.dengueIggTestResult" value="${caseDto.labExamine.dengueIggTestResult}" reg='{"maxlength":"100"}'></td>
		            
		            </tr>
		            
		            <tr>
		                <td class="righttd">登革病毒抗原</td>
		                <td>
		                    <tag:dateInput name="labExamine.dengueAntigenCollectTime" onlypast="true" date="${caseDto.labExamine.dengueAntigenCollectTime}"/>
		                </td>
		                <td><input type="text" name="labExamine.dengueAntigenTestMethod" value="${caseDto.labExamine.dengueAntigenTestMethod}" reg='{"maxlength":"100"}'></td>
		                <td><input type="text" name="labExamine.dengueAntigenTestResult" value="${caseDto.labExamine.dengueAntigenTestResult}" reg='{"maxlength":"100"}'></td>
		            </tr>
		            <tr>
		                <td class="righttd">登革病毒分离</td>
		                <td>
		                    <tag:dateInput name="labExamine.dengueSeparateCollectTime" onlypast="true" date="${caseDto.labExamine.dengueSeparateCollectTime}"/>
		                </td>
		                <td><input type="text" name="labExamine.dengueSeparateTestMethod" value="${caseDto.labExamine.dengueSeparateTestMethod}" reg='{"maxlength":"100"}'></td>
		                <td><input type="text" name="labExamine.dengueSeparateTestResult" value="${caseDto.labExamine.dengueSeparateTestResult}" reg='{"maxlength":"100"}'></td>
		            </tr>
                 </table>
              </td>
         </tr>
    </table>
</fieldset>
<%-- <fieldset>
    <legend>三、症状和体征及一般实验室检查</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 15%"/>
            <col style="width: 35%"/>
            <col style="width: 15%"/>
            <col style="width: 35%"/>
        </colgroup>
        
    </table>
</fieldset> --%>
<fieldset>
	<legend>三、治疗情况</legend>
 	<table class="posttable">
       <tr>
           <td>
               <textarea name="labExamine.treatCondition" style="width: 100%; height: 30px;" reg='{"maxlength":"200"}'>${caseDto.labExamine.treatCondition}</textarea>
            </td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>四、既往史</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 26%"/>
            <col style="width: 24%"/>
            <col style="width: 25%"/>
            <col style="width: 25%"/>
        </colgroup>
        <tr>
            <th>1. 过去身体是否健康：</th>
            <td><ehr:dic-radio dicmeta="PH00001" name="pastHistory.healthFlg" code="1,2" value="${caseDto.pastHistory.healthFlg}"/></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <th>2. 既往是否患过登革热或“乙脑”：</th>

            <td><ehr:dic-radio dicmeta="PH00001" name="pastHistory.dengueJeFlg" code="1,2" value="${caseDto.pastHistory.dengueJeFlg}"/></td>
        </tr>
        <tr>
            <th>3. 乙脑疫苗接种：</th>
            <td colspan="3"><ehr:dic-radio dicmeta="PH00001" name="pastHistory.jeVaccineFlg" code="1,2" value="${caseDto.pastHistory.jeVaccineFlg}"
               onchange="toggleOther('pastHistory.jeVaccineFlg','jeVaccinationDiv',1);"/>
                <span id="jeVaccinationDiv" style="display: none">
                                                 若是，共接种<input type="text" name="pastHistory.jeVaccinationNum" value="${caseDto.pastHistory.jeVaccinationNum}"
                               style="width: 50px;" reg='{"maxlength":"100"}'/>次    时间 :第一针<tag:dateInput name="pastHistory.jeFirstVaccinationDate" date="${caseDto.pastHistory.jeFirstVaccinationDate}" pattern="yyyy/MM/dd" style="width:90px;"/>
                                 第二针<tag:dateInput name="pastHistory.jeSecondVaccinationDate" date="${caseDto.pastHistory.jeSecondVaccinationDate}" pattern="yyyy/MM/dd" style="width:90px;"/>
                </span>
               </td>
               
        </tr>
    </table>
</fieldset>
    <fieldset>
        <legend>五、有关因素调查</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 26%"/>
                <col style="width: 24%"/>
                <col style="width: 25%"/>
                <col style="width: 25%"/>
            </colgroup>
            <tr>
                <th>1. 患者发病前2周曾到过何处？</th>
                <td colspan="3">
                     <input type="text" name="epidemiologicalSurvey.outHistoryAddr" value="${caseDto.epidemiologicalSurvey.outHistoryAddr}"
                               style="width: 200px;" reg='{"maxlength":"100"}'/>
                </td>
            </tr>
            <tr>
                <th>2. 病家共同生活在一起的人口数：</th>
                 <td colspan="3">
                           0-4岁<input type="text" name="epidemicFocusClose.zeroFour" value="${caseDto.epidemicFocusClose.zeroFour}"
                           style="width: 80px;text-align: center" reg='{"maxlength":"20"}'/>人,
                           5-9岁<input type="text" name="epidemicFocusClose.fiveNine" value="${caseDto.epidemicFocusClose.fiveNine}"
                           style="width: 80px;text-align: center" reg='{"maxlength":"20"}'/>人,
                           10-19岁<input type="text" name="epidemicFocusClose.ten" value="${caseDto.epidemicFocusClose.ten}"
                           style="width: 80px;text-align: center" reg='{"maxlength":"20"}'/>人,
                           20-29岁<input type="text" name="epidemicFocusClose.twenty" value="${caseDto.epidemicFocusClose.twenty}"
                           style="width: 80px;text-align: center" reg='{"maxlength":"20"}'/>人,
                           30-39岁<input type="text" name="epidemicFocusClose.thirty" value="${caseDto.epidemicFocusClose.thirty}"
                           style="width: 80px;text-align: center" reg='{"maxlength":"20"}'/>人,
                           40-49岁<input type="text" name="epidemicFocusClose.forty" value="${caseDto.epidemicFocusClose.forty}"
                           style="width: 80px;text-align: center" reg='{"maxlength":"20"}'/>人,
                           50-59岁<input type="text" name="epidemicFocusClose.fifty" value="${caseDto.epidemicFocusClose.fifty}"
                           style="width: 80px;text-align: center" reg='{"maxlength":"20"}'/>人,
                           60-69岁<input type="text" name="epidemicFocusClose.sixty" value="${caseDto.epidemicFocusClose.sixty}"
                           style="width: 80px;text-align: center" reg='{"maxlength":"20"}'/>人,
                           70岁以上<input type="text" name="epidemicFocusClose.aboveSeventy" value="${caseDto.epidemicFocusClose.aboveSeventy}"
                           style="width: 80px;text-align: center" reg='{"maxlength":"20"}'/>人。

                </td>
            </tr>
            <tr>
                <th>3．与病人共同生活在一起的家庭其他人患登革热（或不明原因发热病人）情况：</th>
                <td colspan="3">
                 	<input type="text" name="epidemicFocusClose.simSymptFamily" value="${caseDto.epidemicFocusClose.simSymptFamily}"
                           style="width: 200px;" reg='{"maxlength":"100"}'/>
                </td>
            </tr>
            <tr>
                <th>4. 发病处院内或周围环境：</th>
            </tr>
            <tr>
                <th>4.1. 积水容器数：</th>
                <td><input type="text" name="hygienicCondition.dropsyContainer" value="${caseDto.hygienicCondition.dropsyContainer}"
                           style="width: 80px;text-align: center" reg='{"maxlength":"20"}'/>个</td>
            </tr>
            <tr>
                <th>4.2. 阳性容器数：</th>

                <td><input type="text" name="hygienicCondition.positiveContainer" value="${caseDto.hygienicCondition.positiveContainer}"
                           style="width: 80px;text-align: center" reg='{"maxlength":"20"}'/>个</td>
            </tr>
            <tr>
                <th>4.3. 积水容器类型：</th>
                <td colspan="3"><ehr:dic-list name="hygienicCondition.containerType" dicmeta="IDM00099" value="${caseDto.hygienicCondition.containerType}"
                        onchange="toggleOtherSC('hygienicCondition.containerType','containerOther',99);"/>
                    <span id="containerOther" style="display: none">
                         <input type="text" name="hygienicCondition.containerOther" value="${caseDto.hygienicCondition.containerOther}"
                                reg='{"maxlength":"100"}' style="width: 150px;"/>
                    </span>
                </td>
            </tr>
            <tr>
                <th>5. 防蚊设备：</th>
                <td colspan="3"><ehr:dic-radio name="hygienicCondition.equipment" dicmeta="IDM00100" value="${caseDto.hygienicCondition.equipment}"
                        onchange="toggleOther('hygienicCondition.equipment','equipmentOther',99);"/>
                    <span id="equipmentOther" style="display: none">
                          <input type="text" name="hygienicCondition.equipmentOther" value="${caseDto.hygienicCondition.equipmentOther}"
                                 reg='{"maxlength":"100"}' style="width: 150px;"/>
                    </span>
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
