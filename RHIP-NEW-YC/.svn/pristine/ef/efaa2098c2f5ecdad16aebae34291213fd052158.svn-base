<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/echinococcosis.js" type="text/javascript"></script>

<c:if test="${isPrint != 1}">
    <jsp:include page="caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
<div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
<i class="popno">
    包虫病个案调查表<br/>
    <span>（丙类传染病）</span>
</i>
<input type="hidden" name="idmId" value="${idmId}" id="idmId"/>
<table class="repost_table" style="text-align: right;">
    <tr>
        <td>病例编码：<input type="text" name="attackCondition.medicalRecordNo" style="width: 160px;" value="${caseDto.attackCondition.medicalRecordNo }" reg='{"maxlength":"14"}'/></td>
    </tr>
</table>
<div class="postdiv">
<fieldset>
    <legend>1.一般情况</legend>
    <table class="posttable">
        <colgroup>
            <col style="min-width: 170px; width: 20%"/>
            <col style="min-width: 190px; width: 30%"/>
            <col style="min-width: 160px; width: 18%"/>
            <col style="min-width: 200px; width: 32%"/>
        </colgroup>
        <tr>
            <th>1.1姓名：</th>
            <td><input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name }" reg='{"maxlength":"100"}'/></td>
            <th>1.2身份证号码：</th>
            <td><input id="idCard" type="text" name="generalCondition.idcard" value="${caseDto.generalCondition.idcard }" reg='{"idCard":"true"}'
                       placeholder="输入身份证获取个人信息"/></td>
        </tr>
        <tr>
            <th>1.3性别：</th>
            <td><ehr:dic-radio name="generalCondition.gender" dicmeta="GBT226112003" value="${caseDto.generalCondition.gender }" code="1,2"/></td>
            <th>1.4年龄(岁)：</th>
            <td><input type="text" id="age" name="generalCondition.age" value="${caseDto.generalCondition.age }" reg='{"maxlength":"6"}'/></td>
        </tr>
        <tr>
            <th>1.5民族：</th>
            <td>
				<ehr:dic-list name="generalCondition.nation" dicmeta="GBT3304" value="${caseDto.generalCondition.nation }"></ehr:dic-list>
			</td>
            <th>1.6职业：</th>
            <td>
            <ehr:dic-list id="occupationId" name="generalCondition.occupation" dicmeta="GBT6565" value="${caseDto.generalCondition.occupation }"
                code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,7-76,CV020120216,CV020120299"
                    onchange="toggleOtherSC('generalCondition.occupation', 'occupationOtherPart', 'CV020120299');"/>
            <input id="occupationOtherPart" type="text" name="generalCondition.occupationOther"
                        value="${caseDto.generalCondition.occupationOther}"  reg='{"maxlength":"30"}' style="width:100px;display: none" />
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
            <th>1.7现居住地：</th>
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
            <th>1.8联系电话：</th>
            <td><input type="text" name="generalCondition.phoneNumber" value="${caseDto.generalCondition.phoneNumber }" reg='{"regex":"phone","maxlength":20}'/></td>
            <th>1.9家长或监护人姓名：</th>
            <td><input type="text" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName }" reg='{"maxlength":"50"}'/></td>
        </tr>
        <tr>
            <th>1.10工作或学习单位：</th>
            <td><input type="text" name="generalCondition.unitName" value="${caseDto.generalCondition.unitName }" reg='{"maxlength":"70"}'/></td>
        </tr>
        <tr>
            <th>1.11户口所在地：</th>
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
            <th>1.12发病时间：</th>
            <td><tag:dateInput id="pathogenesisDate" name="attackCondition.pathogenesisDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.pathogenesisDate }" reg='{"compare":["firstVisitDate","le","发病时间不能晚于初诊时间"]}'/></td>
            <th>1.13发病地点：</th>
            <td><input type="text" name="attackCondition.pathogenesisPlace" value="${caseDto.attackCondition.pathogenesisPlace }" reg='{"maxlength":"100"}'/></td>
        </tr>
        <tr>
            <th>1.14初诊时间：</th>
            <td><tag:dateInput id="firstVisitDate" name="attackCondition.firstVisitDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.firstVisitDate }" reg='{"compare":["pathogenesisDate","ge","初诊时间不能早于发病时间"]}'/></td>
            <th>1.15初诊单位：</th>
            <td><input type="text" name="attackCondition.firstVisitUnit" value="${caseDto.attackCondition.firstVisitUnit }" reg='{"maxlength":"100"}'/></td>
        </tr>
        <tr>
            <th>1.16初诊病名：</th>
            <td><input type="text" name="attackCondition.firstVisitName" value="${caseDto.attackCondition.firstVisitName }" reg='{"maxlength":"100"}'/></td>
            <th>1.17确诊时间：</th>
            <td><tag:dateInput name="attackCondition.confirmationDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.confirmationDate }" reg='{"compare":["firstVisitDate","ge","确诊时间不能早于初诊时间"]}'/></td>
        </tr>
        <tr>
            <th>1.18确诊单位：</th>
            <td><input type="text" name="attackCondition.confirmationHospital" value="${caseDto.attackCondition.confirmationHospital }" reg='{"maxlength":"100"}'/></td>
        </tr>
        <tr>
            <th>1.19入院时间：</th>
            <td><tag:dateInput id="inhosDateId" name="attackCondition.inhosDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.inhosDate }"  reg='{"compare":["outHospitalDateId","le","入院时间不能晚于出院时间"]}'/></td>
            <th>1.20所住医院：</th>
            <td><input type="text" name="attackCondition.admissionHospital" value="${caseDto.attackCondition.admissionHospital }" reg='{"maxlength":"100"}'/></td>
        </tr>
        <tr>
            <th>1.21出院时间：</th>
            <td><tag:dateInput id="outHospitalDateId" name="attackCondition.outHospitalDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.outHospitalDate }" reg='{"compare":["inhosDateId","ge","出院时间不能早于入院时间"]}'/></td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>2.临床表现</legend>
    <table class="posttable">
        <colgroup>
            <col style="min-width: 170px; width: 20%"/>
            <col style="min-width: 190px; width: 30%"/>
            <col style="min-width: 160px; width: 18%"/>
            <col style="min-width: 200px; width: 32%"/>
        </colgroup>
        <tr>
            <th>2.1 肝区肿痛：</th>
            <td><ehr:dic-radio dicmeta="FS10018" name="clinicalManifestations.liverSore" value="${caseDto.clinicalManifestations.liverSore }" /></td>
            <th>2.2 咳嗽：</th>
            <td><ehr:dic-radio dicmeta="FS10018" name="clinicalManifestations.cough" value="${caseDto.clinicalManifestations.cough }" /></td>
        </tr>
        <tr>
            <th>2.3 咳血：</th>
            <td><ehr:dic-radio dicmeta="FS10018" name="clinicalManifestations.hemoptysis" value="${caseDto.clinicalManifestations.hemoptysis }" /></td>
            <th>2.4 头痛：</th>
            <td><ehr:dic-radio dicmeta="FS10018" name="clinicalManifestations.headache" value="${caseDto.clinicalManifestations.headache }" /></td>
        </tr>
        <tr>
            <th>2.5 癫痫发作：</th>
            <td><ehr:dic-radio dicmeta="FS10018" name="clinicalManifestations.epilepticSeizure" value="${caseDto.clinicalManifestations.epilepticSeizure }" /></td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>3.实验室检查</legend>
    <table class="posttable">
        <colgroup>
            <col style="min-width: 170px; width: 20%"/>
            <col style="min-width: 190px; width: 30%"/>
            <col style="min-width: 160px; width: 18%"/>
            <col style="min-width: 200px; width: 32%"/>
        </colgroup>
        <tr>
            <th>3.1血象：</th>
        </tr>
        <tr>
            <th>3.1.1 白细胞总数：</th>
            <td><ehr:dic-radio dicmeta="PH00012" name="labExamine.leukocyteFlg" code="1,3" value="${caseDto.labExamine.leukocyteFlg }"/></td>
            <th>3.1.2 嗜酸性细胞：</th>
            <td><ehr:dic-radio dicmeta="PH00012" name="labExamine.eosinophilsFlg" code="1,3" value="${caseDto.labExamine.eosinophilsFlg }"/></td>
        </tr>
        <tr>
            <th>3.2 免疫学检查：</th>
        </tr>
        <tr>
            <th>3.2.1 皮内试验：</th>
            <td><ehr:dic-radio dicmeta="PH00019" name="labExamine.intradermalTest" value="${caseDto.labExamine.intradermalTest }"/></td>
            <th>3.2.2 IHA：</th>
            <td><ehr:dic-radio dicmeta="PH00019" name="labExamine.iha" value="${caseDto.labExamine.iha }"/></td>
        </tr>
        <tr>
            <th>3.2.3 ELISA：</th>
            <td><ehr:dic-radio name="labExamine.elisa" dicmeta="PH00019" value="${caseDto.labExamine.elisa }"/></td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>4.影象学检查</legend>
    <table class="posttable">
        <colgroup>
            <col style="min-width: 170px; width: 20%"/>
            <col style="min-width: 190px; width: 30%"/>
            <col style="min-width: 160px; width: 18%"/>
            <col style="min-width: 200px; width: 32%"/>
        </colgroup>
        <tr>
            <th>4.1 B超：</th>
        </tr>
        <tr>
            <th>4.1.1 肝脏囊肿样病变：</th>
            <td><ehr:dic-radio dicmeta="PH00002" name="labExamine.hepaticCyst" code="1,2" value="${caseDto.labExamine.hepaticCyst }"/></td>
            <th>4.1.2 脾脏囊肿样病变：</th>
            <td><ehr:dic-radio dicmeta="PH00002" name="labExamine.splenicCyst" code="1,2" value="${caseDto.labExamine.splenicCyst }"/></td>
        </tr>
        <tr>
            <th>4.1.3 肾脏囊肿样病变：</th>
            <td><ehr:dic-radio dicmeta="PH00002" name="labExamine.renalCyst" code="1,2" value="${caseDto.labExamine.renalCyst }"/></td>
        </tr>
        <tr>
            <th>4.2 X线：</th>
        </tr>
        <tr>
            <th>4.2.1 肺部圆（椭圆）阴影：</th>
            <td><ehr:dic-radio dicmeta="PH00002" name="labExamine.shadowLungs" code="1,2" value="${caseDto.labExamine.shadowLungs }"/></td>
            <th>4.2.2 其他部位阴影：</th>
            <td><ehr:dic-radio dicmeta="IDM00203" name="labExamine.shadowOther" value="${caseDto.labExamine.shadowOther }"/></td>
        </tr>
        <tr>
            <th>4.3 CT：</th>
        </tr>
        <tr>
            <th>4.3.1 颅脑囊肿阴影：</th>
            <td><ehr:dic-radio dicmeta="PH00002" name="labExamine.shadowBrainCyst" code="1,2" value="${caseDto.labExamine.shadowBrainCyst }"/></td>
            <th>4.3.2 肺部囊肿阴影：</th>
            <td><ehr:dic-radio dicmeta="PH00002" name="labExamine.shadowPulmonaryCyst" code="1,2" value="${caseDto.labExamine.shadowPulmonaryCyst }"/></td>
        </tr>
        <tr>
            <th>4.3.3 肝脏囊肿阴影：</th>
            <td><ehr:dic-radio dicmeta="PH00002" name="labExamine.shadowLiverCyst" code="1,2" value="${caseDto.labExamine.shadowLiverCyst }"/></td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>5.流行病学调查</legend>
    <table class="posttable">
        <colgroup>
            <col style="min-width: 170px; width: 20%"/>
            <col style="min-width: 190px; width: 30%"/>
            <col style="min-width: 160px; width: 18%"/>
            <col style="min-width: 200px; width: 32%"/>
        </colgroup>
        <tr>
            <th>5.1 在牧区工作、生活：</th>
            <td><ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.pastoralLife" code="1,2" value="${caseDto.epidemiologicalSurvey.pastoralLife }"/></td>
            <th>5.2 到过牧区：</th>
            <td><ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.contactPastoral" code="1,2" value="${caseDto.epidemiologicalSurvey.contactPastoral }"/></td>
        </tr>
        <tr>
            <th>5.3 与牧区狗接触：</th>
            <td><ehr:dic-radio dicmeta="IDM00204" name="epidemiologicalSurvey.pastoralDog" value="${caseDto.epidemiologicalSurvey.pastoralDog }"/></td>
            <th>5.4 在牧区吃生菜喝生水：</th>
            <td><ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.pastoralWater" code="1,2" value="${caseDto.epidemiologicalSurvey.pastoralWater }"/></td>
        </tr>
        <tr>
            <th>5.5 其它：</th>
            <td><input type="text" name="epidemiologicalSurvey.immuniHistoryFormOther" value="${caseDto.epidemiologicalSurvey.immuniHistoryFormOther }" reg='{"maxlength":"50"}'/></td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>6.既往治疗史</legend>
    <table class="posttable">
        <colgroup>
            <col style="min-width: 170px; width: 20%"/>
            <col style="min-width: 190px; width: 30%"/>
            <col style="min-width: 160px; width: 18%"/>
            <col style="min-width: 200px; width: 32%"/>
        </colgroup>
        <tr>
            <th>6.1 囊肿摘除手术：</th>
            <td><ehr:dic-radio dicmeta="PH00002" name="pastHistory.cystOperation" code="1,2" value="${caseDto.pastHistory.cystOperation }"/></td>
            <th>6.2 药物治疗史：</th>
            <td><ehr:dic-radio dicmeta="PH00002" name="pastHistory.medicationHistory" code="1,2" value="${caseDto.pastHistory.medicationHistory }"/></td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <table class="posttable">
        <colgroup>
            <col style="min-width: 170px; width: 20%"/>
            <col style="min-width: 190px; width: 30%"/>
            <col style="min-width: 160px; width: 18%"/>
            <col style="min-width: 200px; width: 32%"/>
        </colgroup>
        <tr>
            <th>调查单位：</th>
            <td><ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"></ehr:org></td>
            <th>调查者：</th>
            <td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
                </td>
        </tr>
        <tr>
            <th>审核者：</th>
            <td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/></td>
            <th>调查时间：</th>
            <td><tag:dateInput name="caseInformation.modifySurveyDate" pattern="yyyy/MM/dd" date="${caseDto.caseInformation.modifySurveyDate }"/></td>
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
