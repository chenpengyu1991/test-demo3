<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<script>
    $(function() {
        toggleOtherCK('symptom','symptomOther','99');
    });
</script>

<div class="postcontent">
    <form id="addFrForm" method="get">
        <i class="popno">国家基本公共卫生服务项目肺结核患者第一次入户随访记录表</i>
        <div class="postdiv">
            <input type="hidden" id="rowIndexed" value="${rowIndex}"/>
            <input type="hidden" name="firstVist" value="1"/>
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
                        <%-- <th>身份证号：</th>
                        <td>
                            ${tbSaveDto.generalCondition.idcard}
                        </td> --%>
                        <th>编号：</th>
                        <td>
                            ${tbSaveDto.generalCondition.healthFileNo}
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">随访时间：</label></th>
                        <td>
                            <%--<tag:dateInput name="visitTime" nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"
                                           date="${listSr.visitTime==null ? nowDate : listSr.visitTime}" reg='{"required":"true"}'/>--%>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="visitTime" id="visitTime" value="<fmt:formatDate value='${listSr.visitTime==null ? nowDate : listSr.visitTime}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 90px;" />
                        </td>
                        <th>随访方式：</th>
                        <td>
                            <ehr:dic-radio name="visitType" dicmeta="IDM00414" value="${listSr.visitType}" hideCodes="03"/>
                        </td>
                    </tr>
                    <tr>
                        <th>患者类型：</th>
                        <td>
                            <%-- <ehr:dic code="${tbSaveDto.otherCondition.thisType == '1'? '1' : '2'}" dicmeta="IDM00421"/> --%>
                            <ehr:dic-radio name="" dicmeta="IDM00421" value="${tbSaveDto.otherCondition.thisType == '1'? '1' : '2'}" disabled="true"/>
                        </td>
                        <th>痰菌情况：</th>
                        <td>
                            <c:choose>
                                <c:when test="${tbSaveDto.labExamine.phlegmPcr == '1' || tbSaveDto.labExamine.phlegmPcr == '3'}">
                                    <%-- <ehr:dic code="1" dicmeta="IDM00422"/> --%>
                                    <ehr:dic-radio name="" dicmeta="IDM00422" value="1" disabled="true"/>
                                </c:when>
                                <c:when test="${tbSaveDto.labExamine.phlegmPcr == '2' || tbSaveDto.labExamine.phlegmPcr == '4'}">
                                    <%-- <ehr:dic code="2" dicmeta="IDM00422"/> --%>
                                    <ehr:dic-radio name="" dicmeta="IDM00422" value="2" disabled="true"/>
                                </c:when>
                                <c:otherwise>
                                    <%-- <ehr:dic code="3" dicmeta="IDM00422"/> --%>
                                    <ehr:dic-radio name="" dicmeta="IDM00422" value="3" disabled="true"/>
                                </c:otherwise>
                            </c:choose>

                        </td>
                    </tr>
                    <tr name="firstTr">
                        <th>耐药情况：</th>
                        <td colspan="3">
                            <ehr:dic-radio name="nyResult" dicmeta="IDM00423" value="${listSr.nyResult}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>症状及体征：</th>
                        <td colspan="3">
                            <ehr:dic-checkbox id="occupation" dicmeta="IDM00415" name="symptom"  value="${listSr.symptom}" uninclude="06"
                                              reg='{"required":"false"}' onchange="toggleOtherCK('symptom','symptomOther','99')"/>
                            <span id="symptomOther" style="display: none">
									<input type="text" name="symptomOther" value="${listSr.symptomOther}"
                                           style="width: 200px;" reg='{"maxlength":"20"}'/>
								</span>
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
                </table>
            </fieldset>
            <fieldset class="layui-elem-field">
                <legend>督导</legend>
                <table class="posttable" >
                    <colgroup>
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                    </colgroup>
                    <tr>
                        <th>督导人员选择：</th>
                        <td colspan="3">
                            <ehr:dic-radio name="supervisorType" dicmeta="IDM00413" value="${listSr.supervisorType}"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset class="layui-elem-field">
                <legend>家庭居住环境评估</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                    </colgroup>
                    <tbody>
                    <tr >
                        <th><label class="">单独居室：</label></th>
                        <td>
                            <ehr:dic-radio name="room" dicmeta="IDM00418" value="${listSr.room}"/>
                        </td>
                        <th>通风情况：</th>
                        <td>
                            <ehr:dic-radio name="wind" dicmeta="IDM00424" value="${listSr.wind}"/>
                        </td>
                    </tr>
                    </tbody>
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
                        <th>饮酒：</th>
                        <td>
                            <input type="text" name="drink" reg='{"maxlength":"2"}' value="${listSr.drink}" maxlength="2">
                            两/天
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset class="layui-elem-field">
                <legend>健康教育及培训</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                        <col style="width: 20%" />
                        <col style="width: 30%" />
                    </colgroup>
                    <tr >
                        <th>取药地点：</th>
                        <td>
                            <input type="text" name="drugPlace" value="${listSr.drugPlace}">
                        </td>
                        <th>取药时间：</th>
                        <td>
                            <%--<tag:dateInput name="drugDate" nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"
                                           date="${listSr.drugDate}"/>--%>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="drugDate" id="drugDate" value="<fmt:formatDate value='${listSr.drugDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 90px;" />
                        </td>
                    </tr>
                    <tr >
                        <th>服药记录卡填写：</th>
                        <td>
                            <ehr:dic-radio name="drugRecord" dicmeta="IDM00425" value="${listSr.drugRecord}"/>
                        </td>
                        <th>服药方法及药品存放：</th>
                        <td>
                            <ehr:dic-radio name="drugSave" dicmeta="IDM00425" value="${listSr.drugSave}"/>
                        </td>
                    </tr>
                    <tr >
                        <th>肺结核治疗疗程：</th>
                        <td>
                            <ehr:dic-radio name="treTub" dicmeta="IDM00425" value="${listSr.treTub}"/>
                        </td>
                        <th>不规律服药危害：</th>
                        <td>
                            <ehr:dic-radio name="drugHarm" dicmeta="IDM00425" value="${listSr.drugHarm}"/>
                        </td>
                    </tr>
                    <tr >
                        <th>服药后不良反应及处理：</th>
                        <td>
                            <ehr:dic-radio name="drugUntowardEffect" dicmeta="IDM00425" value="${listSr.drugUntowardEffect}"/>
                        </td>
                        <th>治疗期间复诊查痰：</th>
                        <td>
                            <ehr:dic-radio name="recheck" dicmeta="IDM00425" value="${listSr.recheck}"/>
                        </td>
                    </tr>
                    <tr >
                        <th>外出期间如何坚持服药：</th>
                        <td>
                            <ehr:dic-radio name="outsideKeep" dicmeta="IDM00425" value="${listSr.outsideKeep}"/>
                        </td>
                        <th>生活习惯及注意事项：</th>
                        <td>
                            <ehr:dic-radio name="notice" dicmeta="IDM00425" value="${listSr.notice}"/>
                        </td>
                    </tr>
                    <tr >
                        <th>密切接触者检查：</th>
                        <td>
                            <ehr:dic-radio name="contactCheck" dicmeta="IDM00425" value="${listSr.contactCheck}"/>
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
                        <th>评估医生签名：</th>
                        <td>
                            <input type="text" name="visitDoctor" value="${listSr.visitDoctor==null?currentLoginInfo.user.name:listSr.visitDoctor}" maxlength="20">
                        </td>
                        <input type="hidden" name="id" value="${listSr.id}"/>
                        <input type="hidden" name="idmId" id="idmId" value="${listSr.idmId==null?singleId:listSr.idmId}"/>
                        <input type="hidden" name="visitInst" value="${listFr.visitInst==null ? currentLoginInfo.organization.organCode : listFr.visitInst }">
                        <input type="hidden" name="visitById" value="${listFr.visitById == null ? currentLoginInfo.user.id : listFr.visitById}"/>
                    </tr>
                    <tr>
                        <th>患者（家属）签名：</th>
                        <td>
                            <input type="text" name="signOfFamilyName" value="${listSr.signOfFamilyName}" maxlength="40">
                        </td>
                    </tr>
                </table>
            </fieldset>
        </div>
    </form>
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
            elem: '#drugDate'
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