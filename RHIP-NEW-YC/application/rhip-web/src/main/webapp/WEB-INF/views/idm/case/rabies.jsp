<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/rabies.js" type="text/javascript"></script>
<c:if test="${isPrint != 1}">
<jsp:include page="caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
<div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
<i class="popno">
    狂犬病个案调查表<br/>
    <span>（乙类传染病）</span>
</i>

<input type="hidden" name="idmId" value="${idmId}" id="idmId"/>
<div class="postdiv">
<fieldset>
    <table class="posttable">
         <colgroup>
            <col style="width: 30%"/>
            <col style="width: 20%"/>
            <col style="width: 15%"/>
            <col style="width: 35%"/>
        </colgroup>
        <tr>
            <th>县（市）名称：</th>
            <td><label>${rootDicItem.itemName}</label></td>
            <th>国标码：</th>
            <td><input type="text" name="attackCondition.gbcode" value="${caseDto.attackCondition.gbcode}" reg='{"maxlength":"14"}'/></td>
        </tr>
        <tr>
            <th>病例编号：</th>
            <td colspan="3"><input type="text" name="attackCondition.medicalRecordNo" style="width: 160px;" value="${caseDto.attackCondition.medicalRecordNo }" reg='{"maxlength":"14"}'/>（病例编号填写说明：年号（两位数）、流水号（后边三位））</td>
        </tr>
    </table>
</fieldset>

<fieldset>
    <legend>1、一般情况</legend>
    <table class="posttable">
         <colgroup>
            <col style="width: 30%"/>
            <col style="width: 20%"/>
            <col style="width: 15%"/>
            <col style="width: 35%"/>
        </colgroup>
        <tr>
            <th>1.1姓名：</th>
            <td><input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name }" reg='{"maxlength":"100"}'/></td>
            <th>1.2性别：</th>
            <td><ehr:dic-list name="generalCondition.gender" dicmeta="GBT226112003" value="${caseDto.generalCondition.gender }" code="1,2"/></td>
        </tr>
        <tr>
            <th>1.3年龄：</th>
            <td><input type="text" name="generalCondition.age" value="${caseDto.generalCondition.age }" reg='{"maxlength":"6"}'/></td>
            <th>1.4职业：</th>
            <td><ehr:dic-list name="generalCondition.occupation" dicmeta="GBT6565" value="${caseDto.generalCondition.occupation }" 
            code="CV020120211,CV020120209,CV020120203,CV020120202,CV020120299"/><input type="text"
							name="generalCondition.occupationOther"
							value="${caseDto.generalCondition.occupationOther}"  reg='{"maxlength":"30"}' style="width:100px" id="occupationOther"/>
        </tr>
        <tr>
         	<th>1.5常住类型：</th>
         	<td>
   		<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
             		value="${caseDto.generalCondition.floatPopulation}" onchange="caseEdit.toggerAddress()"/>
         	</td>
         </tr>
		<tr>
			<th>1.6详细住址：</th>
	                    <td colspan="3">
                            <ehr:dic-town-street-village streetId="pastreet_address" townId="patown_address" streetName="generalCondition.pastreet" townName="generalCondition.patownShip"
                                                         streetValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="140px;"
                                                         villageId="pavillage_address" villageName="generalCondition.paGroup" villageValue="${caseDto.generalCondition.paGroup}"/>
                            <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
	                               reg='{"maxlength":"50"}'  style="width: 180px;">
	                    	<span id="spanPaNumber">(门牌号)</span>
	                    </td>
		</tr>
    </table>
</fieldset>
<fieldset>
    <legend>2、暴露（被伤）及伤口处理情况</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 30%"/>
            <col style="width: 20%"/>
            <col style="width: 15%"/>
            <col style="width: 35%"/>
        </colgroup>
        <tr>
            <th>2.1暴露（被伤）日期：</th>
            <td><tag:dateInput id="exposureDt" name="exposureHistory.exposureDt" pattern="yyyy/MM/dd HH" date="${caseDto.exposureHistory.exposureDt }" onlypast="true"/>时
            	<input type="hidden" id="exposureHour" name="exposureHistory.exposureHour">
            </td>
        </tr>
        <tr>
            <th>2.2暴露详细地址：</th>
            <td colspan="3">
                <ehr:dic-town-street-village streetId="street_address" townId="town_address" streetName="exposureHistory.addrVillage" townName="exposureHistory.addrRural"
                                             streetValue="${caseDto.exposureHistory.addrVillage}" townValue="${caseDto.exposureHistory.addrRural}" width="140px;"
                villageId="village_address" villageName="exposureHistory.addrCity" villageValue="${caseDto.exposureHistory.addrCity}"/>
                            <input type="text" id="addrGroup" name="exposureHistory.addrGroup" reg='{"maxlength":"30"}'
                                   value="${caseDto.exposureHistory.addrGroup}" placeholder="门牌号" style="width: 180px;">
            </td>
        </tr>
        <tr>
            <th>2.3暴露方式：</th>
            <td><ehr:dic-list name="exposureHistory.exposureWay" dicmeta="IDM00157" value="${caseDto.exposureHistory.exposureWay }"/> <input type="text" id="exposureWayOther" name="exposureHistory.exposureWayOther" value="${caseDto.exposureHistory.exposureWayOther }" reg='{"maxlength":"20"}'/></td>
            <th>2.4暴露程度：</th>
            <td><ehr:dic-list name="exposureHistory.exposureLevel" dicmeta="IDM00158" value="${caseDto.exposureHistory.exposureLevel }"/></td>
        </tr>
        <tr>
            <th>2.5暴露部位（可多选）：</th>
            <td colspan="3"><ehr:dic-checkbox dicmeta="IDM00159" name="exposureHistory.exposurePart" value="${caseDto.exposureHistory.exposurePart }"></ehr:dic-checkbox></td>
            
        </tr>
        <tr>
        	<th>2.6伤口处理<span id="idmWoundManagement">（如未处理转至3）</span>：</th>
            <td><ehr:dic-list name="exposureHistory.woundManagement" dicmeta="IDM00160" value="${caseDto.exposureHistory.woundManagement }"/></td>
        </tr>
        <tr class="wound">
            <th>2.6.1处理时间：</th>
            <td><tag:dateInput id="handlingTime" name="exposureHistory.handlingTime" pattern="yyyy/MM/dd HH" date="${caseDto.exposureHistory.handlingTime }" onlypast="true"/>时
            	<input type="hidden" id="handlingHour" name="exposureHistory.handlingHour">
            </td>
            <th>2.6.2处理单位：</th>
            <td><ehr:dic-list name="exposureHistory.handlingUnit" dicmeta="IDM00161" value="${caseDto.exposureHistory.handlingUnit }"/><input type="text" name="exposureHistory.handlingUnitOther" value="${caseDto.exposureHistory.handlingUnitOther }" style="width:100px" id="handlingUnit" reg='{"maxlength":"100"}'/></td>
        </tr>
        <tr class="wound">
            <th>2.6.3处理方式（可多选）：</th>
            <td colspan="3"><ehr:dic-checkbox name="exposureHistory.handlingWay" dicmeta="IDM00162" value="${caseDto.exposureHistory.handlingWay }"/><input type="text" id="idmHandlingWayOther" name="exposureHistory.handlingWayOther" value="${caseDto.exposureHistory.handlingWayOther }" reg='{"maxlength":"100"}'/></td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>3、预防注射</legend>
    <table class="posttable">
         <colgroup>
            <col style="width: 30%"/>
            <col style="width: 20%"/>
            <col style="width: 15%"/>
            <col style="width: 35%"/>
        </colgroup>
        <tr>
            <th>3.1暴露免疫史：</th>
            <td><ehr:dic-radio name="exposureHistory.immunizationHistory" dicmeta="PH00002" code="1,2" value="${caseDto.exposureHistory.immunizationHistory }"/></td>
        	<td></td>
        	<td></td>
        </tr>
        <tr class="immunizationHistory" style="display: none;">
            <th>免疫时间：</th>
            <td><tag:dateInput name="exposureHistory.immunizationDt" pattern="yyyy/MM/dd" date="${caseDto.exposureHistory.immunizationDt }"/></td>
            <th>免疫针次：</th>
            <td><input type="text" name="exposureHistory.immunizationHistoryNum" value="${caseDto.exposureHistory.immunizationHistoryNum}" reg='{"maxlength":"20"}'/> 针</td>
        </tr>
        <tr>
            <th>3.2暴露后抗血清注射<span id="idmAntiserumInjection">（转至3.3）</span>：</th>
            <td><ehr:dic-radio name="exposureHistory.antiserumInjection" dicmeta="PH00002" code="1,2" value="${caseDto.exposureHistory.antiserumInjection }"/></td>
        </tr>
        <tr class="antiserumInjection">
            <th>3.2.1种类：</th>
            <td><ehr:dic-radio name="exposureHistory.antiserumInjectionCategory" dicmeta="IDM00163" value="${caseDto.exposureHistory.antiserumInjectionCategory }"/></td>
            <th>3.2.2注射时间：</th>
            <td><tag:dateInput name="exposureHistory.antiserumInjectionDt" pattern="yyyy/MM/dd" date="${caseDto.exposureHistory.antiserumInjectionDt }"></tag:dateInput></td>
        </tr>
        <tr class="antiserumInjection">
            <th>3.2.3注射剂量：</th>
            <td><input type="text" name="exposureHistory.antiserumInjectionMeasure" value="${caseDto.exposureHistory.antiserumInjectionMeasure }" reg='{"maxlength":"20"}'/></td>
        </tr>
        <tr class="antiserumInjection">
        <th>3.2.4有无过敏：</th>
            <td><ehr:dic-radio name="exposureHistory.irritability" dicmeta="PH00002" code="1,2" value="${caseDto.exposureHistory.irritability }"/></td>
            <th class="irritabilityDetail">过敏表现：</th>
            <td class="irritabilityDetail"><input type="text" name="exposureHistory.irritabilityDetail" value="${caseDto.exposureHistory.irritabilityDetail }" reg='{"maxlength":"100"}'/></td>
        </tr>
        <tr>
            <th>3.3暴露后人用狂犬病疫苗注射<span id="idmRabiesVaccination">（转至4）</span>：</th>
            <td><ehr:dic-radio name="exposureHistory.rabiesVaccination" dicmeta="PH00002" code="1,2" value="${caseDto.exposureHistory.rabiesVaccination }"/></td>
        </tr>
        <tr class="rabiesVaccination">
            <th>3.3.1注射单位：</th>
            <td><ehr:dic-list name="exposureHistory.rabiesVaccinationUnit" dicmeta="IDM00161" value="${caseDto.exposureHistory.rabiesVaccinationUnit }"/><input type="text" id="rabiesVaccinationUnitOther"
                                                                                      name="exposureHistory.rabiesVaccinationUnitOther" value="${caseDto.exposureHistory.rabiesVaccinationUnitOther }" style="width:100px" reg='{"maxlength":"100"}'/>
            </td>
            <th>3.3.2 种类：</th>
            <td><ehr:dic-radio name="exposureHistory.rabiesVaccinationCategory" dicmeta="IDM00164" value="${caseDto.exposureHistory.rabiesVaccinationCategory }"/></td>
        </tr>
        <tr class="rabiesVaccination">
            <th>3.3.3首针时间：</th>
            <td><tag:dateInput id="rabiesVaccinationDtF" name="exposureHistory.rabiesVaccinationDtF" pattern="yyyy/MM/dd HH" date="${caseDto.exposureHistory.rabiesVaccinationDtF }" onlypast="true"/>时
            	<input type="hidden" id="rabiesVaccinationHourF" name="exposureHistory.rabiesVaccinationHourF"/>
            </td>
            <th>首针剂量：</th>
            <td><ehr:dic-radio name="exposureHistory.rabiesVaccinationMeasureF" dicmeta="IDM00165" value="${caseDto.exposureHistory.rabiesVaccinationMeasureF }"/></td>
        </tr>
        <tr class="rabiesVaccination">
            <th>3.3.4免疫程序：</th>
            <td colspan="2"><ehr:dic-radio name="exposureHistory.immuneProcedure" dicmeta="IDM00536" value="${caseDto.exposureHistory.immuneProcedure }" 
            		onchange="toggleOther('exposureHistory.immuneProcedure','immuneProcedureOtherDiv',2);"/>
	            <span id="immuneProcedureOtherDiv" style="display:none;">
	            	<input type="text" style="width:100px;" name="exposureHistory.immuneProcedureOther" value="${caseDto.exposureHistory.immuneProcedureOther }" reg='{"maxlength":"100"}'/>
	            </span>
            </td>
        </tr>
        <tr class="rabiesVaccination">
            <th>3.3.5疫苗注射：</th>
            <td><input type="text" name="exposureHistory.rabiesVaccinationNum" value="${caseDto.exposureHistory.rabiesVaccinationNum }" reg='{"maxlength":"20"}'/>针次</td>
            <th>如未全程，原因：</th>
            <td><input type="text" name="exposureHistory.rabiesVaccinationUndo" value="${caseDto.exposureHistory.rabiesVaccinationUndo }" reg='{"maxlength":"100"}'/></td>
        </tr>
        <tr class="rabiesVaccination">
            <th>3.3.6是否加强注射：</th>
            <td><ehr:dic-radio name="exposureHistory.rabiesVaccinationReinforced" dicmeta="PH00001" code="1,2" value="${caseDto.exposureHistory.rabiesVaccinationReinforced }"/></td>
            <th class="rabiesVaccinationReinforced">加强针次：</th>
            <td class="rabiesVaccinationReinforced"><input type="text" name="exposureHistory.reinforcedNum" value="${caseDto.exposureHistory.reinforcedNum }" reg='{"maxlength":"20"}'/>针</td>
        </tr>
        <tr class="rabiesVaccination">
            <th>3.3.7疫苗生产单位：</th>
            <td><input type="text" name="exposureHistory.reinforcedUnit" value="${caseDto.exposureHistory.reinforcedUnit }" reg='{"maxlength":"100"}'/></td>
            <th>批号：</th>
            <td><input type="text" name="exposureHistory.reinforcedBatch" value="${caseDto.exposureHistory.reinforcedBatch }" reg='{"maxlength":"50"}'/></td>
        </tr>
        <tr class="rabiesVaccination">
            <th>失效期：</th>
            <td><tag:dateInput name="exposureHistory.rabiesVaccinationExpDt" pattern="yyyy/MM/dd" date="${caseDto.exposureHistory.rabiesVaccinationExpDt }"/></td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>4、临床资料</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 30%"/>
            <col style="width: 20%"/>
            <col style="width: 15%"/>
            <col style="width: 35%"/>
        </colgroup>
        <tr>
            <th>4.1发病时间：</th>
            <td><tag:dateInput id="pathogenesisDate" name="attackCondition.pathogenesisDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.pathogenesisDate }" reg='{"compare":["dieDt","le","发病时间不能晚于死亡时间"]}'/></td>
            <th>4.2 死亡时间：</th>
            <td><tag:dateInput id="dieDt" name="attackCondition.dieDt" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.dieDt }" reg='{"compare":["dieDt","ge","死亡时间不能早于发病时间"]}'/></td>
        </tr>
        <tr>
            <th>4.3诊断单位：</th>
            <td><ehr:dic-list name="clinicalManifestations.orgDiagnosticsSelect" dicmeta="IDM00161" value="${caseDto.clinicalManifestations.orgDiagnosticsSelect }"/><input type="text"
                                                                                     name="clinicalManifestations.orgDiagnosticsWrite" value="${caseDto.clinicalManifestations.orgDiagnosticsWrite }" style="width:150px" id="orgDiagnosticsWrite" reg='{"maxlength":"100"}'/></td>
            <th>4.4发病临床症状：</th>
            <td><ehr:dic-checkbox name="clinicalManifestations.diseaseClinicalSymptoms" dicmeta="IDM00166" value="${caseDto.clinicalManifestations.diseaseClinicalSymptoms }"/></td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>5、实验室检测</legend>
    <table class="posttable">
       <colgroup>
            <col style="width: 30%"/>
            <col style="width: 20%"/>
            <col style="width: 15%"/>
            <col style="width: 35%"/>
        </colgroup>
        <tr>
            <th>5.1采样时间：</th>
            <td><tag:dateInput name="labExamine.routineBloodDate" pattern="yyyy/MM/dd" date="${caseDto.labExamine.routineBloodDate }"/></td>
            <th>5.2标本种类：</th>
            <td><ehr:dic-list name="labExamine.sampleClass" dicmeta="IDM00167" value="${caseDto.labExamine.sampleClass }"/></td>
        </tr>
        <tr>
            <th>5.3检测项目：</th>
            <td><ehr:dic-radio dicmeta="IDM00168" name="labExamine.testItem" value="${caseDto.labExamine.testItem }"/></td>
            <th>5.4检测结果：</th>
            <td><ehr:dic-radio dicmeta="PH00004" name="labExamine.testResult" code="1,2" value="${caseDto.labExamine.testResult }"/></td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>6、伤人动物情况</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 30%"/>
            <col style="width: 20%"/>
            <col style="width: 15%"/>
            <col style="width: 35%"/>
        </colgroup>
        <tr>
            <th>6.1动物种类：</th>
            <td><ehr:dic-radio name="infectionSourceRoute.animalCategory" dicmeta="IDM00169" value="${caseDto.infectionSourceRoute.animalCategory }"/><input type="text" name="infectionSourceRoute.animalCategoryOther" value="${caseDto.infectionSourceRoute.animalCategoryOther }" style="width:150px" id="animalCategoryOther" reg='{"maxlength":"20"}'/>
            </td>
            <th>6.2伤人动物来源：</th>
            <td>
            	<ehr:dic-list name="infectionSourceRoute.animalSource" dicmeta="IDM00170" value="${caseDto.infectionSourceRoute.animalSource }"/>
            	<input type="text" name="infectionSourceRoute.animalOther" value="${caseDto.infectionSourceRoute.animalOther }" id="animalOther" style="width:150px" reg='{"maxlength":"50"}'/>
            </td>
        </tr>
        <tr>
            <th>6.3若为家养动物，是否接种兽用狂犬病疫苗：</th>
            <td><ehr:dic-radio name="infectionSourceRoute.hydrophobiaVaccine" dicmeta="PH00001" code="1,2" value="${caseDto.infectionSourceRoute.hydrophobiaVaccine }"/></td>
            <th class='hydrophobiaVaccineDt'>接种日期：</th>
            <td class='hydrophobiaVaccineDt'><tag:dateInput name="infectionSourceRoute.hydrophobiaVaccineDt" pattern="yyyy/MM/dd" date="${caseDto.infectionSourceRoute.hydrophobiaVaccineDt }"/></td>
        </tr>
        <tr>
            <th>6.4动物伤人原因：</th>
            <td><ehr:dic-list name="infectionSourceRoute.woundCause" dicmeta="IDM00171" value="${caseDto.infectionSourceRoute.woundCause }"/><input type="text" name="infectionSourceRoute.woundCauseOther" value="${caseDto.infectionSourceRoute.woundCauseOther }" style="width:150px" id='woundCauseOther' reg='{"maxlength":"100"}'/></td>
            <th>6.5是否同时咬伤多人：</th>
            <td><ehr:dic-radio name="infectionSourceRoute.meanwhileBiteMany" dicmeta="PH00001" code="1,2" value="${caseDto.infectionSourceRoute.meanwhileBiteMany }"/></td>
        </tr>
        <tr>
            <th>6.6伤人后：</th>
            <td colspan="3"><ehr:dic-radio name="infectionSourceRoute.afterWounding" dicmeta="IDM00172" value="${caseDto.infectionSourceRoute.afterWounding}"
            						onchange="rabies.toggleOnes('infectionSourceRoute.afterWounding','afterWoundingDiv','2,3,4,5,99');"/>
            						<%-- <input type="text" name="infectionSourceRoute.afterWoundingOther" value="${caseDto.infectionSourceRoute.afterWoundingOther }" style="width:150px" id="afterWoundingOther" reg='{"maxlength":"100"}'"/> --%>
            </td>
        </tr>
        <tr id="afterWoundingDiv" style="display:none;">
            <th>6.6.1死亡时间：</th>
            <td><tag:dateInput name="infectionSourceRoute.afterWoundingDieDt" pattern="yyyy/MM/dd" date="${caseDto.infectionSourceRoute.afterWoundingDieDt }"/></td>
            <th>6.6.2动物死后处理方式：</th>
            <td><ehr:dic-list name="infectionSourceRoute.afterDeathWay" dicmeta="IDM00173" value="${caseDto.infectionSourceRoute.afterDeathWay }"/>
            <%-- <input type="text" name="infectionSourceRoute.afterDeathWayOther" value="${caseDto.infectionSourceRoute.afterDeathWayOther }" id="afterDeathWayOther" style="width:150px" reg='{"maxlength":"20"}'/> --%>
            </td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>7、如为一犬伤多人</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 30%"/>
            <col style="width: 20%"/>
            <col style="width: 15%"/>
            <col style="width: 35%"/>
        </colgroup>
        <tr>
            <th>7.1共伤：</th>
            <td><input type="text" name="infectionSourceRoute.biteTotal" value="${caseDto.infectionSourceRoute.biteTotal }" reg='{"maxlength":"20"}'/>人</td>
            <th>7.2本例为第：</th>
            <td><input type="text" name="infectionSourceRoute.whatBite" value="${caseDto.infectionSourceRoute.whatBite }" reg='{"maxlength":"20"}'/>例次</td>
        </tr>
        <tr>
            <th>7.3共死亡：</th>
            <td><input type="text" name="infectionSourceRoute.dieTotal" value="${caseDto.infectionSourceRoute.dieTotal }" reg='{"maxlength":"20"}'/>人</td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <table class="posttable">
        <colgroup>
            <col style="width: 30%"/>
            <col style="width: 20%"/>
            <col style="width: 15%"/>
            <col style="width: 35%"/>
        </colgroup>
        <tr>
            <th>被调查人与患者关系：</th>
            <td><input type="text" name="caseInformation.informantPatienRel" value="${caseDto.caseInformation.informantPatienRel }" reg='{"maxlength":"20"}'/></td>
            <th> 调查人签名：</th>
            <td>
                <ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"></ehr:user>
                <input type="hidden" name="caseInformation.modifyRespondents" value="${caseDto.caseInformation.modifyRespondents}"/>
            </td>
        </tr>
        <tr>
            <th>调查人单位：</th>
            <td><ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"></ehr:org>
            <input type="hidden" name="caseInformation.modifySurveyOrg" value="${caseDto.caseInformation.modifySurveyOrg}"/>
            </td>
            <th>调查日期：</th>
            <td><tag:dateInput nullToToday="true" name="caseInformation.modifySurveyDate"
								pattern="yyyy/MM/dd"
								date="${caseDto.caseInformation.modifySurveyDate}" /></td>
        </tr>
         <tr>     
            <th>填表日期：</th>
            <td><tag:dateInput nullToToday="true" name="caseInformation.caseFillDate"
								pattern="yyyy/MM/dd"
								date="${caseDto.caseInformation.caseFillDate}" /></td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>填表说明</legend>
    <dl>
        <dd>1.在所选项目前的“□”中，划“∨”作为选择答案，若无特殊说明，所有选项均为单选。凡有“____”的选项，须填写相应内容；</dd>
        <dd>2.病例编号填写规定：年号（两位数）、流水号（后边三位）</dd>
        <dt>3.“2.4暴露程度”参照WHO建议分类标准分为以下三类：</dt>
        <dd>
            Ⅰ度：被犬舔过无开放性伤口的健康皮肤和粘膜；</br>
            Ⅱ度：裸露的皮肤或粘膜被轻轻咬过，表面划伤，但没有破口；</br>
            Ⅲ度：任何部位的皮肤或粘膜，一处或多处被咬破或抓穿。
        </dd>
    </dl>
</fieldset>
</div>
</div>
</form>
