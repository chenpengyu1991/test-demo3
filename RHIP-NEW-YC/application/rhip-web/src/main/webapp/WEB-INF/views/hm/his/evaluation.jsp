<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<c:choose>
    <c:when test="${not empty errorStr}">
        ${errorStr}
    </c:when>
    <c:otherwise>
        <jsp:include page="../manage/personInfo.jsp"></jsp:include>
        <div id="toolbar" class="toolbar">
            <script src="${pageContext.request.contextPath}/js/views/hm/his/add.js"
                    type="text/javascript"></script>
            <a href="javascript:void(0);" id="save-btn-external"><b
                    class="tijiao">提交</b></a>
        </div>
        <div id="evaluation-main">
            <form id="evaluation-form">
                <input type="hidden" name="personId" value="${personInfo.id}"/>
                <div class="postcontent">
                    <i class="popno">老年人管理</i>
                    <div class="postdiv">
                        <fieldset>
                            <legend>自我评估</legend>
                            <table class="posttable">
                                <colgroup>
                                    <col style="width:30%">
                                    <col style="width:70%">
                                </colgroup>
                                <tr>
                                    <th><label class="required">健康状况自我评估</label></th>
                                    <td>
                                        <ehr:dic-radio name="healthSelfAssessment"
                                                       value="${examination.healthSelfAssessment}"
                                                       dicmeta="CV0401013"
                                                       reg="{'required':true}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th><label class="required">生活自理能力自我评估</label></th>
                                    <td>
                                        <ehr:dic-radio name="lifeAbilitySelfAssessment"
                                                       value="${examination.lifeAbilitySelfAssessment }"
                                                       dicmeta="CV0401014"
                                                       reg="{'required':true}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th><label class="required">进餐：使用餐具将饭菜送入口、咀嚼、吞咽等活动</label>
                                    </th>
                                    <td>
                                        <label><input type="radio" name="eatingAssessment"
                                                      onclick="cdmPersonPhyExamAdd.calculateAssessment()"
                                                      value="0"
                                            ${examination.eatingAssessment eq 0 ? "checked" : "" }
                                                      reg="{'required':true}"/> 独立完成（0）</label>
                                        <label><input type="radio" name="eatingAssessment"
                                                      onclick="cdmPersonPhyExamAdd.calculateAssessment()"
                                                      value="3"
                                            ${examination.eatingAssessment eq 3 ? "checked" : ""}
                                                      reg="{'required':true}"/> 需要协助（3）</label>
                                        <label><input type="radio" name="eatingAssessment"
                                                      onclick="cdmPersonPhyExamAdd.calculateAssessment()"
                                                      value="3"
                                            ${examination.eatingAssessment eq 5 ? "checked" : ""}
                                                      reg="{'required':true}"/> 完全需要帮助（5）</label>
                                    </td>
                                </tr>
                                <tr>
                                    <th><label class="required">梳洗：梳头、洗脸、刷牙、剃须、洗澡等活动</label>
                                    </th>
                                    <td>

                                        <label><input type="radio" name="cleaningAssessment"
                                                      onclick="cdmEvaAdd.calculateAssessment()"
                                                      value="0"
                                            ${examination.cleaningAssessment eq 0 ? "checked" : "" }
                                                      reg="{'required':true}"/> 独立完成（0）</label>
                                        <label><input type="radio" name="cleaningAssessment"
                                                      onclick="cdmEvaAdd.calculateAssessment()"
                                                      value="1"
                                            ${examination.cleaningAssessment eq 1 ? "checked" : ""}
                                                      reg="{'required':true}"/> 洗澡需协助（1）</label>
                                        <label><input type="radio" name="cleaningAssessment"
                                                      onclick="cdmEvaAdd.calculateAssessment()"
                                                      value="3"
                                            ${examination.cleaningAssessment eq 3 ? "checked" : ""}
                                                      reg="{'required':true}"/>
                                            协助下能完成（3）</label>
                                        <label><input type="radio" name="cleaningAssessment"
                                                      onclick="cdmEvaAdd.calculateAssessment()"
                                                      value="7"
                                            ${examination.cleaningAssessment eq 7 ? "checked" : ""}
                                                      reg="{'required':true}"/>
                                            完全需要帮助（7）</label>

                                    </td>
                                </tr>
                                <tr>
                                    <th><label class="required">穿衣：穿衣裤、袜子、鞋子等活动</label></th>
                                    <td>
                                        <label><input type="radio" name="clothingAssessment"
                                                      onclick="cdmEvaAdd.calculateAssessment()"
                                                      value="0"
                                            ${examination.clothingAssessment eq 0 ? "checked" : ""}
                                                      reg="{'required':true}"/> 独立完成（0）</label>
                                        <label><input type="radio" name="clothingAssessment"
                                                      onclick="cdmEvaAdd.calculateAssessment()"
                                                      value="3"
                                            ${examination.clothingAssessment eq 3 ? "checked" : ""}
                                                      reg="{'required':true}"/> 需要协助（3）</label>
                                        <label><input type="radio" name="clothingAssessment"
                                                      onclick="cdmEvaAdd.calculateAssessment()"
                                                      value="5"
                                            ${examination.clothingAssessment eq 5 ? "checked" : ""}
                                                      reg="{'required':true}"/>
                                            完全需要帮助（5）</label>
                                    </td>
                                </tr>
                                <tr>
                                    <th><label class="required">如厕：小便、大便等活动及自控</label></th>
                                    <td>
                                        <label><input type="radio" name="defecationAssessment"
                                                      onclick="cdmEvaAdd.calculateAssessment()"
                                                      value="0"
                                            ${examination.defecationAssessment eq 0 ? "checked" : ""}
                                                      reg="{'required':true}"/> 不需协助（0）</label>
                                        <label><input type="radio" name="defecationAssessment"
                                                      onclick="cdmEvaAdd.calculateAssessment()"
                                                      value="1"
                                            ${examination.defecationAssessment eq 1 ? "checked" : ""}
                                                      reg="{'required':true}"/> 偶尔失禁（1）</label>
                                        <label><input type="radio" name="defecationAssessment"
                                                      onclick="cdmEvaAdd.calculateAssessment()"
                                                      value="5"
                                            ${examination.defecationAssessment eq 5 ? "checked" : ""}
                                                      reg="{'required':true}"/> 经常失禁（5）</label>
                                        <label><input type="radio" name="defecationAssessment"
                                                      onclick="cdmEvaAdd.calculateAssessment()"
                                                      value="10"
                                            ${examination.defecationAssessment eq 10 ? "checked" : ""}
                                                      reg="{'required':true}"/>
                                            完全失禁（10）</label>
                                    </td>
                                </tr>
                                <tr>
                                    <th><label class="required">活动：站立、室内行走、上下楼梯、户外活动</label>
                                    </th>
                                    <td>
                                        <label><input type="radio" name="exerciseAssessment"
                                                      onclick="cdmEvaAdd.calculateAssessment()"
                                                      value="0"
                                            ${examination.exerciseAssessment eq 0 ? "checked" : ""}
                                                      reg="{'required':true}"/> 独立完成（0）</label>
                                        <label><input type="radio" name="exerciseAssessment"
                                                      onclick="cdmEvaAdd.calculateAssessment()"
                                                      value="1"
                                            ${examination.exerciseAssessment eq 1 ? "checked" : ""}
                                                      reg="{'required':true}"/>
                                            借助较小外力（1）</label>
                                        <label><input type="radio" name="exerciseAssessment"
                                                      onclick="cdmEvaAdd.calculateAssessment()"
                                                      value="5"
                                            ${examination.exerciseAssessment eq 5 ? "checked" : ""}
                                                      reg="{'required':true}"/>
                                            借助较大外力（5）</label>
                                        <label><input type="radio" name="exerciseAssessment"
                                                      onclick="cdmEvaAdd.calculateAssessment()"
                                                      value="10"
                                            ${examination.exerciseAssessment eq 10 ? "checked" : ""}
                                                      reg="{'required':true}"/> 卧床不起（10）</label>
                                    </td>
                                </tr>
                                <tr>
                                    <th><label class="required">老年人认知功能</label></th>
                                    <td>
                                        <label><input type="radio" name="cognitionScreenResult"
                                                      onclick="util.clickHideText(this,'cognitionScreenScore')" ${examination.cognitionScreenResult eq"1" ?"checked" :""}
                                                      value="1" reg="{'required':true}"/>
                                            粗筛阴性</label>
                                        <label><input type="radio" id="cognitionScreenResult"
                                                      name="cognitionScreenResult"
                                                      onclick="util.clickShowText(this,'cognitionScreenScore')" ${examination.cognitionScreenResult eq"0" ?"checked" :""}
                                                      value="0" reg="{'required':true}"/>
                                            粗筛阳性</label>
                                        <span id="cognitionScreenScore"  ${examination.cognitionScreenResult ne'0' ?'class="hidediv"' :''}>
						   ，简易智力状态检查，总分<tags:numberInput name="cognitionScreenScore"
                                                         style="width:40px;"
                                                         value="${examination.cognitionScreenScore}"
                                                         cssClass="width30"
                                                         reg="{'dependOn':'cognitionScreenResult','required':'true','min':0,'max':9999}"/>
						</span>
                                    </td>
                                </tr>
                                <tr>
                                    <th><label class="required">老年人情感状态</label></th>
                                    <td>
                                        <label><input type="radio" name="emotionScreenResult"
                                                      onclick="util.clickHideText(this,'depressionScore')" ${examination.emotionScreenResult eq"1" ?"checked" :""}
                                                      value="1" reg="{'required':true}"/>
                                            粗筛阴性</label>
                                        <label><input type="radio" id="emotionScreenResult"
                                                      name="emotionScreenResult"
                                                      onclick="util.clickShowText(this,'depressionScore')" ${examination.emotionScreenResult eq"0" ?"checked" :""}
                                                      value="0" reg="{'required':true}"/>
                                            粗筛阳性</label>
                                        <span id="depressionScore" ${examination.emotionScreenResult ne'0' ?'class="hidediv"' :''}>
						，老年人抑郁评分检查，总分<tags:numberInput name="depressionScore" id="depressionScore"
                                                       value="${examination.depressionScore}"
                                                       cssClass="width30" style="width:40px;"
                                                       reg="{'dependOn':'emotionScreenResult','required':'true','min':0,'max':999}"/>
													  <span class="toolbarsublist" ${examination.emotionScreenResult ne'0' ?'class="hidediv"' :''}>
                                                              <a href="javascript:void(0)" id="addOldDepressed"><b
                                                                      class="xinz">老年抑郁</b></a>
                                                      </span>
					</span>
                                    </td>
                                </tr>
                            </table>
                        </fieldset>
                    </div>
                    <div class="postdiv">
                        <fieldset>
                            <legend>健康指导</legend>
                            <table class="posttable">
                                <colgroup>
                                    <col style="width:30%">
                                    <col style="width:70%">
                                </colgroup>
                                <tr>
                                    <th title="《考核项目》纳入慢性病患者健康管理是指高血压、糖尿病、严重精神障碍患者等重点人群定期随访和健康体检。减体重的目标是指根据居民或患者的具体情况,指定下次体检之前需要减重的目标值。"
                                        style="width: 16%"><label class="required">健康指导</label></th>
                                    <td id="ttbhealth">
                                            <%--<label>
                                                <input type="checkbox"
                                                       name="guideRegularFollowup" ${examination.guideRegularFollowup eq"1" ?"checked":""}
                                                       value="1"/>
                                                <span>定期随访</span>
                                            </label>
                                            <br>--%>
                                        <label>
                                            <input type="checkbox"
                                                   reg='{"extension":["healthGuidanceVali","请至少选择一项"]}'
                                                   name="guideIntoChronicDisease" ${examination.guideIntoChronicDisease eq"1" ?"checked":""}
                                                   value="1"/>
                                            <span>纳入慢性病患者健康管理  <font style="color: red">注：若勾选此选项,请核实第二页基本信息既往史有没有勾选高血压、糖尿病或严重精神障碍</font></span>
                                        </label>
                                        <br>
                                        <label>
                                            <input type="checkbox"
                                                   reg='{"extension":["healthGuidanceVali","请至少选择一项"]}'
                                                   name="guideSuggestionReview" ${examination.guideSuggestionReview eq"1" ?"checked":""}
                                                   value="1"/>
                                            <span>建议复查</span>
                                        </label>
                                        <br>
                                        <label>
                                            <input type="checkbox"
                                                   reg='{"extension":["healthGuidanceVali","请至少选择一项"]}'
                                                   name="guideSuggestionReferral" ${examination.guideSuggestionReferral eq"1" ?"checked":""}
                                                   value="1"/>
                                            <span>建议转诊</span>
                                        </label>
                                    </td>
                                </tr>
                                <tr id="ttbRisk">
                                    <th class="required">危险因素控制</th>
                                    <td>
                                        <label>
                                            <input type="checkbox" reg='{"extension":["riskFactorVali","请至少选择一项"]}'
                                                   name="riskQuitSmoking" ${examination.riskQuitSmoking eq '1' ? 'checked' : ''}
                                                   value="1"/>
                                            <span>戒烟</span>
                                        </label>
                                        <br>
                                        <label>
                                            <input type="checkbox" reg='{"extension":["riskFactorVali","请至少选择一项"]}'
                                                   name="riskHealthDrink" ${examination.riskHealthDrink eq '1' ? 'checked' : ''}
                                                   value="1"/>
                                            <span>健康饮酒</span>
                                        </label>
                                        <br>
                                        <label>
                                            <input type="checkbox" reg='{"extension":["riskFactorVali","请至少选择一项"]}'
                                                   name="riskDiet" ${examination.riskDiet eq '1' ? 'checked' : ''}
                                                   value="1"/>
                                            <span>饮食</span>
                                        </label>
                                        <br>
                                        <label>
                                            <input type="checkbox" reg='{"extension":["riskFactorVali","请至少选择一项"]}'
                                                   name="riskExercise" ${examination.riskExercise eq '1' ? 'checked' : ''}
                                                   value="1"/>
                                            <span>锻炼</span>
                                        </label>
                                        <br>
                                        <label>
                                            <input type="checkbox" id="riskWeightReduction" reg='{"extension":["riskFactorVali","请至少选择一项"]}'
                                                   onclick="util.clickShowText(this,'riskWeightTarget')"
                                                   name="riskWeightReduction" ${examination.riskWeightReduction eq '1' ? 'checked' : ''}
                                                   value="1"/>
                                            <span>减体重</span>
                                        </label>
                                        <span id="riskWeightTarget" class="hidediv">目标:&nbsp;
						                <tags:numberInput point="point" value="${examination.riskWeightTarget}"
                                          name="riskWeightTarget"
                                          style="width: 40px;"
                                          reg="{'dependOn':'riskWeightReduction','scale':2,'required':'true','min':0,'max':9999}"/>Kg
					                    </span>
                                        <br>
                                        <label>
                                            <input type="checkbox" id="guideVaccination" reg='{"extension":["riskFactorVali","请至少选择一项"]}'
                                                   onclick="util.clickShowText(this,'guideVaccinationDesc')"
                                                   name="guideVaccination" ${examination.guideVaccination eq '1' ? 'checked' : ''}
                                                   value="1"/>
                                            <span>建议接种疫苗</span>
                                        </label>
                                        <span id="guideVaccinationDesc" class="hidediv"> <input
                                                type="text" name="guideVaccinationDesc"
                                                value="${examination.guideVaccinationDesc}"
                                                reg='{"dependOn":"guideVaccination","required":"true","maxlength":"33"}'> </span>
                                        <br>
                                        <label>
                                            <input type="checkbox" id="riskOther" reg='{"extension":["riskFactorVali","请至少选择一项"]}'
                                                   onclick="util.clickShowText(this,'riskOtherDesc')"
                                                   name="riskOther" ${examination.riskOther eq '1' ? 'checked' : ''}
                                                   value="1"/>
                                            <span>其他</span></label>
                                        <span id="riskOtherDesc" class="hidediv"> <input type="text"
                                                                                         name="riskOtherDesc"
                                                                                         value="${examination.riskOtherDesc}"
                                                                                         reg='{"dependOn":"riskOther","required":"true","maxlength":"33"}'> </span>
                                    </td>
                                </tr>
                            </table>
                        </fieldset>
                    </div>
                </div>
            </form>
        </div>
    </c:otherwise>
</c:choose>
