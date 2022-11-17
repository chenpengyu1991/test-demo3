<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<input type="hidden" value="${caseDto.caseInformation.reportOrg}" name="caseInformation.reportOrg">

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/tetanusNeonatorum.js" type="text/javascript"></script>
<c:if test="${isPrint != 1}">
    <jsp:include page="caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
<div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
<i class="popno">
    新生儿破伤风个案调查表<br/>
    <span>（乙类传染病）</span>
</i>
<input type="hidden" name="idmId" value="${idmId}" id="idmId"/>
<div class="postdiv">
<fieldset>
	<table class="posttable">
		<colgroup>
			<col style="width: 20%" />
			<col style="width: 30%" />
			<col style="width: 20%" />
			<col style="width: 30%" />
		</colgroup>
		<tr>
			<th>国际标码：</th>
			<td>
				<input type="text" name="generalCondition.gbcode" value="${caseDto.generalCondition.gbcode}" style="width: 50%;"
				 	reg='{"maxlength":"14"}'/>
			</td>
            <th>病例编号：</th>
            <td>
               <input type="text" name="attackCondition.medicalRecordNo" style="width: 160px;" value="${caseDto.attackCondition.medicalRecordNo }" reg='{"maxlength":"14"}'/>
            </td>
		</tr>
	</table>
</fieldset>
<fieldset>
    <legend>1.病例基本情况</legend>
    <table class="posttable">
        <colgroup>
            <col style="min-width: 230px; width: 25%"/>
            <col style="min-width: 280px; width: 75%"/>
        </colgroup>
        
       
        <tr>
            <th>病例户口类型：</th>
            <td>
                <ehr:dic-radio dicmeta="CV0201104" name="generalCondition.hrPlace" code="1,2,3,4" value="${caseDto.generalCondition.hrPlace }"/>
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
            <th>病例户口所在地：</th>
            <td colspan="3">
				<input type="text" id="hrAddress" name="generalCondition.hrAddress" value="${caseDto.generalCondition.hrAddress}"
                         			reg='{"maxlength":"100"}'  style="width: 250px;">
			</td>
        </tr>
        <tr>
            <th>现家庭住址：</th>
            <td>
                <ehr:dic-town-street-village streetId="pastreet_address" townId="patown_address" streetName="generalCondition.pastreet" townName="generalCondition.patownShip"
                                             streetValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="140px;"
                                             villageId="pavillage_address" villageName="generalCondition.paGroup" villageValue="${caseDto.generalCondition.paGroup}"/>
                <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
                                   reg='{"maxlength":"50"}'  style="width: 180px;">
                <span id="spanPaNumber">(门牌号)</span>
             </td>
        </tr>
        <tr>
            <th>患儿性别：</th>
            <td>
                <ehr:dic-radio dicmeta="FS10006" name="generalCondition.gender" code="1,2" value="${caseDto.generalCondition.gender }"/>
            </td>
        </tr>
        <tr>
            <th>出生日期：</th>
            <td>
                <tag:dateInput nullToToday="true" name="generalCondition.birthday" onlypast="true" date="${caseDto.generalCondition.birthday }" style="width: 150px;"
                               pattern="yyyy/MM/dd"></tag:dateInput>
            </td>
        </tr>
        <tr>
            <th>出生地点：</th>
            <td>
                <ehr:dic-radio dicmeta="IDM00186" name="generalCondition.birthdateAddr" value="${caseDto.generalCondition.birthdateAddr}"/>
                <%--<ehr:dic-town-village villageId="village_address" townId="town_address" villageName="exposureHistory.addrVillage" townName="exposureHistory.addrRural"
                                        villageValue="${caseDto.exposureHistory.addrVillage}" townValue="${caseDto.exposureHistory.addrRural}" width="180px;"/>
                  <input type="text" id="addrGroup" name="exposureHistory.addrGroup" reg='{"maxlength":"30"}'
                         value="${caseDto.exposureHistory.addrGroup}" placeholder="门牌号" style="width: 180px;">--%>
            </td>
        </tr>
        <%-- <tr>
            <th>患儿姓名：</th>
            <td>
                <input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name }"  style="width:200px" reg='{"maxlength":"100"}'/>
            </td>
        </tr>
        <tr>
            <th>父亲姓名：</th>
            <td>
                <input type="text" name="generalCondition.fatherName" value="${caseDto.generalCondition.fatherName }" style="width:200px" reg='{"maxlength":"50"}'/>
            </td>
        </tr>
        <tr>
            <th>母亲姓名：</th>
            <td>
                <input type="text" name="generalCondition.motherName" value="${caseDto.generalCondition.motherName }" style="width:200px" reg='{"maxlength":"50"}'/>
            </td>
        </tr> --%>
    </table>
</fieldset>
<fieldset>
    <legend>2.母亲免疫与产前检查情况</legend>
    <table class="posttable">
        <colgroup>
            <col style="min-width: 230px; width: 25%"/>
            <col style="min-width: 280px; width: 75%"/>
        </colgroup>
        <tr>
            <th>母亲年龄：</th>
            <td>
                <input type="text" name="attackCondition.motherAge" value="${caseDto.attackCondition.motherAge }" reg='{"maxlength":"20"}' style="width: 100px;"/>
                岁
            </td>
        </tr>
        <tr>
            <th>母亲在产前是否接种过破伤风类毒素？</th>
            <td>
            	<ehr:dic-radio dicmeta="FS10101" name="attackCondition.tetanusToxoidFlg" value="${caseDto.attackCondition.tetanusToxoidFlg }"
                               onchange="toggleOther('attackCondition.tetanusToxoidFlg','tetanusToxoidFlgFromAddrd',1)"></ehr:dic-radio>
            </td>
        </tr>
        <tr style="display: none;" id="tetanusToxoidFlgFromAddrd">
            <td colspan="2" style="padding: 0px;">
                <table>
                    <colgroup>
                        <col style="width: 25%"/>
                        <col style="width: 75%"/>
                    </colgroup>
                    <tr>
                        <th>如是，接种次数：</th>
                        <td>
                            <ehr:dic-radio dicmeta="IDM00187" name="attackCondition.vaccinateCount"
                                           value="${caseDto.attackCondition.vaccinateCount }"></ehr:dic-radio>
                        </td>
                    </tr>
                    <%-- <tr>
                        <th>d.最后一次接种日期：</th>
                        <td>
                            <tag:dateInput nullToToday="true" name="attackCondition.lastVaccinateDate" onlypast="true"
                                           date="${caseDto.attackCondition.lastVaccinateDate }"
                                           pattern="yyyy/MM/dd" style="width:200px"></tag:dateInput>
                        </td>
                    </tr> --%>
                </table>
            </td>
        </tr>
        </tr>
        <tr>
            <th>母亲是否接受产前检查？</th>
            <td>
                <ehr:dic-radio dicmeta="FS10101" name="attackCondition.prenatalDiagnosis" value="${caseDto.attackCondition.prenatalDiagnosis }"></ehr:dic-radio>
            </td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>3.患儿发病情况</legend>
    <table class="posttable">
        <colgroup>
            <col style="min-width: 230px; width: 25%"/>
            <col style="min-width: 280px; width: 75%"/>
        </colgroup>
        <tr>
            <th>患儿由谁接生：</th>
            <td>
            	<ehr:dic-radio dicmeta="IDM00188" name="attackCondition.midwife" value="${caseDto.attackCondition.midwife }"></ehr:dic-radio>
            </td>
        </tr>
        <tr>
            <th>发病日期：</th>
            <td>
                <tag:dateInput name="attackCondition.pathogenesisDate" date="${caseDto.attackCondition.pathogenesisDate }"
                               pattern="yyyy/MM/dd" style="width:150px;"></tag:dateInput>
            </td>
        </tr>
        <tr>
            <th>患儿是否到医疗机构就诊？</th>
            <td>
                <ehr:dic-radio dicmeta="FS10101" name="attackCondition.hospitalFlg" value="${caseDto.attackCondition.hospitalFlg }"
                               onchange="toggleOther('attackCondition.hospitalFlg','hospitalFlgFromAddrd',1)"></ehr:dic-radio>
            </td>
        </tr>
        <tr style="display: none;" id="hospitalFlgFromAddrd">
            <td colspan="2" style="padding: 0px;">
                <table>
                    <colgroup>
                        <col style="width: 25%"/>
                        <col style="width: 75%"/>
                    </colgroup>
                    <tr>
                        <th>如是，初次就诊日期：</th>
                        <td>
                            <tag:dateInput name="attackCondition.firstVisitDate"
                                           date="${caseDto.attackCondition.firstVisitDate }"
                                           pattern="yyyy/MM/dd" style="width:150px;"></tag:dateInput>
                        </td>
                    </tr>
                    <tr>
                        <th>就诊医疗机构级别：</th>
                        <td>
                            <ehr:dic-list name="attackCondition.organLevel" dicmeta="IDM00161"
                                          value="${caseDto.attackCondition.organLevel }"></ehr:dic-list>
                        </td>
                    </tr>
                    <tr>
                        <th>就诊时诊断：</th>
                        <td>
                            <ehr:dic-radio dicmeta="IDM00189" name="attackCondition.diagnosis"
                                           value="${caseDto.attackCondition.diagnosis }"></ehr:dic-radio>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <th>患儿是否死于新生儿破伤风？</th>
            <td>
            	<ehr:dic-radio dicmeta="FS10101" name="attackCondition.deathMocezueloFlag" value="${caseDto.attackCondition.deathMocezueloFlag }"></ehr:dic-radio>
            </td>
        </tr>
        <tr>
            <th>周围还有类似病例发生：</th>
            <td>
            	<ehr:dic-radio dicmeta="FS10009" name="attackCondition.aroundInvasion" value="${caseDto.attackCondition.aroundInvasion }" code="2,1"></ehr:dic-radio>
                <span id="aroundInvasionCount">有
                <input type="text" name="attackCondition.aroundInvasionCount" value="${caseDto.attackCondition.aroundInvasionCount }" style="width:100px" reg='{"maxlength":"20"}'/>例</span>
            </td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>4.最后诊断</legend>
    <table class="posttable">
        <colgroup>
            <col style="min-width: 230px; width: 25%"/>
            <col style="min-width: 280px; width: 75%"/>
        </colgroup>
        <tr>
            <th>最后诊断：</th>
            <td>
            	<input type="text" name="diagnosis.lastDiagnosisText" value="${caseDto.diagnosis.lastDiagnosisText }" style="width:200px" reg='{"maxlength":"100"}'/></span>
            </td>
        </tr>
        <tr>
            <th>患儿是否新生儿破伤风？</th>
            <td>
            	<ehr:dic-radio dicmeta="FS10101" name="attackCondition.mocezueloFlag" value="${caseDto.attackCondition.mocezueloFlag }"></ehr:dic-radio>
            </td>
        </tr>
        <tr>
            <th>报告人姓名：</th>
            <td>
                <ehr:user userCode="${caseDto.caseInformation.reportPerson}"></ehr:user>
                <input type="hidden" name="caseInformation.reportPerson" value="${caseDto.caseInformation.reportPerson }" reg='{"maxlength":"50"}'/>
            </td>
        </tr>
        <tr>
            <th>报告人工作所在地：</th>
            <td>
                <ehr:org code="${caseDto.caseInformation.reportOrg}" />
                <input type="hidden" value="${caseDto.caseInformation.reportOrg}" name="caseInformation.reportOrg">
                <%--<input type="text" name="caseInformation.reportPlace" value="${caseDto.caseInformation.reportPlace }" reg='{"maxlength":"50"}'/>--%>
            </td>
        </tr>
        <tr>
            <th>报告人报告日期：</th>
            <td>
                <fmt:formatDate value='${caseDto.caseInformation.reportDate}' pattern="yyyy/MM/dd" />
                <tag:dateInput nullToToday="true" name="caseInformation.reportDate" onlypast="true"
                               pattern="yyyy/MM/dd" date="${caseDto.caseInformation.reportDate }" style="display: none" ></tag:dateInput>
            </td>
        </tr>
        <tr>
            <th>调查日期：</th>
            <td>
                <tag:dateInput nullToToday="true" name="caseInformation.modifySurveyDate" onlypast="true" date="${caseDto.caseInformation.modifySurveyDate }" style="width: 150px;"
                               pattern="yyyy/MM/dd"></tag:dateInput>
            </td>
        </tr>
        <tr>
            <th>调查人姓名：</th>
            <td>
                <ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"></ehr:user>
                <input type="hidden" name="caseInformation.modifyRespondents" value="${caseDto.caseInformation.modifyRespondents}"/>
                <%--<input type="text" name="caseInformation.surveyName" value="${caseDto.caseInformation.modifyRespondents }" reg='{"maxlength":"50"}'/>--%>
            </td>
        </tr>
         <tr>
            <th>调查人单位：</th>
            <td>
                <ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/>
                <input type="hidden" name="caseInformation.modifySurveyOrg" value="${caseDto.caseInformation.modifySurveyOrg}"/>
                <%--<input type="text" name="caseInformation.surveyPlace" value="${caseDto.caseInformation.surveyPlace }" reg='{"maxlength":"100"}'/>--%>
            </td>
        </tr>
        <tr>
            <th>调查人工作地点：</th>
            <td>
                <%-- <ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/> --%>

                <input type="text" name="caseInformation.surveyPlace" value="${caseDto.caseInformation.surveyPlace }" reg='{"maxlength":"100"}' style="width: 150px;"/>
            </td>
        </tr>
        <tr>
            <th>审核者：</th>
            <td>
                <ehr:user userCode="${caseDto.caseInformation.auditor}"></ehr:user>
                <input type="hidden" name="caseInformation.auditor" value="${caseDto.caseInformation.auditor}"/>
            </td>
        </tr>
        <tr>
            <th>县收到本调查表时间：</th>
            <td>
                <tag:dateInput nullToToday="true" name="caseInformation.countySurveyDate" onlypast="true" date="${caseDto.caseInformation.countySurveyDate }"
                               style="width: 150px;" pattern="yyyy/MM/dd"></tag:dateInput>
            </td>
        </tr>
        <tr>
            <th>省收到本调查表时间：</th>
            <td>
                <tag:dateInput nullToToday="true" name="caseInformation.provinceSurveyDate" onlypast="true" date="${caseDto.caseInformation.provinceSurveyDate }"
                               style="width: 150px;" pattern="yyyy/MM/dd"></tag:dateInput>
            </td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <table class="posttable">
        <colgroup>
            <col style="min-width: 560px; width: 80%"/>
            <col style="min-width: 160px; width: 20%"/>
        </colgroup>
        <tr>
            <th>病例调查人员签名：</th>
            <td>
                <ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"></ehr:user>
            </td>
        </tr>
    </table>
</fieldset>
</div>
</div>
</form>

