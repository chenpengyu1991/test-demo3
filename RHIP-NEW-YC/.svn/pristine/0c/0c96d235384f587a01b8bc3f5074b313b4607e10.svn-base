<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKJFZX" value="<%=RoleType.JKJFZX.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/mhm/management/emergency/main.js" type="text/javascript"></script>
<%--应急处置--%>
<div class="toolbar" style="margin-top: -8px;">
    <!-- <a href="javascript:void(0)" onclick="javascript:mhmCommon.returnSearch(managementSearch.search)"><b class="fanhui">返回</b></a> -->
    <a href="javascript:void(0)" onclick="javascript:mhmCommon.returnSearch(managementSearch.search)" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    <ehr:authorize ifAnyGranted="${JKJFZX}">
        <!-- <a href="javascript:void(0)" onclick="javascript:emergencyMain.add()" id="addE" ><b class="xinz">新增</b></a> -->
        <a href="javascript:void(0)" onclick="javascript:emergencyMain.add()" id="addE"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
        <%--<a href="javascript:void(0)" onclick="javascript:emergencyMain.save()" id="updateE" ><b class="xiug">修改</b></a>--%>
        <!-- <a href="javascript:void(0)" onclick="javascript:emergencyMain.save()" id="updateE" ><b class="baocun">保存</b></a> -->
        <a href="javascript:void(0)" onclick="javascript:emergencyMain.save()" id="updateE"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
        <!-- <a href="javascript:void(0)" onclick="javascript:emergencyMain.save()" id="saveE" ><b class="baocun">保存</b></a> -->
        <a href="javascript:void(0)" onclick="javascript:emergencyMain.save()" id="saveE"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
        <!-- <a href="javascript:void(0)" onclick="javascript:emergencyMain.deleteEmergency()" id="deleteE" ><b class="zuofei">删除</b></a> -->
        <a href="javascript:void(0)" onclick="javascript:emergencyMain.deleteEmergency()" id="deleteE" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>删除</button></a>
    </ehr:authorize>
</div>
<div class="divFixed105">
    <input type="hidden" id="statusId" value="${statusId}">
    <input type="hidden" id="pageIndex" value="${pageIndex}">
    <table>
    	<colgroup>
			<col style="min-width:150px;width:10%"/>
			<col style="min-width:350px;width:90%"/>
		</colgroup>	
		<tr>
			<td style="vertical-align: top;">
				<input type="hidden" id="pageIndex" value="${pageIndex}">
				<div id="emergencyListDiv"></div>
			</td>
			<td>
				<div id="emergencyDiv"></div>
    		</td>
		</tr>	    
    </table>
</div>

