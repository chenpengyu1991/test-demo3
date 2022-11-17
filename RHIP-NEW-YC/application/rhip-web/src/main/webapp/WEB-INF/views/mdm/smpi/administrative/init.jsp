<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/views/mdm/administrative/add.js" type="text/javascript"></script>

<div class="toolbar"  id="admininitdivid">
	<label><a href="javascript:void(0)" style="margin-top:6px;" onclick="javascript:villageAdd.popupAreaInfo(${selectYear})" title="查看详情"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe615;</i>查看详情</button></a></label>
	<c:if test="${selectYear eq currentYear}">
	<span id="hiddenBtn" >
    	<a href="javascript:void(0)" onclick="javascript:villageAdd.popup('')"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增村</button></a>
    	<a href="javascript:void(0)" onclick="javascript:villageAdd.saveRelation()" id="baocun"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存镇村对应关系</button></a>
    	<a href="javascript:void(0)" onclick="javascript:villageAdd.mergeDialog()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>乡镇合并</button></a>
	</span>
	</c:if>
</div>
<input type="hidden" name="townCode" id="townCode"/>
<input type="hidden" id="selectYear" value="${selectYear}"/>
<div class="postcontent contentfixed32" style="margin-top: 40px;height: 350px;">
	<table>
		<colgroup>
			<col style="min-width: 300px; width: 40%;">
			<col style="min-width: 400px; width: 60%;">
		</colgroup>
		<tr>
			<td style="padding-top: 0px; vertical-align: text-top;">
				<jsp:include page="tree.jsp"/>
			</td>
			<td style="padding-top: 0px; vertical-align: text-top; padding-right: 10px; padding-bottom: 10px;">
				<div class="repeattable" id="listDiv"></div>
			</td>
		</tr>
	</table>
</div>
