<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script type="text/javascript">
var diseaseSearch = (function(){
	$(function() {
		search(1);
		$("#searchForm").onEnter(search, 1);
		$("#btnSearch").click(function(e) {
			e.preventDefault();
			search(1);
		});
		$("#btnReset").click(function(e) {
			e.preventDefault();
			util.reset("searchForm");
		});
		
		$("#btnImpAndExp").click(function(e) {
			e.preventDefault();
			showImport();
		})
		
		$("#btnAdd").click(function(e) {
			e.preventDefault();
			/* var dialogParams = {
					id : "d1",
					url : "/mdmDisease/addDisease",
					height : 300,
					width : 550,
					title : "创建疾病"
			};
			$.dialog(dialogParams); */
			
			$.post(contextPath+'/mdmDisease/addDisease',
					function(ret){
		        		  layer.open({
		        			  type: 1,
		        			  id:'addDiseaseDialog',
		        			  area: ['550px', '300px'],
		        			  title:"创建疾病",
		        			  content: ret
		        		  });
		        	});
		});
	});

	function search(indexPage) {
		var searchObj = {
			url : "/mdmDisease/diseaseList",
			insertDiv : "resultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#searchForm").submitFormLoadHtml(searchObj);
	}

	function changeStatus(a, diseaseId, oldStatus) {
		var params = {
				url : "/mdmDisease/changeStatus",
				callback : callback,
				param : {
					diseaseId : diseaseId,
					oldStatus : oldStatus
				}
		};
		$(a).html(loadingSource);
		$.getJsonByUrl(params);
	}

	function callback(data) {
		if (data.result) {
			search($("#indexPage").val());
		} else {
			layer.alert(data.message, {icon:0,title:'提示'});
		}
	}

	function editDisease(diseaseId) {
		/* var dialogParams = {
				id : "d1",
				url : "/mdmDisease/editDisease",
				param : {
					diseaseId : diseaseId
				},
				height : 300,
				width : 550,
				title : "修改疾病"
		};
		$.dialog(dialogParams); */
		
		$.post(contextPath+'/mdmDisease/editDisease',
				{
					diseaseId : diseaseId
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'modifyDiseaseDialog',
	        			  area: ['550px', '300px'],
	        			  title:"修改疾病",
	        			  content: ret
	        		  });
	        	});
	}

	function deleteDisease(diseaseId) {
		layer.confirm("确定删除吗？", {icon:2, title:'确认提示'}, function(){
			var params = {
					url : "/mdmDisease/deleteDisease",
					callback : callback,
					param : {
						diseaseId : diseaseId
					}
			};
			$.getJsonByUrl(params);
		});
	}

	function back() {
		baseLayoutLoad.popMainContent();
	}

	function showDiseaseLogs(diseaseId) {
		/* var dialogParams = {
				id : "d1",
				url : "/mdmDisease/showDiseaseLogs",
				param : {
					indexPage : 1,
					diseaseId : diseaseId
				},
				height : 600,
				width : 750,
				title : "变化跟踪"
		};
		$.dialog(dialogParams); */
		
		$.post(contextPath+'/mdmDisease/showDiseaseLogs',
				{
					indexPage : 1,
					diseaseId : diseaseId
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'changeViewDialog',
	        			  area: ['750px', '600px'],
	        			  title:"变化跟踪",
	        			  content: ret
	        		  });
	        	});
	}

	function searchLog(indexPage) {
		var searchObj = {
			url : "/mdmDisease/showDiseaseLogs",
			insertDiv : "contentd1",
			param : {
				indexPage : indexPage,
				diseaseId : $("#diseaseId_log").val()
			}
		};
		$.loadHtmlByUrl(searchObj);
	}
	
	function showImport() {
		/* var dialogParams = {
				id : "d1",
				url : "/mdmDisease/showImport",
				param : {},
				height : 200,
				width : 750,
				title : "导入导出"
		};
		$.dialog(dialogParams); */
		
		$.post(contextPath+'/mdmDisease/showImport',
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'impAndExpDiseaseDialog',
	        			  area: ['750px', '210px'],
	        			  title:"导入导出",
	        			  content: ret
	        		  });
	        	});
	}
	
	return {
		search : search,
		searchLog : searchLog,
		changeStatus : changeStatus,
		editDisease : editDisease,
		deleteDisease : deleteDisease,
		showDiseaseLogs : showDiseaseLogs,
		back : back,
		showImport : showImport
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
		          <cite>疾病管理</cite></a>
		      </span>
			</div>
		</div>
		<div class="searchbox searchSection x-admin-sm">
			<form:form id="searchForm" modelAttribute="criDisease">
				<table id="searchTable">
					<colgroup span="7">
						<col style="width: 60px;" />
						<col style="width: 100px;" />
						<col style="width: 60px;" />
						<col style="width: 100px;" />
						<col style="width: 60px;" />
						<col style="width: 100px;" />
						<col style="width: 60px;" />
					</colgroup>
					<tbody>
						<tr>
							<td class="coltext">主要编码</th>
							<td class="colinput"><form:input path="icd10main" cssClass="x-layui-input"/></td>
							<td class="coltext">附加编码</th>
							<td class="colinput"><form:input path="icd10ext" cssClass="x-layui-input"/></td>
							<td class="coltext">疾病名称</th>
							<td class="colinput"><form:input path="diseaseName" cssClass="x-layui-input"/></td>
							<td class="coltext">
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
	<div class="toolbarSection">
		<!-- <a href="javascript:void(0)" onclick="diseaseSearch.showImport()"><b class="shangb">导入 导出</b></a> -->
		<a href="javascript:void(0)" id="btnImpAndExp" ><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导入/导出</button></a>
		<!-- <a href="javascript:void(0)" id="btnAdd"><b class="xinz" id="btnReflashLabel">添加</b></a> -->
		<a href="javascript:void(0)" id="btnAdd"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>添加</button></a>
	</div>
	<div id="resultDiv"></div>
</div>