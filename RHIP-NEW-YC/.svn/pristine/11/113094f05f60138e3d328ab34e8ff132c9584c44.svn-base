<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKYFJZ" value="<%=RoleType.JKYFJZ.getValue()%>" />
<jsp:include page="../../../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/vaccine/statistics/report/monthReport/rabies/search.js" type="text/javascript"></script>

<div  class="section">
	<div id="rabiesTopAll">
		<div class="toolbar">
		<div class="x-nav">
	       <span class="layui-breadcrumb">
	        <a href="javascript:void(0)">预防接种管理</a>
	        <a>
          <cite>犬伤防治报表</cite></a>
      	</span>
    	</div>
		</div>
		<div class="searchbox searchSection x-admin-sm">
			<input type="hidden" id="pageIndex" value="${pageIndex}"/>
			<input type="hidden" id="RoleTypeId" value="${RoleType}"/>
			<form id="rabiesReportSearchForm">				
                <table id="rabiesReportSearch" >
				<colgroup>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:100px; width: 23%;"/>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:100px; width: 23%;"/>
                    <col style="min-width:70px; width: 10%;"/>
				</colgroup>		
					<tbody>
						<tr>
							<td class="coltext">填报日期</td>
							<td class="colinput">
								<input type="text" class="layui-input x-admin-sm-date" name="fillBeginDate" id="fillBeginDateId" style="padding-left: 0px;width: 35%;" /> ~
								<input type="text" class="layui-input x-admin-sm-date" name="fillEndDate" id="fillEndDateId" style="padding-left: 0px;width: 35%;" />
							</td>
							<td class="coltext">填报单位</td>
                            <td class="colinput"  colspan="4">
                                <ehr:org-type-list id="fillOrganCodeId" name="fillOrganCode" type="hospital,centre,other" value="${fillOrganCode}" code="${fillOrganCode}"  codeOther="418565332" width="200px"/>
                                <input type="hidden" id="codeOther" value="46714114-9"/>
                            </td>
	                        <td>
								<button class="layui-btn layui-btn-sm" id="rabiesReportBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
	                        </td>
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="5" class="colbottom">
	                          <span onclick="rabiesReportSearch.toggle(this,'rabiesReportSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
	</div>
	<div class="toolbarSection x-admin-sm">
	<a href="javascript:void(0)" id="rabiesExport"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
	</div>
	<div id="rabiesResultDiv" ></div>
</div>

