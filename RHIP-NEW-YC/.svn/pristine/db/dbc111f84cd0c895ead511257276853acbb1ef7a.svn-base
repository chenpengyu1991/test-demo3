<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>


<script src="${pageContext.request.contextPath}/js/views/he/promoteunit/search.js" type="text/javascript"></script>

<div class="section">
	    
		<div class="toolbar">
		<div class="x-nav">
		        <span class="layui-breadcrumb">
			    <a href="javascript:void(0)">健康教育服务</a>
			    <a><cite>健康促进单位</cite></a>
		        </span>
            </div>
			
		</div>
		<div class="searchBox searchSection x-admin-sm">
			<form id="healthPromoteUnitSearchForm">
				<table id="healthPromoteUnitSearch">
					<colgroup>
						<col style="width: 50px;" />
						<col style="width: 150px;" />
						<col style="width: 50px;" />
						<col style="width: 150px;" />
						<col style="width: 50px;" />
						<col style="width: 150px;" />
						<col style="width: 50px;" />
					</colgroup>
					<tbody>
						<tr>
							<td class="col-text">单位名称</td>
							<td class="col-input"><input name="name" type="text" class="x-layui-input"/></td>
							<td class="col-text">创建类别</td>
							<td class="col-input">
								<ehr:dic-list name="type" value="${healthPromoteUnit.type}" dicmeta="HE00009" width="150px" id="type" cssClass="x-layui-input"></ehr:dic-list> 
							</td>
							<td class="col-text">创建级别</td>
							<td class="col-input">
								<ehr:dic-list name="unitLevel" value="${healthPromoteUnit.unitLevel}" dicmeta="HE00010" width="150px" id="unitLevel" cssClass="x-layui-input"></ehr:dic-list>
							</td>
							<td></td>
							</tr>
							<tr>
							<td class="col-text">授予时间</td>
							<td class="col-input"  colspan="5">
								<%-- <tag:dateInput name="createBeginTime" id="createBeginTime"  style="width: 10%;"/>~<tag:dateInput name="createEndTime" id="createEndTime"  style="width: 10%;"/> --%> 
								<input type="text" class="layui-input x-admin-sm-date"  name="createBeginTime" id="createBeginTime" style="padding-left: 0px;width:12%;" value="<fmt:formatDate value='${currentYearStartDate}' pattern='yyyy/MM/dd'/>" /> ~
                            <input type="text" class="layui-input x-admin-sm-date"  name="createEndTime" id="createEndTime" style="padding-left: 0px;width:12%;" />
                            </td>
                            <td style="text-align: right;" rowspan="2"><!-- <input type="button" id="healthPromoteUnitBtnSearch" value="查询"
								 class="search_btn" /> -->
								 <button class="layui-btn layui-btn-sm" id="healthPromoteUnitBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
								 </td>
							</tr>
					</tbody>
				</table>
				<table>
					<tr>
						<td colspan="4" class="col-bottom"><span
							onclick="healthPromoteUnitSearch.toggle(this,'healthPromoteUnitSearch')"
							class="ico-bottom">&nbsp;</span></td>
					</tr>
				</table>
			</form>
		</div>
		<div class="toolbarSection x-admin-sm">
        <ehr:authorize ifNotGranted="04,01">
            <a id="promoteUnitAdd" href="javascript:void(0)"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
        </ehr:authorize>
    </div>
		<div id="healthPromoteUnitResultDiv">
		</div>
</div>

<script type="text/javascript">
layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#createBeginTime' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });
    
    laydate.render({
        elem: '#createEndTime' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
      });
    
  });
</script>