<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ZXJFYS" value="<%=RoleType.ZXJFYS.getValue()%>"/>
<c:set var="JKJFZX" value="<%=RoleType.JKJFZX.getValue()%>"/>


<script src="${pageContext.request.contextPath}/js/views/mhm/management/casePlan/main.js" type="text/javascript"></script>
<%--个案管理计划原型--%>
<div class="toolbar" style="margin-top: -8px;">
    <!-- <a href="javascript:void(0)" onclick="javascript:mhmCommon.returnSearch(managementSearch.search)"><b class="fanhui">返回</b></a> -->
    <a href="javascript:void(0)" onclick="javascript:mhmCommon.returnSearch(managementSearch.search)" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    <ehr:authorize ifAnyGranted="${ZXJFYS},${JKJFZX}">
        <!-- <a href="javascript:void(0)" onclick="javascript:casePlanMain.add()" id="addCase"><b class="xinz">新增</b></a> -->
        <a href="javascript:void(0)" onclick="javascript:casePlanMain.add()" id="addCase"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe608;</i>新增</button></a>
        <%--<a href="javascript:void(0)" onclick="javascript:casePlanMain.save()" id="updateCase"><b class="xiug">修改</b></a>--%>
        <!-- <a href="javascript:void(0)" onclick="javascript:casePlanMain.save()" id="updateCase"><b class="baocun">保存</b></a> -->
        <a href="javascript:void(0)" onclick="javascript:casePlanMain.save()" id="updateCase"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe605;</i>保存</button></a>
        <!-- <a href="javascript:void(0)" onclick="javascript:casePlanMain.save()" id="saveCase"><b class="baocun">保存</b></a> -->
        <a href="javascript:void(0)" onclick="javascript:casePlanMain.save()" id="saveCase"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe605;</i>保存</button></a>
        <!-- <a href="javascript:void(0)" onclick="javascript:casePlanMain.deleteCasePlan()" id="deleteCase"><b class="zuofei">删除</b></a> -->
        <a href="javascript:void(0)" onclick="javascript:casePlanMain.deleteCasePlan()" id="deleteCase"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe605;</i>删除</button></a>
    </ehr:authorize>
</div>
<div class="divFixed105">
    <input type="hidden" id="statusId" value="${statusId}">
    <input type="hidden" id="pageIndex" value="${pageIndex}">
    <input type="hidden" id="bringIntoMode" value="${bringIntoMode}">

    <table>
    	<colgroup>
			<col style="min-width:150px;width:10%"/>
			<col style="min-width:350px;width:90%"/>
		</colgroup>	
		<tr>
			<td style="vertical-align: top;">
				<div id="casePlanListDiv"></div>
			</td>
			<td>
				<div id="casePlanDiv"></div>
    		</td>
		</tr>	    
    </table>
</div>

