<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/cdm/report/tumorYearReport/main.js" type="text/javascript"></script>

<div class="section">
	<%-- <ul id="tags">
		<li class="selectTag"><a id="cdm-year-report-tumor-gender-btn" href="javascript:void(0)">按性别发病统计</a></li>
		<li><a id="cdm-year-report-tumor-age-btn" href="javascript:void(0)">按年龄发病统计</a></li>
		<li><a id="cdm-year-report-tumor-death-gender-btn" href="javascript:void(0)">按性别死亡统计</a></li>
		<li><a id="cdm-year-report-tumor-death-age-btn" href="javascript:void(0)">按年龄死亡统计</a></li>
	</ul>
	<div id="tagContent">
		<div id="tagContent0" class="selectTag">
			<div class="toolbar">
				<a href="javascript:void(0)" id="cdm-year-report-tumor-genger-export"><b class="export">导出</b></a>
			</div>
			<div class="searchbox" style="width: 100%">
				<form id="cdm-year-report-tumor-genger-form">
					<table id="cdm-year-report-tumor-genger-form-table">
						<jsp:include page="form.jsp"></jsp:include>
					</table>
					<table class="toggle-table">
						<tbody>
							<tr>
								<td colspan="6" class="colbottom"><span id ="gengerForm" class="ico-bottom">&nbsp;</span></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<div  class="repeattable" id="cdm-year-report-tumor-genger-content">开发中...</div>
		</div>
		<div id="tagContent1" style="display: none;">
			<div class="toolbar">
				<a href="javascript:void(0)" id="cdm-year-report-tumor-age-export"><b class="export">导出</b></a>
			</div>
			<div class="searchbox" style="width: 100%">
				<form id="cdm-year-report-tumor-age-form">
					<table id="cdm-year-report-tumor-age-form-table">
						<jsp:include page="form.jsp"></jsp:include>
					</table>
					<table class="toggle-table">
						<tbody>
							<tr>
								<td colspan="6" class="colbottom"><span id ="ageForm" class="ico-bottom">&nbsp;</span></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<div class="repeattable" id="cdm-year-report-tumor-age-content"></div>
		</div>
		<div id="tagContent2" style="display: none;">
			<div class="toolbar">
				<a href="javascript:void(0)" id="cdm-year-report-tumor-death-genger-export"><b class="export">导出</b></a>
			</div>
			<div class="searchbox" style="width: 100%">
				<form id="cdm-year-report-tumor-death-genger-form">
					<table id="cdm-year-report-tumor-death-genger-form-table">
						<jsp:include page="form.jsp"></jsp:include>
					</table>
					<table class="toggle-table">
						<tbody>
							<tr>
								<td colspan="6" class="colbottom"><span id ="deathGengerForm" class="ico-bottom">&nbsp;</span></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<div class="repeattable" id="cdm-year-report-tumor-death-genger-content"></div>
		</div>
		<div id="tagContent3" style="display: none;">
			<div class="toolbar">
				<a href="javascript:void(0)" id="cdm-year-report-tumor-death-age-export"><b class="export">导出</b></a>
			</div>
			<div class="searchbox" style="width: 100%">
				<form id="cdm-year-report-tumor-death-age-form">
					<table id="cdm-year-report-tumor-death-age-form-table">
						<jsp:include page="form.jsp"></jsp:include>
					</table>
					<table class="toggle-table">
						<tbody>
							<tr>
								<td colspan="6" class="colbottom"><span id ="deathAgeForm" class="ico-bottom">&nbsp;</span></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<div class="repeattable" id="cdm-year-report-tumor-death-age-content"></div>
		</div>
	</div> --%>
	<div class="layui-tab layui-tab-brief" lay-filter="tumorYearReportTab">
	   <ul class="layui-tab-title">
	    <li class="layui-this">按性别发病统计</li>
	    <li>按年龄发病统计</li>
	    <li>按性别死亡统计</li>
	    <li>按年龄死亡统计</li>
	   </ul>
	<div class="layui-tab-content">
			  <div class="layui-tab-item layui-show" >
			  <div class="toolbar">
				<%-- <a href="javascript:void(0)" id="cdm-year-report-tumor-genger-export"><b class="export">导出</b></a> --%>
				<a href="javascript:void(0)" id="cdm-year-report-tumor-genger-export"><button class="layui-btn layui-btn-sm button" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
			</div>
			<div class="searchbox searchSection x-admin-sm" style="width: 100%">
				<form id="cdm-year-report-tumor-genger-form">
					<table id="cdm-year-report-tumor-genger-form-table">
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
								<%-- <tags:dateInput date="${currentDate}" style="width:120px;" name="year" pattern="yyyy"></tags:dateInput> --%>
								<input type="text" class="layui-input x-admin-content-sm-date" placeholder="选择年份" name="year" id="tumorGenderId" value="<fmt:formatDate value='${currentDate}' pattern='yyyy'/>" style="padding-left: 0px;"/>
								</td>
								<td class="colinput" colspan="2"><input type="radio" checked="checked" name="timeType" value="1" />按报卡日期 <input type="radio" name="timeType"
									value="2"
								/>按诊断日期</td>
								<td class="coltext" colspan="2"></td>
								<td class="colinput" colspan="2"><input class="hide" />
								<button class="layui-btn layui-btn-sm" id="cdm-year-report-tumor-genger-search"><i class="layui-icon">&#xe615;</i>查询</button>
								</td>
							</tr>
						</tbody>
					</table>
					<table class="toggle-table">
						<tbody>
							<tr>
								<td colspan="6" class="colbottom"><span id ="gengerForm" class="ico-bottom">&nbsp;</span></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<div  class="repeattable" id="cdm-year-report-tumor-genger-content">开发中...</div>
		</div>
    		<div class="layui-tab-item" >
    		<div class="toolbar">
				<%-- <a href="javascript:void(0)" id="cdm-year-report-tumor-age-export"><b class="export">导出</b></a> --%>
				<a href="javascript:void(0)" id="cdm-year-report-tumor-age-export"><button class="layui-btn layui-btn-sm button" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
			</div>
			<div class="searchbox searchSection x-admin-sm" style="width: 100%">
				<form id="cdm-year-report-tumor-age-form">
					<table id="cdm-year-report-tumor-age-form-table">
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
								<%-- <tags:dateInput date="${currentDate}" style="width:120px;" name="year" pattern="yyyy"></tags:dateInput> --%>
								<input type="text" class="layui-input x-admin-content-sm-date" placeholder="选择年份" name="year" id="tumorAgeId" value="<fmt:formatDate value='${currentDate}' pattern='yyyy'/>" style="padding-left: 0px;"/>
								</td>
								<td class="colinput" colspan="2"><input type="radio" checked="checked" name="timeType" value="1" />按报卡日期 <input type="radio" name="timeType"
									value="2"
								/>按诊断日期</td>
								<td class="coltext" colspan="2"></td>
								<td class="colinput" colspan="2"><input class="hide" />
								<%-- <input id="cdm-year-report-cdm-genger-search" type="button" class="button search_btn" value="查询" /> --%>
								<button class="layui-btn layui-btn-sm" id="cdm-year-report-tumor-age-search"><i class="layui-icon">&#xe615;</i>查询</button>
								</td>
							</tr>
						</tbody>
					</table>
					<table class="toggle-table">
						<tbody>
							<tr>
								<td colspan="6" class="colbottom"><span id ="ageForm" class="ico-bottom">&nbsp;</span></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<div class="repeattable" id="cdm-year-report-tumor-age-content"></div>
          </div>
          <div class="layui-tab-item" >
          	<div class="toolbar">
				<%-- <a href="javascript:void(0)" id="cdm-year-report-tumor-death-genger-export"><b class="export">导出</b></a> --%>
				<a href="javascript:void(0)" id="cdm-year-report-tumor-death-genger-export"><button class="layui-btn layui-btn-sm button" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
			</div>
			<div class="searchbox searchSection x-admin-sm" style="width: 100%">
				<form id="cdm-year-report-tumor-death-genger-form">
					<table id="cdm-year-report-tumor-death-genger-form-table">
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
								<%-- <tags:dateInput date="${currentDate}" style="width:120px;" name="year" pattern="yyyy"></tags:dateInput> --%>
								<input type="text" class="layui-input x-admin-content-sm-date" placeholder="选择年份" name="year" id="tumorDeathGenderId" value="<fmt:formatDate value='${currentDate}' pattern='yyyy'/>" style="padding-left: 0px;"/>
								</td>
								<td class="colinput" colspan="2"><input type="radio" checked="checked" name="timeType" value="1" />按报卡日期 <input type="radio" name="timeType"
									value="2"
								/>按诊断日期</td>
								<td class="coltext" colspan="2"></td>
								<td class="colinput" colspan="2"><input class="hide" />
								<%-- <input id="cdm-year-report-cdm-genger-search" type="button" class="button search_btn" value="查询" /> --%>
								<button class="layui-btn layui-btn-sm" id="cdm-year-report-tumor-death-genger-search"><i class="layui-icon">&#xe615;</i>查询</button>
								</td>
							</tr>
						</tbody>
					</table>
					<table class="toggle-table">
						<tbody>
							<tr>
								<td colspan="6" class="colbottom"><span id ="deathGengerForm" class="ico-bottom">&nbsp;</span></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<div class="repeattable" id="cdm-year-report-tumor-death-genger-content"></div>
          </div>
          <div class="layui-tab-item" >
    		<div class="toolbar">
				<%-- <a href="javascript:void(0)" id="cdm-year-report-tumor-death-age-export"><b class="export">导出</b></a> --%>
				<a href="javascript:void(0)" id="cdm-year-report-tumor-death-age-export"><button class="layui-btn layui-btn-sm button" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
			</div>
			<div class="searchbox searchSection x-admin-sm" style="width: 100%">
				<form id="cdm-year-report-tumor-death-age-form">
					<table id="cdm-year-report-tumor-death-age-form-table">
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
								<%-- <tags:dateInput date="${currentDate}" style="width:120px;" name="year" pattern="yyyy"></tags:dateInput> --%>
								<input type="text" class="layui-input x-admin-content-sm-date" placeholder="选择年份" name="year" id="tumorDeathAgeId" value="<fmt:formatDate value='${currentDate}' pattern='yyyy'/>" style="padding-left: 0px;" />
								</td>
								<td class="colinput" colspan="2"><input type="radio" checked="checked" name="timeType" value="1" />按报卡日期 <input type="radio" name="timeType"
									value="2"
								/>按诊断日期</td>
								<td class="coltext" colspan="2"></td>
								<td class="colinput" colspan="2"><input class="hide" />
								<%-- <input id="cdm-year-report-cdm-genger-search" type="button" class="button search_btn" value="查询" /> --%>
								<button class="layui-btn layui-btn-sm" id="cdm-year-report-tumor-death-age-search"><i class="layui-icon">&#xe615;</i>查询</button>
								</td>
							</tr>
						</tbody>
					</table>
					<table class="toggle-table">
						<tbody>
							<tr>
								<td colspan="6" class="colbottom"><span id ="deathAgeForm" class="ico-bottom">&nbsp;</span></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<div class="repeattable" id="cdm-year-report-tumor-death-age-content"></div>
          </div>
	 </div>
  </div>
</div>

<script>
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
//一些事件监听
  element.on('tab(tumorYearReportTab)', function(data){
      if (data.index == 0) {
    	  tumorYearReport_main.tumorYearReportsByGenger();
      } else if(data.index == 1) {
    	  tumorYearReport_main.tumorYearReportByAge();
      } else if(data.index == 2) {
    	  tumorYearReport_main.tumorDeathYearReportsByGenger();
      } else if(data.index == 3) {
    	  tumorYearReport_main.tumorDeathYearReportByAge();
      } 
  });
  
  layui.use('laydate', function(){
      var laydate = layui.laydate;
      
      //执行一个laydate实例
      laydate.render({
        elem: '#tumorGenderId' 
     	   ,type: 'year'
     	   ,max:0
      });

      laydate.render({
          elem: '#tumorAgeId' 
       	   ,type: 'year'
       	   ,max:0
        });
      
      laydate.render({
          elem: '#tumorDeathGenderId' 
       	   ,type: 'year'
       	   ,max:0
        });
      
      laydate.render({
          elem: '#tumorDeathAgeId' 
       	   ,type: 'year'
       	   ,max:0
        });
      
    });
  
  
  
});
</script>
