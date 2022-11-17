<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKMBK" value="<%=RoleType.JKMBK.getValue()%>"/>
<c:set var="ZXMB" value="<%=RoleType.ZXMB.getValue()%>"/>
<c:set var="ZMB" value="<%=RoleType.ZMB.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/cdm/standardization/healthCard/list.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/readcard/baseISSObject.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/readcard/baseISSOnline.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/readcard/common.js"></script>
<div class="section" id="cdm-manage-list-box">
        <div class="toolbar">
        	<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">慢病健康管理</a>
		        <a href="javascript:void(0)">慢病规范化管理</a>
		        <a>
		          <cite>慢病管理卡</cite></a>
		      </span>
    </div>
        </div>
    <p id="cert_message" class="msgError" style="display: none;"></p>
    <p id="cert_message_type" style="display: none;"></p>
    <div class="searchbox searchSection x-admin-sm">
        <form method="post" id="form_search">
            <table id="health-card-search-table">
                <colgroup>
                    <col style="min-width: 70px;width:10%">
                    <col style="min-width: 140px;width:23%">
                    <col style="min-width: 70px;width:10%">
                    <col style="min-width: 140px;width:23%">
                    <col style="min-width: 70px;width:10%">
                    <col style="min-width: 140px;width:24%">
                </colgroup>
                <tbody>
                <tr>
                    <td class="coltext">姓名</td>
                    <td class="colinput"><input type="text" name="name" id="personName"/></td>
                    <td class="coltext">身份证号</td>
                    <td class="colinput">
                        <tag:idcardInput name="idcard" style="ime-mode:Disabled;" id="text_idcard" cssClass="x-layui-input"></tag:idcardInput>
                        <input type="button" value="读卡" id="button_read" onclick="new Device().startFun()" style="width: 40px;">
                    </td>
                    <td class="coltext">患病类型</td>
                    <td class="colinput" >
                        <div class="layui-form">
                            <ehr:dic-list width="156px" type="true" id="disTypeSelect" name="diseaseType" dicmeta="DMD00004" value="${diseaseType}" />
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="coltext">年龄段</td>
                    <td class="colinput">
                        <tag:numberInput maxlength="3" name="startAge" id="startAge" style="width:38%" cssClass="x-layui-input"></tag:numberInput> ~
                        <tag:numberInput maxlength="3" name="endAge" id="endAge" style="width:38%" cssClass="x-layui-input"></tag:numberInput>岁
                    </td>

                    <td class="coltext">性别</td>
                    <td class="colinput">
                        <ehr:dic-list dicmeta="GBT226112003" name="gender" id="genderCode" cssClass="x-layui-input"/>
                    </td>
                    <td class="coltext">是否管理</td>
                    <td class="colinput">
                        <ehr:dic-radio isDefault="Y" dicmeta="FS10246" name="isManagedFlag" value="${isManagedFlag}"/>
                    </td>

                </tr>

                <tr class="advanceSearchSection" style="display: none;">
                    <td class="coltext">纳入时间</td>
                    <td class="colinput">
                        <%-- <tag:dateInput name="managedDateStart" onlypast="true" style="width:35%;"/> ~
                        <tag:dateInput name="managedDateEnd" onlypast="true" style="width:35%;"/> --%>
                        <input type="text" class="layui-input x-admin-sm-date"  name="managedDateStart" id="managedDateStart" style="width: 38%;padding-left: 0px;"> ~
                            <input type="text" class="layui-input x-admin-sm-date"  name="managedDateEnd" id="managedDateEnd" style="width: 38%;padding-left: 0px;">
                    </td>
                    <td class="coltext">
                        <ehr:authorize ifAnyGranted="${ADMIN},${JKMBK},${ZXMB}">管理机构</ehr:authorize>
                    </td>
                    <td colspan="2">
                        <ehr:authorize ifAnyGranted="${ADMIN},${JKMBK}">
                            <ehr:dic-town-centre-station centreName="centerOrganCode" stationName="stationOrganCode" townName="gbcode" isShowOneself="true" width="37.5%" cssClass="x-layui-input"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="${ZXMB}">
                            <ehr:dic-org-list id="nowAddressCode" name="stationOrganCode" width="50%;" isShowOneself="true" cssClass="x-layui-input"/>
                         </ehr:authorize>
                    </td>

                    <%--<td align="left">
                        <input type="button" id="per_search_btn" value="查询" onclick="" class="search_btn"/>
                    </td>
                    </td>--%>
                </tr>
                <tr class="advanceSearchSection" style="display: none;">
                    <td class="coltext">现住居委会</td>
                    <td class="colinput">
                        <ehr:dic-town-street-village townName="patownShip" streetName="paStreet" width="50%" cssClass="x-layui-input"/>
                    </td>
                    <td colspan="4"></td>

                </tr>
                <tr>
                    <td colspan="6" class="righttd">
                        <%-- <input type="button" id="per_search_btn" value="查询" onclick="" class="search_btn"/> --%>
                        <button class="layui-btn layui-btn-sm" id="per_search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
                        <button class="layui-btn layui-btn-sm" id="perAdvanceSearchConditionBtn"><i class="iconfont">&#x60010;</i>高级</button>
                    </td>
                </tr>

                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="6" class="colbottom">
                        <span id="health-card-search-toggle-btn" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div class="toolbarSection">
        <ehr:authorize ifAnyGranted="${ZXMB},${ZMB}">
            <%--            <a href="javascript:void(0)" id="cdm-manage-input-btn"><b class="xinz">新增</b></a>--%>
            <a id="cdm-manage-input-btn"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>

            <%-- <a href="javascript:void(0)" id="cdm-manage-export-btn"><b class="export">导出</b></a> --%>
            <a href="javascript:void(0)" id="cdm-manage-export-btn"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
        </ehr:authorize>
    </div>
    <div id="diseaseInfo" class="repeattable"></div>
</div>
<div id="cdm-manage-input-box"></div>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
          elem: '#managedDateStart'
       	   ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#managedDateEnd'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });

      });

    layui.config({
        base: layui.cache.dir+'lay/modules/',  //实际的multiSelect.JS文件位置,也可以用<script>引入
    });
    layui.use(['multiSelect'],function() {
        var $ = layui.jquery,form = layui.form,multiSelect = layui.multiSelect;
        $('#get-val').click(function() {
            var vals = [],
                texts = [];
            $('select[multiple] option:selected').each(function() {
                vals.push($(this).val());
                texts.push($(this).text());
            })
            console.dir(vals);
            console.dir(texts);
        })
        form.on('select(test)',function(data){
            console.dir(data);
        });
    });


    </script>