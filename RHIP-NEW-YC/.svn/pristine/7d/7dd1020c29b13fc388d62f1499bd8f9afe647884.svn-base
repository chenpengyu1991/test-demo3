<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script src="${pageContext.request.contextPath}/js/views/da/daCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/da/drug/pharmacyIn/detailSearch.js" type="text/javascript"></script>
<div class="toolbar">
	<button href="javascript:void(0)" onclick="pharmacyInSearch.returnSearch()" class="btn-gray layui-btn layui-btn-sm button" onclick=""><i class="layui-icon"></i>返回</button>
</div>
	
<div class="section"style="margin:10px 0px 0px 0px">
	<div class="searchbox searchSection x-admin-sm">
		<input type="hidden" id="detailPageIndex" value="${detailPageIndex}">
		<input type="hidden" id="batchNo" value="${batchNo}">
		<form id="detailSearchForm">
               <table id="detailSearch" >
				<colgroup>
					<col style="min-width:90px; width: 20%;"/>
					<col style="min-width:200px; width: 25%;"/>
                    <col style="min-width:100px; width: 20%;"/>
                    <col style="min-width:100px; width: 25%;"/>
					<col style="min-width:100px; width: 10%;"/>
                </colgroup>
				<tbody>
					<tr>
		               	<td class="coltext">通用名</td>
		                <td class="colinput">
		                	<input type="text" name="drugGenericName"/>
		                </td>
<%--		               	<td class="coltext">失效日期</td>--%>
<%--		                <td>--%>
<%--							<input type="text" class="layui-input x-admin-sm-date"  name="beginDt" id="beginDt" style="width:33%;" value="<fmt:formatDate value='${firstDate}' pattern='yyyy/MM/dd'/>"> ~--%>
<%--							<input type="text" class="layui-input x-admin-sm-date"  name="endDt" id="endDt" style="width:33%;" value="<fmt:formatDate value='${lastDate}' pattern='yyyy/MM/dd'/>">--%>
<%--						</td>--%>
						<td class="coltext">关键字</td>
						<td class="colinput">
							<input type="text" name="keyword"/>
						</td>
						<td class="coltext">
							<button class="layui-btn layui-btn-sm" id="detailBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
						</td>
					</tr>				
<%--					<tr>--%>
<%--						<td class="coltext">关键字</td>--%>
<%--                        <td class="colinput">--%>
<%--                        	<input type="text" name="keyword"/>--%>
<%--                        </td>						--%>
<%--                        <td class="coltext" colspan="2">--%>
<%--							<button class="layui-btn layui-btn-sm" id="detailBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>--%>
<%--						</td>--%>
<%--					</tr>--%>
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
		//执行一个laydate实例
		laydate.render({
			elem: '#detailSearchForm #beginDt'
			,format: 'yyyy/MM/dd'
			,max:0
		});

		//执行一个laydate实例
		laydate.render({
			elem: '#detailSearchForm #endDt'
			,format: 'yyyy/MM/dd'
			,max:0
		});
	});
</script>