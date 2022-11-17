<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/meningitis.js" type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js"	type="text/javascript"></script>
<c:if test="${isPrint != 1}">
    <jsp:include page="../caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
<div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
<i class="popno">
    流行性脑脊髓膜炎个案调查表<br/>
    <span>（乙类传染病）</span>
</i>
<input type="hidden" id="idmId" name="idmId" value="${idmId}"/>
<input type="hidden" name="esList" id="esList"></td>
<input type="hidden" name="efcList" id="efcList"></td>

<div class="postdiv">
<fieldset>
<table class="posttable">
<colgroup>
    <col style="width: 15%"/>
    <col style="width: 35%"/>
    <col style="width: 15%"/>
    <col style="width: 35%"/>
</colgroup>
			<tr>
				<th>病例编号：</th>
				<td><input type="text" name="caseInformation.mediRecordNum" value="${caseDto.caseInformation.mediRecordNum}"
                           style="width: 180px;" reg='{"maxlength":"14", "digits":"true"}'/>
                </td>
				<th>调查单位：</th>
				<td><ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/></td>
				
			</tr>
			<tr>
				<th>病例调查者：</th>
				<td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/></td>
				<th>调查日期：</th>
				<td><tag:dateInput name="caseInformation.modifySurveyDate" pattern="yyyy/MM/dd" style="width: 180px;" date="${caseDto.caseInformation.modifySurveyDate}"/></td>
			</tr>
			<tr style="display:none;">
	             <td>
	             	<input type="hidden" name="caseInformation.caseFillOrg" value="${caseDto.caseInformation.caseFillOrg}"/>
	             	<input type="hidden" name="caseInformation.modifySurveyOrg" value="${caseDto.caseInformation.modifySurveyOrg}"/>
	             	<input type="hidden" name="caseInformation.modifyRespondents" value="${caseDto.caseInformation.modifyRespondents}"/>
	             	<input type="hidden" name="caseInformation.auditor" value="${caseDto.caseInformation.auditor}"/>
	             </td> 
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
				<th><label class="required">1. 传染病报告卡卡片编号</label>：</th>
                <td colspan="2">${caseDto.caseInformation.caseNo}
                    <input type="hidden" name="caseInformation.caseNo" value="${caseDto.caseInformation.caseNo}"/>
                </td>
                <td></td>
			</tr>
			<tr>
				<th><label class="required">2. 患者姓名</label>：</th>
                <td colspan="3">
                    <input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}"
                           reg='{"maxlength":"100", "required":"true"}' style="width: 150px;"/>
                    （患儿家长姓名：<input type="text" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}"
                                   reg='{"maxlength":"50"}' style="width: 150px;"/>）
                </td>
			</tr>
			<tr>
				<th><label class="required">3. 身份证号</label>：</th>
                <td><input type="text" id="idCard" name="generalCondition.idcard" value="${caseDto.generalCondition.idcard}" reg='{"idCard":"true"}'
                           placeholder="输入身份证获取个人信息"/></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
				<th><label class="required">4. 性别</label>：</th>
                <td><ehr:dic-radio dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${caseDto.generalCondition.gender}" reg='{"required":"true"}'/></td>
			</tr>
			<tr>
				<th><label class="required">5. 出生日期</label>：</th>
                <td>
                    <tag:dateInput name="generalCondition.birthday" pattern="yyyy/MM/dd" date="${caseDto.generalCondition.birthday}" style="width:100px;" reg='{"required":"true"}'/>
                </td>
            </tr>
            <tr>
				<th><label class="required">6. （如出生日期不详，实足年龄</label>：</th>
				<td colspan="3"><input type="text" id="age" name="generalCondition.age" style="width: 60px; text-align: center" value="${caseDto.generalCondition.age}"
                           reg='{"maxlength":"6", "required":"true"}'/>
                    年龄单位：<ehr:dic-radio name="generalCondition.ageUnit" dicmeta="IDM00003" value="${caseDto.generalCondition.ageUnit}"/>） </td>
			</tr>
			<tr>
				<th><label class="required">7. 工作单位</label>：</th>
                <td>
                    <input type="text" name="generalCondition.unitName" value="${caseDto.generalCondition.unitName}"
                           reg='{"maxlength":"70", "required":"true"}' style="width: 180px;"/>
                </td>
                <th><label class="required">联系电话</label>：</th>
                <td><input type="text" name="generalCondition.phoneNumber" value="${caseDto.generalCondition.phoneNumber}"
                           reg='{"regex":"phone", "required":"true"}' style="width: 140px;"/></td>
			</tr>
			<tr>
				<th><label class="required">8. 病人属于</label>：</th>
				<td colspan="3">
                    <ehr:dic-radio name="generalCondition.patientAttribute" dicmeta="CV0201104" value="${caseDto.generalCondition.patientAttribute}" reg='{"required":"true"}'
                            onchange="meningitisCase.toggerAddress();"/>
				</td>
            </tr>
            <tr>
				<th><label class="required">9. 家庭现住址</label>：</th>
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
				<th><label class="required">10. 患者职业</label>：</th>
                <td colspan="3">
                    <ehr:dic-list id="occupationId" dicmeta="GBT6565" name="generalCondition.occupation" width="180px;" value="${caseDto.generalCondition.occupation}"
                                  code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,
                              CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120299,CV020120217" reg='{"required":"true"}'/>
                </td>
			</tr>
		</table>
	</fieldset>
<fieldset>
<legend>二、发病情况</legend>
<table class="posttable">
<colgroup>
    <col style="width: 25%"/>
    <col style="width: 25%"/>
    <col style="width: 25%"/>
    <col style="width: 25%"/>
</colgroup>
			<tr>
				<th><label class="required">2.1 发病日期</label>：</th>
				<td>
                    <tag:dateInput id="pathogenesisDate" name="attackCondition.pathogenesisDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.pathogenesisDate}" style="width:100px;" reg='{"required":"true", "compare":["deathTime","le","发病时间不能晚于死亡时间"]}'/>
                </td>
                <td></td>
                <td></td>
			</tr>
			<tr>
				<th>2.2 初诊医疗机构：</th>
				<td colspan="3">
                    <input type="text" name="attackCondition.firstVisitUnit" value="${caseDto.attackCondition.firstVisitUnit}"
                           reg='{"maxlength":"100"}' style="width: 200px;"/>
                    初诊日期<tag:dateInput name="attackCondition.firstVisitDate" date="${caseDto.attackCondition.firstVisitDate}"
                                       style="width: 100px;"/>

                </td>
			</tr>
			<tr>
				<th>2.3 诊断医疗机构：</th>
				<td colspan="3">
                    <input type="text" name="attackCondition.confirmationHospital" value="${caseDto.attackCondition.confirmationHospital}"
                           reg='{"maxlength":"100"}' style="width: 200px;"/>
                    诊断日期<tag:dateInput name="attackCondition.confirmationDate" date="${caseDto.attackCondition.confirmationDate}"
                                       style="width: 100px;" />
                </td>
			</tr>
			<tr>
				<th>2.4 报告单位：</th>
				<td colspan="3"><ehr:org code="${caseDto.caseInformation.reportOrg}"/>
                    <input type="hidden" name="caseInformation.reportOrg" value="${caseDto.caseInformation.reportOrg}"/>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;报告日期&nbsp;
                    <fmt:formatDate pattern="yyyy/MM/dd" value="${caseDto.caseInformation.reportDate}"/>
                    <tag:dateInput name="caseInformation.reportDate" date="${caseDto.caseInformation.reportDate}" style="display:none;"/>
                </td>
			</tr>
			<tr>
				<th>2.5 病例转归：</th>
				<td colspan="3"><ehr:dic-radio name="otherCondition.outcomeCode" dicmeta="IDM00005" code="1,2,3,6,4" value="${caseDto.otherCondition.outcomeCode}"
                        onchange="toggleOther('otherCondition.outcomeCode','deathTime',4);"/></td>
			</tr>
            <tr id="deathTime">
                <th><label class="required">2.6 如果死亡，死亡日期</label>：</th>
                <td><tag:dateInput id="deathTime" name="otherCondition.deathTime" style="width: 100px;" date="${caseDto.otherCondition.deathTime}"
                                   reg='{"required":"true", "dependOn":"otherCondition.outcomeCode","dependValue":"4", "compare":["pathogenesisDate","ge","死亡时间不能早于发病时间"]}'/></td>
            </tr>
		</table>
	</fieldset>
<fieldset>
<legend>三、既往疫苗接种情况</legend>
<table class="posttable">
<colgroup>
    <col style="width: 25%"/>
    <col style="width: 75%"/>
</colgroup>
			<tr>
				<th>流脑疫苗免疫史：</th>
				<td>
                    <ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.meningitis" code="2,1,4" value="${caseDto.epidemiologicalSurvey.meningitis}"
                            onchange="toggleOther('epidemiologicalSurvey.meningitis','meningitisPart',1);"/>
                </td>
			</tr>
            <tbody id="meningitisPart" style="display: none">
                <tr>
                    <th>3.1 如有，接种次数：</th>
                    <td>
                        <ehr:dic-radio name="epidemiologicalSurvey.inoculateNum" dicmeta="IDM00251" value="${caseDto.epidemiologicalSurvey.inoculateNum}"/>
                   		 <%-- <input type="text"  name="epidemiologicalSurvey.inoculateNum" value="${caseDto.epidemiologicalSurvey.inoculateNum}"
                               reg='{"maxlength":"20"}'  style="width: 180px;"> --%>
                    </td>
                </tr>
                <tr>
                    <th>3.2 接种依据：</th>
                    <td><ehr:dic-radio dicmeta="IDM00069" name="epidemiologicalSurvey.vaccinationReason" code="2,1,5"
                            value="${caseDto.epidemiologicalSurvey.vaccinationReason}"/></td>
                </tr>
                <tr>
                    <th>3.3 发病前最后一次接种时间：</th>
                    <td colspan="3">
                        A群疫苗接种时间
                        <tag:dateInput name="epidemiologicalSurvey.lastADt" onlypast="true" date="${caseDto.epidemiologicalSurvey.lastADt}"
                            style="width:100px;"/>
                        A+C群疫苗接种时间：最近接种
                        <tag:dateInput name="epidemiologicalSurvey.lastAcDt" onlypast="true" date="${caseDto.epidemiologicalSurvey.lastAcDt}"
                                       style="width:100px;"/>
                    </td>
                </tr>
            </tbody>
		</table>
	</fieldset>
<fieldset>
<legend>四、流行病学史</legend>
<table class="posttable">
<colgroup>
    <col style="width: 28%"/>
    <col style="width: 72%"/>
</colgroup>
			<tr>
				<th>4.1 发病地点近期是否有同类（流脑）病人：</th>
				<td><ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.similarPatients" code="1,2,4"
                        value="${caseDto.epidemiologicalSurvey.similarPatients}"/></td>
            </tr>
            <tr>
				<th>4.2 发病前一周与同类（流脑）病人接触史：</th>
				<td><ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.contactHistory" code="1,2,4" value="${caseDto.epidemiologicalSurvey.contactHistory}"
                                   onchange="toggleOther('epidemiologicalSurvey.contactHistory','contactWay',1);"/></td>
			</tr>
			<tr id="contactWay" style="display: none">
				<th>4.3 如有接触，接触方式：</th>
				<td><ehr:dic-radio name="epidemiologicalSurvey.contactWay" dicmeta="IDM00549" 
                                  value="${caseDto.epidemiologicalSurvey.contactWay}"/>
                </td>
            </tr>
            <tr>
				<th>4.4 家庭内同类（流脑）病人：</th>
				<td><ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.homeContactPatients" code="1,2,4"
                                   value="${caseDto.epidemiologicalSurvey.homeContactPatients}"/></td>
			</tr>
			<tr>
                <th>4.5 如周边（同宿舍、同班、同校）有同类（流脑）病人，根据情况填写下表：</th>
				<td colspan="3">
                    <div class="repeattable">
                    <div class="toolbarsublist">
                        <a href="javascript:meningitisCase.initPopEs()"><b class="xinz">添加</b></a>
                    </div>
                    <table id="esTable">
                        <thead>
                            <tr>
                                <th class="centerth" style="width:12%">患者姓名</th>
                                <th class="centerth" style="width:10%">性别</th>
                                <th class="centerth" style="width:10%">年龄</th>
                                <th class="centerth" style="width:20%">与患者关系</th>
                                <th class="centerth">发病情况</th>
                                <th class="centerth" style="width:70px;">操作</th>
                            </tr>
                        </thead>
                        <c:forEach var="esList" items="${caseDto.idmListEsList}" varStatus="status">
                            <tr>
                                <td field="name"><ehr:tip>${esList.name}</ehr:tip></td>
                                <td field="sexStr"><ehr:tip>${esList.sexStr}</ehr:tip></td>
                                <td field="age"><ehr:tip>${esList.age}</ehr:tip></td>
                                <td field="relation"><ehr:tip>${esList.relation}</ehr:tip></td>
                                <td field="attackCondition"><ehr:tip>${esList.attackCondition}</ehr:tip></td>
                                <td field="sex" style="display:none;"><ehr:tip>${esList.sex}</ehr:tip></td>
                                <td class="btnsublist" field="btn">
                                    <a href="javascript:void(0)" onclick="meningitisCase.editTr(this, 'esList')">修改</a>&nbsp;
                                    <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    </div>
				</td>
			</tr>
		</table>
	</fieldset>
<fieldset>
    <legend>五、临床表现与治疗</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 20%"/>
            <col style="width: 30%"/>
            <col style="width: 20%"/>
            <col style="width: 30%"/>
        </colgroup>
			<tr>
				<th>5.1. 起病：</th>
				<td><ehr:dic-radio dicmeta="PH00007" name="clinicalManifestations.onset" code="2,1,3"
                        value="${caseDto.clinicalManifestations.onset}"/></td>
                <th>5.2. 头痛：</th>
                <td><ehr:dic-radio name="clinicalManifestations.headache" dicmeta="IDM00072" code="2,3,4,6"
                                   value="${caseDto.clinicalManifestations.headache}"/> </td>
            </tr>
			<tr>
				<th>5.3. 恶心：</th>
				<td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.nausea" code="1,2,4"
                                   value="${caseDto.clinicalManifestations.nausea}"/></td>
                <th>5.4. 呕吐：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.vomit" code="1,2,4"
                                   value="${caseDto.clinicalManifestations.vomit}"/></td>
            </tr>
            <%--<tr>--%>
				<%--<th>5.4. 呕吐：</th>--%>
				<%--<td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.vomit" code="1,2,4"--%>
                                   <%--value="${caseDto.clinicalManifestations.vomit}"/></td>--%>
			<%--</tr>--%>
			<tr>
				<th>5.5. 惊厥：</th>
				<td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.seizure" code="1,2,4"
                                   value="${caseDto.clinicalManifestations.seizure}"/></td>
                <th>5.6. 体温：</th>
                <td><input type="text" name="clinicalManifestations.temperature" value="${caseDto.clinicalManifestations.temperature}"
                           reg='{"maxlength":"20"}' style="width: 100px;"/> ℃ </td>
            </tr>
            <%--<tr>--%>
				<%--<th>5.6. 体温：</th>--%>
				<%--<td><input type="text" name="clinicalManifestations.temperature" value="${caseDto.clinicalManifestations.temperature}"--%>
                           <%--reg='{"number":"true", "range":"20,50"}' style="width: 100px;"/> ℃ </td>--%>
			<%--</tr>--%>
			<tr>
				<th>5.7. 皮肤瘀点、瘀斑：</th>
				<td><ehr:dic-radio dicmeta="IDM00073" name="clinicalManifestations.ecchymosis"
                        value="${caseDto.clinicalManifestations.ecchymosis}"/> </td>
                <th>5.8. 颈项强直：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.neckRigidity" code="1,2,4"
                                   value="${caseDto.clinicalManifestations.neckRigidity}"/> </td>
            </tr>
            <%--<tr>--%>
				<%--<th>5.8. 颈项强直：</th>--%>
				<%--<td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.neckRigidity" code="1,2,4"--%>
                        <%--value="${caseDto.clinicalManifestations.neckRigidity}"/> </td>--%>
			<%--</tr>--%>
			<tr>
				<th>5.9. 意识障碍：</th>
				<td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.disturbanceConsciousness" code="1,2,4"
                                   value="${caseDto.clinicalManifestations.disturbanceConsciousness}"/></td>
                <th>5.10. 角弓反张：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.opisthotonos" code="1,2,4"
                                   value="${caseDto.clinicalManifestations.opisthotonos}"/> </td>
            </tr>
            <%--<tr>--%>
				<%--<th>5.10. 角弓反张：</th>--%>
				<%--<td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.opisthotonos" code="1,2,4"--%>
                                   <%--value="${caseDto.clinicalManifestations.opisthotonos}"/> </td>--%>
			<%--</tr>--%>
			<tr>
				<th>5.11. 若为婴儿，前卤隆起：</th>
				<td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.chimney"  code="1,2,4"
                                   value="${caseDto.clinicalManifestations.chimney}"/> </td>
                <th>5.12.克氏征：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.louGehrigsDisease" code="1,2,4"
                                   value="${caseDto.clinicalManifestations.louGehrigsDisease}"/> </td>
            </tr>
            <%--<tr>--%>
				<%--<th>5.12.克氏征：</th>--%>
				<%--<td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.louGehrigsDisease" code="1,2,4"--%>
                                   <%--value="${caseDto.clinicalManifestations.louGehrigsDisease}"/> </td>--%>
			<%--</tr>--%>
			<tr>
				<th>5.13.布氏征：</th>
				<td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.brucellosis" code="1,2,4"
                                   value="${caseDto.clinicalManifestations.brucellosis}"/> </td>
            <th> 5.14 病人隔离：</th>
            <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.isolationPatients" code="1,2,4"
                               value="${caseDto.clinicalManifestations.isolationPatients}"/> </td>
            </tr>
            <%--<tr>--%>
				<%--<th> 5.14 病人隔离：</th>--%>
				<%--<td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.isolationPatients" code="1,2,4"--%>
                                   <%--value="${caseDto.clinicalManifestations.isolationPatients}"/> </td>--%>
			<%--</tr>--%>
			<tr>
				<th>5.15 如有隔离，隔离地点：</th>
				<td>
                    <ehr:dic-radio name="clinicalManifestations.isolationPlace" dicmeta="IDM00550"  value="${caseDto.clinicalManifestations.isolationPlace}"
                            onchange="toggleOther('clinicalManifestations.isolationPlace','isolationPlaceOth',99);"/>
                    <span id="isolationPlaceOth" style="display: none">
                        <input type="text" name="clinicalManifestations.isolationPlaceOth" value="${caseDto.clinicalManifestations.isolationPlaceOth}"
                                style="width: 100px;" reg='{"maxlength":"100"}'/>
                    </span>
                </td>
                <th>5.16 使用抗生素类药物：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.antibioticDrugs" code="1,2,4"
                                   value="${caseDto.clinicalManifestations.antibioticDrugs}"/> </td>
            </tr>
            <%--<tr>--%>
				<%--<th>5.16 使用抗生素类药物：</th>--%>
				<%--<td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.antibioticDrugs" code="1,2,4"--%>
                        <%--value="${caseDto.clinicalManifestations.antibioticDrugs}"/> </td>--%>
			<%--</tr>--%>
			<tr>
				<th>5.17 使用药物名称：</th>
				<td><input type="text" name="clinicalManifestations.antibioticDrugsName" value="${caseDto.clinicalManifestations.antibioticDrugsName}"
                           reg='{"maxlength":"100"}'/> </td>
                <th>5.18 使用效果：</th>
                <td><ehr:dic-radio dicmeta="IDM00074" name="clinicalManifestations.usingEffect"
                                   value="${caseDto.clinicalManifestations.usingEffect}"/>
                </td>
            </tr>
            <%--<tr>--%>
				<%--<th>5.18 使用效果：</th>--%>
				<%--<td><ehr:dic-radio dicmeta="IDM00074" name="clinicalManifestations.usingEffect"--%>
                        <%--value="${caseDto.clinicalManifestations.usingEffect}"/>--%>
                <%--</td>--%>
			<%--</tr>--%>
		</table>
	</fieldset>
<fieldset>
    <legend>六、实验室检验结果</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 25%"/>
            <col style="width: 25%"/>
            <col style="width: 25%"/>
            <col style="width: 25%"/>
        </colgroup>
			<tr>
				<th>1. 血常规：</th>
				<td><ehr:dic-radio dicmeta="PH00002" name="labExamine.routineBlood" code="1,2" value="${caseDto.labExamine.routineBlood}"
                        onchange="toggleOther('labExamine.routineBlood','routineBloodPart',1);"/></td>
                <td></td>
                <td></td>
			</tr>
            <tbody id="routineBloodPart" style="display: none">
                <tr>
                    <th>1.1 采集日期：</th>
                    <td><tag:dateInput name="labExamine.routineBloodDate" date="${caseDto.labExamine.routineBloodDate}"/></td>
                </tr>
                <tr>
                    <th>1.2 血液白细胞总数：</th>
                    <td colspan="3"><input type="text" name="labExamine.leukocyteCount" value="${caseDto.labExamine.leukocyteCount}"
                               reg='{"maxlength":"20"}' style="width: 80px;text-align: center"/> X10^9个/L</td>
                </tr>
                <tr>
                    <th>1.3 中性粒细胞：</th>
                    <td colspan="3"><input type="text" name="labExamine.neutrophilcell" value="${caseDto.labExamine.neutrophilcell}"
                               reg='{"maxlength":"20"}' style="width: 80px;text-align: center"/> ％</td>
                </tr>
            </tbody>
			<tr>
				<th>2. 脑脊液常规：</th>
				<td><ehr:dic-radio dicmeta="PH00002" name="labExamine.csfCheck" code="1,2" value="${caseDto.labExamine.csfCheck}"
                        onchange="toggleOther('labExamine.csfCheck','csfCheckPart',1);"/></td>
			</tr>
            <tbody id="csfCheckPart">
                <tr>
                    <th>2.1 脑脊液标本采集日期：</th>
                    <td><tag:dateInput name="labExamine.csfCheckCollectTime" date="${caseDto.labExamine.csfCheckCollectTime}"/></td>
                </tr>
                <tr>
                    <th>2.2 外观：</th>
                    <td><ehr:dic-radio name="labExamine.cerebrospinalAspect" dicmeta="IDM00075"
                                      value="${caseDto.labExamine.cerebrospinalAspect}"/></td>
                </tr>
                <tr>
                    <th>2.3 脑脊液蛋白质：</th>
                    <td colspan="3"><input type="text" name="labExamine.cerebrospinalProtein" value="${caseDto.labExamine.cerebrospinalProtein}"
                               reg='{"maxlength":"20"}' style="width: 80px;text-align: center"/>g/L（正常值<0.45 g/L）</td>
                </tr>
                <tr>
                    <th>2.4 白细胞：</th>
                    <td colspan="3"><input type="text" name="labExamine.cerebrospinalLeukocyteCount" value="${caseDto.labExamine.cerebrospinalLeukocyteCount}"
                              reg='{"maxlength":"20"}' style="width: 80px;text-align: center"/>个/μL(正常值0-15/μL)</td>
                </tr>
                <tr>
                    <th>2.5 葡萄糖：</th>
                    <td colspan="3"><input type="text" name="labExamine.cerebrospinalSugar" value="${caseDto.labExamine.cerebrospinalSugar}"
                               reg='{"maxlength":"20"}' style="width: 80px;text-align: center"/>mmol/L</td>
                </tr>
                <tr>
                    <th>2.6 氯化物：</th>
                    <td colspan="3"><input type="text" name="labExamine.cerebrospinalChloride" value="${caseDto.labExamine.cerebrospinalChloride}"
                               reg='{"maxlength":"20"}' style="width: 80px;text-align: center"/>mmol/L</td>
                </tr>
            </tbody>
			<tr>
				<th>3. 实验室诊断：</th>
				<td><ehr:dic-radio dicmeta="PH00002" name="labExamine.labDiagnosis" code="1,2" value="${caseDto.labExamine.labDiagnosis}"
                        onchange="toggleOther('labExamine.labDiagnosis','labDiagnosisPart',1);"/></td>
			</tr>
            <tbody id="labDiagnosisPart" style="display: none">
                <tr>
                    <th>3.1 脑脊液培养：</th>
                    <td colspan="3"><ehr:dic-list name="labExamine.cultureCerebrospinal" dicmeta="IDM00076" code="1,2,3,4,5,6,7,8"
                            value="${caseDto.labExamine.cultureCerebrospinal}"/> </td>
                </tr>
                <tr>
                    <th>3.2 脑脊液特异抗原检查：</th>
                    <td colspan="3"><ehr:dic-list name="labExamine.cerebrospinalSpecAntigen" dicmeta="IDM00077"
                                      value="${caseDto.labExamine.cerebrospinalSpecAntigen}"/></td>
                </tr>
                <tr>
                    <th>3.3 脑脊液Nm特异DNA PCR：</th>
                    <td colspan="3"><ehr:dic-list name="labExamine.cerebrospinalNm" dicmeta="IDM00076" code="1,2,3,4,5,6,7,9"
                                      value="${caseDto.labExamine.cerebrospinalNm}"/></td>
                </tr>
                <tr>
                    <th>3.4 瘀点瘀斑图片检查是否见到革兰氏阴性双球菌：</th>
                    <td><ehr:dic-radio dicmeta="PH00001" name="labExamine.petechiaGnid" code="1,2"
                                       value="${caseDto.labExamine.petechiaGnid}"/></td>
                </tr>
                <tr>
                    <th>3.5 血液培养：</th>
                    <td colspan="3"><ehr:dic-list name="labExamine.bloodCulture" dicmeta="IDM00076" code="1,2,3,4,5,6,7,9"
                                      value="${caseDto.labExamine.bloodCulture}"/></td>
                </tr>
                <tr>
                    <th>3.6 血液Nm特异DNA PCR：</th>
                    <td colspan="3"><ehr:dic-list name="labExamine.bloodNmDna" dicmeta="IDM00076" code="1,2,3,4,5,6,7,9"
                                      value="${caseDto.labExamine.bloodNmDna}"/></td>
                </tr>
                <tr>
                    <th>3.7 血清学抗体诊断结果（恢复期抗体滴度较急性期呈4倍以上增高）：</th>
                    <td colspan="3"><ehr:dic-radio name="labExamine.serologyAntibody" dicmeta="IDM00076" code="1,3,7,9"
                                      value="${caseDto.labExamine.serologyAntibody}"/></td>
                </tr>
            </tbody>
			<tr>
				<th>4. 药敏结果：</th>
				<td><ehr:dic-radio dicmeta="PH00002" name="labExamine.sensitivityResult" code="1,2" value="${caseDto.labExamine.sensitivityResult}"
                        onchange="toggleOther('labExamine.sensitivityResult','sensitiveDrugs',1);"/></td>
			</tr>
			<tr id="sensitiveDrugs" style="display: none">
				<th></th>
				<td colspan="3">
                    若有，敏感药品
                    ⑴<input type="text" name="labExamine.sensitiveDrugsOne" value="${caseDto.labExamine.sensitiveDrugsOne}"
                            reg='{"maxlength":"100"}' style="width: 150px;"/>
                    ⑵<input type="text" name="labExamine.sensitiveDrugsTwo" value="${caseDto.labExamine.sensitiveDrugsTwo}"
                            reg='{"maxlength":"100"}' style="width: 150px;"/>
                    <br>⑶<input type="text" name="labExamine.sensitiveDrugsThree" value="${caseDto.labExamine.sensitiveDrugsThree}"
                                reg='{"maxlength":"100"}' style="width: 150px;"/>
                    ⑷<input type="text" name="labExamine.sensitiveDrugsFour" value="${caseDto.labExamine.sensitiveDrugsFour}"
                            reg='{"maxlength":"100"}' style="width: 150px;"/>
                    ⑸<input type="text" name="labExamine.sensitiveDrugsFive" value="${caseDto.labExamine.sensitiveDrugsFive}"
                            reg='{"maxlength":"100"}' style="width: 150px;"/>
                </td>
			</tr>
		</table>
	</fieldset>
<fieldset>
    <legend>七、病例分类</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 25%"/>
            <col style="width: 25%"/>
            <col style="width: 25%"/>
            <col style="width: 25%"/>
        </colgroup>
			<tr>
				<th>1. 最终病例诊断结果：</th>
				<td colspan="3"><ehr:dic-radio name="otherCondition.caseType" dicmeta="CV0501002" code="1,2,3"
                        value="${caseDto.otherCondition.caseType}"/></td>
            </tr>
            <tr>
				<th>2. 病例临床诊断：</th>
				<td colspan="3"><ehr:dic-radio name="otherCondition.clinicalCase" dicmeta="IDM00078"
                        value="${caseDto.otherCondition.clinicalCase}"/></td>
			</tr>
		</table>
	</fieldset>
<fieldset>
    <legend>八、与该病例密切接触者的调查登记表</legend>
    <div id="contactedList">
		<jsp:include page="contactedList.jsp"></jsp:include>
    </div>
	</fieldset>
</div>
</div>
</form>
