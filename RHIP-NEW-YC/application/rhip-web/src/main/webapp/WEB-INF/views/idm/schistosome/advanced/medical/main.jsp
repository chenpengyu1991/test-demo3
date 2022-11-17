<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/idm/schistosome/medicalMain.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" onclick="javascript:advancedSearch.returnSearch()"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<!-- <a href="javascript:void(0)" onclick="javascript:advancedSearch.returnSearch()"><b class="fanhui">返回</b></a> -->
	<c:if test="${logoff != '1'}">
		<a href="javascript:void(0)" onclick="javascript:medicalMain.add(${idmId})" id="add" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
		<%-- <a href="javascript:void(0)" onclick="javascript:medicalMain.add(${idmId})" id="add" ><b class="xinz">新增</b></a> --%>
		<%--<a href="javascript:void(0)" onclick="javascript:medicalMain.save()" id="update" style="display: none"><b class="xiug">修改</b></a>--%>
		<a href="javascript:void(0)" onclick="javascript:medicalMain.save()" id="update" style="display: none"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
		<a href="javascript:void(0)" onclick="javascript:medicalMain.save()" id="save" style="display: none"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
		<a href="javascript:void(0)" onclick="javascript:medicalMain.deleteMedical()" id="delete" style="display: none"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe640;</i>删除</button></a>
	</c:if>
</div>
<div id="medicalMain" class="divFixed125">
    <input type="hidden" id="idmId" value="${idmId}">
    <input type="hidden" id="logoff" value="${logoff}"/>
    <table>
		<tr>
			<td style="vertical-align: top; width: 240px; margin-left: 10px; margin-top: 30px;">
				<%--<fieldset>--%>
					<%--<legend>体检列表</legend>--%>
					<input type="hidden" id="pageIndex" value="${pageIndex}">
					<form id="medicalListForm">
					</form>
					<div id="medicalMainListDiv"></div>
				<%--</fieldset>				--%>
			</td>
			<td>
				<div id="medicalDiv"></div>
    		</td>
		</tr>	    
    </table>
</div>

