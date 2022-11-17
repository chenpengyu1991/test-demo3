<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/oh/enterprise/chemicalsUsedList.js" type="text/javascript"></script>
<script>
    $(function(){
        enableChangeConfirm();
        <c:if test="${msg == true}">
			layer.alert("保存成功！", {icon:0,title:'提示'});
        </c:if>
        <c:if test="${msg == false}">
			layer.alert("保存失败！", {icon:0,title:'提示'});
    	</c:if>
    })
</script>

<input type="hidden" id="enterpriseId" name="enterpriseId" value="${enterpriseId}">
<div class="toolbar">
	<a href="javascript:void(0)" onclick="javascript:enterpriseAdd.returnSearch()"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<c:if test="${type == 'add'}">
		<a href="javascript:chemicalsUsedList.initAdd()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
	</c:if>
    <c:if test="${type == 'edit'}">
		<a href="javascript:chemicalsUsedList.initAdd()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
	</c:if>
</div>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:60px;width: 15%;"/>
	        <col style="min-width:120px;width: 15%;"/>
			<col style="min-width:40px;width:20%;"/>
	        <col style="min-width:100px;width: 20%;"/>
	        <col style="min-width:100px;width: 15%;"/>
	        <col style="min-width:100px;width: 15%;"/>
		</colgroup>	
		<thead>
			<tr>
				<th >时间</th>
				<th >车间</th>
				<th >化学物质名称</th>
				<th >来源</th>	
				<th >年生产/使用量</th>		
				<th >操作</th>	
			</tr>
		</thead>
		<tbody>
			<c:forEach var="chemicalsUsed" items="${chemicalsUsed.list}" varStatus="status">
				<tr>
					<td title="<fmt:formatDate value='${chemicalsUsed.createTime}' pattern='yyyy/MM/dd' />" class="centertd">
						<fmt:formatDate value='${chemicalsUsed.createTime}' pattern='yyyy/MM/dd' />
					</td>
					<td title="${chemicalsUsed.workshopName}">${chemicalsUsed.workshopName}</td>
					<td title="${chemicalsUsed.chemicalName}">${chemicalsUsed.chemicalName}</td>
					<td title="${chemicalsUsed.source}">${chemicalsUsed.source}</td>
					<td class="righttd" title="${chemicalsUsed.harvestUsageAmount}">${chemicalsUsed.harvestUsageAmount}</td>
					<td class="centertd">
					 <c:if test="${type != 'view'}">
						 <a href="javascript:void(0);"  onclick="chemicalsUsedList.initEdit('${chemicalsUsed.id}')" title="修改"><i class="layui-icon">&#xe642;</i></a>&nbsp;&nbsp;
						 <a href="javascript:void(0);"  onclick="chemicalsUsedList.del('${chemicalsUsed.id}')" title="删除"><i class="layui-icon">&#xe640;</i></a>
					 </c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="chemicalsUsedList.search" />
		</tr>
	</table>
</div>