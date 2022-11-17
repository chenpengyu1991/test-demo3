<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<div class="repeattable">
    <div id="statisticsDiv" class="contentfixed119" style="margin-top:-50px; ">
	<table>
		<colgroup>
			<col style="width: 230px;min-width:230px;" />
	  		<c:forEach var="th" items="${ths}" varStatus="status">
            	<col style="width: 100px;min-width:100px;" />
            </c:forEach> 
		</colgroup>
		<thead>
			<tr>
				<th class="centerth" colspan="${(fn:length(ths)) +1}">${diseaseType}传染病上报统计 </th>
			</tr>
			<tr>
				<th class="centerth">上报机构</th>
				<c:forEach var="th" items="${ths}" varStatus="status">
	            	<th class="centerth">${th}</th>
	            </c:forEach> 
	        </tr>
		</thead>
	</table>
	
    <table>
        <colgroup>
           	<col style="width: 230px;min-width:230px;" />
	  		<c:forEach var="th" items="${ths}" varStatus="status">
            	<col style="width: 100px;min-width:100px;" />
            </c:forEach> 
        </colgroup>
		<tbody>
			<c:choose>
				<c:when test="${'centerAndStation' eq centerAndStation}">
					<c:forEach var="result" items="${results}" varStatus="status">
						<tr>
							<c:choose>
								<c:when test="${null eq result.ORGAN_CODE}">
			              			<td>合计</td>
			              			<c:forEach var="td" items="${tds}" varStatus="status">
					                	<td class="centertd">${result[td]}</td>
					                </c:forEach> 
				              	</c:when>
				              	<c:otherwise>
		                    		<td><ehr:org code="${result.ORGAN_CODE}"/></td>
		                    		<c:forEach var="td" items="${tds}" varStatus="status">
					                	<td class="centertd">${result[td]}</td>
					                </c:forEach> 
		                    	</c:otherwise>
			                </c:choose>	  
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<c:forEach var="result" items="${results}" varStatus="status">
						<tr>
							<c:choose>
								<c:when test="${null eq result.ORGAN_CODE && '合计'!=result.PARENT_CODE}">
			              			<td><ehr:org code="${result.parent_CODE}"/></td>
			              			<c:forEach var="td" items="${tds}" varStatus="status">
					                	<td class="centertd">${result[td]}</td>
					                </c:forEach> 
				              	</c:when>
				              	<c:when test="${'合计'==result.PARENT_CODE}">
				              	</c:when>
				              	<c:otherwise>
		                    		<td><ehr:org code="${result.ORGAN_CODE}"/></td>
		                    		<c:forEach var="td" items="${tds}" varStatus="status">
					                	<td class="centertd">${result[td]}</td>
					                </c:forEach> 
		                    	</c:otherwise>
			                </c:choose>	  
						</tr>
					</c:forEach>
					<c:forEach var="result" items="${results}" varStatus="status">
						<tr>
							<c:choose>
				              	<c:when test="${'合计'== result.PARENT_CODE}">
			              			<td>${result.parent_CODE}</td>
			              			 <c:forEach var="td" items="${tds}" varStatus="status">
					                	<td class="centertd">${result[td]}</td>
					                 </c:forEach> 
				              	</c:when>
				              	<c:otherwise>
		                    	</c:otherwise>
			                </c:choose>	 
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	</div>
</div>