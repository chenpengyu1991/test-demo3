<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script type="text/javascript">
var medicineSearch = (function(){
	$(function() {
		search(1);
		// 高级查询条件显示控制
		$("#perAdvanceSearchConditionBtn").click(function(e) {
			e.preventDefault();
			controlAdvanceSearchSection($(this));
		});
		$("#searchForm").onEnter(search, 1);
		$("#btnSearch").click(function(e) {
			e.preventDefault();
			search(1);
		});
		$("#btnReset").click(function(e) {
			e.preventDefault();
			util.reset("medicineSearchParamsDiv");
		});
		
		$("#btnImpAndExp").click(function(e) {
			e.preventDefault();
			showImport();
		})

		$("#btnAdd").click(function(e) {
			e.preventDefault();
			/* var dialogParams = {
					id : "d1",
					url : "/mdmMedicine/addMedicine",
					height : 500,
					width : 550,
					title : "创建药品"
			};
			$.dialog(dialogParams); */
			
			$.post(contextPath+'/mdmMedicine/addMedicine',
					function(ret){
		        		  layer.open({
		        			  type: 1,
		        			  id:'addDrugDialog',
		        			  area: ['550px', '500px'],
		        			  title:"创建药品",
		        			  content: ret
		        		  });
		        	});
		});
		$("#categoryNameOne").change(function() {
			var value = $(this).val();
			if (value.length == 0) {
				emtyCombox("categoryNameTwo");
				emtyCombox("categoryNameThree");
				return;
			}
			var params = {
					url : "/mdmMedicine/getCategoryNameTwo",
					callback : categoryNameTwoCallback,
					param : {
						categoryNameOne : value
					}
			};
			$.getJsonByUrl(params);
		});
		$("#categoryNameTwo").change(function() {
			var value = $(this).val();
			if (value.length == 0) {
				emtyCombox("categoryNameThree");
				return;
			}
			var params = {
					url : "/mdmMedicine/getCategoryNameThree",
					callback : categoryNameThreeCallback,
					param : {
						categoryNameTwo : value
					}
			};
			$.getJsonByUrl(params);
		});
	});
	
	function search(indexPage) {
		var searchObj = {
			url : "/mdmMedicine/medicineList",
			insertDiv : "resultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#searchForm").submitFormLoadHtml(searchObj);
	}
	
	function emtyCombox(comboxId) {
		var combox = $("#" + comboxId);
		combox.empty();
		combox.append('<option value="">全部</option>');
	}

	function categoryNameTwoCallback(data) {
		emtyCombox("categoryNameTwo");
		var categoryNameTwo = $("#categoryNameTwo");
		for (var index in data) {
			var item = '<option value="'+data[index]+'">'+data[index]+'</option>';
			categoryNameTwo.append(item);
		}
		emtyCombox("categoryNameThree");
	}

	function categoryNameThreeCallback(data) {
		emtyCombox("categoryNameThree");
		var categoryNameThree = $("#categoryNameThree");
		for (var index in data) {
			var item = '<option value="'+data[index]+'">'+data[index]+'</option>';
			categoryNameThree.append(item);
		}
	}

	function changeStatus(a, medicineCode, oldStatus) {
		var params = {
				url : "/mdmMedicine/changeStatus",
				callback : callback,
				param : {
					medicineCode : medicineCode,
					oldStatus : oldStatus
				}
		};
		//alert($(a).html());
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

	function viewMedicine(medicineCode) {
		/* var dialogParams = {
				id : "d1",
				url : "/mdmMedicine/viewMedicine",
				param : {
					medicineCode : medicineCode
				},
				height : 500,
				width : 550,
				title : "查看药品"
		};
		$.dialog(dialogParams); */
		
		$.post(contextPath+'/mdmMedicine/viewMedicine',
				{
					medicineCode : medicineCode
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'viewDrugDialog',
	        			  area: ['550px', '500px'],
	        			  title:"查看药品",
	        			  content: ret
	        		  });
	        	});
	}

	function editMedicine(medicineCode) {
		/* var dialogParams = {
				id : "d1",
				url : "/mdmMedicine/editMedicine",
				param : {
					medicineCode : medicineCode
				},
				height : 500,
				width : 550,
				title : "修改药品"
		};
		$.dialog(dialogParams); */
		
		$.post(contextPath+'/mdmMedicine/editMedicine',
				{
					medicineCode : medicineCode
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'modifyDrugDialog',
	        			  area: ['550px', '500px'],
	        			  title:"修改药品",
	        			  content: ret
	        		  });
	        	});
	}

	function deleteMedicine(medicineCode) {
		layer.confirm("确定删除吗？", {icon:2, title:'确认提示'}, function(){
			var params = {
					url : "/mdmMedicine/deleteMedicine",
					callback : callback,
					param : {
						medicineCode : medicineCode
					}
			};
			$.getJsonByUrl(params);
		});
	}

	function back() {
		baseLayoutLoad.popMainContent();
	}

	function showMedicineLogs(medicineCode) {
		/* var dialogParams = {
				id : "d1",
				url : "/mdmMedicine/showMedicineLogs",
				param : {
					indexPage : 1,
					medicineCode : medicineCode
				},
				height : 600,
				width : 750,
				title : "变化跟踪"
		};
		$.dialog(dialogParams); */
		
		$.post(contextPath+'/mdmMedicine/showMedicineLogs',
				{
					indexPage : 1,
					medicineCode : medicineCode
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'changeTraceDialog',
	        			  area: ['750px', '600px'],
	        			  title:"变化跟踪",
	        			  content: ret
	        		  });
	        	});
	}

	function searchLog(indexPage) {
		var searchObj = {
			url : "/mdmMedicine/showMedicineLogs",
			insertDiv : "contentd1",
			param : {
				indexPage : indexPage,
				medicineCode : $("#medicineCode_log").val()
			}
		};
		$.loadHtmlByUrl(searchObj);
	}

	function showMedicineLog(operateTime) {
		/* var dialogParams = {
				id : "d2",
				url : "/mdmMedicine/viewMedicine",
				param : {
					medicineCode : $("#medicineCode_log").val(),
					operateTime : operateTime
				},
				height : 550,
				width : 550,
				title : "查看药品"
		};
		$.dialog(dialogParams); */
		
		$.post(contextPath+'/mdmMedicine/viewMedicine',
				{
					medicineCode : $("#medicineCode_log").val(),
					operateTime : operateTime
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'viewTraceLogDialog',
	        			  area: ['550px', '550px'],
	        			  title:"变化跟踪",
	        			  content: ret
	        		  });
	        	});
	}
	
	function showImport() {
		
		/* var dialogParams = {
				id : "d1",
				url : "/mdmMedicine/showImport",
				param : {},
				height : 200,
				width : 750,
				title : "导入导出"
		};
		$.dialog(dialogParams); */
		
		$.post(contextPath+'/mdmMedicine/showImport',
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'impAndExpDialog',
	        			  area: ['750px', '210px'],
	        			  title:"导入导出",
	        			  content: ret
	        		  });
	        	});
	}
	
	return {
		search : search,
		back : back,
		showImport : showImport,
		viewMedicine : viewMedicine,
		changeStatus : changeStatus,
		editMedicine : editMedicine,
		deleteMedicine : deleteMedicine,
		showMedicineLogs : showMedicineLogs,
		searchLog : searchLog,
		showMedicineLog : showMedicineLog
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
		          <cite>药品管理</cite></a>
		      </span>
			</div>
		</div>
		<div class="searchbox searchSection x-admin-sm">
			<form:form id="searchForm" modelAttribute="criMedicine">
				<table id="searchTable">
					<colgroup span="6">
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
							<td class="coltext">类别一级</th>
							<td class="colinput">
								<form:select path="categoryNameOne" id="categoryNameOne" style="width:150px;" cssClass="x-layui-input">
									<form:option value="" label="全部"/>
									<form:options items="${categoryOne}" />
								</form:select>
							</td>
							<td class="coltext">类别二级</th>
							<td class="colinput">
								<form:select path="categoryNameTwo" id="categoryNameTwo" style="width:150px;" cssClass="x-layui-input">
									<form:option value="" label="全部"/>
								</form:select>
							</td>
							<td class="coltext">类别三级</th>
							<td class="colinput">
								<form:select path="categoryNameThree" id="categoryNameThree" style="width:150px;" cssClass="x-layui-input">
									<form:option value="" label="全部"/>
								</form:select>
							</td>
						</tr>
						<tr>
							<td class="coltext">申报编码</th>
							<td class="colinput"><form:input path="medicineCode" style="width:150px;" cssClass="x-layui-input"/></td>
							<td class="coltext">通用名</th>
							<td class="colinput"><form:input path="commonName" style="width:150px;" cssClass="x-layui-input"/></td>
							<td class="coltext">商品名</th>
							<td class="colinput"><form:input path="productName" style="width:150px;" cssClass="x-layui-input"/></td>
						</tr>
						<tr class="advanceSearchSection" style="display: none;">
							<td class="coltext">药物级别</th>
							<td class="colinput">
								<form:select path="levelCode" style="width:150px;" cssClass="x-layui-input">
									<form:option value="" label="全部"/>
									<ehr:dicItems dicmeta="FS10242"  />
								</form:select>
							</td>
							<td class="coltext">剂型</th>
							<td class="colinput">
								<form:select path="dosage" style="width:150px;" cssClass="x-layui-input">
									<form:option value="" label="全部"/>
									<form:options items="${dosageList}" />
								</form:select>
							</td>
							<td class="coltext">生产企业</th>
							<td class="colinput"><form:input path="manufactory" style="width:150px;" cssClass="x-layui-input"/></td>

						</tr>
						<tr>
							<td class="righttd" colspan="7">
								<!-- <input type="button" id="btnSearch" value="查询"  class="search_btn" /> -->
								<!-- <input type="button" id="btnReset" value="重置"  class="search_btn" /> -->
								<button class="layui-btn layui-btn-sm" id="btnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
								<button class="layui-btn layui-btn-sm" id="perAdvanceSearchConditionBtn" >&#x60010;高级</button>
							</td>
						</tr>
					</tbody>
				</table>
				<table>
					<tr>
						<td class="colbottom">
							<span class="ico-bottom" onclick="toggle(this,'searchTable')">&nbsp;</span>
						</td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
	<div class="toolbarSection">
		<!-- <a href="javascript:void(0)"  onclick="medicineSearch.showImport()"><b class="shangb">导入 导出</b></a> -->
		<a href="javascript:void(0)" id="btnImpAndExp" ><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导入/导出</button></a>
		<!-- <a href="javascript:void(0)"   id="btnAdd"><b class="xinz" id="btnReflashLabel">添加</b></a> -->
		<a href="javascript:void(0)"   id="btnAdd"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>添加</button></a>
	</div>
	<div id="resultDiv"></div>
</div>