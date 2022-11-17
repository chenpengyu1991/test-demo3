<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="ZX_GLY" value="<%=RoleType.ZX_GLY.getValue()%>"/>
<c:set var="Z_GLY" value="<%=RoleType.Z_GLY.getValue()%>"/>
<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>"/>
<c:set var="ZXCRB" value="<%=RoleType.ZXCRB.getValue()%>"/>
<c:set var="ZCRB" value="<%=RoleType.ZCRB.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/phsr/infectEmergCensus/search.js" type="text/javascript"></script>

<div class="section">

    <div class="toolbar">
        <div class="toolbar">
			<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>
		        <a href="javascript:void(0)">公卫服务监管</a>
		        <a>
		          <cite>传染病及突发公共卫生事件报告和处理统计报表</cite></a>
		      </span>
		</div>
    </div>

    <div class="searchBox searchSection x-admin-sm">
        <form id="infectEmergCensusForm">
            <table id="infectEmergCensus">
                <colgroup>
                    <col style="width: 50px;" />
                    <col style="width: 80px;" />
                    <col style="width: 50px;" />
                    <col style="width: 60px;" />
                    <col style="width: 50px;" />
                    <col style="width: 200px;" />
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text"><label>时间范围</label></td>
                    <td class="col-input" colspan="4">
                        <input type="radio" id="mhmReprtYearId" name="countType"  class="radioGroup" value="1" checked="checked" onclick="infectEmergCensus.changeReportType()"/><label for="mhmReprtYearId">按年</label>
                        <input type="radio" id="mhmReprtQuarterId" name="countType"  class="radioGroup" value="2" onclick="infectEmergCensus.changeReportType()"/><label for="mhmReprtQuarterId">按季度</label>
                        <%-- <tag:dateInput nullToToday="true" id="reportYearId" name="year" pattern="yyyy"  date="${searchDate}" onlypast="true" reg='{"required":"true"}' style="width: 100px;"/> --%>
                        <input type="text" reg='{"required":"true"}' class="layui-input x-admin-sm-date" style="width:100px;padding-left: 0px;" name="year" id="reportYearId" value="<fmt:formatDate value='${searchDate}' pattern='yyyy'/>" />
                        <select id="reportQuarter" name="quarter" style="width: 100px;display:none" class="x-layui-input">
                            <option value="">请选择</option>
                            <option value="1">第一季度</option>
                            <option value="2">第二季度</option>
                            <option value="3">第三季度</option>
                            <option value="4">第四季度</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="col-text">机构</td>
                    <td class="col-input" colspan="4">
                        <ehr:authorize ifAnyGranted="01,0111,12">
                            <ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode" townName="gbcode" width="130px;" isShowOneself="true" cssClass="x-layui-input"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="04,0411,0311">
                            <%--<ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode" townName="gbcode" width="130px;" isShowOneself="true" includeTownCodes="${currentLoginInfo.organization.gbCode}"/>--%>
                            <ehr:dic-org-list name="orgCode" width="150px" isShowOneself="true" cssClass="x-layui-input"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="02,0211,03">
                            <ehr:dic-org-list name="orgCode" width="150px" isShowOneself="true" cssClass="x-layui-input"/>
                        </ehr:authorize>
                    </td>

                    <td style="text-align: right;"><!-- <input type="button" id="infectEmergCensusSearch" value="查询" class="search_btn" /> -->
                    <button class="layui-btn layui-btn-sm" id="infectEmergCensusSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                    </td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="4" class="colbottom"><span
                            onclick="infectEmergCensus.toggle(this,'infectEmergCensus')"
                            class="ico-bottom">&nbsp;</span></td>
                </tr>
            </table>
        </form>
    </div>
    <div class="toolbarSection x-admin-sm">
<a id="infectEmergCensusListDivExport" href="javascript:void(0)"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
        <ehr:authorize ifAnyGranted="${ZX_GLY},${Z_GLY},${ZXCRB},${ZCRB}">
	        <span id="modifyInfectEmer">
	            <!-- <a href="javascript:void(0)" id="modify" ><b class="xiug">修改</b></a> -->
	            <a href="javascript:void(0)" id="modify"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe642;</i>修改</button></a>
	        </span>
	        <span id="cancelInfectEmer">
	            <!-- <a href="javascript:void(0)" id="cancel" ><b class="quxiao">取消</b></a> -->
	            <a href="javascript:void(0)" id="cancel" ><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#x1006;</i>取消</button></a>
	            <!-- <a href="javascript:void(0)" id="save" ><b class="baocun">保存</b></a> -->
	            <a href="javascript:void(0)" id="save"  ><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe605;</i>保存</button></a>
	        </span> 
        </ehr:authorize>
        </div>
        
    <div id="infectEmergCensusListDiv">
		<jsp:include page="list.jsp"/>
    </div>
</div>
</div>