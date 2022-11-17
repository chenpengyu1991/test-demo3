<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script type="text/javascript">
var dictionarySearch = (function(){
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
					url : "/mdmDictionary/addDicMate",
					height : 250,
					width : 450,
					title : "创建字典"
			};
			$.dialog(dialogParams); */
			
			$.post(contextPath+'/mdmDictionary/addDicMate',
					function(ret){
		        		  layer.open({
		        			  type: 1,
		        			  id:'addDictionaryDialog',
		        			  area: ['450px', '250px'],
		        			  title:"创建字典",
		        			  content: ret
		        		  });
		        	});
		});
	});

	function search(indexPage) {
		var searchObj = {
			url : "/mdmDictionary/dictionaryList",
			insertDiv : "resultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#searchForm").submitFormLoadHtml(searchObj);
	};

	function editDicMate(dicCode) {
		/* var dialogParams = {
				id : "d1",
				url : "/mdmDictionary/editDicMate",
				height : 250,
				width : 450,
				param : {
					dicCode : dicCode
				},
				title : "修改字典"
		};
		$.dialog(dialogParams); */
		
		$.post(contextPath+'/mdmDictionary/editDicMate',
				{
					dicCode : dicCode
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'modifyDictionaryDialog',
	        			  area: ['450px', '250px'],
	        			  title:"修改字典",
	        			  content: ret
	        		  });
	        	});
	}

	function deleteDicMate(dicCode) {
		/* msgUtil.confirm("确定删除吗？",function(){
			var params = {
					url : "/mdmDictionary/deleteDicMate",
					callback : callback,
					param : {
						dicCode : dicCode
					}
			};
			$.getJsonByUrl(params);
		});
		 */
		layer.confirm('确定删除吗？', {icon:2, title:'确认提示'}, function(){
			var params = {
					url : "/mdmDictionary/deleteDicMate",
					callback : callback,
					param : {
						dicCode : dicCode
					}
			};
			$.getJsonByUrl(params);
		});
	}

	function callback(data) {
		if (data.result) {
			search($("#indexPage").val());
		} else {
			layer.alert(data.message, {icon:0,title:'提示'});
		}
	}

	function viewDicItems(dicCode) {
		$("#dic-list-box").hide();
		$("#dic-input-box").show();
		var params = {
			dicCode : dicCode
		};
		
		var loadHtmlByUrlOption = {
				url : "/mdmDictionary/dicItemsSearch",
				param : params,
				insertDiv : "dic-input-box"
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		/* baseLayoutLoad.pushMainContent("/mdmDictionary/dicItemsSearch", params); */
	}

	function publishVersion(dicCode) {
		/* msgUtil.confirm("确定发布新版本吗？",function(){
			var params = {
					url : "/mdmDictionary/publishVersion",
					callback : callback,
					param : {
						dicCode : dicCode
					}
			};
			$.getJsonByUrl(params);
		}); */
		
		layer.confirm('确定发布新版本吗？', {icon:1, title:'确认提示'}, function(){
			var params = {
					url : "/mdmDictionary/publishVersion",
					callback : callback,
					param : {
						dicCode : dicCode
					}
			};
			$.getJsonByUrl(params);
		});
	}

	function changeStatus(dicCode, oldStatus) {
		var params = {
				url : "/mdmDictionary/changeStatus",
				callback : callback,
				param : {
					dicCode : dicCode,
					oldStatus : oldStatus
				}
		};
		$.getJsonByUrl(params);
	}
	
	return {
		search : search,
		viewDicItems : viewDicItems,
		changeStatus : changeStatus,
		editDicMate : editDicMate,
		deleteDicMate : deleteDicMate
	};
})();

</script>

<div class="section" id="dic-list-box">
	<div id="top_all">
		<div class="toolbar">
		<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">系统管理</a>
		        <a href="javascript:void(0)">术语字典</a>
		        <a>
		          <cite>字典管理</cite></a>
		      </span>
		</div>
		</div>
		<div class="searchbox searchSection x-admin-sm">
			<form:form id="searchForm" modelAttribute="criDictionary">
				<table id="searchTable">
					<tbody>
						<colgroup span="7">
							<col style="width: 60px;" />
							<col style="width: 100px;" />
							<col style="width: 60px;" />
							<col style="width: 100px;" />
							<col style="width: 60px;" />
							<col style="width: 100px;" />
							<col style="width: 120px;" />
						</colgroup>
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
	<div class="toolbarSection">
		<!-- <a href="javascript:void(0)"   id="btnAdd"><b class="xinz" id="btnReflashLabel">添加</b></a> -->
		<a href="javascript:void(0)"   id="btnAdd"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>添加</button></a>
	</div>
	<div id="resultDiv"></div>
</div>

<div id="dic-input-box">
</div>