<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/da/daCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/da/drug/pharmacyIn/search.js" type="text/javascript"></script>

<div class="toolbar">
	<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="javascript:void(0)">卫生综合管理</a>
        <a href="javascript:void(0)">药品电子监管</a>
        <a><cite>药房入库监控</cite></a>
      </span>
	</div>
</div>
<div class="section" id="top_all">
	<div class="searchbox searchSection x-admin-sm">
		<input type="hidden" id="pageIndex" value="${pageIndex}">
		<form id="pharmacyInSearchForm">
			<table id="pharmacyInSearch" >
				<colgroup>
					<col style="min-width:90px; width: 15%;"/>
					<col style="min-width:180px; width: 35%;"/>
					<col style="min-width:90px; width: 15%;"/>
					<col style="min-width:180px; width: 35%;"/>
				</colgroup>
				<tbody>
					<tr>
						<td class="coltext">所属机构</td>
						<td class="colinput">
							<tag:autoSelect name="organCode" id="organCode" codeValue="${organCode}" style="width:200px" ></tag:autoSelect>
						</td>
						<td class="coltext">入库日期</td>
						<td class="colinput">
							<input type="text" class="layui-input x-admin-sm-date"  name="beginDt" id="beginDt" style="width:33%;" value="<fmt:formatDate value='${firstDate}' pattern='yyyy/MM/dd'/>"> ~
							<input type="text" class="layui-input x-admin-sm-date"  name="endDt" id="endDt" style="width:33%;" value="<fmt:formatDate value='${lastDate}' pattern='yyyy/MM/dd'/>">
						</td>
					</tr>
					<tr>
						<td class="coltext">入库方式</td>
						<td class="colinput">
							<ehr:dic-list  name="storageTypeCode" dicmeta="DA00008" value="" width="200px"/>
						</td>
						<td class="coltext">入库单号</td>
						<td class="colinput">
							<input type="text" name="batchNo" style="width: 200px;"/>
						</td>
					</tr>
					<tr>
						<td class="coltext">入库药房</td>
						<td class="colinput">
							<ehr:dic-list  name="pharmacyTypeCode" dicmeta="DA00009" value="" width="200px;"/>
						</td>
						<td class="righttd" colspan="2">
							<button class="layui-btn layui-btn-sm" id="pharmacyInBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td colspan="6" class="colbottom">
						  <span onclick="daCommon.toggle(this,'pharmacyInSearch')" class="ico-bottom">&nbsp;</span>
					</td>
				</tr>
			</table>
		 </form>
	</div>
	<div id="pharmacyInResultDiv"></div>
</div>
<div id="pharmacyInDetailDiv"></div>

<script type="text/javascript">
	layui.use('laydate', function(){
		var laydate = layui.laydate;
		//执行一个laydate实例
		laydate.render({
			elem: '#beginDt'
			,format: 'yyyy/MM/dd'
			,max:0
		});

		//执行一个laydate实例
		laydate.render({
			elem: '#endDt'
			,format: 'yyyy/MM/dd'
			,max:0
		});
	});
</script>