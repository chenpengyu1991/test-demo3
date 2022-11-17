<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/views/ihm/ihmCommon.js" type="text/javascript"></script>

<div class="toolbar">
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="javascript:void(0)">综合管理</a>
        <a href="javascript:void(0)">健康档案</a>
        <a><cite>健康档案统计</cite></a>
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
                    <col style="width: 10%; min-width: 80px;"/>
                    <col style="width: 40%; min-width: 120px;"/>
                    <col style="width: 10%; min-width: 60px;"/>
                    <col style="width: 40%; min-width: 120px;"/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">统计类型</td>
                    <td class="col-input">
                        <select name="genreCode" id="genreCode" style="width: 200px;">
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
                    <td class="col-input" colspan="4">
                        <%--卫生局角色--%>
                        <ehr:authorize ifAnyGranted="01">
                            <input type="hidden" id="gbCode" name="gbCode"/>
                            <input type="hidden" id="superOrganCode" name="superOrganCode"/>
                            <input type="hidden" id="organCode" name="organCode"/>
                            <%--镇--%>
                            <div id="byTown">
                                <ehr:dic-town-village townId="town3" townName="gbCode3" width="180px"/>
                            </div>
                            <%--市级医院--%>
                            <div id="byHospital">
                                <ehr:org-type-list id="organCode0" name="organCode0" type="hospital" value="${organCode}" code="${organCode}" width="180px"/>
                            </div>
                            <%--卫生院--%>
                            <div id="byCentre">
                                <ehr:dic-town-centre-station centreId="centre1" townId="town1" centreName="superOrganCode1" townName="gbCode1" width="180px;" />
                            </div>
                            <%--社区服务站--%>
                            <div id="byStation">
                                <ehr:dic-town-centre-station centreId="centre2" townId="town2" stationId="station2" centreName="superOrganCode2" stationName="organCode2" townName="gbCode2" width="120px;" />
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
                                <ehr:dic-org-list name="organCode" width="130px;"/>
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
                <c:if test="${empty timeRangeFlag}">
                    <tr>
                        <td class="col-text">时间类型</td>
                        <td class="col-input">
                            <select name="rangeType" id="rangeType" style="width: 200px;">
                                <c:if test="${empty rangeFlag}"><option value="4">按时间段</option></c:if>
                                <c:if test="${empty yearRangeFlag}"><option value="3">按年</option></c:if>
                                <c:if test="${empty quarterRangeFlag}"><option value="2">按季度</option></c:if>
                                <c:if test="${empty monthRangeFlag}"><option value="1">按月</option></c:if>
                            </select>
                        </td>
                        <td class="col-text">时间</td>
                        <td class="col-input">
                            <input type="hidden" id="beginDate" name="beginDate"/>
                            <input type="hidden" id="endDate" name="endDate"/>
                            <div id="byMonth">
                                <input type="text" class="layui-input x-admin-sm-date"  name="monthDate" id="beginDate1" style="width:33%;">
                            </div>
                            <div id="byQuarter">
                                <input type="text" class="layui-input x-admin-sm-date"  name="quarterDate" id="beginDate2" style="width:33%;">
                                <select name="rangeQuarter" id="rangeQuarter" style="width: 80px;">
                                    <option value="1">第一季度</option>
                                    <option value="2">第二季度</option>
                                    <option value="3">第三季度</option>
                                    <option value="4">第四季度</option>
                                </select>
                            </div>
                            <div id="byYear">
                                <input type="text" class="layui-input x-admin-sm-date"  name="yearDate" id="beginDate3" style="width:33%;">
                                <c:if test="${empty fullYearFlag}"><input type="radio" id="yearType1" name="yearType"  class="radioGroup" value="1" onclick="ihmCommon.changeYearType()"/><label for="yearType1">全年</label></c:if>
                                <c:if test="${empty firstHalfYearFlag}"><input type="radio" id="yearType2" name="yearType"  class="radioGroup" value="2" onclick="ihmCommon.changeYearType()"/><label for="yearType2">上半年</label></c:if>
                                <c:if test="${empty secondHalfYearFlag}"><input type="radio" id="yearType3" name="yearType"  class="radioGroup" value="3" onclick="ihmCommon.changeYearType()"/><label for="yearType3">下半年</label></c:if>
                            </div>
                            <div id="byRange">
                                <c:if test="${empty pattern}"><c:set var="patternFormat" value="yyyy/MM/dd"></c:set></c:if>
                                <c:if test="${not empty pattern}"><c:set var="patternFormat" value="${pattern}"></c:set></c:if>
                                <input type="text" class="layui-input x-admin-sm-date"  name="beginDate4" id="beginDate4" style="width:33%;" value="<fmt:formatDate value='${currentBeginDate}' pattern='yyyy/MM/dd'/>"> ~
                                <input type="text" class="layui-input x-admin-sm-date"  name="endDate4" id="endDate4" style="width:33%;" value="<fmt:formatDate value='${currentEndDate}' pattern='yyyy/MM/dd'/>">
                            </div>
                        </td>

                    </tr>
                </c:if>
                <tr>
                    <td class="col-text">
                        <label>性别</label>
                    </td>
                    <td class="col-input">
                        <label>
                            <ehr:dic-radio isDefault="Y" dicmeta="GBT226112003" name="gender" value="${PersonalBasicInfoDTO.personInfo.gender}" code="1,2"/>
                        </label>
                    </td>
                    <c:if test="${empty timeRangeFlag}">
                        <td class="col-text">
                            年龄范围
                        </td>
                        <td class="col-input">
                          <%--<span>--%>
                            <tag:numberInput  id="recordStartAge" style="width:35%;" name="recordStartAge">
                            </tag:numberInput>
                            ~
                            <tag:numberInput  id="recordEndAge" style="width:35%;" name="recordEndAge">
                            </tag:numberInput>
                          <%--</span>--%>
                        </td>
                    </c:if>
                    <td></td>
                    <td rowspan="1" colspan="2">
                    </td>
                </tr>
                <tr>
                    <td colspan="4" class="righttd">
                        <button class="layui-btn layui-btn-sm" id="targetBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                    </td>
                </tr>
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
</div>
<div id="resultDiv">
    <jsp:include page="datagrid.jsp"/>
</div>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        //执行一个laydate实例
        laydate.render({
            elem: '#beginDate1',
            type:"month",
            format: 'yyyy/MM',
            max:0,
            value: new Date()
        });
        //执行一个laydate实例
        laydate.render({
            type:"year",
            elem: '#beginDate2', //指定元素
            max:0,
            value: new Date()
        });
        //执行一个laydate实例
        laydate.render({
            type:"year",
            elem: '#beginDate3',
            max:0,
            value: new Date()
        });
        //执行一个laydate实例
        laydate.render({
            elem: '#beginDate4'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#endDate4'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });

    });
</script>