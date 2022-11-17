<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/idm/schistosome/acographyMain.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" onclick="javascript:schCasesSearch.returnSearch()"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<c:if test="${1 != logoff}">
		<a href="javascript:void(0)" onclick="javascript:acographyMain.add(${idmId})" id="add" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
		<%--<a href="javascript:void(0)" onclick="javascript:acographyMain.save()" id="update" style="display: none"><b class="xiug">修改</b></a>--%>
		<a href="javascript:void(0)" onclick="javascript:acographyMain.save()" id="update" style="display: none"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
		<a href="javascript:void(0)" onclick="javascript:acographyMain.save()" id="save" style="display: none"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
		<a href="javascript:void(0)" onclick="javascript:acographyMain.deleteAcography()" id="delete" style="display: none"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe640;</i>删除</button></a>
	</c:if>
</div>
<div id="acographyMain" class="divFixed125">
    <input type="hidden" id="idmId" value="${idmId}">
    <input type="hidden" id="logoff" value="${logoff}"/>
    <table>
		<tr>
			<td style="vertical-align: top; width: 300px; margin-left: 10px; margin-top: 30px;">
				<%--<fieldset>--%>
					<%--<legend>治疗列表</legend>--%>
					<input type="hidden" id="pageIndex" value="${pageIndex}">
					<form id="acographyListForm">
					</form>
					<div id="acographyListDiv"></div>
				<%--</fieldset>				--%>
			</td>
			<td>
				<div id="acographyDiv"></div>
    		</td>
		</tr>	    
    </table>
</div>

