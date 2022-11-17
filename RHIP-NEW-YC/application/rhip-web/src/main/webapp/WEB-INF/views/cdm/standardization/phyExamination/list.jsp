<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKMBK" value="<%=RoleType.JKMBK.getValue()%>"/>
<c:set var="ZXMB" value="<%=RoleType.ZXMB.getValue()%>"/>
<c:set var="ZMB" value="<%=RoleType.ZMB.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/cdm/standardization/phyExamination/list.js" type="text/javascript"></script>
<div class="section" id="cdm-manage-list-box">
	<div class="toolbar">
			<div class="x-nav">
	      	<span class="layui-breadcrumb">
	        <a href="javascript:void(0)">慢病健康管理</a>
	        <a href="javascript:void(0)">慢病规范化管理</a>
	        <a>
	          <cite>慢病体检</cite></a>
	      </span>
    </div>
	</div>
	<div class="searchbox searchSection x-admin-sm">
		<form method="post" id="form_search">
			<table id="health-card-search-table">
				<colgroup>
					<col style="min-width: 70px; width: 10%">
					<col style="min-width: 140px; width: 23%">
					<col style="min-width: 70px; width: 10%">
					<col style="min-width: 140px; width: 23%">
					<col style="min-width: 70px; width: 10%">
					<col style="min-width: 140px; width: 24%">
				</colgroup>
				<tbody>
					<tr>
						<td class="coltext">姓名</td>
						<td class="colinput"><input type="text" name="name" id="personName" class="x-layui-input" /></td>
						<td class="coltext">身份证号</td>
						<td class="colinput"><tag:idcardInput name="idcard" style="ime-mode:Disabled;" cssClass="x-layui-input"></tag:idcardInput></td>
						<td class="coltext">患病类型</td>
						<td class="colinput"><ehr:dic-checkbox name="diseaseType" uninclude="3,4,5" dicmeta="DMD00004" /></td>
					</tr>
					<tr>
						<td class="coltext">年龄段</td>
						<td class="colinput"><tag:numberInput maxlength="3" id="startAge" name="startAge" style="width:35%" cssClass="x-layui-input"></tag:numberInput> ~ <tag:numberInput
								maxlength="3" id="endAge" name="endAge" style="width:35%" cssClass="x-layui-input"
							></tag:numberInput>岁</td>
						<td class="coltext">性别</td>
						<td class="colinput"><ehr:dic-list dicmeta="GBT226112003" name="gender" id="genderCode" /></td>
						<td class="coltext">体检</td>
						<td align="left">
							<label><input checked="checked" name="phyExamType" value="" id="DSFASFASDFASDFASFASDF" type="radio"> 全部</label> 
							<label><input name="phyExamType" value="1" type="radio">已体检</label>
							<label><input name="phyExamType" value="2" type="radio">待体检</label>
						</td>
					</tr>
					<tr class="advanceSearchSection" style="display: none;">
	                    <td class="coltext">现住居委会</td>
	                    <td class="colinput">
	                        <ehr:dic-town-street-village townName="patownShip" streetName="paStreet" width="50%" cssClass="x-layui-input"/>
	                    </td>
	                    <td colspan="2"></td>
	                    <td id="dt1" class="coltext tt_hidden">年份</td>
						<td id="dt2" class="colinput tt_hidden">
							<%-- <tag:dateInput name="yearDt" pattern="yyyy" style="width:35%;" date="${yearDt}" reg="{'required':true}"></tag:dateInput> --%>
							<input type="text" class="layui-input x-admin-sm-date" style="width:35%;padding-left: 0px;" placeholder="选择年份" name="yearDt" id="yearDt" value="<fmt:formatDate value='${yearDt}' pattern='yyyy'/>">
						</td>
	                </tr>
					<tr class="advanceSearchSection" style="display: none;">
						<ehr:authorize ifAnyGranted="${ADMIN},${JKMBK}">
								<td class="coltext">管理机构</td>
								<td colspan="4"><ehr:dic-town-centre-station centreName="centerOrganCode" stationName="stationOrganCode" townName="gbcode" isShowOneself="true" width="32%;" cssClass="x-layui-input"/>
								</td>
						</ehr:authorize>
						<ehr:authorize ifAnyGranted="${ZXMB}">
								<td class="coltext">管理机构</td>
								<td colspan="4"><ehr:dic-org-list id="nowAddressCode" name="stationOrganCode" isShowOneself="true" width="32%;" cssClass="x-layui-input"></ehr:dic-org-list></td>
						</ehr:authorize>
						<ehr:authorize ifAnyGranted="${ZMB}">
								<td class="coltext"></td>
								<td colspan="4"></td>
						</ehr:authorize>
	                </tr>
					<tr>
						<td colspan="6" class="righttd">
							<!-- <input type="button" id="per_search_btn" value="查询" onclick="" class="search_btn" /> -->
							<button class="layui-btn layui-btn-sm" id="per_search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
							<button class="layui-btn layui-btn-sm" id="perAdvanceSearchConditionBtn" ><i class="iconfont">&#x60010;</i>高级</button>
						</td>
					</tr>
					
				</tbody>
			</table>
			<table>
				<tr>
					<td colspan="6" class="colbottom"><span id="health-card-search-toggle-btn" class="ico-bottom">&nbsp;</span></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="toolbarSection">
		<ehr:authorize ifAnyGranted="${ZXMB},${ZMB}">
			<%-- <a href="javascript:void(0)" id="phy-export-btn"><b class="export">导出</b></a> --%>
			<a href="javascript:void(0)" id="phy-export-btn"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
		</ehr:authorize>
	</div>
	<div id="diseaseInfo" class="repeattable"></div>
</div>
<div id="cdm-manage-input-box"></div>
