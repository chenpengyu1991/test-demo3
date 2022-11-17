<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/pam/organ/search.js" type="text/javascript"></script>

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
                            <%--<ehr:authorize ifAnyGranted="01,02,03">--%>
                                <%--<c:if test="${empty organFlag}">--%>
                                    <%--<option value="B2">按社区卫生服务站</option>--%>
                                <%--</c:if>--%>
                            <%--</ehr:authorize>--%>
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
                                <ehr:org-type-list id="organCode0" name="organCode0" type="hospital" value="${organCode}" code="${organCode}" width="260px"/>
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
                    <td rowspan="2">
                        <input type="button" id="targetBtnSearch" value="查询" onclick="" class="search_btn" />
                    </td>
                </tr>
                <c:if test="${empty timeRangeFlag}">
                    <tr>
                        <td class="col-text">时间类型</td>
                        <td class="col-input">
                            <select name="rangeType" id="rangeType" style="width: 130px;">
                                <c:if test="${empty monthRangeFlag}"><option value="1">按月</option></c:if>
                                <c:if test="${empty quarterRangeFlag}"><option value="2">按季度</option></c:if>
                                <c:if test="${empty yearRangeFlag}"><option value="3">按年</option></c:if>
                             </select>
                        </td>
                        <td class="col-text">时间</td>
                        <td class="col-input">
                            <input type="hidden" id="beginDate" name="beginDate"/>
                            <input type="hidden" id="endDate" name="endDate"/>
                            <div id="byMonth">
                                <tag:dateInput name="monthDate" pattern="yyyy/MM" id="beginDate1" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/>
                            </div>
                            <div id="byQuarter">
                                <tag:dateInput name="quarterDate" pattern="yyyy" id="beginDate2" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/>
                                <select name="rangeQuarter" id="rangeQuarter" style="width: 80px;">
                                    <option value="1">第一季度</option>
                                    <option value="2">第二季度</option>
                                    <option value="3">第三季度</option>
                                    <option value="4">第四季度</option>
                                </select>
                            </div>
                            <div id="byYear">
                                <tag:dateInput name="yearDate" pattern="yyyy" id="beginDate3" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/>
                                <c:if test="${empty fullYearFlag}"><input type="radio" id="yearType1" name="yearType"  class="radioGroup" value="1" /><label for="yearType1">全年</label></c:if>
                                <c:if test="${empty firstHalfYearFlag}"><input type="radio" id="yearType2" name="yearType"  class="radioGroup" value="2" /><label for="yearType2">上半年</label></c:if>
                                <c:if test="${empty secondHalfYearFlag}"><input type="radio" id="yearType3" name="yearType"  class="radioGroup" value="3" /><label for="yearType3">下半年</label></c:if>
                            </div>
                        </td>
                    </tr>
                </c:if>
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