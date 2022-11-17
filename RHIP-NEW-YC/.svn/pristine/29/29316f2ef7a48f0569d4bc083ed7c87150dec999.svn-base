<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/familyPlanning/search.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/cwhCommon.js" type="text/javascript"></script>
<div class="section">
	<div class="toolbar">
		<div class="x-nav">
			  <span class="layui-breadcrumb">
				<a href="javascript:void(0)">综合管理</a>
				<a href="javascript:void(0)">计划生育</a>
				  <c:choose>
					  <c:when test="${listpage eq 'premaritalHealthList.jsp'}">
						  <a><cite> 男女婚检信息</cite></a>
					  </c:when>
					  <c:otherwise>
						  <a><cite> 育龄妇女登记</cite></a>
					  </c:otherwise>
				  </c:choose>
			  </span>
		</div>
	</div>
	<div class="searchbox searchSection x-admin-sm">
		<input type="hidden" id="emrPageIndex" value="${pageIndex}">
		<input type="hidden" id="queryPath" value="${queryPath}">
		<form id="fpSearchForm">
			<c:choose>
				<c:when test="${genderCriteria == '1'}">
					<table id="fpSearch">
						<colgroup>
							<col style="width: 10%; min-width: 80px;"/>
							<col style="width: 20%; min-width: 150px;"/>
							<col style="width: 10%; min-width: 80px;"/>
							<col style="width: 20%; min-width: 160px;"/>
							<col style="width: 10%; min-width: 80px;"/>
							<col style="width: 20%; min-width: 160px;"/>
						</colgroup>
						<tbody>
						<tr>
							<td class="col-text">机构</td>
							<td class="col-input">
								<input type="hidden" id="genreCode" name="genreCode" value="0"/>
								<tag:autoSelect name="organCode" id="organCode" style="width:200px" ></tag:autoSelect>
							</td>
							<td class="col-text">填报日期</td>
							<td class="col-input">
								<input type="text" class="layui-input x-admin-sm-date"  name="beginDate" id="beginDate" style="width: 41%;padding-left: 0px;"> ~
								<input type="text" class="layui-input x-admin-sm-date"  name="endDate" id="endDate" style="width: 41%;padding-left: 0px;">
							</td>
							<td class="col-text">性别</td>
							<td class="col-input">
								<ehr:dic-radio name="sex" dicmeta="GBT226112003" code="1,2" isDefault="Y"/>
							</td>
						</tr>
						<tr>
							<td class="col-text">姓名</td>
							<td class="col-input">
								<input type="text" name="name" style="width:200px"/>
							</td>
							<td class="col-text">身份证号</td>
							<td class="col-input" colspan="3">
								<input type="text" name="idcard" style="width:180px"/>
							</td>
						</tr>
						<tr>
							<td colspan="6" class="righttd">
								<button class="layui-btn layui-btn-sm" id="fpBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
							</td>
						</tr>
						</tbody>
					</table>
					<table>
						<tr>
							<td colspan="6" class="col-bottom"><span onclick="toggle(this,'fpSearch')"class="ico-bottom">&nbsp;</span></td>
						</tr>
					</table>
				</c:when>
				<c:otherwise>
					<table id="fpSearch">
						<colgroup>
							<col style="width: 10%; min-width: 80px;"/>
							<col style="width: 40%; min-width: 150px;"/>
							<col style="width: 10%; min-width: 80px;"/>
							<col style="width: 40%; min-width: 160px;"/>
						</colgroup>
						<tbody>
						<tr>
							<td class="col-text">机构</td>
							<td class="col-input">
								<input type="hidden" id="genreCode" name="genreCode" value="0"/>
								<tag:autoSelect name="organCode" id="organCode" style="width:200px" ></tag:autoSelect>
							</td>
							<td class="col-text">填报日期</td>
							<td class="col-input">
								<input type="text" class="layui-input x-admin-sm-date"  name="beginDate" id="beginDate" style="width: 21%;padding-left: 0px;"> ~
								<input type="text" class="layui-input x-admin-sm-date"  name="endDate" id="endDate" style="width: 21%;padding-left: 0px;">
							</td>
						</tr>
						<tr>
							<td class="col-text">姓名</td>
							<td class="col-input">
								<input type="text" name="name" style="width:200px"/>
							</td>
							<td class="col-text">身份证号</td>
							<td class="col-input">
								<input type="text" name="idcard" style="width:180px"/>
							</td>
						</tr>
						<tr>
							<td colspan="4" class="righttd">
								<button class="layui-btn layui-btn-sm" id="fpBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
							</td>
						</tr>
						</tbody>
					</table>
					<table>
						<tr>
							<td colspan="4" class="col-bottom"><span onclick="toggle(this,'fpSearch')"class="ico-bottom">&nbsp;</span></td>
						</tr>
					</table>
				</c:otherwise>
			</c:choose>
			</colgroup>
		</form>
	</div>
</div>
<div id="fpDiv">
	<jsp:include page="${listpage}"/>
</div>
<script type="text/javascript">
	layui.use('laydate', function(){
		var laydate = layui.laydate;
		//执行一个laydate实例
		laydate.render({
			elem: '#beginDate'
			,format: 'yyyy/MM/dd'
			,max:0
		});

		//执行一个laydate实例
		laydate.render({
			elem: '#endDate'
			,format: 'yyyy/MM/dd'
			,max:0
		});

	});
</script>