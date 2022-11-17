<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div class="postdiv">
	<fieldset class="layui-elem-field">
		<legend>巡查指导</legend>
		<input type="hidden" name="inspGuideRecord.id" value="${inspRecord.inspGuideRecord.id}">
		<table class="posttable">
			<colgroup>
				<col style="width: 12%; min-width: 50px;" />
				<col style="width: 38%; min-width: 300px;" />
				<col style="width: 12%; min-width: 50px;" />
				<col style="width: 38%; min-width: 300px;" />
			</colgroup>
			<tr>
				<th><label>巡查内容</label></th>
				<td colspan="3"><c:choose>
						<c:when test="${ not empty inspRecord.id}">
							<c:choose>
								<c:when test="${ inspRecord.inspHealthProfessional =='1'}">
									<div id="hsa-guide-food"><jsp:include page="guide/food.jsp"></jsp:include></div>
								</c:when>
								<c:when test="${ inspRecord.inspHealthProfessional =='2'}">
									<div id="hsa-guide-plocation"><jsp:include page="guide/plocation.jsp"></jsp:include></div>
								</c:when>
								<c:when test="${inspRecord.inspHealthProfessional=='3'&& inspRecord.locationInfo.healthProfessional!=5}">
									<div id="hsa-guide-water"><jsp:include page="guide/water.jsp"></jsp:include></div>
								</c:when>
								<c:when test="${inspRecord.inspHealthProfessional=='3' && inspRecord.locationInfo.healthProfessional==5}">
									<div id="hsa-guide-schoolWater"><jsp:include page="guide/schoolWater.jsp"></jsp:include></div>
								</c:when>
								<c:when test="${ inspRecord.inspHealthProfessional =='5'}">
									<div id="hsa-guide-school"><jsp:include page="guide/idp.jsp"></jsp:include></div>
								</c:when>
								<c:when test="${ inspRecord.inspHealthProfessional =='6'}">
									<div id="hsa-guide-id"><jsp:include page="guide/common.jsp"></jsp:include></div>
								</c:when>
								<c:when test="${ inspRecord.inspHealthProfessional =='7'}">
									<div id="hsa-guide-im"><jsp:include page="guide/common.jsp"></jsp:include></div>
								</c:when>
								<c:when test="${ inspRecord.inspHealthProfessional =='8'}">
									<div id="hsa-guide-jh"><jsp:include page="guide/common.jsp"></jsp:include></div>
								</c:when>
								<c:when test="${ inspRecord.inspHealthProfessional =='9'}">
									<div id="hsa-guide-sy"><jsp:include page="guide/common.jsp"></jsp:include></div>
								</c:when>
								<c:when test="${ inspRecord.inspHealthProfessional =='10'}">
									<div id="hsa-guide-ylwj"><jsp:include page="guide/common.jsp"></jsp:include></div>
								</c:when>
							</c:choose>
						</c:when>
						<c:otherwise>
							<div id="hsa-guide-food" class="${inspRecord.inspHealthProfessional=='1'?'':'hide'}"><jsp:include page="guide/food.jsp"></jsp:include></div>
							<div id="hsa-guide-school" class="${inspRecord.inspHealthProfessional=='5'?'':'hide'}"><jsp:include page="guide/idp.jsp"></jsp:include></div>
							<div id="hsa-guide-plocation" class="${inspRecord.inspHealthProfessional=='2'?'':'hide'}"><jsp:include page="guide/plocation.jsp"></jsp:include></div>
							<div id="hsa-guide-water" class="${inspRecord.inspHealthProfessional=='3'&& inspRecord.locationInfo.healthProfessional!=5?'':'hide'}"><jsp:include page="guide/water.jsp"></jsp:include></div>
							<div id="hsa-guide-schoolWater" class="${inspRecord.inspHealthProfessional=='3' && inspRecord.locationInfo.healthProfessional==5 ?'':'hide'}"><jsp:include page="guide/schoolWater.jsp"></jsp:include></div>
							<div id="hsa-guide-id" class="${inspRecord.inspHealthProfessional=='6'?'':'hide'}"><jsp:include page="guide/common.jsp"></jsp:include></div>
							<div id="hsa-guide-im" class="${inspRecord.inspHealthProfessional=='7'?'':'hide'}"><jsp:include page="guide/common.jsp"></jsp:include></div>
							<div id="hsa-guide-jh" class="${inspRecord.inspHealthProfessional=='8'?'':'hide'}"><jsp:include page="guide/common.jsp"></jsp:include></div>
							<div id="hsa-guide-sy" class="${inspRecord.inspHealthProfessional=='9'?'':'hide'}"><jsp:include page="guide/common.jsp"></jsp:include></div>
							<div id="hsa-guide-ylwj" class="${inspRecord.inspHealthProfessional=='10'?'':'hide'}"><jsp:include page="guide/common.jsp"></jsp:include></div>
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>
	</fieldset>
</div>