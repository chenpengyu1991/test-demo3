<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/conjunctivitis.js" type="text/javascript"></script>

<c:if test="${isPrint != 1}">
    <jsp:include page="caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
    <div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
<i class="popno">
    急性出血性结膜炎个案调查表<br />
    <span>（丙类传染病）</span>
</i>
<table class="posttable">
    <tr style="text-align: right;">
        <td>
            国标码：
            <input type="text" name="generalCondition.gbcode" style="width: 120px;"
                   value="${caseDto.generalCondition.gbcode}"  reg='{"maxlength":"14"}'/>
        </td>
    <td>
    病例编码：
        <input type="text" name="caseInformation.mediRecordNum" style="width: 120px;"
               value="${caseDto.caseInformation.mediRecordNum}"  reg='{"maxlength":"14"}'/>
        <input type="hidden" name="idmId" value="${idmId}" />
    </td>
    </tr>
</table>

<div class="postdiv">
    <fieldset>
        <legend>1.一般情况</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 22%" />
                <col style="width: 28%" />
                <col style="width: 20%" />
                <col style="width: 30%" />
            </colgroup>
            <tr>
                <th>1.1 姓名：</th>
                <td>
                    <input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}" reg='{"maxlength":"100"}' style="width:100px;"/>
                </td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <th>1.2 性别：</th>
                <td>
                    <ehr:dic-radio id="gender" name="generalCondition.gender"
                                   dicmeta="GBT226112003" value="${caseDto.generalCondition.gender}" code="1,2" />
                </td>
            </tr>
            <tr>
                <th>1.3 出生日期：</th>
                <td colspan="3">
                    <tag:dateInput name="generalCondition.birthday" pattern="yyyy/MM/dd" date="${caseDto.generalCondition.birthday}" style="width:100px;"/>
                    （如出生日期不详，实足年龄
                    <input type="text"  id="age" name="generalCondition.age" value="${caseDto.generalCondition.age}"
                           reg='{"maxlength":"6"}' style="width: 60px; text-align: center"/>
                    年龄单位：<ehr:dic-radio name="generalCondition.ageUnit" dicmeta="IDM00003" value="${caseDto.generalCondition.ageUnit}"/>）
                </td>
            </tr>
            <tr>
                <th>1.4 职业：</th>
                <td colspan="3">
                    <ehr:dic-list id="occupationId" dicmeta="GBT6565" name="generalCondition.occupation" width="180px;" value="${caseDto.generalCondition.occupation}"
                                  code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120299,CV020120217"
                                  onchange="toggleOtherSC('generalCondition.occupation','occupationOtherPart','CV020120299');"/>
                    <span id="occupationOtherPart" style="display: none">
                        <input type="text" name="generalCondition.occupationOther" value="${caseDto.generalCondition.occupationOther}"
                               style="width: 200px;" placeholder="选择其他，请描叙" reg='{"maxlength":"100"}'/>
                    </span>
                </td>
            </tr>
            <tr>
                <th>1.5 现居住地：</th>
                <td colspan="3">
                    <ehr:dic-town-street-village streetId="pastreet_address" townId="patown_address" streetName="generalCondition.pastreet" townName="generalCondition.patownShip"
														 streetValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="140px;"
														 villageId="pavillage_address" villageName="generalCondition.paGroup" villageValue="${caseDto.generalCondition.paGroup}"/>
							<input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
			                        reg='{"maxlength":"50"}'  style="width: 180px;">
			             	<span id="spanPaNumber">(门牌号)</span>
                    <br>联系电话：<input type="text" name="generalCondition.phoneNumber" value="${caseDto.generalCondition.phoneNumber}"
                                    reg='{"regex":"phone"}' style="width: 130px;"/>
                </td>
            </tr>
            <tr>
                <th>1.6 工作学习单位：</th>
                <td>

                    <input type="text" id="unitName" name="generalCondition.unitName" value="${caseDto.generalCondition.unitName}"
                           reg='{"maxlength":"70"}'  >
                </td>
            </tr>
            <tr>
                <th>1.7 家庭人数：</th>
                <td><input type="text" name="generalCondition.familyNum" value="${caseDto.generalCondition.familyNum}" reg='{"maxlength":"20","regex":"number"}' style="width: 100px;"/></td>
            </tr>
            <tr>
                <th>1.8 患病人数：</th>
                <td><input type="text" name="generalCondition.prevalence" value="${caseDto.generalCondition.prevalence}" reg='{"maxlength":"20","regex":"number"}' style="width: 100px;"/></td>
            </tr>
            <%--<tr>
                <th>1.2 身份证号码：</th>
                <td><input type="text" id="idCard" name="generalCondition.idcard" value="${caseDto.generalCondition.idcard}" reg='{"idCard":"true"}'
                           placeholder="输入身份证获取个人信息"/></td>
            </tr>
            <tr>
                <th>1.6 文化程度：</th>
                <td colspan="3"><ehr:dic-radio name="generalCondition.education" dicmeta="GBT46582006" code="IDM06,IDM07,IDM02,IDM03,IDM08,IDM09,IDM10"
                                               value="${caseDto.generalCondition.education}"/></td>
            </tr>
            <tr>
                <th>1.7 病人属于：</th>
                <td colspan="3">
                    <ehr:dic-radio name="generalCondition.patientAttribute" dicmeta="CV0201104" value="${caseDto.generalCondition.patientAttribute}"
                            onchange="conjunctivitisCase.toggerAddress();"/>
                </td>
            </tr>
            <tr>
                <th>1.11 家长或监护人姓名：</th>
                <td><input type="text" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}" reg='{"maxlength":"50"}'/></td>
            </tr>
            <tr>
                <th>1.12 病例分类：</th>
                <td colspan="3">
                    <ehr:dic-radio name="otherCondition.caseType" dicmeta="IDM00040" code="1,2,3" value="${caseDto.otherCondition.caseType}"/>
                </td>
            </tr>--%>
            <tr>
                <th>1.9 发病日期：</th>
                <td>
                    <tag:dateInput id="pathogenesisDateId" name="attackCondition.pathogenesisDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.pathogenesisDate}" style="width:100px;"  reg='{"compare":["firstVisitDateId","le","发病日期不能晚于初诊日期"]}'/>
                </td>
            </tr>
            <tr>
                <th>1.10 就诊日期：</th>
                <td>
                    <tag:dateInput id="firstVisitDateId" name="attackCondition.firstVisitDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.firstVisitDate}" style="width:100px;"  reg='{"compare":["pathogenesisDateId","ge","初诊日期不能早于发病日期"]}'/>
                </td>
            </tr>
            <tr>
                <th>1.11 就诊单位：</th>
                <td>
                    <input type="text" name="attackCondition.firstVisitUnit" value="${caseDto.attackCondition.firstVisitUnit}" reg='{"maxlength":"100"}'/>
                </td>
            </tr><%--
            <tr>
                <th>1.16 初诊病名：</th>
                <td><input type="text" name="attackCondition.firstVisitName" value="${caseDto.attackCondition.firstVisitName}" reg='{"maxlength":"100"}'/></td>
            </tr>
            <tr>
                <th>1.17 确诊日期：</th>
                <td>
                    <tag:dateInput name="attackCondition.confirmationDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.confirmationDate}" style="width:100px;" reg='{"compare":["firstVisitDateId","ge","确诊时间不能早于初诊时间"]}'/>
                </td>
            </tr>
            <tr>
                <th>1.18 确诊单位：</th>
                <td>
                    <input type="text" name="attackCondition.confirmationHospital" value="${caseDto.attackCondition.confirmationHospital}"  reg='{"maxlength":"100"}'/>
                </td>
            </tr>--%>
        </table>
    </fieldset>
    <fieldset>
    <legend>2.主要临床表现</legend>
    <table class="posttable">
    <colgroup>
        <col style="width: 22%" />
        <col style="width: 28%" />
        <col style="width: 20%" />
        <col style="width: 30%" />
    </colgroup>
            <tr>
            <th>2 诊断：</th>
            <td>
                <ehr:dic-radio name="clinicalManifestations.clinicalKind" dicmeta="IDM00555" value="${caseDto.clinicalManifestations.clinicalKind}"/>
            </td>
            <td></td>
            <td></td>
            </tr>

            <tr>
            <th>2.1病程：</th>
            <td>
                <input type="text" name="clinicalManifestations.courseDays" value="${caseDto.clinicalManifestations.courseDays}"
                       style="width: 80px;text-align: center" reg='{"maxlength":"20","regex":"number"}'/>天
            </td>
            </tr>
            <tr>
                <th>2.2 眼刺痒：</th>
                <td>
                    <ehr:dic-radio name="clinicalManifestations.itchyEyes" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.itchyEyes}"/>
                </td>
            </tr>
            <tr>
                <th>2.3 眼睑沉重：</th>
                <td>
                    <ehr:dic-radio name="clinicalManifestations.heavyEyelid" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.heavyEyelid}"/>
                </td>
            </tr>
            <tr>
                <th>2.4 畏光流泪：</th>
                <td>
                    <ehr:dic-radio name="clinicalManifestations.photophobiaTears" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.photophobiaTears}"/>
                </td>
            </tr>
            <tr>
                <th>2.5 灼热：</th>
                <td>
                    <ehr:dic-radio name="clinicalManifestations.scorchingHot" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.scorchingHot}"/>
                </td>
            </tr>
            <tr>
                <th>2.6 视物不清：</th>
                <td>
                    <ehr:dic-radio name="clinicalManifestations.unclearVision" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.unclearVision}"/>
                </td>
            </tr>
            <tr>
                <th>2.7 肿胀：</th>
                <td>
                    <ehr:dic-radio name="clinicalManifestations.swell" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.swell}"/>
                </td>
            </tr>
            <tr>
                <th>2.8 粘液分泌物：</th>
                <td>
                    <ehr:dic-radio name="clinicalManifestations.mucosaSecretion" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.mucosaSecretion}"/>
                </td>
            </tr>
            <tr>
                <th>2.9 脓性分泌物：</th>
                <td>
                    <ehr:dic-radio name="clinicalManifestations.purulentSecretion" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.purulentSecretion}"/>
                </td>
            </tr>
            <tr>
                <th>2.10 眼结膜充血：</th>
                <td>
                    <ehr:dic-radio name="clinicalManifestations.conjunctivalCongestion" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.conjunctivalCongestion}"/>
                </td>
            </tr>
        <tr>
            <th>2.11 发热：</th>
            <td>
                <ehr:dic-radio name="clinicalManifestations.feverLimits" dicmeta="IDM00058" value="${caseDto.clinicalManifestations.feverLimits}"/>
            </td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <th>2.12 四肢酸痛：</th>
            <td>
                <ehr:dic-radio name="clinicalManifestations.limbAche" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.limbAche}"/>
            </td>
        </tr>
        <tr>
            <th>2.13 乏力：</th>
            <td>
                <ehr:dic-radio name="clinicalManifestations.feeble" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.feeble}"/>
            </td>
        </tr>
            <tr>
                <th>2.14 其它：</th>
                <td>
                    <input type="text" name="clinicalManifestations.other" value="${caseDto.clinicalManifestations.other}" reg='{"maxlength":"500"}'/>
                </td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend>3.流行病学调查</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 22%" />
                <col style="width: 28%" />
                <col style="width: 20%" />
                <col style="width: 30%" />
            </colgroup>
           <%-- <tr>
                  <th>诊断：</th>
                <td>
                  <ehr:dic-radio name="epidemiologicalSurvey.contactPatients" dicmeta="PH00002" code="1,2,4"
                                   value="${caseDto.epidemiologicalSurvey.contactPatients}"/>
                </td>
            </tr>--%>
            <tr>
                <th>3.1 接触红眼病人：</th>
                <td>
                    <ehr:dic-radio name="epidemiologicalSurvey.contactPatients" dicmeta="PH00002" code="1,2,4"
                                   value="${caseDto.epidemiologicalSurvey.contactPatients}"
                                   onchange="toggleOther('epidemiologicalSurvey.contactPatients','relationPatient',1);"/>
                </td>
                <td></td>
                <td></td>
            </tr>
            <tbody id="relationPatient">
            <tr>
                <th>3.2 与患者关系：</th>
                <td>
                    <ehr:dic-radio name="epidemiologicalSurvey.relationPatient" dicmeta="IDM00059"
                                   value="${caseDto.epidemiologicalSurvey.relationPatient}"/>
                </td>
            </tr>
            </tbody>
            <tr>
                <th>3.3 家庭内毛巾：</th>
                <td>
                    <ehr:dic-radio name="epidemiologicalSurvey.homeTowel" dicmeta="PH00010" code="1,2,4"
                                   value="${caseDto.epidemiologicalSurvey.homeTowel}"/>
                </td>
            </tr>
            <tr>
                <th>3.4 家庭内脸盆：</th>
                <td>
                    <ehr:dic-radio name="epidemiologicalSurvey.homeBasin" dicmeta="PH00010" code="1,2,4"
                                   value="${caseDto.epidemiologicalSurvey.homeBasin}"/>
                </td>
            </tr>
            <tr>
                <th>3.5 游泳：</th>
                <td>
                    <ehr:dic-radio name="epidemiologicalSurvey.swim" dicmeta="PH00002" code="1,2"
                                   value="${caseDto.epidemiologicalSurvey.swim}"/>
                </td>
            </tr>
            <tr>
                <th>3.6 乘坐公交车：</th>
                <td colspan="3">
                    <ehr:dic-radio name="epidemiologicalSurvey.bus" dicmeta="PH00002" code="1,2" value="${caseDto.epidemiologicalSurvey.bus}"
                                   onchange="toggleOther('epidemiologicalSurvey.bus','busPart',1);"/>
                    <span id="busPart" style="display: none">
                        &nbsp;&nbsp;&nbsp;&nbsp;次数：
                        <input type="text" name="epidemiologicalSurvey.busNum" value="${caseDto.epidemiologicalSurvey.busNum}"
                               style="width: 80px;text-align: center" reg='{"maxlength":"20","regex":"number"}'/>
                        	主要乘坐几路车： <input type="text" name="epidemiologicalSurvey.dusDetail" value="${caseDto.epidemiologicalSurvey.dusDetail}"
                                        style="width: 100px;" reg='{"maxlength":"20"}'/>
                    </span>
                </td>
            </tr>
            <tr>
                <th>3.7 乘坐出租车：</th>
                <td colspan="3">
                    <ehr:dic-radio name="epidemiologicalSurvey.texi" dicmeta="PH00002" code="1,2" value="${caseDto.epidemiologicalSurvey.texi}"
                                   onchange="toggleOther('epidemiologicalSurvey.texi','texiNum',1);"/>
                    <span id="texiNum" style="display: none">
                        &nbsp;&nbsp;&nbsp;&nbsp;次数：
                        <input type="text" name="epidemiologicalSurvey.texiNum" value="${caseDto.epidemiologicalSurvey.texiNum}"
                               style="width: 80px;text-align: center" reg='{"maxlength":"20","regex":"number"}'/>
                    </span>
                </td>
            </tr>
            <%--<tr>
                <th>3.5 家庭人数：</th>
                <td>
                    <input type="text" name="epidemiologicalSurvey.homeNum" value="${caseDto.epidemiologicalSurvey.homeNum}"
                           style="width: 80px;text-align: center" reg='{"maxlength":"20"}'/>人
                </td>
            </tr>--%>
            <tr>
                <th>3.8 发病期间在家隔离：</th>
                <td>
                    <ehr:dic-radio name="epidemiologicalSurvey.homeQuarantine" dicmeta="PH00002" code="1,2,4"
                                   value="${caseDto.epidemiologicalSurvey.homeQuarantine}"/>
                </td>
            </tr>
            <tr>
                <th>3.9 是否常洗手：</th>
                <td>
                    <ehr:dic-radio name="epidemiologicalSurvey.washingHandEatingToilet" dicmeta="PH00001" code="1,2"
                                   value="${caseDto.epidemiologicalSurvey.washingHandEatingToilet}"/>
                </td>
            </tr>
            <tr>
                <th>3.10 是否打电话：</th>
                <td colspan="3">
                    <ehr:dic-radio name="epidemiologicalSurvey.tel" dicmeta="PH00001" code="1,2"
                            value="${caseDto.epidemiologicalSurvey.tel}"
                                   onchange="toggleOther('epidemiologicalSurvey.tel','telKind',1);"/>
                    <span id="telKind">
                         <ehr:dic-radio name="epidemiologicalSurvey.telKind" dicmeta="IDM00060"
                                        value="${caseDto.epidemiologicalSurvey.telKind}" />
                    </span>
                </td>
            </tr>
            <tr>
                <th>3.11 是否使用电脑：</th>
                <td colspan="3">
                    <ehr:dic-radio name="epidemiologicalSurvey.computer" dicmeta="PH00001" code="1,2"
                                   value="${caseDto.epidemiologicalSurvey.computer}"
                                   onchange="toggleOther('epidemiologicalSurvey.computer','pcKind',1);"/>
                    <span id="pcKind">
                         <ehr:dic-radio name="epidemiologicalSurvey.pcKind" dicmeta="IDM00256"
                                        value="${caseDto.epidemiologicalSurvey.pcKind}"/>
                    </span>
                </td>
            </tr>
            <tr>
                <th>3.12 公共场所乘坐电梯：</th>
                <td colspan="3">
                    <ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.elevator" code="1,2,4" value="${caseDto.epidemiologicalSurvey.elevator}"
                            onchange="toggleOther('epidemiologicalSurvey.elevator','elevatorNum',1);"/>
                    <span id="elevatorNum" style="display: none">
                        &nbsp;&nbsp;&nbsp;大约次数：
                        <input type="text" name="epidemiologicalSurvey.elevatorNum" value="${caseDto.epidemiologicalSurvey.elevatorNum}"
                                    style="width: 80px;text-align: center" reg='{"maxlength":"20","regex":"number"}'/>
                    </span>
                </td>
            </tr>
            <tr>
                <th>3.13 饭店就餐：</th>
                <td colspan="3">
                    <ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.restaurant" code="1,2,4" value="${caseDto.epidemiologicalSurvey.restaurant}"
                                   onchange="toggleOther('epidemiologicalSurvey.restaurant','restaurantNum',1);"/>
                    <span id="restaurantNum" style="display: none">
                        &nbsp;&nbsp;&nbsp;大约次数：
                        <input type="text" name="epidemiologicalSurvey.restaurantNum" value="${caseDto.epidemiologicalSurvey.restaurantNum}"
                                    style="width: 80px;text-align: center" reg='{"maxlength":"20","regex":"number"}'/>
                    </span>
                </td>

            </tr>
            <tr>
                <th>3.14 舞厅或街头跳舞：</th>
                <td colspan="3">
                    <ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.ballroom" code="1,2,4" value="${caseDto.epidemiologicalSurvey.ballroom}"
                                   onchange="toggleOther('epidemiologicalSurvey.ballroom','ballroomNum',1);"/>
                    <span id="ballroomNum" style="display: none">
                        &nbsp;&nbsp;&nbsp;大约次数：
                        <input type="text" name="epidemiologicalSurvey.ballroomNum" value="${caseDto.epidemiologicalSurvey.ballroomNum}"
                                    style="width: 80px;text-align: center" reg='{"maxlength":"20","regex":"number"}'/>
                    </span>
                </td>
            </tr>
            <tr>
                <th>3.15 有否去过网吧：</th>
                <td colspan="3">
                    <ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.cybercafe" code="1,2,4" value="${caseDto.epidemiologicalSurvey.cybercafe}"
                                   onchange="toggleOther('epidemiologicalSurvey.cybercafe','cybercafeNum',1);"/>
                    <span id="cybercafeNum" style="display: none">
                        &nbsp;&nbsp;&nbsp;大约次数：
                        <input type="text" name="epidemiologicalSurvey.cybercafeNum"  value="${caseDto.epidemiologicalSurvey.cybercafeNum}"
                                    style="width: 80px;text-align: center" reg='{"maxlength":"20","regex":"number"}'/>
                    </span>
                </td>
            </tr>
            <tr>
                <th>3.16 有无打保龄球：</th>
                <td colspan="3">
                    <ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.bowling" code="1,2,4" value="${caseDto.epidemiologicalSurvey.bowling}"
                                   onchange="toggleOther('epidemiologicalSurvey.bowling','bowlingNum',1);"/>
                    <span id="bowlingNum" style="display: none">
                        &nbsp;&nbsp;&nbsp;大约次数：
                        <input type="text" name="epidemiologicalSurvey.bowlingNum" value="${caseDto.epidemiologicalSurvey.bowlingNum}"
                                style="width: 80px;text-align: center" reg='{"maxlength":"20","regex":"number"}'/>
                    </span>
                </td>
            </tr>
            <tr>
                <th>3.17 是否其他公共场所：</th>
                <td  colspan="3">
                    <ehr:dic-radio name="epidemiologicalSurvey.otherPublicPlace" dicmeta="PH00001" code="1,2"
                                   value="${caseDto.epidemiologicalSurvey.otherPublicPlace}"
                                   onchange="toggleOther('epidemiologicalSurvey.otherPublicPlace','publicPlace',1);"/>
                    <span id="publicPlace">
                       	&nbsp;&nbsp;&nbsp;&nbsp;次数：
                        <input type="text" name="epidemiologicalSurvey.publicPlaceNum" value="${caseDto.epidemiologicalSurvey.publicPlaceNum}"
                                style="width: 80px;text-align: center" reg='{"maxlength":"20","regex":"number"}'/>
                        	主要有哪些场所：<input type="text" name="epidemiologicalSurvey.publicPlace" value="${caseDto.epidemiologicalSurvey.publicPlace}"
                                           style="width:100px;text-align: center" reg='{"maxlength":"100"}'/>
                    </span>
                </td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend>4.小结</legend>
        <table class="posttable">
            <tr>
                <td>
                    <textarea name="otherCondition.surveySummary" style="width: 100%" rows="4" reg='{"maxlength":"1000"}'>${caseDto.otherCondition.surveySummary}
                    </textarea>
                </td>
            </tr>
            </table>
        </fieldset>

        <fieldset>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 22%" />
                        <col style="width: 28%" />
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                    </colgroup>
            <tr>
                <th>调查者单位：</th>
                <td>
                    <ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/>
                    <input type="hidden" name="caseInformation.modifySurveyOrg" value="${caseDto.caseInformation.modifySurveyOrg}"/>
                </td>
                <th>调查者：</th>
                <td>
                    <ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
                    <input type="hidden" name="caseInformation.modifyRespondents" value="${caseDto.caseInformation.modifyRespondents}"/>
                </td>
            </tr>
            <tr>
                <th>审查者：</th>
                <td>
                    <ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
                    <input type="hidden" name="caseInformation.auditor" value="${caseDto.caseInformation.auditor}"/>
                </td>
                <th>调查时间：</th>
                <td>
                    <tag:dateInput name="caseInformation.modifySurveyDate" pattern="yyyy/MM/dd" date="${caseDto.caseInformation.modifySurveyDate}"/>
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
