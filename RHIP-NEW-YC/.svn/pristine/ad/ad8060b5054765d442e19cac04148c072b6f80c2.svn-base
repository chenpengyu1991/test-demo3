<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:set var="HOSPITAL" value="<%=OrgGenreCode.HOSPITAL.getValue()%>" />
<c:set var="CENTRE" value="<%=OrgGenreCode.CENTRE.getValue()%>" />
<c:set var="STATION" value="<%=OrgGenreCode.STATION.getValue()%>" />
<div id='currentSearch'>
	<input type="hidden" id="resultGenreCode" value="${resultGenreCode}">
	<input type="hidden" id="resultOrganCode" value="${resultOrganCode}">
	<input type="hidden" id="resultSuperOrganCode" value="${resultSuperOrganCode}">
	<input type="hidden" id="resultGbCode" value="${resultGbCode}">
	<input type="hidden" id="resultRangeType" value="${resultRangeType}">
	<input type="hidden" id="resultMonthDate" value="${resultMonthDate}">
	<input type="hidden" id="resultRangeQuarter" value="${resultRangeQuarter}">
	<input type="hidden" id="resultQuarterDate" value="${resultQuarterDate}">
	<input type="hidden" id="resultYearType" value="${resultYearType}">
	<input type="hidden" id="resultYearDate" value="${resultYearDate}">
</div>
<div>
	<input type="hidden" id="chart_orgcode" value="">
	<input type="hidden" id="chart_title" value="">
	<input type="hidden" id="this_data" value="">
	<input type="hidden" id="categories" value="">
	<input type="hidden" id="seriesname" value="">
</div>
<div class="repeattable" style="overflow-x: auto; overflow-y: auto; min-width: 800px; width: 100%; height: 450px;">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<c:choose>
              	<c:when test="${genreCode == '0' }">
              		<col style="min-width:240px;width: 25%;"/>
              	</c:when>
              	<c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
              		<col style="min-width:120px;width: 12%;"/>
              		<col style="min-width:120px;width: 13%;"/>
              	</c:when>
                <c:when test="${genreCode == STATION}">
                  	<col style="min-width:80px;width: 8%;"/>
              		<col style="min-width:80px;width: 8%;"/>
              		<col style="min-width:80px;width: 8%;"/>
                </c:when>
                <c:otherwise>
                	<col style="min-width:100px;width: 10%;"/>
                </c:otherwise>
             </c:choose>
			<col style="min-width:80px;width: 8%;"/>
			<col style="min-width:80px;width: 8%;"/>
			<col style="min-width:80px;width: 8%;"/>
			<col style="min-width:80px;width: 8%;"/>
			<col style="min-width:80px;width: 8%;"/>
			<%-- <col style="min-width:80px;width: 9%;"/> --%>
			<col style="min-width:80px;width: 8%;"/>
			<col style="min-width:80px;width: 8%;"/>
			<col style="min-width:80px;width: 9%;"/>
		</colgroup>	
		<thead>
			<tr>
				<c:choose>
                	<c:when test="${genreCode == '0' }">
                		<th rowspan="2">镇</th>
                	</c:when>
                	<c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
                		<th colspan="2">医疗机构</th>
                	</c:when>
                    <c:when test="${genreCode == STATION}">
                    	<th colspan="3">医疗机构</th>
                    </c:when>
                    <c:otherwise>
                    	<th rowspan="2">医疗机构</th>
                    </c:otherwise>
                </c:choose>
	            <th rowspan="2">人均门急诊人次数</th>
	            <th rowspan="2">人均出院病人床日数</th>
	            <th rowspan="2">门急诊次均费用</th>
	            <th rowspan="2">出院病人次均费用</th>
	            <th rowspan="2">药占比(%)</th>
	            <!-- <th rowspan="2">抗生素使用率</th> -->
	            <th rowspan="2">门急诊点滴处方比例(%)</th>
	            <th rowspan="2">平均处方费用</th>
	            <th rowspan="2">操作</th>
			</tr>
			<tr>
				<c:choose>
                	<c:when test="${genreCode == '0' }">
                	</c:when>
                	<c:when test="${genreCode == HOSPITAL}">
                		<th>镇</th>
                		<th>医院</th>
                	</c:when>
					<c:when test="${genreCode == CENTRE}">
                		<th>镇</th>
                		<th>卫生院</th>
                	</c:when>                	
                    <c:when test="${genreCode == STATION}">
                    	<th>镇</th>
                		<th>中心</th>
                		<th>站</th>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="report" items="${reports}" varStatus="status">
				<tr>
					<c:set var="gbGroup" value="${report.GB_CODE== 'grouping'}"></c:set>
					<c:set var="parentGroup" value="${report.PARENT_CODE== 'grouping'}"></c:set>
					<c:set var="organGroup" value="${report.ORGAN_CODE== 'grouping'}"></c:set>
					<c:set var="colCount" value="0"></c:set>
					<c:if test="${gbGroup}"><c:set var="colCount" value="${colCount+1}"></c:set></c:if>
					<c:if test="${parentGroup}"><c:set var="colCount" value="${colCount+1}"></c:set></c:if>
					<c:if test="${organGroup}"><c:set var="colCount" value="${colCount+1}"></c:set></c:if>
					<c:choose>
						<c:when test="${gbGroup}">
	                		<td colspan="${colCount}"  class="centertd"><b><ehr:tip>合计</ehr:tip></b></td>
	                	</c:when>
	                	<c:when test="${parentGroup}">
	                		<td><ehr:tip><ehr:dic dicmeta="FS990001" code="${report.GB_CODE}"/></ehr:tip></td>
	                		<td colspan="${colCount}"  class="centertd"><b><ehr:tip>合计</ehr:tip></b></td>
	                	</c:when>
	                	<c:when test="${organGroup}">
	                		<td><ehr:tip><ehr:dic dicmeta="FS990001" code="${report.GB_CODE}"/></ehr:tip></td>
	                		<c:if test="${genreCode != HOSPITAL && genreCode != CENTRE}"><td><ehr:tip><ehr:org  code="${report.PARENT_CODE}"/></ehr:tip></td></c:if>
	                		<td class="centertd"><b><ehr:tip>合计</ehr:tip></b></td>
	                	</c:when>
	                	<c:otherwise>
	                		<c:choose>
	                			<c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
	                				<c:if test="${not empty report.GB_CODE && !gbGroup}">
		                				<td><ehr:tip><ehr:dic dicmeta="FS990001" code="${report.GB_CODE}"/></ehr:tip></td>
		                			</c:if>
		                			<c:if test="${not empty report.ORGAN_CODE && !organGroup}">
		                				<td data-is-orgcode = "true" data-orgcode="${report.ORGAN_CODE}"><ehr:tip><ehr:org  code="${report.ORGAN_CODE}"/></ehr:tip></td>
		                			</c:if>	
	                			</c:when>
	                			<c:when test="${genreCode == STATION}">
	                				<c:if test="${not empty report.GB_CODE && !gbGroup}">
				                		<td><ehr:tip><ehr:dic dicmeta="FS990001" code="${report.GB_CODE}"/></ehr:tip></td>
				                	</c:if>
									<c:if test="${not empty report.PARENT_CODE && !parentGroup}">
				                		<td><ehr:tip><ehr:org  code="${report.PARENT_CODE}"/></ehr:tip></td>
				                	</c:if>
				                	<c:if test="${not empty report.ORGAN_CODE && !organGroup}">
				                		<td data-is-orgcode = "true" data-orgcode="${report.ORGAN_CODE}"><ehr:tip><ehr:org  code="${report.ORGAN_CODE}"/></ehr:tip></td>
				                	</c:if>
	                			</c:when>
	                			<c:otherwise>
				                	<c:if test="${not empty report.GB_CODE && !gbGroup}">
				                		<td data-is-orgcode = "true" data-orgcode="${report.GB_CODE}"><ehr:tip><ehr:dic dicmeta="FS990001" code="${report.GB_CODE}"/></ehr:tip></td>
				                	</c:if>
	                			</c:otherwise>
	                		</c:choose>
	                	</c:otherwise>               	
	                </c:choose>
					<td data-is-data="true" data-total-level="0" data-total="${report.outpatientCount}"><tags:numberLabel value="${report.outpatientCount}" defaultValue="0" /></td>
					<td data-is-data="true" data-total-level="1" data-total="${report.avgDays}"><tags:numberLabel value="${report.avgDays}" defaultValue="0" /></td>
					<td data-is-data="true" data-total-level="2" data-total="${report.outpatientCost}"><tags:numberLabel value="${report.outpatientCost}" fractionDigits="2" defaultValue="0" /></td>
					<td data-is-data="true" data-total-level="3" data-total="${report.inpatientCost}"><tags:numberLabel value="${report.inpatientCost}" fractionDigits="2" defaultValue="0" /></td>
					<td data-is-data="true" data-total-level="4" data-total="${report.amountRate}"><tags:numberLabel value="${report.amountRate*100}" fractionDigits="2"  defaultValue="0" /></td>
					<%-- <td><tags:numberLabel value="0" defaultValue="0" /></td> --%>
 					<td data-is-data="true" data-total-level="5" data-total="${report.prescriptionRate}"><tags:numberLabel value="${report.prescriptionRate*100}" fractionDigits="2" defaultValue="0" /></td>
 					<td data-is-data="true" data-total-level="6" data-total="${report.prescriptionTotalAvg}"><tags:numberLabel value="${report.prescriptionTotalAvg}" fractionDigits="2" defaultValue="0" /></td>
 					<td>
 						<c:if test="${!gbGroup && !parentGroup && !organGroup}"><a class="pop" href="javascript:void(0)">图表</a></c:if>
 					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
