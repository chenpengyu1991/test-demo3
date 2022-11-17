<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="postdiv" id="subDetailDiv">
    <fieldset style="margin-top: 10px">
        <legend>采样情况</legend>
        <form id="tsForm">
            <table class="posttable">
                <colgroup>
                    <col style="min-width: 50px; width: 20%;"/>
                    <col style="min-width: 80px; width: 30%;"/>
                    <col style="min-width: 50px; width: 20%;"/>
                    <col style="min-width: 80px; width: 30%;"/>
                </colgroup>
                <input type="hidden" id="singleId" name="idmId" value="${singleId}">
                <input type="hidden" name="id" id="subId" value="${listTs.id}">
                <input type="hidden" id="infectiousCode" name="infectiousCode" value="${infectiousCode}">

                <input type="hidden" name="createDt" value='<fmt:formatDate value="${listTs.createDt}" pattern="yyyy/MM/dd"/>'/>
                <input type="hidden" name="createUnit" value="${listTs.createUnit}"/>
                <input type="hidden" name="createUser" value="${listTs.createUser}"/>
                <tr>
                    <th>病例编号：</th>
                    <td><input type="text" name="mediRecordNum" value="${listTs.mediRecordNum}" reg='{"maxlength":"20"}'/></td>
                </tr>
                <tr>
                    <th><label class="required">患者姓名：</label></th>
                    <td><input type="text" name="name" value="${listTs.name}" reg='{"maxlength":"50","required":"true"}'/></td>
                    <th>家长姓名：</th>
                    <td><input type="text" name="parentsName" value="${listTs.parentsName}" reg='{"maxlength":"50"}'/></td>
                </tr>
                <tr>
                    <th>性别：</th>
                    <td><ehr:dic-radio name="gender" dicmeta="GBT226112003" value="${listTs.gender}" code="1,2"/></td>
                    <th>出生年月：</th>
                    <td><tag:dateInput name="birthday" onlypast="true" date="${listTs.birthday}"/></td>
                </tr>
                <tbody id="toEmpty">
                    <tr>
                        <th>发病日期：</th>
                        <td><tag:dateInput name="attackDt" onlypast="true" date="${listTs.attackDt}"/></td>
                    </tr>
                    <tr>
                        <th>就诊日期：</th>
                        <td><tag:dateInput name="treatDt" onlypast="true" date="${listTs.treatDt}"/></td>
                        <th><label class="required">采样日期：</label></th>
                        <td><tag:dateInput name="sampleDt" onlypast="true" date="${listTs.sampleDt}" reg='{"required":"true"}'/></td>
                    </tr>
                    <tr>
                        <th>体温℃：</th>
                        <td><input type="text" name="temperature" value="${listTs.temperature}" reg='{"maxlength":"20"}'></td>
                    </tr>
                    <tr>
                        <th>门诊病例：</th>
                        <td><ehr:dic-radio name="outpatient" dicmeta="PH00001" code="1,2" value="${listTs.outpatient}"/></td>
                        <th>住院病例：</th>
                        <td><ehr:dic-radio name="hospitalization" dicmeta="PH00001" code="1,2" value="${listTs.hospitalization}"/></td>
                    </tr>
                    <c:if test="${infectiousCode == '311'}">
                        <tr>
                            <th>手足口病：</th>
                            <td><ehr:dic-radio name="diagnosisHfmd" dicmeta="PH00001" code="1,2" value="${listTs.diagnosisHfmd}"/></td>
                            <th>疱疹性咽峡炎：</th>
                            <td><ehr:dic-radio name="diagnosisAngina" dicmeta="PH00001" code="1,2" value="${listTs.diagnosisAngina}"/></td>
                        </tr>
                        <tr>
                            <th>无菌性脑膜炎：</th>
                            <td><ehr:dic-radio name="diagnosisMeningitis" dicmeta="PH00001" code="1,2" value="${listTs.diagnosisMeningitis}"/></td>
                            <th>脑干脑炎：</th>
                            <td><ehr:dic-radio name="diagnosisEncephalitis" dicmeta="PH00001" code="1,2" value="${listTs.diagnosisEncephalitis}"/></td>
                        </tr>
                        <tr>
                            <th>其他：</th>
                            <td><ehr:dic-radio name="diagnosisOther" dicmeta="PH00001" code="1,2" value="${listTs.diagnosisOther}"/></td>
                        </tr>
                    </c:if>
                    <%--<tr>--%>
                        <%--<th>血清：</th>--%>
                        <%--<td><ehr:dic-radio name="serum" dicmeta="PH00001" code="1,2" value="${listTs.serum}"/></td>--%>
                        <%--<th>全血：</th>--%>
                        <%--<td><ehr:dic-radio name="blood" dicmeta="PH00001" code="1,2" value="${listTs.blood}"/></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<th>咽拭子：</th>--%>
                        <%--<td><ehr:dic-radio name="throatSwab" dicmeta="PH00001" code="1,2" value="${listTs.throatSwab}"/></td>--%>
                        <%--<th>疱内渗出液：</th>--%>
                        <%--<td><ehr:dic-radio name="percolate" dicmeta="PH00001" code="1,2" value="${listTs.percolate}"/></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<th>粪便：</th>--%>
                        <%--<td><ehr:dic-radio name="excrement" dicmeta="PH00001" code="1,2" value="${listTs.excrement}"/></td>--%>
                        <%--<th>肛拭子：</th>--%>
                        <%--<td><ehr:dic-radio name="anusSwab" dicmeta="PH00001" code="1,2" value="${listTs.anusSwab}"/></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<th>脑脊液：</th>--%>
                        <%--<td><ehr:dic-radio name="csf" dicmeta="PH00001" code="1,2" value="${listTs.csf}"/></td>--%>
                        <%--<th>急性期血清：</th>--%>
                        <%--<td><ehr:dic-radio name="acuteSerum" dicmeta="PH00001" code="1,2" value="${listTs.acuteSerum}"/></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<th>恢复期血清：</th>--%>
                        <%--<td><ehr:dic-radio name="convalescentSerum" dicmeta="PH00001" code="1,2" value="${listTs.convalescentSerum}"/></td>--%>
                        <%--<th>其他：</th>--%>
                        <%--<td><ehr:dic-radio name="other" dicmeta="PH00001" code="1,2" value="${listTs.other}"/></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<th>实验室结果：</th>--%>
                        <%--<td colspan="3"><input type="text" name="labResult" value="${listTs.labResult}" reg='{"maxlength":"400"}'/> </td>--%>
                    <%--</tr>--%>
                    <c:choose>
                        <c:when test="${infectiousCode == '101'}"><!-- 鼠疫 -->
                            <tr>
                                <th>血清：</th>
                                <td><ehr:dic-radio name="serum" dicmeta="PH00001" code="1,2" value="${listTs.serum}"/></td>
                                <th>全血：</th>
                                <td><ehr:dic-radio name="blood" dicmeta="PH00001" code="1,2" value="${listTs.blood}"/></td>
                            </tr>
                            <tr>
                                <th>其他：</th>
                                <td><ehr:dic-radio name="other" dicmeta="PH00001" code="1,2" value="${listTs.other}"/></td>
                            </tr>
                        </c:when>
                        <c:when test="${infectiousCode == '102'}"><!-- 霍乱 -->
                            <tr>
                                <th>粪便：</th>
                                <td><ehr:dic-radio name="excrement" dicmeta="PH00001" code="1,2" value="${listTs.excrement}"/></td>
                                <th>肛拭子：</th>
                                <td><ehr:dic-radio name="anusSwab" dicmeta="PH00001" code="1,2" value="${listTs.anusSwab}"/></td>
                            </tr>
                            <tr>
                                <th>其他：</th>
                                <td><ehr:dic-radio name="other" dicmeta="PH00001" code="1,2" value="${listTs.other}"/></td>
                            </tr>
                        </c:when>
                        <c:when test="${infectiousCode == '201'}"><!-- 传染性非典型性肺炎 -->
                            <tr>
                                <th>血清：</th>
                                <td><ehr:dic-radio name="serum" dicmeta="PH00001" code="1,2" value="${listTs.serum}"/></td>
                                <th>咽拭子：</th>
                                <td><ehr:dic-radio name="throatSwab" dicmeta="PH00001" code="1,2" value="${listTs.throatSwab}"/></td>
                            </tr>
                            <tr>
                                <th>其他：</th>
                                <td><ehr:dic-radio name="other" dicmeta="PH00001" code="1,2" value="${listTs.other}"/></td>
                            </tr>
                        </c:when>
                        <c:when test="${fn:contains(infectiousCode,'203')}"><!-- 病毒性肝炎 -->
                            <tr>
                                <th>血清：</th>
                                <td><ehr:dic-radio name="serum" dicmeta="PH00001" code="1,2" value="${listTs.serum}"/></td>
                            </tr>
                        </c:when>
                        <c:when test="${infectiousCode == '205'}"><!-- 人感染高致病性禽流感 -->
                            <tr>
                                <th>血清：</th>
                                <td><ehr:dic-radio name="serum" dicmeta="PH00001" code="1,2" value="${listTs.serum}"/></td>
                                <th>咽拭子：</th>
                                <td><ehr:dic-radio name="throatSwab" dicmeta="PH00001" code="1,2" value="${listTs.throatSwab}"/></td>
                            </tr>
                        </c:when>
                        <c:when test="${infectiousCode == '206'}"><!-- 甲型H1N1流感 -->
                            <tr>
                                <th>咽拭子：</th>
                                <td><ehr:dic-radio name="throatSwab" dicmeta="PH00001" code="1,2" value="${listTs.throatSwab}"/></td>
                            </tr>
                        </c:when>
                        <c:when test="${infectiousCode == '208'}"><!-- 流行性出血热 -->
                            <tr>
                                <th>血清：</th>
                                <td><ehr:dic-radio name="serum" dicmeta="PH00001" code="1,2" value="${listTs.serum}"/></td>
                            </tr>
                        </c:when>
                        <c:when test="${infectiousCode == '209'}"><!-- 狂犬病 -->
                            <tr>
                                <th>脑脊液：</th>
                                <td><ehr:dic-radio name="csf" dicmeta="PH00001" code="1,2" value="${listTs.csf}"/></td>
                                <th>其他：</th>
                                <td><ehr:dic-radio name="other" dicmeta="PH00001" code="1,2" value="${listTs.other}"/></td>
                            </tr>
                        </c:when>
                        <c:when test="${infectiousCode == '211'}"><!-- 登革热 -->
                            <tr>
                                <th>血清：</th>
                                <td><ehr:dic-radio name="serum" dicmeta="PH00001" code="1,2" value="${listTs.serum}"/></td>
                            </tr>
                        </c:when>
                        <c:when test="${fn:contains(infectiousCode, '212')}"><!-- 炭疽 -->
                            <tr>
                                <th>血清：</th>
                                <td><ehr:dic-radio name="serum" dicmeta="PH00001" code="1,2" value="${listTs.serum}"/></td>
                                <th>全血：</th>
                                <td><ehr:dic-radio name="blood" dicmeta="PH00001" code="1,2" value="${listTs.blood}"/></td>
                            </tr>
                            <tr>
                                <th>粪便：</th>
                                <td><ehr:dic-radio name="excrement" dicmeta="PH00001" code="1,2" value="${listTs.excrement}"/></td>
                                <th>脑脊液：</th>
                                <td><ehr:dic-radio name="csf" dicmeta="PH00001" code="1,2" value="${listTs.csf}"/></td>
                            </tr>
                            <tr>
                                <th>其他：</th>
                                <td><ehr:dic-radio name="other" dicmeta="PH00001" code="1,2" value="${listTs.other}"/></td>
                            </tr>
                        </c:when>
                        <c:when test="${fn:contains(infectiousCode, '213')}"><!-- 痢疾 -->
                            <tr>
                                <th>粪便：</th>
                                <td><ehr:dic-radio name="excrement" dicmeta="PH00001" code="1,2" value="${listTs.excrement}"/></td>
                                <th>肛拭子：</th>
                                <td><ehr:dic-radio name="anusSwab" dicmeta="PH00001" code="1,2" value="${listTs.anusSwab}"/></td>
                            </tr>
                        </c:when>
                        <c:when test="${fn:contains(infectiousCode, '215')}"><!-- 伤寒、副伤寒 -->
                            <tr>
                                <th>血清：</th>
                                <td><ehr:dic-radio name="serum" dicmeta="PH00001" code="1,2" value="${listTs.serum}"/></td>
                                <th>全血：</th>
                                <td><ehr:dic-radio name="blood" dicmeta="PH00001" code="1,2" value="${listTs.blood}"/></td>
                            </tr>
                            <tr>
                                <th>粪便：</th>
                                <td><ehr:dic-radio name="excrement" dicmeta="PH00001" code="1,2" value="${listTs.excrement}"/></td>
                                <th>肛拭子：</th>
                                <td><ehr:dic-radio name="anusSwab" dicmeta="PH00001" code="1,2" value="${listTs.anusSwab}"/></td>
                            </tr>
                        </c:when>
                        <c:when test="${infectiousCode =='216'}"><!-- 流行性脑脊髓炎 -->
                            <tr>
                                <th>血清：</th>
                                <td><ehr:dic-radio name="serum" dicmeta="PH00001" code="1,2" value="${listTs.serum}"/></td>
                                <th>全血：</th>
                                <td><ehr:dic-radio name="blood" dicmeta="PH00001" code="1,2" value="${listTs.blood}"/></td>
                            </tr>
                            <tr>
                                <th>脑脊液：</th>
                                <td><ehr:dic-radio name="csf" dicmeta="PH00001" code="1,2" value="${listTs.csf}"/></td>
                                <th>其他：</th>
                                <td><ehr:dic-radio name="other" dicmeta="PH00001" code="1,2" value="${listTs.other}"/></td>
                            </tr>
                        </c:when>
                        <c:when test="${infectiousCode =='220'}"><!-- 猩红热 -->
                            <tr>
                                <th>咽拭子：</th>
                                <td><ehr:dic-radio name="throatSwab" dicmeta="PH00001" code="1,2" value="${listTs.throatSwab}"/></td>
                                <th>其他：</th>
                                <td><ehr:dic-radio name="other" dicmeta="PH00001" code="1,2" value="${listTs.other}"/></td>
                            </tr>
                        </c:when>
                        <c:when test="${infectiousCode =='221'}"><!-- 布鲁氏菌病 -->
                            <tr>
                                <th>血清：</th>
                                <td><ehr:dic-radio name="serum" dicmeta="PH00001" code="1,2" value="${listTs.serum}"/></td>
                                <th>全血：</th>
                                <td><ehr:dic-radio name="blood" dicmeta="PH00001" code="1,2" value="${listTs.blood}"/></td>
                            </tr>
                        </c:when>
                        <c:when test="${infectiousCode =='224'}"><!-- 钩端螺旋体病 -->
                            <tr>
                                <th>血清：</th>
                                <td><ehr:dic-radio name="serum" dicmeta="PH00001" code="1,2" value="${listTs.serum}"/></td>
                                <th>全血：</th>
                                <td><ehr:dic-radio name="blood" dicmeta="PH00001" code="1,2" value="${listTs.blood}"/></td>
                            </tr>
                        </c:when>
                        <c:when test="${infectiousCode =='311'}"><!-- 手足口病 -->
                            <tr>
                                <th>咽拭子：</th>
                                <td><ehr:dic-radio name="throatSwab" dicmeta="PH00001" code="1,2" value="${listTs.throatSwab}"/></td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <th>血清：</th>
                                <td><ehr:dic-radio name="serum" dicmeta="PH00001" code="1,2" value="${listTs.serum}"/></td>
                                <th>全血：</th>
                                <td><ehr:dic-radio name="blood" dicmeta="PH00001" code="1,2" value="${listTs.blood}"/></td>
                            </tr>
                            <tr>
                                <th>咽拭子：</th>
                                <td><ehr:dic-radio name="throatSwab" dicmeta="PH00001" code="1,2" value="${listTs.throatSwab}"/></td>
                                <th>疱内渗出液：</th>
                                <td><ehr:dic-radio name="percolate" dicmeta="PH00001" code="1,2" value="${listTs.percolate}"/></td>
                            </tr>
                            <tr>
                                <th>粪便：</th>
                                <td><ehr:dic-radio name="excrement" dicmeta="PH00001" code="1,2" value="${listTs.excrement}"/></td>
                                <th>肛拭子：</th>
                                <td><ehr:dic-radio name="anusSwab" dicmeta="PH00001" code="1,2" value="${listTs.anusSwab}"/></td>
                            </tr>
                            <tr>
                                <th>脑脊液：</th>
                                <td><ehr:dic-radio name="csf" dicmeta="PH00001" code="1,2" value="${listTs.csf}"/></td>
                                <th>急性期血清：</th>
                                <td><ehr:dic-radio name="acuteSerum" dicmeta="PH00001" code="1,2" value="${listTs.acuteSerum}"/></td>
                            </tr>
                            <tr>
                                <th>恢复期血清：</th>
                                <td><ehr:dic-radio name="convalescentSerum" dicmeta="PH00001" code="1,2" value="${listTs.convalescentSerum}"/></td>
                                <th>其他：</th>
                                <td><ehr:dic-radio name="other" dicmeta="PH00001" code="1,2" value="${listTs.other}"/></td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                    <tr>
                    <th>实验室结果：</th>
                    <td colspan="3"><input type="text" name="labResult" value="${listTs.labResult}" reg='{"maxlength":"400"}'/> </td>
                    </tr>
                </tbody>
            </table>
            </tbody>
        </form>
    </fieldset>
</div>