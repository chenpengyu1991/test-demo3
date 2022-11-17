<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/search.js" type="text/javascript"></script>
<div class="section" id="mainSearchDiv">
    <div class="toolbar">
    	<ehr:authorize ifNotGranted="01">
		<a onclick="mainPage.addRecord()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
		</ehr:authorize>
	</div>
	<div class="searchbox  searchSection x-admin-sm">
		<form method="post" id="form_search">
			<div class="searchbox" id="searchTable">
				<table>
					<colgroup>
						<col style="min-width:70px; width: 10%;"/>
						<col style="min-width:160px; width: 20%;"/>
	                    <col style="min-width:80px; width: 10%;"/>
						<col style="min-width: 210px;width: 20%; "/>
	                    <col style="min-width:60px; width: 10%;"/>
						<col style="min-width:160px; width: 20%;"/>
					</colgroup>
					<tbody>
						<tr>
							<td class="coltext">档案号</td>
							<td class="colinput"><input type="text" name="profileNo" width="100%" cssClass="x-layui-input" /></td>
							<td class="coltext">医院名称</td>
							<td class="colinput"><input type="text" name="hospitalName" cssClass="x-layui-input"/></td>
							<td class="coltext">医院级别</td>
							<td class="colinput"><ehr:dic-list name="hospitalLevel" dicmeta="DM02-02"></ehr:dic-list></td>
						</tr>
						<tr>
							<td class="coltext">更新时间</td>
							<td class="colinput">
								<input type="text" class="layui-input x-admin-sm-date"  name="startDate" id="startDate" style="padding-left: 0px;width: 36%;" /> ~
								<input type="text" class="layui-input x-admin-sm-date"  name="endDate" id="endDate" style="padding-left: 0px;width: 36%;" />
							<td class="coltext">审核情况</td>
							<td class="colinput"><ehr:dic-list name="checkCondition" code="1,2,3" dicmeta="CV0900103"></ehr:dic-list></td>
							<td style="text-align: right;" colspan="2">
								<button class="layui-btn layui-btn-sm" id="per_search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<table>
				<tr>
					<td colspan="6" class="colbottom"><span onclick="mainPage.toggle(this,'searchTable')" class="ico-bottom">&nbsp;</span></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="info_records"></div>
</div>
<div id="record_edit"></div>

<script type="text/javascript">
	layui.use('laydate', function(){
		var laydate = layui.laydate;

		laydate.render({
			elem: '#startDate'
			,format: 'yyyy/MM/dd'
			,max:0
		});

		laydate.render({
			elem: '#endDate'
			,format: 'yyyy/MM/dd'
			,max:0
		});

	});

</script>
