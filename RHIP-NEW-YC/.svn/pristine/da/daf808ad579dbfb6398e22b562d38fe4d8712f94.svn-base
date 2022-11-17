<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="ZXCRB" value="<%=RoleType.ZXCRB.getValue()%>"/>
<c:set var="ZCRB" value="<%=RoleType.ZCRB.getValue()%>"/>
<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>"/>
<%-- <script src="${pageContext.request.contextPath}/js/Highcharts-2.3.3/js/highcharts.js" type="text/javascript"></script> --%>
<script src="${pageContext.request.contextPath}/js/views/ihm/idmTarget/region/search.js" type="text/javascript"></script>


<div class="toolbar">
	    	<div class="x-nav">
			      <span class="layui-breadcrumb">
			        <a href="javascript:void(0)">综合管理</a>
			        <a href="javascript:void(0)">疾病控制</a>
			        <a>
			          <cite>
			           传染病诊断统计
			          </cite></a>
			      </span>
			</div>
	    </div>
 
<div class="section">
    <div class="searchbox searchSection x-admin-sm">
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
                    <td class="col-text">机构类型 </td>
                    <td class="col-input">
                        <select name="genreCode" id="genreCode" style="width: 130px;">
                            <%--卫生局--%>
                            <%-- <ehr:authorize ifAnyGranted="01,10">
                                <c:if test="${empty gbFlag}">
                                    <option value="0">按镇</option>
                                </c:if>
                            </ehr:authorize> --%>
                            <%--卫生局,市级医院--%>
                            <ehr:authorize ifAnyGranted="${ADMIN},${JKFYK}">
                                <c:if test="${empty hospitalFlag}">
                                    <option value="A100">按市级医院</option>
                                </c:if>
                            </ehr:authorize>
                            <%--卫生局,卫生院--%>
                            <ehr:authorize ifAnyGranted="${ADMIN},${ZXCRB},${JKFYK}">
                                <c:if test="${empty superOrganFlag}">
                                    <option value="B100">按中心</option>
                                </c:if>
                            </ehr:authorize>
                            <ehr:authorize ifAnyGranted="${ADMIN},${ZCRB},${JKFYK}">
                                <c:if test="${empty organFlag}">
                                    <option value="B200">按站</option>
                                </c:if>
                            </ehr:authorize>
                        </select>
                    </td>
                    <td class="col-text">机构</td>
                    <td class="col-input">
                        <%--卫生局角色--%>
                        <ehr:authorize ifAnyGranted="${ADMIN},${JKFYK}">
                            <input type="hidden" id="gbCode" name="gbCode"/>
                            <input type="hidden" id="superOrganCode" name="superOrganCode"/>
                            <input type="hidden" id="organCode" name="organCode"/>
                            <%--市级医院--%>
                            <div id="byHospital">
                                <ehr:org-type-list id="organCode0" name="organCode0" type="hospital" value="${organCode}" code="${organCode}" width="220px"/>
                            </div>
                            <%--卫生院--%>
                            <div id="byCentre">
                                <ehr:dic-town-centre-station isAdministration="true" centreId="centre1" townId="town1" centreName="superOrganCode1" townName="gbCode1"  style="width:220px;"/>
                            </div>
                            <%--镇--%>
                            <div id="byTown">
                                <ehr:dic-town-village townId="town3" townName="gbCode3" width="180px"/>
                            </div>
                            <%--站--%>
                            <div id="byStation">
                                <ehr:dic-town-centre-station isAdministration="true" stationId="station2" centreId="centre2" townId="town2" stationName="organCode2" centreName="superOrganCode2" townName="gbCode2"  style="width:220px;"/>
                            </div>
                        </ehr:authorize>
                        <%--卫生院角色--%>
                        <ehr:authorize ifAnyGranted="${ZXCRB}">
                            <%--卫生院--%>
                            <div id="byCentre">
                                <input type="hidden" name="superOrganCode" value="${orgCode}"/>
                                <ehr:org  code="${orgCode}"/>
                            </div>
                        </ehr:authorize>
                    </td>
                    <td rowspan="2">
                        <button class="layui-btn layui-btn-sm"  id="idmBtnSearch"><i class="layui-icon">&#xe615;</i>查看</button>
                    </td>
                </tr>
                <c:if test="${empty timeRangeFlag}">
                    <tr>
                        <td class="col-text">时间范围</td>
                        <td class="col-input">
                            <select name="rangeType" id="rangeType" style="width: 120px;">
                                <option value="5">按周</option>
                                <option value="1">按月</option>
                                <option value="2">按季度</option>
                                <option value="3">按年</option>
                            </select>
                        </td>
                        <td class="col-text">时间</td>
                        <td class="col-input">
                            <input type="hidden" id="beginDate" name="beginDate"/>
                            <input type="hidden" id="endDate" name="endDate"/>
                            <input type="hidden" id="weekNumber" name="weekNumber"/>
                            <div id="byWeek">
                                <input type="hidden" id="weekBeginDate1" name="weekBeginDate1"/>
                                <input type="hidden" id="weekBeginDate2" name="weekBeginDate2"/>
                                <input type="hidden" id="weekBeginDate3" name="weekBeginDate3"/>
                                <input type="hidden" id="weekBeginDate4" name="weekBeginDate4"/>
                                <input type="hidden" id="weekBeginDate5" name="weekBeginDate5"/>
                                <input type="hidden" id="weekBeginDate6" name="weekBeginDate6"/>
                                <input type="hidden" id="weekEndDate1" name="weekEndDate1"/>
                                <input type="hidden" id="weekEndDate2" name="weekEndDate2"/>
                                <input type="hidden" id="weekEndDate3" name="weekEndDate3"/>
                                <input type="hidden" id="weekEndDate4" name="weekEndDate4"/>
                                <input type="hidden" id="weekEndDate5" name="weekEndDate5"/>
                                <input type="hidden" id="weekEndDate6" name="weekEndDate6"/>
                                <tag:dateInput name="weekDate" pattern="yyyy/MM" id="beginDate0" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/>
                                <select name="weekSelect" id="weekSelect" style="width: 200px;"></select>
                            </div>
                            <div id="byMonth">
                                <input type="text" class="layui-input x-admin-sm-date" name="monthDate" id="beginDate1" value="<fmt:formatDate value='${currentBeginDate}' pattern="yyyy/MM"></fmt:formatDate>"
                               style="width: 80px;padding-left: 0px;">
                            </div>
                            <div id="byQuarter">
                                <input type="text" class="layui-input x-admin-sm-date" name="quarterDate" id="beginDate2" value="<fmt:formatDate value='${currentBeginDate}' pattern="yyyy"></fmt:formatDate>"
                               style="width: 80px;padding-left: 0px;">
                                <select name="rangeQuarter" id="rangeQuarter" style="width: 80px;">
                                    <option value="1">第一季度</option>
                                    <option value="2">第二季度</option>
                                    <option value="3">第三季度</option>
                                    <option value="4">第四季度</option>
                                </select>
                            </div>
                            <div id="byYear">
                                <input type="text" class="layui-input x-admin-sm-date" name="yearDate" id="beginDate3" value="<fmt:formatDate value='${currentBeginDate}' pattern="yyyy"></fmt:formatDate>"
                               style="width: 80px;padding-left: 0px;">
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
                    <td class="col-bottom">
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
<div id="idmDiseaseType_pop-chart-con" style="width: 800px;height:400px"></div>

<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#beginDate1'
            ,type:'month'
            , format: 'yyyy/MM'
            , max: 0
            , trigger: 'click' 
        });
        
        laydate.render({
            elem: '#beginDate2'
            ,type:'year'
            , format: 'yyyy'
            , max: 0
            , trigger: 'click' 
        });
        
        laydate.render({
            elem: '#beginDate3'
            ,type: 'year'
            , format: 'yyyy'
            , max: 0
            , trigger: 'click' 
        });



    });

</script>