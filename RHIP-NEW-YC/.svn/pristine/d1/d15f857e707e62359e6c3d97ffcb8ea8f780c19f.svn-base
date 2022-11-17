<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script type="text/javascript">
var downloadSearch = (function(){
	$(function() {
		search(1);
		//openSearch('search');
		$("#searchForm").onEnter(search, 1);
		$("#btnSearch").click(function(e) {
			e.preventDefault();
			search(1);
		});
		$("#btnReset").click(function(e) {
			e.preventDefault();
			util.reset("searchForm");
		});
	});

	function search(indexPage) {
		var searchObj = {
			url : "/mdmDictionary/downloadList",
			insertDiv : "resultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#searchForm").submitFormLoadHtml(searchObj);
	};

	function downLoadCurrent(dicCode) {
		location.href = contextPath + "/mdmDictionary/downLoadCurrent?dicCode=" + dicCode;
	}

	function callback(data) {
		if (data.result) {
			search($("#indexPage").val());
		} else {
			layer.alert(data.message, {icon:0,title:'提示'});
		}
	}
	
	function viewImport(dicCode) {
		/* var dialogParams = {
				id : "d1",
				url : "/mdmDictionary/viewImport",
				param : {
					dicCode : dicCode
				},
				height : 200,
				width : 450,
				title : "导入字典"
		};
		$.dialog(dialogParams); */
		
		$.post(contextPath+'/mdmDictionary/viewImport',
				{
			     dicCode : dicCode
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'importDictionaryDialog',
	        			  area: ['450px', '210px'],
	        			  title:"导入字典",
	        			  content: ret
	        		  });
	        	});
	}
	
	return {
		search : search,
		downLoadCurrent : downLoadCurrent,
		viewImport : viewImport
	};
})();
</script>

<div class="section">
	<div id="top_all">
		<div class="toolbar">
			<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">系统管理</a>
		        <a href="javascript:void(0)">术语字典</a>
		        <a>
		          <cite>字典下载</cite></a>
		      </span>
		</div>
		</div>
		<div class="searchbox searchSection x-admin-sm">
			<form:form id="searchForm" modelAttribute="criDictionary">
				<table id="searchTable">
					<colgroup span="7">
						<col style="width: 60px;" />
						<col style="width: 100px;" />
						<col style="width: 60px;" />
						<col style="width: 100px;" />
						<col style="width: 60px;" />
						<col style="width: 100px;" />
						<col style="width: 120px;" />
					</colgroup>
					<tbody>
						<tr>
							<td class="coltext">编码</th>
							<td class="colinput"><form:input path="dicCode" cssClass="x-layui-input" /></td>
							<td class="coltext">名称</th>
							<td class="colinput"><form:input path="dicName" cssClass="x-layui-input" /></td>
							<td class="coltext">分类</th>
							<td class="colinput">
								<form:select path="categoryId" cssClass="x-layui-input">
									<form:option value="" label="全部"/>
									<form:options items="${categoryList}" itemLabel="itemName" itemValue="itemCode"/>
								</form:select>
							</td>
							<td class="colinput">
								<!-- <input type="button" id="btnSearch" value="查询"  class="search_btn" /> -->
								<!-- <input type="button" id="btnReset" value="重置"  class="search_btn" /> -->
								<button class="layui-btn layui-btn-sm" id="btnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
							</td>
						</tr>
					</tbody>
				</table>
				<table>
					<tr>
						<td class="colbottom">
							<span id="btnSearch" class="ico-bottom" onclick="toggle(this,'searchTable')">&nbsp;</span>
						</td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
	<div id="resultDiv"></div>
</div>