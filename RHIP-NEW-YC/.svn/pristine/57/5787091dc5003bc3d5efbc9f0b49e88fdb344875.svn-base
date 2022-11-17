<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){

		// 高级查询条件显示控制
		$("#perAdvanceSearchConditionBtn").click(function(e) {
			e.preventDefault();
			controlAdvanceSearchSection($(this));
		});
	});
</script>
<div class="section" id="fdm-report-list-box">
	<div class="toolbar">
		<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">食源性疾病</a>
		        <a>
		          <cite>报卡审核</cite></a>
		      </span>
		</div>
	</div>
	<div class="searchbox searchSection x-admin-sm">
		<form method="post" id="fdm-report-list-search-form">
			<input type="hidden" id="selectFlagInput" name="selectFlagName" value="0" />
			<table id="reportSearch">
				<colgroup>
					<col style="min-width: 70px;width:10%">
					<col style="min-width: 150px;width:25%">
					<col style="min-width: 60px;width:8%">
					<col style="min-width: 140px;width:23%">
					<col style="min-width: 70px;width:10%">
					<col style="min-width: 140px;width:23%">
				</colgroup>
				<tbody>
				<tr>
					<td class="coltext" >姓名</td>
					<td class="colinput"><input type="text" name="name" id="personName" class="x-layui-input"/></td>
					<td class="coltext" >身份证号</td>
					<td class="colinput">	<tag:idcardInput name="idcard"  style="ime-mode:Disabled;" cssClass="x-layui-input"></tag:idcardInput></td>
					<td class="coltext">性别</td>
					<td class="colinput">
						<ehr:dic-list dicmeta="GBT226112003"  name="gender" cssClass="x-layui-input"/>
					</td>

				</tr>
				<tr>
					<td class="coltext" >上报时间</td>
					<td class="colinput">
						<%-- <tag:dateInput name="reportCreateStartDate" id="reportCreateStartDate" onlypast="true" reg="{'required':true}" style="width:35%;"/>
						~
						<tag:dateInput name="reportCreateEndDate" id="reportCreateEndDate" onlypast="true" reg="{'required':true}" style="width:35%;"/> --%>
						
						<input type="text" class="layui-input x-admin-sm-date"  name="reportCreateStartDate" id="reportCreateStartDate" style="padding-left: 0px;width:35%;" /> ~
                            <input type="text" class="layui-input x-admin-sm-date"  name="reportCreateEndDate" id="reportCreateEndDate" style="padding-left: 0px;width:35%;" />
					</td>

					<td class="coltext">年龄段</td>
					<td class="colinput">
						<tag:numberInput maxlength="3" style="width:35%;"  name="startAge" id="startAge"  cssClass="x-layui-input"/> ~
						<tag:numberInput maxlength="3"  style="width:35%;"   name="endAge" id="endAge"  cssClass="x-layui-input"/> 岁
					</td>

					<td class="coltext">
						<ehr:authorize ifAnyGranted="01,13">
							上报机构
						</ehr:authorize>
					</td>
					<td class="colinput">
						<ehr:authorize ifAnyGranted="01,13">
							<ehr:org-type-list id="createOrganCode" name="reportCreateOrganCode" type="hospital,centre" cssClass="x-layui-input"></ehr:org-type-list>
						</ehr:authorize>
					</td>
				</tr>
				<tr class="advanceSearchSection" style="display: none;">

					<td class="coltext"  >状态</td>
					<td>
						<%--疾控检验科默认查询已填写检验结果和防保科修改的记录   （待审核）--%>
						<ehr:dic-list  dicmeta="DMD00085"  name="reportStatus" uninclude="3"/>
						<%--<select name="reportStatus">--%>
						<%--<option value="">请选择</option>--%>
						<%--<option value="1">报卡已填写</option>--%>
						<%--<option value="2">防保科审核通过</option>--%>
						<%--<option value="3">检验结果已填写</option>--%>
						<%--<option value="4">疾控审核通过</option>--%>
						<%--<option value="5">防保科审核不通过</option>--%>
						<%--<option value="6">疾控打回</option>--%>
						<%--<option value="7">防保科已修改</option>--%>
						<%--<option value="8">疾控审核作废</option>--%>
						<%--</select>--%>
					</td>
					<td colspan="4"></td>
				</tr>
				<tr>
					<td class="righttd" colspan="6">
						<button class="layui-btn layui-btn-sm" id="reportCard_search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
						<button class="layui-btn layui-btn-sm" id="perAdvanceSearchConditionBtn"  ><i class="iconfont">&#x60010;</i>高级</button>
					</td>
				</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td colspan="6" class="colbottom"><span onclick="$(this).toggleClass('ico-top').toggleClass('ico-bottom');$('#reportSearch').toggle();" class="ico-bottom">&nbsp;</span></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="fdm-report-list-result" class="repeattable"></div>
</div>
<div id="fdm-report-list-view-box" class="postdiv"></div>
<script type="text/javascript">
	var fdReportCardSearch = (function() {
		$(function() {
			$("#fdm-report-list-search-form").onEnter(search, 1);
			$("#reportCard_search_btn").click(function(e) {
				e.preventDefault();
				search(1);
			});
			$("#fdm-report-list-result").on("click",".view",view);
			$("#fdm-report-list-result").on("click",".edit",edit);
			$("#fdm-report-list-result").on("click",".testResult",testResult);
			$("#fdm-report-list-result").on("click",".lastAuth",lastAuth);
			search(1);
		});

		var currentIndexPage = 1;

		function search(indexPage) {
			currentIndexPage = indexPage;
			var searchObj = {
				url : "/fdm/reportCard/listResult",
				insertDiv : "fdm-report-list-result",
				param : {
					indexPage : indexPage
				}
			};
			$("#fdm-report-list-search-form").submitFormLoadHtml(searchObj);
		}

		function refresh() {
			search(currentIndexPage);
		}

		function sendCommond(url, param, message, callback) {
			var p = param || {};
			var option = {
				url : url,
				param : p,
				callback : function(data) {
					if (true == data) {
						layer.alert(message + "成功！", {icon:0,title:'提示'}, function(index) {
							if (callback) {
								callback();
							}
							layer.close(index);
						});
						
					} else {
						layer.alert(message + "失败！", {icon:0,title:'提示'});
					}
				}
			};
			$.getJsonByUrl(option);
		}

		function app(id) {
			layer.confirm("确定通过吗?", function(index) {
				sendCommond("/fdm/reportCard/app", {
					id : id
				}, "审核", refresh);
				layer.close(index);
			});
		}

		function back(){
			$("#fdm-report-list-view-box").hide();
			$("#fdm-report-list-box").show();
		}

		function come(){
			$("#fdm-report-list-box").hide();
			$("#fdm-report-list-view-box").show();
		}

		function view() {
			come();
			var id=$(this).data("id");
			var loadHtmlByUrlOption = {
				url : "/fdm/reportCard/view",
				insertDiv : "fdm-report-list-view-box",
				param : {
					id : id
				}
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);

		}

		function edit() {
			come();
			var id=$(this).data("id");
			var loadHtmlByUrlOption = {
				url : "/fdm/reportCard/edit",
				insertDiv : "fdm-report-list-view-box",
				param : {
					id : id
				}
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		}

		function testResult(){
			come();
			var id=$(this).data("id");
			var loadHtmlByUrlOption = {
				url : "/fdm/reportCard/initTestResult",
				insertDiv : "fdm-report-list-view-box",
				param : {
					id : id
				}
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		}

		function lastAuth(){
			come();
			var id=$(this).data("id");
			var loadHtmlByUrlOption = {
				url : "/fdm/reportCard/lastAuth",
				insertDiv : "fdm-report-list-view-box",
				param : {
					id : id
				}
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		}

		function print(reportId) {
			var url = contextPath + "/fdm/reportCard/printReport?id=" + reportId;
			util.printPage(url);
			//hmStudentExamSearch.search($("#_indexPage").val());
		}

		return {
			search : search,
			view : view,
			edit : edit,
			app : app,
			back:back,
			come:come,
			refresh : refresh,
			print : print,
			testResult : testResult
		};
	})();
	
	layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#reportCreateStartDate' 
       	   ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

        laydate.render({
          elem: '#reportCreateEndDate'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });
        
      });
</script>
