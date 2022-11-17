<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="${pageContext.request.contextPath}/js/views/idm/malaria/caseEdit.js" type="text/javascript"></script>

<div class="toolbar">
    <div class="toolbar" style="background: none">
        <a href="javascript:malariaCase.returnSearch()" id="cancelContact"><b class="fanhui">返回</b></a>
        <c:if test="${malariaDto.specialStatus == 3 && type !='view' && logoff != '1'}">
            <a href="javascript:malariaCaseEdit.caseSubmit(1)"><b class="baocun">保存</b></a>
        </c:if>
        <c:if test="${malariaDto.specialStatus == 4 && type !='view' && logoff != '1'}">
            <%--<a href="javascript:malariaCaseEdit.caseSubmit(2)"><b class="xiug">修改</b></a>--%>
            <a href="javascript:malariaCaseEdit.caseSubmit(2)"><b class="baocun">保存</b></a>
        </c:if>
</div>

</div>
<form id="caseForm">
	<div class="postcontent" >
		<i class="popno" style="height: auto;padding-top: 10px;"> 疟疾病例个案流行病学调查表
		</i>
		<input type="hidden" name="singleId" value="${malariaDto.singleId}"/>
        <input type="hidden" name="idmId" value="${malariaDto.idmId}"/>
        <input type="hidden" name="eventId" value="${malariaDto.eventId}"/>
        <input type="hidden" id="type" value="${type}"/>
        <input type="hidden" id="logoff" value="${logoff}"/>
		<div class="postdiv">
            <table  class="posttable" >
                <colgroup>
                    <col style="width: 50%;"/>
                    <col style="width: 50%;"/>
                </colgroup>
                <tr style="text-align: right">
                    <td>卡片编号：<input type="text" name="caseInformation.mediRecordNum" style="width: 120px;"
                                   value="${malariaDto.caseInformation.mediRecordNum}" reg='{"maxlength":"50"}'/></td>
                </tr>
            </table>
			<fieldset>
				<legend>一般情况</legend>
				<table class="posttable">
                    <colgroup>
                        <col style="width: 23%" />
                        <col style="width: 27%" />
                        <col style="width: 23%" />
                        <col style="width: 27%" />
                    </colgroup>
					<tr>
						<th>姓名：</th>
						<td>
                            <input type="text" name="generalCondition.name" value="${malariaDto.generalCondition.name}"
                                   reg='{"maxlength":"50"}'/>
                        </td>
                        <th>身份证号：</th>
                        <td>
                            <input type="text" name="generalCondition.idcard" value="${malariaDto.generalCondition.idcard}"
                                   reg='{"idCard":"idCard"}'/>
                        </td>
					</tr>
                    <tr>
                        <th>户主姓名：</th>
                        <td>
                            <input type="text" name="generalCondition.headHouseholdName" value="${malariaDto.generalCondition.headHouseholdName}" reg='{"maxlength":"50"}'/>
                        </td>
                        <th>联系电话：</th>
                        <td>
                            <input type="text" name="generalCondition.phoneNumber" value="${malariaDto.generalCondition.phoneNumber}" reg='{"regex":"phone"}'/>
                        </td>
                    </tr>
					<tr>
						<th>性别：</th>
						<td><ehr:dic-radio id="gender" name="generalCondition.gender"
                                           dicmeta="GBT226112003" value="${malariaDto.generalCondition.gender}" code="1,2" /></td>
                        <th>年龄：</th>
                        <td><input type="text" name="generalCondition.age" value="${malariaDto.generalCondition.age}" reg='{"maxlength":"20"}'></td>
					</tr>
					<tr>
						<th>职业：</th>
                        <td>
                            <ehr:dic-list dicmeta="GBT6565" name="generalCondition.occupation" width="140px;" value="${malariaDto.generalCondition.occupation}"
                                          code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120299"
                                          onchange="toggleOtherSC('generalCondition.occupation','occupationPart','CV020120299');"/>
                            <span  id="occupationPart" style="display: none">
                                <input type="text" name="generalCondition.occupationOther" value="${malariaDto.generalCondition.occupationOther}"
                                       reg='{"maxlength":"100"}' style="width: 100px;"/>
                            </span>
                        </td>
                        <th>文化程度：</th>
                        <td>
                            <ehr:dic-list name="generalCondition.education" dicmeta="GBT46582006" code="IDM01,IDM02,IDM03,IDM04,IDM05"
                                   value="${malariaDto.generalCondition.education}"/>
                        </td>
					</tr>
                    <tr>
                        <th>常住类型：</th>
                        <td>
                            <ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
                                           value="${malariaDto.generalCondition.floatPopulation}" onchange="idmCommon.toggerAddress()"/>
                        </td>
                    </tr>
                    <tr>
                        <th>户口所在地：</th>
                        <td colspan="3">
                            <ehr:dic-town-village villageId="hrvillage_address" townId="hrtown_address" villageName="generalCondition.hrstreet" townName="generalCondition.hrtownShip"
                                                  villageValue="${malariaDto.generalCondition.hrstreet}" townValue="${malariaDto.generalCondition.hrtownShip}" width="180px;"/>
                            <label id="tempHrValue">
                                <ehr:dic code="${malariaDto.generalCondition.hrtownShip}" dicmeta="FS990001"/><ehr:dic code="${malariaDto.generalCondition.hrstreet}" dicmeta="FS990001"/>
                            </label>
                            <input type="text" name="generalCondition.hrhouseNumber" id="hrhouseNumber" value="${malariaDto.generalCondition.hrhouseNumber}"
                                   style="width: 150px;" reg='{"maxlength":"50"}'>
                            <span id="spanHrNumber">(门牌号)</span>
                        </td>
                    </tr>
                    <tr>
                        <th>现住址：</th>
                        <td colspan="3">
                            <ehr:dic-town-village villageId="pavillage_address" townId="patown_address" villageName="generalCondition.pastreet" townName="generalCondition.patownShip"
                                                  villageValue="${malariaDto.generalCondition.pastreet}" townValue="${malariaDto.generalCondition.patownShip}" width="180px;"/>
                            <label id="tempPaValue">
                                <ehr:dic code="${malariaDto.generalCondition.patownShip}" dicmeta="FS990001"/><ehr:dic code="${malariaDto.generalCondition.pastreet}" dicmeta="FS990001"/>
                            </label>
                            <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${malariaDto.generalCondition.pahouseNumber}"
                                   reg='{"maxlength":"50"}'  style="width: 150px;">
                            <span id="spanPaNumber">(门牌号)</span>
                        </td>
                    </tr>

					<tr>
						<th>家中有无防蚊设施：</th>
						<td colspan="3"><ehr:dic-checkbox name="hygienicCondition.equipment" dicmeta="IDM00100"
                                                       value="${malariaDto.hygienicCondition.equipment}"/></td>
					</tr>
                    <tr>
                    	<th>是否有使用蚊帐习惯：</th>
                    	<td>
		            		<ehr:dic-radio name="hygienicCondition.mosquitoNet" dicmeta="PH00001" code="1,2"
                        		value="${malariaDto.hygienicCondition.mosquitoNet}"/>
                    	</td>
                        <th>是否有露宿习惯：</th>
                        <td>
                            <ehr:dic-radio name="hygienicCondition.sleepOpen" dicmeta="PH00001" code="1,2"
                                           value="${malariaDto.hygienicCondition.sleepOpen}"/>
                        </td>
                    </tr>					
				</table>
			</fieldset>
		</div>
		<div class="postdiv">
			<fieldset>
				<legend>发病情况</legend>
				<table class="posttable">
                    <colgroup>
                        <col style="width: 23%" />
                        <col style="width: 27%" />
                        <col style="width: 23%" />
                        <col style="width: 27%" />
                    </colgroup>
					<tr>
						<th>发病地点是否国外：</th>
                        <td>
                            <ehr:dic-radio name="attackCondition.pathogenesisPlaceSelect" dicmeta="PH00001" code="1,2" value="${malariaDto.attackCondition.pathogenesisPlaceSelect}"
                                    onchange="toggleOther('attackCondition.pathogenesisPlaceSelect','outPlace',1);
                                    toggleOther('attackCondition.pathogenesisPlaceSelect','inPlace',2);"/>
                        </td>
					</tr>
                    <tr  id="inPlace" style="display: none">
                        <th>国内发病地点：</th>
                        <td><input type="text" name="attackCondition.pathogenesisPlace" value="${malariaDto.attackCondition.pathogenesisPlace}" reg='{"maxlength":"100"}'></td>
                    </tr>
                    <tr id="outPlace" style="display: none">
                        <th>国外发病地点：</th>
                        <td><input type="text" name="attackCondition.foreignAddr" value="${malariaDto.attackCondition.foreignAddr}" reg='{"maxlength":"100"}'></td>
                    <tr>
                        <th>发病日期：</th>
                        <td><tag:dateInput id="pathogenesisDateId" name="attackCondition.pathogenesisDate" onlypast="true" date="${malariaDto.attackCondition.pathogenesisDate}"/></td>
                        <th>初诊日期：</th>
                        <td><tag:dateInput id="firstVisitDateId" name="attackCondition.firstVisitDate" onlypast="true" date="${malariaDto.attackCondition.firstVisitDate}"/></td>
                    </tr>
                    <tr>
                        <th>初诊单位：</th>
                        <td>
                            <ehr:dic-list name="attackCondition.firstVisitUnit" dicmeta="IDM00261" value="${malariaDto.attackCondition.firstVisitUnit}"
                                    onchange="toggleOtherSC('attackCondition.firstVisitUnit','firstVisitUnitOther',99);"/>
                            <span id="firstVisitUnitOther">
                                <input type="text" name="attackCondition.firstVisitUnitOther" value="${malariaDto.attackCondition.firstVisitUnitOther}" style="width: 100px;" reg='{"maxlength":"100"}'>
                            </span>
                        </td>
                        <th>主要临床表现：</th>
                        <td>
                            <ehr:dic-list name="attackCondition.clinicalManifestation" dicmeta="IDM00262" value="${malariaDto.attackCondition.clinicalManifestation}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>本次发病诊断方式：</th>
                        <td>
                            <ehr:dic-list name="attackCondition.thisDiagnosisType" dicmeta="CV0501014" value="${malariaDto.attackCondition.thisDiagnosisType}"
                                    onchange="toggleOtherSC('attackCondition.thisDiagnosisType','thisDiagnosisTypeOther',9);"/>
                            <span id="thisDiagnosisTypeOther" style="display: none">
                                <input type="text" name="attackCondition.thisDiagnosisTypeOther" value="${malariaDto.attackCondition.thisDiagnosisTypeOther}"
                                       reg='{"maxlength":"100"}' style="width: 100px;">
                            </span>
                        </td>
                        <th>血检疟原虫日期：</th>
                        <td>
                            <tag:dateInput id="plasmodiumDtId" name="labExamine.plasmodiumDt" onlypast="true" date="${malariaDto.labExamine.plasmodiumDt}"/>
                        </td>
                    </tr>
					<tr>
						<th>镜检/RDT结果：</th>
						<td>
                            <ehr:dic-list name="labExamine.rdt" dicmeta="IDM00263" value="${malariaDto.labExamine.rdt}"/>
						</td>
                        <th>本次发病是：</th>
                        <td>
                            <ehr:dic-list name="attackCondition.pathogenesisType" dicmeta="IDM00264" value="${malariaDto.attackCondition.pathogenesisType}"/>
                        </td>
					</tr>
					<tr>
						<th>病情程度：</th>
                        <td><ehr:dic-list name="attackCondition.illnesDegree" dicmeta="IDM00265" value="${malariaDto.attackCondition.illnesDegree}"/></td>
                        <th>并发症：</th>
                        <td>
                            <ehr:dic-radio name="clinicalManifestations.isComplications" dicmeta="PH00001" code="1,2" value="${malariaDto.clinicalManifestations.isComplications}"
                                    onchange="toggleOther('clinicalManifestations.isComplications','complications',1);"/>
                            <span id="complications" style="display: none">
                                <input type="text" name="clinicalManifestations.complications" value="${malariaDto.clinicalManifestations.complications}"
                                       reg='{"maxlength":"200"}' style="width: 120px;">
                            </span>
                        </td>
					</tr>
					<tr>
                        <th>病例是否死亡：</th>
                        <td>
                            <ehr:dic-radio name="diagnosis.caseDie" dicmeta="PH00001" code="1,2" value="${malariaDto.diagnosis.caseDie}"/>
                        </td>
                    </tr>
				</table>
			</fieldset>
		</div>

		<div class="postdiv">
			<fieldset>
				<legend>治疗情况</legend>
				<table class="posttable">
                    <colgroup>
                        <col style="width: 23%" />
                        <col style="width: 27%" />
                        <col style="width: 23%" />
                        <col style="width: 27%" />
                    </colgroup>
					<tr>
						<th>治疗药物名称：</th>
						<td>
                            <input type="text" name="otherCondition.antibacterials" value="${malariaDto.otherCondition.antibacterials}" reg='{"maxlength":"100"}'>
						</td>
					</tr>
					<tr>
						<th>是否全程足量（正规）治疗：</th>
						<td>
                            <ehr:dic-radio name="otherCondition.wholeTreat" dicmeta="PH00001" code="1,2" value="${malariaDto.otherCondition.wholeTreat}"/>
                        </td>
                        <th>住院治疗：</th>
                        <td>
                            <ehr:dic-radio name="otherCondition.inpatientFlg" dicmeta="PH00001" code="1,2" value="${malariaDto.otherCondition.inpatientFlg}"/>
                        </td>
					</tr>
				</table>
			</fieldset>
		</div>


        <div class="postdiv">
            <fieldset>
                <legend>既往病史情况</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 23%" />
                        <col style="width: 27%" />
                        <col style="width: 23%" />
                        <col style="width: 27%" />
                    </colgroup>
                    <tr>
                        <th>曾患疟疾次数：</th>
                        <td colspan="3">
                            <input type="text" name="pastHistory.agueNum" value="${malariaDto.pastHistory.agueNum}" style="width: 120px;" reg='{"maxlength":"20"}'>
                            （如为“0”请直接跳至"近一月内家中是否有亲友来访"）
                        </td>
                    </tr>
                    <tr>
                        <th>最近一次患疟疾时间：</th>
                        <td>
                            <tag:dateInput id="lastDt" name="pastHistory.lastDt" pattern="yyyy/MM" onlypast="true" date="${malariaDto.pastHistory.lastDt}"/>
                        </td>
                        <th>发病地点是否国外：</th>
                        <td>
                            <ehr:dic-radio name="pastHistory.isForeign" dicmeta="PH00001" code="1,2" value="${malariaDto.pastHistory.isForeign}"
                                    onchange="toggleOther('pastHistory.isForeign','attackOut',1);
                                    toggleOther('pastHistory.isForeign','attackIn',2);"/>
                        </td>
                    </tr>
                    <tr id="attackIn" style="display: none">
                        <th>国内发病地点：</th>
                        <td>
                            <input type="text" name="pastHistory.attackAddr" value="${malariaDto.pastHistory.attackAddr}">
                        </td>
                    </tr>
                    <tr id="attackOut" style="display: none">
                        <th>国外发病地点：</th>
                        <td>
                            <input type="text" name="pastHistory.foreignAddr" value="${malariaDto.pastHistory.foreignAddr}" reg='{"maxlength":"100"}'>
                        </td>
                    </tr>
                    <tr>
                        <th>当时抗疟治疗药品：</th>
                        <td>
                            <ehr:dic-list name="pastHistory.agueDrug" dicmeta="IDM00266" value="${malariaDto.pastHistory.agueDrug}"
                                    onchange="toggleOtherSC('pastHistory.agueDrug','agueDrugOther',99);"/>
                            <span id="agueDrugOther" style="display: none">
                                <input type="text" name="pastHistory.agueDrugOther" value="${malariaDto.pastHistory.agueDrugOther}" style="width: 100px;">
                            </span>
                        </td>
                        <th>治疗时间：</th>
                        <td>
                            <tag:dateInput id="lastTreatDt" name="pastHistory.lastTreatDt" pattern="yyyy/MM" date="${malariaDto.pastHistory.lastTreatDt}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>治疗地点：</th>
                        <td><input type="text" name="pastHistory.lastTreatProvince" value="${malariaDto.pastHistory.lastTreatProvince}" reg='{"maxlength":"100"}'></td>
                    </tr>
                    <tr>
                        <th>当时治疗是否全程足量（正规）：</th>
                        <td>
                            <ehr:dic-radio name="pastHistory.wholeTreat" dicmeta="PH00001" code="1,2" value="${malariaDto.pastHistory.wholeTreat}"/>
                        </td>
                        <th>是否进行休根治疗</th>
                        <td>
                            <ehr:dic-radio name="pastHistory.rest" dicmeta="PH00001" code="1,2" value="${malariaDto.pastHistory.rest}"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </div>

        <div class="postdiv">
            <fieldset>
                <legend>传染源及传播途径</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 23%" />
                        <col style="width: 27%" />
                        <col style="width: 23%" />
                        <col style="width: 27%" />
                    </colgroup>
                    <tr>
                        <th>发病前10-30天内是否外出：</th>
                        <td>
                            <ehr:dic-radio name="infectionSourceRoute.outHistory" dicmeta="PH00001" code="1,2" value="${malariaDto.infectionSourceRoute.outHistory}"
                                    onchange="toggleOther('infectionSourceRoute.outHistory','outHistoryPart',1);"/>
                        </td>
                    </tr>
                    <tbody id="outHistoryPart" style="display: none">
                        <tr>
                            <th>外出地点：</th>
                            <td>
                                <input type="text" name="infectionSourceRoute.outAddr" value="${malariaDto.infectionSourceRoute.outAddr}" reg='{"maxlength":"100"}'>
                            </td>
                            <th>外出地是否虐区：</th>
                            <td>
                                <ehr:dic-radio name="infectionSourceRoute.outInfectedArea" dicmeta="PH00001" code="1,2" value="${malariaDto.infectionSourceRoute.outInfectedArea}"/>
                            </td>
                        </tr>
                        <tr>
                            <th>外出天数：</th>
                            <td>
                                <input type="text" name="infectionSourceRoute.outDays" value="${malariaDto.infectionSourceRoute.outDays}" reg='{"maxlength":"20"}'>
                            </td>
                        </tr>
                    </tbody>
                    <tr>
                        <th>住地是否有防蚊措施：</th>
                        <td><ehr:dic-radio name="infectionSourceRoute.outPreventFacility" dicmeta="PH00001" code="1,2"
                                           value="${malariaDto.infectionSourceRoute.outPreventFacility}"/></td>
                    </tr>
                    <tr>
                        <th>近一月内家中是否有亲友来访：</th>
                        <td>
                            <ehr:dic-radio name="infectionSourceRoute.stranger" dicmeta="PH00001" code="1,2" value="${malariaDto.infectionSourceRoute.stranger}"
                                    onchange="toggleOther('infectionSourceRoute.stranger','strangerPart',1);"/>
                        </td>
                    </tr>
                    <tbody id="strangerPart" style="display: none">
                        <tr>
                            <th>来访亲友地址：</th>
                            <td>
                                <input type="text" name="infectionSourceRoute.strangerFromAddr" value="${malariaDto.infectionSourceRoute.strangerFromAddr}" reg='{"maxlength":"100"}'>
                            </td>
                            <th>该地是否虐区：</th>
                            <td><ehr:dic-radio name="infectionSourceRoute.strangerFromInfectedArea" dicmeta="PH00001" code="1,2"
                                               value="${malariaDto.infectionSourceRoute.strangerFromInfectedArea}"/></td>
                        </tr>
                        <tr>
                            <th>来访亲友留宿天数：</th>
                            <td>
                                <input type="text" name="infectionSourceRoute.strangerFromDays" value="${malariaDto.infectionSourceRoute.strangerFromDays}" reg='{"maxlength":"20"}'>
                            </td>
                            <th>来访者一个月内发热史：</th>
                            <td>
                                <ehr:dic-radio name="infectionSourceRoute.strangerFromFever" dicmeta="PH00001" code="1,2" value="${malariaDto.infectionSourceRoute.strangerFromFever}"/>
                            </td>
                        </tr>
                        <tr>
                            <th>来访者是否血检疟原虫：</th>
                            <td>
                                <ehr:dic-radio name="infectionSourceRoute.strangerFromPlasmodium" dicmeta="PH00001" code="1,2" value="${malariaDto.infectionSourceRoute.strangerFromPlasmodium}"/>
                            </td>
                        </tr>
                    </tbody>
                    <tr>
                        <th>患者家庭成员中有无发热病人：</th>
                        <td>
                            <ehr:dic-radio name="infectionSourceRoute.familyFever" dicmeta="PH00001" code="1,2" value="${malariaDto.infectionSourceRoute.familyFever}"
                                    onchange="toggleOther('infectionSourceRoute.familyFever','feverPlasmodium',1);"/>
                        </td>

                    </tr>
                    <tr id="feverPlasmodium" style="display: none">
                        <th>发热者是否血检疟原虫：</th>
                        <td>
                            <ehr:dic-radio name="infectionSourceRoute.feverPlasmodium" dicmeta="PH00001" code="1,2" value="${malariaDto.infectionSourceRoute.feverPlasmodium}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>患者发病前15天是否有输血史：</th>
                        <td>
                            <ehr:dic-radio name="infectionSourceRoute.transFusionHistory" dicmeta="PH00001" code="1,2"
                                           value="${malariaDto.infectionSourceRoute.transFusionHistory}"/>
                        </td>
                        <th>本次发病的感染分类：</th>
                        <td colspan="3">
                            <ehr:dic-list name="infectionSourceRoute.thisType" dicmeta="IDM00267" value="${malariaDto.infectionSourceRoute.thisType}"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </div>

		<div class="postdiv">
			<fieldset>
				<table class="posttable">
                    <colgroup>
                        <col style="width: 10%" />
                        <col style="width: 15%" />
                        <col style="width: 15%" />
                        <col style="width: 30%" />
                        <col style="width: 15%" />
                        <col style="width: 15%" />
                    </colgroup>
					<tr>
						<th>调查人：</th>
						<td>
                            <ehr:user userCode="${malariaDto.caseInformation.modifyRespondents}"/>
                            <%--<ehr:staff-list name="caseInformation.modifyRespondents" orgCode="" value="${malariaDto.caseInformation.modifyRespondents}" />--%>
                        </td>
                        <th>调查单位：</th>
                        <td>
                            <ehr:org code="${malariaDto.caseInformation.modifySurveyOrg}"/>
                            <%--<ehr:org-type-list id="fillOrganCode" name="caseInformation.modifySurveyOrg" type="hospital,centre"--%>
                                               <%--width="220px" value="${malariaDto.caseInformation.modifySurveyOrg}"/>--%>
                            <input type="hidden"  name="caseInformation.acceptTown" value="${malariaDto.caseInformation.acceptTown}"/>
                            <input type="hidden"  name="caseInformation.acceptUnit" value="${malariaDto.caseInformation.acceptUnit}"/>
                        </td>
                        <th>调查日期：</th>
                        <td><tag:dateInput id="modifySurveyDateId" name="caseInformation.modifySurveyDate" pattern="yyyy/MM/dd" date="${malariaDto.caseInformation.modifySurveyDate}"/></td>
					</tr>
					<tr>

					</tr>
				</table>
			</fieldset>
		</div>
	</div>
</form>
