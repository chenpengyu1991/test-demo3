<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ehr/person/report.js"></script>
<link href="${pageContext.request.contextPath}/css/views/ech/report.css" type="text/css"   rel="stylesheet"/>
<div id="report">
    <div class="toolbar">
        <%-- <c:if test='${sourceFlag eq "1"}'><a href="javascript:void(0)" onclick="javascript:echManageSearch.returnSearch()"><b class="fanhui">返回</b></a></c:if>
        <c:if test='${sourceFlag eq "1" || sourceFlag eq "2"}'><c:if test='${editflag == "edit"}'><a href="javascript:void(0)" id="calcTZJG" ><b class="">计算</b></a></c:if>
        </c:if> --%>
        <c:if test='${editflag == "edit"}'>
        	<a href="javascript:void(0);" id="save"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
        </c:if>
    </div>
	<input type="hidden" id="sourceFlag" value="${sourceFlag}"/><%--页面来源 1：中医药，2：健康档案 --%>
    <div class="postcontent" style="overflow-y: auto;">
            <i class="popno" style="height: 25px;">老年人抑郁量表（GDS）</i>
            <table class="posttable">
                <colgroup>
                    <col style="min-width: 100px; width: 15%;"/>
                    <col style="min-width: 220px; width: 85%;"/>
                </colgroup>
                <tbody>
                <tr>
                    <th><label class="required">姓名</label></th>
                    <td>
                        ${personInfo.name}
                    </td>
                </tr>
                </tbody>
            </table>
            <div style="margin-right: 17px;">
            <table class="posttable">
                <colgroup>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 70px; width: 10%;"/>
                </colgroup>
                <thead>
                <tr><td colspan="10" ><hr style="margin:5px 0px 5px 5px;height:1px;color:#A9C3D0"/></tr>
                <tr>
                    <td align="center" colspan="5"><b>选择最切合您一周来的感受，回答以下问题。</b></td>
                </tr>
                </thead>
            </table>
            </div>
            <%--<div class="">--%>
            <div style="-ms-overflow-y: auto;">
                <div style="height: 380px;">
                    <form id="reportForm">
                   <%--  <input type="hidden" id="reportId" name="id" value="${report.id}"/> --%>
                    <%-- <input type="hidden" name="name" value="${report.name}"/>
                    <input type="hidden" id="options"  value="${options}"/>
                    <input type="hidden" id="examRecordId" name="examRecordId" value="${report.examRecordId}"/>
                    <input type="hidden" name="examinationDate" value="<fmt:formatDate value="${report.examinationDate}" pattern="yyyy/MM/dd" />"/>
                    <input type="hidden" id="idcard" name="idcard" value="${report.idcard}"/>
                    <input type="hidden" name="createDate"  value="<fmt:formatDate value="${report.createDate}" pattern="yyyy/MM/dd" />"/>
                    <input type="hidden" name="createOrg"  value="${report.createOrg}"/>
                    <input type="hidden" name="createUser"  value="${report.createUser}"/> --%>
                    <input type="hidden" id="options"  value="${options}"/>
                    <input type="hidden" id="editflag"  value="${editflag}"/>
                    <table class="posttable">
                        <tbody>
                            <tr>
                                <th class="leftth" colspan="5">(1)您对生活基本满意吗？</th>
                                <th class="centerth"><div id="option1_0"  data-option-no="1" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option1_1"  data-option-no="1" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(2)您是否已放弃了许多活动与兴趣？</th>
                                <th class="centerth"><div id="option2_1"  data-option-no="2" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option2_0"  data-option-no="2" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(3)您是否觉得生活空虚？</th>
                                <th class="centerth"><div id="option3_1"  data-option-no="3" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option3_0"  data-option-no="3" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(4)您是否感到厌倦？</th>
                                <th class="centerth"><div id="option4_1"  data-option-no="4" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option4_0"  data-option-no="4" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(5)你觉得未来有希望吗？</th>
                                <th class="centerth"><div id="option5_0"  data-option-no="5" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option5_1"  data-option-no="5" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(6)你是否因为脑子里一些想法摆脱不掉而烦恼？</th>
                                <th class="centerth"><div id="option6_1"  data-option-no="6" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option6_0"  data-option-no="6" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(7)你是否大部分时间精力充沛？ </th>
                                <th class="centerth"><div id="option7_0"  data-option-no="7" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option7_1"  data-option-no="7" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(8)你是否害怕有不幸的事落到你头上? </th>
                                <th class="centerth"><div id="option8_1"  data-option-no="8" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option8_0"  data-option-no="8" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(9)你是否大部分时间感到幸福?</th>
                                <th class="centerth"><div id="option9_0"  data-option-no="9" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option9_1"  data-option-no="9" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(10)你是否常感到孤立无援？</th>
                                <th class="centerth"><div id="option10_1"  data-option-no="10" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option10_0"  data-option-no="10" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(11)你是否经常坐立不安，心烦意乱？</th>
                                <th class="centerth"><div id="option11_1"  data-option-no="11" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option11_0"  data-option-no="11" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(12)你是否愿意呆在家里而不愿去做些新鲜事？</th>
                                <th class="centerth"><div id="option12_1"  data-option-no="12" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option12_0"  data-option-no="12" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(13)你是否常常担心将来？</th>
                                <th class="centerth"><div id="option13_1"  data-option-no="13" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option13_0"  data-option-no="13" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(14)你是否觉得记忆力比以前差？</th>
                                <th class="centerth"><div id="option14_1"  data-option-no="14" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option14_0"  data-option-no="14" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(15)你觉得现在活着很惬意吗？</th>
                                <th class="centerth"><div id="option15_0"  data-option-no="15" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option15_1"  data-option-no="15" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(16)你是否常感到心情沉重、郁闷？ </th>
                                <th class="centerth"><div id="option16_1"  data-option-no="16" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option16_0"  data-option-no="16" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(17)你是否觉得像现在这样活着毫无意义？</th>
                                <th class="centerth"><div id="option17_1"  data-option-no="17" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option17_0"  data-option-no="17" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(18)你是否总对过去的事忧愁？</th>
                                <th class="centerth"><div id="option18_1"  data-option-no="18" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option18_0"  data-option-no="18" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(19)你觉得生活很令人兴奋吗？</th>
                                <th class="centerth"><div id="option19_0"  data-option-no="19" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option19_1"  data-option-no="19" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(20)你开始一件新的工作很困难吗？</th>
                                <th class="centerth"><div id="option20_1"  data-option-no="20" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option20_0"  data-option-no="20" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(21)你觉得生活充满活力吗? </th>
                                <th class="centerth"><div id="option21_0"  data-option-no="21" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option21_1"  data-option-no="21" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(22)你是否觉得你的处境已毫无希望？ </th>
                                <th class="centerth"><div id="option22_1"  data-option-no="22" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option22_0"  data-option-no="22" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(23)你是否觉得大多数人比你强得多？ </th>
                                <th class="centerth"><div id="option23_1"  data-option-no="23" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option23_0"  data-option-no="23" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(24)你是否常为些小事伤心？</th>
                                <th class="centerth"><div id="option24_1"  data-option-no="24" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option24_0"  data-option-no="24" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(25)你是否常觉得想哭？</th>
                                <th class="centerth"><div id="option25_1"  data-option-no="25" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option25_0"  data-option-no="25" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(26)你集中精力有困难吗？</th>
                                <th class="centerth"><div id="option26_1"  data-option-no="26" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option26_0"  data-option-no="26" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(27)你早晨起来很快活吗？</th>
                                <th class="centerth"><div id="option27_0"  data-option-no="27" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option27_1"  data-option-no="27" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(28)你希望避开聚会吗？</th>
                                <th class="centerth"><div id="option28_1"  data-option-no="28" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option28_0"  data-option-no="28" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(29)你作决定很容易吗？</th>
                                <th class="centerth"><div id="option29_0"  data-option-no="29" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option29_1"  data-option-no="29" class="optionNormal"><b>否</b></div></th>
                            </tr>
                            <tr>
                                <th class="leftth" colspan="5">(30)你的头脑像往常一样清晰吗？</th>
                                <th class="centerth"><div id="option30_0"  data-option-no="30" class="optionNormal"><b>是</b></div></th>
                                <th class="centerth"><div id="option30_1"  data-option-no="30" class="optionNormal"><b>否</b></div></th>
                            </tr>
                        </tbody>
                    </table>
                </form>
                </div>
            </div>
    </div>
</div>
<div id="result"></div>


