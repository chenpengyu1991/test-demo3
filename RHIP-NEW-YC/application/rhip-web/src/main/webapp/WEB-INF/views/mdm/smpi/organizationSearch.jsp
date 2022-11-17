<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script type="text/javascript">
var organizationSearch = (function(){
	$(function() {
		search(1);
		$("#searchForm").onEnter(search, 1);
		$("#btnSearch").click(function(e) {
			e.preventDefault();
			search(1);
		});
		$("#btnReset").click(function() {
			util.reset("searchForm");
		});

		$("#btnAdd").click(function(e) {
			e.preventDefault();
			/* var dialogParams = {
					id : "d1",
					url : "/mdmOrganization/add",
					height : 500,
					width : 800,
					title : "创建机构"
			};
			$.dialog(dialogParams); */
			
/*			$.post(contextPath+'/mdmOrganization/add',
				function(ret){
            	layui.use(['layer'], function() {
            		  var layer = layui.layer
            		  layer.open({
            			  type: 1,
            			  id:'addOrganizationDialog',
            			  area: ['800px', '500px'],
            			  title:'创建机构',
            			  content: ret
            		  });
            		});
            	});*/
			$("#oraganSearchDiv").hide();
			$.loadHtmlByUrl({
				url : contextPath+'/mdmOrganization/add',
				insertDiv :"medicalOraganDiv",
				wait : true
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
			url : "/mdmOrganization/list",
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
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.alert(data.message, {icon:0,title:'提示'});
			});
		}
		
	}

	function view(organId) {
		/* var dialogParams = {
				id : "d1",
				url : "/mdmOrganization/view",
				param : {
					organId : organId
				},
				height : 360,
				width : 800,
				title : "查看机构"
		};
		$.dialog(dialogParams); */
		
/*		$.post(contextPath+'/mdmOrganization/view',
        		{ organId : organId
			     }, 
			function(ret){
        		  layer.open({
        			  type: 1,
        			  id:'viewOrganizationDialog1',
        			  area: ['800px', '375px'],
        			  title:'查看机构',
        			  content: ret
        		  });
        	});*/
		$("#oraganSearchDiv").hide();
		$.loadHtmlByUrl({
			url : contextPath+'/mdmOrganization/view',
			param:{organId : organId},
			insertDiv :"medicalOraganDiv",
			wait : true
		});
	}
	
	function viewlog(organId, operateTime) {
		/* var dialogParams = {
				id : "d2",
				url : "/mdmOrganization/view",
				param : {
					organId : organId,
					operateTime : operateTime
				},
				height : 320,
				width : 800,
				title : "查看机构"
		};
		$.dialog(dialogParams); */
		
		$.post(contextPath+'/mdmOrganization/view',
        		{organId : organId,
			     operateTime : operateTime
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'viewOrganizationDialog2',
        			  area: ['800px', '375px'],
        			  title:'查看机构',
        			  content: ret
        		  });
        		});
        	});
	}

	function edit(organId) {
		/* var dialogParams = {
				id : "d1",
				url : "/mdmOrganization/edit",
				param : {
					organId : organId
				},
				height : 500,
				width : 800,
				title : "修改机构"
		};
		$.dialog(dialogParams); */
		
/*		$.post(contextPath+'/mdmOrganization/edit',
        		{organId : organId
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'editOrganizationDialog',
        			  area: ['800px', '500px'],
        			  title:'修改机构',
        			  content: ret
        		  });
        		});
        	});*/
		$("#oraganSearchDiv").hide();
		$.loadHtmlByUrl({
			url : contextPath+'/mdmOrganization/edit',
			param:{organId : organId},
			insertDiv :"medicalOraganDiv",
			wait : true
		});
	}

	function remove(organId) {
		/* msgUtil.confirm("确定删除吗？",function(){
			var params = {
					url : "/mdmOrganization/remove",
					callback : callback,
					param : {
						organId : organId
					}
			};
			$.getJsonByUrl(params);
		}); */
		
		layui.use('layer', function(){
			var layer = layui.layer;
			var index = layer.confirm('确定删除吗？', {icon:2, title:'确认提示'}, function(){
				var params = {
						url : "/mdmOrganization/remove",
						callback : callback,
						param : {
							organId : organId
						}
				};
				$.getJsonByUrl(params);
				layer.close(index);
			});
		});
	}
	
	function changeStatus(a, organId, oldStatus) {
		var params = {
				url : "/mdmOrganization/changeStatus",
				callback : callback,
				param : {
					organId : organId,
					oldStatus : oldStatus
				}
		};
		$(a).html(loadingSource);
		$.getJsonByUrl(params);
	}

	function back() {
		baseLayoutLoad.popMainContent();
	}

	function toShowLogs(organId) {
		/* var dialogParams = {
				id : "d1",
				url : "/mdmOrganization/showLogs",
				param : {
					indexPage : 1,
					organId : organId
				},
				height : 600,
				width : 750,
				title : "变化跟踪"
		};
		$.dialog(dialogParams); */
		
		$.post(contextPath+'/mdmOrganization/toShowLogs',
        		{
			      organId : organId
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'changeTrackDialog',
        			  area: ['750px', '600px'],
        			  title:'变化跟踪',
        			  content: ret
        		  });
        		});
        	});
	}

	function searchLog(indexPage) {
		var searchObj = {
			url : "/mdmOrganization/showLogs",
			insertDiv : "contentd1",
			param : {
				indexPage : indexPage,
				organId : $("#organId_log").val()
			}
		};
		$.loadHtmlByUrl(searchObj);
	}
	
	function showImport() {
		/* var dialogParams = {
				id : "d1",
				url : "/mdmOrganization/showImport",
				param : {},
				height : 200,
				width : 750,
				title : "导入导出"
		};
		$.dialog(dialogParams); */
		
		$.post(contextPath+'/mdmOrganization/showImport',
        		 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'orgImpExpDialog',
        			  area: ['750px', '200px'],
        			  title:'导入导出',
        			  content: ret
        		  });
        		});
        	});
	}
	
	return {
		search : search,
		back : back,
		showImport : showImport,
		view : view,
		viewlog : viewlog,
		edit : edit,
		remove : remove,
		changeStatus : changeStatus,
		toShowLogs : toShowLogs,
		searchLog : searchLog
	};
})();


var srList = (function() {
	function atStart() {
		$("#tab0").click(function() {
			selectTag("tagContent0", this);
		});
		$("#tab1").click(function() {
			selectTag("tagContent1", this);
		});
//		searchSr(1);
	}

    function searchSr(pageIndex) {
        var searchObj = {
            url : "/sr/list",
            insertDiv : "srDiv",
            param : {
                pageIndex : pageIndex,
                organCode : $("#organCodeForSr").val(),
                type : "onlyView"
            }
        };
        
        $("#searchForm").submitFormLoadHtml(searchObj);
    }

	return {
		atStart : atStart
	}
})();
</script>
<div class="section" id="oraganSearchDiv">
	<div id="top_all">
		
			<div class="toolbar">
				<div class="x-nav">
			      <span class="layui-breadcrumb">
			        <a href="javascript:void(0)">系统管理</a>
			        <a href="javascript:void(0)">卫生资源</a>
			        <a>
			          <cite>医疗机构</cite></a>
			      </span>
				</div>
			

			</div>
		
		<div class="searchbox searchSection x-admin-sm">
			<form:form id="searchForm" modelAttribute="criOrganization">
				<table id="searchTable">
					<colgroup span="6">
						<col style="width: 80px;" />
						<col style="width: 100px;" />
						<col style="width: 60px;" />
						<col style="width: 100px;" />
						<col style="width: 60px;" />
						<col style="width: 100px;" />
					</colgroup>
					<tbody>
						<tr>
							<td class="coltext">机构编码</td>
							<td class="colinput">
								<form:input path="organCode" style="width:150px;" cssClass="x-layui-input"/>
							</td>
							<td class="coltext">机构名称</td>
							<td class="colinput">
								<form:input path="organName" style="width:150px;" cssClass="x-layui-input"/>
							</td>
							<td class="coltext">机构类别</td>
							<td class="colinput">
								<ehr:dic-list name="genreCode" dicmeta="GBT2182002" code="J100,R11,A100,B100,B200,C,R200,L" cssClass="x-layui-input"/>
							</td>
						</tr>
						<tr>
							<td class="coltext">行政区划</td>
							<td class="colinput">
								<form:select path="gbCode" style="width:150px;">
									<form:option value="" label="全部"/>
									<ehr:dicItems dicmeta="FS990001"  parentcode="320586" />
								</form:select>
							</td>
							<td class="coltext">机构级别</td>
							<td class="colinput">
								<form:select path="gradeCode" style="width:150px;" cssClass="x-layui-input">
									<form:option value="" label="全部"/>
									<ehr:dicItems dicmeta="DM02-02"  />
								</form:select>
							</td>
							<td class="coltext">经营性质</td>
							<td class="colinput">
								<form:select path="manageCode" style="width:150px;" cssClass="x-layui-input">
									<form:option value="" label="全部"/>
									<ehr:dicItems dicmeta="FS10223"  />
								</form:select>
							</td>
						</tr>
						<tr>
							<td class="coltext">上级机构编码</td>
							<td class="colinput">
								<form:input path="parentCode" style="width:150px;"/>
							</td>
							<td class="coltext" colspan="4">
                                <!-- <input type="button" id="btnReset" value="重置"  class="search_btn" style="float:right;"/> -->
								<!-- <input type="button" id="btnSearch" value="查询"  class="search_btn" style="float:right;"/> -->
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
		<ehr:authorize ifNotGranted="03,39">
			<!-- <a href="javascript:void(0)"  onclick="organizationSearch.showImport()"><b class="shangb" id="btnReflashLabel">导入 导出</b></a> -->
			<a href="javascript:void(0)"  onclick="organizationSearch.showImport()"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导入 导出</button></a>
			<!-- <a href="javascript:void(0)"   id="btnAdd"><b class="xinz" id="btnReflashLabel">添加</b></a> -->
			<a href="javascript:void(0)"   id="btnAdd"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>添加</button></a>
		</ehr:authorize>
	</div>
	<div id="resultDiv"></div>
</div>
<div id="medicalOraganDiv"></div>