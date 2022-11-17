<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script src="${pageContext.request.contextPath}/js/views/da/daCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/da/daily/inpatientDrug/itemSearch.js" type="text/javascript"></script>
<div class="toolbar">
    <a href="javascript:void(0)" onclick="inpatientDrugSearch.returnSearch()"><b class="fanhui">返回</b></a>
</div>

	
<div class="section"style="margin:10px 0px 0px 0px">
	<div class="searchbox">
		<input type="hidden" id="itemPageIndex" value="${itemPageIndex}">
		<input type="hidden" id="detailHospitalCode" value="${hospitalCode}">
		<input type="hidden" id="prescribeDateBegin" value="${prescribeDateBegin}">
		<input type="hidden" id="prescribeDateEnd" value="${prescribeDateEnd}">
		<input type="hidden" id="totalCostSum" value="${totalCostSum}">		
		<form id="itemSearchForm">
               <table id="itemSearch" >
				<colgroup>
					<col style="min-width:90px; width: 20%;"/>
					<col style="min-width:200px; width: 30%;"/>
                    <col style="min-width:100px; width: 20%;"/>
                    <col style="min-width:100px; width: 30%;"/>
                </colgroup>
				<tbody>
					<tr>
		               	<td class="coltext">机构名称</td>
		                <td class="colinput"><ehr:org  code="${hospitalCode}"/></td>
		               	<td class="coltext">监控期间</td>
		                <td>
		                	${prescribeDateBegin}<c:if test="${not empty prescribeDateBegin || not empty prescribeDateEnd}">~</c:if>${prescribeDateEnd}
		                </td>  
					</tr>				
					<tr>
						<td class="coltext">关键字</td>
                        <td class="colinput">
                        	<input type="text" name="keyword" style="width: 120px;"/>
                        </td>						
                        <td class="lefttd" colspan="2">
                            <input type="button" id="itemBtnSearch" value="查询" class="search_btn"/>
                        </td>                             													
					</tr>
				</tbody>
			</table>
               <table>
                <tr>
                    <td colspan="6" class="colbottom">
                          <span onclick="daCommon.toggle(this,'itemSearch')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
			</table>
		 </form>
	</div>
	<div id="itemResultDiv"></div>
</div>
<div id="itemDetailDiv"></div>

