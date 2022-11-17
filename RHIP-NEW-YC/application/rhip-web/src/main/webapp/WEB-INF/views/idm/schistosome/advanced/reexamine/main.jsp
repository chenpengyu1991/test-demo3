<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/idm/schistosome/reexamineMain.js" type="text/javascript"></script>
<div class="toolbar">
	<!-- <a href="javascript:void(0)" onclick="javascript:advancedSearch.returnSearch()"><b class="fanhui">返回</b></a> -->
	<a href="javascript:void(0)"  id="reexamineReturn" style="display: none"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<c:if test="${logoff != '1'}">
		<%-- <a href="javascript:void(0)" onclick="javascript:reexamineMain.add(${idmId})" id="add" ><b class="xinz">新增</b></a> --%>
		<a href="javascript:void(0)" onclick="javascript:reexamineMain.add(${idmId})"  id="reexamineAdd" style="display: none"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
		<%--<a href="javascript:void(0)" onclick="javascript:reexamineMain.save()" id="update" style="display: none"><b class="xiug">修改</b></a>--%>
		<!-- <a href="javascript:void(0)" onclick="javascript:reexamineMain.save()" id="update" style="display: none"><b class="baocun">保存</b></a> -->
		<a href="javascript:void(0)"  id="reexamineUpdate" style="display: none"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
		<!-- <a href="javascript:void(0)" onclick="javascript:reexamineMain.save()" id="save" style="display: none"><b class="baocun">保存</b></a> -->
		<a href="javascript:void(0)" id="reexamineSave" style="display: none"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
		<!-- <a href="javascript:void(0)" onclick="javascript:reexamineMain.deleteReexamine()" id="delete" style="display: none"><b class="zuofei">删除</b></a> -->
		<a href="javascript:void(0)" id="reexamineDelete" style="display: none"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe640;</i>删除</button></a>
	</c:if>
</div>
<div id="reexamineMain" class="divFixed125">
    <input type="hidden" id="idmId" value="${idmId}">
    <input type="hidden" id="logoff" value="${logoff}"/>
    <table>
		<tr>
			<td style="vertical-align: top; width: 300px; margin-left: 10px; margin-top: 30px;">
				<%--<fieldset>--%>
					<%--<legend>复查列表</legend>--%>
					<input type="hidden" id="pageIndex" value="${pageIndex}">
					<form id="reexamineListForm">
					</form>
					<div id="reexamineListDiv"></div>
				<%--</fieldset>				--%>
			</td>
			<td>
				<div id="reexamineDiv"></div>
    		</td>
		</tr>	    
    </table>
</div>

