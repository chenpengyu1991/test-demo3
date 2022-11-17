<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript">
	var dicVersionSearch = (function(){
		$(function() {
			$("#versionBtnAdd").click(function(e) {
				e.preventDefault();
				/* var dialogParams = {
					id : "d4",
					url : "/mdmDictionary/addDicVersion",
					height : 200,
					width : 550,
					param : {
						dicCode : $("#parentDicCode").val()
					},
					title : "创建字典版本号"
				};
				$.dialog(dialogParams); */
				
				$.post(contextPath+'/mdmDictionary/addDicVersion',
						{
					      dicCode : $("#parentDicCode").val()
						},
						function(ret){
			        		  layer.open({
			        			  type: 1,
			        			  id:'addDictionaryVersionDialog',
			        			  area: ['550px', '200px'],
			        			  title:"创建字典版本号",
			        			  content: ret
			        		  });
			        	});
			});

		});

		function editDicVersion(id) {
			/* var dialogParams = {
				id : "d4",
				url : "/mdmDictionary/editDicVersion",
				callback : callback,
				height : 200,
				width : 550,
				param : {
					id : id
				},
				title : "修改字典版本号"
			};
			$.dialog(dialogParams); */
			
			$.post(contextPath+'/mdmDictionary/editDicVersion',
					{
						id : id
					},
					function(ret){
		        		  layer.open({
		        			  type: 1,
		        			  id:'modifyDictionaryVersionDialog',
		        			  area: ['550px', '200px'],
		        			  title:"修改字典版本号",
		        			  content: ret
		        		  });
		        	});
		}

		function changeVersionStatus(id, oldStatus) {
			var params = {
				url : "/mdmDictionary/changeVersionStatus",
				callback : callback,
				param : {
					id : id,
					oldStatus : oldStatus
				}
			};
			$.getJsonByUrl(params);
		}

		function versionSearch(indexPage){
			/* $.removeDialog("d3"); */
			/* var dialogParams = {
				id : "d3",
				url : "/mdmDictionary/dicVersionList",
				height : 400,
				width : 850,
				close:dicItemSearch.submitCallback(),
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
		        			  id:'viewDictionaryVersionDialog',
		        			  area: ['850px', '400px'],
		        			  title:"字典版本号管理",
		        			  content: ret
		        		  });
		        	});
		}

		function callback(data) {
			if (data.result) {
				layer.closeAll();
				versionSearch($("#versions_indexPage").val());
			} else {
				layer.alert(data.message, {icon:0,title:'提示'});
			}
		}

		function changeMajorVersion(id, isMajor,dicCode){
			layer.confirm("确定设为主版本吗？", {icon:1, title:'确认提示'}, function(){
			var params = {
				url : "/mdmDictionary/changeMajorVersion",
				callback : callback,
				param : {
					id : id,
					isMajor : isMajor,
					dicCode :dicCode
				}
			};
			$.getJsonByUrl(params);
		 });
		     
		}
		
		function deleteDicVersion(id,dicCode) {
			layer.confirm("确定删除吗？", {icon:2, title:'确认提示'}, function() {
				var params = {
						url : "/mdmDictionary/deleteDicVersion",
						callback : callback,
						param : {
							id : id,
							dicCode : dicCode
						}
				};
				$.getJsonByUrl(params);
			});
		}

		return {
			deleteDicVersion : deleteDicVersion,
			editDicVersion : editDicVersion,
			changeVersionStatus:changeVersionStatus,
			changeMajorVersion:changeMajorVersion
		};
	})();
</script>
<div class="repeattable" style="width: 99%;margin-left: 2px;">
	<div class="toolbar">
		<!-- <a href="javascript:void(0)"   id="versionBtnAdd"><b class="xinz" id="btnReflashLabel">添加</b></a> -->
		<a href="javascript:void(0)"   id="versionBtnAdd"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>添加</button></a>
	</div>
<table class="layui-table x-admin-sm-table-list-small">
	<thead>
	<tr>
		<th width="20%">字典编码</th>
		<th width="20%">版本号</th>
		<th width="20%">版本描述</th>
		<th width="20%">版本状态</th>
		<th>操作</th>
	</tr>
	</thead>
	<c:forEach items="${dicVersionList}" var="item" varStatus="status">
		<tr>
			<td>${item.dicCode}</td>
			<td title="${item.versionNumber}">${item.versionNumber}</td>
			<td>${item.versionDesc}</td>
			<td>
				<a href="javascript:void(0);" onclick="dicVersionSearch.changeVersionStatus('${item.id}',${item.versionStatus})">
					<c:if test="${item.versionStatus eq -1}">作废</c:if>
					<c:if test="${item.versionStatus eq 1}">有效</c:if>
				</a>
			</td>
			<td>
				<form:hidden path="dicCode" id="parentDicCode"/>
				<%-- <a href="javascript:void(0);" onclick="dicVersionSearch.editDicVersion('${item.id}')">修改</a>&nbsp; --%>
				<a href="javascript:void(0);" onclick="dicVersionSearch.editDicVersion('${item.id}')" title="修改"><i class="layui-icon">&#xe642;</i></a>&nbsp;&nbsp;
				<%-- <a href="javascript:void(0);" onclick="dicVersionSearch.deleteDicVersion('${item.id}','${item.dicCode}')">删除</a> --%>
				<a href="javascript:void(0);" onclick="dicVersionSearch.deleteDicVersion('${item.id}','${item.dicCode}')" title="删除"><i class="layui-icon">&#xe640;</i></a>&nbsp;&nbsp;
				<%-- <a href="javascript:void(0);" onclick="dicVersionSearch.changeMajorVersion('${item.id}',${item.majorVersion},'${item.dicCode}')">
					<c:if test="${item.majorVersion eq 0}">设为主版本号</c:if>
					<c:if test="${item.majorVersion eq 1}"></c:if>
				</a> --%>
				<a href="javascript:void(0);" onclick="dicVersionSearch.changeMajorVersion('${item.id}',${item.majorVersion},'${item.dicCode}')" title="设为主版本号">
				<c:if test="${item.majorVersion eq 0}"><i class="layui-icon">&#xe68e;</i></c:if>
					<c:if test="${item.majorVersion eq 1}"></c:if>
				</a>
			</td>
		</tr>
	</c:forEach>
</table>
<table>
	<tr>
		<ehr:pagination action="dicVersionSearch.versionSearch" />
	</tr>
</table>
<input type="hidden" id="versions_indexPage" value="${indexPage}" />
</div>