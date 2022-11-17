<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/cdm/report/yearReport/main.js"></script>
<div class="section">
	<%-- <ul id="tags">
		<li class=selectTag><a id="cdm-year-report-cdm-gender-btn" href="javascript:void(0)">按性别发病统计</a></li>
		<li><a id="cdm-year-report-cdm-age-btn" href="javascript:void(0)">按年龄发病统计</a></li>
	</ul>
	<div id="tagContent">
		<div id="tagContent1" class="selectTag" style="display: none;">
			<div id="top_allRegister">
				<div class="toolbar">
					<a href="javascript:void(0)" id="cdm-year-report-cdm-age-export"><b class="export">导出</b></a>
				</div>
				<div class="searchbox" style="width: 100%">
					<form id="cdm-year-report-cdm-age-form">
						<table id="cdm-year-report-cdm-age-form-table">
							<colgroup>
								<col style="width: 8%;">
								<col style="width: 16.5%;">
								<col style="width: 8%;">
								<col style="width: 16.5%;">
								<col style="width: 8%;">
								<col style="width: 16.5%;">
								<col style="width: 8%;">
								<col style="width: 16.5%;">
								<col style="width: 8%;">
								<col style="width: 16.5%;">

							</colgroup>
							<tbody>
								<tr>
									<td class="coltext">年份</td>
									<td class="colinput"><tag:dateInput date="${currentDate}" style="width:120px;" name="year" pattern="yyyy"></tag:dateInput></td>
									<td class="colinput" colspan="2"><input type="radio" checked="checked" name="timeType" value="1" />按报卡日期 <input type="radio" name="timeType" value="2" />按诊断日期
									</td>
									<td class="coltext">性别</td>
									<td class="colinput" ><ehr:dic-list uninclude="0,9" dicmeta="GBT226112003"  name="gender"/></td>
									<td class="colinput" colspan="2" ><input class="hide" /><input id="cdm-year-report-cdm-age-search" type="button" class="button search_btn" value="查询" /></td>
								</tr>
							</tbody>
						</table>
						<table>
							<tbody>
								<tr>
									<td colspan="6" class="colbottom"><span onclick="cdmYearReport.toggle(this,'cdm-year-report-cdm-age-form-table')" class="ico-bottom">&nbsp;</span></td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
			<div class="repeattable" id="cdm-year-report-cdm-age-content"></div>
		</div>
		<div id="tagContent0">
			<div id="top_allRegister">
				<div class="toolbar">
					<a href="javascript:void(0)" id="cdm-year-report-cdm-genger-export"><b class="export">导出</b></a>
				</div>
				<div class="searchbox" style="width: 100%">
					<form id="cdm-year-report-cdm-genger-form">
						<table id="cdm-year-report-cdm-genger-form-table">
							<colgroup>
								<col style="width: 8%;">
								<col style="width: 16.5%;">
								<col style="width: 8%;">
								<col style="width: 16.5%;">
								<col style="width: 8%;">
								<col style="width: 16.5%;">
								<col style="width: 8%;">
								<col style="width: 16.5%;">
								<col style="width: 8%;">
								<col style="width: 16.5%;">
							</colgroup>
							<tbody>
								<tr>
									<td class="coltext">年份</td>
									<td class="colinput"><tag:dateInput date="${currentDate}" style="width:120px;" name="year" pattern="yyyy"></tag:dateInput></td>
									<td class="colinput" colspan="2"><input type="radio" checked="checked" name="timeType" value="1" />按报卡日期 <input type="radio" name="timeType" value="2" />按诊断日期
									</td>
									<td colspan="2"></td>
									<td colspan="2"><input id="cdm-year-report-cdm-genger-search" type="button" class="button search_btn" value="查询" /></td>
								</tr>
							</tbody>
						</table>
						<table>
							<tbody>
								<tr>
									<td colspan="6" class="colbottom"><span onclick="cdmYearReport.toggle(this,'cdm-year-report-cdm-genger-form-table')" class="ico-bottom">&nbsp;</span></td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
			<div class="repeattable" id="cdm-year-report-cdm-genger-content"></div>
		</div>
	</div> --%>
	
	<div class="layui-tab layui-tab-brief" lay-filter="cdmYearReportTab">
	   <ul class="layui-tab-title">
	    <li class="layui-this">按性别发病统计</li>
	    <li>按年龄发病统计</li>
	   </ul>
	<div class="layui-tab-content">
			  <div class="layui-tab-item layui-show" >
			    <div id="top_allRegister">
				<div class="toolbar">
					<%-- <a href="javascript:void(0)" id="cdm-year-report-cdm-genger-export"><b class="export">导出</b></a> --%>
					<a href="javascript:void(0)" id="cdm-year-report-cdm-genger-export"><button class="layui-btn layui-btn-sm button" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
				</div>
				<div class="searchbox searchSection x-admin-sm" style="width: 100%">
					<form id="cdm-year-report-cdm-genger-form">
						<table id="cdm-year-report-cdm-genger-form-table">
							<colgroup>
								<col style="width: 8%;">
								<col style="width: 16.5%;">
								<col style="width: 8%;">
								<col style="width: 16.5%;">
								<col style="width: 8%;">
								<col style="width: 16.5%;">
								<col style="width: 8%;">
								<col style="width: 16.5%;">
								<col style="width: 8%;">
								<col style="width: 16.5%;">
							</colgroup>
							<tbody>
								<tr>
									<td class="coltext">年份</td>
									<td class="colinput">
									<%-- <tag:dateInput date="${currentDate}" style="width:120px;" name="year" pattern="yyyy"></tag:dateInput> --%>
									<input type="text" class="layui-input x-admin-sm-date" placeholder="选择年份" name="year" id="yearIdByGenderQuery" value="<fmt:formatDate value='${currentDate}' pattern='yyyy'/>" style="padding-left: 0px;"/>
									</td>
									<td class="colinput" colspan="2"><input type="radio" checked="checked" name="timeType" value="1" />按报卡日期 <input type="radio" name="timeType" value="2" />按诊断日期
									</td>
									<td colspan="2"></td>
									<td colspan="2">
									<%-- <input id="cdm-year-report-cdm-genger-search" type="button" class="button search_btn" value="查询" /> --%>
									<button class="layui-btn layui-btn-sm" id="cdm-year-report-cdm-genger-search"><i class="layui-icon">&#xe615;</i>查询</button>
									</td>
								</tr>
							</tbody>
						</table>
						<table>
							<tbody>
								<tr>
									<td colspan="6" class="colbottom"><span onclick="cdmYearReport.toggle(this,'cdm-year-report-cdm-genger-form-table')" class="ico-bottom">&nbsp;</span></td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
			<div class="repeattable" id="cdm-year-report-cdm-genger-content"></div>
		</div>
    		<div class="layui-tab-item" >
    			<div id="top_allRegister">
				<div class="toolbar">
					<%-- <a href="javascript:void(0)" id="cdm-year-report-cdm-age-export"><b class="export">导出</b></a> --%>
					<a href="javascript:void(0)" id="cdm-year-report-cdm-age-export"><button class="layui-btn layui-btn-sm button" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
				</div>
				<div class="searchbox searchSection x-admin-sm" style="width: 100%">
					<form id="cdm-year-report-cdm-age-form">
						<table id="cdm-year-report-cdm-age-form-table">
							<colgroup>
								<col style="width: 8%;">
								<col style="width: 16.5%;">
								<col style="width: 8%;">
								<col style="width: 16.5%;">
								<col style="width: 8%;">
								<col style="width: 16.5%;">
								<col style="width: 8%;">
								<col style="width: 16.5%;">
								<col style="width: 8%;">
								<col style="width: 16.5%;">

							</colgroup>
							<tbody>
								<tr>
									<td class="coltext">年份</td>
									<td class="colinput">
									<%-- <tag:dateInput date="${currentDate}" style="width:120px;" name="year" pattern="yyyy"></tag:dateInput> --%>
									<input type="text" class="layui-input x-admin-sm-date" placeholder="选择年份" name="year" id="yearIdByAgeQuery" value="<fmt:formatDate value='${currentDate}' pattern='yyyy'/>" style="padding-left: 0px;" />
									</td>
									<td class="colinput" colspan="2"><input type="radio" checked="checked" name="timeType" value="1" />按报卡日期 <input type="radio" name="timeType" value="2" />按诊断日期
									</td>
									<td class="coltext">性别</td>
									<td class="colinput" ><ehr:dic-list uninclude="0,9" dicmeta="GBT226112003"  name="gender"/></td>
									<td class="colinput" colspan="2" ><input class="hide" />
									<%-- <input id="cdm-year-report-cdm-age-search" type="button" class="button search_btn" value="查询" /> --%>
									<button class="layui-btn layui-btn-sm" id="cdm-year-report-cdm-age-search"><i class="layui-icon">&#xe615;</i>查询</button>
									</td>
								</tr>
							</tbody>
						</table>
						<table>
							<tbody>
								<tr>
									<td colspan="6" class="colbottom"><span onclick="cdmYearReport.toggle(this,'cdm-year-report-cdm-age-form-table')" class="ico-bottom">&nbsp;</span></td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
			<div class="repeattable" id="cdm-year-report-cdm-age-content"></div>
          </div>
	 </div>
  </div>
</div>
<script>
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
//一些事件监听
  element.on('tab(cdmYearReportTab)', function(data){
      if (data.index == 0) {
    	  cdmYearReport.getGengerResult();
      } else if(data.index == 1) {
    	  cdmYearReport.getAgeResult();
      } 
  });
  
  layui.use('laydate', function(){
      var laydate = layui.laydate;
      
      //执行一个laydate实例
      laydate.render({
        elem: '#yearIdByGenderQuery' 
     	   ,type: 'year'
     	   ,max:0
      });

      laydate.render({
          elem: '#yearIdByAgeQuery' 
       	   ,type: 'year'
       	   ,max:0
        });
      
    });
});
</script>