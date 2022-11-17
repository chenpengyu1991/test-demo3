<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript">
var domainSearch = (function(){
	$(function() {
		search(1);
		$("#searchForm").onEnter(search, 1);
		$("#btnSearch").click(function() {
			search(1);
		});
		$("#btnReset").click(function() {
			util.reset("searchForm");
		});
		$("#btnAdd").click(function() {
			var dialogParams = {
					id : "d1",
					url : "/mdmDomain/add",
					height : 250,
					width : 450,
					title : "创建域"
			};
			$.dialog(dialogParams);
		});
	});

	function search(indexPage) {
		var searchObj = {
			url : "/mdmDomain/list",
			insertDiv : "resultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#searchForm").submitFormLoadHtml(searchObj);
	};

	function editDomain(domainCode) {
		var dialogParams = {
				id : "d1",
				url : "/mdmDomain/edit",
				height : 250,
				width : 450,
				param : {
					domainCode : domainCode
				},
				title : "修改域"
		};
		$.dialog(dialogParams);
	}

	function deleteDomain(domainCode) {
		layer.confirm("确定删除吗？", {icon:2, title:'确认提示'}, function(index) {
			var params = {
					url : "/mdmDomain/delete",
					callback : callback,
					param : {
						domainCode : domainCode
					}
			};
			$.getJsonByUrl(params);
			layer.close(index);
		});
	}

	function callback(data) {
		if (data.result) {
			search($("#indexPage").val());
		} else {
			alert(data.message);
		}
	}

	return {
		search : search,
		editDomain : editDomain,
		deleteDomain : deleteDomain
	};
})();
</script>

<div class="section">
	<div id="top_all">
		<div class="toolbar">
			<a href="javascript:void(0)"   id="btnAdd"><b class="xinz" >添加</b></a>
		</div>
		<div class="searchbox">
			<form:form id="searchForm" modelAttribute="criDomain">
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
							<td class="coltext">域编码</th>
							<td class="colinput"><form:input path="domainCode"/></td>
							<td class="coltext">域名称</th>
							<td class="colinput"><form:input path="domainName" /></td>
							<td class="colinput">
								<input type="button" id="btnSearch" value="查询"  class="search_btn" />
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