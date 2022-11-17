<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<c:set var="ZXJFYS" value="<%=RoleType.ZXJFYS.getValue()%>"/>
<script src="${pageContext.request.contextPath}/js/util/jquery.jqprint-0.3.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/mhm/management/followUp/main.js" type="text/javascript"></script>
<%--随访记录--%>
<div class="toolbar" style="margin-top: 8px;">
	<c:choose>
		<c:when test="${not empty searchType}">
			<a href="javascript:void(0)" id="sf_return"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
		</c:when>
		<c:otherwise>
			<a href="javascript:void(0)" id="return"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
		</c:otherwise>
	</c:choose>	<ehr:authorize ifAnyGranted="${ZXJFYS}">
		<!-- <a href="javascript:void(0)" id="pass" ><b class="tongguo">通过</b></a> -->
		<a href="javascript:void(0)" id="pass" style="display: none"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe605;</i>通过</button></a>
		<!-- <a href="javascript:void(0)" id="reject" ><b class="zuofei">不通过</b></a> -->
		<a href="javascript:void(0)" id="reject" style="display: none"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#x1006;</i>不通过</button></a>
	</ehr:authorize>
	<!-- <a href="javascript:void(0)" id="add" ><b class="xinz">新增</b></a> -->
	<a href="javascript:void(0)" id="add" style="display: none"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe608;</i>新增</button></a>
	<%--<a href="javascript:void(0)" id="update" ><b class="xiug">修改</b></a>--%>
	<!-- <a href="javascript:void(0)" id="update" ><b class="baocun">保存</b></a> -->
	<a href="javascript:void(0)" id="update" style="display: none" ><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe605;</i>保存</button></a>
	<!-- <a href="javascript:void(0)" id="save" ><b class="baocun">保存</b></a> -->
	<a href="javascript:void(0)" id="save" style="display: none"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe605;</i>保存</button></a>
	<!-- <a href="javascript:void(0)" id="delete" ><b class="zuofei">删除</b></a> -->
	<a href="javascript:void(0)" id="delete" style="display: none"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe640;</i>删除</button></a>
	<a href="javascript:void(0)" id="button_print" style="margin-top: 3.5px;"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe66d;</i>打印</button></a>

</div>
<div class="divFixed105" style="${not empty searchType ? 'top:65px;':'115px;'}">
    <input type="hidden" id="statusId" value="${statusId}">
	<input type="hidden" id="nextFollowUpFlag" value="${nextFollowUpFlag}">
    <table>
    	<colgroup>
			<col style="min-width:200px;width:25%"/>
			<col style="min-width:350px;width:75%"/>
		</colgroup>	
		<tr>
			<td style="vertical-align: top;">
				<input type="hidden" id="followUpPageIndex" value="${pageIndex}">
				<form id="followUpListForm">
				</form>
				<div id="followUpListDiv"></div>
			</td>
			<td>
				<div id="followUpDiv"></div>
    		</td>
		</tr>	    
    </table>
</div>

