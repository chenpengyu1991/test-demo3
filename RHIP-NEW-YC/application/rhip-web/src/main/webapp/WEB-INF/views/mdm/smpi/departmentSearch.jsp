<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script type="text/javascript">
var departmentSearch = (function(){
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

		$("#btnAdd").click(function(e) {
			e.preventDefault();
			/* var dialogParams = {
					id : "d1",
					url : "/mdmDepartment/add",
					height : 240,
					width : 550,
					param : {
						organCode : $("#hidden_organCode").val()
					},
					title : "创建科室"
			};
			$.dialog(dialogParams); */
			
			$.post(contextPath+'/mdmDepartment/add',
					{
				     organCode : $("#hidden_organCode").val()
					},
					function(ret){
		        		  layer.open({
		        			  type: 1,
		        			  id:'addDeptDialog',
		        			  area: ['550px', '240px'],
		        			  title:"创建科室",
		        			  content: ret
		        		  });
		        	});
		});
	});
	/*
	function reset() {
	    $("#searchParamsDiv").find("input[type!='button']").val("");
	    $("#searchParamsDiv").find("select").val("");
	}
	*/
	function search(indexPage) {
		var searchObj = {
			url : "/mdmDepartment/list",
			insertDiv : "resultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#searchForm").submitFormLoadHtml(searchObj);
	}

	function callback(data) {
		if (data.result) {
			search($("#indexPage").val());
		} else {
			layer.alert(data.message, {icon:0,title:'提示'});
		}
	}

	function edit(deptId) {
		/* var dialogParams = {
				id : "d1",
				url : "/mdmDepartment/edit",
				param : {
					deptId : deptId
				},
				height : 240,
				width : 550,
				title : "修改科室"
		};
		$.dialog(dialogParams); */
		
		$.post(contextPath+'/mdmDepartment/edit',
				{
			     deptId : deptId
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'modifyDeptDialog',
	        			  area: ['550px', '240px'],
	        			  title:"修改科室",
	        			  content: ret
	        		  });
	        	});
	}

	function remove(deptId) {
		/* msgUtil.confirm("确定删除吗？",function(){
			var params = {
					url : "/mdmDepartment/remove",
					callback : callback,
					param : {
						deptId : deptId
					}
			};
			$.getJsonByUrl(params);
		}); */
		
		layer.confirm('确定删除吗？', {icon:2, title:'确认提示'}, function(index){
			var params = {
					url : "/mdmDepartment/remove",
					callback : callback,
					param : {
						deptId : deptId
					}
			};
			$.getJsonByUrl(params);
		});
	}

	function showLogs(deptId) {
		/* var dialogParams = {
				id : "d1",
				url : "/mdmDepartment/showLogs",
				param : {
					indexPage : 1,
					deptId : deptId
				},
				height : 600,
				width : 750,
				title : "变化跟踪"
		};
		$.dialog(dialogParams); */
		
		$.post(contextPath+'/mdmDepartment/showLogs',
				{
					indexPage : 1,
					deptId : deptId
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'showLogDialog',
	        			  area: ['750px', '600px'],
	        			  title:"变化跟踪",
	        			  content: ret
	        		  });
	        	});
	}

	function searchLog(indexPage) {
		var searchObj = {
			url : "/mdmDepartment/showLogs",
			insertDiv : "contentd1",
			param : {
				indexPage : indexPage,
				deptId : $("#deptId_log").val()
			}
		};
		$.loadHtmlByUrl(searchObj);
	}
	
	return {
		search : search,
		edit : edit,
		remove : remove,
		showLogs : showLogs,
		searchLog : searchLog
	};
})();
</script>

<div class="section">
	<div id="top_all">
		<div class="toolbar">
			<!-- <a href="javascript:void(0)"   id="btnAdd"><b class="xinz" >添加</b></a> -->
			<a href="javascript:void(0)"   id="btnAdd"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>添加</button></a>
		</div>
		<div class="searchbox searchSection x-admin-sm">
			<form:form id="searchForm" modelAttribute="criDepartment">
				<table id="searchTable">
					<colgroup span="5">
						<col style="width: 60px;" />
						<col style="width: 100px;" />
						<col style="width: 60px;" />
						<col style="width: 100px;" />
						<col style="width: 120px;" />
					</colgroup>
					<tbody>
						<tr>
							<td class="coltext">科室编码</th>
							<td class="colinput">
								<form:input path="deptCode" cssClass="x-layui-input"/>
							</td>
							<td class="coltext">科室名称</th>
							<td class="colinput">
								<form:input path="deptName" />
								<form:hidden id="hidden_organCode" path="organCode"/>
							</td>
							<td class="colinput">
								<!-- <input type="button" id="btnSearch" value="查询"  class="search_btn" /> -->
								<button class="layui-btn layui-btn-sm" id="btnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
								<!-- <input type="button" id="btnReset" value="重置"  class="search_btn" /> -->
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