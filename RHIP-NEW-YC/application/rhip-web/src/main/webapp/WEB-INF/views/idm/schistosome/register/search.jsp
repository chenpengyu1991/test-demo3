<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.founder.rhip.ehr.common.EHRConstants" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<c:set var="JK_CODE" value="<%=EHRConstants.JK_CODE%>"/>
<script src="${pageContext.request.contextPath}/js/views/idm/schistosome/registerSearch.js"
        type="text/javascript"></script>
    <div id="register_top_all">
        <div class="searchbox searchSection x-admin-sm">
            <input type="hidden" id="pageIndex" value="${pageIndex}">
            <form id="registerSearchForm">
                <table id="registerSearch">
                    <colgroup>
                        <col style="min-width:70px; width: 10%;"/>
                        <col style="min-width:100px; width: 26%;"/>
                        <col style="min-width:70px; width: 10%;"/>
                        <col style="min-width:100px; width: 20%;"/>
                        <col style="min-width:70px; width: 10%;"/>
                        <col style="min-width:183px; width: 23%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <td class="coltext">身份证号</td>
                        <td class="colinput">
                            <tag:idcardInput name="idcard" id="idCard2" cssClass="x-layui-input"></tag:idcardInput>&nbsp;
                            <input type="button" id="check-submit-btn" value="读卡" style="width: 40px;">
                        </td>
                        <td class="coltext">常住类型</td>
                        <td class="colinput">
                            <ehr:dic-radio name="floatPopulation" dicmeta="FS10005" value="" isDefault="Y"/>
                        </td>
                        <td class="coltext">血检结果</td>
                        <td class="colinput" rowspan="2">
                            <ehr:dic-list id="bloodTestId" name="bloodTest" dicmeta="IDM00322"
                                          onchange="registerSearch.getTestOption(this.value);"/>
                            <select id="bloodOptionId" name="bloodOption" class="x-layui-input">
                                <option value="">请选择</option>
                            </select>
                        </td>

                    </tr>
                    <tr>
                        <td class="coltext">姓名</td>
                        <td class="colinput"><input type="text" name="name"/></td>
                        <td class="coltext">确诊结果</td>
                        <td class="colinput">
                            <ehr:dic-list id="specialStatus" name="specialStatus" dicmeta="IDM00337"
                                          cssClass="x-layui-input"/>
                        </td>
                    </tr>
                    <tr class="advanceSearchSection" style="display: none;">
                        <td class="coltext">性别</td>
                        <td class="colinput">
                            <ehr:dic-radio name="gender" dicmeta="GBT226112003" code="1,2" value="" isDefault="Y"/>
                        </td>
                        <c:choose>
                            <c:when test="${JKXFK=='1'}">
                                <td class="coltext">报告单位</td>
                                <td colspan="2">
                                    <ehr:org-type-list id="reportUnitCode" name="reportUnitCode" type="other,centre"
                                                       value="${reportUnitCode}" code="${reportUnitCode}" width="220px"
                                                       codeOther="${JK_CODE}" cssClass="x-layui-input"/>
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td></td>
                                <td></td>
                                <td></td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                    <tr class="advanceSearchSection" style="display: none;">
                        <td class="coltext">DDIA检查日期</td>
                        <td class="colinput">
                            <%-- <tag:dateInput nullToToday="false" id="ddiaBeginDt" name="ddiaBeginDt" pattern="yyyy/MM/dd"  onlypast="true" style="width: 36%;"></tag:dateInput>
                            ~<tag:dateInput nullToToday="false" id="ddiaEndDt" name="ddiaEndDt" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 36%;"
                                            reg='{"compare":["ddiaBeginDt","ge","结束时间不能早于开始时间"]}'></tag:dateInput> --%>

                            <input type="text" class="layui-input x-admin-sm-date" name="ddiaBeginDt" id="ddiaBeginDt"
                                   style="padding-left: 0px;width: 36%;"/> ~
                            <input type="text" reg='{"compare":["ddiaBeginDt","ge","结束时间不能早于开始时间"]}'
                                   class="layui-input x-admin-sm-date" name="ddiaEndDt" id="ddiaEndDt"
                                   style="padding-left: 0px;width: 36%;"/>
                        </td>
                        <td colspan="3"></td>
                    </tr>
                    <tr>
                        <td colspan="6" class="righttd">
                            <%-- <input type="button" id="registerBtnSearch" value="查询" onclick="" class="search_btn"/> --%>
                            <button class="layui-btn layui-btn-sm" id="registerBtnSearch"><i
                                    class="layui-icon">&#xe615;</i>查询
                            </button>
                            <%-- <input type="button" id="registerBtnExport" value="导出" onclick="" class="search_btn"/> --%>
                            <button class="layui-btn layui-btn-sm" id="registerBtnExport"><i
                                    class="layui-icon">&#xe67d;</i>导出
                            </button>
                            <button class="layui-btn layui-btn-sm" id="perAdvanceSearchConditionBtn" ><i class="iconfont">&#x60010;</i>高级</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <table>
                    <tr>
                        <td colspan="6" class="colbottom">
                            <span onclick="schIndex.toggle(this,'registerSearch')" class="ico-bottom">&nbsp;</span>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="toolbarSection x-admin-sm">
            <a href="javascript:void(0)" onclick='javascript:registerSearch.addRegister("add","Other")'>
                <button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>暂住登记</button>
            </a>
            <a href="javascript:void(0)" onclick='javascript:registerSearch.addRegister("add","Local")'>
                <button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>本地登记</button>
            </a>
            <c:if test="${ZXXXC=='1'}">
                <a href="javascript:void(0)" onclick="javascript:registerSearch.batchApproval()">
                    <button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>一键通过</button>
                </a>
            </c:if>
        </div>
        <div id="registerResultDiv"></div>
    </div>
    <div id="registerdetailDiv"></div>

<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#ddiaBeginDt'
            , format: 'yyyy/MM/dd'
            , max: 0
        });

        laydate.render({
            elem: '#ddiaEndDt'
            , format: 'yyyy/MM/dd'
            , max: 0
        });


    });

</script>
