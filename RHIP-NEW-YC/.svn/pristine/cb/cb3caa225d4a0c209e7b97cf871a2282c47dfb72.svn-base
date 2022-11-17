<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
var dicItemSearch = (function(){
	$(function() {
		itemSearch(1);
		$("#itemSearchForm").onEnter(itemSearch, 1);
		$("#itemBtnSearch").click(function(e) {
			e.preventDefault();
			itemSearch(1);
		});
		$("#itemBtnReset").click(function(e) {
			e.preventDefault();
			util.reset("itemSearchForm");
		});
		$("#itemBtnAdd").click(function(e) {
			e.preventDefault();
			/* var dialogParams = {
					id : "d1",
					url : "/mdmDictionary/addDicItem",
					height : 250,
					width : 550,
					param : {
						dicCode : $("#parentDicCode").val()
					},
					title : "创建字典项"
			};
			$.dialog(dialogParams); */
			
			$.post(contextPath+'/mdmDictionary/addDicItem',
					{
				      dicCode : $("#parentDicCode").val()
					},
					function(ret){
		        		  layer.open({
		        			  type: 1,
		        			  id:'addDictionaryDialog',
		        			  area: ['550px', '250px'],
		        			  title:"创建字典项",
		        			  content: ret
		        		  });
		        	});
		});
		$("#itemVersionOperator").click(function(indexPage) {
			versionSearch(1);
		});
	});

	function versionSearch(indexPage){
		/* var dialogParams = {
			id : "d3",
			url : "/mdmDictionary/dicVersionList",
			height : 400,
			width : 850,
			close : submitCallback,
			param : {
				dicCode : $("#parentDicCode").val(),
				indexPage : indexPage
			},
			title : "字典版本号管理"
		};
		$.dialog(dialogParams); */
		
		$.post(contextPath+'/mdmDictionary/dicVersionList',
				{
					dicCode : $("#parentDicCode").val(),
					indexPage : indexPage
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'manageDictionaryVersionDialog',
	        			  area: ['850px', '400px'],
	        			  title:"字典版本号管理",
	        			  content: ret
	        		  });
	        	});
	}

	function itemSearch(indexPage) {
		var searchObj = {
			url : "/mdmDictionary/dicItemList",
			insertDiv : "itemResultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#itemSearchForm").submitFormLoadHtml(searchObj);
	};

	function editDicItem(itemId) {
		/* var dialogParams = {
				id : "d1",
				url : "/mdmDictionary/editDicItem",
				height : 250,
				width : 550,
				param : {
					itemId : itemId
				},
				title : "修改字典项"
		};
		$.dialog(dialogParams); */
		
		$.post(contextPath+'/mdmDictionary/editDicItem',
				{
					itemId : itemId
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'modifyDictionaryItemDialog',
	        			  area: ['550px', '250px'],
	        			  title:"修改字典项",
	        			  content: ret
	        		  });
	        	});
	}



	function deleteDicItem(itemId) {
		layer.confirm('确定删除吗？', {icon:2, title:'确认提示'}, function(index){
			var params = {
					url : "/mdmDictionary/deleteDicItem",
					callback : itemCallback,
					param : {
						itemId : itemId
					}
			};
			$.getJsonByUrl(params);
			layer.close(index);
		});
	}

	function itemCallback(data) {
		if (data.result) {
			layer.closeAll();
			itemSearch($("#items_indexPage").val());
		} else {
			layer(data.message);
		}
	}

	function changeItemStatus(a, itemId, oldStatus) {
		var params = {
				url : "/mdmDictionary/changeItemStatus",
				callback : itemCallback,
				param : {
					itemId : itemId,
					oldStatus : oldStatus
				}
		};
		$(a).html(loadingSource);
		$.getJsonByUrl(params);
	}

	function back() {
		$("#dic-list-box").show();
		$("#dic-input-box").hide();
	}
	
	function showDicItemLogs(itemId) {
		/* var dialogParams = {
				id : "d1",
				url : "/mdmDictionary/showDicItemLogs",
				height : 600,
				width : 750,
				param : {
					indexPage : 1,
					itemId : itemId
				},
				title : "变化跟踪"
		};
		$.dialog(dialogParams); */
		
		$.post(contextPath+'/mdmDictionary/showDicItemLogs',
				{
					indexPage : 1,
					itemId : itemId
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'traceChangeDialog',
	        			  area: ['750px', '600px'],
	        			  title:"变化跟踪",
	        			  content: ret
	        		  });
	        	});
	}

	function searchLog(indexPage) {
		var searchObj = {
			url : "/mdmDictionary/showDicItemLogs",
			insertDiv : "contentd1",
			param : {
				indexPage : indexPage,
				itemId : $("#itemId_log").val()
			}
		};
		$.loadHtmlByUrl(searchObj);
	}
	
	function editDicItemMap(dicCode,itemCode,itemCodeVersion) {
		/* var dialogParams = {
				id : "d2",
				url : "/mdmDictionary/editDicItemMap",
				height : 400,
				width : 550,
				param : {
					dicCode : dicCode,
					itemCode : itemCode,
					itemCodeVersion : itemCodeVersion
				},
				title : "配置字典映射"
		};
		$.dialog(dialogParams); */
		
		$.post(contextPath+'/mdmDictionary/editDicItemMap',
				{
					dicCode : dicCode,
					itemCode : itemCode,
					itemCodeVersion : itemCodeVersion
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'configDicMappingDialog',
	        			  area: ['550px', '400px'],
	        			  title:"配置字典映射",
	        			  content: ret
	        		  });
	        	});
	}
	
	function mapDicItem(dicCode,itemCode,itemCodeVersion) {
		/* var dialogParams = {
				id : "mapDicItem",
				url : "/mdmDictionary/mapDicItem",
				height : 400,
				width : 550,
				param : {
					dicCode : dicCode,
					itemCode : itemCode,
					itemCodeVersion : itemCodeVersion
				},
				title : "字典映射"
		};
		$.dialog(dialogParams); */
		
		$.post(contextPath+'/mdmDictionary/mapDicItem',
				{
					dicCode : dicCode,
					itemCode : itemCode,
					itemCodeVersion : itemCodeVersion
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'mapDicItemDialog',
	        			  area: ['550px', '400px'],
	        			  title:"字典映射",
	        			  content: ret
	        		  });
	        	});
	}
	
	function choiceItemVersion(dicCode,itemCode) {
		/* var dialogParams = {
				id : "choiceVersion",
				url : "/mdmDictionary/choiceVersion",
				height : 200,
				width : 350,
				param : {
					dicCode : dicCode,
					itemCode : itemCode
				},
				title : "字典版本"
		};
		$.dialog(dialogParams); */
		
		$.post(contextPath+'/mdmDictionary/choiceVersion',
				{
					dicCode : dicCode,
					itemCode : itemCode
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'choiceVersionDialog',
	        			  area: ['350px', '200px'],
	        			  title:"字典版本",
	        			  content: ret
	        		  });
	        	});
	}

	function submitCallback() {

//		var option = "<option></option>";
//		var params = {
//			url : "/mdmDictionary/getDicVersions",
//			param : {
//				dicCode :  $("#parentDicCode").val()
//			},
//			callback : function(data) {
//				$.each(data.versions, function (i,o) {
//					option += '<option value="' + o.versionNumber + '">' + o.versionDesc + '</option>';
//				})
//				alert(option);
//				$("#ops").html(option);
//			}
//		};
//		$.getJsonByUrl(params);

		var option = "";
		$.getJSON("${pageContext.request.contextPath}/mdmDictionary/getDicVersions",
				{dicCode : $("#parentDicCode").val()},
				function(data){
					$.each(data.versions,function(i,o){
						     option += '<option value="'+o.versionNumber+'">'+ o.versionDesc+'</option>';
					})
//					alert(option);
					$("#ops").html(option);
				}
		);

	}

	
	return {
		submitCallback:submitCallback,
		itemSearch : itemSearch,
		searchLog : searchLog,
		back : back,
		editDicItem : editDicItem,
		deleteDicItem : deleteDicItem,
		showDicItemLogs : showDicItemLogs,
		changeItemStatus : changeItemStatus,
		editDicItemMap : editDicItemMap,
		mapDicItem : mapDicItem,
		choiceItemVersion : choiceItemVersion
	};
})();


</script>

<div class="section">
	<div id="top_all">
		<div class="toolbar">
			<!-- <a href="javascript:void(0)"  onclick="dicItemSearch.back()"><b class="fanhui">返回</b></a> -->
			<a href="javascript:void(0)"  onclick="dicItemSearch.back()" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
			<!-- <a href="javascript:void(0)"   id="itemBtnAdd"><b class="xinz" id="btnReflashLabel">添加</b></a> -->
			<a href="javascript:void(0)"   id="itemBtnAdd"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>添加</button></a>
			<!-- <a href="javascript:void(0)"   id="itemVersionOperator"><b class="qianyue" id="btnVersionLabel">版本号管理</b></a> -->
			<a href="javascript:void(0)"   id="itemVersionOperator"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe642;</i>版本号管理</button></a>
		</div>
		<div class="searchbox searchSection x-admin-sm">
			<form:form id="itemSearchForm" modelAttribute="criDicItem">
				<table id="searchItemTable">
					<colgroup span="5">
						<col style="width: 60px;" />
						<col style="width: 100px;" />
						<col style="width: 60px;" />
						<col style="width: 100px;" />
						<col style="width: 60px;" />
						<col style="width: 100px;" />
						<col style="width: 100px;" />
					</colgroup>
					<tbody>
						<tr>
							<td class="coltext">项目编码</td>
							<td class="colinput"><form:input path="itemCode" cssClass="x-layui-input" /></td>
							<td class="coltext">项目名称</td>
							<td class="colinput"><form:input path="itemName" cssClass="x-layui-input" /></td>
							<td class="coltext">字典版本</td>
							<td>
								<select name="version" id ="ops" class="x-layui-input">
									<c:forEach var="dicVersion" items="${dicVersions}">
										<option value="${dicVersion.versionNumber}">${dicVersion.versionDesc}</option>
									</c:forEach>
								</select>
							</td>
							<td class="colinput">
								<form:hidden path="dicCode" id="parentDicCode"/>
								<!-- <input type="button" id="itemBtnSearch" value="查询"  class="search_btn" /> -->
								<!-- <input type="button" id="itemBtnReset" value="重置"  class="search_btn" /> -->
								<button class="layui-btn layui-btn-sm" id="itemBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
							</td>
						</tr>
					</tbody>
				</table>
				<table>
					<tr>
						<td class="colbottom">
							<span id="btnSearch" class="ico-bottom" onclick="toggle(this,'searchItemTable')">&nbsp;</span>
						</td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
	<div id="itemResultDiv"></div>
</div>