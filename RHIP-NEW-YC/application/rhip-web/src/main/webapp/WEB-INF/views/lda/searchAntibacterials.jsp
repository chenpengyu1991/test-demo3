<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/lda/antibacterialsSearch.js" type="text/javascript"></script>

<%--统一机构考核搜索--%>
<div>
	<div class="searchBox">
		<input type="hidden" id="pageIndex" value="${pageIndex}">
		<input type="hidden" id="searchUrl" value="${searchUrl}">
		<form id="targetSearchForm">
            <table id="targetSearch">
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
                            <%--卫生局--%>
                            <%--<ehr:authorize ifAnyGranted="01">--%>
                                <%--<c:if test="${empty gbFlag}">--%>
                                    <%--<option value="0">按镇</option>--%>
                                <%--</c:if>--%>
                            <%--</ehr:authorize>--%>
                        </select>
                    </td>
                    <td class="col-text">机构</td>
                    <td class="col-input">
                        <%--卫生局角色--%>
                        <ehr:authorize ifAnyGranted="01">
                            <input type="hidden" id="gbCode" name="gbCode"/>
                            <input type="hidden" id="superOrganCode" name="superOrganCode"/>
                            <input type="hidden" id="organCode" name="organCode"/>
                            <%--市级医院--%>
                            <div id="byHospital">
                                <ehr:org-type-list id="organCode0" name="organCode0" type="hospital" value="${organCode}" code="${organCode}" subsid="0" width="260px"/>
                            </div>
                            <%--卫生院--%>
                            <div id="byCentre">
                                <ehr:dic-town-centre-station centreId="centre1" townId="town1" centreName="superOrganCode1" townName="gbCode1" width="220px;"/>
                            </div>
                            <%--社区服务站--%>
                            <div id="byStation">
                                <ehr:dic-town-centre-station centreId="centre2" townId="town2" stationId="station2" centreName="superOrganCode2" stationName="organCode2" townName="gbCode2" width="33%;" />
                            </div>
                            <%--镇--%>
                            <div id="byTown">
                                <ehr:dic-town-village townId="town3" townName="gbCode3" width="180px"/>
                            </div>
                        </ehr:authorize>
                        <%--市级医院角色--%>
                        <ehr:authorize ifAnyGranted="39">
                            <%--市级医院--%>
                            <div id="byHospital">
                                <input type="hidden" name="organCode" value="${orgCode}"/>
                                <ehr:org  code="${orgCode}"/>
                            </div>
                        </ehr:authorize>
                        <%--卫生院角色--%>
                        <ehr:authorize ifAnyGranted="03">
                            <%--卫生院--%>
                            <div id="byCentre">
                                <input type="hidden" name="superOrganCode" value="${orgCode}"/>
                                <ehr:org  code="${orgCode}"/>
                            </div>
                            <%--社区服务站--%>
                            <div id="byStation">
                                <ehr:dic-org-list name="organCode" width="180px;"/>
                            </div>
                        </ehr:authorize>
                        <%--社区服务站角色--%>
                        <ehr:authorize ifAnyGranted="02">
                            <%--社区服务站--%>
                            <div id="byStation">
                                <input type="hidden" name="organCode" value="${orgCode}"/>
                                <ehr:org  code="${orgCode}"/>
                            </div>
                        </ehr:authorize>
                    </td>

                </tr>
                <tr>
                    <td class="col-text">时间</td>
                    <td class="col-input">
	                    <tag:dateInput id="beginDateA" name="beginDateA" maxId="endDateA" onlypast="true" style="width: 80px;" date="${currentBeginDate}"/>~
	                    <tag:dateInput  id="endDateA" name="endDateA" minId="beginDateA" onlypast="true" style="width: 80px;" date="${currentEndDate}"/></td>
                    <td class="col-text">指标</td>
                    <td class="col-input">
                        <select id="drugType" name="drugType" style="width: 100px">
                            <option value="1">抗菌</option>
                            <option value="2">抗生素</option>
                            <option value="3">麻醉</option>
                            <option value="4">毒性</option>
                        </select>
                    </td>
                    <td>
                        <input type="button" id="targetBtnSearch" value="查询" onclick="" class="search_btn" />
                    </td>
                </tr>
                </tbody>
            </table>
			<table>
				<tr>
					<td colspan="4" class="col-bottom">
						<span onclick="toggle(this,'targetSearch')" class="ico-bottom">&nbsp;</span>
					</td>
				</tr>
			</table>

		</form>
	</div>
	<div id="resultDiv">
		<jsp:include page="${listpath}" ></jsp:include>
	</div>
</div>