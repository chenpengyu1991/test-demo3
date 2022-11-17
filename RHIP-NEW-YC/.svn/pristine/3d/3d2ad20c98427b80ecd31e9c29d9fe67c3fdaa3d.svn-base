<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ihm/medicalTarget/cpwSearch.js" type="text/javascript"></script>

<div class="toolbar">
    	<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>
		        <a href="javascript:void(0)">医疗服务</a>
		        <a>
		          <cite>
		          临床路径
		          </cite></a>
		      </span>
		</div>
    </div>
    
<div class="searchbox searchSection x-admin-sm" id="top_all">
	<input type="hidden" id="pageIndex" value="${pageIndex}">
	<form id="clinicalPathwaySearchForm">
		<table id="clinicalPathwaySearch">
			<colgroup>
               	<col style="width: 15%; min-width: 80px;"/>
                <col style="width: 30%; min-width: 190px;"/>
                <col style="width: 15%; min-width: 80px;"/>
				<col style="width: 30%; min-width: 190px;"/>
				<col style="width: 10%; min-width: 80px;"/>
			</colgroup>
			<tbody>
				<tr>
                       <td class="col-text">机构</td>
					<td class="col-input">
						<ehr:org-type-list  name="hospitalCode" type="hospital" value="${hospitalCode}" code="${hospitalCode}" width="180px"/>
					</td>   
                       <td class="col-text">身份证</td>
					<td class="col-input">
						<input type="text" name="idCard" style="width:180px"/>
					</td>   
					<td rowspan="2" style="text-align: right;">
						<!-- <input type="button" id="clinicalPathwayBtnSearch" value="查询" onclick="" class="search_btn" /> -->
						<button class="layui-btn layui-btn-sm"  id="clinicalPathwayBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
					</td>  											  
				</tr>
				<tr>
					<td class="col-text">患者姓名</td>
                    <td class="col-input"><input type="text" name="patientName" style="width:180px"/></td>		
					<td class="col-text">诊断名称</td>
                    <td class="col-input"><input type="text" name="diagnosisName" style="width:180px"/></td>                       			
				</tr>
                   
			</tbody>
		</table>
		<table>
			<tr>
				<td class="col-bottom">
					<span onclick="toggle(this,'clinicalPathwaySearch')" class="ico-bottom">&nbsp;</span>
				</td>   					
			</tr>
		</table>
	</form>
</div>
<div id="resultDiv"></div>