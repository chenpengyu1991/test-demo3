<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%--药库库存 --%>
<script src="${pageContext.request.contextPath}/js/views/da/daCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/da/daily/drugDistribution/detailSearch.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" onclick="drugDistributionSearch.returnSearch()"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon"></i>返回</button></a>
</div>
<div class="section" id="top_all">
	<div class="searchbox searchSection x-admin-sm">
			<input type="hidden" id="organCode" value="${organCode}">
			<input type="hidden" id="medicareCode" value="${medicareCode}">
			<input type="hidden" id="type" value="${type}">
			<input type="hidden" id="beginDt" value="${beginDt}">
			<input type="hidden" id="endDt" value="${endDt}">		
			<input type="hidden" id="itemPageIndex" value="${pageIndex}">		
			<form id="detailSearchForm">
                <table id="detailSearch" >
					<colgroup>
						<col style="min-width:90px; width: 15%;"/>
						<col style="min-width:180px; width: 30%;"/>
	                    <col style="min-width:90px; width: 15%;"/>
						<col style="min-width:180px; width: 30%;"/>
						<col style="min-width:180px; width: 10%;"/>						
	                </colgroup>
					<tbody>
						<tr>
                            <td class="coltext">所属机构</td>
                            <td class="colinput"><ehr:tip><ehr:org  code="${organCode}"/></ehr:tip></td>							
							<td class="coltext">失效日期</td>
							<td class="colinput">
								<input type="text" class="layui-input x-admin-sm-date" name="expiryBeginDt" id="expiryBeginDt" value="<fmt:formatDate value="${expiryBeginDt}" pattern="yyyy/MM/dd"/>" style="padding-left: 0px;width: 38%;" /> ~
								<input type="text" class="layui-input x-admin-sm-date" name="expiryEndDt" id="expiryEndDt" value="<fmt:formatDate value="${expiryEndDt}" pattern="yyyy/MM/dd"/>" style="padding-left: 0px;width: 38%;" />
							</td>
						</tr>
						<tr>
                            <td class="coltext">通用名</td>
                            <td class="colinput">${genericName}</td>  
                            <td class="coltext">批号</td>
                            <td class="colinput">
 								<input type="text" name="batchNo" />
                            </td>
							<td class="righttd">
								<button class="layui-btn layui-btn-sm" id="detailBtnSearch"><i class="layui-icon"></i>查询</button>
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
			elem: '#expiryBeginDt'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});

		laydate.render({
			elem: '#expiryEndDt'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});
	});

</script>
