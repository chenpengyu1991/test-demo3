<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/oh/enterprise/conditionList.js" type="text/javascript"></script>
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
		<a href="javascript:conditionList.initAdd()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
	</c:if>
    <c:if test="${type == 'edit'}">
		<a href="javascript:conditionList.initAdd()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
	</c:if>
</div>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:60px;width: 8%;"/>
	        <col style="min-width:120px;width: 8%;"/>
			<col style="min-width:40px;width: 8%;"/>
	        <col style="min-width:100px;width: 8%;"/>	
	        <col style="min-width:100px;width: 10%;"/>	
	        <col style="min-width:100px;width: 10%;"/>	
	        <col style="min-width:100px;width: 10%;"/>
	        <col style="min-width:100px;width: 10%;"/>
	        <col style="min-width:100px;width: 10%;"/>
	        <col style="min-width:100px;width: 18%;"/>		
		</colgroup>	
		<thead>
			<tr>
				<th rowspan="2">时间</th>
				<th rowspan="2">职工总数</th>
				<th rowspan="2">女工总数</th>
				<th rowspan="2">生产工人数</th>	
				<th colspan="5">接触职业危害因素人数</th>		
				<th rowspan="2">操作</th>			
			</tr>
			<tr>
				<th>总数</th>
				<th>粉尘</th>
				<th>毒物</th>
				<th>物理因素</th>
				<th>其他</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="condition" items="${conditionList.list}" varStatus="status">
				<tr>
					<td class="centertd" title="<fmt:formatDate value='${condition.createTime}' pattern='yyyy/MM/dd' />" class="centertd">
						<fmt:formatDate value='${condition.createTime}' pattern='yyyy/MM/dd' />
					</td>
					<td class="righttd" title="${condition.employeeNum}">${condition.employeeNum}</td>
					<td class="righttd" title="${condition.workingwomanNum}">${condition.workingwomanNum}</td>
					<td class="righttd" title="${condition.workerNum}">${condition.workerNum}</td>
					<td class="righttd" title="${condition.dustNum+condition.poisonNum +condition.physicalFactorNum +condition.otherNum}">${condition.dustNum+condition.poisonNum +condition.physicalFactorNum +condition.otherNum}</td>
					<td class="righttd" title="${condition.dustNum}">${condition.dustNum}</td>
					<td class="righttd" title="${condition.poisonNum}">${condition.poisonNum}</td>
					<td class="righttd" title="${condition.physicalFactorNum}">${condition.physicalFactorNum}</td>
					<td class="righttd" title="${condition.otherNum}">${condition.otherNum}</td>
					<td class="centertd">
					<c:if test="${type != 'view'}">
						<a href="javascript:void(0);"  onclick="conditionList.initEdit('${condition.id}')" title="修改"><i class="layui-icon">&#xe642;</i></a>&nbsp;&nbsp;
						<a href="javascript:void(0);"  onclick="conditionList.del('${condition.id}')" title="删除"><i class="layui-icon">&#xe640;</i></a>
					  </c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="conditionList.search" />
		</tr>
	</table>
</div>