<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<%-- <script src="${pageContext.request.contextPath}/js/views/ihm/baseTarget/hr/search.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/baseTarget/hr/hrCommon.js" type="text/javascript"></script> --%>
<!-- <script type="text/javascript">
	 require(['views/ihm/baseTarget/hr/search','views/ihm/baseTarget/hr/hrCommon'],function(search,hrCommon){
		 search.load();
		 hrCommon.load();
	 });
</script> -->

<script src="${pageContext.request.contextPath}/js/views/ihm/baseTarget/hr/hrCommon2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/baseTarget/hr/search2.js" type="text/javascript"></script>

<div class="section">
	<div class="searchbox searchSection x-admin-sm" style="width: 99.5%">
		<input type="hidden" id="queryPath" value="${queryPath}">
		<form id="healthSearchForm">
			<table id="healthSearch">
                <colgroup>
                    <col style="width: 8%; min-width: 55px;"/>
                    <col style="width: 18%; min-width: 100px;"/>
                    <col style="width: 6%; min-width: 45px;"/>
                    <col/>
                    <col style="width: 11%; min-width: 80px;"/>
                </colgroup>
				<tbody>
					<tr>
						<td class="col-text">统计类型</td>
						<td class="col-input">
							<select name="genreCode" id="genreCode" style="width: 130px;">
                                <%--卫生局--%>
                                <ehr:authorize ifAnyGranted="01">
                                    <c:if test="${empty gbFlag}">
                                        <option value="0">按镇</option>
                                    </c:if>
                                </ehr:authorize>
								<%--卫生局,市级医院--%>
								<ehr:authorize ifAnyGranted="01,39">
									<c:if test="${empty hospitalFlag}">
										<option value="A100">按市级医院</option>
									</c:if>
								</ehr:authorize>
								<%--卫生局,卫生院--%>
								<ehr:authorize ifAnyGranted="01,03">
									<c:if test="${empty superOrganFlag}">
										<option value="B100">按卫生院</option>
									</c:if>
								</ehr:authorize>
								<%--卫生局,卫生院,社区服务中心--%>
								<ehr:authorize ifAnyGranted="01,02,03">
									<c:if test="${empty organFlag}">
										<option value="B200">按社区卫生服务站</option>
									</c:if>
								</ehr:authorize>
							</select>
						</td>
						<td class="col-text">机构</td>
						<td class="col-input">
							<%--卫生局角色--%> 
							<ehr:authorize ifAnyGranted="01">
								<input type="hidden" id="gbCode" name="gbCode" />
								<input type="hidden" id="superOrganCode" name="superOrganCode" />
								<input type="hidden" id="organCode" name="organCode" />
								<%--镇--%>
								<div id="byTown">
									<ehr:dic-town-village townId="town3" townName="gbCode3" width="180px" />
								</div>
								<%--市级医院--%>
								<div id="byHospital">
									<ehr:org-type-list id="organCode0" name="organCode0" type="hospital" subsid="0" value="${organCode}" code="${organCode}" width="260px" />
								</div>
								<%--卫生院--%>
								<div id="byCentre">
									<ehr:dic-town-centre-station centreId="centre1" townId="town1" centreName="superOrganCode1" townName="gbCode1" width="220px;" />
								</div>
								<%--社区服务站--%>
								<div id="byStation">
									<ehr:dic-town-centre-station centreId="centre2" townId="town2" stationId="station2" centreName="superOrganCode2" stationName="organCode2" townName="gbCode2" width="33%;" />
								</div>
							</ehr:authorize>
							<%--市级医院角色--%> 
							<ehr:authorize ifAnyGranted="39">
								<%--市级医院--%>
								<div id="byHospital">
									<input type="hidden" name="organCode" value="${orgCode}" />
									<ehr:org code="${orgCode}" />
								</div>
							</ehr:authorize> 
							<%--卫生院角色--%> 
							<ehr:authorize ifAnyGranted="03">
								<%--卫生院--%>
								<div id="byCentre">
									<input type="hidden" name="superOrganCode" value="${orgCode}" />
									<ehr:org code="${orgCode}" />
								</div>
								<%--社区服务站--%>
								<div id="byStation">
									<ehr:dic-org-list name="organCode" width="130px;" />
								</div>
							</ehr:authorize> 
							<%--社区服务站角色--%> 
							<ehr:authorize ifAnyGranted="02">
								<%--社区服务站--%>
								<div id="byStation">
									<input type="hidden" name="organCode" value="${orgCode}" />
									<ehr:org code="${orgCode}" />
								</div>
							</ehr:authorize>
						</td>
						<td style="text-align: left;">
							<button class="layui-btn layui-btn-sm"  id="healthBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td colspan="5" class="col-bottom"><span
						onclick="toggle(this,'healthSearch')" class="ico-bottom">&nbsp;</span>
					</td>
				</tr>
			</table>

		</form>
	</div>
	<div id="healthDiv">
		<jsp:include page="${listpage}"></jsp:include>
	</div>
</div>