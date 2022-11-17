<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/hm/manage/report.js"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css"/>
<link href="${pageContext.request.contextPath}/css/views/ehrbrowser/personalRecord/phyExam.css" type="text/css"
      rel="stylesheet"/>
<script type="text/javascript">
    $(function() {
        toggleOther('healthEvaluateAnomalyFlag', 'ttb30', '1');
    })

</script>
<style  type="text/css">
    .dt {
        background:#eeeeee;
        color:#4a4a4a;
        font-size: 14px;
        font-weight:bold;
        width:80px;
        padding-left:5px;
        padding-right:5px;
        border-bottom: 1px solid #666;
    }
    .dd{
        margin:5px 0;
        padding:5px 0;
        border-bottom: 1px solid #666;
    }
</style>

<div id="con_two_3" style="width: 95%; margin: 0 auto;">
    <form action="" id="phyExamForm">
        <table style="margin-top: 15px;">
            <tr>
                <td colspan="2" style="text-align: center;"><h1>老年人体检报告</h1></td>
            </tr>
            <tr>
                <td class="dt">编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
                <td class="dd">${physiqueExamination.physicalExamCode}</td>
            </tr>
            <tr>
                <td height="2" colspan="2"></td>
            </tr>
            <tr>
                <td class="dt">体检机构：</td>
                <td class="dd"><ehr:org code="${physiqueExamination.examinationOrganCode}"/></td>
            </tr>
            <tr>
                <td height="2" colspan="2"></td>
            </tr>
            <tr>
                <td class="dt">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
                <td class="dd">${physiqueExamination.name}</td>
            </tr>
            <tr>
                <td height="2" colspan="2"></td>
            </tr>
            <tr>
                <td class="dt">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
                <td class="dd"><ehr:dic dicmeta="GBT226112003" code="${physiqueExamination.gender}"/></td>
            </tr>
            <tr>
                <td height="2" colspan="2"></td>
            </tr>
            <tr>
                <td class="dt">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：</td>
                <td class="dd">${physiqueExamination.age}</td>
            </tr>
        </table>
        <table>
            <colgroup>
                <col style="width: 50%;">
                <col style="width: 50%;">
            </colgroup>
            <tr>
                <td><b>体检日期：</b><fmt:formatDate value="${physiqueExamination.examinationDate}" pattern="yyyy/MM/dd"/></td>
                <td style="text-align: right;"><b>责任医生：</b>${physiqueExamination.manaDoctorName}</td>
            </tr>
        </table>

        <div class="table-basic" style="height: 330px;">
            <table class="formtable" width="100%" border="0" cellpadding="0" cellspacing="0" style="clear:both;">
                <colgroup>
                    <col style="width: 12%;">
                    <col style="width: 15%;">
                    <col style="width: 15%;">
                    <col style="width: 15%;">
                    <col style="width: 13%;">
                    <col style="width: 25%;">
                </colgroup>
            <tr>
                <td class="h_top">内容</td>
                <td colspan="5" class="h_top">检查细项及结果</td>
            </tr>
            <tr>
                <th>症状</th>
                <td colspan="5">
                    ${physiqueExamination.symptomFlag eq '0' ? '无症状':''}
                    <c:if test="${physiqueExamination.symptomOtherDesc ne '未检'}">
                            ${physiqueExamination.symptomFlag eq '1' ? '有症状：<br>':''}
                    </c:if>
                    <c:if test="${physiqueExamination.symptomFlag eq '1'}">
                        ${physiqueExamination.symptomHeadache eq '1' ? '头痛&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomDizzy eq '1' ? '头晕&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomPalpitations eq '1' ? '心悸&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomChestTightness eq '1' ? '胸闷&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomChestPain eq '1' ? '胸痛&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomChronicCough eq '1' ? '慢性咳嗽&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomCough eq '1' ? '咳痰&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomDyspnea eq '1' ? '呼吸困难&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomPolydipsia eq '1' ? '多饮&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomPolyuria eq '1' ? '多尿&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomWeightLoss eq '1' ? '体重下降&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomFatigue eq '1' ? '乏力&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomJointPain eq '1' ? '关节肿痛&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomBlurredVision eq '1' ? '视力模糊&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomNumbness eq '1' ? '手脚麻木&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomUrgency eq '1' ? '尿急&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomDysuria eq '1' ? '尿痛&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomConstipation eq '1' ? '便秘&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomDiarrhea eq '1' ? '腹泻&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomNauseaVomiting eq '1' ? '恶心呕吐&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomVertigo eq '1' ? '眼花&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomTinnitus eq '1' ? '耳鸣&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomBreastTenderness eq '1' ? '乳房胀痛&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomOther eq '1' ? '<br>其他症状:&nbsp;&nbsp;':''}
                        ${physiqueExamination.symptomOtherDesc}
                    </c:if>
            </tr>
            <tr>
            	<th>既往史</th>
            	<td colspan="5">${physiqueExamination.pastHistory}</td>
            </tr>
            <tr>
            	<th>家族史</th>
            	<td colspan="5">${physiqueExamination.familyHistory}</td>
            </tr>
            <tr>
                <th rowspan="15">一般状况</th>
                <th>体温</th>
                <td colspan="2">${physiqueExamination.temperature}℃</td>
                <th>脉率</th>
                <td>${physiqueExamination.pulseRate}次/分钟</td>
            </tr>
            <tr>
                <th>呼吸频率</th>
                <td colspan="2">${physiqueExamination.respiratoryRate}次/分钟</td>
                <th>血压</th>
                <td>
                    <table>
                        <tr>
                            <td>左侧</td>
                            <td>
                                ${physiqueExamination.leftSbp}/
                                ${physiqueExamination.leftDbp}mmHg
                            </td>
                            <td>右侧</td>
                            <td>
                                ${physiqueExamination.rightSbp}/
                                ${physiqueExamination.rightDbp}mmHg
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <th>身高</th>
                <td colspan="2">${physiqueExamination.height}cm</td>
                <th>体重</th>
                <td>${physiqueExamination.bodyWeight}kg</td>
            </tr>
            <tr>
                <th>腰围</th>
                <td colspan="2">${physiqueExamination.waostline}cm</td>
                <th>体质指数（BMI）</th>
                <td>${physiqueExamination.indexOfBodyCharacteristics}kg/㎡</td>
            </tr>
            <tr>
                <th>臀围</th>
                <td colspan="2">${physiqueExamination.hip}cm</td>
                <th>腰臀围比值</th>
                <td>${physiqueExamination.whr}</td>
            </tr>
            <tr>
                <th>老年人健康状况自我评估</th>
                <td colspan="4">
                    <c:if test="${operate eq 'view'}">
                        <ehr:dic dicmeta="CV0401013" code="${physiqueExamination.healthSelfAssessment}"/>
                    </c:if>
                    <c:if test="${operate eq 'edit'}">
                        <ehr:authorize ifAnyGranted="02,03">
                            <ehr:dic-radio name="healthSelfAssessment" value="${physiqueExamination.healthSelfAssessment}"
                                           dicmeta="CV0401013"/>
                        </ehr:authorize>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th rowspan="6">老年人生活自理能力自我评估</th>
                <td colspan="4">
                    <c:if test="${operate eq 'view'}">
                        <ehr:dic dicmeta="CV0401014" code="${physiqueExamination.lifeAbilitySelfAssessment}"/>
                    </c:if>
                    <c:if test="${operate eq 'edit'}">
                        <ehr:authorize ifAnyGranted="02,03">
                            <ehr:dic-radio name="lifeAbilitySelfAssessment" value="${physiqueExamination.lifeAbilitySelfAssessment }"
                                           dicmeta="CV0401014"/>
                        </ehr:authorize>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td class="td_gray">进餐：使用餐具将饭菜送入口、咀嚼、吞咽等活动</td>
                <td colspan="3">
                    <c:if test="${operate eq 'view'}">
                        <c:if test="${physiqueExamination.eatingAssessment eq 0}">独立完成</c:if>
                        <c:if test="${physiqueExamination.eatingAssessment eq 3}">需要协助</c:if>
                        <c:if test="${physiqueExamination.eatingAssessment eq 5}">完全需要帮助</c:if>
                    </c:if>
                    <c:if test="${operate eq 'edit'}">
                        <ehr:authorize ifAnyGranted="02,03">
                            <input type="radio" name="eatingAssessment" onclick="hmManageReport.calculateAssessment()" value="0"
                                ${physiqueExamination.eatingAssessment eq 0 ? "checked" : ""}/> 独立完成（0）
                            <input type="radio" name="eatingAssessment" onclick="hmManageReport.calculateAssessment()" value="3"
                                ${physiqueExamination.eatingAssessment eq 3 ? "checked" : ""}/> 需要协助（3）
                            <input type="radio" name="eatingAssessment" onclick="hmManageReport.calculateAssessment()" value="5"
                                ${physiqueExamination.eatingAssessment eq 5 ? "checked" : ""}/> 完全需要帮助（5）
                        </ehr:authorize>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td class="td_gray">梳洗：梳头、洗脸、刷牙、剃须、洗澡等活动</td>
                <td colspan="3">
                    <c:if test="${operate eq 'view'}">
                        <c:if test="${physiqueExamination.cleaningAssessment eq 0}">独立完成</c:if>
                        <c:if test="${physiqueExamination.cleaningAssessment eq 1}">洗澡需协助</c:if>
                        <c:if test="${physiqueExamination.cleaningAssessment eq 3}">协助下能完成</c:if>
                        <c:if test="${physiqueExamination.cleaningAssessment eq 7}">完全需要帮助</c:if>
                    </c:if>
                    <c:if test="${operate eq 'edit'}">
                        <ehr:authorize ifAnyGranted="02,03">
                            <input type="radio" name="cleaningAssessment" onclick="hmManageReport.calculateAssessment()" value="0"
                                ${physiqueExamination.cleaningAssessment eq 0 ? "checked" : ""}/> 独立完成（0）
                            <input type="radio" name="cleaningAssessment" onclick="hmManageReport.calculateAssessment()" value="1"
                                ${physiqueExamination.cleaningAssessment eq 1 ? "checked" : ""}/> 洗澡需协助（1）
                            <input type="radio" name="cleaningAssessment" onclick="hmManageReport.calculateAssessment()" value="3"
                                ${physiqueExamination.cleaningAssessment eq 3 ? "checked" : ""}/> 协助下能完成（3）
                            <input type="radio" name="cleaningAssessment" onclick="hmManageReport.calculateAssessment()" value="7"
                                ${physiqueExamination.cleaningAssessment eq 7 ? "checked" : ""}/> 完全需要帮助（7）
                        </ehr:authorize>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td class="td_gray">穿衣：穿衣裤、袜子、鞋子等活动</td>
                <td colspan="3">
                    <c:if test="${operate eq 'view'}">
                        <c:if test="${physiqueExamination.clothingAssessment eq 0}">独立完成</c:if>
                        <c:if test="${physiqueExamination.clothingAssessment eq 3}">需要协助</c:if>
                        <c:if test="${physiqueExamination.clothingAssessment eq 5}">完全需要帮助</c:if>
                    </c:if>
                    <c:if test="${operate eq 'edit'}">
                        <ehr:authorize ifAnyGranted="02,03">
                            <input type="radio" name="clothingAssessment" onclick="hmManageReport.calculateAssessment()" value="0"
                                ${physiqueExamination.clothingAssessment eq 0 ? "checked" : ""}/> 独立完成（0）
                            <input type="radio" name="clothingAssessment" onclick="hmManageReport.calculateAssessment()" value="3"
                                ${physiqueExamination.clothingAssessment eq 3 ? "checked" : ""}/> 需要协助（3）
                            <input type="radio" name="clothingAssessment" onclick="hmManageReport.calculateAssessment()" value="5"
                                ${physiqueExamination.clothingAssessment eq 5 ? "checked" : ""}/> 完全需要帮助（5）
                        </ehr:authorize>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td class="td_gray">如厕：小便、大便等活动及自控</td>
                <td colspan="3">
                    <c:if test="${operate eq 'view'}">
                        <c:if test="${physiqueExamination.defecationAssessment eq 0}">不需协助</c:if>
                        <c:if test="${physiqueExamination.defecationAssessment eq 1}">偶尔失禁</c:if>
                        <c:if test="${physiqueExamination.defecationAssessment eq 5}">经常失禁</c:if>
                        <c:if test="${physiqueExamination.defecationAssessment eq 10}">完全失禁</c:if>
                    </c:if>
                    <c:if test="${operate eq 'edit'}">
                        <ehr:authorize ifAnyGranted="02,03">
                            <input type="radio" name="defecationAssessment" onclick="hmManageReport.calculateAssessment()" value="0"
                                ${physiqueExamination.defecationAssessment eq 0 ? "checked" : ""}/> 不需协助（0）
                            <input type="radio" name="defecationAssessment" onclick="hmManageReport.calculateAssessment()" value="1"
                                ${physiqueExamination.defecationAssessment eq 1 ? "checked" : ""}/> 偶尔失禁（1）
                            <input type="radio" name="defecationAssessment" onclick="hmManageReport.calculateAssessment()" value="5"
                                ${physiqueExamination.defecationAssessment eq 5 ? "checked" : ""}/> 经常失禁（5）
                            <input type="radio" name="defecationAssessment" onclick="hmManageReport.calculateAssessment()" value="10"
                                ${physiqueExamination.defecationAssessment eq 10 ? "checked" : ""}/> 完全失禁（10）
                        </ehr:authorize>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td class="td_gray">活动：站立、室内行走、上下楼梯、户外活动</td>
                <td colspan="3">
                    <c:if test="${operate eq 'view'}">
                        <c:if test="${physiqueExamination.exerciseAssessment eq 0}">独立完成</c:if>
                        <c:if test="${physiqueExamination.exerciseAssessment eq 1}">借助较小外力</c:if>
                        <c:if test="${physiqueExamination.exerciseAssessment eq 5}">借助较大外力</c:if>
                        <c:if test="${physiqueExamination.exerciseAssessment eq 10}">卧床不起</c:if>
                    </c:if>
                    <c:if test="${operate eq 'edit'}">
                        <ehr:authorize ifAnyGranted="02,03">
                            <input type="radio" name="exerciseAssessment" onclick="hmManageReport.calculateAssessment()" value="0"
                                ${physiqueExamination.exerciseAssessment eq 0 ? "checked" : ""}/> 独立完成（0）
                            <input type="radio" name="exerciseAssessment" onclick="hmManageReport.calculateAssessment()" value="1"
                                ${physiqueExamination.exerciseAssessment eq 1 ? "checked" : ""}/> 借助较小外力（1）
                            <input type="radio" name="exerciseAssessment" onclick="hmManageReport.calculateAssessment()" value="5"
                                ${physiqueExamination.exerciseAssessment eq 5 ? "checked" : ""}/> 借助较大外力（5）
                            <input type="radio" name="exerciseAssessment" onclick="hmManageReport.calculateAssessment()" value="10"
                                ${physiqueExamination.exerciseAssessment eq 10 ? "checked" : ""}/> 卧床不起（10）
                        </ehr:authorize>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>老年人认知功能</th>
                <td colspan="4">
                    <c:if test="${operate eq 'view'}">
                        ${physiqueExamination.cognitionScreenResult eq"1" ?"粗筛阴性" :""}

                        ${physiqueExamination.cognitionScreenResult eq"0" ?"粗筛阳性" :""}
                        <c:if test="${physiqueExamination.cognitionScreenResult eq '0'}">
                            <span id="cognitionScreenScore">
                               ，简易智力状态检查，总分${physiqueExamination.cognitionScreenScore}
                            </span>
                        </c:if>
                    </c:if>
                    <c:if test="${operate eq 'edit'}">
                        <ehr:authorize ifAnyGranted="02,03">
                            <input type="radio" name="cognitionScreenResult"
                                   onclick="util.clickHideText(this,'cognitionScreenScore')" ${physiqueExamination.cognitionScreenResult eq"1" ?"checked" :""}
                                   value="1"/>
                            粗筛阴性
                            <input type="radio" id="cognitionScreenResult" name="cognitionScreenResult"
                                   onclick="util.clickShowText(this,'cognitionScreenScore')" ${physiqueExamination.cognitionScreenResult eq"0" ?"checked" :""}
                                   value="0"/>
                            粗筛阳性
                            <span id="cognitionScreenScore"  ${physiqueExamination.cognitionScreenResult ne'0' ?'class="hidediv"' :''}>
                               ，简易智力状态检查，总分<tag:numberInput name="cognitionScreenScore"
                                                            value="${physiqueExamination.cognitionScreenScore}" cssClass="width30"
                                                            reg="{'dependOn':'cognitionScreenResult','required':'true','min':0,'max':9999}"/>
                            </span>
                        </ehr:authorize>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>老年人情感状态</th>
                <td colspan="4">
                    <c:if test="${operate eq 'view'}">
                        ${physiqueExamination.emotionScreenResult eq"1" ?"粗筛阴性" :""}

                        ${physiqueExamination.emotionScreenResult eq "0" ?"粗筛阳性" :""}
                        <c:if test="${physiqueExamination.emotionScreenResult eq '0'}">
                            <span id="depressionScore">
                                ，老年人抑郁评分检查，总分${physiqueExamination.depressionScore}
                            </span>
                        </c:if>
                    </c:if>
                    <c:if test="${operate eq 'edit'}">
                        <ehr:authorize ifAnyGranted="02,03">
                            <input type="radio" name="emotionScreenResult"
                                   onclick="util.clickHideText(this,'depressionScore')" ${physiqueExamination.emotionScreenResult eq"1" ?"checked" :""}
                                   value="1"/>
                            粗筛阴性
                            <input type="radio" id="emotionScreenResult" name="emotionScreenResult"
                                   onclick="util.clickShowText(this,'depressionScore')" ${physiqueExamination.emotionScreenResult eq"0" ?"checked" :""}
                                   value="0"/>
                            粗筛阳性
                        <span id="depressionScore" ${physiqueExamination.emotionScreenResult ne'0' ?'class="hidediv"' :''}>
                            ，老年人抑郁评分检查，总分<tag:numberInput name="depressionScore" value="${physiqueExamination.depressionScore}"
                                                          cssClass="width30"
                                                          reg="{'dependOn':'emotionScreenResult','required':'true','min':0,'max':999}"/>
                        </span>
                        </ehr:authorize>
                    </c:if>
                </td>
            </tr>
            <tr>
				<th>运动功能</th>
                <td colspan="4">${physiqueExamination.activeFunction}</td>
            </tr>
            <tr>
                <th rowspan="13">生活方式</th>
                <th rowspan="3">体育锻炼</th>
                <td class="td_gray">锻炼频率</td>
                <td colspan="3">
                	${physiqueExamination.physicalTrainingFreq}
                </td>
            </tr>
            <tr>
                <td class="td_gray">每次锻炼时间</td>
                <td>
                    ${physiqueExamination.trainingMin}分钟
                </td>
                <td class="td_gray">坚持锻炼时间</td>
                <td>
                    ${physiqueExamination.trainingTotaltime}年
                </td>
            </tr>
            <tr>
                <td class="td_gray">锻炼方式</td>
                <td colspan="3"><ehr:dic dicmeta="FS990004" code="${physiqueExamination.trainingWay}"/></td>
            </tr>
            <tr>
                <th>饮食习惯</th>
                <td colspan="4">
					${physiqueExamination.dietaryHabit}
                </td>
            </tr>
            <tr>
                <th rowspan="3">吸烟情况</th>
                <td  class="td_gray">吸烟状况</td>
                <td colspan="3">
                    ${physiqueExamination.smokeDesc}
                </td>
            </tr>
            <tr>
                <td class="td_gray">日吸烟量</td>
                <td colspan="3">平均
                    ${physiqueExamination.dailySmoke}支
                </td>
            </tr>
            <tr>
                <td class="td_gray">开始吸烟年龄</td>
                <td>${physiqueExamination.smokeAge}岁</td>
                <td class="td_gray">戒烟年龄</td>
                <td>${physiqueExamination.quitSmokeAge}岁</td>
            </tr>
            <tr>
                <th rowspan="5">饮酒情况</th>
                <td class="td_gray">饮酒频率</td>
                <td colspan="3">
                    ${physiqueExamination.drinkDesc}
                </td>
            </tr>
            <tr>
                <td class="td_gray">日饮酒量</td>
                <td colspan="3">平均
                    ${physiqueExamination.dailyDrink}两
                </td>
            </tr>
            <tr>
                <td class="td_gray">是否戒酒</td>
                <td>
                    <ehr:dic dicmeta="FS10214" code="${physiqueExamination.nodrink}"/>
                </td>
                <td class="td_gray">戒酒年龄</td>
                <td>${physiqueExamination.nodrinkAge}岁</td>

            </tr>
            <tr>
                <td class="td_gray">开始饮酒年龄</td>
                <td>${physiqueExamination.drinkAge}岁</td>
                <td class="td_gray">近一年内是否曾醉酒</td>
                <td>
                    <ehr:dic dicmeta="FS10009" code="${physiqueExamination.drunk}"/>
                </td>
            </tr>
            <tr>
                <td class="td_gray">饮酒种类</td>
                <td colspan="3">
                    <ehr:dic dicmeta="CV0300105" code="${physiqueExamination.drinkSpirit}"/>
                    <ehr:dic dicmeta="CV0300105" code="${physiqueExamination.drinkBeer}"/>
                    <ehr:dic dicmeta="CV0300105" code="${physiqueExamination.drinkRedWine}"/>
                    <ehr:dic dicmeta="CV0300105" code="${physiqueExamination.drinkYellowWine}"/>
                    <ehr:dic dicmeta="CV0300105" code="${physiqueExamination.drinkOther}"/>
                    <c:out value="${physiqueExamination.drinkOtherDesc}"/>
                </td>
            </tr>
            <tr>
                <th>职业病危害因素接触史</th>
                <td colspan="4">
                    <label>
                        ${physiqueExamination.occupationExposureFlag eq"0" ||physiqueExamination.occupationExposureFlag eq null ?"<span>无</span>" :""}
                    </label>
                    <label>
                        ${physiqueExamination.occupationExposureFlag eq"1" ?"<span>有</span>" :""}
                    </label>
                    <c:if test="${physiqueExamination.occupationExposureFlag eq '1'}">
                         <span id="ttb2">
                                (工种${physiqueExamination.riskOccupationDesc}
                                          从业时间
                                          ${physiqueExamination.riskOccupationTime}年)
                                <table>
                                    <tr>
                                        <td width="10%">粉尘</td>
                                        <td width="30%">${physiqueExamination.dustTypeDesc}</td>
                                        <td width="10%">防护措施</td>
                                        <td width="50%">
                                                ${physiqueExamination.dustProtectionFlag eq"0" ?"无" :""}
                                                ${physiqueExamination.dustProtectionFlag eq"1" ?"有" :""}
                                                ${physiqueExamination.dustProtectionDesc}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>放射物质</td>
                                        <td>${physiqueExamination.radiationTypeDesc}</td>
                                        <td>防护措施</td>
                                        <td>
                                                ${physiqueExamination.radiationProtectionFlag eq"0" ?"无" :""}
                                                ${physiqueExamination.radiationProtectionFlag eq"1" ?"有" :""}
                                                ${physiqueExamination.radiationProtectionDesc}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>物理因素</td>
                                        <td>${physiqueExamination.physicsTypeDesc}</td>
                                        <td>防护措施</td>
                                        <td>
                                                ${physiqueExamination.physicsProtectionFlag eq"0" ?"无" :""}
                                                ${physiqueExamination.physicsProtectionFlag eq"1" ?"有" :""}
                                                ${physiqueExamination.physicsProtectionDesc}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>化学因素</td>
                                        <td>${physiqueExamination.chemistryTypeDesc}</td>
                                        <td>防护措施</td>
                                        <td>
                                                ${physiqueExamination.chemistryProtectionFlag eq"0" ?"无" :""}
                                                ${physiqueExamination.chemistryProtectionFlag eq"1" ?"有" :""}
                                                ${physiqueExamination.chemistryProtectionDesc}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>其他</td>
                                        <td>${physiqueExamination.otherTypeDesc}</td>
                                        <td>防护措施</td>
                                        <td>
                                                ${physiqueExamination.otherProtectionFlag eq"0" ?"无" :""}
                                                ${physiqueExamination.otherProtectionFlag eq"1" ?"有" :""}
                                                ${physiqueExamination.otherProtectionDesc}
                                        </td>
                                    </tr>
                                </table>
                         </span>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th rowspan="3">脏器功能</th>
                <th>口腔</th>
                <td colspan="4">
                    <table>
                        <tr>
                            <td colspan="2">口唇&nbsp;
                                <ehr:dic dicmeta="CV0410007" code="${physiqueExamination.lipAppearanceCehckResult}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>齿列&nbsp;
                                ${physiqueExamination.dentitionAnomalyFlag eq "0" ?"正常" :""}
                                ${physiqueExamination.dentitionAnomalyFlag eq "1" ?"异常" :""}
                                ${physiqueExamination.dentitionAnomalyFlag eq "9" ? physiqueExamination.dentitionDesc :""}
                            </td>
                            <td id="ttb7" style="width: 60%;">
                                ${physiqueExamination.missingToothFlg eq "1" ? "缺齿" : ""}
                                <c:if test="${not empty physiqueExamination.missingToothFlg}">
                                    <table style="width: 20%;">
                                        <tr>
                                            <td>${physiqueExamination.missingToothNumberUpl}</td>
                                            <td>${physiqueExamination.missingToothNumberUpr}</td>
                                        </tr>
                                        <tr>
                                            <td>${physiqueExamination.missingToothNumberDownl}</td>
                                            <td>${physiqueExamination.missingToothNumberDownr}</td>
                                        </tr>
                                    </table>
                                </c:if>
                                ${physiqueExamination.decayedToothFlg eq "1"?"龋齿":""}
                                <c:if test="${not empty physiqueExamination.decayedToothFlg}">
                                    <table style="width: 20%;">
                                        <tr>
                                            <td>${physiqueExamination.decayedToothNumberUpl}</td>
                                            <td>${physiqueExamination.decayedToothNumberUpr}</td>
                                        </tr>
                                        <tr>
                                            <td>${physiqueExamination.decayedToothNumberDownl}</td>
                                            <td>${physiqueExamination.decayedToothNumberDownr}</td>
                                        </tr>
                                    </table>
                                </c:if>
                                ${physiqueExamination.dentureToothFlg eq "1"?"义齿":""}
                                <c:if test="${not empty physiqueExamination.dentureToothFlg}">
                                    <table style="width: 20%;">
                                        <tr>
                                            <td>${physiqueExamination.dentureToothNumberUpl}</td>
                                            <td>${physiqueExamination.dentureToothNumberUpr}</td>
                                        </tr>
                                        <tr>
                                            <td>${physiqueExamination.dentureToothNumberDownl}</td>
                                            <td>${physiqueExamination.dentureToothNumberDownr}</td>
                                        </tr>
                                    </table>
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">咽部&nbsp;
                                <c:if test="${physiqueExamination.throatCheckResult eq '9'}">${physiqueExamination.throatAnomalyDesc}</c:if>
                                <c:if test="${physiqueExamination.throatCheckResult ne '9'}"><ehr:dic dicmeta="FS10183" code="${physiqueExamination.pharynxCheckResult}"/></c:if>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <th>视力</th>
                <td colspan="4">
                    左眼${physiqueExamination.lNakedEye}
                    右眼${physiqueExamination.rNakedEye}
                    （矫正视力：左眼${physiqueExamination.lEyecorrection}
                    右眼${physiqueExamination.rEyecorrection})
                </td>
            </tr>
            <tr>
                <th>听力</th>
                <td colspan="4">
                    <ehr:dic dicmeta="FS10170" code="${physiqueExamination.hearDetectResult}"/>
                </td>
            </tr>
            <%--<tr>--%>
                <%--<th>运动功能状态</th>--%>
                <%--<td colspan="4">--%>
                    <%--<ehr:dic dicmeta="FS10212" code="${physiqueExamination.motorFuncState}"/>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <tr>
                <th rowspan=${physiqueExamination.lungsAnomalySound eq '9' ? 11 : 11}>查体</th>
                <th>眼底</th>
                <td colspan="4">
                    ${physiqueExamination.fundusOculiAnomalyFlag eq"0" ?"正常":""}
                    ${physiqueExamination.fundusOculiAnomalyFlag eq"1" ?"异常":""}
                    ${physiqueExamination.fundusOculiAnomalyDesc}
                </td>
            </tr>
            <tr>
                <th>皮肤</th>
                <td colspan="4">
                    <%--${physiqueExamination.skinCheckResult eq"1" ?"正常":""}--%>
                    <%--${physiqueExamination.skinCheckResult eq"2" ?"潮红":""}--%>
                    <%--${physiqueExamination.skinCheckResult eq"3" ?"苍白":""}--%>
                    <%--${physiqueExamination.skinCheckResult eq"4" ?"发绀":""}--%>
                    <%--${physiqueExamination.skinCheckResult eq"5" ?"黄染":""}--%>
                    <%--${physiqueExamination.skinCheckResult eq"6" ?"色素沉着":""}--%>
                    <%--${physiqueExamination.skinCheckResult eq"7" ?"其他":""}--%>
                    <%--${physiqueExamination.skinCheckDesc}--%>
                    <c:choose>
                        <c:when test="${physiqueExamination.skinCheckResult eq '1'}">
                            正常
                        </c:when>
                        <c:otherwise>
                            ${physiqueExamination.skinCheckDesc}
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>巩膜</th>
                <td colspan="4">
                    ${physiqueExamination.scleraCheckResult eq"1" ?"正常":""}
                    ${physiqueExamination.scleraCheckResult eq"2" ?"黄染":""}
                    ${physiqueExamination.scleraCheckResult eq"3" ?"充血":""}
                    ${physiqueExamination.scleraCheckResult eq"4" ?"其他":""}
                    ${physiqueExamination.scleraCheckDesc}
                </td>
            </tr>
            <tr>
                <th>淋巴结</th>
                <td colspan="4">
                    ${physiqueExamination.lymphNodeCheckResult eq"1" ?"未触及 ":""}
                    ${physiqueExamination.lymphNodeCheckResult eq"2" ?"锁骨上 ":""}
                    ${physiqueExamination.lymphNodeCheckResult eq"3" ?"腋窝  ":""}
                    ${physiqueExamination.lymphNodeCheckResult eq"4" ?"其他  ":""}
                    ${physiqueExamination.lymphNodeCheckDesc}
                </td>
            </tr>
            <c:if test="${physiqueExamination.lungsAnomalySound eq '9'}">
                <tr>
                    <th rowspan="3">肺</th>
                    <td colspan="4">${physiqueExamination.lungsAnomalyDesc}</td>
                </tr>
                <tr>
                </tr>
                <tr>
                </tr>
            </c:if>
            <c:if test="${physiqueExamination.lungsAnomalySound ne '9'}">
                <tr>
                    <th rowspan="3">肺</th>
                    <td colspan="4">桶状胸：
                        ${physiqueExamination.barrelChest eq"1" ?"是":""}
                        ${physiqueExamination.barrelChest eq"0" ?"否":""}
                    </td>
                <tr>
                    <td colspan="4">呼吸音：
                        ${physiqueExamination.lungsAnomalySound eq"1" ?"正常":""}
                        ${physiqueExamination.lungsAnomalySound eq"0" ?"异常":""}
                        <c:if test="${physiqueExamination.lungsAnomalySound eq '0'}">
                            ${physiqueExamination.lungsAnomalyDesc}
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td colspan="4"> 啰音：
                        ${physiqueExamination.lungsRaleFlag eq"1" ?"无   ":""}
                        ${physiqueExamination.lungsRaleFlag eq"2" ?"干啰音 ":""}
                        ${physiqueExamination.lungsRaleFlag eq"3" ?"湿啰音 ":""}
                        ${physiqueExamination.lungsRaleFlag eq"4" ?"其它  ":""}
                        ${physiqueExamination.lungsRaleDesc}
                    </td>
                </tr>
            </c:if>
            <c:if test="${physiqueExamination.heartMurmurFlag eq '9'}">
                <tr>
                    <th>心脏</th>
                    <td colspan="4">${physiqueExamination.heartMurmurDesc}</td>
                </tr>
            </c:if>
            <c:if test="${physiqueExamination.heartMurmurFlag ne '9'}">
                <tr>
                    <th>心脏</th>
                    <td colspan="4">
                        心率： ${physiqueExamination.heartRate}次/分钟
                        <br>
                        心律 ：<ehr:dic dicmeta="FS10176" code="${physiqueExamination.cardioverter}"/>
                        <br>
                        杂音：
                        ${physiqueExamination.heartMurmurFlag eq"0" || physiqueExamination.heartMurmurFlag eq null ?"无":""}
                        ${physiqueExamination.heartMurmurFlag eq"1" ?"有":""}
                        <c:if test="${physiqueExamination.heartMurmurFlag eq '1'}">
                            <span id="heartMurmurDesc"> ${physiqueExamination.heartMurmurDesc}次/分钟</span>
                        </c:if>
                    </td>
                </tr>
            </c:if>
            <%--<c:if test="${physiqueExamination.abdominalTendernessFlag eq '9'}">--%>
                <tr>
                    <th>腹部</th>
                    <td colspan="4">${physiqueExamination.abdominalTendernessDesc}</td>
                </tr>
            <%--</c:if>--%>
            <%--<c:if test="${physiqueExamination.abdominalTendernessFlag ne '9'}">--%>
                <%--<tr>--%>
                    <%--<th rowspan="5">腹部</th>--%>
                    <%--<td colspan="4">--%>
                        <%--压痛：--%>
                        <%--${physiqueExamination.abdominalTendernessFlag eq"0" ||physiqueExamination.abdominalTendernessFlag eq null ?"无":""}--%>
                        <%--${physiqueExamination.abdominalTendernessFlag eq "1" ?"有":""}--%>
                        <%--${physiqueExamination.abdominalTendernessDesc}--%>
                        <%--<c:choose>--%>
                            <%--<c:when test="${physiqueExamination.abdominalTendernessFlag eq '9'}">--%>
                                <%--${physiqueExamination.abdominalTendernessDesc}--%>
                            <%--</c:when>--%>
                        <%--</c:choose>--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td colspan="4">包块：--%>
                        <%--${physiqueExamination.abdominalMassFlag eq "0" || physiqueExamination.abdominalMassFlag eq null ?"无":""}--%>
                        <%--${physiqueExamination.abdominalMassFlag eq"1" ?"有":""}--%>
                        <%--${physiqueExamination.abdominalMassDesc}--%>
                        <%--<c:choose>--%>
                            <%--<c:when test="${physiqueExamination.abdominalMassFlag eq '9'}">--%>
                                <%--${physiqueExamination.abdominalMassDesc}--%>
                            <%--</c:when>--%>
                        <%--</c:choose>--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td colspan="4">肝大：--%>
                        <%--${physiqueExamination.liverFlag eq "0" || physiqueExamination.liverFlag eq null ?"无":""}--%>
                        <%--${physiqueExamination.liverFlag eq"1" ?"有":""}--%>
                        <%--${physiqueExamination.liverDesc}--%>
                        <%--<c:choose>--%>
                            <%--<c:when test="${physiqueExamination.liverFlag eq '9'}">--%>
                                <%--${physiqueExamination.liverDesc}--%>
                            <%--</c:when>--%>
                        <%--</c:choose>--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td colspan="4">脾大：--%>
                        <%--${physiqueExamination.splenomegalyFlag eq"0" || physiqueExamination.splenomegalyFlag eq null ?"无":""}--%>
                        <%--${physiqueExamination.splenomegalyFlag eq"1" ?"有":""}--%>
                        <%--${physiqueExamination.splenomegalyDesc}--%>
                        <%--<c:choose>--%>
                            <%--<c:when test="${physiqueExamination.splenomegalyFlag eq '9'}">--%>
                                <%--${physiqueExamination.splenomegalyDesc}--%>
                            <%--</c:when>--%>
                        <%--</c:choose>--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td colspan="4">移动性浊音：--%>
                        <%--${physiqueExamination.abdominalVoicedFlag eq"0" || physiqueExamination.abdominalVoicedFlag eq null ?"无":""}--%>
                        <%--${physiqueExamination.abdominalVoicedFlag eq"1" ?"有":""}--%>
                        <%--${physiqueExamination.abdominalVoicedDesc}--%>
                        <%--<c:choose>--%>
                            <%--<c:when test="${physiqueExamination.abdominalVoicedFlag eq '9'}">--%>
                                <%--${physiqueExamination.abdominalVoicedDesc}--%>
                            <%--</c:when>--%>
                        <%--</c:choose>--%>
                    <%--</td>--%>
                <%--</tr>--%>
            <%--</c:if>--%>
            <tr>
                <th>下肢水肿</th>
                <td colspan="4">
                    <ehr:dic dicmeta="CV0410014" code="${physiqueExamination.legsEdemaCheckResult}"/>
                </td>
            </tr>
            <tr>
                <th>足背动脉搏动</th>
                <td colspan="4">
                    <ehr:dic dicmeta="CV0410015" code="${physiqueExamination.arteriopalmus}"/>
                </td>
            </tr>
            <%-- <tr>
                <th>肛门指诊</th>
                <td colspan="4">
                    <ehr:dic dicmeta="CV0410013" code="${physiqueExamination.dreCheckResultType}"/>
                    ${physiqueExamination.dreCheckResultDesc}
                </td>
            </tr>
            <tr>
                <th>乳腺</th>
                <td colspan="4">
                    ${physiqueExamination.breastAnomalyFlag eq"0" ?"未见异常 ":""}
                    ${physiqueExamination.breastAnomalyFlag eq"1" ?"有异常  ":""}

                    <c:if test="${physiqueExamination.breastAnomalyFlag eq '1'}">
                    <span id="ttb8">
                        ${physiqueExamination.breastResection eq"1" ?        "乳房切除  ": ""}
                        ${physiqueExamination.breastAnomalyLactation eq"1" ? "异常泌乳  ": ""}
                        ${physiqueExamination.breastMass eq"1" ?             "乳腺包块  ": ""}
                        ${physiqueExamination.breastOther eq"1" ?            "其它     " : ""}
                        ${physiqueExamination.breastOtherDesc}
                    </span>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th rowspan="5">妇科</th>
                <td class="td_gray">外阴</td>
                <td colspan="3">
                    ${physiqueExamination.vulvaAnomalyFlag eq"0" ?"未见异常 ":""}
                    ${physiqueExamination.vulvaAnomalyFlag eq"1" ?"有异常  ":""}
                    ${physiqueExamination.vulvaAnomalyDesc}
                </td>
            </tr>
            <tr>
                <td class="td_gray">阴道</td>
                <td colspan="3">
                    ${physiqueExamination.vaginaAnomalyFlag eq"0" ?"未见异常   ":""}
                    ${physiqueExamination.vaginaAnomalyFlag eq"1" ?"有异常    ":""}
                    ${physiqueExamination.vaginaAnomalyDesc}
                </td>
            </tr>
            <tr>
                <td class="td_gray">宫颈</td>
                <td colspan="3">
                    ${physiqueExamination.cervicalAnomalyFlag eq"0" ?"未见异常  ":""}
                    ${physiqueExamination.cervicalAnomalyFlag eq"1" ?"有异常   ":""}
                    ${physiqueExamination.cervicalAnomalyDesc}
                </td>
            </tr>
            <tr>
                <td class="td_gray">宫体</td>
                <td colspan="3">
                    ${physiqueExamination.corpusAnomalyFlag eq"0" ?"未见异常 ":""}
                    ${physiqueExamination.corpusAnomalyFlag eq"1" ?"有异常  ":""}
                    ${physiqueExamination.corpusAnomalyDesc}
                </td>
            </tr>
            <tr>
                <td class="td_gray">附件</td>
                <td colspan="3">
                    ${physiqueExamination.accessoriesAnomalyFlag eq"0" ?"未见异常   ":""}
                    ${physiqueExamination.accessoriesAnomalyFlag eq"1" ?"有异常    ":""}
                    ${physiqueExamination.accessoriesAnomalyDesc}
                </td>
            </tr>
            <tr>
                <th>其他</th>
                <td colspan="4">
                    ${physiqueExamination.otherCheckResult}
                </td>
            </tr> --%>
            <tr>
                <th rowspan="14">辅助检查</th>
                <th>血常规</th>
                <td colspan="4">
                    血红蛋白${physiqueExamination.hemoglobinValue}g/L
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    白细胞${physiqueExamination.leukocyteCount}×10<sup>9</sup>/L
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    血小板${physiqueExamination.plateletCount}×10<sup>9</sup>/L
                    <br>
                    其它${physiqueExamination.bloodRoutineOtherDesc}
                </td>
            </tr>
            <tr>
                <th rowspan="2">尿常规</th>
                <td colspan="4">
                    尿蛋白${physiqueExamination.urineProQuantitativeValue}
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    尿糖${physiqueExamination.urineSugQuantitativeValue}
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    尿酮体${physiqueExamination.ketQuantitativeValue}
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    尿潜血${physiqueExamination.eryQuantitativeValue}
                    <br>
                    其它${physiqueExamination.urineRoutinesOtherDesc}
                </td>
            </tr>
            <tr>
                <td class="td_gray">空腹血糖</td>
                <td colspan="4">
                    ${physiqueExamination.fpgMmol}mmol/L
                    或
                    ${physiqueExamination.fpgMg}mg/dL
                </td>
            </tr>
            <tr>
                <th>心电图</th>
                <td colspan="4">
                    ${physiqueExamination.ecgAnomalyFlag eq"0" ?"正常":""}
                    ${physiqueExamination.ecgAnomalyDesc}
                </td>
            </tr>
            <tr>
                <th>尿微量白蛋白</th>
                <td colspan="4">
                    ${physiqueExamination.urineMicroTongAlbumin}mg/dL
                </td>
            </tr>
            <tr>
                <th>大便潜血</th>
                <td colspan="4">
                    <ehr:dic dicmeta="FS10058" code="${physiqueExamination.fecalOccultBlood}"/>
                </td>
            </tr>
            <tr>
                <th>糖化血红蛋白</th>
                <td colspan="4">
                    ${physiqueExamination.hgb}%
                </td>
            </tr>
            <tr>
                <th>乙型肝炎表面抗原</th>
                <td colspan="4">
                    <ehr:dic dicmeta="FS10058" code="${physiqueExamination.hbsagDetectResult}"/>
                </td>
            </tr>
            <tr>
                <th>肝功能</th>
                <td colspan="4">
                    血清谷丙转氨酶 ${physiqueExamination.serumGptValue}U/L
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    血清谷草转氨酶 ${physiqueExamination.serumAstValue}U/L
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    白蛋白浓度 ${physiqueExamination.albuminConcentration}g/L
                    <br>
                    总胆红素 ${physiqueExamination.totalBilirubin}μmol/L
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    结合胆红素 ${physiqueExamination.conjugatedBilirubin}μmol/L
                </td>
            </tr>
            <tr>
                <th>肾功能</th>
                <td colspan="4">
                    血清肌酐 ${physiqueExamination.creatinine} μmol/L
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    血尿素氮${physiqueExamination.bloodUreaNitrogenValue}μmol/L
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                   尿素（URIC）${physiqueExamination.urea}
                    <br>
                    血钾浓度${physiqueExamination.potassiumConcentration}μmol/L
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    血钠浓度${physiqueExamination.sodiumConcentration}μmol/L
                </td>
            </tr>
            <tr>
                <th>血脂</th>
                <td colspan="4">
                    总胆固醇 ${physiqueExamination.tc}mmol/L
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    甘油三酯 ${physiqueExamination.triglycerideValue}mmol/L
                    <br>
                    血清低密度脂蛋白胆固醇 ${physiqueExamination.ldlcDetectValue}mmol/L
                    <br>
                    血清高密度脂蛋白胆固醇 ${physiqueExamination.hdlcDetectValue}mmol/L
                </td>
            </tr>
            <tr>
                <th>胸部X线片</th>
                <td colspan="4">
                    ${physiqueExamination.chestXAnomalyfFlag eq"0" ?"正常":""}
                    ${physiqueExamination.chestXAnomalyfFlag eq"1" ?"异常":""}
                    ${physiqueExamination.chestXAnomalyfDesc}
                </td>
            </tr>
            <tr>
                <th>B超</th>
                <td colspan="4">
                    ${physiqueExamination.bmodeAnomalyfFlag eq"0" ?"正常":""}
                    ${physiqueExamination.bmodeAnomalyfFlag eq"1" ?"异常":""}
                    ${physiqueExamination.bmodeAnomalyfDesc}
                </td>
            </tr>
            <%-- <tr>
                <th>宫颈涂片</th>
                <td colspan="4">
                    ${physiqueExamination.cervicalSmearAnomalyfFlag eq"0" ?"正常":""}
                    ${physiqueExamination.cervicalSmearAnomalyfFlag eq"1" ?"异常":""}
                    ${physiqueExamination.cervicalSmearAnomalyfDesc}
                </td>
            </tr> --%>
            <tr>
                <th>其他</th>
                <td colspan="4">
                    ${physiqueExamination.otherAuxiliaryExamination}
                </td>
            </tr>
            <tr>
            	<th>目前主要用药情况</th>
            	<td colspan="5">${physiqueExamination.medicineDesc}</td>
            </tr>
            <tr>
                <th rowspan="9">中医体质辨识</th>
                <th>平和质</th>
                <td colspan="4">
                    <ehr:dic dicmeta="FS10186" code="${physiqueExamination.tcmPeacefulQuality}"/>
                </td>
            </tr>
            <tr>
                <th>气虚质</th>
                <td colspan="4">
                    <ehr:dic dicmeta="FS10186" code="${physiqueExamination.tcmQiQuality}"/>
                </td>
            </tr>
            <tr>
                <th>阳虚质</th>
                <td colspan="4">
                    <ehr:dic dicmeta="FS10186" code="${physiqueExamination.tcmYangQuality}"/>
                </td>
            </tr>
            <tr>
                <th>阴虚质</th>
                <td colspan="4">
                    <ehr:dic dicmeta="FS10186" code="${physiqueExamination.tcmYinDeficiency}"/>
                </td>
            </tr>
            <tr>
                <th>痰湿质</th>
                <td colspan="4">
                    <ehr:dic dicmeta="FS10186" code="${physiqueExamination.tcmPhlegmWetness}"/>
                </td>
            </tr>
            <tr>
                <th>湿热质</th>
                <td colspan="4">
                    <ehr:dic dicmeta="FS10186" code="${physiqueExamination.tcmHeatMedium}"/>
                </td>
            </tr>
            <tr>
                <th>血瘀质</th>
                <td colspan="4">
                    <ehr:dic dicmeta="FS10186" code="${physiqueExamination.tcmBloodQuality}"/>
                </td>
            </tr>
            <tr>
                <th>气郁质</th>
                <td colspan="4">
                    <ehr:dic dicmeta="FS10186" code="${physiqueExamination.tcmQiStagnation}"/>
                </td>
            </tr>
            <tr>
                <th>特秉质</th>
                <td colspan="4">
                    <ehr:dic dicmeta="FS10186" code="${physiqueExamination.tcmSpecialQuality}"/>
                </td>
            </tr>
            <tr>
                <th rowspan="5">现存主要健康问题</th>
                <th>脑血管疾病</th>
                <td colspan="4">
                    ${physiqueExamination.cvascularFlag eq"0" ?"未发现":""}
                    ${physiqueExamination.cvascularFlag eq"1" ?"已发现":""}
                    <c:if test="${physiqueExamination.cvascularFlag eq '1'}">
                        <span id="ttb9">
                        ${physiqueExamination.cvascularHemorrhageStroke eq '1' ?     '缺血性卒中         ':''}
                        ${physiqueExamination.cvascularHemorrhage eq '1' ?           '脑出血           ':''}
                        ${physiqueExamination.cvascularSah eq '1' ?                  '蛛网膜下腔出血       ':''}
                        ${physiqueExamination.covascularTransientIschemic eq '1' ?   '短暂性脑缺血发作      ':''}
                        ${physiqueExamination.covascularOther eq '1' ?               '其它            ':''}
                        ${physiqueExamination.cvascularOtherDesc}
                        </span>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>肾脏疾病</th>
                <td colspan="4">
                    ${physiqueExamination.kidneyDiseaseFlag eq"0" ?"未发现":""}
                    ${physiqueExamination.kidneyDiseaseFlag eq"1" ?"已发现":""}
                    <c:if test="${physiqueExamination.kidneyDiseaseFlag eq '1'}">
                    <span id="ttb10">
                        ${physiqueExamination.kidneyDiabeticNephropathy eq '1' ? '糖尿病肾病   ':''}
                        ${physiqueExamination.kidneyRenalFailure eq '1' ?        '肾功能衰竭   ':''}
                        ${physiqueExamination.kidneyAcuteNephritis eq '1' ?      '急性肾炎    ':''}
                        ${physiqueExamination.kidneyChronicNephritis eq '1' ?    '慢性肾炎    ':''}
                        ${physiqueExamination.kidneyOther eq '1' ?               '其它      ':''}
                        ${physiqueExamination.kidneyOtherDesc}
                    </span>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>心脏疾病</th>
                <td colspan="4">
                    ${physiqueExamination.heartDiseaseFlag eq"0" ?"未发现 ":""}
                    ${physiqueExamination.heartDiseaseFlag eq"1" ?"已发现 ":""}
                    <c:if test="${physiqueExamination.heartDiseaseFlag eq '1'}">
                    <span id="ttb11">
                        ${physiqueExamination.heartMiocardialInfarction eq '1' ? '心肌梗死         ':''}
                        ${physiqueExamination.heartAnginaPectoris eq '1' ?       '心绞痛          ':''}
                        ${physiqueExamination.heartCoronary eq '1' ?             '冠状动脉血运重建     ':''}
                        ${physiqueExamination.heartCongestiveHeart eq '1' ?      '充血性心力衰竭        ':''}
                        ${physiqueExamination.heartPrecordialPain eq '1' ?       '心前区疼痛        ':''}
                        ${physiqueExamination.heartOther eq '1' ?                '其它           ':''}
                        ${physiqueExamination.heartOtherDesc}
                     </span>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>血管疾病</th>
                <td colspan="4">
                    ${physiqueExamination.arteryDiseaseFlag eq"0" ?"未发现":""}
                    ${physiqueExamination.arteryDiseaseFlag eq"1" ?"已发现":""}
                    <c:if test="${physiqueExamination.arteryDiseaseFlag eq '1'}">
                     <span id="ttb12">
                        ${physiqueExamination.arteryDissectingAneurysm eq '1' ?  '夹层动脉瘤      ':''}
                        ${physiqueExamination.arteryPaod eq '1' ?                '动脉闭塞性疾病    ':''}
                        ${physiqueExamination.arteryOther eq '1' ?               '其它         ':''}
                        ${physiqueExamination.arteryOtherDesc}
                     </span>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>眼部疾病</th>
                <td colspan="4">
                    ${physiqueExamination.eyeDiseasesFlag eq"0" ?"未发现":""}
                    ${physiqueExamination.eyeDiseasesFlag eq"1" ?"已发现":""}
                    <c:if test="${physiqueExamination.eyeDiseasesFlag eq '1'}">
                     <span id="ttb13">
                        ${physiqueExamination.eyeRetinalOozing eq '1' ?  '视网膜出血或者渗出       ':''}
                        ${physiqueExamination.eyeOpticPapilla eq '1' ?   '视乳头水肿           ':''}
                        ${physiqueExamination.eyeCataract eq '1' ?       '白内障             ':''}
                        ${physiqueExamination.eyeOther eq '1' ?          '其它              ':''}
                        ${physiqueExamination.eyeOtherDesc}
                    </span>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th colspan="2">结论</th>
                <td colspan="4">${healthExamination.examinationResult}</td>
            </tr>
            <tr>
                <th colspan="2">建议</th>
                <td colspan="4">${healthExamination.suggestion}</td>
            </tr>
            <tr>
                <th colspan="2">健康评价</th>
                <td colspan="4">
                    <c:if test="${operate eq 'view'}">
                        ${physiqueExamination.healthEvaluateAnomalyFlag eq '0'?'体检无异常（结合临床表现综合评估）':''}
                        ${physiqueExamination.healthEvaluateAnomalyFlag eq '1'?'有异常    ':''}
                        <br/>
                        <c:if test="${physiqueExamination.healthEvaluateAnomalyFlag eq 1 && not empty healthEvaluateAnomalyList}">
                            <c:forEach items="${healthEvaluateAnomalyList}" var="healEvaluateAnomaly" varStatus="status">
                                异常 ${healEvaluateAnomaly.healthEvaluateAnomalyDesc}<br>
                            </c:forEach>
                        </c:if>
                    </c:if>
                    <c:if test="${operate eq 'edit'}">
                        <ehr:authorize ifAnyGranted="03">${healthEvaluateAnomalyFlg}
                            <input type="radio"
                                   onclick="util.clickHideTable(this,'ttb30')"  ${physiqueExamination.healthEvaluateAnomalyFlag eq '0'?'checked ="checked"':''}
                                   name="healthEvaluateAnomalyFlag" value="0"> 体检无异常（结合临床表现综合评估）
                            <input type="radio" id="healthEvaluateAnomalyFlg" ${physiqueExamination.healthEvaluateAnomalyFlag eq '1'?'checked ="checked"':''}
                                   onclick="util.clickShowTable(this,'ttb30')"
                                   name="healthEvaluateAnomalyFlag" value="1"> 有异常
                            <br/>
                            <span class="hidediv" id="ttb30">
                                  异常 <input id="anomalyDesc0" name="anomalyDesc0" value="${healthEvaluateAnomalyList[0].healthEvaluateAnomalyDesc}" reg='{"dependOn":"healthEvaluateAnomalyFlg","required":true,"maxlength":"33"}' style="width: 400px; border: none; border-bottom: 1px solid #D7D7D7;"> <br>
                                  异常 <input id="anomalyDesc1" name="anomalyDesc1" value="${healthEvaluateAnomalyList[1].healthEvaluateAnomalyDesc}" reg='{"maxlength":"33"}' style="width: 400px; border: none; border-bottom: 1px solid #D7D7D7;"> <br>
                                  异常 <input id="anomalyDesc2" name="anomalyDesc2" value="${healthEvaluateAnomalyList[2].healthEvaluateAnomalyDesc}" reg='{"maxlength":"33"}' style="width: 400px; border: none; border-bottom: 1px solid #D7D7D7;"> <br>
                                  异常 <input id="anomalyDesc3" name="anomalyDesc3" value="${healthEvaluateAnomalyList[3].healthEvaluateAnomalyDesc}" reg='{"maxlength":"33"}' style="width: 400px; border: none; border-bottom: 1px solid #D7D7D7;">
                            </span>
                        </ehr:authorize>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th colspan="2">健康指导</th>
                <td colspan="2">
                    <c:if test="${operate eq 'view'}">
                        <label>
                                ${physiqueExamination.guideRegularFollowup eq"1" ?"<span>定期随访</span>":""}
                        </label>
                        <br>
                        <label>
                                ${physiqueExamination.guideIntoChronicDisease eq"1" ?"<span>纳入慢性病患者健康管理</span>":""}
                        </label>
                        <br>
                        <label>
                                ${physiqueExamination.guideSuggestionReview eq"1" ?"<span>建议复查</span>":""}
                        </label>
                        <br>
                        <label>
                                ${physiqueExamination.guideSuggestionReferral eq"1" ?"<span>建议转诊</span>":""}
                        </label>
                    </c:if>
                    <c:if test="${operate eq 'edit'}">
                        <ehr:authorize ifAnyGranted="03">
                            <label>
                                <input type="checkbox"
                                       name="guideRegularFollowup" ${physiqueExamination.guideRegularFollowup eq"1" ?"checked":""}
                                       value="1"/>
                                <span>定期随访</span>
                            </label>
                            <br>
                            <label>
                                <input type="checkbox"
                                       name="guideIntoChronicDisease" ${physiqueExamination.guideIntoChronicDisease eq"1" ?"checked":""}
                                       value="1"/>
                                <span>纳入慢性病患者健康管理</span>
                            </label>
                            <br>
                            <label>
                                <input type="checkbox"
                                       name="guideSuggestionReview" ${physiqueExamination.guideSuggestionReview eq"1" ?"checked":""}
                                       value="1"/>
                                <span>建议复查</span>
                            </label>
                            <br>
                            <label>
                                <input type="checkbox"
                                       name="guideSuggestionReferral" ${physiqueExamination.guideSuggestionReferral eq"1" ?"checked":""}
                                       value="1"/>
                                <span>建议转诊</span>
                            </label>
                        </ehr:authorize>
                    </c:if>
                </td>
                <td colspan="2">
                    危险因素控制
                    <br>
                    <c:if test="${operate eq 'view'}">
                        <label>
                                ${physiqueExamination.riskQuitSmoking eq '1' ? '<span>戒烟</span>' : ''}

                        </label>
                        <br>
                        <label>
                                ${physiqueExamination.riskHealthDrink eq '1' ? '<span>健康饮酒</span>' : ''}

                        </label>
                        <br>
                        <label>
                                ${physiqueExamination.riskDiet eq '1' ? '<span>饮食</span>' : ''}

                        </label>
                        <br>
                        <label>
                                ${physiqueExamination.riskExercise eq '1' ? '<span>锻炼</span>' : ''}

                        </label>
                        <br>
                        <label>
                                ${physiqueExamination.riskWeightReduction eq '1' ? '<span>减体重</span>' : ''}
                        </label>
                        <c:if test="${physiqueExamination.riskWeightReduction eq '1'}">
                            <span id="riskWeightTarget"> ${physiqueExamination.riskWeightTarget}</span>
                        </c:if>
                        <br>
                        <label>${physiqueExamination.guideVaccination eq '1' ? '<span>建议接种疫苗</span>' : ''}</label>
                        <c:if test="${physiqueExamination.guideVaccination eq '1'}">
                            <span id="guideVaccinationDesc"> ${physiqueExamination.guideVaccinationDesc} </span>
                        </c:if>
                        <br>
                        <label>
                                ${physiqueExamination.riskOther eq '1' ? '<span>其他</span>' : ''}
                        </label>
                        <c:if test="${physiqueExamination.riskOther eq '1'}">
                            <span id="riskOtherDesc"> ${physiqueExamination.riskOtherDesc}</span>
                        </c:if>
                    </c:if>
                    <c:if test="${operate eq 'edit'}">
                        <ehr:authorize ifAnyGranted="03">
                            <label>
                                <input type="checkbox"
                                       name="riskQuitSmoking" ${physiqueExamination.riskQuitSmoking eq '1' ? 'checked' : ''} value="1"/>
                                <span>戒烟</span>
                            </label>
                            <br>
                            <label>
                                <input type="checkbox"
                                       name="riskHealthDrink" ${physiqueExamination.riskHealthDrink eq '1' ? 'checked' : ''} value="1"/>
                                <span>健康饮酒</span>
                            </label>
                            <br>
                            <label>
                                <input type="checkbox" name="riskDiet" ${physiqueExamination.riskDiet eq '1' ? 'checked' : ''}
                                       value="1"/>
                                <span>饮食</span>
                            </label>
                            <br>
                            <label>
                                <input type="checkbox" name="riskExercise" ${physiqueExamination.riskExercise eq '1' ? 'checked' : ''}
                                       value="1"/>
                                <span>锻炼</span>
                            </label>
                            <br>
                            <label>
                                <input type="checkbox" id="riskWeightReduction" onclick="util.clickShowText(this,'riskWeightTarget')"
                                       name="riskWeightReduction" ${physiqueExamination.riskWeightReduction eq '1' ? 'checked' : ''}
                                       value="1"/>
                                <span>减体重</span>
                            </label>
                            <span id="riskWeightTarget" class="hidediv">目标:&nbsp;
                                 <!--  <input type="text" name="PersonalPhyExamDTO.physiqueExamination.riskWeightTarget" value="${physiqueExamination.riskWeightTarget}">  -->
                                 <tag:numberInput point="point" value="${physiqueExamination.riskWeightTarget}" name="riskWeightTarget"
                                                  cssClass="width30 "
                                                  reg="{'dependOn':'riskWeightReduction','required':'true','min':0,'max':9999}"/>Kg
                            </span>
                            <br>
                            <label>
                                <input type="checkbox" id="guideVaccination" onclick="util.clickShowText(this,'guideVaccinationDesc')"
                                       name="guideVaccination" ${physiqueExamination.guideVaccination eq '1' ? 'checked' : ''}
                                       value="1"/>
                                <span>建议接种疫苗</span>
                            </label>
                            <span id="guideVaccinationDesc" class="hidediv"> <input type="text" name="guideVaccinationDesc"
                                                                                value="${physiqueExamination.guideVaccinationDesc}"
                                                                                reg='{"dependOn":"guideVaccination","required":"true","maxlength":"33"}'> </span>
                            <br>
                            <label>
                                <input type="checkbox" id="riskOther" onclick="util.clickShowText(this,'riskOtherDesc')"
                                       name="riskOther" ${physiqueExamination.riskOther eq '1' ? 'checked' : ''} value="1"/>
                                <span>其他</span></label>
                            <span id="riskOtherDesc" class="hidediv"> <input type="text" name="riskOtherDesc"
                                                                         value="${physiqueExamination.riskOtherDesc}"
                                                                         reg='{"dependOn":"riskOther","required":"true","maxlength":"33"}'> </span>

                        </ehr:authorize>
                    </c:if>
                </td>
            </tr>
            <%--<input type="text" id="examId" value="${physiqueExamination.id}" hidden="hidden"/>--%>
            <tr>
                <td colspan="6" style="text-align: center">
                    <c:if test="${operate eq 'edit'}">
                        <ehr:authorize ifAnyGranted="02,03">
                            <input id="updateAssessment" type="button"
                                   onclick="hmManageReport.updateAssessment('${physiqueExamination.id}', '${physicalExamRecord.id}')" value="提交自我评估"/>
                        </ehr:authorize>
                    </c:if>
                    <c:if test="${operate eq 'edit'}">
                        <ehr:authorize ifAnyGranted="03">
                            <input id="updateGuide" type="button"
                                   onclick="hmManageReport.updateGuide('${physiqueExamination.id}', '${physicalExamRecord.id}', '${physiqueExamination.ehrId}')" value="提交健康指导"/>
                        </ehr:authorize>
                    </c:if>
                </td>
            </tr>
            </table>
        </div>
    </form>
</div>

