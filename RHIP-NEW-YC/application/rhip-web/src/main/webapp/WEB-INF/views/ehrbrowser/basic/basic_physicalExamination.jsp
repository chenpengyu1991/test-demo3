<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css"/>
<link href="${pageContext.request.contextPath}/css/views/ehrbrowser/personalRecord/phyExam.css" type="text/css" rel="stylesheet"/>
<%--<i class="pop_No">
    <a class="bc" id="button_print">打印</a>
</i>--%>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/basic/physical.js" type="text/javascript"></script>
<div class="postcontent" id="printDiv">
    <div id="con_two_3">
        <form action="" id="phyExamForm">
            <input type="hidden" id="personIdForPhysical" value="${personBasicInfoDto.personInfo.id}">
            <span class="span_floatleft"><b>姓名:</b>
                <c:choose>
                    <c:when test="${not empty brwAnonymousSetStr}">
                        <ehr:authorize ifAnyGranted="${brwAnonymousSetStr}">
                            <c:out value="${fn:substring(personBasicInfoDto.personInfo.name, 0, 1)}" />
                            <c:choose>
                                <c:when test="${fn:length(personBasicInfoDto.personInfo.name) ==2}">${ANONYMOUS_X}</c:when>
                                <c:when test="${fn:length(personBasicInfoDto.personInfo.name) ==3}">${ANONYMOUS_2X}</c:when>
                                <c:otherwise>${ANONYMOUS_3X}</c:otherwise>
                            </c:choose>
                        </ehr:authorize>
                        <ehr:authorize ifNotGranted="${brwAnonymousSetStr}">
                            ${personBasicInfoDto.personInfo.name}
                        </ehr:authorize>
                    </c:when>
                    <c:otherwise>${personBasicInfoDto.personInfo.name}</c:otherwise>
                </c:choose>
            </span>
            <c:choose>
                <c:when test="${not empty personBasicInfoDto.personInfo.healthFileNoHtml}">
                    ${personBasicInfoDto.personInfo.healthFileNoHtml}
                </c:when>
                <c:otherwise>
                    <s class="pop_No">
                        <span class="text"><b>编号：</b></span>
                        <span></span><span></span><span></span><span></span><span></span>
                        <span class="line">-</span>
                        <span></span><span></span><span></span>
                        <span class="line">-</span>
                        <span></span><span></span><span></span>
                        <span class="line">-</span>
                        <span></span><span></span><span></span><span></span>
                    </s>
                </c:otherwise>
            </c:choose>
            <span style="float: right; padding-left: 200px; padding-right:10px;">
                <a href="#" id="searchForPhysical" title="历次体检">历次体检</a>
            </span>
            <span style="float: right; padding-left: 200px; padding-right:10px;">
                <a href="#" id="healthServiceFeedbackForm" title="健康服务反馈表">健康服务反馈表</a>
            </span>

            <div class="table-01">
                <span style="	float: right;	margin-left: 8px;">&nbsp;&nbsp;<b>体检日期:</b><fmt:formatDate
                        value="${personalPhyExamDTO.physiqueExamination.examinationDate}" pattern="yyyy/MM/dd"/></span>
                <span style="	float: left;  margin-right: 8px;"><b>责任医生:</b>${personalPhyExamDTO.physiqueExamination.manaDoctorName}&nbsp;&nbsp;</span>
                <table border="0" cellpadding="0" cellspacing="0" style="clear:both; ">
                    <tr>
                        <td class="h_top">内容</td>
                        <td colspan="5" class="h_top">检查项目</td>
                    </tr>
                    <tr>
                        <th>症状</th>
                        <td colspan="5">
                            ${personalPhyExamDTO.physiqueExamination.symptomFlag eq '0' ? '无症状':''}
                            ${personalPhyExamDTO.physiqueExamination.symptomFlag eq '1' ? '<b>有症状</b>:<br>':''}

                            <c:if test="${personalPhyExamDTO.physiqueExamination.symptomFlag eq '1'}">
                                ${personalPhyExamDTO.physiqueExamination.symptomHeadache eq '1' ? '头痛,':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomDizzy eq '1' ? '头晕,':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomPalpitations eq '1' ? '心悸,':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomChestTightness eq '1' ? '胸闷,':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomChestPain eq '1' ? '胸痛,':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomChronicCough eq '1' ? '慢性咳嗽,':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomCough eq '1' ? '咳痰,':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomDyspnea eq '1' ? '呼吸困难,':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomPolydipsia eq '1' ? '多饮,':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomPolyuria eq '1' ? '多尿,':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomWeightLoss eq '1' ? '体重下降,':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomFatigue eq '1' ? '乏力,':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomJointPain eq '1' ? '关节肿痛,':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomBlurredVision eq '1' ? '视力模糊,':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomNumbness eq '1' ? '手脚麻木,':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomUrgency eq '1' ? '尿急,':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomDysuria eq '1' ? '尿痛,':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomConstipation eq '1' ? '便秘,':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomDiarrhea eq '1' ? '腹泻,':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomNauseaVomiting eq '1' ? '恶心呕吐,':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomVertigo eq '1' ? '眼花,':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomTinnitus eq '1' ? '耳鸣,':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomBreastTenderness eq '1' ? '乳房胀痛,':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomOther eq '1' ? '<br>其他症状:&nbsp;&nbsp;':''}
                                ${personalPhyExamDTO.physiqueExamination.symptomOtherDesc}
                            </c:if>
                    </tr>
                    <tr>
                        <th <c:if test="${isElder}"> rowspan="9" </c:if> <c:if test="${not isElder}"> rowspan="5" </c:if>>一般状况</th>
                        <th width="10%">体温</th>
                        <td colspan="2">${personalPhyExamDTO.physiqueExamination.temperature}℃</td>
                        <th width="10%">脉率</th>
                        <td width="30%">${personalPhyExamDTO.physiqueExamination.pulseRate}次/分钟</td>
                    </tr>
                    <tr>
                        <th>呼吸频率</th>
                        <td colspan="2">${personalPhyExamDTO.physiqueExamination.respiratoryRate}次/分钟</td>
                        <th>血压</th>
                        <td>
                            <table>
                                <tr>
                                    <td>左侧</td>
                                    <td>
                                        ${personalPhyExamDTO.physiqueExamination.leftSbp}/
                                        ${personalPhyExamDTO.physiqueExamination.leftDbp}mmHg
                                    </td>
                                    <td>右侧</td>
                                    <td>
                                        ${personalPhyExamDTO.physiqueExamination.rightSbp}/
                                        ${personalPhyExamDTO.physiqueExamination.rightDbp}mmHg
                                    </td>
                                </tr>
                            </table>
                        </td>

                    </tr>
                    <tr>
                        <th></th>
                        <td colspan="2"></td>
                        <th>来源</th>
                        <td>
                            <ehr:dic dicmeta="TFJKDA001" code="${personalPhyExamDTO.physiqueExamination.bloodPressureSource}"/>
                        </td>

                    </tr>
                    <tr>
                        <th>身高</th>
                        <td colspan="2">${personalPhyExamDTO.physiqueExamination.height}cm</td>
                        <th>体重</th>
                        <td width="16%">${personalPhyExamDTO.physiqueExamination.bodyWeight}kg</td>
                    </tr>
                    <tr>
                        <th>腰围</th>
                        <td colspan="2">${personalPhyExamDTO.physiqueExamination.waostline}cm</td>
                        <th>体质指数（BMI）</th>
                        <td width="16%">${personalPhyExamDTO.physiqueExamination.indexOfBodyCharacteristics}kg/㎡</td>
                    </tr>
                    <%--<tr>
                        <th>臀围</th>
                        <td colspan="2">${personalPhyExamDTO.physiqueExamination.hip}cm</td>
                        <th>腰臀围比值</th>
                        <td width="16%">${personalPhyExamDTO.physiqueExamination.whr}</td>
                    </tr>--%>
                    <c:if test="${isElder}">
                        <tr>
                            <th>老年人健康状况自我评估</th>
                            <td colspan="4">
                                <c:if test="${personalPhyExamDTO.physiqueExamination.healthSelfAssessment eq '0'}">未检</c:if>
                                <ehr:dic dicmeta="CV0401013" code="${personalPhyExamDTO.physiqueExamination.healthSelfAssessment}"/>
                            </td>
                        </tr>
                        <tr>
                            <th>老年人生活自理能力自我评估</th>
                            <td colspan="4">
                                <c:if test="${personalPhyExamDTO.physiqueExamination.lifeAbilitySelfAssessment eq '0'}">未检</c:if>
                                <ehr:dic dicmeta="CV0401014" code="${personalPhyExamDTO.physiqueExamination.lifeAbilitySelfAssessment}"/>
                            </td>
                        </tr>
                        <tr>
                            <th>老年人认知功能</th>
                            <td colspan="4">
                                    ${personalPhyExamDTO.physiqueExamination.cognitionScreenResult eq "2" ? "未检" : ""}
                                    ${personalPhyExamDTO.physiqueExamination.cognitionScreenResult eq "1" ? "粗筛阴性" : ""}
                                    ${personalPhyExamDTO.physiqueExamination.cognitionScreenResult eq "0" ? "粗筛阳性" : ""}
                                <c:if test="${personalPhyExamDTO.physiqueExamination.cognitionScreenResult eq '0'}">
                <span id="cognitionScreenScore">
                ,简易智力状态检查,总分${personalPhyExamDTO.physiqueExamination.cognitionScreenScore}
                </span>
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <th>老年人情感状态</th>
                            <td colspan="4">
                                    ${personalPhyExamDTO.physiqueExamination.emotionScreenResult eq "2" ? "未检" : ""}
                                    ${personalPhyExamDTO.physiqueExamination.emotionScreenResult eq "1" ? "粗筛阴性" :""}
                                    ${personalPhyExamDTO.physiqueExamination.emotionScreenResult eq "0" ? "粗筛阳性" :""}
                                <c:if test="${personalPhyExamDTO.physiqueExamination.emotionScreenResult eq '0'}">
           <span id="depressionScore">
              	,老年人抑郁评分检查,总分${personalPhyExamDTO.physiqueExamination.depressionScore}
           </span>
                                </c:if>
                            </td>
                        </tr>
                    </c:if>
                    <tr>
                        <th rowspan="13">生活方式</th>
                        <th rowspan="3">体育锻炼</th>
                        <td width="16%" class="td_gray">锻炼频率</td>
                        <td colspan="3">
                            <ehr:dic dicmeta="FS10208" code="${personalPhyExamDTO.physiqueExamination.trainFrequencyTypeCode}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="td_gray">每次锻炼时间</td>
                        <td width="16%">
                            ${personalPhyExamDTO.physiqueExamination.trainingMin}分钟
                        </td>
                        <td class="td_gray">坚持锻炼时间</td>
                        <td>
                            ${personalPhyExamDTO.physiqueExamination.trainingTotaltime}年
                        </td>
                    </tr>
                    <tr>
                        <td class="td_gray">锻炼方式</td>
                        <td colspan="3">
                            <ehr:dic dicmeta="FS990004" code="${personalPhyExamDTO.physiqueExamination.trainingWay}"/>
                            <c:if test="${personalPhyExamDTO.physiqueExamination.otherTrainingWay ne null}">
                                : ${personalPhyExamDTO.physiqueExamination.otherTrainingWay}
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <th>饮食习惯</th>
                        <td colspan="4">
                            <ehr:dic dicmeta="CV0300107" code="${personalPhyExamDTO.physiqueExamination.dietHunsuEquilibrium}"/>
                            <ehr:dic dicmeta="CV0300107" code="${personalPhyExamDTO.physiqueExamination.dietMeatMain}"/>
                            <ehr:dic dicmeta="CV0300107" code="${personalPhyExamDTO.physiqueExamination.dietVegetarian}"/>
                            <ehr:dic dicmeta="CV0300107" code="${personalPhyExamDTO.physiqueExamination.dietHalophilic}"/>
                            <ehr:dic dicmeta="CV0300107" code="${personalPhyExamDTO.physiqueExamination.dietAddictedOil}"/>
                            <ehr:dic dicmeta="CV0300107" code="${personalPhyExamDTO.physiqueExamination.dietSugarCravings}"/>
                        </td>
                    </tr>
                    <tr>
                        <th rowspan="3">吸烟情况</th>
                        <td width="16%" class="td_gray">吸烟状况</td>
                        <td colspan="3">
                            <ehr:dic dicmeta="CV0300101" code="${personalPhyExamDTO.physiqueExamination.smodeStatusCode}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="td_gray">日吸烟量</td>
                        <td colspan="3">平均
                            ${personalPhyExamDTO.physiqueExamination.dailySmoke}支
                        </td>
                    </tr>
                    <tr>
                        <td class="td_gray">开始吸烟年龄</td>
                        <td width="16%">${personalPhyExamDTO.physiqueExamination.smokeAge}岁</td>
                        <td class="td_gray">戒烟年龄</td>
                        <td>${personalPhyExamDTO.physiqueExamination.quitSmokeAge}岁</td>
                    </tr>
                    <tr>
                        <th rowspan="5">饮酒情况</th>
                        <td width="16%" class="td_gray">饮酒频率</td>
                        <td colspan="3">
                            <ehr:dic dicmeta="CV0300104" code="${personalPhyExamDTO.physiqueExamination.drinkFrequency}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="td_gray">日饮酒量</td>
                        <td colspan="3">平均
                            ${personalPhyExamDTO.physiqueExamination.dailyDrink}两
                        </td>
                    </tr>
                    <tr>
                        <td class="td_gray">是否戒酒</td>
                        <td>
                            <ehr:dic dicmeta="FS10214" code="${personalPhyExamDTO.physiqueExamination.nodrink}"/>
                        </td>
                        <td class="td_gray">戒酒年龄</td>
                        <td>${personalPhyExamDTO.physiqueExamination.nodrinkAge}岁</td>

                    </tr>
                    <tr>
                        <td class="td_gray">开始饮酒年龄</td>
                        <td width="16%">${personalPhyExamDTO.physiqueExamination.drinkAge}岁</td>
                        <td class="td_gray">近一年内是否曾醉酒</td>
                        <td>
                            <ehr:dic dicmeta="FS10009" code="${personalPhyExamDTO.physiqueExamination.drunk}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="td_gray">饮酒种类</td>
                        <td colspan="3">
                            <ehr:dic dicmeta="CV0300105" code="${personalPhyExamDTO.physiqueExamination.drinkSpirit}"/>
                            <ehr:dic dicmeta="CV0300105" code="${personalPhyExamDTO.physiqueExamination.drinkBeer}"/>
                            <ehr:dic dicmeta="CV0300105" code="${personalPhyExamDTO.physiqueExamination.drinkRedWine}"/>
                            <ehr:dic dicmeta="CV0300105" code="${personalPhyExamDTO.physiqueExamination.drinkYellowWine}"/>
                            <ehr:dic dicmeta="CV0300105" code="${personalPhyExamDTO.physiqueExamination.drinkOther}"/>
                            <c:out value="${personalPhyExamDTO.physiqueExamination.drinkOtherDesc}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>职业病危害因素接触史</th>
                        <td colspan="4">
                            <label>
                                ${personalPhyExamDTO.physiqueExamination.occupationExposureFlag eq"0" ||personalPhyExamDTO.physiqueExamination.occupationExposureFlag eq null ?"<span>无</span>" :""}
                            </label>
                            <label>
                                ${personalPhyExamDTO.physiqueExamination.occupationExposureFlag eq"1" ?"<span><b>有</b></span>" :""}
                            </label>
                            <c:if test="${personalPhyExamDTO.physiqueExamination.occupationExposureFlag eq '1'}">
             <span id="ttb2">
                    (工种${personalPhyExamDTO.physiqueExamination.riskOccupationDesc}
                              从业时间
                              ${personalPhyExamDTO.physiqueExamination.riskOccupationTime}年)
                    <table>
                        <tr>
                            <td width="10%">粉尘</td>
                            <td width="30%">${personalPhyExamDTO.physiqueExamination.dustTypeDesc}</td>
                            <td width="10%">防护措施</td>
                            <td width="50%">
                                ${personalPhyExamDTO.physiqueExamination.dustProtectionFlag eq"0" ?"无" :""}
                                ${personalPhyExamDTO.physiqueExamination.dustProtectionFlag eq"1" ?"有" :""}
                                ${personalPhyExamDTO.physiqueExamination.dustProtectionDesc}
                            </td>
                        </tr><tr>
                        <td>放射物质</td><td>${personalPhyExamDTO.physiqueExamination.radiationTypeDesc}</td>
                        <td>防护措施</td>
                        <td>
                            ${personalPhyExamDTO.physiqueExamination.radiationProtectionFlag eq"0" ?"无" :""}
                            ${personalPhyExamDTO.physiqueExamination.radiationProtectionFlag eq"1" ?"有" :""}
                            ${personalPhyExamDTO.physiqueExamination.radiationProtectionDesc}
                        </td>
                    </tr><tr>
                        <td>物理因素</td><td>${personalPhyExamDTO.physiqueExamination.physicsTypeDesc}</td>
                        <td>防护措施</td>
                        <td>
                            ${personalPhyExamDTO.physiqueExamination.physicsProtectionFlag eq"0" ?"无" :""}
                            ${personalPhyExamDTO.physiqueExamination.physicsProtectionFlag eq"1" ?"有" :""}
                            ${personalPhyExamDTO.physiqueExamination.physicsProtectionDesc}
                        </td>
                    </tr><tr>
                        <td>化学因素</td><td>${personalPhyExamDTO.physiqueExamination.chemistryTypeDesc}</td>
                        <td>防护措施</td>
                        <td>
                            ${personalPhyExamDTO.physiqueExamination.chemistryProtectionFlag eq"0" ?"无" :""}
                            ${personalPhyExamDTO.physiqueExamination.chemistryProtectionFlag eq"1" ?"有" :""}
                            ${personalPhyExamDTO.physiqueExamination.chemistryProtectionDesc}
                        </td>
                    </tr><tr>
                        <td>其他</td><td>${personalPhyExamDTO.physiqueExamination.otherTypeDesc}</td>
                        <td>防护措施</td>
                        <td>
                            ${personalPhyExamDTO.physiqueExamination.otherProtectionFlag eq"0" ?"无" :""}
                            ${personalPhyExamDTO.physiqueExamination.otherProtectionFlag eq"1" ?"有" :""}
                            ${personalPhyExamDTO.physiqueExamination.otherProtectionDesc}
                        </td>
                    </tr>
                    </table>
             </span>
                            </c:if>
                            </li>
                        </td>
                    </tr>
                    <tr>
                        <th rowspan="4">脏器功能</th>
                        <th>口腔</th>
                        <td colspan="4">
                            <table>
                                <tr>
                                    <td colspan="2">口唇&nbsp;
                                        <ehr:dic dicmeta="CV0410007" code="${personalPhyExamDTO.physiqueExamination.lipAppearanceCehckResult}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>齿列&nbsp;
                                        ${personalPhyExamDTO.physiqueExamination.dentitionAnomalyFlag eq "0" ?"正常" :""}
                                        ${personalPhyExamDTO.physiqueExamination.dentitionAnomalyFlag eq "1" ?"<b>异常</b>" :""}
                                    </td>
                                    <td id="ttb7" style="width: 60%;">
                                        ${personalPhyExamDTO.physiqueExamination.missingToothFlg eq "1" ? "缺齿" : ""}
                                        <c:if test="${not empty personalPhyExamDTO.physiqueExamination.missingToothFlg}">
                                            <table style="width: 20%;">
                                                <tr>
                                                    <td>${personalPhyExamDTO.physiqueExamination.missingToothNumberUpl}</td>
                                                    <td>${personalPhyExamDTO.physiqueExamination.missingToothNumberUpr}</td>
                                                </tr>
                                                <tr>
                                                    <td>${personalPhyExamDTO.physiqueExamination.missingToothNumberDownl}</td>
                                                    <td>${personalPhyExamDTO.physiqueExamination.missingToothNumberDownr}</td>
                                                </tr>
                                            </table>
                                        </c:if>
                                        ${personalPhyExamDTO.physiqueExamination.decayedToothFlg eq "1"?"龋齿":""}
                                        <c:if test="${not empty personalPhyExamDTO.physiqueExamination.decayedToothFlg}">
                                            <table style="width: 20%;">
                                                <tr>
                                                    <td>${personalPhyExamDTO.physiqueExamination.decayedToothNumberUpl}</td>
                                                    <td>${personalPhyExamDTO.physiqueExamination.decayedToothNumberUpr}</td>
                                                </tr>
                                                <tr>
                                                    <td>${personalPhyExamDTO.physiqueExamination.decayedToothNumberDownl}</td>
                                                    <td>${personalPhyExamDTO.physiqueExamination.decayedToothNumberDownr}</td>
                                                </tr>
                                            </table>
                                        </c:if>
                                        ${personalPhyExamDTO.physiqueExamination.dentureToothFlg eq "1"?"义齿":""}
                                        <c:if test="${not empty personalPhyExamDTO.physiqueExamination.dentureToothFlg}">
                                            <table style="width: 20%;">
                                                <tr>
                                                    <td>${personalPhyExamDTO.physiqueExamination.dentureToothNumberUpl}</td>
                                                    <td>${personalPhyExamDTO.physiqueExamination.dentureToothNumberUpr}</td>
                                                </tr>
                                                <tr>
                                                    <td>${personalPhyExamDTO.physiqueExamination.dentureToothNumberDownl}</td>
                                                    <td>${personalPhyExamDTO.physiqueExamination.dentureToothNumberDownr}</td>
                                                </tr>
                                            </table>
                                        </c:if>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">咽部&nbsp;
                                        <ehr:dic dicmeta="FS10183" code="${personalPhyExamDTO.physiqueExamination.pharynxCheckResult}"/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <th>视力</th>
                        <td colspan="4">
                            左眼${personalPhyExamDTO.physiqueExamination.lNakedEye}
                            右眼${personalPhyExamDTO.physiqueExamination.rNakedEye}
                            （矫正视力:左眼${personalPhyExamDTO.physiqueExamination.lEyecorrection}
                            右眼${personalPhyExamDTO.physiqueExamination.rEyecorrection})
                        </td>
                    </tr>
                    <tr>
                        <th>听力</th>
                        <td colspan="4">
                            <ehr:dic dicmeta="FS10170" code="${personalPhyExamDTO.physiqueExamination.hearDetectResult}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>运动功能</th>
                        <td colspan="4">
                            <ehr:dic dicmeta="FS10212" code="${personalPhyExamDTO.physiqueExamination.motorFuncState}"/>
                        </td>
                    </tr>
                    <tr>
                        <th <c:if test="${isWoman}"> rowspan="23" </c:if> <c:if test="${not isWoman}"> rowspan="18" </c:if>>查体</th>
                        <th>眼底</th>
                        <td colspan="4">
                            <c:if test="${personalPhyExamDTO.physiqueExamination.fundusOculiAnomalyFlag eq '2'}">未检</c:if>
                            ${personalPhyExamDTO.physiqueExamination.fundusOculiAnomalyFlag eq"0" ?"正常":""}
                            ${personalPhyExamDTO.physiqueExamination.fundusOculiAnomalyFlag eq"1" ?"<b>异常</b>":""}
                            ${personalPhyExamDTO.physiqueExamination.fundusOculiAnomalyDesc}
                        </td>
                    </tr>
                    <tr>
                        <th>皮肤</th>
                        <td colspan="4">
                            ${personalPhyExamDTO.physiqueExamination.skinCheckResult eq"1" ?"正常":""}
                            ${personalPhyExamDTO.physiqueExamination.skinCheckResult eq"2" ?"潮红":""}
                            ${personalPhyExamDTO.physiqueExamination.skinCheckResult eq"3" ?"苍白":""}
                            ${personalPhyExamDTO.physiqueExamination.skinCheckResult eq"4" ?"发绀":""}
                            ${personalPhyExamDTO.physiqueExamination.skinCheckResult eq"5" ?"黄染":""}
                            ${personalPhyExamDTO.physiqueExamination.skinCheckResult eq"6" ?"色素沉着":""}
                            ${personalPhyExamDTO.physiqueExamination.skinCheckResult eq"7" ?"其他":""}
                            ${personalPhyExamDTO.physiqueExamination.skinCheckDesc}
                        </td>
                    </tr>
                    <tr>
                        <th>巩膜</th>
                        <td colspan="4">
                            ${personalPhyExamDTO.physiqueExamination.scleraCheckResult eq"1" ?"正常":""}
                            ${personalPhyExamDTO.physiqueExamination.scleraCheckResult eq"2" ?"黄染":""}
                            ${personalPhyExamDTO.physiqueExamination.scleraCheckResult eq"3" ?"充血":""}
                            ${personalPhyExamDTO.physiqueExamination.scleraCheckResult eq"4" ?"其他":""}
                            ${personalPhyExamDTO.physiqueExamination.scleraCheckDesc}
                        </td>
                    </tr>
                    <tr>
                        <th>淋巴结</th>
                        <td colspan="4">
                            ${personalPhyExamDTO.physiqueExamination.lymphNodeCheckResult eq"1" ?"未触及 ":""}
                            ${personalPhyExamDTO.physiqueExamination.lymphNodeCheckResult eq"2" ?"锁骨上 ":""}
                            ${personalPhyExamDTO.physiqueExamination.lymphNodeCheckResult eq"3" ?"腋窝  ":""}
                            ${personalPhyExamDTO.physiqueExamination.lymphNodeCheckResult eq"4" ?"其他  ":""}
                            ${personalPhyExamDTO.physiqueExamination.lymphNodeCheckDesc}
                        </td>
                    </tr>
                    <tr>
                        <th rowspan="3">肺</th>
                        <td colspan="4">桶状胸:
                            ${personalPhyExamDTO.physiqueExamination.barrelChest eq"1" ?"是":""}
                            ${personalPhyExamDTO.physiqueExamination.barrelChest eq"0" ?"<b>否</b>":""}
                    <tr>
                        <td colspan="4">呼吸音:
                            ${personalPhyExamDTO.physiqueExamination.lungsAnomalySound eq"1" ?"正常":""}
                            ${personalPhyExamDTO.physiqueExamination.lungsAnomalySound eq"0" ?"<b>异常</b>":""}
                            ${personalPhyExamDTO.physiqueExamination.lungsAnomalyDesc}
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4"> 啰音:
                            ${personalPhyExamDTO.physiqueExamination.lungsRaleFlag eq"1" ?"无   ":""}
                            ${personalPhyExamDTO.physiqueExamination.lungsRaleFlag eq"2" ?"干啰音 ":""}
                            ${personalPhyExamDTO.physiqueExamination.lungsRaleFlag eq"3" ?"湿啰音 ":""}
                            ${personalPhyExamDTO.physiqueExamination.lungsRaleFlag eq"4" ?"其它  ":""}
                            ${personalPhyExamDTO.physiqueExamination.lungsRaleDesc}
                        </td>
                    </tr>
                    <tr>
                        <th>心脏</th>
                        <td colspan="4">
                            心率: ${personalPhyExamDTO.physiqueExamination.heartRate}次/分钟
                            <br>
                            心律 :<ehr:dic dicmeta="FS10176" code="${personalPhyExamDTO.physiqueExamination.cardioverter}"/>
                            <br>
                            杂音:
                            ${personalPhyExamDTO.physiqueExamination.heartMurmurFlag eq"0" || personalPhyExamDTO.physiqueExamination.heartMurmurFlag eq null ?"无":""}
                            ${personalPhyExamDTO.physiqueExamination.heartMurmurFlag eq"1" ?"<b>有</b>":""}
                            <c:if test="${personalPhyExamDTO.physiqueExamination.heartMurmurFlag eq '1'}">
                                <span id="heartMurmurDesc"> ${personalPhyExamDTO.physiqueExamination.heartMurmurDesc}次/分钟</span>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <th rowspan="5">腹部</th>
                        <td colspan="4">
                            压痛:
                            ${personalPhyExamDTO.physiqueExamination.abdominalTendernessFlag eq"0" ||personalPhyExamDTO.physiqueExamination.abdominalTendernessFlag eq null ?"无":""}
                            ${personalPhyExamDTO.physiqueExamination.abdominalTendernessFlag eq"1" ?"<b>有</b>":""}
                            ${personalPhyExamDTO.physiqueExamination.abdominalTendernessDesc}

                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">包块:
                            ${personalPhyExamDTO.physiqueExamination.abdominalMassFlag eq "0" || personalPhyExamDTO.physiqueExamination.abdominalMassFlag eq null ?"无":""}
                            ${personalPhyExamDTO.physiqueExamination.abdominalMassFlag eq"1" ?"<b>有</b>":""}
                            ${personalPhyExamDTO.physiqueExamination.abdominalMassDesc}
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">肝大:
                            ${personalPhyExamDTO.physiqueExamination.liverFlag eq "0" || personalPhyExamDTO.physiqueExamination.liverFlag eq null ?"无":""}
                            ${personalPhyExamDTO.physiqueExamination.liverFlag eq"1" ?"<b>有</b>":""}
                            ${personalPhyExamDTO.physiqueExamination.liverDesc}
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">脾大:
                            ${personalPhyExamDTO.physiqueExamination.splenomegalyFlag eq"0" || personalPhyExamDTO.physiqueExamination.splenomegalyFlag eq null ?"无":""}
                            ${personalPhyExamDTO.physiqueExamination.splenomegalyFlag eq"1" ?"<b>有</b>":""}
                            ${personalPhyExamDTO.physiqueExamination.splenomegalyDesc}
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">移动性浊音:
                            ${personalPhyExamDTO.physiqueExamination.abdominalVoicedFlag eq"0" || personalPhyExamDTO.physiqueExamination.abdominalVoicedFlag eq null ?"无":""}
                            ${personalPhyExamDTO.physiqueExamination.abdominalVoicedFlag eq"1" ?"<b>有</b>":""}
                            ${personalPhyExamDTO.physiqueExamination.abdominalVoicedDesc}
                        </td>
                    </tr>
                    <tr>
                        <th>下肢水肿</th>
                        <td colspan="4">
                            <ehr:dic dicmeta="CV0410014" code="${personalPhyExamDTO.physiqueExamination.legsEdemaCheckResult}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>足背动脉搏动</th>
                        <td colspan="4">
                            <ehr:dic dicmeta="CV0410015" code="${personalPhyExamDTO.physiqueExamination.arteriopalmus}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>肛门指诊</th>
                        <td colspan="4">
                            <c:if test="${personalPhyExamDTO.physiqueExamination.dreCheckResultType eq '0'}">未检</c:if>
                            <ehr:dic dicmeta="CV0410013" code="${personalPhyExamDTO.physiqueExamination.dreCheckResultType}"/>
                            ${personalPhyExamDTO.physiqueExamination.dreCheckResultDesc}
                        </td>
                    </tr>
                    <tr>
                        <th>乳腺</th>
                        <td colspan="4">
                            ${personalPhyExamDTO.physiqueExamination.breastAnomalyFlag eq"2" ?"未检 ":""}
                            ${personalPhyExamDTO.physiqueExamination.breastAnomalyFlag eq"0" ?"未见异常 ":""}
                            ${personalPhyExamDTO.physiqueExamination.breastAnomalyFlag eq"1" ?"<b>有异常</b>":""}

                            <c:if test="${personalPhyExamDTO.physiqueExamination.breastAnomalyFlag eq '1'}">
        <span id="ttb8">
            ${personalPhyExamDTO.physiqueExamination.breastResection eq"1" ?        "乳房切除  ": ""}
            ${personalPhyExamDTO.physiqueExamination.breastAnomalyLactation eq"1" ? "异常泌乳  ": ""}
            ${personalPhyExamDTO.physiqueExamination.breastMass eq"1" ?             "乳腺包块  ": ""}
            ${personalPhyExamDTO.physiqueExamination.breastOther eq"1" ?            "其它     " : ""}
            ${personalPhyExamDTO.physiqueExamination.breastOtherDesc}
        </span>
                            </c:if>
                        </td>
                    </tr>
                    <c:if test="${isWoman}">
                        <tr>
                            <th rowspan="5">妇科</th>
                            <td class="td_gray">外阴</td>
                            <td colspan="3">
                                <c:if test="${personalPhyExamDTO.physiqueExamination.vulvaAnomalyFlag eq '2'}">未检</c:if>
                                    ${personalPhyExamDTO.physiqueExamination.vulvaAnomalyFlag eq"0" ?"未见异常 ":""}
                                    ${personalPhyExamDTO.physiqueExamination.vulvaAnomalyFlag eq"1" ?"<b>有异常</b>":""}
                                    ${personalPhyExamDTO.physiqueExamination.vulvaAnomalyDesc}
                            </td>
                        </tr>
                        <tr>
                            <td class="td_gray">阴道</td>
                            <td colspan="3">
                                <c:if test="${personalPhyExamDTO.physiqueExamination.vaginaAnomalyFlag eq '2'}">未检</c:if>
                                    ${personalPhyExamDTO.physiqueExamination.vaginaAnomalyFlag eq"0" ?"未见异常   ":""}
                                    ${personalPhyExamDTO.physiqueExamination.vaginaAnomalyFlag eq"1" ?"<b>有异常</b>":""}
                                    ${personalPhyExamDTO.physiqueExamination.vaginaAnomalyDesc}
                            </td>
                        </tr>
                        <tr>
                            <td class="td_gray">宫颈</td>
                            <td colspan="3">
                                <c:if test="${personalPhyExamDTO.physiqueExamination.cervicalAnomalyFlag eq '2'}">未检</c:if>
                                    ${personalPhyExamDTO.physiqueExamination.cervicalAnomalyFlag eq"0" ?"未见异常  ":""}
                                    ${personalPhyExamDTO.physiqueExamination.cervicalAnomalyFlag eq"1" ?"<b>有异常</b>":""}
                                    ${personalPhyExamDTO.physiqueExamination.cervicalAnomalyDesc}
                            </td>
                        </tr>
                        <tr>
                            <td class="td_gray">宫体</td>
                            <td colspan="3">
                                <c:if test="${personalPhyExamDTO.physiqueExamination.corpusAnomalyFlag eq '2'}">未检</c:if>
                                    ${personalPhyExamDTO.physiqueExamination.corpusAnomalyFlag eq"0" ?"未见异常 ":""}
                                    ${personalPhyExamDTO.physiqueExamination.corpusAnomalyFlag eq"1" ?"<b>有异常</b>":""}
                                    ${personalPhyExamDTO.physiqueExamination.corpusAnomalyDesc}
                            </td>
                        </tr>
                        <tr>
                            <td class="td_gray">附件</td>
                            <td colspan="3">
                                <c:if test="${personalPhyExamDTO.physiqueExamination.accessoriesAnomalyFlag eq '2'}">未检</c:if>
                                    ${personalPhyExamDTO.physiqueExamination.accessoriesAnomalyFlag eq"0" ?"未见异常 ":""}
                                    ${personalPhyExamDTO.physiqueExamination.accessoriesAnomalyFlag eq"1" ?"<b>有异常</b>":""}
                                    ${personalPhyExamDTO.physiqueExamination.accessoriesAnomalyDesc}
                            </td>
                        </tr>
                    </c:if>
                    <tr>
                        <th>其他</th>
                        <td colspan="4">
                            ${personalPhyExamDTO.physiqueExamination.otherCheckResult}
                        </td>
                    </tr>
                    <tr>
                        <th <c:if test="${isWoman}"> rowspan="17" </c:if> <c:if test="${not isWoman}"> rowspan="16" </c:if> >辅助检查</th>
                        <th>血常规</th>
                        <td colspan="4">
                            血红蛋白${personalPhyExamDTO.physiqueExamination.hemoglobinValue}g/L
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            白细胞${personalPhyExamDTO.physiqueExamination.leukocyteCount}×10<sup>9</sup>/L
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            血小板${personalPhyExamDTO.physiqueExamination.plateletCount}×10<sup>9</sup>/L
                            <br>
                            其它${personalPhyExamDTO.physiqueExamination.bloodRoutineOtherDesc}
                        </td>
                    </tr>
                    <tr>
                        <th>尿常规</th>
                        <td colspan="4">
                            尿蛋白${personalPhyExamDTO.physiqueExamination.urineProQuantitativeValue}
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            尿糖${personalPhyExamDTO.physiqueExamination.urineSugQuantitativeValue}
                            &nbsp;&nbsp;&nbsp;&nbsp;
              尿酮体${personalPhyExamDTO.physiqueExamination.ketQuantitativeValue}
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            尿潜血${personalPhyExamDTO.physiqueExamination.eryQuantitativeValue}
                            <br>
                            其它${personalPhyExamDTO.physiqueExamination.urineRoutinesOtherDesc}
                        </td>
                    </tr>
                    <tr>
                        <th>空腹血糖</th>
                        <td colspan="4">
                            <fmt:formatNumber type="number" pattern="#.00" value="${personalPhyExamDTO.physiqueExamination.fpgMmol}"/>mmol/L
                            或
                            <fmt:formatNumber type="number" pattern="#.00" value="${personalPhyExamDTO.physiqueExamination.fpgMg}"/>mg/dL
                        </td>
                        <%-- <td colspan="4">
                            ${personalPhyExamDTO.physiqueExamination.fpgMmol}mmol/L
                            或
                            ${personalPhyExamDTO.physiqueExamination.fpgMg}mg/dL
                        </td> --%>
                    </tr>
                    <tr>
                        <th>来源</th>
                        <td colspan="4">
                            <ehr:dic dicmeta="TFJKDA001" code="${personalPhyExamDTO.physiqueExamination.bloodSugarSource}"/>
                        </td>

                    </tr>
                    <tr>
                        <th>心电图</th>
                        <td colspan="4">
                            <c:if test="${personalPhyExamDTO.physiqueExamination.ecgAnomalyFlag eq '2'}">未检</c:if>
                            ${personalPhyExamDTO.physiqueExamination.ecgAnomalyFlag eq"0" ?"正常":""}
                            ${personalPhyExamDTO.physiqueExamination.ecgAnomalyFlag eq"1" ?"<b>异常</b>":""}
                            ${personalPhyExamDTO.physiqueExamination.ecgAnomalyDesc}
                        </td>
                    </tr>
                    <tr>
                        <th>尿微量白蛋白</th>
                        <td colspan="4">
                            ${personalPhyExamDTO.physiqueExamination.urineMicroTongAlbumin}mg/dL
                        </td>
                    </tr>
                    <tr>
                        <th>大便潜血</th>
                        <td colspan="4">
                            <c:if test="${personalPhyExamDTO.physiqueExamination.fecalOccultBlood eq '0'}">未检</c:if>
                            <ehr:dic dicmeta="FS10058" code="${personalPhyExamDTO.physiqueExamination.fecalOccultBlood}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>糖化血红蛋白</th>
                        <td colspan="4">
                            ${personalPhyExamDTO.physiqueExamination.hgb}%
                        </td>
                    </tr>
                    <tr>
                        <th>乙型肝炎表面抗原</th>
                        <td colspan="4">
                            <c:if test="${personalPhyExamDTO.physiqueExamination.hbsagDetectResult eq '0'}">未检</c:if>
                            <ehr:dic dicmeta="FS10058" code="${personalPhyExamDTO.physiqueExamination.hbsagDetectResult}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>肝功能</th>
                        <td colspan="4">
                            血清谷丙转氨酶 ${personalPhyExamDTO.physiqueExamination.serumGptValue}U/L
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            血清谷草转氨酶 ${personalPhyExamDTO.physiqueExamination.serumAstValue}U/L
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            白蛋白浓度 ${personalPhyExamDTO.physiqueExamination.albuminConcentration}g/L
                            <br>
                            总胆红素 ${personalPhyExamDTO.physiqueExamination.totalBilirubin}μmol/L
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            结合胆红素 ${personalPhyExamDTO.physiqueExamination.conjugatedBilirubin}μmol/L
                        </td>
                    </tr>
                    <tr>
                        <th>肾功能</th>
                        <td colspan="4">
                            血清肌酐 ${personalPhyExamDTO.physiqueExamination.creatinine}μmol/L
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            血尿素氮${personalPhyExamDTO.physiqueExamination.bloodUreaNitrogenValue}mmol/L
                            <br>
                            血钾浓度${personalPhyExamDTO.physiqueExamination.potassiumConcentration}mmol/L
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            血钠浓度${personalPhyExamDTO.physiqueExamination.sodiumConcentration}mmol/L
                        </td>
                    </tr>
                    <tr>
                        <th>血脂</th>
                        <td colspan="4">
                            总胆固醇 ${personalPhyExamDTO.physiqueExamination.tc}mmol/L
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            甘油三酯 ${personalPhyExamDTO.physiqueExamination.triglycerideValue}mmol/L
                            <br>
                            血清低密度脂蛋白胆固醇 ${personalPhyExamDTO.physiqueExamination.ldlcDetectValue}mmol/L
                            <br>
                            血清高密度脂蛋白胆固醇 ${personalPhyExamDTO.physiqueExamination.hdlcDetectValue}mmol/L
                        </td>
                    </tr>
                    <tr>
                        <th>胸部X线片</th>
                        <td colspan="4">
                            ${personalPhyExamDTO.physiqueExamination.chestXAnomalyfFlag eq "2" ?"未检":""}
                            ${personalPhyExamDTO.physiqueExamination.chestXAnomalyfFlag eq "0" ?"正常":""}
                            ${personalPhyExamDTO.physiqueExamination.chestXAnomalyfFlag eq "1" ?"<b>异常</b>":""}
                            ${personalPhyExamDTO.physiqueExamination.chestXAnomalyfDesc}
                        </td>
                    </tr>
                    <tr>
                        <th rowspan="2">B超</th>
                        <td width="16%" class="td_gray">腹部B超</td>
                        <td colspan="3">
                            ${personalPhyExamDTO.physiqueExamination.bmodeAnomalyfFlag eq"2" ?"未检":""}
                            ${personalPhyExamDTO.physiqueExamination.bmodeAnomalyfFlag eq"0" ?"正常":""}
                            ${personalPhyExamDTO.physiqueExamination.bmodeAnomalyfFlag eq"1" ?"<b>异常</b>":""}
                            ${personalPhyExamDTO.physiqueExamination.bmodeAnomalyfDesc}
                        </td>
                    </tr>
                    <tr>
                        <td width="16%" class="td_gray">其他B超</td>
                        <td colspan="3">
                            ${personalPhyExamDTO.physiqueExamination.bmodeOtherAnomalyfFlag eq"2" ?"未检":""}
                            ${personalPhyExamDTO.physiqueExamination.bmodeOtherAnomalyfFlag eq"0" ?"正常":""}
                            ${personalPhyExamDTO.physiqueExamination.bmodeOtherAnomalyfFlag eq"1" ?"<b>异常</b>":""}
                            ${personalPhyExamDTO.physiqueExamination.bmodeOtherAnomalyfDesc}
                        </td>
                    </tr>
                    <c:if test="${isWoman}">
                        <tr>
                            <th>宫颈涂片</th>
                            <td colspan="4">
                                    ${personalPhyExamDTO.physiqueExamination.cervicalSmearAnomalyfFlag eq"2" ?"未检":""}
                                    ${personalPhyExamDTO.physiqueExamination.cervicalSmearAnomalyfFlag eq"0" ?"正常":""}
                                    ${personalPhyExamDTO.physiqueExamination.cervicalSmearAnomalyfFlag eq"1" ?"<b>异常</b>":""}
                                    ${personalPhyExamDTO.physiqueExamination.cervicalSmearAnomalyfDesc}
                            </td>
                        </tr>
                    </c:if>
                    <tr>
                        <th>其他</th>
                        <td colspan="4">
                            ${personalPhyExamDTO.physiqueExamination.otherAuxiliaryExamination}
                        </td>
                    </tr>
                <c:if test="${isElder}">
                    <tr>
                        <th rowspan="9">中医体质辨识</th>
                        <%-- <c:if test="${not empty personalPhyExamDTO.physiqueExamination.tcmPeacefulQuality }">
                            <div class="toolbarsublist">
                                <a href="javascript:void(0)" id="addEch"><b class="xinz">查看体质辨识</b></a>
                            </div>
                        </c:if> --%>

                        <th>平和质</th>
                        <td colspan="4">
                            <ehr:dic dicmeta="FS10186" code="${personalPhyExamDTO.physiqueExamination.tcmPeacefulQuality}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>气虚质</th>
                        <td colspan="4">
                            <ehr:dic dicmeta="FS10186" code="${personalPhyExamDTO.physiqueExamination.tcmQiQuality}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>阳虚质</th>
                        <td colspan="4">
                            <ehr:dic dicmeta="FS10186" code="${personalPhyExamDTO.physiqueExamination.tcmYangQuality}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>阴虚质</th>
                        <td colspan="4">
                            <ehr:dic dicmeta="FS10186" code="${personalPhyExamDTO.physiqueExamination.tcmYinDeficiency}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>痰湿质</th>
                        <td colspan="4">
                            <ehr:dic dicmeta="FS10186" code="${personalPhyExamDTO.physiqueExamination.tcmPhlegmWetness}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>湿热质</th>
                        <td colspan="4">
                            <ehr:dic dicmeta="FS10186" code="${personalPhyExamDTO.physiqueExamination.tcmHeatMedium}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>血瘀质</th>
                        <td colspan="4">
                            <ehr:dic dicmeta="FS10186" code="${personalPhyExamDTO.physiqueExamination.tcmBloodQuality}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>气郁质</th>
                        <td colspan="4">
                            <ehr:dic dicmeta="FS10186" code="${personalPhyExamDTO.physiqueExamination.tcmQiStagnation}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>特秉质</th>
                        <td colspan="4">
                            <ehr:dic dicmeta="FS10186" code="${personalPhyExamDTO.physiqueExamination.tcmSpecialQuality}"/>
                        </td>
                    </tr>
                </c:if>
                    <tr>
                        <th rowspan="7">现存主要健康问题</th>
                        <th>脑血管疾病</th>
                        <td colspan="4">
                            ${personalPhyExamDTO.physiqueExamination.cvascularFlag eq"0" ?"未发现":""}
                            ${personalPhyExamDTO.physiqueExamination.cvascularFlag eq"1" ?"<b>已发现</b>":""}
                            <c:if test="${personalPhyExamDTO.physiqueExamination.cvascularFlag eq '1'}">
            <span id="ttb9">
            ${personalPhyExamDTO.physiqueExamination.cvascularHemorrhageStroke eq '1' ?     '缺血性卒中         ':''}
            ${personalPhyExamDTO.physiqueExamination.cvascularHemorrhage eq '1' ?           '脑出血           ':''}
            ${personalPhyExamDTO.physiqueExamination.cvascularSah eq '1' ?                  '蛛网膜下腔出血       ':''}
            ${personalPhyExamDTO.physiqueExamination.covascularTransientIschemic eq '1' ?   '短暂性脑缺血发作      ':''}
            ${personalPhyExamDTO.physiqueExamination.covascularOther eq '1' ?               '其它            ':''}
            ${personalPhyExamDTO.physiqueExamination.cvascularOtherDesc}
            </span>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <th>肾脏疾病</th>
                        <td colspan="4">
                            ${personalPhyExamDTO.physiqueExamination.kidneyDiseaseFlag eq"0" ?"未发现":""}
                            ${personalPhyExamDTO.physiqueExamination.kidneyDiseaseFlag eq"1" ?"<b>已发现</b>":""}
                            <c:if test="${personalPhyExamDTO.physiqueExamination.kidneyDiseaseFlag eq '1'}">
        <span id="ttb10">
            ${personalPhyExamDTO.physiqueExamination.kidneyDiabeticNephropathy eq '1' ? '糖尿病肾病   ':''}
            ${personalPhyExamDTO.physiqueExamination.kidneyRenalFailure eq '1' ?        '肾功能衰竭   ':''}
            ${personalPhyExamDTO.physiqueExamination.kidneyAcuteNephritis eq '1' ?      '急性肾炎    ':''}
            ${personalPhyExamDTO.physiqueExamination.kidneyChronicNephritis eq '1' ?    '慢性肾炎    ':''}
            ${personalPhyExamDTO.physiqueExamination.kidneyOther eq '1' ?               '其它      ':''}
            ${personalPhyExamDTO.physiqueExamination.kidneyOtherDesc}
        </span>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <th>心脏疾病</th>
                        <td colspan="4">
                            ${personalPhyExamDTO.physiqueExamination.heartDiseaseFlag eq"0" ?"未发现 ":""}
                            ${personalPhyExamDTO.physiqueExamination.heartDiseaseFlag eq"1" ?"<b>已发现</b> ":""}
                            <c:if test="${personalPhyExamDTO.physiqueExamination.heartDiseaseFlag eq '1'}">
        <span id="ttb11">
            ${personalPhyExamDTO.physiqueExamination.heartMiocardialInfarction eq '1' ? '心肌梗死         ':''}
            ${personalPhyExamDTO.physiqueExamination.heartAnginaPectoris eq '1' ?       '心绞痛          ':''}
            ${personalPhyExamDTO.physiqueExamination.heartCoronary eq '1' ?             '冠状动脉血运重建     ':''}
            ${personalPhyExamDTO.physiqueExamination.heartCongestiveHeart eq '1' ?      '充血性心力衰竭        ':''}
            ${personalPhyExamDTO.physiqueExamination.heartPrecordialPain eq '1' ?       '心前区疼痛        ':''}
            ${personalPhyExamDTO.physiqueExamination.heartOther eq '1' ?                '其它           ':''}
            ${personalPhyExamDTO.physiqueExamination.heartOtherDesc}
         </span>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <th>血管疾病</th>
                        <td colspan="4">
                            ${personalPhyExamDTO.physiqueExamination.arteryDiseaseFlag eq"0" ?"未发现":""}
                            ${personalPhyExamDTO.physiqueExamination.arteryDiseaseFlag eq"1" ?"<b>已发现</b>":""}
                            <c:if test="${personalPhyExamDTO.physiqueExamination.arteryDiseaseFlag eq '1'}">
         <span id="ttb12">
            ${personalPhyExamDTO.physiqueExamination.arteryDissectingAneurysm eq '1' ?  '夹层动脉瘤      ':''}
            ${personalPhyExamDTO.physiqueExamination.arteryPaod eq '1' ?                '动脉闭塞性疾病    ':''}
            ${personalPhyExamDTO.physiqueExamination.arteryOther eq '1' ?               '其它         ':''}
            ${personalPhyExamDTO.physiqueExamination.arteryOtherDesc}
         </span>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <th>眼部疾病</th>
                        <td colspan="4">
                            ${personalPhyExamDTO.physiqueExamination.eyeDiseasesFlag eq"0" ?"未发现":""}
                            ${personalPhyExamDTO.physiqueExamination.eyeDiseasesFlag eq"1" ?"<b>已发现</b>":""}
                            <c:if test="${personalPhyExamDTO.physiqueExamination.eyeDiseasesFlag eq '1'}">
         <span id="ttb13">
            ${personalPhyExamDTO.physiqueExamination.eyeRetinalOozing eq '1' ?  '视网膜出血或者渗出       ':''}
            ${personalPhyExamDTO.physiqueExamination.eyeOpticPapilla eq '1' ?   '视乳头水肿           ':''}
            ${personalPhyExamDTO.physiqueExamination.eyeCataract eq '1' ?       '白内障             ':''}
            ${personalPhyExamDTO.physiqueExamination.eyeOther eq '1' ?          '其它              ':''}
            ${personalPhyExamDTO.physiqueExamination.eyeOtherDesc}
        </span>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <th>神经系统疾病</th>
                        <td colspan="4">
                            ${personalPhyExamDTO.physiqueExamination.nervousDiseasesFlag eq"0" ?"未发现  ":""}
                            ${personalPhyExamDTO.physiqueExamination.nervousDiseasesFlag eq"1" ?"<b>有</b> ":""}
                            ${personalPhyExamDTO.physiqueExamination.nervousDiseasesDesc}
                        </td>
                    </tr>
                    <tr>
                        <th>其他系统疾病</th>
                        <td colspan="4">
                            ${personalPhyExamDTO.physiqueExamination.healthOther eq"0" ?"未发现   ":""}
                            ${personalPhyExamDTO.physiqueExamination.healthOther eq"1" ?"<b>有</b> ":""}
                            ${personalPhyExamDTO.physiqueExamination.healthOtherDesc}
                        </td>
                    </tr>
                    <tr>
                        <th rowspan="2">住院治疗情况</th>
                        <th>住院史</th>
                        <td colspan="4">
                            ${personalPhyExamDTO.hospitalizedHistoryFlg eq "0" || personalPhyExamDTO.hospitalizedHistoryFlg eq null ? "无":""}
                            ${personalPhyExamDTO.hospitalizedHistoryFlg eq "1" ? "<b>有</b>":""}
                            <c:if test="${not empty personalPhyExamDTO.hospitalizedHistoryList}">
                                <table id="ttb20">
                                    <tr>
                                        <td class="td_gray">入院时间</td>
                                        <td class="td_gray">原因</td>
                                        <td class="td_gray">医疗机构名称</td>
                                        <td class="td_gray">病案号</td>
                                    </tr>
                                    <c:forEach items="${personalPhyExamDTO.hospitalizedHistoryList}" var="hospitalizedList" varStatus="status">
                                        <c:if test="${not empty hospitalizedList.inDate or not empty hospitalizedList.outhosDate or not empty hospitalizedList.inhosReason or not empty hospitalizedList.inputOrganName or not empty hospitalizedList.medicalRecordNo}">
                                            <tr>
                                                <td>
                                                    <div style="width: 140px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;" title=
                                                            <fmt:formatDate value="${hospitalizedList.inDate}" pattern="yyyy/MM/dd"/><fmt:formatDate
                                                            value="${hospitalizedList.outhosDate}" pattern="yyyy/MM/dd"/>>
                                                        <fmt:formatDate value="${hospitalizedList.inDate}" pattern="yyyy/MM/dd"/>
                                                        ~ <fmt:formatDate value="${hospitalizedList.outhosDate}" pattern="yyyy/MM/dd"/>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div style="width:180px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;"
                                                         title="${hospitalizedList.inhosReason}">
                                                            ${hospitalizedList.inhosReason}
                                                    </div>
                                                </td>
                                                <td>
                                                    <div style="width:150px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;"
                                                         title="${hospitalizedList.inputOrganName}">
                                                            ${hospitalizedList.inputOrganName}
                                                    </div>
                                                </td>
                                                <td>
                                                    <div style="width:80px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;"
                                                         title="${hospitalizedList.medicalRecordNo}">
                                                            ${hospitalizedList.medicalRecordNo}
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:if>
                                    </c:forEach>
                                </table>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <th>家庭病床史</th>
                        <td colspan="4">
                            ${personalPhyExamDTO.familyBedHistoryFlg eq '0' || personalPhyExamDTO.familyBedHistoryFlg eq null ? '无':''}
                            ${personalPhyExamDTO.familyBedHistoryFlg eq '1' ? '<b>有</b>':''}

                            <c:if test="${not empty personalPhyExamDTO.familyBedHistoryList}">
                                <table id="ttb21">
                                    <tr>
                                        <td class="td_gray">建/撤床日期</td>
                                        <td class="td_gray">原因</td>
                                        <td class="td_gray">医疗机构名称</td>
                                        <td class="td_gray">病案号</td>
                                    </tr>
                                    <c:forEach items="${personalPhyExamDTO.familyBedHistoryList}" var="familyBed" varStatus="status">
                                        <c:if test="${not empty familyBed.builtBedDate || not empty familyBed.removeBedDate || not empty familyBed.builtBedReason || not empty familyBed.inputOrganName || not empty familyBed.medicalRecordNo}">
                                            <tr>
                                                <td>
                                                    <div style="width: 140px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;" title=
                                                            <fmt:formatDate value="${familyBed.builtBedDate}" pattern="yyyy/MM/dd"/><fmt:formatDate
                                                            value="${familyBed.removeBedDate}" pattern="yyyy/MM/dd"/>>
                                                        <fmt:formatDate value="${familyBed.builtBedDate}" pattern="yyyy/MM/dd"/>
                                                        ~ <fmt:formatDate value="${familyBed.removeBedDate}" pattern="yyyy/MM/dd"/>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div style="width:180px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;"
                                                         title="${familyBed.builtBedReason}">
                                                            ${familyBed.builtBedReason}
                                                    </div>
                                                </td>
                                                <td>
                                                    <div style="width:150px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;"
                                                         title="${familyBed.inputOrganName}">
                                                            ${familyBed.inputOrganName}
                                                    </div>
                                                </td>
                                                <td>
                                                    <div style="width:80px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;"
                                                         title="${familyBed.medicalRecordNo}">
                                                            ${familyBed.medicalRecordNo}
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:if>
                                    </c:forEach>
                                </table>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <th colspan="2">主要用药情况</th>
                        <td colspan="4">
                            ${personalPhyExamDTO.drugHistoryFlag eq '0' || personalPhyExamDTO.drugHistoryFlag eq null ?'无':'' }
                            ${personalPhyExamDTO.drugHistoryFlag eq '1'?'<b>有</b>':'' }
                            <br>

                            <c:if test="${not empty personalPhyExamDTO.drugHistoryList}">
                                <table id="ttb22">
                                    <c:if test="${not empty personalPhyExamDTO.drugHistoryList[0].drugGenericName}">
                                        <tr>
                                            <th style="width: 17%">第一种药物名称</th>
                                            <td style="width: 26%">${personalPhyExamDTO.drugHistoryList[0].drugGenericName}</td>
                                            <th style="width: 13%">用法与用量</th>
                                            <td style="width: 44%">
                                                <ehr:dic dicmeta="CV0600102" code="${personalPhyExamDTO.drugHistoryList[0].drugUseRouteCode}"/>
                                                每日 ${personalPhyExamDTO.drugHistoryList[0].drugUseFrequency}次,
                                                每次${personalPhyExamDTO.drugHistoryList[0].drugUseState}
                                                <ehr:dic dicmeta="DMD00067" code="${personalPhyExamDTO.drugHistoryList[0].drugUseDoseUnit}"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th style="width: 17%">用药时间</th>
                                            <td style="width: 26%">
                                                <fmt:formatDate value="${personalPhyExamDTO.drugHistoryList[0].startDate}" pattern="yyyy/MM/dd"/> ~
                                                <fmt:formatDate value="${personalPhyExamDTO.drugHistoryList[0].stopDate}" pattern="yyyy/MM/dd"/>
                                            </td>
                                            <th style="width: 13%">服药依从性</th>
                                            <td style="width: 44%"><ehr:dic dicmeta="FS10141"
                                                                            code="${personalPhyExamDTO.drugHistoryList[0].medicationCompliance}"/></td>
                                        </tr>
                                    </c:if>
                                    <c:if test="${not empty personalPhyExamDTO.drugHistoryList[1].drugGenericName}">
                                        <tr>
                                            <th style="width: 17%">第二种药物名称</th>
                                            <td style="width: 26%">${personalPhyExamDTO.drugHistoryList[1].drugGenericName}</td>
                                            <th style="width: 13%">用法与用量</th>
                                            <td style="width: 44%">
                                                <ehr:dic dicmeta="CV0600102" code="${personalPhyExamDTO.drugHistoryList[1].drugUseRouteCode}"/>
                                                每日 ${personalPhyExamDTO.drugHistoryList[1].drugUseFrequency}次,
                                                每次${personalPhyExamDTO.drugHistoryList[1].drugUseState}
                                                <ehr:dic dicmeta="DMD00067" code="${personalPhyExamDTO.drugHistoryList[1].drugUseDoseUnit}"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th style="width: 17%">用药时间</th>
                                            <td style="width: 26%">
                                                <fmt:formatDate value="${personalPhyExamDTO.drugHistoryList[1].startDate}" pattern="yyyy/MM/dd"/> ~
                                                <fmt:formatDate value="${personalPhyExamDTO.drugHistoryList[1].stopDate}" pattern="yyyy/MM/dd"/>
                                            </td>
                                            <th style="width: 13%">服药依从性</th>
                                            <td style="width: 44%"><ehr:dic dicmeta="FS10141"
                                                                            code="${personalPhyExamDTO.drugHistoryList[1].medicationCompliance}"/></td>
                                        </tr>
                                    </c:if>
                                    <c:if test="${not empty personalPhyExamDTO.drugHistoryList[2].drugGenericName}">
                                        <tr>
                                            <th style="width: 17%">第三种药物名称</th>
                                            <td style="width: 26%">${personalPhyExamDTO.drugHistoryList[2].drugGenericName}</td>
                                            <th style="width: 13%">用法与用量</th>
                                            <td style="width: 44%">
                                                <ehr:dic dicmeta="CV0600102" code="${personalPhyExamDTO.drugHistoryList[2].drugUseRouteCode}"/>
                                                每日 ${personalPhyExamDTO.drugHistoryList[2].drugUseFrequency}次,
                                                每次${personalPhyExamDTO.drugHistoryList[2].drugUseState}
                                                <ehr:dic dicmeta="DMD00067" code="${personalPhyExamDTO.drugHistoryList[2].drugUseDoseUnit}"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th style="width: 17%">用药时间</th>
                                            <td style="width: 26%">
                                                <fmt:formatDate value="${personalPhyExamDTO.drugHistoryList[2].startDate}" pattern="yyyy/MM/dd"/> ~
                                                <fmt:formatDate value="${personalPhyExamDTO.drugHistoryList[2].stopDate}" pattern="yyyy/MM/dd"/>
                                            </td>
                                            <th style="width: 13%">服药依从性</th>
                                            <td style="width: 44%"><ehr:dic dicmeta="FS10141"
                                                                            code="${personalPhyExamDTO.drugHistoryList[2].medicationCompliance}"/></td>
                                        </tr>
                                    </c:if>
                                    <c:if test="${not empty personalPhyExamDTO.drugHistoryList[3].drugGenericName}">
                                        <tr>
                                            <th style="width: 17%">第四种药物名称</th>
                                            <td style="width: 26%">${personalPhyExamDTO.drugHistoryList[3].drugGenericName}</td>
                                            <th style="width: 13%">用法与用量</th>
                                            <td style="width: 44%">
                                                <ehr:dic dicmeta="CV0600102" code="${personalPhyExamDTO.drugHistoryList[3].drugUseRouteCode}"/>
                                                每日 ${personalPhyExamDTO.drugHistoryList[3].drugUseFrequency}次,
                                                每次${personalPhyExamDTO.drugHistoryList[3].drugUseState}
                                                <ehr:dic dicmeta="DMD00067" code="${personalPhyExamDTO.drugHistoryList[3].drugUseDoseUnit}"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th style="width: 17%">用药时间</th>
                                            <td style="width: 26%">
                                                <fmt:formatDate value="${personalPhyExamDTO.drugHistoryList[3].startDate}" pattern="yyyy/MM/dd"/> ~
                                                <fmt:formatDate value="${personalPhyExamDTO.drugHistoryList[3].stopDate}" pattern="yyyy/MM/dd"/>
                                            </td>
                                            <th style="width: 13%">服药依从性</th>
                                            <td style="width: 44%"><ehr:dic dicmeta="FS10141"
                                                                            code="${personalPhyExamDTO.drugHistoryList[3].medicationCompliance}"/></td>
                                        </tr>
                                    </c:if>
                                    <c:if test="${not empty personalPhyExamDTO.drugHistoryList[4].drugGenericName}">
                                        <tr>
                                            <th style="width: 17%">第五种药物名称</th>
                                            <td style="width: 26%">${personalPhyExamDTO.drugHistoryList[4].drugGenericName}</td>
                                            <th style="width: 13%">用法与用量</th>
                                            <td style="width: 44%">
                                                <ehr:dic dicmeta="CV0600102" code="${personalPhyExamDTO.drugHistoryList[4].drugUseRouteCode}"/>
                                                每日 ${personalPhyExamDTO.drugHistoryList[4].drugUseFrequency}次,
                                                每次${personalPhyExamDTO.drugHistoryList[4].drugUseState}
                                                <ehr:dic dicmeta="DMD00067" code="${personalPhyExamDTO.drugHistoryList[4].drugUseDoseUnit}"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th style="width: 17%">用药时间</th>
                                            <td style="width: 26%">
                                                <fmt:formatDate value="${personalPhyExamDTO.drugHistoryList[4].startDate}" pattern="yyyy/MM/dd"/> ~
                                                <fmt:formatDate value="${personalPhyExamDTO.drugHistoryList[4].stopDate}" pattern="yyyy/MM/dd"/>
                                            </td>
                                            <th style="width: 13%">服药依从性</th>
                                            <td style="width: 44%"><ehr:dic dicmeta="FS10141"
                                                                            code="${personalPhyExamDTO.drugHistoryList[4].medicationCompliance}"/></td>
                                        </tr>
                                    </c:if>
                                </table>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <th colspan="2">非免疫规划预防接种史</th>
                        <td colspan="4">
                            ${personalPhyExamDTO.vaccinationInfoFlg eq '0' || personalPhyExamDTO.vaccinationInfoFlg eq null ? '无':''}
                            ${personalPhyExamDTO.vaccinationInfoFlg eq '1' ? '<b>有</b>':''}

                            <c:if test="${not empty personalPhyExamDTO.vaccinationInfoList}">
                                <table>
                                    <tr>
                                        <th>名称</th>
                                        <th>接种日期</th>
                                        <th>接种机构</th>
                                    </tr>

                                    <c:forEach items="${personalPhyExamDTO.vaccinationInfoList}" var="vaccinationInfo" varStatus="status">
                                        <c:if test="${ not empty vaccinationInfo.vaccineName|| not empty vaccinationInfo.vaccinationUnitName}">
                                            <tr>
                                                <td>
                                                        ${vaccinationInfo.vaccineName}
                                                </td>
                                                <td>
                                                    <fmt:formatDate value="${vaccinationInfo.vaccinationDate}" pattern="yyyy/MM/dd"/>
                                                </td>
                                                <td>
                                                        ${vaccinationInfo.vaccinationUnitName}
                                                </td>
                                            </tr>
                                        </c:if>
                                    </c:forEach>
                                </table>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <th colspan="2">健康评价</th>
                        <td colspan="4">
                            ${personalPhyExamDTO.healthEvaluateAnomalyFlg eq '0'?'体检无异常（结合临床表现综合评估）':''}
                            ${personalPhyExamDTO.healthEvaluateAnomalyFlg eq '1'?'<b>有异常</b>':''}
                            <br>
                            <c:if test="${not empty personalPhyExamDTO.physiqueExamination.id }">
                                <c:forEach items="${personalPhyExamDTO.healthEvaluateAnomalyList}" var="healEvaluateAnomaly" varStatus="status">
                                    异常 ${healEvaluateAnomaly.healthEvaluateAnomalyDesc}<br>
                                </c:forEach>
                            </c:if>
                            <c:if test="${not empty personalPhyExamDTO.physiqueExamination.healthEvaluateCheck }">
                                <c:set var="healthEvaluateCheck" value="${personalPhyExamDTO.physiqueExamination.healthEvaluateCheck}"/>
                                <c:forEach var="tdv" items="${fn:split(healthEvaluateCheck,',')}">
                                    <c:if test="${not empty tdv}">
                                        异常 <ehr:dic dicmeta="IDM00645" code="${tdv}"/><br/>
                                    </c:if>

                                </c:forEach>
                            </c:if>
                            <c:if test="${not empty personalPhyExamDTO.physiqueExamination.healthEvaluateOtherDesc }">
                                其他异常 ${personalPhyExamDTO.physiqueExamination.healthEvaluateOtherDesc}
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <th colspan="2">健康指导</th>
                        <td colspan="2">
                            <c:if test="${personalPhyExamDTO.physiqueExamination.guideRegularFollowup eq '1' }">
                                <span>定期随访</span><br/>
                            </c:if>
                            <c:if test="${personalPhyExamDTO.physiqueExamination.guideIntoChronicDisease eq '1' }">
                                <span>纳入慢性病患者健康管理</span><br/>
                            </c:if>
                            <c:if test="${personalPhyExamDTO.physiqueExamination.guideSuggestionReview eq '1' }">
                                <span>建议复查</span><br/>
                            </c:if>
                            <c:if test="${personalPhyExamDTO.physiqueExamination.guideSuggestionReferral eq '1' }">
                                <span>建议转诊</span><br/>
                            </c:if>
                            <c:if test="${personalPhyExamDTO.physiqueExamination.includedSixManagement eq '1' }">
                                <span>纳入0-6岁儿童管理</span><br/>
                            </c:if>
                            <c:if test="${personalPhyExamDTO.physiqueExamination.maternalManagement eq '1' }">
                                <span>纳入孕产妇管理</span><br/>
                            </c:if>
                            <c:if test="${personalPhyExamDTO.physiqueExamination.preventionOsteoporosis eq '1' }">
                                <span>骨质疏松预防</span><br/>
                            </c:if>
                            <c:if test="${personalPhyExamDTO.physiqueExamination.preventionTumble eq '1' }">
                                <span>防跌倒措施</span><br/>
                            </c:if>
                            <c:if test="${personalPhyExamDTO.physiqueExamination.preventionInjury eq '1' }">
                                <span>意外伤害预防</span><br/>
                            </c:if>

                        </td>
                        <td colspan="2">
                            危险因素控制
                            <br>
                            <c:if test="${personalPhyExamDTO.physiqueExamination.riskQuitSmoking eq '1' }">
                                <span>戒烟</span><br/>
                            </c:if>
                            <c:if test="${personalPhyExamDTO.physiqueExamination.riskHealthDrink eq '1' }">
                                <span>健康饮酒</span><br/>
                            </c:if>
                            <c:if test="${personalPhyExamDTO.physiqueExamination.riskDiet eq '1' }">
                                <span>饮食</span><br/>
                            </c:if>
                            <c:if test="${personalPhyExamDTO.physiqueExamination.riskExercise eq '1' }">
                                <span>锻炼</span><br/>
                            </c:if>
                            <c:if test="${personalPhyExamDTO.physiqueExamination.riskWeightReduction eq '1' }">
                                <span>减体重</span>
                                <c:if test="${personalPhyExamDTO.physiqueExamination.riskWeightReduction eq '1'}">
                                    <span id="riskWeightTarget">目标： ${personalPhyExamDTO.physiqueExamination.riskWeightTarget}kg</span><br/>
                                </c:if>
                            </c:if>
                            <c:if test="${personalPhyExamDTO.physiqueExamination.guideVaccination eq '1'}">
                                <span>建议接种疫苗</span>
                                <c:if test="${personalPhyExamDTO.physiqueExamination.guideVaccination eq '1'}">
                                    <span id="guideVaccinationDesc"> ${personalPhyExamDTO.physiqueExamination.guideVaccinationDesc}</span><br/>
                                </c:if>
                            </c:if>
                            <c:if test="${personalPhyExamDTO.physiqueExamination.riskOther eq '1'}">
                                <span>其他</span>
                                <c:if test="${personalPhyExamDTO.physiqueExamination.riskOther eq '1'}">
                                    <span id="riskOtherDesc"> ${personalPhyExamDTO.physiqueExamination.riskOtherDesc}</span><br/>
                                </c:if>
                            </c:if>
                        </td>
                    </tr>
                </table>
            </div>
        </form>
    </div>
</div>

