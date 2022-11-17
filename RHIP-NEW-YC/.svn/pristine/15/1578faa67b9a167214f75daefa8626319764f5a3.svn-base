<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script src="${pageContext.request.contextPath}/js/views/da/daCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/da/consumable/out/detailSearch.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" onclick="consumableOutSearch.returnSearch()"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
</div>

	
<div class="section"style="margin:10px 0px 0px 0px">
	<div class="searchbox  searchSection x-admin-sm">
		<input type="hidden" id="detailPageIndex" value="${detailPageIndex}">
		<input type="hidden" id="batchNo" value="${batchNo}">
		<form id="detailSearchForm">
               <table id="detailSearch" >
				<colgroup>
					<col style="min-width:90px; width: 20%;"/>
					<col style="min-width:200px; width: 30%;"/>
                    <col style="min-width:100px; width: 20%;"/>
                    <col style="min-width:100px; width: 30%;"/>
                </colgroup>
				<tbody>
					<tr>
		               	<td class="coltext">通用名</td>
		                <td class="colinput">
		                	<input type="text" name="pinying" style="width: 120px;"/>
		                </td>
		               	<td class="coltext">失效日期</td>
		                <td>
							<input type="text" class="layui-input x-admin-sm-date"  name="beginDt" id="beginDt1" style="width:35%;" value="<fmt:formatDate value='${firstDate}' pattern='yyyy/MM/dd'/>">
							~<input type="text" class="layui-input x-admin-sm-date"  name="endDt" id="endDt1" style="width:35%;" value="<fmt:formatDate value='${lastDate}' pattern='yyyy/MM/dd'/>">
		                </td>  
					</tr>				
					<tr>
						<td class="coltext">关键字</td>
                        <td class="colinput">
                        	<input type="text" name="keyword" style="width: 120px;"/>
                        </td>
                        <td class="righttd" colspan="2">
							<button class="layui-btn layui-btn-sm"  id="detailBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                        </td>                             													
					</tr>
				</tbody>
			</table>
               <table>
                <tr>
                    <td colspan="6" class="colbottom">
                          <span onclick="daCommon.toggle(this,'detailSearch')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
			</table>
		 </form>
	</div>
	<div id="detailResultDiv"></div>
</div>
<div id="detailDetailDiv"></div>
<script type="text/javascript">
	layui.use('laydate', function(){
		var laydate = layui.laydate;

		laydate.render({
			elem: '#beginDt1'
			,format: 'yyyy/MM/dd'
			,max: 0
			,trigger: 'click'
		});

		//执行一个laydate实例
		laydate.render({
			elem: '#endDt1'
			,format: 'yyyy/MM/dd'
			,max: 0
			,trigger: 'click'
		});
	});
</script>

