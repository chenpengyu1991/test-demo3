<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/views/vaccine/statistics/report/monthReport/pneumonia/search.js" type="text/javascript"></script>

<div  class="section">
	<div id="pneumoniaTopAll">
		<div class="toolbar">
		<div class="x-nav">
	       <span class="layui-breadcrumb">
	        <a href="javascript:void(0)">预防接种管理</a>
	        <a>
          <cite>23价疫苗报表</cite></a>
      	</span>
    	</div>
		</div>
		<div class="searchbox searchSection x-admin-sm">
		    <input type="hidden" id="pageIndex" value="${pageIndex}"/>
			<input type="hidden" id="RoleTypeId" value="${RoleType}"/>
			<form id="pneumoniaReportSearchForm">				
                <table id="pneumoniaReportSearch" >
				<colgroup>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:100px; width: 23%;"/>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:100px; width: 23%;"/>
                    <col style="min-width:70px; width: 10%;"/>
				</colgroup>		
					<tbody>
						<tr>
							<td class="coltext">日期</td>
							<td class="colinput">
								<input type="text" class="layui-input x-admin-sm-date" name="fillBeginDate" id="fillBeginDateId" style="padding-left: 0px;width: 35%;" /> ~
								<input type="text" class="layui-input x-admin-sm-date" name="fillEndDate" id="fillEndDateId" style="padding-left: 0px;width: 35%;" />
							</td>
							<td class="coltext">机构</td>
                            <td class="colinput"  colspan="4">
                                <ehr:org-type-list id="fillOrganCodeId" name="fillOrganCode" type="centre" value="${fillOrganCode}" code="${fillOrganCode}"  width="200px"/>
                            </td>
	                        <td>
								<button class="layui-btn layui-btn-sm" id="pneumoniaReportBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
	                        </td>  							
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="5" class="colbottom">
	                          <span onclick="pneumoniaReportSearch.toggle(this,'pneumoniaReportSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
	</div>
	<div class="toolbarSection x-admin-sm">
	<a href="javascript:void(0)" id="pneumoniaExport"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
	</div>
	<div id="pneumoniaResultDiv" ></div>
</div>

