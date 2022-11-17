<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/oh/pesticidePoison/search.js" type="text/javascript"></script>

<div class="section" id="mainSearchDiv">
	<div class="toolbar">
		<ehr:authorize ifNotGranted="01">
		<a id="initAdd" onclick="mainPage.add()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
		</ehr:authorize>
	</div>
	<div class="searchbox searchSection x-admin-sm">
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
							<td class="coltext">姓名</td>
							<td class="colinput"><input type="text" name="name" cssClass="x-layui-input" /></td>
							<td class="coltext">身份证号</td>
							<td class="colinput"><tag:idcardInput name="idCard"  style="ime-mode:Disabled;"></tag:idcardInput></td>
							<td class="coltext">转归</td>
							<td class="colinput"><ehr:dic-list name="outCome" dicmeta="CV550102" ></ehr:dic-list></td>
							
						</tr>
						<tr>
							<td class="coltext">报卡类别</td>
							<td class="colinput"><ehr:dic-list name="reportCardType" dicmeta="FS10016"></ehr:dic-list></td>
							<td class="coltext">中毒农药种类</td>
							<td class="colinput"><ehr:dic-list id="drugType" name="drugType" dicmeta="CV0300204" value="${record.drugType }"></ehr:dic-list></td>
							<td class="coltext">中毒类型</td>
							<td class="colinput"><ehr:dic-list name="poisonType" dicmeta="CV510123" value="${record.poisonType }"></ehr:dic-list></td>
							
						</tr>
						<tr>
							<td class="coltext">报卡时间</td>
							<td nowrap="nowrap">
							    <tag:dateInput id="startDate" name="startDate" onlypast="true" style="width: 36%" />~ 
							    <tag:dateInput id="endDate" name="endDate" onlypast="true" style="width: 37%" />
							<td class="coltext">审核情况</td>
							<td class="colinput"><ehr:dic-list name="checkCondition" code="1,2,3" dicmeta="CV0900103"></ehr:dic-list></td>
							<td></td>
							<td>
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


