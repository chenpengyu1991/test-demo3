<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/ihm/heTarget/search.js" type="text/javascript"></script>

<div class="section">
		<div class="searchBox">
			<form id="targetSearchForm">
				<table id="targetSearch">
					<colgroup>
						<col style="width: 10%; min-width: 70px;"/>
                        <col style="width: 30%; min-width: 140px;"/>
                        <col style="width: 10%; min-width: 70px;"/>
                        <col style="width: 40%; min-width: 100px;"/>
						<col style="width: 10%; min-width: 70px;"/>
					</colgroup>
					<tbody>
						<tr>
							<td class="col-text">时间</td>
							<td class="col-input">
								<tag:dateInput id="beginTime" name="beginTime" style="width: 120px;" date="${startDate}"/>~
                        		<tag:dateInput id="endTime" name="endTime" style="width: 120px;"  date="${endDate}"/></td>
							<td class="col-text">机构</td>
							<td class="col-input"> 
							<ehr:authorize ifAnyGranted="01,11">
									<ehr:dic-town-centre-station centreName="inputSuperOrganCode" stationName="" townName="gBCode" width="130px;" />
								</ehr:authorize>
								<ehr:authorize ifAnyGranted="02,03">
									<ehr:user userCode="${currentUser.id}" />
								</ehr:authorize>
							</td>
							<td style="text-align: right;">
								<input type="button" id="targetBtnSearch" value="查询" onclick="" class="search_btn" /></td>
						</tr>
					</tbody>
				</table>
				<table>
					<tr>
						<td colspan="4" class="col-bottom"><span
							onclick="toggle(this,'targetSearch')"
							class="ico-bottom">&nbsp;</span></td>
					</tr>
				</table>

			</form>
		</div>

		<div id="targetDiv">
			<jsp:include page="list.jsp"/>
		</div>
</div>