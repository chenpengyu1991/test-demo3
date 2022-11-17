<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/hiwhpai.js" type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js"	type="text/javascript"></script>
<c:if test="${isPrint != 1}">
    <jsp:include page="../caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
<div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
<i class="popno">
    人感染高致病性禽流感个案调查表<br/>
    <span>（乙类传染病）</span>
</i>
<input type="hidden" name="idmId" value="${idmId}" id="idmId"/>
<input type="hidden" name="acList" id="acList"></td>
<input type="hidden" name="ehList" id="ehList"></td>
<input type="hidden" name="hcList" id="hcList"></td>
<input type="hidden" name="leList" id="leList"></td>
<input type="hidden" name="efcList" id="efcList"></td>
<input type="hidden" value="hiwhpai" id="reportDiseasesId"/>
<div class="postdiv">
<fieldset>
    <legend>一、病例的发现/报告情况</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 25%" />
            <col style="width: 25%" />
            <col style="width: 25%" />
            <col style="width: 25%" />
        </colgroup>
        <tr>
            <th>1 病例的首次发现单位(具体到科室)：</th>
            <td>
                <input type="text" name="caseInformation.firstFoundOrg" value="${caseDto.caseInformation.firstFoundOrg}">
            </td>
        </tr>
        <tr>
            <th>1.1 联系方式：</th>
            <td colspan="3">
                (1)电话:
                <input type="text" name="caseInformation.phone" value="${caseDto.caseInformation.phone}" reg='{"regex":"phone"}' style="width: 150px;"/>
                <br>(2)传真:
                <input type="text" name="caseInformation.fax" value="${caseDto.caseInformation.fax}" reg='{"regex":"phone"}' style="width: 150px;"/>
                <br>(3)E-mail:
                <input type="text" name="caseInformation.mail" value="${caseDto.caseInformation.mail}" reg='{"regex":"email", "maxlength":"50"}' style="width: 150px;"/>
            </td>
        </tr>
        <tr>
            <th>1.2 发现时间：</th>
            <td>
                <tag:dateInput id="discoveryDate" name="caseInformation.discoveryDate" onlypast="true" pattern="yyyy/MM/dd HH:mm"
                           date="${caseDto.caseInformation.discoveryDate}"/>
                <input type="hidden" id="discoveryDateHM" name="caseInformation.discoveryDateHM">
            </td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <th>2 首次报告单位：</th>
            <td colspan="3">
                <input type="text" name="caseInformation.firstReportOrg" value="${caseDto.caseInformation.firstReportOrg}" reg='{"maxlength":"100"}'/>
                <%--${caseDto.caseInformation.firstReportOrg}--%>
            </td>
        </tr>
        <tr>
            <th>2.1 接到报告单位：</th>
            <td colspan="3"><input type="text" name="caseInformation.receiveReportOrg" value="${caseDto.caseInformation.receiveReportOrg}" reg='{"maxlength":"100"}'/></td>
        </tr>
        <tr>
            <th>2.2 报告方式：</th>
            <td colspan="3">
                <ehr:dic-radio name="caseInformation.firstReportType" dicmeta="IDM00129" value="${caseDto.caseInformation.firstReportType}"/>
            </td>
        </tr>
        <tr>
            <th>2.3 报告时间：</th>
            <td>
                <tag:dateInput id="reportDate" name="caseInformation.reportDate"  onlypast="true" pattern="yyyy/MM/dd HH:mm" date="${caseDto.caseInformation.reportDate}"
                        />
                <%--<fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${caseDto.caseInformation.reportDate}"/>
                <input type="hidden" id="reportDateHM" name="caseInformation.reportDateHM">--%>

            </td>
        </tr>
        <tr>
            <th>2.4 报告疾病名称：</th>
            <td>
                <input type="text" name="caseInformation.reportDiseases" value="${caseDto.caseInformation.reportDiseases}" reg='{"maxlength":"100"}'/>
            </td>
        </tr>
        <tr>
            <th>3 首次报告时，是否进行网络直报：</th>
            <td>
                <ehr:dic-radio name="caseInformation.isNetworkReport" dicmeta="PH00001" value="${caseDto.caseInformation.isNetworkReport}" code="1,2"
                        onchange="toggleOther('caseInformation.isNetworkReport','networkPart',1);"/>
            </td>
        </tr>
        <tbody id="networkPart" style="display: none">
            <tr>
                <th>3.1 若进行网络直报，报告单位为：</th>
                <td colspan="3"><input type="text" name="caseInformation.networkReportOrg" value="${caseDto.caseInformation.networkReportOrg}" reg='{"maxlength":"100"}'/></td>
            </tr>
            <tr>
                <th>3.2 报告时间：</th>
                <td>
                    <tag:dateInput id="directReportDate" name="caseInformation.directReportDate" onlypast="true" pattern="yyyy/MM/dd HH:mm"
                                   date="${caseDto.caseInformation.directReportDate}"/>
                    <input type="hidden" id="directReportDateHM" name="caseInformation.directReportDateHM" />
                </td>
            </tr>
            <tr>
                <th>3.3 报告疾病名称：</th>
                <td colspan="3"><input type="text" name="caseInformation.directReportDiseases" value="${caseDto.caseInformation.directReportDiseases}" reg='{"maxlength":"100"}'/></td>
            </tr>
        </tbody>
    </table>
</fieldset>
<fieldset>
    <legend>二、病例一般情况</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 28%" />
            <col style="width: 22%" />
            <col style="width: 25%" />
            <col style="width: 25%" />
        </colgroup>
        <tr>
            <th>1 病例姓名：</th>
            <td colspan="3"><input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}"
                                   reg='{"maxlength":"100"}' style="width: 150px;"/>
                家长姓名（若是儿童，请填写）<input type="text" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}"
                               reg='{"maxlength":"50"}' style="width: 150px;"/>
            </td>
        </tr>
        <tr>
            <th>2 性别：</th>
            <td>
                <ehr:dic-radio dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${caseDto.generalCondition.gender}"/>
            </td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <th>3 民族：</th>
            <td><ehr:dic-list name="generalCondition.nation" dicmeta="GBT3304" value="${caseDto.generalCondition.nation}"/></td>
        </tr>
        <tr>
            <th>4 出生日期：</th>
            <td colspan="3">
                <tag:dateInput name="generalCondition.birthday" pattern="yyyy/MM/dd" date="${caseDto.generalCondition.birthday}" style="width:100px;"/>
                （如出生日期不详，实足年龄
                <input type="text" id="age" name="generalCondition.age" value="${caseDto.generalCondition.age}"
                       reg='{"maxlength":"6"}' style="width: 60px; text-align: center" />
                年龄单位<ehr:dic-radio name="generalCondition.ageUnit" dicmeta="IDM00003" value="${caseDto.generalCondition.ageUnit}"/>)
            </td>
        </tr>
        <tr>
            <th>5 身份证号码：</th>
            <td colspan="3">
                <input type="text" id="idCard" name="generalCondition.idcard" value="${caseDto.generalCondition.idcard}"
                       reg='{"idCard":"idCard"}' style="width: 150px;" placeholder="输入身份证获取个人信息"/>(或家长身份证号码)
            </td>
        </tr>
       <tr>
	       	<th>6 常住类型：</th>
	       	<td>
	 		<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
	           		value="${caseDto.generalCondition.floatPopulation}" onchange="caseEdit.toggerAddress()"/>
	       	</td>
       </tr>
       <tr>
			<th>7 户籍地址：</th>
             <td colspan="3">
                <ehr:dic-town-village villageId="hrvillage_address" townId="hrtown_address" villageName="generalCondition.hrstreet" townName="generalCondition.hrtownShip"
                                       villageValue="${caseDto.generalCondition.hrstreet}" townValue="${caseDto.generalCondition.hrtownShip}" width="180px;"/>

                 <input type="text" name="generalCondition.hrhouseNumber" id="hrhouseNumber" value="${caseDto.generalCondition.hrhouseNumber}"
                         style="width: 180px;" reg='{"maxlength":"50"}'>
                 <span id="spanHrNumber">(门牌号)</span>
             </td>
		</tr>
		<tr>
			<th>8 现住址：</th>
             <td colspan="3">
                 <ehr:dic-town-village villageId="pavillage_address" townId="patown_address" villageName="generalCondition.pastreet" townName="generalCondition.patownShip"
                                       villageValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="180px;"/>
                 <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
                        reg='{"maxlength":"50"}'  style="width: 180px;">
                 <span id="spanPaNumber">(门牌号)</span>
             </td>
		</tr>
        <tr>
            <th>9 学习或工作单位：</th>
            <td colspan="2">
                <input reg='{"maxlength":"70"}' type="text" name="generalCondition.unitName" value="${caseDto.generalCondition.unitName}"/>
            </td>
        </tr>
        <tr>
            <th>10 联系电话：</th>
            <td colspan="3">
                (1)手机:
                <input type="text" name="generalCondition.mobile" value="${caseDto.generalCondition.mobile}"
                       style="width: 150px;" reg='{"regex":"mobile"}'/>
                <br>(2)家庭电话:
                <input type="text" name="generalCondition.familyPhone" value="${caseDto.generalCondition.familyPhone}"
                       style="width: 150px;" reg='{"regex":"phone"}'/>
                <br>(3)其它联系人电话:
                <input type="text" name="generalCondition.contactPhone" value="${caseDto.generalCondition.contactPhone}"
                       style="width: 150px;" reg='{"regex":"phone"}'/>
            </td>
        </tr>
        <tr>
            <th>11 职业：</th>
            <td colspan="3">
                <ehr:dic-list id="occupationId" dicmeta="GBT6565" name="generalCondition.occupation" width="180px;" value="${caseDto.generalCondition.occupation}"
                      code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,
                      CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120299,CV020120217"/>
            </td>
        </tr>
    </table>
</fieldset>

<fieldset>
    <legend>三、病例的发病与就诊经过</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 28%" />
            <col style="width: 22%" />
            <col style="width: 25%"/>
            <col style="width: 25%"/>
        </colgroup>
        <tr>
            <th>1 发病日期：</th>
            <td>
                <tag:dateInput name="attackCondition.pathogenesisDate" onlypast="true" pattern="yyyy/MM/dd"
                           date="${caseDto.attackCondition.pathogenesisDate}"/>
            </td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <th>2 发病地点：</th>
            <td colspan="3">
                <ehr:dic-radio name="attackCondition.pathogenesisPlaceSelect" dicmeta="IDM00044" value="${caseDto.attackCondition.pathogenesisPlaceSelect}"/>
            </td>
        </tr>
        <tr>
            <th>3 前往医疗机构就诊前，是否自行服药：</th>
            <td>
                <ehr:dic-radio name="attackCondition.selfMedication" dicmeta="PH00001" code="1,2,4" value="${caseDto.attackCondition.selfMedication}"
                        onchange="toggleOther('attackCondition.selfMedication','medicationType',1);"/>
            </td>
        </tr>
        <tr id="medicationType" style="display: none">
            <th>3.1 若自行服药，则服药种类：</th>
            <td><input type="text" name="attackCondition.medicationType" value="${caseDto.attackCondition.medicationType}" reg='{"maxlength":"100"}'/></td>
        </tr>
        <tr>
            <td colspan="4">
                <div class="repeattable">
                    <div class="toolbarsublist">
                        4 请填写以下就诊情况<a href="javascript:hiwhpaiCase.popupAc(this)"><b class="xinz">添加</b></a>
                    </div>
                    <table id="acTable">
                        <thead>
                            <tr>
                                <th class="centerth" style="width: 13%">就诊单位</th>
                                <th class="centerth" style="width: 11%">就诊日期</th>
                                <th class="centerth" style="width: 60px;">治疗天数</th>
                                <th class="centerth">诊断结果</th>
                                <th class="centerth" style="width: 60px;">是否隔离</th>
                                <th class="centerth" style="width: 11%">入住院时间</th>
                                <th class="centerth" style="width: 14%">门诊/住院病历号</th>
                                <th class="centerth" style="width: 8%">转归</th>
                                <th class="centerth" style="width: 65px;">操作</th>
                            </tr>
                        </thead>
                        <c:forEach var="acObj" items="${caseDto.idmListAcList}" varStatus="status">
                            <tr>
                                <td field="treatmentUnit"><ehr:tip>${acObj.treatmentUnit}</ehr:tip></td>
                                <td field="treatmentDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${acObj.treatmentDt}"/></ehr:tip></td>
                                <td field="treatDays"><ehr:tip>${acObj.treatDays}</ehr:tip></td>
                                <td field="diagnosisResult"><ehr:tip>${acObj.diagnosisResult}</ehr:tip></td>
                                <td field="quarantineStr"><ehr:tip>${acObj.quarantineStr}</ehr:tip></td>
                                <td field="inhospitalDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${acObj.inhospitalDt}"/></ehr:tip></td>
                                <td field="outpatientNo"><ehr:tip>${acObj.outpatientNo}</ehr:tip></td>
                                <td field="lapseStr"><ehr:tip>${acObj.lapseStr}</ehr:tip></td>
                                <td field="lapse" style="display:none;">${acObj.lapse}</td>
                                <td field="quarantine" style="display:none;">${acObj.quarantine}</td>
                                <td class="btnsublist" field="btn">
                                    <a href="javascript:void(0)" onclick="hiwhpaiCase.popupAc(this,'edit')">修改</a>&nbsp;
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
    <legend>四、病例的临床表现</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 28%"/>
            <col style="width: 72%"/>
            <%--<col style="width: 25%"/>--%>
            <%--<col style="width: 25%"/>--%>
        </colgroup>
        <tr>
            <th>1 首发症状(描述)：</th>
            <td>
                <%--<input type="text" name="clinicalManifestations.originalSymptom" value="${caseDto.clinicalManifestations.originalSymptom}" reg='{"maxlength":"200"}'/>--%>
                <textarea name="clinicalManifestations.originalSymptom" rows="3" style="width: 100%;font-size: 12px;" reg='{"maxlength":"200"}'>${caseDto.clinicalManifestations.originalSymptom}</textarea>

            </td>
        </tr>
        <tr>
            <th>2 流感样表现：</th>
            <td>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 50%" />
                        <col style="width: 50%" />
                    </colgroup>
                    <tr>
                        <td colspan="2">发热&nbsp;&nbsp;
                            <ehr:dic-radio name="clinicalManifestations.fever" dicmeta="PH00001" code="1,2" value="${caseDto.clinicalManifestations.fever}"
                                    onchange="toggleOther('clinicalManifestations.fever','feverPart',1);"/>
                            <span id="feverPart">
                                    &nbsp;&nbsp;体温(范围)&nbsp;<input type="text" name="clinicalManifestations.temperature" style="width: 100px;"
                                    value="${caseDto.clinicalManifestations.temperature}" reg='{"maxlength":"20"}'/>℃
                                    &nbsp;&nbsp;持续时间&nbsp;<input type="text" name="clinicalManifestations.heatingDuration" style="width: 150px;"
                                                           value="${caseDto.clinicalManifestations.heatingDuration}" reg='{"maxlength":"20"}'/>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td>寒战&nbsp;&nbsp;
                            <ehr:dic-radio name="clinicalManifestations.chill" dicmeta="PH00001" code="1,2" value="${caseDto.clinicalManifestations.chill}"/>
                        </td>
                        <td>咳嗽&nbsp;&nbsp;
                            <ehr:dic-radio name="clinicalManifestations.cough" dicmeta="PH00001" code="1,2" value="${caseDto.clinicalManifestations.cough}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>咳痰&nbsp;&nbsp;
                            <ehr:dic-radio name="clinicalManifestations.expectoration" dicmeta="PH00001" code="1,2" value="${caseDto.clinicalManifestations.expectoration}"/>
                        </td>
                        <td>咽痛&nbsp;&nbsp;
                            <ehr:dic-radio name="clinicalManifestations.soreThroat" dicmeta="PH00001" code="1,2" value="${caseDto.clinicalManifestations.soreThroat}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>头痛&nbsp;&nbsp;
                            <ehr:dic-radio name="clinicalManifestations.headache" dicmeta="PH00001" code="1,2" value="${caseDto.clinicalManifestations.headache}"/>
                        </td>
                        <td>鼻塞&nbsp;&nbsp;
                            <ehr:dic-radio name="clinicalManifestations.nasalObstruction" dicmeta="PH00001" code="1,2" value="${caseDto.clinicalManifestations.nasalObstruction}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>流涕&nbsp;&nbsp;
                            <ehr:dic-radio name="clinicalManifestations.runningNose" dicmeta="PH00001" code="1,2" value="${caseDto.clinicalManifestations.runningNose}"/>
                        </td>
                        <td>肌肉酸痛&nbsp;&nbsp;
                            <ehr:dic-radio name="clinicalManifestations.muscularStiffness" dicmeta="PH00001" code="1,2" value="${caseDto.clinicalManifestations.muscularStiffness}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>关节酸痛&nbsp;&nbsp;
                            <ehr:dic-radio name="clinicalManifestations.limbAche" dicmeta="PH00001" code="1,2" value="${caseDto.clinicalManifestations.limbAche}"/>
                        </td>
                        <td>乏力&nbsp;&nbsp;
                            <ehr:dic-radio name="clinicalManifestations.feeble" dicmeta="PH00001" code="1,2" value="${caseDto.clinicalManifestations.feeble}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>胸闷&nbsp;&nbsp;
                            <ehr:dic-radio name="clinicalManifestations.chestStufly" dicmeta="PH00001" code="1,2" value="${caseDto.clinicalManifestations.chestStufly}"/>
                        </td>
                        <td>气促&nbsp;&nbsp;
                            <ehr:dic-radio name="clinicalManifestations.asthma" dicmeta="PH00001" code="1,2" value="${caseDto.clinicalManifestations.asthma}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>呼吸困难&nbsp;&nbsp;
                            <ehr:dic-radio name="clinicalManifestations.dyspnea" dicmeta="PH00001" code="1,2" value="${caseDto.clinicalManifestations.dyspnea}"/>
                        </td>
                        <td>腹泻&nbsp;&nbsp;
                            <ehr:dic-radio name="clinicalManifestations.diarrhea" dicmeta="PH00001" code="1,2" value="${caseDto.clinicalManifestations.diarrhea}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>结膜炎&nbsp;&nbsp;
                            <ehr:dic-radio name="clinicalManifestations.conjunctivitis" dicmeta="PH00001" code="1,2" value="${caseDto.clinicalManifestations.conjunctivitis}"/>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <th>3 其它临床表现(描述)：</th>
            <td>
                <textarea name="clinicalManifestations.other" rows="3" style="width: 100%;font-size: 12px;" reg='{"maxlength":"500"}'>${caseDto.clinicalManifestations.other}</textarea>
            </td>
        </tr>
    </table>
</fieldset>
<fieldset>
<legend>五、病例居住环境及暴露情况</legend>
<table class="posttable">
<colgroup>
    <col style="width: 36%"/>
    <col style="width: 64%"/>
</colgroup>
<tr>
    <th>1 病例居住地点(村庄/居民楼)周围环境描述：</th>
    <td>
        <textarea name="exposureHistory.patLiveEnvir" rows="2" style="width: 100%;font-size: 12px;" reg='{"maxlength":"200"}'>${caseDto.exposureHistory.patLiveEnvir}</textarea>
    </td>
</tr>
<tr>
    <th>2 病例居住地点(村庄/居民楼)周围3公里内是否有：</th>
    <td>
        <ehr:dic-checkbox name="exposureHistory.isMarket" dicmeta="IDM00131" value="${caseDto.exposureHistory.isMarket}"/>
    </td>
</tr>
<tr>
    <th>3 是否能见到候鸟或野禽：</th>
    <td>
        <ehr:dic-radio name="exposureHistory.isSeeAnimal" dicmeta="IDM00132" value="${caseDto.exposureHistory.isSeeAnimal}"/>
    </td>
</tr>
<tr>
    <th>4 近期是否有死亡候鸟或野禽：</th>
    <td>
        <ehr:dic-radio name="exposureHistory.isDieAnimal" dicmeta="PH00001" code="1,2,4" value="${caseDto.exposureHistory.isDieAnimal}"
                onchange="toggleOther('exposureHistory.isDieAnimal','isDieAnimalPart',1);"/>
    </td>
</tr>
<tbody id="isDieAnimalPart" style="display: none">
    <tr>
        <th>4.1 若有，常见地点：</th>
        <td><input type="text" name="exposureHistory.place" value="${caseDto.exposureHistory.place}" reg='{"maxlength":"100"}'/></td>
    </tr>
    <tr>
        <th>4.2 候鸟或野禽最近死亡时间：</th>
        <td><tag:dateInput name="exposureHistory.dieAnimalDate" onlypast="true" pattern="yyyy/MM/dd" style="width:100px;"
                           date="${caseDto.exposureHistory.dieAnimalDate}"/>
        </td>
    </tr>
</tbody>
<tr>
    <th>5 病例居住地点(村庄/居民区)动物饲养或病死情况：</th>
    <td>
        <ehr:dic-radio name="exposureHistory.isDieLive" dicmeta="PH00002" code="1,2" value="${caseDto.exposureHistory.isDieLive}"
                onchange="toggleOther('exposureHistory.isDieLive','isDieLivePart',1);"/>
    </td>
</tr>
<tr id="isDieLivePart" style="display: none">
    <td colspan="2">
        <div class="repeattable">
            <div class="toolbarsublist">
                <a href="javascript:hiwhpaiCase.popupEh(this,'add',1)"><b class="xinz">添加</b></a>
            </div>
            <table id="eh1Table">
                <thead>
                <tr>
                    <th class="centerth" style="width: 10%">养殖场名称</th>
                    <th class="centerth" style="width: 9%">动物种类</th>
                    <th class="centerth" style="width: 9%">饲养数量</th>
                    <th class="centerth" style="width: 9%">病/死数量</th>
                    <th class="centerth" style="width: 9%">病/死时间</th>
                    <th class="centerth">处理方式</th>
                    <th class="centerth" style="width: 9%">处理时间</th>
                    <th class="centerth" style="width: 110px;">参与处理人员数量</th>
                    <th class="centerth" style="width: 65px;">操作</th>
                </tr>
                </thead>
                <c:forEach var="eh1Obj" items="${caseDto.idmListEhList}" varStatus="status">
                    <c:if test="${eh1Obj.flag == 1}">
                        <tr>
                            <td field="farmName"><ehr:tip>${eh1Obj.farmName}</ehr:tip></td>
                            <td field="animalType"><ehr:tip>${eh1Obj.animalType}</ehr:tip></td>
                            <td field="animalNum"><ehr:tip>${eh1Obj.animalNum}</ehr:tip></td>
                            <td field="dieNum"><ehr:tip>${eh1Obj.dieNum}</ehr:tip></td>
                            <td field="dieDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${eh1Obj.dieDt}"/></ehr:tip></td>
                            <td field="processMode"><ehr:tip>${eh1Obj.processMode}</ehr:tip></td>
                            <td field="processDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${eh1Obj.processDt}"/></ehr:tip></td>
                            <td field="processNum"><ehr:tip>${eh1Obj.processNum}</ehr:tip></td>
                            <td class="btnsublist" field="btn">
                                <a href="javascript:void(0)" onclick="hiwhpaiCase.popupEh(this,'edit',1)">修改</a>&nbsp;
                                <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </div>
    </td>
</tr>
<tr>
    <td colspan="2">
        <div class="repeattable">
            <div class="toolbarsublist">
                6 家禽饲养户人员情况<a href="javascript:hiwhpaiCase.popupEh(this,'add',2)"><b class="xinz">添加</b></a>
            </div>
            <table id="eh2Table">
                <thead>
                <tr>
                    <th class="centerth">总户数</th>
                    <th class="centerth">总人口数</th>
                    <th class="centerth">常驻人口</th>
                    <th class="centerth">饲养家禽户数</th>
                    <th class="centerth">饲养家禽户人口数</th>
                    <th class="centerth">病死家禽户数</th>
                    <th class="centerth">病死家禽户人口数</th>
                    <th class="centerth" style="width: 130px;">异常表现人数(流感样病例/发热性疾病等)</th>
                    <th class="centerth" style="width: 65px;">操作</th>
                </tr>
                </thead>
                <c:forEach var="eh2Obj" items="${caseDto.idmListEhList}" varStatus="status">
                    <c:if test="${eh2Obj.flag == 2}">
                        <tr>
                            <td field="familyNum"><ehr:tip>${eh2Obj.familyNum}</ehr:tip></td>
                            <td field="peopleNum"><ehr:tip>${eh2Obj.peopleNum}</ehr:tip></td>
                            <td field="permanentPopulation"><ehr:tip>${eh2Obj.permanentPopulation}</ehr:tip></td>
                            <td field="fowlFamilyNum"><ehr:tip>${eh2Obj.fowlFamilyNum}</ehr:tip></td>
                            <td field="fowlPeopleNum"><ehr:tip>${eh2Obj.fowlPeopleNum}</ehr:tip></td>
                            <td field="dieFowlNum"><ehr:tip>${eh2Obj.dieFowlNum}</ehr:tip></td>
                            <td field="dieFowlPeopleNum"><ehr:tip>${eh2Obj.dieFowlPeopleNum}</ehr:tip></td>
                            <td field="exceptionNum"><ehr:tip>${eh2Obj.exceptionNum}</ehr:tip></td>
                            <td class="btnsublist" field="btn">
                                <a href="javascript:void(0)" onclick="hiwhpaiCase.popupEh(this,'edit',2)">修改</a>&nbsp;
                                <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </div>
    </td>
</tr>
<tr>
    <td colspan="2">
        <div class="repeattable">
            <div class="toolbarsublist">
                7 若居住地有养殖场,则<a href="javascript:hiwhpaiCase.popupEh(this,'add',3)"><b class="xinz">添加</b></a>
            </div>
            <table id="eh3Table">
                <thead>
                <tr>
                    <th class="centerth" >养殖场名称</th>
                    <th class="centerth" style="width: 30%">饲养动物种类及数量</th>
                    <th class="centerth" style="width: 30%">病/死动物种类及数量</th>
                    <th class="centerth" style="width: 110px;">操作</th>
                </tr>
                </thead>
                <c:forEach var="eh3Obj" items="${caseDto.idmListEhList}" varStatus="status">
                    <c:if test="${eh3Obj.flag == 3}">
                        <tr>
                            <td field="farmName"><ehr:tip>${eh3Obj.farmName}</ehr:tip></td>
                            <td field="animalType"><ehr:tip>${eh3Obj.animalType}</ehr:tip></td>
                            <td field="dieNum"><ehr:tip>${eh3Obj.dieNum}</ehr:tip></td>
                            <td class="btnsublist" field="btn">
                                <a href="javascript:void(0)" onclick="hiwhpaiCase.popupEh(this,'edit',3)">修改</a>&nbsp;
                                <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </div>
    </td>
</tr>
<tr>
    <td colspan="2">
        8 农业部门是否已经证实死亡家禽死于H5N1型禽流感
        <ehr:dic-radio name="exposureHistory.isDieHn" dicmeta="PH00001" value="${caseDto.exposureHistory.isDieHn}"/>
    </td>
</tr>
<tr id="isDieHnPart">
    <td colspan="2">
        <div class="repeattable">
            <div class="toolbarsublist">
                8.1 农业部门H5N1型禽流感病毒分离或PCR情况<a href="javascript:hiwhpaiCase.popupEh(this,'add',4)"><b class="xinz">添加</b></a>
            </div>
            <table id="eh4Table">
                <thead>
                <tr>
                    <th class="centerth" style="width: 150px;">分离(PCR)阳性标本类型</th>
                    <th class="centerth" style="width: 20%">采集地点</th>
                    <th class="centerth" style="width: 12%">采集时间</th>
                    <th class="centerth" style="width: 12%">分离时间</th>
                    <th class="centerth">分离单位</th>
                    <th class="centerth" style="width: 80px;">操作</th>
                </tr>
                </thead>
                <c:forEach var="eh4Obj" items="${caseDto.idmListEhList}" varStatus="status">
                    <c:if test="${eh4Obj.flag == 4}">
                        <tr>
                            <td field="pcr"><ehr:tip>${eh4Obj.pcr}</ehr:tip></td>
                            <td field="sampleAddr"><ehr:tip>${eh4Obj.sampleAddr}</ehr:tip></td>
                            <td field="sampleDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${eh4Obj.sampleDt}"/></ehr:tip></td>
                            <td field="separateDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${eh4Obj.separateDt}"/></ehr:tip></td>
                            <td field="separateUnit"><ehr:tip>${eh4Obj.separateUnit}</ehr:tip></td>
                            <td class="btnsublist" field="btn">
                                <a href="javascript:void(0)" onclick="hiwhpaiCase.popupEh(this,'edit',4)">修改</a>&nbsp;
                                <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </div>
    </td>
</tr>
<tr>
    <th>9 当地环境是否已经进行彻底消毒：</th>
    <td>
        <ehr:dic-radio name="exposureHistory.isDisinfect" dicmeta="PH00001" code="1,2,4" value="${caseDto.exposureHistory.isDisinfect}"
                onchange="toggleOther('exposureHistory.isDisinfect','disinfectDate',1);"/>
    </td>
</tr>
<tr id="disinfectDate" style="display: none">
    <th>9.1 若已经彻底消毒,则时间为：</th>
    <td>
        <tag:dateInput name="exposureHistory.disinfectDate"  onlypast="true" pattern="yyyy/MM/dd"
                       date="${caseDto.exposureHistory.disinfectDate}" style="width:100px;"/>
    </td>
</tr>
<tr>
    <td colspan="2">
        10 有病死动物后,当地有无流感样/发热/不明原因死亡病例等
        <ehr:dic-radio name="exposureHistory.isPat" dicmeta="PH00001" code="1,2,4" value="${caseDto.exposureHistory.isPat}"
                onchange="toggleOther('exposureHistory.isPat','isPatPart',1);"/>
    </td>
</tr>
<tr id="isPatPart" style="display: none">
    <td colspan="2">
        <div class="repeattable">
            <div class="toolbarsublist">
                10.1 若有,则填写以下表<a href="javascript:hiwhpaiCase.popupEh(this,'add',5)"><b class="xinz">添加</b></a>
            </div>
            <table id="eh5Table">
                <thead>
                <tr>
                    <th class="centerth" style="width: 11%">病例姓名</th>
                    <th class="centerth" style="width: 7%">性别</th>
                    <th class="centerth" style="width: 7%">年龄</th>
                    <th class="centerth" style="width: 12%">临床表现</th>
                    <th class="centerth" style="width: 12%">发病/死亡时间</th>
                    <th class="centerth" style="width: 20%">有无接触及时间</th>
                    <th class="centerth">备注</th>
                    <th class="centerth" style="width: 80px;">操作</th>
                </tr>
                </thead>
                <c:forEach var="eh5Obj" items="${caseDto.idmListEhList}" varStatus="status">
                    <c:if test="${eh5Obj.flag == 5}">
                        <tr>
                            <td field="name"><ehr:tip>${eh5Obj.name}</ehr:tip></td>
                            <td field="sexStr"><ehr:tip>${eh5Obj.sexStr}</ehr:tip></td>
                            <td field="age"><ehr:tip>${eh5Obj.age}</ehr:tip></td>
                            <td field="clinicalManifestation"><ehr:tip>${eh5Obj.clinicalManifestation}</ehr:tip></td>
                            <td field="saveDieDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${eh5Obj.saveDieDt}"/></ehr:tip></td>
                            <td field="contact"><ehr:tip>${eh5Obj.contact}</ehr:tip></td>
                            <td field="comments"><ehr:tip>${eh5Obj.comments}</ehr:tip></td>
                            <td field="sex" style="display: none"><ehr:tip>${eh5Obj.sex}</ehr:tip></td>
                            <td class="btnsublist" field="btn">
                                <a href="javascript:void(0)" onclick="hiwhpaiCase.popupEh(this,'edit',5)">修改</a>&nbsp;
                                <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </div>
    </td>
</tr>
</table>
</fieldset>
<fieldset>
<legend>六、病例家居环境情况</legend>
<table class="posttable">
<colgroup>
    <col style="width: 25%"/>
    <col style="width: 25%"/>
    <col style="width: 25%"/>
    <col style="width: 25%"/>
</colgroup>
<tr>
    <th>1 描述病例家庭位置(位置/附近水源等情况)：</th>
    <td colspan="3">
        <%--<input type="text" name="hygienicCondition.familyPosition" value="${caseDto.hygienicCondition.familyPosition}">--%>
        <textarea name="hygienicCondition.familyPosition" rows="3" reg='{"maxlength":"200"}' style="width: 100%;font-size: 12px;">${caseDto.hygienicCondition.familyPosition}</textarea>
    </td>
</tr>
<tr>
    <th>2 病例家庭：</th>
    <td colspan="3">
        <ehr:dic-radio name="hygienicCondition.casesFamily" dicmeta="IDM00133" value="${caseDto.hygienicCondition.casesFamily}"/>
    </td>
</tr>
<tr>
    <th>3 病人家居住房类型：</th>
    <td colspan="3">
        <ehr:dic-radio name="hygienicCondition.patHousingTypes" dicmeta="IDM00134" value="${caseDto.hygienicCondition.patHousingTypes}"/>
    </td>
</tr>
<tr>
    <th>4 房屋地板类型：</th>
    <td colspan="3">
        <ehr:dic-radio name="hygienicCondition.houseFloorType" dicmeta="IDM00135" value="${caseDto.hygienicCondition.houseFloorType}"/>
    </td>
</tr>
<tr>
    <th>5 多长时间打扫一次房间：</th>
    <td colspan="3">
        <input type="text" name="hygienicCondition.cleanRoomTime" value="${caseDto.hygienicCondition.cleanRoomTime}" reg='{"maxlength":"50"}'/>
    </td>
</tr>
<tr>
    <th>6 家中厨房菜板使用：</th>
    <td colspan="3">
        <ehr:dic-radio name="hygienicCondition.kitchenCuttingBoard" dicmeta="IDM00136" value="${caseDto.hygienicCondition.kitchenCuttingBoard}"
                onchange="toggleOther('hygienicCondition.kitchenCuttingBoard','procRawMeatAfter',2);"/>
    </td>
</tr>
<tr id="procRawMeatAfter" style="display: none">
    <th>6.1 若混用菜板，则加工完生肉类后：</th>
    <td colspan="3">
        <ehr:dic-radio name="hygienicCondition.procRawMeatAfter" dicmeta="IDM00137" value="${caseDto.hygienicCondition.procRawMeatAfter}"/>
    </td>
</tr>
<tr>
    <th>7 家庭成员的禽流感知识知晓情况：</th>
    <td colspan="3">
        <ehr:dic-radio name="hygienicCondition.isKnow" dicmeta="IDM00138" value="${caseDto.hygienicCondition.isKnow}"
                onchange="toggleOther('hygienicCondition.isKnow','fromType',1);"/>
    </td>
</tr>
<tr id="fromType" style="display: none">
    <th>7.1 若明白，则知识来于：</th>
    <td colspan="3">
        <ehr:dic-radio name="hygienicCondition.fromType" dicmeta="IDM00139" value="${caseDto.hygienicCondition.fromType}"/>
    </td>
</tr>
<tr>
    <td colspan="4">
        <div class="repeattable">
            <div class="toolbarsublist">
                8 家中禽类饲养情况<a href="javascript:hiwhpaiCase.popupHc(this,'add',3)"><b class="xinz">添加</b></a>
            </div>
            <table id="hc3Table">
                <thead>
                <tr>
                    <th class="centerth" style="width: 15">动物种类</th>
                    <th class="centerth" style="width: 10">饲养数量</th>
                    <th class="centerth" style="width: 10">饲养时间</th>
                    <th class="centerth" style="width: 15">活动范围</th>
                    <th class="centerth">动物粪便可见范围</th>
                    <th class="centerth" style="width: 80px;">操作</th>
                </tr>
                </thead>
                <c:forEach var="hc3Obj" items="${caseDto.idmListHcList}" varStatus="status">
                    <c:if test="${hc3Obj.flag == 3}">
                        <tr>
                            <td field="animalType"><ehr:tip>${hc3Obj.animalType}</ehr:tip></td>
                            <td field="animalNum"><ehr:tip>${hc3Obj.animalNum}</ehr:tip></td>
                            <td field="animalDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${hc3Obj.animalDt}"/></ehr:tip></td>
                            <td field="activityRangeDetail"><ehr:tip>${hc3Obj.activityRangeDetail}</ehr:tip></td>
                            <td field="dungRangeDetail"><ehr:tip>${hc3Obj.dungRangeDetail}</ehr:tip></td>
                            <td field="activityRange" style="display: none">${hc3Obj.activityRange}</td>
                            <td field="dungRange" style="display: none">${hc3Obj.dungRange}</td>
                            <td class="btnsublist" field="btn">
                                <a href="javascript:void(0)" onclick="hiwhpaiCase.popupHc(this,'edit',3)">修改</a>&nbsp;
                                <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </div>
    </td>
</tr>
<tr>
    <th>9 家禽圈位置，描述与病例居住房间关系：</th>
    <td colspan="3">
        <ehr:dic-radio name="hygienicCondition.anPatRel" dicmeta="IDM00142" value="${caseDto.hygienicCondition.anPatRel}"/>
    </td>
</tr>
<tr>
    <td colspan="4">
        <div class="repeattable">
            <div class="toolbarsublist">
                10 近期内病例家中病死动物情况<a href="javascript:hiwhpaiCase.popupHc(this,'add',1)"><b class="xinz">添加</b></a>
            </div>
            <table id="hc1Table">
                <thead>
                    <tr>
                        <th class="centerth"style="width: 15%">动物种类</th>
                        <th class="centerth"style="width: 13%">饲养数量</th>
                        <th class="centerth"style="width: 13%">病死数量</th>
                        <th class="centerth" style="width: 13%">发病/死亡时间</th>
                        <th class="centerth">死亡原因</th>
                        <th class="centerth">处理方式</th>
                        <th class="centerth" style="width: 80px;">操作</th>
                    </tr>
                </thead>
                <c:forEach var="hc1Obj" items="${caseDto.idmListHcList}" varStatus="status">
                    <c:if test="${hc1Obj.flag == 1}">
                        <tr>
                            <td field="animalType"><ehr:tip>${hc1Obj.animalType}</ehr:tip></td>
                            <td field="animalNum"><ehr:tip>${hc1Obj.animalNum}</ehr:tip></td>
                            <td field="dieNum"><ehr:tip>${hc1Obj.dieNum}</ehr:tip></td>
                            <td field="dieDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${hc1Obj.dieDt}"/></ehr:tip></td>
                            <td field="dieReason"><ehr:tip>${hc1Obj.dieReason}</ehr:tip></td>
                            <td field="processMode"><ehr:tip>${hc1Obj.processMode}</ehr:tip></td>
                            <td class="btnsublist" field="btn">
                                <a href="javascript:void(0)" onclick="hiwhpaiCase.popupHc(this,'edit',1)">修改</a>&nbsp;
                                <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </div>
    </td>
</tr>
<tr>
    <th>11 农业部门是否证实病死动物死于H5N1型禽流感：</th>
    <td>
        <ehr:dic-radio name="hygienicCondition.isDieAnHn" dicmeta="PH00001" code="1,2,4" value="${caseDto.hygienicCondition.isDieAnHn}"/>
    </td>
</tr>
<tr>
    <td colspan="4">
        <div class="repeattable">
            <div class="toolbarsublist">
                11.1 环境/病死禽畜采样情况<a href="javascript:hiwhpaiCase.popupHc(this,'add',2)"><b class="xinz">添加</b></a>
            </div>
            <table id="hc2Table">
                <thead>
                <tr>
                    <th class="centerth" style="width: 10%">采样种类</th>
                    <th class="centerth" style="width: 12%">采样时间</th>
                    <th class="centerth" style="width: 18%">采样地点</th>
                    <th class="centerth" style="width: 10%">采样份数</th>
                    <th class="centerth">检测结果</th>
                    <th class="centerth">检测单位</th>
                    <th class="centerth" style="width: 80px;">操作</th>
                </tr>
                </thead>
                <c:forEach var="hc2Obj" items="${caseDto.idmListHcList}" varStatus="status">
                    <c:if test="${hc2Obj.flag == 2}">
                        <tr>
                            <td field="sampleType"><ehr:tip>${hc2Obj.sampleType}</ehr:tip></td>
                            <td field="sampleDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${hc2Obj.sampleDt}"/></ehr:tip></td>
                            <td field="sampleAddr"><ehr:tip>${hc2Obj.sampleAddr}</ehr:tip></td>
                            <td field="sampleNum"><ehr:tip>${hc2Obj.sampleNum}</ehr:tip></td>
                            <td field="detectionResult"><ehr:tip>${hc2Obj.detectionResult}</ehr:tip></td>
                            <td field="detectionUnit"><ehr:tip>${hc2Obj.detectionUnit}</ehr:tip></td>
                            <td class="btnsublist" field="btn">
                                <a href="javascript:void(0)" onclick="hiwhpaiCase.popupHc(this,'edit',2)">修改</a>&nbsp;
                                <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </div>
    </td>
</tr>
<tr>
    <th>12 家庭环境是否进行彻底消毒：</th>
    <td>
        <ehr:dic-radio name="hygienicCondition.isDisinfectFamly" dicmeta="PH00001" code="1,2,4" value="${caseDto.hygienicCondition.isDisinfectFamly}"
                onchange="toggleOther('hygienicCondition.isDisinfectFamly','disinfectFamlyDate',1);"/>
    </td>
</tr>
<tr id="disinfectFamlyDate" style="display: none">
    <th>12.1 若已经彻底消毒，则时间为：</th>
    <td>
        <tag:dateInput name="hygienicCondition.disinfectFamlyDate"  onlypast="true" pattern="yyyy/MM/dd"
                       date="${caseDto.hygienicCondition.disinfectFamlyDate}"/>
    </td>
</tr>
<tr>
    <td colspan="4">
        <div class="repeattable">
            <div class="toolbarsublist">
                13 病例家庭成员及与病死动物接触方式<a href="javascript:hiwhpaiCase.popupHc(this,'add',4)"><b class="xinz">添加</b></a>
            </div>
            <table id="hc4Table">
                <thead>
                <tr>
                    <th class="centerth" style="width: 15%">姓名</th>
                    <th class="centerth" style="width: 10%">性别</th>
                    <th class="centerth" style="width: 10%">年龄</th>
                    <th class="centerth" style="width: 10%">发病与否</th>
                    <th class="centerth" style="width: 18%">接触病死动物种类</th>
                    <th class="centerth">接触病死动物方式</th>
                    <th class="centerth" style="width: 80px;">操作</th>
                </tr>
                </thead>
                <c:forEach var="hc4Obj" items="${caseDto.idmListHcList}" varStatus="status">
                    <c:if test="${hc4Obj.flag == 4}">
                        <tr>
                            <td field="name"><ehr:tip>${hc4Obj.name}</ehr:tip></td>
                            <td field="sexStr"><ehr:tip>${hc4Obj.sexStr}</ehr:tip></td>
                            <td field="age"><ehr:tip>${hc4Obj.age}</ehr:tip></td>
                            <td field="attackStr"><ehr:tip>${hc4Obj.attackStr}</ehr:tip></td>
                            <td field="dieAnimalCategory"><ehr:tip>${hc4Obj.dieAnimalCategory}</ehr:tip></td>
                            <td field="dieAnimalTypeDetail"><ehr:tip>${hc4Obj.dieAnimalTypeDetail}</ehr:tip></td>
                            <td field="sex" style="display: none">${hc4Obj.sex}</td>
                            <td field="attack" style="display: none">${hc4Obj.attack}</td>
                            <td field="dieAnimalType" style="display: none">${hc4Obj.dieAnimalType}</td>
                            <td class="btnsublist" field="btn">
                                <a href="javascript:void(0)" onclick="hiwhpaiCase.popupHc(this,'edit',4)">修改</a>&nbsp;
                                <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </div>
    </td>
</tr>
</table>
</fieldset>
<fieldset>
    <legend>七、病例生活习惯、既往健康史</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 25%"/>
            <col style="width: 25%"/>
            <col style="width: 25%"/>
            <col style="width: 25%"/>
        </colgroup>
        <tr>
            <th>1 饭前洗手：</th>
            <td colspan="3">
                <ehr:dic-radio name="hygienicCondition.wash" dicmeta="IDM00145" value="${caseDto.hygienicCondition.wash}"/>
            </td>
        </tr>
        <tr>
            <th>2 是否抽烟：</th>
            <td>
                <ehr:dic-radio name="hygienicCondition.isSmoke" dicmeta="PH00001" value="${caseDto.hygienicCondition.isSmoke}" code="1,2"
                        onchange="toggleOther('hygienicCondition.isSmoke','spliffNum',1);"/>
            </td>
        </tr>
        <tr id="spliffNum" style="display: none">
            <th>3.1 若抽烟，每天几支：</th>
            <td colspan="3">
                <ehr:dic-radio name="hygienicCondition.spliffNum" dicmeta="IDM00062" value="${caseDto.hygienicCondition.spliffNum}"/>
            </td>
        </tr>
        <tr>
            <th>4 是否有慢性疾病，若有(医生已经诊断,可多选)：</th>
            <td colspan="3">
                <ehr:dic-checkbox name="hygienicCondition.chronicDisease" dicmeta="IDM00146" value="${caseDto.hygienicCondition.chronicDisease}"/>
            </td>
        </tr>
        <tr>
            <th>5 一年内是否接种流感疫苗：</th>
            <td>
                <ehr:dic-radio name="hygienicCondition.tiv" dicmeta="PH00001" code="1,2" value="${caseDto.hygienicCondition.tiv}"
                        onchange="toggleOther('hygienicCondition.tiv','tivLastInoculateDate',1);"/>
            </td>
        </tr>
        <tr id="tivLastInoculateDate" style="display: none">
            <th>5.1 如有，最后一次接种日期：</th>
            <td><tag:dateInput name="hygienicCondition.tivLastInoculateDate"  onlypast="true" pattern="yyyy/MM/dd"
                               date="${caseDto.hygienicCondition.tivLastInoculateDate}"/></td>
        </tr>
        <tr>
            <th>6 是否曾注射免疫球蛋白：</th>
            <td>
                <ehr:dic-radio name="hygienicCondition.immunoglobulin" dicmeta="PH00001" code="1,2,4" value="${caseDto.hygienicCondition.immunoglobulin}"
                        onchange="toggleOther('hygienicCondition.immunoglobulin','immLastInoculateDate',1);"/>
            </td>
        </tr>
        <tr id="immLastInoculateDate" style="display: none">
            <th>6.1 如有，最后一次接种日期：</th>
            <td><tag:dateInput name="hygienicCondition.immLastInoculateDate" onlypast="true" pattern="yyyy/MM/dd"
                               date="${caseDto.hygienicCondition.immLastInoculateDate}"/></td>
        </tr>
    </table>
</fieldset>
<fieldset>
<legend>八、病例发病前的暴露情况</legend>
<table class="posttable">
<colgroup>
    <col style="width: 37%"/>
    <col style="width: 63%"/>
</colgroup>
<tr>
    <th>1 病前2周内是否接触禽类及其它动物：</th>
    <td>
        <ehr:dic-radio name="exposureHistory.contactAnimal" dicmeta="PH00001" code="1,2,4" value="${caseDto.exposureHistory.contactAnimal}"
                onchange="hiwhpaiCase.toggleContactAnimal('exposureHistory.contactAnimal');"/>
    </td>
</tr>
<tbody id="contactAnimalCategoryPart" style="display: none">
    <tr>
        <th>1.1 若接触，则接触动物种类：</th>
        <td colspan="3">
            <ehr:dic-checkbox name="exposureHistory.contactAnimalCategory" dicmeta="IDM00147" code="1,2,3,4,99"
                           value="${caseDto.exposureHistory.contactAnimalCategory}"/>
        </td>
    </tr>
    <tr>
        <th>1.2 接触方式：</th>
        <td colspan="2">
            <ehr:dic-checkbox name="exposureHistory.contactAnimalWay" dicmeta="IDM00148" value="${caseDto.exposureHistory.contactAnimalWay}"/>
        </td>
    </tr>
    <tr>
        <th>1.3 接触时间：</th>
        <td><tag:dateInput name="exposureHistory.contactAnimalDt" onlypast="true" pattern="yyyy/MM/dd" style="width:100px;"
                date="${caseDto.exposureHistory.contactAnimalDt}"/></td>
    </tr>
    <tr>
        <th>1.4 接触家禽后是否洗手：</th>
        <td>
            <ehr:dic-radio name="exposureHistory.waterCategory" dicmeta="IDM00137" value="${caseDto.exposureHistory.waterCategory}"/>
        </td>
    </tr>
</tbody>
<tr id="publicPlace" style="display: none">
    <th>1.5 若未接触过禽类及其它动物，是否在病前2周内到过：</th>
    <td>
        <ehr:dic-checkbox name="exposureHistory.publicPlace" dicmeta="IDM00149" value="${caseDto.exposureHistory.publicPlace}"/>
    </td>
</tr>
<tr>
    <th>2 病前2周内是否接触病死禽类：</th>
    <td>
        <ehr:dic-radio name="exposureHistory.dieAnimalCategory" dicmeta="PH00001" code="1,2,4" value="${caseDto.exposureHistory.dieAnimalCategory}"
                onchange="toggleOther('exposureHistory.dieAnimalCategory','dieAnimalCategoryPart',1);"/>
    </td>
</tr>
<tbody id="dieAnimalCategoryPart" style="display: none">
    <tr>
        <th>2.1 若接触，则接触种类：</th>
        <td>
            <ehr:dic-checkbox name="exposureHistory.animalContactCategory" dicmeta="IDM00147" value="${caseDto.exposureHistory.animalContactCategory}"/>
        </td>
    </tr>
    <tr>
        <th>2.2 若接触，则接触方式：</th>
        <td>
            <ehr:dic-checkbox name="exposureHistory.animalContactWay" dicmeta="IDM00150" value="${caseDto.exposureHistory.animalContactWay}"
                    onchange="toggleOtherCK('exposureHistory.animalContactWay','boilCategory',5);"/>
        </td>
    </tr>
    <tr>
        <th>2.3 接触时间：</th>
        <td>
            <tag:dateInput name="exposureHistory.animalContactDt" onlypast="true" pattern="yyyy/MM/dd" style="width:100px;"
                           date="${caseDto.exposureHistory.animalContactDt}"/>
        </td>
    </tr>

    <tr id="boilCategory" style="display: none">
        <th>2.4 若食用病死禽肉，则所食用时是否熟透：</th>
        <td>
            <ehr:dic-radio name="exposureHistory.boilCategory" dicmeta="PH00001" code="1,2,4" value="${caseDto.exposureHistory.boilCategory}"/>
        </td>
    </tr>
</tbody>
<tr>
    <th>3 病前2周内，若参与宰杀、加工病死禽类，则主要方式：</th>
    <td>
        <ehr:dic-checkbox name="exposureHistory.slaughterCategoey" dicmeta="IDM00152" value="${caseDto.exposureHistory.slaughterCategoey}"/>
    </td>
</tr>
<tr>
    <th>3.1 接触病死禽期间，手部伤口情况：</th>
    <td>
        <ehr:dic-radio name="exposureHistory.woundCategory" dicmeta="IDM00153" value="${caseDto.exposureHistory.woundCategory}"/>
    </td>
</tr>
<tr>
    <th>3.2 处理病死禽类时是否采取防护措施及其它预防措施：</th>
    <td>
        <ehr:dic-checkbox name="exposureHistory.conservatoryMeasureAnimal" dicmeta="IDM00154" value="${caseDto.exposureHistory.conservatoryMeasureAnimal}"/>
    </td>
</tr>
<tr>
    <th>3.3 处理病死禽后是否洗手：</th>
    <td>
        <ehr:dic-radio name="exposureHistory.dieAnimalWaterCategory" dicmeta="IDM00145" value="${caseDto.exposureHistory.dieAnimalWaterCategory}"/>
    </td>
</tr>
<tr>
    <th>4 发病前2周内是否与其它发热病人有所接触：</th>
    <td>
        <ehr:dic-radio name="exposureHistory.feverPatientContact" dicmeta="PH00001" code="1,2,4" value="${caseDto.exposureHistory.feverPatientContact}"
                onchange="toggleOther('exposureHistory.feverPatientContact','feverPatientContactPact',1);"/>
    </td>
</tr>
<tbody id="feverPatientContactPact" style="display: none">
    <tr>
        <td colspan="2">
            <div class="repeattable">
                <div class="toolbarsublist">
                    4.1 若接触过，则填写下表<a href="javascript:hiwhpaiCase.popupEh(this,'add',6)"><b class="xinz">添加</b></a>
                </div>
                <table id="eh6Table">
                    <thead>
                    <tr>
                        <th class="centerth" style="width: 10%">病例姓名</th>
                        <th class="centerth" style="width: 12%">发病时间</th>
                        <th class="centerth" style="width: 10%">临床表现</th>
                        <th class="centerth" style="width: 10%">诊断</th>
                        <th class="centerth" style="width: 13%">最后接触时间</th>
                        <th class="centerth">接触方式及频率</th>
                        <th class="centerth">接触地点</th>
                        <th class="centerth" style="width: 80px;">操作</th>
                    </tr>
                    </thead>
                    <c:forEach var="eh6Obj" items="${caseDto.idmListEhList}" varStatus="status">
                        <c:if test="${eh6Obj.flag == 6}">
                            <tr>
                                <td field="name"><ehr:tip>${eh6Obj.name}</ehr:tip></td>
                                <td field="attackDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${eh6Obj.attackDt}"/></ehr:tip></td>
                                <td field="clinicalManifestation"><ehr:tip>${eh6Obj.clinicalManifestation}</ehr:tip></td>
                                <td field="diagnosis"><ehr:tip>${eh6Obj.diagnosis}</ehr:tip></td>
                                <td field="contactDtLast"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${eh6Obj.contactDtLast}"/></ehr:tip></td>
                                <td field="contactTypeRate"><ehr:tip>${eh6Obj.contactTypeRate}</ehr:tip></td>
                                <td field="contactAddr"><ehr:tip>${eh6Obj.contactAddr}</ehr:tip></td>
                                <td class="btnsublist" field="btn">
                                    <a href="javascript:void(0)" onclick="hiwhpaiCase.popupEh(this,'edit',6)">修改</a>&nbsp;
                                    <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
            </div>
        </td>
    </tr>
    <tr>
        <th>4.2 若在医院接触病人，则与病人接触时是否戴口罩：</th>
        <td>
            <ehr:dic-radio name="exposureHistory.mask" dicmeta="PH00001" code="1,2" value="${caseDto.exposureHistory.mask}"/>
        </td>
    </tr>
    <tr>
        <th>4.3 若看望病人，看望病人后是否洗手：</th>
        <td>
            <ehr:dic-radio name="exposureHistory.water" dicmeta="PH00001" code="1,2" value="${caseDto.exposureHistory.water}"/>
        </td>
    </tr>
</tbody>
<tr>
    <th>5 发病前2周内，是否到过禽流感病毒学实验室：</th>
    <td>
        <ehr:dic-radio name="exposureHistory.hnLabWeek" dicmeta="PH00001" code="1,2" value="${caseDto.exposureHistory.hnLabWeek}"
                onchange="toggleOther('exposureHistory.hnLabWeek','conservatoryMeasureLabWeek',1);"/>
    </td>
</tr>
<tr id="conservatoryMeasureLabWeek" style="display: none">
    <th>5.1 若曾到过实验室，是否进行防护：</th>
    <td>
        <ehr:dic-radio name="exposureHistory.conservatoryMeasureLabWeek" dicmeta="PH00001" code="1,2" value="${caseDto.exposureHistory.conservatoryMeasureLabWeek}"/>
    </td>
</tr>

<tr>
    <td colspan="2">
        <div class="repeattable">
            <div class="toolbarsublist">
                6 病例旅行史（发病前2周内）<a href="javascript:hiwhpaiCase.popupEh(this,'add',7)"><b class="xinz">添加</b></a>
            </div>
            <table id="eh7Table">
                <thead>
                <tr>
                    <th class="centerth" style="width: 20%">旅行起始地</th>
                    <th class="centerth" style="width: 12%">旅行时间</th>
                    <th class="centerth" style="width: 20%">旅行目的地</th>
                    <th class="centerth">发病地点以外所到地区情况</th>
                    <th class="centerth" style="width: 80px;">操作</th>
                </tr>
                </thead>
                <c:forEach var="eh7Obj" items="${caseDto.idmListEhList}" varStatus="status">
                    <c:if test="${eh7Obj.flag == 7}">
                        <tr>
                            <td field="travelBegin"><ehr:tip>${eh7Obj.travelBegin}</ehr:tip></td>
                            <td field="travelDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${eh7Obj.travelDt}"/></ehr:tip></td>
                            <td field="travelAddr"><ehr:tip>${eh7Obj.travelAddr}</ehr:tip></td>
                            <td field="condition"><ehr:tip>${eh7Obj.condition}</ehr:tip></td>
                            <td class="btnsublist" field="btn">
                                <a href="javascript:void(0)" onclick="hiwhpaiCase.popupEh(this,'edit',7)">修改</a>&nbsp;
                                <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </div>
    </td>
</tr>
</table>
</fieldset>
<fieldset>
    <legend>九、密切接触者情况（具体见附件4中的表2）</legend>
    <div id="contactedList">
		<jsp:include page="contactedList.jsp"></jsp:include>
    </div>
</fieldset>
<fieldset>
    <legend>十、实验室检查</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 15%"/>
            <col style="width: 85%"/>
        </colgroup>
        <tr>
            <td colspan="2">
                <div class="repeattable">
                    <div class="toolbarsublist">
                        1.血常规&nbsp;&nbsp;<a href="javascript:hiwhpaiCase.popupLe(this,'add',1)"><b class="xinz">添加</b></a>
                    </div>
                    <table id="le1Table">
                        <thead>
                        <tr>
                            <th class="centerth" style="width: 15%">检查日期</th>
                            <th class="centerth" style="width: 15%">WBC（10<sup>9</sup>/L）</th>
                            <th class="centerth" style="width: 15%">N（%）</th>
                            <th class="centerth" style="width: 15%">L（%）</th>
                            <th class="centerth">检测单位</th>
                            <th class="centerth" style="width: 80px;">操作</th>
                        </tr>
                        </thead>
                        <c:forEach var="le1Obj" items="${caseDto.idmListLeList}" varStatus="status">
                            <c:if test="${le1Obj.flag == 1}">
                                <tr>
                                    <td field="routineBloodTestDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${le1Obj.routineBloodTestDt}"/></ehr:tip></td>
                                    <td field="wbc"><ehr:tip>${le1Obj.wbc}</ehr:tip></td>
                                    <td field="n"><ehr:tip>${le1Obj.n}</ehr:tip></td>
                                    <td field="l"><ehr:tip>${le1Obj.l}</ehr:tip></td>
                                    <td field="detectionUnit"><ehr:tip>${le1Obj.detectionUnit}</ehr:tip></td>
                                    <td class="btnsublist" field="btn">
                                        <a href="javascript:void(0)" onclick="hiwhpaiCase.popupLe(this,'edit',1)">修改</a>&nbsp;
                                        <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <div class="repeattable">
                    <div class="toolbarsublist">
                        2.Ｘ线检查&nbsp;&nbsp;<a href="javascript:hiwhpaiCase.popupLe(this,'add',2)"><b class="xinz">添加</b></a>
                    </div>
                    <table id="le2Table">
                        <thead>
                        <tr>
                            <th class="centerth" style="width: 18%">检查日期</th>
                            <th class="centerth" style="width: 30%">结果</th>
                            <th class="centerth">检测单位</th>
                            <th class="centerth" style="width: 80px;">操作</th>
                        </tr>
                        </thead>
                        <c:forEach var="le2Obj" items="${caseDto.idmListLeList}" varStatus="status">
                            <c:if test="${le2Obj.flag == 2}">
                                <tr>
                                    <td field="xDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${le2Obj.xDt}"/></ehr:tip></td>
                                    <td field="resultContent"><ehr:tip>${le2Obj.resultContent}</ehr:tip></td>
                                    <td field="detectionUnit"><ehr:tip>${le2Obj.detectionUnit}</ehr:tip></td>
                                    <td class="btnsublist" field="btn">
                                        <a href="javascript:void(0)" onclick="hiwhpaiCase.popupLe(this,'edit',2)">修改</a>&nbsp;
                                        <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <div class="repeattable">
                    <div class="toolbarsublist">
                        3.CT检查&nbsp;&nbsp;<a href="javascript:hiwhpaiCase.popupLe(this,'add',3)"><b class="xinz">添加</b></a>
                    </div>
                    <table id="le3Table">
                        <thead>
                        <tr>
                            <th class="centerth" style="width: 18%">检查日期</th>
                            <th class="centerth" style="width: 30%">结果</th>
                            <th class="centerth">检测单位</th>
                            <th class="centerth" style="width: 80px;">操作</th>
                        </tr>
                        </thead>
                        <c:forEach var="le3Obj" items="${caseDto.idmListLeList}" varStatus="status">
                            <c:if test="${le3Obj.flag == 3}">
                                <tr>
                                    <td field="ctDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${le3Obj.ctDt}"/></ehr:tip></td>
                                    <td field="resultContent"><ehr:tip>${le3Obj.resultContent}</ehr:tip></td>
                                    <td field="detectionUnit"><ehr:tip>${le3Obj.detectionUnit}</ehr:tip></td>
                                    <td class="btnsublist" field="btn">
                                        <a href="javascript:void(0)" onclick="hiwhpaiCase.popupLe(this,'edit',3)">修改</a>&nbsp;
                                        <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <div class="repeattable">
                    <div class="toolbarsublist">
                        4.病原学和血清学检查&nbsp;&nbsp;<a href="javascript:hiwhpaiCase.popupLe(this,'add',4)"><b class="xinz">添加</b></a>
                    </div>
                    <table id="le4Table">
                        <thead>
                        <tr>
                            <th class="centerth" style="width: 15%">标本类型</th>
                            <th class="centerth" style="width: 12%">采集时间</th>
                            <th class="centerth" style="width: 12%">检测方法</th>
                            <th class="centerth">检测结果</th>
                            <th class="centerth">检测单位</th>
                            <th class="centerth" style="width: 12%">检测时间</th>
                            <th class="centerth" style="width: 80px;">操作</th>
                        </tr>
                        </thead>
                        <c:forEach var="le4Obj" items="${caseDto.idmListLeList}" varStatus="status">
                            <c:if test="${le4Obj.flag == 4}">
                                <tr>
                                    <td field="sampleType"><ehr:tip>${le4Obj.sampleType}</ehr:tip></td>
                                    <td field="collectDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${le4Obj.collectDt}"/></ehr:tip></td>
                                    <td field="method"><ehr:tip>${le4Obj.method}</ehr:tip></td>
                                    <td field="checkResult"><ehr:tip>${le4Obj.checkResult}</ehr:tip></td>
                                    <td field="detectionUnit"><ehr:tip>${le4Obj.detectionUnit}</ehr:tip></td>
                                    <td field="checkFt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${le4Obj.checkFt}"/></ehr:tip></td>
                                    <td class="btnsublist" field="btn">
                                        <a href="javascript:void(0)" onclick="hiwhpaiCase.popupLe(this,'edit',4)">修改</a>&nbsp;
                                        <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </div>
            </td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>十一、转归与最终诊断情况</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 20%"/>
            <col style="width: 30%"/>
            <col style="width: 20%"/>
            <col style="width: 30%"/>
        </colgroup>
        <tr>
            <th>1 最终诊断：</th>
            <td colspan="3">
                <ehr:dic-radio name="otherCondition.finalDiagnosis" dicmeta="IDM00040" value="${caseDto.otherCondition.finalDiagnosis}" code="3,1,2,5"
                        onchange="toggleOther('otherCondition.finalDiagnosis','clinicalCaseExcludeName',5);"/>
                <span id="clinicalCaseExcludeName" style="display: none">
                      (病名:<input type="text" name="otherCondition.clinicalCaseExcludeName" value="${caseDto.otherCondition.clinicalCaseExcludeName}"
                        style="width: 150px;" reg='{"maxlength":"100"}'/>)
                </span>
            </td>
        </tr>
        <tr>
            <th>2 诊断单位：</th>
            <td colspan="2">
                <input type="text" name="otherCondition.diagnosisUnit" value="${caseDto.otherCondition.diagnosisUnit}" reg='{"maxlength":"100"}'/>
            </td>
        </tr>
        <tr>
            <th>3 转归：</th>
            <td colspan="3">
                <ehr:dic-radio name="otherCondition.outcomeCode" dicmeta="IDM00005" code="1,4,99" value="${caseDto.otherCondition.outcomeCode}"
                        onchange="hiwhpaiCase.toggleOutcome('otherCondition.outcomeCode');"/>
            </td>
        </tr>
        <tr id="outhosDate" style="display: none">
            <th>3.1若痊愈，出院日期：</th>
            <td>
                <tag:dateInput name="otherCondition.outhosDate" onlypast="true" pattern="yyyy/MM/dd" date="${caseDto.otherCondition.outhosDate}"/>
            </td>
            <td></td>
            <td></td>
        </tr>
        <tr id="deathPart" style="display: none">
            <th>3.2 若死亡，死亡日期：</th>
            <td colspan="3">
                <tag:dateInput name="otherCondition.deathTime" onlypast="true" pattern="yyyy/MM/dd" date="${caseDto.otherCondition.deathTime}"
                        style="width:100px;"/>
                死亡原因<input type="text" name="otherCondition.deathCause" value="${caseDto.otherCondition.deathCause}" reg='{"maxlength":"100"}'
                    style="width: 200px;"/>
            </td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>十二、调查小结</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 20%"/>
            <col style="width: 30%"/>
            <col style="width: 20%"/>
            <col style="width: 30%"/>
        </colgroup>
        <tr>
            <th>调查者单位：</th>
            <td>
                <ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/>
            </td>
            <th>调查时间：</th>
            <td>
                <tag:dateInput name="caseInformation.modifySurveyDate"
                               pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.caseInformation.modifySurveyDate}"/>
            </td>
        </tr>
        <tr>
            <th>调查者：</th>
            <td>
                <ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
            </td>
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
</div>
</div>
</form>
