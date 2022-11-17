<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ihm/idmTarget/search.js" type="text/javascript"></script>

<div class="section">
		<div class="searchbox searchSection x-admin-sm">
			<form id="targetSearchForm">
				<table id="targetSearch">
					<colgroup>
                        <col style="width: 8%; min-width: 70px;"/>
                        <col style="width: 8%; min-width: 70px;"/>
						<col style="width: 8%; min-width: 70px;"/>
                        <col style="width: 22%; min-width: 100px;"/>
                        <col style="width: 8%; min-width: 70px;"/>
                        <col/>
						<col style="width: 10%; min-width: 70px;"/>
					</colgroup>
					<tbody>
						<tr>
                            <td class="col-text">疾病分类</td>
                            <td class="col-input">
                                <select name="viewType" id="viewType">
                                    <option value="1" selected="true">慢性病管理</option>
                                    <option value="2">传染病管理</option>
                                    <option value="3">精神卫生管理</option>
                                </select>
                            </td>
							<td class="col-text">时间dd</td>
							<td class="col-input">
								<tag:dateInput id="beginTime" name="beginTime" style="width: 80px;" date="${startDate}"/>~
                        		<tag:dateInput id="endTime" name="endTime" style="width: 80px;" date="${endDate}"/></td>
							<td class="col-text">机构</td>
							<td class="col-input"> 
								<ehr:authorize ifAnyGranted="01,11">
									<ehr:dic-town-centre-station centreName="inputSuperOrganCode" stationName="" townName="gBCode" width="130px;" />
								</ehr:authorize>
								<ehr:authorize ifAnyGranted="02,03">
									<ehr:user userCode="${currentUser.userCode}" />
								</ehr:authorize>
							</td>
							<td style="text-align: left;">
								<button class="layui-btn layui-btn-sm"  id="targetBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
								</td>
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