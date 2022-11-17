<%--
  Created by IntelliJ IDEA.
  User: wang_zhou
  Date: 2015/6/6
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/health/report.js"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/basic/basic.js" type="text/javascript"></script>
<div id="beforeSaveDiv" class="rightnav">
    <table>
        <tr>
            	<td class="dingwei"><div id="location" parentMenu="disease-management" childMenu="selfEvaluation">当前位置&nbsp;&gt;&nbsp;老年人自我评估</div>
            </td>
        </tr>
    </table>
    <div  class="table-basic" id="basicInfoEdit">
        <br/>
        <form action="" id="phyExamForm">
            <input type="hidden" name="id" value="${physiqueExamination.id}">
            <table style="width: 100%; border-collapse: collapse;" cellspacing="0"  border="1">
                <tr>
                    <th>老年人健康状况自我评估</th>
                    <td colspan="4">
                        <ehr:dic-radio name="healthSelfAssessment" value="${physiqueExamination.healthSelfAssessment}"
                                       dicmeta="CV0401013"/>
                    </td>
                </tr>
                <tr>
                    <th rowspan="6">老年人生活自理能力自我评估</th>
                    <td colspan="4">
                        <ehr:dic-radio name="lifeAbilitySelfAssessment" value="${physiqueExamination.lifeAbilitySelfAssessment }"
                                       dicmeta="CV0401014"/>
                    </td>
                </tr>
                <tr>
                    <td class="td_gray">进餐：使用餐具将饭菜送入口、咀嚼、吞咽等活动</td>
                    <td colspan="3">
                        <input type="radio" name="eatingAssessment" onclick="hmManageReport.calculateAssessment()" value="0"  ${physiqueExamination.eatingAssessment eq 0 ? "checked" : ""}/> 独立完成（0）
                        <input type="radio" name="eatingAssessment" onclick="hmManageReport.calculateAssessment()" value="3" ${physiqueExamination.eatingAssessment eq 3 ? "checked" : ""}/> 需要协助（3）
                        <input type="radio" name="eatingAssessment" onclick="hmManageReport.calculateAssessment()" value="5" ${physiqueExamination.eatingAssessment eq 5 ? "checked" : ""}/> 完全需要帮助（5）
                    </td>
                </tr>
                <tr>
                    <td class="td_gray">梳洗：梳头、洗脸、刷牙、剃须、洗澡等活动</td>
                    <td colspan="3">
                        <input type="radio" name="cleaningAssessment" onclick="hmManageReport.calculateAssessment()" value="0" ${physiqueExamination.cleaningAssessment eq 0 ? "checked" : ""}/> 独立完成（0）
                        <input type="radio" name="cleaningAssessment" onclick="hmManageReport.calculateAssessment()" value="1" ${physiqueExamination.cleaningAssessment eq 1 ? "checked" : ""}/> 洗澡需协助（1）
                        <input type="radio" name="cleaningAssessment" onclick="hmManageReport.calculateAssessment()" value="3" ${physiqueExamination.cleaningAssessment eq 3 ? "checked" : ""}/> 协助下能完成（3）
                        <input type="radio" name="cleaningAssessment" onclick="hmManageReport.calculateAssessment()" value="7" ${physiqueExamination.cleaningAssessment eq 7 ? "checked" : ""}/> 完全需要帮助（7）
                    </td>
                </tr>
                <tr>
                    <td class="td_gray">穿衣：穿衣裤、袜子、鞋子等活动</td>
                    <td colspan="3">
                        <input type="radio" name="clothingAssessment" onclick="hmManageReport.calculateAssessment()" value="0" ${physiqueExamination.clothingAssessment eq 0 ? "checked" : ""}/> 独立完成（0）
                        <input type="radio" name="clothingAssessment" onclick="hmManageReport.calculateAssessment()" value="3" ${physiqueExamination.clothingAssessment eq 3 ? "checked" : ""}/> 需要协助（3）
                        <input type="radio" name="clothingAssessment" onclick="hmManageReport.calculateAssessment()" value="5" ${physiqueExamination.clothingAssessment eq 5 ? "checked" : ""}/> 完全需要帮助（5）
                    </td>
                </tr>
                <tr>
                    <td class="td_gray">如厕：小便、大便等活动及自控</td>
                    <td colspan="3">
                        <input type="radio" name="defecationAssessment" onclick="hmManageReport.calculateAssessment()" value="0" ${physiqueExamination.defecationAssessment eq 0 ? "checked" : ""}/> 不需协助（0）
                        <input type="radio" name="defecationAssessment" onclick="hmManageReport.calculateAssessment()" value="1" ${physiqueExamination.defecationAssessment eq 1 ? "checked" : ""}/> 偶尔失禁（1）
                        <input type="radio" name="defecationAssessment" onclick="hmManageReport.calculateAssessment()" value="5" ${physiqueExamination.defecationAssessment eq 5 ? "checked" : ""}/> 经常失禁（5）
                        <input type="radio" name="defecationAssessment" onclick="hmManageReport.calculateAssessment()" value="10" ${physiqueExamination.defecationAssessment eq 10 ? "checked" : ""}/> 完全失禁（10）
                    </td>
                </tr>
                <tr>
                    <td class="td_gray">活动：站立、室内行走、上下楼梯、户外活动</td>
                    <td colspan="3">
                        <input type="radio" name="exerciseAssessment" onclick="hmManageReport.calculateAssessment()" value="0" ${physiqueExamination.exerciseAssessment eq 0 ? "checked" : ""}/> 独立完成（0）
                        <input type="radio" name="exerciseAssessment" onclick="hmManageReport.calculateAssessment()" value="1" ${physiqueExamination.exerciseAssessment eq 1 ? "checked" : ""}/> 借助较小外力（1）
                        <input type="radio" name="exerciseAssessment" onclick="hmManageReport.calculateAssessment()" value="5" ${physiqueExamination.exerciseAssessment eq 5 ? "checked" : ""}/> 借助较大外力（5）
                        <input type="radio" name="exerciseAssessment" onclick="hmManageReport.calculateAssessment()" value="10" ${physiqueExamination.exerciseAssessment eq 10 ? "checked" : ""}/> 卧床不起（10）
                    </td>
                </tr>
                <tr>
                    <th>老年人认知功能</th>
                    <td colspan="4">

                        <input type="radio" name="cognitionScreenResult"
                               onclick="util.clickHideText(this,'cognitionScreenScore')" ${physiqueExamination.cognitionScreenResult eq"1" ?"checked" :""}
                               value="1"/>
                        粗筛阴性
                        <input type="radio" id="cognitionScreenResult" name="cognitionScreenResult"
                               onclick="util.clickShowText(this,'cognitionScreenScore')" ${physiqueExamination.cognitionScreenResult eq"0" ?"checked" :""}
                               value="0"/>
                        粗筛阳性
                            <span id="cognitionScreenScore" ${physiqueExamination.cognitionScreenResult ne'0' ?'class="hidediv"' :''}>
                               ，简易智力状态检查，总分<tag:numberInput name="cognitionScreenScore" value="${physiqueExamination.cognitionScreenScore}" cssClass="width30"
                                                            reg="{'dependOn':'cognitionScreenResult','required':'true','min':0,'max':9999}"/>
                            </span>
                    </td>
                </tr>
                <tr>
                    <th>老年人情感状态</th>
                    <td colspan="4">

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
                    </td>
                </tr>
                <tr>
                    <td colspan="6" style="text-align: center">
                        <input id="updateAssessment" type="button"
                               onclick="hmManageReport.updateAssessment('${personInfo.id}')" value="提交自我评估"/>
                        <input id="edit" type="button" style="display: none"
                               onclick="hmManageReport.bj()" value="编辑"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>