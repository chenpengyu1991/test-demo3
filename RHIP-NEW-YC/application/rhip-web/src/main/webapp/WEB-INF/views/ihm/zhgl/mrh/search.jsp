<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="ZX_GLY" value="<%=RoleType.ZX_GLY.getValue()%>"/>
<c:set var="YY_GLY" value="<%=RoleType.YY_GLY.getValue()%>"/>
<c:set var="Z_GLY" value="<%=RoleType.Z_GLY.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/ihm/zhgl/mrh/search.js" type="text/javascript"></script>

<div class="toolbar">
    <div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>
		        <a href="javascript:void(0)">病案首页</a>
		        <a>
		          <cite>
		          ${title}
		          </cite></a>
		      </span>
    </div>
</div>

<%--统一机构考核搜索--%>
<div class="section">
    <div class="searchbox searchSection x-admin-sm">
        <input type="hidden" id="pageIndex" value="${pageIndex}">
        <input type="hidden" id="searchUrl" value="${searchUrl}">
        <form id="targetSearchForm">
            <table id="targetSearch">
                <colgroup>
                    <col style="width: 10%;"/>
                    <col style="width: 10%;"/>
                    <col style="width: 10%;"/>
                    <col style="width: 50%;"/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">统计类型</td>
                    <td class="col-input">
                        <select name="genreCode" id="genreCode" style="width: 150px;">
                            <%--疾控,卫生局 可选--%>
                            <%--<ehr:authorize ifAnyGranted="${ADMIN}">
                                <option value="0">按镇</option>
                            </ehr:authorize>--%>
                            <%--疾控卫生局,市级医院 可选--%>
                            <ehr:authorize ifAnyGranted="${ADMIN},${YY_GLY}">
                                <option value="A100">按市级医院</option>
                            </ehr:authorize>
                            <%--疾控卫生局,中心 可选--%>
                            <ehr:authorize ifAnyGranted="${ADMIN},${ZX_GLY}">
                                <option value="B100">按卫生院</option>
                            </ehr:authorize>
                            <%--疾控卫生局,中心,站 可选--%>
                            <ehr:authorize ifAnyGranted="${ADMIN},${ZX_GLY},${Z_GLY}">
                                <option value="B200">按社区卫生服务站</option>
                            </ehr:authorize>
                        </select>
                        <input type="hidden" name="orgG2" id="orgG2">
                    </td>
                    <td class="col-text"><label id="orgTitle">机构</label></td>
                    <td class="col-input">
                        <%--疾控卫生局角色--%>
                        <ehr:authorize ifAnyGranted="${ADMIN}">
                            <input type="hidden" id="gbCode" name="gbCode"/>
                            <input type="hidden" id="superOrganCode" name="superOrganCode"/>
                            <input type="hidden" id="organCode" name="organCode"/>
                            <%--镇--%>
                            <div id="byTown">
                                <ehr:dic-town-village townId="town3" townName="gbCode3" width="150px;"/>
                            </div>
                            <%--市级医院--%>
                            <div id="byHospital">
                                <ehr:org-type-list id="organCode0" name="organCode0" type="hospital" subsid="0"
                                                   value="${organCode}" code="${organCode}" width="150px;"/>
                            </div>
                            <%--卫生院--%>
                            <div id="byCentre">
                                <ehr:dic-town-centre-station centreId="centre1" townId="town1"
                                                             centreName="superOrganCode1" townName="gbCode1"
                                                             width="150px;"/>
                            </div>
                            <%--社区服务站--%>
                            <div id="byStation">
                                <ehr:dic-town-centre-station centreId="centre2" townId="town2" stationId="station2"
                                                             centreName="superOrganCode2" stationName="organCode2"
                                                             townName="gbCode2" width="150px;"/>
                            </div>
                        </ehr:authorize>
                        <%--市级医院角色--%>
                        <ehr:authorize ifAnyGranted="${YY_GLY}">
                            <%--市级医院--%>
                            <div id="byHospital">
                                <input type="hidden" name="organCode" value="${orgCode}"/>
                                <ehr:org code="${orgCode}"/>
                            </div>
                        </ehr:authorize>
                        <%--中心角色--%>
                        <ehr:authorize ifAnyGranted="${ZX_GLY}">
                            <%--卫生院--%>
                            <div id="byCentre">
                                <input type="hidden" name="superOrganCode" value="${orgCode}"/>
                                <ehr:org code="${orgCode}"/>
                            </div>
                            <%--社区服务站--%>
                            <div id="byStation">
                                <ehr:dic-org-list name="organCode" width="180px;"/>
                            </div>
                        </ehr:authorize>
                        <%--站角色--%>
                        <ehr:authorize ifAnyGranted="${Z_GLY}">
                            <%--社区服务站--%>
                            <div id="byStation">
                                <input type="hidden" name="organCode" value="${orgCode}"/>
                                <ehr:org code="${orgCode}"/>
                            </div>
                        </ehr:authorize>
                    </td>
                    <td rowspan="2">
                        <button class="layui-btn layui-btn-sm" id="targetBtnSearch"><i class="layui-icon">&#xe615;</i>查询
                        </button>
                    </td>
                </tr>
                <tr>
                    <td class="col-text">时间类型</td>
                    <td class="col-input">
                        <select name="rangeType" id="rangeType" style="width: 150px;">
                            <option value="1">按月</option>
                            <option value="2">按季度</option>
                            <option value="3">按年</option>
                        </select>
                    </td>
                    <td class="col-text">时间</td>
                    <td class="col-input">
                        <input type="hidden" id="beginDate" name="beginDate"/>
                        <input type="hidden" id="endDate" name="endDate"/>
                        <div id="byMonth">
                            <input type="text" class="layui-input x-admin-sm-date" name="monthDate" id="beginDate1"
                                   value="<fmt:formatDate value='${currentBeginDate}' pattern="yyyy/MM"></fmt:formatDate>"
                                   style="width: 150px;padding-left: 0px;">
                        </div>
                        <div id="byQuarter">
                            <input type="text" class="layui-input x-admin-sm-date" name="quarterDate" id="beginDate2"
                                   value="<fmt:formatDate value='${currentBeginDate}' pattern="yyyy"></fmt:formatDate>"
                                   style="width: 150px;padding-left: 0px;">
                            <select name="rangeQuarter" id="rangeQuarter" style="width: 150px;">
                                <option value="1">第一季度</option>
                                <option value="2">第二季度</option>
                                <option value="3">第三季度</option>
                                <option value="4">第四季度</option>
                            </select>
                        </div>
                        <div id="byYear">
                            <input type="text" class="layui-input x-admin-sm-date" name="yearDate" id="beginDate3"
                                   value="<fmt:formatDate value='${currentBeginDate}' pattern="yyyy"></fmt:formatDate>"
                                   style="width: 150px;padding-left: 0px;">
                            <input type="radio" id="yearType1" name="yearType" class="radioGroup" value="1"/>
                            <label for="yearType1">全年</label>
                            <input type="radio" id="yearType2" name="yearType" class="radioGroup" value="2"/>
                            <label for="yearType2">上半年</label>
                            <input type="radio" id="yearType3" name="yearType" class="radioGroup" value="3"/>
                            <label for="yearType3">下半年</label>
                        </div>
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
    <div id="resultDiv"></div>
</div>

<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        laydate.render({
            elem: '#beginDate1'
            , type: 'month'
            , format: 'yyyy/MM'
            , max: 0
        });

        laydate.render({
            elem: '#beginDate2'
            , type: 'year'
            , format: 'yyyy'
            , max: 0
        });

        laydate.render({
            elem: '#beginDate3'
            , type: 'year'
            , format: 'yyyy'
            , max: 0
        });
    });

</script>