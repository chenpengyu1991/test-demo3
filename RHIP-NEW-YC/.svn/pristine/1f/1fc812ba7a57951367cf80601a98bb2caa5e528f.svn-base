<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/search.js" type="text/javascript"></script>

<div class="section">
		<div class="searchBox">
			<form id="targetSearchForm">
				<table id="targetSearch">
					<colgroup>
						<col style="width: 5%; min-width: 70px;"/>
                        <col style="width: 10%; min-width: 140px;"/>
                        <col style="width: 10%; min-width: 70px;"/>
					</colgroup>
					<tbody>
						<tr>
							<td class="col-text">时间</td>
							<td class="col-input">
								<tag:dateInput id="beginTime" name="beginTime" style="width: 120px;" date="${startDate}"/>~
                        		<tag:dateInput id="endTime" name="endTime" style="width: 120px;" date="${endDate}"/></td>
							<td >
								<input type="button" id="targetBtnSearch" value="查询"  class="search_btn" />
							</td>
						</tr>
					</tbody>
				</table>
				<table>
					<tr>
						<td colspan="3" class="col-bottom"><span onclick="toggle(this,'targetSearch')" class="ico-bottom">&nbsp;</span></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="targetDiv">
			<jsp:include page="list.jsp"/>
		</div>
</div>