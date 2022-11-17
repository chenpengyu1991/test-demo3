<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<script>
    $(function() {
        toggleOtherCK('symptom','symptomOther','99');
        toggleOther('untowardEffect','effect','02');
        toggleOther('complication','complicationDes','02');

        $("#shouldDoseNum").blur(function() {
            calDoseRate();
        });
        $("#actualDoseNum").blur(function() {
            calDoseRate();
        });

    });
    function calDoseRate() {
        var shouldDoseNum = $("#shouldDoseNum").val();
        var actualDoseNum = $("#actualDoseNum").val();
        var doseRate = 0;
        if (actualDoseNum && actualDoseNum)
        {
            height = shouldDoseNum * 0.01;
            doseRate = (actualDoseNum / (shouldDoseNum * 0.01)).toFixed(1);
        }
        $("#doseRate").val(doseRate);
    }
</script>
<div class="postcontent">
    <form id="addFrForm" method="get">
        <i class="popno">国家基本公共卫生服务项目肺结核患者随访服务记录表</i>
        <div class="postdiv">
            <input type="hidden" id="rowIndexed" value="${rowIndex}"/>
            <input type="hidden" name="generalConditionId"  value="${tbSaveDto.generalCondition.id}"/>
            <input type="hidden" name="firstVist" value="2"/>
            <fieldset class="layui-elem-field">
                <legend>基本信息</legend>
                <table class="posttable" id="popFrTable">
                    <colgroup>
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                    </colgroup>
                    <tr>
                        <th>姓名：</th>
                        <td>
                            ${tbSaveDto.generalCondition.name}
                        </td>
                        <!-- <th>身份证号：</th> -->
                        <th>编号：</th>
                        <td>
                            ${tbSaveDto.generalCondition.healthFileNo}
                            <%-- ${tbSaveDto.generalCondition.idcard} --%>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">随访时间：</label></th>
                        <td>
                            <%--<tag:dateInput name="visitTime" nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"
                                           date="${listSr.visitTime==null ? nowDate : listSr.visitTime}" reg='{"required":"true"}'/>--%>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="visitTime" id="visitTime" value="<fmt:formatDate value='${listSr.visitTime==null ? nowDate : listSr.visitTime}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 90px;" />
                        </td>
                    </tr>
                    <tr>
                        <th>治疗月序：</th>
                        <td><tag:numberInput name="monthCount" value="${listSr.monthCount}"
                                     style="width: 140px"
                                     reg="{'min':0,'max':12}" id="leftBloodUp" maxlength="2"/>
                        </td>
                    </tr>
                    <tr>
                        <th>随访方式：</th>
                        <td>
                            <ehr:dic-radio name="visitType" dicmeta="IDM00414" value="${listSr.visitType}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>督导人员选择：</th>
                        <td>
                            <ehr:dic-radio name="supervisorType" dicmeta="IDM00413" value="${listSr.supervisorType}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>症状及体征：</th>
                        <td colspan="3">
                            <ehr:dic-checkbox id="occupation" dicmeta="IDM00415" name="symptom"  value="${listSr.symptom}"
                                              reg='{"required":"false"}' onchange="toggleOtherCK('symptom','symptomOther','99')"/>
                            <span id="symptomOther" style="display: none">
									<input type="text" name="symptomOther" value="${listSr.symptomOther}"
                                           style="width: 30%;" reg='{"maxlength":"20"}'/>
								</span>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset class="layui-elem-field">
                <legend>生活方式评估</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                    </colgroup>
                    <tr>
                        <th>吸烟：</th>
                        <td>
                            <input type="text" name="smoke" reg='{"maxlength":"2"}' value="${listSr.smoke}" maxlength="2">
                            支/天
                        </td>
                    </tr>
                    <tr>
                        <th>饮酒：</th>
                        <td>
                            <input type="text" name="drink" reg='{"maxlength":"2"}' value="${listSr.drink}" maxlength="2">
                            两/天
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset class="layui-elem-field">
                <legend>用药</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                    </colgroup>
                    <tr>
                        <th>化疗方案：</th>
                        <td>
                            <input type="text" name="method" reg='{"maxlength":"200"}' value="${listSr.method}" maxlength="50">
                        </td>
                    </tr>
                    <tr>
                        <th>用法：</th>
                        <td>
                            <ehr:dic-radio name="usage" dicmeta="IDM00416" value="${listSr.usage}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>药品剂型：</th>
                        <td colspan="3">
                            <ehr:dic-checkbox name="drugForm" dicmeta="IDM00417" value="${listSr.drugForm}"/>
                        </td>
                    </tr>
                    <tr><th>漏服药次数：</th>
                        <td>
                            <input type="text" name="forgotTimes" reg='{"maxlength":"2"}' value="${listSr.forgotTimes}" maxlength="2">次
                        </td></tr>
                </table>
            </fieldset>
            <fieldset class="layui-elem-field">
                <table class="posttable">
                    <colgroup>
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                    </colgroup>
                    <tr>
                        <th>药物不良反应：</th>
                        <td>
                            <ehr:dic-radio name="untowardEffect" dicmeta="IDM00418" value="${listSr.untowardEffect}" onchange="toggleOther('untowardEffect','effect','02')"/>
                            <span id="effect" style="display: none">
									<input type="text" name="effect" value="${listSr.effect}"
                                           style="width: 60%;" reg='{"maxlength":"50"}'/>
							</span>
                        </td>
                    </tr>
                    <tr>
                        <th>并发症或合并症：</th>
                        <td>
                            <ehr:dic-radio name="complication" dicmeta="IDM00418" value="${listSr.complication}" onchange="toggleOther('complication','complicationDes','02')"/>
                            <span id="complicationDes" style="display: none">
									<input type="text" name="complicationDes" value="${listSr.complicationDes}"
                                           style="width: 60%;" reg='{"maxlength":"50"}'/>
								</span>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset class="layui-elem-field">
                <legend>转诊</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                    </colgroup>
                    <tr>
                        <th>原因：</th>
                        <td>
                            <input type="text" name="season" value="${listSr.season}" maxlength="20">
                        </td>
                    </tr>
                    <tr>
                        <%-- <th>科室：</th>
                        <td>
                            <input type="text" name="clicName" value="${listSr.clicName}" maxlength="20">
                        </td> --%>
                        <th>机构及科别：</th>
                        <td>
                            <input type="text" name="clic" value="${listSr.clic}" maxlength="20">
                        </td>
                    </tr>

                    <tr>
                        <th>2周内随访，随访结果：</th>
                        <td>
                            <input type="text" name="visitResult" value="${listSr.visitResult}" maxlength="20">
                        </td>

                    </tr>
                    <tr>
                        <th>处理意见：</th>
                        <td colspan="3">
                            <input type="text" name="adv" value="${listSr.adv}" maxlength="20">
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset class="layui-elem-field">
                <legend>随访信息</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                    </colgroup>
                    <tr>
                        <th>下次随访时间：</th>
                        <td>
                            <%--<tag:dateInput name="nextVisitTime" nullToToday="true" onlyfuture="true" pattern="yyyy/MM/dd"
                                           date="${listSr.nextVisitTime}"/>--%>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="nextVisitTime" id="nextVisitTime" value="<fmt:formatDate value='${listSr.nextVisitTime}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 90px;" />
                        </td>
                    </tr>
                    <tr>
                        <th>随访医生签名：</th>
                        <td>
                            <input type="text" name="visitDoctor" value="${listSr.visitDoctor==null?currentLoginInfo.user.name:listSr.visitDoctor}" maxlength="20">
                        </td>
                        <input type="hidden" name="id" value="${listSr.id}"/>
                        <input type="hidden" name="idmId" id="idmId" value="${listSr.idmId==null?singleId:listSr.idmId}"/>
                        <input type="hidden" name="visitInst" value="${listFr.visitInst==null ? currentLoginInfo.organization.organCode : listFr.visitInst }">
                        <input type="hidden" name="visitById" value="${listFr.visitById == null ? currentLoginInfo.user.id : listFr.visitById}"/>
                    </tr>
                    <tr>
                        <th>患者/家属签名：</th>
                        <td>
                            <input type="text" name="signOfFamilyName" value="${listSr.signOfFamilyName}" maxlength="40">
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset class="layui-elem-field">
                <legend>停止治疗及原因</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                    </colgroup>
                    <tr>
                        <th>出现停止治疗时间：</th>
                        <td>
                            <%--<tag:dateInput name="discontinuedDate" onlypast="true"  pattern="yyyy/MM/dd"
                                           date="${tbSaveDto.generalCondition.discontinuedDate}"/>--%>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="discontinuedDate" id="discontinuedDate" value="<fmt:formatDate value='${tbSaveDto.generalCondition.discontinuedDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 90px;" />
                        </td>
                    </tr>
                    <tr>
                        <th>停止治疗原因：</th>
                        <td colspan="3"><ehr:dic-radio name="discontinuedReason" dicmeta="IDM00635" value="${tbSaveDto.generalCondition.discontinuedReason}"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset class="layui-elem-field">
                <legend>全程管理情况</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                    </colgroup>
                    <tr>
                        <td></td>
                        <td colspan="3">
                            应访视患者
                            <tag:numberInput  style="width:80px" name="shouldVisitNum" value="${tbSaveDto.generalCondition.shouldVisitNum}"  reg="{'maxlength':5}" />次,实际访视
                            <tag:numberInput  name="actualVisitNum" style="width:80px" value="${tbSaveDto.generalCondition.actualVisitNum}" reg="{'maxlength':5}"/>次;
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="3">
                                患者在治疗中,应服药
                                <tag:numberInput style="width:80px" name="shouldDoseNum" id="shouldDoseNum" value="${tbSaveDto.generalCondition.shouldDoseNum}" reg="{'maxlength':5}"/>次,实际服药
                                <tag:numberInput style="width:80px" name="actualDoseNum" id="actualDoseNum"  value="${tbSaveDto.generalCondition.actualDoseNum}" reg="{'maxlength':5}"/>次，服药率
                                <input type="text" style="width:80px" name="doseRate" id="doseRate" value="${tbSaveDto.generalCondition.doseRate}" maxlength="20">%</td>
                        <td>
                    </tr>
                    <tr>
                        <th>评估医生签名：</th>
                        <td>
                            <input type="text" name="evaluateDoc" value="${tbSaveDto.generalCondition.evaluateDoc}" maxlength="20">
                        </td>
                    </tr>
                </table>
            </fieldset>
        </div>
    </form>
<%--    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            &lt;%&ndash;<input type="button" id="saveContact" value="保存" onclick="standardization.saveServiceRecord('addFrForm')">&ndash;%&gt;
            <button class="layui-btn layui-btn-sm"  id="saveContact" onclick="standardization.saveServiceRecord('addFrForm')">保存</button>
        </c:if>
        <c:if test="${type == 'edit'}">
            &lt;%&ndash;<input type="button" id="editContact" value="修改" onclick="standardization.saveServiceRecord('addFrForm')">&ndash;%&gt;
            <button class="layui-btn layui-btn-sm"  id="editContact" onclick="standardization.saveServiceRecord('addFrForm')">修改</button>
        </c:if>
        &lt;%&ndash;<input type="button" id="cancelContact" value="取消" onclick="idmCommon.closePopUp('fwDialog')">&ndash;%&gt;
        <button class="layui-btn layui-btn-sm"  id="cancelContact" onclick="standardization.closeAll('fwDialog')">取消</button>
    </div>--%>
</div>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        laydate.render({
            elem: '#visitTime'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
        });

        laydate.render({
            elem: '#discontinuedDate'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
        });

        laydate.render({
            elem: '#nextVisitTime'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
        });
    });
</script>
