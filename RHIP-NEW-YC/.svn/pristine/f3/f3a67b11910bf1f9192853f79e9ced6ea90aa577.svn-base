<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ep/iodate/samplingSearch.js" type="text/javascript"></script>

<div class="section">
	<div class="toolbar">
		<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">地方病防治</a>
		        <a href="javascript:void(0)">碘盐监测</a>
		        <a>
		          <cite>抽样登记</cite></a>
		      </span>
		</div>
	</div>
	<div class="searchbox searchSection x-admin-sm">
		<form id="searchForm">
			<table id="searchTable">
				<colgroup>
					<col style="width: 15%"/>
					<col style="width: 25%"/>
					<col style="width: 30%"/>
				</colgroup>
				<tbody>
				<tr>
					<td class="coltext">抽检年份</td>
					<td class="colinput">
						<input type="text" class="layui-input x-admin-sm-date"  name="samplingTime" id="samplingTime" style="width:150px;padding-left: 0px;" />
						<input type="text" style="display: none"/>
					</td>
					<td style="text-align: left;">
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
	<div class="toolbarSection x-admin-sm">
		<a id="addBtn" href="javascript:void(0)"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
	</div>
	<div id="listDiv"></div>
</div>

<script type="text/javascript">
	layui.use('laydate', function(){
		var laydate = layui.laydate;
		laydate.render({
			elem: '#samplingTime'
			,type: 'year'
			,max:0
		});

	});

</script>