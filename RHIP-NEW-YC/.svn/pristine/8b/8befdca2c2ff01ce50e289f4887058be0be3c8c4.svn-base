<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ihm/medicalTarget/susSearch.js" type="text/javascript"></script>

<div class="toolbar">
    	<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>
		        <a href="javascript:void(0)">医疗服务</a>
		        <a>
		          <cite>
		          床位使用情况
		          </cite></a>
		      </span>
		</div>
    </div>
    
<div class="searchbox searchSection x-admin-sm" id="top_all">
	<input type="hidden" id="pageIndex" value="${pageIndex}">
	<form id="sickbedUseStateSearchForm">
		<table id="sickbedUseStateSearch">
			<colgroup>
               	<col style="width: 10%; min-width: 100px;"/>
                <col style="width: 25%; min-width: 150px;"/>
                <col style="width: 10%; min-width: 100px;"/>
				<col style="width: 25%; min-width: 150px;"/>
				<col style="width: 10%; min-width: 100px;"/>
				<col style="width: 20%; min-width: 150px;"/>
			</colgroup>
			<tbody>
				<tr>
                    <td class="col-text">机构</td>
					<td class="col-input">
						<ehr:org-type-list  name="hospitalCode" type="hospital" value="${hospitalCode}" code="${hospitalCode}" width="180px"/>
					</td>   
                    <td class="col-text">科室名称</td>
					<td class="col-input">
						<input type="text" name="departmentName" />
					</td>
                    <td class="col-text">所在病区</td>
					<td class="col-input">
						<input type="text" name="sickArea" />
					</td>					  						  
				</tr>
				<tr>
                    <td class="col-text">是否加床</td>
					<td class="col-input">
						<ehr:dic-list name="extraBedMark" dicmeta="FS10186" code="0,1" />
					</td> 				
					<td class="col-text">是否开放</td>
					<td class="col-input">
						<ehr:dic-list name="avirableBedMark" dicmeta="FS10186" code="0,1" />
					</td> 		
					<td colspan="2" style="text-align: right;">
						<button class="layui-btn layui-btn-sm"  id="sickbedUseStateBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
					</td>                         			
				</tr>
                   
			</tbody>
		</table>
		<table>
			<tr>
				<td class="col-bottom">
					<span onclick="toggle(this,'sickbedUseStateSearch')" class="ico-bottom">&nbsp;</span>
				</td>   					
			</tr>
		</table>
	</form>
</div>
<div id="resultDiv"></div>