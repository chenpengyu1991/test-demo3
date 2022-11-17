<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/womenHealthyCare/womanDiseaseCensus.js" type="text/javascript"></script>
<div class="rightnav">
	<table>
		<tr>
	      	<td class="crumbs"><div id="location" parentMenu="women-health" childMenu="womanDiseaseCensusList">当前位置:&gt;&gt;妇女保健&gt;&gt;妇女病普查</div>
			</td>
	  	</tr>
	 </table>
<div>
	<table class="follow-up-table">
		<thead>
			<tr>
				<th>检查日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${womanDiseaseCensuses}" var="wdc">
				<tr onclick="brwHealthWomanDisCensus.getWomanDisCensus(${wdc.id})" style="cursor: pointer;">
					<td>
						<input type="hidden" value="${wdc.id}" class="WomanDisCensus" />
						<fmt:formatDate value="${wdc.checkDate}" pattern="yyyy/MM/dd"/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div>
	<br/>
	<div id="WomanDisCensusDiv" style="position: relative;"></div>
</div>
</div>