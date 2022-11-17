<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/views/da/daCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/da/daily/drugDistribution/search.js" type="text/javascript"></script>

<div class="section" id="top_all">
	<div class="toolbar">
		<div class="x-nav">
		<span class="layui-breadcrumb">
			<a href="javascript:void(0)">综合管理</a>
			<a href="javascript:void(0)">药品电子监管</a>
			<a><cite>药品分析</cite></a>
		</span>
		</div>
	</div>
	<div class="searchbox searchSection x-admin-sm">
			<input type="hidden" id="mainPageIndex" value="${pageIndex}">
			<form id="drugDistributionSearchForm">
                <table id="drugDistributionSearch" >
					<colgroup>
						<col style="min-width:90px; width: 15%;"/>
						<col style="min-width:180px; width: 25%;"/>
	                    <col style="min-width:90px; width: 15%;"/>
						<col style="min-width:180px; width: 25%;"/>
						<col style="min-width:90px; width: 20%;"/>
	                </colgroup>
					<tbody>
						<tr>
							<td class="coltext">通用名</td>
							<td class="colinput">
								<input type="text" name=keyword  />
							</td> 	
							<td class="coltext"><!-- 监控日期 --></td>
							<td class="colinput">
								<%--
								<tag:dateInput nullToToday="true" id="expiryDtBegin" name="expiryDtBegin" 
									date="${firstDate}" pattern="yyyy/MM/dd"  onlypast="true" style="width: 80px;"  reg='{"required":"true"}'></tag:dateInput>
								~<tag:dateInput nullToToday="true" id="expiryDtEnd" name="expiryDtEnd" 
									date="${lastDate}" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 80px;"></tag:dateInput>--%>
							</td> 	
						</tr>
						<tr>											
							<td class="coltext">所属机构</td>
                            <td class="colinput">
                            	<tag:autoSelect name="hospitalCode" id="hospitalCode" codeValue="${hospitalCode}" reg="{'required':'true'}"></tag:autoSelect>
                            </td>						
	                        <td class="righttd" colspan="3">
								<button class="layui-btn layui-btn-sm" id="drugDistributionBtnSearch"><i class="layui-icon"></i>查询</button>
                            </td>
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="daCommon.toggle(this,'drugDistributionSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="drugDistributionResultDiv">
		<div class="repeattable">
			<table class="layui-table x-admin-sm-table-list-middle">
				<colgroup>
					<col style="min-width:120px;width: 20%;"/>
			        <col style="min-width:80px;width: 10%;"/>
					<col style="min-width:80px;width: 10%;"/>
			        <col style="min-width:80px;width: 15%;"/>
			        <col style="min-width:80px;width: 15%;"/>
			        <col style="min-width:80px;width: 15%;"/>
			        <col style="min-width:80px;width: 15%;"/>	        	        	        
				</colgroup>
				<thead>
					<tr>
		                <th>医疗机构</th>
						<th>药品名称</th>
		                <th>通用名</th>
						<th>药库入库量</th>
						<th>药库库存量</th>
						<th>药房库存量</th>
						<th>科室库存量</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
</div>
<div id="drugDistributionDetailDiv"></div>

