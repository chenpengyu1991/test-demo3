<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@page import="com.founder.rhip.ehr.common.EHRConstants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKWJ" value="<%=RoleType.JKWJ.getValue()%>"/>
<c:set var="QWGZX" value="<%=RoleType.QWGZX.getValue()%>"/>
<script src="${pageContext.request.contextPath}/js/views/hsa/common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/hsa/location/list/list.js" type="text/javascript"></script>
<input type="hidden" id="hsa-insp-record-type" value="${type}">

<div class="section" id="hsa-record-locationList-box">
    <div class="toolbar">
    	<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">卫生计生监督协管</a>
		        <a>
		          <cite>基础档案管理</cite></a>
		      </span>
		</div>
    </div>
    <div class="searchbox searchSection x-admin-sm">
        <form method="post" id="form_search">
            <input class="hide">
            <table id="hsa-recordLocation-recordSearchBox">
                <colgroup>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 100px; width: 15%;"/>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 100px; width: 15%;"/>
                    <col style="min-width: 70px; width: 10%;"/>
                    <col style="min-width: 100px; width: 15%;"/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="coltext">卫生专业</td>
                    <td>
                        <ehr:dic-list dicmeta="HSA00006" uninclude="1,4,99" parentCode="0" id="hsa-inspection-location-healthProfessional" name="healthProfessional"/></td>
                    <td class="coltext">行业分类</td>
                    <td class="colinput"><select id="hsa-inspection-location-mainBusinessCode" name="mainBusinessCode">
                        <option value="">请选择</option>
                    </select>
                    </td>
                    <%--<td class="coltext">乡镇地段</td>
                    <td><ehr:dic-list name="townshipLotCode" dicmeta="HSA00005"/>
                    </td> --%>
                     <td class="coltext">状态</td>
                    <td colspan="1">
                        <label><input type="radio" checked="checked" value="<%=EHRConstants.LOCATION_DATA_STATUS_NORMAL%>" name="locationStatus">正常</label>
                        <label><input type="radio" value="<%=EHRConstants.LOCATION_DATA_STATUS_CANCEL%>" name="locationStatus">已注销</label>
                    </td>
                </tr>

                <tr>
                    <td class="coltext">单位名称</td>
                    <td class="colinput"><input type="text" name="unitName" class="x-layui-input">
                    </td>
                    <td class="coltext">法人/负责人</td>
                    <td class="colinput"><input type="text" name="personInCharge" class="x-layui-input"></td>

                    <td class="coltext">许可到期情况</td>
                    <td class="colinput">
                        <select name="dueDateType" style="width:50%;" class="x-layui-input">
                            <option value="">全部记录</option>
                            <option value="1">二个月以上到期</option>
                            <option value="2">二个月内到期</option>
                            <option value="3">一个月内到期</option>
                            <option value="4">已过期</option>
                        </select>
                    </td>

                </tr>
                <tr class="advanceSearchSection" style="display: none;">
                    <td class="coltext">巡查次数</td>
                    <td class="colinput"><select name="inspCountType" class="x-layui-input">
                        <option value="">全部记录</option>
                        <option value="1">0次</option>
                        <option value="2">1次</option>
                        <option value="3">2次</option>
                        <option value="4">3次</option>
                        <option value="5">大于3次</option>
                    </select></td>
                    <td class="coltext">指导次数</td>
                    <td class="colinput"><select name="guideCountType" class="x-layui-input">
                        <option value="">全部记录</option>
                        <option value="1">0次</option>
                        <option value="2">1次</option>
                        <option value="3">大于1次</option>
                    </select></td>
                    </td>
                </tr>
                <ehr:authorize ifAnyGranted="${ADMIN},${JKWJ},${QWGZX}">
                    <tr class="advanceSearchSection" style="display: none;">
                        <td class="coltext">录入机构</td>
                        <td class="colinput" colspan="2">
                            <ehr:dic-town-centre-station centreName="createOrganCode" townName="gbcode" isShowOther="true" width="180px;" cssClass="x-layui-input"/>
                        </td>
                    </tr>

                </ehr:authorize>
                <tr>
                    <td colspan="5"></td>
                    <td>
                        <button class="layui-btn layui-btn-sm" id="hsa-inspRecord-locationList-search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
                        <button class="layui-btn layui-btn-sm" id="gjBtn"  ><i class="iconfont">&#x60010;</i>高级</button>
                    </td>
                </tr>

                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="6" class="colbottom"><span onclick="HsaCommon.toggle(this,'hsa-recordLocation-recordSearchBox')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div class="toolbarSection">
        <ehr:authorize ifNotGranted="${ADMIN}">
            <!-- <a href="javascript:void(0)" id="hsa-location-add-btn"><b class="xinz">新增</b></a> -->
            <a href="javascript:void(0)" id="hsa-location-add-btn"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
        </ehr:authorize>
        <!-- <a href="javascript:void(0)" id="hsa-location-export-btn"><b class="export">导出</b></a> -->
        <a href="javascript:void(0)" id="hsa-location-export-btn"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
    </div>
    <div id="hsa-record-result-locationList" class="repeattable"></div>
</div>
<div id="hsa-record-location-input-add" class="postdiv"></div>
