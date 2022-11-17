<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ep/iodate/monitorSearch.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/menubox/menubox.css"></link>
<script type="text/javascript">
	layui.use('laydate', function(){
        var laydate = layui.laydate;
		//年月日
		laydate.render({
		  elem: '#beginTime'
		  ,format: 'yyyy/MM/dd'
		  ,max:0 //今天之后不可选
		});
		laydate.render({
		  elem: '#endTime'
		  ,format: 'yyyy/MM/dd'
		  ,max:0 //今天之后不可选
		});
	});
</script>

<div class="section">
	<div class="toolbar">
		<div style="position:relative;">
			<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">地方病防治</a>
		        <a href="javascript:void(0)">碘盐监测</a>
		        <a>
		          <cite>非碘盐调查表</cite></a>
		      </span>
			</div>
		</div>
	</div>
	 <div class="searchbox searchSection x-admin-sm">
		<form id="searchForm">
			<input type="hidden" id="functionName" value="非碘盐调查记录"/>
			<input type="hidden" id="functionCode" name="function" value="nonIodizedSalt"/>
			<table id="searchTable">
				<colgroup>
					<col style="width: 13%;" />
					<col style="width: 20%;" />
					<col style="width: 10%;" />
					<col style="width: 23%;" />
					<col style="width: 10%;" />
					<col style="width: 23%;" />
				</colgroup>
				<tbody>
				<tr>
					<td class="coltext">户主姓名或商店名称</td>
					<td class="colinput"><input type="text" name="name" style="width: 150px"/></td>
					<td class="coltext">所属乡镇、村</td>
					<td class="colinput" colspan="3">
						<select id="searchTown" name="gbCode" style="width: 150px" reg="{'required':'true'}">
							<option value="">请选择</option>
							<c:forEach var="town" items="${townList}">
								<option value="${town[0]}" ${record.gbCode eq town[0] ? "selected" : ""}>${town[1]}</option>
							</c:forEach>
						</select>
						<select id="searchVillage" name="villageCode" style="width: 150px">
							<option value="">请选择</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="coltext">调查时间</td>
					<td class="colinput">
						<input type="text" class="layui-input x-admin-sm-date"  name="beginTime" id="beginTime" style="padding-left: 0px;width: 80px;" /> &nbsp;~&nbsp;
                        <input type="text" class="layui-input x-admin-sm-date"  name="endTime" id="endTime" style="padding-left: 0px;width: 80px;" />
					</td>
					<td class="coltext">调查类型</td>
					<td class="colinput"><ehr:dic-list name="surveyType" dicmeta="FS10274" width="150px"/></td>
					<td></td>
					<td class="colinput">
						<button class="layui-btn layui-btn-sm" id="searchBtn"><i class="layui-icon">&#xe615;</i>查询</button>
					</td>
				</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td class="colbottom">
						<span class="ico-bottom" onclick="toggle(this,'searchTable')">&nbsp;</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div class="toolbarSection x-admin-sm" style="margin-bottom: 45px;">
	<a href="javascript:void(0)"><button id="addBtn" class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
		<div id="menubox" style="left: 6px;top: 180px;width: 80px">
			<ul>
				<li><a href="javascript:void(0)" data-type="1">用户调查</a></li>
				<li><a href="javascript:void(0)" data-type="2">零售商调查</a></li>
			</ul>
		</div>
	</div>
	<div id="listDiv"></div>
</div>