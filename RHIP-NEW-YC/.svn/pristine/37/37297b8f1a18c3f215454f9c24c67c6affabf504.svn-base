<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"/>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ep/iodate/monitorSearch.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/menubox/menubox.css"></link>
<div class="section">
	<div class="toolbar">
		<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">地方病防治</a>
		        <a href="javascript:void(0)">碘盐监测</a>
		        <a>
		          <cite>食盐碘含量监测表</cite></a>
		      </span>
		</div>
	</div>
	 <div class="searchbox searchSection x-admin-sm">
		<form id="searchForm">
			<input type="hidden" id="functionName" value="食盐碘含量调查记录"/>
			<input type="hidden" id="functionCode" name="function" value="iodineContent"/>
			<table id="searchTable">
				<colgroup>
					<col style="width: 12%;"/>
					<col style="width: 20%;"/>
					<col style="width: 10%;"/>
					<col style="width: 20%;"/>
					<col style="width: 10%;"/>
					<col style="width: 18%;"/>
					<col style="width: 10%;"/>
				</colgroup>
				<tbody>
				<tr>
					<td class="coltext">监测企业或商店名称</td>
					<td class="colinput"><input type="text" name="name" style="width: 150px"/></td>
					<td class="coltext">盐样编号</td>
					<td class="colinput"><input type="text" name="saltSamplingNumber" style="width: 150px"/></td>
				</tr>
				<tr>
					<td class="coltext">采样时间</td>
					<td class="colinput">
						<input type="text" class="layui-input x-admin-sm-date"  name="beginTime" id="beginTime" style="padding-left: 0px;width: 80px;" /> &nbsp;~&nbsp;
                        <input type="text" class="layui-input x-admin-sm-date"  name="endTime" id="endTime" style="padding-left: 0px;width: 80px;" />
					</td>
					<td class="coltext">监测类型</td>
					<td class="colinput"><ehr:dic-list name="surveyType" dicmeta="FS10275" width="150px"/></td>
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
		<div style="position:relative;">
			<a href="javascript:void(0)"><button id="addBtn" class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
		</div>
		<div id="menubox" style="left: 6px;top: 180px;width: 80px">
			<ul>
				<li><a href="javascript:void(0)" data-type="1">零售商监测</a></li>
				<li><a href="javascript:void(0)" data-type="2">批发商监测</a></li>
			</ul>
		</div>
	</div>

	<div id="listDiv"></div>
</div>