<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/lax.js" type="text/javascript"></script>

<c:if test="${isPrint != 1}">
    <jsp:include page="caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
<div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
    <i class="popno"> 其他感染性腹泻个案调查表<br /> <span>（丙类传染病）</span> </i>
    <div class="postdiv">
        <table  class="posttable" >
            <tr style="text-align: right">
                <td>国际码：
                    <input type="text" name="generalCondition.gbcode" value="${caseDto.generalCondition.gbcode}" style="width: 120px;"
                           reg='{"maxlength":"14"}'/>
                </td>
                <td>病例编号：<input type="text" name="caseInformation.mediRecordNum" style="width: 120px;"
                           value="${caseDto.caseInformation.mediRecordNum}" reg='{"maxlength":"14"}'/>
                    <input type="hidden" name="idmId" value="${idmId}" /></td>
            </tr>
        </table>
    <div class="postdiv">
        <fieldset>
            <legend>1. 一般情况</legend>
            <table class="posttable">
                <colgroup>
                    <col style="width: 23%" />
                    <col style="width: 27%" />
                    <col style="width: 23%" />
                    <col style="width: 27%" />
                </colgroup>
            <tr>
                <th>1.1 姓名：</th>
                <td><input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}" reg='{"maxlength":"100"}'/></td>
                <td></td>
                <td></td>
            </tr>
                <tr>
                    <th>1.2 家长或监护人姓名：</th>
                    <td><input type="text" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}"
                               reg='{"maxlength":"50"}'/></td>
                </tr>

                <tr>
                    <th>1.3 性别：</th>
                    <td>
                        <ehr:dic-radio id="gender" name="generalCondition.gender"
                                       dicmeta="GBT226112003" value="${caseDto.generalCondition.gender}" code="1,2" />
                    </td>
                </tr>
                <tr>
                    <th>1.4 出生日期：</th>
                    <td colspan="3">
                        <tag:dateInput name="generalCondition.birthday" pattern="yyyy/MM/dd" date="${caseDto.generalCondition.birthday}" onlypast="true" style="width:100px;"/>
                        （如出生日期不详，实足年龄
                        <input type="text" id="age" name="generalCondition.age" value="${caseDto.generalCondition.age}"
                               reg='{"maxlength":"6"}' style="width: 60px; text-align: center" />
                        年龄单位：<ehr:dic-radio name="generalCondition.ageUnit" dicmeta="IDM00003" value="${caseDto.generalCondition.ageUnit}"/>)
                    </td>
                </tr>
                <tr>
                    <th>1.5 职业：</th>
                    <td colspan="3">
                        <ehr:dic-list id="occupationId" dicmeta="GBT6565" name="generalCondition.occupation" width="180px;" value="${caseDto.generalCondition.occupation}"
                                      code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120299"
                                      onchange="toggleOtherSC('generalCondition.occupation','occupationOtherPart','CV020120299');"/>
                        <span  id="occupationOtherPart" style="display: none">
                        <input type="text" name="generalCondition.occupationOther" value="${caseDto.generalCondition.occupationOther}"
                               reg='{"maxlength":"30"}' placeholder="选择其他，请描叙" style="width: 150px;" />
                    </span>
                    </td>
                </tr>
                <tr>
                    <th>1.6 文化程度：</th>
                    <td colspan="3"><ehr:dic-radio name="generalCondition.education" dicmeta="GBT46582006"  code="IDM06,IDM07,IDM02,IDM03,IDM08,IDM09,IDM10"
                                                   value="${caseDto.generalCondition.education}"/></td>
                </tr>
                <%--<tr>
                <th>1.2 身份证号码：</th>
                <td><input type="text" id="idCard" name="generalCondition.idcard" value="${caseDto.generalCondition.idcard}" reg='{"idCard":"true"}'
                           placeholder="输入身份证获取个人信息"/></td>
            </tr>--%>
                <tr>
                    <th>1.7 户口地址：</th>
                    <td><input type="text" id="hrAddress" name="generalCondition.hrAddress" value="${caseDto.generalCondition.hrAddress}"
                           reg='{"maxlength":"100"}' ></td>
                </tr>
            <tr>
                <th>1.8 现居住地或工作学习单位：</th>
                <td colspan="3">
                    <ehr:dic-town-street-village streetId="pastreet_address" townId="patown_address" streetName="generalCondition.pastreet" townName="generalCondition.patownShip"
                                                 streetValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="140px;"
                                                 villageId="pavillage_address" villageName="generalCondition.paGroup" villageValue="${caseDto.generalCondition.paGroup}"/>
                    <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
                                   reg='{"maxlength":"50"}'  style="width: 180px;">
                        	<span id="spanPaNumber">(门牌号)</span>
                        	<div> 联系电话：<input type="text" name="generalCondition.phoneNumber" value="${caseDto.generalCondition.phoneNumber}"
                                reg='{"regex":"phone"}' style="width: 100px;"/>
                            </div>
                </td>
            </tr>
                <tr>
                    <th>1.9 联系人：</th>
                    <td colspan="3"><input type="text" name="generalCondition.contactName" value="${caseDto.generalCondition.contactName}"
                               reg='{"maxlength":"50"}' style="width: 100px;"/>
                    	电话：
                    <input type="text" name="generalCondition.contactPhone" value="${caseDto.generalCondition.contactPhone}"
                               reg='{"maxlength":"50"}' style="width: 100px;"/></td>
                </tr>
            <%--<tr>
                <th>1.11 病人属于：</th>
                <td colspan="3">
                    <ehr:dic-radio name="generalCondition.patientAttribute" dicmeta="CV0201104" value="${caseDto.generalCondition.patientAttribute}" onchange="caseEdit.toggerAddress()"/>
                </td>
            </tr>
            <tr>
                <th>1.12 病例分类：</th>
                <td colspan="3">
                    <ehr:dic-radio name="otherCondition.caseType" dicmeta="IDM00040" code="1,2,3,4" value="${caseDto.otherCondition.caseType}"/>
                </td>
            </tr>--%>
            <tr>
                <th>1.10 发病日期：</th>
                <td colspan="3">
                    <tag:dateInput id="pathogenesisDateId" name="attackCondition.pathogenesisDate" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.attackCondition.pathogenesisDate}" style="width:100px;" reg='{"compare":["firstVisitDateId","le","发病时间不能晚于初诊时间"]}'/>
                    地点：<input type="text" name="attackCondition.pathogenesisPlace" value="${caseDto.attackCondition.pathogenesisPlace}"
                              reg='{"maxlength":"33"}' style="width: 280px;"/>
                </td>
            </tr>
            <tr>
                <th>1.11 初诊日期：</th>
                <td colspan="3">
                    <%--<input type="text" name="attackCondition.firstVisitDate" value="${caseDto.attackCondition.firstVisitDate}"/>--%>
                    <tag:dateInput id="firstVisitDateId" name="attackCondition.firstVisitDate" onlypast="true" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.firstVisitDate}" style="width:100px;" reg='{"compare":["pathogenesisDateId","ge","初诊时间不能早于发病时间"]}'/>
                    单位：<input type="text" name="attackCondition.firstVisitUnit" value="${caseDto.attackCondition.firstVisitUnit}"
                              reg='{"maxlength":"33"}' style="width: 280px;"/>
                        诊断医院：<input type="text" name="attackCondition.confirmationHospital" value="${caseDto.attackCondition.confirmationHospital}"
                                  reg='{"maxlength":"100"}' style="width: 280px;"/>
                </td>
            </tr>

            <%--<tr>
                <th>1.15 初诊病名：</th>
                <td colspan="3"><input type="text" name="attackCondition.firstVisitName" value="${caseDto.attackCondition.firstVisitName}"
                                       reg='{"maxlength":"33"}' style="width: 280px;"/></td>
            </tr>--%>
            <%--<tr>
                <th>1.16 确诊日期：</th>
                <td colspan="3">
                    &lt;%&ndash;<input type="text" name="attackCondition.confirmationDate" value="${caseDto.attackCondition.confirmationDate}"/>&ndash;%&gt;
                    <tag:dateInput id="confirmationDateId" name="attackCondition.confirmationDate" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.attackCondition.confirmationDate}" style="width:100px;" reg='{"compare":["firstVisitDateId","ge","确诊时间不能早于初诊时间"]}'/>
                    单位：<input type="text" name="attackCondition.confirmationHospital" value="${caseDto.attackCondition.confirmationHospital}"
                              reg='{"maxlength":"33"}' style="width: 280px;"/>
                </td>
            </tr>--%>
            <tr>
                <th>1.12 报告时间：</th>
                <td colspan="3">
                    <%--<input type="text" name="attackCondition.reportTime" value="${caseDto.attackCondition.reportTime}"/>--%>
                    <tag:dateInput name="caseInformation.reportDate" pattern="yyyy/MM/dd" date="${caseDto.caseInformation.reportDate}" onlypast="true"
                                   style="width:100px;display:none" reg='{"compare":["confirmationDateId","ge","报告时间不能早于确诊时间"]}'/>
                    <fmt:formatDate pattern="yyyy/MM/dd" value="${caseDto.caseInformation.reportDate}"/>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  单位：<ehr:org code="${caseDto.caseInformation.reportOrg}" />
                        <input type="hidden" name="caseInformation.reportOrg" value="${caseDto.caseInformation.reportOrg}"
                              reg='{"maxlength":"33"}' style="width: 280px;"/>
                </td>
            </tr>
            <tr>
                <th>1.13 住院日期：</th>
                <td colspan="3">
                    <tag:dateInput id="inhosDateId" name="attackCondition.inhosDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.inhosDate}" onlypast="true" style="width:100px;" reg='{"compare":["outHospitalDateId","le","入院日期不能晚于出院日期"]}'/>
                    单位：<input type="text" name="attackCondition.admissionHospital" value="${caseDto.attackCondition.admissionHospital}"
                              reg='{"maxlength":"33"}' style="width: 280px;" reg='{"compare":["outHospitalDateId","le","入院日期不能晚于出院日期"]}'/>
                </td>
            </tr>
            <tr>
                <th>1.14 出院日期：</th>
                <td>
                    <tag:dateInput id="outHospitalDateId" name="attackCondition.outHospitalDate" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.attackCondition.outHospitalDate}" style="width:100px;" reg='{"compare":["inhosDateId","ge","出院日期不能早于入院日期"]}'/>
                </td>
            </tr>
          <%--  <tr>
                <th>1.20 病例来源：</th>
                <td colspan="3">
                    <ehr:dic-radio name="otherCondition.caseSource" dicmeta="IDM00022" value="${caseDto.otherCondition.caseSource}"/>
                </td>
            </tr>--%>
        </table>
        </fieldset>
        </div>
        <div class="postdiv">
			<fieldset>
				<legend>2. 主要临床表现</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 23%" />
                        <col style="width: 27%" />
                        <col style="width: 23%" />
                        <col style="width: 27%" />
                    </colgroup>
                    <tr>
                        <th>2.1 腹泻：</th>
                        <td colspan="3">
                            <ehr:dic-radio name="clinicalManifestations.diarrhea" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.diarrhea}"
                                    onchange="toggleOther('clinicalManifestations.diarrhea','diarrheaPart',1);"/>
                            <br>
                            <div id="diarrheaPart" style="display: none">腹泻天数：
                                <input type="text" name="clinicalManifestations.diarrhoeaDays" style="width: 80px;"
                                       value="${caseDto.clinicalManifestations.diarrhoeaDays}" reg='{"maxlength":"20"}'/>天
                                &nbsp;&nbsp;&nbsp;&nbsp;每天最多泻
                                <input type="text" name="clinicalManifestations.diarrheaDailyTimes" style="width: 80px;"
                                       value="${caseDto.clinicalManifestations.diarrheaDailyTimes}" reg='{"maxlength":"20"}'/>次
                                <br>便量：
                                <ehr:dic-radio name="clinicalManifestations.diarrheaVariable" dicmeta="PH00011" value="${caseDto.clinicalManifestations.diarrheaVariable}"/>
                                &nbsp;&nbsp;&nbsp;&nbsp;气味：
                                <ehr:dic-radio name="clinicalManifestations.diarrheaSmell" dicmeta="IDM00024" value="${caseDto.clinicalManifestations.diarrheaSmell}"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>2.2 粪便性状：</th>
                        <td colspan="3">
                            <ehr:dic-radio name="clinicalManifestations.stoolProperty" dicmeta="IDM00571"
                                    value="${caseDto.clinicalManifestations.stoolProperty}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>2.3 腹泻方式：</th>
                        <td>
                            <ehr:dic-radio name="clinicalManifestations.diarrheaPattern" dicmeta="IDM00572"
                                           value="${caseDto.clinicalManifestations.diarrheaPattern}"/>
                        </td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>2.4 排便情况：</th>
                        <td colspan="3">
                            <ehr:dic-radio name="clinicalManifestations.conditionDefecation" dicmeta="IDM00026" code="2,3,4,5"
                                           value="${caseDto.clinicalManifestations.conditionDefecation}"/>
                        </td>
                    </tr>

                    <tr>
                        <th>2.5 呕吐：</th>
                        <td colspan="3">
                            <ehr:dic-radio name="clinicalManifestations.vomit" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.vomit}"
                                          onchange="toggleOther('clinicalManifestations.vomit','vomitPart',1);"/>
                            <br>
                            <div id="vomitPart" style="display: none">呕吐天数：
                                <input type="text" name="clinicalManifestations.vomitDays"
                                            value="${caseDto.clinicalManifestations.vomitDays}" style="width: 80px;" reg='{"maxlength":"20"}'/>天
                                &nbsp;&nbsp;&nbsp;&nbsp;每天最多呕吐次数
                                <input type="text" name="clinicalManifestations.vomitTimes"
                                       value="${caseDto.clinicalManifestations.vomitTimes}" style="width: 80px;" reg='{"maxlength":"20"}'/>次
                                <br>呕吐物性状：
                                <ehr:dic-radio name="clinicalManifestations.vomitCharacter" dicmeta="IDM00027"
                                        value="${caseDto.clinicalManifestations.vomitCharacter}" code="1,2,4"/>
                                &nbsp;&nbsp;&nbsp;&nbsp;呕吐量：
                                <ehr:dic-radio name="clinicalManifestations.vomitingQuantity" dicmeta="PH00011"
                                               value="${caseDto.clinicalManifestations.vomitingQuantity}"/>
                                <br>呕吐方式：
                                <ehr:dic-radio name="clinicalManifestations.vomitWay" dicmeta="IDM00028"
                                               value="${caseDto.clinicalManifestations.vomitWay}"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>2.6 发热：</th>
                        <td colspan="3">
                            <ehr:dic-radio name="clinicalManifestations.fever" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.fever}"
                                    onchange="toggleOther('clinicalManifestations.fever','feverPart',1);"/>
                            <br>
                            <div id="feverPart" style="display: none">
                                发热天数：<input type="text" name="clinicalManifestations.heatingDuration" style="width: 80px;"
                                        value="${caseDto.clinicalManifestations.heatingDuration}" reg='{"maxlength":"20"}'/>天
                                最高体温<input type="text" name="clinicalManifestations.highestTemperature" style="width: 80px;"
                                       value="${caseDto.clinicalManifestations.highestTemperature}" reg='{"maxlength":"20"}'/>℃
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>2.7 食欲不振：</th>
                        <td>
                            <ehr:dic-radio name="clinicalManifestations.poorAppetite" dicmeta="PH00002" code="1,2"
                                           value="${caseDto.clinicalManifestations.poorAppetite}"/>
                        </td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>2.8 头痛头晕：</th>
                        <td>
                            <ehr:dic-radio name="clinicalManifestations.headacheDizziness" dicmeta="PH00002" code="1,2"
                                           value="${caseDto.clinicalManifestations.headacheDizziness}"/>
                        </td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>2.9 乏力：</th>
                        <td>
                            <ehr:dic-radio name="clinicalManifestations.feeble" dicmeta="PH00002" code="1,2"
                                           value="${caseDto.clinicalManifestations.feeble}"/>
                        </td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>2.10 腹胀：</th>
                        <td>
                            <ehr:dic-radio name="clinicalManifestations.abdominalDistension" dicmeta="PH00002" code="1,2"
                                           value="${caseDto.clinicalManifestations.abdominalDistension}"/>
                        </td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>2.11 腹鸣：</th>
                        <td>
                            <ehr:dic-radio name="clinicalManifestations.barborygmus" dicmeta="PH00002" code="1,2"
                                           value="${caseDto.clinicalManifestations.barborygmus}"/>
                        </td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>2.12 腓肠肌疼痛：</th>
                        <td>
                            <ehr:dic-radio name="clinicalManifestations.gastrocnemius" dicmeta="PH00002" code="1,2"
                                           value="${caseDto.clinicalManifestations.gastrocnemius}"/>
                        </td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>2.13 失水情况：</th>
                        <td>
                            <ehr:dic-radio name="clinicalManifestations.waterLossSituation" dicmeta="IDM00031"
                                           value="${caseDto.clinicalManifestations.waterLossSituation}"/>
                        </td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>2.14 临床类型：</th>
                        <td>
                            <ehr:dic-radio name="clinicalManifestations.clinicalTypeLevel" dicmeta="IDM00032"
                                           value="${caseDto.clinicalManifestations.clinicalTypeLevel}" code="1,2,3"/>
                        </td>
                        <td></td>
                        <td></td>
                    </tr><%--
                    <tr>
                        <th>2.5 腹痛：</th>
                        <td colspan="3">
                            <ehr:dic-radio name="clinicalManifestations.stomachache" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.stomachache}"
                                           onchange="toggleOther('clinicalManifestations.stomachache','stomachachePart',1);"/>
                            <br>
                            <div id="stomachachePart" style="display: none">腹痛部位：
                                <ehr:dic-radio name="clinicalManifestations.abdominalPainParts" dicmeta="IDM00029"
                                               value="${caseDto.clinicalManifestations.abdominalPainParts}"/>
                                <br>腹痛类型：
                                <ehr:dic-radio name="clinicalManifestations.abdominalPain" dicmeta="IDM00030"
                                               value="${caseDto.clinicalManifestations.abdominalPain}"/>
                            </div>
                        </td>
                    </tr>--%>
                    <tr>
                        <th>2.15 感染者发现方式：</th>
                        <td>
                            <ehr:dic-radio name="clinicalManifestations.fxFounder" dicmeta="IDM00573"
                                           value="${caseDto.clinicalManifestations.fxFounder}"
                             onchange="toggleOther('clinicalManifestations.fxFounder','fxOther',99);" />
                            <span id="fxOther">
                            <input type="text" name="clinicalManifestations.fxOther"
                                   value="${caseDto.clinicalManifestations.fxOther}" style="width: 80px;" reg='{"maxlength":"100"}'/>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <th>2.16 确诊依据：</th>
                        <td colspan="3">
                            <ehr:dic-radio name="clinicalManifestations.fxBasis" dicmeta="IDM00106"
                                           value="${caseDto.clinicalManifestations.fxBasis}" />
                        </td>
                    </tr>
                    <tr>
                        <th>2.17 采样时间：</th>
                        <td>
                            <tag:dateInput name="clinicalManifestations.fxSampleDate" onlypast="true" pattern="yyyy/MM/dd" date="${caseDto.clinicalManifestations.fxSampleDate}" style="width:100px;" />
                        </td>
                    </tr>
                    <tr>
                        <th>2.18 标本名称：</th>
                        <td>
                            <input type="text" name="clinicalManifestations.fxSampleName"
                                   value="${caseDto.clinicalManifestations.fxSampleName}" style="width: 80px;" reg='{"maxlength":"100"}'/>
                        </td>
                    </tr>
                    <tr>
                        <th>2.19 病原学检验结果报告时间：</th>
                        <td>
                            <tag:dateInput name="clinicalManifestations.fxResultDate" onlypast="true"
                                           pattern="yyyy/MM/dd" date="${caseDto.clinicalManifestations.fxResultDate}" style="width:100px;" />

                        </td>
                    </tr>
                    <tr>
                        <th>2.20 粪便检验结果：</th>
                        <td colspan="3">红细胞：<input type="text" name="clinicalManifestations.redCell"
                                   value="${caseDto.clinicalManifestations.redCell}" style="width: 80px;" reg='{"maxlength":"100"}'/>
                            &nbsp;&nbsp;&nbsp;&nbsp;白细胞：<input type="text" name="clinicalManifestations.whiteCell"
                                   value="${caseDto.clinicalManifestations.whiteCell}" style="width: 80px;" reg='{"maxlength":"100"}'/>
                            &nbsp;&nbsp;&nbsp;&nbsp;脓细胞：<input type="text" name="clinicalManifestations.pusCell"
                                   value="${caseDto.clinicalManifestations.pusCell}" style="width: 80px;" reg='{"maxlength":"100"}'/>
                        </td>
                    </tr>
                    <tr>
                        <th>2.21 血清学检验结果：</th>
                        <td>
                            <input type="text" name="clinicalManifestations.fxSuremResult"
                                   value="${caseDto.clinicalManifestations.fxSuremResult}" style="width: 80px;" reg='{"maxlength":"20"}'/>
                        </td>
                    </tr>
                    <tr>
                        <th>2.22 病人转归：</th>
                        <td>
                            <ehr:dic-radio name="clinicalManifestations.patientReturn" dicmeta="IDM00005"
                                           value="${caseDto.clinicalManifestations.patientReturn}" code="1,5,4"/>
                             </td>
                    </tr>
                    <tr>
                        <th>2.23 死因：</th>
                        <td>
                            <input type="text" name="clinicalManifestations.fxDeathReason"
                                   value="${caseDto.clinicalManifestations.fxDeathReason}" style="width: 80px;" reg='{"maxlength":"20"}'/>
                        </td>
                    </tr>
                </table>
            </fieldset>
    </div>
    <div class="postdiv">
        <fieldset>
            <legend>3. 流行病学调查</legend>
            <table class="posttable">
                <colgroup>
                    <col style="width: 23%" />
                    <col style="width: 20%" />
                    <col style="width: 19%" />
                    <col style="width: 19%" />
                    <col style="width: 19%" />
                </colgroup>
                <tr>
                    <th>3.1 接触过类似病人：</th>
                    <td colspan="4">
                        <ehr:dic-radio name="infectionSourceRoute.contactSimilerPatient" dicmeta="PH00002" code="1,2" value="${caseDto.infectionSourceRoute.contactSimilerPatient}"
                                       onchange="toggleOther('infectionSourceRoute.contactSimilerPatient','contactSimilerPatientPart',1);"/>
                        <span id="contactSimilerPatientPart" style="display: none">
                            <br>接触地点：<input type="text" name="infectionSourceRoute.contactSimilerPatientAddr" value="${caseDto.infectionSourceRoute.contactSimilerPatientAddr}"
                                            reg='{"maxlength":"100"}'>
                            <br>接触时间：<tag:dateInput name="infectionSourceRoute.contactSimilerPatientDt" date="${caseDto.infectionSourceRoute.contactSimilerPatientDt}"
                                                    onlypast="true" style="width: 90px;"/>
                            <br>接触方式：<ehr:dic-checkbox name="infectionSourceRoute.contactSimilerPatientWay" dicmeta="IDM00033" value="${caseDto.infectionSourceRoute.contactSimilerPatientWay}"/>
                        </span>
                    </td>
                </tr>
                <tr>
                    <th>3.2 饮水类型：</th>
                    <td colspan="4">
                        <ehr:dic-radio name="beforeDiseaseDiet.drinkingType" dicmeta="IDM00034" code="1,2,4,6,7,8,10,99"
                                       value="${caseDto.beforeDiseaseDiet.drinkingType}"/>
                    </td>
                </tr>
                <tr>
                    <th>3.3 饮生水史：</th>
                    <td colspan="4">
                        <ehr:dic-radio name="beforeDiseaseDiet.drinkingHistory" dicmeta="PH00002" code="1,2"
                                       value="${caseDto.beforeDiseaseDiet.drinkingHistory}"/>
                    </td>
                </tr>
                <%--<tr>
                    <th>3.1 传染源与传播途径的追溯(病前五天内)：</th>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <th>3.1.1 本地是否有同样疾病的发生：</th>
                    <td colspan="4">
                        <ehr:dic-radio name="infectionSourceRoute.sameDisease" dicmeta="PH00001" code="1,2" value="${caseDto.infectionSourceRoute.sameDisease}"
                                onchange="toggleOther('infectionSourceRoute.sameDisease','sameDiseasePart',1);"/>
                        <span id="sameDiseasePart" style="display: none">
                            发生时间：
                            <tag:dateInput id="outSameDiseaseDtStart" name="infectionSourceRoute.outSameDiseaseDt" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.infectionSourceRoute.outSameDiseaseDt}" style="width:100px;" reg='{"compare":["outSameDiseaseDtEnd","le","开始时间不能晚于结束时间"]}'/>
                            ～
                            <tag:dateInput id="outSameDiseaseDtEnd" name="infectionSourceRoute.outSameDiseaseDt" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.infectionSourceRoute.outSameDiseaseDt}" style="width:100px;" reg='{"compare":["outSameDiseaseDtStart","ge","结束时间不能早于开始时间"]}'/>
                        </span>
                    </td>
                </tr>--%>
                <tr>
                    <th>3.4 外出史：</th>
                    <td colspan="4">
                        <ehr:dic-radio name="infectionSourceRoute.outHistory" dicmeta="PH00002" code="1,2" value="${caseDto.infectionSourceRoute.outHistory}"
                                       onchange="toggleOther('infectionSourceRoute.outHistory','outHistoryPart',1);"/>
                        <span id="outHistoryPart" style="display: none">
                            <br>去何地：
                            <input type="text" name="infectionSourceRoute.outAddr" value="${caseDto.infectionSourceRoute.outAddr}"
                                   reg='{"maxlength":"100"}'/>
                            <br>该地有无同样疾病:
                            <ehr:dic-radio name="infectionSourceRoute.outSameDisease" dicmeta="PH00002" code="1,2"
                                           value="${caseDto.infectionSourceRoute.outSameDisease}"/>
                            <br>是否在该地住宿、用膳、带回水产品等食物：
                            <ehr:dic-radio name="infectionSourceRoute.outBackFood" dicmeta="PH00001" code="1,2" value="${caseDto.infectionSourceRoute.outBackFood}"
                                           onchange="toggleOther('infectionSourceRoute.outBackFood','outBackFoodPart',1);"/>
                            <span id="outBackFoodPart" style="display: none">
                            食物名称：
                            <input type="text" name="infectionSourceRoute.outBackFoodName" value="${caseDto.infectionSourceRoute.outBackFoodName}"
                                   style="width: 120px;" reg='{"maxlength":"100"}'/>
                            </span>

                        </span>
                    </td>
                </tr>
                <tr>
                    <th>3.5 有无外人来家：</th>
                    <td colspan="4">
                        <ehr:dic-radio name="infectionSourceRoute.stranger" dicmeta="PH00002" code="1,2" value="${caseDto.infectionSourceRoute.stranger}"
                                       onchange="toggleOther('infectionSourceRoute.stranger','strangerPart',1);"/>
                        <span id="strangerPart" style="display: none">
                            <br> 来自何地：
                            <input type="text" name="infectionSourceRoute.strangerFromAddr" value="${caseDto.infectionSourceRoute.strangerFromAddr}"
                                   reg='{"maxlength":"100"}'/>
                            <br>该人是否有同样疾病：
                            <ehr:dic-radio name="infectionSourceRoute.strangerSameDisease" dicmeta="PH00001" code="1,2,4" value="${caseDto.infectionSourceRoute.strangerSameDisease}"
                                          onchange="toggleOther('infectionSourceRoute.strangerSameDisease','strangerSameDiseasePart',1);"/>
                            <span id="strangerSameDiseasePart" style="display: none">发病时间：
                                <tag:dateInput name="infectionSourceRoute.strangerSameDiseaseDt" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.infectionSourceRoute.strangerSameDiseaseDt}"
                                               style="width:100px;"/>
                            </span>
                        </span>
                    </td>
                </tr>
                <tr>
                    <th>3.6 饮食史：</th>
                    <td colspan="4"></td>
                </tr>
                <tr>
                    <th>饮生水次数：</th>
                    <td colspan="4">
                        <ehr:dic-radio dicmeta="IDM00007" name="beforeDiseaseDiet.drinkingNum" code="2,3"
                                value="${caseDto.beforeDiseaseDiet.drinkingNum}"/>
                        最近饮水时间：
                        <tag:dateInput name="beforeDiseaseDiet.drinkingTime" pattern="yyyy/MM/dd" onlypast="true"
                                       date="${caseDto.beforeDiseaseDiet.drinkingTime}" style="width:100px;"/>
                    </td>
                </tr><tr>
                <th> 吃生冷食品：</th>
                <td colspan="4">
                    <ehr:dic-radio name="beforeDiseaseDiet.coldFood" dicmeta="PH00002" code="1,2" value="${caseDto.beforeDiseaseDiet.coldFood}"
                                   onchange="toggleOther('beforeDiseaseDiet.coldFood','suspiciousFoodPart1',1);"/>
                    <span id="suspiciousFoodPart1" style="display: none">
                            食品名称：<input type="text" name="beforeDiseaseDiet.coldFoodName" value="${caseDto.beforeDiseaseDiet.coldFoodName}"
                                        reg='{"maxlength":"200"}' style="width:150px;"/>
                            购买地点：<input type="text" name="beforeDiseaseDiet.coldFoodBuyPlace" value="${caseDto.beforeDiseaseDiet.coldFoodBuyPlace}"
                                        reg='{"maxlength":"200"}' style="width:250px;"/>
                        </span>
                </td>
            </tr>
                <tr>
                    <th> 熟食冷吃：</th>
                    <td colspan="4">
                        <ehr:dic-radio name="beforeDiseaseDiet.cookedFoodColdEat" dicmeta="PH00002" code="1,2" value="${caseDto.beforeDiseaseDiet.cookedFoodColdEat}"
                                       onchange="toggleOther('beforeDiseaseDiet.cookedFoodColdEat','suspiciousFoodPart2',1);"/>
                        <span id="suspiciousFoodPart2" style="display: none">
                            食品名称：<input type="text" name="beforeDiseaseDiet.cookedFoodName" value="${caseDto.beforeDiseaseDiet.cookedFoodName}"
                                        reg='{"maxlength":"200"}' style="width:150px;"/>
                            购买地点：<input type="text" name="beforeDiseaseDiet.cookedFoodBuyPlace" value="${caseDto.beforeDiseaseDiet.cookedFoodBuyPlace}"
                                        reg='{"maxlength":"200"}' style="width:250px;"/>
                        </span>
                    </td>
                </tr>
                <tr>
                    <th> 在外就餐史：</th>
                    <td colspan="4">
                        <ehr:dic-radio name="beforeDiseaseDiet.outsideDiningHistory" dicmeta="PH00002" code="1,2" value="${caseDto.beforeDiseaseDiet.outsideDiningHistory}"
                                       onchange="toggleOther('beforeDiseaseDiet.outsideDiningHistory','outsideDiningHistoryPart',1);"/>
                        <span id="outsideDiningHistoryPart" style="display: none">
                            <br>就餐地点：
                            <ehr:dic-radio name="beforeDiseaseDiet.eatPlace" dicmeta="IDM00037" value="${caseDto.beforeDiseaseDiet.eatPlace}" reg='{"maxlength":"200"}'/>
                            <br>最近就餐时：
                            <tag:dateInput id="eatTime" name="beforeDiseaseDiet.eatTime" pattern="yyyy/MM/dd HH" onlypast="true"
                                           date="${caseDto.beforeDiseaseDiet.eatTime}" style="width:100px;"/>
                            <input type="hidden" id="eatTimeHour" name="beforeDiseaseDiet.eatTimeHour">时
                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;同餐人数：
                            <input type="text" name="beforeDiseaseDiet.mealPNum" value="${caseDto.beforeDiseaseDiet.mealPNum}"
                                   style="width:80px;" reg='{"maxlength":"20"}'/>人
                        </span>
                    </td>
                </tr>
                <tr>
                    <th> 吃海水产品：</th>
                    <td colspan="4">
                        <ehr:dic-radio name="beforeDiseaseDiet.eatSeaProducts" dicmeta="PH00002" code="1,2" value="${caseDto.beforeDiseaseDiet.eatSeaProducts}"
                                      onchange="toggleOther('beforeDiseaseDiet.eatSeaProducts','eatSeaProductsPart',1);"/>
                        <span id="eatSeaProductsPart" style="display: none">
                            海水产品种类：
                            <input type="text" name="beforeDiseaseDiet.seaFoodName" value="${caseDto.beforeDiseaseDiet.seaFoodName}"
                                reg='{"maxlength":"200"}' style="width:120px;"/>
                           <%--    购买地点：
                            <input type="text" name="beforeDiseaseDiet.seaSalesPlaces" value="${caseDto.beforeDiseaseDiet.seaSalesPlaces}"
                                   reg='{"maxlength":"200"}' style="width:220px;"/>--%>
                        </span>
                    </td>
                </tr>
                <tr>
                    <th> 食用方法：</th>
                    <td colspan="4">
                        <ehr:dic-radio name="beforeDiseaseDiet.edibleMethod" dicmeta="IDM00036" value="${caseDto.beforeDiseaseDiet.edibleMethod}"
                                onchange="toggleOther('beforeDiseaseDiet.edibleMethod','edibleMethodPart',99);"/>
                        <span id="edibleMethodPart" style="display: none">
                            <input type="text" name="beforeDiseaseDiet.edibleMethodOther" value="${caseDto.beforeDiseaseDiet.edibleMethodOther}"
                                   reg='{"maxlength":"100"}' style="width:250px;"/>
                        </span>
                    </td>
                </tr>
                <tr>
                <th> 聚餐史：</th>
                <td colspan="4">
                    <ehr:dic-radio name="beforeDiseaseDiet.dinnerHistory" dicmeta="PH00002" code="1,2" value="${caseDto.beforeDiseaseDiet.dinnerHistory}"
                                   onchange="toggleOther('beforeDiseaseDiet.dinnerHistory','dinnerHistoryPart',1);" />
                    <span id="dinnerHistoryPart">
                            聚餐日期：
                            <tag:dateInput name="beforeDiseaseDiet.dinnerDate" pattern="yyyy/MM/dd" onlypast="true"
                                           date="${caseDto.beforeDiseaseDiet.dinnerDate}" style="width:100px;"/>
                            同餐人数：
                            <input type="text" name="beforeDiseaseDiet.dinnerPNum" value="${caseDto.beforeDiseaseDiet.dinnerPNum}"
                                   style="width:80px;" reg='{"maxlength":"20"}'/>人　
                            发病人数：
                            <input type="text" name="beforeDiseaseDiet.infectedNum" value="${caseDto.beforeDiseaseDiet.infectedNum}"
                                   style="width:80px;" reg='{"maxlength":"20"}'/>人
                        </span>
                </td>
            </tr>
               <%-- <tr>
                    <th>3.3.6 吃其它可疑食品：</th>
                    <td colspan="4">
                        <ehr:dic-radio name="beforeDiseaseDiet.suspiciousFood" dicmeta="PH00002" code="1,2" value="${caseDto.beforeDiseaseDiet.suspiciousFood}"
                                     onchange="toggleOther('beforeDiseaseDiet.suspiciousFood','suspiciousFoodPart',1);"/>
                        <span id="suspiciousFoodPart" style="display: none">
                            食品名称：<input type="text" name="beforeDiseaseDiet.susFoodName" value="${caseDto.beforeDiseaseDiet.susFoodName}"
                                        reg='{"maxlength":"200"}' style="width:150px;"/>
                            购买地点：<input type="text" name="beforeDiseaseDiet.susSalesPlaces" value="${caseDto.beforeDiseaseDiet.susSalesPlaces}"
                                        reg='{"maxlength":"200"}' style="width:250px;"/>
                        </span>
                    </td>


                <tr>
                    <th>3.3.9 居所卫生：</th>
                    <td colspan="4">
                        <ehr:dic-radio name="beforeDiseaseDiet.resHealth" dicmeta="IDM00038"
                                       value="${caseDto.beforeDiseaseDiet.resHealth}"/>
                    </td>
                </tr>
                <tr>
                    <th>3.4 室内苍蝇：</th>
                    <td colspan="4">
                        <ehr:dic-radio name="beforeDiseaseDiet.indoorFlies" dicmeta="IDM00039"
                                       value="${caseDto.beforeDiseaseDiet.indoorFlies}"/>
                    </td>
                </tr>--%>
    </table>
    </fieldset>
    </div>
<div class="postdiv">
			<%--<fieldset>
				<legend>4. 实验室检测</legend>
				<table class="posttable">
                    <colgroup>
                        <col style="width: 23%" />
                        <col style="width: 77%" />
                    </colgroup>
            <tr>
                <th>4.1 采样时间：</th>
                <td>
                    <tag:dateInput id="routineBloodDate" name="labExamine.routineBloodDate" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.labExamine.routineBloodDate}" style="width:160px;" reg='{"compare":["reportTime","le","采样时间不能晚于 检测结果报告时间"]}'/>
                    标本名称：<input type="text" name="labExamine.sampleName" value="${caseDto.labExamine.sampleName}"
                                reg='{"maxlength":"100"}' style="width: 160px;" />
                    血清学检验结果：<input type="text" name="labExamine.serologicallyResult" value="${caseDto.labExamine.serologicallyResult}"
                                   reg='{"maxlength":"100"}' style="width: 160px;" />
                    <br>病原学检验结果：<input type="text" name="labExamine.etiologicalTestResult" value="${caseDto.labExamine.etiologicalTestResult}"
                                       reg='{"maxlength":"100"}' style="width: 160px;" />
                    检测结果报告时间：
                    <tag:dateInput id="reportTime" name="labExamine.reportTime" pattern="yyyy/MM/dd HH" date="${caseDto.labExamine.reportTime}" onlypast="true" style="width:160px;" />
                    <input type="hidden" id="reportHour" name="labExamine.reportHour" reg='{"compare":["routineBloodDate","ge","检测结果报告时间不能早于采样时间"]}'/>
                </td>
            </tr> 
            <tr>
                <th>4.2 病人转归：</th>
                <td>
                    <ehr:dic-radio name="otherCondition.outcomeCode" dicmeta="IDM00005" code="1,5,4"
                            value="${caseDto.otherCondition.outcomeCode}"/>
                </td>
            </tr> 
            <tr>
                <th>4.3 其它检测结果（临床检测）：</th>
                <td><input type="text" name="labExamine.otherResult" value="${caseDto.labExamine.otherResult}"  reg='{"maxlength":"100"}'/></td>
            </tr>
        </table>
        </fieldset>--%>
    </div>
<div class="postdiv">
			<fieldset>
				<legend>4.简述控制措施</legend>
				<table class="posttable">
            <tr>
                <td>
                    <textarea name="otherCondition.controlMeasures" style="width: 100%" rows="4" reg='{"maxlength":"1000"}'>${caseDto.otherCondition.controlMeasures}</textarea>
                </td>
            </tr>
        </table>
        </fieldset>
    </div>
    <div class="postdiv">
                <fieldset>
                    <legend>5.小结</legend>
                    <table class="posttable">
                <tr>
                    <td>
                        <textarea  name="otherCondition.surveySummary" style="width: 100%" rows="5" reg='{"maxlength":"1000"}'>${caseDto.otherCondition.surveySummary}</textarea>
                    </td>
                </tr>
                        </table>
                    </fieldset>
        </div>
    <div class="postdiv">
        <fieldset>
            <table class="posttable">
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
            </table>
            </fieldset>
        </div>
     </div>
</div>
</form>
