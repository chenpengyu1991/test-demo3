<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/mhm/mhmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/mhm/drugSearch.js" type="text/javascript"></script>

<div class="section" id="top_all">
    <div class="toolbar">
        <div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">精神障碍患者管理</a>
		        <a href="javascript:void(0)">系统管理</a>
		        <a>
		          <cite>药品维护</cite></a>
		      </span>
		</div>
    </div>
    <div class="searchbox searchSection x-admin-sm">
			<form id="drugSearchForm">
                <table id="drugSearch" >
				<colgroup>
					<col style="min-width:70px; width: 13%;"/>
					<col style="min-width:160px; width: 20%;"/>
                    <col style="min-width:80px; width: 13%;"/>
					<col style="min-width:160px; width: 20%;"/>
                    <col style="min-width:80px; width: 13%;"/>
                    <col style="min-width:80px; width: 20%;"/>
                </colgroup>
					<tbody>
						<tr>
                            <td class="coltext">药品名称</td>
                            <td class="colinput"><input type="text" name="drugName" class="x-layui-input"/></td>
							<td class="coltext">药品剂型</td>
							<td class="colinput"><input type="text" name="drugForm" class="x-layui-input"/></td>
                            <td></td>
                            <td>
                                <!-- <input type="button" id="drugBtnSearch" value="查询" class="search_btn"/> -->
                                <button class="layui-btn layui-btn-sm" id="drugBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                            </td>
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="mhmCommon.toggle(this,'drugSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>

			 </form>
		</div>
		<div class="toolbarSection x-admin-sm">
		<a href="javascript:void(0)" id="addDrug" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
		</div>
		<div id="drugResultDiv"></div>
</div>
<div id="drugDetailDiv"></div>

