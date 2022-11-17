<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/cdm/standardization/followup/list.js"
        type="text/javascript"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/readcard/baseISSObject.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/readcard/baseISSOnline.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/readcard/common.js"></script>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKMBK" value="<%=RoleType.JKMBK.getValue()%>"/>
<c:set var="ZXMB" value="<%=RoleType.ZXMB.getValue()%>"/>
<c:set var="ZMB" value="<%=RoleType.ZMB.getValue()%>"/>

<div class="section" id="cdm-manage-list-box">
    <div class="toolbar">
    	<div class="x-nav">
	      <span class="layui-breadcrumb">
	        <a href="javascript:void(0)">慢病健康管理</a>
	        <a href="javascript:void(0)">慢病规范化管理</a>
	        <a>
	          <cite>随访管理</cite></a>
	      </span>
    </div>
    </div>
    <p id="cert_message" class="msgError" style="display: none;"></p>
    <p id="cert_message_type" style="display: none;"></p>
    <div class="searchbox searchSection x-admin-sm">
        <form method="post" id="form_search">
            <input type="hidden" id="fromHomeId" name="fromHome" value="${fromHome}">
            <input type="hidden" id="followupStatus" name="followupFlag" value="${followupFlag}">
            <table id="health-card-search-table">
                <colgroup>
                    <col style="width:10%">
                    <col style="width:23%">
                    <col style="width:10%">
                    <col style="width:23%">
                    <col style="width:10%">
                    <col style="width:24%">
                </colgroup>
                <tbody>
                <tr>
                    <td class="coltext">姓名</td>
                    <td class="colinput"><input type="text" name="name" id="personName" class="x-layui-input"/></td>
                    <td class="coltext">身份证号</td>
                    <td class="colinput"><tag:idcardInput name="idcard" style="ime-mode:Disabled;" id="text_idcard"
                                                          cssClass="x-layui-input"></tag:idcardInput>
                        <input type="button" value="读卡" id="button_read" onclick="new Device().startFun()"
                               style="width: 40px;"/>
                    </td>
                    <td class="coltext">患病类型</td>
                    <td class="colinput">
                        <div class="layui-form">
                            <ehr:dic-list width="156px" type="true" id="disTypeSelect" name="diseaseType"
                                          dicmeta="DMD00004" cssClass="x-layui-input"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="coltext">年龄段</td>
                    <td class="colinput">
                        <tag:numberInput maxlength="3" id="startAge" name="startAge" style="width:35%"
                                         cssClass="x-layui-input"></tag:numberInput> ~
                        <tag:numberInput maxlength="3" id="endAge" name="endAge" style="width:35%"
                                         cssClass="x-layui-input"></tag:numberInput>岁
                    </td>
                    <td class="coltext">随访时间</td>
                    <td class="colinput">
                        <%-- <tag:dateInput name="followupDateStart" onlypast="true" style="width:35%;"/> ~
                        <tag:dateInput name="followupDateEnd" onlypast="true" style="width:35%;"/> --%>
                        <input type="text" class="layui-input x-admin-sm-date" name="followupDateStart"
                               id="followupDateStart" style="width: 38%;padding-left:0px;"> ~
                        <input type="text" class="layui-input x-admin-sm-date" name="followupDateEnd"
                               id="followupDateEnd" style="width: 38%;padding-left: 0px;">
                    </td>

                    <td class="coltext">随访次数</td>
                    <td class="colinput">
                        <select name="followupCountCompareType" style="width: 100px;">
                            <option value="3">大于等于</option>
                            <option value="2">等于</option>
                            <option value="1">小于等于</option>
                        </select>
                        <tag:numberInput style="width:40px;" name="followupCount"/>
                    </td>
                </tr>

                <tr class="advanceSearchSection" style="display: none;">
                    <td class="coltext">性别</td>
                    <td class="colinput">
                        <ehr:dic-list dicmeta="GBT226112003" name="gender" id="genderCode"/>
                    </td>
                    <td class="coltext">随访医生</td>
                    <td class="colinput">
                        <input type="text" name="doctorCode"/>
                    </td>
                    <td class="coltext">下次随访时间</td>
                    <td class="colinput">
                        <%-- <tag:dateInput name="nextFollowupDate"/> --%>
                        <input class="layui-input x-admin-sm-date" placeholder="选择时间" name="nextFollowupDate"
                               id="nextFollowupDate" style="width: 38%;">
                    </td>
                </tr>
                <tr class="advanceSearchSection" style="display: none;">
                    <td class="coltext">现住居委会</td>
                    <td class="colinput">
                        <ehr:dic-town-street-village townName="patownShip" streetName="paStreet" width="50%"/>
                    </td>
                    <td class="coltext">
                        <ehr:authorize ifAnyGranted="${JKMBK},${ADMIN},${ZXMB}">管理机构</ehr:authorize>
                    </td>
                    <td colspan="2">
                        <ehr:authorize ifAnyGranted="${JKMBK},${ADMIN}">
                            <ehr:dic-town-centre-station centreName="centerOrganCode" stationName="stationOrganCode"
                                                         townName="gbcode" isShowOneself="true" width="25%;"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="${ZXMB}">
                            <ehr:dic-org-list id="nowAddressCode" name="stationOrganCode" width="30%;"
                                              isShowOneself="true"></ehr:dic-org-list>
                        </ehr:authorize>
                    </td>
                </tr>
                <tr>
                    <td class="righttd" colspan="6">
                        <%-- <input type="button" id="per_search_btn" value="查询" onclick="" class="search_btn"/> --%>
                        <button class="layui-btn layui-btn-sm" id="per_search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
						<button class="layui-btn layui-btn-sm" id="perAdvanceSearchConditionBtn"  ><i class="iconfont">&#x60010;</i>高级</button>
                    </td>
                </tr>

                </tbody>
            </table>
            <ehr:authorize ifAnyGranted="${ZXMB},${ZMB}">
                <table>
                    <colgroup>
                        <col style="min-width: 10px;width:2%">
                        <col style="width:96%">
                        <col style="min-width: 10px;width:2%">

                    </colgroup>
                    <tr>
                        <td></td>
                        <td class="collink">
                            <div id="dm-followup-links">
                                <a class="to-followup-link" href="javascript:void(0)" data-followupflag="4">过期待访(<label
                                        id="expire-to-followup"></label>)</a>
                                <a class="to-followup-link" href="javascript:void(0)" data-followupflag="1">本日待访(<label
                                        id="today-to-followup"></label>)</a>
                                <a class="to-followup-link" href="javascript:void(0)" data-followupflag="2">7天内待访(<label
                                        id="week-followup"></label>)</a>
                                <a class="to-followup-link" href="javascript:void(0)"
                                   data-followupflag="3">30天内待访(<label id="month-to-followup"></label>)</a>
                            </div>
                        </td>
                        <td></td>

                    </tr>
                </table>
            </ehr:authorize>
            <table>
                <tr>
                    <td colspan="6" class="colbottom">
                        <span id="health-card-search-toggle-btn" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <ehr:authorize ifAnyGranted="${ZXMB},${ZMB}">
        <div class="toolbarSection">
                <%-- <a href="javascript:void(0)" id="person-export-btn"><b class="export">导出人员</b></a>
                    <a href="javascript:void(0)" id="plan-export-btn"><b class="export">导出计划</b></a>
                    <a href="javascript:void(0)" id="followup-export-btn"><b class="export">导出详情</b></a> --%>
            <a href="javascript:void(0)" id="person-export-btn"><button class="layui-btn layui-btn-sm button" ><i class="layui-icon">&#xe67d;</i>导出人员</button></a>
            <a href="javascript:void(0)" id="plan-export-btn"><button class="layui-btn layui-btn-sm button" ><i class="layui-icon">&#xe67d;</i>导出计划</button></a>
            <a href="javascript:void(0)" id="followup-export-btn"><button class="layui-btn layui-btn-sm button" ><i class="layui-icon">&#xe67d;</i>导出详情</button></a>
        </div>
    </ehr:authorize>
    <div id="diseaseInfo" class="repeattable">
    </div>
</div>
<div id="cdm-manage-input-box">
</div>
<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#followupDateStart'
            , format: 'yyyy/MM/dd'
            , max: 0
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#followupDateEnd'
            , format: 'yyyy/MM/dd'
            , max: 0
        });

        laydate.render({
            elem: '#nextFollowupDate'
            , format: 'yyyy/MM/dd'
            , max: 0
        });

    });

    layui.config({
        base: layui.cache.dir + 'lay/modules/',  //实际的multiSelect.JS文件位置,也可以用<script>引入
    });
    layui.use(['multiSelect'], function () {
        var $ = layui.jquery, form = layui.form, multiSelect = layui.multiSelect;
        $('#get-val').click(function () {
            var vals = [],
                texts = [];
            $('select[multiple] option:selected').each(function () {
                vals.push($(this).val());
                texts.push($(this).text());
            })
            console.dir(vals);
            console.dir(texts);
        })
        form.on('select(test)', function (data) {
            console.dir(data);
        });
    });


</script>